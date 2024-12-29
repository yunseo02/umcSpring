package umcspring.umc.apiPayload.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import umcspring.umc.apiPayload.ApiResponse;
import umcspring.umc.apiPayload.code.ErrorReasonDTO;
import umcspring.umc.apiPayload.code.status.ErrorStatus;
import umcspring.umc.apiPayload.exception.GeneralException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j//로그 기록을 위해
@RestControllerAdvice(annotations = {RestController.class})//Restcontroller가 붙은 클래스에서 발생하는 예외를 처리하는 전역 예외 처리 클래스임을 나타냄
public class ExceptionAdvice extends ResponseEntityExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<Object> validation(ConstraintViolationException e, WebRequest request) {
        String errorMessage = e.getConstraintViolations().stream()
                .map(constraintViolation -> constraintViolation.getMessage())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("ConstraintViolationException 추출 도중 에러 발생"));

        return handleExceptionInternalConstraint(e, ErrorStatus.valueOf(errorMessage), HttpHeaders.EMPTY,request);
    }
    //validation 사용되는 예외: ContraintViolationException => 유효성 검사 실패로 인해 발생하는 예외를 처리
    //ConstraintViolationException에서 첫 번째 에러 메세지를 추출, 추출된 메시지를 기반으로 적적한 errorstatus를 찾은 뒤 handleExceptionInternalConstraint 메서드를 호출하여 응답을 생성
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String, String> errors = new LinkedHashMap<>();

        e.getBindingResult().getFieldErrors().stream()//에러정보를 받음
                .forEach(fieldError -> {
                    String fieldName = fieldError.getField();
                    String errorMessage = Optional.ofNullable(fieldError.getDefaultMessage()).orElse("");
                    errors.merge(fieldName, errorMessage, (existingErrorMessage, newErrorMessage) -> existingErrorMessage + ", " + newErrorMessage);
                });

        return handleExceptionInternalArgs(e,HttpHeaders.EMPTY,ErrorStatus.valueOf("_BAD_REQUEST"),request,errors);
    }
    //MethodArgumentNotValidException: 컨트롤러 메서드의 매개변수 유효성 검사에 실패했을 때
    //발생한 유효성 검사 실패 항목들을 Map으로 수집 - 키: 필드 이름 값: 오류 메시지
    //수집된 데이터를 handleExceptionInternalArgs를 통해 클라이언트에 반환
    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception e, WebRequest request) {
        e.printStackTrace();

        return handleExceptionInternalFalse(e, ErrorStatus._INTERNAL_SERVER_ERROR, HttpHeaders.EMPTY, ErrorStatus._INTERNAL_SERVER_ERROR.getHttpStatus(),request, e.getMessage());
    }
    //Exception: 최상위 예외

    @ExceptionHandler(value = GeneralException.class)
    public ResponseEntity onThrowException(GeneralException generalException, HttpServletRequest request) {
        ErrorReasonDTO errorReasonHttpStatus = generalException.getErrorReasonHttpStatus();
        return handleExceptionInternal(generalException,errorReasonHttpStatus,null,request);
    }
    //GeneralException: 사용자 정의 예외를 처리
    //GeneralException 객체에 포함된 ErrorReasonDTO를 사용하여 응답을 생성

    private ResponseEntity<Object> handleExceptionInternal(Exception e, ErrorReasonDTO reason, HttpHeaders headers, HttpServletRequest request) {

        ApiResponse<Object> body = ApiResponse.onFailure(reason.getCode(),reason.getMessage(),null);
//        e.printStackTrace();

        WebRequest webRequest = new ServletWebRequest(request);
        return super.handleExceptionInternal(
                e,
                body,
                headers,
                reason.getHttpStatus(),
                webRequest
        );
    }
    //GeneralException 및 일반 예외의 콩통 처리를 담당하는 메서드


    private ResponseEntity<Object> handleExceptionInternalFalse(Exception e, ErrorStatus errorCommonStatus,
                                                                HttpHeaders headers, HttpStatus status, WebRequest request, String errorPoint) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorCommonStatus.getCode(),errorCommonStatus.getMessage(),errorPoint);
        return super.handleExceptionInternal(
                e,
                body,
                headers,
                status,
                request
        );
    }

    private ResponseEntity<Object> handleExceptionInternalArgs(Exception e, HttpHeaders headers, ErrorStatus errorCommonStatus,
                                                               WebRequest request, Map<String, String> errorArgs) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorCommonStatus.getCode(),errorCommonStatus.getMessage(),errorArgs);
        return super.handleExceptionInternal(
                e,
                body,
                headers,
                errorCommonStatus.getHttpStatus(),
                request
        );
    }

    private ResponseEntity<Object> handleExceptionInternalConstraint(Exception e, ErrorStatus errorCommonStatus,
                                                                     HttpHeaders headers, WebRequest request) {
        ApiResponse<Object> body = ApiResponse.onFailure(errorCommonStatus.getCode(), errorCommonStatus.getMessage(), null);
        return super.handleExceptionInternal(
                e,
                body,
                headers,
                errorCommonStatus.getHttpStatus(),
                request
        );
    }
}
//ResponseEntity<Object>는 Spring Framework에서 제공하는 클래스로 HTTP 응답을 표현하는 데 사용됨
//이를 통해 응답 상태 코드, 헤더, 응답 본문을 모두 커스터마이징할 수 있음
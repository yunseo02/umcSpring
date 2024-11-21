package umcspring.umc.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umcspring.umc.apiPayload.code.BaseCode;
import umcspring.umc.apiPayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    //일반적인 응답
    _OK(HttpStatus.OK, "COMMON200", "성공입니다.");//Enum 상수
    //HttpStatus는 스프링 부트 자체에서 제공하는 상수이다

    private final HttpStatus httpStatus;
    private final String code;
    private String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}

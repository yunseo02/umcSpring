package umcspring.umc.apiPayload.exception.handler;

import umcspring.umc.apiPayload.code.BaseErrorCode;
import umcspring.umc.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

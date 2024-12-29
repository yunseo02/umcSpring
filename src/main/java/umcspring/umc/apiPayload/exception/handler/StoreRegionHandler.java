package umcspring.umc.apiPayload.exception.handler;

import umcspring.umc.apiPayload.code.BaseErrorCode;
import umcspring.umc.apiPayload.exception.GeneralException;

public class StoreRegionHandler extends GeneralException {

    public StoreRegionHandler(BaseErrorCode errorCode) { super(errorCode);}
}

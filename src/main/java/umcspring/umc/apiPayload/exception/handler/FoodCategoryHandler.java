package umcspring.umc.apiPayload.exception.handler;

import umcspring.umc.apiPayload.code.BaseErrorCode;
import umcspring.umc.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

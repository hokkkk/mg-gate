package init.mg.app.exception

import init.mg.app.payload.ErrorCode


class BusinessException: RuntimeException {
    private lateinit var errorCode: ErrorCode;

    constructor(errorCode: ErrorCode, message: String?) : super(message) {
        this.errorCode = errorCode
    }

    constructor(errorCode: ErrorCode) : super(errorCode.message) {
        this.errorCode = errorCode
    }

    fun getErrorCode(): ErrorCode {
        return errorCode
    }
}
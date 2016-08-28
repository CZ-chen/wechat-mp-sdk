package tech.nodex.mp.api;

/**
 * Created by cz on 2016-8-27.
 */
public class ApiInvokeException extends RuntimeException {
    public ApiInvokeException() {
    }

    public ApiInvokeException(String message) {
        super(message);
    }

    public ApiInvokeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiInvokeException(Throwable cause) {
        super(cause);
    }

    public ApiInvokeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package cn.zzf.spring.cloud.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author GaoFeng
 * @date 2020/10/31 20:52
 */
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
public class ResponseResult<T> {
    private static final ResponseResult<Object> SUCCESS_RESPONSE_RESULT = ok(null);

    private int code;
    private String message;
    private T data;

    public ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> ok(T data) {
        return new ResponseResult<>(0, "ok", data);
    }

    public static ResponseResult<Object> ok() {
        return SUCCESS_RESPONSE_RESULT;
    }

    public static ResponseResult<Object> fail(int code, String message) {
        return new ResponseResult<>(code, message, null);
    }

}

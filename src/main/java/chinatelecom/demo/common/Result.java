package chinatelecom.demo.common;

import lombok.Data;

@Data
public class Result<T> {
    private int code;      // 状态码，例如200
    private String message; // 描述信息
    private T data;        // 返回数据

    // 成功
    public static <T> Result<T> success(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMessage("success");
        r.setData(data);
        return r;
    }

    // 失败
    public static <T> Result<T> error(String message) {
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setMessage(message);
        r.setData(null);
        return r;
    }
}

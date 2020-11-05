package com.lovrth.tpl.common.exception;


import lombok.Data;

@Data
public class Parameter extends HttpException {
    private Object msg = ErrorCode.PARAMETER_ERROR.getDescription();

    private Integer errorCode = ErrorCode.PARAMETER_ERROR.getCode();

    private Integer httpCode = HttpStatus.BAD_REQUEST.value();

    public Parameter(String msg) {
        this.msg = msg;
    }

    public Parameter() {
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

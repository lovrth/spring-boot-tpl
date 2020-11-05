package com.lovrth.tpl.common.result;

import com.alibaba.fastjson.JSON;
import com.lovrth.tpl.common.exception.ErrorCode;
import com.lovrth.tpl.common.exception.Success;
import com.lovrth.tpl.common.exception.HttpException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 响应结果生成工具
 */
@SuppressWarnings("unchecked")
@Slf4j
public class ResultGenerator {

    public static Result genResult(HttpException e) {
        String url = RequestHelper.getRequestUrl();
        return new Result()
                .setMsg(e.getMsg())
                .setErrorCode(e.getErrorCode())
                .setUrl(url)
                .setHttpCode(e.getHttpCode());
    }

    public static <T> Result<T> genSuccessResult(T data) {
        Success success = new Success();
        String url = RequestHelper.getRequestUrl();
        return new Result().setUrl(url)
                .setErrorCode(success.getErrorCode())
                .setMsg(data)
                .setHttpCode(success.getHttpCode());
    }

    public static <T> Result<T> genResult(ErrorCode errorCode, int httpCode) {
        String url = RequestHelper.getRequestUrl();
        return new Result().setUrl(url)
                .setErrorCode(errorCode.getCode())
                .setMsg(errorCode.getDescription())
                .setHttpCode(httpCode);
    }

    public static Result genFailResult(String message) {
        return new Result();
    }

    public static void writeResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(result.getHttpCode());
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }

    public static void genAndWriteResult(HttpServletResponse response, HttpException e) {
        Result result = genResult(e);
        writeResult(response, result);
    }
}

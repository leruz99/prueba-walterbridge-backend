package org.pruebatecnica.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.pruebatecnica.domain.models.ApiError;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateTaskResponse <T>{
    private T body;
    private ApiError error;
    private Object message;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}

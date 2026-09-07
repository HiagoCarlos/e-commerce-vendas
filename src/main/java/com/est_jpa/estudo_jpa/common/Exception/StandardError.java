package com.est_jpa.estudo_jpa.common.Exception;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class StandardError extends RuntimeException {
    private Integer status;
    private Instant timeStamp;
    private String path;
    private String error;
    private String message;

    public StandardError() {
    }

    public StandardError(Integer status, Instant timeStamp, String path, String error, String message) {
        this.status = status;
        this.timeStamp = timeStamp;
        this.path = path;
        this.error = error;
        this.message = message;
    }
    
}

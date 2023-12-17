package com.cos.security3.jwt;

public class TokenException extends RuntimeException{
    public TokenException(String message){
        super(message);
    }
}

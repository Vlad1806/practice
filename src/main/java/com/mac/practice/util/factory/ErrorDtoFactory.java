package com.mac.practice.util.factory;

import com.mac.practice.model.dto.common.ErrorDto;

public class ErrorDtoFactory {

    private ErrorDtoFactory() {
    }

    public static ErrorDto getErrorDto(String errorMessage){
        final ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(errorMessage);
        errorDto.setCode(1L);
        errorDto.setService(1);
        return errorDto;
    }
}

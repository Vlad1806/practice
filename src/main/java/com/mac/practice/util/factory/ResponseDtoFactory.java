package com.mac.practice.util.factory;

import com.mac.practice.model.dto.common.ErrorDto;
import com.mac.practice.model.dto.common.ResponseDto;
import com.mac.practice.model.enums.Status;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class ResponseDtoFactory {

    private ResponseDtoFactory() {
    }


    public static  <T>ResponseDto<T> getSuccessfulResponseDto(T data){
        ResponseDto<T> responseDto = new ResponseDto();
        responseDto.setStatus(Status.OK);
        responseDto.setData(data);
        responseDto.setErrors(emptyList());
        return responseDto;
    }

    public static  <T>ResponseDto<T> getFailedResponseDto(String errorMessage){
        ResponseDto<T> responseDto = new ResponseDto();
        responseDto.setStatus(Status.FAILED);
        responseDto.setErrors(List.of(ErrorDtoFactory.getErrorDto(errorMessage)));
        return responseDto;
    }
}

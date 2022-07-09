package com.mac.practice.model.dto.common;

import com.mac.practice.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto<T> {

    private T data;
    private Status status;
    private List<ErrorDto> errors;
}

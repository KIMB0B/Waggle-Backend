package com.waggle.waggle.global.interfaces;

import com.waggle.waggle.global.dto.ErrorReasonDto;

public interface BaseErrorCode {

    public ErrorReasonDto getReason();
    public ErrorReasonDto getReasonHttpStatus();
}

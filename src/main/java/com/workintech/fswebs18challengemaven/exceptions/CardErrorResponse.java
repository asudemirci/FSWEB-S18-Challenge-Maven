package com.workintech.fswebs18challengemaven.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

    public CardErrorResponse(String message) {
        this.status = 400;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }
}

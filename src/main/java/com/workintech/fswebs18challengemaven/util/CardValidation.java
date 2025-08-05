package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

public class CardValidation {
    public static void validate(Card card) {
        if (card.getType() == Type.JOKER) {
            if (card.getValue() != null || card.getColor() != null) {
                throw new CardException("JOKER card must have null value and null color.", HttpStatus.BAD_REQUEST);
            }
        } else {
            if (card.getValue() != null && card.getType() != null) {
                throw new CardException("Card cannot have both value and type.", HttpStatus.BAD_REQUEST);
            }
            if (card.getValue() == null && card.getType() == null) {
                throw new CardException("Card must have either value or type.", HttpStatus.BAD_REQUEST);
            }
        }
    }
}

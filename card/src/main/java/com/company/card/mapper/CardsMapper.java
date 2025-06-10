package com.company.card.mapper;


import com.company.card.dto.CardDto;
import com.company.card.entity.Cards;

public class CardsMapper {

    public static CardDto mapToCardsDto(Cards cards, CardDto cardDto) {
        cardDto.setCardNumber(cards.getCardNumber());
        cardDto.setCardType(cards.getCardType());
        cardDto.setMobileNumber(cards.getMobileNumber());
        cardDto.setTotalLimit(cards.getTotalLimit());
        cardDto.setAvailableAmount(cards.getAvailableAmount());
        cardDto.setAmountUsed(cards.getAmountUsed());
        return cardDto;
    }

    public static Cards mapToCards(CardDto cardDto, Cards cards) {
        cards.setCardNumber(cardDto.getCardNumber());
        cards.setCardType(cardDto.getCardType());
        cards.setMobileNumber(cardDto.getMobileNumber());
        cards.setTotalLimit(cardDto.getTotalLimit());
        cards.setAvailableAmount(cardDto.getAvailableAmount());
        cards.setAmountUsed(cardDto.getAmountUsed());
        return cards;
    }

}

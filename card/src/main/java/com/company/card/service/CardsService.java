package com.company.card.service;


import com.company.card.dto.CardContactInfoDto;
import com.company.card.dto.CardDto;

public interface CardsService {

    void createCard(String mobileNumber);

    CardDto fetchCard(String mobileNumber);

    boolean updateCard(CardDto cardDto);

    boolean deleteCard(String mobileNumber);

    CardContactInfoDto getContactDetails();
}

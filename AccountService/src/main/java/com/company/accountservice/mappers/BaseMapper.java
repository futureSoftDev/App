package com.company.accountservice.mappers;

public interface BaseMapper<Entity, Dto> {

    Entity toEntity(Dto dto);
}

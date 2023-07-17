package com.ohgiraffers.mybatisspring.section01.factorybean;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDTO> findAllMenus();
}

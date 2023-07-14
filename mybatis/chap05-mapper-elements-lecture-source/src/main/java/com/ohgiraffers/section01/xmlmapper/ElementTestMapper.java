package com.ohgiraffers.section01.xmlmapper;

import java.util.List;

public interface ElementTestMapper {
    List<MenuDTO> selectResultMapTest();

    List<MenuAndCategoryDTO> selectResultMapAssociationTest();

    List<MenuDTO> selectResultMapConstructorTest();

    List<CategoryAndMenuDTO> selectResultMapCollectionTest();
}

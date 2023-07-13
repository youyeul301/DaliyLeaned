package com.ohgiraffers.section01.xml;

import org.apache.ibatis.session.SqlSession;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.section01.xml.Template.getSqlSession;

public class MenuService {
    public void findMenuByPrice(int price) {
        SqlSession sqlSession=getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String,Integer> map = new HashMap<>();
        map.put("price",price);

        List<MenuDTO> menuDTOS = mapper.findMenuByPrice(map);

        if(menuDTOS !=null && menuDTOS.size()>0){
            menuDTOS.forEach(System.out::println);
        }else {
            System.out.println("검색에 실패했거나 검색 결과가 없습니다.");
        }

        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria){
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);


        List<MenuDTO> menuDTOS = mapper.searchMenu(searchCriteria);

        if (menuDTOS !=null && menuDTOS.size() >0){
            menuDTOS.forEach(System.out::println);
        }else {
            System.out.println("검색 실패 혹은 검색 결과 없음");
        }

        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession=getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menus = mapper.searchMenuBySupCategory(searchCriteria);

        if(menus !=null && menus.size()>0){
            menus.forEach(System.out::println);
        }else {
            System.out.println("검색 실패 혹은 검색 결과 없음");
        }


        sqlSession.close();
    }

    public void searchMenuByRandomMenuCode() {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String ,List<Integer>>criteria =new HashMap<>();
//        criteria.put("randomMenuCodeList",randomMenuCodeList);

//        List<MenuDTO> menus =mapper.searchMenuByRandomMenuCode(criteria);
        List<MenuDTO> menus =mapper.searchMenuByRandomMenuCode();

        if(menus !=null && menus.size()>0){
            menus.forEach(System.out::println);
        }else {
            System.out.println("검색 실패 혹은 검색 결과 없음");
        }

        sqlSession.close();
    }

    public void searchMenuByCodeOfSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlSession=getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menus =mapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menus!=null && menus.size()>0){
            menus.forEach(System.out::println);
        }else {
            System.out.println("검색 실패 혹은 검색 결과 없음");
        }

        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> criteria) {
        SqlSession sqlSession =getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        List<MenuDTO> menus =mapper.searchMenuByNameOrCategory(criteria);

        if(menus!=null && menus.size()>0){
            menus.forEach(System.out::println);
        }else {
            System.out.println("검색 실패 혹은 검색 결과 없음");
        }

        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {
        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        int result = mapper.modifyMenu(criteria);

        if (result>0){
            System.out.println("메뉴 정보 변경에 성공 하셨습니다.");
            sqlSession.commit();
        }else {
            System.out.println("메뉴 정보 변경에 실패 하셨습니다.");
            sqlSession.rollback();
        }

        sqlSession.close();
    }
}

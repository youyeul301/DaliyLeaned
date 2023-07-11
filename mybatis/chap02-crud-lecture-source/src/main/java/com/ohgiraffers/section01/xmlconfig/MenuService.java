package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;
import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {

    private final MenuDAO menuDAO;
    public MenuService(){
        menuDAO = new MenuDAO();
    }
    public List<MenuDTO> findAllMenus() {
        SqlSession sqlSession=getSqlSession();

        List<MenuDTO> menus=menuDAO.findAllMenus(sqlSession);

        sqlSession.close();
        return menus;
    }

    public MenuDTO findMenuByMenuCode(int menuCode) {
        SqlSession sqlSession=getSqlSession();

        MenuDTO menuDTO=menuDAO.findMenuByMenuCode(sqlSession,menuCode);
        sqlSession.close();

        return menuDTO;
    }

    public boolean registMenu(MenuDTO menuDTO) {
        SqlSession sqlSession=getSqlSession();
        int result = MenuDAO.registMenu(sqlSession,menuDTO);

        if(result>0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();
        return result > 0 ? true : false;
    }

    public boolean modifyMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getSqlSession();
        int result = MenuDAO.modifyMenu(sqlSession,menuDTO);

        if(result>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        sqlSession.close();

        return result>0 ? true : false;
    }

    public boolean removeMenu(int menuCode) {
        SqlSession sqlSession=getSqlSession();
        int result = MenuDAO.removeMenu(sqlSession,menuCode);

        if (result>0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result>0? true:false;
    }
}

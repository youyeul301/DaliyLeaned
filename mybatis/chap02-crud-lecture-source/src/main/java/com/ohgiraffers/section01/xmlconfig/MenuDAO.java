package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*Database Access Object(DAO)*/
public class MenuDAO {
    public static int registMenu(SqlSession sqlSession, MenuDTO menuDTO) {
        return sqlSession.insert("MenuMapper.registMenu",menuDTO);
    }

    public static int modifyMenu(SqlSession sqlSession, MenuDTO menuDTO) {
        return sqlSession.update("MenuMapper.modifyMenu",menuDTO);
    }

    public static int removeMenu(SqlSession sqlSession, int menuCode) {
        return sqlSession.delete("MenuMapper.removeMenu",menuCode);
    }

    public List<MenuDTO> findAllMenus(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.findAllMenus");
    }

    public MenuDTO findMenuByMenuCode(SqlSession sqlSession, int menuCode) {

        return sqlSession.selectOne("MenuMapper.findMenuByMenuCode",menuCode);
    }
}

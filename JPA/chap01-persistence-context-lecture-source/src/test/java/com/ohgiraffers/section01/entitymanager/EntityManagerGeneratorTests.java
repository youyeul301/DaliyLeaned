package com.ohgiraffers.section01.entitymanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerGeneratorTests {
    /* 필기.
     *   엔티티 매니저 팩토리(EntityManagerFactory)란?
     *   엔티티 매니저를 생성할 수 있는 기능을 제공하는 팩토리 클래스이다.
     *   스레드 세이프이기 때문에 여러 스레드가 동시에 접근해도 안전하므로
     *   서로 다른 스레드간 공유해서 재사용한다.
     *   스레드 세이프한 기능을 요청 스코프마다 생성하기에는 비용(시간, 메모리)부담이 크기 때문에
     *   application 스코프와 동일한 싱글톤으로 생성해서 관리하는게 효율적이다.
     *   다라서 데이터베이스를 사용하는 애플리케이션 당 한 개의 EntityManagerFactory를 생성한다.
     * */

    @DisplayName("엔티티 매니저 팩토리 생성 확인")
    @Test
    void testGeneratorEntityManagerFactory(){
        //given

        //when
        EntityManagerFactory factory =EntityManagerFactoryGenerator.getInstance();
        //then
        Assertions.assertNotNull(factory);
    }

    @DisplayName("엔티티 매니저 팩토리 싱글톤 인스턴스 확인")
    @Test
    void testIsEntityManagerFactorySingletonInstance(){
        //given
        EntityManagerFactory factory1 = EntityManagerFactoryGenerator.getInstance();
        //when
        EntityManagerFactory factory2 = EntityManagerFactoryGenerator.getInstance();
        //then
        Assertions.assertEquals(factory1,factory2);
    }
    /* 필기.
    *   엔티티 매니저(EntityManager)란?
    *    엔티티 매니저는 엔티티를 저장하는 메모리상의 데이터베이스를 관리하는 인스턴스이다.
    *    엔티티를 저장하고, 수정, 삭제, 조회하는 등의 엔티티와 관련된 모든 일을 한다.
    *    엔티티 매니저는 스레드세이프 하지 않기때문에 동시성 문제가 발생할 수 있다.
    *    따라서 스레드간 공유를 하지 않고, web의 경우 일반적으로는 request scope와 일치시킨다.
    *   영속성 컨텍스트((PersistenceContext)란?
    *    엔티티 매니저를 통해 엔티티를 저장하거나 조회하면 엔티티 메니저는 영속성 컨텍스틍 엔티티를 보관하고 관리한다.
    *    영속성 컨텍스트는 엔티티 매니저를 생성할 때 하나 만들어진다.
    *    그리고 엔티티 매니저를 통해서 영속성 컨텍스트에 접근할 수 있고, 또 관리할 수 있다.
    * */

    @DisplayName("엔티티 매니저 생성 확인")
    @Test
    void testGenerateEntityManager(){
        //given

        //when
        EntityManager manager =EntityManagerGenerator.getInstance();
        //then
        Assertions.assertNotNull(manager);
    }

    @DisplayName("엔티티 매니저 스코프 확인")
    @Test
    void testEntityManagerLifeCycle(){
        //given
        EntityManager manager1 = EntityManagerGenerator.getInstance();
        //when
        EntityManager manager2 = EntityManagerGenerator.getInstance();
        //then
        Assertions.assertNotEquals(manager1,manager2);
    }
}

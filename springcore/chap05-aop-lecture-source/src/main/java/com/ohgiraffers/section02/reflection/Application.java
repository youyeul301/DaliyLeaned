package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {
        //클래스 객체만드는법
        //1 클래스이름.class , 2.new 클래스().getclass() , 3 Class.forname("클래스주소")
        Class class1= Account.class;
        System.out.println("class1 = " + class1);

        Class class2=new Account().getClass();
        System.out.println("class2 = " + class2);

        try {
            Class class3=Class.forName("com.ohgiraffers.section02.reflection.Account"); //동적 로딩 지원
            System.out.println("class3 = " + class3);

            Class class4=Class.forName("[D");
            System.out.println("class4 = " + class4);
            Class class5=double[].class;
            System.out.println("class5 = " + class5);

            Class class6=Class.forName("[Ljava.lang.String;");
            System.out.println("class6 = " + class6);
            Class class7=String[].class;
            System.out.println("class7 = " + class7);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Class class8=Double.TYPE;
        System.out.println("class8 = " + class8);

        Class class9=Void.TYPE;
        System.out.println("class9 = " + class9);

        Class superClass=class1.getSuperclass();
        System.out.println("superClass = " + superClass);

        Field[] fields=Account.class.getDeclaredFields();
        for (Field field:fields){
            System.out.println("접근제한자(modifiers) : " + Modifier.toString(field.getModifiers())+
                    ", type : "+field.getType()+
                    ", name : "+field.getName());
        }
        
        Constructor[] constructors=Account.class.getConstructors();
        for (Constructor constructor:constructors){
            System.out.println("constructor.getName()+ = " + constructor.getName());
            Class[] params=constructor.getParameterTypes();
            for (Class param:params){
                System.out.println("param = " + param);
            }
        }

        try {
            Account acc= (Account) constructors[0].newInstance("20","110-212-232132","1234",10000);
            System.out.println("acc.getBalance() = " + acc.getBalance());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        Method[] methods=Account.class.getMethods();
        Method getBalanceMethod=null;
        for (Method method:methods){
            System.out.println(Modifier.toString(method.getModifiers())+" "+
                    method.getReturnType().getSimpleName()+" "+
                    method.getName());
            if("getBalance".equals(method.getName())){
                getBalanceMethod=method;
            }
        }
        try {
            System.out.println("getBalanceMethod.invoke(constructors[2].newInstance()) = " + getBalanceMethod.invoke(constructors[2].newInstance()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        //"invoke"메서드는 메서드 객체(java.lang.reflect.Method)를 호출하여 실행시킵니다.
        //invoke(Object obj, Object... args) or invoke(Object obj)
        //"obj"은 메서드가 있는 클래스 인스턴스(클래스를 "new"로 생성되거나 "newInstance()"으로 생성된 객체(Object)) 입니다.
        //"args"는 메서드에 전달되는 파라미터로 객체(Object)로 구성된 배열입니다. 파라미터가 없으면 입력하지 않습니다.
        //Spring의 구조에서 이 기법을 사용한다.
    }
}

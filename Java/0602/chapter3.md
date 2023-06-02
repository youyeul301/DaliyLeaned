# 기본기연습
## method
메소드(method)는 어떤 특정 작업을 수행하기 위한 명령문의 집합이라고 할 수 있다.
## 변수의 종류
1. 지역변수 - method블럭 안에서 생성하는 변수
2. 매개변수 - method( ) 괄호안에 전달인자를 받기 위해 선언하는 변수
3. 전역변수 - 클래스안에서 생성하는 변수 (같은클래스에서만 사용가능)
4. 클래스변수 -static을 사용한 전역변수 (다른 클래스에서도 사용가능)
## return
*  return 이란?
*  모든 메소드 내부에는 return; 이 존재한다.
*  void 메소드의 경우 return;을 명시적으로 작성하지 않아도 마지막줄에 컴파일러가 자동으로 추가를 해준다.
*  return은 현재 메소드를 강제 종료하고 호출한 구문으로 다시 돌아가는 명령어이다.
*  method에 자료형이 있는 경우 return 값; 과 같은식으로 써야한다.
<hr/>

## 패키지
 *   서로 관련 있는 클래스 또는 인터페이스 등을 모아 하나의 묶음(그룹)으로 단위를 구성하는 것을 말한다.
 *   같은 패키지 내에서는 동일한 이름의 클래스를 만들 수 없지만, 패키지가 다르면 동일한 이름을 가진 클래스를 만들 수 도 있다.
 *   클래스명은 원래 패키지명을 포함하고 있기 때문이다.  예)com.ohgiraffers.section01.method.Calculator (이게 클래스명이다.)
 *   지금까지 클래스명에 패키지명을 함께 사용하지 않은 이유는 동일한 패키지 내에서 사용했기 때문이다.
 *   그렇기 때문에 서로 다른 패키지에 존재하는 클래스를 사용하는 경우에는 클래스명 앞에 패키지명을 명시해서 풀 클래스 이름으로 사용해야 한다.
 ```
 com.ohgiraffers.section01.method.Calculator calc = new com.ohgiraffers.section01.method.Calculator();
 int min = calc.minNumberOf(30, 20);
 
 //static의 경우 객체화를 하지않고 불러올수 있다
 int max = com.ohgiraffers.section01.method.Calculator.maxNumberOf(30, 20);
 ```
 ## 임포트
 *   서로 다른 패키지에 존재하는 클래스를 사용하는 경우 패키지명을 포함한 풀 클래스 이름을 사용해야 한다.
 *   하지만 매번 다른 클래스의 패키지명까지 기술하기에는 번거롭다.
 *   그래서 패키지명을 생략하고 사용할 수 있도록 한 구문이 import 구문이다.
 *   import는 package 선언문과 class 선언문 사이에 작성하며
 *   어떠한 패키지 내에 있는 클래스를 사용할 것인지에 대해 미리 선언하는 효과를 가진다.
 ```
최상단에 import com.ohgiraffers.section01.method.Calculator; //임포트 하고자 하는 클래스를 적어야한다.
Calculator calc = new Calculator();			                    //임포트구문 추가시 사용가능
int min = calc.minNumberOf(50, 60);
```
<hr/>

## API
*  Application Programming Interface는 응용프로그램에서 사용할 수 있도록,
*  운영체제나 프로그래밍 언어가 제공하는 기능을 제어할 수 있도록 만든 인터페이스를 뜻한다.
*  쉽게 말해 우리가 구현할 수 없거나 구현하기 번거로운 기능들을 JDK를 설치하면 사용할 수 있도록 제공해놓은 소스코드(클래스나 인터페이스)들을 의미한다.
*  더 쉽게 말해 누가 작성해놓은 소스코드이니 가져다 쓰는 방법을 본다는 말이다.
*  모든 코드를 우리가 다 외울 수 없으니 API 문서를 별도로 제공해주고 있다.

자바에서 제공하는 java.lang.Math가 있다.
### Math클래스는 
*  Math.abs(숫자) : 절대값
*  Math.min(숫자1,숫자2) : 숫자1과 2중 작은값
*  Math.max(숫자1,숫자2) : 숫자1과 2중 큰값
*  Math.random() :난수 생성 (Math.random()*범위)+시작위치 로 사용한다  ex) (Math.random() * 6) + 10; 10 ~ 15까지의 난수 발생 10부터 6개의 범위 10~15
<hr/>

## Scanner
*  콘솔 화면에 값을 입력 받아 출력해보기
Scanner sc = new Scanner(System.in);
sc.nextLine(); 방식으로 사용한다 Scanner클래스 함수에는 
*  nextInt() : 정수형값받기 
*  nextLine() : 문자열 받기
*  next() : 공백문자나 개행문자 전 까지 받기
*  nextLine() : 행이 개행되는 순간 받기
등등이 있다.

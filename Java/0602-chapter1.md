# 기본기 복습

## 상수 변수 리터럴
```
int a = 1;
//여기서 a는 변수(variable) 1은 데이터(literal)
final int a = 1;
//자료형 앞에 final이 붙으면 a는 변수가 아닌 상수(constant)가 된다.
```
## overflow
```
byte num1=127;
num1++;
//이 경우 overflow가 발생하여
//발생한 carry를 버림처리하고 sign bit를 반전시켜 최소값으로 순환한다

현재 num1의 값은 128이 아닌 byte가 가질수 있는 최소값 -128인 된다
```
##typecasting
```
자동형변환
  -컴파일러가 자동으로 수행해주는 타입변환이다 
  -작은자료형에서 큰자료형으로는 자동 형변환이된다.
  -정수는 실수로 자동형변환 된다
  -문자는 int형으로 자동형변환된다.
  -논리형은 형변환 규칙에서 제외된다
강제형변환
  -형변환 연산자를 이용하여 강제적으로 수행하는 타입변환이다
  -자동형변환이 적용되지 않는 경우 강제형변환이 필요하다
byte bnum = 1;
short snum = bnum;
int inum = snum;
long lnum = inum;
//작은 자료형에서 큰자료형으로 데이터를 옮기기 떄문에 문제없이 자동형변환 처리된다.
long lnum = 8;
//int inum = lnum;			//데이터 손실 가능성을 컴파일러가 알려준다. (에러남)
int inum = (int) lnum;		//변경하려는 자료형을 명시하여 강제 형변환을 해야 함
short snum = (short) inum;
byte bnum = (byte) snum;

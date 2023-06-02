# 조건문 if,ifelse,ifelseif,switch
```
[if]
if(조건식) {
     조건식이 true일 때 실행할 명령문;
}

[ifelse]
if(조건식) {
     조건식이 true일 때 실행할 명령문;
 }else {
     조건식이 false일 때 실행할 명령문;
}

[ifelseif]
if(조건식1) {
   조건식1이 true일 때 실행할 명령문;
} else if(조건식2) {
  조건식1이 false이고 조건식2가 true일 때 실행할 명령문;
} else {
   위의 조건 2개가 모두 거짓인 경우 실핼할 명령문;
}

[switch]
switch(비교할변수) {
  case 비교값1 : 비교값1과 일치하는 경우 실행할 구문; break;
  case 비교값2 : 비교값2와 일치하는 경우 실행할 구문; break;
  default : case에 모두 해당하지 않는 경우 실행할 구문; break;
}
```
<hr/>

# 반복문 for,while,doWhile
```
[for]
for(초기식; 조건식; 증감식) {
     조건을 만족하는 경우 수행할 구문(반복할 구문);
}

[while]
초기식;
 while(조건식) {
     조건을 만족하는 경우 수행할 구문(반복할 구문);
     증감식;
}

[doWhile]
초기식;
do {
   1회차에는 무조건 실행하고, 이후에는 조건식을 확인하여 조건을 만족하는 경우 수행할 구문(반복할 구문);
   증감식;
} while(조건식);
```
<hr/>

# break,continue
*  break는 모든 반복문을 종료하는 것이 아닌, 자신에게 가장 인접한 반복문 실행만 멈춘다.
*  continue는 해당 반복문의 반복 회차를 중간에 멈추고 다시 증감식으로 넘어가게 해준다.

> label명: 을 사용할떄 
> *  break label명;을 사용시 라벨명에 해당하는 반복문을 종료시킨다.
> *  continue label명;을 사용시 라벨명에 해당하는 반복으로 이동하여 이어 진행한다.

//  명시적 타입 변환
//  1. String 생성자 함수를 이용하는 방법
//  2. 빌트인 메소트를 사용하는 방법

//  객체의 함수형 프로퍼티를 메소드라고 한다.
function Test(){} //생성자 함수
function test(){} //함수
var obj = {test : function(){}} //메소드
//1. String 생성자 함수를 new 연산자 없이 호출
console.log(typeof String(10));
console.log(typeof String(true));

// 2. Object.prototype.toString 메소드 사용
console.log(typeof (10).toString());
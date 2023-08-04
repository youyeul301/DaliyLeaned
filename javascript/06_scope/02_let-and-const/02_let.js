//1. 변수 중복 선언 금지
let msg = '안녕하세요'
let msg = '안녕히가세요';

//2.블록 레벨 스코프
let i=0;
for(let i =0;i<10;i++){

}
console.log(i)
//3.변수 호이스팅
console.log(test);
let test = "반갑습니다"
console.log(test);
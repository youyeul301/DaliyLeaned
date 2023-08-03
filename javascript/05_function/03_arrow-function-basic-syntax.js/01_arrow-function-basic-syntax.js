//화살표 함수
//ES6에서 도입된 화살표 함수는 function 키워드 대신 화살표를 이용하여 더 간략한 방법으로 함수를 선언할 수 있다.

var message;

message = function(){
    return "hello world";
}

console.log(message());

message = () =>{
    return "Arrow function";
}

console.log(message());


//명령문이 하나만 있는 경우 중괄호 생략 가능
//이 때 함수 몸체 내부의 문이 값으로 평가될 수 있는 표션식인 문이라면 암묵적으로 반환한다. (return 생략)
message = () =>"Arrow function are simple";

console.log(message());

message=(val1,val2) =>"Arrow "+val1+val2;
console.log(message("function ","!!"))

message = val1=> "Arrow "+val1;
console.log(message("function are good"));
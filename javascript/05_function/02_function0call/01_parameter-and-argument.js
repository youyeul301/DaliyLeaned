//매개변수와 인자

function hello(name){
    console.log(name);
    console.log(arguments);
    return `${name}님 환영합니다!`;
}

// console.log(name);

var result = hello('홍길동');
console.log(result);

result = hello('홍길동','유관순');
console.log(result);

function hi(name = '아무개'){
    return `${name}님 환영합니다!`;
}
result =hi();
console.log(result);
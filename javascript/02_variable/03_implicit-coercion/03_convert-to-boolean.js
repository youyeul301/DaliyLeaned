//논리 타입으로 변환
//자바스크립트 엔진은 boolean 타입이 아닌 Truthy값(참으로 평가되는 값) 또는 Falsy(거짓으로 평가되는 값)값으로 구분한다.
//Truthy -> true, Falsy -> false로 암묵적으로 변환 된다.

if(true){
    console.log('if(ture)');
}
if(false){
    console.log('if(false)');
}
if(undefined){
    console.log('if(undefined');
}
if(null){
    console.log('if(null)');
}
if(0){
    console.log('if(0)');
}
if(NaN){
    console.log('if(NaN)');
}
if(''){
    console.log('if("")');
}
if('JavaScript'){
    console.log('if("JavaScript")');
}

//false, undefined, null, 0 ,NaN, ''(빈문자열)은 Falsy 값이며
//이 외의 값은 Truthy 값이다.

function test(value){
    if(value){
        console.log('hello');
    }
}

test('');
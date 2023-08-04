//const 키워드로 선언한 변수는 반드시 선언과 동시에 초기화 해야한다.
//const x;
const x=1;

//const 키워드로 선언한 변수는 재할당이 금지된다.
//x =2;

const DISCOUNT_RATe=0.15;
let price =15000;

let discountPrice = price*(1-DISCOUNT_RATe);
console.log(discountPrice);

//주의사항
const student = {
    name:'홍길동',
    age:20
}

console.log(student);

student.name='유관수';
console.log(student);
const student1 ={
    name :'유관순',
    age : 16,
    getInfo: ()=> `${this.name}은(는) ${this.age}세 입니다.`
};
const student2 ={
    name :'홍길동',
    age : 16,
    getInfo: ()=> `${this.name}은(는) ${this.age}세 입니다.`
};

console.log(student1);
console.log(student2);

// 생성자 함수에 의한 객체 생성
function Stundent(name,age){
    this.name = name;
    this.age = age;
    this.getInfo = ()=>`${this.name}은(는) ${this.age}세 입니다.`;
}

const student3 = new Stundent('장보고',30)
const student4 = new Stundent('신사임당',40)

console.log(student3);
console.log(student4);
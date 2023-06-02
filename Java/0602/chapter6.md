# 기본기 복습

## 객체 지향 프로그래밍이란
    *  현실세계의 모든 사건(event)는 객체와 객체의 상호작용에 의해 일어난다는 세계관을
    *  프로그램을 만들 때 이용하여 새로운 세계를 창조하는 방법론이다.
    *  현실 세계와 닮아있지만 현실 세계와 다른 점은,
    *  객체간의 상호 작용을 한다는 사실은 현실 세계와 동일하지만 의인화 기법이 적용되어
    *  현실세계에서 불가능한 무생물이나 개념 같은 존재들도 하나의 주체로
    *  본인의 상태를 스스로 제어하고 행동하도록 한다는 것이 현실 세계와는 다른 점이다. (캡슐화의 의미)
    *  모든 객체는 책임을 가지고 자신의 역할을 수행해야 한다.
    *  또한 하나의 객체는 너무 많은 일을 수행하는 것이 아닌 적절한 책임을 가지고 있어야 한다. (단일 책임의 원칙)
		
### 추상화란?
    *  공통된 부분을 추출하고 공통되지 않은 부분을 제거한다는 의미를 가지며, 추상화의 목적은 유연성을 확보하기 위함이다.
    *  유연성 확보는 여러 곳에 적용될 수 있는 유연한 객체를 의미하며, 즉 재사용성이 높아질 수 있게 한다는 의미이다.
    *  객체의 재사용성이 증가하면 중복 작성되는 코드를 줄일 수 있으며, 오류 발생 가능성을 감소시키고 유지보수성을 증가시킨다.

### 객체와 객체의 상호작용이란?
    *  객체와 객체는 메세지를 통해 서로 상호작용을 한다. 메세지(메소드 호출)를 보내는 쪽을 송신자라고 하고
    *  메세지를 수신하는 쪽을 수신자 라고 한다. 수신자는 메세지를 전달 받아 그 메세지에 해당하는 내용을 처리하는 방법을
    *  스스로 결정하고, 그 결정한 방법 대로 처리할 명령어들을 순차적으로 기술한 것을 메소드라고 한다.
    *  상호작용에 중요한 것은 메세지를 송수신 하고 그 방법을 기술하여 메세지에 응답하는 상호작용을 설계하는 것이다.
    *  따라서 객체를 설계할 때는 속성은 부가적이며 적절한 책임을 가진 객체들간의 주고 받는 메세지를 이용해 상호작용하는 것을
    *  설계하는 것을 의미한다.
    *  즉, 필드보다는 메소드를 중점으로 추상화기법을 적용하여 객체를 설계하고,
    *  그 객체를 구현하는 방법으로 설계한 대로 클래스를 작성하는 것이다. 이것을 추상화라고 부른다.
### DTO (Data Transfer Object)
    *  캡슐화의 원칙을 준수, 객체를 설계 할때는 행위가 아닌 데이터 위주
    *  모든 필드를 private로 직접 접근을 막고, 각 필드값을 변경하거나 반환하는 메소드를 세트로 미리 작성해둔다.
    *  어떤것을 쓸 줄 모르니 미리 다 준비해두는 종합선물세트 같은 개념이다.
    *  private 필드와 필드값을 수정하는 설정자(setter), 필드에 접근하는 접근자(getter)들로 구성된다.
    *  주로 계층간 데이터를 주고 받을 목적으로 사용한다.
    
## 생성자
    *  인스턴스를 생성할 때 초기 수행할 명령이 있는 경우 미리 작성해두고, 인스턴스를 생성할 때 호출된다.
    *  생성자 함수에 매개변수가 없는 생성자를 기본생성자(default constructor)라고 하며,
    *  기본생성자는 compiler에 의해 자동으로 추가되기 때문에 지금까지 명시적으로 작성하지 않고 사용할 수 있었다.
    *  (인스턴스 생성 시 별도로 수행할 명령이 없었기 때문에 아무 것도 작성하지 않은 것이다.)
<hr/>

## overloading
  1. 설명
      *  생성자 작성 시 동일한 이름의 생성자를 한 클래스 내에서 작성하는게 불가능하다는 것을 확인했다.
      *  또한, 매개변수 부분의 타입, 갯수, 순서를 다르게 작성하면 서로 다른 메소드나 생성자로 인식하기 때문에
      *  동일한 이름의 생성자나 메소드를 여러 개 작성할 수 있게 하기도 했다.
      *  그러한 것을 오버로딩(Overloading) 이라고 한다.
  2. 사용이유
      *  매개변수의 종류별로 메소드 내용을 다르게 작성해야 하는 경우들이 종종 있다.
      *  이 때, 동일한 기능의 메소드를 매개변수에 따라 다르게 이름을 정의하면 복잡하고 관리하기가 매우 어려울 것이다.
      *  규모가 작은 프로그램의 경우는 정도가 덜 하지만, 규모가 거대해지면 메소드 또한 관리하기가 매우 어려워진다.
      *  따라서 동일한 이름으로 다양한 종류의 매개변수에 따라 처리해야 하는 여러 메소드를 동일한 이름으로 관리하기 위해
      *  사용하는 기술을 오버로딩이라고 한다.
<hr/>

## singleton
1. singleton pattern 이란
    *  애플리케이션이 시작될 때 어떤 클래스가 최초 한 번만 메모리를 할당하고 그 메모리에 인스턴스를 만들어서
    *  하나의 인스턴스를 공유해서 사용하며 메모리 낭비를 방지할 수 있게 함 (매번 인스턴스 생성 하지 않음)
    *  장점
        1. 첫 번째 이용 시에는 인스턴스를 생성해야 하므로 속도 차이가 나지 않지만두 번째 이용 시에는 인스턴스 생성 시간 없이 사용할 수 있다.
        2. 인스턴스가 절대적으로 한 개만 존재하는 것을 보증할 수 있다.
    *  단점
        1. 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유하면 결합도가 높아진다. (유지보수와 테스트에 문제점이 있음)
        2. 동시성 문제를 고려해서 설계해야 하기 때문에 난이도가 있다.
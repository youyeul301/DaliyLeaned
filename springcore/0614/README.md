# 0614

작성일시: 2023년 6월 14일 오전 9:02

DI(Dependency Injection) 의존성 주입

1. 필드주입 생성자주입 Setter주입
- xml을 이용한 주입 ( 생성자 , setter)
    
    ```jsx
    xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
            <bean id="account" class="com.ohgiraffers.common.PersonalAccount">
                <constructor-arg index="0"><value>1234-456-789012</value></constructor-arg>
                <constructor-arg index="1"><value>0</value></constructor-arg>
            </bean>
        <!-- bean 태그의 class 속성은 인터페이스 타입이 아닌 구현 클래스 타입으로 작성해야한다-->
    <!-- ref = bean의 아이디값.  생성자 주입
            <bean id="member" class="com.ohgiraffers.common.Member">
                <constructor-arg name="sequence" value="1" />
                <constructor-arg name="name" value="홍길동"/>
                <constructor-arg name="phone" value="010-1234-5678"/>
                <constructor-arg name="email" value="hong123@gmail.com"/>
                <constructor-arg name="personalAccount" ref="account"/>
            </bean>
    -->
        <!-- Setter 주입 -->
        <bean id="member" class="com.ohgiraffers.common.Member">
            <property name="sequence" value="1"/>
            <property name="name" value="홍길도"/>
            <property name="email" value="hong@gmail.com"/>
            <property name="phone" value="010-2134-3214"/>
            <property name="personalAccount" ref="account"/>
        </bean>
    </beans>
    ```
    
- java를 이용한 주입( 생성자 , setter)
    
    ```jsx
    java
    @Configuration
    public class ContextConfig {
        @Bean
        public Account accountGenerator(){
            return new PersonalAccount("111-222-333333",1000);
        }
    
        @Bean
        public Member memberGenerator(){
    //        생성자 주입
    //        return new Member(1,"홍길동","010-2234-1234","hong332@gmail.com",accountGenerator());  생성자 주입
    
    //      Setter 주입
            Member member=new Member();
            member.setSequence(1);
            member.setName("홍길둥");
            member.setPhone("010-2341-3142");
            member.setEmail("edjv@ndwq.com");
            member.setPersonalAccount(accountGenerator());
    
            return member;
        }
    }
    ```
    
- annotation (field)
    
    ```jsx
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    @ToString
    public class Book {
        private  int sequence;
        private int isbn;
        private String title;
        private String author;
        private  String publisher;
        private java.util.Date createDate;
    }
    ```
    
    ```jsx
    @Repository("bookDAO")
    public class BookDAOImpl implements BookDAO {
        private final Map<Integer,Book> bookList;
    
        BookDAOImpl(){
            this.bookList = new HashMap<>();
    
            bookList.put(1,new Book(1,123456,"자바의정석","남궁석","도우출판",new java.util.Date()));
            bookList.put(2,new Book(2,654321,"칭찬은 고래도 춤추게 한다.","고래","고래출판",new java.util.Date()));
        }
    
        @Override
        public List<Book> findAllBooks() {
            return new ArrayList<>(bookList.values());
        }
    
        @Override
        public Book findBookBySequence(int sequence) {
            return bookList.get(sequence);
        }
    }
    ```
    
    ```jsx
    @Service("bookServiceField")
    public class BookService {
        @Autowired
        private BookDAO bookDAO;
    
        public List<Book> findAllBooks(){
    
            return bookDAO.findAllBooks();
        }
    
        public Book searchBookBySequence(int sequence){
    
            return bookDAO.findBookBySequence(sequence);
        }
    }
    ```
    
    ```jsx
    public class Application {
        public static void main(String[] args) {
            ApplicationContext context=new AnnotationConfigApplicationContext("com.ohgiraffers.section01");
            //ComponentScan 대신 사용가능 가변인자라서 ,후 다른 패키지 주소를 추가 할수도 있음
            BookService bookService=context.getBean("bookServiceField",BookService.class);
    
            List<Book> books=bookService.findAllBooks();
            for (Book book:books){
                System.out.println("book = " + book);
            }
        }
    }
    ```
    
- annotation ( 생성자 )
    
    ```jsx
    public class Application {
        public static void main(String[] args) {
            ApplicationContext context=new AnnotationConfigApplicationContext("com.ohgiraffers.section01");
    
            BookService bookService=context.getBean("bookServiceConstructor",BookService.class);
    
            bookService.findAllBooks().forEach(System.out::println);
    
            System.out.println("bookService.searchBookBySequence(1) = " + bookService.searchBookBySequence(1));
        }
    }
    ```
    
    ```jsx
    @Service("bookServiceConstructor")
    public class BookService {
    
        private final BookDAO bookDAO;
    
        @Autowired
        public BookService(BookDAO bookDAO){
            this.bookDAO=bookDAO;
        }
    
        public List<Book> findAllBooks(){
            return bookDAO.findAllBooks();
        }
    
        public Book searchBookBySequence(int sequence){
            return bookDAO.findBookBySequence(sequence);
        }
    }
    ```
    
- annotation (setter)
    
    ```jsx
    @Service("bookServiceSetter")
    public class BookService {
        private BookDAO bookDAO;
        @Autowired
        public void setBookDAO(BookDAO bookDAO){
            this.bookDAO = bookDAO;
        }
    
        public List<Book> findAllBooks(){
            return bookDAO.findAllBooks();
        }
    
        public Book searchBookBySequence(int sequence){
            return bookDAO.findBookBySequence(1);
        }
    }
    ```
    
    ```jsx
    public class Application {
        public static void main(String[] args) {
            ApplicationContext context=new AnnotationConfigApplicationContext("com.ohgiraffers.section01");
    
            BookService bookService=context.getBean("bookServiceSetter",BookService.class);
            bookService.findAllBooks().forEach(System.out::println);
        }
    }
    ```
    

의존성이 낮아진다

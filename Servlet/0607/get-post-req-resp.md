# 0607

작성일시: 2023년 6월 7일 오전 9:47

- get 방식 요청
    
    ```jsx
    @WebServlet("/querystring")
    public class QueryStringTestServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            System.out.println("name = "+name);
    
            int age = Integer.parseInt(request.getParameter("age"));
            System.out.println("age = "+age);
    
    //        Date birthday= request.getParameter("birthday");
            /*
            String tempDate = request.getParameter("birthday");
            String[] arr=tempDate.split("-");
            int year=Integer.parseInt(arr[0]);
            int month=Integer.parseInt(arr[1]);
            int date=Integer.parseInt(arr[2]);
    
            Calendar calendar = new GregorianCalendar(year, month-1,date);
            Date birthday = new Date(calendar.getTimeInMillis());
            System.out.println("birthday  = "+birthday);
            */
    
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            System.out.println("birthday = "+birthday);
            System.out.println(birthday instanceof Date);
        }
    }
    ```
    
    ```jsx
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>RequestParameter</title>
    </head>
    <body>
        <h1>Request Parameter1</h1>
        <h3>GET 방식의 요청</h3>
        <h4>form 태그를 이용한 get 방식 요청</h4>
        <form action="querystring" method="get">
            <label for="name">이름 : </label>
            <input type="text" name="name" id="name" value="홍길동"/>
            <br/>
            <label>나이 : </label>
            <input type="number" name="age" />
            <br/>
            <label>생일 : </label>
            <input type="date" name="birthday"/>
            <br/>
            <label >성별</label>
            <input type="radio" name="gender"id="male" value="M">
            <label for="male">남자</label>
            <input type="radio" name="gender" id="female" value="F">
            <label for="female">여자</label>
            <br/>
            <laber>국적 : </laber>
            <select name="national">
                <option value="ko">한국</option>
                <option value="ch">중국</option>
                <option value="jp">일본</option>
                <option valupackage com.ohgiraffers.section01.querystring;
    
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    
    import java.io.IOException;
    import java.sql.Date;
    import java.util.Calendar;
    import java.util.GregorianCalendar;
    
    @WebServlet("/querystring")
    public class QueryStringTestServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            System.out.println("name = "+name);
    
            int age = Integer.parseInt(request.getParameter("age"));
            System.out.println("age = "+age);
    
    //        Date birthday= request.getParameter("birthday");
            /*
            String tempDate = request.getParameter("birthday");
            String[] arr=tempDate.split("-");
            int year=Integer.parseInt(arr[0]);
            int month=Integer.parseInt(arr[1]);
            int date=Integer.parseInt(arr[2]);
    
            Calendar calendar = new GregorianCalendar(year, month-1,date);
            Date birthday = new Date(calendar.getTimeInMillis());
            System.out.println("birthday  = "+birthday);
            */
    
            Date birthday = Date.valueOf(request.getParameter("birthday"));
            System.out.println("birthday = "+birthday);
            System.out.println(birthday instanceof Date);
    
            String gender =request.getParameter("gender");
            System.out.println("gender = "+gender);
    
            String national = request.getParameter("national");
            System.out.println("national = "+national);
    
            String[] hobbies = request.getParameterValues("hobbies");
            for(String s : hobbies){
                System.out.println("hobby = " + s);
            }
        }
    }e="etc" selected>기타</option>
            </select>
            <br/>
            <label>취미 : </label>
            <input type="checkbox" id="movie" value="movie" name="hobbies"><label for="movie">영화</label>
            <input type="checkbox" id="music" value="music" name="hobbies"><label for="music">음악</label>
            <input type="checkbox" id="sleep" value="sleep" name="hobbies"><label for="sleep">수면</label>
            <br/>
    
            <input type="submit" value="GET 요청">
        </form>
    
        <h4>a 태그의 href 속성에 직접 파라미터를 쿼리스트링 형태로 작성하여 get방식 요청</h4>
        <a href="http://localhost:8080/querystring?name=%ED%99%8D%EA%B8%B8%EB%8F%99&age=2&birthday=2023-06-29&gender=M&national=etc&hobbies=movie&hobbies=music&hobbies=sleep">
            쿼리스트링을 이용한 값 전달
        </a>
    </body>
    </html>
    ```
    
- POST 요청 방식
    
    ```jsx
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>RequestParameter</title>
        <meta charset="UTF-8"/>
    </head>
    <body>
        <h1>Request Parameter2</h1>
        <h4>form 태그를 이용한 post 방식 요청</h4>
        <form action="formdata" method="post">
            <label for="name2">이름 : </label>
            <input type="text" name="name" id="name2" value="홍길동"/>
            <br/>
            <label>나이 : </label>
            <input type="number" name="age" />
            <br/>
            <label>생일 : </label>
            <input type="date" name="birthday"/>
            <br/>
            <label >성별</label>
            <input type="radio" name="gender"id="male2" value="M">
            <label for="male2">남자</label>
            <input type="radio" name="gender" id="female2" value="F">
            <label for="female2">여자</label>
            <br/>
            <laber>국적 : </laber>
            <select name="national">
                <option value="ko">한국</option>
                <option value="ch">중국</option>
                <option value="jp">일본</option>
                <option value="etc" selected>기타</option>
            </select>
            <br/>
            <label>취미 : </label>
            <input type="checkbox" id="movie2" value="movie" name="hobbies"><label for="movie2">영화</label>
            <input type="checkbox" id="music2" value="music" name="hobbies"><label for="music2">음악</label>
            <input type="checkbox" id="sleep2" value="sleep" name="hobbies"><label for="sleep2">수면</label>
            <br/>
    
            <input type="submit" value="POST 요청">
        </form>
    </body>
    </html>
    ```
    
    ```jsx
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    
    import java.io.IOException;
    
    @WebServlet("/formdata")
    public class FormDataTestServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //        request.setCharacterEncoding("UTF-8"); 톰캣10버전부터는 기본설정으로 되있다
    //        하지만 이전 버전 톰캣에서는 html의 meta charset과 Servlet에서 setCharacterEncodin을 UTF-8로 설정 해야 한글이 깨지지않는다.
    
            String name=request.getParameter("name");
            System.out.println("name = "+name);        
        }
    }
    ```
    

```jsx
//get 방식 header 부분에서 url에 모든 정보를 담아서 전달하기 떄문에 body부분을 볼 필요가 없어서 처리속도가 빠르다.
주로 조회할때 사용. urlEncoding을 하기때문에 인코딩을 따로 해줄 필요가없다.
//post 방식 body부분을 보면서 전송해야하기 떄문에 데이터를 인코딩해줘야 한다 ex)mata charset="UTF-8"
```

- RequestHeaders
    
    ```jsx
    package com.ohgiraffers.section01.headers;
    
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    
    import java.io.IOException;
    import java.util.Enumeration;
    
    @WebServlet("/headers")
    public class RequestHeaderPrintServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Enumeration<String> headerNames= request.getHeaderNames(); //헤더가 가진 키값을 가져온다. fi2 - NetWork - Name- Header 의 값과 동일
            while (headerNames.hasMoreElements()){
                System.out.println(headerNames.nextElement());
            }
    
            System.out.println("accept : "+request.getHeader("accept"));
            System.out.println("cookie : "+request.getHeader("cookie"));
        }
    }
    ```
    
    ```jsx
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>RequestHeaders</title>
    </head>
    <body>
    <h1>RequestHeaders</h1>
    <a href="headers">요청 헤더값 출력해보기</a>
    </body>
    </html>
    ```
    
- Response
    
    ```jsx
    package com.ohgiraffers.section01.response;
    
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    
    import java.io.IOException;
    
    @WebServlet("/response")
    public class ResponseTestServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            /* 필기
            *   서블릿이 수행하는 역할은 크게 3가지이다.
            *   1. 클라이언트의 요청 받기 - HttpMethod GET/POST 요청에 따라서 parameter로 전달받은 데이터를 꺼낸다
            *   2. 비지니스 로직 처리 = DB 접속과 CRUD에 대한 로딕 + 도메인 로직
            *   3. 응답하기 -문자열로 동적인 웹(HTML 태그) 페이지를 만들고 스트림을 이용해 내보낸다.
            * */
        }
    }
    ```

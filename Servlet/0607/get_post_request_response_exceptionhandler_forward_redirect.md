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
    import jakarta.servlet.http.HttpServletResponse;
    
    import java.io.IOException;
    import java.io.PrintWriter;
    
    @WebServlet("/response")
    public class ResponseTestServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            /* 필기
            *   서블릿이 수행하는 역할은 크게 3가지이다.
            *   1. 클라이언트의 요청 받기 - HttpMethod GET/POST 요청에 따라서 parameter로 전달받은 데이터를 꺼낸다
            *   2. 비지니스 로직 처리 = DB 접속과 CRUD에 대한 로딕 + 도메인 로직
            *   3. 응답하기 -문자열로 동적인 웹(HTML 태그) 페이지를 만들고 스트림을 이용해 내보낸다.
            *
            *  사용자마다 보는화면 다른것이 동적 , 모두 같은 화면을 보면 정적인 화면
            * */
            String greeting ="안녕하세요";
    
            StringBuilder responseBuilder =new StringBuilder();//서버 로직에 따라 바뀔수있다. 동적인 페이지
            responseBuilder.append("<!doctype html>\n")
                    .append("<html>\n")
                    .append("<head></head\n")
                    .append("<body>\n")
                    .append("<h1>"+greeting+"</h1>\n")
                    .append("</body>\n")
                    .append("</html>");
            //MINE 타입
            /*
            resp.setContentType("text/html"); //위에 적힌 데이터정보에 대한 타입
            resp.setCharacterEncoding("UTF-8");
            */
    
            resp.setContentType("text/html; charset=UTF-8"); //스트림에 설정하기 전에 설정 해줘야한다.
    
            PrintWriter out=resp.getWriter(); //사용자에게 내보는 통로
            out.write(responseBuilder.toString());
    
            out.flush();
            out.close();
        }
    }
    ```
    
    ```jsx
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    
    import java.io.IOException;
    
    @WebServlet("/status")
    public class StatusCodeTestServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //        resp.sendError(404,"요청 페이지를 찾을 수 없습니다. 경로를 확인 해주세요");
            resp.sendError(500,"서버 내부 오류입니다. 서버 오류는 개발자의 잘못이고, 개발자는 여러분입니다.");
        }
    }
    ```
    
    ```jsx
    package com.ohgiraffers.section02.headers;
    
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.Collection;
    import java.util.Iterator;
    
    @WebServlet("/headers")
    public class ResponseHeaderPrintServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html;charset=UTF-8");
    
            PrintWriter out= resp.getWriter();
            long currentTime = System.currentTimeMillis();
            out.print("<h1>"+currentTime+"</h1>");
    
            out.close();
    
           Collection<String> responseHeaders = resp.getHeaderNames();
            Iterator<String> iter= responseHeaders.iterator();
    
            while(iter.hasNext()){
                String headerName= iter.next();
                System.out.println(headerName+" : "+resp.getHeader(headerName));
    
            }
        }
    }
    ```
    
    ```jsx
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>Response</title>
    </head>
    <body>
        <h1>Response</h1>
        <ul>
            <li><a href="response">응답확인하기</a></li>
            <li><a href="headers">응답 헤더 확인하기</a></li>
            <li><a href="status">응답 상태 코드 확인하기</a></li>
        </ul>
    </body>
    </html>
    ```
    
- Exception Handler
    
    ```jsx
    package com.ohgiraffers.section01.exception;
    
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.Enumeration;
    
    @WebServlet("/showErrorPage")
    public class ExceptionHandlerServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Enumeration<String> attrNames=req.getAttributeNames();
            while (attrNames.hasMoreElements()){
                System.out.println(attrNames.nextElement());
            }
    
            String statusCode= req.getAttribute("jakarta.servlet.error.status_code").toString();
            String message= req.getAttribute("jakarta.servlet.error.message").toString();
    
            System.out.println("statusCode = "+statusCode);
            System.out.println("message = "+message);
    
            StringBuilder errorPage=new StringBuilder();
            errorPage.append("<!doctype html>\n")
                    .append("<html>\n")
                    .append("<head></head>\n")
                    .append("<body>\n")
                    .append("<h1>")
                    .append(statusCode)
                    .append(" - ")
                    .append(message)
                    .append("</h1>\n")
                    .append("</body>\n")
                    .append("</html>");
    
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out=resp.getWriter();
            out.print(errorPage.toString());
    
            out.flush();
            out.close();
        }
    }
    ```
    
    ```jsx
    <?xml version="1.0" encoding="UTF-8"?>
    <web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
             version="5.0">
        <error-page>
            <error-code>404</error-code>
            <location>/showErrorPage</location>
        </error-page>
        <error-page>
            <error-code>500</error-code>
            <location>/showErrorPage</location>
        </error-page>
    </web-app>
    ```
    
    ```jsx
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
        <h1>Excetion Handler</h1>
        <%--  emmet문법 ul>li*2>a --%>
        <ul>
            <li><a href="show404Error">404에러 확인</a></li>
            <li><a href="show500Error">500에러 확인</a></li>
        </ul>
    </body>
    </html>
    ```
    
    ```jsx
    @WebServlet("/show404Error")
    public class Show404ErrorServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.sendError(404,"페이지를 찾을 수 없습니다.");
        }
    }
    
    @WebServlet("/show500Error")
    public class Show500ErrorServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.sendError(500,"500번 애러는 누구 잘못? 개발자! 개발자는 누구? 여러분!!!");
        }
    }
    ```
    
- forward
    
    ```jsx
    <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>Forwadrd</title>
    </head>
    <body>
        <h1>Forward</h1>
        <form action="forward" method="post">
            <label>아이디 : </label>
            <input type="text" name="userId"/>
            <br/>
            <label>패스워드 : </label>
            <input type="password" name="password"/>
            <br/>
            <button type="submit">로그인</button>
        </form>
    </body>
    </html>
    ```
    
    ```jsx
    @WebServlet("/forward")
    public class ReceiveInformationServlet extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String userId=req.getParameter("userId");
            String password = req.getParameter("password");
    
            System.out.println("userId = "+userId);
            System.out.println("password = "+password);
    
            //데이터베이스 조회
            //추가적인 로직...
    
            req.setAttribute("userId",userId);
            RequestDispatcher rd=req.getRequestDispatcher("print");
            rd.forward(req,resp);
        }
    }
    ```
    
    ```jsx
    @WebServlet("/print")
    public class PrintLogicSuccessServlet extends HttpServlet {
    
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String userId = req.getAttribute("userId").toString();
    
            System.out.println("print servlet userId = "+userId);
            StringBuilder responseText=new StringBuilder();
            responseText.append("<!doctype html>\n")
                    .append("<html>\n")
                    .append("<header></header>\n")
                    .append("<body>\n")
                    .append("<h3 align=\"center\">")
                    .append(userId)
                    .append("님 환영합니다.</h3>\n")
                    .append("</body>\n")
                    .append("</html>");
    
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out=resp.getWriter();
            out.print(responseText.toString());
    
            out.flush();
            out.close();
        }
    }
    ```
    
- redirect
    
    ```jsx
    <!DOCTYPE html>
    <html>
    <head>
        <title>Redirect</title>
    </head>
    <body>
        <h1>Redirect</h1>
        <ul>
            <li><a href="othersite">다른 웹 사이트로 리다이렉트</a></li>
            <li><a href="otherservlet">다른 서블릿으로 리다이렉트</a></li>
        </ul>
    </body>
    </html>
    ```
    
    ```jsx
    @WebServlet("/othersite")
    public class OtherSiteRedirectServlet extends HttpServlet {
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("get 요청 후 naver 사이트로 redirect");
    
            resp.sendRedirect("http://www.naver.com");
        }
    }
    ```
    
    ```jsx
    @WebServlet("/otherservlet")
    public class OtherServletRedirectTestServlet extends HttpServlet {
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("get 요청 정상 수락");
    
            Logic logic=new Logic();
            logic.registData();
    
            resp.sendRedirect("redirect");
            //정보를 담고 전달하고 싶은경우
            // 1. resp.sendRedirect("redirect?name=gildong&age=18");  받는 쪽에서 getParameter("name")
        }
    }
    ```
    
    ```jsx
    public class Logic {
        public void registData(){
            System.out.println("데이터베이스에 데이터를 생성했습니다.");
        }
    }
    ```
    
    ```jsx
    @WebServlet("/redirect")
    public class RedirectServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //url을 이용하면 무조건 get방식
            System.out.println("이 서블릿으로 redirect 성공");
    
            StringBuilder redirectText=new StringBuilder();
            redirectText.append("<!docType html>\n")
                    .append("<html>\n")
                    .append("<header></head>\n")
                    .append("<body>\n")
                    .append("<h1>이 서블릿으로 redirect 성공!</h1>\n")
                    .append("</body>\n")
                    .append("</html>");
    
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out=resp.getWriter();
            out.print(redirectText);
    
            out.flush();
            out.close();
        }
    }
    ```

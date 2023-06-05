servlet 작성 방식
```
xml 방식 
<web-app>
	<servlet>
		<servlet-name>mappin명</servlet-name>
		<servlet-class>설정 Class명</servlet-class>
		<init-param>
			<param-name>저장명</param-name>
			<param-value>저장값</param-value>
		</init-param>
	</servlet>
</web-app>
```
<hr/>

```
@어노테이션 방식
@WebServlet(“/mapping명칭”)
public class Servlet명 extends HttpServlet {
	(Servlet code)
}
```
Servlet 구동 순서
1. init() 서버 생성될떄 첫 한번만 실행
2. service()  작업이 실행 될 때마다 service() method가 요청한 HTTP Type에 따라 doGet(), doPost() method를 호출한다.
3. doGet() 또는 doPost()
4. destroy() 서버가 종료될떄 첫 한번만 실행

<hr/>

HTTP<br/>
      1. 상태 404 - NOT FOUND  
      2. 상태 200 - 정상 응답  
      3. 상태 500 - 코드에 문제 
<hr/>

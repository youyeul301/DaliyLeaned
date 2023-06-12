```
public class CheckMemberBirthday {
    public void checkBirth(String date) throws ParseException {

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();// Calendar 객체 생성
        cal.setTime(sdf.parse(date)); //String 타입을 Calendar타입으로 convert 하기 위함


        LocalDate now=LocalDate.now(); //날짜 까지만 비교하기 떄문에 LocalDate 객체를 사용
        LocalDate paramDate20=LocalDate.of(cal.get(Calendar.YEAR)+19,cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE));


        if(0>=now.compareTo(paramDate20)){
            throw new IllegalArgumentException("미성년입니다.");
        }
        //LocalDate compareTo()
        //파라미터로 전달받은 날짜와 같을 경우 0
        //파라미터로 전달받은 날짜보다 클 경우 양수
        //파라미터로 전달받은 날짜보다 작을 경우 음수
    }
    // 유열님
}
```

```
@WebServlet("/regist")
public class MemberFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration params=req.getParameterNames();  //아마도 null값으로 넣을경우 error페이지 이동
        while (params.hasMoreElements()){
            String name=(String)params.nextElement();
            if(req.getParameter(name).equals("")||req.getParameter(name).equals(null)){
                resp.sendError(500,"입력되지않은 정보가 있습니다.");
                break;
            }
        }


        try { //검증 서비스 호출 및 저장
            SaveMemberInformation smi=new SaveMemberInformation();
            smi.saveInformation(req);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher dispatcher=req.getRequestDispatcher("/himember"); //저장이 된 후 페이지 이동
        dispatcher.forward(req,resp);
    }
    //유열님
}
```

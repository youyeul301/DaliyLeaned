```
public class Application {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket =new ServerSocket(8000);

        Socket client;
        while ((client = serverSocket.accept())!=null){

            /*new Thread(new Runnable() {  //익명 클래스
                @Override
                public void run() {

                }
            });*/
            Socket finalClient=client;
            new Thread( () -> { //람다 문법
                try {
                    BufferedReader reader= new BufferedReader(new InputStreamReader(finalClient.getInputStream()));

                    /*String line;
                    while ((line =reader.readLine())!=null){
                        System.out.println("line = "+line);
                    }*/
                    String generalHeader = reader.readLine();
                    System.out.println("generalHeader ="+generalHeader);

                    String requestMethod=generalHeader.split(" ")[0];
                    String requestPath=generalHeader.split(" ")[1];

                    System.out.println("requestMethod ="+requestMethod);
                    System.out.println("requestPath ="+requestPath);


                    Map<String, String> requestHeader =new HashMap<>();
                    String line;
                    while ((line=reader.readLine()) !=null){
                        if(line.isBlank()){ //빈공백을 만날때 true 반환
                            break;
                        }
                        String key=line.split(": ")[0];
                        String value=line.split(": ")[1];

                        requestHeader.put(key,value);
                    }

                    System.out.println("requestHeader = "+requestHeader);

                    String body=null;

                    if("POST".equals(requestMethod)){ //post방식
                        int conmtentLength =Integer.parseInt(requestHeader.get("Content-Length"));
                        char[] temp=new char[conmtentLength];
                        reader.read(temp);

                        body=new String(temp).trim();
                    }

                    System.out.println("body = "+body);


                    StringBuilder responseText=new StringBuilder();//get방식
                    if("/".equals(requestPath)&&"GET".equals(requestMethod)){
                        String responseGeneralHeader = "HTTP/1.1 200 OK\r\n";
                        String contentType = "Content-Type: text/html;charset=UTF-8\r\n";
                        String whiteLine ="\r\n";

                        responseText.append(responseGeneralHeader);
                        responseText.append(contentType);
                        responseText.append(whiteLine);

                        BufferedReader br=new BufferedReader(new FileReader("src/main/resources/index.html"));
                        String htmlLine = null;
                        while ((htmlLine=br.readLine()) != null){
                            responseText.append(htmlLine);

                        }
                        responseText.append(whiteLine);
                    }

                    System.out.println("responseText = "+responseText);

                    OutputStream out=finalClient.getOutputStream();
                    out.write(responseText.toString().getBytes());

                    out.flush();
                    out.close();

                    reader.close();

                    finalClient.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
```
클라이언트를 만들지 않고 웹브라이저를 이용한 방식 <br/>
웹 브라우저에서 자신의 ip인 127.0.0.1:포트번호 를 검색
POST 방식 과 GET 방식을 방법

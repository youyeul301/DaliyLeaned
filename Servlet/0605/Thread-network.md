thread 프로세스내에서 실행하는 작은 작업단위<br/>
-단일thread , 멀티thread 병렬화 작업

프로세스 : 실행중인 프로그램 즉, 프로그램을 운영체제의 메모리와 cpu를 할당받아 실행되는 단위

쓰레드(thread)란 프로세스 내에서 실제로 작업을 수행하는 주체를 의미한다.

프로세스와 쓰레드 차이 정리하기<br/>
프로세스 : 자신만의 고유 공간과 자원을 할당받아 사용<br/>
스레드 : 다른 스레드와 공간과 자원을 공유하면서 사용

프로세스끼리 연결하기 위해 소켓필요. 소켓을 통한 이동을 Stream<br/>
스트림은 단방향 이동, ip와 port가 필요함

스트림 방식 tcp , udp<br/>
tcp 신뢰성이 높음, 속도가 느림, 연결지향 프로토콜 		서로가 각각 연결 , http가 유명 , accept() 함수 사용해야함<br/>
udp 신뢰성이 낮음, 속도가 빠름,비연결히향 프로토콜		일반적으로 보내기
```
public class Client {
    public static void main(String[] args) throws IOException {

        int port= 8500;

        String serverIp = "192.168.0.17";


        Socket socket=new Socket(serverIp,port);

        if(socket !=null){
            InputStream input=socket.getInputStream();
            OutputStream output=socket.getOutputStream();

            BufferedReader br=new BufferedReader(new InputStreamReader(input));
            PrintWriter pw=new PrintWriter(output);

            Scanner sc=new Scanner(System.in);

            do{
                System.out.println("대화 입력 : ");
                String message=sc.nextLine();

                pw.println(message);
                pw.flush();

                if (message.equals("exit")){
                    break;
                }

                String receiveMessage=br.readLine();
                System.out.println(receiveMessage);
            }while (true);

            br.close();
            pw.close();
            socket.close();
        }
    }
}
```


```


public class Server {
    public static void main(String[] args) throws IOException {
        /*port는 65535까지 이용 가능 (8000번 미만은 직접 설정하지 않음)*/
        int port=8500;

        ServerSocket server=new ServerSocket(port);

        while (true){
            Socket client=server.accept();

            InputStream input=client.getInputStream();
            OutputStream output=client.getOutputStream();

            BufferedReader br=new BufferedReader(new InputStreamReader(input));
            PrintWriter pw =new PrintWriter(output);

            while (true){
                String message=br.readLine();

                if(!message.equals("exit")){
                    System.out.println(client.getInetAddress().getHostAddress()+"가 보낸 메세지 : "+message);
                    pw.println("메시지 받기 성공!");
                    pw.flush();
                }else {
                    System.out.println("접속 종료");
                    break;
                }
            }

            br.close();
            pw.close();
            client.close();
        }
    }
}
```

단일 thread 코딩이라 한번에 한명의 연결만 받을수 있음

## 1 jdk 설치 및 환경변수 설정
    [다운로드](https://github.com/ojdkbuild/ojdkbuild)
    내pc 속성 고급 시스템 설정 환경변수 시스템 변수 [JAVA_HOME] 변수값 jdk 설치 위치    
    사용자변수 path 변수추가 %JAVA_HOME%\bin 추가
    
## 2 intellij 설치 및 설정    
    [다운로드](https://www.jetbrains.com/ko-kr/idea/download/#section=windows)
    id [dbduf1209@gmail.com](mailto:dbduf1209@gmail.com) 
    
    file setting editot general change font size ctrl+휠 폰트사이즈 변경 체크
    
    설정 help edit custom vm option =>  -Dfile.encoding=UTF-8 추가  주석 한글 가능하게 해줌
    
    setting build- gradle- run using ,run test - intellij 변경 속도 빨라짐
    
    TODO , FIXME 주석 하이라이트 관리가능
    todo 패턴 추가 setting editor todo +버튼 추가
    fillter 보고싶은 todo만 볼수있게 관리 가능
    
    프로젝트 불러오기
    open 프로젝트 zip파일 한개씩 가능
    jdk 버전이 다른 경우 우측하단 automatically
    
    ※ jdk설치 후 자바 path 설정 - intellij 설치 ※intellij 먼저 설치 하게 될시 jdk를 못찾을수 있어서 후에 설치
    
## 3 소스트리 다운로드
    -git에 	관리되는 소스들을 쉽게 다룰수있는 gui 인터페이스를 제공하는 툴
    -설치 
      next 계속 key 없음 clone 누름 git - code -https 주소 복사
      깃허브 내프로필 settings - developer settings 클래식 토큰으로 발금
      전부체크 토큰 이름 아카데미 기간 없음
      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 토큰 비밀번호 아이디 이메일계정
      원격저장소 remote repository https 주소
      로컬저장소 local repository 워크스페이스 주소

    로컬저장소 숨김항복 .git - 로컬저장소
    pull버튼을 누르면 깃에서 변경된 내용이 업데이트 됨

## 4 intellij
        깃 호스팅 서버 - 깃허브(오픈소스) , 깃랩(CI/CD) , 비트버킷(CI/CD)유료버전 소스트리개발회사
        성격  - 원격저장소(remote repository) 서비스를 제공 및 접근 용이,원하는 사람에게만 공유 가능
	              버전관리  언제든지 이전 버전을 사용할수 있게 관리해줌
                협업
        인텔리제이 <--(불러오기) 로컬저장소(워크스페이스) <--(clone) 원격저장소
        인텔리제이 (내용수정)-->(commit) 로컬저장소(워크스페이스) -->(push) 원격저장소
	commit이란 수정된 사항을 로컬저장소에 저장하는것.
	clone이란 원격저장소에 저장된 프로젝트를 로컬저장소로 가져오는것.
	push란 로컬저장소에 내용을 원격저장소에 저장하는것
        원격 저장소간의 이동 (fork)
        허락을 받고 수정사항을 원격저장소에 저장(pull request)
        merge - 각각의 프로젝트를 합칠때 사용
        conflic - (merge 상황에서 문제발생)
        branch - 협업시 main branch를 베이스로 각각 main branch를 복사하여 새로운 branch 생성 후 작업한다
        checkout - branch간의 이동
	pull - master branch 를 동기화 할때 사용	
	개인 환경 설정값 제외- gitignore파일에 구문추가 idea 및 idea/gradle.xml 구문추가 
        자세한 이미지 노션 0531 첨부
        
## 5 organizations (협업 그룹화)
      협업 프로젝트 생성 프로필 선택 -> your organizations 선택 -> new organizations 선택 -> 무료 생성
      권힌 부여 setting - Member privileges - base permissions - write 
      각각의 개인 수정물 결합 comepare request로 수정된 내용 요청 --> merge request --> confirm 
      conflict 발생시 - resolve 실행 - 충돌난 구문 수정 - confirm - merge request 다시 실행

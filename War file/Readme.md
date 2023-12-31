# Apache 와 Tomcat 
- Apache
    
    아파치 소프트웨어 재단(Apache Software Foundation, ASF)에서 만든 웹서버 프로그램이다.
    
    - 웹서버 란 ?
        
        웹서버는 하드웨어와 소프트웨어 두 분야에서 다른 의미로 부른다.
        
        **1. 하드웨어**
        
        > 웹 서버 소프트웨어와 웹 사이트의 구성 요소 파일을 저장하는 컴퓨터를 의미한다.
        > 
        > 
        > (예 : HTML 문서, 이미지, CSS 스타일 시트 및 JavaScript파일)
        > 
        
        **2. 소프트웨어**
        
        > 보통 HTTP 서버를 의미한다.
        > 
        > 
        > **HTTP 서버**는 **URL**(웹주소) 및 **HTTP**(프로토콜 주소)를 이해하는 소프트웨어이다.
        > 
        > **HTTP 서버**는 저장하는 웹 사이트의 도메인 이름을 통해 액세스 할 수 있으며 이러한 호스팅 된 웹 사이트의 콘텐츠를 최종 사용자의 장치로 전달한다.
        > 
        
        
        
        > 브라우저에 웹 서버에서 호스팅되는 파일이 필요할 때마다 브라우저는 HTTP를 통해 파일을 요청한다.
        > 
        > 
        > 요청이 올바른 **웹서버**(하드웨어)에 도달하면 **HTTP서버**(소프트웨어)가 요청을 수락하고 요청된 문서를 찾은 다음에 **HTTP를 통해 브라우저**로 다시 보낸다.
        > 
        > (서버가 요청된 문서를 찾지 못하면 대신 404 응답을 반환하게 된다.)
        > 
    
    결국 **아파치서버** 란 클라이언트에서 요청하는 HTTP요청을 처리하는 **웹서버**를 의미한다.
    
    이는 **정적타입** (HTML, CSS, 이미지 등)의 데이터만을 처리하기 때문에 톰캣이란 것이 등장한 것 같다.
    

- Tomcat  **WAS**(web application server)
    
    JAVA EE 기반으로 만들어졌으며, JSP와 Servlet을 구동하기 위한 서블릿 컨테이너 역할을 수행한다.
    
    아파치서버와는 다르게 DB연결, 다른 응용프로그램과 상호 작용 등 동적인 기능들을
    
    사용할 수 있다.
    
    ### WAS(wab application server) 란 ?
    
    > DB 처리, 로직 처리를 요구하는 동적타입을 제공하는 소프트웨어 프레임워크를 의미한다.
    > 
    > 
    > 기본적으로 사용되는 기능 3가지는 아래와 같다.
    > 
    > - 프로그램 실행 환경과 데이터베이스 접속 기능을 제공한다.
    > - 여러 개의 트랜잭션을 관리한다.
    > - 업무를 처리하는 비즈니스 로직을 수행한다.
    - 컨테이너(container)
        
        > 동적인 데이터들을 가공하여 정적인 파일로 만들어주는 모듈
        > 
    - 서블릿(servlet)
        
        > 클라이언트의 요청을 받고 요청을 처리하여 결과를 클라이언트에게 제공하는 자바 인터페이스.
        > 
        > 
        > java.servlet.package에 정의된 인터페이스로서 서블릿의 라이프 사이클을 위한 세 가지 필수적인 메소드들을 정의한다.
        > 
        > - init()
        > - service()
        > - destory()
    - 서블릿 컨테이너(servlet container)
        
        > 서블릿들을 모아 관리새로운 요청이 들어올 때마다 새로운 스레드를 생성작업이 끝난 서블릿 스레드 자동 제거
        > 
        

### **요약**

**아파치 서버(Apache Server)** - 정적인 파일 처리해주는 웹 서버 (80 포트)

**톰캣 (Tomcat)** - DB처리와 같은 동적인 기능들을 가공하여 HTML파일로 만들어 클라이언트에게 제공(8080 포트)

- 그러면  WEB 서버와 WAS 서버의 차이는 뭘까 ?
    
    *Client* 에서는 미리 정해진 *HTTP* 규격에 맞게 요청을 보내게 됩니다. 이것을 해석하고 우리는 *Client* 가 원하는 데이터를 보내주어야 합니다.
    
    - WEB 서버 : HTML, CSS, js, jpg 등 정적인 데이터를 처리하는 웹서버
        - 여기서 *HTTP* 를 해석하고, 그에 맞는 데이터 형식으로 보내주는 것이 *Web Server* 가 할 일입니다. 요청을 데이터와 단순하게 매칭을 하고, 이를 *HTTP* 에 맞게 돌려주면 되기 때문에, 이러한 과정을 *Static(정적)* 인 웹서버 라고도 합니다.
        - 정해진 데이터만 가져와서 반환하면 된다는 점 때문에, 처리 속도가 빠르며 트래픽의 과부하를 잘 처리할 수 있다는 장점이 있습니다.
    - WAS(Web Application Server) 서버: JSP, ASP, PHP 등 사용자의 입력을 받아 서버에서 무언가를 처리하고 그 결과를 보여주는 동적인 데이터를 처리하는 웹서버
        - 현실에서의 *Web Application*들은 더욱더 많은 기능을 요구할 때가 많습니다.
        - 예를 들면 커뮤니티 사이트에서 자신이 쓴 글만 모아서 볼 수 있게 하는 기능 등이 있습니다. 하지만 기존의 *Web Server* 에서는 *DB* 와 함께 유동적으로 로직에 따라 요청을 처리하지 못합니다. 이를 해결하기 위해서 *Web Application Server*를 사용하게 됩니다.
        
       
        - *WAS (Web Application Server)* 는 일부 *Web Server* 기능과 *Web Container* 로 함께 구성됩니다. 앞 단의 *Web Server* 는 *HTTP* 요청을 받아서 *Web Container* 로 넘겨주게 됩니다. *Web Container* 이를 내부 프로그램 로직의 처리에 따라서 데이터를 만들어서 *Web Server* 로 다시 전달하게 됩니다. *Java* 에서는 이를 *Servlet* 을 통해서 처리하기 때문에 *Servlet Container* 라고도 부릅니다. 앞서 언급한 같은 *URL* 이지만 로그인한 사용자에 따라 자신이 쓴 글이 보이게 하는 등의 로직이 필요한 기능을 추가할 수가 있습니다. 요청 조건에 따라서 *Web Server* 가 유연하게 처리하지 못하는 문제가 해결됩니다. 이렇게 데이터를 가공한 후에 *Client* 에게 반환해주는 작업을 *Dynamic(동적)* 인 웹처리라고 합니다.
    
- Embedded Tomcat ( 내장톰캣 ) VS Tomcat ( 외장톰캣 )
    
    내장톰캣
    
    - 내장톰캣으로 실행하는 스프링부트 애플리케이션은 그 자체가 하나의 프로그램으로 서블릿 컨테이너가 하나의 포트를 독자적으로 점유함 그렇기 때문에 여러 호스트를 분기 할 수 있는 기능을 사용하기 매우 복잡함
    - jar든 war든 톰캣이 내장된 애플리케이션은 톰캣 구성에 대한 부분의 관심사를 분리하여 개발자에게 애플리케이션단의 코드 작성에 더 집중할 수 있게해줌(필요에 의하면 server.xml에서 작성했던 구성요소를 application.properties 에서 바인딩되어 내장톰캣에 설정됌)
    
    외장톰캣
    
    - 외장톰캣은 Apache HTTPd 에서 사용하는 Virtual Host라는 main host 하위에 가상의 호스트를 소프트웨어적으로 둘 수 있는 기능을 제공하는데, 외장 Tomcat에서도 Host설정으로 이 apache virtual host를 설정할 수 있음 ( 즉 여러 애플리케이션을 하나의 포트로 서비스 할 수 있음 )

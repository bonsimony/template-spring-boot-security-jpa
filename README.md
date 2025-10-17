<BONCMS_V1 환경 세팅 및 기본 프로젝트 구성과 기술 스택 설정 및 개발 준비>



전자정부프레임워크 버전 4.3.0
자바 버전 17
톰캣 버전 9



1. 자바 버전 확인
- CMD창에서 java -version 명령어 실행하여 17버전인지 확인하고 아니면 아래 링크로 이동한 후 설치
https://adoptium.net/temurin/releases/


2. 톰캣 설치
- 아래 링크로 이동하여 톰캣 버전 9를 설치한다.
ㄴ 메인 페이지 : https://archive.apache.org/dist/tomcat/ 
ㄴ 9.0.109 설치하는 페이지 : https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.109/bin/


3. 전자정부 프레임워크 4.3.0 설치하기
- 아래 링크로 이동하여 개발자용 개발환경 Windows 64bit를 설치한다.
https://www.egovframe.go.kr/home/sub.do?menuNo=94

4. 전자정부프레임워크 4.3.0을 실행한다.

5. Eclipse Marketplace 를 통해 플러그인을 설치한다.
  5-1. 이클립스 상단 메뉴에서 [Help] → **[Eclipse Marketplace...]**를 클릭합니다.
  5-2. 검색창에 Spring Tools 또는 **Spring Tools 4**를 입력하고 검색합니다.

  5-3. 검색된 **Spring Tools 4**를 찾아 [Install] 버튼을 클릭하여 설치합니다.

  5-4. Confirm 버튼을 클릭한다.

  5-5. 또 Confirm 버튼을 클릭한다.

  5-6. The installation cannot be completed as requested. 라는 문구가 보이면
         Update my installation to be compatible with the items being installled 옵션을 선택하고
         Confirm 버튼을 클릭한다. 이 옵션은 설치 항목과 호환되도록 내 설치 환경을 업데이트한다.

  5-7. I accept the terms of the license agreements 를 선택하고 Finish 버튼을 클릭한다.


  5-8. 창이 닫히면서 이클립스 오른쪽 하단을 보면 installing Software 라고 나오면서 설치를 진행하다가
          Trust Authorities 창이 나오면 https://downlocad.springsource.com 체크하고 Trurst Selected 버튼을 클릭한다.

  5-9. 또 조금만 설치하다가 Trust Artifacts 창이 나오는데 Select All 을 선택하고 Turst Selected 버튼을 클릭한다.

  5-10. 설치가 완료되면 Software Updates 창이 나오는데 REstart Eclipse IDE to apply software update?라고 나오는데
         Restart Now 버튼을 클릭한다.

  5-11. 재시작하면  [File] → [New] -> Others... 를 클릭한 후 Select a wizard 창에서 **Spring Starter Project**가 나타나고 Next 버튼을 클릭한다.

6. New Spring Starter Projecft 단계인데 추천/권장 설정 값을 입력하고 Next 버튼을 클릭한다.
항목	          현재 이미지 값 (참고)	   추천/권장 설정 값	                                   설명
Service URL	https://start.spring.io	   그대로 둡니다.	                                            Spring Initializr 서비스 주소입니다.
Name	            demo	                             BONCMS_V1	                                                        생성할 프로젝트의 이름입니다.
Location	C:\...	                             기본값(Workspace)을 그대로 둡니다.	      프로젝트 파일이 저장될 위치입니다.
Type	            Gradle - Groovy	    Maven	                                                        빌드 도구입니다. Spring Boot는 Maven이 더 일반적이며,
                                                                                                                                               Gradle을 선호하지 않는다면 Maven으로 변경해주세요.
Packaging	Jar	                             Jar	                                                                    패키징 형식입니다. 
                                                                                                                                               내장 Tomcat을 사용하기 위해 Jar가 권장됩니다.
Java Version	17	                             17	                                                                    JDK 버전입니다. 원하는 Java 17로 잘 설정되어 있습니다.
Language	Java	                             Java	                                                                    프로그래밍 언어입니다.
Group	            com.example	                com.bon.cms	                                                       그룹 ID(일반적으로 회사/조직 도메인 역순)를 설정합니다.
Artifact	            demo	                            BONCMS_V1	                                                       아티팩트 ID(프로젝트 이름과 동일하게)를 설정합니다.
Version	            0.0.1-SNAPSHOT	   그대로 둡니다.	                                          개발 중임을 나타내는 기본 버전입니다.
Description	Demo project...	                Baseline Project	                                 프로젝트 설명을 입력합니다.
Package	com.example.demo	   com.bon.cms.v1	                                           기본 패키지 이름입니다. 
                                                                                                                                               Group + Artifact의 소문자 버전으로 설정하는 것이 일반적입니다.

7. New Spring Starter Project Dependencies 단계이며 핵심 의존성을 선택하는데 
    Spring Boot Version을 정할때 목록에 있는 버전 중 **SNAPSHOT**이나 M (마일스톤) 표시가 없는 버전을 선택해야 한다.
   그 중에 3.5.6을 선택하고 화면 좌측 목록(Available)을 펼쳐서 다음 항목들을 찾아 우측 Selected 박스로 이동시켜준다.
    - Web: Spring Web
    - SQL: Spring Data JPA, MySQL Driver
    - Security: Spring Security
    - Developer Tools: Spring Boot DevTools (선택 사항이지만 권장)
    모든 의존성 선택 후 [Next >] 또는 **[Finish]**를 클릭하여 프로젝트 생성을 완료한다.

8. /BONCMS_V1/src/main/resources 경로에 있는 application.properties 파일을 application.yml로 수정한 후에 
    로컬 호스트 PC에서 실행을 하기 위해 아래 코드를 추가한 후 저장한다.
     server:
       port: 8080 # 서버 포트 번호 (기본값)

9.  /BONCMS_V1/src/main/java/com/bon/cms/v1 경로에 있는 BoncmsV1Application.java 파일을 수정한다.

package com.bon.cms.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;       // ① 임포트 추가
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration; // ② 임포트 추가

@SpringBootApplication(
    exclude = {
        DataSourceAutoConfiguration.class,       // ③ DB 연결 자동 설정 제외
        HibernateJpaAutoConfiguration.class      // ④ JPA/Hibernate 자동 설정 제외
    }
)
public class BoncmsV1Application {

    public static void main(String[] args) {
        SpringApplication.run(BoncmsV1Application.class, args);
    }
}

10. 수정을 완료하면 /BONCMS_V1/src/main/java/com/bon/cms/v1 경로에 있는 BoncmsV1Application.java 파일 마우스 우클릭 후
      [Run As] → **Spring Boot App**을 선택합니다.

11. 브라우저 주소창에 http://localhost:8080/ 입력 후 엔터를 누르면 Spring Security 기본 로그인 페이지 (Default Login Page)가 보여진다.

★★★ Spring Security 기본 로그인 페이지가 뜨는 이유 ★★★
프로젝트에 Spring Security 의존성을 추가하면, Security는 다음과 같은 기본 규칙을 활성화합니다.
  11-1. 모든 요청 가로채기 (Intercept): 서버에 들어오는 모든 HTTP 요청을 Spring Security가 가장 먼저 가로챕니다.
  11-2. 인증 확인: http://localhost:8080/ (루트 경로)로 접속하는 요청은 기본적으로 **인증(로그인)**이 필요하다고 간주됩니다.
  11-3. 로그인 페이지 리다이렉션: 인증되지 않은 사용자가 보호된 리소스에 접근하려고 하면, Security는 자동으로 사용자를 /login 경로(기본 로그인 페이지)로 리다이렉트 시킵니다. (SecurityConfig를 설정하기 전의 기본 규칙입니다.)









  
  <이클립스 EGit을 이용한 프로젝트 GitHub 연동 및 초기 푸시 상세 가이드>

1. GitHub에서 저장소(Repository) 생성

먼저 GitHub 웹사이트에서 코드를 올릴 공간을 만듭니다.

1-1. GitHub에 로그인한 후, 오른쪽 상단의 + 또는 Repositories 탭에서 New 버튼을 클릭합니다.

1-2. Repository name에 원하는 이름을 입력 합니다.
ex) template-spring-boot-security-jpa

1-3. 저장소 공개 여부(Public/Private)를 선택합니다.

1-4. 하단의 Create repository 버튼을 클릭하여 저장소를 만듭니다.

저장소가 생성된 후 나타나는 페이지에서 저장소의 URL을 복사해 둡니다. 
ex) https://github.com/bonsimony/template-spring-boot-security-jpa.git





2. 이클립스 프로젝트와 Git 연동

이클립스 프로젝트를 로컬 Git 저장소에 연결하고, 방금 만든 원격 GitHub 저장소와 연결합니다.

2-1. 프로젝트 우클릭: 이클립스에서 푸시하려는 프로젝트를 우클릭합니다.

2-2. **Team → Share Project...**를 선택합니다.

2-3. Share Project 창에서 Git을 선택합니다.

2-4. Use or create repository in parent folder of project 를 체크를 하고 
       Create Repository 버튼을 클릭 후 Finish 버튼을 클릭합니다.

2-5. 프로젝트 이름 옆에 [프로젝트명 master] 또는 [프로젝트명 main] 이 표시되는지 확인합니다.

2-6. 원격 저장소 연결:
- 이클립스 Window → Show View → Other...에서 Git Repositories 뷰를 엽니다.
- 프로젝트명과 동일한 저장소를 펼치고 Remotes 마우스 우클릭 후 Create Remote...를 클릭합니다.
- Create 버튼을 클릭합니다.
- 깃허브에서 생성한 Repository 들어가서 .git 으로 끝나는 주소를 복사 합니다.
- Change... 버튼을 클릭하면 Slect a URI 창을 열면 Location 부분과 Connection 부분이 자동으로 입력이 되고
  Authentication 부분에 User에는 GitHub 사용자 이름(ID)를 입력하고 
  Password에는 GitHub Personal Access Token (PAT) 을 입력합니다.
  ㄴ GitHub 사용자 이름(ID)
       -  GitHub 웹사이트에 로그인합니다.
       - 오른쪽 상단에 있는 프로필 이미지를 클릭합니다.
       - 드롭다운 메뉴의 최상단에 표시되는 이름이 **사용자 이름(ID)**입니다. (종종 실제 이름이나 회사 이름과 다를 수 있습니다.)
  ㄴ  GitHub Personal Access Token (PAT) -> 잃어버리면 새로 발급해야 하기 때문에 꼭 메모를 해두어야 한다!!!!!!!!!!
       - GitHub 접속 및 로그인: GitHub 웹사이트에 로그인합니다.
       - 설정 (Settings) 이동: 오른쪽 상단의 프로필 아이콘을 클릭한 후, 드롭다운 메뉴에서 **Settings**를 선택합니다.
       - 개발자 설정 접근: 왼쪽 메뉴 하단의 **Developer settings**를 클릭합니다.
       - 토큰 메뉴 선택: 왼쪽 메뉴에서 **Personal access tokens**를 클릭한 후, **Tokens (classic)**을 선택합니다. 
         (새로운 방식의 Fine-grained tokens도 있지만, EGit 연동에는 Classic 토큰이 더 범용적입니다.)
       - 새 토큰 생성: 오른쪽 상단의 Generate new token 버튼을 클릭하고 **Generate new token (classic)**을 선택합니다.
       - Note (필수): 토큰의 용도를 식별할 수 있는 이름을 입력합니다. (예: Egov-Eclipse-PAT)
       - Expiration (만료일): 만료 기간을 설정합니다. (보안을 위해 90일 또는 1년 권장)
       - Select scopes (권한 설정): EGit을 이용한 코드 푸시를 위해 repo 항목에 체크해야 합니다. (저장소에 대한 모든 권한을 포함합니다.)
       - 토큰 발급: 하단의 Generate token 버튼을 클릭합니다.
- Store in Secure Store 를 체크하고 Finish 버튼을 클릭한다.
- Save 버튼을 클릭한다.





3. 프로젝트 최초 커밋 및 GitHub 푸시
3-1. Git Staging 뷰 열기
- 이클립스 상단 메뉴에서 **Window**를 클릭합니다.      
- 드롭다운 메뉴에서 **Show View**를 선택합니다.
- 다시 펼쳐지는 메뉴에서 **Other...**를 선택합니다.
- 팝업된 Show View 창에서 Git 폴더를 확장합니다.
- 목록에서 **Git Staging**을 찾아서 선택한 후, **Open**을 클릭합니다.
- 이제 이클립스 하단이나 측면에 Git Staging이라는 이름의 새로운 탭이 열립니다.
3-2. 파일 Staging (변경사항 추가)
- Git Staging 뷰를 확인합니다.
- 뷰 상단에는 Unstaged Changes (스테이징되지 않은 변경 사항) 영역이 보이고, 그 아래에 프로젝트의 모든 파일 목록이 나타납니다.
- Unstaged Changes 영역의 오른쪽 상단에 있는 작은 아이콘 (일반적으로 더하기 기호 모양의 ++ 아이콘 또는 Add All 버튼)을 클릭합니다.
- Unstaged Changes 영역에 있던 모든 파일들이 Staged Changes (스테이징된 변경 사항) 영역으로 이동했는지 확인합니다.
3-3. 초기 커밋 (Commit) 생성
- Git Staging 뷰에서 Commit Message에 내용을 입력합니다.
- 오른쪽 하단에 있는 Commit 버튼만 클릭합니다.
3-4. 푸시 (Push) 실행
로컬 저장소에 커밋이 성공적으로 만들어졌으므로, 이제 이 내용을 GitHub로 전송합니다.
- 이클립스의 Package Explorer (프로젝트 목록)로 돌아갑니다.
- 프로젝트 **BONCMS_V1**을 우클릭합니다.
- Team → Push Branch 'master'... (혹은 Push to Upstream)를 선택합니다.
- 팝업 창에서 원격 저장소(origin) 정보가 올바른지 확인하고 Next 또는 **Finish**를 클릭합니다.

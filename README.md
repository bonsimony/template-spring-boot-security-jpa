# BONCMS_V1 개발 환경 설정 가이드

전자정부 프레임워크 기반 Spring Boot 프로젝트 개발 환경 구축 및 GitHub 연동 가이드입니다.

---

## 📋 필수 요구사항

- **Java**: 17 버전
- **Tomcat**: 버전 9
- **전자정부 프레임워크**: 4.3.0
- **IDE**: Eclipse

---

## 1️⃣ 개발 환경 설치

### 1-1. Java 17 버전 확인 및 설치

CMD 창에서 Java 버전 확인:
```bash
java -version
```

17 버전이 아니라면 다음 링크에서 설치:
- [Adoptium Temurin 다운로드](https://adoptium.net/temurin/releases/)

### 1-2. Tomcat 9 설치

아래 링크에서 Tomcat 9.0.109 버전을 다운로드합니다.
- [Tomcat 아카이브](https://archive.apache.org/dist/tomcat/)
- [9.0.109 직접 다운로드](https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.109/bin/)

### 1-3. 전자정부 프레임워크 4.3.0 설치

[전자정부 프레임워크 공식 사이트](https://www.egovframe.go.kr/home/sub.do?menuNo=94)에서 **Windows 64bit 개발자용** 버전을 다운로드하여 설치합니다.

---

## 2️⃣ Eclipse 플러그인 설치 (Spring Tools 4)

### 2-1. Eclipse Marketplace 열기
- 상단 메뉴: **[도움말]** → **[Eclipse Marketplace...]** 클릭

### 2-2. Spring Tools 4 검색 및 설치
- 검색창에 **Spring Tools 4** 입력
- 검색 결과에서 **[설치]** 버튼 클릭

### 2-3. 설치 프로세스 진행
1. **확인 버튼** 클릭 (반복)
2. "요청한 대로 설치를 완료할 수 없습니다" 메시지가 나타나면:
   - **"내 설치를 업데이트하세요"** 옵션 선택 → **[확인]** 클릭
3. **라이센스 계약 동의** 선택 → **[완료]** 클릭
4. Trust Authorities에서 **https://download.springsource.com** 체크
   - **[Trust Selected]** 클릭
5. **Select All** 선택 → **[Trust Selected]** 클릭
6. Eclipse 재시작 메시지 → **[지금 다시 시작]** 클릭

### 2-4. Spring Starter 프로젝트 생성
- **[파일]** → **[새로 만들기]** → **[기타...]** 선택
- **Spring Starter 프로젝트** 선택 → **[다음]** 클릭

---

## 3️⃣ New Spring Starter Project 설정

### 3-1. 기본 프로젝트 정보

| 항목 | 설정값 | 설명 |
|------|--------|------|
| **Service URL** | https://start.spring.io | 기본값 유지 |
| **Name (프로젝트명)** | BONCMS_V1 | 생성할 프로젝트 이름 |
| **Location** | C:...(작업 공간) | 프로젝트 저장 위치 |
| **Type** | Maven | Spring Boot는 Maven 권장 |
| **Packaging** | Jar | 내장 Tomcat 사용 |
| **Java** | 17 | JDK 17 선택 |
| **Language** | Java | Java 프로그래밍 언어 |
| **Group** | com.bon.cms | 그룹 ID (회사/조직 역순) |
| **Artifact** | BONCMS_V1 | 아티팩트 ID |
| **Version** | 0.0.1-SNAPSHOT | 개발 중 기본 버전 |
| **Package** | com.bon.cms.v1 | Group + Artifact 조합 |

### 3-2. Spring Boot 버전 선택
- 버전 목록에서 **3.5.6** 선택
- SNAPSHOT이나 M(마일스톤) 표시가 없는 버전 권장

### 3-3. 의존성(Dependencies) 선택

다음 항목들을 선택합니다:

**웹 (Web)**
- Spring Web

**데이터베이스 (SQL)**
- Spring Data JPA
- MySQL 드라이버

**보안 (Security)**
- Spring Security

**개발자 도구 (Developer Tools)**
- Spring Boot DevTools ⭐ (권장)

모든 의존성 선택 후 **[다음 >]** 또는 **[마침]** 클릭하여 프로젝트 생성

---

## 4️⃣ 프로젝트 기본 설정

### 4-1. application.properties → application.yml 변경

경로: `/BONCMS_V1/src/main/resources`

`application.properties` 파일을 `application.yml`로 변경하고 다음 코드 추가:

```yaml
server:
  port: 8080  # 서버 포트 번호 (기본값)
```

### 4-2. BoncmsV1Application.java 파일 수정

경로: `/BONCMS_V1/src/main/java/com/bon/cms/v1`

```java
package com.bon.cms.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(
    exclude = {
        DataSourceAutoConfiguration.class,      // DB 연결 자동 설정 제외
        HibernateJpaAutoConfiguration.class     // JPA/Hibernate 자동 설정 제외
    }
)
public class BoncmsV1Application {
    public static void main(String[] args) {
        SpringApplication.run(BoncmsV1Application.class, args);
    }
}
```

---

## 5️⃣ 프로젝트 실행

### 5-1. Spring Boot 앱 실행
1. `/BONCMS_V1/src/main/java/com/bon/cms/v1` 경로의 `BoncmsV1Application.java` 우클릭
2. **[다음 계정으로 실행]** → **Spring Boot App** 선택

### 5-2. 실행 확인
브라우저에서 `http://localhost:8080/` 입력하면 **Spring Security 기본 로그인 페이지**가 표시됩니다.

#### ⚠️ Spring Security 로그인 페이지가 나타나는 이유:
- Spring Security 의존성 추가 시, 기본적으로 모든 요청에 인증(로그인)을 요구합니다
- 인증되지 않은 사용자는 자동으로 `/login` 경로로 리다이렉트됩니다
- 이는 SecurityConfig 설정 전 기본 동작입니다

---

## 6️⃣ GitHub 연동 (EGit 사용)

### 6-1. GitHub 저장소 생성

1. GitHub 웹사이트에 로그인
2. 오른쪽 상단의 **[+ ]** 또는 **[Repositories]** 탭 클릭
3. **저장소 이름** 입력 (예: `template-spring-boot-security-jpa`)
4. **Public/Private** 선택
5. **[저장소 생성]** 버튼 클릭
6. 생성된 저장소 **URL 복사** (예: `https://github.com/username/template-spring-boot-security-jpa.git`)

### 6-2. Eclipse 프로젝트와 Git 연동

#### 단계 1: 로컬 Git 저장소 생성
1. Eclipse에서 프로젝트 우클릭
2. **[Team]** → **[프로젝트 공유...]** 선택
3. **Git** 선택
4. **"프로젝트의 상위 폴더에 저장소를 사용하거나 생성합니다"** 확인
5. **[저장소 생성]** → **[마침]** 클릭
6. 프로젝트명 옆에 `[프로젝트명 master]` 또는 `[프로젝트명 main]` 표시 확인

#### 단계 2: 원격 저장소 연결
1. **[Window]** → **[Show View]** → **[Other...]** 선택
2. **Git Repositories** 선택
3. 프로젝트명을 펼친 후 **[Remote]** 우클릭
4. **[원격 생성...]** 클릭
5. **[생성]** 버튼 클릭
6. GitHub에서 복사한 저장소 URL `.git` 주소 입력
7. **[변경...]** 버튼 클릭하여 다음 정보 입력:
   - **사용자**: GitHub 사용자명(ID)
   - **비밀번호**: GitHub Personal Access Token (PAT)

#### 단계 3: GitHub Personal Access Token (PAT) 생성

⚠️ **중요**: 토큰은 반드시 별도로 보관하세요!

1. GitHub 로그인
2. 오른쪽 상단 **프로필 아이콘** 클릭
3. 드롭다운 메뉴에서 **[Settings]** 선택
4. 왼쪽 메뉴 하단 **[Developer settings]** 클릭
5. **[Personal access tokens]** → **[Tokens (classic)]** 선택
6. **[Generate new token]** → **[Generate new token (classic)]** 선택
7. 다음 정보 입력:
   - **Note (필수)**: `Egov-Eclipse-PAT` (토큰 용도)
   - **Expiration**: 90일 또는 1년 권장 (보안을 위해)
   - **Scopes**: `repo` 항목 체크 (저장소 전체 권한)
8. **[Generate token]** 클릭
9. 생성된 토큰 복사 및 별도 보관

#### 단계 4: 저장소 연결 완료
1. **"보안스토어에 저장"** 체크
2. **[완료]** → **[저장]** 버튼 클릭

### 6-3. 초기 커밋 및 GitHub 푸시

#### 단계 1: Git Staging 뷰 열기
1. Eclipse 상단 메뉴 **[Window]** → **[Show View]** → **[Other...]** 클릭
2. **Git** 폴더 확장
3. **Git Staging** 선택 → **[열기]** 클릭
4. Eclipse 좌측 패널에 **Git Staging** 탭 생성됨

#### 단계 2: 파일 준비 (Staging)
1. **Git Staging** 확인
2. 상단의 **"Unstaged Changes"** (스테이징되지 않은 변경사항) 확인
3. 오른쪽 상단 **"++ (모두 추가)"** 버튼 클릭
4. 모든 파일이 **"Staged Changes"**로 이동 확인

#### 단계 3: 초기 커밋 생성
1. **Git Staging** 하단의 커밋 메시지 입력 필드에 메시지 작성
   (예: `Initial commit: BONCMS_V1 project setup`)
2. **[Commit]** 버튼 클릭

#### 단계 4: GitHub에 Push
1. Eclipse 좌측 패널에서 프로젝트 **BONCMS_V1** 우클릭
2. **[Team]** → **[Push Branch 'master'...]** (또는 **[Push to Upstream]**) 선택
3. 팝업 창에서 **Remote** 정보 확인 (origin이 올바르게 설정되었는지 확인)
4. **[다음]** 또는 **[마침]** 클릭
5. GitHub 저장소에 코드 푸시 완료 확인

---

## 📝 참고사항

- Spring Security 의존성으로 기본 로그인 페이지가 나타나는 것은 정상입니다
- 데이터베이스 자동 설정을 제외하는 이유는 수동으로 DB 설정을 구성하기 위함입니다
- PAT 토큰은 외부에 공개하지 마세요!
- 토큰 만료 기간을 설정하여 보안을 강화하세요

---

**프로젝트 개발 환경 설정 완료! 🎉**

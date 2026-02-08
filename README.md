
````markdown
# 🩺 QuadCore - 욕창방지 관제 시스템

Spring Boot 기반 욕창 방지 실시간 모니터링 시스템입니다.  
Thymeleaf 템플릿, RESTful 웹 기능, 실시간 알림 등을 제공합니다.

---

## 📦 프로젝트 클론 및 실행 방법

### 1. 프로젝트 클론

```bash
git clone -b 한정현 https://github.com/KSB131/real-project.git
cd real-project
````

---

### 2. Java 17 이상 설치 확인

```bash
java -version
```

> ✅ `17.x` 이상이면 OK
> ❗ 설치 안 된 경우: [Java 17 다운로드](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

---

## ⚙️ Gradle 프로젝트 실행 방법 (IDE별)

### ✅ IntelliJ IDEA (추천)

* `build.gradle` 파일을 열고 "Open as Project" 선택
* `QuadCoreApplication.java` 열고 ▶️ 실행

---

### ✅ Eclipse 사용자 (📌 Buildship 필요)

1. **Eclipse에서**
   `File` → `Import` → `Gradle` → `Existing Gradle Project` 선택
2. 루트 폴더 선택 후 Finish
3. `src/main/java/com.quadcore.QuadCoreApplication` 우클릭 → Run As → Java Application

---

### ✅ VS Code 사용자 (📌 Java 플러그인 필요)

1. [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) 설치
2. VS Code로 폴더 열기
3. `QuadCoreApplication.java` 열고 ▶️ 실행
   또는 터미널에서 다음 명령어 실행:

```bash
./gradlew bootRun
```

> Windows 사용자는 `gradlew.bat bootRun`

---

### ✅ 명령어로 직접 실행 (IDE 없이도 가능)

```bash
./gradlew bootRun
```

---

## 🧪 테스트 실행

```bash
./gradlew test
```

---

## 🗂️ 주요 기술 스택

| 구분  | 내용                                  |
| --- | ----------------------------------- |
| 백엔드 | Spring Boot 3.2                     |
| 템플릿 | Thymeleaf + Layout Dialect          |
| 빌드툴 | Gradle                              |
| 언어  | Java 17                             |
| 기타  | Lombok, Spring Validation, DevTools |

---

## 📂 프로젝트 구조

```
spring-wireframe/
│
├── build.gradle                              # Gradle 빌드 설정
│
└── src/main/
    │
    ├── java/com/quadcore/
    │   │
    │   ├── QuadCoreApplication.java          # 메인 클래스 (@SpringBootApplication)
    │   │
    │   └── controller/
    │       └── MainController.java           # 컨트롤러 (URL 라우팅)
    │
    └── resources/
        │
        ├── application.properties            # Spring 설정 (포트, DB 등)
        │
        ├── static/css/
        │   └── style.css                     # CSS 스타일
        │
        └── templates/
            │
            ├── layout/
            │   └── layout.html               # 공통 레이아웃 (사이드바)
            │
            ├── login.html                    # 로그인 페이지
            ├── register.html                 # 회원가입 페이지
            ├── dashboard.html                # 대시보드
            ├── patients.html                 # 침상 관리
            ├── monitoring.html               # 실시간 모니터링
            ├── alerts.html                   # 알림 센터
            ├── guide.html                    # 체위 가이드
            ├── reports.html                  # 보고서
            └── settings.html                 # 설정
```
## 파일별 역할

```

| 파일 | 설명 |
|------|------|
| `QuadCoreApplication.java` | 앱 시작점 (main 메서드) |
| `MainController.java` | URL → 화면 연결 |
| `application.properties` | DB, 포트 등 설정 |
| `style.css` | 전체 스타일 |
| `layout.html` | 사이드바 + 공통 구조 |
| `*.html` | 각 페이지 화면 |

```
---

## 🤝 기여 방법 (선택)

1. 이 저장소를 fork합니다.
2. 새 브랜치를 만듭니다. (`git checkout -b feature/기능명`)
3. 변경 후 커밋합니다. (`git commit -m "Add 기능"`)
4. 브랜치에 push합니다. (`git push origin feature/기능명`)
5. Pull Request를 제출합니다.

---

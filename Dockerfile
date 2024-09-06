# 1. Base image로 OpenJDK를 사용
FROM openjdk:17-jdk-slim

# 2. 환경 변수 설정
ARG ENV_FILE_PATH=.env
COPY ${ENV_FILE_PATH} .env

# 3. JAR 파일을 애플리케이션 디렉터리에 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 4. 컨테이너가 시작될 때 실행할 명령어
ENTRYPOINT ["java","-jar","/app.jar"]
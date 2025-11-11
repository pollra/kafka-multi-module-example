# Kafka Setup Guide

## 개요
이 프로젝트는 Spring Boot와 Apache Kafka를 사용한 알람 시스템 예제입니다.

## 구성 요소

- **Producer** (port: 8081): REST API를 통해 알람 메시지를 Kafka에 발행
- **Consumer** (port: 8082): Kafka로부터 알람 메시지를 수신하고 처리
- **Kafka**: 메시지 브로커
- **Zookeeper**: Kafka 클러스터 관리

## 실행 방법

### 1. Kafka 및 Zookeeper 시작

```bash
docker-compose up -d
```

Kafka와 Zookeeper가 시작되었는지 확인:
```bash
docker-compose ps
```

### 2. Producer 애플리케이션 실행

```bash
./domain/gradlew :producer:bootRun
```

또는 IDE에서 `ProducerApplication.java`를 직접 실행

### 3. Consumer 애플리케이션 실행

```bash
./domain/gradlew :consumer:bootRun
```

또는 IDE에서 `ConsumerApplication.java`를 직접 실행

## 테스트 방법

### 방법 1: 테스트 엔드포인트 사용

```bash
curl http://localhost:8081/api/alarms/test
```

### 방법 2: 커스텀 데이터 전송

```bash
curl -X POST http://localhost:8081/api/alarms \
  -H "Content-Type: application/json" \
  -d '{
    "timestamp": "2024-11-09T10:30:00",
    "userAgent": "Mozilla/5.0",
    "userName": "john.doe"
  }'
```

### 결과 확인

Consumer 로그에서 다음과 같은 메시지를 확인할 수 있습니다:

```
Received Kafka message: {...}
Processed alarm - timestamp: ..., userAgent: ..., userName: ...
Processing alarm for user: john.doe at 2024-11-09T10:30:00
```

## Kafka 토픽 확인

Kafka 토픽 목록 확인:
```bash
docker exec -it kafka kafka-topics --list --bootstrap-server localhost:9092
```

`alarm-topic`의 메시지 확인:
```bash
docker exec -it kafka kafka-console-consumer \
  --bootstrap-server localhost:9092 \
  --topic alarm-topic \
  --from-beginning
```

## 종료 방법

### 애플리케이션 종료
각 터미널에서 `Ctrl + C`

### Kafka 및 Zookeeper 종료
```bash
docker-compose down
```

완전히 삭제 (볼륨 포함):
```bash
docker-compose down -v
```

## 주요 설정

### Producer (application.yaml)
- Kafka 서버: `localhost:9092`
- 포트: `8081`
- Serializer: `StringSerializer`

### Consumer (application.yaml)
- Kafka 서버: `localhost:9092`
- 포트: `8082`
- Consumer Group: `alarm-consumer-group`
- Deserializer: `StringDeserializer`
- Auto Offset Reset: `earliest`

## 트러블슈팅

### Kafka 연결 실패
- Docker 컨테이너가 실행 중인지 확인: `docker-compose ps`
- Kafka 로그 확인: `docker-compose logs kafka`

### Consumer가 메시지를 받지 못함
- Kafka 토픽이 생성되었는지 확인
- Consumer Group이 올바르게 설정되었는지 확인
- `auto-offset-reset: earliest` 설정 확인

### 포트 충돌
- 8081, 8082, 9092, 2181 포트가 사용 중인지 확인
- 필요시 application.yaml에서 포트 변경

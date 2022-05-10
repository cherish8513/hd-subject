먼저, 외부적 요인으로(코로나, 교육생 활동) 과제에 전념하지 못한 점 죄송합니다.(예외처리, 테스트, 벨리데이션 체크 등 누락)

# 구현 전략
1. entity -> repository -> service -> controller 순으로 api를 구현했습니다
2. CODE 관련으로 pk를 사용하지 않는 점과 생성 될 수 있는 CODE 데이터가 한정적이라고 생각되어 테이블이 아닌 enum 클래스로 생성했습니다.
3. 예외 처리는 잘못 된 입력 값이 주어진 경우의 IllegalArgumentException 발생을 처리했습니다.
4. 테스트는 생성과 관련해서 repository와 service의 단위 테스트와 querydsl 조회 테스트를 진행했습니다.
5. 기획서에서 1개의 병원을 기준으로 검색하는 건지 헷갈려서 visit(방문 정보)과 관련한 기능은 제대로 구현하지 못했습니다. 죄송합니다.

# 사용
SubjectApplication으로 실행시켜 기본 포트인 8080에서 작동합니다. <br>
localhost:8080/h2-console을 통해서 데이터의 상황을 확인할 수 있습니다. <br>
포스트맨을 통해 기능을 사용해봤습니다. <br>

<img src="https://user-images.githubusercontent.com/61926875/167603476-a6a5e50c-f433-4d3c-ab02-e69002dc5ff1.png" width="300" height="300">
<img src="https://user-images.githubusercontent.com/61926875/167602810-4d666bbd-bdec-46c8-8428-9b6968ccb1ac.png" width="300" height="300">

## API 명세
### 1. 인증인가 API
#### 1.1 회원가입
#### 1.2 로그인
#### 1.3 로그아웃

### 2. 유저 API
#### 2.1 유저 전체 조회
| 항목 | 내용 | 
|-------|-------|
| URL  | GET /users  |
| Response   | 200 OK  |
| ResponseBody| id,email,name,createdAt,modifiedAt|
| Error | |

#### 2.2 유저 단건 조회
| 항목 | 내용 |
|-------|-------|
| URL  | GET /users/{userId}  |
| PathVariable| userId(Long, 필수)|
| Response   | 200 OK  |
| ResponseBody| id,email,name,createdAt,modifiedAt|


#### 2.3 유저 수정
| 항목 | 내용 |
|-------|-------|
| URL  | GET /users/{userId}  |
| Pathvariable| userId(Long, 필수)|
| RequestBody| name(String, 필수)|
| Response   | 200 OK  |
| ResponseBody| 수정된 유저 정보|
| Error | 400 Bad Request - 유저 정보 불일치 |
| 비고 | 로그인한 유저 당사자만 수정 가능 |

#### 2.4 유저 삭제
| 항목 | 내용 |
|-------|-------|
| URL  | GET /users/{userId}  |
| PathVariable| userId(Long, 필수)|
| Response   | 200 OK  |
| Error| 400 Bad Request - 유저 정보 불일치 |


### 3. 일정 API
#### 3.1 일정 생성
| 항목 | 내용 | 
|-------|-------|
| URL  | GET /users/{userId}/schedules  |
| PathVariable| userId(Long, 필수)|
| RequestBody| title(String, 필수) <br> content(Stirng, 필수)|
| Response   | 200 OK  |
| ResponseBody| id,title,content,createdAt,modifiedAt|
| Error | 400 Bad Request - 필수값 누락 |

#### 3.2 일정 전체 조회
#### 3.3 일정 단건 조회
#### 3.4 일정 수정
#### 3.5 일정 삭제

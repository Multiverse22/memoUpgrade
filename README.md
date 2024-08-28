1.일정 조회

+ API 명 : 단일 일정 조회
+ HTTP METHOD : GET
+ URL : api/memo/{id}
+ Request : @Pathvariable = id값

+ Response :
  ```
  {
    ”id”:03,
    "title":"오늘할일",
    "user”:”김창섭",
    ”memoContents”:”코드개선”,
    ”creationDate”:2024-08-13 12:34:56,
    ”modifiedDate”:2024-08-13 12:34:56
  }
  ```
+ 상태코드 :
  ```
  
  ```
* * *
2.일정 작성

+ API 명 : 일정 작성
+ HTTP METHOD : POST
+ URL : api/memo
+ Request :
  ```
  {
    "title":"오늘할일",
    "user":"이길환",
    "memoContents":"과제"
  }
  ```

+ Response :
  ```
  {
   "message":"작성완료"
  }
  ```
+ 상태코드 :
  ```
  ```
* * *
  3.일정 수정

+ API 명 : 일정 업데이트
+ HTTP METHOD : PUT
+ URL : api/memo/{id}
+ Request :
  ```
  {
    "user": "김갑환",
    "memoContents": "집에있기"
  }
  ```

+ Response :
  ```
  {
    "message":"수정완료"
  }
  ```
+ 상태코드 :
  ```
  ```
* * *
 4.일정 삭제

+ API 명 : 일정 삭제
+ HTTP METHOD : DELETE
+ URL : /todolist/{id}
+ Request : @PathVariable id

+ Response :
  ```
  {
   "message":"삭제완료"
  }
  ```
+ 상태코드 :
  ```
  ```
* * *
5.일정 목록 조회

+ API 명 : 일정 목록 조회
+ HTTP METHOD : GET
+ URL : /api/memolist/{user}
+ Request :
+
+ 

+ Response :
  ```
  예 http://localhost:8080/api/memolist/{user}
    {
        "user": "김길환",
        "memoContents": "과제",
        "creationDate": "1999-06-20 11:11:11",
        "modifiedDate": "1999-06-20 11:11:11"
    },
    {
        "user": "김길환",
        "memoContents": "집에서쉬기",
        "creationDate": "1999-06-20 11:11:11",
        "modifiedDate": "1999-06-20 11:11:11"
    }
  ```
  ```
+ 상태코드 :
  ```
  '200 OK' 데이터 목록 조회 성공
  '404 Not Found' 사용자를 찾을수 없음
  ```
***
ERD 다이어그램
![image](https://github.com/user-attachments/assets/d2b13d00-3e6a-4fae-a920-19eb5c4cc9d4)

->수정사항


![image](https://github.com/user-attachments/assets/4e81d113-f532-4373-a3d7-e1a6f355ae91)





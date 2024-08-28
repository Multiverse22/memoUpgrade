1.일정 조회

+ API 명 : 단일 일정 조회
+ HTTP METHOD : GET
+ URL : api/memos/{id}
+ Request : @Pathvariable = id값

+ Response :
  ```
  {
    "id": 6,
    "writer": "페이징테스트2",
    "title": "정상화의은혜",
    "memoContents": "정상화",
    "commentCount": 0,
    "createdAt": "2024-08-28T17:54:25.709662",
    "modifiedAt": "2024-08-28T17:54:25.709662",
    "userIds": [
        {
            "id": 3,
            "name": "페이징테스트2",
            "email": "테스트2"
        }
    ]
  }
  ```
+ 상태코드 :
  ```
  
  ```
* * *
2.일정 작성

+ API 명 : 일정 작성
+ HTTP METHOD : POST
+ URL : api/memos
+ Request :
  ```
  {
    "title":"정상화의은혜",
    "memoContents":"정상화"
  }
  ```

+ Response :
  ```
  {
    "message": "작성 완료",
    "status": 201,
    "userId": 8
  }
  ```
+ 상태코드 :
  ```
  ```
* * *
  3.일정 수정

+ API 명 : 일정 업데이트
+ HTTP METHOD : PUT
+ URL : api/memos/{id}
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
    "message": "수정 완료",
    "status": 201,
    "userId": 6
  }
  ```
+ 상태코드 :
  ```
  ```
* * *
 4.일정 삭제

+ API 명 : 일정 삭제
+ HTTP METHOD : DELETE
+ URL : /api/memos/{id}
+ Request : @PathVariable id

+ Response :
  ```
  {
   5
  }
  ```
+ 상태코드 :
  ```
  ```
* * *
5.일정 목록 조회

+ API 명 : 일정 목록 조회
+ HTTP METHOD : GET
+ URL : /api/memos
+ Request :
+
+ 

+ Response :
  ```
  예 http://localhost:8080/api/memolist/{user}
    {
    "content": [
        {
            "title": "정상화의은혜",
            "memoContents": "정상화",
            "commentCount": 0,
            "createdAt": "2024-08-28T17:54:28.014502",
            "modifiedAt": "2024-08-28T17:54:28.014502",
            "postUser": "페이징테스트2"
        },
        {
            "title": "정상화의은혜",
            "memoContents": "정상화",
            "commentCount": 0,
            "createdAt": "2024-08-28T17:54:26.877526",
            "modifiedAt": "2024-08-28T17:54:26.877526",
            "postUser": "페이징테스트2"
        },
        {
            "title": "정상화의은혜",
            "memoContents": "정상화",
            "commentCount": 0,
            "createdAt": "2024-08-28T17:54:25.709662",
            "modifiedAt": "2024-08-28T17:54:25.709662",
            "postUser": "페이징테스트2"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 3,
    "totalPages": 1,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 3,
    "empty": false
}
  ```
  ```
+ 상태코드 :
  ```
  '200 OK' 데이터 목록 조회 성공
  '404 Not Found' 사용자를 찾을수 없음
  ```
***
6.댓글 작성

+ API 명 : 댓글 작성
+ HTTP METHOD : POST
+ URL : /api/comments/{memoId}
+ Request :
  ```
  {
    "userName":"김길환",
    "commentContents":"잘보고갑니다."
  }
  
  ``` 
+ Response :
  ```
  {
    "message": "댓글 작성완료",
    "status": 200,
    "userId": 6
  }
  ```
***
7.댓글 단건 조회

+ API 명 : 댓글 단건 조회
+ HTTP METHOD : GET
+ URL : /api/comments/{commentId}
+ Request : @Pathvariable commentId
  ```
  
  ```
+ Response :
  ```
  {
    "id": 1,
    "userName": "김길환",
    "commentContent": "잘보고갑니다.",
    "createdAt": "2024-08-28T20:58:45.915011",
    "modifiedAt": "2024-08-28T20:58:45.915011"
  }
  ```
  ***
8.댓글 리스트 조회

+ API 명 : 댓글 리스트 조회
+ HTTP METHOD : GET
+ URL : /api/comments/{memoId}
+ Request : @Pathvariable memoId
  ```
  
  ```
+ Response :
  ```[
    {
        "id": 1,
        "userName": "김길환",
        "commentContent": "잘보고갑니다.",
        "createdAt": "2024-08-28T20:58:45.915011",
        "modifiedAt": "2024-08-28T20:58:45.915011"
    }
]
  ```
***
9.댓글 삭제

+ API 명 : 댓글 리스트 조회
+ HTTP METHOD : Delete
+ URL : /api/comments/{commentId}
+ Request : @Pathvariable commentId
  ```
  
  ```
+ Response :
  ```
  6
  ```
***
10.댓글 수정

+ API 명 : 댓글 수정
+ HTTP METHOD : PUT
+ URL : /api/comments/{commentId}
+ Request : @Pathvariable commentId
  ```
  {
    "userName":"변경된김길환",
    "commentContents":"변경된내용"
  }
  
  ```
+ Response :
  ```
  {
    "id": 1,
    "userName": "변경된김길환",
    "commentContents": "변경된내용",
    "createAt": "2024-08-28T20:58:45.915011",
    "modifiedAt": "2024-08-28T20:58:45.915011"
  }
  ```
***
11.유저 저장

+ API 명 : 유저 저장
+ HTTP METHOD : POST
+ URL : /api/users
+ Request : 
  ```
  {
    "email":"테스트2",
    "name":"페이징테스트2"
  }
  ```
+ Response :
  ```
  {
    "id": 8,
    "name": "페이징테스트2",
    "email": "테스트2",
    "createAt": "2024-08-28T15:57:21.1361908",
    "modifiedAt": "2024-08-28T15:57:21.1361908"
  }
  ```
***
12. 일정에 매니저 할당

+ API 명 : 일정에 매니저 할당
+ HTTP METHOD : POST
+ URL : /api/users/{userId}/memos/{memoId}/mandate/{managerId}
+ Request : @PathVariable long userId, @PathVariable long memoId,@PathVariable long managerId
+ Response :
  ```
  ```
***
13.유저 단건 조회

+ API 명 : 유저 단건 조회
+ HTTP METHOD : GET
+ URL : /api/users/{userId}
+ Request : @PathVariable userId
  ```
  ```
+ Response :
  ```
  {
    "id": 6,
    "writer": "페이징테스트2",
    "title": "정상화의은혜",
    "memoContents": "정상화",
    "commentCount": 0,
    "createdAt": "2024-08-28T17:54:25.709662",
    "modifiedAt": "2024-08-28T17:54:25.709662",
    "userIds": [
        {
            "id": 3,
            "name": "페이징테스트2",
            "email": "테스트2"
        }
    ]
}
  ```
***
14.유저 전체 조회

+ API 명 : 유저 전체 조회
+ HTTP METHOD : GET
+ URL : /api/users
+ Request : @RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10")int size
  ```
  ```
+ Response :
  ```
 {
    "content": []<<줄생겨서 닫았습니다
        {
            "name": "페이징테스트2",
            "email": "테스트2",
            "createdAt": "2024-08-28T15:57:18.210346",
            "modifiedAt": "2024-08-28T15:57:18.210346"
        },
        {
            "name": "페이징테스트2",
            "email": "테스트2",
            "createdAt": "2024-08-28T15:57:18.752203",
            "modifiedAt": "2024-08-28T15:57:18.752203"
        },
        {
            "name": "페이징테스트2",
            "email": "테스트2",
            "createdAt": "2024-08-28T15:57:19.139464",
            "modifiedAt": "2024-08-28T15:57:19.139464"
        },
        {
            "name": "페이징테스트2",
            "email": "테스트2",
            "createdAt": "2024-08-28T15:57:19.526538",
            "modifiedAt": "2024-08-28T15:57:19.526538"
        },
        {
            "name": "페이징테스트2",
            "email": "테스트2",
            "createdAt": "2024-08-28T15:57:19.914301",
            "modifiedAt": "2024-08-28T15:57:19.914301"
        },
        {
            "name": "페이징테스트2",
            "email": "테스트2",
            "createdAt": "2024-08-28T15:57:20.579533",
            "modifiedAt": "2024-08-28T15:57:20.579533"
        },
        {
            "name": "페이징테스트2",
            "email": "테스트2",
            "createdAt": "2024-08-28T15:57:21.136191",
            "modifiedAt": "2024-08-28T15:57:21.136191"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalElements": 7,
    "totalPages": 1,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 7,
    "empty": false
}
  ```
***
15.유저 삭제

+ API 명 : 유저 저장
+ HTTP METHOD : DELETE
+ URL : /api/users
+ Request : @PathVariable userId
  ```
  ```
+ Response :
  ```
  3
  ```
***
16.유저 수정

+ API 명 : 유저 수정
+ HTTP METHOD : PUT
+ URL : /api/users/{userId}
+ Request :@PathVariable userId,@RequestBody userRequestDto requestDto
  ```
  {
    "email":"asd@zxc.com",
    "name":"김갑환"
  }
  ```
+ Response :
  ```
  {
    "id": 2,
    "name": "김갑환",
    "email": "asd@zxc.com",
    "createAt": "2024-08-28T15:57:18.210346",
    "modifiedAt": "2024-08-28T15:57:18.210346"
  }
  ```

ERD 다이어그램
![image](https://github.com/user-attachments/assets/d2b13d00-3e6a-4fae-a920-19eb5c4cc9d4)

->수정사항


![image](https://github.com/user-attachments/assets/4e81d113-f532-4373-a3d7-e1a6f355ae91)





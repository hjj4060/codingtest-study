# 코딩테스트 공부
1. 코딩테스트 전 꼭 알아야 할 개념과 문제(with 자바) : https://www.inflearn.com/course/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%90%EB%B0%94-%EA%B0%9C%EB%85%90/
2. 백준 단계별로 풀어보기 : https://www.acmicpc.net/step
3. 패스트캠퍼스 온라인 강의 : https://fastcampus.co.kr/courses/203934/clips/

### 문제집 링크
1. 백준
  - silver5 : https://solved.ac/problems/level/6?sort=solved&direction=desc&page=1
  - DP : https://solved.ac/problems/tags/dp?sort=solved&direction=desc&page=1

## 공부내용정리
1. 알고리즘 전략과 charAt(), substring() 함수 활용 문제풀이, String 형인 숫자를 int형으로 변경 방법, StringBuilder 사용이유 : https://deftkang.tistory.com/187?category=1006553
2. ToCharArray() 함수를 활용하여 문제풀이 : https://deftkang.tistory.com/190?category=1006553
3. indexOf(), substring() 함수의 개념과 코딩 : https://deftkang.tistory.com/193?category=1006553
4. 스캐너는 느리기 때문에 버퍼리더, 스트링토크나이저 이용 : https://deftkang.tistory.com/215
5. char를 int로 변경하면 아스키코드 나옴
6. 자료구조 배열 : https://deftkang.tistory.com/216

## 함수정리
1. String
   - charAt(I) => 문자열의 위치
   - charAt(i) -‘0’ => int 값
   - toCharArray() => char[] return
   - indexOf() => 문자의 위치를 반환
   - subString() => substirng(0, 7) = teacher
   - contains() => 문자열 내에 존재하는 특정 문자 시퀀스 확인 있으면 true 반환

## 다이나믹 프로그래밍

### 규격화된 문제 풀이
1. 문제가 원하는 정답을 찾기 위해 완전탐색접근을 시도해본다.
2. 완전탐색 과정에서 탐색하게 되는 경우가 지나치게 많아서 안될거 같다고 생각한다.
3. 이럴때 모든 경우를 빠르게 탐색하는 방법으로 다이나믹 프로그래밍으 접근을 시도한다.

### 다이나믹 프로그래밍 문제 풀이순서
1. 풀고싶은 가짜 문제 정의
2. 가짜문제를 풀면 진짜 문제를 풀수있는지 확인
3. 초기값 구하기
4. 점화식 구해내기
5. 진짜 문제 정답 출력하기

## 다음에 다시 풀 문제
1. https://www.acmicpc.net/problem/2839

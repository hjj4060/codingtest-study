# 공부하는 방법
1. 각 알고리즘 이해
   - 개념이해
   -  기본문제, 코드 따라해보기
   -  안보고도 코드 작성할 수 있을정도로 외우기
   -  유사 다른문제 풀어보기 기본적으로 10문제 정도
2. 실전상황 노출하기
   -  시간 정하면서 문제풀기
   -  스터디 활용
3. 각 알고리즘 이해 이후
   -  하루에 몇과목씩 돌아가면서 풀기
   -  한문제에 30분 넘기지 않기
     - 30분정도 보고 잘모르겠거나 감도 안왔을때 인터넷에서 풀이 보고, 코드를 안보고도 풀정도로 할수있어야 함
   -  틀린문제 복습하면서 반복
     - 오답노트를 만들어서 계속해서 잘 풀수있을정도로

# 코딩테스트 푸는 방법
1. 아이디어 생각
   1. 문제를 어떻게 풀것인지 여기서 대부분 설계하고 진행
   2. 처음에 내가 생각해낸 아이디어가 잘못됐을때 다시 생각하는 시간을 줄일수 있음
2. 시간복잡도
   1. 내가 설계한 방법이 오래걸리는지 확인
3. 자료구조(변수)
   1. 내가 자료구조를 어떻게 사용할지 미리 계획
   2. 최대숫자가 변수 범위가 넘어가서 쓰레기값이 나오는 걸 방지
   3. 문제풀기가 수월해진다.


# 코딩테스트 공부
1. 코딩테스트 전 꼭 알아야 할 개념과 문제(with 자바) : https://www.inflearn.com/course/%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%90%EB%B0%94-%EA%B0%9C%EB%85%90/
2. 백준 단계별로 풀어보기 : https://www.acmicpc.net/step
3. 패스트캠퍼스 온라인 강의 : https://fastcampus.co.kr/courses/203934/clips/

### 문제집 링크
1. 백준
  - silver5 : https://solved.ac/problems/level/6?sort=solved&direction=desc&page=1
  - silver3 : https://solved.ac/problems/level/8?sort=solved&direction=desc&page=1
  - silver2 : https://solved.ac/problems/level/9?sort=solved&direction=desc&page=1
  - silver1 : https://solved.ac/problems/level/10?sort=solved&direction=desc&page=1
  - DP : https://solved.ac/problems/tags/dp?sort=solved&direction=desc&page=1

## 공부내용정리
1. 알고리즘 전략과 charAt(), substring() 함수 활용 문제풀이, String 형인 숫자를 int형으로 변경 방법, StringBuilder 사용이유 : https://deftkang.tistory.com/187?category=1006553
2. ToCharArray() 함수를 활용하여 문제풀이 : https://deftkang.tistory.com/190?category=1006553
3. indexOf(), substring() 함수의 개념과 코딩 : https://deftkang.tistory.com/193?category=1006553
4. 스캐너는 느리기 때문에 버퍼리더, 스트링토크나이저 이용 : https://deftkang.tistory.com/215
5. char를 int로 변경하면 아스키코드 나옴
6. 자료구조 배열 : https://deftkang.tistory.com/216
7. 정렬은 크게 Quick sort방식과 Tim Sort 방식이 있다. Quick sort방식은  Arrays.sort()로 하고 Tim sort 방식은 Collections.sort() 함수를 이용 하는데 2개의 가장 큰 차이는 최악의 case일 경우에 Quick sort는 시간복잡도가 O(n^2) 이고 Tim sort는 O(NlogN)이다. 
8. A, B의 최소공배수는 A * B * (A,B의 최대공약수), 최대공약수는 유클리드호제법 알고리즘사용
9. 소수 찾기 에라토스테네스의체 이용

## 함수정리
1. String
   - "문자열".charAt(i) : 문자열에서 i번째 char형 반환
   - charAt(i) -‘0’ : int 값
   - toCharArray() : char[] return
   - indexOf() : 문자의 위치를 반환
   - subString() : substirng(0, 7) = teacher
   - contains() : 문자열 내에 존재하는 특정 문자 시퀀스 확인 있으면 true 반환
   - Character.isUpperCase(a) : a값이 대분자면 true
   - Character.toUpperCase(a) : a값을 대문자로 변환
   - String.valueOf() : 문자열 변환
2. Math 클래스
   - Math.abs(숫자값) : 절대값 반환
   - Math.pow(숫자값, 승수) : 숫자값에 대한 승수 값 리턴
3기타
   - () => 문자열 정렬용 함수, comparator 인터페이스 구현할때 사용
   
### 링크
1. 백준 
   - 실버5 푼사람순 : https://solved.ac/problems/level/6?sort=solved&direction=desc&page=1
   - dp 푼사람순 : https://solved.ac/problems/tags/dp?sort=solved&direction=desc&page=1 
   

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

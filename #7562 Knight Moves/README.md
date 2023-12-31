# <img width="20px"  src="https://d2gd6pc034wcta.cloudfront.net/tier/10.svg" class="solvedac-tier"> [Knight Moves](https://www.acmicpc.net/problem/7562) 

| 제출 번호 | 닉네임 | 채점 결과 | 메모리 | 시간 | 언어 | 코드 길이 |
|---|---|---|---|---|---|---|
|70955731|7174andy|맞았습니다!! |115436KB|396ms|Java 11|2083B|

## 문제
<p>Mr Somurolov, fabulous chess-gamer indeed, asserts that no one else but him can move knights from one position to another so fast. Can you beat him?</p>

<p>Your task is to write a program to calculate the minimum number of moves needed for a knight to reach one point from another, so that you have the chance to be faster than Somurolov.</p>

<p>For people not familiar with chess, the possible knight moves are shown in Figure 1.</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/knight.png" style="height:172px; width:175px"></p>

<p>Figure 1: Possible knight moves on the board.</p>

## 입력
<p>The input begins with the number n of scenarios on a single line by itself.</p>

<p>Next follow n scenarios. Each scenario consists of three lines containing integer numbers. The ﬁrst line speciﬁes the length l of a side of the chess board (4 ≤ l ≤ 300). The entire board has size l × l. The second and third line contain pair of integers {0, ..., l−1}× {0, ..., l−1} specifying the starting and ending position of the knight on the board. The integers are separated by a single blank. You can assume that the positions are valid positions on the chess board of that scenario</p>

## 출력
<p>For each scenario of the input you have to calculate the minimal amount of knight moves which are necessary to move from the starting point to the ending point. If starting point and ending point are equal, distance is zero. The distance must be written on a single line.</p>

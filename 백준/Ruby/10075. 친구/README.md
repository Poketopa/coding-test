# [Ruby V] 친구 - 10075 

[문제 링크](https://www.acmicpc.net/problem/10075) 

### 성능 요약

메모리: 17408 KB, 시간: 140 ms

### 분류

다이나믹 프로그래밍, 그리디 알고리즘

### 제출 일자

2026년 4월 26일 14:44:28

### 문제 설명

<p>0, ... , n-1로 번호가 매겨진 n명의 사람으로 구성된 소셜 네트워크를 만들자. 이 네트워크에 있는 사람들 중 어떤 쌍은 서로 친구가 된다. 즉, 사람 x가 사람 y의 친구가 되면, 사람 y도 사람 x의 친구가 된다.</p>

<p>사람들은 n 단계를 거쳐서 네트워크에 추가되는데, 각 단계를 0부터 n-1로 번호를 매기자. 사람 i는 단계 i에 추가된다. 단계 0에서, 사람 0은 이 네트워크에 있는 유일한 사람으로 추가된다. 다음 n-1개의 각 단계에서, 초대자가 새로 사람 하나를 네트워크에 추가한다. 초대자는 이 단계에 네트워크에 이미 들어와 있는 사람 중 하나이다. 단계 i에서 (0 < i < n), 이 단계의 초대자는 새로 들어오는 사람 를 다음 프로토콜 중 하나를 사용하여 네트워크에 추가한다.</p>

<ul>
	<li>IAmYourFriend는 사람 i를 초대자의 친구로만 등록한다.</li>
	<li>MyFriendsAreYourFriends는 사람 i를 초대자의 현재 모든 친구의 친구로 등록한다. 이 경우 사람 i는 초대자의 친구가 아니다.</li>
	<li>WeAreYourFriends는 사람 i를 초대자와, 초대자의 현재 모든 친구의 친구로 등록한다.</li>
</ul>

<p>네트워크를 다 만든 다음에는 설문을 위해서 표본을 구하고자 한다. 표본은 네트워크에 속한 사람들로 구성된 모임이다. 친구끼리는 서로 좋아하는 것이 비슷하기 때문에, 표본에 속하는 사람들 중에는 서로 친구인 쌍이 있으면 안 된다. 각 사람마다 설문에서 쓰이는 신뢰도가 있는데, 이는 양의 정수로 표현된다. 우리는 신뢰도의 총합이 최대인 표본을 구하려 한다.</p>

<table class="table table-bordered" style="width:50%">
	<thead>
		<tr>
			<th>단계</th>
			<th>초대자</th>
			<th>프로토콜</th>
			<th>추가되는 친구 관계</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>0</td>
			<td>IAmYourFriend</td>
			<td>(1, 0)</td>
		</tr>
		<tr>
			<td>2</td>
			<td>0</td>
			<td>MyFriendsAreYourFriends</td>
			<td>(2, 1)</td>
		</tr>
		<tr>
			<td>3</td>
			<td>1</td>
			<td>WeAreYourFriends</td>
			<td>(3, 1), (3, 0), (3, 2)</td>
		</tr>
		<tr>
			<td>4</td>
			<td>2</td>
			<td>MyFriendsAreYourFriends</td>
			<td>(4, 1), (4, 3)</td>
		</tr>
		<tr>
			<td>5</td>
			<td>0</td>
			<td>IAmYourFriend</td>
			<td>(5, 0)</td>
		</tr>
	</tbody>
</table>

<p>처음 네트워크에는 사람 0만 있다. 단계 1의 초대자(사람 0)는 새로 사람 1을 IAmYourFriend 프로토콜로 추가해서, 서로 친구가 된다. 단계 2의 초대자(이번에도 사람 0)는 사람 2를 MyFriendsAreYourFriends로 추가하는데,사람 1(초대자의 유일한 친구)이 사람 2의 유일한 친구가 된다. 단계 3의 초대자(사람 1)는 사람 3을WeAreYourFriends로 추가하는데, 사람 3은 사람 1(초대자)과 사람 0, 2 (초대자의 친구들)의 친구가 된다. 단계 4와 단계 5도 표에 보인 바와 같다. 최종적인 네트워크는 다음 그림과 같고, 동그라미 안의 숫자는 사람의 번호이고, 동그라미 아래의 숫자는 이 사람의 신뢰도를 나타낸다. 사람 3과 5로 이루어진 표본의 신뢰도의 총합은 20 + 15 = 35인데, 이는 가능한 신뢰도의 총합 중 최대이다.</p>

<p style="text-align: center;"><img alt="" src="" style="width: 293px; height: 173px;"></p>

<p>각 단계의 기술과 각 사람의 신뢰도가 주어졌을 때, 신뢰도의 총합이 최대인 표본을 구하시오.</p>

### 입력 

 <p>첫째 줄에 사람의 수 n이 주어진다.</p>

<p>둘째 줄에 각 사람의 신뢰도가 공백으로 구분되어 주어진다.</p>

<p>셋째 줄에는 각 단계의 정보가 host<sub>1</sub> protocol<sub>1</sub> host<sub>2</sub> protocol<sub>2</sub> ... host<sub>n-1</sub> protocol<sub>n-1</sub>과 같은 형식으로 주어진다. (단계 0에는 초대자가 없기 때문에 host<sub>0</sub>과 protocol<sub>0</sub>은 주어지지 않는다) host는 i번 단계의 초대자이고, protocol의 값이 0이면 IAmYourFriend, 1이면 MyFriendsAreYourFriends, 2이면 WeAreYourFriends 프로토콜이다.</p>

### 출력 

 <p>신뢰도의 총합이 최대인 표본에 대한 신뢰도의 총합을 출력한다.</p>


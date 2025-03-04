def solution(left, right):
    answer = 0
    # left에서 시작해서 right까지 시행
    for i in range(left, right+1):
        # temp 는 약수의 갯수
        temp = 0
        # 1부터 i까지 약수 계산
        for j in range(1, i+1):
            # 나머지가 0이면 나누어 떨어진다 -> 약수다!
            if i % j == 0:
                temp += 1
        if temp % 2 == 0:
            answer += i
        else:
            answer -= i
    return answer
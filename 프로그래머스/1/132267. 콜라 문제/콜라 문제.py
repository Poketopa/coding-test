def solution(a, b, n):
    # 빈병 a개를 콜라 b개로 바꿔줌 n개면?
    answer = 0
    while 1:
        if n // a == 0:
            break
        newBottle = n // a
        newBottle *= b
        emptyBottle = n % a
        n = emptyBottle + newBottle
        answer += newBottle
    
    return answer
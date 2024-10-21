def solution(n):
    answer = 1
    for i in range(2,n+1):
        if i%2==0:
            continue
        else:
            for j in range(2,int(i**(1/2))+1):
                if i%j == 0:
                    answer -=1
                    break
            answer +=1
    return answer
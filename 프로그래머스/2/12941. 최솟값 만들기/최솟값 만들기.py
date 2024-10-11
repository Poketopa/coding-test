def solution(A,B):
    A.sort()
    B.sort(reverse = True)
    sum =0
    for x,y in zip(A,B):
        sum += x*y

    return sum
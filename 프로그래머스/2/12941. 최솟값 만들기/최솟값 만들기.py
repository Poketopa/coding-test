def solution(A,B):
    sum = 0
    A.sort()
    B.sort()
    for i in range(0, len(A)):
        sum += A[i] * B[len(B)-i -1]
    return sum
def solution(slice, n):
    count = 1
    sum = slice
    while True:
        if sum >= n:
            return count
        else:
            count = count + 1
            sum += slice

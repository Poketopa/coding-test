def solution(s):
    newList = s.split()
    newList = [int(num) for num in newList]
    maxValue = max(newList)
    minValue = min(newList)
    answer = str(minValue) + " " + str(maxValue)
    return answer
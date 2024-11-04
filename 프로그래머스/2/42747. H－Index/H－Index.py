def solution(citations):
    min = 0
    maxIndex = 0
    citations = sorted(citations, reverse=True)
    for i in range(len(citations)):
        if (i+1 >= citations[i]):
            min = citations[i]
        else:
            min = i+1
        if (maxIndex < min):
            maxIndex = min
    return maxIndex
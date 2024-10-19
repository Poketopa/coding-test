def solution(name, yearning, photo):
    answer = []
    newDict = {}
    for i in range(len(name)):
        newDict[name[i]] = yearning[i]

    for i in photo:
        score = 0
        for j in i:
            score += newDict.get(j,0)
        answer.append(score)
            

    
    return answer
def solution(keymap, targets):
    answer = []
    
    for targetIndex in targets:
        # TARGET의 문자 하나하나
        sum = 0
        for alpha in targetIndex:
            min = 100
            for i in keymap:
                if i.find(alpha) == -1:
                    continue
                elif i.find(alpha) < min:
                    min = i.find(alpha)
                    
            if min == 100:
                answer.append(-1)
                break
            else:
                sum += min+1
        if min == 100:
            continue
        else:
            answer.append(sum)
    
    return answer

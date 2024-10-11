def solution(s):
    temp = 0
    newList = list(s)
    for num in newList:
        if temp == -1:
            return False
            break
        else:
            if(num == "("):
                temp +=1
            else:
                temp -=1
    if temp == 0:
        return True
    else :
        return False
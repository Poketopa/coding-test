def solution(today, terms, privacies):
    answer = []
    
    
    # 오늘의 날짜를 배열로 저장 [2022, 05, 19]
    todayDate = today.split(".")
    # 정수형으로 변경
    todayDate = [int(i) for i in todayDate]
    
    # 약관의 유효기간을 딕셔너리로 저장
    contract = {}
    for i in terms:
        x, y = i.split()
        contract[x] = y
        
    
    for i in range(0,len(privacies)):
        # 날짜와 약관을 나눈다 
        temp = privacies[i].split()
        # 날짜를 배렬로 저장
        tempDate = temp[0].split(".")
        tempDate = [int(i) for i in tempDate]
        # 약관이 무엇인지 저장
        tempContract = temp[1]
        # 달에 약관의 달을 더한다
        tempDate[1] += int(contract[tempContract])
        # 달이 12가 넘어갈 경우 년도를 변경
        # 만약 달이 12의 배수면 1뺀 뒤 연산하고 다시 더함
        if tempDate[1] % 12 == 0:
            tempDate[0] += (tempDate[1] // 12)  -1
            tempDate[1] = 12
        else:
            tempDate[0] += tempDate[1] //12
            tempDate[1] = tempDate[1] % 12
        
        if tempDate[0]<todayDate[0]:
            answer.append(i+1)
            continue
        elif tempDate[0] == todayDate[0]:
            if tempDate[1]<todayDate[1]:
                answer.append(i+1)
                continue
            elif tempDate[1] == todayDate[1]:
                if tempDate[2]<=todayDate[2]:
                    answer.append(i+1)
                else:
                    continue

    return answer
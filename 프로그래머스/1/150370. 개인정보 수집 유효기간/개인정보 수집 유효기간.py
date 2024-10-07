from datetime import datetime, timedelta

def solution(today, terms, privacies):
    # 답
    answer = []
    # 약관과 달 저장
    terms2 = []
    privacies2 = []
    
    # [["A","6"], ["B", "12"], ["C", "3"]]
    for i in terms :
        terms2.append(i.split())
    for i in privacies : 
        privacies2.append(i.split())

        # 오늘 날짜 배열 저장
        today2 = today.split(".")
        # 1일 기준 저장
        todayDate = int(today2[0]) * 12 * 28 + int(today2[1]) * 28 + int(today2[2])

    count = 1

    for i in privacies2 : 
        # 계약 날짜 나누기
        expire = i[0].split(".")
        for j in terms2 :
            if i[1] == j[0] :
                expireDate = int(expire[0]) * 12*28 + int(expire[1]) * 28 + int(j[1]) * 28 + int(expire[2])
                break
        if todayDate >= expireDate :
            answer.append(count)
        count += 1

    return answer
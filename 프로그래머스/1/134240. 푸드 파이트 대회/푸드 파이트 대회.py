def solution(food):
    answer = []
    food_list = []
    
    for i in food[1:] : 
        food_list.append(i // 2)
        
    kcal = 1
    for i in food_list : 
        for j in range(i) : 
            answer.append(kcal)
        kcal += 1
        
    answer.append(0)
        
    kcal = len(food)-1
    for i in food_list[::-1] : 
        for j in range(i) : 
            answer.append(kcal)
        kcal -= 1
        
        
    answer = ''.join([str(num) for num in answer])
    
    return answer


print(solution([1, 3, 4, 6]))
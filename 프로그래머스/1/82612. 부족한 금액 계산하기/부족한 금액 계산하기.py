def solution(price, money, count):
    nowPrice = 0
    for i in range(count):
        nowPrice += price * (i+1)
    if nowPrice > money:
        return nowPrice - money
    else:
        return 0
a, b = map(int, input().strip().split(' '))
# a, b 를 입력받는 코드
# a==5, b==3

for i in range(0, b):
    for j in range(0, a):
        print("*", end="")
    print("")
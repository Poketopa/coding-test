basket, num = map(int, input().split())
arr = [0]
for i in range(1,basket+1):
    arr.append(i)


for _ in range(num):
    x, y = map(int,input().split())
    temp = arr[x]
    arr[x] = arr[y]
    arr[y] = temp
    
for i in range(1,len(arr)):
    print(arr[i],end = ' ')
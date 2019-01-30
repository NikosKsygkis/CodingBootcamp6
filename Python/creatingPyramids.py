N = int(input('floors? '))

for floor in range(N):
    word=''
    for i in range(N-1-floor):
        word=word+' '
    for i in range(2*floor+1):
        word=word+'*'
    print(word)
    


for floor in range(N):
    word=' ' * (N-1-floor)
    word=word+'*'*(2*floor + 1)
    print(word)



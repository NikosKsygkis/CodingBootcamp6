


def factorial(x):
    y = 1
    for i in range (1, x+1):        
        y *= i    
    print(y)
    return(y)



def fibonacci(n):

    a = 1
    b = 1

    for i in range(3, n+1):
        z=b
        b= a+b
        a=z
        
    return(b)



def fizzbuzz1(n):

    for i in range(n):
        
        if i%3==0 and i%5!=0:
            print(i,' is the fizz')

        elif i%5==0 and i%3!=0:
            print(i,' is the buzz')

        elif i%5==0 and i%3==0:
            print(i,' is the fizzbuzz')
        else:
            print(i)


def fizzbuzz2(n):
    for i in range(1,n+1):
        
        if int(i/3)*1.0==(i/3) and int(i/5)*1.0!=(i/5) :
           print(i,' is the fizz')
        elif int(i/5)*1.0==(i/5) and int(i/3)*1.0!=(i/3):
           print(i,' is the buzz')
        elif int(i/5)*1.0==(i/5) and int(i/3)*1.0==(i/3):
            print(i, 'fizzbuzz')
        else:
            print(i)

print(fizzbuzz2(10))




















        

## EXCERSISE 5 HANGMAN P vs AI
import random

words = ['bootcamp', 'algorithm', 'pasparakis']

secret = random.choice(words)

# to hint pou dinoume ston paixti
hint=[]

def listToStr(lista):
    x=''
    for i in lista:
        x=x+i+' '
    
    return x

for i in range(len(secret)):
    hint.append('_')

# to plithos twn prospatheiwn pou apomenoun
guesses = 7
used_letters = []

while guesses>0 and '_' in hint:

    print('Hint is: ',listToStr(hint))
    choice = input('dialekse ena gramma: ')

    if len(choice)>1:
        print('parapanw xaraktires')
        continue
    

    # elegxoume an o xaraktiras pou dwsame einai gramma kai an einai mikro

    while len(choice) !=1 and not choice.isalpha() and not choice.islower():
        choice=input('dialekse ena gramma: ')
        

    if choice in secret:
        
        for i in range(len(secret)):
            if secret[i] == choice:
                hint[i]=choice
        print('you guessed right!')

    else:
        guesses=guesses - 1
        print('wrong guess')
if guesses > 0:
    print('You win')

else:
    print('You lost')

def listToStr(lista):
    x=''
    for i in lista:
        x=x+i
    return x
        

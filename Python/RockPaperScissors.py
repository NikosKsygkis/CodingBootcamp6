# EXCERSISE 4 ROCK - PAPER - SCISSORS

import random

L=['rock', 'paper', 'scissors']
player=0
computer=0
for i in range(100):

    x=input('Choose between rock, paper, scissors: ')
    if x not in L:
        print("wrong word, choose again")
        continue
    y=random.choice(L)
    print('player= ',x)
    print('computer= ',y)
    
    if (x=='rock' and y=='scissors') or (x=='paper' and y=='rock') or (x=='scissors'and y=='paper'):
        player=player+1
        print('player wins :  player score: ',player, '   computer score: ',computer)
    elif x==y:
        print('player score: ',player, '   computer score: ',computer)
        continue
    else:
        computer=computer+1
        print('computer wins :  player score: ',player, '   computer score: ',computer)
    if player==3:
        print('player WINS !!!!')
        break
       
    elif computer==3:
        print('Computer WINS')
        break
       
    

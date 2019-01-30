"""
## 1 Custom Range
Create the function custom_range(start, end, step) which returns a list containing numbers in the range [start, end) and increase by 'step' in each iteration.

## 2 Larger than Sum
Create the function larger_than_sum(L) which returns True if for every  item of list L it holds that L[i] > sum(L[i+1] + L[i+2] + ... + L[len(L)-1]]) or False otherwise.

## 3 Palindrome
Create the function isPalindrome(L) which returns True if the list L is symmetrical or False otherwise. That is, L[0] == L[len(L)-1], L[1] == L[len(L)-2] etc.

## 4 Rock - Scissors - Paper PvsAI
Create a game for one player. Player chooses between rock / scissors / paper and the same is done by the computer in a random way. If someone wins the round he gets 1 point. The game is finished when someone gets 3 points.

## 5 Hangman PvsAI
Create a game for one player against the computer. The computer has a 'word bank', a list of words, from where it chooses one for the game. The player tries to guess it, character by character with a maximum of 7 guesses. If he manages to guess it he wins otherwise he loses. The game continually provides visual aid about the state of the game.

## 6 Hangman PvP
Create a game for two players, player Red and player Blue. Every round, Red player chooses a secret word and the other player tries to guess it, character by character with maximum of 7 guesses. Then, player Blue chooses a word and Red tries to guess it. If both players guess the word, or both fail then the round is a tie, otherwise one players gets 1 point. The game ends when a player reaches 3 points. The game continually provides visual aid about the state of the game.
"""
# EXCERSISE 6 HANGMAN P vs P

L=['house','computer','elevator','automobile']          
Blue=L[int(input('Blue choose between 0, 1, 2, 3 for the words in the list "L": '))]
M=[]
p=0
q=0

for e in Blue:
    M.append(e)
for i in range(30):
    Red=input('Red your letter is: ')
    
    if Red not in M:
        q=q+1
        print('incorrect for your number ',q,' try')
        
    if Red in M:
        
        for j in M:
            if Red in M:
                M.remove(Red)
                print('Well Done, the word now has: ',len(M),' letters')
    
       
    if q==7:
        print('you lose, the word was: ',Blue)

    
    elif M==[]:
        print('you win, the word was ',Blue)

## EXCERSISE 5 HANGMAN P vs AI
import random
L=['house','computer','elevator','automobile']          
y=random.choice(L)
M=[]
p=0
q=0

for e in y:
    M.append(e)
for i in range(30):
    x=input('your letter is: ')
    
    if x not in M:
        q=q+1
        print('incorrect and q= ',q)
        
    if x in M:
        print('Well Done')
        for j in M:
            if x in M:
                M.remove(x)                
                print('Well done! the word has now ',len(M),' letters')
    if q==7:
        print('you lose, the word was: ',y)

    elif M==[]:
        print('you win, the word was ',y)
    

# EXCERSISE 4 ROCK - PAPER - SCISSORS

import random

L=['rock', 'paper', 'scissors']
player=0
computer=0
for i in range(100):

    x=input('Choose between rock, paper, scissors: ')
    if x not in L:
        print("Please watch your spelling, choose again")
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


# EXCERSISE 3 PALINDROME
L=[500, 200, 50, 30, 15]
B=[1, 2, 3, 4, 3, 2, 1]
V=[1,2,3,3,2,1]
 
def isPalindrome(B):
    y=0
    for i in range(0, int(len(B)/2)):
        if B[i]==B[len(B)-1-i]:
            print(True)
            return True
        else:
            print(False)
            return False
isPalindrome(V)

# allos tropos einai na xrisimopoiisoume ti sinthiki me tin antistrofi L==L[::-1] i to L.reverse() me to V.copy())
   


# EXCERSISE 2 LARGER THAN SUM

def larger_than_sum(lista):
    x=0
    y=0
    for j in range(len(L)-1): 
        for i in range(j+1,len(L)):
            x=x+L[i]        
        if L[j]>x:            
            x=0                                             
        else:
            x=0
            y=y+1            
    if y==0:
        print("I LISTA EINAI AYKSOUSA")
        return(True)
    else:
        print('I LISTA DEN EINAI AYKSOUSA')
        return(False)   

# ALLOS TROPOS EINAI NA XRISIMOPOIISOUME TO " sum(L [ i : j ] , i to  " sum(L [ i : ] "





# EXCERSISE 1 CUSTOM RANGE
def CustomRange(a,b,c):

    L=[]

    for i in range(a,b,c):
        L.append(i)
    print(L)
    return L



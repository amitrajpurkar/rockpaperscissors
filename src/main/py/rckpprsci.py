# Rock-Paper-Scissors
# program that lets the user play Rock-Paper-Scissors against the computer
from random import randint

def tryout_exercise13():
    print("program that lets the user play Rock-Paper-Scissors against the computer")
    rock = 1
    paper = 2
    scissor = 3
    # paper > rock > scissor > paper

    user_wins = 0
    computer_wins = 0
    draws = 0
    for i in range(5):
        compPick = randint(1,3)
        uPick = input("enter your number: 1.rock, 2.paper, 3.scissor: ")
        userPick = eval(uPick) if uPick.isnumeric() else 0
        if compPick == rock:
            if userPick == rock:
                draws = draws + 1
            elif userPick == paper:
                user_wins = user_wins + 1
            elif userPick == scissor:
                computer_wins = computer_wins + 1
        elif compPick == paper:
            if userPick == rock:
                computer_wins = computer_wins + 1
            elif userPick == paper:
                draws = draws + 1
            elif userPick == scissor:
                user_wins = user_wins + 1
        elif compPick == scissor:
            if userPick == rock:
                user_wins = user_wins + 1
            elif userPick == paper:
                computer_wins = computer_wins + 1
            elif userPick == scissor:
                draws = draws + 1
    print("Results -- user wins",user_wins,"times, computer wins",computer_wins,"times, and draws",draws,"times")
    pass

def tryout_exercise13_v2():
    print("program that lets the user play Rock-Paper-Scissors against the computer")
    rock = 1
    paper = 2
    scissor = 3
    # paper > rock > scissor > paper

    user_wins = 0
    computer_wins = 0
    draws = 0
    for i in range(5):
        compPick = randint(1,3)
        uPick = input("enter your number: 1.rock, 2.paper, 3.scissor: ")
        userPick = eval(uPick) if uPick.isnumeric() else 0
        if ((compPick == rock and userPick == rock)
            or (compPick == paper and userPick == paper)
            or (compPick == scissor and userPick == scissor)):
                draws = draws + 1
        elif ((compPick == rock and userPick == paper)
            or (compPick == paper and userPick == scissor)
            or (compPick == scissor and userPick == rock)):
                user_wins = user_wins + 1
        elif ((compPick == rock and userPick == scissor)
            or (compPick == paper and userPick == rock)
            or (compPick == scissor and userPick == paper)):
                computer_wins = computer_wins + 1
    print("Results -- user wins",user_wins,"times, computer wins",computer_wins,"times, and draws",draws,"times")
    pass


tryout_exercise13_v2()



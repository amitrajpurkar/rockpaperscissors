# Rock-Paper-Scissors
# program that lets the user play Rock-Paper-Scissors against the computer
from random import randint


def rock_paper_scissors():
    print("program that lets the user play Rock-Paper-Scissors against the computer")
    rock = 1
    paper = 2
    scissor = 3
    # paper > rock > scissor > paper

    user_wins = 0
    computer_wins = 0
    print("scoreboard:: user:",user_wins,"computer:",computer_wins)
    draws = 0
    exit_entered = False
    while not exit_entered:
        compPick = randint(1,3)
        uPick = input("enter your number: 1.rock, 2.paper, 3.scissor (or 'exit' to quit): ")
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
        print("scoreboard:: user:",user_wins,"computer:",computer_wins)
        if uPick == "exit":
            exit_entered = True

    print("Results -- user wins",user_wins,"times, computer wins",computer_wins,"times, and draws",draws,"times")
    pass


rock_paper_scissors()



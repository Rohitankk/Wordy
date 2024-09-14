import sys
import threading
import traceback
import time

from PyQt5.QtCore import QSize

import WordyApp
from PyQt5 import QtCore, QtGui, QtWidgets
from Wordy_idl import *
from Client_Python.GUI.RoundWinner import RoundWinner
from Client_Python.GUI.Login import ui_mainpage
from Client_Python.GUI.Home import Home
from Client_Python.GUI.WinnerPage import WinnerPage
from Client_Python.GUI.Waiting import Waiting
from Client_Python.GUI.Leader import Leader
from Client_Python.GUI.Instruction import Instructions
from Client_Python.GUI.Game import Game


class Client():

    def __init__(self):
        self.ui = None
        self.wordyImpl = None
        self.mainWindow = None
        self.homePage = None
        self.gamePage = Game()
        self.winnerPage = None
        self.username = None
        self.thread = None
        self.formatter = '%S.%f'
        self.roundWinnerPage = None
        self.waiting = None
        self.leaderBoardsPage = None
        self.instructionsPage = None
        self.username = None
        self.drawPage = None
        self.w = "None"
        self.isWinner = False

    def initializeClient(self):
        orb = CORBA.ORB_init()

        obj = orb.string_to_object("IOR:000000000000001749444c3a576f7264794170702f576f7264793a312e300000000000010000000000000086000102000000000d3139322e3136382e312e31300000caee00000031afabcb00000000202882df1100000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002")
        self.wordyImpl = obj._narrow(WordyApp.Wordy)
        if self.wordyImpl is None:
            print("Unable to narrow the wordyImpl interface")
            sys.exit(1)

    def loginpage(self):
        try:
            self.mainWindow = QtWidgets.QMainWindow()
            self.ui = ui_mainpage()
            self.ui.setupUi(self.mainWindow)
            self.mainWindow.show()
            self.ui.LoginButton.clicked.connect(self.handleLoginButtonClick)
        except Exception as e:
            print(e)


    def showHomePage(self):
        self.mainWindow.close()
        self.homePage = QtWidgets.QMainWindow()
        self.ui = Home()
        self.ui.setupUi(self.homePage)
        self.homePage.show()
        self.ui.Username.setText(self.username)
        self.ui.Leaderboard.clicked.connect(self.showLeaderboards)
        self.ui.Instructions.clicked.connect(self.showInstructions)
        self.ui.SignOut.clicked.connect(self.handleSignOut)
        self.ui.Start.clicked.connect(self.startGame)

    def showHomePageAndCloseLoading(self):
        self.waiting.close()
        self.homePage = QtWidgets.QMainWindow()
        self.ui = Home()
        self.ui.setupUi(self.homePage)
        self.homePage.show()
        self.ui.Username.setText(self.username)
        self.ui.Leaderboard.clicked.connect(self.showLeaderboards)
        self.ui.Instructions.clicked.connect(self.showInstructions)
        self.ui.SignOut.clicked.connect(self.handleSignOut)
        self.ui.Start.clicked.connect(self.startGame)

    def showHomePageAndCloseGame(self):
        self.winnerPage.close()
        self.homePage = QtWidgets.QMainWindow()
        self.ui = Home()
        self.ui.setupUi(self.homePage)
        self.homePage.show()
        self.ui.Username.setText(self.username)
        self.ui.Leaderboard.clicked.connect(self.showLeaderboards)
        self.ui.Instructions.clicked.connect(self.showInstructions)
        self.ui.SignOut.clicked.connect(self.handleSignOut)
        self.ui.Start.clicked.connect(self.startGame)

    def handleLoginButtonClick(self):
        name = self.ui.UsernameTF.text()
        password = self.ui.PasswordTF.text()
        print(name)

        result = self.wordyImpl.login(name, password)
        print(result)
        try:
            if result == "Success":
                print("what")
                self.username = name
                self.showHomePage()
                print(name + " logged in successfully. Welcome!")
            elif result == "UsernameMismatch":
                raise usernameMismatch
            elif result == "AlreadyOnline":
                raise alreadyLoggedIn()

        except usernameMismatch:
            print("Hello")
            import tkinter as tk
            from tkinter import messagebox

            root = tk.Tk()
            root.withdraw()
            messagebox.showinfo("No Such User", "User does not exist!")

        except alreadyLoggedIn:
            import tkinter as tk
            from tkinter import messagebox

            root = tk.Tk()
            root.withdraw()
            messagebox.showinfo("Already Online", "User already online!")

    def handleSignOut(self):
        self.wordyImpl.signOut(self.username)
        self.homePage.close()
        self.loginpage()

    def showInstructions(self):
        self.homePage.close()
        self.instructionsPage = Instructions()
        self.ui = self.instructionsPage
        self.ui.setupUi(self.instructionsPage)
        self.instructionsPage.show()
        self.ui.Back.clicked.connect(self.showHomePageAndCloseInstructions)

    def showHomePageAndCloseInstructions(self):
        self.instructionsPage.close()
        self.showHomePage()

    def loadingPlayers(self):
        self.homePage.close()
        self.waiting = QtWidgets.QMainWindow()
        self.ui = Waiting()
        self.ui.setupUi(self.waiting)
        self.waiting.show()

    def loadingGame(self):
        self.waiting.close()
        self.waiting = QtWidgets.QMainWindow()
        self.ui = Waiting()
        self.ui.setupUi(self.waiting)
        self.waiting.show()

    def loadingRound(self):
        self.roundWinnerPage.close()
        self.waiting = QtWidgets.QMainWindow()
        self.ui = Waiting()
        self.ui.setupUi(self.waiting)
        self.waiting.show()

    def showGamePage(self):
        self.gamePage = Game()
        self.ui = self.gamePage
        self.ui.initUI()
        self.gamePage.UserNameLabel.setText(self.username)
        self.gamePage.show()
        self.gamePage.SendWordButton.clicked.connect(
            lambda: self.wordyImpl.sendWord(self.username, self.gamePage.jTextField1.text()))
        self.gamePage.ClearButton.clicked.connect(lambda: self.gamePage.jTextField1.setText(""))


    def startGame(self):
        try:
            glassPane = QtWidgets.QWidget(self.homePage)
            glassPane.setGeometry(self.homePage.geometry())
            glassPane.setStyleSheet("background-color: rgba(30, 19, 70, 225);")

            waitingLabel = QtWidgets.QLabel(glassPane)
            waitingLabel.setPixmap(QtGui.QPixmap("GUI/Waiting.py"))
            waitingLabel.setGeometry(QtCore.QRect(440, 315, 560, 80))

            self.homePage.setCentralWidget(glassPane)
            self.loadingPlayers()
            if not self.wordyImpl.startGame(self.username):
                self.waiting.close()
                self.showHomePageAndCloseLoading()

            else:
                self.loadingGame()

                while True:
                    if self.wordyImpl.checkTime(self.username, 5):
                        break

                thread = threading.Thread(target=self.run)
                thread.start()

                self.waiting.close()
                self.showGamePage()

                letterButtons = self.gamePage.letterButtons
                temp = self.wordyImpl.requestLetters(self.username)
                for i, letter in enumerate(temp):
                    imageIcon = QtGui.QIcon("images/" + letter + ".png")

                    button = letterButtons[i]
                    button.setIcon(imageIcon)
                    button.setText(letter)
                    size = QSize(82, 110)
                    button.setIconSize(size)

                    button.clicked.connect(lambda _, btn=button: self.letterButtonClicked(btn))

                time.sleep(15)

                if self.isWinner:
                    self.showGameWinner(self.w)
                    self.isWinner = False
                    self.w = "None"
                else:
                    if self.w == "Tie":
                        self.showRoundWinnerPage(self.w)
                        self.w = "None"
                    else:
                        self.showRoundWinnerPage(self.w)
                        self.w = "None"

        except Exception as e:
            traceback.print_exc()

    def letterButtonClicked(self, button):
        try:
            self.gamePage.jTextField1.setText(self.gamePage.jTextField1.text() + button.text())
        except Exception as e:
            traceback.print_exc()

    def run(self):
        try:
            while True:
                if self.wordyImpl.checkTime(self.username, 15):
                    winner = self.wordyImpl.getGameWinner(self.username)
                    if winner != "None":
                        self.isWinner = True
                        self.w = winner
                        # print("WINNER")
                        # self.showGameWinner(winner)
                        break
                    winner = self.wordyImpl.getRoundWinner(self.username)
                    print(winner)
                    if winner == "Tie":
                        self.w = winner
                        # self.showRoundWinnerPage("Tie")
                    else:
                        self.w = winner
                        # self.showRoundWinnerPage(winner)
                    break
                else:
                    time.sleep(0.05)
        except Exception as e:
            traceback.print_exc()


    def showRoundWinnerPage(self, winner):
        try:
            self.gamePage.close()
            self.roundWinnerPage = QtWidgets.QMainWindow()
            self.ui = RoundWinner()
            self.ui.setupUi(self.roundWinnerPage)
            self.ui.RoundWinnerLabel.setText(winner)
            self.roundWinnerPage.show()
            QtWidgets.QApplication.processEvents()
            self.ui.nextRoundBT.clicked.connect(self.handleNextRound)
        except Exception as e:
            traceback.print_exc()


    def showDrawPage(self):
        self.drawPage = QtWidgets.QMainWindow()
        self.ui = RoundWinner()
        self.ui.Draw(self.drawPage)
        self.drawPage.show()
        self.ui.nextRoundBT.clicked.connect(self.handleNextRound)

    def handleNextRound(self):
        self.loadingRound()
        while True:
            if self.wordyImpl.checkReadyStatus(self.username):
                break

        self.showGamePage()

        thread = threading.Thread(target=self.run())
        thread.start()

        self.showGamePage()

        letterButtons = self.gamePage.letterButtons
        temp = self.wordyImpl.requestLetters(self.username)
        for i, letter in enumerate(temp):
            imageIcon = QtGui.QIcon(
                "images/" + letter + ".png")
            button = letterButtons[i]
            button.setIcon(imageIcon)
            button.setText(letter)
            size = QSize(82, 110)
            button.setIconSize(size)

            button.clicked.connect(lambda _, btn=button: self.letterButtonClicked(btn))

    def showGameWinner(self, winner):
        try:
            self.winnerPage = QtWidgets.QMainWindow()
            self.ui = WinnerPage()
            self.ui.setupUi(self.winnerPage)
            self.ui.GameWinnerLabel.setText(winner)
            self.winnerPage.show()
            self.ui.Playagain.clicked.connect(self.showHomePageAndCloseGame())
        except Exception as e:
            traceback.print_exc()

    def showLoading(self):
        self.waiting = QtWidgets.QMainWindow()
        self.ui = Waiting()
        self.ui.setupUi(self.waiting)
        self.waiting.show()

    def showLeaderboards(self):
        self.homePage.close()
        self.leaderBoardsPage = Leader(self.wordyImpl.getTopPlayers(), self.wordyImpl.getTopWords())
        self.ui = self.leaderBoardsPage
        self.ui.setupUi(self.leaderBoardsPage)
        self.leaderBoardsPage.show()
        self.ui.Back.clicked.connect(self.showHomePageAndCloseLeaderboards)

    def showHomePageAndCloseLeaderboards(self):
        self.leaderBoardsPage.close()
        self.showHomePage()


if __name__ == "__main__":
    app = QtWidgets.QApplication(sys.argv)
    client = Client()

    client.initializeClient()
    client.loginpage()
    sys.exit(app.exec_())

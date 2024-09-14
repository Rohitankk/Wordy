import sys
from PyQt5 import QtCore, QtGui, QtWidgets
class Game(QtWidgets.QMainWindow):
    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):
        self.setWindowTitle("Game")
        self.setGeometry(0, 0, 1370, 775)
        self.setFixedSize(1370, 775)

        self.ProfileLabel = QtWidgets.QLabel(self)
        self.ProfileLabel.setPixmap(QtGui.QPixmap("Client_Python/images/Profile.png"))
        self.ProfileLabel.setGeometry(QtCore.QRect(10, 10, 100, 120))

        self.UserNameLabel = QtWidgets.QLabel(self)
        self.UserNameLabel.setGeometry(QtCore.QRect(110, 50, 180, 60))
        self.UserNameLabel.setStyleSheet("font-size: 48pt; color: rgb(255, 204, 0); font-family: STXinwei;")

        self.jTextField1 = QtWidgets.QLineEdit(self)
        self.jTextField1.setGeometry(QtCore.QRect(420, 130, 450, 100))
        self.jTextField1.setStyleSheet(
            "background-color: rgb(227, 192, 48); font-size: 48pt; color: rgb(68, 56, 29); border: none;")
        self.jTextField1.setAlignment(QtCore.Qt.AlignCenter)
        self.jTextField1.setVisible(True)

        self.ClearButton = QtWidgets.QPushButton(self)
        self.ClearButton.setGeometry(QtCore.QRect(610, 250, 190, 131))
        self.ClearButton.setIcon(QtGui.QIcon("Client_Python/images/ClearButton.png"))
        self.ClearButton.setStyleSheet("border: none;")

        self.SendWordButton = QtWidgets.QPushButton(self)
        self.SendWordButton.setGeometry(QtCore.QRect(890, 130, 190, 100))
        self.SendWordButton.setIcon(QtGui.QIcon("images/SpellButton.png"))
        self.SendWordButton.setStyleSheet("border: none;")

        self.TimeLabel = QtWidgets.QLabel(self)
        self.TimeLabel.setGeometry(QtCore.QRect(640, 30, 70, 60))
        self.TimeLabel.setStyleSheet("font-size: 48pt; color: rgb(234, 219, 133); font-family: Serif;")
        self.TimeLabel.setText("10")

        self.BackgroundLabel = QtWidgets.QLabel(self)
        self.BackgroundLabel.setPixmap(QtGui.QPixmap("Client_Python/images/inGame.png"))
        self.BackgroundLabel.setGeometry(QtCore.QRect(0, 0, 1370, 740))

        self.generateLetterButtons()
        self.jTextField1.raise_()
        self.ClearButton.raise_()
        self.SendWordButton.raise_()

    def generateLetterButtons(self):
        x = 420
        y = 370
        buttonSize = 82
        buttonSpacing = 90

        self.letterButtons = []
        for i in range(17):
            button = QtWidgets.QPushButton(self)
            button.setGeometry(QtCore.QRect(x, y, buttonSize, buttonSize))
            button.setStyleSheet("border: none;")
            self.letterButtons.append(button)

            x += buttonSpacing
            if (i + 1) % 7 == 0:
                x = 420
                y += buttonSpacing


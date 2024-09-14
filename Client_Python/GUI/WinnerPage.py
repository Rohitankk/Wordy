from PyQt5 import QtCore, QtGui, QtWidgets
from tkinter import *


class WinnerPage(object):
    def playagain(self):
        from Home import Home
        self.home = QtWidgets.QMainWindow()
        self.ui = Home()
        self.ui.setupUi(self.home)
        self.home.show()
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("WinnerPage")
        MainWindow.resize(1300, 750)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.Winnerpage = QtWidgets.QLabel(self.centralwidget)
        self.Winnerpage.setGeometry(QtCore.QRect(0, 0, 1370, 775))
        font = QtGui.QFont()
        font.setPointSize(60)
        font.setBold(False)
        font.setItalic(False)
        font.setWeight(50)

        self.GameWinnerLabel = QtWidgets.QLabel(self.centralwidget)
        font = QtGui.QFont("STXinwei")
        self.GameWinnerLabel.setFont(font)
        self.GameWinnerLabel.setStyleSheet("color: yellow; font-size: 40px;")
        # self.GameWinnerLabel.setForegroundRole(self,QtGui.QColor(255, 255, 255))
        self.GameWinnerLabel.setGeometry(QtCore.QRect(950, 560, 160, 90))

        self.Winnerpage.setFont(font)
        self.Winnerpage.setText("")
        self.Winnerpage.setPixmap(QtGui.QPixmap("Client_Python/images/WinnerPage.png"))
        self.Winnerpage.setObjectName("Winnerpage")
        self.Playagain = QtWidgets.QPushButton(self.centralwidget)
        self.Playagain.setGeometry(QtCore.QRect(300, 390, 320, 90))
        font = QtGui.QFont()
        font.setPointSize(40)
        self.Playagain.setFont(font)
        self.Playagain.setText("")
        self.Playagain.setStyleSheet("Border: 0px")
        self.Playagain.clicked.connect(self.playagain)
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("Client_Python/images/PlayAgain.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.Playagain.setIcon(icon)
        self.Playagain.setIconSize(QtCore.QSize(320, 90))
        self.Playagain.setObjectName("Playagain")
        self.Playagain.clicked.connect(MainWindow.close)
        # self.Exit = QtWidgets.QPushButton(self.centralwidget)
        # self.Exit.setGeometry(QtCore.QRect(950, 640, 160, 90))
        # self.Exit.clicked.connect(exit)
        # font = QtGui.QFont()
        # font.setPointSize(40)
        # self.Exit.setFont(font)
        # self.Exit.setText("")
        # icon1 = QtGui.QIcon()
        # icon1.addPixmap(QtGui.QPixmap("images/Exit.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        # self.Exit.setIcon(icon1)
        # self.Exit.setIconSize(QtCore.QSize(160, 90))
        # self.Exit.setObjectName("Exit")
        # self.Exit.setStyleSheet("Border: 0px")
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 1350, 800))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("Game Winner", "Game Winner"))




from PyQt5 import QtCore, QtGui, QtWidgets

class Home(object):

    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(1300, 750)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.Profile = QtWidgets.QLabel(self.centralwidget)
        self.Profile.setEnabled(True)
        self.Profile.setGeometry(QtCore.QRect(10, 10, 100, 120))
        self.Profile.setText("")
        self.Profile.setPixmap(QtGui.QPixmap("Client_Python/images/Profile.png"))
        self.Profile.setObjectName("Profile")


        self.Home = QtWidgets.QLabel(self.centralwidget)
        self.Home.setGeometry(QtCore.QRect(-50, -10, 1360, 760))
        self.Home.setText("")
        self.Home.setStyleSheet("Border: 0px")
        self.Home.setPixmap(QtGui.QPixmap("Client_Python/images/Home (1).png"))
        self.Home.setScaledContents(True)
        self.Home.setAlignment(QtCore.Qt.AlignCenter)
        self.Home.setObjectName("Home")

        self.Username = QtWidgets.QLabel(self.centralwidget)
        self.Username.setGeometry(120, 10, 150, 120)
        self.Username.setObjectName("Username")
        font = QtGui.QFont("STXinwei")
        self.Username.setFont(font)
        self.Username.setStyleSheet("color: rgb(255, 189, 89); font-size: 50px;")

        self.Start = QtWidgets.QPushButton(self.centralwidget)
        self.Start.setGeometry(QtCore.QRect(550, 480, 200, 100))
        self.Start.setAutoFillBackground(False)
        self.Start.setText("")
        self.Start.setStyleSheet("Border: 0px")
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("Client_Python/images/StartBT.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.Start.setIcon(icon)
        self.Start.setIconSize(QtCore.QSize(200, 100))
        self.Start.setObjectName("Start")

        self.Leaderboard = QtWidgets.QPushButton(self.centralwidget)
        self.Leaderboard.setGeometry(QtCore.QRect(10, 610, 141, 120))
        self.Leaderboard.setText("")
        self.Leaderboard.setStyleSheet("Border: 0px")
        icon1 = QtGui.QIcon()
        icon1.addPixmap(QtGui.QPixmap("Client_Python/images/LeaderBoards.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.Leaderboard.setIcon(icon1)
        self.Leaderboard.setIconSize(QtCore.QSize(141, 120))
        self.Leaderboard.setObjectName("Leaderboard")

        self.SignOut = QtWidgets.QPushButton(self.centralwidget)
        self.SignOut.setGeometry(QtCore.QRect(1180, -10, 100, 120))
        self.SignOut.setText("")
        self.SignOut.setStyleSheet("Border: 0px")
        icon3 = QtGui.QIcon()
        icon3.addPixmap(QtGui.QPixmap("Client_Python/images/LogoutBT.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.SignOut.setIcon(icon3)
        self.SignOut.setIconSize(QtCore.QSize(200, 100))
        self.SignOut.setObjectName("SignOut")

        self.Instructions = QtWidgets.QPushButton(self.centralwidget)
        self.Instructions.setGeometry(QtCore.QRect(1180, 610, 110, 120))
        self.Instructions.setText("")
        icon2 = QtGui.QIcon()
        icon2.addPixmap(QtGui.QPixmap("Client_Python/images/InstructionsBT.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.Instructions.setIcon(icon2)
        self.Instructions.setIconSize(QtCore.QSize(110, 120))
        self.Instructions.setStyleSheet("Border: 0px")
        self.Instructions.setObjectName("pushButton")

        self.Home.raise_()
        self.Profile.raise_()
        self.Start.raise_()
        self.Leaderboard.raise_()
        self.Instructions.raise_()
        self.SignOut.raise_()
        self.Username.raise_()
        self.Profile.raise_()

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
        MainWindow.setWindowTitle(_translate("Home", "Home"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = Home()
    ui.setupUi(MainWindow)
    ui.Username.setText("Rohit")
    MainWindow.show()
    sys.exit(app.exec_())

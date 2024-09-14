from PyQt5 import QtCore, QtGui, QtWidgets

class RoundWinner(object):

    def setupUi(self,MainWindow):
        MainWindow.setObjectName("Round Winner Page")
        MainWindow.resize(1320, 775)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")

        self.RoundWinnerLabel = QtWidgets.QLabel(self.centralwidget)
        font = QtGui.QFont("STXinwei")
        self.RoundWinnerLabel.setFont(font)
        self.RoundWinnerLabel.setStyleSheet("color: rgb(255, 189, 89); font-size: 70px;")
        # self.GameWinnerLabel.setForegroundRole(self,QtGui.QColor(255, 255, 255))
        self.RoundWinnerLabel.setGeometry(QtCore.QRect(550, 360, 380, 90))

        self.nextRoundBT = QtWidgets.QPushButton(self.centralwidget)
        self.nextRoundBT.setGeometry(QtCore.QRect(555, 565, 200, 100))
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("Client_Python/images/StartBT.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.nextRoundBT.setIconSize(QtCore.QSize(200, 100))
        self.nextRoundBT.setStyleSheet("Border: 0px")
        self.nextRoundBT.setIcon(icon)
        self.nextRoundBT.setObjectName("nextRound")

        self.BackgroundLabel = QtWidgets.QLabel(self.centralwidget)
        self.BackgroundLabel.setGeometry(QtCore.QRect(-50, -10, 1370, 775))
        self.BackgroundLabel.setStyleSheet("Border: 0px")
        self.BackgroundLabel.setPixmap(QtGui.QPixmap("Client_Python/images/RoundWinner.png"))
        self.BackgroundLabel.setScaledContents(True)
        self.BackgroundLabel.setAlignment(QtCore.Qt.AlignCenter)
        self.BackgroundLabel.setObjectName("BackgroundLabel")

        self.RoundWinnerLabel.raise_()
        self.nextRoundBT.raise_()

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(-50, -10, 1370, 775))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)
        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def Draw(self, MainWindow):
        name=""
        MainWindow.setObjectName("Round Winner Page")
        MainWindow.resize(1320, 775)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")

        self.nextRoundBT = QtWidgets.QPushButton(self.centralwidget)
        self.nextRoundBT.setGeometry(QtCore.QRect(555, 565, 200, 100))
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("Client_Python/images/StartBT.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.nextRoundBT.setIconSize(QtCore.QSize(200, 100))
        self.nextRoundBT.setStyleSheet("Border: 0px")
        self.nextRoundBT.setIcon(icon)
        self.nextRoundBT.setObjectName("nextRound")

        self.BackgroundLabel = QtWidgets.QLabel(self.centralwidget)
        self.BackgroundLabel.setGeometry(QtCore.QRect(-50, -10, 1370, 775))
        self.BackgroundLabel.setStyleSheet("Border: 0px")
        self.BackgroundLabel.setPixmap(QtGui.QPixmap("Client_Python/images/RoundDraw.png"))
        self.BackgroundLabel.setScaledContents(True)
        self.BackgroundLabel.setAlignment(QtCore.Qt.AlignCenter)
        self.BackgroundLabel.setObjectName("BackgroundLabel")

        self.nextRoundBT.raise_()

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(-50, -10, 1370, 775))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)
        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("Round Winner", "Round Winner"))



if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = RoundWinner()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())



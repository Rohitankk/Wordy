from PyQt5 import QtCore, QtGui, QtWidgets

class ui_mainpage(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("Login")
        MainWindow.resize(1300, 800)
        MainWindow.setMaximumSize(QtCore.QSize(1350, 900))
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.label = QtWidgets.QLabel(self.centralwidget)
        self.label.setGeometry(QtCore.QRect(0, 0, 1300, 800))
        self.label.setText("")
        self.label.setPixmap(QtGui.QPixmap("Client_Python/images/LoginPage.png"))
        self.label.setScaledContents(True)
        self.label.setAlignment(QtCore.Qt.AlignCenter)
        self.label.setObjectName("LoginPage")
        self.LoginButton = QtWidgets.QPushButton(self.centralwidget)
        self.LoginButton.setGeometry(QtCore.QRect(750, 600, 180, 90))
        self.LoginButton.setText("")
        self.LoginButton.setStyleSheet("Border: 0px")
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("Client_Python/images/LoginButton.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.LoginButton.setIcon(icon)
        self.LoginButton.setIconSize(QtCore.QSize(180, 90))
        self.LoginButton.setObjectName("LoginButton")
        self.UsernameTF = QtWidgets.QLineEdit(self.centralwidget)
        self.UsernameTF.setGeometry(QtCore.QRect(680, 410, 300, 40))
        self.UsernameTF.setText("")
        self.UsernameTF.setObjectName("UsernameTF")
        self.PasswordTF = QtWidgets.QLineEdit(self.centralwidget)
        self.PasswordTF.setGeometry(QtCore.QRect(680, 520, 300, 40))
        self.PasswordTF.setText("")
        self.PasswordTF.setObjectName("PasswordTF")
        MainWindow.setCentralWidget(self.centralwidget)
        self.menuBar = QtWidgets.QMenuBar(MainWindow)
        self.menuBar.setGeometry(QtCore.QRect(0, 0, 1350, 21))
        self.menuBar.setObjectName("menuBar")
        MainWindow.setMenuBar(self.menuBar)
        self.Wordy = QtWidgets.QStatusBar(MainWindow)
        self.Wordy.setObjectName("Wordy")
        MainWindow.setStatusBar(self.Wordy)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("Login", "Login"))

if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = ui_mainpage()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())

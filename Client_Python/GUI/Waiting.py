from PyQt5 import QtCore, QtGui, QtWidgets
import time

class Waiting(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(1300, 700)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.waiting = QtWidgets.QLabel(self.centralwidget)
        self.waiting.setGeometry(QtCore.QRect(0, 0, 1300, 700))
        self.waiting.setText("")
        self.waiting.setPixmap(QtGui.QPixmap("Client_Python/images/inGame.png"))
        self.waiting.setScaledContents(True)
        self.waiting.setObjectName("waiting")
        self.label_2 = QtWidgets.QLabel(self.centralwidget)
        self.label_2.setGeometry(QtCore.QRect(400, 280, 551, 61))
        self.label_2.setText("")
        self.label_2.setPixmap(QtGui.QPixmap("Client_Python/images/WaitingLabel-removebg-preview.png"))
        self.label_2.setObjectName("label_2")
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 1300, 21))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("Loading", "Loading"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = Waiting()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())

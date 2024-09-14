from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtWidgets import QApplication, QMainWindow


class Instructions(QMainWindow):
    def __init__(self):
        super().__init__()

    def setupUi(self,MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(1300, 800)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.label = QtWidgets.QLabel(self.centralwidget)
        self.label.setGeometry(QtCore.QRect(0, 0, 1300, 800))
        self.label.setText("")
        self.label.setPixmap(QtGui.QPixmap("Client_Python/images/InstructionsPage.png"))
        self.label.setObjectName("label")

        self.Back = QtWidgets.QPushButton(self.centralwidget)
        self.Back.setGeometry(QtCore.QRect(1020, 170, 120, 70))
        font = QtGui.QFont()
        font.setPointSize(30)
        self.Back.setFont(font)
        self.Back.setText("")
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("Client_Python/images/backBT.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.Back.setStyleSheet("Border: 0px")
        self.Back.setIcon(icon)
        self.Back.setIconSize(QtCore.QSize(120, 70))
        self.Back.setObjectName("Back")

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 1305, 21))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("Instructions", "Instructions"))


if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = Instructions()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())

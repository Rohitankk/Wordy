
from PyQt5 import QtCore, QtWidgets, QtGui
from PyQt5.QtWidgets import QApplication, QMainWindow
class Leader(QMainWindow):
    def __init__(self, wins, words):
        super().__init__()
        self.mostWins = wins
        self.longestWords = words

    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(1300, 750)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.label = QtWidgets.QLabel(self.centralwidget)
        self.label.setGeometry(QtCore.QRect(-70, 0, 1370, 800))
        self.label.setText("")
        self.label.setPixmap(QtGui.QPixmap("Client_Python/images/LeaderBoardsBG.png"))
        self.label.setScaledContents(True)
        self.label.setAlignment(QtCore.Qt.AlignCenter)
        self.label.setObjectName("label")
        self.Back = QtWidgets.QPushButton(self.centralwidget)
        self.Back.setGeometry(QtCore.QRect(1130, 10, 120, 60))
        font = QtGui.QFont()
        font.setPointSize(30)
        self.Back.setFont(font)
        self.Back.setText("")
        self.Back.setStyleSheet("Border: 0px")
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap("Client_Python/images/backBT.png"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.Back.setIcon(icon)
        self.Back.setIconSize(QtCore.QSize(120, 60))
        self.Back.setObjectName("pushButton")

        self.MostWinsTable = QtWidgets.QTableWidget(self.centralwidget)
        self.MostWinsTable.setGeometry(QtCore.QRect(75, 375, 400, 300))
        self.MostWinsTable.setColumnCount(2)
        self.MostWinsTable.setHorizontalHeaderLabels(["Name", "Wins"])
        self.MostWinsTable.setStyleSheet(f"background-color: rgb(71, 22, 168); color: white")
        self.MostWinsTable.horizontalHeader().setStyleSheet(
            "QHeaderView::section { background-color: rgb(71, 22, 168); color: white; }")
        self.MostWinsTable.verticalHeader().setStyleSheet(
            "QHeaderView::section { background-color: rgb(71, 22, 168); color: white; }")

        self.MostWinsTable.setRowCount(len(self.mostWins))
        for row, data in enumerate(self.mostWins):
            for col, value in enumerate(data):
                item = QtWidgets.QTableWidgetItem(str(value))
                self.MostWinsTable.setItem(row, col, item)

        self.LongestWordTable = QtWidgets.QTableWidget(self.centralwidget)
        self.LongestWordTable.setGeometry(QtCore.QRect(750, 375, 400, 300))
        self.LongestWordTable.setColumnCount(2)
        self.LongestWordTable.setHorizontalHeaderLabels(["Name", "Words"])
        self.LongestWordTable.setStyleSheet(f"background-color: rgb(255, 189, 89); color: white;")
        self.LongestWordTable.horizontalHeader().setStyleSheet(
            "QHeaderView::section { background-color: rgb(255, 189, 89); color: white; }")
        self.LongestWordTable.verticalHeader().setStyleSheet(
            "QHeaderView::section { background-color: rgb(255, 189, 89); color: white; }")

        self.LongestWordTable.setRowCount(len(self.longestWords))
        for row, data in enumerate(self.longestWords):
            for col, value in enumerate(data):
                item = QtWidgets.QTableWidgetItem(str(value))
                self.LongestWordTable.setItem(row, col, item)

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
        MainWindow.setWindowTitle(_translate("Leaderboards", "Leaderboards"))


if __name__ == "__main__":
    import sys
    # Example usage
    most_wins_data = [
        ["Player 1", "5"],
        ["Player 2", "3"],
        ["Player 3", "2"],
        # ...
    ]

    longest_words_data = [
        ["Player 1", "Word 1"],
        ["Player 2", "Word 2"],
        ["Player 3", "Word 3"],
        # ...
    ]

    app = QtWidgets.QApplication(sys.argv)
    MainWindow = QtWidgets.QMainWindow()
    ui = Leader(most_wins_data, longest_words_data)
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())

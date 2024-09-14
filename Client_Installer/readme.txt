WORDY GAME
--------------------------------------------------------------------------------------------
Wordy game is a Java Application that allows users to play a spelling game. Players have to 
spell a word more than four letters based on a set of letters provided, and whoever casts 
the longest word wins the round .

Features
--------------------------------------------------------------------------------------------
• User Friendly Interface
• Randomly Generated Letters
• High score Tracking
• LeaderBoards with the most wins and longest words


Installation
--------------------------------------------------------------------------------------------
• Make sure to download the required Python Languages into you system 

	‣ Python 3.8

	  Link: https://www.python.org/downloads/release/python-380/

	‣ Python 3.10

	  Link: https://www.python.org/downloads/release/python-31011/

• Download the Python compatible ORB packages which are: 

    	‣ OmniOrb 
      ‣ OmniOrb-py version 4.3 
   
 	Link: https://sourceforge.net/projects/omniorb/files/omniORBpy/omniORBpy-4.3.0/

• Download Pycharm, an IDE that supports Python programming language 
  
	Link: https://www.jetbrains.com/pycharm/download/#section=windows


• Place the necessary paths in the terminal's environment variables 

• Ensure that the terminal has registered the Python version/s and orb module
  with the commands:

   	‣ python --version 
 	‣ omniidl -u 

• Clone the repository : https://gitlab.com/ramecaba/finalproject7_900-1030tf_other.git

• Add Python 3.8 as a Python Interpreter in Pycharm and download the necessary packages: 
 
  	‣ omniorb-py
 	‣ PyQT5 package

• To install the PyQT5 package the following commands were used: 

	‣ pip install pyqt5
	‣ pip install pyqt5-tools
   

• Navigate to the Java project source folder and compile the Wordy.idl file for the 
  Python project in your command prompt with the command below and add it inot the Python project 

      ‣ idlj -fall Wordy.idl 

• Connect to the Java Side Server

    In the same directory, type in  the  command:

      ‣ start orbd ORBInitialPort 1044

• Create the Python side Wordy Program in the Python project directory with the command:

      ‣ omniidl-bpython Wordy.idl  


Usage
--------------------------------------------------------------------------------------------

• Launch the Application
To start the game, Navigate to the source folder of the project with Command Prompt and
issue these commands to start the ORB Demon start orbd -ORBInitialPort 1044 After issuing
the command, you can now start the client class

• Login with your credentials
	Melody  000	
	Rohit   000
	Krisha  000
	Allen   000

• Read the Instructions Carefully
• Start a Game and Wait for Players to join
• Enter your Word by clicking on the letters provided
• Press SPELL to submit your word and spell as many as you can within 10 seconds
• Move to the next round and win 3 rounds to be the Winner of the game
• Play again or go back to the home page


Authors and acknowledgment
--------------------------------------------------------------------------------------------

Authors

• Rohit Tank: 2223175@slu.edu.ph
• Melody Jane Ang: 2223314@slu.edu.ph
• Allen Cedric Manaois: 2213503@slu.edu.ph
• Bruce Balderas:2191909@slu.edu.ph
• Crisha Mae Deguzman:2206090@slu.edu.ph
• John Rex Aliba:219487@slu.edu.ph

Acknowledgements

Sir Ramel Cabanilla
Sir Roderick Makil
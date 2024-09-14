class Exceptions(Exception):
    def __init__(self, message):
        super().__init__(message)
        self.message = message

    def UserAlreadyExists(self):
        self.message = "User Already Exists"
        return self.message

    def UsernameMismatch(self):
        self.message = "Incorrect Password"
        return self.message

    def NotAWordException(self):
        self.message = "Invalid Word!"
        return self.message

    def UserAlreadyLoggedIn(self):
        self.message = "This user is already logged in!"
        return self.message

    def WordLessThan5Letters(self):
        self.message = "Your word is less than 5 letters"
        return self.message

    def GameAlreadyStarted(self):
        self.message = "The game has already started"
        return self.message

    def NoPlayers(self):
        self.message = "There are no players present"
        return self.message

    def CannotSendWordTimeLimitReached(self):
        self.message = "Time is up!"
        return self.message

    def getMessage(self):
        return self.message

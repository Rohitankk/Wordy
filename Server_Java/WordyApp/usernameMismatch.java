package Server_Java.WordyApp;


/**
* WordyApp/usernameMismatch.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Wordy.idl
* Wednesday, May 17, 2023 4:04:53 PM SGT
*/

public final class usernameMismatch extends org.omg.CORBA.UserException
{

  public usernameMismatch ()
  {
    super(usernameMismatchHelper.id());
  } // ctor


  public usernameMismatch (String $reason)
  {
    super(usernameMismatchHelper.id() + "  " + $reason);
  } // ctor

} // class usernameMismatch

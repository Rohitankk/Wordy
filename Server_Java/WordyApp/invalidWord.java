package Server_Java.WordyApp;


/**
* WordyApp/invalidWord.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Wordy.idl
* Wednesday, May 17, 2023 4:04:53 PM SGT
*/

public final class invalidWord extends org.omg.CORBA.UserException
{

  public invalidWord ()
  {
    super(invalidWordHelper.id());
  } // ctor


  public invalidWord (String $reason)
  {
    super(invalidWordHelper.id() + "  " + $reason);
  } // ctor

} // class invalidWord

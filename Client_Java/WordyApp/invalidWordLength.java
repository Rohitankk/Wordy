package Client_Java.WordyApp;


/**
* WordyApp/invalidWordLength.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Wordy.idl
* Wednesday, May 17, 2023 4:05:19 PM SGT
*/

public final class invalidWordLength extends org.omg.CORBA.UserException
{

  public invalidWordLength ()
  {
    super(invalidWordLengthHelper.id());
  } // ctor


  public invalidWordLength (String $reason)
  {
    super(invalidWordLengthHelper.id() + "  " + $reason);
  } // ctor

} // class invalidWordLength

package Client_Java.WordyApp;

/**
* WordyApp/WordyHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Wordy.idl
* Wednesday, May 17, 2023 4:05:19 PM SGT
*/

public final class WordyHolder implements org.omg.CORBA.portable.Streamable
{
  public Wordy value = null;

  public WordyHolder ()
  {
  }

  public WordyHolder (Wordy initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyHelper.type ();
  }

}

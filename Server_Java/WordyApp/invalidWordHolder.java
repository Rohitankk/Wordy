package Server_Java.WordyApp;

/**
* WordyApp/invalidWordHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Wordy.idl
* Wednesday, May 17, 2023 4:04:53 PM SGT
*/

public final class invalidWordHolder implements org.omg.CORBA.portable.Streamable
{
  public invalidWord value = null;

  public invalidWordHolder ()
  {
  }

  public invalidWordHolder (invalidWord initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = invalidWordHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    invalidWordHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return invalidWordHelper.type ();
  }

}

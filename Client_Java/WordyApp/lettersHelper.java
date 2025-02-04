package Client_Java.WordyApp;


/**
* WordyApp/lettersHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Wordy.idl
* Wednesday, May 17, 2023 4:05:19 PM SGT
*/

abstract public class lettersHelper
{
  private static String  _id = "IDL:WordyApp/letters:1.0";

  public static void insert (org.omg.CORBA.Any a, String[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static String[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_string_tc (0);
      __typeCode = org.omg.CORBA.ORB.init ().create_array_tc (17, __typeCode );
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (lettersHelper.id (), "letters", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static String[] read (org.omg.CORBA.portable.InputStream istream)
  {
    String value[] = null;
    value = new String[17];
    for (int _o0 = 0;_o0 < (17); ++_o0)
    {
      value[_o0] = istream.read_string ();
    }
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, String[] value)
  {
    if (value.length != (17))
      throw new org.omg.CORBA.MARSHAL (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    for (int _i0 = 0;_i0 < (17); ++_i0)
    {
      ostream.write_string (value[_i0]);
    }
  }

}

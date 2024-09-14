package Client_Java.WordyApp;


/**
* WordyApp/playerStatsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Wordy.idl
* Monday, May 8, 2023 11:44:10 AM SGT
*/

abstract public class playerStatsHelper
{
  private static String  _id = "IDL:WordyApp/playerStats:1.0";

  public static void insert (org.omg.CORBA.Any a, String[][] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static String[][] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_string_tc (0);
      __typeCode = org.omg.CORBA.ORB.init ().create_array_tc (5, __typeCode );
      __typeCode = org.omg.CORBA.ORB.init ().create_array_tc (2, __typeCode );
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (playerStatsHelper.id (), "playerStats", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static String[][] read (org.omg.CORBA.portable.InputStream istream)
  {
    String value[][] = null;
    value = new String[5][];
    for (int _o0 = 0;_o0 < (5); ++_o0)
    {
      value[_o0] = new String[2];
      for (int _o1 = 0;_o1 < (2); ++_o1)
      {
        value[_o0][_o1] = istream.read_string ();
      }
    }
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, String[][] value)
  {
    if (value.length != (5))
      throw new org.omg.CORBA.MARSHAL (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    for (int _i0 = 0;_i0 < (5); ++_i0)
    {
      if (value[_i0].length != (2))
        throw new org.omg.CORBA.MARSHAL (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
      for (int _i1 = 0;_i1 < (2); ++_i1)
      {
        ostream.write_string (value[_i0][_i1]);
      }
    }
  }

}

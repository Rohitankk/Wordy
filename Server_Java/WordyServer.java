package Server_Java;

import Server_Java.WordyApp.*;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class WordyServer {
    public void initializeServer(String[] args){
        try{
            ORB orb = ORB.init(args, null);
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            WordyImpl wordyImpl = new WordyImpl();

            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(wordyImpl);
            Wordy href = WordyHelper.narrow(ref);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            System.out.println("Server reference: " + orb.object_to_string(ref));

            String name = "Wordy";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("Server running...");

            orb.run();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Server exiting...");
    }

    public static void main(String[] args) {
        WordyServer server = new WordyServer();
        server.initializeServer(args);
    }
}


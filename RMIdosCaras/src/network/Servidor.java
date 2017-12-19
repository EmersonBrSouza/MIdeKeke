package network;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Servidor {

	public Servidor(String urlLocal){
		try {
			Naming.bind(urlLocal, new ImplAPI());
		} catch (MalformedURLException | RemoteException | AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

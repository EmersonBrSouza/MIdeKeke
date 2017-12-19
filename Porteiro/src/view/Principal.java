package view;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import network.PorteiroImpl;

public class Principal {

	public static void main(String[] args){
		try {
			
			String ip = InetAddress.getLocalHost().getHostAddress();
			String url = String.format("rmi://%s:%d/%s", ip,1099,"porteiro");
			System.out.println("Rodando de kéké em "+url);
			Naming.rebind(url, new PorteiroImpl());
		} catch (UnknownHostException | MalformedURLException | RemoteException e) {
			e.printStackTrace();
		}
	}
}

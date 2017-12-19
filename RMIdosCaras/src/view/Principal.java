package view;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import controller.ClientController;
import controller.ServerController;
import network.Servidor;

public class Principal {

	public static void main(String[] args) {
		
		try {
			String ip = JOptionPane.showInputDialog("Insira o ip do porteiro");
			String urlPorteiro = String.format("rmi://%s:%d/porteiro", ip,1099);
			
			int myId = (int)(Math.random()*100)+1;

			String ipLocal = InetAddress.getLocalHost().getHostAddress();
			String urlLocal = String.format("rmi://%s:%d/%s", ipLocal,1099,myId);
			
			System.out.println("De quebrada em "+ urlLocal);
			
			ClientController.getInstance().setLocalURL(urlLocal);
			ClientController.getInstance().setURLPorteiro(urlPorteiro);
			
			ServerController.getInstance().setUrlPorteiro(urlPorteiro);
			ServerController.getInstance().setLocalUrl(urlLocal);
			
			new View();
			new Servidor(urlLocal);
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}

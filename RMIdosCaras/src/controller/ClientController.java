package controller;

import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import network.API;
import network.PorteiroAPI;

public class ClientController {

	private static ClientController controller;
	private String localURL;
	private String URLPorteiro;
	private ClientController(){}
	
	public static ClientController getInstance(){
		if(controller == null){
			controller = new ClientController();
		}
		return controller;
	}
	
	public void setURLPorteiro(String URLPorteiro){
		this.URLPorteiro = URLPorteiro;
	}
	public void setLocalURL(String localURL){
		this.localURL = localURL;
	}
	
	public void adicionar(File file){
		try {
			API api = (API)Naming.lookup(localURL);
			api.guardar(file);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public void buscar(String filename){
		try {
			PorteiroAPI porteiro = (PorteiroAPI)Naming.lookup(URLPorteiro);			
			API servidorRemoto = (API)Naming.lookup(porteiro.buscarHost(filename));
			byte[] arquivoRecebido = servidorRemoto.download(filename);
			
			if(arquivoRecebido.length > 0){
				System.out.println("Arquivo Salvo lá no outro server");
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public void remover(String filename){
		try {
			PorteiroAPI porteiro = (PorteiroAPI)Naming.lookup(URLPorteiro);			
			API servidorRemoto = (API)Naming.lookup(porteiro.buscarHost(filename));
			servidorRemoto.remover(filename);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
}

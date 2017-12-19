package controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;

import network.PorteiroAPI;

public class ServerController {

	private HashMap<String,String> arquivos = new HashMap<String,String>();
	private String localURL;
	private String urlPorteiro;
	private static ServerController controller;
	
	private ServerController(){}
	
	public static ServerController getInstance(){
		if(controller == null){
			controller = new ServerController();
		}
		return controller;
	}
	
	public void setLocalUrl(String localURL){
		this.localURL = localURL;
	}
	
	public void setUrlPorteiro(String urlPorteiro){
		this.urlPorteiro = urlPorteiro;
	}
	
	public void mapearArquivo(String filename, String filepath){
		arquivos.put(filename, filepath);
		try {
			PorteiroAPI porteiro = (PorteiroAPI)Naming.lookup(urlPorteiro);
			porteiro.guardarHost(filename,localURL);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public File buscar(String filename){
		return new File(arquivos.get(filename));
	}
	
	public byte[] converterEmBytes(File file){
		try {
			return Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			return null;
		}		
	}
	
	public void remover(String filename){
		arquivos.remove(filename);
		try {
			PorteiroAPI porteiro = (PorteiroAPI)Naming.lookup(urlPorteiro);
			porteiro.removerHost(filename);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}

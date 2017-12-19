package network;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PorteiroAPI extends Remote{

	public void guardarHost(String filename, String url) throws RemoteException;
	public String buscarHost(String filename) throws RemoteException;
	public void removerHost(String filename) throws RemoteException;
}

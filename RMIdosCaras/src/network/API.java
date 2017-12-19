package network;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface API extends Remote{

	public void guardar(File file) throws RemoteException;
	public byte[] download(String filename) throws RemoteException;
	public void remover(String filename) throws RemoteException;
	
}

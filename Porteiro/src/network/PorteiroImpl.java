package network;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class PorteiroImpl extends UnicastRemoteObject implements PorteiroAPI{

	private HashMap<String,String> hosts = new HashMap<String,String>();
	private static final long serialVersionUID = 1L;
	
	public PorteiroImpl() throws RemoteException {
		super();
	}

	@Override
	public void guardarHost(String filename, String url) throws RemoteException {
		hosts.put(filename, url);
	}

	@Override
	public String buscarHost(String filename) throws RemoteException {
		return hosts.get(filename);
	}

	@Override
	public void removerHost(String filename) throws RemoteException {
		hosts.remove(filename);
	}

}

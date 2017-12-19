package network;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controller.ServerController;

public class ImplAPI extends UnicastRemoteObject implements API{
	
	private static final long serialVersionUID = 1L;
	private ServerController controller = ServerController.getInstance();
	public ImplAPI() throws RemoteException {
		super();
	}

	
	@Override
	public void guardar(File file) throws RemoteException {
		controller.mapearArquivo(file.getName(), file.getAbsolutePath());
	}

	@Override
	public byte[] download(String filename) throws RemoteException {
		return controller.converterEmBytes(controller.buscar(filename));
	}

	@Override
	public void remover(String filename) throws RemoteException {
		controller.remover(filename);
	}

}

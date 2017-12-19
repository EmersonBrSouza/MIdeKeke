package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ClientController;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField remover;
	private JTextField buscar;
	
	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnAdicionarArquivo = new JButton("Adicionar Arquivo");
		btnAdicionarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int resposta = chooser.showOpenDialog(null);
				if(resposta == JFileChooser.APPROVE_OPTION){
					File file = chooser.getSelectedFile();
					ClientController.getInstance().adicionar(file);
				}
			}
		});
		btnAdicionarArquivo.setBounds(135, 51, 158, 23);
		contentPane.add(btnAdicionarArquivo);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientController.getInstance().remover(remover.getText());
			}
		});
		btnRemover.setBounds(292, 187, 89, 23);
		contentPane.add(btnRemover);
		
		remover = new JTextField();
		remover.setBounds(135, 188, 127, 20);
		contentPane.add(remover);
		remover.setColumns(10);
		
		buscar = new JTextField();
		buscar.setBounds(135, 119, 127, 20);
		contentPane.add(buscar);
		buscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientController.getInstance().buscar(buscar.getText());
			}
		});
		btnBuscar.setBounds(292, 118, 89, 23);
		contentPane.add(btnBuscar);
		setVisible(true);
		
	}
}

package uade.ioo.vista.formularios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import uade.ioo.modelo.AdministradorPagos;

public class JFormularioPrincipal extends JFormularioBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JFormularioPrincipal(AdministradorPagos modelo){
		super(modelo);
		this.setTitle("Administrador de Pagos");
		this.setSize(700, 200);
		this.setLocation(10, 10);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu inicio = new JMenu("Inicio");
			
			JMenuItem salir = new JMenuItem("Salir");
			salir.addActionListener(new exitApp());
		
		JMenu items = new JMenu("Formularios");
		
			JMenuItem registrar = new JMenuItem("Registrar cheque");
			registrar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					JFrame frmRegistro = new JFormularioRegistro(getModelo());
					frmRegistro.setVisible(true);
				}
			});
			
			JMenuItem avencer = new JMenuItem("Depositar cheques a vencer");
			avencer.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					JFrame frmAvencer = new JFormularioAVencer(getModelo());
					frmAvencer.setVisible(true);
				}
			});
			
			JMenuItem servicios = new JMenuItem("Pagar servicios");
			servicios.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					JFrame frmPagoServicios = new JFormularioPagosServicios(getModelo());
					frmPagoServicios.setVisible(true);
				}
			});
			
		JMenu ayuda = new JMenu("Ayuda");
		
			JMenuItem acercade = new JMenuItem("Acerca de IOO.TPP");
			acercade.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					JFrame frmAcercaDe= new JFormularioAcercaDe();
					frmAcercaDe.setVisible(true);
				}
			});
			
		
		menuBar.add(inicio);
			inicio.addSeparator();
			inicio.add(salir);
		
		menuBar.add(items);
			items.add(registrar);
			items.add(avencer);
			items.add(servicios);
			
		menuBar.add(ayuda);
			ayuda.add(acercade);
		
	}
	
	static class exitApp implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	@Override
	public void refresh() {
		
	}	
}

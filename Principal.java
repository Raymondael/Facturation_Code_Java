package les_Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JInternalFrame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXStatusBar;
import org.jdesktop.swingx.JXTaskPane;
import org.jdesktop.swingx.JXHyperlink;

public class Principal extends JFrame {

	private JPanel contentPane;
	protected JXTaskPane taskPanAdmin, taskPanFacturation;
	protected JMenu mnEdition;
	

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 Principal fraPrincipal = new Principal();
					 Dimension dmG = Toolkit.getDefaultToolkit().getScreenSize();
					    int large =  fraPrincipal.getWidth();
						int haut = fraPrincipal.getHeight();
						int X = (dmG.width - large )/2;
						int Y = (dmG.height - haut)/2;
						fraPrincipal.setLocation(X, Y);
						fraPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		//});
	//}

	/**
	 * Create the frame.
	 */
	public Principal() {
		
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setBackground(new Color(233, 150, 122));
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 1020, 731);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(143, 188, 143));
		setJMenuBar(menuBar);
		
		JMenu mnFicher = new JMenu("Ficher");
		menuBar.add(mnFicher);
		
		JMenuItem mntmOuvrir = new JMenuItem("Ouvrir");
		mnFicher.add(mntmOuvrir);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFicher.add(mntmQuitter);
		
		mnEdition = new JMenu("Edition");
		menuBar.add(mnEdition);
		
		JMenuItem mntmArticle = new JMenuItem("Article");
		mntmArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 Articles fraArticle = new Articles();
				 Dimension dmG = Toolkit.getDefaultToolkit().getScreenSize();
				    int large =  fraArticle.getWidth();
					int haut = fraArticle.getHeight();
					int X = (dmG.width - large )/2;
					int Y = (dmG.height - haut)/2;
					fraArticle.setLocation(X, Y);
				    fraArticle.setVisible(true);	
			}
		});
		mntmArticle.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
		});
		mnEdition.add(mntmArticle);
		
		JMenuItem mntmClient = new JMenuItem("Client");
		mntmClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clients fraClient = new Clients();
				Dimension dmG = Toolkit.getDefaultToolkit().getScreenSize();
				    int large =  fraClient.getWidth();
					int haut = fraClient.getHeight();
					int X = (dmG.width - large )/2;
					int Y = (dmG.height - haut)/2;
					fraClient.setLocation(X, Y);
				    fraClient.setVisible(true);
			}
		});
		mnEdition.add(mntmClient);
		
		JMenuItem mntmDevis = new JMenuItem("Devis");
		mntmDevis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Devis fraDevis = new Devis();
				Dimension dmG = Toolkit.getDefaultToolkit().getScreenSize();
			    int large =  fraDevis.getWidth();
				int haut = fraDevis.getHeight();
				int X = (dmG.width - large )/2;
				int Y = (dmG.height - haut)/2;
				fraDevis.setLocation(X, Y);
				fraDevis.setVisible(true);
			}
		});
		mnEdition.add(mntmDevis);
		
		JMenuItem mntmFacture = new JMenuItem("Facture");
		mntmFacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Facture fraFact = new Facture();
				Dimension dmG = Toolkit.getDefaultToolkit().getScreenSize();
			    int large =  fraFact.getWidth();
				int haut = fraFact.getHeight();
				int X = (dmG.width - large )/2;
				int Y = (dmG.height - haut)/2;
				fraFact.setLocation(X, Y);
				fraFact.setVisible(true);
			}
		});
		mnEdition.add(mntmFacture);
		
		JMenu mnOutils = new JMenu("Outils");
		menuBar.add(mnOutils);
		
		JMenuItem mntmCalculatrice = new JMenuItem("Calculatrice");
		mnOutils.add(mntmCalculatrice);
		
		JMenu mnParamtre = new JMenu("Paramètre");
		menuBar.add(mnParamtre);
		
		JMenuItem mntmInformation = new JMenuItem("Informations");
		mnParamtre.add(mntmInformation);
		
		JMenu mnAide = new JMenu("Aide");
		menuBar.add(mnAide);
		
		JMenuItem mntmApropos = new JMenuItem("Apropos");
		mnAide.add(mntmApropos);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	//----------------------------------------------------------------------------	
		JXTaskPaneContainer taskPaneContainer = new JXTaskPaneContainer();
		taskPaneContainer.setBounds(0, 0, 137, 671);
		contentPane.add(taskPaneContainer, BorderLayout.WEST);
		
		
		taskPanAdmin = new JXTaskPane();
		taskPanAdmin.setExpanded(false);
		taskPanAdmin.setTitle("Administration");
		taskPanAdmin.setBounds(38, 138, 109, 102);
		taskPaneContainer.add(taskPanAdmin);
		
//----------------------------------------------------------------		
		JXHyperlink hprlnkArticle = new JXHyperlink();
		hprlnkArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Articles fraArticle = new Articles();
				Dimension dmU = Toolkit.getDefaultToolkit().getScreenSize();
				int large =  fraArticle.getWidth();
				int haut = fraArticle.getHeight();
				int X = (dmU.width - large )/2;
				int Y = (dmU.height - haut)/2;
				fraArticle.setLocation(X, Y);
				fraArticle.setVisible(true);
			}
		});
		taskPanAdmin.add(hprlnkArticle, BorderLayout.NORTH);
		hprlnkArticle.setText("Articles");
	
//---------------------------------------------------------------------------------		
		JXHyperlink hprlnkClient = new JXHyperlink();
		hprlnkClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Clients fraClients = new Clients();
					Dimension dmU = Toolkit.getDefaultToolkit().getScreenSize();
					int large =  fraClients.getWidth();
					int haut = fraClients.getHeight();
					int X = (dmU.width - large )/2;
					int Y = (dmU.height - haut)/2;
					fraClients.setLocation(X, Y);
					fraClients.setVisible(true);
		}
		});
		hprlnkClient.setText("Clients");
		taskPanAdmin.add(hprlnkClient, BorderLayout.SOUTH);
		
//----------------------------------------------------------------------------		
		
		JXHyperlink hprlnkUtilisateurs = new JXHyperlink();
		hprlnkUtilisateurs.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Utilisateurs fraUtilisateurs = new Utilisateurs();
				Dimension dmU = Toolkit.getDefaultToolkit().getScreenSize();
				int large =  fraUtilisateurs.getWidth();
				int haut = fraUtilisateurs.getHeight();
				int X = (dmU.width - large )/2;
				int Y = (dmU.height - haut)/2;
				fraUtilisateurs.setLocation(X, Y);
				fraUtilisateurs.setVisible(true);
				
			}
		});
		hprlnkUtilisateurs.setText("Utilisateurs");
		taskPanAdmin.add(hprlnkUtilisateurs, BorderLayout.SOUTH);

//-------------------------------------------------------------------------------		
		
		taskPanFacturation = new JXTaskPane();
		taskPanFacturation.setExpanded(false);
		taskPanFacturation.setTitle("Facturation");
		taskPanFacturation.setBounds(20, 72, 31, 46);
		//contentPane.add(taskPanFacturation);
		taskPaneContainer.add(taskPanFacturation);
		
		JXHyperlink hprlnkDevis = new JXHyperlink();
		hprlnkDevis.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				Devis fraDevis = new Devis();
				Dimension dmU = Toolkit.getDefaultToolkit().getScreenSize();
				int large =  fraDevis.getWidth();
				int haut = fraDevis.getHeight();
				int X = (dmU.width - large )/2;
				int Y = (dmU.height - haut)/2;
				fraDevis.setLocation(X, Y);
				fraDevis.setVisible(true);
				
			}
		});
		hprlnkDevis.setText("Devis");
		taskPanFacturation.add(hprlnkDevis, BorderLayout.SOUTH);
		
		JXHyperlink hprlnkFacture = new JXHyperlink();
		hprlnkFacture.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Facture fraFacture = new Facture();
				Dimension dmU = Toolkit.getDefaultToolkit().getScreenSize();
				int large =  fraFacture.getWidth();
				int haut = fraFacture.getHeight();
				int X = (dmU.width - large )/2;
				int Y = (dmU.height - haut)/2;
				fraFacture.setLocation(X, Y);
				fraFacture.setVisible(true);
				
			}
		});
		hprlnkFacture.setText("Facture");
		taskPanFacturation.add(hprlnkFacture, BorderLayout.SOUTH);
	}
}

package les_Fenetres;
 


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donnees.DBConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Clients extends ListeClients {

	private JPanel contentPane;
	private JTextField tfNomClient;
	private JTextField tfTel;
	private JTextField tfFax;
	private JTextField tfEmail;
	private JTextField tfNoteClient;
	private JTextArea txtaAdresse;
	
	String chNomClient , chTelClient, chFaxClient ,chEmail, chNoteClient, chAdresseClient;
	int idCl ;
	
	Connection	conn  = DBConnection.SeConnecter();
	ResultSet rs;
	PreparedStatement pst;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clients frame = new Clients();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		//});
	//}

	/**
	 * Create the frame.
	 */
	public Clients() {
		setTitle("Clients");
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 357, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomDuClient = new JLabel("Nom du client :");
		lblNomDuClient.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomDuClient.setBounds(22, 70, 93, 14);
		contentPane.add(lblNomDuClient);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdresse.setBounds(22, 95, 93, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblTel = new JLabel("Tel :");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setBounds(22, 137, 93, 14);
		contentPane.add(lblTel);
		
		JLabel lblFax = new JLabel("Fax :");
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFax.setBounds(22, 162, 93, 14);
		contentPane.add(lblFax);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(22, 187, 93, 14);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Note Client :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(22, 215, 93, 14);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 267, 298, 2);
		contentPane.add(separator);
		
//---------------------------Ajouter un client -------------------------------------		
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// convertion des chaines
				
				chNomClient =  tfNomClient.getText();
				chAdresseClient = txtaAdresse.getText();
				chTelClient = tfTel.getText();
				chFaxClient = tfFax.getText();
				chEmail =  tfEmail.getText();
				chNoteClient =  tfNoteClient.getText();
				
				try {
					String sql = "Insert into tab_client Values(?,?,?,?,?,?,?)";
					pst = conn.prepareStatement(sql);
					pst.setInt(1, idCl);
					pst.setString(2, chNomClient);
					pst.setString(3, chAdresseClient);
					pst.setString(4, chTelClient);
					pst.setString(5, chFaxClient);
					pst.setString(6, chEmail);
					pst.setString(7, chNoteClient);
					pst.execute();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erreur d'ajout de client");
				}
				
				tfEmail.setText("");
				tfFax.setText("");
				tfNomClient.setText("");
				tfNoteClient.setText("");
				tfTel.setText("");
				txtaAdresse.setText("");
			}
		});
		
		
		btnAjouter.setBounds(32, 280, 89, 23);
		contentPane.add(btnAjouter);
//-------------------------------------------------------------------------------
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFermer.setBounds(176, 280, 89, 23);
		contentPane.add(btnFermer);
		
		tfNomClient = new JTextField();
		tfNomClient.setBounds(127, 70, 183, 20);
		contentPane.add(tfNomClient);
		tfNomClient.setColumns(10);
		
		txtaAdresse = new JTextArea();
		txtaAdresse.setBorder(UIManager.getBorder("TextField.border"));
		txtaAdresse.setBounds(127, 93, 183, 43);
		contentPane.add(txtaAdresse);
//--------------------saisir uniquement des chiffres -----------------------------------------------		
		tfTel = new JTextField();
		
		tfTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char num = arg0.getKeyChar();
				if(!(Character.isDigit(num)) || num == KeyEvent.VK_BACK_SPACE || num == KeyEvent.VK_DELETE){
					getToolkit().beep();
					arg0.consume();
				}
				
			}
		});
		
		tfTel.setBounds(127, 137, 183, 20);
		contentPane.add(tfTel);
		tfTel.setColumns(10);
		
		tfFax = new JTextField();
		tfFax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char num = arg0.getKeyChar();
				if(!(Character.isDigit(num)) || num == KeyEvent.VK_BACK_SPACE || num == KeyEvent.VK_DELETE){
					getToolkit().beep();
					arg0.consume();
				}
				
			}
		});
		
		tfFax.setBounds(127, 162, 183, 20);
		contentPane.add(tfFax);
		tfFax.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(127, 187, 183, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfNoteClient = new JTextField();
		tfNoteClient.setBounds(127, 212, 183, 20);
		contentPane.add(tfNoteClient);
		tfNoteClient.setColumns(10);
		
		JLabel lblAjouterUnClient = new JLabel("Ajouter un Client");
		lblAjouterUnClient.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAjouterUnClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblAjouterUnClient.setBounds(22, 28, 280, 14);
		contentPane.add(lblAjouterUnClient);
	}
	
//------------- Les méthodes ----------------------------------	
	
	 
	
	
}

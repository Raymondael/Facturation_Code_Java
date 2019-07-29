package les_Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import org.jdesktop.swingx.JXDatePicker;

import donnees.DBConnection;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Utilisateurs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNomUitil;
	private JTextField tfPrenomUtil;
	private JTextField tfTelUtil;
	private JTextField tfEmailUtil;
	private JTextField tfLogin;
	private JPasswordField tfPassword;
	private JPasswordField tfPassConfirmer;
	private JComboBox<String> cbCategorie;
	private JXDatePicker dateEnregistree;
	
	String chNomUtil, chPrenomUtil, chTelUtil, chEmailUtil, chLogin, chPassUtil, chPassConfirmer, chCategorieUtil, chDateUtil;
	int idUtil;
	
	SimpleDateFormat df;
	
	Connection	conn  = DBConnection.SeConnecter();
	ResultSet rs;
	PreparedStatement pst;
	
	//Login log = new Login();

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Utilisateurs frame = new Utilisateurs();
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
	public Utilisateurs() {
		setTitle("Utilisateurs");
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 682, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNom.setBounds(31, 34, 60, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrenom.setBounds(31, 59, 60, 14);
		contentPane.add(lblPrenom);
		
		JLabel lblTel = new JLabel("Tel :");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setBounds(31, 84, 60, 14);
		contentPane.add(lblTel);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(31, 109, 60, 14);
		contentPane.add(lblEmail);
		
		JLabel lblDateDenregistrement = new JLabel("Date d'enregistrement :");
		lblDateDenregistrement.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateDenregistrement.setBounds(329, 109, 128, 14);
		contentPane.add(lblDateDenregistrement);
		
		tfNomUitil = new JTextField();
		tfNomUitil.setBounds(101, 31, 200, 20);
		contentPane.add(tfNomUitil);
		tfNomUitil.setColumns(10);
		
		tfPrenomUtil = new JTextField();
		tfPrenomUtil.setBounds(101, 56, 200, 20);
		contentPane.add(tfPrenomUtil);
		tfPrenomUtil.setColumns(10);
		
		tfTelUtil = new JTextField();
		tfTelUtil.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char num = arg0.getKeyChar();
				if(!(Character.isDigit(num)) || num == KeyEvent.VK_BACK_SPACE || num == KeyEvent.VK_DELETE){
					getToolkit().beep();
					arg0.consume();
				}
				
			}
		});
		tfTelUtil.setBounds(101, 81, 200, 20);
		contentPane.add(tfTelUtil);
		tfTelUtil.setColumns(10);
		
		tfEmailUtil = new JTextField();
		tfEmailUtil.setBounds(101, 106, 200, 20);
		contentPane.add(tfEmailUtil);
		tfEmailUtil.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setBounds(329, 34, 128, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPessword = new JLabel("Password :");
		lblPessword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPessword.setBounds(329, 59, 128, 14);
		contentPane.add(lblPessword);
		
		JLabel lblConfirmation = new JLabel("Confirmation :");
		lblConfirmation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmation.setBounds(329, 84, 128, 14);
		contentPane.add(lblConfirmation);
		
		tfLogin = new JTextField();
		tfLogin.setBounds(465, 31, 177, 20);
		contentPane.add(tfLogin);
		tfLogin.setColumns(10);
		
		tfPassword= new JPasswordField();
		tfPassword.setBounds(465, 56, 177, 20);
		contentPane.add(tfPassword);
		
		tfPassConfirmer = new JPasswordField();
		tfPassConfirmer.setBounds(465, 81, 177, 20);
		contentPane.add(tfPassConfirmer);
		
		dateEnregistree = new JXDatePicker();
		dateEnregistree.setFormats("EEEE dd MMMM yyyy");
		dateEnregistree.setBounds(465, 105, 177, 22);
		contentPane.add(dateEnregistree);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 180, 614, 2);
		contentPane.add(separator);
		
//------------------- Ajouter un utilisateur ---------------------------------		
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// convertion des chaines
				df = new SimpleDateFormat("yyyy-MM-dd");
				chNomUtil = tfNomUitil.getText();
				chPrenomUtil = tfPrenomUtil.getText();
				chTelUtil = tfTelUtil.getText();
				chEmailUtil = tfEmailUtil.getText();
				chCategorieUtil = cbCategorie.getSelectedItem().toString();
				chLogin = tfLogin.getText();
				chPassUtil = tfPassword.getText();
				chPassConfirmer = tfPassConfirmer.getText();
				chDateUtil = df.format(dateEnregistree.getDate());
				
				
//------------------Ajouter un utilisateur -------------------				
			if(tfPassword.getText().equals(chPassConfirmer)) {
				try {

					String sql = "Insert into tab_utilisateur Values(?,?,?,?,?,?,?,?,?,?)";
					pst = conn.prepareStatement(sql);
					pst.setInt(1, idUtil);
					pst.setString(2, chNomUtil);
					pst.setString(3, chPrenomUtil);
					pst.setString(4, chTelUtil);
					pst.setString(5, chEmailUtil);
					pst.setString(6, chCategorieUtil);
					pst.setString(7, chLogin);
					pst.setString(8, chPassUtil);
					pst.setString(9, chPassConfirmer);
					pst.setString(10, chDateUtil);
					pst.execute();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erreur d'ajout d'utilisateur");
				}
				
				tfNomUitil.setText("");
				tfPrenomUtil.setText("");
				tfEmailUtil.setText("");
				tfLogin.setText("");
				tfPassword.setText("");
				tfPassConfirmer.setText("");
				tfTelUtil.setText("");
				
			}
				else {
					JOptionPane.showMessageDialog(null, "Les mots de passe ne sont pas conforme");
				}
				
			}
		});
		btnAjouter.setBounds(31, 211, 150, 38);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(191, 211, 146, 38);
		contentPane.add(btnModifier);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		btnFermer.setBounds(485, 211, 157, 38);
		contentPane.add(btnFermer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(347, 211, 128, 38);
		contentPane.add(btnSupprimer);
		
		JLabel lblCategorie = new JLabel("Categorie :");
		lblCategorie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategorie.setBounds(10, 134, 81, 14);
		contentPane.add(lblCategorie);
		
		
		cbCategorie = new JComboBox<String>();
	    //cbCategorieU.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cbCategorie.setBounds(101, 131, 200, 20);
		contentPane.add(cbCategorie);
		RemplirCbCategorieU();
		
	}
	
	
	 public void RemplirCbCategorieU(){
			try{
				String sql = "SELECT * FROM tab_usercategorie order by categorie";
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				
				while (rs.next()) {
					String CATEGORIEU = rs.getString("categorie");
					cbCategorie.addItem(CATEGORIEU);
				}
			}catch(Exception e){
			}
}
}

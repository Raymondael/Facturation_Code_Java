package les_Fenetres;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donnees.DBConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tflogin;
	private JPasswordField tfpass;
	private JComboBox<String> cbCategorie;
	
	
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
					Login framLogin = new Login();
					framLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		//});
	//}

	/**
	 * Create the frame.
	 */
	public Login() 
	
			{try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 424, 263);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setBounds(23, 51, 110, 14);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(23, 104, 110, 14);
		contentPane.add(lblPassword);
		
		tflogin = new JTextField();
		tflogin.setBounds(149, 51, 204, 20);
		contentPane.add(tflogin);
		tflogin.setColumns(10);
		
		tfpass = new JPasswordField();
		tfpass.setBounds(150, 104, 203, 20);
		contentPane.add(tfpass);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
// ---- si l'utilisateur est un administrateur -------------------------------------------------------
				
				if(cbCategorie.getSelectedItem().equals("Administrateur")) {
					
				String sql ="Select * From tab_utilisateur Where login_utilisateur = ? AND categorie_utilisateur = ? AND password_utilisateur = ?";
				try {
					pst = conn.prepareStatement(sql);
					pst.setString(1, tflogin.getText());
					pst.setString(2, cbCategorie.getSelectedItem().toString());
					pst.setString(3, tfpass.getText());
					rs =pst.executeQuery();
					if(rs.next()){
						//JOptionPane.showMessageDialog(null, "Bienvenue");
						 Principal fraPrincipal = new Principal();
						 Dimension dmG = Toolkit.getDefaultToolkit().getScreenSize();
						    int large =  fraPrincipal.getWidth();
							int haut = fraPrincipal.getHeight();
							int X = (dmG.width - large )/2;
							int Y = (dmG.height - haut)/2;
							fraPrincipal.setLocation(X, Y);
							fraPrincipal.setVisible(true);
						
					}
					else{
						JOptionPane.showMessageDialog(null, "Vous n'êtes pas autorisés");
						tflogin.setText("");
						tfpass.setText("");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
			  }
				} //------------- fin if----------------------------

//--------------------------------- s'il n'est pas administrateur --------------------------------				
				else if(cbCategorie.getSelectedItem().equals("Sécrétaire") || cbCategorie.getSelectedItem().equals("Vendeur")) {
					
					
					String sql ="Select * From tab_utilisateur Where login_utilisateur = ? AND categorie_utilisateur = ? AND password_utilisateur = ?";
					try {
						pst = conn.prepareStatement(sql);
						pst.setString(1, tflogin.getText());
						pst.setString(2, cbCategorie.getSelectedItem().toString());
						pst.setString(3, tfpass.getText());
						rs =pst.executeQuery();
						if(rs.next()){
						
							 Principal fraPrincipal = new Principal();
							 Dimension dmG = Toolkit.getDefaultToolkit().getScreenSize();
							 
							// on rend invisible-------------------------
							    fraPrincipal.taskPanAdmin.setVisible(false); 
							    fraPrincipal.mnEdition.setVisible(false);
							//----------------------------------------------------
							    
							    int large =  fraPrincipal.getWidth();
								int haut = fraPrincipal.getHeight();
								int X = (dmG.width - large )/2;
								int Y = (dmG.height - haut)/2;
								fraPrincipal.setLocation(X, Y);
								fraPrincipal.setVisible(true);
							
						}
						else{
							JOptionPane.showMessageDialog(null, "Vous n'êtes pas autorisés");
							tflogin.setText("");
							tfpass.setText("");
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
				  }
					
				}
			}
		});
		btnValider.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnValider.setBounds(51, 155, 141, 41);
		contentPane.add(btnValider);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAnnuler.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAnnuler.setBounds(202, 155, 153, 41);
		contentPane.add(btnAnnuler);
		
		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setBounds(23, 76, 110, 14);
		contentPane.add(lblStatus);
		
	    cbCategorie = new JComboBox<String>();
	    cbCategorie.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cbCategorie.setBounds(149, 76, 204, 20);
		contentPane.add(cbCategorie);
		RemplirCbCategorie();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 139, 375, 2);
		contentPane.add(separator);
	}
	
//------------------------- remplir cb gategorie --------------------------------------------------------------	
	 public void RemplirCbCategorie(){
			try{
				String sql = "SELECT * FROM tab_usercategorie order by categorie";
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				
				while (rs.next()) {
					String CATEGORIE = rs.getString("categorie");
					cbCategorie.addItem(CATEGORIE);
				}
			}catch(Exception e){
			}
}
}

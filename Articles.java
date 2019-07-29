package les_Fenetres;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import donnees.DBConnection;

public class Articles extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfDescription;
	private JTextField tfPrix;
	private JTextField tfCodeArticle;
	private JTextField tfTaux, tfStock;
	
	Connection	conn  = DBConnection.SeConnecter();
	ResultSet rs;
	PreparedStatement pst;
	
	String chCodeArticle, chDescription, chPrix, chEnStock, chTauxTva; 
	int idArti;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Articles frame = new Articles();
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
	public Articles() {
		setTitle("Articles");
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 424, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodeArticle = new JLabel("Code Article :");
		lblCodeArticle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodeArticle.setBounds(36, 41, 75, 14);
		contentPane.add(lblCodeArticle);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(36, 72, 75, 14);
		contentPane.add(lblDescription);
		
		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrix.setBounds(36, 100, 75, 14);
		contentPane.add(lblPrix);
		
		JLabel lblEnStock = new JLabel("En stock :");
		lblEnStock.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnStock.setBounds(36, 125, 75, 14);
		contentPane.add(lblEnStock);
		
		JLabel lblTauxTva = new JLabel("Taux TVA :");
		lblTauxTva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTauxTva.setBounds(36, 153, 75, 14);
		contentPane.add(lblTauxTva);
		
		tfDescription = new JTextField();
		tfDescription.setBounds(112, 66, 225, 23);
		contentPane.add(tfDescription);
		tfDescription.setColumns(10);
		
		tfPrix = new JTextField();
		tfPrix.setBounds(112, 97, 157, 20);
		contentPane.add(tfPrix);
		tfPrix.setColumns(10);
		
		JButton btnTva = new JButton("......");
		btnTva.setBounds(235, 149, 34, 23);
		contentPane.add(btnTva);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(36, 207, 334, 2);
		contentPane.add(separator);
		
		
// ------------------- Ajouter un article ----------------------------------		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Convertion des chaines
				
				chCodeArticle = tfCodeArticle.getText();
				chDescription = tfDescription.getText();
				chPrix =  tfPrix.getText();
				chEnStock = tfStock.getText();
				chTauxTva = tfTaux.getText();
				
				try {
					
						String sql = "Insert into tab_article Values(?,?,?,?,?,?)";
						pst = conn.prepareStatement(sql);
						pst.setInt(1, idArti);
						pst.setString(2, chCodeArticle);
						pst.setString(3, chDescription);
						pst.setString(4, chPrix);
						pst.setString(5, chEnStock);
						pst.setString(6,chTauxTva);
						pst.execute();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erreur d'ajout d'article");
			 }
				
				tfCodeArticle.setText("");
				tfDescription.setText("");
				tfPrix.setText("");
				tfTaux.setText("");
				tfStock.setText("");
			}
		});
		btnAjouter.setBounds(52, 220, 89, 23);
		contentPane.add(btnAjouter);

//-----------------------------------------------------------------
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFermer.setBounds(248, 220, 89, 23);
		contentPane.add(btnFermer);
		
		tfStock = new JTextField();
		tfStock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char num = arg0.getKeyChar();
				if(!(Character.isDigit(num)) || num == KeyEvent.VK_BACK_SPACE || num == KeyEvent.VK_DELETE){
					getToolkit().beep();
					arg0.consume();
				}
				
			}
		});
		tfStock.setBounds(112, 125, 86, 20);
		contentPane.add(tfStock);
		
		tfTaux = new JTextField();
		tfTaux.setBounds(112, 150, 113, 20);
		contentPane.add(tfTaux);
		
		tfCodeArticle = new JTextField();
		tfCodeArticle.setBounds(112, 38, 86, 20);
		contentPane.add(tfCodeArticle);
		tfCodeArticle.setColumns(10);
	}
}

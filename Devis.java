package les_Fenetres;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXDatePicker;

import donnees.DBConnection;

public class Devis extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNumDevis;
	private JTextField tfLigneDeBasDevis;
	private JTextField tfTelDevis;
	private JTextField tfFaxDevis;
	private JTextField tfEmailDevis;
	private JTable tableDevis;
	private JXDatePicker dateDevis;
	private JComboBox<String> cbAjoutArtcleDevis, cbChoixClient ;
	
	String chTelDevis, chFaxDevis, chLigneBasDevis, chNumDevis, chChoixClientDevis, chDateDevis;
	String chDesignation, chQuantite, chPrix, chTotal;
	String chMontantTTC, chMontantHT, chMontantTVA;
	
	SimpleDateFormat df;
	double prixU, prixT, produit, quant, tnet, montTTC,monHT, montantTotal, remis, montantTotalFinal ;
	
	Connection	conn  = DBConnection.SeConnecter();
	ResultSet rs;
	PreparedStatement pst;
	
	int idDevis, idLigneDevis, quantite, chIdClient;
	
	private JTextField tfQuantite;
	private JTextField tfPrix;
	private JTextField tfTotal;
	private JTextField tfIdClient;
	private JTextField tfMontantTVA;
	private JTextField tfMontantHT;
	private JTextField tfMontantTTC;
	private JTextField tfMontantNet;
	private JComboBox<String> cbClientDevis;
	DefaultTableModel dmt;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
	//	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Devis frame = new Devis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		//});
//	}

	/**
	 * Create the frame.
	 */
	public Devis() {
		setTitle("Devis");
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 780, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 224, 208));
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Devis", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 45, 603, 184);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNDevis = new JLabel("N Devis :");
		lblNDevis.setBounds(20, 20, 74, 14);
		panel_2.add(lblNDevis);
		lblNDevis.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfNumDevis = new JTextField();
		tfNumDevis.setBounds(104, 17, 108, 20);
		panel_2.add(tfNumDevis);
		tfNumDevis.setText("DEV"+NumAutoDevis());
		
		JLabel lblCleint = new JLabel("Client/Entrepr :");
		lblCleint.setBounds(6, 45, 88, 14);
		panel_2.add(lblCleint);
		lblCleint.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(20, 72, 74, 14);
		panel_2.add(lblAdresse);
		lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblLigneDeBas = new JLabel("ligne de bas :");
		lblLigneDeBas.setBounds(20, 109, 74, 14);
		panel_2.add(lblLigneDeBas);
		lblLigneDeBas.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfLigneDeBasDevis = new JTextField();
		tfLigneDeBasDevis.setBounds(104, 106, 215, 20);
		panel_2.add(tfLigneDeBasDevis);
		tfLigneDeBasDevis.setColumns(10);
		
		JTextArea txtAdresseDevis = new JTextArea();
		txtAdresseDevis.setBounds(104, 66, 215, 37);
		panel_2.add(txtAdresseDevis);
		txtAdresseDevis.setBorder(UIManager.getBorder("TextField.border"));
		
		JLabel lblNotes = new JLabel("Notes :");
		lblNotes.setBounds(20, 143, 74, 14);
		panel_2.add(lblNotes);
		lblNotes.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JTextArea txtNoteDevis = new JTextArea();
		txtNoteDevis.setBounds(104, 127, 215, 50);
		panel_2.add(txtNoteDevis);
		txtNoteDevis.setBorder(UIManager.getBorder("TextField.border"));
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(340, 20, 65, 14);
		panel_2.add(lblDate);
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfTelDevis = new JTextField();
		tfTelDevis.setBounds(415, 42, 158, 20);
		panel_2.add(tfTelDevis);
		tfTelDevis.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel :");
		lblTel.setBounds(350, 45, 55, 14);
		panel_2.add(lblTel);
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblFax = new JLabel("Fax :");
		lblFax.setBounds(350, 66, 55, 14);
		panel_2.add(lblFax);
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(350, 91, 55, 14);
		panel_2.add(lblEmail);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfFaxDevis = new JTextField();
		tfFaxDevis.setBounds(415, 66, 158, 20);
		panel_2.add(tfFaxDevis);
		tfFaxDevis.setColumns(10);
		
		tfEmailDevis = new JTextField();
		tfEmailDevis.setBounds(415, 86, 158, 20);
		panel_2.add(tfEmailDevis);
		tfEmailDevis.setColumns(10);
		
		JCheckBox chckbxImprimerDevis = new JCheckBox("Imprimé");
		chckbxImprimerDevis.setBounds(425, 115, 74, 23);
		panel_2.add(chckbxImprimerDevis);
		
		JCheckBox chckbxFacturerDevis = new JCheckBox("Facturé");
		chckbxFacturerDevis.setBounds(498, 115, 74, 23);
		panel_2.add(chckbxFacturerDevis);
		chckbxFacturerDevis.setSelected(true);
		
		dateDevis = new JXDatePicker();
		dateDevis.setBounds(415, 17, 158, 22);
		panel_2.add(dateDevis);
		
		tfIdClient = new JTextField();
		tfIdClient.setVisible(false);
		tfIdClient.setBounds(222, 17, 86, 20);
		panel_2.add(tfIdClient);
		tfIdClient.setColumns(10);

//--------------------------- selection des clients-----------------------------------------------------
		
		cbClientDevis = new JComboBox<String>();
		cbClientDevis.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				SelectionIdClient();
				try {
					String sql = "SELECT * FROM tab_client WHERE nom = ?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, cbClientDevis.getSelectedItem().toString());
					rs = pst.executeQuery();
					
					if(rs.next()){
						/*
						 * ch = rs.getString("CODE_A"); Tf_CodeA.setText(chCode); chPrenom =
						 * rs.getString("PRENOM"); Tf_pren.setText(chPrenom); chTelT =
						 * rs.getString("TELEPHONE"); Tf_TelT.setText(chTelT); chEnreP =
						 * rs.getString("NOM"); Tf_EnregrP.setText(chEnreP);
						 */
						
						
						
					}
				} catch (SQLException e) {
		
					JOptionPane.showMessageDialog(null, "Cet apprenti  n'exist pas , Voulez vous le cr�er?");
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});
		cbClientDevis.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cbClientDevis.setBounds(104, 42, 215, 20);
		panel_2.add(cbClientDevis);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 343, 510, 241);
		contentPane.add(scrollPane);
		
		tableDevis = new JTable();
		scrollPane.setViewportView(tableDevis);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 595, 744, 2);
		contentPane.add(separator);

//-------------------- Valider une devis ---------------------------------------------------------		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//convertion des chaines pour devis
				df = new SimpleDateFormat("yyyy-MM-dd");
				
				chChoixClientDevis = cbClientDevis.getSelectedItem().toString();
				chNumDevis =  tfNumDevis.getText();
				chTelDevis =  tfTelDevis.getText();
				chFaxDevis = tfFaxDevis.getText();
				chLigneBasDevis = tfLigneDeBasDevis.getText();
				chDateDevis = df.format(dateDevis.getDate());
				chMontantTTC = tfMontantTTC.getText();
				chMontantHT = tfMontantHT.getText();
				chMontantTVA = tfMontantTVA.getText();
				chIdClient = Integer.parseInt(tfIdClient.getText());
				
				//convertion des chaines pour lignedevis
				chQuantite =  tfQuantite.getText();
				chDesignation = cbAjoutArtcleDevis.getSelectedItem().toString();
				chPrix = tfPrix.getText();
				chTotal = tfTotal.getText();
				
// ------------------------------insert tableDevis-----------------------------------
				try {
					String sql = "INSERT INTO tab_devis VALUES(?,?,?,?,?,?)";
					pst = conn.prepareStatement(sql);
					pst.setInt(1, idDevis);
					pst.setString(2, chDateDevis);
					pst.setInt(3, chIdClient);
					pst.setString(4, chMontantHT);
					pst.setString(5, chMontantTVA);
					pst.setString(6, chMontantTTC);
					pst.execute();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				
//---------------------------- insert tableLigneDevis---------------------------------------
				try {
					String sql = "INSERT INTO tab_lignedevis VALUES(?,?,?,?,?,?)";
					pst = conn.prepareStatement(sql);
					pst.setInt(1, idLigneDevis);
					pst.setInt(2, idDevis);
					pst.setString(3, chQuantite);
					pst.setString(4, chDesignation);
					pst.setString(5, chPrix);
					pst.setString(6, chTotal);
					pst.execute();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnValider.setBounds(623, 45, 131, 37);
		contentPane.add(btnValider);

		
//---------------------- Midifier un devis -------------------------------------------
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(623, 88, 131, 42);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(623, 136, 131, 42);
		contentPane.add(btnSupprimer);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFermer.setBounds(567, 547, 187, 37);
		contentPane.add(btnFermer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 205, 170));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "G\u00E9rer les articles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 249, 744, 83);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblA = new JLabel("Sélectionner l'article  :");
		lblA.setBounds(6, 20, 175, 14);
		panel_1.add(lblA);

		
//--------------------------cb Ajouter article -----------------		
		cbAjoutArtcleDevis = new JComboBox<String>();
		cbAjoutArtcleDevis.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {

			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				AffichePrixEtAutres();
				
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {

			}
		});
		cbAjoutArtcleDevis.setBounds(120, 17, 409, 20);
		panel_1.add(cbAjoutArtcleDevis);
		cbAjoutArtcleDevis.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
	
		
//----------------Ajouter un article --------------------------------------		
		JButton btnAjouterArticle = new JButton("Ajouter Article");
		btnAjouterArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				chQuantite =  tfQuantite.getText();
				chChoixClientDevis = cbChoixClient.getSelectedItem().toString().toUpperCase();
				chPrix = tfPrix.getText();
				chTotal =  tfTotal.getText();
				chNumDevis = tfNumDevis.getText();
				
				
 // méthode d'ajout les lignes de commande par la création d'un model de table pour recupérer

				dmt =	 (DefaultTableModel)tableDevis.getModel();
				dmt.addRow(new Object[]{chQuantite,chChoixClientDevis,chPrix,chTotal });
				tfMontantNet.setText(""+SommColo());
				
				AfficheAutreMontant();
			
				try {
					String sql = "INSERT INTO tab_lignedevis VALUES(?,?,?,?,?,?)";
					
					pst = conn.prepareStatement(sql);
					pst.setInt(1, idLigneDevis);
					pst.setInt(2, idDevis);
					pst.setString(3, chQuantite);
					pst.setString(4, chDesignation);
					pst.setString(5, chPrix);
					pst.setString(6, chTotal);
					pst.execute();
					
					
				} catch (SQLException e) {
					//JOptionPane.showMessageDialog(null, e.getMessage());
					//JOptionPane.showMessageDialog(null, " Ajouté la quantité de Produit ");
				
					
					//MiseAJourTab_Detail_Cmd();
				}		
	             
				tfQuantite.setText("");
				tfPrix.setText("");
				tfTotal.setText("");
				}
			
		});
		btnAjouterArticle.setBounds(539, 20, 185, 23);
		panel_1.add(btnAjouterArticle);

		
//--------------------- Supprimer un article -------------------------------
		
		JButton btnSupprimerUneLigne = new JButton("Supprimer une ligne");
		btnSupprimerUneLigne.setBounds(539, 44, 185, 23);
		panel_1.add(btnSupprimerUneLigne);
		
		JLabel lblQuantit = new JLabel("Quantité :");
		lblQuantit.setBounds(46, 48, 64, 14);
		panel_1.add(lblQuantit);
		lblQuantit.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfQuantite = new JTextField();
		tfQuantite.setBounds(120, 45, 46, 20);
		panel_1.add(tfQuantite);
		tfQuantite.setColumns(10);
		
		JLabel lblPrix = new JLabel("Prix :");
		lblPrix.setBounds(171, 48, 46, 14);
		panel_1.add(lblPrix);
		lblPrix.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfPrix = new JTextField();
		tfPrix.setEditable(false);
		tfPrix.setBounds(222, 45, 124, 20);
		panel_1.add(tfPrix);
		tfPrix.setColumns(10);
		
		tfTotal = new JTextField();
		tfTotal.setEditable(false);
		tfTotal.setBounds(392, 45, 137, 20);
		panel_1.add(tfTotal);
		tfTotal.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setBounds(336, 48, 46, 14);
		panel_1.add(lblTotal);
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblFaireUneDevis = new JLabel("Faire une Devis");
		lblFaireUneDevis.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFaireUneDevis.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaireUneDevis.setBounds(10, 11, 589, 14);
		contentPane.add(lblFaireUneDevis);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Montants", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(530, 344, 224, 155);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tfMontantTVA = new JTextField();
		tfMontantTVA.setBounds(96, 112, 109, 20);
		panel.add(tfMontantTVA);
		tfMontantTVA.setColumns(10);
		
		JLabel lblMontantTva = new JLabel("Montant TVA :");
		lblMontantTva.setBounds(10, 118, 85, 14);
		panel.add(lblMontantTva);
		lblMontantTva.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfMontantHT = new JTextField();
		tfMontantHT.setBounds(96, 53, 109, 20);
		panel.add(tfMontantHT);
		tfMontantHT.setColumns(10);
		
		JLabel lblMontantHt = new JLabel("Montant HT :");
		lblMontantHt.setBounds(10, 56, 85, 14);
		panel.add(lblMontantHt);
		lblMontantHt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		tfMontantTTC = new JTextField();
		tfMontantTTC.setBounds(96, 81, 109, 20);
		panel.add(tfMontantTTC);
		tfMontantTTC.setColumns(10);
		
		JLabel lblMontantTtc = new JLabel("Montant TTC :");
		lblMontantTtc.setBounds(10, 87, 85, 14);
		panel.add(lblMontantTtc);
		lblMontantTtc.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblMontantNet = new JLabel("Montant NET :");
		lblMontantNet.setBounds(10, 31, 85, 14);
		panel.add(lblMontantNet);
		
		tfMontantNet = new JTextField();
		tfMontantNet.setBounds(96, 28, 109, 20);
		panel.add(tfMontantNet);
		tfMontantNet.setColumns(10);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setBounds(623, 189, 131, 40);
		contentPane.add(btnImprimer);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(567, 510, 187, 37);
		contentPane.add(btnAnnuler);
		RemplirCbAjouterArticle();
		RemplirCbClientDevis();
		
	}
	
	//------------------------- remplir cb article à ajouter --------------------------------------------------------------	
		 public void RemplirCbAjouterArticle(){
				try{
					String sql = "SELECT * FROM tab_article order by description";
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					
					while (rs.next()) {
						String ARTICLE = rs.getString("description");
						cbAjoutArtcleDevis.addItem(ARTICLE);
					}
				}catch(Exception e){
				}
	}
		 //------------------------- remplir cb client à ajouter --------------------------------------------------------------	
		 public void RemplirCbClientDevis(){
			 try{
				 String sql = "SELECT * FROM tab_client order by nom";
				 pst = conn.prepareStatement(sql);
				 rs = pst.executeQuery();
				 
				 while (rs.next()) {
					 String CLIENT = rs.getString("nom");
					 cbClientDevis.addItem(CLIENT);
				 }
			 }catch(Exception e){
			 }
		 }

		 
//-------------------------- numereo de devis-----------------------------------------		 
		 public int NumAutoDevis(){
				int num = 0;
				
				try {
					String sql ="SELECT max(idtab_devis) FROM tab_devis";
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					
					if(rs.next()){
						num = rs.getInt(1);
						num ++;
				      } 
				} 
					catch (SQLException e) {
					e.printStackTrace();
				}
			
				//Tf_NumComm.setText("CMDE0001"+rs.getRow());
				return 	num;		
				
				
			}
		 
		 
		 
		//--------------------------------------------------------------------------------------------------------------------------------
		   /* ******************************************************************************************************
		     ***calcule de la somme total cette méthode est valable si on travail directement sur le model de table
		   ***********************************************************************************************************/
		
		public void calculSomme(){
			
			double ligneTotal = tableDevis.getRowCount();
			for (int i = 0; i < tableDevis.getRowCount(); i++) {
			
			quantite = Integer.parseInt(tableDevis.getValueAt(i, 1).toString());
			double	som = Double.valueOf(tableDevis.getValueAt(i,3).toString());
				som += som;
				montantTotal += som;
			
				tfTotal.setText(""+montantTotal);
			}
			
				}

//----------------------------------------------------------------------------------------------------------------------------		
		
		public void AffichePrixEtAutres(){
			try {
				

				String sg = (String)cbAjoutArtcleDevis.getSelectedItem();
				String sql ="Select * From tab_article Where designation =?";
				
					pst = conn.prepareStatement(sql);
					pst.setString(1, sg);
					rs = pst.executeQuery();

					if(rs.next()){
						chPrix = rs.getString("prix");
						tfPrix.setText(chPrix);

						// calcul du produit
						 chQuantite = tfQuantite.getText();
					     chPrix = tfPrix.getText();
						 quant = Integer.parseInt(chQuantite);
						 prixU = Double.parseDouble(chPrix);
						 produit = quant * prixU;

						 // affiche le produit
				
				  Double pro = new Double(produit); 
				  chTotal = pro.toString();
				  tfTotal.setText(chTotal);
				 

			   } 
			}
					catch (Exception e) {
			//	JOptionPane.showMessageDialog(null, e.getMessage());
			}
			
		}

		
//------------------------------------------------------------------------------------------------------------------------------		
		public void SelectionIdClient(){
			 try {
				
				 String nom = (String)cbChoixClient.getSelectedItem();
				 String sql = "SELECT * FROM tab_client Where nom = ?";
				 pst = conn.prepareStatement(sql);
				 pst.setString(1, nom);
				 rs = pst.executeQuery();
				 
				if(rs.next()) {
					 chIdClient = Integer.parseInt(rs.getString("idtab_client"));
					  tfIdClient.setText(""+chIdClient);
				}
				 
			 } catch (SQLException e) {
				 
			 }
		 }
		
//----------------------------------------------------------------------------------------------------------------------------------		
		public double SommColo(){	
			double ligTotal = tableDevis.getRowCount();
			double somTotal = 0;
			for (int i = 0; i < ligTotal; i++) {
				
				//somTotal = somTotal + Double.valueOf(Tab_AjoutLigneComde.getValueAt(i, 3).toString()); ou ce qui suit
				somTotal += Double.valueOf(tableDevis.getValueAt(i, 3).toString());
			}
			return somTotal;
		}
		
		
//-----------------------------------------------------------------------------------------------------------------------------------		
		public void AfficheAutreMontant(){
			
			
		
		  // calcul de montant ttc tnet = Double.parseDouble(Tf_TotNet.getText());
		  montTTC = tnet + tnet * 18/100; tfMontantTTC.setText(""+montTTC);
		  
		  
		  // calcul du montant hors taxe monHT =
		 // Double.parseDouble(Tf_TotNet.getText()); monHT = tnet - tnet*18/100;
		 
			
			 // affichage du montant ht
			Double ht = new Double(monHT);
			chMontantHT = ht.toString();
			tfMontantHT.setText(""+monHT);
			
		
		}
		
//----------------------------------------------------------------------------------------------------------------------------------------------		
	/*
	 * public void Remise(){ remis = tnet *
	 * (Double.valueOf(CbRemise.getSelectedItem().toString())/100);
	 * montantTotalFinal = tnet - remis; TfRemise.setText(""+montantTotalFinal); }
	 */
		
		
//-------------------------------- mise à jour de la table commandes-------------------------------------------------------------------------------------
		
		public void MiseAJourTabCmd() {
			
			
			 try {
				  
				 String sql="Select IDCMDE as NUMERO,NOM_CLT as 'NOM CLIENT', DATE_FORMAT(DATE_DE_COMM, '%d/%m/%Y') as 'DATE', TOTALNET as 'TOTAL NET', TOTALHT as 'TOTAL HORS TAXE',  FRAIS_PORT as 'TRANSPORT',TOTALTTC as 'TOTAL TTC', TOTALREMISE  as 'TOTAL REMISE' From tab_commandes order by DATE_DE_COMM";
					pst = conn.prepareStatement(sql);
					rs = pst.executeQuery();
					//tabVisa.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e);
				}
		}
		
	
//------------------------------------------ aperçu avant impression -------------------------------------------------------------
		
		public void ApercuAvantImpression() {
			try {
				String query = "SELECT Cm.NOM_CLT, DATE_FORMAT(Cm.DATE_DE_COMM, '%d/%m/%Y') as 'DATE DE COMMANDE', Cm.TOTALNET, Cm.TOTALHT, Cm.FRAIS_PORT, Cm.TOTALTTC, Cm.TOTALREMISE, Dcm.QUANTITE, Dcm.DESIGNATION, Dcm.PRIXUNI, Dcm.TOTAL FROM  tab_devis Cm, tab_lignedevis Dcm "
						+ "WHERE Cm.IDCMDE = Dcm.IDCMDE AND Cm.NOM_CLT = ?, AND Cm.DATE_DE_COMM = ?";
				pst = conn.prepareStatement(query);
				rs = pst.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}

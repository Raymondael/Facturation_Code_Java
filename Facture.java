package les_Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.UIManager;
import org.jdesktop.swingx.JXDatePicker;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Facture extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField tfNumFacture;
	private JTextField tfEmailFacture;
	private JTextField tfFaxFacture;
	private JTextField tfTelFacture;
	private JTextField tfClientFacture;
	private JTable tableFacture;

	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facture frame = new Facture();
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
	public Facture() {
		setTitle("Factures");
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 647, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 1);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel);
		
		JLabel label = new JLabel("N Devis :");
		label.setBounds(52, 45, 46, 14);
		panel.add(label);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(108, 42, 108, 20);
		panel.add(spinner);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(130, 73, 86, 20);
		panel.add(textField);
		
		JLabel label_1 = new JLabel("Cleint/");
		label_1.setBounds(52, 76, 46, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Adresse :");
		label_2.setBounds(52, 114, 46, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("ligne de bas :");
		label_3.setBounds(52, 139, 46, 14);
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 136, 86, 20);
		panel.add(textField_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(130, 104, 86, 22);
		panel.add(textArea);
		
		JLabel label_4 = new JLabel("Notes ");
		label_4.setBounds(52, 183, 46, 14);
		panel.add(label_4);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(130, 178, 171, 53);
		panel.add(textArea_1);
		
		JLabel label_5 = new JLabel("Date  :");
		label_5.setBounds(379, 42, 46, 14);
		panel.add(label_5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(447, 73, 86, 20);
		panel.add(textField_2);
		
		JLabel label_6 = new JLabel("Tel :");
		label_6.setBounds(389, 76, 46, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Fax :");
		label_7.setBounds(389, 114, 46, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("Email :");
		label_8.setBounds(389, 139, 46, 14);
		panel.add(label_8);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(447, 104, 86, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(447, 136, 86, 20);
		panel.add(textField_4);
		
		JCheckBox checkBox = new JCheckBox("Imprimé");
		checkBox.setBounds(379, 179, 97, 23);
		panel.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Facturé");
		checkBox_1.setSelected(true);
		checkBox_1.setBounds(379, 205, 97, 23);
		panel.add(checkBox_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 302, 553, 95);
		panel.add(scrollPane);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(447, 42, 86, 20);
		panel.add(spinner_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 452, 551, 2);
		panel.add(separator);
		
		JButton button = new JButton("Ajouter ");
		button.setBounds(76, 484, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Modifier");
		button_1.setBounds(175, 484, 89, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Supprimer");
		button_2.setBounds(303, 484, 89, 23);
		panel.add(button_2);
		
		JLabel lblNFact = new JLabel("N Fact :");
		lblNFact.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNFact.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNFact.setBounds(10, 49, 75, 14);
		contentPane.add(lblNFact);
		
		JLabel lblClient = new JLabel("Client :");
		lblClient.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblClient.setHorizontalAlignment(SwingConstants.TRAILING);
		lblClient.setBounds(10, 80, 75, 14);
		contentPane.add(lblClient);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblAdresse.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAdresse.setBounds(10, 105, 75, 14);
		contentPane.add(lblAdresse);
		
		JLabel lblLigneDeBas = new JLabel("Ligne de bas :");
		lblLigneDeBas.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblLigneDeBas.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLigneDeBas.setBounds(10, 153, 75, 14);
		contentPane.add(lblLigneDeBas);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setBounds(321, 49, 78, 14);
		contentPane.add(lblDate);
		
		JLabel lblTel = new JLabel("Tel :");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setBounds(321, 71, 78, 14);
		contentPane.add(lblTel);
		
		JLabel lblFax = new JLabel("Fax :");
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFax.setBounds(321, 99, 78, 14);
		contentPane.add(lblFax);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(321, 120, 78, 14);
		contentPane.add(lblEmail);
		
		tfNumFacture = new JTextField();
		tfNumFacture.setBounds(95, 49, 86, 20);
		contentPane.add(tfNumFacture);
		tfNumFacture.setColumns(10);
		
		tfEmailFacture = new JTextField();
		tfEmailFacture.setBounds(409, 114, 131, 20);
		contentPane.add(tfEmailFacture);
		tfEmailFacture.setColumns(10);
		
		tfFaxFacture = new JTextField();
		tfFaxFacture.setBounds(409, 93, 131, 20);
		contentPane.add(tfFaxFacture);
		tfFaxFacture.setColumns(10);
		
		tfTelFacture = new JTextField();
		tfTelFacture.setBounds(409, 68, 131, 20);
		contentPane.add(tfTelFacture);
		tfTelFacture.setColumns(10);
		
		JTextArea txtAdresseFacture = new JTextArea();
		txtAdresseFacture.setBorder(UIManager.getBorder("TextField.border"));
		txtAdresseFacture.setBounds(95, 103, 187, 34);
		contentPane.add(txtAdresseFacture);
		
		tfClientFacture = new JTextField();
		tfClientFacture.setBounds(95, 80, 187, 20);
		contentPane.add(tfClientFacture);
		tfClientFacture.setColumns(10);
		
		JXDatePicker dateFacture = new JXDatePicker();
		dateFacture.setBounds(409, 42, 131, 22);
		contentPane.add(dateFacture);
		
		JTextArea txtNoteFacture = new JTextArea();
		txtNoteFacture.setBorder(UIManager.getBorder("TextField.border"));
		txtNoteFacture.setBounds(83, 218, 451, 34);
		contentPane.add(txtNoteFacture);
		
		JLabel lblNotes = new JLabel("Notes :");
		lblNotes.setBounds(27, 224, 46, 14);
		contentPane.add(lblNotes);
		
		JCheckBox chckImprimeFacture = new JCheckBox("Imprimée");
		chckImprimeFacture.setBounds(95, 177, 97, 23);
		contentPane.add(chckImprimeFacture);
		
		JCheckBox chckEnvoyeFacture = new JCheckBox("Envoyée");
		chckEnvoyeFacture.setBounds(227, 177, 97, 23);
		contentPane.add(chckEnvoyeFacture);
		
		JCheckBox chckPayeFacture = new JCheckBox("Payée");
		chckPayeFacture.setBounds(371, 177, 97, 23);
		contentPane.add(chckPayeFacture);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 286, 611, 294);
		contentPane.add(scrollPane_1);
		
		tableFacture = new JTable();
		scrollPane_1.setViewportView(tableFacture);
		
		JButton btnAjouter = new JButton("Valider");
		btnAjouter.setBounds(10, 612, 150, 38);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(166, 612, 145, 38);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(321, 612, 132, 38);
		contentPane.add(btnSupprimer);
		
		JButton btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		btnFermer.setBounds(463, 612, 131, 38);
		contentPane.add(btnFermer);
		
		JComboBox cbbasdeLigneFacture = new JComboBox();
		cbbasdeLigneFacture.setModel(new DefaultComboBoxModel(new String[] {"", "Signature du client.", "Délai maximum de X jours pour le paiement. Merci.", "Paiement reçu avec remerciements"}));
		cbbasdeLigneFacture.setBounds(95, 150, 445, 20);
		contentPane.add(cbbasdeLigneFacture);
		
		JLabel lblFaireUneFacture = new JLabel("Faire une Facture");
		lblFaireUneFacture.setHorizontalAlignment(SwingConstants.CENTER);
		lblFaireUneFacture.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFaireUneFacture.setBounds(15, 17, 606, 14);
		contentPane.add(lblFaireUneFacture);
	}
}

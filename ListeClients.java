package les_Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jdesktop.swingx.JXTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import donnees.DBConnection;

public class ListeClients extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JXTable tableClients;

	Connection	conn  = DBConnection.SeConnecter();
	ResultSet rs;
	PreparedStatement pst;
	
	
	/**
	 * Launch the application.
	 */
	//public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeClients frame = new ListeClients();
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
	public ListeClients() {
		setTitle("Liste des Clients");
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 583, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 547, 261);
		contentPane.add(scrollPane);
		
		tableClients = new JXTable();
		scrollPane.setViewportView(tableClients);
		miseAjourTabClients();
		
		JLabel lblListeDesClients = new JLabel("Liste des Clients");
		lblListeDesClients.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListeDesClients.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesClients.setBounds(121, 27, 273, 14);
		contentPane.add(lblListeDesClients);
	}
	
	public void miseAjourTabClients() {
		 
		 try {
				
				String sql="Select idtab_client as 'NUMERO CLIENT',nom as 'NOM CLIENT', "
						+ "adresse  as 'ADRESSE', telephone as 'TELEPHONE', fax as 'FAX', email as 'EMAIL',"
						+ " note_client as 'NOTE CLIENT' From  tab_client order by idtab_client";
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();
				tableClients.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e);
			}
	 }
}

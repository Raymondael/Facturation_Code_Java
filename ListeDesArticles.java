package les_Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import org.jdesktop.swingx.JXTable;

import donnees.DBConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;

public class ListeDesArticles extends JFrame {

	private JPanel contentPane;
	private JXTable tableArticle;
	
	
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
					ListeDesArticles frame = new ListeDesArticles();
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
	public ListeDesArticles() {
		setTitle("Liste des Articles");
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 711, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListeDesArticles = new JLabel("Liste des Articles");
		lblListeDesArticles.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesArticles.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListeDesArticles.setBounds(10, 28, 675, 14);
		contentPane.add(lblListeDesArticles);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 675, 280);
		contentPane.add(scrollPane);
		
		tableArticle = new JXTable();
		scrollPane.setViewportView(tableArticle);
	}
	
	public void miseAjourArticle() {
		try {
			
			String sql="Select idtab_client as 'NUMERO CLIENT',nom as 'NOM CLIENT', "
					+ "adresse  as 'ADRESSE', telephone as 'TELEPHONE', fax as 'FAX', email as 'EMAIL',"
					+ " note_client as 'NOTE CLIENT' From  tab_article order by idtab_article";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			tableArticle.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
}

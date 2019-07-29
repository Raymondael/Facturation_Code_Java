package les_Fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import donnees.DBConnection;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ListeDesUtilisateurs extends JFrame {

	private JPanel contentPane;
	private JTable tableUtilisateur;
	
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
					ListeDesUtilisateurs frame = new ListeDesUtilisateurs();
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
	public ListeDesUtilisateurs() {
		setTitle("Liste des Utilisateurs");
		setDefaultCloseOperation(JFrame.ICONIFIED);
		setBounds(100, 100, 722, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListeDesUtilisateurs = new JLabel("Liste des Utilisateurs");
		lblListeDesUtilisateurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblListeDesUtilisateurs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListeDesUtilisateurs.setBounds(10, 22, 686, 14);
		contentPane.add(lblListeDesUtilisateurs);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 57, 676, 257);
		contentPane.add(scrollPane);
		
		tableUtilisateur = new JTable();
		scrollPane.setViewportView(tableUtilisateur);
	}
}

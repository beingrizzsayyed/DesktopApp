package com.enter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import java.awt.SystemColor;

public class Partyinfo extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partyinfo frame = new Partyinfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Partyinfo() {
		setIconifiable(true);
		setMaximizable(true);
		setTitle("PARTY INFORMATION");
		setResizable(true);
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setBounds(100, 100, 834, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 168, 798, 254);
		contentPane.add(scrollPane);
		
		table = 
				new JTable();
		table.setRowSelectionAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PARTY CODE", "COMPANY NAME", "CONTACT", "ADDRESS"
			}
		));
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFont(new Font("Arial Black", Font.ITALIC, 15));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBackground(Color.WHITE);

		try
		{
			String url="jdbc:mysql://localhost:3306/zenter";
			String username="root";
			String pass="rizz";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection  conn=DriverManager.getConnection(url,username,pass);
			PreparedStatement ps;
			ResultSet rs;
			ps=conn.prepareStatement("select * from party_info");
			rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(10, 11, 798, 103);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnRegisteredPartyInformation = new JTextPane();
		txtpnRegisteredPartyInformation.setForeground(Color.WHITE);
		txtpnRegisteredPartyInformation.setBackground(SystemColor.scrollbar);
		txtpnRegisteredPartyInformation.setEditable(false);
		txtpnRegisteredPartyInformation.setText("REGISTERED PARTY INFORMATION ");
		txtpnRegisteredPartyInformation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtpnRegisteredPartyInformation.setBounds(208, 11, 380, 38);
		panel.add(txtpnRegisteredPartyInformation);
	}
}



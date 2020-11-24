package com.enter;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.a.ResultsetRowReader;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Sellerinfo extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sellerinfo frame = new Sellerinfo();
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
	public Sellerinfo() {
		setMaximizable(true);
		setIconifiable(true);
		setTitle("SELLER INFORMATION");
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
				"SELLER CODE", "NAME", "CONTACT", "ADDRESS"
			}
		));
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFont(new Font("Tahoma", Font.ITALIC, 15));
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
			ps=conn.prepareStatement("select * from seller_info");
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
		
		JTextPane txtpnRegisteredSellerInformation = new JTextPane();
		txtpnRegisteredSellerInformation.setEditable(false);
		txtpnRegisteredSellerInformation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtpnRegisteredSellerInformation.setForeground(Color.WHITE);
		txtpnRegisteredSellerInformation.setBackground(SystemColor.scrollbar);
		txtpnRegisteredSellerInformation.setText("REGISTERED SELLER INFORMATION ");
		txtpnRegisteredSellerInformation.setBounds(211, 11, 386, 31);
		panel.add(txtpnRegisteredSellerInformation);
	}
}

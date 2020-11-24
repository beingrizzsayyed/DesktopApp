package com.enter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Insertparty extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblPartyCode;
	private JLabel scomt;
	private JLabel lblPartyContact;
	private JLabel lblPartyAddress;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextPane txtpnInsertInformationOf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertparty frame = new Insertparty();
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
	public Insertparty() {
		setIconifiable(true);
		setMaximizable(true);
		setTitle("INSERT PARTY");
		setResizable(true);
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setBounds(100, 100, 818, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(10, 11, 783, 83);
		contentPane.add(panel);
		
		txtpnInsertInformationOf = new JTextPane();
		txtpnInsertInformationOf.setForeground(Color.WHITE);
		txtpnInsertInformationOf.setBackground(SystemColor.scrollbar);
		txtpnInsertInformationOf.setText("INSERT INFORMATION OF PARTY");
		txtpnInsertInformationOf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtpnInsertInformationOf.setBounds(211, 11, 358, 31);
		panel.add(txtpnInsertInformationOf);
		
		textField = new JTextField();
		textField.setText("NOTE :-");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.RED);
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField.setEditable(false);
		textField.setBackground(Color.WHITE);
		textField.setBounds(657, 142, 86, 20);
		contentPane.add(textField);
		
		JTextPane txtpnPartyCodeIs = new JTextPane();
		txtpnPartyCodeIs.setText("PARTY CODE IS SET AS IDENTITY OF PARTY.\r\n\r\nPARTY CODE SHOUD BE UNIQUE FOR EACH PARTY.\r\n\r\n");
		txtpnPartyCodeIs.setForeground(Color.WHITE);
		txtpnPartyCodeIs.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnPartyCodeIs.setEditable(false);
		txtpnPartyCodeIs.setBackground(SystemColor.activeCaption);
		txtpnPartyCodeIs.setBounds(612, 202, 181, 136);
		contentPane.add(txtpnPartyCodeIs);
		
		lblPartyCode = new JLabel("Party Code");
		lblPartyCode.setForeground(Color.BLACK);
		lblPartyCode.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblPartyCode.setBounds(10, 142, 80, 22);
		contentPane.add(lblPartyCode);
		
		scomt = new JLabel("Company Name");
		scomt.setForeground(Color.BLACK);
		scomt.setFont(new Font("Tahoma", Font.ITALIC, 15));
		scomt.setBounds(10, 212, 122, 22);
		contentPane.add(scomt);
		
		lblPartyContact = new JLabel("Party Contact");
		lblPartyContact.setForeground(Color.BLACK);
		lblPartyContact.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblPartyContact.setBounds(10, 280, 122, 22);
		contentPane.add(lblPartyContact);
		
		lblPartyAddress = new JLabel("Party Address");
		lblPartyAddress.setForeground(Color.BLACK);
		lblPartyAddress.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblPartyAddress.setBounds(10, 346, 122, 22);
		contentPane.add(lblPartyAddress);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.YELLOW);
		textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(142, 142, 129, 30);
		contentPane.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(142, 212, 369, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(142, 280, 232, 30);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(142, 344, 369, 32);
		contentPane.add(textField_5);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String  Pcode =textField_1.getText();
					String  comp =textField_3.getText();
					String  cont=textField_4.getText();
					String  addr=textField_5.getText();
				String url="jdbc:mysql://localhost:3306/zenter";
				String username="root";
				String pass="rizz";
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection  conn=DriverManager.getConnection(url,username,pass);
				PreparedStatement ps,ps1;
				ResultSet rs;
				ps=conn.prepareStatement("select * from party_info where pcode=?");
				ps.setString(1,Pcode);
				rs=ps.executeQuery();
				if(rs.next()== true)
				{
					JOptionPane.showMessageDialog(btnNewButton, "THE PARTY CODE MUST BE UNIQUE ");
				}
				else
				{
				ps1=conn.prepareStatement("insert into party_info values(?,?,?,?)");
				ps1.setString(1,Pcode);
				ps1.setString(2,comp);
				ps1.setString(3,cont);	
				ps1.setString(4,addr);
				ps1.executeLargeUpdate();
				JOptionPane.showMessageDialog(btnNewButton, "THE PARTY INFORMATION SUCCESSFULLY INSERTED ");
				
				
				textField_1.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				}
				
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(142, 400, 129, 30);
		contentPane.add(btnNewButton);
	}
}

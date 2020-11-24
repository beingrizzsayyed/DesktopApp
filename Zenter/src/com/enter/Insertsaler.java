package com.enter;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;



public class Insertsaler extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtNote;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextPane txtpnInsertInformationOf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertsaler frame = new Insertsaler();
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
	public Insertsaler() {
		setIconifiable(true);
		setMaximizable(true);
		
		setTitle("INSERT SELLER");
		setResizable(true);
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setBounds(100, 100, 819, 464);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(10, 11, 783, 83);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtpnInsertInformationOf = new JTextPane();
		txtpnInsertInformationOf.setBackground(SystemColor.scrollbar);
		txtpnInsertInformationOf.setForeground(Color.WHITE);
		txtpnInsertInformationOf.setText("INSERT INFORMATION OF SELLER");
		txtpnInsertInformationOf.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtpnInsertInformationOf.setBounds(231, 11, 368, 35);
		panel.add(txtpnInsertInformationOf);
		
		txtNote = new JTextField();
		txtNote.setBackground(Color.WHITE);
		txtNote.setEditable(false);
		txtNote.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txtNote.setHorizontalAlignment(SwingConstants.CENTER);
		txtNote.setText("NOTE :-");
		txtNote.setForeground(Color.RED);
		txtNote.setBounds(660, 135, 86, 20);
		contentPane.add(txtNote);
		txtNote.setColumns(10);
		
		JTextPane txtpnSalerCodeIs = new JTextPane();
		txtpnSalerCodeIs.setEditable(false);
		txtpnSalerCodeIs.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnSalerCodeIs.setForeground(Color.WHITE);
		txtpnSalerCodeIs.setBackground(Color.GREEN);
		txtpnSalerCodeIs.setText("SELLER CODE IS SET AS IDENTITY OF SELLER.\r\n\r\nSELLER CODE SHOUD BE UNIQUE FOR EACH SELLER.\r\n\r\n");
		txtpnSalerCodeIs.setBounds(612, 198, 181, 136);
		contentPane.add(txtpnSalerCodeIs);
		
		JLabel scodet = new JLabel("Seller Code");
		scodet.setForeground(Color.BLACK);
		scodet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		scodet.setBounds(10, 134, 94, 22);
		contentPane.add(scodet);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		textField.setForeground(Color.YELLOW);
		textField.setColumns(10);
		textField.setBackground(Color.BLACK);
		textField.setBounds(165, 126, 129, 30);
		contentPane.add(textField);
		
		JLabel snamet = new JLabel("Seller Name");
		snamet.setForeground(Color.BLACK);
		snamet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		snamet.setBounds(10, 184, 80, 22);
		contentPane.add(snamet);
		
		JLabel sphonet = new JLabel("Seller Contact");
		sphonet.setForeground(Color.BLACK);
		sphonet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		sphonet.setBounds(10, 261, 122, 22);
		contentPane.add(sphonet);
		
		JLabel saddresst = new JLabel("Seller Address");
		saddresst.setForeground(Color.BLACK);
		saddresst.setFont(new Font("Tahoma", Font.ITALIC, 15));
		saddresst.setBounds(10, 338, 122, 22);
		contentPane.add(saddresst);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(165, 176, 275, 30);
		contentPane.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(165, 253, 232, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(165, 328, 369, 32);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String  scode =textField.getText();
					String  name =textField_1.getText();
					String  cont=textField_3.getText();
					String  addr=textField_4.getText();
				String url="jdbc:mysql://localhost:3306/zenter";
				String username="root";
				String pass="rizz";
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection  conn=DriverManager.getConnection(url,username,pass);
				PreparedStatement ps,ps1;
				ResultSet rs;
				ps=conn.prepareStatement("select * from seller_info where scode=?");
				ps.setString(1,scode);
				rs=ps.executeQuery();
				if(rs.next()== true)
				{
					JOptionPane.showMessageDialog(btnNewButton, "THE SELLER CODE MUST BE UNIQUE ");
				}
				else
				{
				ps1=conn.prepareStatement("insert into seller_info values(?,?,?,?)");
				ps1.setString(1,scode);
				ps1.setString(2,name);
				ps1.setString(3,cont);	
				ps1.setString(4,addr);
				ps1.executeLargeUpdate();
				JOptionPane.showMessageDialog(btnNewButton, "THE SELLER INFORMATION SUCCESSFULLY INSERTED ");
				
				textField.setText("");
				textField_1.setText("");
				textField_3.setText("");
				textField_4.setText("");
				}
				
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(165, 384, 129, 30);
		contentPane.add(btnNewButton);
	}
}

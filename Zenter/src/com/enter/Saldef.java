package com.enter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Saldef extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField sltfee;
	private JTextField r75b;
	private JTextField r90b;
	private JTextField r90u;
	private JTextField r100u;
	private JTextField r125u;
	private JTextField r140u;
	private JTextField r150u;
	private JTextField r175u;
	private JTextField r200u;
	private JTextField r225u;
	private JTextField r250u;
	private JTextField txtUpdateTheDefault;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saldef frame = new Saldef();
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
	public Saldef() {
		setTitle("SALE DEFAULTS");
		setResizable(true);
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setBounds(100, 100, 942, 606);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel date = new JLabel("Date");
		date.setForeground(Color.BLACK);
		date.setFont(new Font("Tahoma", Font.ITALIC, 15));
		date.setBounds(10, 113, 59, 22);
		contentPane.add(date);
		
		Calendar cal=new GregorianCalendar();
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		
		textField = new JTextField(day+"/"+month+"/"+year);
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField.setForeground(Color.YELLOW);
		textField.setColumns(10);
		textField.setBackground(Color.BLACK);
		textField.setBounds(132, 108, 140, 33);
		contentPane.add(textField);
		
		JTextPane txtpnValue = new JTextPane();
		txtpnValue.setText("SLT RATE");
		txtpnValue.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnValue.setEditable(false);
		txtpnValue.setBounds(10, 159, 86, 25);
		contentPane.add(txtpnValue);
		
		sltfee = new JTextField();
		sltfee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		sltfee.setColumns(10);
		sltfee.setBounds(131, 159, 86, 25);
		contentPane.add(sltfee);
		
		JTextPane txtpnRate = new JTextPane();
		txtpnRate.setText("Rate 75 Below");
		txtpnRate.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRate.setEditable(false);
		txtpnRate.setBounds(10, 215, 111, 25);
		contentPane.add(txtpnRate);
		
		r75b = new JTextField();
		r75b.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		r75b.setColumns(10);
		r75b.setBounds(131, 215, 86, 25);
		contentPane.add(r75b);
		
		r90b = new JTextField();
		r90b.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		r90b.setColumns(10);
		r90b.setBounds(131, 276, 86, 25);
		contentPane.add(r90b);
		
		JTextPane txtpnRateBelow = new JTextPane();
		txtpnRateBelow.setText("Rate 90 Below");
		txtpnRateBelow.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateBelow.setEditable(false);
		txtpnRateBelow.setBounds(10, 276, 111, 25);
		contentPane.add(txtpnRateBelow);
		
		JTextPane txtpnRateUp = new JTextPane();
		txtpnRateUp.setText("Rate 90 Up");
		txtpnRateUp.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp.setEditable(false);
		txtpnRateUp.setBounds(10, 343, 111, 25);
		contentPane.add(txtpnRateUp);
		
		r90u = new JTextField();
		r90u.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		r90u.setColumns(10);
		r90u.setBounds(131, 343, 86, 25);
		contentPane.add(r90u);
		
		r100u = new JTextField();
		r100u.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		r100u.setColumns(10);
		r100u.setBounds(131, 408, 86, 25);
		contentPane.add(r100u);
		
		JTextPane txtpnRateUp_1 = new JTextPane();
		txtpnRateUp_1.setText("Rate 100 Up");
		txtpnRateUp_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_1.setEditable(false);
		txtpnRateUp_1.setBounds(10, 408, 111, 25);
		contentPane.add(txtpnRateUp_1);
		
		JTextPane txtpnRateUp_2 = new JTextPane();
		txtpnRateUp_2.setText("Rate 125 Up");
		txtpnRateUp_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_2.setEditable(false);
		txtpnRateUp_2.setBounds(10, 471, 111, 25);
		contentPane.add(txtpnRateUp_2);
		
		r125u = new JTextField();
		r125u.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		r125u.setColumns(10);
		r125u.setBounds(131, 471, 86, 25);
		contentPane.add(r125u);
		
		r140u = new JTextField();
		r140u.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		r140u.setColumns(10);
		r140u.setBounds(384, 159, 86, 25);
		contentPane.add(r140u);
		
		JTextPane txtpnRateUp_3 = new JTextPane();
		txtpnRateUp_3.setText("Rate 140 Up");
		txtpnRateUp_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_3.setEditable(false);
		txtpnRateUp_3.setBounds(263, 159, 111, 25);
		contentPane.add(txtpnRateUp_3);
		
		JTextPane txtpnRateUp_4 = new JTextPane();
		txtpnRateUp_4.setText("Rate 150 Up");
		txtpnRateUp_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_4.setEditable(false);
		txtpnRateUp_4.setBounds(263, 213, 111, 25);
		contentPane.add(txtpnRateUp_4);
		
		r150u = new JTextField();
		r150u.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		r150u.setColumns(10);
		r150u.setBounds(384, 213, 86, 25);
		contentPane.add(r150u);
		
		JTextPane txtpnRateUp_5 = new JTextPane();
		txtpnRateUp_5.setText("Rate 175 Up");
		txtpnRateUp_5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_5.setEditable(false);
		txtpnRateUp_5.setBounds(263, 280, 111, 25);
		contentPane.add(txtpnRateUp_5);
		
		r175u = new JTextField();
		r175u.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		r175u.setColumns(10);
		r175u.setBounds(384, 280, 86, 25);
		contentPane.add(r175u);
		
		JTextPane txtpnRateUp_6 = new JTextPane();
		txtpnRateUp_6.setText("Rate 200 Up");
		txtpnRateUp_6.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_6.setEditable(false);
		txtpnRateUp_6.setBounds(263, 345, 111, 25);
		contentPane.add(txtpnRateUp_6);
		
		r200u = new JTextField();
		r200u.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		r200u.setColumns(10);
		r200u.setBounds(384, 345, 86, 25);
		contentPane.add(r200u);
		
		JTextPane txtpnRateUp_7 = new JTextPane();
		txtpnRateUp_7.setText("Rate 225 Up");
		txtpnRateUp_7.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_7.setEditable(false);
		txtpnRateUp_7.setBounds(263, 408, 111, 25);
		contentPane.add(txtpnRateUp_7);
		
		r225u = new JTextField();
		r225u.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		r225u.setColumns(10);
		r225u.setBounds(384, 408, 86, 25);
		contentPane.add(r225u);
		
		JTextPane txtpnRateUp_8 = new JTextPane();
		txtpnRateUp_8.setText("Rate 250 Up");
		txtpnRateUp_8.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_8.setEditable(false);
		txtpnRateUp_8.setBounds(263, 471, 111, 25);
		contentPane.add(txtpnRateUp_8);
		
		r250u = new JTextField();
		r250u.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		r250u.setColumns(10);
		r250u.setBounds(384, 471, 86, 25);
		contentPane.add(r250u);
		
		JButton upd = new JButton("UPDATE");
		upd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String  sl =sltfee.getText();
					String  r75 =r75b.getText();
					String  r90b1=r90b.getText();
					String  r90=r90u.getText();
					String  r100=r100u.getText();
					String  r125=r125u.getText();
					String  r140=r140u.getText();
					String  r150=r150u.getText();
					String  r175=r175u.getText();
					String  r200=r200u.getText();
					String  r225=r225u.getText();
					String  r250=r250u.getText();
				String url="jdbc:mysql://localhost:3306/zenter";
				String username="root";
				String pass="rizz";
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection  conn=DriverManager.getConnection(url,username,pass);
				PreparedStatement ps,ps1,psd;
				ResultSet rs;
				psd=conn.prepareStatement("select * from defs");
				rs=psd.executeQuery();
				if(rs.next()== true)
				{
				String  sltd =rs.getString("slt");
				ps1=conn.prepareStatement("delete from defs where slt=?");
				ps1.setString(1,sltd);
				ps1.executeLargeUpdate();
				}
				
				
				ps=conn.prepareStatement("insert into defs values(?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,sl);
				ps.setString(2,r75);
				ps.setString(3,r90b1);
				ps.setString(4,r90);
				ps.setString(5,r100);
				ps.setString(6,r125);
				ps.setString(7,r140);
				ps.setString(8,r150);
				ps.setString(9,r175);
				ps.setString(10,r200);
				ps.setString(11,r225);
				ps.setString(12,r250);
				ps.executeLargeUpdate();
				JOptionPane.showMessageDialog(upd, "THE DEFAULT VALUES SUCCESSFULLY INSERTED ");
				
				sltfee.setText("");
				r75b.setText("");
				r90b.setText("");
				r90u.setText("");
				r100u.setText("");
				r125u.setText("");
				r140u.setText("");
				r150u.setText("");
				r175u.setText("");
				r200u.setText("");
				r225u.setText("");
				r250u.setText("");
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		upd.setBounds(342, 526, 140, 33);
		contentPane.add(upd);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 11, 571, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUpdateTheDefault = new JTextField();
		txtUpdateTheDefault.setEditable(false);
		txtUpdateTheDefault.setHorizontalAlignment(SwingConstants.CENTER);
		txtUpdateTheDefault.setBackground(Color.CYAN);
		txtUpdateTheDefault.setForeground(Color.WHITE);
		txtUpdateTheDefault.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtUpdateTheDefault.setText("UPDATE THE DEFAULT VALUES OF SALES HERE");
		txtUpdateTheDefault.setBounds(10, 22, 515, 37);
		panel.add(txtUpdateTheDefault);
		txtUpdateTheDefault.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(492, 106, 421, 453);
		contentPane.add(panel_2);
		
		JTextPane txtpnRateBelow_1 = new JTextPane();
		txtpnRateBelow_1.setText("Rate 90 Below");
		txtpnRateBelow_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateBelow_1.setEditable(false);
		txtpnRateBelow_1.setBackground(new Color(240, 248, 255));
		txtpnRateBelow_1.setBounds(21, 83, 111, 25);
		panel_2.add(txtpnRateBelow_1);
		
		JTextPane txtpnRateUp_9 = new JTextPane();
		txtpnRateUp_9.setText("Rate 90 Up");
		txtpnRateUp_9.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_9.setEditable(false);
		txtpnRateUp_9.setBackground(new Color(240, 248, 255));
		txtpnRateUp_9.setBounds(21, 119, 111, 25);
		panel_2.add(txtpnRateUp_9);
		
		JTextPane txtpnRateUp_1_1 = new JTextPane();
		txtpnRateUp_1_1.setText("Rate 100 Up");
		txtpnRateUp_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_1_1.setEditable(false);
		txtpnRateUp_1_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_1_1.setBounds(21, 155, 111, 25);
		panel_2.add(txtpnRateUp_1_1);
		
		JTextPane txtpnRateUp_2_1 = new JTextPane();
		txtpnRateUp_2_1.setText("Rate 125 Up");
		txtpnRateUp_2_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_2_1.setEditable(false);
		txtpnRateUp_2_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_2_1.setBounds(21, 191, 111, 25);
		panel_2.add(txtpnRateUp_2_1);
		
		JTextPane txtpnRateUp_3_1 = new JTextPane();
		txtpnRateUp_3_1.setText("Rate 140 Up");
		txtpnRateUp_3_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_3_1.setEditable(false);
		txtpnRateUp_3_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_3_1.setBounds(21, 227, 111, 25);
		panel_2.add(txtpnRateUp_3_1);
		
		JTextPane txtpnRate_1 = new JTextPane();
		txtpnRate_1.setText("Rate 75 Below");
		txtpnRate_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRate_1.setEditable(false);
		txtpnRate_1.setBackground(new Color(240, 248, 255));
		txtpnRate_1.setBounds(21, 47, 111, 25);
		panel_2.add(txtpnRate_1);
		
		JTextPane txtpnValue_1 = new JTextPane();
		txtpnValue_1.setText("SLT RATE");
		txtpnValue_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnValue_1.setEditable(false);
		txtpnValue_1.setBackground(new Color(240, 248, 255));
		txtpnValue_1.setBounds(21, 11, 86, 25);
		panel_2.add(txtpnValue_1);
		
		JTextPane txtpnRateUp_4_1 = new JTextPane();
		txtpnRateUp_4_1.setText("Rate 150 Up");
		txtpnRateUp_4_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_4_1.setEditable(false);
		txtpnRateUp_4_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_4_1.setBounds(21, 263, 111, 25);
		panel_2.add(txtpnRateUp_4_1);
		
		JTextPane txtpnRateUp_5_1 = new JTextPane();
		txtpnRateUp_5_1.setText("Rate 175 Up");
		txtpnRateUp_5_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_5_1.setEditable(false);
		txtpnRateUp_5_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_5_1.setBounds(21, 299, 111, 25);
		panel_2.add(txtpnRateUp_5_1);
		
		JTextPane txtpnRateUp_6_1 = new JTextPane();
		txtpnRateUp_6_1.setText("Rate 200 Up");
		txtpnRateUp_6_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_6_1.setEditable(false);
		txtpnRateUp_6_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_6_1.setBounds(21, 337, 111, 25);
		panel_2.add(txtpnRateUp_6_1);
		
		JTextPane txtpnRateUp_7_1 = new JTextPane();
		txtpnRateUp_7_1.setText("Rate 225 Up");
		txtpnRateUp_7_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_7_1.setEditable(false);
		txtpnRateUp_7_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_7_1.setBounds(21, 373, 111, 25);
		panel_2.add(txtpnRateUp_7_1);
		
		JTextPane txtpnRateUp_8_1 = new JTextPane();
		txtpnRateUp_8_1.setText("Rate 250 Up");
		txtpnRateUp_8_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_8_1.setEditable(false);
		txtpnRateUp_8_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_8_1.setBounds(21, 409, 111, 25);
		panel_2.add(txtpnRateUp_8_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 255, 255));
		textField_1.setEditable(false);
		textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(192, 11, 126, 25);
		panel_2.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(192, 47, 126, 25);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 255, 255));
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(192, 83, 126, 25);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(255, 255, 255));
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(192, 119, 126, 25);
		panel_2.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(255, 255, 255));
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(192, 155, 126, 25);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(255, 255, 255));
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(192, 191, 126, 25);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(255, 255, 255));
		textField_8.setEditable(false);
		textField_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(192, 227, 126, 25);
		panel_2.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setBackground(new Color(255, 255, 255));
		textField_9.setEditable(false);
		textField_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_9.setColumns(10);
		textField_9.setBounds(192, 263, 126, 25);
		panel_2.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setBackground(new Color(255, 255, 255));
		textField_10.setEditable(false);
		textField_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_10.setColumns(10);
		textField_10.setBounds(192, 299, 126, 25);
		panel_2.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setBackground(new Color(255, 255, 255));
		textField_11.setEditable(false);
		textField_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_11.setColumns(10);
		textField_11.setBounds(192, 337, 126, 25);
		panel_2.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setBackground(new Color(255, 255, 255));
		textField_12.setEditable(false);
		textField_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_12.setColumns(10);
		textField_12.setBounds(192, 373, 126, 25);
		panel_2.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setBackground(new Color(255, 255, 255));
		textField_13.setEditable(false);
		textField_13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_13.setColumns(10);
		textField_13.setBounds(192, 409, 126, 25);
		panel_2.add(textField_13);
		
		JButton btnNewButton = new JButton("LOADED VALUES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String url="jdbc:mysql://localhost:3306/zenter";
					String username="root";
					String pass="rizz";
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection  conn=DriverManager.getConnection(url,username,pass);
						PreparedStatement ps;
						ResultSet rs;
						ps=conn.prepareStatement("select * from defs");
						rs=ps.executeQuery();
						if(rs.next()== true)
						{
							textField_1.setText(rs.getString("slt").trim());
							textField_3.setText(rs.getString("rate75b").trim());
							textField_4.setText(rs.getString("rate90b").trim());
							textField_5.setText(rs.getString("rate90u").trim());
							textField_6.setText(rs.getString("rate100u").trim());
							textField_7.setText(rs.getString("rate125u").trim());
							textField_8.setText(rs.getString("rate140u").trim());
							textField_9.setText(rs.getString("rate150u").trim());
							textField_10.setText(rs.getString("rate175u").trim());
							textField_11.setText(rs.getString("rate200u").trim());
							textField_12.setText(rs.getString("rate225u").trim());
							textField_13.setText(rs.getString("rate250u").trim());
						}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnNewButton.setBounds(645, 47, 173, 33);
		contentPane.add(btnNewButton);
	}

	private void getString(String string) {
		// TODO Auto-generated method stub
		
	}
}

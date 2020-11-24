package com.enter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.Box;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField slt;
	private JTextField comm;
	private JTextField rate75be;
	private JTextField textField_1;
	private JTextField rate140up;
	private JTextField rate90be;
	private JTextField rate90up;
	private JTextField rate100up;
	private JTextField rate125up;
	private JTextField rate150up;
	private JTextField rate175up;
	private JTextField rate200up;
	private JTextField rate225up;
	private JTextField rate250up;
	private JTextField textField;
	private JTextField textField_2;
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
					Main frame = new Main();
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
	public Main() {
		setTitle("HOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1367, 911);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(81, 155, 1, 1);
		desktopPane.add(desktopPane_1);
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setForeground(Color.PINK);
		desktopPane_2.setBackground(Color.GRAY);
		desktopPane_2.setBounds(10, 404, 195, -271);
		desktopPane.add(desktopPane_2);
		
		slt = new JTextField();
		slt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		slt.setBounds(131, 328, 86, 25);
		desktopPane.add(slt);
		slt.setColumns(10);
		
		JTextPane txtpnValue = new JTextPane();
		txtpnValue.setEditable(false);
		txtpnValue.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnValue.setText("SLT RATE");
		txtpnValue.setBounds(10, 328, 86, 25);
		desktopPane.add(txtpnValue);
		
		JButton upd = new JButton("UPDATE");
		upd.setBackground(SystemColor.activeCaption);
		upd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String  sl =slt.getText();
					String  com =comm.getText();
					String  r75b =rate75be.getText();
					String  r90b=rate90be.getText();
					String  r90u=rate90up.getText();
					String  r100u=rate100up.getText();
					String  r125u=rate125up.getText();
					String  r140u=rate140up.getText();
					String  r150u=rate150up.getText();
					String  r175u=rate175up.getText();
					String  r200u=rate200up.getText();
					String  r225u=rate225up.getText();
					String  r250u=rate250up.getText();
				String url="jdbc:mysql://localhost:3306/zenter";
				String username="root";
				String pass="rizz";
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection  conn=DriverManager.getConnection(url,username,pass);
				PreparedStatement ps,ps1,psd;
				ResultSet rs;
				psd=conn.prepareStatement("select * from def");
				rs=psd.executeQuery();
				if(rs.next()== true)
				{
				String  sltd =rs.getString("slt");
				ps1=conn.prepareStatement("delete from def where slt=?");
				ps1.setString(1,sltd);
				ps1.executeLargeUpdate();
				}
				
				
				ps=conn.prepareStatement("insert into def values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,sl);
				ps.setString(2,com);
				ps.setString(3,r75b);
				ps.setString(4,r90b);
				ps.setString(5,r90u);
				ps.setString(6,r100u);
				ps.setString(7,r125u);
				ps.setString(8,r140u);
				ps.setString(9,r150u);
				ps.setString(10,r175u);
				ps.setString(11,r200u);
				ps.setString(12,r225u);
				ps.setString(13,r250u);
				ps.executeLargeUpdate();
				JOptionPane.showMessageDialog(upd, "THE DEFAULT VALUES SUCCESSFULLY INSERTED ");
				
				slt.setText("");
				comm.setText("");
				rate75be.setText("");
				rate90be.setText("");
				rate90up.setText("");
				rate100up.setText("");
				rate125up.setText("");
				rate140up.setText("");
				rate150up.setText("");
				rate175up.setText("");
				rate200up.setText("");
				rate225up.setText("");
				rate250up.setText("");
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		upd.setBounds(342, 695, 140, 33);
		desktopPane.add(upd);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 233, 568, 33);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		menuBar.setBounds(0, 0, 594, 33);
		panel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("PURCHASE");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("PURCHASE ");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UNDEFINED, 0));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Purchase pur = new Purchase();
				desktopPane.add(pur);
				pur.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("SELLER INFO");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Sellerinfo slfi = new Sellerinfo();
				desktopPane.add(slfi);
				slfi.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("PURCHASE INFO");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Purinfo puri = new Purinfo();
				desktopPane.add(puri);
				puri.setVisible(true);
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("SALE");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("SALE");
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Sale sale = new Sale();
				desktopPane.add(sale);
				sale.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu_1.add(separator_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("PARTY INFO");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Partyinfo pi = new Partyinfo();
				desktopPane.add(pi);
				pi.setVisible(true);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("SALE INFO");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Saleinfo si = new Saleinfo();
				desktopPane.add(si);
				si.setVisible(true);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_2 = new JMenu("REPORT");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("PURCHASE REPORT");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Purchaserep pr = new Purchaserep();
				desktopPane.add(pr);
				pr.setVisible(true);
			}
		});
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("SALE REPORT");
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Salereport sr = new Salereport();
				desktopPane.add(sr);
				sr.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_3 = new JMenu("UPDATE");
		mnNewMenu_3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("INSERT SELLER INFO");
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Insertsaler ins = new Insertsaler();
				desktopPane.add(ins);
				ins.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("INSERT PARTY INFO");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Insertparty inp = new Insertparty();
				desktopPane.add(inp);
				inp.setVisible(true);
			}
		});
		mntmNewMenuItem_11.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu_3.add(mntmNewMenuItem_11);
		
		JSeparator separator_4 = new JSeparator();
		mnNewMenu_3.add(separator_4);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("UPDATE SALE RATE");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Saldef sd = new Saldef();
				desktopPane.add(sd);
				sd.setVisible(true);
			}
		});
		mntmNewMenuItem_12.setFont(new Font("Segoe UI", Font.ITALIC, 12));
		mnNewMenu_3.add(mntmNewMenuItem_12);
		
		JTextPane txtpnComm = new JTextPane();
		txtpnComm.setEditable(false);
		txtpnComm.setText("COMM");
		txtpnComm.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnComm.setBounds(263, 328, 86, 25);
		desktopPane.add(txtpnComm);
		
		JTextPane txtpnRate = new JTextPane();
		txtpnRate.setEditable(false);
		txtpnRate.setText("Rate 75 Below");
		txtpnRate.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRate.setBounds(10, 384, 111, 25);
		desktopPane.add(txtpnRate);
		
		comm = new JTextField();
		comm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		comm.setColumns(10);
		comm.setBounds(384, 328, 86, 25);
		desktopPane.add(comm);
		
		rate75be = new JTextField();
		rate75be.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rate75be.setColumns(10);
		rate75be.setBounds(131, 384, 86, 25);
		desktopPane.add(rate75be);
		
		JLabel date = new JLabel("Date");
		date.setForeground(Color.BLACK);
		date.setFont(new Font("Tahoma", Font.ITALIC, 15));
		date.setBounds(10, 282, 59, 22);
		desktopPane.add(date);
		
		Calendar cal=new GregorianCalendar();
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		
		textField_1 = new JTextField(day+"/"+month+"/"+year);
		textField_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_1.setBackground(Color.BLACK);
		textField_1.setForeground(Color.YELLOW);
		textField_1.setBounds(132, 277, 140, 33);
		desktopPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane txtpnRateUp_3 = new JTextPane();
		txtpnRateUp_3.setEditable(false);
		txtpnRateUp_3.setText("Rate 140 Up");
		txtpnRateUp_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_3.setBounds(10, 695, 111, 25);
		desktopPane.add(txtpnRateUp_3);
		
		rate140up = new JTextField();
		rate140up.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rate140up.setColumns(10);
		rate140up.setBounds(131, 695, 86, 25);
		desktopPane.add(rate140up);
		
		JTextPane txtpnRateBelow = new JTextPane();
		txtpnRateBelow.setEditable(false);
		txtpnRateBelow.setText("Rate 90 Below");
		txtpnRateBelow.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateBelow.setBounds(10, 445, 111, 25);
		desktopPane.add(txtpnRateBelow);
		
		rate90be = new JTextField();
		rate90be.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rate90be.setColumns(10);
		rate90be.setBounds(131, 445, 86, 25);
		desktopPane.add(rate90be);
		
		JTextPane txtpnRateUp = new JTextPane();
		txtpnRateUp.setEditable(false);
		txtpnRateUp.setText("Rate 90 Up");
		txtpnRateUp.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp.setBounds(10, 512, 111, 25);
		desktopPane.add(txtpnRateUp);
		
		rate90up = new JTextField();
		rate90up.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rate90up.setColumns(10);
		rate90up.setBounds(131, 512, 86, 25);
		desktopPane.add(rate90up);
		
		JTextPane txtpnRateUp_1 = new JTextPane();
		txtpnRateUp_1.setEditable(false);
		txtpnRateUp_1.setText("Rate 100 Up");
		txtpnRateUp_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_1.setBounds(10, 577, 111, 25);
		desktopPane.add(txtpnRateUp_1);
		
		rate100up = new JTextField();
		rate100up.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rate100up.setColumns(10);
		rate100up.setBounds(131, 577, 86, 25);
		desktopPane.add(rate100up);
		
		JTextPane txtpnRateUp_2 = new JTextPane();
		txtpnRateUp_2.setEditable(false);
		txtpnRateUp_2.setText("Rate 125 Up");
		txtpnRateUp_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_2.setBounds(10, 640, 111, 25);
		desktopPane.add(txtpnRateUp_2);
		
		rate125up = new JTextField();
		rate125up.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rate125up.setColumns(10);
		rate125up.setBounds(131, 640, 86, 25);
		desktopPane.add(rate125up);
		
		JTextPane txtpnRateUp_4 = new JTextPane();
		txtpnRateUp_4.setEditable(false);
		txtpnRateUp_4.setText("Rate 150 Up");
		txtpnRateUp_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_4.setBounds(263, 382, 111, 25);
		desktopPane.add(txtpnRateUp_4);
		
		rate150up = new JTextField();
		rate150up.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rate150up.setColumns(10);
		rate150up.setBounds(384, 382, 86, 25);
		desktopPane.add(rate150up);
		
		JTextPane txtpnRateUp_5 = new JTextPane();
		txtpnRateUp_5.setEditable(false);
		txtpnRateUp_5.setText("Rate 175 Up");
		txtpnRateUp_5.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_5.setBounds(263, 449, 111, 25);
		desktopPane.add(txtpnRateUp_5);
		
		rate175up = new JTextField();
		rate175up.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rate175up.setColumns(10);
		rate175up.setBounds(384, 449, 86, 25);
		desktopPane.add(rate175up);
		
		JTextPane txtpnRateUp_6 = new JTextPane();
		txtpnRateUp_6.setEditable(false);
		txtpnRateUp_6.setText("Rate 200 Up");
		txtpnRateUp_6.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_6.setBounds(263, 514, 111, 25);
		desktopPane.add(txtpnRateUp_6);
		
		rate200up = new JTextField();
		rate200up.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rate200up.setColumns(10);
		rate200up.setBounds(384, 514, 86, 25);
		desktopPane.add(rate200up);
		
		JTextPane txtpnRateUp_7 = new JTextPane();
		txtpnRateUp_7.setEditable(false);
		txtpnRateUp_7.setText("Rate 225 Up");
		txtpnRateUp_7.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_7.setBounds(263, 577, 111, 25);
		desktopPane.add(txtpnRateUp_7);
		
		rate225up = new JTextField();
		rate225up.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rate225up.setColumns(10);
		rate225up.setBounds(384, 577, 86, 25);
		desktopPane.add(rate225up);
		
		JTextPane txtpnRateUp_8 = new JTextPane();
		txtpnRateUp_8.setEditable(false);
		txtpnRateUp_8.setText("Rate 250 Up");
		txtpnRateUp_8.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_8.setBounds(263, 640, 111, 25);
		desktopPane.add(txtpnRateUp_8);
		
		rate250up = new JTextField();
		rate250up.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		rate250up.setColumns(10);
		rate250up.setBounds(384, 640, 86, 25);
		desktopPane.add(rate250up);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.scrollbar);
		panel_1.setBounds(10, 11, 1321, 211);
		desktopPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextPane txtpnZainabEnterprices = new JTextPane();
		txtpnZainabEnterprices.setEditable(false);
		txtpnZainabEnterprices.setForeground(Color.WHITE);
		txtpnZainabEnterprices.setBackground(SystemColor.scrollbar);
		txtpnZainabEnterprices.setText("ZAINAB ENTERPRICES");
		txtpnZainabEnterprices.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 50));
		txtpnZainabEnterprices.setBounds(334, 11, 590, 78);
		panel_1.add(txtpnZainabEnterprices);
		
		JTextPane txtpnMobileNo = new JTextPane();
		txtpnMobileNo.setEditable(false);
		txtpnMobileNo.setForeground(SystemColor.window);
		txtpnMobileNo.setBackground(SystemColor.scrollbar);
		txtpnMobileNo.setText("MOBILE NO     +919021540260");
		txtpnMobileNo.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		txtpnMobileNo.setBounds(10, 100, 357, 40);
		panel_1.add(txtpnMobileNo);
		
		JTextPane txtpnMailIdZakigmailcom = new JTextPane();
		txtpnMailIdZakigmailcom.setEditable(false);
		txtpnMailIdZakigmailcom.setForeground(SystemColor.window);
		txtpnMailIdZakigmailcom.setBackground(SystemColor.scrollbar);
		txtpnMailIdZakigmailcom.setText("MAIL ID    Zaki540260@gmail.com");
		txtpnMailIdZakigmailcom.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		txtpnMailIdZakigmailcom.setBounds(10, 160, 391, 40);
		panel_1.add(txtpnMailIdZakigmailcom);
		
		JTextPane txtpnAddressSangamnertalsangamnerDist = new JTextPane();
		txtpnAddressSangamnertalsangamnerDist.setEditable(false);
		txtpnAddressSangamnertalsangamnerDist.setForeground(SystemColor.window);
		txtpnAddressSangamnertalsangamnerDist.setBackground(SystemColor.scrollbar);
		txtpnAddressSangamnertalsangamnerDist.setText("ADDRESS\r\nSANGAMNER,TAL.SANGAMNER\r\nDIST. A.NAGAR , STATE  MAHARASHTRA\r\n422605");
		txtpnAddressSangamnertalsangamnerDist.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		txtpnAddressSangamnertalsangamnerDist.setBounds(893, 96, 418, 115);
		panel_1.add(txtpnAddressSangamnertalsangamnerDist);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(240, 248, 255));
		panel_2.setBounds(910, 233, 421, 506);
		desktopPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane txtpnRateBelow_1 = new JTextPane();
		txtpnRateBelow_1.setBackground(new Color(240, 248, 255));
		txtpnRateBelow_1.setText("Rate 90 Below");
		txtpnRateBelow_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateBelow_1.setEditable(false);
		txtpnRateBelow_1.setBounds(20, 154, 111, 25);
		panel_2.add(txtpnRateBelow_1);
		
		JTextPane txtpnRateUp_9 = new JTextPane();
		txtpnRateUp_9.setBackground(new Color(240, 248, 255));
		txtpnRateUp_9.setText("Rate 90 Up");
		txtpnRateUp_9.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_9.setEditable(false);
		txtpnRateUp_9.setBounds(20, 190, 111, 25);
		panel_2.add(txtpnRateUp_9);
		
		JTextPane txtpnRateUp_1_1 = new JTextPane();
		txtpnRateUp_1_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_1_1.setText("Rate 100 Up");
		txtpnRateUp_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_1_1.setEditable(false);
		txtpnRateUp_1_1.setBounds(20, 226, 111, 25);
		panel_2.add(txtpnRateUp_1_1);
		
		JTextPane txtpnRateUp_2_1 = new JTextPane();
		txtpnRateUp_2_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_2_1.setText("Rate 125 Up");
		txtpnRateUp_2_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_2_1.setEditable(false);
		txtpnRateUp_2_1.setBounds(20, 262, 111, 25);
		panel_2.add(txtpnRateUp_2_1);
		
		JTextPane txtpnRateUp_3_1 = new JTextPane();
		txtpnRateUp_3_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_3_1.setText("Rate 140 Up");
		txtpnRateUp_3_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_3_1.setEditable(false);
		txtpnRateUp_3_1.setBounds(20, 298, 111, 25);
		panel_2.add(txtpnRateUp_3_1);
		
		JTextPane txtpnRate_1 = new JTextPane();
		txtpnRate_1.setBackground(new Color(240, 248, 255));
		txtpnRate_1.setText("Rate 75 Below");
		txtpnRate_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRate_1.setEditable(false);
		txtpnRate_1.setBounds(20, 118, 111, 25);
		panel_2.add(txtpnRate_1);
		
		JTextPane txtpnValue_1 = new JTextPane();
		txtpnValue_1.setBackground(new Color(240, 248, 255));
		txtpnValue_1.setText("SLT RATE");
		txtpnValue_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnValue_1.setEditable(false);
		txtpnValue_1.setBounds(20, 46, 86, 25);
		panel_2.add(txtpnValue_1);
		
		JTextPane txtpnComm_1 = new JTextPane();
		txtpnComm_1.setBackground(new Color(240, 248, 255));
		txtpnComm_1.setText("COMM");
		txtpnComm_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnComm_1.setEditable(false);
		txtpnComm_1.setBounds(20, 82, 86, 25);
		panel_2.add(txtpnComm_1);
		
		JTextPane txtpnRateUp_4_1 = new JTextPane();
		txtpnRateUp_4_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_4_1.setText("Rate 150 Up");
		txtpnRateUp_4_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_4_1.setEditable(false);
		txtpnRateUp_4_1.setBounds(20, 334, 111, 25);
		panel_2.add(txtpnRateUp_4_1);
		
		JTextPane txtpnRateUp_5_1 = new JTextPane();
		txtpnRateUp_5_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_5_1.setText("Rate 175 Up");
		txtpnRateUp_5_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_5_1.setEditable(false);
		txtpnRateUp_5_1.setBounds(20, 370, 111, 25);
		panel_2.add(txtpnRateUp_5_1);
		
		JTextPane txtpnRateUp_6_1 = new JTextPane();
		txtpnRateUp_6_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_6_1.setText("Rate 200 Up");
		txtpnRateUp_6_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_6_1.setEditable(false);
		txtpnRateUp_6_1.setBounds(20, 408, 111, 25);
		panel_2.add(txtpnRateUp_6_1);
		
		JTextPane txtpnRateUp_7_1 = new JTextPane();
		txtpnRateUp_7_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_7_1.setText("Rate 225 Up");
		txtpnRateUp_7_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_7_1.setEditable(false);
		txtpnRateUp_7_1.setBounds(20, 444, 111, 25);
		panel_2.add(txtpnRateUp_7_1);
		
		JTextPane txtpnRateUp_8_1 = new JTextPane();
		txtpnRateUp_8_1.setBackground(new Color(240, 248, 255));
		txtpnRateUp_8_1.setText("Rate 250 Up");
		txtpnRateUp_8_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnRateUp_8_1.setEditable(false);
		txtpnRateUp_8_1.setBounds(20, 480, 111, 25);
		panel_2.add(txtpnRateUp_8_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField.setColumns(10);
		textField.setBounds(191, 46, 126, 25);
		panel_2.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(191, 82, 126, 25);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setEditable(false);
		textField_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(191, 118, 126, 25);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 255, 255));
		textField_4.setEditable(false);
		textField_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(191, 154, 126, 25);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(255, 255, 255));
		textField_5.setEditable(false);
		textField_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(191, 190, 126, 25);
		panel_2.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBackground(new Color(255, 255, 255));
		textField_6.setEditable(false);
		textField_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(191, 226, 126, 25);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(255, 255, 255));
		textField_7.setEditable(false);
		textField_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(191, 262, 126, 25);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(255, 255, 255));
		textField_8.setEditable(false);
		textField_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(191, 298, 126, 25);
		panel_2.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setBackground(new Color(255, 255, 255));
		textField_9.setEditable(false);
		textField_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_9.setColumns(10);
		textField_9.setBounds(191, 334, 126, 25);
		panel_2.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setBackground(new Color(255, 255, 255));
		textField_10.setEditable(false);
		textField_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_10.setColumns(10);
		textField_10.setBounds(191, 370, 126, 25);
		panel_2.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setBackground(new Color(255, 255, 255));
		textField_11.setEditable(false);
		textField_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_11.setColumns(10);
		textField_11.setBounds(191, 408, 126, 25);
		panel_2.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setBackground(new Color(255, 255, 255));
		textField_12.setEditable(false);
		textField_12.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_12.setColumns(10);
		textField_12.setBounds(191, 444, 126, 25);
		panel_2.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setBackground(new Color(255, 255, 255));
		textField_13.setEditable(false);
		textField_13.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		textField_13.setColumns(10);
		textField_13.setBounds(191, 480, 126, 25);
		panel_2.add(textField_13);
		
		JButton btnNewButton = new JButton("LOADED VALUES");
		btnNewButton.setBackground(SystemColor.activeCaption);
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
						ps=conn.prepareStatement("select * from def");
						rs=ps.executeQuery();
						if(rs.next()== true)
						{
							textField.setText(rs.getString("slt").trim());
							textField_2.setText(rs.getString("comm").trim());
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
		btnNewButton.setBounds(10, 12, 162, 23);
		panel_2.add(btnNewButton);
		
		JTextPane txtpnInsertThePurchase = new JTextPane();
		txtpnInsertThePurchase.setText("INSERT THE PURCHASE RATE,AND SLT FEES.\r\n\r\n\r\n\r\n");
		txtpnInsertThePurchase.setForeground(Color.WHITE);
		txtpnInsertThePurchase.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtpnInsertThePurchase.setEditable(false);
		txtpnInsertThePurchase.setBackground(SystemColor.activeCaption);
		txtpnInsertThePurchase.setBounds(610, 466, 181, 136);
		desktopPane.add(txtpnInsertThePurchase);
		
		JLabel lblNewLabel = new JLabel("NOTE :-");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(642, 414, 111, 25);
		desktopPane.add(lblNewLabel);
	}
}

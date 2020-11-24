package com.enter;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;

public class Purchaserep extends JInternalFrame {
	private JTextField sc;
	private JTextField scon;
	private JTextField sadd;
	private JTextField sn;
	private JTable table;
	private JTable table_1;
	private JTextField sbn;
	private JTextField nt;
	private JTextField bal;
	private JTextField paid;
	private JTextField narrat;
	private JTextField bt;
	private JTextField gnt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchaserep frame = new Purchaserep();
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
	public Purchaserep() {
		setMaximizable(true);
		setIconifiable(true);
		setTitle("PURCHASE REPORT");
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setBounds(100, 100, 1325, 770);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(10, 11, 1290, 45);
		getContentPane().add(panel);
		
		JTextPane txtpnPurchaseAccountsReport = new JTextPane();
		txtpnPurchaseAccountsReport.setText("PURCHASE ACCOUNTS REPORT");
		txtpnPurchaseAccountsReport.setForeground(Color.WHITE);
		txtpnPurchaseAccountsReport.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		txtpnPurchaseAccountsReport.setEditable(false);
		txtpnPurchaseAccountsReport.setBackground(SystemColor.scrollbar);
		txtpnPurchaseAccountsReport.setBounds(435, 11, 410, 34);
		panel.add(txtpnPurchaseAccountsReport);
		
		JButton btnLoadSellerData = new JButton("LOAD SELLER DATA");
		btnLoadSellerData.addActionListener(new ActionListener() {
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
					ps=conn.prepareStatement("select * from seller_info");
					rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		btnLoadSellerData.setBackground(SystemColor.activeCaption);
		btnLoadSellerData.setBounds(10, 68, 132, 30);
		getContentPane().add(btnLoadSellerData);
		
		JLabel lblSelectedSellerInformation = new JLabel("SELECTED SELLER INFORMATION");
		lblSelectedSellerInformation.setForeground(SystemColor.textHighlight);
		lblSelectedSellerInformation.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblSelectedSellerInformation.setBounds(740, 68, 239, 22);
		getContentPane().add(lblSelectedSellerInformation);
		
		JLabel lblNewLabel_1 = new JLabel("SELLER CODE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(634, 114, 94, 22);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CONTACT");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_2.setBounds(634, 158, 94, 22);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("SELLER ADDRESS");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_3.setBounds(634, 203, 94, 22);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("SELLER NAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_1.setBounds(885, 114, 94, 22);
		getContentPane().add(lblNewLabel_1_1);
		
		sc = new JTextField();
		sc.setFont(new Font("Tahoma", Font.ITALIC, 14));
		sc.setEditable(false);
		sc.setColumns(10);
		sc.setBackground(Color.WHITE);
		sc.setBounds(740, 111, 125, 26);
		getContentPane().add(sc);
		
		scon = new JTextField();
		scon.setFont(new Font("Tahoma", Font.ITALIC, 14));
		scon.setEditable(false);
		scon.setColumns(10);
		scon.setBackground(Color.WHITE);
		scon.setBounds(740, 158, 257, 26);
		getContentPane().add(scon);
		
		sadd = new JTextField();
		sadd.setFont(new Font("Tahoma", Font.ITALIC, 14));
		sadd.setEditable(false);
		sadd.setColumns(10);
		sadd.setBackground(Color.WHITE);
		sadd.setBounds(740, 199, 534, 26);
		getContentPane().add(sadd);
		
		sn = new JTextField();
		sn.setFont(new Font("Tahoma", Font.ITALIC, 14));
		sn.setEditable(false);
		sn.setColumns(10);
		sn.setBackground(Color.WHITE);
		sn.setBounds(1003, 111, 271, 26);
		getContentPane().add(sn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 109, 549, 115);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				DefaultTableModel model=new DefaultTableModel();
				model = (DefaultTableModel)table.getModel();
				int sri=table.getSelectedRow();
				sc.setText(model.getValueAt(sri, 0).toString());
				sn.setText(model.getValueAt(sri, 1).toString());
				scon.setText(model.getValueAt(sri, 2).toString());
				sadd.setText(model.getValueAt(sri, 3).toString());
			}
			
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"SELLER CODE", "NAME", "CONTACT", "ADDRESS"
			}
		));
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFont(new Font("Arial Black", Font.ITALIC, 15));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBackground(Color.WHITE);
		
		JButton btnLoadSelectedSeller = new JButton("LOAD SELECTED SELLER DATA");
		btnLoadSelectedSeller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String sco=sc.getText();
				try
				{
					String url="jdbc:mysql://localhost:3306/zenter";
					String username="root";
					String pass="rizz";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection  conn=DriverManager.getConnection(url,username,pass);
					PreparedStatement ps;
					ResultSet rs;
					ps=conn.prepareStatement("select bno,scode,sname,rels,qnt,item,total,rent,netwet,adv,ntot,memo,bal,narrat from purchase where scode='"+sco+"'");
					rs=ps.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				int sum=0,sum1=0;
				 
				 for(int i=0; i<table_1.getRowCount();i++)
				 {
					 sum=sum+Integer.parseInt(table_1.getValueAt(i, 10).toString());
					 sum1=sum1+Integer.parseInt(table_1.getValueAt(i, 12).toString());

				 }
				 
				gnt.setText(Integer.toString(sum));
				bt.setText(Integer.toString(sum1));
			}
		});
		btnLoadSelectedSeller.setBackground(SystemColor.activeCaption);
		btnLoadSelectedSeller.setBounds(9, 251, 186, 30);
		getContentPane().add(btnLoadSelectedSeller);
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(288, 256, 127, 25);
		getContentPane().add(dateChooser1);
		dateChooser1.setDateFormatString("YYYY-MM-dd");
		
		JButton btnSortByDate = new JButton("SORT BY DATE");
		btnSortByDate.addActionListener(new ActionListener() {
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
					String sco=sc.getText();
					String memo=(((JTextField) dateChooser1.getDateEditor().getUiComponent()).getText());
					ps=conn.prepareStatement("select bno,scode,sname,rels,qnt,item,total,rent,netwet,adv,ntot,memo,bal,narrat from purchase where memo='"+memo+"' and scode='"+sco+"'");
					rs=ps.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				int sum=0,sum1=0;
				 
				 for(int i=0; i<table_1.getRowCount();i++)
				 {
					 sum=sum+Integer.parseInt(table_1.getValueAt(i, 10).toString());
					 sum1=sum1+Integer.parseInt(table_1.getValueAt(i, 12).toString());
				 }
				 
				gnt.setText(Integer.toString(sum));
				bt.setText(Integer.toString(sum1));
			}
		});
		btnSortByDate.setBackground(SystemColor.activeCaption);
		btnSortByDate.setBounds(425, 251, 135, 30);
		getContentPane().add(btnSortByDate);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 303, 1288, 209);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{

				DefaultTableModel model=new DefaultTableModel();
				model = (DefaultTableModel)table_1.getModel();
				int sbnt=table_1.getSelectedRow();
				sbn.setText(model.getValueAt(sbnt, 0).toString());
				nt.setText(model.getValueAt(sbnt, 10).toString());
				bal.setText(model.getValueAt(sbnt, 12).toString());
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"BILL NUMBER", "SELLER CODE", "SELLER NAME", "REL SUPP.", "QUANTITY", "ITEM", "TOTAL", "RENT", "NET WEIGHT", "ADVANCE", "NET TOTAL", "DATE", "BALANCE", "NARRATION"
			}
		));
		scrollPane_1.setViewportView(table_1);
		table_1.setToolTipText("");
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_1.setFont(new Font("Arial Black", Font.ITALIC, 15));
		table_1.setFillsViewportHeight(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table_1.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1_4 = new JLabel("SELECTED BILL NUMBER");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_4.setBounds(10, 586, 162, 22);
		getContentPane().add(lblNewLabel_1_4);
		
		sbn = new JTextField();
		sbn.setForeground(Color.YELLOW);
		sbn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		sbn.setEditable(false);
		sbn.setColumns(10);
		sbn.setBackground(Color.BLACK);
		sbn.setBounds(182, 577, 72, 38);
		getContentPane().add(sbn);
		
		nt = new JTextField();
		nt.setFont(new Font("Tahoma", Font.ITALIC, 14));
		nt.setEditable(false);
		nt.setColumns(10);
		nt.setBackground(Color.WHITE);
		nt.setBounds(392, 585, 162, 30);
		getContentPane().add(nt);
		
		JLabel lblNewLabel_1_5 = new JLabel("NET TOTAL");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_5.setBounds(306, 593, 82, 22);
		getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("BALANCE");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_6.setBounds(636, 593, 72, 22);
		getContentPane().add(lblNewLabel_1_6);
		
		bal = new JTextField();
		bal.setFont(new Font("Tahoma", Font.ITALIC, 14));
		bal.setEditable(false);
		bal.setColumns(10);
		bal.setBackground(Color.WHITE);
		bal.setBounds(718, 585, 147, 30);
		getContentPane().add(bal);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("PAID");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_5_1.setBounds(313, 681, 82, 22);
		getContentPane().add(lblNewLabel_1_5_1);
		
		paid = new JTextField();
		paid.setFont(new Font("Tahoma", Font.ITALIC, 14));
		paid.setColumns(10);
		paid.setBackground(Color.WHITE);
		paid.setBounds(399, 673, 162, 30);
		getContentPane().add(paid);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("NARRATION");
		lblNewLabel_1_5_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_5_2.setBounds(634, 681, 82, 22);
		getContentPane().add(lblNewLabel_1_5_2);
		
		narrat = new JTextField();
		narrat.setFont(new Font("Tahoma", Font.ITALIC, 14));
		narrat.setColumns(10);
		narrat.setBackground(Color.WHITE);
		narrat.setBounds(740, 678, 177, 30);
		getContentPane().add(narrat);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					int b=Integer.parseInt(sbn.getText());
					int s=Integer.parseInt(bal.getText());
					int p=Integer.parseInt(paid.getText());
					int ba=s-p;
					String n=narrat.getText();
					String url="jdbc:mysql://localhost:3306/zenter";
					String username="root";
					String pass="rizz";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection  conn=DriverManager.getConnection(url,username,pass);
					PreparedStatement ps,ps1;
					ps=conn.prepareStatement("update purchase set bal='"+ba+"'  where bno='"+b+"'");
					ps.executeUpdate();
					ps1=conn.prepareStatement("update purchase set narrat='"+n+"' where bno='"+b+"'");
					ps1.executeUpdate();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				sbn.setText("");
				nt.setText("");
				bal.setText("");
				narrat.setText("");
				paid.setText("");
			}
		});
		btnUpdate.setBackground(SystemColor.activeCaption);
		btnUpdate.setBounds(1013, 679, 135, 30);
		getContentPane().add(btnUpdate);
		
		bt = new JTextField();
		bt.setForeground(SystemColor.textHighlight);
		bt.setFont(new Font("Tahoma", Font.ITALIC, 14));
		bt.setEditable(false);
		bt.setColumns(10);
		bt.setBackground(Color.WHITE);
		bt.setBounds(1127, 523, 147, 30);
		getContentPane().add(bt);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("BALANCE TOTAL");
		lblNewLabel_1_6_1.setForeground(Color.RED);
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_6_1.setBounds(1013, 531, 104, 22);
		getContentPane().add(lblNewLabel_1_6_1);
		
		gnt = new JTextField();
		gnt.setForeground(SystemColor.textHighlight);
		gnt.setFont(new Font("Tahoma", Font.ITALIC, 14));
		gnt.setEditable(false);
		gnt.setColumns(10);
		gnt.setBackground(Color.WHITE);
		gnt.setBounds(845, 523, 147, 30);
		getContentPane().add(gnt);
		
		JLabel lblNewLabel_1_6_2 = new JLabel("GRAND NET TOTAL");
		lblNewLabel_1_6_2.setForeground(Color.RED);
		lblNewLabel_1_6_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_6_2.setBounds(703, 531, 132, 22);
		getContentPane().add(lblNewLabel_1_6_2);

	}
}

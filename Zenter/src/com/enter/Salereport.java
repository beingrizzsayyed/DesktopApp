package com.enter;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

public class Salereport extends JInternalFrame {
	private JTable table;
	private JTextField pc;
	private JTextField pn;
	private JTextField pcon;
	private JTextField padd;
	private JTable table_1;
	private JTextField sbn;
	private JTextField nt;
	private JTextField bal;
	private JTextField paid;
	private JTextField narrat;
	private JTextField gnt;
	private JTextField bt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salereport frame = new Salereport();
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
	public Salereport() {
		setMaximizable(true);
		setIconifiable(true);
		setTitle("SALE REPORT");
		setResizable(true);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(10, 11, 1290, 45);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnSalerAccountReport = new JTextPane();
		txtpnSalerAccountReport.setEditable(false);
		txtpnSalerAccountReport.setText("SALE ACCOUNTS REPORT");
		txtpnSalerAccountReport.setBackground(SystemColor.scrollbar);
		txtpnSalerAccountReport.setForeground(Color.WHITE);
		txtpnSalerAccountReport.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		txtpnSalerAccountReport.setBounds(468, 11, 341, 34);
		panel.add(txtpnSalerAccountReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 110, 551, 114);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				DefaultTableModel model=new DefaultTableModel();
				model = (DefaultTableModel)table.getModel();
				int sri=table.getSelectedRow();
				pc.setText(model.getValueAt(sri, 0).toString());
				pn.setText(model.getValueAt(sri, 1).toString());
				pcon.setText(model.getValueAt(sri, 2).toString());
				padd.setText(model.getValueAt(sri, 3).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PARTY CODE", "COMPANY NAME", "CONTACT", "ADDRESS"
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
		
		JButton btnNewButton = new JButton("LOAD PARTY DATA");
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
					ps=conn.prepareStatement("select * from party_info");
					rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
			}
		});
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(10, 67, 125, 30);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SELECTED PARTY INFORMATION");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setBounds(740, 67, 239, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PARTY CODE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(634, 113, 94, 22);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PARTY NAME");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_1.setBounds(885, 113, 94, 22);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CONTACT");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_2.setBounds(634, 157, 94, 22);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("PARTY ADDRESS");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_3.setBounds(634, 202, 94, 22);
		getContentPane().add(lblNewLabel_1_3);
		
		pc = new JTextField();
		pc.setBackground(SystemColor.textHighlightText);
		pc.setEditable(false);
		pc.setFont(new Font("Tahoma", Font.ITALIC, 14));
		pc.setBounds(740, 110, 125, 26);
		getContentPane().add(pc);
		pc.setColumns(10);
		
		pn = new JTextField();
		pn.setBackground(SystemColor.textHighlightText);
		pn.setEditable(false);
		pn.setFont(new Font("Tahoma", Font.ITALIC, 14));
		pn.setColumns(10);
		pn.setBounds(1003, 110, 271, 26);
		getContentPane().add(pn);
		
		pcon = new JTextField();
		pcon.setBackground(SystemColor.textHighlightText);
		pcon.setEditable(false);
		pcon.setFont(new Font("Tahoma", Font.ITALIC, 14));
		pcon.setColumns(10);
		pcon.setBounds(740, 157, 257, 26);
		getContentPane().add(pcon);
		
		padd = new JTextField();
		padd.setBackground(SystemColor.textHighlightText);
		padd.setEditable(false);
		padd.setFont(new Font("Tahoma", Font.ITALIC, 14));
		padd.setColumns(10);
		padd.setBounds(740, 198, 534, 26);
		getContentPane().add(padd);
		
		JButton btnLoadSelectedParty = new JButton("LOAD SELECTED  PARTY DATA");
		btnLoadSelectedParty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String pco=pc.getText();
				try
				{
					String url="jdbc:mysql://localhost:3306/zenter";
					String username="root";
					String pass="rizz";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection  conn=DriverManager.getConnection(url,username,pass);
					PreparedStatement ps;
					ResultSet rs;
					ps=conn.prepareStatement("select * from sale where pcode='"+pco+"'");
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
					 sum=sum+Integer.parseInt(table_1.getValueAt(i, 12).toString());
					 sum1=sum1+Integer.parseInt(table_1.getValueAt(i, 14).toString());

				 }
				 
				gnt.setText(Integer.toString(sum));
				bt.setText(Integer.toString(sum1));
			}
		});
		btnLoadSelectedParty.setBackground(SystemColor.activeCaption);
		btnLoadSelectedParty.setBounds(10, 243, 186, 30);
		getContentPane().add(btnLoadSelectedParty);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 296, 1290, 208);
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
				nt.setText(model.getValueAt(sbnt, 12).toString());
				bal.setText(model.getValueAt(sbnt, 14).toString());
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"BILL NUMBER", "PARTY CODE", "PARTY NAME",  "QUANTITY", "ITEM", "TOTAL", "SLT FEE", "EMERGENCY", "JAUNDICE", "RENT", "NET WEIGHT", "ADVANCE", "NET TOTAL", "DATE","BALANCE","NARRATION"
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
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(289, 248, 127, 25);
		getContentPane().add(dateChooser1);
		dateChooser1.setDateFormatString("YYYY-MM-dd");
		setClosable(true);
		setBounds(100, 100, 1326, 757);
		
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
					String pco=pc.getText();
					String memo=(((JTextField) dateChooser1.getDateEditor().getUiComponent()).getText());
					ps=conn.prepareStatement("select * from sale where memo='"+memo+"' and pcode='"+pco+"'");
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
					 sum=sum+Integer.parseInt(table_1.getValueAt(i, 12).toString());
					 sum1=sum1+Integer.parseInt(table_1.getValueAt(i, 14).toString());

				 }
				 
				gnt.setText(Integer.toString(sum));
				bt.setText(Integer.toString(sum1));
			}
		});
		btnSortByDate.setBackground(SystemColor.activeCaption);
		btnSortByDate.setBounds(426, 243, 135, 30);
		getContentPane().add(btnSortByDate);
		
		sbn = new JTextField();
		sbn.setForeground(Color.YELLOW);
		sbn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		sbn.setEditable(false);
		sbn.setColumns(10);
		sbn.setBackground(Color.BLACK);
		sbn.setBounds(182, 577, 72, 38);
		getContentPane().add(sbn);
		
		JLabel lblNewLabel_1_4 = new JLabel("SELECTED BILL NUMBER");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_4.setBounds(10, 586, 162, 22);
		getContentPane().add(lblNewLabel_1_4);
		
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
		
		bal = new JTextField();
		bal.setFont(new Font("Tahoma", Font.ITALIC, 14));
		bal.setEditable(false);
		bal.setColumns(10);
		bal.setBackground(Color.WHITE);
		bal.setBounds(718, 585, 147, 30);
		getContentPane().add(bal);
		
		JLabel lblNewLabel_1_6 = new JLabel("BALANCE");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_6.setBounds(636, 593, 72, 22);
		getContentPane().add(lblNewLabel_1_6);
		
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
					ps=conn.prepareStatement("update sale set bal='"+ba+"'  where bno='"+b+"'");
					ps.executeUpdate();
					ps1=conn.prepareStatement("update sale set narat='"+n+"' where bno='"+b+"'");
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
		btnUpdate.setBounds(1003, 673, 135, 30);
		getContentPane().add(btnUpdate);
		
		JLabel lblNewLabel_1_6_2 = new JLabel("GRAND NET TOTAL");
		lblNewLabel_1_6_2.setForeground(Color.RED);
		lblNewLabel_1_6_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_6_2.setBounds(703, 523, 132, 22);
		getContentPane().add(lblNewLabel_1_6_2);
		
		gnt = new JTextField();
		gnt.setForeground(SystemColor.textHighlight);
		gnt.setFont(new Font("Tahoma", Font.ITALIC, 14));
		gnt.setEditable(false);
		gnt.setColumns(10);
		gnt.setBackground(Color.WHITE);
		gnt.setBounds(845, 515, 147, 30);
		getContentPane().add(gnt);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("BALANCE TOTAL");
		lblNewLabel_1_6_1.setForeground(Color.RED);
		lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1_6_1.setBounds(1013, 523, 104, 22);
		getContentPane().add(lblNewLabel_1_6_1);
		
		bt = new JTextField();
		bt.setForeground(SystemColor.textHighlight);
		bt.setFont(new Font("Tahoma", Font.ITALIC, 14));
		bt.setEditable(false);
		bt.setColumns(10);
		bt.setBackground(Color.WHITE);
		bt.setBounds(1127, 515, 147, 30);
		getContentPane().add(bt);
		
	

	}
}

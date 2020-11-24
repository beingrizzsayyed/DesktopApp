package com.enter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSplitPane;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Purinfo extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField bn;
	private JTextField gnt;
	private JTextField bt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purinfo frame = new Purinfo();
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
	public Purinfo() {
		setMaximizable(true);
		setIconifiable(true);
		setTitle("PURCHASE INFORMATION");
		setResizable(true);
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setBounds(100, 100, 1288, 661);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(10, 11, 1252, 103);
		contentPane.add(panel);
		
		JTextPane txtpnPurchaseInformation = new JTextPane();
		txtpnPurchaseInformation.setText("PURCHASE INFORMATION ");
		txtpnPurchaseInformation.setForeground(Color.WHITE);
		txtpnPurchaseInformation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtpnPurchaseInformation.setEditable(false);
		txtpnPurchaseInformation.setBackground(SystemColor.scrollbar);
		txtpnPurchaseInformation.setBounds(533, 11, 287, 31);
		panel.add(txtpnPurchaseInformation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 1252, 310);
		contentPane.add(scrollPane);
		
	
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"BILL NUMBER", "SELLER CODE", "SELLER NAME", "REL SUPP.", "QUANTITY", "ITEM", "TOTAL", "SLT FEE", "EMERGENCY", "COMMISSION", "JAUNDICE", "RENT", "NET WEIGHT", "ADVANCE", "NET TOTAL", "DATE","BALANCE","NARRATION"
			}
		));
		scrollPane.setViewportView(table);
		table.setToolTipText("");
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFont(new Font("Tahoma", Font.ITALIC, 15));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBackground(Color.WHITE);
		
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(525, 164, 127, 25);
		contentPane.add(dateChooser_1);
		dateChooser_1.setDateFormatString("YYYY-MM-dd");
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(696, 164, 127, 25);
		contentPane.add(dateChooser_2);
		dateChooser_2.setDateFormatString("YYYY-MM-dd");
		
		JTextPane txtpnTo = new JTextPane();
		txtpnTo.setText("TO");
		txtpnTo.setBounds(662, 164, 20, 20);
		contentPane.add(txtpnTo);
		
		JDateChooser dateChooser1 = new JDateChooser();
		dateChooser1.setBounds(190, 170, 127, 25);
		contentPane.add(dateChooser1);
		dateChooser1.setDateFormatString("YYYY-MM-dd");
			JButton btnNewButton = new JButton("ALL DATA");
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
						ps=conn.prepareStatement("select * from purchase");
						rs=ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					int sum=0,sum1=0;
					 
					 for(int i=0; i<table.getRowCount();i++)
					 {
						 sum=sum+Integer.parseInt(table.getValueAt(i, 14).toString());
						 sum1=sum1+Integer.parseInt(table.getValueAt(i, 16).toString());

					 }
					 
					gnt.setText(Integer.toString(sum));
					bt.setText(Integer.toString(sum1));
					
				}
			});
			btnNewButton.setBounds(10, 164, 149, 31);
			contentPane.add(btnNewButton);
			
			JButton btnDataByDate = new JButton("DATA BY DATE");
			btnDataByDate.addActionListener(new ActionListener() {
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
						String memo=(((JTextField) dateChooser1.getDateEditor().getUiComponent()).getText());
						ps=conn.prepareStatement("select * from purchase where memo='"+memo+"'");
						rs=ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
				}
			});
			btnDataByDate.setBounds(327, 164, 149, 31);
			contentPane.add(btnDataByDate);
			
			JButton btnByBillNo = new JButton("BY BILL NO");
			btnByBillNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					String bno=bn.getText();
					try
					{
						String url="jdbc:mysql://localhost:3306/zenter";
						String username="root";
						String pass="rizz";
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection  conn=DriverManager.getConnection(url,username,pass);
						PreparedStatement ps;
						ResultSet rs;
						ps=conn.prepareStatement("select * from purchase where bno='"+bno+"'");
						rs=ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					int sum=0,sum1=0;
					 
					 for(int i=0; i<table.getRowCount();i++)
					 {
						 sum=sum+Integer.parseInt(table.getValueAt(i, 14).toString());
						 sum1=sum1+Integer.parseInt(table.getValueAt(i, 16).toString());

					 }
					 
					gnt.setText(Integer.toString(sum));
					bt.setText(Integer.toString(sum1));
				}
			});
			btnByBillNo.setBounds(1113, 164, 149, 31);
			contentPane.add(btnByBillNo);
			
			JButton btnBySeason = new JButton("BY SEASON");
			btnBySeason.addActionListener(new ActionListener() {
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
						String mem1=(((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText());
						String mem2=(((JTextField) dateChooser_2.getDateEditor().getUiComponent()).getText());
						ps=conn.prepareStatement("select * from purchase where memo between '"+mem1+"'and '"+mem2+"'");
						rs=ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					int sum=0,sum1=0;
					 
					 for(int i=0; i<table.getRowCount();i++)
					 {
						 sum=sum+Integer.parseInt(table.getValueAt(i, 14).toString());
						 sum1=sum1+Integer.parseInt(table.getValueAt(i, 16).toString());

					 }
					 
					gnt.setText(Integer.toString(sum));
					bt.setText(Integer.toString(sum1));
				}
			});
			btnBySeason.setBounds(833, 164, 149, 31);
			contentPane.add(btnBySeason);
			
			bn = new JTextField();
			bn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			bn.setBackground(Color.BLACK);
			bn.setForeground(Color.YELLOW);
			bn.setBounds(1040, 164, 63, 31);
			contentPane.add(bn);
			bn.setColumns(10);
			
			JLabel lblNewLabel_1_6_2 = new JLabel("GRAND NET TOTAL");
			lblNewLabel_1_6_2.setForeground(Color.RED);
			lblNewLabel_1_6_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_1_6_2.setBounds(662, 568, 132, 22);
			contentPane.add(lblNewLabel_1_6_2);
			
			gnt = new JTextField();
			gnt.setForeground(SystemColor.textHighlight);
			gnt.setFont(new Font("Tahoma", Font.ITALIC, 14));
			gnt.setEditable(false);
			gnt.setColumns(10);
			gnt.setBackground(Color.WHITE);
			gnt.setBounds(804, 560, 147, 30);
			contentPane.add(gnt);
			
			JLabel lblNewLabel_1_6_1 = new JLabel("BALANCE TOTAL");
			lblNewLabel_1_6_1.setForeground(Color.RED);
			lblNewLabel_1_6_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblNewLabel_1_6_1.setBounds(972, 568, 104, 22);
			contentPane.add(lblNewLabel_1_6_1);
			
			bt = new JTextField();
			bt.setForeground(SystemColor.textHighlight);
			bt.setFont(new Font("Tahoma", Font.ITALIC, 14));
			bt.setEditable(false);
			bt.setColumns(10);
			bt.setBackground(Color.WHITE);
			bt.setBounds(1086, 560, 147, 30);
			contentPane.add(bt);
			
		
		
		
	}
	public JDateChooser getDateChooser() {
		return getDateChooser();
	}
}

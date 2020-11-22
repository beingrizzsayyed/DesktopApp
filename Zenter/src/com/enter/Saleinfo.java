package com.enter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

public class Saleinfo extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField bn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Saleinfo frame = new Saleinfo();
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
	public Saleinfo() {
		setTitle("SALE INFORMATION");
		setResizable(true);
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setBounds(100, 100, 1359, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		panel.setBounds(10, 11, 1323, 103);
		contentPane.add(panel);
		
		JTextPane txtpnPurchaseInformation = new JTextPane();
		txtpnPurchaseInformation.setText("SALE INFORMATION ");
		txtpnPurchaseInformation.setForeground(Color.WHITE);
		txtpnPurchaseInformation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		txtpnPurchaseInformation.setEditable(false);
		txtpnPurchaseInformation.setBackground(Color.CYAN);
		txtpnPurchaseInformation.setBounds(554, 11, 220, 31);
		panel.add(txtpnPurchaseInformation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 1323, 310);
		contentPane.add(scrollPane);
		
	
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"BILL NUMBER", "PARTY CODE", "PARTY NAME",  "QUANTITY", "ITEM", "TOTAL", "SLT FEE", "EMERGENCY", "JAUNDICE", "RENT", "NET WEIGHT", "ADVANCE", "NET TOTAL", "DATE","BALANCE","NARRATION"
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
		dateChooser_1.setBounds(577, 164, 127, 25);
		contentPane.add(dateChooser_1);
		dateChooser_1.setDateFormatString("YYYY-MM-dd");
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(748, 164, 127, 25);
		contentPane.add(dateChooser_2);
		dateChooser_2.setDateFormatString("YYYY-MM-dd");
		
		JTextPane txtpnTo = new JTextPane();
		txtpnTo.setText("TO");
		txtpnTo.setBounds(714, 164, 20, 20);
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
						ps=conn.prepareStatement("select * from sale");
						rs=ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					
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
						ps=conn.prepareStatement("select * from sale where memo='"+memo+"'");
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
						ps=conn.prepareStatement("select * from sale where bno='"+bno+"'");
						rs=ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
				}
			});
			btnByBillNo.setBounds(1184, 164, 149, 31);
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
						ps=conn.prepareStatement("select * from sale where memo between '"+mem1+"'and '"+mem2+"'");
						rs=ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
				}
			});
			btnBySeason.setBounds(885, 164, 149, 31);
			contentPane.add(btnBySeason);
			
			bn = new JTextField();
			bn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			bn.setBackground(Color.BLACK);
			bn.setForeground(Color.YELLOW);
			bn.setBounds(1111, 164, 63, 31);
			contentPane.add(bn);
			bn.setColumns(10);
	}
	public JDateChooser getDateChooser() {
		return getDateChooser();
	}
}

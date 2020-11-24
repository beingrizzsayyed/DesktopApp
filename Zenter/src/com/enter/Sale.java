package com.enter;



import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;

public class Sale extends JInternalFrame {

	public static JTextField qnt;
	public static JTextField itm;
	public static JTextField sb;
	public static JTextField weight;
	public static JTextField less;
	public static JTextField netwet;
	public static JTextField rate;
	public static JTextField ammt;
	public static JTextField pcode;
	public static JTextField pcon;
	public static JTextField padd;
	public static JTextField cname;
	public static JTextField sltfee;
	public static JTextField emergency;
	public static JTextField rent;
	public static JTextField total;
	public static JTextField advance;
	public static JTextField nettotal;
	public static JTextField netweight;
	public static JTextField jdiss;
	public static JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sale frame = new Sale();
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
	public Sale() {
		setMaximizable(true);
		setIconifiable(true);
		setTitle("SALE");
		setResizable(true);
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setBounds(100, 100, 1286, 743);
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane);
		setBounds(100, 100, 1304, 739);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(SystemColor.scrollbar);
		panel_1.setBounds(10, 272, 896, 215);
		desktopPane.add(panel_1);
		
		JLabel lblPurchaseInfo = new JLabel("Sale Info :-");
		lblPurchaseInfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblPurchaseInfo.setBounds(10, 11, 126, 14);
		panel_1.add(lblPurchaseInfo);
		
		JLabel quantity = new JLabel("Quantity");
		quantity.setForeground(Color.WHITE);
		quantity.setFont(new Font("Tahoma", Font.ITALIC, 15));
		quantity.setBounds(10, 46, 80, 22);
		panel_1.add(quantity);
		
		qnt = new JTextField();
		qnt.setFont(new Font("Tahoma", Font.ITALIC, 15));
		qnt.setColumns(10);
		qnt.setBounds(96, 49, 86, 27);
		panel_1.add(qnt);
		
		JLabel item = new JLabel("Item");
		item.setForeground(Color.WHITE);
		item.setFont(new Font("Tahoma", Font.ITALIC, 15));
		item.setBounds(285, 46, 80, 22);
		panel_1.add(item);
		
		itm = new JTextField();
		itm.setFont(new Font("Tahoma", Font.ITALIC, 15));
		itm.setColumns(10);
		itm.setBounds(356, 49, 86, 27);
		panel_1.add(itm);
		
		JLabel sbl = new JLabel("Sale Bill No");
		sbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		sbl.setBounds(512, 23, 96, 14);
		panel_1.add(sbl);
		
		sb = new JTextField();
		sb.setForeground(Color.YELLOW);
		sb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		sb.setEditable(false);
		sb.setColumns(10);
		sb.setBackground(Color.BLACK);
		sb.setBounds(621, 10, 80, 38);
		panel_1.add(sb);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setForeground(Color.DARK_GRAY);
		lblWeight.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblWeight.setBounds(98, 104, 80, 22);
		panel_1.add(lblWeight);
		
		weight = new JTextField();
		weight.setFont(new Font("Tahoma", Font.ITALIC, 15));
		weight.setColumns(10);
		weight.setBounds(82, 137, 96, 27);
		panel_1.add(weight);
		
		JLabel lblLess = new JLabel("Less");
		lblLess.setForeground(Color.DARK_GRAY);
		lblLess.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLess.setBounds(209, 104, 80, 22);
		panel_1.add(lblLess);
		
		JLabel lblNetWeight = new JLabel("Net Weight");
		lblNetWeight.setForeground(Color.DARK_GRAY);
		lblNetWeight.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNetWeight.setBounds(343, 104, 80, 22);
		panel_1.add(lblNetWeight);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setForeground(Color.DARK_GRAY);
		lblRate.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblRate.setBounds(508, 104, 80, 22);
		panel_1.add(lblRate);
		
		JLabel lblAmmount = new JLabel("Ammount");
		lblAmmount.setForeground(Color.DARK_GRAY);
		lblAmmount.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblAmmount.setBounds(617, 104, 80, 22);
		panel_1.add(lblAmmount);
		
		less = new JTextField();
		less.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
				int w=Integer.parseInt(weight.getText());
				int l=Integer.parseInt(less.getText());
				int nw= w-l;
				netwet.setText(String.valueOf(nw));
				try
				{
					String url="jdbc:mysql://localhost:3306/zenter";
					String username="root";
					String pass="rizz";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection  conn=DriverManager.getConnection(url,username,pass);
					PreparedStatement ps0;
					ResultSet rs0;
					ps0=conn.prepareStatement("select * from defs");
					rs0=ps0.executeQuery();
					if(rs0.next()== true)
					{
						String  sl =rs0.getString("slt");
						String  r1 =rs0.getString("rate75b");
						String  r2 =rs0.getString("rate90b");
						String  r3 =rs0.getString("rate90u");
						String  r4 =rs0.getString("rate100u");
						String  r5 =rs0.getString("rate125u");
						String  r6 =rs0.getString("rate140u");
						String  r7 =rs0.getString("rate150u");
						String  r8 =rs0.getString("rate175u");
						String  r9 =rs0.getString("rate200u");
						String  r10 =rs0.getString("rate225u");
						String  r11=rs0.getString("rate250u");
					
					
							if(w<=75)
							{
								rate.setText(String.valueOf(r1));
							}
							
							else
							if(w>75 && w<=90)
							{
								rate.setText(String.valueOf(r2));
							}
								
							else
							if(w>90 && w<=100)
							{
								rate.setText(String.valueOf(r3));
							}
							
							else
							if(w>100 && w<=125)
							{
								rate.setText(String.valueOf(r4));
							}
							
							else
							if(w>125 && w<=140)
							{
								rate.setText(String.valueOf(r5));
							}
							
							else
							if(w>140 && w<=150)
							{
								rate.setText(String.valueOf(r6));
							}
							
							else
							if(w>150 && w<=175)
							{
								rate.setText(String.valueOf(r7));
							}
							
							else
							if(w>175 && w<=200)
							{
								rate.setText(String.valueOf(r8));
							}
							
							else
							if(w>200 && w<=225)
							{
								rate.setText(String.valueOf(r9));
							}
							
							else
							if(w>225 && w<=250)
							{
								rate.setText(String.valueOf(r10));
							}
							
							else
							if(w>=250 )
							{
								rate.setText(String.valueOf(r11));
							}
							
						
					int r=Integer.parseInt(rate.getText());
					int am=nw * r;
					ammt.setText(String.valueOf(am));
					int q=Integer.parseInt(qnt.getText());
					int s=Integer.parseInt(sl.toString());
					int sf=q*s;
					sltfee.setText(String.valueOf(sf));
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
				}
			}
		});
		less.setFont(new Font("Tahoma", Font.ITALIC, 15));
		less.setColumns(10);
		less.setBounds(209, 137, 86, 27);
		panel_1.add(less);
		
		netwet = new JTextField();
		netwet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		netwet.setEditable(false);
		netwet.setColumns(10);
		netwet.setBackground(Color.WHITE);
		netwet.setBounds(332, 137, 106, 27);
		panel_1.add(netwet);
		
		rate = new JTextField();
		rate.setFont(new Font("Tahoma", Font.ITALIC, 15));
		rate.setEditable(false);
		rate.setColumns(10);
		rate.setBackground(Color.WHITE);
		rate.setBounds(482, 137, 106, 27);
		panel_1.add(rate);
		
		ammt = new JTextField();
		ammt.setFont(new Font("Tahoma", Font.ITALIC, 15));
		ammt.setEditable(false);
		ammt.setColumns(10);
		ammt.setBackground(Color.WHITE);
		ammt.setBounds(617, 137, 137, 27);
		panel_1.add(ammt);
		
		JButton add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DefaultTableModel model=new DefaultTableModel();
				model = (DefaultTableModel)table.getModel();
				model.addRow(new Object[]
				{
						
						weight.getText(),
						less.getText(),
						netwet.getText(),
						rate.getText(),
						ammt.getText(),
				}
						);
				
				weight.setText("");
				less.setText("");
				netwet.setText("");
				rate.setText("");
				ammt.setText("");
				 int sum=0,sum1=0;
				 
				 for(int i=0; i<table.getRowCount();i++)
				 {
					 sum=sum+Integer.parseInt(table.getValueAt(i, 2).toString());
					 sum1=sum1+Integer.parseInt(table.getValueAt(i, 4).toString());
				 }
				 
				total.setText(Integer.toString(sum1));
				netweight.setText(Integer.toString(sum));
				table.selectAll();
			}
		});
		add.setBackground(SystemColor.activeCaption);
		add.setBounds(790, 177, 96, 27);
		panel_1.add(add);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(10, 11, 896, 233);
		desktopPane.add(panel);
		
		JLabel lblPartyInfo = new JLabel("Party Info :-");
		lblPartyInfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblPartyInfo.setBounds(10, 11, 98, 14);
		panel.add(lblPartyInfo);
		
		JLabel lblPartyCode = new JLabel("Party Code");
		lblPartyCode.setForeground(Color.WHITE);
		lblPartyCode.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblPartyCode.setBounds(10, 89, 80, 22);
		panel.add(lblPartyCode);
		
		pcode = new JTextField();
		pcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e)
			{
				try
				{
				String url="jdbc:mysql://localhost:3306/zenter";
				String username="root";
				String pass="rizz";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection  conn=DriverManager.getConnection(url,username,pass);
					PreparedStatement ps,ps1;
					ResultSet rs,rs1;
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					String  sc =pcode.getText();
					ps=conn.prepareStatement("select * from party_info where pcode=?");
					ps.setString(1,sc);
					rs=ps.executeQuery();
					if(rs.next()== true)
					{
						String  comp =rs.getString("company");
						String  cont=rs.getString("contact");
						String  addr=rs.getString("addr");
						
						pcon.setText(cont.trim());
						padd.setText(addr.trim());
						cname.setText(comp.trim());
					
					}
					else
					{
						JOptionPane.showMessageDialog(pcode, "THIS PARTY IS NOT AVAILABLE");
					}
					int bno=0;
					ps1=conn.prepareStatement("SELECT * FROM sale WHERE bno=(SELECT max(bno) FROM sale);");
					rs1=ps1.executeQuery();
					if(rs1.next())
						bno=rs1.getInt("bno");
					bno=bno+1;
					sb.setText(String.valueOf(bno));
				}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		pcode.setForeground(Color.YELLOW);
		pcode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		pcode.setColumns(10);
		pcode.setBackground(Color.BLACK);
		pcode.setBounds(110, 86, 173, 30);
		panel.add(pcode);
		
		JLabel sphonet = new JLabel("Party Contact");
		sphonet.setForeground(Color.WHITE);
		sphonet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		sphonet.setBounds(10, 143, 122, 22);
		panel.add(sphonet);
		
		JLabel saddresst = new JLabel("Party Address");
		saddresst.setForeground(Color.WHITE);
		saddresst.setFont(new Font("Tahoma", Font.ITALIC, 15));
		saddresst.setBounds(363, 195, 122, 22);
		panel.add(saddresst);
		
		JLabel scomt = new JLabel("Company Name");
		scomt.setForeground(Color.WHITE);
		scomt.setFont(new Font("Tahoma", Font.ITALIC, 15));
		scomt.setBounds(343, 94, 122, 22);
		panel.add(scomt);
		
		JLabel date = new JLabel("Date");
		date.setForeground(Color.BLACK);
		date.setFont(new Font("Tahoma", Font.ITALIC, 15));
		date.setBounds(674, 15, 80, 22);
		panel.add(date);
		
		pcon = new JTextField();
		pcon.setBackground(Color.WHITE);
		pcon.setEditable(false);
		pcon.setFont(new Font("Tahoma", Font.ITALIC, 15));
		pcon.setColumns(10);
		pcon.setBounds(111, 140, 232, 30);
		panel.add(pcon);
		
		padd = new JTextField();
		padd.setBackground(Color.WHITE);
		padd.setEditable(false);
		padd.setFont(new Font("Tahoma", Font.ITALIC, 15));
		padd.setColumns(10);
		padd.setBounds(497, 190, 369, 32);
		panel.add(padd);
		
		cname = new JTextField();
		cname.setBackground(Color.WHITE);
		cname.setEditable(false);
		cname.setFont(new Font("Tahoma", Font.ITALIC, 15));
		cname.setColumns(10);
		cname.setBounds(497, 91, 369, 30);
		panel.add(cname);
		
		Calendar cal=new GregorianCalendar();
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		
		JLabel lblNewLabel_2 = new JLabel(day+"/"+month+"/"+year);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(764, 11, 122, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblMemoDate = new JLabel("Memo Date");
		lblMemoDate.setForeground(Color.BLACK);
		lblMemoDate.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblMemoDate.setBounds(654, 52, 80, 22);
		panel.add(lblMemoDate);
		
		JDateChooser mdate = new JDateChooser();
		mdate.setBounds(744, 48, 122, 32);
		panel.add(mdate);
		mdate.setDateFormatString("YYYY-MM-dd");
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(931, 11, 332, 686);
		desktopPane.add(panel_2_1);
		
		JLabel lblSltFee_1 = new JLabel("SLT fee");
		lblSltFee_1.setForeground(Color.BLACK);
		lblSltFee_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblSltFee_1.setBounds(10, 93, 90, 32);
		panel_2_1.add(lblSltFee_1);
		
		JLabel lblEmergency_1 = new JLabel("Emergency");
		lblEmergency_1.setForeground(Color.BLACK);
		lblEmergency_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblEmergency_1.setBounds(10, 176, 80, 22);
		panel_2_1.add(lblEmergency_1);
		
		JLabel lblRent_1 = new JLabel("RENT");
		lblRent_1.setForeground(Color.BLACK);
		lblRent_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblRent_1.setBounds(10, 334, 80, 22);
		panel_2_1.add(lblRent_1);
		
		JLabel lblTotal_1 = new JLabel("TOTAL");
		lblTotal_1.setForeground(Color.RED);
		lblTotal_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTotal_1.setBounds(10, 27, 80, 24);
		panel_2_1.add(lblTotal_1);
		
		JLabel lblAdvance_1 = new JLabel("ADVANCE");
		lblAdvance_1.setForeground(Color.BLACK);
		lblAdvance_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblAdvance_1.setBounds(10, 498, 80, 22);
		panel_2_1.add(lblAdvance_1);
		
		JLabel lblNetTotal_1 = new JLabel("NET TOTAL");
		lblNetTotal_1.setForeground(Color.RED);
		lblNetTotal_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNetTotal_1.setBounds(10, 578, 90, 22);
		panel_2_1.add(lblNetTotal_1);
		
		sltfee = new JTextField();
		sltfee.setFont(new Font("Tahoma", Font.ITALIC, 15));
		sltfee.setEditable(false);
		sltfee.setColumns(10);
		sltfee.setBackground(Color.WHITE);
		sltfee.setBounds(126, 93, 141, 32);
		panel_2_1.add(sltfee);
		
		emergency = new JTextField();
		emergency.setFont(new Font("Tahoma", Font.ITALIC, 15));
		emergency.setColumns(10);
		emergency.setBounds(126, 173, 141, 32);
		panel_2_1.add(emergency);
		
		rent = new JTextField();
		rent.setFont(new Font("Tahoma", Font.ITALIC, 15));
		rent.setColumns(10);
		rent.setBounds(126, 331, 141, 32);
		panel_2_1.add(rent);
		
		total = new JTextField();
		total.setForeground(SystemColor.textHighlight);
		total.setFont(new Font("Tahoma", Font.ITALIC, 15));
		total.setEditable(false);
		total.setColumns(10);
		total.setBackground(Color.WHITE);
		total.setBounds(126, 22, 141, 29);
		panel_2_1.add(total);
		
		advance = new JTextField();
		advance.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					int s=Integer.parseInt(sltfee.getText());
					int em=Integer.parseInt(emergency.getText());
					int rnt=Integer.parseInt(rent.getText());
					int t=Integer.parseInt(total.getText());
					int adv=Integer.parseInt(advance.getText());
					int jd=Integer.parseInt(jdiss.getText());
					int nt1=t;
					int nt2=adv+jd+s+em+rnt;
					int ntf=nt1-nt2;
					nettotal.setText(String.valueOf(ntf));
				}

			}
		});
		advance.setFont(new Font("Tahoma", Font.ITALIC, 15));
		advance.setColumns(10);
		advance.setBounds(126, 495, 141, 32);
		panel_2_1.add(advance);
		
		nettotal = new JTextField();
		nettotal.setForeground(SystemColor.textHighlight);
		nettotal.setFont(new Font("Tahoma", Font.ITALIC, 15));
		nettotal.setEditable(false);
		nettotal.setColumns(10);
		nettotal.setBackground(Color.WHITE);
		nettotal.setBounds(126, 575, 141, 32);
		panel_2_1.add(nettotal);
		
		JButton btnNewButton_1 = new JButton("BILL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String s=sb.getText();
					String pc=pcode.getText();
					String pn=cname.getText();
					String qn=qnt.getText();
					String it=itm.getText();
					String tot=total.getText();
					String sf=sltfee.getText();
					String em=emergency.getText();
					String jd=jdiss.getText();
					String rnt=rent.getText();
					String nw=netweight.getText();
					String ad=advance.getText();
					String ntot=nettotal.getText();
					String memo=mdate.getDateFormatString();
					String narat=null;
					
					String url="jdbc:mysql://localhost:3306/zenter";
					String username="root";
					String pass="rizz";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection  conn=DriverManager.getConnection(url,username,pass);
					PreparedStatement ps1;
					ps1=conn.prepareStatement("insert into sale values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					ps1.setString(1,s);
					ps1.setString(2,pc);
					ps1.setString(3,pn);
					ps1.setString(4,qn);
					ps1.setString(5,it);
					ps1.setString(6,tot);
					ps1.setString(7,sf);
					ps1.setString(8,em);
					ps1.setString(9,jd);
					ps1.setString(10,rnt);
					ps1.setString(11,nw);
					ps1.setString(12,ad);
					ps1.setString(13,ntot);
					ps1.setString(14,(((JTextField) mdate.getDateEditor().getUiComponent()).getText()));
					ps1.setString(15,ntot);
					ps1.setString(16,narat);
					ps1.executeLargeUpdate();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				
				Salebill sbt = new Salebill();
				desktopPane.add(sbt);
				sbt.setVisible(true);
				sbt.pb0.setText(sb.getText());
				sbt.sc.setText(pcode.getText());
				sbt.sn.setText(cname.getText());
				sbt.scon.setText(pcon.getText());
				sbt.sadd.setText(padd.getText());
				sbt.sf.setText(sltfee.getText());
				sbt.emer.setText(emergency.getText());
				sbt.jdiss.setText(jdiss.getText());
				sbt.rnt.setText(rent.getText());
				sbt.adv.setText(advance.getText());
				sbt.nw.setText(netweight.getText());
				sbt.tot.setText(total.getText());
				sbt.nt.setText(nettotal.getText());
				sbt.qnt.setText(qnt.getText());
				sbt.itm.setText(itm.getText());
				
				TableModel model=table.getModel();
				int indexs[]=table.getSelectedRows();
				Object[] row=new Object[5];
				DefaultTableModel model1=new DefaultTableModel();
				model1 = (DefaultTableModel)sbt.table1.getModel();
				for(int i=0;i<indexs.length;i++)
				{
					row[0]=model.getValueAt(indexs[i],0);
					row[1]=model.getValueAt(indexs[i],1);
					row[2]=model.getValueAt(indexs[i],2);
					row[3]=model.getValueAt(indexs[i],3);
					row[4]=model.getValueAt(indexs[i],4);
					model1.addRow(row);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(126, 634, 141, 44);
		panel_2_1.add(btnNewButton_1);
		
		netweight = new JTextField();
		netweight.setForeground(SystemColor.textHighlight);
		netweight.setFont(new Font("Tahoma", Font.ITALIC, 15));
		netweight.setEditable(false);
		netweight.setColumns(10);
		netweight.setBackground(Color.WHITE);
		netweight.setBounds(126, 414, 141, 32);
		panel_2_1.add(netweight);
		
		JLabel lblTotal_1_1 = new JLabel("NET WEIGHT");
		lblTotal_1_1.setForeground(Color.RED);
		lblTotal_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTotal_1_1.setBounds(10, 418, 80, 22);
		panel_2_1.add(lblTotal_1_1);
		
		jdiss = new JTextField();
		jdiss.setFont(new Font("Tahoma", Font.ITALIC, 15));
		jdiss.setColumns(10);
		jdiss.setBounds(126, 258, 141, 32);
		panel_2_1.add(jdiss);
		
		JLabel lblEmergency_1_1 = new JLabel("Jaundice");
		lblEmergency_1_1.setForeground(Color.BLACK);
		lblEmergency_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblEmergency_1_1.setBounds(10, 261, 80, 22);
		panel_2_1.add(lblEmergency_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("ELEMENTS :-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(10, 498, 94, 22);
		desktopPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 531, 892, 166);
		desktopPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"weight", "Less", "Net Weight", "Rate", "Ammount"
			}
		));
		table.setToolTipText("");
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFont(new Font("Tahoma", Font.ITALIC, 15));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setBackground(Color.WHITE);

	}

}

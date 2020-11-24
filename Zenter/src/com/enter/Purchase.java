package com.enter;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;

public class Purchase extends JInternalFrame {
	public static JTextField scode;
	public static JTextField sname;
	public static JTextField sphone;
	public static JTextField saddress;
	public static JTextField qnt;
	public static JTextField itm;
	public static JTextField sb;
	public static JTextField weight;
	public static JTextField less;
	public static JTextField netweight;
	public static JTextField rate;
	public static JTextField ammount;
	public static JTextField sltfee;
	public static JTextField comm;
	public static JTextField emergency;
	public static JTextField rent;
	public static JTextField total;
	public static JTextField advance;
	public static JTextField nettotal;
	private JTable table;
	private JLabel lblNewLabel_2;
	public static JTextField rel;
	public static JTextField mark;
	public static JTextField nwet;
	public static JTextField jdiss;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase frame = new Purchase();
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
	public Purchase() {
		setMaximizable(true);
		setIconifiable(true);
		setTitle("PURCHASE");
		setResizable(true);
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setBounds(100, 100, 1304, 788);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		desktopPane.setBackground(Color.WHITE);
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(10, 11, 896, 233);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saler Info :-");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(10, 11, 98, 14);
		panel.add(lblNewLabel);
		
		JLabel scodet = new JLabel("Seller Code");
		scodet.setForeground(Color.WHITE);
		scodet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		scodet.setBounds(10, 89, 80, 22);
		panel.add(scodet);
		
		scode = new JTextField();
		scode.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		scode.addKeyListener(new KeyAdapter() {
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
					String  sc =scode.getText();
					ps=conn.prepareStatement("select * from seller_info where scode=?");
					ps.setString(1,sc);
					rs=ps.executeQuery();
					if(rs.next()== true)
					{
						String  name =rs.getString("name");
						String  cont=rs.getString("contact");
						String  addr=rs.getString("addr");
						
						sname.setText(name.trim());
						sphone.setText(cont.trim());
						saddress.setText(addr.trim());
					
					}
					else
					{
						JOptionPane.showMessageDialog(scode, "THIS SELLER IS NOT AVAILABLE");
					}
					int bno=0;
					ps1=conn.prepareStatement("SELECT * FROM purchase WHERE bno=(SELECT max(bno) FROM purchase);");
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
		scode.setForeground(Color.YELLOW);
		scode.setBackground(Color.BLACK);
		scode.setBounds(100, 86, 173, 30);
		panel.add(scode);
		scode.setColumns(10);
		
		JLabel snamet = new JLabel("Seller Name");
		snamet.setForeground(Color.WHITE);
		snamet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		snamet.setBounds(10, 148, 80, 22);
		panel.add(snamet);
		
		JLabel sphonet = new JLabel("Seller Contact");
		sphonet.setForeground(Color.WHITE);
		sphonet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		sphonet.setBounds(10, 190, 80, 22);
		panel.add(sphonet);
		
		JLabel saddresst = new JLabel("Seller Address");
		saddresst.setForeground(Color.WHITE);
		saddresst.setFont(new Font("Tahoma", Font.ITALIC, 15));
		saddresst.setBounds(363, 195, 122, 22);
		panel.add(saddresst);
		
		JLabel date = new JLabel("Date");
		date.setForeground(Color.BLACK);
		date.setFont(new Font("Tahoma", Font.ITALIC, 15));
		date.setBounds(674, 15, 80, 22);
		panel.add(date);
		
		sname = new JTextField();
		sname.setBackground(Color.WHITE);
		sname.setEditable(false);
		sname.setFont(new Font("Tahoma", Font.ITALIC, 15));
		sname.setColumns(10);
		sname.setBounds(100, 145, 275, 30);
		panel.add(sname);
		
		sphone = new JTextField();
		sphone.setBackground(Color.WHITE);
		sphone.setEditable(false);
		sphone.setFont(new Font("Tahoma", Font.ITALIC, 15));
		sphone.setColumns(10);
		sphone.setBounds(100, 192, 232, 30);
		panel.add(sphone);
		
		saddress = new JTextField();
		saddress.setBackground(Color.WHITE);
		saddress.setEditable(false);
		saddress.setFont(new Font("Tahoma", Font.ITALIC, 15));
		saddress.setColumns(10);
		saddress.setBounds(497, 190, 369, 32);
		panel.add(saddress);
		
		Calendar cal=new GregorianCalendar();
		int day=cal.get(Calendar.DAY_OF_MONTH);
		int month=cal.get(Calendar.MONTH);
		int year=cal.get(Calendar.YEAR);
		
		 lblNewLabel_2 = new JLabel(day+"/"+month+"/"+year);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(764, 11, 122, 30);
		panel.add(lblNewLabel_2);
		
		rel = new JTextField();
		rel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		rel.setColumns(10);
		rel.setBounds(603, 138, 263, 32);
		panel.add(rel);
		
		JLabel lblRelSupplier = new JLabel("Rel Supplier");
		lblRelSupplier.setForeground(Color.WHITE);
		lblRelSupplier.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblRelSupplier.setBounds(513, 145, 80, 22);
		panel.add(lblRelSupplier);
		
		JLabel lblMemoDate = new JLabel("Memo Date");
		lblMemoDate.setForeground(Color.BLACK);
		lblMemoDate.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblMemoDate.setBounds(654, 52, 80, 22);
		panel.add(lblMemoDate);
		
		JDateChooser mdate = new JDateChooser();
		mdate.setBounds(744, 48, 122, 32);
		panel.add(mdate);
		mdate.setDateFormatString("YYYY-MM-dd");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBackground(SystemColor.scrollbar);
		panel_1.setBounds(10, 266, 896, 215);
		desktopPane.add(panel_1);
		
		JLabel lblPurchaseInfo = new JLabel("Purchase Info :-");
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
		qnt.setBounds(96, 49, 86, 27);
		panel_1.add(qnt);
		qnt.setColumns(10);
		
		JLabel item = new JLabel("Item");
		item.setForeground(Color.WHITE);
		item.setFont(new Font("Tahoma", Font.ITALIC, 15));
		item.setBounds(285, 46, 80, 22);
		panel_1.add(item);
		
		itm = new JTextField();
		itm.setFont(new Font("Tahoma", Font.ITALIC, 15));
		itm.setBounds(356, 49, 86, 27);
		panel_1.add(itm);
		itm.setColumns(10);
		
		JLabel sbl = new JLabel("Purchase Bill No");
		sbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		sbl.setBounds(475, 23, 133, 14);
		panel_1.add(sbl);
		
		sb = new JTextField();
		sb.setEditable(false);
		sb.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		sb.setBackground(Color.BLACK);
		sb.setForeground(Color.YELLOW);
		sb.setBounds(621, 10, 80, 38);
		panel_1.add(sb);
		sb.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setForeground(Color.DARK_GRAY);
		lblWeight.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblWeight.setBounds(230, 105, 80, 22);
		panel_1.add(lblWeight);
		
		weight = new JTextField();
		weight.setFont(new Font("Tahoma", Font.ITALIC, 15));
		weight.setBounds(214, 138, 96, 27);
		panel_1.add(weight);
		weight.setColumns(10);
		
		JLabel lblLess = new JLabel("Less");
		lblLess.setForeground(Color.DARK_GRAY);
		lblLess.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblLess.setBounds(341, 105, 80, 22);
		panel_1.add(lblLess);
		
		JLabel lblNetWeight = new JLabel("Net Weight");
		lblNetWeight.setForeground(Color.DARK_GRAY);
		lblNetWeight.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNetWeight.setBounds(475, 105, 80, 22);
		panel_1.add(lblNetWeight);
		
		JLabel lblRate = new JLabel("Rate");
		lblRate.setForeground(Color.DARK_GRAY);
		lblRate.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblRate.setBounds(640, 105, 80, 22);
		panel_1.add(lblRate);
		
		JLabel lblAmmount = new JLabel("Ammount");
		lblAmmount.setForeground(Color.DARK_GRAY);
		lblAmmount.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblAmmount.setBounds(749, 105, 80, 22);
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
				netweight.setText(String.valueOf(nw));
				try
				{
					String url="jdbc:mysql://localhost:3306/zenter";
					String username="root";
					String pass="rizz";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection  conn=DriverManager.getConnection(url,username,pass);
					PreparedStatement ps0;
					ResultSet rs0;
					ps0=conn.prepareStatement("select * from def");
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
					ammount.setText(String.valueOf(am));
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
		less.setBounds(341, 138, 86, 27);
		panel_1.add(less);
		less.setColumns(10);
		
		netweight = new JTextField();
		netweight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				
			}
		});
		netweight.setBackground(Color.WHITE);
		netweight.setEditable(false);
		netweight.setFont(new Font("Tahoma", Font.ITALIC, 15));
		netweight.setBounds(464, 138, 106, 27);
		panel_1.add(netweight);
		netweight.setColumns(10);
		
		rate = new JTextField();
		rate.setEditable(false);
		rate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		rate.setBackground(Color.WHITE);
		rate.setFont(new Font("Tahoma", Font.ITALIC, 15));
		rate.setBounds(614, 138, 106, 27);
		panel_1.add(rate);
		rate.setColumns(10);
		
		ammount = new JTextField();
		ammount.setBackground(Color.WHITE);
		ammount.setEditable(false);
		ammount.setFont(new Font("Tahoma", Font.ITALIC, 15));
		ammount.setBounds(749, 138, 137, 27);
		panel_1.add(ammount);
		ammount.setColumns(10);
		
		JButton add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
			
				DefaultTableModel model=new DefaultTableModel();
				model = (DefaultTableModel)table.getModel();
				model.addRow(new Object[]
				{
						mark.getText(),
						weight.getText(),
						less.getText(),
						netweight.getText(),
						rate.getText(),
						ammount.getText(),
				}
						);
				
				mark.setText("");
				weight.setText("");
				less.setText("");
				netweight.setText("");
				rate.setText("");
				ammount.setText("");
				
				
				 int sum=0,sum1=0;
				 
				 for(int i=0; i<table.getRowCount();i++)
				 {
					 sum=sum+Integer.parseInt(table.getValueAt(i, 5).toString());
					 sum1=sum1+Integer.parseInt(table.getValueAt(i, 3).toString());
				 }
				 
				total.setText(Integer.toString(sum));
				nwet.setText(Integer.toString(sum1));
				try
				{
					String url="jdbc:mysql://localhost:3306/zenter";
					String username="root";
					String pass="rizz";
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection  conn=DriverManager.getConnection(url,username,pass);
					PreparedStatement ps0;
					ResultSet rs0;
					ps0=conn.prepareStatement("select * from def");
					rs0=ps0.executeQuery();
					if(rs0.next()== true)
					{
						String  c =rs0.getString("comm");
					
				int n0=Integer.parseInt(nwet.getText());
				int c0=Integer.parseInt(c.toString());
				int f0=n0*c0;
				comm.setText(String.valueOf(f0));
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				table.selectAll();
			}
		});
		add.setBackground(SystemColor.activeCaption);
		add.setBounds(749, 177, 96, 27);
		panel_1.add(add);
		
		mark = new JTextField();
		mark.setFont(new Font("Tahoma", Font.ITALIC, 15));
		mark.setColumns(10);
		mark.setBounds(96, 138, 96, 27);
		panel_1.add(mark);
		
		JLabel markt = new JLabel("Mark");
		markt.setForeground(Color.DARK_GRAY);
		markt.setFont(new Font("Tahoma", Font.ITALIC, 15));
		markt.setBounds(96, 105, 80, 22);
		panel_1.add(markt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setBounds(10, 525, 896, 172);
		desktopPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "MARK","WEIGHT", "LESS", "NET WEIGHT", "RATE", "AMMOUNT"
			}
		));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setSurrendersFocusOnKeystroke(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setFont(new Font("Tahoma", Font.ITALIC, 15));
		table.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("ELEMENTS :-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(10, 492, 94, 22);
		desktopPane.add(lblNewLabel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(936, 11, 332, 686);
		desktopPane.add(panel_2_1);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		
		JLabel lblSltFee_1 = new JLabel("SLT fee");
		lblSltFee_1.setForeground(Color.BLACK);
		lblSltFee_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblSltFee_1.setBounds(10, 113, 90, 32);
		panel_2_1.add(lblSltFee_1);
		
		JLabel lblComm_1 = new JLabel("COMM");
		lblComm_1.setForeground(Color.BLACK);
		lblComm_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblComm_1.setBounds(10, 180, 80, 22);
		panel_2_1.add(lblComm_1);
		
		JLabel lblEmergency_1 = new JLabel("Emergency");
		lblEmergency_1.setForeground(Color.BLACK);
		lblEmergency_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblEmergency_1.setBounds(10, 242, 80, 22);
		panel_2_1.add(lblEmergency_1);
		
		JLabel lblRent_1 = new JLabel("Rent");
		lblRent_1.setForeground(Color.BLACK);
		lblRent_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblRent_1.setBounds(10, 376, 80, 22);
		panel_2_1.add(lblRent_1);
		
		JLabel lblTotal_1 = new JLabel("TOTAL");
		lblTotal_1.setForeground(Color.RED);
		lblTotal_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTotal_1.setBounds(10, 46, 80, 22);
		panel_2_1.add(lblTotal_1);
		
		JLabel lblAdvance_1 = new JLabel("ADVANCE");
		lblAdvance_1.setForeground(Color.BLACK);
		lblAdvance_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblAdvance_1.setBounds(10, 512, 80, 22);
		panel_2_1.add(lblAdvance_1);
		
		JLabel lblNetTotal_1 = new JLabel("NET TOTAL");
		lblNetTotal_1.setForeground(Color.RED);
		lblNetTotal_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNetTotal_1.setBounds(10, 578, 90, 22);
		panel_2_1.add(lblNetTotal_1);
		
		sltfee = new JTextField();
		sltfee.setBackground(Color.WHITE);
		sltfee.setEditable(false);
		sltfee.setFont(new Font("Tahoma", Font.ITALIC, 15));
		sltfee.setColumns(10);
		sltfee.setBounds(126, 113, 141, 32);
		panel_2_1.add(sltfee);
		
		comm = new JTextField();
		comm.setBackground(Color.WHITE);
		comm.setEditable(false);
		comm.setFont(new Font("Tahoma", Font.ITALIC, 15));
		comm.setColumns(10);
		comm.setBounds(126, 177, 141, 32);
		panel_2_1.add(comm);
		
		emergency = new JTextField();
		emergency.setFont(new Font("Tahoma", Font.ITALIC, 15));
		emergency.setColumns(10);
		emergency.setBounds(126, 239, 141, 32);
		panel_2_1.add(emergency);
		
		rent = new JTextField();
		rent.setFont(new Font("Tahoma", Font.ITALIC, 15));
		rent.setColumns(10);
		rent.setBounds(126, 373, 141, 32);
		panel_2_1.add(rent);
		
		total = new JTextField();
		total.setForeground(SystemColor.textHighlight);
		total.setBackground(Color.WHITE);
		total.setEditable(false);
		total.setFont(new Font("Tahoma", Font.ITALIC, 15));
		total.setColumns(10);
		total.setBounds(126, 41, 141, 32);
		panel_2_1.add(total);
		
		advance = new JTextField();
		advance.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
					int s=Integer.parseInt(sltfee.getText());
					int c=Integer.parseInt(comm.getText());
					int em=Integer.parseInt(emergency.getText());
					int rnt=Integer.parseInt(rent.getText());
					int t=Integer.parseInt(total.getText());
					int adv=Integer.parseInt(advance.getText());
					int jd=Integer.parseInt(jdiss.getText());
					int nt1=t;
					int nt2=adv+rnt+jd+s+c+em;
					int ntf=nt1-nt2;
					nettotal.setText(String.valueOf(ntf));
				}
			}
		});
		advance.setFont(new Font("Tahoma", Font.ITALIC, 15));
		advance.setColumns(10);
		advance.setBounds(126, 509, 141, 32);
		panel_2_1.add(advance);
		
		nettotal = new JTextField();
		nettotal.setForeground(SystemColor.textHighlight);
		nettotal.setBackground(Color.WHITE);
		nettotal.setEditable(false);
		nettotal.setFont(new Font("Tahoma", Font.ITALIC, 15));
		nettotal.setColumns(10);
		nettotal.setBounds(126, 575, 141, 32);
		panel_2_1.add(nettotal);
		
		JButton btnNewButton_1 = new JButton("BILL");
		btnNewButton_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String s=sb.getText();
					String sc=scode.getText();
					String sn=sname.getText();
					String rs=rel.getText();
					String qn=qnt.getText();
					String it=itm.getText();
					String tot=total.getText();
					String sf=sltfee.getText();
					String em=emergency.getText();
					String cm=comm.getText();
					String jd=jdiss.getText();
					String rnt=rent.getText();
					String nw=nwet.getText();
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
					ps1=conn.prepareStatement("insert into purchase values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					ps1.setString(1,s);
					ps1.setString(2,sc);
					ps1.setString(3,sn);
					ps1.setString(4,rs);
					ps1.setString(5,qn);
					ps1.setString(6,it);
					ps1.setString(7,tot);
					ps1.setString(8,sf);
					ps1.setString(9,em);
					ps1.setString(10,cm);
					ps1.setString(11,jd);
					ps1.setString(12,rnt);
					ps1.setString(13,nw);
					ps1.setString(14,ad);
					ps1.setString(15,ntot);
					ps1.setString(16, (((JTextField) mdate.getDateEditor().getUiComponent()).getText()));
					ps1.setString(17,ntot);
					ps1.setString(18,narat);
					ps1.executeLargeUpdate();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
				Purbil pb= new Purbil();
				desktopPane.add(pb);
				pb.setVisible(true);
				pb.pb0.setText(sb.getText());
				pb.rs.setText(rel.getText());
				pb.sc.setText(scode.getText());
				pb.sn.setText(sname.getText());
				pb.scon.setText(sphone.getText());
				pb.sadd.setText(saddress.getText());
				pb.sf.setText(sltfee.getText());
				pb.cm.setText(comm.getText());
				pb.emer.setText(emergency.getText());
				pb.jdiss.setText(jdiss.getText());
				pb.rnt.setText(rent.getText());
				pb.adv.setText(advance.getText());
				pb.nw.setText(nwet.getText());
				pb.tot.setText(total.getText());
				pb.nt.setText(nettotal.getText());
				pb.qnt.setText(qnt.getText());
				pb.itm.setText(itm.getText());
				
				TableModel model=table.getModel();
				int indexs[]=table.getSelectedRows();
				Object[] row=new Object[6];
				DefaultTableModel model1=new DefaultTableModel();
				model1 = (DefaultTableModel)pb.table1.getModel();
				for(int i=0;i<indexs.length;i++)
				{
					row[0]=model.getValueAt(indexs[i],0);
					row[1]=model.getValueAt(indexs[i],1);
					row[2]=model.getValueAt(indexs[i],2);
					row[3]=model.getValueAt(indexs[i],3);
					row[4]=model.getValueAt(indexs[i],4);
					row[5]=model.getValueAt(indexs[i],5);
					model1.addRow(row);
				}
				
			}
		});
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(126, 634, 141, 44);
		panel_2_1.add(btnNewButton_1);
		
		nwet = new JTextField();
		nwet.setForeground(SystemColor.textHighlight);
		nwet.setBackground(Color.WHITE);
		nwet.setEditable(false);
		nwet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		nwet.setColumns(10);
		nwet.setBounds(126, 438, 141, 32);
		panel_2_1.add(nwet);
		
		JLabel lblTotal_1_1 = new JLabel("NET WEIGHT");
		lblTotal_1_1.setForeground(Color.RED);
		lblTotal_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTotal_1_1.setBounds(10, 441, 80, 22);
		panel_2_1.add(lblTotal_1_1);
		
		jdiss = new JTextField();
		jdiss.setFont(new Font("Tahoma", Font.ITALIC, 15));
		jdiss.setColumns(10);
		jdiss.setBounds(126, 298, 141, 32);
		panel_2_1.add(jdiss);
		
		JLabel lblEmergency_1_1 = new JLabel("Jaundice");
		lblEmergency_1_1.setForeground(Color.BLACK);
		lblEmergency_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblEmergency_1_1.setBounds(10, 301, 80, 22);
		panel_2_1.add(lblEmergency_1_1);
	}
}

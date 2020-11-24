package com.enter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Salebill extends JInternalFrame {
	public static JTable table1;
	public static JTextField pb0;
	public static JTextField sc;
	public static JTextField sn;
	public static JTextField scon;
	public static JTextField sadd;
	public static JTextField sf;
	public static JTextField emer;
	public static JTextField jdiss;
	public static JTextField rnt;
	public static JTextField adv;
	public static JTextField nw;
	public static JTextField tot;
	public static JTextField nt;
	public static JTextField qnt;
	public static JTextField itm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salebill frame = new Salebill();
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
	public Salebill() {
		setMaximizable(true);
		setIconifiable(true);
		setTitle("SALE BILL");
		getContentPane().setBackground(SystemColor.control);
		setClosable(true);
		setBounds(100, 100, 1088, 770);
		getContentPane().setLayout(null);
		
		JPanel panelprnt = new JPanel();
		panelprnt.setBackground(Color.WHITE);
		panelprnt.setBounds(11, 11, 921, 708);
		getContentPane().add(panelprnt);
		panelprnt.setLayout(null);
		
		JLabel scodet = new JLabel("Party Code");
		scodet.setForeground(Color.BLACK);
		scodet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		scodet.setBounds(485, 154, 80, 22);
		panelprnt.add(scodet);
		
		JLabel snamet = new JLabel("Company Name");
		snamet.setForeground(Color.BLACK);
		snamet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		snamet.setBounds(10, 181, 122, 22);
		panelprnt.add(snamet);
		
		JLabel saddresst = new JLabel("Party Address");
		saddresst.setForeground(Color.BLACK);
		saddresst.setFont(new Font("Tahoma", Font.ITALIC, 15));
		saddresst.setBounds(474, 220, 122, 22);
		panelprnt.add(saddresst);
		
		JLabel sphonet = new JLabel("Party Contact");
		sphonet.setForeground(Color.BLACK);
		sphonet.setFont(new Font("Tahoma", Font.ITALIC, 15));
		sphonet.setBounds(474, 187, 107, 22);
		panelprnt.add(sphonet);
		
		JLabel quantity = new JLabel("Quantity");
		quantity.setForeground(Color.BLACK);
		quantity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		quantity.setBounds(10, 220, 80, 22);
		panelprnt.add(quantity);
		
		JLabel item = new JLabel("Item");
		item.setForeground(Color.BLACK);
		item.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		item.setBounds(241, 221, 52, 22);
		panelprnt.add(item);
		
		JLabel sbl = new JLabel("Sale Bill No");
		sbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		sbl.setBounds(10, 145, 133, 14);
		panelprnt.add(sbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 253, 892, 222);
		panelprnt.add(scrollPane);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"WEIGHT", "LESS", "NET WEIGHT", "RATE", "AMMOUNT"
			}
		));
		scrollPane.setViewportView(table1);
		table1.setToolTipText("");
		table1.setSurrendersFocusOnKeystroke(true);
		table1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		table1.setFillsViewportHeight(true);
		table1.setColumnSelectionAllowed(true);
		table1.setCellSelectionEnabled(true);
		table1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table1.setBackground(Color.WHITE);
		
		JLabel lblTotal_1 = new JLabel("TOTAL");
		lblTotal_1.setForeground(Color.RED);
		lblTotal_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTotal_1.setBounds(649, 486, 68, 22);
		panelprnt.add(lblTotal_1);
		
		JLabel lblNetTotal_1 = new JLabel("NET TOTAL");
		lblNetTotal_1.setForeground(Color.RED);
		lblNetTotal_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNetTotal_1.setBounds(627, 671, 90, 22);
		panelprnt.add(lblNetTotal_1);
		
		JLabel lblTotal_1_1 = new JLabel("NET WEIGHT");
		lblTotal_1_1.setForeground(Color.RED);
		lblTotal_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblTotal_1_1.setBounds(258, 497, 101, 22);
		panelprnt.add(lblTotal_1_1);
		
		JTextPane txtpnZainabEnterprices = new JTextPane();
		txtpnZainabEnterprices.setEditable(false);
		txtpnZainabEnterprices.setText("ZAINAB ENTERPRICES");
		txtpnZainabEnterprices.setForeground(Color.BLACK);
		txtpnZainabEnterprices.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		txtpnZainabEnterprices.setBounds(312, 11, 297, 32);
		panelprnt.add(txtpnZainabEnterprices);
		
		JLabel lblSltFee_1 = new JLabel("SLT fee");
		lblSltFee_1.setForeground(Color.BLACK);
		lblSltFee_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblSltFee_1.setBounds(664, -46, 90, 32);
		panelprnt.add(lblSltFee_1);
		
		JLabel lblEmergency_1 = new JLabel("Emergency");
		lblEmergency_1.setForeground(Color.BLACK);
		lblEmergency_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblEmergency_1.setBounds(634, 556, 80, 22);
		panelprnt.add(lblEmergency_1);
		
		JLabel lblEmergency_1_1 = new JLabel("Jaundice");
		lblEmergency_1_1.setForeground(Color.BLACK);
		lblEmergency_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblEmergency_1_1.setBounds(634, 582, 68, 22);
		panelprnt.add(lblEmergency_1_1);
		
		JLabel lblRent_1 = new JLabel("Rent");
		lblRent_1.setForeground(Color.BLACK);
		lblRent_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblRent_1.setBounds(664, 615, 44, 22);
		panelprnt.add(lblRent_1);
		
		JLabel lblAdvance_1 = new JLabel("ADVANCE");
		lblAdvance_1.setForeground(Color.BLACK);
		lblAdvance_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblAdvance_1.setBounds(634, 648, 80, 22);
		panelprnt.add(lblAdvance_1);
		
		JLabel lblSltFee_1_1 = new JLabel("SLT fee");
		lblSltFee_1_1.setForeground(Color.BLACK);
		lblSltFee_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblSltFee_1_1.setBounds(649, 523, 63, 22);
		panelprnt.add(lblSltFee_1_1);
		
		pb0 = new JTextField();
		pb0.setEditable(false);
		pb0.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		pb0.setBackground(Color.WHITE);
		pb0.setBounds(152, 132, 74, 32);
		panelprnt.add(pb0);
		pb0.setColumns(10);
		
		sc = new JTextField();
		sc.setColumns(10);
		sc.setBounds(591, 153, 305, 25);
		panelprnt.add(sc);
		
		sn = new JTextField();
		sn.setColumns(10);
		sn.setBounds(152, 184, 305, 25);
		panelprnt.add(sn);
		
		scon = new JTextField();
		scon.setColumns(10);
		scon.setBounds(591, 189, 305, 25);
		panelprnt.add(scon);
		
		sadd = new JTextField();
		sadd.setColumns(10);
		sadd.setBounds(591, 221, 320, 25);
		panelprnt.add(sadd);
		
		sf = new JTextField();
		sf.setColumns(10);
		sf.setBounds(720, 519, 155, 27);
		panelprnt.add(sf);
		
		emer = new JTextField();
		emer.setColumns(10);
		emer.setBounds(720, 552, 155, 25);
		panelprnt.add(emer);
		
		jdiss = new JTextField();
		jdiss.setColumns(10);
		jdiss.setBounds(720, 580, 155, 25);
		panelprnt.add(jdiss);
		
		rnt = new JTextField();
		rnt.setColumns(10);
		rnt.setBounds(720, 612, 155, 25);
		panelprnt.add(rnt);
		
		adv = new JTextField();
		adv.setColumns(10);
		adv.setBounds(720, 644, 155, 25);
		panelprnt.add(adv);
		
		nw = new JTextField();
		nw.setForeground(SystemColor.textHighlight);
		nw.setColumns(10);
		nw.setBounds(369, 497, 155, 25);
		panelprnt.add(nw);
		
		tot = new JTextField();
		tot.setForeground(SystemColor.textHighlight);
		tot.setColumns(10);
		tot.setBounds(720, 486, 155, 25);
		panelprnt.add(tot);
		
		nt = new JTextField();
		nt.setForeground(SystemColor.textHighlight);
		nt.setColumns(10);
		nt.setBounds(720, 672, 155, 25);
		panelprnt.add(nt);
		
		qnt = new JTextField();
		qnt.setColumns(10);
		qnt.setBounds(100, 221, 90, 25);
		panelprnt.add(qnt);
		
		itm = new JTextField();
		itm.setColumns(10);
		itm.setBounds(302, 220, 155, 25);
		panelprnt.add(itm);
		
		JTextPane txtpnMobileNo = new JTextPane();
		txtpnMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtpnMobileNo.setText("MOBILE NO     +919021540260 \t\tMAIL ID    Zaki540260@gmail.com\r\nADDRESS:: SANGAMNER,TAL.SANGAMNER\r\nDIST. A.NAGAR , STATE  MAHARASHTRA\r\n422605");
		txtpnMobileNo.setBounds(209, 46, 508, 70);
		panelprnt.add(txtpnMobileNo);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(932, 11, 130, 708);
		getContentPane().add(desktopPane);
		
		JButton prnt = new JButton("PRINT");
		prnt.setBounds(0, 376, 108, 39);
		desktopPane.add(prnt);
		prnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				printRecord(panelprnt);
			}

			private void printRecord(JPanel panelprnt)
			{
				// TODO Auto-generated method stub
				PrinterJob printerjob=PrinterJob.getPrinterJob();
				printerjob.setJobName("Print Record");
				printerjob.setPrintable(new Printable() {
					
					@Override
					public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
						if(pageIndex >0 )
						{
							return Printable.NO_SUCH_PAGE;
						}
						Graphics2D graphics2D=(Graphics2D)graphics;
						graphics2D.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
						graphics2D.scale(0.5, 0.5);
						panelprnt.paint(graphics2D);
						
						return Printable.PAGE_EXISTS;
					}
			
				});
				boolean returningResult =printerjob.printDialog();
				if(returningResult)
				{
					try
					{
						printerjob.print();
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(prnt, "print error:" +ex);
					}
				}
			}
			
		});
		prnt.setBackground(SystemColor.activeCaption);
		prnt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));

	}
}

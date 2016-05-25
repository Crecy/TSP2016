package Jiemian;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Jiemian.InvestDialog;
import Tongji.*;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import java.awt.GridLayout;

public class Tongji extends JPanel {
	private JTextField textField_1;
	private JFileChooser fileDialog;
	private JTable table;
	private JDialog gerenshezhi;
	private InvestDialog investDialog;
	private WriteToExcel writetoexcel;
		
	private Records records;
	private JPanel chartpanel;
	
	public Tongji(final Records records) {
		
		this.records = records;     //把record都传进来，在这个面板中
		fileDialog = new JFileChooser();
		fileDialog.setFileFilter(new FileNameExtensionFilter("Excel", "xls", "xlsx"));
		fileDialog.setAcceptAllFileFilterUsed(false);  
		
		setLayout(null);		
		JButton btnImport = new JButton("导入数据");
		btnImport.setBounds(10, 10, 93, 23);
		add(btnImport);

		
		JButton btnOutport = new JButton("导出数据");
		btnOutport.setBounds(10, 43, 93, 23);
		add(btnOutport);
		
		btnOutport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					writetoexcel = new WriteToExcel(table);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
			
		JButton btnZengjia = new JButton("增加记录");
		btnZengjia.setBounds(10, 76, 93, 23);
		add(btnZengjia);
		
		btnZengjia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(investDialog==null)
					investDialog = new InvestDialog(table, records, textField_1);
				investDialog.setVisible(true);
			}
		});
		
		JButton btnJieguo = new JButton("进行统计");
		btnJieguo.setBounds(10, 109, 93, 23);
		add(btnJieguo);
			
		JLabel lblNewLabel_1 = new JLabel("当前账户金额");
		lblNewLabel_1.setBounds(140, 14, 86, 15);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(222, 11, 66, 21);
		textField_1.setEditable(false);
		add(textField_1);
		textField_1.setColumns(10);
		
		//添加了一个JScrollPane和JTable
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 55, 577, 217);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new RecordsModel(records));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("个人设置");
		btnNewButton.setBounds(427, 10, 93, 23);
		add(btnNewButton);
		
		//添加“个人设置”的监听事件
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gerenshezhi==null)
					gerenshezhi = new Gerenshezhi();
				gerenshezhi.setVisible(true);
			}
		});
				
		/*JPanel chartpanel = new JPanel();
		chartpanel.setBackground(Color.GRAY);
		chartpanel.setBounds(140, 282, 604, 341);
		add(chartpanel);
		chartpanel.add((new LineChart(new MoneyDataSet(records), new RateDataSet(records))).getChartPanel());

		btnImport.addActionListener(new ReadFromExcel(fileDialog, table, this.records, textField_1,chartpanel));
		chartpanel.setLayout(new GridLayout(1, 0, 0, 0));*/
	
		chartpanel = new JPanel();
		chartpanel.setBackground(Color.GRAY);
		chartpanel.setBounds(140, 282, 577, 341);
		chartpanel.setLayout(new GridLayout(1, 0, 0, 0));
		add(chartpanel);
		//改变部分
		chartpanel.removeAll();
		chartpanel.add((new LineChart(new MoneyDataSet(records), new RateDataSet(records)).getChartPanel()));
		chartpanel.revalidate();
		
		btnJieguo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chartpanel.add((new LineChart(new MoneyDataSet(records), new RateDataSet(records))).getChartPanel());
				chartpanel.removeAll();
				chartpanel.add((new LineChart(new MoneyDataSet(records), new RateDataSet(records)).getChartPanel()));
				chartpanel.revalidate();
			}
		});
		
		btnImport.addActionListener(new ReadFromExcel(fileDialog, table, this.records, textField_1));

	}
}

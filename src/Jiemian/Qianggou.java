package Jiemian;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Button;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.ButtonGroup;

import Qianggou.ExtractService;
import Qianggou.ProjectData;
import Qianggou.ProjectFilter;
import Qianggou.Rule;


public class Qianggou extends JPanel {
	public static int num=1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Button btnNewButton;
	Boolean flag =true;
	
	ProjectFilter projectFilter,Filter;
	

	public Qianggou() {
		setLayout(null);
		projectFilter=new ProjectFilter();
		
		//投资期限
		JLabel lblNewLabel = new JLabel("投资期限：");
		lblNewLabel.setBounds(10, 10, 80, 15);
		add(lblNewLabel);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("不限",true);
		rdbtnNewRadioButton.setBounds(70, 6, 55, 23);
		add(rdbtnNewRadioButton);
		this.add(rdbtnNewRadioButton);
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("6个月以下");
		rdbtnNewRadioButton_1.setBounds(127, 6, 85, 23);
		add(rdbtnNewRadioButton_1);
		this.add(rdbtnNewRadioButton_1);

		final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("6-12个月");
		rdbtnNewRadioButton_2.setBounds(214, 6, 80, 23);
		add(rdbtnNewRadioButton_2);
		this.add(rdbtnNewRadioButton_2);

		final JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("12月以上");
		rdbtnNewRadioButton_3.setBounds(296, 6, 80, 23);
		add(rdbtnNewRadioButton_3);
		this.add(rdbtnNewRadioButton_3);
	
		final JRadioButton rdbtnNewRadioButton_Z1 = new JRadioButton("自定义");
		rdbtnNewRadioButton_Z1.setBounds(382, 6, 80, 23);
		add(rdbtnNewRadioButton_Z1);
		this.add(rdbtnNewRadioButton_Z1);
		
		ButtonGroup radioGroup1 = new ButtonGroup();//添加到组中
		radioGroup1.add(rdbtnNewRadioButton);
		radioGroup1.add(rdbtnNewRadioButton_1);
		radioGroup1.add(rdbtnNewRadioButton_2);
		radioGroup1.add(rdbtnNewRadioButton_3);
		radioGroup1.add(rdbtnNewRadioButton_Z1);
	
		textField = new JTextField();
		textField.setBounds(466, 7, 66, 21);
		add(textField);
		textField.setColumns(10);
		textField.setEditable(false);

		JLabel lblNewLabel_1 = new JLabel("个月—");
		lblNewLabel_1.setBounds(532, 10, 46, 15);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(578, 7, 66, 21);
		add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);

			
	rdbtnNewRadioButton_Z1.addItemListener(new ItemListener(){
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (rdbtnNewRadioButton_Z1.isSelected()==true)
            {
        		textField.setEditable(true);
				textField_1.setEditable(true);
            }
			else {
        		textField.setEditable(false);
				textField_1.setEditable(false);
            }
		}
		
	});

		JLabel lblNewLabel_2 = new JLabel("个月");
		lblNewLabel_2.setBounds(644, 10, 36, 15);
		add(lblNewLabel_2);
		
		
		//投资金额
		JLabel label = new JLabel("投资金额：");
		label.setBounds(10, 35, 80, 15);
		add(label);
		
		final JRadioButton radioButton = new JRadioButton("不限",true);
		radioButton.setBounds(70, 31, 55, 23);
		add(radioButton);
		this.add(radioButton);
		
		final JRadioButton radioButton_1 = new JRadioButton("1万元以下");
		radioButton_1.setBounds(127, 31, 85, 23);
		add(radioButton_1);
		this.add(radioButton_1);
 
		
		final JRadioButton radioButton_2 = new JRadioButton("1-5万元");
		radioButton_2.setBounds(214, 31, 80, 23);
		add(radioButton_2);
		this.add(radioButton_2);
 
		
		final JRadioButton radioButton_3 = new JRadioButton("5-10万元");
		radioButton_3.setBounds(296, 31, 80, 23);
		add(radioButton_3);
		this.add(radioButton_3);
 
		
		final JRadioButton radioButton_4 = new JRadioButton("10万元以上");
		radioButton_4.setBounds(382, 34, 95, 23);
		add(radioButton_4);
		this.add(radioButton_4);
 
		
		final JRadioButton rdbtnNewRadioButton_Z2 = new JRadioButton("自定义");
		rdbtnNewRadioButton_Z2.setBounds(483, 31, 80, 23);
		add(rdbtnNewRadioButton_Z2);
		this.add(rdbtnNewRadioButton_Z2);

		
		ButtonGroup radioGroup2 = new ButtonGroup();//添加到组
		radioGroup2.add(radioButton);
		radioGroup2.add(radioButton_1);
		radioGroup2.add(radioButton_2);
		radioGroup2.add(radioButton_3);
		radioGroup2.add(radioButton_4);
		radioGroup2.add(rdbtnNewRadioButton_Z2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(569, 32, 66, 21);
		add(textField_2);
		textField_2.setEditable(false);
		
		JLabel label_1 = new JLabel("万元—");
		label_1.setBounds(635, 35, 46, 15);
		add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(681, 32, 66, 21);
		add(textField_3);
		textField_3.setEditable(false);
		
		JLabel label_2 = new JLabel("万元");
		label_2.setBounds(747, 35, 36, 15);
		add(label_2);
		
		rdbtnNewRadioButton_Z2.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (rdbtnNewRadioButton_Z2.isSelected()==true)
                {
            		textField_2.setEditable(true);
    				textField_3.setEditable(true);
                }
				else{
            		textField_2.setEditable(false);
    				textField_3.setEditable(false);
                }
			}
			
		});
	
		//年收益率部分
		JLabel label_3 = new JLabel("年收益率：");
		label_3.setBounds(10, 60, 80, 15);
		add(label_3);
		
		final JRadioButton radioButton_5 = new JRadioButton("不限",true);
		radioButton_5.setBounds(70, 56, 55, 23);
		add(radioButton_5);
		this.add(radioButton_5);
		radioButton_5.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (radioButton_5.isSelected()==true)
                {
					projectFilter.setRate("","");
                }
			}
			
		});
		
		final JRadioButton radioButton_6 = new JRadioButton("3%以下");
		radioButton_6.setBounds(127, 56, 85, 23);
		add(radioButton_6);
		this.add(radioButton_6);
		radioButton_6.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (radioButton_6.isSelected()==true)
                {
					projectFilter.setRate("0","0.03");
                }
			}
			
		});
		
		final JRadioButton radioButton_7 = new JRadioButton("3%-6%");
		radioButton_7.setBounds(214, 56, 80, 23);
		add(radioButton_7);
		this.add(radioButton_7);
		radioButton_7.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (radioButton_7.isSelected()==true)
                {
					projectFilter.setRate("0.03","0.06");
                }
			}
			
		});
		
		final JRadioButton radioButton_8 = new JRadioButton("6%-9%");
		radioButton_8.setBounds(296, 56, 80, 23);
		add(radioButton_8);
		this.add(radioButton_8);
		radioButton_8.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (radioButton_8.isSelected()==true)
                {
					projectFilter.setRate("0.06","0.09");
                }
			}
			
		});
		
		final JRadioButton radioButton_9 = new JRadioButton("9%以上");
		radioButton_9.setBounds(382, 56, 80, 23);
		add(radioButton_9);
		this.add(radioButton_9);
		radioButton_9.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (radioButton_9.isSelected()==true)
                {
					projectFilter.setRate("0.09","");
                }
			}
			
		});
		
		ButtonGroup radioGroup3 = new ButtonGroup();
		radioGroup3.add(radioButton_5);
		radioGroup3.add(radioButton_6);
		radioGroup3.add(radioButton_7);
		radioGroup3.add(radioButton_8);
		radioGroup3.add(radioButton_9);
		
		btnNewButton = new Button("开始抢购");
		btnNewButton.setBounds(697, 60, 93, 23);
		add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener()
			{
			@Override
			
			public void actionPerformed(ActionEvent arg0){
				if (rdbtnNewRadioButton.isSelected()==true)
                {
					projectFilter.setPeriod("","");
                }
				else if (rdbtnNewRadioButton_1.isSelected()==true)
                {
					projectFilter.setPeriod("0","180");
                }
				else if (rdbtnNewRadioButton_2.isSelected()==true)
                {
					projectFilter.setPeriod("180","360");
                }
				else if (rdbtnNewRadioButton_3.isSelected()==true)
                {
					projectFilter.setPeriod("360","");
                }
				else{
			//	projectFilter.setPeriod(String.valueOf(Integer.parseInt(textField.getText())*30),String.valueOf(Integer.parseInt(textField_1.getText())*30));
				if(textField.getText()!=null)
					projectFilter.setMinDays(String.valueOf(Integer.parseInt(textField.getText())*30));
				if(textField_1.getText()!=null)
					projectFilter.setMaxDays(String.valueOf(Integer.parseInt(textField_1.getText())*30));
				}
				
				if (radioButton.isSelected()==true)
                {
					projectFilter.setAmount("","");
                }
				else if (radioButton_1.isSelected()==true)
                {
					projectFilter.setAmount("0","10000");
                }
				else if (radioButton_2.isSelected()==true)
                {
					projectFilter.setAmount("10000","50000");
                }
				else if (radioButton_3.isSelected()==true)
                {
					projectFilter.setAmount("50000","100000");
                }
				else if (radioButton_4.isSelected()==true)
                {
					projectFilter.setAmount("100000","");
                }
				else {		
					if(textField_2.getText()!=null)
					projectFilter.setMinMoney(String.valueOf(Integer.parseInt(textField_2.getText())*10000));
					if(textField_3.getText()!=null)
					projectFilter.setMaxMoney(String.valueOf(Integer.parseInt(textField_3.getText())*10000));
					}
				
				if(flag){
						synchronized (flag)
							{
							flag = false;
							btnNewButton.setLabel("停止抢购");
							}
							
						new Thread(){
							@Override
							public void run(){
								while(true){
									synchronized(flag){
												if(flag)
													break;
													}
									try{
										Thread.sleep(1000);
										}
									catch(InterruptedException e){
										e.printStackTrace();
										}
									}
								}
							}.start();
							
							new Thread(){
								public void run(){
									
									Filter = new ProjectFilter(projectFilter);
									Rule rule = new Rule(Filter.getURL(), null, null,"product-list", Rule.CLASS, Rule.GET);
						           
									while(true){
										synchronized (flag) {
															if(flag)
																break;
															}
										List<ProjectData> extracts = ExtractService.extract(rule);
									if(extracts.size() != 0 ){
									    try {  
									    	String url =Filter.getURL();
									        URI uri = new URI(url);  
									        Desktop.getDesktop().browse(uri);  
									    	} 
									    catch (URISyntaxException e) 
									    {  
									        e.printStackTrace();  
									    }
									    catch(java.lang.NullPointerException e)
									    {
									    	e.printStackTrace();
										} 
									    catch (IOException e) 
									    {  
									            e.printStackTrace();  
									   	}    										
									    break;
										}
									 }							
									}
							}.start();
						}
				else{
					synchronized (flag) {
						flag=true;
						btnNewButton.setLabel("开始抢购");
						}
				     }
				
			}
			});

	}
}



package Jiemian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import Controll.Controll;

public class Shaixuan extends JPanel {
	public static String bianhao;
	public static int num=1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table_1;

	public Shaixuan() {
		setLayout(null);
		
		//投资期限部分
		JLabel lblNewLabel = new JLabel("投资期限：");
		lblNewLabel.setBounds(10, 10, 78, 19);
		add(lblNewLabel);
		
		JRadioButton radio1 = new JRadioButton();
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("不限",true);
		rdbtnNewRadioButton.setBounds(71, 6, 54, 23);
		radio1.add(rdbtnNewRadioButton);
		this.add(rdbtnNewRadioButton);
		
		final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("6个月以下");
		rdbtnNewRadioButton_1.setBounds(127, 6, 84, 23);
		radio1.add(rdbtnNewRadioButton_1);
		this.add(rdbtnNewRadioButton_1);
		
		final JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("6-12个月");
		rdbtnNewRadioButton_2.setBounds(213, 6, 78, 23);
		radio1.add(rdbtnNewRadioButton_2);
		this.add(rdbtnNewRadioButton_2);
		
		final JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("12个月以上");
		rdbtnNewRadioButton_3.setBounds(293, 6, 91, 23);
		radio1.add(rdbtnNewRadioButton_3);
		this.add(rdbtnNewRadioButton_3);


		//自定义月份
		final JRadioButton rdbtnNewRadioButton_21 = new JRadioButton("自定义");
		rdbtnNewRadioButton_21.setBounds(390, 6, 70, 23);
		radio1.add(rdbtnNewRadioButton_21);
		this.add(rdbtnNewRadioButton_21);
		
		ButtonGroup radioGroup1 = new ButtonGroup();
		radioGroup1.add(rdbtnNewRadioButton);
		radioGroup1.add(rdbtnNewRadioButton_1);
		radioGroup1.add(rdbtnNewRadioButton_2);
		radioGroup1.add(rdbtnNewRadioButton_3);
		radioGroup1.add(rdbtnNewRadioButton_21);
		
		textField = new JTextField();
		textField.setBounds(460, 7, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("个月—");
		lblNewLabel_1.setBounds(530, 10, 44, 15);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(570, 7, 66, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("个月");
		lblNewLabel_2.setBounds(640, 10, 30, 15);
		add(lblNewLabel_2);
		
		
		//投资金额部分
		JLabel label = new JLabel("投资金额：");
		label.setBounds(10, 35, 78, 15);
		add(label);
		
		JRadioButton radio2 = new JRadioButton();
		final JRadioButton radioButton = new JRadioButton("不限",true);
		radioButton.setBounds(71, 31, 54, 23);
		radio2.add(radioButton);
		this.add(radioButton);
		
		final JRadioButton radioButton_1 = new JRadioButton("1万元以下");
		radioButton_1.setBounds(127, 31, 84, 23);
		radio2.add(radioButton_1);
		this.add(radioButton_1);
		
		final JRadioButton radioButton_2 = new JRadioButton("1万-5万元");
		radioButton_2.setBounds(213, 31, 84, 23);
		radio2.add(radioButton_2);
		this.add(radioButton_2);
		
		final JRadioButton radioButton_3 = new JRadioButton("5万-10万元");
		radioButton_3.setBounds(293, 31, 91, 23);
		radio2.add(radioButton_3);
		this.add(radioButton_3);
		
		final JRadioButton radioButton_4 = new JRadioButton("10万以上");
		radioButton_4.setBounds(390, 34, 78, 23);
		radio2.add(radioButton_4);
		this.add(radioButton_4);
		
		//自定义金钱
		final JRadioButton radioButton_20 = new JRadioButton("自定义");
		radioButton_20.setBounds(475, 34, 70, 23);
		radio2.add(radioButton_20);
		this.add(radioButton_20);
		
		ButtonGroup radioGroup2 = new ButtonGroup();
		radioGroup2.add(radioButton);
		radioGroup2.add(radioButton_1);
		radioGroup2.add(radioButton_2);
		radioGroup2.add(radioButton_3);
		radioGroup2.add(radioButton_4);
		radioGroup2.add(radioButton_20);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(550, 35, 66, 21);
		add(textField_5);
		
		JLabel label_1 = new JLabel("万元—");
		label_1.setBounds(620, 38, 40, 15);
		add(label_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(670, 35, 66, 21);
		add(textField_6);
		
		JLabel label_2 = new JLabel("万元");
		label_2.setBounds(740, 38, 30, 15);
		add(label_2);
		
		
		//年收益率部分
		JLabel label_3 = new JLabel("年收益率：");
		label_3.setBounds(10, 60, 78, 15);
		add(label_3);
		
		JRadioButton radio3 = new JRadioButton();
		final JRadioButton radioButton_5 = new JRadioButton("不限",true);
		radioButton_5.setBounds(71, 56, 54, 23);
		radio3.add(radioButton_5);
		this.add(radioButton_5);
		
		final JRadioButton radioButton_6 = new JRadioButton("3%以下");
		radioButton_6.setBounds(127, 56, 84, 23);
		radio3.add(radioButton_6);
		this.add(radioButton_6);
		
		final JRadioButton radioButton_7 = new JRadioButton("3%-6%");
		radioButton_7.setBounds(213, 56, 84, 23);
		radio3.add(radioButton_7);
		this.add(radioButton_7);
		
		final JRadioButton radioButton_8 = new JRadioButton("6%-9%");
		radioButton_8.setBounds(293, 56, 72, 23);
		radio3.add(radioButton_8);
		this.add(radioButton_8);
		
		
		final JRadioButton radioButton_9 = new JRadioButton("9%以上");
		radioButton_9.setBounds(390, 56, 91, 23);
		radio3.add(radioButton_9);
		this.add(radioButton_9);
		
		ButtonGroup radioGroup3 = new ButtonGroup();
		radioGroup3.add(radioButton_5);
		radioGroup3.add(radioButton_6);
		radioGroup3.add(radioButton_7);
		radioGroup3.add(radioButton_8);
		radioGroup3.add(radioButton_9);
		
		/*
		//排序部分
		JLabel label_4 = new JLabel("排序：");
		label_4.setBounds(10, 85, 78, 15);
		add(label_4);
		
		JRadioButton radio4 = new JRadioButton();
		JRadioButton radioButton_10 = new JRadioButton("默认排序",true);
		radioButton_10.setBounds(71, 81, 78, 23);
		radio4.add(radioButton_10);
		this.add(radioButton_10);
		
		JRadioButton radioButton_11 = new JRadioButton("投资期限");
		radioButton_11.setBounds(151, 81, 84, 23);
		radio4.add(radioButton_11);
		this.add(radioButton_11);
		
		JRadioButton radioButton_12 = new JRadioButton("起投金额");
		radioButton_12.setBounds(237, 81, 84, 23);
		radio4.add(radioButton_12);
		this.add(radioButton_12);
		
		JRadioButton radioButton_13 = new JRadioButton("年收益率");
		radioButton_13.setBounds(323, 81, 91, 23);
		radio4.add(radioButton_13);
		this.add(radioButton_13);
		
		ButtonGroup radioGroup4 = new ButtonGroup();
		radioGroup4.add(radioButton_10);
		radioGroup4.add(radioButton_11);
		radioGroup4.add(radioButton_12);
		radioGroup4.add(radioButton_13);
	*/	
		//内容部分
		JLabel lblNewLabel_3 = new JLabel("投资项目");
		lblNewLabel_3.setBounds(10, 128, 54, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("投资利率");
		lblNewLabel_4.setBounds(199, 128, 54, 15);
		add(lblNewLabel_4);
		
		final JLabel lblNewLabel_5 = new JLabel("投资期限");
		lblNewLabel_5.setBounds(330, 128, 54, 15);
		add(lblNewLabel_5);
		
		final JLabel lblNewLabel_6 = new JLabel("投资金额");
		lblNewLabel_6.setBounds(452, 128, 54, 15);
		add(lblNewLabel_6);
		
		final JLabel lblNewLabel_7 = new JLabel("New l");
		lblNewLabel_7.setBounds(10, 153, 174, 19);
		add(lblNewLabel_7);
		
		final JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(199, 153, 174, 19);
		add(lblNewLabel_8);
		
		final JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(330, 153, 174, 15);
		add(lblNewLabel_9);
		
		final JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(452, 155, 188, 15);
		lblNewLabel_10.setSize(80,20);
		add(lblNewLabel_10);
		
		final JLabel label_5 = new JLabel("New label");
		label_5.setBounds(10, 182, 174, 19);
		add(label_5);
		
		final JLabel label_6 = new JLabel("New label");
		label_6.setBounds(199, 184, 54, 15);
		add(label_6);
		
		final JLabel label_7 = new JLabel("New label");
		label_7.setBounds(330, 184, 54, 15);
		add(label_7);
		
		final JLabel label_8 = new JLabel("New label");
		label_8.setBounds(452, 184, 188, 15);
		label_8.setSize(80,20);
		add(label_8);
		
		final JLabel label_9 = new JLabel("New label");
		label_9.setBounds(10, 211, 174, 19);
		add(label_9);
		
		final JLabel label_10 = new JLabel("New label");
		label_10.setBounds(199, 213, 54, 15);
		add(label_10);
		
		final JLabel label_11 = new JLabel("New label");
		label_11.setBounds(330, 215, 54, 15);
		add(label_11);
		
		final JLabel label_12 = new JLabel("New label");
		label_12.setBounds(452, 213, 188, 15);
		label_12.setSize(80,20);
		add(label_12);
		
		final JLabel label_13 = new JLabel("New label");
		label_13.setBounds(10, 240, 174, 19);
		add(label_13);
		
		final JLabel label_14 = new JLabel("New label");
		label_14.setBounds(199, 242, 54, 15);
		add(label_14);
		
		final JLabel label_15 = new JLabel("New label");
		label_15.setBounds(330, 242, 54, 15);
		add(label_15);
		
		final JLabel label_16 = new JLabel("New label");
		label_16.setBounds(452, 242, 188, 15);
		label_16.setSize(80,20);
		add(label_16);
		
		final JLabel label_17 = new JLabel("New label");
		label_17.setBounds(10, 269, 174, 19);
		add(label_17);
		
		final JLabel label_18 = new JLabel("New label");
		label_18.setBounds(199, 271, 54, 15);
		add(label_18);
		
		final JLabel label_19 = new JLabel("New label");
		label_19.setBounds(330, 271, 54, 15);
		add(label_19);
		
		final JLabel label_20 = new JLabel("New label");
		label_20.setBounds(452, 271, 188, 15);
		label_20.setSize(80,20);
		add(label_20);
		
		final JLabel label_21 = new JLabel("New label");
		label_21.setBounds(10, 298, 174, 19);
		add(label_21);
		
		final JLabel label_22 = new JLabel("New label");
		label_22.setBounds(199, 300, 54, 15);
		add(label_22);
		
		final JLabel label_23 = new JLabel("New label");
		label_23.setBounds(330, 300, 54, 15);
		add(label_23);
		
		final JLabel label_24 = new JLabel("New label");
		label_24.setBounds(452, 300, 188, 15);
		label_24.setSize(80,20);
		add(label_24);
		
		final JLabel label_25 = new JLabel("New label");
		label_25.setBounds(10, 327, 174, 19);
		add(label_25);
		
		final JLabel label_26 = new JLabel("New label");
		label_26.setBounds(199, 329, 54, 15);
		add(label_26);
		
		final JLabel label_27 = new JLabel("New label");
		label_27.setBounds(330, 329, 54, 15);
		add(label_27);
		
		final JLabel label_28 = new JLabel("New label");
		label_28.setBounds(452, 329, 188, 15);
		label_28.setSize(80,20);
		add(label_28);
		
		final JLabel label_29 = new JLabel("New label");
		label_29.setBounds(10, 356, 188, 19);
		add(label_29);
		
		final JLabel label_30 = new JLabel("New label");
		label_30.setBounds(199, 358, 54, 15);
		add(label_30);
		
		final JLabel label_31 = new JLabel("New label");
		label_31.setBounds(330, 358, 54, 15);
		add(label_31);
		
		final JLabel label_32 = new JLabel("New label");
		label_32.setBounds(452, 360, 188, 15);
		label_32.setSize(80,20);
		add(label_32);
		
		
		
		final JLabel label_33 = new JLabel("New label");
		label_33.setBounds(10, 385, 174, 19);
		add(label_33);
		
		final JLabel label_34 = new JLabel("New label");
		label_34.setBounds(199, 387, 54, 15);
		add(label_34);
		
		final JLabel label_35 = new JLabel("New label");
		label_35.setBounds(330, 387, 54, 15);
		add(label_35);
		
		final JLabel label_36 = new JLabel("New lel");
		label_36.setBounds(452, 387, 188, 15);
		add(label_36);
		
		

		
		JButton btnNewButton = new JButton("购买");
		btnNewButton.setBounds(560, 151, 78, 23);
		add(btnNewButton);

				
		JButton button = new JButton("\u8D2D\u4E70");
		button.setBounds(560, 180, 78, 23);
		add(button);
		
		JButton button_1 = new JButton("\u8D2D\u4E70");
		button_1.setBounds(560, 209, 78, 23);
		add(button_1);

		JButton button_2 = new JButton("\u8D2D\u4E70");
		button_2.setBounds(560, 238, 78, 23);
		add(button_2);

		
		JButton button_3 = new JButton("\u8D2D\u4E70");
		button_3.setBounds(560, 269, 78, 23);
		add(button_3);

		JButton button_4 = new JButton("\u8D2D\u4E70");
		button_4.setBounds(560, 296, 78, 23);
		add(button_4);
		

		JButton button_5 = new JButton("\u8D2D\u4E70");
		button_5.setBounds(560, 325, 78, 23);
		add(button_5);

		JButton button_6 = new JButton("\u8D2D\u4E70");
		button_6.setBounds(560, 354, 78, 23);
		add(button_6);
		

		
		JButton button_7 = new JButton("\u8D2D\u4E70");
		button_7.setBounds(560, 383, 78, 23);
		add(button_7);
		

		
//	
//		JButton btnNewButton_1 = new JButton("首页");
//		btnNewButton_1.setBounds(71, 449, 93, 23);
//		add(btnNewButton_1);
		
		JButton button_9 = new JButton("上一页");
		button_9.setBounds(185, 449, 93, 23);
		add(button_9);
		
		//页数标签
		final JLabel label_37 = new JLabel("New lel");
		label_37.setBounds(452, 449, 54, 15);
		add(label_37);
		
		JButton button_10 = new JButton("下一页");
		button_10.setBounds(304, 449, 93, 23);
		add(button_10);
		

		
//		JLabel lblNewLabel_11 = new JLabel("New label");
//		lblNewLabel_11.setBounds(548, 453, 54, 15);
//		add(lblNewLabel_11);
		
	    final JButton button_12 = new JButton("确定");
		button_12.setBounds(560, 80, 78, 23);
		add(button_12);
		
		button_12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int yeshu=num,l_money=0,r_money=100000000;
                double l_rate=0,r_rate=100;
                int l_day=0,r_day=100000000;
                int q=0,b=0,d=0,r=0;
                String mode="";
              
                if (rdbtnNewRadioButton.isSelected()==true)
                {
                	l_day=0;r_day=10000000;
                }else
                if(rdbtnNewRadioButton_1.isSelected()==true)
                    {
                        l_day=0;r_day=180;
                    }else
                if(rdbtnNewRadioButton_2.isSelected()==true)
                    {
                        l_day=181;r_day=360;
                    }else
                 if(rdbtnNewRadioButton_3.isSelected()==true)
                    {
                       l_day=361;r_day=100000000;
                    }else
                    	if(rdbtnNewRadioButton_21.isSelected()==true)
                    {                   
                  try {
                        if (textField.getText() != null) q = Integer.parseInt(textField.getText());
                        l_day=q*30;
                        if (textField_1.getText() != null) b = Integer.parseInt(textField_1.getText());
                        r_day=b*30;
                    }catch(Exception a){}
                }
                
                if(radioButton.isSelected()==true)
                {
                    l_money=0;r_money=100000000;
                }else if(radioButton_1.isSelected()==true)
                {
                    l_money=0;r_money=10000;
                }else if(radioButton_2.isSelected()==true)
                {
                    l_money=10001;r_money=50000;
                }else if(radioButton_3.isSelected()==true)
                {
                    l_money=50001;r_money=100000;
                }else if(radioButton_4.isSelected()==true)
                {
                    l_money=100001;r_money=100000000;
                }else if(radioButton_20.isSelected()==true)
                {    
                try {
                    if (textField_5.getText() != null) d = Integer.parseInt(textField_5.getText());
                    l_money=d*10000;               
                    if (textField_6.getText() != null) r = Integer.parseInt(textField_6.getText());
                    r_money=r*10000;
                }catch(Exception a){}
                }
                if(radioButton_5.isSelected()==true)
                {
                    l_rate=0;r_rate=100;
                }else if(radioButton_6.isSelected()==true)
                {
                    l_rate=0;r_rate=3;
                }else if(radioButton_7.isSelected()==true)
                {
                    l_rate=3;r_rate=6;
                }else if(radioButton_8.isSelected()==true)
                {
                    l_rate=6;r_rate=9;
                }else if(radioButton_9.isSelected()==true)
                {
                    l_rate=9;r_rate=100;
                }
                
          
                               String info;     
          try {
                    info = Controll.captureHtml(yeshu, mode, l_money, r_money, l_rate / 100, r_rate / 100, l_day, r_day);
                    System.out.println(info);
                    	int l_index=0,r_index=0;
                    	String s;
                    	
                    	lblNewLabel_7.setText("");lblNewLabel_8.setText("");
                		lblNewLabel_9.setText("");lblNewLabel_10.setText("");
                		label_5.setText("");label_20.setText("");
                		label_6.setText("");label_21.setText("");
                		label_7.setText("");label_22.setText("");
                		label_8.setText("");label_23.setText("");
                		label_9.setText("");label_24.setText("");
                		label_10.setText("");label_25.setText("");
                		label_11.setText("");label_26.setText("");
                		label_12.setText("");label_27.setText("");
                		label_13.setText("");label_28.setText("");
                		label_14.setText("");label_29.setText("");
                		label_15.setText("");label_30.setText("");
                		label_16.setText("");label_31.setText("");
                		label_17.setText("");label_32.setText("");
                		label_18.setText("");label_33.setText("");
                		label_19.setText("");label_34.setText("");
                		label_35.setText("");label_36.setText("");
                		label_37.setText("");

                    	for(int i=0;i<9;i++)
                    	{          		
                    		
                    		for(int j=0;j<=3;j++)
                    		{
           		
			                        r_index=info.indexOf("..",l_index+1);
			                        if(l_index>0)
			                        s=info.substring(l_index+2,r_index);
			                        else s=info.substring(l_index,r_index);
			                        l_index=r_index;
			                        
			                        if(i==0&&j==0)
			                            lblNewLabel_7.setText(s);else
			                        if(i==0&&j==1)
			                        	lblNewLabel_8.setText(s);else
			                        if(i==0&&j==2)
				                        lblNewLabel_9.setText(s);else
			                        if(i==0&&j==3)
				                        lblNewLabel_10.setText(s);else
				                   if(i==1&&j==0)
				                        label_5.setText(s);else
				                    if(i==1&&j==1)
					                    label_6.setText(s);else
					                if(i==1&&j==2)
						                label_7.setText(s);else
						            if(i==1&&j==3)
							           label_8.setText(s); else
							        if(i==2&&j==0)
								        label_9.setText(s);else
								    if(i==2&&j==1)
									    label_10.setText(s);else
									if(i==2&&j==2)
										label_11.setText(s);else
									if(i==2&&j==3)
										label_12.setText(s);else
									if(i==3&&j==0)
										label_13.setText(s);else
									if(i==3&&j==1)
										label_14.setText(s);else
									if(i==3&&j==2)
										label_15.setText(s);else
									if(i==3&&j==3)
										label_16.setText(s);else
									if(i==4&&j==0)
										label_17.setText(s);else
									if(i==4&&j==1)
										label_18.setText(s);else
									if(i==4&&j==2)
										label_19.setText(s);else
									if(i==4&&j==3)
										label_20.setText(s);else
									if(i==5&&j==0)
										label_21.setText(s);else
									if(i==5&&j==1)
										label_22.setText(s);else
									if(i==5&&j==2)
										label_23.setText(s);else
								    if(i==5&&j==3)
										label_24.setText(s);else
									if(i==6&&j==0)
										label_25.setText(s);else
									if(i==6&&j==1)
										label_26.setText(s);else
									if(i==6&&j==2)
										label_27.setText(s);else
									if(i==6&&j==3)
										label_28.setText(s);else
									if(i==7&&j==0)
										label_29.setText(s);else
									if(i==7&&j==1)
										label_30.setText(s);else
									if(i==7&&j==2)
										label_31.setText(s);else
									if(i==7&&j==3)
										label_32.setText(s);else
									if(i==8&&j==0)
										label_33.setText(s);else
									if(i==8&&j==1)
										label_34.setText(s);else
									if(i==8&&j==2)
										label_35.setText(s);else
									if(i==8&&j==3)
										label_36.setText(s);
			                        
			                        
																				             																			                	
                    		}}
                    	label_37.setText("第"+num+"页");
   
                }    catch(Exception a)
                {

                }
    }
});

		
		 button_10.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                num++;
//	                System.out.println(num);
	            button_12.doClick();
	            }
	        });
		 
		 button_9.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if(num>1)num--;
//	                System.out.println(num);
	            button_12.doClick();
	            }
	        });
		
	//跳页部分	 
		textField_7 = new JTextField();
		textField_7.setBounds(572, 450, 66, 21);
		add(textField_7);
		textField_7.setColumns(10);
		
		JButton button_11 = new JButton("跳页");
		button_11.setBounds(640, 450, 70, 20);
		add(button_11);
			
		button_11.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (textField_7.getText() != null) num = Integer.parseInt(textField_7.getText());
	            	if (num>=1)	            		
//	            	   System.out.println(num);
	            	button_12.doClick();
	            }
	        });
		
//购买部分		
		btnNewButton.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  bianhao=lblNewLabel_7.getText();
//		    	  System.out.println(bianhao);
		    	  DialogPanel dialog=new DialogPanel();			        
		      }
		  });		
		button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  DialogPanel dialog=new DialogPanel();	
//		    	  System.out.println(bianhao);
		    	  bianhao=label_9.getText();
		      }
		  });		
		button_1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  DialogPanel dialog=new DialogPanel();	
		    	  bianhao=label_13.getText();

		      }
		  });		
		button_2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  DialogPanel dialog=new DialogPanel();		
		    	  bianhao=label_17.getText();
		      }
		  });		
		button_3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  DialogPanel dialog=new DialogPanel();	
		    	  bianhao=label_21.getText();
		      }
		  });
		button_4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  DialogPanel dialog=new DialogPanel();	
		    	  bianhao=label_25.getText();
		      }
		  });		
		button_5.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  DialogPanel dialog=new DialogPanel();	
		    	  bianhao=label_29.getText();
		      }
		  });
		button_6.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  DialogPanel dialog=new DialogPanel();
		    	  bianhao=label_33.getText();
		      }
		  });
		button_7.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  DialogPanel dialog=new DialogPanel();
		    	  bianhao=label_37.getText();
		      }
		  });
	}
}

package Jiemian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import jxl.*;
public class DialogPanel extends JPanel {

	public static int jine=0;
	public static int year=0;
	public static int mon=0;
	public static int day=0;
	public static int  num=1;
	public static int  aaa=0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	
	JDialog dialog=new JDialog();
	

	public DialogPanel()
	{
	
	setLayout(null); 
	dialog.add(this);
	dialog.setSize(400,250);
	dialog.setLocation(300,300);
	dialog.setVisible(true);
	
	JButton Button_1 = new JButton("购买");
	Button_1.setBounds(150, 170, 78, 23);
	add(Button_1);
	
	final JLabel label_1 = new JLabel("请输入购买金额");
	label_1.setBounds(30, 50, 150, 20);
	add(label_1);
	
	textField_1 = new JTextField();
	textField_1.setColumns(10);
	textField_1.setBounds(150, 50, 80, 20);
	add(textField_1);
	
	final JLabel label_6 = new JLabel("元");
	label_6.setBounds(240, 50, 20, 20);
	add(label_6);
	
	final JLabel label_2 = new JLabel("请输入购买时间");
	label_2.setBounds(30, 100, 150, 19);
	add(label_2);
	
	textField_2 = new JTextField();
	textField_2.setColumns(10);
	textField_2.setBounds(150, 100, 40, 20);
	add(textField_2);
	
	final JLabel label_3 = new JLabel("年");
	label_3.setBounds(200, 100, 20, 20);
	add(label_3);
	
	textField_3 = new JTextField();
	textField_3.setColumns(10);
	textField_3.setBounds(230, 100, 20, 20);
	add(textField_3);
	
	final JLabel label_4 = new JLabel("月");
	label_4.setBounds(260, 100, 20, 20);
	add(label_4);
	
	textField_4 = new JTextField();
	textField_4.setColumns(10);
	textField_4.setBounds(290, 100, 20, 20);
	add(textField_4);
	
	final JLabel label_5 = new JLabel("日");
	label_5.setBounds(320, 100, 20, 19);
	add(label_5);
	
	
	Button_1.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  try {
                  if (textField_1.getText() != null) jine = Integer.parseInt(textField_1.getText());                                 
              }catch(Exception a){}  
	    	  try {
                  if (textField_2.getText() != null) year = Integer.parseInt(textField_2.getText());                                 
              }catch(Exception a){}  
	    	  try {
                  if (textField_3.getText() != null) mon = Integer.parseInt(textField_3.getText());                                 
              }catch(Exception a){} 
	    	  try {
                  if (textField_4.getText() != null) day = Integer.parseInt(textField_4.getText());                                 
              }catch(Exception a){}  
	    	  
//	    	System.out.println("1");
			sc gg = new sc();
	    	num++;
	    	aaa=0;
//	    	  System.out.println(Shaixuan.bianhao);
	    	dialog.setVisible(false);
	      }
	});
	
	}
}
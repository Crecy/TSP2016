package Jiemian;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import javax.swing.*;

import Tongji.Records;



import java.awt.event.*;
import java.util.GregorianCalendar;

//创建总的框架
public class FrameWork extends JFrame {
	//private JPanel contentPane;
	private Container container;
	private BorderLayout layout;
	private CardLayout card;
	private JPanel dingbuPanel,zuobian,neirong;
	private ImageIcon img;
	private JLabel zhaocaiLabel;
	private JButton shaixuanbutton,qianggoubutton,tongjibutton;
	private JPanel shaixuanPanel,qianggouPanel,tongjiPanel;
	
	private final static int WIDTH=55;	//设置顶部面板的大小
	private final static int HEIGHT=55;

	public FrameWork()
	{
		super("首页");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 666, 331);   //设置JFrame出现的位置
		layout = new BorderLayout(0, 0);  //设置组件间的间距，以距离
        container = getContentPane();
        container.setLayout(layout);
        
        dingbuPanel = new JPanel();   //new出logo的顶部面板
		dingbuPanel.setBackground(new Color(153, 204, 255));
		dingbuPanel.setPreferredSize(new Dimension(600, 55));//设置顶部面板大小
		container.add(dingbuPanel, BorderLayout.NORTH);
		dingbuPanel.setLayout(new BorderLayout(0, 0));
		
		ImageIcon img = new ImageIcon("src/JMXY.JPG");//加载图片，并改变图片的大小
		img.setImage(img.getImage().getScaledInstance(FrameWork.WIDTH,FrameWork.HEIGHT,Image.SCALE_DEFAULT));
		JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
		dingbuPanel.add(imgLabel,BorderLayout.WEST);
		
		zhaocaiLabel = new JLabel("   招财猪");   //添加"招财猪"字样
		zhaocaiLabel.setFont(new Font("华文新魏", Font.BOLD, 20));
		zhaocaiLabel.setForeground(Color.BLACK);
		dingbuPanel.add(zhaocaiLabel);
	
		zuobian = new JPanel();   //new出导航栏部分
		zuobian.setBackground(new Color(192, 192, 192));  //设置导航栏的颜色
	    zuobian.setPreferredSize(new Dimension(100, 200));//设置导航栏的大小
		container.add(zuobian, BorderLayout.WEST);
		zuobian.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		shaixuanbutton=new JButton("投资筛选");
		shaixuanbutton.setFont(new Font("楷体", Font.BOLD, 13));
		zuobian.add(shaixuanbutton);
		
		qianggoubutton=new JButton("项目抢购");
		qianggoubutton.setFont(new Font("楷体", Font.BOLD, 13));
		zuobian.add(qianggoubutton);
		
		tongjibutton=new JButton("投资统计");
		tongjibutton.setFont(new Font("楷体", Font.BOLD, 13));
		zuobian.add(tongjibutton);
		
		neirong = new JPanel();
	    card = new CardLayout(0,0);
		neirong.setLayout(card);
		
		shaixuanPanel = new Shaixuan();
				
		qianggouPanel = new Qianggou();
		tongjiPanel = new Tongji((new Records(new GregorianCalendar(2014,2,29),200000)));
		neirong.add(shaixuanPanel,"card1");
		neirong.add(qianggouPanel,"card2");
		neirong.add(tongjiPanel,"card3");
		container.add(neirong, BorderLayout.CENTER);
		
		shaixuanbutton.addMouseListener(
				new MouseAdapter(){		
					public void mouseClicked(MouseEvent event)
					{
						container.setVisible(false);
						card.show(neirong, "card1");
						container.setVisible(true);
					}	
				}
				);
		
		qianggoubutton.addMouseListener(
				new MouseAdapter(){		
					public void mouseClicked(MouseEvent event)
					{
						container.setVisible(false);
						card.show(neirong, "card2");
						container.setVisible(true);
					}
				
				}
				);	
		
		tongjibutton.addMouseListener(
				new MouseAdapter(){		
					public void mouseClicked(MouseEvent event)
					{
						container.setVisible(false);
						card.show(neirong, "card3");
						container.setVisible(true);
					}
				
				}
				);	
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameWork frame = new FrameWork();
				//	frame.setPreferredSize(new Dimension(950,600));
					frame.setExtendedState(Frame.MAXIMIZED_BOTH);
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
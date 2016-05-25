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

//�����ܵĿ��
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
	
	private final static int WIDTH=55;	//���ö������Ĵ�С
	private final static int HEIGHT=55;

	public FrameWork()
	{
		super("��ҳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 666, 331);   //����JFrame���ֵ�λ��
		layout = new BorderLayout(0, 0);  //���������ļ�࣬�Ծ���
        container = getContentPane();
        container.setLayout(layout);
        
        dingbuPanel = new JPanel();   //new��logo�Ķ������
		dingbuPanel.setBackground(new Color(153, 204, 255));
		dingbuPanel.setPreferredSize(new Dimension(600, 55));//���ö�������С
		container.add(dingbuPanel, BorderLayout.NORTH);
		dingbuPanel.setLayout(new BorderLayout(0, 0));
		
		ImageIcon img = new ImageIcon("src/JMXY.JPG");//����ͼƬ�����ı�ͼƬ�Ĵ�С
		img.setImage(img.getImage().getScaledInstance(FrameWork.WIDTH,FrameWork.HEIGHT,Image.SCALE_DEFAULT));
		JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ�
		dingbuPanel.add(imgLabel,BorderLayout.WEST);
		
		zhaocaiLabel = new JLabel("   �в���");   //���"�в���"����
		zhaocaiLabel.setFont(new Font("������κ", Font.BOLD, 20));
		zhaocaiLabel.setForeground(Color.BLACK);
		dingbuPanel.add(zhaocaiLabel);
	
		zuobian = new JPanel();   //new������������
		zuobian.setBackground(new Color(192, 192, 192));  //���õ���������ɫ
	    zuobian.setPreferredSize(new Dimension(100, 200));//���õ������Ĵ�С
		container.add(zuobian, BorderLayout.WEST);
		zuobian.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		shaixuanbutton=new JButton("Ͷ��ɸѡ");
		shaixuanbutton.setFont(new Font("����", Font.BOLD, 13));
		zuobian.add(shaixuanbutton);
		
		qianggoubutton=new JButton("��Ŀ����");
		qianggoubutton.setFont(new Font("����", Font.BOLD, 13));
		zuobian.add(qianggoubutton);
		
		tongjibutton=new JButton("Ͷ��ͳ��");
		tongjibutton.setFont(new Font("����", Font.BOLD, 13));
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
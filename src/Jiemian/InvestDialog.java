package Jiemian;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

//import org.eclipse.wb.swing.FocusTraversalOnArray;



import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JRadioButton;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.CardLayout;

import javax.swing.JComboBox;

import Tongji.Record;
import Tongji.Records;

@SuppressWarnings("serial")
public class InvestDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel buttonPane;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel moneyLable;
	private JTextField MoneyTextField;
	private JTextField ProjTextField;
	private JLabel projectLable;
	private JLabel operationLable;
	private JLabel dateLable;
	private JPanel TypeButtonGroup;
	private JRadioButton buyRadioButton;
	private JRadioButton redeenRadioButton;
	private JPanel dateInputPanel;
	private JTextField yearTextField;
	private JTextField monthTextField;
	private JTextField dayTextField;
	private Record.Op selected;
	private ButtonGroup buttongroup;
	private JPanel projPanel;
	private JComboBox<String> comboBox;
	private CardLayout card;
	private JLabel yearLable;
	private JLabel monthLable;
	private JLabel dayLable;

	/**
	 * Create the dialog.
	 */
	public InvestDialog(final JTable table, final Records records,
			final JTextField outputTextField) {
		setTitle("添加记录");
		setModal(true);
		setAlwaysOnTop(true);

		buttongroup = new ButtonGroup();

		setBounds(100, 100, 553, 341);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 45, 173, 33, 0 };
		gbl_contentPanel.rowHeights = new int[] { 30, 30, 30, 30, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			dateLable = new JLabel("\u65E5\u671F");
			dateLable.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_dateLable = new GridBagConstraints();
			gbc_dateLable.fill = GridBagConstraints.BOTH;
			gbc_dateLable.insets = new Insets(0, 0, 5, 5);
			gbc_dateLable.gridx = 0;
			gbc_dateLable.gridy = 0;
			contentPanel.add(dateLable, gbc_dateLable);
		}
		{
			dateInputPanel = new JPanel();
			dateInputPanel.setBorder(null);
			dateInputPanel.setBackground(Color.WHITE);
			GridBagConstraints gbc_dateInputPanel = new GridBagConstraints();
			gbc_dateInputPanel.insets = new Insets(0, 0, 5, 5);
			gbc_dateInputPanel.fill = GridBagConstraints.BOTH;
			gbc_dateInputPanel.gridx = 1;
			gbc_dateInputPanel.gridy = 0;
			contentPanel.add(dateInputPanel, gbc_dateInputPanel);
			GridBagLayout gbl_dateInputPanel = new GridBagLayout();
			gbl_dateInputPanel.columnWidths = new int[]{30, 0, 30, 0, 30, 0, 0};
			gbl_dateInputPanel.rowHeights = new int[]{25, 0};
			gbl_dateInputPanel.columnWeights = new double[]{2.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_dateInputPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			dateInputPanel.setLayout(gbl_dateInputPanel);
			{
				yearTextField = new JTextField();
				//yearTextField.setBackground(Color.GRAY);
				//yearTextField.setForeground(Color.WHITE);
				yearTextField.setText(String.format("%tY" ,new Date()));
				yearTextField.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_yearTextField = new GridBagConstraints();
				gbc_yearTextField.fill = GridBagConstraints.BOTH;
				gbc_yearTextField.insets = new Insets(0, 0, 0, 5);
				gbc_yearTextField.gridx = 0;
				gbc_yearTextField.gridy = 0;
				dateInputPanel.add(yearTextField, gbc_yearTextField);
				yearTextField.setColumns(10);
			}
			{
				yearLable = new JLabel("\u5E74");
				GridBagConstraints gbc_yearLable = new GridBagConstraints();
				gbc_yearLable.insets = new Insets(0, 0, 0, 5);
				gbc_yearLable.anchor = GridBagConstraints.EAST;
				gbc_yearLable.gridx = 1;
				gbc_yearLable.gridy = 0;
				dateInputPanel.add(yearLable, gbc_yearLable);
			}
			{
				monthTextField = new JTextField();
				/*monthTextField.setForeground(Color.WHITE);
				monthTextField.setBackground(Color.GRAY);*/
				monthTextField.setText(String.format("%tm",new Date()));
				monthTextField.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_monthTextField = new GridBagConstraints();
				gbc_monthTextField.fill = GridBagConstraints.BOTH;
				gbc_monthTextField.insets = new Insets(0, 0, 0, 5);
				gbc_monthTextField.gridx = 2;
				gbc_monthTextField.gridy = 0;
				dateInputPanel.add(monthTextField, gbc_monthTextField);
				monthTextField.setColumns(10);
			}
			{
				monthLable = new JLabel("\u6708");
				GridBagConstraints gbc_monthLable = new GridBagConstraints();
				gbc_monthLable.insets = new Insets(0, 0, 0, 5);
				gbc_monthLable.anchor = GridBagConstraints.EAST;
				gbc_monthLable.gridx = 3;
				gbc_monthLable.gridy = 0;
				dateInputPanel.add(monthLable, gbc_monthLable);
			}
			{
				dayTextField = new JTextField();
				/*dayTextField.setForeground(Color.WHITE);
				dayTextField.setBackground(Color.GRAY);*/
				dayTextField.setText(String.format("%td",new Date()));
				dayTextField.setHorizontalAlignment(SwingConstants.CENTER);
				GridBagConstraints gbc_dayTextField = new GridBagConstraints();
				gbc_dayTextField.insets = new Insets(0, 0, 0, 5);
				gbc_dayTextField.fill = GridBagConstraints.BOTH;
				gbc_dayTextField.gridx = 4;
				gbc_dayTextField.gridy = 0;
				dateInputPanel.add(dayTextField, gbc_dayTextField);
				dayTextField.setColumns(10);
			}
			{
				dayLable = new JLabel("\u65E5");
				GridBagConstraints gbc_dayLable = new GridBagConstraints();
				gbc_dayLable.gridx = 5;
				gbc_dayLable.gridy = 0;
				dateInputPanel.add(dayLable, gbc_dayLable);
			}
		}
		{
			operationLable = new JLabel("\u64CD\u4F5C");
			operationLable.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_operationLable = new GridBagConstraints();
			gbc_operationLable.fill = GridBagConstraints.BOTH;
			gbc_operationLable.insets = new Insets(0, 0, 5, 5);
			gbc_operationLable.gridx = 0;
			gbc_operationLable.gridy = 1;
			contentPanel.add(operationLable, gbc_operationLable);
		}
		{
			TypeButtonGroup = new JPanel();
		//	TypeButtonGroup.setBackground(Color.WHITE);
			GridBagConstraints gbc_TypeButtonGroup = new GridBagConstraints();
			gbc_TypeButtonGroup.insets = new Insets(0, 0, 5, 5);
			gbc_TypeButtonGroup.fill = GridBagConstraints.BOTH;
			gbc_TypeButtonGroup.gridx = 1;
			gbc_TypeButtonGroup.gridy = 1;
			contentPanel.add(TypeButtonGroup, gbc_TypeButtonGroup);
			TypeButtonGroup.setLayout(new GridLayout(0, 2, 0, 0));
			{
				buyRadioButton = new JRadioButton("\u8D2D\u4E70");
				buyRadioButton.setSelected(true);
				buyRadioButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						card.show(projPanel, "输入");
						selected = Record.Op.BUY;
						MoneyTextField.setEditable(true);
						//MoneyTextField.setText("请输入金额");
					}
				});
				TypeButtonGroup.add(buyRadioButton);
				buttongroup.add(buyRadioButton);
			}
			{
				redeenRadioButton = new JRadioButton("\u8D4E\u56DE");
				//redeenRadioButton.setForeground(Color.BLACK);
				redeenRadioButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						card.show(projPanel, "选择");
						selected = Record.Op.REDEEN;
						MoneyTextField.setEditable(false);
					//	MoneyTextField.setText("(此处无法输入)");
						comboBox.setModel(new ProjModel(records));
						comboBox.updateUI();
					}
				});
				TypeButtonGroup.add(redeenRadioButton);
				buttongroup.add(redeenRadioButton);
			}
		}
		{
			moneyLable = new JLabel("\u91D1\u989D");
			moneyLable.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_moneyLable = new GridBagConstraints();
			gbc_moneyLable.fill = GridBagConstraints.BOTH;
			gbc_moneyLable.insets = new Insets(0, 0, 5, 5);
			gbc_moneyLable.gridx = 0;
			gbc_moneyLable.gridy = 2;
			contentPanel.add(moneyLable, gbc_moneyLable);
		}
		{
			MoneyTextField = new JTextField();
			/*MoneyTextField.setBackground(Color.GRAY);
			MoneyTextField.setForeground(Color.WHITE);*/
			MoneyTextField.setHorizontalAlignment(SwingConstants.CENTER);
			//MoneyTextField.setText("\u8BF7\u8F93\u5165\u91D1\u989D");
			GridBagConstraints gbc_MoneyTextField = new GridBagConstraints();
			gbc_MoneyTextField.fill = GridBagConstraints.BOTH;
			gbc_MoneyTextField.insets = new Insets(0, 0, 5, 5);
			gbc_MoneyTextField.gridx = 1;
			gbc_MoneyTextField.gridy = 2;
			contentPanel.add(MoneyTextField, gbc_MoneyTextField);
			MoneyTextField.setColumns(10);
		}
		{
			projectLable = new JLabel("项目编号");
			projectLable.setHorizontalAlignment(SwingConstants.RIGHT);
			GridBagConstraints gbc_projectLable = new GridBagConstraints();
			gbc_projectLable.fill = GridBagConstraints.BOTH;
			gbc_projectLable.insets = new Insets(0, 0, 0, 5);
			gbc_projectLable.gridx = 0;
			gbc_projectLable.gridy = 3;
			contentPanel.add(projectLable, gbc_projectLable);
		}
		{
			projPanel = new JPanel();
			projPanel.setBorder(null);
		//	projPanel.setBackground(Color.WHITE);
			GridBagConstraints gbc_projPanel = new GridBagConstraints();
			gbc_projPanel.insets = new Insets(0, 0, 0, 5);
			gbc_projPanel.fill = GridBagConstraints.BOTH;
			gbc_projPanel.gridx = 1;
			gbc_projPanel.gridy = 3;
			contentPanel.add(projPanel, gbc_projPanel);
			card = new CardLayout(0, 0);
			projPanel.setLayout(card);
			{
				comboBox = new JComboBox<String>();
				/*comboBox.setForeground(Color.WHITE);
				comboBox.setBackground(Color.GRAY);*/
				comboBox.setEditable(false);
				projPanel.add(comboBox, "选择");
			}
			{
				ProjTextField = new JTextField();
				//ProjTextField.setBackground(Color.GRAY);
			//	ProjTextField.setForeground(Color.WHITE);
				projPanel.add(ProjTextField, "输入");
			//	ProjTextField.setText("\u8BF7\u8F93\u5165\u9879\u76EE\u7F16\u53F7");
				ProjTextField.setHorizontalAlignment(SwingConstants.CENTER);
				ProjTextField.setColumns(10);
			}
		}
		{
			//初始化默认值
			card.show(projPanel, "输入");
			selected = Record.Op.BUY;
		}
		{
			buttonPane = new JPanel();
			//buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				/*okButton.setBackground(Color.GRAY);
				okButton.setForeground(Color.WHITE);*/
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
						GregorianCalendar dateFromTextField = new GregorianCalendar(
										Integer.valueOf(yearTextField.getText()).intValue(), 
										Integer.valueOf(monthTextField.getText()).intValue() - 1,
										Integer.valueOf(dayTextField.getText()).intValue());
						
						if (selected == Record.Op.BUY) {
							if (!records.add(new Record(dateFromTextField, 
									selected,
									Double.valueOf(MoneyTextField.getText()).doubleValue(), 
									ProjTextField.getText()))){
								JOptionPane.showMessageDialog(getContentPane(),
										"账户余额不足!", "投资错误", JOptionPane.WARNING_MESSAGE);
								return;
							}
						}else{
							Record selectedRec = records.get(comboBox.getItemAt(comboBox.getSelectedIndex()));
							if(dateFromTextField.compareTo(selectedRec.getDate())>0) {
								records.redeen(selectedRec, dateFromTextField);
							}
							else{
								JOptionPane.showMessageDialog(getContentPane(),
										"赎回日期有误!", "赎回错误", JOptionPane.WARNING_MESSAGE);
								return;
							}
						}
						table.updateUI();
						outputTextField.setText(records.getAccount() + "");
						yearTextField.setText(String.format("%tY",new Date()));
						monthTextField.setText(String.format("%tm",new Date()));
						dayTextField.setText(String.format("%td",new Date()));
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancle");
			//	cancelButton.setForeground(Color.WHITE);
			//	cancelButton.setBackground(Color.GRAY);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						yearTextField.setText(String.format("%tY",new Date()));
						monthTextField.setText(String.format("%tm",new Date()));
						dayTextField.setText(String.format("%td",new Date()));
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	/*	getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { contentPanel,
						buttonPane, okButton, cancelButton }));*/
	}

	class ProjModel extends AbstractListModel<String> implements
			ComboBoxModel<String> {

		private ArrayList<Record> rec;
		private String now;

		public ProjModel(Records records) {
			rec = new ArrayList<Record>();
			for (Record element : records)
				if (!element.isRedeened() && element.getType() == Record.Op.BUY)
					rec.add(element);
		}

		@Override
		public int getSize() {
			return rec.size();
		}

		@Override
		public String getElementAt(int index) {
			return rec.get(index).getProject();
		}

		@Override
		public void setSelectedItem(Object anItem) {
			this.now = (String) anItem;

		}

		@Override
		public Object getSelectedItem() {
			return now;
		}
	}

}

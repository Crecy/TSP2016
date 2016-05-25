package Tongji;

import java.util.Date;

/*
 * ��������������Ŀ��
 */
public class Xiangmu {
	private String name; //��Ŀ����
	private String touziqixian; //Ͷ������
	private double shouzijiner; //Ͷ�ʽ��
	private double touzililv; //Ͷ������
	private  Date theDate;
	private double investMoney;
	private int id;
	
	public Xiangmu() {
		super();
		investMoney=0;
		theDate=null;
		name = null;
		
		
		touziqixian = null;
		shouzijiner = 0;
		touzililv = 0;	
	}
	
	public Xiangmu(Xiangmu tp){
		investMoney=tp.getInvestMoney();
		theDate=(Date) tp.getTheDate().clone();
		name=new String(tp.getName());
	}
	
	public Date getTheDate() {
		return theDate;
	}

	public void setTheDate(Date theDate) {
		this.theDate = theDate;
	}
	
	public double getInvestMoney() {
		return investMoney;
	}
	public void setInvestMoney(double investMoney) {
		this.investMoney = investMoney;
	}
	

	public void setName(String name){
		this.name = name;
		
	}
	
	public String getName(){
		return this.name;
		
	}
	
	public void setTouziqixian(String touziqixian){
		this.touziqixian = touziqixian;
		
	}
	
	public String getTouziqixian(){
		return this.touziqixian;
		
	}
	
	public void setShouzijiner(double shouzijiner){
		this.shouzijiner = shouzijiner;
		
	}
	
	public double getShouzijiner(){
		return this.shouzijiner;
		
	}
	
	public void setTouzililv(double touzililv){
		this.touzililv = touzililv;
		
	}
	
	public double getTouzililv(){
		return this.touzililv;
		
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}

}

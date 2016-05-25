package Tongji;

import java.util.Date;

/*
 * 该类用来描述项目的
 */
public class Xiangmu {
	private String name; //项目名称
	private String touziqixian; //投资期限
	private double shouzijiner; //投资金额
	private double touzililv; //投资利率
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

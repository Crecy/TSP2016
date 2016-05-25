package Qianggou;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ProjectData
{
	private int id;
	/**
	 * ���ӵĵ�ַ
	 */
	private String linkHref;
	/**
	 * ���ӵı���
	 */
	private String linkText;
	/**
	 * ժҪ
	 */
	private String summary;
	/**
	 * ����
	 */
	private String content;
	
	//private String interestRate;
	
	private String interestRate;//����
	
	private String investPeriod;//Ͷ������
	
	private String collectionMode;//���淽ʽ
	
	private String productAmount;//Ͷ�ʽ��
	
	private double investMoney;
	
	private Date theDate;
	
	//private Date beginDate;
	
	//private Date endDate;
	private String Name;

	public ProjectData() {
		super();
		// TODO Auto-generated constructor stub
		investMoney=0;
		//beginDate=null;
		//endDate=null;
		theDate=null;
		Name="";
	}
	
	public ProjectData(ProjectData tp){
		investMoney=tp.getInvestMoney();
		/*
		if(tp.getBeginDate()!=null){
			beginDate=(Date) tp.getBeginDate().clone();
			endDate=null;
		}
		else{
			endDate=(Date) tp.getEndDate().clone();
			beginDate=null;
		}*/
		
		theDate=(Date) tp.getTheDate().clone();
		
		Name=new String(tp.getName());
	}


	
	public Date getTheDate() {
		return theDate;
	}

	public void setTheDate(Date theDate) {
		this.theDate = theDate;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	/*
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}*/
	public double getInvestMoney() {
		return investMoney;
	}
	public void setInvestMoney(double investMoney) {
		this.investMoney = investMoney;
	}
	/*
	public String getBeginDateString(DateFormat ft) {
		return ft.format(beginDate);
	}
	public void setBeginDateString(DateFormat ft,String date) {
		try {
			this.beginDate = ft.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	@Override
	public String toString() {
		
		String res;
		/*
		if(endDate==null)
		res= "ProjectData :\n Name=" + Name  + "\n beginDate="
				+ beginDate + "\ninvestMoney=" + investMoney+ "\n************\n";
		else
			res= "ProjectData :\n Name=" + Name  + "\n endDate=" + endDate + "\ninvestMoney=" + investMoney+ "\n************\n";
		*/
		
		res="ProjectData :\n Name=" + Name  + "\n theDate=" + theDate + "\ninvestMoney=" + investMoney+ "\n************\n";
		return res;
	}



	/*public String getEndDateString(DateFormat ft) {
		return ft.format(endDate);
	}
	public void setEndDateString(DateFormat ft,String date) {
		try {
			this.beginDate = ft.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public String getInvestPeriod() {
		return investPeriod;
	}
	public void setInvestPeriod(String investPeriod) {
		this.investPeriod = investPeriod;
	}
	public String getCollectionMode() {
		return collectionMode;
	}
	public void setCollectionMode(String collectionMode) {
		this.collectionMode = collectionMode;
	}
	public String getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(String productAmount) {
		this.productAmount = productAmount;
	}
	public String getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(String interestRate) {
		this.interestRate = interestRate;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getLinkHref()
	{
		return linkHref;
	}
	public void setLinkHref(String linkHref)
	{
		this.linkHref = linkHref;
	}
	public String getLinkText()
	{
		return linkText;
	}
	public void setLinkText(String linkText)
	{
		this.linkText = linkText;
	}
	public String getSummary()
	{
		return summary;
	}
	public void setSummary(String summary)
	{
		this.summary = summary;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
}

package Shaixuan;

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
	
	public double getInvestMoney() {
		return investMoney;
	}
	public void setInvestMoney(double investMoney) {
		this.investMoney = investMoney;
	}
	
	
	@Override
	public String toString() {
		
		String res;
		res="ProjectData :\n Name=" + Name  + "\n theDate=" + theDate + "\ninvestMoney=" + investMoney+ "\n************\n";
		return res;
	}

	
	
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
	
	
	//�ⲿ����Ҫ�����������鿴��
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

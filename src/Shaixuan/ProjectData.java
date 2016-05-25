package Shaixuan;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ProjectData
{
	private int id;
	/**
	 * 链接的地址
	 */
	private String linkHref;
	/**
	 * 链接的标题
	 */
	private String linkText;
	/**
	 * 摘要
	 */
	private String summary;
	/**
	 * 内容
	 */
	private String content;
	
	//private String interestRate;
	
	private String interestRate;//利率
	
	private String investPeriod;//投资期限
	
	private String collectionMode;//收益方式
	
	private String productAmount;//投资金额
	
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
	
	
	//这部分需要？后面再来查看吧
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

package Tongji;

import java.util.GregorianCalendar;


public class Record {

	private boolean redeened;
	private GregorianCalendar redeenDay;

	public enum Op {
		BUY, REDEEN
	};

	private GregorianCalendar date;
	private Op type;
	private double money;
	private String project;
	private double profit;

	public Record(GregorianCalendar date, Op type, double money, String project) {
		this.date = date;
		this.type = type;
		this.money = money;
		this.project = project;
		if (type == Op.BUY)
			this.redeened = false;
		else
			this.redeened = true;
		this.profit = 0;
	}

	public boolean isRedeened(GregorianCalendar date) {
		if(redeened)
			if(date.compareTo(redeenDay)>=0)
				return true;
		return false;
	}
	
	public boolean isRedeened(){
		return redeened;
	}

	public void setRedeenDay(GregorianCalendar redeenDay) {
		this.redeenDay = redeenDay;
	}

	public boolean redeen(GregorianCalendar date) {
		if (!redeened && type == Op.BUY) {
			redeened = true;
			profit = this.getValue(date) - this.money;
			return true;
		}
		return false;
	}

	public boolean redeen(double values) {
		if (!redeened && type == Op.BUY) {
			redeened = true;
			profit = values - this.money;
			return true;
		}
		return false;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public double getMoney() {
		return money;
	}

	public Op getType() {
		return type;
	}

	public String getProject() {
		return project;
	}

	public double getValue(GregorianCalendar d) {
		if(d.compareTo(this.date)<=0){
			return money;
		}
		long day = (d.getTimeInMillis() - this.date.getTimeInMillis()) / 86400000;
		return money * (1 + 0.084) * day / 365;
	}

	public double getProfit() throws Exception {
		if (type != Op.BUY || !redeened) {
			throw new Exception("项目尚未结束，无法查看收益");
		}
		return profit;
	}
}

package Tongji;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SortedMap;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class Records extends ArrayList<Record> {

	private GregorianCalendar date;
	private double initialCash;

	private double account;

	public class Count {
		public double profit;
		public double investing;
		public double rateofprofit;

		public Count(double profit, double investing, double rateofprofit) {
			super();
			this.profit = profit;
			this.investing = investing;
			this.rateofprofit = rateofprofit;
		}
	}

	SortedMap<GregorianCalendar, Count> counts;

	private void deleteCounts(GregorianCalendar date) {
		if (counts.isEmpty())
			return;
		if (date.compareTo(counts.lastKey()) < 0) {
			Calendar key = (Calendar) date.clone();

			do {
				counts.remove(key);
				key.add(Calendar.DAY_OF_MONTH, 1);
			} while (counts.lastKey().compareTo((Calendar) key) > 0);
		}
	}

	public Records(GregorianCalendar date, double initialCash) {
		this.date = date;
		this.initialCash = this.account = initialCash;
		counts = new TreeMap<GregorianCalendar, Count>();
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public double getInitialCash() {
		return initialCash;
	}

	public double getAccount() {
		return account;
	}

	public boolean addAccount(double money) {
		this.account += money;
		if (this.account > 0)
			return true;
		else {
			this.account -= money;
			return false;
		}
	}

	public boolean redeen(Record rec, GregorianCalendar date) {
		// 删除已改变的统计内容
		deleteCounts(date);

		// ///////////////////////////////////////////////////////////////////////
		if (rec.redeen(rec.getValue(date))) {
			try {
				account += rec.getProfit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			super.add(new Record(date, Record.Op.REDEEN, rec.getValue(date),
					rec.getProject()));
			rec.setRedeenDay(date);
			return true;
		}
		return false;
	}

	public double investing(GregorianCalendar date) {

		double sum = 0;
		for (Record e : this) {
			if (e.getType() == Record.Op.BUY && !e.isRedeened(date))
				sum += e.getValue(date);
		}
		return sum;
	}

	public double countProfit(GregorianCalendar date) {
		double sum = 0;
		for (Record e : this) {
			if (e.getDate().compareTo(date) <= 0) {
				if (e.getType() == Record.Op.BUY) {
					if (!e.isRedeened(date))
						sum += e.getValue(date) - e.getMoney();
					else
						try {
							sum += e.getProfit();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
				}
			}
		}
		return sum;
	}

	public double rateOfReturn(GregorianCalendar date) {
		int day = (int)((date.getTimeInMillis() - this.date.getTimeInMillis()) / 86400000);
		return countProfit(date) / initialCash / day * 365;
	}

	public double rateOfReturn(double profit, GregorianCalendar date) {
		int day = (int)((date.getTimeInMillis() - this.date.getTimeInMillis()) / 86400000);
		return profit / initialCash / day * 365;
	}

	@Override
	public boolean add(Record e) {
		// 删除已改变的统计内容
		deleteCounts(e.getDate());

		// ////////////////////////////////////////////////////////////////////////
		if (e.getType() == Record.Op.BUY) {
			if (this.account > e.getMoney()) {
				this.account -= e.getMoney();
				return super.add(e);
			} else
				return false;
		} else {
			for (int index = 0; index != this.size(); index++) {
				Record rec = this.get(index);
				if (rec.getProject().compareTo(e.getProject()) == 0) {
					if (rec.redeen(e.getMoney())) {
						this.account += e.getMoney();
						rec.setRedeenDay(e.getDate());
						return super.add(e);
					}
				}
			}
			account += e.getMoney();
			return super.add(e);
		}
	}

	public Record get(String s) {
		for (Record e : this)
			if (e.getProject() == s)
				return e;
		return null;
	}

	public void clear() {
		this.date = new GregorianCalendar();
		this.initialCash = 0;
		this.account = 0;
		super.clear();
	}

	public ArrayList<Record> subRecords() {
		ArrayList<Record> rec = new ArrayList<Record>();
		for (Record element : this)
			if (!element.isRedeened() && element.getType() == Record.Op.BUY)
				rec.add(element);
		return rec;
	}

	public Count countByDate(GregorianCalendar date) {
		if (date == null)
			return null;
		if (counts.containsKey(date))
			return counts.get(date);
		else {
			date = (GregorianCalendar) date.clone();
			double profit = countProfit(date);
			Count aCount = new Count(profit, investing(date), rateOfReturn(
					profit, date));
			counts.put(date, aCount);
			return aCount;
		}
	}

	public GregorianCalendar getLastDay() {
		if (isEmpty())
			return null;
		GregorianCalendar date = null;
		for (Record e : this) {
			if (date == null || date.compareTo(e.getDate()) < 0)
				date = e.getDate();
		}
		return (GregorianCalendar) date.clone();
	}
}

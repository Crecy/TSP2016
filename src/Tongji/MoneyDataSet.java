package Tongji;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;


@SuppressWarnings("serial")
public class MoneyDataSet extends TimeSeriesCollection {

	public MoneyDataSet(Records records) {
		TimeSeries profit = new TimeSeries("收益");
		TimeSeries invest = new TimeSeries("投资");

		if (records.size() != 0) {
			GregorianCalendar key = records.getLastDay();
			do {
				Records.Count count = records.countByDate(key);
				Day day = new Day(key.get(GregorianCalendar.DAY_OF_MONTH),
						key.get(GregorianCalendar.MONTH) + 1, key.get(Calendar.YEAR));
				profit.add(day, count.profit);
				invest.add(day, count.investing);

				key.add(GregorianCalendar.DAY_OF_MONTH, -1);
			} while (key.compareTo(records.getDate()) >= 0);
		}

		addSeries(profit);
		addSeries(invest);
	}

}

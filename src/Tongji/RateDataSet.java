package Tongji;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;


@SuppressWarnings("serial")
public class RateDataSet extends TimeSeriesCollection {

	public RateDataSet(Records records) {
		TimeSeries rate = new TimeSeries("ÊÕÒæÂÊ");

		if (records.size() != 0) {
			GregorianCalendar key = records.getLastDay();
			do {
				Records.Count count = records.countByDate(key);
				Day day = new Day(key.get(GregorianCalendar.DAY_OF_MONTH),
						key.get(GregorianCalendar.MONTH) + 1, key.get(Calendar.YEAR));
			
				rate.add(day, count.rateofprofit);

				key.add(GregorianCalendar.DAY_OF_MONTH, -1);
			} while (key.compareTo(records.getDate()) > 0);
		}

		addSeries(rate);
	}
}


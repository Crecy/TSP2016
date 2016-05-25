package Tongji;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class RecordsModel extends AbstractTableModel {

	private Records data;

	public RecordsModel(Records data) {
		this.data = data;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			GregorianCalendar date = data.get(rowIndex).getDate();
			return "" + date.get(Calendar.YEAR)
					+ (date.get(Calendar.MONTH) + 1 > 9 ? "" : "0")
					+ (date.get(Calendar.MONTH) + 1)
					+ (date.get(Calendar.DAY_OF_MONTH) > 9 ? "" : "0")
					+ date.get(Calendar.DAY_OF_MONTH);
		case 1:
			return data.get(rowIndex).getType() == Record.Op.BUY ? "����" : "���";
		case 2:
			return data.get(rowIndex).getMoney();
		case 3:
			return data.get(rowIndex).getProject();
		default:
			return null;
		}
	}


	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "����";
		case 1:
			return "����";
		case 2:
			return "���";
		case 3:
			return "��Ŀ���";
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return Double.class;
		case 3:
			return String.class;
		default:
			return null;
		}
	}

}


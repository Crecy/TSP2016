package Tongji;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.GregorianCalendar;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Tongji.Record;
import Tongji.Records;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadFromExcel implements ActionListener {

	private String Url;
	private Records records;
	private JFileChooser fileDialog;
	private JTable table;
	private JTextField textField;
//	private JPanel chartpanel;

	public ReadFromExcel(JFileChooser fileDialog, JTable table,
			Records records, JTextField textField) {
		this.fileDialog = fileDialog;
		this.table = table;
		this.records = records;
		this.textField = textField;
		//this.chartpanel = chartpanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (fileDialog.showOpenDialog(table) == JFileChooser.APPROVE_OPTION) {
			Url = fileDialog.getSelectedFile().getPath();
		} else
			return;
		
		InputStream stream = null;
		Workbook rwb = null;

		try {
			stream = new FileInputStream(Url);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			rwb = Workbook.getWorkbook(stream);
		} catch (BiffException | IOException e1) {
			e1.printStackTrace();
		}

		Sheet sheet = rwb.getSheet(0);

		for (int i = 1; i < sheet.getRows(); i++) {

			String string = sheet.getCell(0, i).getContents();
			if (string.equals("")) {
				break;
			}
			GregorianCalendar date = new GregorianCalendar(Integer.valueOf(
					string.substring(0, 4)).intValue(), Integer.valueOf(
					string.substring(4, 6)).intValue() - 1, Integer.valueOf(
					string.substring(6, 8)).intValue(), 0, 0, 0);

			string = sheet.getCell(1, i).getContents();
			Record.Op type = string.equals("¹ºÂò") ? Record.Op.BUY
					: Record.Op.REDEEN;

			double money = Double.valueOf(sheet.getCell(2, i).getContents())
					.doubleValue();

			Record record = new Record(date, type, money, sheet.getCell(3, i)
					.getContents());
			
			records.add(record);
		}
		
		textField.setText(""+records.getAccount());
/*		chartpanel.removeAll();
		chartpanel.add((new LineChart(new MoneyDataSet(records), new RateDataSet(records)).getChartPanel()));
		chartpanel.revalidate();*/
		table.updateUI();
	}
}

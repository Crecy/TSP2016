package Tongji;

import java.awt.Color;
import java.awt.Font;
import java.nio.channels.Channel;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;

//�����������������ͼ��
public class LineChart {
	
	private JPanel chartpanel;

	public LineChart(XYDataset xydate, XYDataset xydataset2) {
		XYDataset xydataset = xydate;
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(
				null, "ʱ��", "���", xydataset, true, true,true);
		
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		
		//����������
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
		dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy��\nMM��dd��"));
		
		//����������������
		NumberAxis numberaxis = new NumberAxis("������");
		xyplot.setRangeAxis(1, numberaxis);
		xyplot.setDataset(1, xydataset2);
		xyplot.mapDatasetToRangeAxis(1, 1);
		XYItemRenderer renderer = new DefaultXYItemRenderer();
		
		//���Ӳ���
		renderer.setSeriesPaint(1, Color.BLACK);
		xyplot.setRenderer(1, renderer);
		
		chartpanel = new ChartPanel(jfreechart, true);
		((ChartPanel) chartpanel).setMouseZoomable(false);
		dateaxis.setLabelFont(new Font("����", Font.BOLD, 10)); // ˮƽ�ײ�����
		dateaxis.setTickLabelFont(new Font("����", Font.BOLD, 10)); // ��ֱ����
		ValueAxis rangeAxis = xyplot.getRangeAxis(0);// ��ȡ��״
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		jfreechart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		rangeAxis = xyplot.getRangeAxis(1);// ��ȡ��״
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		jfreechart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		//jfreechart.getTitle().setFont(new Font("����", Font.BOLD, 10));// ���ñ�������
		
	}
	
	public ChartPanel getChartPanel() {
		return (ChartPanel) chartpanel;
	}
}
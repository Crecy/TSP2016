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

//这个类是用来画曲线图的
public class LineChart {
	
	private JPanel chartpanel;

	public LineChart(XYDataset xydate, XYDataset xydataset2) {
		XYDataset xydataset = xydate;
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(
				null, "时间", "金额", xydataset, true, true,true);
		
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		
		//设置日期轴
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
		dateaxis.setDateFormatOverride(new SimpleDateFormat("yyyy年\nMM月dd日"));
		
		//创建收益率坐标轴
		NumberAxis numberaxis = new NumberAxis("收益率");
		xyplot.setRangeAxis(1, numberaxis);
		xyplot.setDataset(1, xydataset2);
		xyplot.mapDatasetToRangeAxis(1, 1);
		XYItemRenderer renderer = new DefaultXYItemRenderer();
		
		//增加部分
		renderer.setSeriesPaint(1, Color.BLACK);
		xyplot.setRenderer(1, renderer);
		
		chartpanel = new ChartPanel(jfreechart, true);
		((ChartPanel) chartpanel).setMouseZoomable(false);
		dateaxis.setLabelFont(new Font("黑体", Font.BOLD, 10)); // 水平底部标题
		dateaxis.setTickLabelFont(new Font("黑体", Font.BOLD, 10)); // 垂直标题
		ValueAxis rangeAxis = xyplot.getRangeAxis(0);// 获取柱状
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		rangeAxis = xyplot.getRangeAxis(1);// 获取柱状
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		//jfreechart.getTitle().setFont(new Font("宋体", Font.BOLD, 10));// 设置标题字体
		
	}
	
	public ChartPanel getChartPanel() {
		return (ChartPanel) chartpanel;
	}
}
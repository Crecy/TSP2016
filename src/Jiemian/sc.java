package Jiemian;

import java.io.File;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class sc {
	public sc() {
		if (DialogPanel.num==1)
		{
try {
// 打开文件
WritableWorkbook book = Workbook.createWorkbook( new File( " test.xls " ));
// 生成名为“第一页”的工作表，参数0表示这是第一页
WritableSheet sheet = book.createSheet( " 第一页 " , 0 );
// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
// 以及单元格内容为test
Label label = new Label( 0 , 0 , " 日期 " );
Label label1 = new Label( 1 , 0 , " 操作 " );
Label label2 = new Label( 2 , 0 , " 金额 " );
Label label3 = new Label( 3 , 0 , " 项目编号 " );
// 将定义好的单元格添加到工作表中
 sheet.addCell(label);
 sheet.addCell(label1);
 sheet.addCell(label2);
 sheet.addCell(label3);
 /**/ /*
 * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
 */
//System.out.println(DialogPanel.aaa);
//System.out.println(Shaixuan.bianhao);
 jxl.write.Label number = new jxl.write.Label( DialogPanel.aaa , DialogPanel.num , DialogPanel.year+"/"+DialogPanel.mon+"/"+DialogPanel.day );
 sheet.addCell(number);
 jxl.write.Label number1 = new jxl.write.Label( DialogPanel.aaa+1 , DialogPanel.num , "购买" );
 sheet.addCell(number1);
 jxl.write.Number number2 = new jxl.write.Number( DialogPanel.aaa+2 , DialogPanel.num , DialogPanel.jine);
 sheet.addCell(number2);
 jxl.write.Label number3 = new jxl.write.Label( DialogPanel.aaa+3 , DialogPanel.num , Shaixuan.bianhao );
 sheet.addCell(number3);
 book.write();
 book.close();

} catch (Exception e) {
System.out.println(e);
}
		} 
		else
try {
	// Excel获得文件
	Workbook wb = Workbook.getWorkbook( new File( " test.xls " ));
	// 打开一个文件的副本，并且指定数据写回到原文件
	WritableWorkbook book = Workbook.createWorkbook( new File( " test.xls " ),wb);
	// 添加一个工作表
	WritableSheet sheet = book.createSheet( " 第一页 " , 0 );

jxl.write.Label number = new jxl.write.Label( DialogPanel.aaa , DialogPanel.num , DialogPanel.year+"/"+DialogPanel.mon+"/"+DialogPanel.day );
sheet.addCell(number);
jxl.write.Label number1 = new jxl.write.Label( DialogPanel.aaa+1 , DialogPanel.num , "购买" );
sheet.addCell(number1);
jxl.write.Number number2 = new jxl.write.Number( DialogPanel.aaa+2 , DialogPanel.num , DialogPanel.jine);
sheet.addCell(number2);
jxl.write.Label number3 = new jxl.write.Label( DialogPanel.aaa+3 , DialogPanel.num , Shaixuan.bianhao );
sheet.addCell(number3);
book.write();
book.close();

	} catch (Exception e) {
	System.out.println(e);
	}
		
	}
}


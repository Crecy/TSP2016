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
// ���ļ�
WritableWorkbook book = Workbook.createWorkbook( new File( " test.xls " ));
// ������Ϊ����һҳ���Ĺ���������0��ʾ���ǵ�һҳ
WritableSheet sheet = book.createSheet( " ��һҳ " , 0 );
// ��Label����Ĺ�������ָ����Ԫ��λ���ǵ�һ�е�һ��(0,0)
// �Լ���Ԫ������Ϊtest
Label label = new Label( 0 , 0 , " ���� " );
Label label1 = new Label( 1 , 0 , " ���� " );
Label label2 = new Label( 2 , 0 , " ��� " );
Label label3 = new Label( 3 , 0 , " ��Ŀ��� " );
// ������õĵ�Ԫ����ӵ���������
 sheet.addCell(label);
 sheet.addCell(label1);
 sheet.addCell(label2);
 sheet.addCell(label3);
 /**/ /*
 * ����һ���������ֵĵ�Ԫ�� ����ʹ��Number��������·�����������﷨���� ��Ԫ��λ���ǵڶ��У���һ�У�ֵΪ789.123
 */
//System.out.println(DialogPanel.aaa);
//System.out.println(Shaixuan.bianhao);
 jxl.write.Label number = new jxl.write.Label( DialogPanel.aaa , DialogPanel.num , DialogPanel.year+"/"+DialogPanel.mon+"/"+DialogPanel.day );
 sheet.addCell(number);
 jxl.write.Label number1 = new jxl.write.Label( DialogPanel.aaa+1 , DialogPanel.num , "����" );
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
	// Excel����ļ�
	Workbook wb = Workbook.getWorkbook( new File( " test.xls " ));
	// ��һ���ļ��ĸ���������ָ������д�ص�ԭ�ļ�
	WritableWorkbook book = Workbook.createWorkbook( new File( " test.xls " ),wb);
	// ���һ��������
	WritableSheet sheet = book.createSheet( " ��һҳ " , 0 );

jxl.write.Label number = new jxl.write.Label( DialogPanel.aaa , DialogPanel.num , DialogPanel.year+"/"+DialogPanel.mon+"/"+DialogPanel.day );
sheet.addCell(number);
jxl.write.Label number1 = new jxl.write.Label( DialogPanel.aaa+1 , DialogPanel.num , "����" );
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


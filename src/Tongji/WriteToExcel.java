package Tongji;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

public class WriteToExcel extends JFrame {
	
/*	private String Url;
	private JFileChooser fileDialog;*/
/*	private JTable table;*/
    
	public WriteToExcel(JTable table) throws IOException{
		
		FileDialog fd = new FileDialog(this,"±£´æ¼ÇÂ¼",FileDialog.SAVE);
		fd.setLocation(400,250);
		fd.setVisible(true);
		String stringFile = fd.getDirectory()+fd.getFile()+".xls";
	
		TableModel model = table.getModel();
		BufferedWriter bWriter = new BufferedWriter(new FileWriter(stringFile));
		
		for(int i=0;i<model.getColumnCount();i++){
			bWriter.write(model.getColumnName(i));
			bWriter.write("\t");
		}
		bWriter.newLine();
		for(int i=0;i<model.getRowCount();i++){
			for(int j=0;j<model.getColumnCount();j++){
				bWriter.write(model.getValueAt(i,j).toString());
				bWriter.write("\t");
			}
			bWriter.newLine();
		
		}
		bWriter.close();	
		
	}

}

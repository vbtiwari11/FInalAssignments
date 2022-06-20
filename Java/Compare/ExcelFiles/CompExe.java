package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.binary.XSSFBSharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CompExe {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String excelpath1="./Data/data.xlsx";
		String excelpath2="./Data/target.xlsx";
		String[] c1= {"E_ID","Name","Salary"};
		String [] c2= {"EMP_ID","Name","Salary_credited"};
		XSSFWorkbook w1=new XSSFWorkbook(excelpath1);
		XSSFSheet s1=w1.getSheet("Sheet1");
		XSSFWorkbook w2=new XSSFWorkbook(excelpath2);
		XSSFSheet s2=w2.getSheet("Sheet1");
		 int rc1=s1.getPhysicalNumberOfRows();
		 int rc2=s2.getPhysicalNumberOfRows();
		 if(rc1==rc2) {
			 for(int i=0;i<rc1;i++) {
				 XSSFRow r1=s1.getRow(i);
				 XSSFRow r2=s2.getRow(i);
				 String idstr1="";
				 XSSFCell id1=r1.getCell(1);
				 if(id1!=null) {
					 id1.setCellType(CellType.STRING);
					 idstr1=id1.getStringCellValue();
				 }
				 String idstr2="";
				 XSSFCell id2=r2.getCell(1);
				 if(id2!=null) {
					 id2.setCellType(CellType.STRING);
					 idstr2=id2.getStringCellValue();
				 }
				 if(!idstr1.equals(idstr2)) {
					 System.out.println("diffrence:"+idstr1+" "+idstr2);
				 }
				 else {
					 System.out.println("No difference:"+idstr1+" "+idstr2);
				 }
			 }
		 }
		 else {
			 System.out.println("The data size differs");
		 }
		
	}

}

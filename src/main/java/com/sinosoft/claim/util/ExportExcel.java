package com.sinosoft.claim.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;

import com.sinosoft.utiall.blsvr.BLPrpDrisk;
import com.sinosoft.utility.ExportExcelExtenExtendTool;
import com.sinosoft.utility.PrpallUtility;

public class ExportExcel {
	private static String getArr = "get";
	private static String getSize = "size";		
	
	public static void ExportByPOI(HttpServletResponse response,
            HashMap titleHash,
            HashMap fieldHash,
            Object BLObject,
            String excelFileName,
            String strRiskCode,
            String registNo,
            String strUserCode
            ) throws Exception
	{   
		PrpallUtility prpallUtility = new PrpallUtility();
		prpallUtility.getPhisicaMemory(registNo);
		setReponse(response,excelFileName);
		
		HSSFWorkbook wb = new HSSFWorkbook();//����excel�ļ�
		HSSFSheet sheet = wb.createSheet();//����sheet
		
		sheet.setColumnWidth((short)0, (short)4000); //���
		sheet.setColumnWidth((short)1, (short)4000); //����
		sheet.setColumnWidth((short)2, (short)6000); //���֤��
		sheet.setColumnWidth((short)3, (short)3500); //��ϵ�绰
		sheet.setColumnWidth((short)4, (short)6000); //ʡ������
		sheet.setColumnWidth((short)5, (short)6000); //��������
		sheet.setColumnWidth((short)6, (short)7500); //�˺�����
		sheet.setColumnWidth((short)7, (short)5000); //���д���
		sheet.setColumnWidth((short)8, (short)7000); //�����˺�
		sheet.setColumnWidth((short)9, (short)15200); //�˺�����
		sheet.setColumnWidth((short)10, (short)6000); //��������
		sheet.setColumnWidth((short)11, (short)6000); //��ϵ��ַ
		sheet.setColumnWidth((short)12, (short)6000); //���
		sheet.setColumnWidth((short)13, (short)7000); //֧����ʽ
		sheet.setColumnWidth((short)14, (short)6000); //֧��ԭ��
		sheet.setColumnWidth((short)15, (short)6000); //��;˵��
		sheet.setColumnWidth((short)16, (short)6000); //���к�
		
		wb.setSheetName(0, "�⸶��Ϣ��������",HSSFWorkbook.ENCODING_UTF_16);//ȷ��sheet�ı���֧����������
		
		
		creatTitle(wb,sheet,titleHash,strRiskCode,registNo);//����excel��һ�еı����   
		creatData(wb,sheet,fieldHash,BLObject);//����excel�ĵ�������
		writeExcelByResponse(wb,response);//дexcel ���ݵ������
		prpallUtility.getPhisicaMemory(registNo);
	}
	
	 /**
	  * ���������� ע������Ǵ����� hashmap�еģ�key����������������ñ��������ڱ�������λ�� value ������б�����Ŀ
	  * @param sheet
	  * @param titleHash
	  */
	 private static  void creatTitle(HSSFWorkbook workbook,HSSFSheet sheet,HashMap titleHash,String strRiskCode,String strRegistNo)
	 { 
		 sheet.addMergedRegion(new Region(0,(short)0,2,(short)(titleHash.size()-1)));
		 sheet.addMergedRegion(new Region(3,(short)0,3,(short)(titleHash.size()-1)));
		 int rowHeight=500;//�и�25
		 
		 HSSFFont font0 = workbook.createFont();
		 font0.setFontName("����");
		 font0.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//������ʾ
		 font0.setFontHeightInPoints((short) 24);//���������С
		  
		 HSSFCellStyle titleStyle0 = workbook.createCellStyle();
		 titleStyle0.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
		 titleStyle0.setBorderLeft((short)1);
		 titleStyle0.setBorderRight((short)1);
		 titleStyle0.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
		 titleStyle0.setFillForegroundColor(HSSFColor.WHITE.index);
		 titleStyle0.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 titleStyle0.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 titleStyle0.setFont(font0);

		 java.util.Calendar cal = java.util.Calendar.getInstance();
		 int year = cal.get(java.util.Calendar.YEAR);
		 BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
		 String strRiskCName = "";
		 try{
			 strRiskCName = blPrpDrisk.translateCode(strRiskCode, true);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 HSSFRow row0 = sheet.createRow(( short ) 0 );//����excel�ı����У�Ĭ��Ϊ��һ��
		 row0.setHeight(( short )rowHeight);
		 HSSFCell cell0 = row0.createCell(( short ) 0 );
		 cell0.setEncoding(HSSFCell.ENCODING_UTF_16);	//ȷ����Ԫ��֧������	
		 cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
		 cell0.setCellValue(year +"��Ԫũҵ����֧���嵥("+strRiskCName+")");
		 cell0.setCellStyle(titleStyle0);
		 
		 HSSFFont font1 = workbook.createFont();
		 font1.setFontName("����");
		 font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//������ʾ
		 font1.setFontHeightInPoints((short) 16);//���������С
		  
		 HSSFCellStyle titleStyle1 = workbook.createCellStyle();
		 titleStyle1.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
		 titleStyle1.setBorderLeft((short)1);
		 titleStyle1.setBorderRight((short)1);
		 titleStyle1.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
		 titleStyle1.setFillForegroundColor(HSSFColor.WHITE.index);
		 titleStyle1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 titleStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 titleStyle1.setFont(font1);
		 
		 HSSFRow row1 = sheet.createRow(( short ) 3 );//����excel�ı����У�Ĭ��Ϊ��һ��
		 row1.setHeight(( short )rowHeight);
		 HSSFCell cell1 = row1.createCell(( short ) 0 );
		 cell1.setEncoding(HSSFCell.ENCODING_UTF_16);	//ȷ����Ԫ��֧������	
		 cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
		 cell1.setCellValue("("+strRegistNo+")");
		 cell1.setCellStyle(titleStyle1);


		 HSSFFont font = workbook.createFont();
		 font.setFontName("����");
		 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//������ʾ
		 font.setFontHeightInPoints((short) 10);//���������С
		  
		 HSSFCellStyle titleStyle = workbook.createCellStyle();
		 titleStyle.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
		 titleStyle.setBorderLeft((short)1);
		 titleStyle.setBorderRight((short)1);
		 titleStyle.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
		 titleStyle.setFillForegroundColor(HSSFColor.WHITE.index);
		 titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 titleStyle.setFont(font);
		 
		 HSSFRow row = sheet.createRow(( short ) 4 );//����excel�ı����У�Ĭ��Ϊ��һ��
		 row.setHeight(( short )rowHeight);
		 //������⼯�������ݣ�Ҳ����û�б���������ô����һ��Ĭ�ϱ���,Ĭ�ϱ���10�����ֱ�Ϊ��һ��.....��ʮ��
		 if(titleHash==null||titleHash.size()==0)
		 {
			 for(int i=0;i<10;i++)
			 {
				 HSSFCell cell = row.createCell(( short ) i );
				 cell.setEncoding(HSSFCell.ENCODING_UTF_16);	//ȷ����Ԫ��֧������	
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue("��"+i+"��");
				 cell.setCellStyle(titleStyle);
			 }
		 }
		 else
		 {		 
			 Collection keySet = titleHash.keySet();	 
			 Iterator it = keySet.iterator();
			 while(it.hasNext())
			 { 
				 String   index = (String)it.next();
				 String   indexName = (String) titleHash.get(index);
				 HSSFCell cell = row.createCell( (short) Short.parseShort(index) );
				 cell.setEncoding(HSSFCell.ENCODING_UTF_16);	//ȷ����Ԫ��֧������	
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue(indexName); 
				 cell.setCellStyle(titleStyle);
			 }
			 
		 }
	 }
	 
	 private static void creatData(HSSFWorkbook workbook,HSSFSheet sheet,HashMap fieldHash,Object BLObject) throws Exception
	 {
		
		 int rowHeight=500;//�и�25
		 HSSFCellStyle dataStyle = workbook.createCellStyle();
		 dataStyle.setBorderBottom((short)1);
	     dataStyle.setBorderLeft((short)1);
		 dataStyle.setBorderRight((short)1);
		 dataStyle.setBorderTop((short)1);
		 dataStyle.setFillForegroundColor(HSSFColor.WHITE.index);
		 dataStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 dataStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		 HSSFDataFormat format = workbook.createDataFormat();               
		 dataStyle.setDataFormat(format.getFormat("@"));  
		 
		 String className = BLObject.getClass().getName();//��ȡ���ݶ��������������
		 Method getSizeMethod = Class.forName(className).getDeclaredMethod(getSize, null);//��ȡ����Դ�Ĵ�С�ķ���
		 Class[] parameterTypes  = new Class[]{int.class};
		 Method getArrMethod  = Class.forName(className).getDeclaredMethod(getArr, parameterTypes);//��ȡÿ�����ݵķ���
		 int t = ((Integer)getSizeMethod.invoke(BLObject, null)).intValue();//��ȡ��������
		 for(int m = 0;m<t;m++)
		 {
			 HSSFRow row = sheet.createRow((short) (m+5) );//����һ������
			 row.setHeight(( short )rowHeight);
			 Integer  intt =new Integer (m);
			 Object[] parameter = new Object[]{intt};
			 Object objSchema = getArrMethod.invoke(BLObject, parameter);//��ȡ��һ������	
			 
			 Collection keySet = fieldHash.keySet();	 
			 Iterator it = keySet.iterator();
			 while(it.hasNext())
			 {
  				 String   index = (String)it.next();
				 String fieldValue = "";
				 String fieldName  = "";
				 if(Integer.parseInt(index)<0)//����ȡֵ������ֱ��ȡֵ���������
				 {
					 String arrTemp = (String) fieldHash.get(index);
					 fieldValue = ExportExcelExtenExtendTool.getExceptionalValue(objSchema, Integer.parseInt(index),intt);
					 index = arrTemp;
				 }
				 else
				 {
					fieldName= (String) fieldHash.get(index);
				    String getFieldMethodName = "get"+fieldName.trim();
				    Method getFieldMethod = Class.forName(objSchema.getClass().getName()).getDeclaredMethod(getFieldMethodName, null);
				    fieldValue = ((Object)getFieldMethod.invoke(objSchema, null)).toString();
				 }
				 
				 
				 HSSFCell cell = row.createCell((short)Short.parseShort(index));//����һ������
				 cell.setCellStyle(dataStyle);
				 cell.setEncoding(HSSFCell.ENCODING_UTF_16);//ȷ����Ԫ��֧������
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue(fieldValue);
			 }
		 }
	 }
	 
	 /**
	  * ��excel д�뵽�������
	  * @param wb  ����д���excel �ļ�
	  * @param response  ����������󣬿����� �ļ�������������������������չʹ��
	  * @throws IOException
	  */
	 private static void writeExcelByResponse(HSSFWorkbook wb,HttpServletResponse response) throws IOException
	 {
	     wb.write(response.getOutputStream());
	     response.getOutputStream().flush();
	     response.getOutputStream().close();
	 }	 
	
	 /**
	  * ����reponse ͷ����Ϣ�����÷�����Ϣ�Լ����ص��ļ�����
	  * @param response
	  * @param excelFileName
	  * @throws UnsupportedEncodingException
	  */
	 private static void setReponse(HttpServletResponse response,String excelFileName) throws UnsupportedEncodingException
	 {
		    response.reset();//�˺����ز����٣�who �ܱ�֤�κ�ʱ�� response��buffer���ǿյģ���������ܱ�֤����ô�㽫�õ�һ�����벻����excel��
		    response.setContentType("application/vnd.ms-excel;charset=gb2312");//��֤excel��ʽ�Լ�����֧��	    
		    String FileName = getExcelName(excelFileName);   
		    response.setHeader("Content-Disposition" ,"attachment;filename=\""+new String(FileName.getBytes(),"ISO-8859-1")+"\""); //ȷ��excel �ļ�֧������ 
	 }
	 /**
	  * ��ȡ���ص�excel ������ �����Զ�У������Ŷ
	  * @param excelFileName
	  * @return
	  */
	 private static String getExcelName(String excelFileName)
	 {
		 String fileName = excelFileName;
		 if(fileName==null||fileName.trim().equals(""))
		 {
			 fileName = "test.xls";
		 }
		 else if(!fileName.endsWith(".xls"))
		 {
	      fileName = fileName +".xls";
		 }
		 return fileName;
	 }
	 
	 public static void ExportByPOI(HttpServletResponse response,
	            HashMap titleHash,
	            HashMap fieldHash,
	            Object BLObject,
	            String excelFileName,
	            String strRiskCode,
	            String registNo,
	            String compensateNo,
	            String strUserCode
	            ) throws Exception
		{   
			PrpallUtility prpallUtility = new PrpallUtility();
			prpallUtility.getPhisicaMemory(registNo);
			setReponse(response,excelFileName);
			
			HSSFWorkbook wb = new HSSFWorkbook();//����excel�ļ�
			HSSFSheet sheet = wb.createSheet();//����sheet
			
			sheet.setColumnWidth((short)0, (short)4000); //���
			sheet.setColumnWidth((short)1, (short)4000); //����
			sheet.setColumnWidth((short)2, (short)6000); //���֤��
			sheet.setColumnWidth((short)3, (short)3500); //��ϵ�绰
			sheet.setColumnWidth((short)4, (short)6000); //ʡ������
			sheet.setColumnWidth((short)5, (short)6000); //��������
			sheet.setColumnWidth((short)6, (short)7500); //�˺�����
			sheet.setColumnWidth((short)7, (short)5000); //���д���
			sheet.setColumnWidth((short)8, (short)7000); //�����˺�
			sheet.setColumnWidth((short)9, (short)15200); //�˺�����
			sheet.setColumnWidth((short)10, (short)6000); //��������
			sheet.setColumnWidth((short)11, (short)6000); //��ϵ��ַ
			sheet.setColumnWidth((short)12, (short)6000); //���
			sheet.setColumnWidth((short)13, (short)7000); //֧����ʽ
			sheet.setColumnWidth((short)14, (short)6000); //֧��ԭ��
			sheet.setColumnWidth((short)15, (short)6000); //��;˵��
			sheet.setColumnWidth((short)16, (short)6000); //���к�
			
			wb.setSheetName(0, "�⸶��Ϣ��������",HSSFWorkbook.ENCODING_UTF_16);//ȷ��sheet�ı���֧����������
			
			
			creatTitle(wb,sheet,titleHash,strRiskCode,registNo,compensateNo);//����excel��һ�еı����   
			creatData(wb,sheet,fieldHash,BLObject);//����excel�ĵ�������
			writeExcelByResponse(wb,response);//дexcel ���ݵ������
			prpallUtility.getPhisicaMemory(registNo+","+compensateNo);
		}
		
		 /**
		  * ���������� ע������Ǵ����� hashmap�еģ�key����������������ñ��������ڱ�������λ�� value ������б�����Ŀ
		  * @param sheet
		  * @param titleHash
		  */
		 private static  void creatTitle(HSSFWorkbook workbook,HSSFSheet sheet,HashMap titleHash,String strRiskCode,String strRegistNo,String strCompensateNo)
		 { 
			 sheet.addMergedRegion(new Region(0,(short)0,2,(short)(titleHash.size()-1)));
			 sheet.addMergedRegion(new Region(3,(short)0,3,(short)(titleHash.size()-1)));
			 int rowHeight=500;//�и�25
			 
			 HSSFFont font0 = workbook.createFont();
			 font0.setFontName("����");
			 font0.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//������ʾ
			 font0.setFontHeightInPoints((short) 24);//���������С
			  
			 HSSFCellStyle titleStyle0 = workbook.createCellStyle();
			 titleStyle0.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
			 titleStyle0.setBorderLeft((short)1);
			 titleStyle0.setBorderRight((short)1);
			 titleStyle0.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
			 titleStyle0.setFillForegroundColor(HSSFColor.WHITE.index);
			 titleStyle0.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			 titleStyle0.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 titleStyle0.setFont(font0);

			 java.util.Calendar cal = java.util.Calendar.getInstance();
			 int year = cal.get(java.util.Calendar.YEAR);
			 BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
			 String strRiskCName = "";
			 try{
				 strRiskCName = blPrpDrisk.translateCode(strRiskCode, true);
			 }catch(Exception e){
				 e.printStackTrace();
			 }
			 HSSFRow row0 = sheet.createRow(( short ) 0 );//����excel�ı����У�Ĭ��Ϊ��һ��
			 row0.setHeight(( short )rowHeight);
			 HSSFCell cell0 = row0.createCell(( short ) 0 );
			 cell0.setEncoding(HSSFCell.ENCODING_UTF_16);	//ȷ����Ԫ��֧������	
			 cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
			 cell0.setCellValue(year +"��Ԫũҵ����֧���嵥("+strRiskCName+")");
			 cell0.setCellStyle(titleStyle0);
			 
			 HSSFFont font1 = workbook.createFont();
			 font1.setFontName("����");
			 font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//������ʾ
			 font1.setFontHeightInPoints((short) 16);//���������С
			  
			 HSSFCellStyle titleStyle1 = workbook.createCellStyle();
			 titleStyle1.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
			 titleStyle1.setBorderLeft((short)1);
			 titleStyle1.setBorderRight((short)1);
			 titleStyle1.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
			 titleStyle1.setFillForegroundColor(HSSFColor.WHITE.index);
			 titleStyle1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			 titleStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 titleStyle1.setFont(font1);
			 
			 HSSFRow row1 = sheet.createRow(( short ) 3 );//����excel�ı����У�Ĭ��Ϊ��һ��
			 row1.setHeight(( short )rowHeight);
			 HSSFCell cell1 = row1.createCell(( short ) 0 );
			 cell1.setEncoding(HSSFCell.ENCODING_UTF_16);	//ȷ����Ԫ��֧������	
			 cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
			 cell1.setCellValue("("+strRegistNo+"),("+strCompensateNo+")");
			 cell1.setCellStyle(titleStyle1);


			 HSSFFont font = workbook.createFont();
			 font.setFontName("����");
			 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//������ʾ
			 font.setFontHeightInPoints((short) 10);//���������С
			  
			 HSSFCellStyle titleStyle = workbook.createCellStyle();
			 titleStyle.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
			 titleStyle.setBorderLeft((short)1);
			 titleStyle.setBorderRight((short)1);
			 titleStyle.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
			 titleStyle.setFillForegroundColor(HSSFColor.WHITE.index);
			 titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			 titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 titleStyle.setFont(font);
			 
			 HSSFRow row = sheet.createRow(( short ) 4 );//����excel�ı����У�Ĭ��Ϊ��һ��
			 row.setHeight(( short )rowHeight);
			 //������⼯�������ݣ�Ҳ����û�б���������ô����һ��Ĭ�ϱ���,Ĭ�ϱ���10�����ֱ�Ϊ��һ��.....��ʮ��
			 if(titleHash==null||titleHash.size()==0)
			 {
				 for(int i=0;i<10;i++)
				 {
					 HSSFCell cell = row.createCell(( short ) i );
					 cell.setEncoding(HSSFCell.ENCODING_UTF_16);	//ȷ����Ԫ��֧������	
					 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					 cell.setCellValue("��"+i+"��");
					 cell.setCellStyle(titleStyle);
				 }
			 }
			 else
			 {		 
				 Collection keySet = titleHash.keySet();	 
				 Iterator it = keySet.iterator();
				 while(it.hasNext())
				 { 
					 String   index = (String)it.next();
					 String   indexName = (String) titleHash.get(index);
					 HSSFCell cell = row.createCell( (short) Short.parseShort(index) );
					 cell.setEncoding(HSSFCell.ENCODING_UTF_16);	//ȷ����Ԫ��֧������	
					 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					 cell.setCellValue(indexName); 
					 cell.setCellStyle(titleStyle);
				 }
				 
			 }
		 }
}

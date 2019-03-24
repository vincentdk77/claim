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
		
		HSSFWorkbook wb = new HSSFWorkbook();//创建excel文件
		HSSFSheet sheet = wb.createSheet();//创建sheet
		
		sheet.setColumnWidth((short)0, (short)4000); //序号
		sheet.setColumnWidth((short)1, (short)4000); //姓名
		sheet.setColumnWidth((short)2, (short)6000); //身份证号
		sheet.setColumnWidth((short)3, (short)3500); //联系电话
		sheet.setColumnWidth((short)4, (short)6000); //省份名称
		sheet.setColumnWidth((short)5, (short)6000); //城市名称
		sheet.setColumnWidth((short)6, (short)7500); //账号属性
		sheet.setColumnWidth((short)7, (short)5000); //银行大类
		sheet.setColumnWidth((short)8, (short)7000); //银行账号
		sheet.setColumnWidth((short)9, (short)15200); //账号类型
		sheet.setColumnWidth((short)10, (short)6000); //开户银行
		sheet.setColumnWidth((short)11, (short)6000); //联系地址
		sheet.setColumnWidth((short)12, (short)6000); //金额
		sheet.setColumnWidth((short)13, (short)7000); //支付方式
		sheet.setColumnWidth((short)14, (short)6000); //支付原因
		sheet.setColumnWidth((short)15, (short)6000); //用途说明
		sheet.setColumnWidth((short)16, (short)6000); //联行号
		
		wb.setSheetName(0, "赔付信息导出数据",HSSFWorkbook.ENCODING_UTF_16);//确保sheet的标题支持中文名称
		
		
		creatTitle(wb,sheet,titleHash,strRiskCode,registNo);//创建excel第一行的标的栏   
		creatData(wb,sheet,fieldHash,BLObject);//创建excel的导出数据
		writeExcelByResponse(wb,response);//写excel 数据到输出流
		prpallUtility.getPhisicaMemory(registNo);
	}
	
	 /**
	  * 创建标题栏 注意标题是存贮在 hashmap中的，key必须是整数，代表该标题列所在标题栏的位置 value 代表该列标题题目
	  * @param sheet
	  * @param titleHash
	  */
	 private static  void creatTitle(HSSFWorkbook workbook,HSSFSheet sheet,HashMap titleHash,String strRiskCode,String strRegistNo)
	 { 
		 sheet.addMergedRegion(new Region(0,(short)0,2,(short)(titleHash.size()-1)));
		 sheet.addMergedRegion(new Region(3,(short)0,3,(short)(titleHash.size()-1)));
		 int rowHeight=500;//行高25
		 
		 HSSFFont font0 = workbook.createFont();
		 font0.setFontName("宋体");
		 font0.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		 font0.setFontHeightInPoints((short) 24);//设置字体大小
		  
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
		 HSSFRow row0 = sheet.createRow(( short ) 0 );//创建excel的标题行，默认为第一行
		 row0.setHeight(( short )rowHeight);
		 HSSFCell cell0 = row0.createCell(( short ) 0 );
		 cell0.setEncoding(HSSFCell.ENCODING_UTF_16);	//确保单元格支持中文	
		 cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
		 cell0.setCellValue(year +"国元农业保险支付清单("+strRiskCName+")");
		 cell0.setCellStyle(titleStyle0);
		 
		 HSSFFont font1 = workbook.createFont();
		 font1.setFontName("宋体");
		 font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		 font1.setFontHeightInPoints((short) 16);//设置字体大小
		  
		 HSSFCellStyle titleStyle1 = workbook.createCellStyle();
		 titleStyle1.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
		 titleStyle1.setBorderLeft((short)1);
		 titleStyle1.setBorderRight((short)1);
		 titleStyle1.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
		 titleStyle1.setFillForegroundColor(HSSFColor.WHITE.index);
		 titleStyle1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 titleStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 titleStyle1.setFont(font1);
		 
		 HSSFRow row1 = sheet.createRow(( short ) 3 );//创建excel的标题行，默认为第一行
		 row1.setHeight(( short )rowHeight);
		 HSSFCell cell1 = row1.createCell(( short ) 0 );
		 cell1.setEncoding(HSSFCell.ENCODING_UTF_16);	//确保单元格支持中文	
		 cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
		 cell1.setCellValue("("+strRegistNo+")");
		 cell1.setCellStyle(titleStyle1);


		 HSSFFont font = workbook.createFont();
		 font.setFontName("宋体");
		 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
		 font.setFontHeightInPoints((short) 10);//设置字体大小
		  
		 HSSFCellStyle titleStyle = workbook.createCellStyle();
		 titleStyle.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
		 titleStyle.setBorderLeft((short)1);
		 titleStyle.setBorderRight((short)1);
		 titleStyle.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
		 titleStyle.setFillForegroundColor(HSSFColor.WHITE.index);
		 titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 titleStyle.setFont(font);
		 
		 HSSFRow row = sheet.createRow(( short ) 4 );//创建excel的标题行，默认为第一行
		 row.setHeight(( short )rowHeight);
		 //如果标题集中无数据，也就是没有标题栏，那么创建一个默认标题,默认标题10栏，分别为第一列.....第十列
		 if(titleHash==null||titleHash.size()==0)
		 {
			 for(int i=0;i<10;i++)
			 {
				 HSSFCell cell = row.createCell(( short ) i );
				 cell.setEncoding(HSSFCell.ENCODING_UTF_16);	//确保单元格支持中文	
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue("第"+i+"列");
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
				 cell.setEncoding(HSSFCell.ENCODING_UTF_16);	//确保单元格支持中文	
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue(indexName); 
				 cell.setCellStyle(titleStyle);
			 }
			 
		 }
	 }
	 
	 private static void creatData(HSSFWorkbook workbook,HSSFSheet sheet,HashMap fieldHash,Object BLObject) throws Exception
	 {
		
		 int rowHeight=500;//行高25
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
		 
		 String className = BLObject.getClass().getName();//获取数据对象的完整类名称
		 Method getSizeMethod = Class.forName(className).getDeclaredMethod(getSize, null);//获取数据源的大小的方法
		 Class[] parameterTypes  = new Class[]{int.class};
		 Method getArrMethod  = Class.forName(className).getDeclaredMethod(getArr, parameterTypes);//获取每条数据的方法
		 int t = ((Integer)getSizeMethod.invoke(BLObject, null)).intValue();//获取数据条数
		 for(int m = 0;m<t;m++)
		 {
			 HSSFRow row = sheet.createRow((short) (m+5) );//创建一行数据
			 row.setHeight(( short )rowHeight);
			 Integer  intt =new Integer (m);
			 Object[] parameter = new Object[]{intt};
			 Object objSchema = getArrMethod.invoke(BLObject, parameter);//获取到一条数据	
			 
			 Collection keySet = fieldHash.keySet();	 
			 Iterator it = keySet.iterator();
			 while(it.hasNext())
			 {
  				 String   index = (String)it.next();
				 String fieldValue = "";
				 String fieldName  = "";
				 if(Integer.parseInt(index)<0)//特殊取值，不能直接取值的例外情况
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
				 
				 
				 HSSFCell cell = row.createCell((short)Short.parseShort(index));//创建一列数据
				 cell.setCellStyle(dataStyle);
				 cell.setEncoding(HSSFCell.ENCODING_UTF_16);//确保单元格支持中文
				 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				 cell.setCellValue(fieldValue);
			 }
		 }
	 }
	 
	 /**
	  * 将excel 写入到输出流中
	  * @param wb  即将写入的excel 文件
	  * @param response  数据输出对象，可以是 文件，等其他输出流，这里可以扩展使用
	  * @throws IOException
	  */
	 private static void writeExcelByResponse(HSSFWorkbook wb,HttpServletResponse response) throws IOException
	 {
	     wb.write(response.getOutputStream());
	     response.getOutputStream().flush();
	     response.getOutputStream().close();
	 }	 
	
	 /**
	  * 设置reponse 头部信息，设置返回信息以及下载的文件名称
	  * @param response
	  * @param excelFileName
	  * @throws UnsupportedEncodingException
	  */
	 private static void setReponse(HttpServletResponse response,String excelFileName) throws UnsupportedEncodingException
	 {
		    response.reset();//此函数必不可少，who 能保证任何时候 response的buffer都是空的？？如果不能保证，那么你将得到一个意想不到的excel！
		    response.setContentType("application/vnd.ms-excel;charset=gb2312");//保证excel格式以及中文支持	    
		    String FileName = getExcelName(excelFileName);   
		    response.setHeader("Content-Disposition" ,"attachment;filename=\""+new String(FileName.getBytes(),"ISO-8859-1")+"\""); //确保excel 文件支持中文 
	 }
	 /**
	  * 获取下载的excel 的名称 附带自动校正功能哦
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
			
			HSSFWorkbook wb = new HSSFWorkbook();//创建excel文件
			HSSFSheet sheet = wb.createSheet();//创建sheet
			
			sheet.setColumnWidth((short)0, (short)4000); //序号
			sheet.setColumnWidth((short)1, (short)4000); //姓名
			sheet.setColumnWidth((short)2, (short)6000); //身份证号
			sheet.setColumnWidth((short)3, (short)3500); //联系电话
			sheet.setColumnWidth((short)4, (short)6000); //省份名称
			sheet.setColumnWidth((short)5, (short)6000); //城市名称
			sheet.setColumnWidth((short)6, (short)7500); //账号属性
			sheet.setColumnWidth((short)7, (short)5000); //银行大类
			sheet.setColumnWidth((short)8, (short)7000); //银行账号
			sheet.setColumnWidth((short)9, (short)15200); //账号类型
			sheet.setColumnWidth((short)10, (short)6000); //开户银行
			sheet.setColumnWidth((short)11, (short)6000); //联系地址
			sheet.setColumnWidth((short)12, (short)6000); //金额
			sheet.setColumnWidth((short)13, (short)7000); //支付方式
			sheet.setColumnWidth((short)14, (short)6000); //支付原因
			sheet.setColumnWidth((short)15, (short)6000); //用途说明
			sheet.setColumnWidth((short)16, (short)6000); //联行号
			
			wb.setSheetName(0, "赔付信息导出数据",HSSFWorkbook.ENCODING_UTF_16);//确保sheet的标题支持中文名称
			
			
			creatTitle(wb,sheet,titleHash,strRiskCode,registNo,compensateNo);//创建excel第一行的标的栏   
			creatData(wb,sheet,fieldHash,BLObject);//创建excel的导出数据
			writeExcelByResponse(wb,response);//写excel 数据到输出流
			prpallUtility.getPhisicaMemory(registNo+","+compensateNo);
		}
		
		 /**
		  * 创建标题栏 注意标题是存贮在 hashmap中的，key必须是整数，代表该标题列所在标题栏的位置 value 代表该列标题题目
		  * @param sheet
		  * @param titleHash
		  */
		 private static  void creatTitle(HSSFWorkbook workbook,HSSFSheet sheet,HashMap titleHash,String strRiskCode,String strRegistNo,String strCompensateNo)
		 { 
			 sheet.addMergedRegion(new Region(0,(short)0,2,(short)(titleHash.size()-1)));
			 sheet.addMergedRegion(new Region(3,(short)0,3,(short)(titleHash.size()-1)));
			 int rowHeight=500;//行高25
			 
			 HSSFFont font0 = workbook.createFont();
			 font0.setFontName("宋体");
			 font0.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
			 font0.setFontHeightInPoints((short) 24);//设置字体大小
			  
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
			 HSSFRow row0 = sheet.createRow(( short ) 0 );//创建excel的标题行，默认为第一行
			 row0.setHeight(( short )rowHeight);
			 HSSFCell cell0 = row0.createCell(( short ) 0 );
			 cell0.setEncoding(HSSFCell.ENCODING_UTF_16);	//确保单元格支持中文	
			 cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
			 cell0.setCellValue(year +"国元农业保险支付清单("+strRiskCName+")");
			 cell0.setCellStyle(titleStyle0);
			 
			 HSSFFont font1 = workbook.createFont();
			 font1.setFontName("宋体");
			 font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
			 font1.setFontHeightInPoints((short) 16);//设置字体大小
			  
			 HSSFCellStyle titleStyle1 = workbook.createCellStyle();
			 titleStyle1.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
			 titleStyle1.setBorderLeft((short)1);
			 titleStyle1.setBorderRight((short)1);
			 titleStyle1.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
			 titleStyle1.setFillForegroundColor(HSSFColor.WHITE.index);
			 titleStyle1.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			 titleStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 titleStyle1.setFont(font1);
			 
			 HSSFRow row1 = sheet.createRow(( short ) 3 );//创建excel的标题行，默认为第一行
			 row1.setHeight(( short )rowHeight);
			 HSSFCell cell1 = row1.createCell(( short ) 0 );
			 cell1.setEncoding(HSSFCell.ENCODING_UTF_16);	//确保单元格支持中文	
			 cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
			 cell1.setCellValue("("+strRegistNo+"),("+strCompensateNo+")");
			 cell1.setCellStyle(titleStyle1);


			 HSSFFont font = workbook.createFont();
			 font.setFontName("宋体");
			 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
			 font.setFontHeightInPoints((short) 10);//设置字体大小
			  
			 HSSFCellStyle titleStyle = workbook.createCellStyle();
			 titleStyle.setBorderBottom(HSSFCellStyle.BORDER_DOUBLE);
			 titleStyle.setBorderLeft((short)1);
			 titleStyle.setBorderRight((short)1);
			 titleStyle.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
			 titleStyle.setFillForegroundColor(HSSFColor.WHITE.index);
			 titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			 titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			 titleStyle.setFont(font);
			 
			 HSSFRow row = sheet.createRow(( short ) 4 );//创建excel的标题行，默认为第一行
			 row.setHeight(( short )rowHeight);
			 //如果标题集中无数据，也就是没有标题栏，那么创建一个默认标题,默认标题10栏，分别为第一列.....第十列
			 if(titleHash==null||titleHash.size()==0)
			 {
				 for(int i=0;i<10;i++)
				 {
					 HSSFCell cell = row.createCell(( short ) i );
					 cell.setEncoding(HSSFCell.ENCODING_UTF_16);	//确保单元格支持中文	
					 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					 cell.setCellValue("第"+i+"列");
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
					 cell.setEncoding(HSSFCell.ENCODING_UTF_16);	//确保单元格支持中文	
					 cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					 cell.setCellValue(indexName); 
					 cell.setCellStyle(titleStyle);
				 }
				 
			 }
		 }
}

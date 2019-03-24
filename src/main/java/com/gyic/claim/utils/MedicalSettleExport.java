package com.gyic.claim.utils;



import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.gyic.claim.bl.facade.BLMedicalsettlelistFacade;
import com.gyic.claim.dto.domain.MedicalsettlelistDto;
import com.gyic.claim.ui.control.facade.UIClaimGetSettleListFacade;

import com.sinosoft.prpall.bl.facade.BLPrpCmainFacade;
import com.sinosoft.prpall.dto.domain.PrpCmainDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.utiall.blsvr.BLPrpDkind;
import com.sinosoft.utiall.blsvr.BLPrpDrisk;
import com.sinosoft.utility.error.UserException;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;


import jxl.Cell;
import jxl.Workbook;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;




/**
 * Struts Creation date: 2-10-2011
 * 
 * XDoclet definition:
 * 
 * @struts.action validate="false"
 * @struts.action-forward name="breedingInsureInput" path="/mulBasicInfo.jsp"
 *                        forward name="herdsInsureAddInput"
 *                        path="/jsp/breeding/herdsInsure/herdsInsureAddInput.jsp"
 *           <forward name="herdsInsureLoad" path="/jsp/breeding/herdsInsure/herdsInsureLoad.jsp" />
 */
public class MedicalSettleExport {
	public String medicalExportAct(HttpServletRequest request,HttpServletResponse response,
			String rootPath)throws Exception {
		try {
//				ServletContext servletContext = getServlet().getServletContext();
			// String savePath =
			// servletContext.getRealPath("/WEB-INF/Template");
			Utils utils=new Utils();
			utils.getPhisicaMemory("理赔清单导入开始----start");
			String riskCode = request.getParameter("riskCode");
			List<String> strTitleList = getTitleListByRisk(riskCode);
			String saveFile;
			if(null!=strTitleList && strTitleList.size()>1){
				saveFile = exportSettleByNewTemplate(request,rootPath);  
			}else 
				saveFile = exportSettleByTemplate(request,rootPath);       
			if (saveFile != null) {
				try {
					//String areaCode = request.getParameter("areaCode");
					BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
					String fileName = "";
					String settleListCode =  request.getParameter("settleListCode");
					if(null!=settleListCode && !"".equals(settleListCode))
						fileName = settleListCode; //+ "_";
					//fileName += getAreaName(areaCode);
					java.util.Calendar cal = java.util.Calendar.getInstance();
					int year = cal.get(java.util.Calendar.YEAR);
					fileName += "_"+year+"年";
					fileName += blPrpDrisk.translateCode(riskCode, true);
					fileName += "理赔清单.xls";
					response.setContentType("application/x-msdownload");
					response.setHeader("Content-Disposition",
							"attachment; filename=\""
									+ new String(fileName
											.getBytes("gb2312"),
											"ISO-8859-1"));
					downFile(response.getOutputStream(), saveFile);
					utils.getPhisicaMemory("理赔清单导入结束-----end");
				} catch (Exception e) {
					e.printStackTrace();
				}
				Boolean flag = new File(saveFile).delete();
			}
			return null;
		} catch (Exception e) {
			System.out.println(e);
			throw e;
		}
//		return null;
	}
	
	public void downFile(OutputStream outStream, String fileName) {
		try {
			File file = new File(fileName);
			InputStream inPut = new FileInputStream(file);
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len = inPut.read(buf)) > 0)
				outStream.write(buf, 0, len);
			inPut.close();
			outStream.close();
		} catch (IOException e) {
			// System.out.println("下载单个文件操作出错");
			e.printStackTrace();
		}

	}
	
	public String exportSettleByTemplate(HttpServletRequest request,String rootPath) {
/*		ServletContext servletContext = getServlet().getServletContext();
		String commonPath = servletContext.getRealPath("//WEB-INF");*/
		String commonPath = rootPath;
		String settleListCode = request.getParameter("settleListCode");
		try {
			//String areacode = request.getParameter("areaCode");
			String claimNo   = request.getParameter("claimNo");
			String savePath = commonPath + "//downloadExcel//settle_"
					+ settleListCode + ".xls";

			//String fullPath = getAreaFullName(areacode);

			WritableWorkbook wwb = null;
			Workbook wb = null;
			WritableSheet wrisheet = null;

			String templatePath = commonPath
					+ "//Template//template_medicalsettle.xls";

			int rowIndex = 0;
			try {
				// InputStream ins = new FileInputStream(templatePath);
				// wb = Workbook.getWorkbook(ins);
				wb = Workbook.getWorkbook(new File(templatePath));
				File targetFile = new File(savePath);

				wwb = Workbook.createWorkbook(targetFile, wb);
				wrisheet = wwb.getSheet("理赔清册");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.print(e);
			}

			// wrisheet.setProtected(false);
			// SheetSettings ss=wrisheet.getSettings();
			// ss.setProtected(false);
			wrisheet.mergeCells(0, 0, 8, 2);

			WritableFont wf = new WritableFont(WritableFont.COURIER, 24,
					WritableFont.BOLD, false);
			WritableCellFormat wcfF = new WritableCellFormat(wf);
			wcfF.setAlignment(Alignment.CENTRE);
			wcfF.setBorder(jxl.write.Border.ALL,jxl.write.BorderLineStyle.THIN);

			java.util.Calendar cal = java.util.Calendar.getInstance();
			int year = cal.get(java.util.Calendar.YEAR);

			String title = year + "年度";

			BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
			UICodeAction uiCodeAction = new UICodeAction();
			String riskCode = request.getParameter("riskCode");
			String kindCode = request.getParameter("kindCode");
			if(null!=riskCode && !"".equals(riskCode) && null!=kindCode && !"".equals(kindCode)){
				//title = title.concat("（");
				title = title.concat(uiCodeAction.translateKindCode(riskCode, kindCode, true));
				//title = title.concat("）");
			}else if(null!=riskCode && !"".equals(riskCode)){
				//title = title.concat("（");
				title = title
						.concat(blPrpDrisk.translateCode(riskCode, true));
				//title = title.concat("）");
			}
			title = title.concat("赔付清单");

			Label wrilabel = new Label(0, 0, title, wcfF);
			wrisheet.addCell(wrilabel);

			rowIndex += 3;
			wrisheet.mergeCells(0, rowIndex, 8, rowIndex);
			wf = new WritableFont(WritableFont.COURIER, 16, WritableFont.BOLD,false);
			wcfF = new WritableCellFormat(wf);
			wcfF.setAlignment(Alignment.CENTRE);
			wcfF.setBorder(jxl.write.Border.ALL,jxl.write.BorderLineStyle.THIN);
			String strLabel =  "赔案号："+claimNo;
//			if(null!=settleListCode && !"".equals(settleListCode))
//				strLabel += "("	+ settleListCode + ")";
			Label labelCF = new Label(0, rowIndex, strLabel, wcfF);
			wrisheet.addCell(labelCF);
			

			rowIndex++;
			setDataToSheet(request,wrisheet,rowIndex);
			

			/*
			 * ++rowIndex; wrilabel = new Label(1, rowIndex, "总计：");
			 * wrisheet.addCell(wrilabel); Number number = new Number(5,
			 * rowIndex, totelTaxArea.doubleValue()); wrisheet.addCell(number);
			 * number = new Number(6, rowIndex, totelFpremium.doubleValue());
			 * wrisheet.addCell(number);
			 */
			// wribook.write();
			// wribook.close();
			wwb.write();
			wwb.close();
			wb.close();
			return savePath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	private Collection getInfos(HttpServletRequest request){
		Collection infoes = new ArrayList();
		try {
			String listType = request.getParameter("listType");//清单表类型，SettleList 为理赔清单， PolicyList 为保单清单。 不再使用
			String template = request.getParameter("template");//导出模板参数：如果该参数为template，则导出模板。
			if(!"template".equals(template)){
				String settleListCode = request.getParameter("settleListCode");
				String nodeType = request.getParameter("nodeType");
				BLMedicalsettlelistFacade blMedicalSettleListFacade = new BLMedicalsettlelistFacade();
				String sqlCondition = " settleListCode like '"+settleListCode+"' and nodeType like '"+nodeType+"' and validity like '1' ";
				infoes = blMedicalSettleListFacade.findByConditions(sqlCondition);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return infoes;
	}
	private void setDataToSheet(HttpServletRequest request,WritableSheet wrisheet,int rowIndex){
		Collection infos = getInfos(request);
		
		try {
			WritableFont wf = new WritableFont(WritableFont.COURIER, 10, WritableFont.NO_BOLD,
					false);
			WritableCellFormat wcfF = new WritableCellFormat(wf);
			wcfF = new WritableCellFormat(wf);
			wcfF.setAlignment(Alignment.CENTRE);
			wcfF.setBorder(jxl.write.Border.ALL,jxl.write.BorderLineStyle.THIN);
			
			Double totelTaxArea = Double.valueOf(0.0D);
			Double totelFpremium = Double.valueOf(0.0D);
			Double d = Double.valueOf(0.0D);
			if ((infos != null) && (infos.size() > 0)) {
				String template = request.getParameter("template");//导出模板参数：如果该参数为template，则导出模板。
				String listType = request.getParameter("listType");//清单表类型，SettleList 为理赔清单， PolicyList 为保单清单。不再使用
				Iterator it = infos.iterator();
				if(!"template".equals(template)){
					int i=0;
					while(it.hasNext()){
						MedicalsettlelistDto medicalSettleListDto = (MedicalsettlelistDto) it.next();
						rowIndex++;
						// Number number = new Number(0, rowIndex, rowIndex - 4);
						Number number = new Number(0, rowIndex, i + 1, wcfF);
						wrisheet.addCell(number);
						Label lab = new Label(1, rowIndex, medicalSettleListDto.getName(), wcfF);
						wrisheet.addCell(lab);
						lab = new Label(2, rowIndex, medicalSettleListDto.getIdcard(), wcfF);
						wrisheet.addCell(lab);
						lab = new Label(3, rowIndex, medicalSettleListDto.getMedicalcard(), wcfF);
						wrisheet.addCell(lab);
						
						d = round(medicalSettleListDto.getSuminsured(), 2);
						number = new Number(4, rowIndex, d.doubleValue(), wcfF);
						wrisheet.addCell(number);
						
						d = round(medicalSettleListDto.getSettlesum(), 2);
						number = new Number(5, rowIndex, d.doubleValue(), wcfF);
						wrisheet.addCell(number);
						
						lab = new Label(6, rowIndex, medicalSettleListDto.getMedicalfamily(), wcfF);
						wrisheet.addCell(lab);

						d = round(medicalSettleListDto.getSuminsured(), 2);
						number = new Number(7, rowIndex, d.doubleValue(), wcfF);
						wrisheet.addCell(number);
						
						lab = new Label(8, rowIndex, String.valueOf(medicalSettleListDto.getBank()), wcfF);
						wrisheet.addCell(lab);
						
						lab = new Label(9, rowIndex, transformFieldSourceToName(medicalSettleListDto.getCreditcard()), wcfF);
						wrisheet.addCell(lab);
						
						i++;
					}
				}
			}
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/** *//**
	* 提供精确的小数位四舍五入处理。
	* @param v 需要四舍五入的数字
	* @param scale 小数点后保留几位
	* @return 四舍五入后的结果
	*/
	public static double round(double v,int scale){
		if(scale<0){
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
//	public String getAreaFullName(String fAreaCode){
//		String areaFullName = "";
//		if(null!=fAreaCode && !"".equals(fAreaCode)){
//			while(!"0".equals(fAreaCode)){
//				AreasSchema areasSchema = getAreas(fAreaCode);
//				if(null!=areasSchema){
//					areaFullName = areasSchema.getArea_Name() + areaFullName;
//					fAreaCode = areasSchema.getSuper_Code();
//				}else break;	
//			}
//		}
//		return areaFullName;		
//	}
//	public String getAreaName(String fAreaCode){
//		String areaName = "";
//		if(null!=fAreaCode && !"".equals(fAreaCode)){
//			AreasSchema areasSchema = getAreas(fAreaCode);
//			if(null!=areasSchema){
//				areaName = areasSchema.getArea_Name() + areaName;
//			}
//		}
//		return areaName;		
//	}
//	private AreasSchema getAreas(String fAreaCode){
//		AreasSchema areasSchema = null;
//		try {
//			BLAreas blAreas = new BLAreas();
//			String sqlCondition = " area_code like '"+fAreaCode+"'";
//			blAreas.query(sqlCondition);
//			if(blAreas.getSize()>=1){
//				areasSchema = blAreas.getArr(0);
//			}
//		} catch (UserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return areasSchema;
//	}
	public static String getKindCodeName(String riskCode, String kindCode){
		String strKindCodeName = "";
		UICodeAction uiCodeAction = new UICodeAction();
		if(null!=riskCode && !"".equals(riskCode) && null!=kindCode && !"".equals(kindCode)){
			try {
				strKindCodeName = uiCodeAction.translateKindCode(riskCode, kindCode, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return strKindCodeName;
	}
	public String transformFieldSourceToName(String fieldSource){
		String fieldSourceName = "";
		if(null!=fieldSource)
			fieldSourceName = UIClaimGetSettleListFacade.fieldSourceMap.get(fieldSource)==null?"":(String)UIClaimGetSettleListFacade.fieldSourceMap.get(fieldSource);
		return fieldSourceName;
	}
	

	public String exportSettleByNewTemplate(HttpServletRequest request,String rootPath) {
/*		ServletContext servletContext = getServlet().getServletContext();
		String commonPath = servletContext.getRealPath("//WEB-INF");*/
		String commonPath = rootPath;
		String settleListCode = request.getParameter("settleListCode");
		try {
			//String areacode = request.getParameter("areaCode");
			String claimNo   = request.getParameter("claimNo");
			String savePath = commonPath + "//downloadExcel//settle_"
					+ settleListCode + ".xls";

			//String fullPath = getAreaFullName(areacode);

			WritableWorkbook wwb = null;
			Workbook wb = null;
			WritableSheet wrisheet = null;

			String riskCode = request.getParameter("riskCode");
			List<String> strTitleList = getTitleListByRisk(riskCode);
			String templatePath; 

			if(null!=strTitleList && strTitleList.size()>1){
				templatePath = commonPath
				+ "//Template//template_"+riskCode+"_settle.xls";
			}else{
				templatePath = commonPath
				+ "//Template//template_medicalsettle.xls";
			}
			int rowIndex = 0;
			try {
				// InputStream ins = new FileInputStream(templatePath);
				// wb = Workbook.getWorkbook(ins);
				wb = Workbook.getWorkbook(new File(templatePath));
				File targetFile = new File(savePath);

				wwb = Workbook.createWorkbook(targetFile, wb);
				wrisheet = wwb.getSheet("理赔清册");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.print(e);
			}

			// wrisheet.setProtected(false);
			// SheetSettings ss=wrisheet.getSettings();
			// ss.setProtected(false);
			boolean needNormalTitle = needNormalTitle(riskCode);
			if(needNormalTitle){
				wrisheet.mergeCells(0, 0, strTitleList.size()-1, 2);
	
				WritableFont wf = new WritableFont(WritableFont.COURIER, 24,
						WritableFont.BOLD, false);
				WritableCellFormat wcfF = new WritableCellFormat(wf);
				wcfF.setAlignment(Alignment.CENTRE);
				wcfF.setBorder(jxl.write.Border.ALL,jxl.write.BorderLineStyle.THIN);
	
				java.util.Calendar cal = java.util.Calendar.getInstance();
				int year = cal.get(java.util.Calendar.YEAR);
	
				String title = year + "年度";
	
				BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
				UICodeAction uiCodeAction = new UICodeAction();
				String kindCode = request.getParameter("kindCode");
				if(null!=riskCode && !"".equals(riskCode) && null!=kindCode && !"".equals(kindCode)){
					//title = title.concat("（");
					title = title.concat(uiCodeAction.translateKindCode(riskCode, kindCode, true));
					//title = title.concat("）");
				}else if(null!=riskCode && !"".equals(riskCode)){
					//title = title.concat("（");
					title = title
							.concat(blPrpDrisk.translateCode(riskCode, true));
					//title = title.concat("）");
				}
				title = title.concat("赔付清单");
	
				Label wrilabel = new Label(0, 0, title, wcfF);
				wrisheet.addCell(wrilabel);
	
				rowIndex += 3;
				wrisheet.mergeCells(0, rowIndex, strTitleList.size()-1, rowIndex);
				wf = new WritableFont(WritableFont.COURIER, 16, WritableFont.BOLD,false);
				wcfF = new WritableCellFormat(wf);
				wcfF.setAlignment(Alignment.LEFT);
				wcfF.setBorder(jxl.write.Border.ALL,jxl.write.BorderLineStyle.THIN);
				String strLabel = "赔案号："+claimNo;
//				if(null!=settleListCode && !"".equals(settleListCode))
//					strLabel += "("	+ settleListCode + ")";
				Label labelCF = new Label(0, rowIndex, strLabel, wcfF);
				wrisheet.addCell(labelCF);
			}else{
				rowIndex += 3;
				
				wrisheet.mergeCells(0, rowIndex, strTitleList.size()-1, rowIndex);
				WritableFont wf = new WritableFont(WritableFont.COURIER, 16, WritableFont.BOLD,false);
				WritableCellFormat wcfF = new WritableCellFormat(wf);
				wcfF.setAlignment(Alignment.CENTRE);
				wcfF.setBorder(jxl.write.Border.ALL,jxl.write.BorderLineStyle.THIN);
				String appliName = "";
				
				String policyNo = request.getParameter("policyNo");
				if(null != policyNo){
					BLPrpCmainFacade blPrpCmainFacade = new BLPrpCmainFacade();
					PrpCmainDto prpCmainDto = blPrpCmainFacade.findByPrimaryKey(policyNo);
					appliName = prpCmainDto.getAppliName();
				}
				Label labelCF = new Label(0, rowIndex, "投保人："+appliName, wcfF);
				wrisheet.addCell(labelCF);
			}

			rowIndex++;
			if(null!=strTitleList && strTitleList.size()>0){
				//在本class中定义了导入导出模板的险种，根据导入导出的模板将数据放入excel。
				setDataToSheetByNewTemplate(request,wrisheet,rowIndex);
			}
			else
				setDataToSheet(request,wrisheet,rowIndex);
			

			/*
			 * ++rowIndex; wrilabel = new Label(1, rowIndex, "总计：");
			 * wrisheet.addCell(wrilabel); Number number = new Number(5,
			 * rowIndex, totelTaxArea.doubleValue()); wrisheet.addCell(number);
			 * number = new Number(6, rowIndex, totelFpremium.doubleValue());
			 * wrisheet.addCell(number);
			 */
			// wribook.write();
			// wribook.close();
			wwb.write();
			wwb.close();
			wb.close();
			return savePath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private void setDataToSheetByNewTemplate(HttpServletRequest request,WritableSheet wrisheet,int rowIndex){
		Collection infos = getInfos(request);
		
		try {
			WritableFont wf = new WritableFont(WritableFont.COURIER, 10, WritableFont.NO_BOLD,
					false);
			WritableCellFormat wcfF = new WritableCellFormat(wf);
			wcfF = new WritableCellFormat(wf);
			wcfF.setAlignment(Alignment.CENTRE);
			wcfF.setBorder(jxl.write.Border.ALL,jxl.write.BorderLineStyle.THIN);
			
			Double totelTaxArea = Double.valueOf(0.0D);
			Double totelFpremium = Double.valueOf(0.0D);
			if ((infos != null) && (infos.size() > 0)) {
				String riskCode = request.getParameter("riskCode");
				String policyNo = request.getParameter("policyNo");
				List<String> strTitleFieldNameList = getTitleFieldNameListByRiskPolicyNo(riskCode,policyNo);//根据险种,保单号获取模板。
				String template = request.getParameter("template");//导出模板参数：如果该参数为template，则导出模板。
				String listType = request.getParameter("listType");//清单表类型，SettleList 为理赔清单， PolicyList 为保单清单。不再使用
				Iterator it = infos.iterator();
				Double d = Double.valueOf(0.0D);
				Label lab;
				if(!"template".equals(template)&& null != strTitleFieldNameList && strTitleFieldNameList.size()>1){
					int i=0;
					while(it.hasNext() ){
						MedicalsettlelistDto medicalSettleListDto = (MedicalsettlelistDto) it.next();
						rowIndex++;
						// Number number = new Number(0, rowIndex, rowIndex - 4);
						Number number = new Number(0, rowIndex, i + 1, wcfF);
						wrisheet.addCell(number);
						for(int indexFieldName = 1; indexFieldName < strTitleFieldNameList.size(); indexFieldName ++){
							
                            if("NAME".equals(strTitleFieldNameList.get(indexFieldName))){
								lab = new Label(indexFieldName, rowIndex, medicalSettleListDto.getName(), wcfF);
								wrisheet.addCell(lab);
							}else if("IDCARD".equals(strTitleFieldNameList.get(indexFieldName))){
								lab = new Label(indexFieldName, rowIndex, medicalSettleListDto.getIdcard(), wcfF);
								wrisheet.addCell(lab);
							}else if("MEDICALCARD".equals(strTitleFieldNameList.get(indexFieldName))){
								if("2607".equals(riskCode) && "空编号".equals(medicalSettleListDto.getMedicalcard()))
								{
									lab = new Label(indexFieldName, rowIndex, "", wcfF);
								}
								else
								{
									lab = new Label(indexFieldName, rowIndex, medicalSettleListDto.getMedicalcard(), wcfF);
								}
	                            //lab = new Label(indexFieldName, rowIndex, medicalSettleListDto.getMedicalcard(), wcfF);
								wrisheet.addCell(lab);
							}else if("SUMINSURED".equals(strTitleFieldNameList.get(indexFieldName))){
								d = round(medicalSettleListDto.getSuminsured(), 2);
								number = new Number(indexFieldName, rowIndex, d.doubleValue(), wcfF);
								wrisheet.addCell(number);
							}else if("SETTLESUM".equals(strTitleFieldNameList.get(indexFieldName))){
								d = round(medicalSettleListDto.getSettlesum(), 2);
								number = new Number(indexFieldName, rowIndex, d.doubleValue(), wcfF);
								wrisheet.addCell(number);
							}else if("MEDICALFAMILY".equals(strTitleFieldNameList.get(indexFieldName))){
								lab = new Label(indexFieldName, rowIndex, String.valueOf(medicalSettleListDto.getMedicalfamily()), wcfF);
								wrisheet.addCell(lab);
							}else if("BANK".equals(strTitleFieldNameList.get(indexFieldName))){
								lab = new Label(indexFieldName, rowIndex, medicalSettleListDto.getBank(), wcfF);
								wrisheet.addCell(lab);
								
							}else if("CREDITCARD".equals(strTitleFieldNameList.get(indexFieldName))){
								lab = new Label(indexFieldName, rowIndex, medicalSettleListDto.getCreditcard(), wcfF);
								wrisheet.addCell(lab);
							
							}
						}
						i++;
					}
				}				
			}
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//定义清单缮制导入导出excel的清单表头标签信息
	public static List<String> getTitleListByRisk(String riskCode){
		List<String> strTitleList = new ArrayList<String>();
		if("2801".equals(riskCode)||"2607".equals(riskCode) || "2605".equals(riskCode) || "2606".equals(riskCode)){
			String[] tempTitle = {"序号","被保险人","身份证号码","医保编号","发票金额","赔付金额","户名","开户行","银行账号"};
			for(int i=0;i<tempTitle.length;i++){
				strTitleList.add(tempTitle[i]);
			}
		}
		return strTitleList;
	}
	//定义清单缮制导入导出excel的清单表单数据信息，与表头标签信息一一对应。
	public static List<String> getTitleFieldNameListByRiskPolicyNo(String riskCode,String policyNo){
		List<String> strTitleFieldNameList = new ArrayList<String>();
		if("2801".equals(riskCode)||"2607".equals(riskCode)|| "2605".equals(riskCode) || "2606".equals(riskCode)){
			try {
			
	
					//String itemCode = ((PrpCitemKindDto)colItemKind.toArray()[0]).getItemCode();
					String[] tempTitleFieldName = {"INDEXOFSETTLE","NAME","IDCARD","MEDICALCARD","SUMINSURED","SETTLESUM","MEDICALFAMILY","BANK","CREDITCARD"};
					for(int i=0;i<tempTitleFieldName.length;i++){
						strTitleFieldNameList.add(tempTitleFieldName[i]);
					
		
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return strTitleFieldNameList;
	}
	//根据险种判断表头样式
	boolean needNormalTitle(String riskCode){
		boolean result = true;
		if("3149".equals(riskCode) || "3177".equals(riskCode)){
			result = false;
		}
		return result;
	}
}

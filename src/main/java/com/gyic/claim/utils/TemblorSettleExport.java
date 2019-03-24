package com.gyic.claim.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gyic.claim.bl.facade.*;
import com.gyic.claim.dto.domain.*;
import com.gyic.claim.ui.control.facade.UIClaimGetSettleListFacade;
import com.sinosoft.nyx.blsvr.BLAreas;
import com.sinosoft.nyx.schema.AreasSchema;
import com.sinosoft.platform.bl.facade.BLPrpDitemFacade;
import com.sinosoft.platform.bl.facade.BLPrpDkindFacade;
import com.sinosoft.platform.dto.domain.PrpDitemDto;
import com.sinosoft.platform.dto.domain.PrpDkindDto;
import com.sinosoft.utiall.blsvr.BLPrpDcode;
import com.sinosoft.utiall.blsvr.BLPrpDkind;
import com.sinosoft.utiall.blsvr.BLPrpDrisk;
import com.sinosoft.utiall.schema.PrpDcodeSchema;
import com.sinosoft.utility.error.UserException;
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
public class TemblorSettleExport {
	public String temblorExportAct(HttpServletRequest request,HttpServletResponse response,
			String rootPath)throws Exception {
		try {
//				ServletContext servletContext = getServlet().getServletContext();
			// String savePath =
			// servletContext.getRealPath("/WEB-INF/Template");
			Utils utils=new Utils();
			utils.getPhisicaMemory("理赔清单导出开始----start");
			String saveFile = exportSettleByTemplate(request,rootPath);       
			if (saveFile != null) {
				try {
					String areaCode = request.getParameter("areaCode");
					String riskCode = request.getParameter("riskCode");
					BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
					String fileName = "";
					String settleListCode =  request.getParameter("settleListCode");
					if(null!=settleListCode && !"".equals(settleListCode))
						fileName = settleListCode + "_";
					System.err.println(settleListCode);
					fileName += getAreaName(areaCode);
					System.err.println("xxxxx");
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
					utils.getPhisicaMemory("理赔清单导出结束-----end");
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
			String areacode = request.getParameter("areaCode");
			String savePath = commonPath + "//downloadExcel//settle_"
					+ areacode + ".xls";
			System.err.println("22222");
			String fullPath = getAreaFullName(areacode);

			WritableWorkbook wwb = null;
			Workbook wb = null;
			WritableSheet wrisheet = null;

			String templatePath = commonPath
					+ "//Template//template_"+request.getParameter("riskCode")+"_settle.xls";
			System.err.println(templatePath);
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
			wrisheet.mergeCells(0, 0, 16, 2);

			WritableFont wf = new WritableFont(WritableFont.COURIER, 24,
					WritableFont.BOLD, false);
			WritableCellFormat wcfF = new WritableCellFormat(wf);
			wcfF.setAlignment(Alignment.CENTRE);
			wcfF.setBorder(jxl.write.Border.ALL,jxl.write.BorderLineStyle.THIN);

			java.util.Calendar cal = java.util.Calendar.getInstance();
			int year = cal.get(java.util.Calendar.YEAR);

			String title = year + "年国元农业保险农户理赔清单";

			BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
			UICodeAction uiCodeAction = new UICodeAction();
			String riskCode = request.getParameter("riskCode");
			String kindCode = request.getParameter("kindCode");
			if(null!=riskCode && !"".equals(riskCode) && null!=kindCode && !"".equals(kindCode)){
				title = title.concat("（");
				title = title.concat(uiCodeAction.translateKindCode(riskCode, kindCode, true));
				title = title.concat("）");
			}else if(null!=riskCode && !"".equals(riskCode)){
				title = title.concat("（");
				title = title
						.concat(blPrpDrisk.translateCode(riskCode, true));
				title = title.concat("）");
			}

			Label wrilabel = new Label(0, 0, title, wcfF);
			wrisheet.addCell(wrilabel);

			rowIndex += 3;
			wrisheet.mergeCells(0, rowIndex, 14, rowIndex);
			wf = new WritableFont(WritableFont.COURIER, 16, WritableFont.BOLD,false);
			wcfF = new WritableCellFormat(wf);
			wcfF.setAlignment(Alignment.CENTRE);
			wcfF.setBorder(jxl.write.Border.ALL,jxl.write.BorderLineStyle.THIN);
			String strLabel = fullPath;
			if(null!=settleListCode && !"".equals(settleListCode))
				strLabel += "("	+ settleListCode + ")";
			Label labelCF = new Label(0, rowIndex, strLabel, wcfF);
			wrisheet.addCell(labelCF);
			
			//为表头的赔付险别和赔付标的增加险别和标的的代码名称对照说明。
			updateKindCodeAndItemCodeRemark(riskCode,wrisheet);
			
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
			String template = request.getParameter("template");//导出模板参数：如果该参数为template，则导出模板。
			if(!"template".equals(template)){
				String settleListCode = request.getParameter("settleListCode");
				String nodeType = request.getParameter("nodeType");
				BLTemblorsettlelistFacade blTemblorsettlelistFacade = new BLTemblorsettlelistFacade();
				//BLPlanting31SettleListFacade blPlanting31SettleListFacade = new BLPlanting31SettleListFacade();
				String sqlCondition = " settleListCode like '"+settleListCode+"' and nodeType like '"+nodeType+"' and validity like '1' order by indexOfSettle ";
				infoes = blTemblorsettlelistFacade.findByConditions(sqlCondition);
			}else {
				String insureListCode = request.getParameter("insureListCode");
//			String kindCode = request.getParameter("kindCode");
				String sqlCondition = " inusreListCode like '"+insureListCode+"' and validity like '1' ";
//			sqlCondition += " and kindCode like '"+kindCode+"'";
				BLTemblorpolicylistFacade blTemblorpolicylistFacade = new BLTemblorpolicylistFacade();
				//BLPlanting31PolicyListFacade blPlanting31PolicyListFacade = new BLPlanting31PolicyListFacade();
				infoes = blTemblorpolicylistFacade.findByConditions(sqlCondition);
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
			UICodeAction uicodeAction = new UICodeAction();
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
				Object[] planting31Array = infos.toArray();
				if(!"template".equals(template) && null != planting31Array && planting31Array.length>0){
					int i=0;
					for(int indexSettle = 0; indexSettle < planting31Array.length; indexSettle++){
						
						TemblorsettlelistDto TemblorsettlelistDto = (TemblorsettlelistDto)planting31Array[indexSettle];
						rowIndex++;
						// Number number = new Number(0, rowIndex, rowIndex - 4);
						Number number = new Number(0, rowIndex, i + 1, wcfF);
						wrisheet.addCell(number);
						int j = 1; //j 代表列数。
						
						//农户代码
						Label lab = new Label(j, rowIndex, TemblorsettlelistDto.getName(), wcfF);//j=1
						wrisheet.addCell(lab);
						j++;
						
						//姓名
						lab = new Label(j, rowIndex, TemblorsettlelistDto.getCardtype(), wcfF);//
						wrisheet.addCell(lab);
						j++;
						
						//身份证
						lab = new Label(j, rowIndex, TemblorsettlelistDto.getIdcard(), wcfF);
						wrisheet.addCell(lab);
						j++;
						
						//银行账号
						lab = new Label(j, rowIndex, TemblorsettlelistDto.getAddress(), wcfF);
						wrisheet.addCell(lab);
						j++;

//						//联系电话
//						lab = new Label(j, rowIndex, TemblorsettlelistDto.getKindcode(), wcfF);
//						wrisheet.addCell(lab);
//						j++;
						
						//赔付险别代码
						lab = new Label(j, rowIndex, getKindCodeName(TemblorsettlelistDto.getRiskcode(), TemblorsettlelistDto.getKindcode()), wcfF);
						wrisheet.addCell(lab);
						j++;
						
						//赔付标的
						lab = new Label(j, rowIndex, getItemCodeName(TemblorsettlelistDto.getRiskcode(), TemblorsettlelistDto.getItemcode()), wcfF);
						wrisheet.addCell(lab);
						j++;

						lab = new Label(j, rowIndex, TemblorsettlelistDto.getDamagelevel(), wcfF);
						wrisheet.addCell(lab);
						j++;
						//剩余面积
						d = round(TemblorsettlelistDto.getPrepay(), 3);
						number = new Number(j, rowIndex, d.doubleValue(), wcfF);
						wrisheet.addCell(number);
						j++;
						
						//剩余保额
						d = round(TemblorsettlelistDto.getSupplyprepay(), 2);
						number = new Number(j, rowIndex, d.doubleValue(), wcfF);
						wrisheet.addCell(number);
						j++;
						
						//受损面积
						d = round(TemblorsettlelistDto.getLossamount(), 3);
						number = new Number(j, rowIndex, d.doubleValue(), wcfF);
						wrisheet.addCell(number);
						j++;
						
						d = round(TemblorsettlelistDto.getSuminsured(), 3);
						number = new Number(j, rowIndex, d.doubleValue(), wcfF);
						wrisheet.addCell(number);
						j++;
						
						//赔付比例%
						d = round(TemblorsettlelistDto.getClaimrate(), 1);
						number = new Number(j, rowIndex, d.doubleValue(), wcfF);
						wrisheet.addCell(number);
						j++;
						
						//损失率%
						d = round(TemblorsettlelistDto.getLossrate(), 2);
						number = new Number(j, rowIndex, d.doubleValue(), wcfF);
						wrisheet.addCell(number);
						j++;
						
						//赔偿金额
						d = round(TemblorsettlelistDto.getSettlesum(), 2);
						number = new Number(j, rowIndex, d.doubleValue(), wcfF);
						wrisheet.addCell(number);
						j++;
						
						//赔偿金额合计
//						boolean needSumByFIdCard = false;
//						if(i<planting31Array.length-1){
//							int indexNext = i + 1;
//							TemblorsettlelistDto TemblorsettlelistDtoTemp = (TemblorsettlelistDto)planting31Array[indexNext];
//							String fIdCardTemp = TemblorsettlelistDtoTemp.getIdcard();
//							if(null != fIdCardTemp && !fIdCardTemp.equals(TemblorsettlelistDto.getIdcard())){
//								needSumByFIdCard = true;
//							}
//						}else if(i==planting31Array.length-1)
//							needSumByFIdCard = true;
//						
//						if(needSumByFIdCard){
//							
//							BLTemblorsettlelistFacade blTemblorsettlelistFacade = new BLTemblorsettlelistFacade();
//							d = round(blTemblorsettlelistFacade.getSettleSumByFcodeNodeType(TemblorsettlelistDto.getSettlelistcode(), TemblorsettlelistDto.getIdcard(), TemblorsettlelistDto.getAddress(), TemblorsettlelistDto.getNodetype()), 2);
//							number = new Number(j, rowIndex, d.doubleValue(), wcfF);
//							wrisheet.addCell(number);
//						}
						//j++;

//						//土地来源
//						lab = new Label(j, rowIndex, transformFieldSourceToName(TemblorsettlelistDto.getFieldsource()), wcfF);
//						wrisheet.addCell(lab);
//						j++;
						
						//备注
						lab = new Label(j, rowIndex, TemblorsettlelistDto.getRemark(), wcfF);
						wrisheet.addCell(lab);
						i++;
					}
				}else{
					int i=0;
					for(int indexSettle = 0; indexSettle < planting31Array.length; indexSettle++){
						TemblorpolicylistDto TemblorpolicylistDto = (TemblorpolicylistDto) planting31Array[i];
						rowIndex++;
						int j = 1; //j 代表列数。
						
						// Number number = new Number(0, rowIndex, rowIndex - 4);
						Number number = new Number(0, rowIndex, i + 1, wcfF);
						wrisheet.addCell(number);
						
						//农户代码
						Label lab = new Label(j, rowIndex, TemblorpolicylistDto.getName(), wcfF);
						wrisheet.addCell(lab);
						j++;

						//姓名
						lab = new Label(j, rowIndex, TemblorpolicylistDto.getCardtype(), wcfF);
						wrisheet.addCell(lab);
						j++;

						//身份证
						lab = new Label(j, rowIndex, TemblorpolicylistDto.getIdcard(), wcfF);
						wrisheet.addCell(lab);
						j++;

						//银行账号
						lab = new Label(j, rowIndex, TemblorpolicylistDto.getAddress(), wcfF);
						wrisheet.addCell(lab);
						j++;

//						//联系电话
//						lab = new Label(j, rowIndex, TemblorpolicylistDto.getPhone(), wcfF);
//						wrisheet.addCell(lab);
//						j++;

						//赔付险别代码
						lab = new Label(j, rowIndex, TemblorpolicylistDto.getKindcode(), wcfF);
						wrisheet.addCell(lab);
						j++;

						//赔付标的
						lab = new Label(j, rowIndex, TemblorpolicylistDto.getItemcode(), wcfF);
						wrisheet.addCell(lab);
						j++;
						
						
						//破坏等级
						number = new Number(j, rowIndex, 0, wcfF);
						wrisheet.addCell(number);
						j++;	
						
						//预付金额
						number = new Number(j, rowIndex, 0, wcfF);
						wrisheet.addCell(number);
						j++;		

						//补充赔付金额
						number = new Number(j, rowIndex, 0, wcfF);
						wrisheet.addCell(number);
						j++;		

						//定损金额
						number = new Number(j, rowIndex, 0, wcfF);
						wrisheet.addCell(number);
						j++;		
						//剩余保额
						d = round(TemblorpolicylistDto.getSumamount(), 2);
						number = new Number(j, rowIndex, d.doubleValue(), wcfF);
						wrisheet.addCell(number);
						j++;						
						//赔付比例%
						number = new Number(j, rowIndex, 0, wcfF);
						wrisheet.addCell(number);
						j++;						

						//损失率%
						number = new Number(j, rowIndex, 0, wcfF);
						wrisheet.addCell(number);
						j++;

						//赔偿金额
						number = new Number(j, rowIndex, 0, wcfF);
						wrisheet.addCell(number);
						j++;
						

						

						//备注
						lab = new Label(j, rowIndex, TemblorpolicylistDto.getRemark(), wcfF);
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
		}catch (Exception e) {
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
	public String getAreaFullName(String fAreaCode){
		String areaFullName = "";
		if(null!=fAreaCode && !"".equals(fAreaCode)){
			while(!"0000".equals(fAreaCode.substring(2))){
				PrpDcodeSchema areasSchema = getAreas(fAreaCode);
				if(null!=areasSchema){
					areaFullName = areasSchema.getCodeCName() + areaFullName;
					fAreaCode = areasSchema.getNewCodeCode();
				}else break;	
			}
		}
		return areaFullName;		
	}
	public String getAreaName(String fAreaCode){
		String areaName = "";
		if(null!=fAreaCode && !"".equals(fAreaCode)){
			PrpDcodeSchema areasSchema = getAreas(fAreaCode);
			if(null!=areasSchema){
				areaName = areasSchema.getCodeCName() + areaName;
			}
		}
		return areaName;		
	}
	private PrpDcodeSchema getAreas(String fAreaCode){
		PrpDcodeSchema areasSchema = null;
		try {
			BLPrpDcode blAreas = new BLPrpDcode();
			String sqlCondition = " codetype = 'BusinessZone0311' and codecode like '"+fAreaCode+"'";
			System.err.println(sqlCondition);
			blAreas.query(sqlCondition);
			if(blAreas.getSize()>=1){
				areasSchema = blAreas.getArr(0);
			}
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areasSchema;
	}
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
	public static String getItemCodeName(String riskCode, String itemCode){
		String strKindCodeName = "";
		UICodeAction uiCodeAction = new UICodeAction();
		if(null!=riskCode && !"".equals(riskCode) && null!=itemCode && !"".equals(itemCode)){
			try {
				strKindCodeName = uiCodeAction.translateItemCode(riskCode, itemCode, true);
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
	public String getKindCodeNamesByRiskCode(String riskCode)throws Exception{
		String strResult = "";
		try {
			BLPrpDkindFacade blPrpDkindFacade = new BLPrpDkindFacade();
			String sqlCondition = "riskCode = '"+riskCode+"' and validStatus = '1' ";
			Collection resultList = blPrpDkindFacade.findByConditions(sqlCondition);
			if(null!=resultList && resultList.size() > 0){
				Iterator it = resultList.iterator();
				strResult += "(";
				while(it.hasNext()){
					PrpDkindDto prpDkindDto = (PrpDkindDto)it.next();
					String kindCode = prpDkindDto .getKindCode();
					String kindCName = prpDkindDto.getKindCName();
					strResult += "【"+kindCode + ":" + kindCName + "】";
				}
				strResult += ")";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strResult;
	}
	public String getItemCodeNamesByRiskCode(String riskCode)throws Exception{
		String strResult = "";
		try {
			BLPrpDitemFacade blPrpDitemFacade = new BLPrpDitemFacade();
			String sqlCondition = "riskCode = '"+riskCode+"' and validStatus = '1' ";
			Collection resultList = blPrpDitemFacade.findByConditions(sqlCondition);
			if(null!=resultList && resultList.size() > 0){
				Iterator it = resultList.iterator();
				strResult += "(";
				while(it.hasNext()){
					PrpDitemDto prpDitemDto = (PrpDitemDto)it.next();
					String itemCode = prpDitemDto.getItemCode();
					String itemCName = prpDitemDto.getItemCName();
					strResult += "【"+itemCode + ":" + itemCName + "】";
				}
				strResult += ")";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strResult;
	}
	public void updateKindCodeAndItemCodeRemark(String riskCode, WritableSheet wrisheet)throws Exception{
		if(null!=wrisheet && null != riskCode && !"".equals(riskCode)){
			//获取kindCode的cell
			Label labelKindCode = (Label)wrisheet.getWritableCell(5, 4);
			String kindCodeInfo = getKindCodeNamesByRiskCode(riskCode);
			labelKindCode.setString(labelKindCode.getString()+kindCodeInfo);
			Label labelItemCode = (Label)wrisheet.getWritableCell(6, 4);
			String itemCodeInfo = getItemCodeNamesByRiskCode(riskCode);
			labelItemCode.setString(labelItemCode.getString()+itemCodeInfo);
		}
	}
}

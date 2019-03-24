package com.sinosoft.claim.ui.control.facade;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLPrpJthirdBankMappingFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimBillManagerFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.bl.facade.BLSaBankBranchFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLbillPayDto;
import com.sinosoft.claim.dto.domain.PrpLclaimBillManagerDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.dto.domain.SaBankBranchDto;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelperNew;
import com.sinosoft.claim.util.CheckInputUtil;
import com.sinosoft.fxq.bl.facade.BLTerroristFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.ParamUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.PrpallUtility;
import com.sinosoft.utility.string.Str;

public class UILpaymentBillExcelFacade_new extends Action{

	@SuppressWarnings("deprecation")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "";
		String content = "";
		String message = "" ; 
		ActionMessages messages = new ActionMessages();
		try{
		PrpallUtility prpallUtility = new PrpallUtility();
		prpallUtility.getPhisicaMemory("清单导入-----1");
		ParamUtils paramUtils = new ParamUtils(request);
		prpallUtility.getPhisicaMemory("清单导入-----1.1");
		String editType = paramUtils.getParameter("editType");
		String payType = paramUtils.getParameter("payType");
		String Datatype = paramUtils.getParameter("Datatype");
		UserDto user = (UserDto)request.getSession().getAttribute("user");
		String nodeType = paramUtils.getParameter("nodeType");
		String paymentType = paramUtils.getParameter("paymentType");
		String mergerFlag  = paramUtils.getParameter("mergerFlag");
		String billFlag = paramUtils.getParameter("billFlag");
		String submitType = paramUtils.getParameter("submitType");
		String billNo = paramUtils.getParameter("billNo");
		String isAccBack = paramUtils.getParameter("isAccBack");
		String strFilePath     = paramUtils.getParameter("FILE1");
		prpallUtility.getPhisicaMemory("清单导入-----1.2");
		InputStream file  = new FileInputStream(strFilePath);
		System.err.println("路径:"+strFilePath);
		prpallUtility.getPhisicaMemory("清单导入-----2");
		if (!strFilePath.toLowerCase().endsWith(".xls")) {
			OutputStream out = response.getOutputStream();
			String strMessage = "上传的文件不是一个合法的Excel文件。<br>请选择后缀名为.xsl的Excel文件！";
			out.write(strMessage.getBytes());
			out.close();
			throw new Exception(strMessage);
		}
		ArrayList prpLbillPayDtoList = new ArrayList();
			Workbook workbook=Workbook.getWorkbook(file);
			Sheet sheet=workbook.getSheet(0);
			prpallUtility.getPhisicaMemory("清单导入-----3--条数----"+(sheet.getRows()-5));
			if (sheet.getRows()-5>999) {
				OutputStream out = response.getOutputStream();
				String strMessage = "上传的文件支付记录条数太大，请调整为小于1000条，分多个Excel多次导入！";
				out.write(strMessage.getBytes());
				out.close();
				throw new Exception(strMessage);
			}
			PrpLbillPayDto prpLbillPayDto = null;
			for(int i=5;i<sheet.getRows();i++){
				String rowNum = sheet.getCell(0, i).getContents();
				if ((rowNum == null) || ("".equals(rowNum.trim())))
					continue;
				prpLbillPayDto = new PrpLbillPayDto();
				for(int j=0;j<sheet.getColumns();j++){
					switch(j){
					case 0:
						String serialNo = sheet.getCell(j, i).getContents().trim();
						if ((serialNo != null) && !("".equals(serialNo))) {
							prpLbillPayDto.setSerialNo(Integer.parseInt(serialNo));
						} 
						break;
					case 1:
						String receiverfullName = sheet.getCell(j,i).getContents().trim();
						if((receiverfullName != null)&& !("".equals(receiverfullName))){
							prpLbillPayDto.setReceiverfullName(receiverfullName);
						}
						break;
					case 2:
						String certifNo = sheet.getCell(j, i).getContents().trim();
						if((certifNo != null) && !("".equals(certifNo))){
							prpLbillPayDto.setCertifNo(certifNo);
						}
						break;
					case 3:
						String mobilePhone = sheet.getCell(j, i).getContents().trim();
						if((mobilePhone != null) && !("".equals(mobilePhone))){
							prpLbillPayDto.setMobilePhone(mobilePhone);
						}
						break;
					case 4:
						String provinceName = sheet.getCell(j, i).getContents().trim();
						if((provinceName != null) && !("".equals(provinceName))){
							prpLbillPayDto.setProvinceName(provinceName);
						}
						break;
					case 5:
						String cityName = sheet.getCell(j, i).getContents().trim();
						if((cityName != null) && !("".equals(cityName))){
							prpLbillPayDto.setCityName(cityName);
						}
						break;
					case 6:
						String accountType = sheet.getCell(j, i).getContents().trim();
						if((accountType != null) && !("".equals(accountType))){
							prpLbillPayDto.setAccountType(accountType);
						}
						break;
					case 7:
						String bankType = sheet.getCell(j, i).getContents().trim();
						if((bankType != null) && !("".equals(bankType))){
							prpLbillPayDto.setBankType(bankType);
						}
						break;
					case 8:
						String bankAccount = sheet.getCell(j, i).getContents().trim();
						if((bankAccount != null) && !("".equals(bankAccount))){
							prpLbillPayDto.setBankAccount(bankAccount);
						}
						break;
					case 9:
						String accountFlag = sheet.getCell(j, i).getContents().trim();
						if((accountFlag != null) && !("".equals(accountFlag))){
							prpLbillPayDto.setAccountFlag(accountFlag);
						}
						break;
					case 10:
						String bank = sheet.getCell(j, i).getContents().trim();
						if((bank != null) && !("".equals(bank))){
							prpLbillPayDto.setBank(bank);
						}
						break;
					case 11:
						String address = sheet.getCell(j, i).getContents().trim();
						if((address != null) && !("".equals(address))){
							prpLbillPayDto.setAddress(address);
						}
						break;
					case 12:
						String payAmount = sheet.getCell(j, i).getContents().trim();
						if((payAmount != null) && !("".equals(payAmount))){
							prpLbillPayDto.setPayAmount(Double.parseDouble(payAmount));
						}
						break;
					case 13:
						String payWay = sheet.getCell(j, i).getContents().trim();
						if((payWay != null) && !("".equals(payWay))){
							prpLbillPayDto.setPayWay(payWay);
						}
						break;
					case 14:
						String payReason = sheet.getCell(j, i).getContents().trim();
						if((payReason != null) && !("".equals(payReason))){
							prpLbillPayDto.setPayReason(payReason);
						}
						break;
					case 15:
						String payPurpose = sheet.getCell(j, i).getContents().trim();
						if((payPurpose != null) && !("".equals(payPurpose))){
							prpLbillPayDto.setPayPurpose(payPurpose);
						}else{
							prpLbillPayDto.setPayPurpose("国元理赔");
						}
						break;
					case 16:
						String routeNum = sheet.getCell(j, i).getContents().trim();
						if((routeNum != null) && !("".equals(routeNum))){
							prpLbillPayDto.setRouteNum(routeNum);
						}
						break;	
					default:
						break;
					}
				}
				prpLbillPayDtoList.add(prpLbillPayDto) ;
			}
			prpallUtility.getPhisicaMemory("清单导入-----4");
			workbook.close();
			file.close();
			prpallUtility.getPhisicaMemory("清单导入-----5");
			String noBillFlag = paramUtils.getParameter("noBillFlag");
			
			if(noBillFlag != null && "1".equals(noBillFlag)){
				message = checkAccountNoBill(prpLbillPayDtoList,paramUtils,request);
			}else{
				message = checkAccount(prpLbillPayDtoList,paramUtils,request);
				
			}
			if(!message.equals("")){
				throw new Exception(message);
			}
			//message = checkAccount(prpLbillPayDtoList,paramUtils,request);
			PaymentViewHelperNew paymentViewHelper = new PaymentViewHelperNew();

			paymentViewHelper.saveBillOrupdate(user,paramUtils,prpLbillPayDtoList);
	
			payRegistExtpayRegistExt(paramUtils,request);
			prpallUtility.getPhisicaMemory("清单导入-----6");
			request.setAttribute("prpLbillPayDtoList", prpLbillPayDtoList);
			request.setAttribute("editType", editType);
			request.setAttribute("billNo", billNo);
			request.setAttribute("noBillFlag", noBillFlag);
			if("true".equals(isAccBack)){
				request.setAttribute("isAccBack", true);
			}else{
				request.setAttribute("isAccBack", false);
			}
			
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
			"prompt.billpay.submit"));
			saveMessages(request, messages);
			forward = "success";
		}catch  (Exception e){
			message = "提交失败，请联系系统管理员查找原因";
			e.printStackTrace() ;
		      //错误信息处理
		      ActionErrors errors = new ActionErrors();
		      ActionError error = new ActionError("title.uploadpay.info");
		      errors.add(ActionErrors.GLOBAL_ERROR, error);
		      request.setAttribute("error",e.getMessage()) ;
		      request.setAttribute("errorMessage",e.getMessage()) ;
		      saveErrors(request, errors);
		      forward = "error";
		}finally{
			
		}
			request.setAttribute("message", message);
			request.setAttribute("success", forward);
			request.setAttribute("upLoadFlag", "true");
			return mapping.findForward(forward);
	}
	
	private void payRegistExtpayRegistExt(ParamUtils paramUtils,HttpServletRequest request) throws ServletException {
		ArrayList list = new ArrayList();
		PrpLpayExtDto prpLpayExtDto = null;
		PrpLpayExtDto prpLpayExtDtoNew = new PrpLpayExtDto();
		String[] prpLpayExtFlag = paramUtils.getParameterValues("prpLpayExtFlag1");
		String[] prpLpayExtSerialNo = paramUtils.getParameterValues("prpLpayExtSerialNo1");
		String[] prpLpayExtNodeType = paramUtils.getParameterValues("prpLpayExtNodeType1");
		String[] prpLpayExtNodeName = paramUtils.getParameterValues("prpLpayExtNodeName1");
		String[] prpLpayExtInputDate = paramUtils.getParameterValues("prpLpayExtInputDate1");
		String[] prpLpayExtCostTime = paramUtils.getParameterValues("prpLpayExtCostTime1");
		String[] prpLpayExtOperatorCode = paramUtils.getParameterValues("prpLpayExtOperatorCode1");
		String[] prpLpayExtOperatorCodeName = paramUtils.getParameterValues("prpLpayExtOperatorCodeName1");
		String[] prpLpayExtComCName = paramUtils.getParameterValues("prpLpayExtComCName1");
		String[] prpLpayExtComCode = paramUtils.getParameterValues("prpLpayExtComCode1");
		String[] prpLpayExtNotionCode = paramUtils.getParameterValues("prpLpayExtNotionCode1");
		String[] prpLpayExtNotionName = paramUtils.getParameterValues("prpLpayExtNotionName1");
		String[] prpLpayExtContext = paramUtils.getParameterValues("prpLpayExtContext1");
		if(prpLpayExtSerialNo!=null){
			for(int i=0;i<prpLpayExtSerialNo.length;i++){
				prpLpayExtDto = new PrpLpayExtDto();
				prpLpayExtDto.setFlag(prpLpayExtFlag[i]);
				prpLpayExtDto.setSerialNo(Integer.parseInt(prpLpayExtSerialNo[i]));
				prpLpayExtDto.setNodeType(prpLpayExtNodeType[i]);
				prpLpayExtDto.setNodeName(prpLpayExtNodeName[i]);
				prpLpayExtDto.setInputDate(new DateTime(prpLpayExtInputDate[i],DateTime.YEAR_TO_SECOND));
				prpLpayExtDto.setCostTime(prpLpayExtCostTime[i]);
				prpLpayExtDto.setOperatorCode(prpLpayExtOperatorCode[i]);
				prpLpayExtDto.setOperatorCodeName(prpLpayExtOperatorCodeName[i]);
				prpLpayExtDto.setComCName(prpLpayExtComCName[i]);
				prpLpayExtDto.setComCode(prpLpayExtComCode[i]);
				prpLpayExtDto.setNotionCode(prpLpayExtNotionCode[i]);
				prpLpayExtDto.setNotionName(prpLpayExtNotionName[i]);
				prpLpayExtDto.setContext(prpLpayExtContext[i]);
				list.add(prpLpayExtDto);
			}
		}
		request.setAttribute("prpLpayExtDtoList", list);
		
		String prpLpayExtFlag2 = paramUtils.getParameter("prpLpayExtFlag2");
		String prpLpayExtSerialNo2 = paramUtils.getParameter("prpLpayExtSerialNo2");
		String prpLpayExtNodeType2 = paramUtils.getParameter("prpLpayExtNodeType2");
		String prpLpayExtNodeName2 = paramUtils.getParameter("prpLpayExtNodeName2");
		String prpLpayExtInputDate2 = paramUtils.getParameter("prpLpayExtInputDate2");
		String prpLpayExtCostTime2 = paramUtils.getParameter("prpLpayExtCostTime2");
		String prpLpayExtOperatorCode2 = paramUtils.getParameter("prpLpayExtOperatorCode2");
		String prpLpayExtOperatorCodeName2 = paramUtils.getParameter("prpLpayExtOperatorCodeName2");
		String prpLpayExtComCName2 = paramUtils.getParameter("prpLpayExtComCName2");
		String prpLpayExtComCode2 = paramUtils.getParameter("prpLpayExtComCode2");
		String prpLpayExtNotionCode2 = paramUtils.getParameter("prpLpayExtNotionCode2");
		String prpLpayExtNotionName2 = paramUtils.getParameter("prpLpayExtNotionName2");
		String prpLpayExtContext2 = paramUtils.getParameter("prpLpayExtContext2");
		if(prpLpayExtSerialNo2!=null){
			prpLpayExtDtoNew.setFlag(prpLpayExtFlag2);
			prpLpayExtDtoNew.setSerialNo(Integer.parseInt(prpLpayExtSerialNo2));
			prpLpayExtDtoNew.setNodeType(prpLpayExtNodeType2);
			prpLpayExtDtoNew.setNodeName(prpLpayExtNodeName2);
			prpLpayExtDtoNew.setInputDate(new DateTime(prpLpayExtInputDate2,DateTime.YEAR_TO_SECOND));
			prpLpayExtDtoNew.setCostTime(prpLpayExtCostTime2);
			prpLpayExtDtoNew.setOperatorCode(prpLpayExtOperatorCode2);
			prpLpayExtDtoNew.setOperatorCodeName(prpLpayExtOperatorCodeName2);
			prpLpayExtDtoNew.setComCName(prpLpayExtComCName2);
			prpLpayExtDtoNew.setComCode(prpLpayExtComCode2);
			prpLpayExtDtoNew.setNotionCode(prpLpayExtNotionCode2);
			prpLpayExtDtoNew.setNotionName(prpLpayExtNotionName2);
			prpLpayExtDtoNew.setContext(prpLpayExtContext2);
		}
		request.setAttribute("prpLpayExtDtoNew", prpLpayExtDtoNew);
	}

	public String checkAccountNoBill(ArrayList prpLbillPayDtoList,ParamUtils paramUtils,HttpServletRequest request) throws Exception{
		String reQPolicyNo = paramUtils.getParameter("reQPolicyNo");
		String reQClaimNo = paramUtils.getParameter("reQClaimNo");
		String reQRegistNo = paramUtils.getParameter("reQRegistNo");
		String reQVflag = paramUtils.getParameter("reQVflag");
		String[] compensateNo = paramUtils.getParameterValues("compensateNo");
		String[] payName = paramUtils.getParameterValues("payName");
		String[] identifyNumber = paramUtils.getParameterValues("identifyNumber");
		String[] payAmount = paramUtils.getParameterValues("payAmount");
		String[] fkSerialNo = paramUtils.getParameterValues("fkSerialNo");
		String[] payAmounts = paramUtils.getParameterValues("payAmounts");
		String[] paymentNo = paramUtils.getParameterValues("paymentNo");
		String[] backReason = paramUtils.getParameterValues("backReason");
		BLPrpJthirdBankMappingFacade blPrpJthirdBankMappingFacade = null;
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		String checkMessage = "";
		double sumTotalPaidOld = 0d;
		boolean isChecked = false;
		PrpLbillPayDto PrpLbillPayDto = null;
		double sumPaid = 0 ; 
//		if(payAmount != null && payAmount.length > 0 ){
//			sumPaid = Double.parseDouble(payAmount[0]) ; 
//		}
		BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
		BLPrpLcompensateFacade lcompensateFacade = new BLPrpLcompensateFacade() ; 
		ArrayList compensateList = (ArrayList) lcompensateFacade.findByConditions(" claimno = '"+reQClaimNo+"'") ;
		if(compensateList != null && compensateList.size() > 0 ){
			for (int i = 0; i < compensateList.size(); i++) {
				sumPaid = sumPaid + ((PrpLcompensateDto)compensateList.get(i)).getSumDutyPaid() ; 
			}
		}
		BLPrpLclaimBillManagerFacade blPrpLclaimBillManagerFacade = new BLPrpLclaimBillManagerFacade() ; 
		
		String conditions = "" ; 
		conditions = " p.registno = '"+reQRegistNo+"' and p.policyno = '"+reQPolicyNo+"' and p.compensateno = '"+compensateNo[0]+"' " ; //  and substr(flag , 1, 1) = '1'
		
		ArrayList compensateList1 = (ArrayList) blPrplpayFacade.findByConditions(conditions) ;
		if(compensateList != null && compensateList1.size() > 0 ){
			for (int i = 0; i < compensateList1.size(); i++) {
				sumPaid = sumPaid - ((PrplpayDto)compensateList1.get(i)).getPayamount() ; 
			}
		}
		conditions = " registno = '"+reQRegistNo+"' and policyno = '"+reQPolicyNo+"' and compensateno = '"+compensateNo[0]+"' " ; //  and substr(flag , 1, 1) = '1'
		int serialNo = blPrpLclaimBillManagerFacade.getMaxSerialNo(conditions)+1;
		String[] receiverTypeOtherName = new String[prpLbillPayDtoList.size()];
		String[] certifNo = new String[prpLbillPayDtoList.size()];
		String[] mobilePhone = new String[prpLbillPayDtoList.size()];
		String[] provinceCode = new String[prpLbillPayDtoList.size()];
		String[] cityCode = new String[prpLbillPayDtoList.size()];
		String[] accountType = new String[prpLbillPayDtoList.size()];
		String[] bankType = new String[prpLbillPayDtoList.size()];
		String[] bankAccount = new String[prpLbillPayDtoList.size()];
		String[] accountFlag = new String[prpLbillPayDtoList.size()];
		String[] bank = new String[prpLbillPayDtoList.size()];
		String[] address = new String[prpLbillPayDtoList.size()];
		String[] payWay = new String[prpLbillPayDtoList.size()];
		String[] payReason = new String[prpLbillPayDtoList.size()];
		String[] payPurpose = new String[prpLbillPayDtoList.size()];
		String[] routeNum = new String[prpLbillPayDtoList.size()];
		
		BLTerroristFacade blTerroristFacade= new BLTerroristFacade();
		Collection collection=null;
		
		for(int i=0;i<prpLbillPayDtoList.size();i++){
			
			PrpLbillPayDto = (PrpLbillPayDto)prpLbillPayDtoList.get(i);
			receiverTypeOtherName[i] = PrpLbillPayDto.getReceiverfullName();
			certifNo[i] = PrpLbillPayDto.getCertifNo();
			mobilePhone[i] = PrpLbillPayDto.getMobilePhone();
			provinceCode[i] = PrpLbillPayDto.getProvinceName();
			cityCode[i] = PrpLbillPayDto.getCityName();
			accountType[i] = PrpLbillPayDto.getAccountType();
			bankType[i] = PrpLbillPayDto.getBankType();
			bankAccount[i] = PrpLbillPayDto.getBankAccount();
			accountFlag[i] = PrpLbillPayDto.getAccountFlag();
			bank[i] = PrpLbillPayDto.getBank();
			address[i] = PrpLbillPayDto.getAddress();
			payWay[i] = PrpLbillPayDto.getPayWay();
			payReason[i] = PrpLbillPayDto.getPayReason();
			payPurpose[i] = PrpLbillPayDto.getPayPurpose();
			routeNum[i] = PrpLbillPayDto.getRouteNum();

//			if(payName[j].equals(PrpLbillPayDto.getReceiverfullName())&&(identifyNumber[j]).trim().equals(PrpLbillPayDto.getCertifNo())&&payAmount[j].equals(String.valueOf(PrpLbillPayDto.getPayAmount()))){
				PrpLbillPayDto.setRegistNo(reQRegistNo);
				PrpLbillPayDto.setPolicyNo(reQPolicyNo);
				PrpLbillPayDto.setCompensateNo(compensateNo[0]);
				PrpLbillPayDto.setClaimNo(reQClaimNo);
				PrpLbillPayDto.setFkSerialNo(String.valueOf(serialNo++));
				PrpLbillPayDto.setPayAmounts(PrpLbillPayDto.getPayAmount()+"");
				PrpLbillPayDto.setPaymentNo(paymentNo[0]);
				PrpLbillPayDto.setPayReMark(backReason[0]);
				PrpLbillPayDto.setVflag(reQVflag);
				CheckInputUtil checkInputUtil = new CheckInputUtil();
				if("".equals(PrpLbillPayDto.getProvinceName())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，省份名称不能为空！\n";
				}else if(!"".equals(PrpLbillPayDto.getProvinceName())){
					if(!checkInputUtil.checkCityOrPro(PrpLbillPayDto.getProvinceName())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，省份名称不符合录入要求！\n";
					}
				}
				if("".equals(PrpLbillPayDto.getCityName())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，城市名称不能为空！\n";
				}else if(!"".equals(PrpLbillPayDto.getCityName())){
					if(!checkInputUtil.checkCityOrPro(PrpLbillPayDto.getCityName())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，城市名称不符合录入要求！\n";
					}
				}
				if("".equals(PrpLbillPayDto.getAccountType())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账户属性不能为空！\n";
				}else if(!"".equals(PrpLbillPayDto.getAccountType())&&!"1".equals(PrpLbillPayDto.getAccountType())&&!"2".equals(PrpLbillPayDto.getAccountType())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账户属性不是文件中规定的内容，请重新填写！\n";
					PrpLbillPayDto.setAccountType("");
				}
				if("".equals(PrpLbillPayDto.getBankType())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，银行大类不能为空！\n";
				}/*else if(!"".equals(PrpLbillPayDto.getBankType())){
					blPrpJthirdBankMappingFacade = new BLPrpJthirdBankMappingFacade();
					ArrayList list1 = (ArrayList)blPrpJthirdBankMappingFacade.findByConditions(" gybank = '"+PrpLbillPayDto.getBankType()+"'");
					if(list1.size()==0){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，银行大类“"+PrpLbillPayDto.getBankType()+"”不是系统中维护的银行，请查证后重新填写！\n";
						PrpLbillPayDto.setBankType("");
					}
				}*/
		else if(!"".equals(PrpLbillPayDto.getBankType())){
			Pattern p=Pattern.compile("^\\d{1,}$");
			if(p.matcher(PrpLbillPayDto.getBankType().trim()).matches()){
				checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，银行大类不能为纯数字！\n";						
			}
		}
				if("".equals(PrpLbillPayDto.getBank())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，开户银行不能为空！\n";
				}else if(!"".equals(PrpLbillPayDto.getBank())){
					Pattern p=Pattern.compile("^\\d{1,}$");
					if(p.matcher(PrpLbillPayDto.getBank().trim()).matches()){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，开户银行不能为纯数字！\n";							
					}else{
						/*BLSaBankBranchFacade blSaBankBranchFacade = new BLSaBankBranchFacade();
						SaBankBranchDto saBankBranchDto = null;
						ArrayList list1 = (ArrayList)blSaBankBranchFacade.findByConditions(" bankbranchcname = '"+PrpLbillPayDto.getBank()+"' ");
						if(list1.size()>0){
							saBankBranchDto = (SaBankBranchDto)list1.get(0);
							PrpLbillPayDto.setRouteNum(saBankBranchDto.getBankBranchCode());	
					}*/										
					}
				}
				if("".equals(PrpLbillPayDto.getBankAccount())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，银行账号不能为空！\n";
				}else if( PrpLbillPayDto.getBankAccount().length()<5){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，银行账号不能小于五位！\n";
				}
				if("".equals(PrpLbillPayDto.getAccountFlag())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账号类型不能为空！\n";
				}else if(!"".equals(PrpLbillPayDto.getAccountFlag())&&!"00".equals(PrpLbillPayDto.getAccountFlag())&&!"01".equals(PrpLbillPayDto.getAccountFlag())
						&&!"02".equals(PrpLbillPayDto.getAccountFlag())&&!"03".equals(PrpLbillPayDto.getAccountFlag())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账号类型不是文件中规定的内容，请重新填写！\n";
					PrpLbillPayDto.setAccountFlag("");
				}
				if("".equals(PrpLbillPayDto.getPayWay())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，支付方式不能为空！\n";
				}else if(!"".equals(PrpLbillPayDto.getPayWay())&&!"1".equals(PrpLbillPayDto.getPayWay())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，支付方式不是文件中规定的内容，请重新填写！\n";
					PrpLbillPayDto.setPayWay("");
				}
				if(!"".equals(PrpLbillPayDto.getPayWay())&&!"1".equals(PrpLbillPayDto.getPayWay())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，批量时支付方式只能为第三方支付！\n";
				}
				if("2".equals(PrpLbillPayDto.getPayWay())&&"".equals(PrpLbillPayDto.getPayReason())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账户信息中支付方式为“传统方式支付”时，支付原因不能为空！\n";
				}
				if(!"".equals(PrpLbillPayDto.getAccountType())&&!"".equals(PrpLbillPayDto.getAccountFlag())){
					if("2".equals(PrpLbillPayDto.getAccountType())&&!"03".equals(PrpLbillPayDto.getAccountFlag())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账号属性为单位时，账号类型必须为对公账户！\n";
						PrpLbillPayDto.setAccountFlag("");
					}
					if("1".equals(PrpLbillPayDto.getAccountType())&&"03".equals(PrpLbillPayDto.getAccountFlag())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账号属性为个人时，账号类型不能为对公账户！\n";
						PrpLbillPayDto.setAccountFlag("");
					}
				}
				if(PrpLbillPayDto.getCertifNo()==null || "".equals(PrpLbillPayDto.getCertifNo())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，身份证号不能为空！\n";
				}else if(PrpLbillPayDto.getCertifNo().length() > 20){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，身份证号长度不能超过20！\n";
				}
				String conditionTT=" terroristCName='"+PrpLbillPayDto.getReceiverfullName()+"' and  identifyNumber='"+PrpLbillPayDto.getCertifNo()+"' ";
				collection= blTerroristFacade.findByConditions(conditionTT);
				if(collection!=null &&collection.size()>0){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"证件号"+PrpLbillPayDto.getCertifNo()+"可能为恐怖分子！\n";
				}
				if(PrpLbillPayDto.getRouteNum()==null||"".equals(PrpLbillPayDto.getRouteNum())){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，联行号信息不能为空！\n";
				}else if(!PrpLbillPayDto.getRouteNum().matches("[0-9]+")){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，联行号信息必须为纯数字！\n";
				}else if(PrpLbillPayDto.getRouteNum().length()!=12){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，联行号长度必须为12位！\n";
				}
				if(PrpLbillPayDto.getPayAmount()==0){
					checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，支付金额不能为0！\n";
				}
				sumTotalPaidOld += PrpLbillPayDto.getPayAmount();

		}
//		if(isChecked){
//			throw new Exception("立案:"+reQClaimNo+"的理算金额大于支付清单的赔付金额。");
//		}

		if(Str.round(sumTotalPaidOld, 2) > Str.round(sumPaid, 2)){
			throw new Exception("立案:"+reQClaimNo+"的支付清单的赔付金额大于理算金额。");
		}
////		PrpLcompensateDto prpLcompensateDto = lcompensateFacade.
//		
////		if(!isChecked){
////			throw new Exception("领款人:"+PrpLbillPayDto.getReceiverfullName()+"、身份证号:"+PrpLbillPayDto.getCertifNo()+"、金额:"+PrpLbillPayDto.getPayAmount()+" 的赔付信息和系统清单列表中数据不一致，请检查导入清单。");
////		}
		request.setAttribute("sumTotalPaid", decimalFormat.format(sumTotalPaidOld));
		request.setAttribute("reQRegistNo", reQRegistNo);
		request.setAttribute("reQClaimNo", reQClaimNo);
		request.setAttribute("reQPolicyNo", reQPolicyNo);
		request.setAttribute("reQVflag", reQVflag);
		return checkMessage;
	}
	public String checkAccount(ArrayList list,ParamUtils paramUtils,HttpServletRequest request) throws Exception{
		String reQPolicyNo = paramUtils.getParameter("reQPolicyNo");
		String reQClaimNo = paramUtils.getParameter("reQClaimNo");
		String reQRegistNo = paramUtils.getParameter("reQRegistNo");
		String reQVflag = paramUtils.getParameter("reQVflag");
		String editType = paramUtils.getParameter("editType");
		String back = paramUtils.getParameter("back");
		String paymentType = paramUtils.getParameter("paymentType");//赔款类型----
		String compensateNoo = paramUtils.getParameter("compensateNo");
		/*String[] compensateNo = paramUtils.getParameterValues("compensateNo");
		String[] payName = paramUtils.getParameterValues("payName");
		String[] identifyNumber = paramUtils.getParameterValues("identifyNumber");
		String[] payAmount = paramUtils.getParameterValues("payAmount");
		String[] fkSerialNo = paramUtils.getParameterValues("fkSerialNo");
		String[] payAmounts = paramUtils.getParameterValues("payAmounts");
		String[] paymentNo = paramUtils.getParameterValues("paymentNo");
		String[] backReason = paramUtils.getParameterValues("backReason");*/
		String condi = " and rr.compensateno='"+compensateNoo+"' and registno = '"+reQRegistNo+"' and payflag in ('0','3')";
		BLPrpLclaimBillManagerFacade blPrpLclaimBillManagerFacade = new BLPrpLclaimBillManagerFacade();
		PageRecord pr = null;
		ArrayList prpLclaimBillManagerList = new ArrayList();
		pr = blPrpLclaimBillManagerFacade.findByConditonSum(condi,editType,back,0,0);
		prpLclaimBillManagerList = (ArrayList)pr.getResult();
		
		BLPrpJthirdBankMappingFacade blPrpJthirdBankMappingFacade = null;
		DecimalFormat decimalFormat = new DecimalFormat("#0.00");
		String checkMessage = "";
		double sumTotalPaidOld = 0d;
		PrpLbillPayDto PrpLbillPayDto = null;
		
		BLTerroristFacade blTerroristFacade= new BLTerroristFacade();
		Collection collection=null;
		/**
		 * 理赔清单存在领款人合并问题，所以理算书，序号，支付金额会以逗号隔开
		 */
		ArrayList listCopy = new ArrayList();
		PrpLbillPayDto PrpLbillPayDtoCopy=null;
		for(int i=0;i<list.size();i++){
			boolean isChecked = false;
			PrpLbillPayDto = (PrpLbillPayDto)list.get(i);
			for(int j=0;j<prpLclaimBillManagerList.size();j++){
				PrpLclaimBillManagerDto iiPrpLclaimBillManagerDto = (PrpLclaimBillManagerDto)prpLclaimBillManagerList.get(j);
				
				if(iiPrpLclaimBillManagerDto.getPayName().equals(PrpLbillPayDto.getReceiverfullName())
						&&(iiPrpLclaimBillManagerDto.getIdentifyNumber()).trim().equals(PrpLbillPayDto.getCertifNo())&&String.valueOf(iiPrpLclaimBillManagerDto.getPayAmount()).equals(String.valueOf(PrpLbillPayDto.getPayAmount()))){
					String[] serialNo = iiPrpLclaimBillManagerDto.getFkSerialNo().split(",");
					String[] compensateNo = iiPrpLclaimBillManagerDto.getCompensateNo().split(",");
					String[] payAmount = iiPrpLclaimBillManagerDto.getPayAmounts().split(",");
					PrpLbillPayDto.setRegistNo(reQRegistNo);
					PrpLbillPayDto.setPolicyNo(reQPolicyNo);
//					PrpLbillPayDto.setCompensateNo(iiPrpLclaimBillManagerDto.getCompensateNo());
					PrpLbillPayDto.setClaimNo(reQClaimNo);
//					PrpLbillPayDto.setFkSerialNo(iiPrpLclaimBillManagerDto.getFkSerialNo());
//					PrpLbillPayDto.setPayAmounts(iiPrpLclaimBillManagerDto.getPayAmounts());
					PrpLbillPayDto.setPaymentNo(iiPrpLclaimBillManagerDto.getPaymentNo());
					PrpLbillPayDto.setPayReMark(iiPrpLclaimBillManagerDto.getPayReMark());
					PrpLbillPayDto.setVflag(reQVflag);
					CheckInputUtil checkInputUtil = new CheckInputUtil();
					if("".equals(PrpLbillPayDto.getProvinceName())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，省份名称不能为空！\n";
					}else if(!"".equals(PrpLbillPayDto.getProvinceName())){
						if(!checkInputUtil.checkCityOrPro(PrpLbillPayDto.getProvinceName())){
							checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，省份名称不符合录入要求！\n";
						}
					}
					if("".equals(PrpLbillPayDto.getCityName())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，城市名称不能为空！\n";
					}else if(!"".equals(PrpLbillPayDto.getCityName())){
						if(!checkInputUtil.checkCityOrPro(PrpLbillPayDto.getCityName())){
							checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，城市名称不符合录入要求！\n";
						}
					}
					if("".equals(PrpLbillPayDto.getAccountType())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账户属性不能为空！\n";
					}else if(!"".equals(PrpLbillPayDto.getAccountType())&&!"1".equals(PrpLbillPayDto.getAccountType())&&!"2".equals(PrpLbillPayDto.getAccountType())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账户属性不是文件中规定的内容，请重新填写！\n";
						PrpLbillPayDto.setAccountType("");
					}
					if("".equals(PrpLbillPayDto.getBankType())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，银行大类不能为空！\n";
					}/*else if(!"".equals(PrpLbillPayDto.getBankType())){
						blPrpJthirdBankMappingFacade = new BLPrpJthirdBankMappingFacade();
						ArrayList list1 = (ArrayList)blPrpJthirdBankMappingFacade.findByConditions(" gybank = '"+PrpLbillPayDto.getBankType()+"'");
						if(list1.size()==0){
							checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，银行大类“"+PrpLbillPayDto.getBankType()+"”不是系统中维护的银行，请查证后重新填写！\n";
							PrpLbillPayDto.setBankType("");
						}
					}*/
				else if(!"".equals(PrpLbillPayDto.getBankType())){
					Pattern p=Pattern.compile("^\\d{1,}$");
					if(p.matcher(PrpLbillPayDto.getBankType().trim()).matches()){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，银行大类不能为纯数字！\n";	
					}
				}
					if("".equals(PrpLbillPayDto.getBank())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，开户银行不能为空！\n";
					}else if(!"".equals(PrpLbillPayDto.getBank())){
						Pattern p=Pattern.compile("^\\d{1,}$");
						if(p.matcher(PrpLbillPayDto.getBank().trim()).matches()){
							checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，开户银行不能为纯数字！\n";							
						}else{
						/*BLSaBankBranchFacade blSaBankBranchFacade = new BLSaBankBranchFacade();
						SaBankBranchDto saBankBranchDto = null;
						ArrayList list1 = (ArrayList)blSaBankBranchFacade.findByConditions(" bankbranchcname = '"+PrpLbillPayDto.getBank()+"' ");
						if(list1.size()>0){
							saBankBranchDto = (SaBankBranchDto)list1.get(0);
							PrpLbillPayDto.setRouteNum(saBankBranchDto.getBankBranchCode());
						}*/
						}
					}
					if("".equals(PrpLbillPayDto.getBankAccount())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，银行账号不能为空！\n";
					}else if( PrpLbillPayDto.getBankAccount().length()<5){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，银行账号不能小于五位！\n";
					}
					if("".equals(PrpLbillPayDto.getAccountFlag())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账号类型不能为空！\n";
					}else if(!"".equals(PrpLbillPayDto.getAccountFlag())&&!"00".equals(PrpLbillPayDto.getAccountFlag())&&!"01".equals(PrpLbillPayDto.getAccountFlag())
							&&!"02".equals(PrpLbillPayDto.getAccountFlag())&&!"03".equals(PrpLbillPayDto.getAccountFlag())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账号类型不是文件中规定的内容，请重新填写！\n";
						PrpLbillPayDto.setAccountFlag("");
					}
					if("".equals(PrpLbillPayDto.getPayWay())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，支付方式不能为空！\n";
					}else if(!"".equals(PrpLbillPayDto.getPayWay())&&!"1".equals(PrpLbillPayDto.getPayWay())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，支付方式不是文件中规定的内容，请重新填写！\n";
						PrpLbillPayDto.setPayWay("");
					}
					if(!"".equals(PrpLbillPayDto.getPayWay())&&!"1".equals(PrpLbillPayDto.getPayWay())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，批量时支付方式只能为第三方支付！\n";
					}
					if("2".equals(PrpLbillPayDto.getPayWay())&&"".equals(PrpLbillPayDto.getPayReason())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账户信息中支付方式为“传统方式支付”时，支付原因不能为空！\n";
					}
					if(!"".equals(PrpLbillPayDto.getAccountType())&&!"".equals(PrpLbillPayDto.getAccountFlag())){
						if("2".equals(PrpLbillPayDto.getAccountType())&&!"03".equals(PrpLbillPayDto.getAccountFlag())){
							checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账号属性为单位时，账号类型必须为对公账户！\n";
							PrpLbillPayDto.setAccountFlag("");
						}
						if("1".equals(PrpLbillPayDto.getAccountType())&&"03".equals(PrpLbillPayDto.getAccountFlag())){
							checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，账号属性为个人时，账号类型不能为对公账户！\n";
							PrpLbillPayDto.setAccountFlag("");
						}
					}
					if(PrpLbillPayDto.getCertifNo()==null || "".equals(PrpLbillPayDto.getCertifNo())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，身份证号不能为空！\n";
					}else if(PrpLbillPayDto.getCertifNo().length() > 20){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，身份证号长度不能超过20！\n";
					}
					
					String conditionTT=" terroristCName='"+PrpLbillPayDto.getReceiverfullName()+"' and  identifyNumber='"+PrpLbillPayDto.getCertifNo()+"' ";
					//collection= blTerroristFacade.findByConditions(conditionTT);
					if(collection!=null &&collection.size()>0){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"证件号"+PrpLbillPayDto.getCertifNo()+"可能为恐怖分子！\n";
					}
					if(PrpLbillPayDto.getRouteNum()==null||"".equals(PrpLbillPayDto.getRouteNum())){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，联行号信息不能为空！\n";
					}else if(!PrpLbillPayDto.getRouteNum().matches("[0-9]+")){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，联行号信息必须为纯数字！\n";
					}else if(PrpLbillPayDto.getRouteNum().length()!=12){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，联行号长度必须为12位！\n";
					}
					if(PrpLbillPayDto.getPayAmount()==0){
						checkMessage += "人员"+PrpLbillPayDto.getReceiverfullName()+"，支付金额不能为0！\n";
					}
					for(int is=0;is<serialNo.length;is++){
						PrpLbillPayDtoCopy=copyPrpLbillPay(PrpLbillPayDto);
						PrpLbillPayDtoCopy.setFkSerialNo(serialNo[is]);
						PrpLbillPayDtoCopy.setCompensateNo(compensateNo[is]);
						PrpLbillPayDtoCopy.setPayAmount(Double.parseDouble(payAmount[is]));
						listCopy.add(PrpLbillPayDtoCopy);
					}
					sumTotalPaidOld += PrpLbillPayDto.getPayAmount();
					isChecked = true;
					break;
				}
			}
			if(!isChecked){
				throw new Exception("领款人:"+PrpLbillPayDto.getReceiverfullName()+"、身份证号:"+PrpLbillPayDto.getCertifNo()+"、金额:"+PrpLbillPayDto.getPayAmount()+" 的赔付信息和系统清单列表中数据不一致，请检查导入清单。");
			}
		}
		//校验支付金额不超理算金额
		HashMap<String,Double> checkMap = new HashMap<String,Double>();
		for(int ci=0;ci<listCopy.size();ci++){
			PrpLbillPayDto copyDto= (PrpLbillPayDto)listCopy.get(ci);
			if(!checkMap.containsKey(copyDto.getCompensateNo())){
				checkMap.put(copyDto.getCompensateNo(), copyDto.getPayAmount());
			}else{
				checkMap.put(copyDto.getCompensateNo(),checkMap.get(copyDto.getCompensateNo())+copyDto.getPayAmount());
			}
		}
		 DBManager dbManager = new DBManager();
	       
	        //boolean ifOverPlanfee = false;
	        String ifOver = "NO";
		  try{
	            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	            for(Map.Entry<String,Double> entry :checkMap.entrySet()){
	            	String compensateNo=entry.getKey();
	            	double payAmount=entry.getValue();
	            	double planfee = 0.00;
	     	        double payamount = 0.00;
	                //查询数据,赋值给DTO
//		            if(null!=paymentType && "GS60".equals(paymentType)){
//		            	String queryCondtion = "select planfee from prpjplanfeecoins where certitype in ('C','Y') and certiNo = '"+compensateNo+"' and payrefreason = '"+paymentType+"'";
//		                if(null!=coinsCode && !"".equals(coinsCode)){
//		                	queryCondtion += " and coinscode ='"+coinsCode+"' ";
//		                }
//		            	ResultSet rs = dbManager.executeQuery(queryCondtion);
//		                if(rs.next()){
//		                	planfee = Str.round(Double.parseDouble(rs.getString("planfee")),2);
//		                }
//		                rs.close();
//		            }else{
		            	String queryCondtion = "select planfee from prpjplanfee where certitype in ('C','Y') and certiNo = '"+compensateNo+"' and payrefreason = '"+paymentType+"'";
		                ResultSet rs = dbManager.executeQuery(queryCondtion);
		                if(rs.next()){
		                	planfee = Str.round(Double.parseDouble(rs.getString("planfee")),2);
		                }
		                rs.close();
//		            }
		            String querySumPay = " select sum(payamount) as payamount from prplpay where compensateno = '"+compensateNo+"' and paymenttype = '"+paymentType+"'";
//		            if(null!=coinsCode && !"".equals(coinsCode)){
//		            	querySumPay += " and coinscode ='"+coinsCode+"' ";
//		            }
//		            if(null!=paymentNo && !"".equals(paymentNo)){
//		            	querySumPay += " and serialno <> '"+paymentNo+"'";
//		            }
		            ResultSet rso = dbManager.executeQuery(querySumPay);
		            String queryPayamount = "";
		            if(rso.next()){
		            	queryPayamount = rso.getString("payamount");
		            }
		            rso.close();
		            if(null == queryPayamount || "".equals(queryPayamount)){
		            	queryPayamount = "0";
		        	}
		        	payamount = Double.parseDouble(queryPayamount);
		            double nowfee = Str.round(payamount, 2) + Str.round(payAmount,2);
		            nowfee = Str.round(nowfee,2);
		            if(nowfee>planfee){
		            	ifOver = "YES";//ifOverPlanfee = true;
		            }
		            if(ifOver.equals("YES")){
			        	  throw new Exception("该笔支付对象关联的"+compensateNo+"计算书中，录入的支付金额汇总系统该计算书已录入的金额超出计算书理算金额，请核实！");
			          }
	            }
	          
	        }catch(Exception exception){
	            throw exception;
	        }finally{
	            dbManager.close();
	        }
		
		
		
		list.clear();
		list.addAll(listCopy);
		request.setAttribute("sumTotalPaid", decimalFormat.format(sumTotalPaidOld));
		request.setAttribute("reQRegistNo", reQRegistNo);
		request.setAttribute("reQClaimNo", reQClaimNo);
		request.setAttribute("reQPolicyNo", reQPolicyNo);
		request.setAttribute("reQVflag", reQVflag);
		return checkMessage;
	}
	
	public PrpLbillPayDto copyPrpLbillPay(PrpLbillPayDto PrpLbillPayDto){
		PrpLbillPayDto prpLbillPayDtoCopy =new PrpLbillPayDto();
		prpLbillPayDtoCopy.setAccountFlag(PrpLbillPayDto.getAccountFlag());
		prpLbillPayDtoCopy.setAccountType(PrpLbillPayDto.getAccountType());
		prpLbillPayDtoCopy.setAddress(PrpLbillPayDto.getAddress());
		prpLbillPayDtoCopy.setBank(PrpLbillPayDto.getBank());
		prpLbillPayDtoCopy.setBankAccount(PrpLbillPayDto.getBankAccount());
		prpLbillPayDtoCopy.setBankType(PrpLbillPayDto.getBankType());
		prpLbillPayDtoCopy.setCertifNo(PrpLbillPayDto.getCertifNo());
		prpLbillPayDtoCopy.setCertifType(PrpLbillPayDto.getCertifType());
		prpLbillPayDtoCopy.setCityName(PrpLbillPayDto.getCityName());
		prpLbillPayDtoCopy.setClaimNo(PrpLbillPayDto.getClaimNo());
		prpLbillPayDtoCopy.setComCode(PrpLbillPayDto.getComCode());
		prpLbillPayDtoCopy.setCompensateNo(PrpLbillPayDto.getCompensateNo());
		prpLbillPayDtoCopy.setFkSerialNo(PrpLbillPayDto.getFkSerialNo());
		prpLbillPayDtoCopy.setMobilePhone(PrpLbillPayDto.getMobilePhone());
		prpLbillPayDtoCopy.setOperatorcode(PrpLbillPayDto.getOperatorcode());
		prpLbillPayDtoCopy.setPayAmount(PrpLbillPayDto.getPayAmount());
		prpLbillPayDtoCopy.setPayAmounts(PrpLbillPayDto.getPayAmounts());
		prpLbillPayDtoCopy.setPaymentNo(PrpLbillPayDto.getPaymentNo());
		prpLbillPayDtoCopy.setPayPurpose(PrpLbillPayDto.getPayPurpose());
		prpLbillPayDtoCopy.setPayReason(PrpLbillPayDto.getPayReason());
		prpLbillPayDtoCopy.setPayReMark(PrpLbillPayDto.getPayReMark());
		prpLbillPayDtoCopy.setPayWay(PrpLbillPayDto.getPayWay());
		prpLbillPayDtoCopy.setPolicyNo(PrpLbillPayDto.getPolicyNo());
		prpLbillPayDtoCopy.setProvinceName(PrpLbillPayDto.getProvinceName());
		prpLbillPayDtoCopy.setReceiverfullName(PrpLbillPayDto.getReceiverfullName());
		prpLbillPayDtoCopy.setRegistNo(PrpLbillPayDto.getRegistNo());
		prpLbillPayDtoCopy.setRouteNum(PrpLbillPayDto.getRouteNum());
		prpLbillPayDtoCopy.setSerialNo(PrpLbillPayDto.getSerialNo());
		prpLbillPayDtoCopy.setStrPayAmount(PrpLbillPayDto.getStrPayAmount());
		prpLbillPayDtoCopy.setStrSerialNo(PrpLbillPayDto.getStrSerialNo());
		prpLbillPayDtoCopy.setVflag(PrpLbillPayDto.getVflag());
		return prpLbillPayDtoCopy;
	}
}


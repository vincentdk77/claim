package com.sinosoft.claim.ui.control.facade;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
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

import com.sinosoft.claim.bl.facade.BLPrpJthirdBankMappingFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimBillManagerFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.bl.facade.BLSaBankBranchFacade;
import com.sinosoft.claim.dto.domain.PrpLbillPayDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.dto.domain.SaBankBranchDto;
import com.sinosoft.claim.util.CheckInputUtil;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.ParamUtils;
import com.sinosoft.utility.PrpallUtility;
import com.sinosoft.utility.string.Str;

public class UILpaymentBillExcelFacade extends Action{

	@SuppressWarnings("deprecation")
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "";
		String content = "";
		try{
		PrpallUtility prpallUtility = new PrpallUtility();
		prpallUtility.getPhisicaMemory("�嵥����-----1");
		ParamUtils paramUtils = new ParamUtils(request);
		prpallUtility.getPhisicaMemory("�嵥����-----1.1");
		String editType = paramUtils.getParameter("editType");
		String billNo = paramUtils.getParameter("billNo");
		String isAccBack = paramUtils.getParameter("isAccBack");
		String strFilePath     = paramUtils.getParameter("FILE1");
		prpallUtility.getPhisicaMemory("�嵥����-----1.2");
		InputStream file  = new FileInputStream(strFilePath);
		System.err.println("·��:"+strFilePath);
		prpallUtility.getPhisicaMemory("�嵥����-----2");
		if (!strFilePath.toLowerCase().endsWith(".xls")) {
			OutputStream out = response.getOutputStream();
			String message = "�ϴ����ļ�����һ���Ϸ���Excel�ļ���<br>��ѡ���׺��Ϊ.xsl��Excel�ļ���";
			out.write(message.getBytes());
			out.close();
			throw new Exception(message);
		}
		ArrayList prpLbillPayDtoList = new ArrayList();
			Workbook workbook=Workbook.getWorkbook(file);
			Sheet sheet=workbook.getSheet(0);
			prpallUtility.getPhisicaMemory("�嵥����-----3");
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
							prpLbillPayDto.setPayPurpose("��Ԫ����");
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
			prpallUtility.getPhisicaMemory("�嵥����-----4");
			workbook.close();
			file.close();
			prpallUtility.getPhisicaMemory("�嵥����-----5");
			String noBillFlag = paramUtils.getParameter("noBillFlag");
			String message = "" ; 
			if(noBillFlag != null && "1".equals(noBillFlag)){
				message = checkAccountNoBill(prpLbillPayDtoList,paramUtils,request);
			}else{
				message = checkAccount(prpLbillPayDtoList,paramUtils,request);
				
			}
			//message = checkAccount(prpLbillPayDtoList,paramUtils,request);
			payRegistExtpayRegistExt(paramUtils,request);
			prpallUtility.getPhisicaMemory("�嵥����-----6");
			request.setAttribute("prpLbillPayDtoList", prpLbillPayDtoList);
			request.setAttribute("editType", editType);
			request.setAttribute("billNo", billNo);
			request.setAttribute("noBillFlag", noBillFlag);
			if("true".equals(isAccBack)){
				request.setAttribute("isAccBack", true);
			}else{
				request.setAttribute("isAccBack", false);
			}
			request.setAttribute("message", message);
			forward = "success";
		}catch  (Exception e){
			e.printStackTrace() ;
		      //������Ϣ����
		      ActionErrors errors = new ActionErrors();
		      ActionError error = new ActionError("title.uploadpay.info");
		      errors.add(ActionErrors.GLOBAL_ERROR, error);
		      request.setAttribute("error",e.getMessage()) ;
		      request.setAttribute("errorMessage",e.getMessage()) ;
		      saveErrors(request, errors);
		      forward = "error";
		}finally{
			
		}
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
		for(int i=0;i<prpLbillPayDtoList.size();i++){
			
			PrpLbillPayDto = (PrpLbillPayDto)prpLbillPayDtoList.get(i);
			

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
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"��ʡ�����Ʋ���Ϊ�գ�\n";
				}else if(!"".equals(PrpLbillPayDto.getProvinceName())){
					if(!checkInputUtil.checkCityOrPro(PrpLbillPayDto.getProvinceName())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"��ʡ�����Ʋ�����¼��Ҫ��\n";
					}
				}
				if("".equals(PrpLbillPayDto.getCityName())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���������Ʋ���Ϊ�գ�\n";
				}else if(!"".equals(PrpLbillPayDto.getCityName())){
					if(!checkInputUtil.checkCityOrPro(PrpLbillPayDto.getCityName())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���������Ʋ�����¼��Ҫ��\n";
					}
				}
				if("".equals(PrpLbillPayDto.getAccountType())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˻����Բ���Ϊ�գ�\n";
				}else if(!"".equals(PrpLbillPayDto.getAccountType())&&!"1".equals(PrpLbillPayDto.getAccountType())&&!"2".equals(PrpLbillPayDto.getAccountType())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˻����Բ����ļ��й涨�����ݣ���������д��\n";
					PrpLbillPayDto.setAccountType("");
				}
				if("".equals(PrpLbillPayDto.getBankType())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����д��಻��Ϊ�գ�\n";
				}else if(!"".equals(PrpLbillPayDto.getBankType())){
					Pattern p=Pattern.compile("^\\d{1,}$");
					if(p.matcher(PrpLbillPayDto.getBankType().trim()).matches()){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����д��಻��Ϊ�����֣�\n";						
					}else{					
					/*blPrpJthirdBankMappingFacade = new BLPrpJthirdBankMappingFacade();
					ArrayList list1 = (ArrayList)blPrpJthirdBankMappingFacade.findByConditions(" gybank = '"+PrpLbillPayDto.getBankType()+"'");
					if(list1.size()==0){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����д��ࡰ"+PrpLbillPayDto.getBankType()+"������ϵͳ��ά�������У����֤��������д��\n";
						PrpLbillPayDto.setBankType("");
					}*/}
				}
				if("".equals(PrpLbillPayDto.getBank())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���������в���Ϊ�գ�\n";
				}else if(!"".equals(PrpLbillPayDto.getBank())){
					Pattern p=Pattern.compile("^\\d{1,}$");
					if(p.matcher(PrpLbillPayDto.getBank().trim()).matches()){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���������в���Ϊ�����֣�\n";							
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
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�������˺Ų���Ϊ�գ�\n";
				}
				else if( PrpLbillPayDto.getBankAccount().length()<5){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�������˺Ų���С����λ��\n";
				}
				if("".equals(PrpLbillPayDto.getAccountFlag())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˺����Ͳ���Ϊ�գ�\n";
				}else if(!"".equals(PrpLbillPayDto.getAccountFlag())&&!"00".equals(PrpLbillPayDto.getAccountFlag())&&!"01".equals(PrpLbillPayDto.getAccountFlag())
						&&!"02".equals(PrpLbillPayDto.getAccountFlag())&&!"03".equals(PrpLbillPayDto.getAccountFlag())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˺����Ͳ����ļ��й涨�����ݣ���������д��\n";
					PrpLbillPayDto.setAccountFlag("");
				}
				if("".equals(PrpLbillPayDto.getPayWay())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"��֧����ʽ����Ϊ�գ�\n";
				}else if(!"".equals(PrpLbillPayDto.getPayWay())&&!"1".equals(PrpLbillPayDto.getPayWay())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"��֧����ʽ�����ļ��й涨�����ݣ���������д��\n";
					PrpLbillPayDto.setPayWay("");
				}
				if(!"".equals(PrpLbillPayDto.getPayWay())&&!"1".equals(PrpLbillPayDto.getPayWay())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"������ʱ֧����ʽֻ��Ϊ������֧����\n";
				}
				if("2".equals(PrpLbillPayDto.getPayWay())&&"".equals(PrpLbillPayDto.getPayReason())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˻���Ϣ��֧����ʽΪ����ͳ��ʽ֧����ʱ��֧��ԭ����Ϊ�գ�\n";
				}
				if(!"".equals(PrpLbillPayDto.getAccountType())&&!"".equals(PrpLbillPayDto.getAccountFlag())){
					if("2".equals(PrpLbillPayDto.getAccountType())&&!"03".equals(PrpLbillPayDto.getAccountFlag())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˺�����Ϊ��λʱ���˺����ͱ���Ϊ�Թ��˻���\n";
						PrpLbillPayDto.setAccountFlag("");
					}
					if("1".equals(PrpLbillPayDto.getAccountType())&&"03".equals(PrpLbillPayDto.getAccountFlag())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˺�����Ϊ����ʱ���˺����Ͳ���Ϊ�Թ��˻���\n";
						PrpLbillPayDto.setAccountFlag("");
					}
				}
				if(PrpLbillPayDto.getCertifNo()==null || "".equals(PrpLbillPayDto.getCertifNo())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����֤�Ų���Ϊ�գ�\n";
				}else if(PrpLbillPayDto.getCertifNo().length() > 20){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����֤�ų��Ȳ��ܳ���20��\n";
				}
				if(PrpLbillPayDto.getRouteNum()==null||"".equals(PrpLbillPayDto.getRouteNum())){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����к���Ϣ����Ϊ�գ�\n";
				}else if(!PrpLbillPayDto.getRouteNum().matches("[0-9]+")){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����к���Ϣ����Ϊ�����֣�\n";
				}else if(PrpLbillPayDto.getRouteNum().length()!=12){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����кų��ȱ���Ϊ12λ��\n";
				}
				if(PrpLbillPayDto.getPayAmount()==0){
					checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"��֧������Ϊ0��\n";
				}
				sumTotalPaidOld += PrpLbillPayDto.getPayAmount();

		}
//		if(isChecked){
//			throw new Exception("����:"+reQClaimNo+"�����������֧���嵥���⸶��");
//		}

		if(Str.round(sumTotalPaidOld, 2) > Str.round(sumPaid, 2)){
			throw new Exception("����:"+reQClaimNo+"��֧���嵥���⸶�����������");
		}
////		PrpLcompensateDto prpLcompensateDto = lcompensateFacade.
//		
////		if(!isChecked){
////			throw new Exception("�����:"+PrpLbillPayDto.getReceiverfullName()+"�����֤��:"+PrpLbillPayDto.getCertifNo()+"�����:"+PrpLbillPayDto.getPayAmount()+" ���⸶��Ϣ��ϵͳ�嵥�б������ݲ�һ�£����鵼���嵥��");
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
		PrpLbillPayDto PrpLbillPayDto = null;
		for(int i=0;i<list.size();i++){
			boolean isChecked = false;
			PrpLbillPayDto = (PrpLbillPayDto)list.get(i);
			for(int j=0;j<payName.length;j++){
				if(payName[j].equals(PrpLbillPayDto.getReceiverfullName())&&(identifyNumber[j]).trim().equals(PrpLbillPayDto.getCertifNo())&&payAmount[j].equals(String.valueOf(PrpLbillPayDto.getPayAmount()))){
					PrpLbillPayDto.setRegistNo(reQRegistNo);
					PrpLbillPayDto.setPolicyNo(reQPolicyNo);
					PrpLbillPayDto.setCompensateNo(compensateNo[j]);
					PrpLbillPayDto.setClaimNo(reQClaimNo);
					PrpLbillPayDto.setFkSerialNo(fkSerialNo[j]);
					PrpLbillPayDto.setPayAmounts(payAmounts[j]);
					PrpLbillPayDto.setPaymentNo(paymentNo[j]);
					PrpLbillPayDto.setPayReMark(backReason[j]);
					PrpLbillPayDto.setVflag(reQVflag);
					CheckInputUtil checkInputUtil = new CheckInputUtil();
					if("".equals(PrpLbillPayDto.getProvinceName())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"��ʡ�����Ʋ���Ϊ�գ�\n";
					}else if(!"".equals(PrpLbillPayDto.getProvinceName())){
						if(!checkInputUtil.checkCityOrPro(PrpLbillPayDto.getProvinceName())){
							checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"��ʡ�����Ʋ�����¼��Ҫ��\n";
						}
					}
					if("".equals(PrpLbillPayDto.getCityName())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���������Ʋ���Ϊ�գ�\n";
					}else if(!"".equals(PrpLbillPayDto.getCityName())){
						if(!checkInputUtil.checkCityOrPro(PrpLbillPayDto.getCityName())){
							checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���������Ʋ�����¼��Ҫ��\n";
						}
					}
					if("".equals(PrpLbillPayDto.getAccountType())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˻����Բ���Ϊ�գ�\n";
					}else if(!"".equals(PrpLbillPayDto.getAccountType())&&!"1".equals(PrpLbillPayDto.getAccountType())&&!"2".equals(PrpLbillPayDto.getAccountType())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˻����Բ����ļ��й涨�����ݣ���������д��\n";
						PrpLbillPayDto.setAccountType("");
					}
					if("".equals(PrpLbillPayDto.getBankType())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����д��಻��Ϊ�գ�\n";
					}else if(!"".equals(PrpLbillPayDto.getBankType())){
						Pattern p=Pattern.compile("^\\d{1,}$");
						if(p.matcher(PrpLbillPayDto.getBankType().trim()).matches()){
							checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����д��಻��Ϊ�����֣�\n";						
						}else{
						/*blPrpJthirdBankMappingFacade = new BLPrpJthirdBankMappingFacade();
						ArrayList list1 = (ArrayList)blPrpJthirdBankMappingFacade.findByConditions(" gybank = '"+PrpLbillPayDto.getBankType()+"'");
						if(list1.size()==0){
							checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����д��ࡰ"+PrpLbillPayDto.getBankType()+"������ϵͳ��ά�������У����֤��������д��\n";
							PrpLbillPayDto.setBankType("");
						}*/
						}
					}
					if("".equals(PrpLbillPayDto.getBank())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���������в���Ϊ�գ�\n";
					}else if(!"".equals(PrpLbillPayDto.getBank())){
						Pattern p=Pattern.compile("^\\d{1,}$");
						if(p.matcher(PrpLbillPayDto.getBank().trim()).matches()){
							checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���������в���Ϊ�����֣�\n";							
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
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�������˺Ų���Ϊ�գ�\n";
					}
					else if( PrpLbillPayDto.getBankAccount().length()<5){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�������˺Ų���С����λ��\n";
					}
					if("".equals(PrpLbillPayDto.getAccountFlag())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˺����Ͳ���Ϊ�գ�\n";
					}else if(!"".equals(PrpLbillPayDto.getAccountFlag())&&!"00".equals(PrpLbillPayDto.getAccountFlag())&&!"01".equals(PrpLbillPayDto.getAccountFlag())
							&&!"02".equals(PrpLbillPayDto.getAccountFlag())&&!"03".equals(PrpLbillPayDto.getAccountFlag())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˺����Ͳ����ļ��й涨�����ݣ���������д��\n";
						PrpLbillPayDto.setAccountFlag("");
					}
					if("".equals(PrpLbillPayDto.getPayWay())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"��֧����ʽ����Ϊ�գ�\n";
					}else if(!"".equals(PrpLbillPayDto.getPayWay())&&!"1".equals(PrpLbillPayDto.getPayWay())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"��֧����ʽ�����ļ��й涨�����ݣ���������д��\n";
						PrpLbillPayDto.setPayWay("");
					}
					if(!"".equals(PrpLbillPayDto.getPayWay())&&!"1".equals(PrpLbillPayDto.getPayWay())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"������ʱ֧����ʽֻ��Ϊ������֧����\n";
					}
					if("2".equals(PrpLbillPayDto.getPayWay())&&"".equals(PrpLbillPayDto.getPayReason())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˻���Ϣ��֧����ʽΪ����ͳ��ʽ֧����ʱ��֧��ԭ����Ϊ�գ�\n";
					}
					if(!"".equals(PrpLbillPayDto.getAccountType())&&!"".equals(PrpLbillPayDto.getAccountFlag())){
						if("2".equals(PrpLbillPayDto.getAccountType())&&!"03".equals(PrpLbillPayDto.getAccountFlag())){
							checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˺�����Ϊ��λʱ���˺����ͱ���Ϊ�Թ��˻���\n";
							PrpLbillPayDto.setAccountFlag("");
						}
						if("1".equals(PrpLbillPayDto.getAccountType())&&"03".equals(PrpLbillPayDto.getAccountFlag())){
							checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"���˺�����Ϊ����ʱ���˺����Ͳ���Ϊ�Թ��˻���\n";
							PrpLbillPayDto.setAccountFlag("");
						}
					}
					if(PrpLbillPayDto.getCertifNo()==null || "".equals(PrpLbillPayDto.getCertifNo())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����֤�Ų���Ϊ�գ�\n";
					}else if(PrpLbillPayDto.getCertifNo().length() > 20){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����֤�ų��Ȳ��ܳ���20��\n";
					}
					if(PrpLbillPayDto.getRouteNum()==null||"".equals(PrpLbillPayDto.getRouteNum())){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����к���Ϣ����Ϊ�գ�\n";
					}else if(!PrpLbillPayDto.getRouteNum().matches("[0-9]+")){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����к���Ϣ����Ϊ�����֣�\n";
					}else if(PrpLbillPayDto.getRouteNum().length()!=12){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"�����кų��ȱ���Ϊ12λ��\n";
					}
					if(PrpLbillPayDto.getPayAmount()==0){
						checkMessage += "��Ա"+PrpLbillPayDto.getReceiverfullName()+"��֧������Ϊ0��\n";
					}
					sumTotalPaidOld += PrpLbillPayDto.getPayAmount();
					isChecked = true;
					break;
				}
			}
			if(!isChecked){
				throw new Exception("�����:"+PrpLbillPayDto.getReceiverfullName()+"�����֤��:"+PrpLbillPayDto.getCertifNo()+"�����:"+PrpLbillPayDto.getPayAmount()+" ���⸶��Ϣ��ϵͳ�嵥�б������ݲ�һ�£����鵼���嵥��");
			}
		}
		request.setAttribute("sumTotalPaid", decimalFormat.format(sumTotalPaidOld));
		request.setAttribute("reQRegistNo", reQRegistNo);
		request.setAttribute("reQClaimNo", reQClaimNo);
		request.setAttribute("reQPolicyNo", reQPolicyNo);
		request.setAttribute("reQVflag", reQVflag);
		return checkMessage;
	}

}

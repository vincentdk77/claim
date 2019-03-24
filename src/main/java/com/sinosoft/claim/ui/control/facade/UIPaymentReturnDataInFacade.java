package com.sinosoft.claim.ui.control.facade;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jdom.Element;

import com.sinosoft.claim.bl.facade.BLCallCenterSendStatusFacade;
import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpJpayRefRecFacade;
import com.sinosoft.claim.bl.facade.BLPrpJplanFeeFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLrecaseFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.dto.domain.CallCenterSendStatusDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpJpayRefRecDto;
import com.sinosoft.claim.dto.domain.PrpJplanFeeDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrplpayDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.util.GHBSendmessageLogger;
import com.sinosoft.claim.util.OperXML;
import com.sinosoft.claim.webservice.client.EliteGeneralWS.EliteDBWSImpl;
import com.sinosoft.claim.webservice.client.EliteGeneralWS.EliteDBWSImplServiceLocator;
import com.sinosoft.sff.blsvr.BLPrpJpackDetail;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

/**
 * 调用：	回访数据传入接口
 * UIReturnDataInFacade
 * @author Administrator
 *
 */
public class UIPaymentReturnDataInFacade {
	GHBSendmessageLogger ghbSendmessageLogger = new GHBSendmessageLogger();
	/**
	 * 收付系统在案件有支付信息时调用 caseStatus:1支付，0支付退回
	 * @param compensateNo
	 * @throws Exception 
	 */
	public void sendPaymentReturnDate(String registNo,String caseStatus){
		long serial = System.currentTimeMillis();
		BLCallCenterSendStatusFacade blCallCenterSendStatusFacade = new BLCallCenterSendStatusFacade();
		CallCenterSendStatusDto callCenterSendStatusDto = new CallCenterSendStatusDto();
		callCenterSendStatusDto.setRegistNo(registNo);
		callCenterSendStatusDto.setCaseStatus(caseStatus);
		callCenterSendStatusDto.setSendSystem("claim");
		callCenterSendStatusDto.setSendType("3");
		callCenterSendStatusDto.setSendTime(new DateTime(new Date(),DateTime.YEAR_TO_SECOND));
		String sqlPayrefrec = "";
		try {
			ghbSendmessageLogger.log(serial,"registNo: "+registNo+" caseStatus: "+caseStatus);
			if(registNo==null||registNo.trim().length()==0){
				throw new Exception("调用：sendPaymentReturnDate(String registNo) 时，参数registNo不能为空");
			}
			double sumpay = 0D;
			double sumPaid = 0D;
			String centerCode ="";
			String centerName = "";
			String comCode ="";
			String comName = "";
			String insuredName = "";
			String reportDate = "";
			String endCaseDate = "";
			String paydate = "";
			String custgotdate = "是";
			String compensateNo = "";
			BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
			UICodeAction uiCodeAction = new UICodeAction();
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			comCode = prpLregistDto.getComCode();
			comName = uiCodeAction.translateComCode(prpLregistDto.getComCode(), true);
			insuredName = prpLregistDto.getInsuredName();
			reportDate = prpLregistDto.getReportDate().toString(DateTime.YEAR_TO_DAY);
			
			//报案日期小于2014年的案子不推送数据
			if(reportDate!=null && reportDate.length()>0){
			    int year = Integer.parseInt(reportDate.substring(0,4));
			    if(year<2014){
				    return;
			    }
			}
			String conditions = "comlevel = '3' start with ComCode = '"+prpLregistDto.getComCode()+"' "+
							 " Connect By   ComCode =  Prior UpperComCode "+
							 " AND  UpperComCode != Prior ComCode ";
			BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
			ArrayList<PrpDcompanyDto> prpDcompanyList = (ArrayList<PrpDcompanyDto>)blPrpDcompanyFacade.findByConditions(conditions);
			if(prpDcompanyList!=null&&prpDcompanyList.size()>0){
				centerName = prpDcompanyList.get(0).getComCName();
				centerCode = prpDcompanyList.get(0).getComCode();
			}
			BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
			String sql = " registno = '"+registNo+"' order by endcasedate";
			ArrayList<PrpLclaimDto> prpLclaimList = (ArrayList<PrpLclaimDto>)blPrpLclaimFacade.findByConditions(sql);
			String sqlClaimnos = "";
			if(prpLclaimList!=null&&prpLclaimList.size()>0){
				//重开赔案的案子不推送回访数据
				BLPrpLrecaseFacade prpLrecaseFacade = new BLPrpLrecaseFacade();
				PrpLrecaseDto prpLrecaseDto = prpLrecaseFacade.findByPrimaryKey(prpLclaimList.get(0).getClaimNo(), 1);
				if(prpLrecaseDto!=null){
					return;
				}
				endCaseDate = prpLclaimList.get(0).getEndCaseDate().toString(DateTime.YEAR_TO_DAY);
				for(int i = 0;i<prpLclaimList.size();i++){
					if(i==prpLclaimList.size()-1){
						sqlClaimnos += "'"+prpLclaimList.get(i).getClaimNo()+"'";
					}else{
						sqlClaimnos += "'"+prpLclaimList.get(i).getClaimNo()+"',";
					}
				}
			}
			if("".equals(sqlClaimnos)){sqlClaimnos="''";}
			String sqlPlanFee ="certitype in('C') " +
							" and payrefreason in('P60') "+
							" and claimno in("+sqlClaimnos+")";
			BLPrpJplanFeeFacade blPrpJplanFeeFacade = new BLPrpJplanFeeFacade();
			ArrayList<PrpJplanFeeDto> prpJplanFeeDtoList = (ArrayList<PrpJplanFeeDto>)blPrpJplanFeeFacade.findByConditions(sqlPlanFee);
			if(prpJplanFeeDtoList.size()==0){
				return;
			}
			String certinoSql = "";
			PrpJplanFeeDto prpJplanFeeDto = null;
			for(int m=0;m<prpJplanFeeDtoList.size();m++){
				prpJplanFeeDto = prpJplanFeeDtoList.get(m);
				sumpay += prpJplanFeeDto.getPlanFee();
				sumPaid += prpJplanFeeDto.getRealPayRefFee();
				sumpay = trans2Double(sumpay);
				sumPaid = trans2Double(sumPaid);
				if(m==prpJplanFeeDtoList.size()-1){
					certinoSql += "'"+prpJplanFeeDto.getCertiNo()+"'";
				}else{
					certinoSql += "'"+prpJplanFeeDto.getCertiNo()+"',";
				}
			}
			if("".equals(certinoSql)){certinoSql="''";}
			sqlPayrefrec += " payrefreason IN ('P60')";
			sqlPayrefrec += " and certitype in('C')";
			sqlPayrefrec += " and certino in ("+certinoSql+")";
			sqlPayrefrec += " and payrefdate is not null order by payrefdate asc";
			BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();
			ArrayList<PrpJpayRefRecDto>  prpJpayRefRecDtoList =(ArrayList<PrpJpayRefRecDto>) blPrpJpayRefRecFacade.findByConditions(sqlPayrefrec);
			if(prpJpayRefRecDtoList!=null&&prpJpayRefRecDtoList.size()>0){
				PrpJpayRefRecDto prpJpayRefRecDto =prpJpayRefRecDtoList.get(0);
				paydate = prpJpayRefRecDto.getPayRefDate().toString(DateTime.YEAR_TO_DAY);
			}
			String message = returnDataIn(serial,registNo, sumpay, sumPaid, centerName, comName, insuredName, reportDate, endCaseDate, paydate, custgotdate,centerCode,comCode);
			callCenterSendStatusDto.setSendStatus(message, "0");
			blCallCenterSendStatusFacade.insert(callCenterSendStatusDto);
		} catch (Exception e) {
			callCenterSendStatusDto.setSendStatus("", "0");
			try {
				blCallCenterSendStatusFacade.insert(callCenterSendStatusDto);
			} catch (Exception e1) {
				e1.printStackTrace();
				ghbSendmessageLogger.log(serial,e);
			}
			e.printStackTrace();
			ghbSendmessageLogger.log(serial,sqlPayrefrec);
			ghbSendmessageLogger.log(serial,e);
		}
	}
	/**
	 * 
	 * @param registno 报案号
	 * @param sumpay 赔付金额
	 * @param sumPaid 已赔付金额
	 * @param centerName 中支机构
	 * @param comName 承保机构
	 * @param insuredName 被保险人
	 * @param reportDate 报案时间
	 * @param endCaseDate 结案时间
	 * @param paydate 支付时间
	 * @param custgotdate 是否到账
	 * @throws Exception 
	 */
	private String returnDataIn(long serial,String registno,double sumpay,double sumPaid,String centerName,
		String comName,String insuredName,String reportDate,String endCaseDate,String paydate,String custgotdate,String centerCode,String comCode) throws Exception{
		try {
			String  strSumpay = String.valueOf(sumpay);
			String strSumPaid = String.valueOf(sumPaid);
			EliteDBWSImplServiceLocator service = new EliteDBWSImplServiceLocator();
			String SERVER_URL = AppConfig.get("sysconst.GHBSYNSTATUS_URL");
			service.setEliteDBWSImplEndpointAddress(SERVER_URL);
			EliteDBWSImpl facade = service.getEliteDBWSImpl();
			String paramsXml = this.sendXMLData(registno,strSumpay,strSumPaid,centerName,comName,insuredName,reportDate,endCaseDate,paydate,custgotdate,centerCode,comCode);
			ghbSendmessageLogger.log(serial,"支付信息：发送数据："+paramsXml);
			String resultXML = facade.callProcedure(paramsXml);
			ghbSendmessageLogger.log(serial,"支付信息：接收数据："+resultXML);
			String message = this.doTransData(resultXML);
			System.out.println("message="+message);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			ghbSendmessageLogger.log(serial,e);
			throw e;
		}
	}
	
	private String sendXMLData(String registno, String sumpay, String sumPaid,
			String centerName, String comName, String insuredName,
			String reportDate, String endCaseDate, String paydate,
			String custgotdate,String centerCode,String comCode) {
		
		String paramsXml = "<root>";
			paramsXml += "<sp name=\"sp_revisiteinfor\" timeout=\"10\">";
			paramsXml += "<spparam name=\"registno\">";
			paramsXml += registno;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"sumpay\">";
			paramsXml += sumpay;
			paramsXml += "</spparam> ";
			paramsXml += "<spparam name=\"sumPaid\">";
			paramsXml += sumPaid;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"centerCode\">";
			paramsXml += centerCode;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"centerName\">";
			paramsXml += centerName;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"comCode\">";
			paramsXml += comCode;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"comName\">";
			paramsXml += comName;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"insuredName\">";
			paramsXml += insuredName;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"reportDate\">";
			paramsXml += reportDate;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"endCaseDate\">";
			paramsXml += endCaseDate;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"paydate\">";
			paramsXml += paydate;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"custgotdate\">";
			paramsXml += custgotdate;
			paramsXml += "</spparam>";
			paramsXml += "</sp>";
			paramsXml += "</root>";

		return paramsXml;
	}
	/**
	 * 解析返回数据 message :000表示成功，其他显示表错误信息
	 * @throws Exception 
	 */
	private String doTransData(String iData) throws Exception {
		OperXML operXML = new OperXML();
		String message = "";
		try {
			operXML.parserFromXMLString(iData);
			System.out.println("接收的XML:" + iData);
			System.out.println("开始解析基本数据！");
			List<?> responseCodeList = operXML.getChildrenElement(iData, "datas");
			System.out.println("业务数据codesize____:" + responseCodeList.size());
			if (responseCodeList.size() < 1) {
				throw new Exception("数据类型不匹配！");
			}
			Element responseCode = (Element) responseCodeList.get(0);
			Element rowList = responseCode.getChild("row");
			String codevalue = rowList.getAttributeValue("col1").trim();
			message = codevalue;
		} catch (Exception e) {
			e.printStackTrace();
			message = "解析失败";
			throw e;
		}
		return message;
	}
	
	/**
	 *补传
	 * @param registNo
	 * @param serialNo
	 * @param type
	 * @throws Exception
	 */
	public void reissuePaymentReturnDate(String registNo,double serialNo,String type) throws Exception{
		long serial = System.currentTimeMillis();
		BLCallCenterSendStatusFacade blCallCenterSendStatusFacade = new BLCallCenterSendStatusFacade();
		CallCenterSendStatusDto callCenterSendStatusDto = blCallCenterSendStatusFacade.findByPrimaryKey(serialNo);
		callCenterSendStatusDto.setAgainSendTime(new DateTime(new Date(),DateTime.YEAR_TO_SECOND));
		String sqlPayrefrec = "";
		try {
			ghbSendmessageLogger.log(serial,"registNo: "+registNo);
			if(registNo==null||registNo.trim().length()==0){
				throw new Exception("调用：sendPaymentReturnDate(String registNo) 时，参数registNo不能为空");
			}
			double sumpay = 0D;
			double sumPaid = 0D;
			String centerName = "";
			String centerCode ="";
			String comName = "";
			String comCode ="";
			String insuredName = "";
			String reportDate = "";
			String endCaseDate = "";
			String paydate = "";
			String custgotdate = "是";
			String compensateNo = "";
			BLPrplpayFacade blPrplpayFacade = new BLPrplpayFacade();
			UICodeAction uiCodeAction = new UICodeAction();
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			comCode = prpLregistDto.getComCode();
			comName = uiCodeAction.translateComCode(prpLregistDto.getComCode(), true);
			insuredName = prpLregistDto.getInsuredName();
			reportDate = prpLregistDto.getReportDate().toString(DateTime.YEAR_TO_DAY);
			String conditions = "comlevel = '3' start with ComCode = '"+prpLregistDto.getComCode()+"' "+
							 " Connect By   ComCode =  Prior UpperComCode "+
							 " AND  UpperComCode != Prior ComCode ";
			BLPrpDcompanyFacade blPrpDcompanyFacade = new BLPrpDcompanyFacade();
			ArrayList<PrpDcompanyDto> prpDcompanyList = (ArrayList<PrpDcompanyDto>)blPrpDcompanyFacade.findByConditions(conditions);
			if(prpDcompanyList!=null&&prpDcompanyList.size()>0){
				centerName = prpDcompanyList.get(0).getComCName();
				centerCode = prpDcompanyList.get(0).getComCode();
			}
			BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
			String sql = " registno = '"+registNo+"' order by endcasedate";
			ArrayList<PrpLclaimDto> prpLclaimList = (ArrayList<PrpLclaimDto>)blPrpLclaimFacade.findByConditions(sql);
			String sqlClaimnos = "";
			if(prpLclaimList!=null&&prpLclaimList.size()>0){
				endCaseDate = prpLclaimList.get(0).getEndCaseDate().toString(DateTime.YEAR_TO_DAY);
				for(int i = 0;i<prpLclaimList.size();i++){
					if(i==prpLclaimList.size()-1){
						sqlClaimnos += "'"+prpLclaimList.get(i).getClaimNo()+"'";
					}else{
						sqlClaimnos += "'"+prpLclaimList.get(i).getClaimNo()+"',";
					}
				}
			}
			if("".equals(sqlClaimnos)){sqlClaimnos="''";}
			String sqlPlanFee ="certitype in('C') " +
							" and payrefreason in('P60') "+
							" and claimno in("+sqlClaimnos+")";
			BLPrpJplanFeeFacade blPrpJplanFeeFacade = new BLPrpJplanFeeFacade();
			ArrayList<PrpJplanFeeDto> prpJplanFeeDtoList = (ArrayList<PrpJplanFeeDto>)blPrpJplanFeeFacade.findByConditions(sqlPlanFee);
			if(prpJplanFeeDtoList.size()==0){
				return;
			}
			String certinoSql = "";
			PrpJplanFeeDto prpJplanFeeDto = null;
			for(int m=0;m<prpJplanFeeDtoList.size();m++){
				prpJplanFeeDto = prpJplanFeeDtoList.get(m);
				sumpay += prpJplanFeeDto.getPlanFee();
				sumPaid += prpJplanFeeDto.getRealPayRefFee();
				sumpay = trans2Double(sumpay);
				sumPaid = trans2Double(sumPaid);
				if(m==prpJplanFeeDtoList.size()-1){
					certinoSql += "'"+prpJplanFeeDto.getCertiNo()+"'";
				}else{
					certinoSql += "'"+prpJplanFeeDto.getCertiNo()+"',";
				}
			}
			
			if("".equals(certinoSql)){certinoSql="''";}
			sqlPayrefrec += " payrefreason IN ('P60')";
			sqlPayrefrec += " and certitype in('C')";
			sqlPayrefrec += " and certino in ("+certinoSql+")";
			sqlPayrefrec += " and payrefdate is not null order by payrefdate asc";
			BLPrpJpayRefRecFacade blPrpJpayRefRecFacade = new BLPrpJpayRefRecFacade();
			ArrayList<PrpJpayRefRecDto>  prpJpayRefRecDtoList =(ArrayList<PrpJpayRefRecDto>) blPrpJpayRefRecFacade.findByConditions(sqlPayrefrec);
			if(prpJpayRefRecDtoList!=null&&prpJpayRefRecDtoList.size()>0){
				PrpJpayRefRecDto prpJpayRefRecDto =prpJpayRefRecDtoList.get(0);
				paydate = prpJpayRefRecDto.getPayRefDate().toString(DateTime.YEAR_TO_DAY);
			}
			String message = returnDataIn(serial,registNo, sumpay, sumPaid, centerName, comName, insuredName, reportDate, endCaseDate, paydate, custgotdate,centerCode,comCode);
			callCenterSendStatusDto.setSendStatus(message, type);
			blCallCenterSendStatusFacade.update(callCenterSendStatusDto);
		} catch (Exception e) {
			callCenterSendStatusDto.setSendStatus("", type);
			try {
				blCallCenterSendStatusFacade.update(callCenterSendStatusDto);
			} catch (Exception e1) {
				e1.printStackTrace();
				ghbSendmessageLogger.log(serial,e);
			}
			e.printStackTrace();
			ghbSendmessageLogger.log(serial,sqlPayrefrec);
			ghbSendmessageLogger.log(serial,e);
		}
	}
	
	private  double trans2Double(double d){
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.parseDouble(df.format(d).toString());
	}
	
}

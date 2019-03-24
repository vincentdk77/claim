package com.sinosoft.claim.webservice.paymentinformatino;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitAction;
import com.sinosoft.claim.bl.action.domain.BLPrplreturnvisitswflogAction;
import com.sinosoft.claim.dto.domain.PrplreturnvisitDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.webservice.dto.ReturnVisitInfo;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class LIstPayInformationService {
	public PayListMainInfo getPaymentInfoBackList(String registNo) throws Exception{
		PayListMainInfo payListMainInfo = null;
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		String payMentno = null;
		DateTime payrefDate = null ;
		ArrayList<PaymentInfoBackList> paymentInfoBackList = new ArrayList<PaymentInfoBackList>();
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			StringBuffer bufsql = new StringBuffer();
			StringBuffer buffsql = new StringBuffer();
			bufsql.append("select c.paymentno, ");
			bufsql.append("rec.payrefdatetime ");
			bufsql.append("from prpjpackrefrec c,prpjpayrefrec rec ,prplclaim a,prplcompensate p ");
			bufsql.append("where c.certino = rec.certino ");
			bufsql.append("and c.payreftimes = rec.payreftimes ");
			bufsql.append("and a.claimno = p.claimno ");
			bufsql.append("and p.compensateno = rec.certino ");
			bufsql.append("and rec.payrefdatetime <>Date'1970-01-01' ");
			bufsql.append("and a.registno = '"+registNo+"' ");
			resultSet = dbManager.executeQuery(bufsql.toString());
			while(resultSet.next()){
				payMentno = dbManager.getString(resultSet, 1);//支付编号
				payrefDate = dbManager.getDateTime(resultSet, DateTime.YEAR_TO_SECOND,2);//支付时间
			}
			buffsql.append("select n.receiverfullname, ");
			buffsql.append("n.payamount, ");
			buffsql.append("n.thirdpayflag, ");
			buffsql.append("n.bankaccount ");
			buffsql.append("from prplpaymain n ");
			buffsql.append("where n.paymentno= '"+payMentno+"' ");
			resultSet2 = dbManager.executeQuery(buffsql.toString());
			while(resultSet2.next()){
				PaymentInfoBackList paymentInfoBackListinfo = new PaymentInfoBackList();
				paymentInfoBackListinfo.setPayRefName(dbManager.getString(resultSet2, 1));//领款人姓名
				paymentInfoBackListinfo.setPayRefAmount(dbManager.getDouble(resultSet2, 2));//实付金额
				paymentInfoBackListinfo.setPayStatus(dbManager.getString(resultSet2, 3));//支付状态
				paymentInfoBackListinfo.setPayAccount(dbManager.getString(resultSet2, 4));//账号
				paymentInfoBackListinfo.setPayNo(payMentno);//支付编号
				paymentInfoBackListinfo.setPayrefDate(payrefDate);//支付时间
				paymentInfoBackList.add(paymentInfoBackListinfo);
			}
			//数据转换
			PaymentInfoBackList[] paymentInfoBack = new PaymentInfoBackList[paymentInfoBackList.size()];
			for(int i = 0;i<paymentInfoBackList.size();i++){
				paymentInfoBack[i] = paymentInfoBackList.get(i);
			}
			payListMainInfo = new PayListMainInfo();
			payListMainInfo.setPaymentInfoBackList(paymentInfoBack);
		}catch(Exception e){
			throw e;
		}finally{
			if(resultSet!=null){
				resultSet.close();
			}
			if(resultSet2!=null){
				resultSet.close();
			}
			if(dbManager!=null){
				dbManager.close();
			}
		}
		return payListMainInfo;
		
	}
	
	
	public String saveReturnVisit(ReturnVisitInfomation returnVisitInfomation) throws Exception {
		String flag = "0";
		DBManager dbManager = new DBManager();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			
			PrplagrireturnvisitDto prplagrireturnvisitDto = new PrplagrireturnvisitDto();
			prplagrireturnvisitDto.setBusinessNo(returnVisitInfomation.getRegistno());
			//序号处理
			BLPrplAgrireturnvisitAction blPrplAgrireturnvisitAction = new BLPrplAgrireturnvisitAction();
			int a = blPrplAgrireturnvisitAction.getCount(dbManager," businessNo='"+returnVisitInfomation.getRegistno()+"'");
			prplagrireturnvisitDto.setSerialno(String.valueOf(a+1));
			
			prplagrireturnvisitDto.setContact(returnVisitInfomation.getContact());
			prplagrireturnvisitDto.setRecorderno(returnVisitInfomation.getRecorderno());
			prplagrireturnvisitDto.setService(returnVisitInfomation.getService());
			prplagrireturnvisitDto.setExistissue(returnVisitInfomation.getExistissue());
			prplagrireturnvisitDto.setVisitsuccess(returnVisitInfomation.getVisitSuccess());
			prplagrireturnvisitDto.setVisitnocause(returnVisitInfomation.getVisitnocause());
			prplagrireturnvisitDto.setVisitopinion(returnVisitInfomation.getVisitopinion());
			prplagrireturnvisitDto.setEnteringcode(returnVisitInfomation.getEnteringCode());
			prplagrireturnvisitDto.setEnteringname(returnVisitInfomation.getEnteringName());
			prplagrireturnvisitDto.setEnteringcomcode(returnVisitInfomation.getEnteringComcode());
			prplagrireturnvisitDto.setEnteringtime(new DateTime(returnVisitInfomation.getEnteringTime(),DateTime.YEAR_TO_SECOND));
			
			BLPrplAgrireturnvisitlogAction blPrplAgrireturnvisitlogAction = new BLPrplAgrireturnvisitlogAction();
			PrplAgrireturnvisitlogDto prplagrireturnvisitlogDto = new PrplAgrireturnvisitlogDto();
			prplagrireturnvisitlogDto.setBusinessno(returnVisitInfomation.getRegistno());
			prplagrireturnvisitlogDto.setRegistno(returnVisitInfomation.getRegistno());
			prplagrireturnvisitlogDto.setPolicyno(returnVisitInfomation.getPolicyno());
			prplagrireturnvisitlogDto.setComcode(returnVisitInfomation.getComcode());
			prplagrireturnvisitlogDto.setComcodename(returnVisitInfomation.getComcodename());
			prplagrireturnvisitlogDto.setInsuredname(returnVisitInfomation.getInsuredname());
			prplagrireturnvisitlogDto.setHandlercode(returnVisitInfomation.getEnteringCode());
			prplagrireturnvisitlogDto.setHandlername(returnVisitInfomation.getEnteringName());
			prplagrireturnvisitlogDto.setHandlercomcode(returnVisitInfomation.getEnteringComcode());
			
			
			blPrplAgrireturnvisitAction.insert(dbManager,prplagrireturnvisitDto);
			blPrplAgrireturnvisitlogAction.delete(dbManager, returnVisitInfomation.getRegistno());
			blPrplAgrireturnvisitlogAction.insert(dbManager, prplagrireturnvisitlogDto);
			dbManager.commitTransaction();
			flag = "1";
			
		
		} catch (Exception e) {
			dbManager.rollbackTransaction();
			e.printStackTrace();
			throw e;
		}finally{
            dbManager.close();
        }
		return flag;
	}
}

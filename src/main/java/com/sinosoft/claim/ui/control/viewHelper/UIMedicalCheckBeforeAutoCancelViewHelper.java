package com.sinosoft.claim.ui.control.viewHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLinterCancelClaimRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterrelationFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDuser;
import com.sinosoft.claim.webservice.AccidentPersonInfoDto;
import com.sinosoft.claim.webservice.RegistCancelRequestInfo;
import com.sinosoft.claim.webservice.CertifyInfoDto;
import com.sinosoft.claim.webservice.ClaimRequestInfo;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����ע���ӿڴ�������ĺϷ���У����
 * 
 * */
public class UIMedicalCheckBeforeAutoCancelViewHelper {
	/**
	 * �ӿڴ�������ĺϷ���У��
	 * @param payRequestInfo
	 * 
	 * */
	public String checkBeforeCancel(RegistCancelRequestInfo cancelClaimRequestInfo) throws Exception{
		String returnStr = "";
		returnStr = this.checkNotNullFields(cancelClaimRequestInfo);
		if("".equals(returnStr)){
			returnStr = this.checkFlagFieldsRange(cancelClaimRequestInfo);
		}
		if("".equals(returnStr)){
			returnStr = this.checkOperatorCodeAndMakeCom(cancelClaimRequestInfo);
		}
		if("".equals(returnStr)){
			returnStr = this.checkExistenceOfOutId(cancelClaimRequestInfo);
		}
		if("".equals(returnStr)){
			returnStr = this.checkPolicyNoAndDamageStartDate(cancelClaimRequestInfo);
		}
		if("".equals(returnStr)){
			returnStr = this.checkClaimInputdate(cancelClaimRequestInfo);
		}
		return returnStr;
	}
	
	/**
	 * �ǿ��ֶεķǿ���У�飬���в������������ֶ����ԣ�������ʾ��0^ĳ���Բ���Ϊ��
	 * @param RegistCancelRequestInfo
	 * @return String
	 * @throws Exception
	 * */
	public String checkNotNullFields(RegistCancelRequestInfo cancelClaimRequestInfo) throws Exception{
		String returnStr = "";
		if(null == cancelClaimRequestInfo){
			returnStr = "0^��ζ�����Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getOutId()==null || "".equals(cancelClaimRequestInfo.getOutId())){
			//returnStr = "0^�ͻ���������������Ϊ��";
			//return returnStr;
		}
		if(cancelClaimRequestInfo.getOutRegistNo()==null || "".equals(cancelClaimRequestInfo.getOutRegistNo())){
			returnStr = "0^�ͻ��˱�����ˮ�Ų���Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getPolicyNo()==null || "".equals(cancelClaimRequestInfo.getPolicyNo())){
			returnStr = "0^�����Ų���Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getDamageStartDate()==null || "".equals(cancelClaimRequestInfo.getDamageStartDate())){
			returnStr = "0^�¹����ڲ���Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getDamageStartHour()==null || "".equals(cancelClaimRequestInfo.getDamageStartHour())){
			returnStr = "0^�¹�ʱ�ֲ���Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getDamageCode()==null || "".equals(cancelClaimRequestInfo.getDamageCode())){
			returnStr = "0^�¹�ԭ����Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getReportDate()==null || "".equals(cancelClaimRequestInfo.getReportDate())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getReportHour()==null || "".equals(cancelClaimRequestInfo.getReportHour())){
			returnStr = "0^����ʱ�ֲ���Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getReportType()==null || "".equals(cancelClaimRequestInfo.getReportType())){
			returnStr = "0^������ʽ����Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getLinkerName()==null || "".equals(cancelClaimRequestInfo.getLinkerName())){
			returnStr = "0^��ϵ�˲���Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getPhoneNumber()==null || "".equals(cancelClaimRequestInfo.getPhoneNumber())){
			returnStr = "0^��ϵ�绰����Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getClauseType()==null || "".equals(cancelClaimRequestInfo.getClauseType())){
			returnStr = "0^���¹��߹�ϵ����Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getDamageAddress()==null || "".equals(cancelClaimRequestInfo.getDamageAddress())){
			returnStr = "0^�¹ʵص㲻��Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getDamageTypeCode()==null || "".equals(cancelClaimRequestInfo.getDamageTypeCode())){
			returnStr = "0^�¹����Ͳ���Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getOperatorCode() == null || "".equals(cancelClaimRequestInfo.getOperatorCode())){
			returnStr = "0^�����˴��벻��Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getOperatorName() == null || "".equals(cancelClaimRequestInfo.getOperatorName())){
			returnStr = "0^���������Ʋ���Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getMakeCom() == null || "".equals(cancelClaimRequestInfo.getMakeCom())){
			returnStr = "0^ע�������������Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getMakeComName() == null || "".equals(cancelClaimRequestInfo.getMakeComName())){
			returnStr = "0^ע������������Ʋ���Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getCancelDate() == null || "".equals(cancelClaimRequestInfo.getCancelDate())){
			returnStr = "0^ע��ʱ�����Ʋ���Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getDealerCode() == null || "".equals(cancelClaimRequestInfo.getDealerCode())){
			returnStr = "0^ע���˴��벻��Ϊ��";
			return returnStr;
		}
		if(cancelClaimRequestInfo.getCancelContext() == null || "".equals(cancelClaimRequestInfo.getCancelContext())){
			returnStr = "0^ע��ԭ����Ϊ��";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * ��־λ�ֶεķ�ΧУ�飬���в������������ֶ����ԣ�������ʾ��0^ĳ���Բ��Ϸ�
	 * @param RegistCancelRequestInfo
	 * @return String
	 * @throws Exception
	 * */
	public String checkFlagFieldsRange(RegistCancelRequestInfo cancelClaimRequestInfo) throws Exception{
		String returnStr = "";
		
		String damageCode = "3b8,150";
		if(!damageCode.contains(cancelClaimRequestInfo.getDamageCode())){
			returnStr = "0^�¹�ԭ�򲻺Ϸ�";
			return returnStr;
		}
		String reportType = "10,11,99";
		if(!reportType.contains(cancelClaimRequestInfo.getReportType())){
			returnStr = "0^������ʽ���Ϸ�";
			return returnStr;
		}
		String clauseType = "1,2,3";
		if(!clauseType.contains(cancelClaimRequestInfo.getClauseType())){
			returnStr = "0^���¹��߹�ϵ���Ϸ�";
			return returnStr;
		}
		if(!"999".equals(cancelClaimRequestInfo.getDamageTypeCode())){
			returnStr = "0^�¹����Ͳ��Ϸ�";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * У���ⲿoutId�Ƿ����м���д��ڣ����Ѿ����ڵĻ�����������Ϣ
	 * @param RegistCancelRequestInfo
	 * @return String
	 * @throwsException
	 * */
	public String checkExistenceOfOutId(RegistCancelRequestInfo cancelClaimRequestInfo) throws Exception{
		String returnStr = "";
		BLPrpLinterCancelClaimRequestFacade blPrpLinterCancelClaimRequestFacade = new BLPrpLinterCancelClaimRequestFacade();
		Collection collection = blPrpLinterCancelClaimRequestFacade.findByConditionsWithChild(" OutRegistNo='"+cancelClaimRequestInfo.getOutRegistNo()+"' ");
		if(collection!=null && collection.size()>0){
			Iterator it = collection.iterator();
			if(it.hasNext()){
				returnStr = "2^�������Ѿ�����������ϵͳ";
				return returnStr;
			}
		}
		
		return returnStr;
	}
	
	/**
	 * �жϲ����˴��롢���⴦����������Ȳ鿱��������Ƿ�Ϸ��������Ϸ���������ʾ��0^***���Ϸ�
	 * @param cancelClaimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkOperatorCodeAndMakeCom(RegistCancelRequestInfo cancelClaimRequestInfo) throws Exception{
		String returnStr = "";
		String operatorCode = cancelClaimRequestInfo.getOperatorCode();
		String makeCom = cancelClaimRequestInfo.getMakeCom();
		
		DBManager dbManager = new DBManager();
		try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
    		PrpDuserDto prpDuserDto = dbPrpDuser.findByPrimaryKey(operatorCode);
    		if(prpDuserDto==null){
    			returnStr = "0^�����˴��벻�Ϸ�";
    			return returnStr;
    		}
    		
    		DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
    		PrpDcompanyDto prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(makeCom);
    		if(prpDcompanyDto==null){
    			returnStr = "0^ע������������Ϸ�";
    			return returnStr;
    		}
    		
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
		return returnStr;
	}
	
	/**
	 * �ж�ҵ�񵥺ŵ���Ч��У�飨���������Ƿ���Ч����������ʾ��0^������Ϣ������
	 * �ж��¹�ʱ�䣬������Ч��֮�ڣ�������ʾ��0^�¹�ʱ�䲻�ڱ�����Ч����
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkPolicyNoAndDamageStartDate(RegistCancelRequestInfo cancelClaimRequestInfo) throws Exception{
		String returnStr = "";
		String policyNo = cancelClaimRequestInfo.getPolicyNo();
		
		Date damageDateStr = cancelClaimRequestInfo.getDamageStartDate();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String damageDate = "";
		if(null != damageDateStr){
			damageDate = simple.format(damageDateStr);
		}
		
		String damageHour = cancelClaimRequestInfo.getDamageStartHour();
		// ��ѯ������Ϣ
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate, damageHour);
		if(policyDto == null || policyDto.getPrpCmainDto()==null){
			returnStr = "0^������Ϣ������";
			return returnStr;
		}
		PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
		if(cancelClaimRequestInfo.getDamageStartDate().before(prpCmainDto.getStartDate()) 
				|| cancelClaimRequestInfo.getDamageStartDate().after(prpCmainDto.getEndDate())){
			returnStr = "0^�¹�ʱ�䲻�ڱ�����Ч����";
			return returnStr;
		}

		return returnStr;
	}
	
	/**
	 * �жϲ����˴��롢���⴦����������Ȳ鿱��������Ƿ�Ϸ��������Ϸ���������ʾ��0^***���Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkClaimInputdate(RegistCancelRequestInfo cancelClaimRequestInfo) throws Exception{
		String returnStr = "";
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateTime CancelDate = new DateTime(cancelClaimRequestInfo.getCancelDate(),DateTime.YEAR_TO_DAY);
		BLPrpLinterRequestFacade  blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		int flag = 0;
		try{
            Calendar cal = Calendar.getInstance();
            String year = String.valueOf(cal.get(Calendar.YEAR));
            String month = String.valueOf(cal.get(Calendar.MONTH));
            
            int iYear = 0;
            String iEndDate = "";
            if (month.equals("03")) {
              iEndDate = year + "-03-31";
            }
            else if (month.equals("09")) {
              iEndDate = year + "-09-30";
            }
            else if (month.equals("06")) {
              iEndDate = year + "-06-30";
            }
            else if (month.equals("12")) {
              iEndDate = year + "-12-31";
            }
            else if (month.equals("02")) {
              iYear = Integer.parseInt(year);
              //�ж��Ƿ�������
              if ( (iYear % 4 == 0 && iYear % 100 != 0) ||
                  (iYear % 400 == 0 && iYear % 100 == 0)) {
               iEndDate = year + "-02-29";
              }
              else {
                iEndDate = year + "-02-28";
              }
            }
            else if (month.equals("04") || month.equals("11")) {
              iEndDate = year + "-" + month + "-30";
            }
            else {
              iEndDate = year + "-" + month + "-31";
            }
           System.err.println("outregist="+cancelClaimRequestInfo.getOutRegistNo()+" ==VericTime==="+ CancelDate.toString()+"iEndDate==="+iEndDate);  
           flag =  PubTools.compareDate(CancelDate.toString(), iEndDate);
           if(flag>0){
        	   
           }else{
        	   returnStr = "0^ע��ʱ��С�ڵ�ǰ�µ�һ�첻��ͬ��";
     		   return returnStr;
           }
          
        }catch(Exception exception){
            throw exception;
        }finally{
           
        }
        return returnStr;
	}
	
}

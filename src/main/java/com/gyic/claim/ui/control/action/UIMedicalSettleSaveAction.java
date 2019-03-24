package com.gyic.claim.ui.control.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.gyic.claim.bl.action.domain.*;
import com.gyic.claim.bl.facade.*;
import com.gyic.claim.dto.domain.*;
import com.gyic.claim.utils.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDrisk;

public class UIMedicalSettleSaveAction extends Action{
	public ActionForward execute(ActionMapping actionMapping,
            ActionForm actionForm,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)throws Exception{

		String mappingRes="success";
		String settleListCode = trimString(httpServletRequest.getParameter("settleListCode"));
		String policyNo = trimString(httpServletRequest.getParameter("policyNo"));
		String registNo = trimString(httpServletRequest.getParameter("registNo"));
		String compensateNo = trimString(httpServletRequest.getParameter("compensateNo"));
		String timeStamp = trimString(httpServletRequest.getParameter("timeStamp"));
		httpServletRequest.setAttribute("policyNo", policyNo);
		httpServletRequest.setAttribute("registNo", registNo);
		httpServletRequest.setAttribute("nodeType", trimString(httpServletRequest.getParameter("nodeType")));
		httpServletRequest.setAttribute("riskCode", trimString(httpServletRequest.getParameter("riskCode")));
		httpServletRequest.setAttribute("editType", trimString(httpServletRequest.getParameter("editType")));
		httpServletRequest.setAttribute("claimNo", trimString(httpServletRequest.getParameter("claimNo")));
		httpServletRequest.setAttribute("compensateNo", compensateNo);
		//根据报案号和事件戳来获取临时表数据。
		Utils utils=new Utils();
		utils.getPhisicaMemory("理赔清单保存开始-----start");
		int tempCount = getMedicalSettleListTempCount(timeStamp,registNo);
		boolean isNewSettle = true;
		if(null!=settleListCode && !"".equals(settleListCode)){
			isNewSettle = false;
		}else{
			settleListCode = findSettleListInDB(policyNo,registNo,compensateNo);
			if(null!=settleListCode && !"".equals(settleListCode))
				isNewSettle = false;
		}

		if(tempCount>0){
			DBManager dbManager = new DBManager();
			dbManager.open("JKXDataSource");
			dbManager.beginTransaction();
			try {
				if(isNewSettle){
					SettlemainlistDto settleMainListDto = new SettlemainlistDto();
					BLSettlemainlistAction blSettlemainlistAction = new BLSettlemainlistAction();
					settleMainListDto = initSettleMainList(httpServletRequest);
					blSettlemainlistAction.insert(dbManager,settleMainListDto);
					settleListCode = settleMainListDto.getSettlelistcode();
				}else{
					String nodeType = trimString(httpServletRequest.getParameter("nodeType"));
					String riskCode = trimString(httpServletRequest.getParameter("riskCode"));
//				String kindCode = httpServletRequest.getParameter("kindCode");
					UIDeleteMedicalSettleListAction uiDeleteMedicalSettleListAction = new UIDeleteMedicalSettleListAction();
					boolean deleteResult = uiDeleteMedicalSettleListAction.deleteSettleLists(settleListCode, nodeType, riskCode,dbManager);
					if(!deleteResult){
						httpServletRequest.setAttribute("saveErrorMessage","无法删除清单号为："+settleListCode+" 节点类型为："+nodeType+" 险种代码为："+riskCode+" 的理赔清单。");
						return actionMapping.findForward("message");
					}
				}
				int startIndex = 1;
				if(!isNewSettle)
					startIndex = getMaxIndexInSettleList(settleListCode);
				BLMedicalsettlelistAction blMedicalSettleListAction = new BLMedicalsettlelistAction();
				for(int index=0;index<tempCount;index++){
					String whereCondition = " STRINGTIMESTAMP = '"+timeStamp+"' and REGISTCODE = '"+registNo+"' and INDEXOFSETTLE = '"+index+"'";
					blMedicalSettleListAction.evaluate(dbManager, settleListCode, startIndex, whereCondition);
					startIndex ++;
				}
				dbManager.commitTransaction();
				httpServletRequest.setAttribute("settleListCode", settleListCode);
				httpServletRequest.setAttribute("saveSuccessMessage", "理赔清单："+settleListCode+"保存成功！");
			}catch(Exception exception){
	            dbManager.rollbackTransaction();
				httpServletRequest.setAttribute("saveErrorMessage", "理赔清单："+settleListCode+"保存失败！");
				exception.printStackTrace();
				return actionMapping.findForward("message");
	        }finally{
				//无论保存是否成功都删除临时表数据。
				deleteTempTableData(timeStamp,registNo);
	            dbManager.close();
	        }
		}
		utils.getPhisicaMemory("理赔清单保存结束-----end");
		return actionMapping.findForward(mappingRes);
	}
	private SettlemainlistDto initSettleMainList(HttpServletRequest httpServletRequest)throws Exception{
		String policyNo = trimString(httpServletRequest.getParameter("policyNo"));
		String riskCode = trimString(httpServletRequest.getParameter("riskCode"));
		//String fAreaCode = trimString(httpServletRequest.getParameter("areaCode"));
		String claimNo = trimString(httpServletRequest.getParameter("claimNo"));
		String registNo = trimString(httpServletRequest.getParameter("registNo"));
		String insureListCode = trimString(httpServletRequest.getParameter("insureListCode"));
		String classCode = trimString(httpServletRequest.getParameter("classCode"));
		String compensateNo = trimString(httpServletRequest.getParameter("compensateNo"));
		
		String settleListCode = generateSettleListCode(riskCode);
		
		SettlemainlistDto settleMainListDto = new SettlemainlistDto();
		settleMainListDto.setSettlelistcode(settleListCode);
		settleMainListDto.setInusrelistcode(insureListCode);
		//settleMainListDto.setFareacode(fAreaCode);
		settleMainListDto.setReportcode(registNo);
		settleMainListDto.setRegistercode(claimNo);
		settleMainListDto.setPolicyno(policyNo);
		settleMainListDto.setClasscode(classCode);
		settleMainListDto.setRiskcode(riskCode);
		settleMainListDto.setValidity("2");
		settleMainListDto.setRemark(generateRemark(httpServletRequest));
		if(!(null==compensateNo || "".equals(compensateNo)||"null".equals(compensateNo)||"NULL".equals(compensateNo)))
			settleMainListDto.setCompensateno(compensateNo);
		UserDto user = (UserDto)httpServletRequest.getSession().getAttribute("user");
		settleMainListDto.setUpdatecode(user.getUserCode());
		DateTime currentDate = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
		settleMainListDto.setUpdatedate(currentDate);
		settleMainListDto.setOpcode(user.getUserCode());
		settleMainListDto.setDamagetime(getDamageTimeByRegistNo(registNo));
		
		return settleMainListDto;
	}
	private String generateSettleListCode(String riskCode){
		String settleListCode = "";
		settleListCode+="2";//种植险理赔清单以2开头
		Date currentTime = new Date();
		String pioDate=new SimpleDateFormat("yyMMddHHmmss").format(currentTime);
		settleListCode+=riskCode+pioDate;
		return settleListCode;
	}
	private String generateRemark(HttpServletRequest httpServletRequest)throws Exception{
		String remark = "";
		try {
			Calendar cal = Calendar.getInstance();
			int year = cal.get(java.util.Calendar.YEAR);
			remark += year + "年";
			String riskCode = trimString(httpServletRequest.getParameter("riskCode"));
			String fAreaCode = trimString(httpServletRequest.getParameter("areaCode"));
			//MedicalSettleExport medicalSettleExport = new MedicalSettleExport();
			//remark += medicalSettleExport.getAreaFullName(fAreaCode);
			BLPrpDrisk blPrpDrisk = new BLPrpDrisk();
			String strRiskcode1 = blPrpDrisk.translateCode(riskCode,true);
			remark += strRiskcode1;
			remark += "理赔清单";
		} catch (com.sinosoft.utility.error.UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return remark;
	}
	private DateTime getDamageTimeByRegistNo(String registNo)throws Exception{
		DateTime dateTime = new DateTime();
		try {
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
			if(null==prpLregistDto)
				return null;
			else{
				dateTime = prpLregistDto.getDamageStartDate();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateTime;
	}
	private int getMaxIndexInSettleList(String settleListCode)throws Exception{
		int index = 1;
		try {
			String sqlCondition = " settleListCode like '"+settleListCode+"'";
			BLMedicalsettlelistFacade blMedicalsettlelistFacade = new BLMedicalsettlelistFacade();
			int i = blMedicalsettlelistFacade.getMaxIndex(sqlCondition);
			if(0!=i)
				index = i+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return index;
	}
	private String findSettleListInDB(String policyNo, String registNo, String compensateNo)throws Exception{
		String settleListCode = "";
		if(null!=policyNo && !"".equals(policyNo) && null!=registNo && !"".equals(registNo)){
			try {
				String sqlCondition = " policyNo like '"+policyNo+"' and reportCode like '"+registNo+"' and validity like '2' ";
				if(null==compensateNo || "".equals(compensateNo))
					sqlCondition += " and (compensateNo is null or compensateNo like '') ";
				else 
					sqlCondition += " and compensateNo like '"+compensateNo+"'";
				BLSettlemainlistFacadeForMedical blSettleMainListFacade = new BLSettlemainlistFacadeForMedical();
				Collection collectionSettleMainList = blSettleMainListFacade.findByConditions(sqlCondition);
				if(null!=collectionSettleMainList && collectionSettleMainList.size()==1){
					SettlemainlistDto settleMainListDto = (SettlemainlistDto)collectionSettleMainList.toArray()[0];
					settleListCode = settleMainListDto.getSettlelistcode();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return settleListCode;
	}
	private String trimString(String string){
		if(null!=string && !"".equals(string))
			string = string.trim();
		return string;
	}
	//根据报案号和时间戳获取临时表数据。
	private Collection getMedicalSettleListTemp(String timeStamp, String registNo)throws Exception{
		Collection medicalSettleList = new ArrayList();
		String sqlCondition = " REGISTCODE = '"+registNo+"' and STRINGTIMESTAMP = '"+timeStamp+"'";
		BLMedicalsettlelisttempFacade blMedicalSettleListTempFacade = new BLMedicalsettlelisttempFacade();
		try {
			medicalSettleList = blMedicalSettleListTempFacade.findByConditions(sqlCondition);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicalSettleList;
	}
	//根据报案号和时间戳获取临时表数据。
	private int getMedicalSettleListTempCount(String timeStamp, String registNo)throws Exception{
		int result = 0;
		String sqlCondition = " REGISTCODE = '"+registNo+"' and STRINGTIMESTAMP = '"+timeStamp+"'";
		BLMedicalsettlelisttempFacade blMedicalSettleListTempFacade = new BLMedicalsettlelisttempFacade();
		try {
			result = blMedicalSettleListTempFacade.getCount(sqlCondition);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//根据报案号和时间戳删除临时表数据。
	private void deleteTempTableData(String timeStamp, String registNo)throws Exception{
		String sqlCondition = " REGISTCODE = '"+registNo+"' and STRINGTIMESTAMP = '"+timeStamp+"'";
		BLMedicalsettlelisttempFacade blMedicalSettleListTempFacade = new BLMedicalsettlelisttempFacade();
		try {
			blMedicalSettleListTempFacade.deleteByConditions(sqlCondition);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

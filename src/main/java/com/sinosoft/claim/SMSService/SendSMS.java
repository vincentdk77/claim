package com.sinosoft.claim.SMSService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gyic.claim.bl.facade.BLHerdpolicylistFacade;
import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.SMSService.feedback.MessageCenter;
import com.sinosoft.claim.SMSService.feedback.custom.MessageSendDto;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.string.Str;

public class SendSMS extends Action{
	private Map responseMap = null;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String registNo = request.getParameter("registNo");
		String checkUserName = request.getParameter("checkUserName");
		String checkUser1 = request.getParameter("checkUser1");
		String checkPhone = request.getParameter("checkPhone");
		String reportorName = request.getParameter("reportorName");
		String reportorName1 = request.getParameter("reportorName1");
		String reportorPhone = request.getParameter("reportorPhone");
		String insuredName = request.getParameter("insuredName");
		String insuredName1 = request.getParameter("insuredName1");
		String insuredPhone = request.getParameter("insuredPhone");
		String staffName0Flag = request.getParameter("staffName0Flag");
		String staffName0 = request.getParameter("staffName0");
		String staffPhone0 = request.getParameter("staffPhone0");
		String staffName1Flag = request.getParameter("staffName1Flag");
		String staffName1 = request.getParameter("staffName1");
		String staffPhone1 = request.getParameter("staffPhone1");
		String forward = "";
		try {
			
			this.prepareDate(registNo,checkUserName,checkUser1,checkPhone,reportorName,reportorName1,reportorPhone,insuredName,insuredName1,insuredPhone,staffName0Flag,staffName0,staffPhone0,staffName1Flag,staffName1,staffPhone1);
			//处理结果
			String message = this.doResult();
			request.setAttribute("message", message);
			forward = "success";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		return mapping.findForward(forward);
	}
	/**转化响应结果*/
	private String doResult(){
		StringBuffer sbMessage = new StringBuffer("");
		Iterator itr = this.responseMap.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry entry = (Map.Entry)itr.next();
			String key = (String)entry.getKey();
			String value = (String)entry.getValue();
			if("0".equals(key)){
				if("0".equals(value)){
					sbMessage.append("报案人信息发送成功！<br>");
				} else{
					sbMessage.append("报案人信息发送失败！<br>");
				} 
			}else if("1".equals(key)){
				if("0".equals(value)){
					sbMessage.append("被保险人信息发送成功！<br>");
				}else{
					sbMessage.append("被保险人信息发送失败！<br>");
				}
			}else if("2".equals(key)){
				if("0".equals(value)) {
					sbMessage.append("查勘人信息发送成功！<br>");
				}else{
					sbMessage.append("查勘人信息发送失败！<br>");
				} 
			}else if("3".equals(key)){
				if("0".equals(value)){
					sbMessage.append("转接报案人信息发送成功！<br>");
				}else{
					sbMessage.append("转接报案人信息发送失败！<br>");
				}
			}else if("4".equals(key)){
				if("0".equals(value)){
					sbMessage.append("对接人信息发送成功！<br>");
				}else{
					sbMessage.append("对接人信息发送失败！<br>");
				}
			}
			
		}
		return sbMessage.toString();
	}
	
	
	public void prepareDate(String registNo,String checkUserName,String checkUser1,String checkPhone,String reportorName,String reportorName1,String reportorPhone, String insuredName,String insuredName1,String insuredPhone,String staffName0Flag,String staffName0,String staffPhone0,String staffName1Flag,String staffName1,String staffPhone1) throws Exception{
    	MessageSendDto messageSendDto = null;
        ArrayList messageSendDtoList = new ArrayList();
        BLRegistFacade blRegistFacade = new BLRegistFacade();
        String isWhere = " registNo ='" + registNo + "'";
        String policyNo = "";
        String message = "";
        String phoneNumber = "4009696999/96999(安徽省内)";
        if("".equals(reportorPhone)){
        	reportorPhone = "未录入";
        }
        if("".equals(insuredPhone)){
        	insuredPhone = "未录入";
        }
        try {
        	String strModuleCode = AppConfig.get("sysconst.Claim_NoReceive_ModuleCode");
        	BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
       	   	PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
       	   	String detailMessage = this.getNYXDetailMessage(registNo, prpLregistDto.getRiskCode());//明细项
//       	   	String comCode  = prpLregistDto.getComCode();
//       	   	if(comCode!=null&&!"".equals(comCode)){
//       	   	  if(comCode.length()>2){	
//       	      	if("41".equals(comCode.substring(0, 2))){
//       	         	phoneNumber = "4009696999";
//       	      	}
//       	   	  } 	
//       	   	}
       	   	
		   	String msgHead = "";
		   	String msgLicenseNo = "";
		   	String msgDamageAddress = "";
			if("05".equals(prpLregistDto.getClassCode())){
				msgLicenseNo = "，车牌号码："+prpLregistDto.getLicenseNo();
				msgHead = "车险，车牌号码："+prpLregistDto.getLicenseNo();
				msgDamageAddress = "，出险地点：" + prpLregistDto.getDamageAddress();
			}else{
				msgHead = new UICodeAction().translateRiskCode(prpLregistDto.getRiskCode(),true);
			}
       	   	String damageDate = prpLregistDto.getDamageEndDate().getYear()      +"年"
					       	 +  prpLregistDto.getDamageEndDate().getMonth()     +"月"
					       	 +  prpLregistDto.getDamageEndDate().getDate()      +"日"
					       	 +  prpLregistDto.getDamageEndHour().substring(0, 2)+"时"
					       	 +  prpLregistDto.getDamageEndHour().substring(3, 5)+"分";
       	   	/**
       	   	 * 报案人*/
        	if(isNotEmpty(reportorName)){
        		message = "尊敬的客户，您的报案已受理" 
        				+ msgLicenseNo
        				+ "，报案号："+prpLregistDto.getRegistNo()
        				+ "，保单号："+prpLregistDto.getPolicyNo()
        				+ "，出险时间："+damageDate
        				+ msgDamageAddress
        				+ "，为您服务的查勘员是："+checkUser1+"，联系电话："+checkPhone
        				+ "。如有疑问，请致电："+phoneNumber+"。";
        		
        		
        		messageSendDto = new MessageSendDto();
        		messageSendDto.setMobilePhones(reportorPhone);
        		messageSendDto.setContent(message);
        		messageSendDto.setPriority("3");
        		messageSendDto.setModuleCode(strModuleCode);
        		messageSendDto.setReceive("0");
        		messageSendDto.setAcceptor("0");
        		messageSendDtoList.add(messageSendDto);
        	}
        	/**
        	 * 被保险人
        	 * 如果报案人和被保险人号码相同，则只发送一条短息*/
        	if(isNotEmpty(insuredName)&& !reportorPhone.equals(insuredPhone)){
        		message = "尊敬的客户，您的报案已受理" 
        				+ msgLicenseNo
        				+ "，报案号："+prpLregistDto.getRegistNo()
        	   			+ "，保单号："+prpLregistDto.getPolicyNo()
        	   			+ "，出险时间："+damageDate
        	   			+ msgDamageAddress
        	   			+ "，为您服务的查勘员是："+checkUser1+"，联系电话："+checkPhone
        	   			+ "。如有疑问，请致电："+phoneNumber+"。";
        		messageSendDto = new MessageSendDto();
        	    messageSendDto.setMobilePhones(insuredPhone);
		   		messageSendDto.setContent(message);
		   		messageSendDto.setPriority("3");
		   		messageSendDto.setModuleCode(strModuleCode);
		   		messageSendDto.setReceive("0");
		   		messageSendDto.setAcceptor("1");
		   		messageSendDtoList.add(messageSendDto);
			}
        	/**查勘人员*/
        	if(isNotEmpty(checkUserName)){
        		if("".equals(insuredName1)){
       			 	insuredName1 = prpLregistDto.getInsuredName();
       	     	}
        	  	message = msgHead + "，报案号："+registNo+"，保单号："+prpLregistDto.getPolicyNo()
        	  			+ "，出险时间：" + damageDate + "，出险地点："+prpLregistDto.getDamageAddress()
        	  			+ "，报案人："+reportorName1 +"，联系号码："+reportorPhone
        	  			+ "，被保险人："+insuredName1+"，联系电话："+insuredPhone
        	  			+ "。请尽快联系客户。"
        	  			+ detailMessage;
        	  	messageSendDto = new MessageSendDto();
        	  	messageSendDto.setMobilePhones(checkPhone);
		   		messageSendDto.setContent(message);
		   		messageSendDto.setPriority("3");
		   		messageSendDto.setModuleCode(strModuleCode);
		   		messageSendDto.setReceive("0");
		   		messageSendDto.setAcceptor("2");
		   		messageSendDtoList.add(messageSendDto);
         	}
        	/**转接报案人*/
        	if(isNotEmpty(staffName0Flag)){
        		message = msgHead + ",报案号：" + prpLregistDto.getRegistNo() 
         	   		   + "，保单号："+prpLregistDto.getPolicyNo()
         	   		   + "，出险时间："+ damageDate
         	   		   + "，出险地点：" + prpLregistDto.getDamageAddress()
         	   		   + "，报案人："+reportorName1 +"，联系号码："+reportorPhone
         	   		   + "，被保险人："+insuredName1+"，联系电话："+insuredPhone
         	   		   + "。" 
         	   		   + detailMessage;
        		messageSendDto = new MessageSendDto();
        		messageSendDto.setMobilePhones(staffPhone0);
		   		messageSendDto.setContent(message);
		   		messageSendDto.setPriority("3");
		   		messageSendDto.setModuleCode(strModuleCode);
		   		messageSendDto.setReceive("0");
		   		messageSendDto.setAcceptor("3");
		   		messageSendDtoList.add(messageSendDto);
 			}
        	/**对接人*/
        	if(isNotEmpty(staffName1Flag)){
        		message = msgHead + ",报案号：" + prpLregistDto.getRegistNo() 
		  	   		   + "，保单号："+prpLregistDto.getPolicyNo()
		  	   		   + "，出险时间：" + damageDate
		  	   		   + "，出险地点：" + prpLregistDto.getDamageAddress()
		  	   		   + "，报案人："+reportorName1 +"，联系号码："+reportorPhone
		  	   		   + "，被保险人："+insuredName1+"，联系电话："+insuredPhone
		  	   		   + "。" 
		  	   		   + detailMessage;
        		messageSendDto = new MessageSendDto();
        		messageSendDto.setMobilePhones(staffPhone1);
		   		messageSendDto.setContent(message);
		   		messageSendDto.setPriority("3");
		   		messageSendDto.setModuleCode(strModuleCode);
		   		messageSendDto.setReceive("0");
        		messageSendDto.setAcceptor("4");
        		messageSendDtoList.add(messageSendDto);
 			}
        	MessageCenter center = new MessageCenter();
        	if(detailMessage.equals("")){
        		this.responseMap = center.send(messageSendDtoList);
        	}else{
        		this.responseMap = center.send(messageSendDtoList,MessageCenter.SEND_URL);
        	}
		} catch (Exception e) {
			throw e;
		}
    }
    private String getNYXDetailMessage(String registNo,String riskCode) throws Exception{
    	String rtnMessage = "";
    	String taskCode = SysConfig.getProperty("SEND_MESSAGE_ADD_DETAIL","claim");
   	   	if(taskCode.indexOf(riskCode)==-1){
   	   		return rtnMessage;
   	   	}
    	BLPrplcompensateearFacade blPrplcompensateearFacade = new BLPrplcompensateearFacade();
   		Collection prplcompensateearList = blPrplcompensateearFacade.findByConditions(" registno='"+registNo.trim()+"' and nodetype = 'regis' "+"  and Businessno ='"+registNo.trim()+"' ");
   		if(prplcompensateearList.size()>0){
   			BLHerdpolicylistFacade bLHerdpolicylistFacade = new BLHerdpolicylistFacade();
   			PrplcompensateearDto prplcompensateearDto = null;
   			StringBuffer sbMessage = null;
   			Iterator herdpolicylistItr = null;
   			HerdpolicylistDto herdpolicylistDto = null;
   			String tmpPhone = "";
   			Map detailMsgMap = new HashMap();
   			for(Iterator itr = prplcompensateearList.iterator();itr.hasNext();){
   				prplcompensateearDto = (PrplcompensateearDto)itr.next();
   				//  inusrelistcode, earlabel, fcode, kindcode
   				herdpolicylistItr = bLHerdpolicylistFacade.findByConditions(" inusrelistcode= '"+prplcompensateearDto.getInusrelistcode()+"' and earlabel = '"+prplcompensateearDto.getEarno()+"' and fcode = '"+prplcompensateearDto.getFcode()+"' and kindcode = '"+prplcompensateearDto.getKindcode()+"'").iterator();
   				if(herdpolicylistItr !=null && herdpolicylistItr.hasNext()){
   					herdpolicylistDto = (HerdpolicylistDto)herdpolicylistItr.next();
   					tmpPhone = herdpolicylistDto.getPhone();
   					if("".equals(tmpPhone)) tmpPhone = "未录入";
   				}
   				if(detailMsgMap.containsKey(prplcompensateearDto.getFcode())){
   					sbMessage = (StringBuffer)detailMsgMap.get(prplcompensateearDto.getFcode());
   					sbMessage.insert(sbMessage.indexOf("。"), "，"+prplcompensateearDto.getEarno());
   				}else{
   					sbMessage=new StringBuffer("\r\n");
   					sbMessage.append("姓名：").append(prplcompensateearDto.getName()).append("，");
   					sbMessage.append("联系电话：").append(tmpPhone).append("，");
   					sbMessage.append("地址：").append(prplcompensateearDto.getBreedingareaname()).append("，");
   					sbMessage.append("耳标号：").append(prplcompensateearDto.getEarno()).append("。");
   					detailMsgMap.put(prplcompensateearDto.getFcode(), sbMessage);
   				}
				
   				
   			}
   			StringBuffer sb_totalMsg = new StringBuffer();
   			for(Iterator itr = detailMsgMap.values().iterator();itr.hasNext();){
   				sb_totalMsg.append(itr.next()); 
   			}
   			rtnMessage = "明细清单如下，" + sb_totalMsg.toString();
   		}
   		System.err.print(rtnMessage);
    	return rtnMessage;
    }
    
    public boolean isNotEmpty(String checkString){
    	if("".equals(checkString) || checkString == null){
    		return false;
    	}else{
    		return true;
    	}
    }
	
}

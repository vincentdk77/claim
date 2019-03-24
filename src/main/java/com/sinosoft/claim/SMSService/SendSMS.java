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
			//������
			String message = this.doResult();
			request.setAttribute("message", message);
			forward = "success";
		} catch (Exception e) {
			e.printStackTrace();
			forward = "error";
		}
		return mapping.findForward(forward);
	}
	/**ת����Ӧ���*/
	private String doResult(){
		StringBuffer sbMessage = new StringBuffer("");
		Iterator itr = this.responseMap.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry entry = (Map.Entry)itr.next();
			String key = (String)entry.getKey();
			String value = (String)entry.getValue();
			if("0".equals(key)){
				if("0".equals(value)){
					sbMessage.append("��������Ϣ���ͳɹ���<br>");
				} else{
					sbMessage.append("��������Ϣ����ʧ�ܣ�<br>");
				} 
			}else if("1".equals(key)){
				if("0".equals(value)){
					sbMessage.append("����������Ϣ���ͳɹ���<br>");
				}else{
					sbMessage.append("����������Ϣ����ʧ�ܣ�<br>");
				}
			}else if("2".equals(key)){
				if("0".equals(value)) {
					sbMessage.append("�鿱����Ϣ���ͳɹ���<br>");
				}else{
					sbMessage.append("�鿱����Ϣ����ʧ�ܣ�<br>");
				} 
			}else if("3".equals(key)){
				if("0".equals(value)){
					sbMessage.append("ת�ӱ�������Ϣ���ͳɹ���<br>");
				}else{
					sbMessage.append("ת�ӱ�������Ϣ����ʧ�ܣ�<br>");
				}
			}else if("4".equals(key)){
				if("0".equals(value)){
					sbMessage.append("�Խ�����Ϣ���ͳɹ���<br>");
				}else{
					sbMessage.append("�Խ�����Ϣ����ʧ�ܣ�<br>");
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
        String phoneNumber = "4009696999/96999(����ʡ��)";
        if("".equals(reportorPhone)){
        	reportorPhone = "δ¼��";
        }
        if("".equals(insuredPhone)){
        	insuredPhone = "δ¼��";
        }
        try {
        	String strModuleCode = AppConfig.get("sysconst.Claim_NoReceive_ModuleCode");
        	BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
       	   	PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(registNo);
       	   	String detailMessage = this.getNYXDetailMessage(registNo, prpLregistDto.getRiskCode());//��ϸ��
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
				msgLicenseNo = "�����ƺ��룺"+prpLregistDto.getLicenseNo();
				msgHead = "���գ����ƺ��룺"+prpLregistDto.getLicenseNo();
				msgDamageAddress = "�����յص㣺" + prpLregistDto.getDamageAddress();
			}else{
				msgHead = new UICodeAction().translateRiskCode(prpLregistDto.getRiskCode(),true);
			}
       	   	String damageDate = prpLregistDto.getDamageEndDate().getYear()      +"��"
					       	 +  prpLregistDto.getDamageEndDate().getMonth()     +"��"
					       	 +  prpLregistDto.getDamageEndDate().getDate()      +"��"
					       	 +  prpLregistDto.getDamageEndHour().substring(0, 2)+"ʱ"
					       	 +  prpLregistDto.getDamageEndHour().substring(3, 5)+"��";
       	   	/**
       	   	 * ������*/
        	if(isNotEmpty(reportorName)){
        		message = "�𾴵Ŀͻ������ı���������" 
        				+ msgLicenseNo
        				+ "�������ţ�"+prpLregistDto.getRegistNo()
        				+ "�������ţ�"+prpLregistDto.getPolicyNo()
        				+ "������ʱ�䣺"+damageDate
        				+ msgDamageAddress
        				+ "��Ϊ������Ĳ鿱Ա�ǣ�"+checkUser1+"����ϵ�绰��"+checkPhone
        				+ "���������ʣ����µ磺"+phoneNumber+"��";
        		
        		
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
        	 * ��������
        	 * ��������˺ͱ������˺�����ͬ����ֻ����һ����Ϣ*/
        	if(isNotEmpty(insuredName)&& !reportorPhone.equals(insuredPhone)){
        		message = "�𾴵Ŀͻ������ı���������" 
        				+ msgLicenseNo
        				+ "�������ţ�"+prpLregistDto.getRegistNo()
        	   			+ "�������ţ�"+prpLregistDto.getPolicyNo()
        	   			+ "������ʱ�䣺"+damageDate
        	   			+ msgDamageAddress
        	   			+ "��Ϊ������Ĳ鿱Ա�ǣ�"+checkUser1+"����ϵ�绰��"+checkPhone
        	   			+ "���������ʣ����µ磺"+phoneNumber+"��";
        		messageSendDto = new MessageSendDto();
        	    messageSendDto.setMobilePhones(insuredPhone);
		   		messageSendDto.setContent(message);
		   		messageSendDto.setPriority("3");
		   		messageSendDto.setModuleCode(strModuleCode);
		   		messageSendDto.setReceive("0");
		   		messageSendDto.setAcceptor("1");
		   		messageSendDtoList.add(messageSendDto);
			}
        	/**�鿱��Ա*/
        	if(isNotEmpty(checkUserName)){
        		if("".equals(insuredName1)){
       			 	insuredName1 = prpLregistDto.getInsuredName();
       	     	}
        	  	message = msgHead + "�������ţ�"+registNo+"�������ţ�"+prpLregistDto.getPolicyNo()
        	  			+ "������ʱ�䣺" + damageDate + "�����յص㣺"+prpLregistDto.getDamageAddress()
        	  			+ "�������ˣ�"+reportorName1 +"����ϵ���룺"+reportorPhone
        	  			+ "���������ˣ�"+insuredName1+"����ϵ�绰��"+insuredPhone
        	  			+ "���뾡����ϵ�ͻ���"
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
        	/**ת�ӱ�����*/
        	if(isNotEmpty(staffName0Flag)){
        		message = msgHead + ",�����ţ�" + prpLregistDto.getRegistNo() 
         	   		   + "�������ţ�"+prpLregistDto.getPolicyNo()
         	   		   + "������ʱ�䣺"+ damageDate
         	   		   + "�����յص㣺" + prpLregistDto.getDamageAddress()
         	   		   + "�������ˣ�"+reportorName1 +"����ϵ���룺"+reportorPhone
         	   		   + "���������ˣ�"+insuredName1+"����ϵ�绰��"+insuredPhone
         	   		   + "��" 
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
        	/**�Խ���*/
        	if(isNotEmpty(staffName1Flag)){
        		message = msgHead + ",�����ţ�" + prpLregistDto.getRegistNo() 
		  	   		   + "�������ţ�"+prpLregistDto.getPolicyNo()
		  	   		   + "������ʱ�䣺" + damageDate
		  	   		   + "�����յص㣺" + prpLregistDto.getDamageAddress()
		  	   		   + "�������ˣ�"+reportorName1 +"����ϵ���룺"+reportorPhone
		  	   		   + "���������ˣ�"+insuredName1+"����ϵ�绰��"+insuredPhone
		  	   		   + "��" 
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
   					if("".equals(tmpPhone)) tmpPhone = "δ¼��";
   				}
   				if(detailMsgMap.containsKey(prplcompensateearDto.getFcode())){
   					sbMessage = (StringBuffer)detailMsgMap.get(prplcompensateearDto.getFcode());
   					sbMessage.insert(sbMessage.indexOf("��"), "��"+prplcompensateearDto.getEarno());
   				}else{
   					sbMessage=new StringBuffer("\r\n");
   					sbMessage.append("������").append(prplcompensateearDto.getName()).append("��");
   					sbMessage.append("��ϵ�绰��").append(tmpPhone).append("��");
   					sbMessage.append("��ַ��").append(prplcompensateearDto.getBreedingareaname()).append("��");
   					sbMessage.append("����ţ�").append(prplcompensateearDto.getEarno()).append("��");
   					detailMsgMap.put(prplcompensateearDto.getFcode(), sbMessage);
   				}
				
   				
   			}
   			StringBuffer sb_totalMsg = new StringBuffer();
   			for(Iterator itr = detailMsgMap.values().iterator();itr.hasNext();){
   				sb_totalMsg.append(itr.next()); 
   			}
   			rtnMessage = "��ϸ�嵥���£�" + sb_totalMsg.toString();
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

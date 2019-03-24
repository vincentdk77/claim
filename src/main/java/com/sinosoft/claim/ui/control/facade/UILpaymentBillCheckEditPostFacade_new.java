package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.fxq.bl.facade.BLTerroristFacade;

public class UILpaymentBillCheckEditPostFacade_new extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			String[] payName = request.getParameterValues("payName");
			String[] provinceName = request.getParameterValues("provinceName");
			String[] cityName = request.getParameterValues("cityName");
			String[] accountType = request.getParameterValues("accountType");
			String[] bankName = request.getParameterValues("bankName");
			String[] openBank = request.getParameterValues("openBank");
			String[] bankAccount = request.getParameterValues("bankAccount");
			String[] accountFlag = request.getParameterValues("accountFlag");
			String[] mobilePhone = request.getParameterValues("mobilePhone");
			String[] address = request.getParameterValues("address");
			String[] payWay = request.getParameterValues("payWay");
			String[] ipayAmount = request.getParameterValues("payAmount");
			String[] payReason = request.getParameterValues("payReason");
			String[] identifyNumber = request.getParameterValues("identifyNumber");
			
			//zf0000000000
			BLTerroristFacade blTerroristFacade= new BLTerroristFacade();
			Collection collection=null;
			String conditions="";
			response.setCharacterEncoding("GBK");
			String message = "";
			try {
				for(int i=0;i<payName.length;i++){
					if(provinceName[i]==null||"".equals(provinceName[i])||"".equals(provinceName[i].trim())){
				   		message += "��Ա"+payName[i]+"�˻���Ϣ��ʡ�����Ʋ���Ϊ�գ�\n";
				    }
				   
				   if(cityName[i]==null||"".equals(cityName[i])||"".equals(cityName[i].trim())){
				   		message += "��Ա"+payName[i]+"�˻���Ϣ�г������Ʋ���Ϊ�գ�\n";
				   }
				   
				   if(accountType[i]==null||"".equals(accountType[i])||"".equals(accountType[i].trim())){
				   		message += "��Ա"+payName[i]+"�˻���Ϣ���˻����Բ���Ϊ�գ�\n";
				   }
				   
					if(bankName[i] == null||"".equals(bankName[i])||"".equals(bankName[i].trim())){
						message += "��Ա"+payName[i]+"�˻���Ϣ�����д��಻��Ϊ�գ�\n";
					}
					
					if(openBank[i] == null||"".equals(openBank[i])||"".equals(openBank[i].trim())){
						message += "��Ա"+payName[i]+"�˻���Ϣ�п������в���Ϊ�գ�\n";
					}
					
					if(bankAccount[i] == null||"".equals(bankAccount[i])||"".equals(bankAccount[i].trim())){
						message += "��Ա"+payName[i]+"�˻���Ϣ�������˺Ų���Ϊ�գ�\n";
					}
					//У�������˺Ų���С����λ
					else if( bankAccount[i].trim().length()<5){
						message += "��Ա"+payName[i]+"�˻���Ϣ�������˺Ų���С����λ��\n";
					}
					
				   if(accountFlag[i] ==null||"".equals(accountFlag[i])||"".equals(accountFlag[i].trim())){
				   		message += "��Ա"+payName[i]+"�˻���Ϣ���˺����Ͳ���Ϊ�գ�\n";
				   }
					
					if(payWay[i] == null||"".equals(payWay[i])||"".equals(payWay[i].trim())){
						message += "��Ա"+payName[i]+"�˻���Ϣ��֧����ʽ����Ϊ�գ�\n" ;
					}
					if("2".equals(payWay[i])){
					    message += "��Ա"+payName[i]+"������֧��ʱ,�˻���Ϣ�е�֧����ʽֻ��ѡ�������֧����\n";
					}
					if("2".equals(payWay[i])&&"".equals(payReason[i])){
						message += "��Ա"+payName[i]+"�˻���Ϣ��֧����ʽΪ����ͳ��ʽ֧����ʱ��֧��ԭ����Ϊ�գ�\n";
					}
					 
					 if(Double.parseDouble(ipayAmount[i])<=0&&"1".equals(payWay[i])){
					 	message += "��Ա"+payName[i]+"�˻���Ϣ�б���֧�����Ϊ0����ʱ��֧����ʽ��ѡ�񡰴�ͳ��ʽ֧������\n";
					 }
					 
					 if(identifyNumber[i]==null || "".equals(identifyNumber[i])){
						 message += "��Ա"+payName[i]+"���֤�Ų���Ϊ�գ�\n";
					 }else if(identifyNumber[i].length() > 20){
						 message += "��Ա"+payName[i]+"���֤�ų��Ȳ��ܳ���20��\n";
					 }
					 if(identifyNumber[i]!=null &&!"".equals(identifyNumber[i])
							 && payName[i]!=null && !"".equals(payName[i]) && !"".equals(payName[i].trim())){
						 conditions=" terroristCName='"+payName[i]+"' and  identifyNumber='"+identifyNumber[i]+"' ";
						collection= blTerroristFacade.findByConditions(conditions);
						if(collection!=null &&collection.size()>0){
							 message += "��Ա"+payName[i]+"֤����"+identifyNumber[i]+"����Ϊ�ֲ����ӣ�\n";
						}
					 }
					 
				}
				response.getWriter().write("true##"+message);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
    	   
		return null;
	}

}

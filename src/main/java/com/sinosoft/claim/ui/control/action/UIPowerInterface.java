/*
 * Created on 2005-4-28
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */ 
package com.sinosoft.claim.ui.control.action;


import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.function.power.ui.action.UIPowerAction;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.sysframework.reference.AppConfig;
/** 
 * @author Administrator 
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class UIPowerInterface { 
	
	/**
	 * ���������Ա���Ƿ�������ĳ������������͵�Ȩ��
	 * 
	 * @param user PrpDuserDto
	 * @param taskCode �������
	 * @param checkCode Ȩ�޲�������(r:�� x:ִ�� w��д��
	 * @param groupCode Ȩ�����
	 * @return �Ƿ���в���Ȩ�ޣ���Ȩ�޷���true����Ȩ�޷���false
	 */
	
	public boolean checkPower(String userCode, 
			String taskCode, 
			String checkCode, 
			String groupCode) 
	throws Exception {
		String platFlag = AppConfig.get("sysconst.CompanyCode");
		
		if("CCIC".equals(platFlag)){ 
			UIPowerAction uiPowerAction = new UIPowerAction();  
			boolean bln = uiPowerAction.checkPower(userCode,groupCode,taskCode,checkCode);
			return bln;   
		}else if("SUNSHINE".equalsIgnoreCase(platFlag)){
			UIPowerAction uiPowerAction = new UIPowerAction();  
			boolean bln = uiPowerAction.checkPower(userCode,groupCode,taskCode,checkCode);
			return bln; 
		}else{ 
			UIPowerAction uiPowerAction = new UIPowerAction();  
			boolean bln = uiPowerAction.checkPower(userCode,"0101",taskCode,checkCode);
			return bln; 
		}
	}
	
	/** 
	 * �����ⲿ�����Ա������+�������+Ȩ����Ż�ȡ��ѯ��������Ȩ��
	 * 
	 * @param user PrpDuserDto
	 * @param taskCode �������
	 * @param tableName ����
	 * @param groupCode Ȩ�����
	 * @throws Exception
	 * @return String
	 */    
	public String addPower(String userCode, String taskCode, String tableName,String riskCode) throws Exception {    
		if(taskCode==null)taskCode="lp";  
		UIPowerAction uiPowerAction = new UIPowerAction();  
		String condition = uiPowerAction.addPower(userCode,riskCode,taskCode,tableName);
		return condition;
	}
	 
	//add by zhaolu 20060816 start
	//reason�����Ȩ��
	public String addPower(UserDto user, String tableName, String userCodeFields, String comCodeFields) throws Exception
	{
		PrpDuserDto userDto =UserToPrpDuser.convert(user);
//		System.out.println("userDtoffffffffffffffffff=="+userDto.getLoginComCode());
		if("0000000000".equals(userDto.getLoginComCode())){
		    return "";	
		}else{
		String condition = com.sinosoft.platform.ui.control.action.UIPowerAction.addPower(userDto,tableName,userCodeFields,comCodeFields);
		return condition;
		}
	}
	//add by zhaolu 20060816 end
	
   //add by zhaolu 20060816 start
   public boolean checkPowerReturn(UserDto user,String taskCode) throws Exception
   {
	   
	   PrpDuserDto userDto = UserToPrpDuser.convert(user);
	   boolean bln = com.sinosoft.platform.ui.control.action.UIPowerAction.checkPowerReturn(userDto,taskCode);
	   return bln;
	  
   }
   
   public void checkDataPower(UserDto user,String dataUserCode,String dataComCode) throws Exception
   {
	   PrpDuserDto userDto = UserToPrpDuser.convert(user);
	   com.sinosoft.platform.ui.control.action.UIPowerAction.checkDataPower(userDto,dataUserCode,dataUserCode);
   }
  //add by zhaolu 20060816 end
   
// add by zhaolu 20060827 start
   //����������
    public String addRiskPower(UserDto user,String tableName) throws Exception
    {
            PrpDuserDto userDto = UserToPrpDuser.convert(user);
            String condition = com.sinosoft.platform.ui.control.action.UIPowerAction.addRiskPower(userDto,tableName);
            //String condition="";
            return condition;
    }
   
    //���û�����������
    public String addCustomerPower(UserDto user, String tableName, String userCodeFields, String comCodeFields) throws Exception
    {
            PrpDuserDto userDto = UserToPrpDuser.convert(user);
            //String condition="";
//    		System.out.println("userDtoffffffffffffffffff=="+userDto.getLoginComCode());
    		if("0000000000".equals(userDto.getLoginComCode())){
    		    return "";	
    		}else{
             String condition = com.sinosoft.platform.ui.control.action.UIPowerAction.addCustomerPower(userDto,tableName,userCodeFields,comCodeFields);
             return condition;
    		}
    }
   //add by zhaolu 20060827 end
	
}

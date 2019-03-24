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
	 * 检验给定的员工是否具有针对某个任务操作类型的权限
	 * 
	 * @param user PrpDuserDto
	 * @param taskCode 任务代码
	 * @param checkCode 权限操作代码(r:读 x:执行 w：写）
	 * @param groupCode 权限组号
	 * @return 是否具有操作权限，有权限返回true，无权限返回false
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
	 * 根据外部传入的员工代码+任务代码+权限组号获取查询条件附加权限
	 * 
	 * @param user PrpDuserDto
	 * @param taskCode 任务代码
	 * @param tableName 表名
	 * @param groupCode 权限组号
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
	//reason添加新权限
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
   //对险种限制
    public String addRiskPower(UserDto user,String tableName) throws Exception
    {
            PrpDuserDto userDto = UserToPrpDuser.convert(user);
            String condition = com.sinosoft.platform.ui.control.action.UIPowerAction.addRiskPower(userDto,tableName);
            //String condition="";
            return condition;
    }
   
    //对用户机构的限制
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

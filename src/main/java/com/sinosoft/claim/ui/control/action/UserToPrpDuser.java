package com.sinosoft.claim.ui.control.action;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.custom.UserDto;
/**
 * 
 * @author Administrator
 * ������ϵͳ��UserDto����ƽ̨ϵͳ��PrpDuserDto�����ת��
 */
public class UserToPrpDuser{
	public UserToPrpDuser(){
		
	}
	public static PrpDuserDto convert(UserDto user){
		 PrpDuserDto prpDuser = new PrpDuserDto();
		 prpDuser.setUserCode(user.getUserCode());
		 prpDuser.setLoginComCode(user.getComCode());
		 prpDuser.setLoginGradeCodes(user.getLoginGradeCodes());
	     prpDuser.setLoginSystemCode("claim");
	     return prpDuser;
    }
	
}
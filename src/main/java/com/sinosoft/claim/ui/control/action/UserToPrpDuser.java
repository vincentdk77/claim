package com.sinosoft.claim.ui.control.action;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.custom.UserDto;
/**
 * 
 * @author Administrator
 * 从理赔系统的UserDto对象到平台系统的PrpDuserDto对象的转换
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
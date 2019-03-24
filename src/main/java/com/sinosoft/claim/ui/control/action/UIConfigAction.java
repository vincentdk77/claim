package com.sinosoft.claim.ui.control.action;

import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
/**
 * 常量信息
 * <p>Title: 获取险种属性常量  </p>
 * <p>Description: 通过险种号和属性名称获取属性常量值</p>
 * <p>Copyright: Copyright (c) 2005/7/20</p>
 * <p>Company: Sinosoft/sunny</p>
 * @author qinyongli
 * @version 1.0  
 */
public class UIConfigAction {
	private static UIConfigAction uiConfigAction= new UIConfigAction();
	public static UIConfigAction getInstance(){
		return uiConfigAction;
	}
	
	private String   configValue = "" ;
	private String   comCode     = "00000000"; 
	PrpDriskConfigDto prpDriskConfigDto= new PrpDriskConfigDto();
	//默认构造函数
	public UIConfigAction(){
	}
	//通过机构代码、险种和属性名称返回参数值
	public String getConfigValue(String configCode, String riskCode) throws Exception {
		BLPrpDriskConfigFacade blPrpDriskConfigFacade = new BLPrpDriskConfigFacade();
		try{
			if(!configCode.equals("")&&!riskCode.equals("")){
		            prpDriskConfigDto = blPrpDriskConfigFacade.findByPrimaryKey(comCode,riskCode,configCode);
			}
			if(prpDriskConfigDto!=null){
			    configValue =prpDriskConfigDto.getConfigValue();
			}
		}catch(Exception e){
			throw e;
		}
		return configValue ;
	} 
}
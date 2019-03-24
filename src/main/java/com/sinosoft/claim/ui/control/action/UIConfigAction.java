package com.sinosoft.claim.ui.control.action;

import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
/**
 * ������Ϣ
 * <p>Title: ��ȡ�������Գ���  </p>
 * <p>Description: ͨ�����ֺź��������ƻ�ȡ���Գ���ֵ</p>
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
	//Ĭ�Ϲ��캯��
	public UIConfigAction(){
	}
	//ͨ���������롢���ֺ��������Ʒ��ز���ֵ
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
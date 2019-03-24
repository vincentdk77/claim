package com.sinosoft.communication.bl.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.communication.dto.custom.PrplCommunicatPersonDto;

public class BLPrplCommunicatPersonFacade extends
		BLPrplCommunicatPersonFacadeBase {
	public BLPrplCommunicatPersonFacade(){}
	
	/**
	 * 根据沟通号码获取沟通人列表，包含扩展字段的赋值
	 * @param communicationNo
	 * @return
	 */
	public ArrayList getPersonList(String communicationNo) throws Exception{
		ArrayList result = new ArrayList();
		UICodeAction uiCodeAction = new UICodeAction();
		Collection collection = this.findByCommunicationNo(communicationNo);
		Iterator it = collection.iterator();
		while (it.hasNext()){
			PrplCommunicatPersonDto pPrplCommunicatPersonDto = (PrplCommunicatPersonDto)it.next();
			pPrplCommunicatPersonDto.setComCName(uiCodeAction.translateComCode(pPrplCommunicatPersonDto.getComCode(), true));
			result.add(pPrplCommunicatPersonDto);
		}
		return result;
	}
}

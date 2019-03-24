package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.sinosoft.claim.dto.domain.PrpLmenuDto;
import com.sinosoft.claim.ui.control.action.UIMenuFuncAction;

/**
 * <p>
 * Title: ClaimStatusViewHelper
 * </p>
 * <p>
 * Description:����ڵ�״̬ViewHelper�࣬�ڸ��������ҳ�����ݵ�����
 * </p>
 * <p>
 * Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004
 * </p>
 * 
 * @author ����������Ŀ�� liubvo
 * @version 1.0 <br>
 */

public class MenuFuncViewHelper {
	/**
	 * Ĭ�Ϲ��췽��
	 */
	public MenuFuncViewHelper() {
	}
	
	/**
	 * ��ʼ���˵�
	 * 
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void initMenu(HttpServletRequest httpServletRequest)
	throws Exception {
		// ȡ�ò˵�����Ϣ
		UIMenuFuncAction uiMenuFuncAction = new UIMenuFuncAction();
		String conditions = " 1=1 and UseFlag='1' and ModelName='claim' order by funcid";
		Collection collection = uiMenuFuncAction.findByConditions(conditions);
		PrpLmenuDto prpLmenuDto = new PrpLmenuDto();
		prpLmenuDto.setMenuFuncList(collection);
		
		//modify by mengdongdong 2006-03-04 �����ݼ��У��ֱ�����������Ĳ˵�
		Collection  menuLevelList1 = new ArrayList();  //һ���˵�
		Collection  menuLevelList2 = new ArrayList();  //�����˵�
		Collection  menuLevelList3 = new ArrayList();  //�����˵�
		
		for (Iterator iter = collection.iterator(); iter.hasNext();) {
			PrpLmenuDto prpLmenu = (PrpLmenuDto)iter.next();
			if(prpLmenu.getFuncLevel().trim().equals("1")){//һ���˵�
				menuLevelList1.add(prpLmenu);
			}else if(prpLmenu.getFuncLevel().trim().equals("2")){
				menuLevelList2.add(prpLmenu);
			}else if(prpLmenu.getFuncLevel().trim().equals("3")){
				menuLevelList3.add(prpLmenu);
			}
			
		}
		prpLmenuDto.setMenuLevel1(menuLevelList1); 
		prpLmenuDto.setMenuLevel2(menuLevelList2);
		prpLmenuDto.setMenuLevel3(menuLevelList3);

		//modify by mengdongdong end 2006-03-04
		
		httpServletRequest.getSession().setAttribute("prpLmenuDto", prpLmenuDto);
	}
}

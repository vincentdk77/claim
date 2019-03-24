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
 * Description:理赔节点状态ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 liubvo
 * @version 1.0 <br>
 */

public class MenuFuncViewHelper {
	/**
	 * 默认构造方法
	 */
	public MenuFuncViewHelper() {
	}
	
	/**
	 * 初始化菜单
	 * 
	 * @param httpServletRequest
	 * @throws Exception
	 */
	public void initMenu(HttpServletRequest httpServletRequest)
	throws Exception {
		// 取得菜单的信息
		UIMenuFuncAction uiMenuFuncAction = new UIMenuFuncAction();
		String conditions = " 1=1 and UseFlag='1' and ModelName='claim' order by funcid";
		Collection collection = uiMenuFuncAction.findByConditions(conditions);
		PrpLmenuDto prpLmenuDto = new PrpLmenuDto();
		prpLmenuDto.setMenuFuncList(collection);
		
		//modify by mengdongdong 2006-03-04 从数据集中，分别解析出三级的菜单
		Collection  menuLevelList1 = new ArrayList();  //一级菜单
		Collection  menuLevelList2 = new ArrayList();  //二级菜单
		Collection  menuLevelList3 = new ArrayList();  //三级菜单
		
		for (Iterator iter = collection.iterator(); iter.hasNext();) {
			PrpLmenuDto prpLmenu = (PrpLmenuDto)iter.next();
			if(prpLmenu.getFuncLevel().trim().equals("1")){//一级菜单
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

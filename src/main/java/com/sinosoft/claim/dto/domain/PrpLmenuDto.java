package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 这是PrpLmenu-菜单表(新增)的数据传输对象类<br>
 * 创建于 2005-05-08 15:15:50.703<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLmenuDto extends PrpLmenuDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLmenuDto对象
     */
    public PrpLmenuDto(){
    }
    Collection menuFuncList;
    
    
    //将菜单分为三级存放 modify by qinyongli 2006-02-27
    Collection  menuLevel1 = new ArrayList();  //一级菜单
    Collection  menuLevel2 = new ArrayList();  //二级菜单
    Collection  menuLevel3 = new ArrayList();  //三级菜单

    
	public Collection getMenuLevel1() {
		return menuLevel1;
	}
	public void setMenuLevel1(Collection menuLevel1) {
		this.menuLevel1 = menuLevel1;
	}
	public Collection getMenuLevel2() {
		return menuLevel2;
	}
	public void setMenuLevel2(Collection menuLevel2) {
		this.menuLevel2 = menuLevel2;
	}
	public Collection getMenuLevel3() {
		return menuLevel3;
	}
	public void setMenuLevel3(Collection menuLevel3) {
		this.menuLevel3 = menuLevel3;
	}
	/**
	 * @return Returns the menuFuncList.
	 */
	public Collection getMenuFuncList() {
		return menuFuncList;
	} 
	/**
	 * @param menuFuncList The menuFuncList to set.
	 */
	public void setMenuFuncList(Collection menuFuncList) {
		this.menuFuncList = menuFuncList;
	}
}

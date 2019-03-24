package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLmenu-菜单表(新增)的数据访问对象类<br>
 * 创建于 2005-05-08 15:15:52.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLmenu extends DBPrpLmenuBase{
    private static Log logger = LogFactory.getLog(DBPrpLmenu.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLmenu(DBManager dbManager){
        super(dbManager);
    }
}

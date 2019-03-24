package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcertifyDirect-索赔指引(新增)的数据访问对象类<br>
 * 创建于 2005-03-22 17:21:38.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcertifyDirect extends DBPrpLcertifyDirectBase{
    private static Log logger = LogFactory.getLog(DBPrpLcertifyDirect.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcertifyDirect(DBManager dbManager){
        super(dbManager);
    }
}

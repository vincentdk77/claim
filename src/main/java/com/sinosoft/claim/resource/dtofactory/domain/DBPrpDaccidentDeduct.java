package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDaccidentDeduct-事故责任免赔率的数据访问对象类<br>
 * 创建于 2006-06-05 19:44:13.843<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpDaccidentDeduct extends DBPrpDaccidentDeductBase{
    private static Log logger = LogFactory.getLog(DBPrpDaccidentDeduct.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDaccidentDeduct(DBManager dbManager){
        super(dbManager);
    }
}

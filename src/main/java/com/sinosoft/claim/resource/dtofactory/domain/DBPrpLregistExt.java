package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLregistExt-报案信息补充说明的数据访问对象类<br>
 * 创建于 2005-03-11 11:11:43.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLregistExt extends DBPrpLregistExtBase{
    private static Log logger = LogFactory.getLog(DBPrpLregistExt.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLregistExt(DBManager dbManager){
        super(dbManager);
    }
}

package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLverifyLossExt的数据访问对象类<br>
 * 创建于 2006-03-20 17:55:51.328<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLverifyLossExt extends DBPrpLverifyLossExtBase{
    private static Log logger = LogFactory.getLog(DBPrpLverifyLossExt.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLverifyLossExt(DBManager dbManager){
        super(dbManager);
    }
}

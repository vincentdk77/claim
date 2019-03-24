package com.sinosoft.servlet.accisd.resource.dtofactory.domain;

import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPLACCICLAIMINFOSD的数据访问对象类<br>
 * 创建于 2018-07-24 15:18:40.323<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLAcciClaimInfoSD extends DBPrpLAcciClaimInfoSDBase{
    private static Logger logger = Logger.getLogger(DBPrpLAcciClaimInfoSD.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLAcciClaimInfoSD(DBManager dbManager){
        super(dbManager);
    }
}

package com.sinosoft.servlet.accisd.resource.dtofactory.domain;

import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPLACCIBASEINFOSD的数据访问对象类<br>
 * 创建于 2018-07-24 15:18:40.245<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLAcciBaseInfoSD extends DBPrpLAcciBaseInfoSDBase{
    private static Logger logger = Logger.getLogger(DBPrpLAcciBaseInfoSD.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLAcciBaseInfoSD(DBManager dbManager){
        super(dbManager);
    }
}

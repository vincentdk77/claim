package com.sinosoft.claim.resource.dtofactory.domain;

import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpCcoinsDetail的数据访问对象类<br>
 * 创建于 2013-09-06 11:02:16.968<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCcoinsDetailTg extends DBPrpCcoinsDetailTgBase{
    private static Logger logger = Logger.getLogger(DBPrpCcoinsDetailTg.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCcoinsDetailTg(DBManager dbManager){
        super(dbManager);
    }
}

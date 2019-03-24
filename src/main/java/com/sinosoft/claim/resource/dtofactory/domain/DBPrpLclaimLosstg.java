package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimLoss的数据访问对象类<br>
 * 创建于 2004-06-24 14:46:01.860<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLclaimLosstg extends DBPrpLclaimLosstgBase{
    private static Log logger = LogFactory.getLog(DBPrpLclaimLosstg.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimLosstg(DBManager dbManager){
        super(dbManager);
    }
}

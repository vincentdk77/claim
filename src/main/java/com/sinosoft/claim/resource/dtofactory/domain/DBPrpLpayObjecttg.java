package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpayObject-支付对象管理表的数据访问对象类<br>
 * 创建于 2006-08-03 14:43:26.173<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpayObjecttg extends DBPrpLpayObjecttgBase{
    private static Log logger = LogFactory.getLog(DBPrpLpayObjecttg.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpayObjecttg(DBManager dbManager){
        super(dbManager);
    }
}

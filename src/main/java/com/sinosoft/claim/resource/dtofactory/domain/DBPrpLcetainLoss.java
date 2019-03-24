package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcetainLoss的数据访问对象类<br>
 * 创建于 2005-03-18 15:44:09.343<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLcetainLoss extends DBPrpLcetainLossBase{
    private static Log logger = LogFactory.getLog(DBPrpLcetainLoss.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcetainLoss(DBManager dbManager){
        super(dbManager);
    }
}

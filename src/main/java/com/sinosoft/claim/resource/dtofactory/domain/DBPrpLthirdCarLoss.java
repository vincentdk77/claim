package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLthirdCarLoss损失部位的数据访问对象类<br>
 * 创建于 2004-12-06 12:08:36.555<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLthirdCarLoss extends DBPrpLthirdCarLossBase{
    private static Log logger = LogFactory.getLog(DBPrpLthirdCarLoss.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLthirdCarLoss(DBManager dbManager){
        super(dbManager);
    }
}

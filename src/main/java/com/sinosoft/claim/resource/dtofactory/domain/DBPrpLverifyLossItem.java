package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLverifyLossItem定核损处理标的表的数据访问对象类<br>
 * 创建于 2004-11-11 14:31:03.533<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLverifyLossItem extends DBPrpLverifyLossItemBase{
    private static Log logger = LogFactory.getLog(DBPrpLverifyLossItem.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLverifyLossItem(DBManager dbManager){
        super(dbManager);
    }
}

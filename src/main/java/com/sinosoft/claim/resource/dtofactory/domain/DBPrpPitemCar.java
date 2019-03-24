package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppitem_car机动车险标的信息的数据访问对象类<br>
 * 创建于 2004-11-22 15:24:18.000<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPitemCar extends DBPrpPitemCarBase{
    private static Log logger = LogFactory.getLog(DBPrpPitemCar.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPitemCar(DBManager dbManager){
        super(dbManager);
    }
}

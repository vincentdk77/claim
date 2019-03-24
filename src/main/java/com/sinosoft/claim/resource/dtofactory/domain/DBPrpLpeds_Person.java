package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpeds_Person人员伤亡明细信息表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpeds_Person extends DBPrpLpeds_PersonBase{
    private static Log log = LogFactory.getLog(DBPrpLpeds_Person.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpeds_Person(DBManager dbManager){
        super(dbManager);
    }
}

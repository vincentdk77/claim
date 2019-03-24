package com.sinosoft.function.insutil.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdstatitype的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:16:30<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDStatiType extends DBPrpDStatiTypeBase{
    private static Log log = LogFactory.getLog(DBPrpDStatiType.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDStatiType(DBManager dbManager){
        super(dbManager);
    }
}

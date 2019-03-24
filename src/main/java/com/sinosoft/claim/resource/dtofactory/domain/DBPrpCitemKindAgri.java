package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpCitemKindAgri的数据访问对象类<br>
 * 创建于 2007-01-30 20:27:06.515<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpCitemKindAgri extends DBPrpCitemKindAgriBase{
    private static Log logger = LogFactory.getLog(DBPrpCitemKindAgri.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCitemKindAgri(DBManager dbManager){
        super(dbManager);
    }
}

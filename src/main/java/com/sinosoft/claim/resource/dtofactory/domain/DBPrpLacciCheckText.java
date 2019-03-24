package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLacciCheckText的数据访问对象类<br>
 * 创建于 2005-06-14 12:03:15.687<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLacciCheckText extends DBPrpLacciCheckTextBase{
    private static Log logger = LogFactory.getLog(DBPrpLacciCheckText.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLacciCheckText(DBManager dbManager){
        super(dbManager);
    }
}

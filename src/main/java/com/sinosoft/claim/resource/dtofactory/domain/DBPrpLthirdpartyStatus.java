package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLthirdpartyStatus-与第三方企业信息交互信息状态表的数据访问对象类<br>
 * 创建于 2005-03-18 15:44:08.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLthirdpartyStatus extends DBPrpLthirdpartyStatusBase{
    private static Log logger = LogFactory.getLog(DBPrpLthirdpartyStatus.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLthirdpartyStatus(DBManager dbManager){
        super(dbManager);
    }
}

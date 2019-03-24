package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLthirdProp-财产损失部位表的数据访问对象类<br>
 * 创建于 2005-04-12 11:37:49.843<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLthirdProp extends DBPrpLthirdPropBase{
    private static Log logger = LogFactory.getLog(DBPrpLthirdProp.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLthirdProp(DBManager dbManager){
        super(dbManager);
    }
}

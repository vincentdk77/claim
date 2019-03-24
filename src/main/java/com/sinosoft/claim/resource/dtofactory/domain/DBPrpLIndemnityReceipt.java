package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是赔款收据的数据访问对象类<br>
 * 创建于 2006-02-25 11:37:06.984<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLIndemnityReceipt extends DBPrpLIndemnityReceiptBase{
    private static Log logger = LogFactory.getLog(DBPrpLIndemnityReceipt.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLIndemnityReceipt(DBManager dbManager){
        super(dbManager);
    }
}

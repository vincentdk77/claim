package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是UtiCodeTransfer -险种险类代码对照表的数据访问对象类<br>
 * 创建于 2005-05-09 09:01:22.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBUtiCodeTransfer extends DBUtiCodeTransferBase{
    private static Log logger = LogFactory.getLog(DBUtiCodeTransfer.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiCodeTransfer(DBManager dbManager){
        super(dbManager);
    }
}

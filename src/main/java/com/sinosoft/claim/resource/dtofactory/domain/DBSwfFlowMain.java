package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfFlowMain流程主表的数据访问对象类<br>
 * 创建于 2004-08-09 19:54:51.902<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfFlowMain extends DBSwfFlowMainBase{
    private static Log logger = LogFactory.getLog(DBSwfFlowMain.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfFlowMain(DBManager dbManager){
        super(dbManager);
    }
}

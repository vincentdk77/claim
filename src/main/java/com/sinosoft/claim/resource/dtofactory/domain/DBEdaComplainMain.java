package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaComplainMain投诉信息表的数据访问对象类<br>
 * 创建于 2005-08-20 17:41:16.322<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdaComplainMain extends DBEdaComplainMainBase{
    private static Log logger = LogFactory.getLog(DBEdaComplainMain.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBEdaComplainMain(DBManager dbManager){
        super(dbManager);
    }
}

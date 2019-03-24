package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WFPATH工作流路径定义表的数据访问对象类<br>
 * 创建于 2004-08-09 19:54:51.882<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBSwfPath extends DBSwfPathBase{
    private static Log logger = LogFactory.getLog(DBSwfPath.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBSwfPath(DBManager dbManager){
        super(dbManager);
    }
}

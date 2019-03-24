package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaComplainText投诉文字表的数据访问对象类<br>
 * 创建于 2005-08-20 17:41:16.342<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBEdaComplainText extends DBEdaComplainTextBase{
    private static Log logger = LogFactory.getLog(DBEdaComplainText.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBEdaComplainText(DBManager dbManager){
        super(dbManager);
    }
}

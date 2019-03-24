package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplregisttext赔案文字表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLregistText extends DBPrpLregistTextBase{
    private static Log log = LogFactory.getLog(DBPrpLregistText.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLregistText(DBManager dbManager){
        super(dbManager);
    }
}

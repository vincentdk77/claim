package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLRegistRPolicy赔案保单关联表的数据访问对象类<br>
 * 创建于 2006-06-04 15:22:07.456<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLRegistRPolicyTg extends DBPrpLRegistRPolicyTgBase{
    private static Log logger = LogFactory.getLog(DBPrpLRegistRPolicyTg.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLRegistRPolicyTg(DBManager dbManager){
        super(dbManager);
    }
}

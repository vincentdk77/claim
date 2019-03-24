package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplclaimpolicy立案保单清单表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLclaimPolicy extends DBPrpLclaimPolicyBase{
    private static Log log = LogFactory.getLog(DBPrpLclaimPolicy.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimPolicy(DBManager dbManager){
        super(dbManager);
    }
}

package com.sinosoft.claim.resource.dtofactory.domain;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpdBankBranch的数据访问对象类<br>
 * 创建于 2018-01-26 15:40:08.171<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpdBankBranch extends DBPrpdBankBranchBase{
    private static Logger logger = Logger.getLogger(DBPrpdBankBranch.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpdBankBranch(DBManager dbManager){
        super(dbManager);
    }
}

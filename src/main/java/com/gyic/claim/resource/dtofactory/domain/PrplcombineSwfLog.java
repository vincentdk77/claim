package com.gyic.claim.resource.dtofactory.domain;

import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是并案关联表与节点状态表联合的数据访问对象类<br>
 * 创建于 2011-08-03 08:18:47.843<br>
 * JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class PrplcombineSwfLog extends PrpCombineSwfLogBase{
    private static Logger logger = Logger.getLogger(PrplcombineSwfLog.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public PrplcombineSwfLog(DBManager dbManager){
        super(dbManager);
    }
}

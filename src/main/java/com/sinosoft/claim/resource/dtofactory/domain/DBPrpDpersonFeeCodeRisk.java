package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDpersonFeeCodeRisk-人伤费用险种对照表的数据访问对象类<br>
 * 创建于 2006-06-20 15:51:34.484<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpDpersonFeeCodeRisk extends DBPrpDpersonFeeCodeRiskBase{
    private static Log logger = LogFactory.getLog(DBPrpDpersonFeeCodeRisk.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDpersonFeeCodeRisk(DBManager dbManager){
        super(dbManager);
    }
}

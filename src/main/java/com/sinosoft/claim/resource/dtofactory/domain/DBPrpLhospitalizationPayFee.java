package com.sinosoft.claim.resource.dtofactory.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLhospitalizationPayFee的数据访问对象类<br>
 * 创建于 2007-05-23 14:10:26.242<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLhospitalizationPayFee extends DBPrpLhospitalizationPayFeeBase{
    private static Log logger = LogFactory.getLog(DBPrpLhospitalizationPayFee.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLhospitalizationPayFee(DBManager dbManager){
        super(dbManager);
    }
}

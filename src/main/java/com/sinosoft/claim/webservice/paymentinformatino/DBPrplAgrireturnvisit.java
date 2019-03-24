package com.sinosoft.claim.webservice.paymentinformatino;

import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisit;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplreturnvisitBase;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PRPLAGRIRETURNVISIT的数据访问对象类
 * @author Administrator
 *
 */
public class DBPrplAgrireturnvisit extends DBPrplAgrireturnvisitBase{
    private static Logger logger = Logger.getLogger(DBPrplAgrireturnvisit.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplAgrireturnvisit(DBManager dbManager){
        super(dbManager);
    }
}

package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterGetPaymentShow;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLinterGetPaymentShowAction{
    private static Logger logger = Logger.getLogger(BLPrpLinterGetPaymentShowAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterGetPaymentShowAction(){
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterPaymentInfoDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBPrpLinterGetPaymentShow dbPrpLinterGetPaymentShow = new DBPrpLinterGetPaymentShow(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterGetPaymentShow.findByConditions(conditions);
        return collection;
    }
}

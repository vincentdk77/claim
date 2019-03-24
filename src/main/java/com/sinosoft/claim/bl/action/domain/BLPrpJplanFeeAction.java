package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJplanFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpayRefRec;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJplanFee;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是应收应付费信息表的业务对象扩展类<br>
 */
public class BLPrpJplanFeeAction extends BLPrpJplanFeeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpJplanFeeAction.class);

    /**
     * 构造函数
     */
    public BLPrpJplanFeeAction(){
        super();
    }

	public Collection findJoinJpayRefRecByConditions(DBManager dbManager,
			String conditions) throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpJplanFee.findJoinJpayRefRecByConditions(conditions);
        return collection;
    }

   

}

package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJpayRefRec;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpJpayRefRecActionBase {
	private static Log log = LogFactory.getLog(BLPrpJpayRefRecAction.class
			.getName());
	private int rowCount; // findByConditions查询到的记录数

	public Collection findByConditions(DBManager dbManager, String conditions) throws Exception {
        DBPrpJpayRefRec dbPrpJpayRefRec = new DBPrpJpayRefRec(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpJpayRefRec.findByConditions(conditions);
        return collection;
    }
	
	/**
	 * 新增实收实付时间查询方法
	 * @throws Exception 
	 */
	public DateTime getRefDate(DBManager dbManager, String conditions) throws Exception{
		DBPrpJpayRefRec dbPrpJpayRefRec = new DBPrpJpayRefRec(dbManager);
		DateTime refDate = null;
		refDate = dbPrpJpayRefRec.findRefDate(conditions);
		return refDate;
	}
}

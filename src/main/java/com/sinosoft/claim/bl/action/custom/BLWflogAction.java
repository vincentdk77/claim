package com.sinosoft.claim.bl.action.custom;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.resource.dtofactory.domain.DBWfLog;

public class BLWflogAction {

	 /**
     * 按自定义SQL查询多条数据
     *
     * @param dbManager
     *            DB管理器
     * @param conditions
     *            自定义SQL
     * @param blnAll
     *            自定义标志
     * @return Collection 包含wfLogDto的集合
     * @throws Exception
     * @author luyang
     */
    public Collection findByConditions(DBManager dbManager, String conditions,
            boolean blnAll) throws Exception {
        DBWfLog dbWfLog = new DBWfLog(dbManager);
        ArrayList logList = new ArrayList();
        Collection collection = new ArrayList();
        if (conditions.trim().length() == 0) {
            conditions = "1=1";
        }
        /*************
         *begin delete by xuning dubang 20051212
         *把按流入时间倒序排列放到统一的入口（DBWflog.java） 
         */
        //conditions += " ORDER BY flowintime desc ";
        /**
         * end delete 
         */
        logList = (ArrayList) dbWfLog.findByStatement(conditions, blnAll);
        return logList;
    }
}

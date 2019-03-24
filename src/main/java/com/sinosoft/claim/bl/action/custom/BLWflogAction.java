package com.sinosoft.claim.bl.action.custom;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.resource.dtofactory.domain.DBWfLog;

public class BLWflogAction {

	 /**
     * ���Զ���SQL��ѯ��������
     *
     * @param dbManager
     *            DB������
     * @param conditions
     *            �Զ���SQL
     * @param blnAll
     *            �Զ����־
     * @return Collection ����wfLogDto�ļ���
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
         *�Ѱ�����ʱ�䵹�����зŵ�ͳһ����ڣ�DBWflog.java�� 
         */
        //conditions += " ORDER BY flowintime desc ";
        /**
         * end delete 
         */
        logList = (ArrayList) dbWfLog.findByStatement(conditions, blnAll);
        return logList;
    }
}

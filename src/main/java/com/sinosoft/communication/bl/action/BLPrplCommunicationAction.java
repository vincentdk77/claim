package com.sinosoft.communication.bl.action;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.communication.resource.dtofactory.custom.DBPrplCommunication;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;


public class BLPrplCommunicationAction extends BLPrplCommunicationActionBase {
	
	public BLPrplCommunicationAction(){
		
	}
	/**
     * ��ͨ��ѯ����
     * @param conditions
     * @param userCode
     * @param editType
     * @param flags
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public PageRecord getResultList(DBManager dbManager,String conditions,String userCode,String editType,String flags,int pageNo,int rowsPerPage) throws Exception{
    	DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        Collection collection = new ArrayList();

        //if(conditions.trim().length()==0){
         //   conditions = "1=1";
       // }

        int count = dbPrplCommunication.getListCount(conditions, userCode, editType, flags, pageNo, rowsPerPage);
        collection = dbPrplCommunication.getResultList(conditions, userCode, editType, flags, pageNo, rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    /**
     * ��ͨ��ѯ����2(���������Ľӿ�ʹ�ã����������Ҫ������淽��2���ֶ�usercode,nodecode)
     * @param conditions
     * @param userCode
     * @param editType
     * @param flags
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public PageRecord getResultList2(DBManager dbManager,String conditions,String userCode,String editType,String flags,int pageNo,int rowsPerPage) throws Exception{
    	DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
        Collection collection = new ArrayList();

        //if(conditions.trim().length()==0){
         //   conditions = "1=1";
       // }

        int count = dbPrplCommunication.getListCount(conditions, userCode, editType, flags, pageNo, rowsPerPage);
        collection = dbPrplCommunication.getResultList2(conditions, userCode, editType, flags, pageNo, rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    /**
     * ��ȡ��ǰ��Ա�账��ĵĹ�ͨ����
     * @param usercode
     * @return
     * @throws Exception
     */
    public int getUserCommunicatNum(DBManager dbManager,String usercode) throws Exception{
    	 DBPrplCommunication dbPrplCommunication = new DBPrplCommunication(dbManager);
         int count = dbPrplCommunication.getUserCommunicatNum(usercode);
         return count;
    }
}

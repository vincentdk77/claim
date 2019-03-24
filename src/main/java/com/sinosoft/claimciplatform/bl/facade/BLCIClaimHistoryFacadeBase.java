package com.sinosoft.claimciplatform.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimHistoryAction;
import com.sinosoft.claimciplatform.dto.custom.HistoryClaim;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����������Ϣ�ϴ�ƽ̨�����⸶��Ϣ���ҵ���߼�����Facade����<br>
 * ������ 2010-03-30
 */
public class BLCIClaimHistoryFacadeBase {
	private static Log logger = LogFactory.getLog(BLCIClaimHistoryFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCIClaimHistoryFacadeBase(){
    }
    
    /**
     * ����һ������
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void insert(HistoryClaim historyClaim)throws Exception{
    	DBManager dbManager = new DBManager();
    	BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
    	try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blCIClaimHistoryAction.insert(dbManager,historyClaim);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * ������ɾ��һ������
     * @param claimCode �������
     * @param serialNo ˳���
     * @throws Exception
     */
    public void delete(String claimCode,int serialNo)
    throws Exception{
    	DBManager dbManager = new DBManager();
    	BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
    	try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blCIClaimHistoryAction.delete(dbManager,claimCode, serialNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * ������ɾ������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(String conditions)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blCIClaimHistoryAction.deleteByConditions(dbManager,conditions);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * ����������һ������(���������޷����)
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void update(HistoryClaim historyClaim)throws Exception{
    	DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
    	try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blCIClaimHistoryAction.update(dbManager,historyClaim);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * ����������һ������
     * @param claimCode �������
     * @param serialNo ���
     * @return HistoryClaim historyClaim
     * @throws Exception
     */
    public HistoryClaim findByPrimaryKey(String claimCode,int serialNo)
    throws Exception{
    	DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
    	
    	HistoryClaim historyClaim = null;
    	
    	try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            historyClaim = blCIClaimHistoryAction.findByPrimaryKey(dbManager,claimCode, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return historyClaim;
    }
    
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions, int pageNo,
			int rowsPerPage) throws Exception {
		PageRecord pageRecord = new PageRecord(0, pageNo, 1, rowsPerPage,
				new ArrayList());

		if (conditions.trim().length() == 0) {
			conditions = "1=1";
		}

		DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
		try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blCIClaimHistoryAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        
        return pageRecord;
	}
    
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection ����historyClaim�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
        
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blCIClaimHistoryAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCIClaimHistoryAction blCIClaimHistoryAction = new BLCIClaimHistoryAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blCIClaimHistoryAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
}

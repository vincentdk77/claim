package com.sinosoft.claimciplatform.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.dto.custom.HistoryClaim;
import com.sinosoft.claimciplatform.dto.domain.CIClaimThirdCarDto;
import com.sinosoft.claimciplatform.resource.dtofactory.domain.DBCIClaimHistory;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����������Ϣ�ϴ�ƽ̨���߳��⸶��Ϣ���ҵ���߼�������<br>
 * ������ 2010-03-30
 */
public class BLCIClaimHistoryActionBase {
	private static Log logger = LogFactory.getLog(BLCIClaimHistoryActionBase.class);

    /**
     * ���캯��
     */
    public BLCIClaimHistoryActionBase(){
    }
    
    /**
     * ����һ������
     * @param dbManager DB������
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void insert(DBManager dbManager,HistoryClaim historyClaim)throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	dbCIClaimHistory.insert(historyClaim);
    }
    
    /**
     * ����һ������
     * @param dbManager DB������
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection collection)throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	dbCIClaimHistory.insertAll(collection);
    }
    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimCode �������
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimCode,int serialNo)
            throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	dbCIClaimHistory.delete(claimCode, serialNo);
    }
    
    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	dbCIClaimHistory.deleteByConditions(conditions);
    }
    
    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param HistoryClaim historyClaim
     * @throws Exception
     */
    public void update(DBManager dbManager,HistoryClaim historyClaim)
    		throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	dbCIClaimHistory.update(historyClaim);
    }
    
    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimCode �������
     * @param serialNo ˳���
     * @return HistoryClaim historyClaim
     * @throws Exception
     */
    public HistoryClaim findByPrimaryKey(DBManager dbManager,String claimCode,int serialNo)
    throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	HistoryClaim historyClaim = null;
    	
    	historyClaim = dbCIClaimHistory.findByPrimaryKey(claimCode, serialNo);
    	
    	return historyClaim;
    }
    
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
    	throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	
    	Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        int count = dbCIClaimHistory.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbCIClaimHistory.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }
    
    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����cIClaimUploadLogDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
    	throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbCIClaimHistory.findByConditions(conditions);
        return collection;
    }
    
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
    throws Exception{
    	DBCIClaimHistory dbCIClaimHistory = new DBCIClaimHistory(dbManager);
    	if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbCIClaimHistory.getCount(conditions);
        return count;
    }
    
    
}

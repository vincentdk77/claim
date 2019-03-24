package com.sinosoft.claimciplatform.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claimciplatform.bl.action.domain.BLCIClaimThirdCarAction;
import com.sinosoft.claimciplatform.dto.domain.CIClaimThirdCarDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����������Ϣ�ϴ�ƽ̨���߳��⸶��Ϣ���ҵ���߼�����Facade����<br>
 * ������ 2010-03-30
 */
public class BLCIClaimThirdCarFacadeBase {
	private static Log logger = LogFactory.getLog(BLCIClaimThirdCarFacadeBase.class);

    /**
     * ���캯��
     */
    public BLCIClaimThirdCarFacadeBase(){
    }

    /**
     * ����һ������
     * @param CIClaimThirdCarDto ciClaimThirdCarDto
     * @throws Exception
     */
    public void insert(CIClaimThirdCarDto ciClaimThirdCarDto)throws Exception{
    	 DBManager dbManager = new DBManager();
    	 BLCIClaimThirdCarAction blCIClaimThirdCarAction = new BLCIClaimThirdCarAction();
    	 try{
             dbManager.open(AppConfig.get("sysconst.DBJNDI"));
             dbManager.beginTransaction();
             //�����¼
             blCIClaimThirdCarAction.insert(dbManager,ciClaimThirdCarDto);
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
    	BLCIClaimThirdCarAction blCIClaimThirdCarAction = new BLCIClaimThirdCarAction();
    	try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blCIClaimThirdCarAction.delete(dbManager,claimCode, serialNo);
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
        BLCIClaimThirdCarAction blCIClaimThirdCarAction = new BLCIClaimThirdCarAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blCIClaimThirdCarAction.deleteByConditions(dbManager,conditions);
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
     * @param CIClaimThirdCarDto ciClaimThirdCarDto
     * @throws Exception
     */
    public void update(CIClaimThirdCarDto ciClaimThirdCarDto)throws Exception{
    	DBManager dbManager = new DBManager();
    	BLCIClaimThirdCarAction blCIClaimThirdCarAction = new BLCIClaimThirdCarAction();
    	try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blCIClaimThirdCarAction.update(dbManager,ciClaimThirdCarDto);
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
     * @return CIClaimThirdCarDto ciClaimThirdCarDto
     * @throws Exception
     */
    public CIClaimThirdCarDto findByPrimaryKey(String claimCode,int serialNo)
    throws Exception{
    	DBManager dbManager = new DBManager();
    	BLCIClaimThirdCarAction blCIClaimThirdCarAction = new BLCIClaimThirdCarAction();
    	
    	CIClaimThirdCarDto ciClaimThirdCarDto = null;
    	
    	try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            ciClaimThirdCarDto = blCIClaimThirdCarAction.findByPrimaryKey(dbManager,claimCode, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return ciClaimThirdCarDto;
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
		BLCIClaimThirdCarAction blCIClaimThirdCarAction = new BLCIClaimThirdCarAction();
		try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blCIClaimThirdCarAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����ciClaimThirdCarDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLCIClaimThirdCarAction blCIClaimThirdCarAction = new BLCIClaimThirdCarAction();
        
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blCIClaimThirdCarAction.findByConditions(dbManager,conditions);
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
        BLCIClaimThirdCarAction blCIClaimThirdCarAction = new BLCIClaimThirdCarAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blCIClaimThirdCarAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    
    
}

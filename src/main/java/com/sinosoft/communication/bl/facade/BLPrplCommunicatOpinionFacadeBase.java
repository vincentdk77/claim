package com.sinosoft.communication.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.bl.action.BLPrplCommunicatOpinionAction;
import com.sinosoft.communication.dto.custom.PrplCommunicatOpinionDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrplCommunicatOpinion��ͨ�ӱ���ͨ�������ҵ�����Facade��<br>
 * ������ 2013-02-22
 * 
 */
public class BLPrplCommunicatOpinionFacadeBase {
	private static Log logger = LogFactory.getLog(BLPrplCommunicatOpinionFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplCommunicatOpinionFacadeBase(){
    }
    
    /**
     * ����һ������
     * @param prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public void insert(PrplCommunicatOpinionDto prplCommunicatOpinionDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
            //dbManager.open("claimTempDataSource");
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplCommunicatOpinionAction.insert(dbManager,prplCommunicatOpinionDto);
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
     * @param endorseNo ��������
     * @throws Exception
     */
    public void delete(String comunicationNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplCommunicatOpinionAction.delete(dbManager,comunicationNo);
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
     * @param endorseNo ��������
     * @throws Exception
     */
    public void delete(String comunicationNo,String personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplCommunicatOpinionAction.delete(dbManager,comunicationNo,personNo);
            
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
     * @param endorseNo ��������
     * @throws Exception
     */
    public void delete(String comunicationNo,String personNo,String opinionNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplCommunicatOpinionAction.delete(dbManager,comunicationNo,opinionNo);
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
     * @param prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public void update(PrplCommunicatOpinionDto prplCommunicatOpinionDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplCommunicatOpinionAction.update(dbManager,prplCommunicatOpinionDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����ͨ�������һ������
     * @param communicaitonNo ��ͨ����
     * @return Collection Collection
     * @throws Exception
     */
    public Collection findByCommunicationNo(String communicationNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        //����DTO
        PrplCommunicatOpinionDto prplCommunicatOpinionDto = null;
        Collection collection = new ArrayList();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
        	collection = blPrplCommunicatOpinionAction.findByCommunicationNo(dbManager, communicationNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    /**
     * ����������һ������
     * @param communicationNo ��ͨ����
     * @param personNo ��ͨ�˺���
     * @param personNo ��ͨ�������
     * @return prplCommunicatOpinionDto prplCommunicatOpinionDto
     * @throws Exception
     */
    public PrplCommunicatOpinionDto findByPrimaryKey(String communicationNo,String opinionNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        //����DTO
        PrplCommunicatOpinionDto prplCommunicatOpinionDto = null;
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplCommunicatOpinionDto = blPrplCommunicatOpinionAction.findByPrimaryKey(dbManager, communicationNo, opinionNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplCommunicatOpinionDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplCommunicatOpinionAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplCommunicatOpinionDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplCommunicatOpinionAction.findByConditions(dbManager,conditions);
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
        BLPrplCommunicatOpinionAction blPrplCommunicatOpinionAction = new BLPrplCommunicatOpinionAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplCommunicatOpinionAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

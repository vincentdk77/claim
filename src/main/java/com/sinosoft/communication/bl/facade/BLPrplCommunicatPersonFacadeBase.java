package com.sinosoft.communication.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.communication.bl.action.BLPrplCommunicatPersonAction;
import com.sinosoft.communication.dto.custom.PrplCommunicatPersonDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrplCommunicatPerson��ͨ�ӱ���ͨ��Ա����ҵ�����Facade��<br>
 * ������ 2013-02-21
 * 
 */
public class BLPrplCommunicatPersonFacadeBase {
	private static Log logger = LogFactory.getLog(BLPrplCommunicatPersonFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplCommunicatPersonFacadeBase(){
    }
    /**
     * ����һ������
     * @param prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public void insert(PrplCommunicatPersonDto prplCommunicatPersonDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplCommunicatPersonAction.insert(dbManager,prplCommunicatPersonDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }

    /**
     * ����ͨ����ɾ��һ������
     * @param comunicationNo ��ͨ����
     * @throws Exception
     */
    public void delete(String comunicationNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplCommunicatPersonAction.delete(dbManager,comunicationNo);
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
     * @param comunicationNo ��ͨ����
     * @param personNo ��ͨ�˺���
     * @throws Exception
     */
    public void delete(String comunicationNo,String personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplCommunicatPersonAction.delete(dbManager,comunicationNo,personNo);
            
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
     * @param prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public void update(PrplCommunicatPersonDto prplCommunicatPersonDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplCommunicatPersonAction.update(dbManager,prplCommunicatPersonDto);
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
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        //����DTO
        PrplCommunicatPersonDto prplCommunicatPersonDto = null;
        Collection collection = new ArrayList();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
        	collection = blPrplCommunicatPersonAction.findByCommunicationNo(dbManager, communicationNo);
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
     * @return prplCommunicatPersonDto prplCommunicatPersonDto
     * @throws Exception
     */
    public PrplCommunicatPersonDto findByPrimaryKey(String communicationNo,String personNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        //����DTO
        PrplCommunicatPersonDto prplCommunicatPersonDto = null;
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplCommunicatPersonDto = blPrplCommunicatPersonAction.findByPersonNo(dbManager, communicationNo, personNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplCommunicatPersonDto;
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
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplCommunicatPersonAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplCommunicatPersonDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplCommunicatPersonAction.findByConditions(dbManager,conditions);
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
        BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplCommunicatPersonAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * ����ͨ������ɾ��һ����ͨ������
     * @param communicationNo ��ͨ����
     * @param personNo ��ͨ�˺���
     * @throws Exception
     */
	public void removePersonByKey(String communicationNo,String personNo) throws Exception{
		DBManager dbManager = new DBManager();
		BLPrplCommunicatPersonAction blPrplCommunicatPersonAction = new BLPrplCommunicatPersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            blPrplCommunicatPersonAction.removePersonByKey(dbManager, communicationNo, personNo);
            dbManager.commitTransaction();
        }catch(Exception exception){
        	dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
	}
}

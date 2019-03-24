package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplinterrelationAction;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * �����м����������ŵ�ҵ���߼�����Facade����<br>
 */
public class BLPrplinterrelationFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplinterrelationFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplinterrelationFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public void insert(PrplinterrelationDto prplinterrelationDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplinterrelationAction.insert(dbManager,prplinterrelationDto);
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
     * @param id ����id
     * @param outId �ͻ�������
     * @throws Exception
     */
    public void delete(String id,String outId)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplinterrelationAction.delete(dbManager,id, outId);
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
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplinterrelationAction.deleteByConditions(dbManager,conditions);
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
     * @param prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public void update(PrplinterrelationDto prplinterrelationDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplinterrelationAction.update(dbManager,prplinterrelationDto);
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
     * @param id ����id
     * @param outId �ͻ�������
     * @return prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public PrplinterrelationDto findByPrimaryKey(String id,String outId)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        //����DTO
        PrplinterrelationDto prplinterrelationDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplinterrelationDto = blPrplinterrelationAction.findByPrimaryKey(dbManager,id, outId);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplinterrelationDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage)
        throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplinterrelationAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplinterrelationDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplinterrelationAction.findByConditions(dbManager,conditions);
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
        BLPrplinterrelationAction blPrplinterrelationAction = new BLPrplinterrelationAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplinterrelationAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

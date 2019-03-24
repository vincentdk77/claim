package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLpayExttgAction;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֧������������ҵ���߼�����tgFacade����<br>
 */
public class BLPrpLpayExttgFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLpayExttgFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLpayExttgFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLpayExttgDto prpLpayExttgDto
     * @throws Exception
     */
    public void insert(PrpLpayExtDto prpLpayExttgDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayExttgAction blPrpLpayExtAction = new BLPrpLpayExttgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLpayExtAction.insert(dbManager,prpLpayExttgDto);
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
     * @param paymentNo �ո����
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String paymentNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayExttgAction blPrpLpayExtAction = new BLPrpLpayExttgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLpayExtAction.delete(dbManager,paymentNo, serialNo);
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
        BLPrpLpayExttgAction blPrpLpayExtAction = new BLPrpLpayExttgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLpayExtAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLpayExttgDto prpLpayExttgDto
     * @throws Exception
     */
    public void update(PrpLpayExtDto prpLpayExttgDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayExttgAction blPrpLpayExtAction = new BLPrpLpayExttgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLpayExtAction.update(dbManager,prpLpayExttgDto);
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
     * @param paymentNo �ո����
     * @param serialNo ���
     * @return prpLpayExttgDto prpLpayExttgDto
     * @throws Exception
     */
    public PrpLpayExtDto findByPrimaryKey(String paymentNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLpayExttgAction blPrpLpayExtAction = new BLPrpLpayExttgAction();
        //����DTO
        PrpLpayExtDto prpLpayExttgDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLpayExttgDto = blPrpLpayExtAction.findByPrimaryKey(dbManager,paymentNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLpayExttgDto;
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
        BLPrpLpayExttgAction blPrpLpayExtAction = new BLPrpLpayExttgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLpayExtAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLpayExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLpayExttgAction blPrpLpayExtAction = new BLPrpLpayExttgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLpayExtAction.findByConditions(dbManager,conditions);
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
        BLPrpLpayExttgAction blPrpLpayExtAction = new BLPrpLpayExttgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLpayExtAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplaccidangersdAction;
import com.sinosoft.claim.dto.domain.PrplaccidangersdDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCIDANGERSD��ҵ���߼�����Facade����<br>
 */
public class BLPrplaccidangersdFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplaccidangersdFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplaccidangersdFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public void insert(PrplaccidangersdDto prplaccidangersdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplaccidangersdAction.insert(dbManager,prplaccidangersdDto);
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
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String insuredname,int serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplaccidangersdAction.delete(dbManager,insuredname, serialno);
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
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplaccidangersdAction.deleteByConditions(dbManager,conditions);
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
     * @param prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public void update(PrplaccidangersdDto prplaccidangersdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplaccidangersdAction.update(dbManager,prplaccidangersdDto);
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
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @return prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public PrplaccidangersdDto findByPrimaryKey(String insuredname,int serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        //����DTO
        PrplaccidangersdDto prplaccidangersdDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplaccidangersdDto = blPrplaccidangersdAction.findByPrimaryKey(dbManager,insuredname, serialno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplaccidangersdDto;
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
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplaccidangersdAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplaccidangersdDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplaccidangersdAction.findByConditions(dbManager,conditions);
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
        BLPrplaccidangersdAction blPrplaccidangersdAction = new BLPrplaccidangersdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplaccidangersdAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

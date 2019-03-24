package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrplaccidangerclaimsdAction;
import com.sinosoft.claim.dto.domain.PrplaccidangerclaimsdDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCIDANGERCLAIMSD��ҵ���߼�����Facade����<br>
 */
public class BLPrplaccidangerclaimsdFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrplaccidangerclaimsdFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrplaccidangerclaimsdFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @throws Exception
     */
    public void insert(PrplaccidangerclaimsdDto prplaccidangerclaimsdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangerclaimsdAction blPrplaccidangerclaimsdAction = new BLPrplaccidangerclaimsdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplaccidangerclaimsdAction.insert(dbManager,prplaccidangerclaimsdDto);
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
     * @param companycode COMPANYCODE
     * @param lossdate LOSSDATE
     * @throws Exception
     */
    public void delete(String insuredname,int serialno,String companycode,String lossdate)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangerclaimsdAction blPrplaccidangerclaimsdAction = new BLPrplaccidangerclaimsdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplaccidangerclaimsdAction.delete(dbManager,insuredname, serialno, companycode, lossdate);
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
        BLPrplaccidangerclaimsdAction blPrplaccidangerclaimsdAction = new BLPrplaccidangerclaimsdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplaccidangerclaimsdAction.deleteByConditions(dbManager,conditions);
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
     * @param prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @throws Exception
     */
    public void update(PrplaccidangerclaimsdDto prplaccidangerclaimsdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangerclaimsdAction blPrplaccidangerclaimsdAction = new BLPrplaccidangerclaimsdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplaccidangerclaimsdAction.update(dbManager,prplaccidangerclaimsdDto);
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
     * @param companycode COMPANYCODE
     * @param lossdate LOSSDATE
     * @return prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @throws Exception
     */
    public PrplaccidangerclaimsdDto findByPrimaryKey(String insuredname,int serialno,String companycode,String lossdate)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrplaccidangerclaimsdAction blPrplaccidangerclaimsdAction = new BLPrplaccidangerclaimsdAction();
        //����DTO
        PrplaccidangerclaimsdDto prplaccidangerclaimsdDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplaccidangerclaimsdDto = blPrplaccidangerclaimsdAction.findByPrimaryKey(dbManager,insuredname, serialno, companycode, lossdate);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplaccidangerclaimsdDto;
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
        BLPrplaccidangerclaimsdAction blPrplaccidangerclaimsdAction = new BLPrplaccidangerclaimsdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplaccidangerclaimsdAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplaccidangerclaimsdDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrplaccidangerclaimsdAction blPrplaccidangerclaimsdAction = new BLPrplaccidangerclaimsdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplaccidangerclaimsdAction.findByConditions(dbManager,conditions);
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
        BLPrplaccidangerclaimsdAction blPrplaccidangerclaimsdAction = new BLPrplaccidangerclaimsdAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplaccidangerclaimsdAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

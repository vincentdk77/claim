package com.sinosoft.servlet.accisd.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.servlet.accisd.bl.action.domain.BLPrpLAcciClaimInfoSDAction;
import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;
import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCICLAIMINFOSD��ҵ���߼�����Facade����<br>
 */
public class BLPrpLAcciClaimInfoSDFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLAcciClaimInfoSDFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLAcciClaimInfoSDFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @throws Exception
     */
    public void insert(PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciClaimInfoSDAction blPrplacciclaiminfosdAction = new BLPrpLAcciClaimInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplacciclaiminfosdAction.insert(dbManager,prplacciclaiminfosdDto);
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
     * @param name NAME
     * @throws Exception
     */
    public void delete(String name,String credentialType,String credentialNo,String claimNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciClaimInfoSDAction blPrplacciclaiminfosdAction = new BLPrpLAcciClaimInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplacciclaiminfosdAction.delete(dbManager,name,credentialType,credentialNo,claimNo);
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
        BLPrpLAcciClaimInfoSDAction blPrplacciclaiminfosdAction = new BLPrpLAcciClaimInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplacciclaiminfosdAction.deleteByConditions(dbManager,conditions);
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
     * @param prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @throws Exception
     */
    public void update(PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciClaimInfoSDAction blPrplacciclaiminfosdAction = new BLPrpLAcciClaimInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplacciclaiminfosdAction.update(dbManager,prplacciclaiminfosdDto);
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
     * @param name NAME
     * @return prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @throws Exception
     */
    public PrpLAcciClaimInfoSDDto findByPrimaryKey(String name,String credentialType,String credentialNo,String claimNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciClaimInfoSDAction blPrplacciclaiminfosdAction = new BLPrpLAcciClaimInfoSDAction();
        //����DTO
        PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplacciclaiminfosdDto = blPrplacciclaiminfosdAction.findByPrimaryKey(dbManager,name,credentialType,credentialNo,claimNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplacciclaiminfosdDto;
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
        BLPrpLAcciClaimInfoSDAction blPrplacciclaiminfosdAction = new BLPrpLAcciClaimInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplacciclaiminfosdAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplacciclaiminfosdDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLAcciClaimInfoSDAction blPrplacciclaiminfosdAction = new BLPrpLAcciClaimInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplacciclaiminfosdAction.findByConditions(dbManager,conditions);
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
        BLPrpLAcciClaimInfoSDAction blPrplacciclaiminfosdAction = new BLPrpLAcciClaimInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplacciclaiminfosdAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

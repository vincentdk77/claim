package com.sinosoft.servlet.accisd.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.servlet.accisd.bl.action.domain.BLPrpLAcciBaseInfoSDAction;
import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciBaseInfoSDDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCIBASEINFOSD��ҵ���߼�����Facade����<br>
 */
public class BLPrpLAcciBaseInfoSDFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLAcciBaseInfoSDFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLAcciBaseInfoSDFacadeBase(){
    }

    /**
     * ����һ������
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public void insert(PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrplaccibaseinfosdAction.insert(dbManager,prplaccibaseinfosdDto);
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
    public void delete(String name,String credentialType,String credentialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrplaccibaseinfosdAction.delete(dbManager,name,credentialType,credentialNo);
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
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrplaccibaseinfosdAction.deleteByConditions(dbManager,conditions);
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
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public void update(PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrplaccibaseinfosdAction.update(dbManager,prplaccibaseinfosdDto);
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
     * @return prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public PrpLAcciBaseInfoSDDto findByPrimaryKey(String name,String credentialType,String credentialNo )
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        //����DTO
        PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prplaccibaseinfosdDto = blPrplaccibaseinfosdAction.findByPrimaryKey(dbManager,name,credentialType,credentialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prplaccibaseinfosdDto;
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
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrplaccibaseinfosdAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prplaccibaseinfosdDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrplaccibaseinfosdAction.findByConditions(dbManager,conditions);
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
        BLPrpLAcciBaseInfoSDAction blPrplaccibaseinfosdAction = new BLPrpLAcciBaseInfoSDAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrplaccibaseinfosdAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

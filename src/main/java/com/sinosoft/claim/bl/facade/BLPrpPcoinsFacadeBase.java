package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpPcoinsAction;
import com.sinosoft.claim.dto.domain.PrpPcoinsDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpPcoins��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpPcoinsFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpPcoinsFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpPcoinsFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpPcoinsDto prpPcoinsDto
     * @throws Exception
     */
    public void insert(PrpPcoinsDto prpPcoinsDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsAction blPrpPcoinsAction = new BLPrpPcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpPcoinsAction.insert(dbManager,prpPcoinsDto);
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
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(String endorseNo,long serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsAction blPrpPcoinsAction = new BLPrpPcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpPcoinsAction.delete(dbManager,endorseNo, serialNo);
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
        BLPrpPcoinsAction blPrpPcoinsAction = new BLPrpPcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpPcoinsAction.deleteByConditions(dbManager,conditions);
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
     * @param prpPcoinsDto prpPcoinsDto
     * @throws Exception
     */
    public void update(PrpPcoinsDto prpPcoinsDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsAction blPrpPcoinsAction = new BLPrpPcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpPcoinsAction.update(dbManager,prpPcoinsDto);
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
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @return prpPcoinsDto prpPcoinsDto
     * @throws Exception
     */
    public PrpPcoinsDto findByPrimaryKey(String endorseNo,long serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpPcoinsAction blPrpPcoinsAction = new BLPrpPcoinsAction();
        //����DTO
        PrpPcoinsDto prpPcoinsDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpPcoinsDto = blPrpPcoinsAction.findByPrimaryKey(dbManager,endorseNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpPcoinsDto;
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
        BLPrpPcoinsAction blPrpPcoinsAction = new BLPrpPcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpPcoinsAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpPcoinsDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpPcoinsAction blPrpPcoinsAction = new BLPrpPcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpPcoinsAction.findByConditions(dbManager,conditions);
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
        BLPrpPcoinsAction blPrpPcoinsAction = new BLPrpPcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpPcoinsAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

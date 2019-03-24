package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpCcoinsAction;
import com.sinosoft.claim.dto.domain.PrpCcoinsDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCcoins��ҵ���߼�����Facade����<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCcoinsFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpCcoinsFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpCcoinsFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public void insert(PrpCcoinsDto prpCcoinsDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpCcoinsAction.insert(dbManager,prpCcoinsDto);
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
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpCcoinsAction.delete(dbManager,policyNo, serialNo);
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
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpCcoinsAction.deleteByConditions(dbManager,conditions);
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
     * @param prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public void update(PrpCcoinsDto prpCcoinsDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpCcoinsAction.update(dbManager,prpCcoinsDto);
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
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @return prpCcoinsDto prpCcoinsDto
     * @throws Exception
     */
    public PrpCcoinsDto findByPrimaryKey(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        //����DTO
        PrpCcoinsDto prpCcoinsDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpCcoinsDto = blPrpCcoinsAction.findByPrimaryKey(dbManager,policyNo, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpCcoinsDto;
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
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            int count = blPrpCcoinsAction.getRowCount(dbManager,conditions);
            Collection collection = blPrpCcoinsAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
            pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
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
     * @return Collection ����prpCcoinsDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpCcoinsAction.findByConditions(dbManager,conditions,0,0);
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
    public int getRowCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpCcoinsAction blPrpCcoinsAction = new BLPrpCcoinsAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpCcoinsAction.getRowCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

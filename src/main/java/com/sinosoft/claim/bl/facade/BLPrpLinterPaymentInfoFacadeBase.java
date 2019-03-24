package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterPaymentInfoAction;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�������ӱ�-----�⸶��Ϣ��ҵ���߼�����Facade����<br>
 */
public class BLPrpLinterPaymentInfoFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPaymentInfoFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterPaymentInfoFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @throws Exception
     */
    public void insert(PrpLinterPaymentInfoDto prpLinterPaymentInfoDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPaymentInfoAction blPrpLinterPaymentInfoAction = new BLPrpLinterPaymentInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLinterPaymentInfoAction.insert(dbManager,prpLinterPaymentInfoDto);
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
     * @param id ����id PK
     * @param serialNo ������� PK
     * @throws Exception
     */
    public void delete(String id,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPaymentInfoAction blPrpLinterPaymentInfoAction = new BLPrpLinterPaymentInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLinterPaymentInfoAction.delete(dbManager,id, serialNo);
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
        BLPrpLinterPaymentInfoAction blPrpLinterPaymentInfoAction = new BLPrpLinterPaymentInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLinterPaymentInfoAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @throws Exception
     */
    public void update(PrpLinterPaymentInfoDto prpLinterPaymentInfoDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPaymentInfoAction blPrpLinterPaymentInfoAction = new BLPrpLinterPaymentInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLinterPaymentInfoAction.update(dbManager,prpLinterPaymentInfoDto);
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
     * @param id ����id PK
     * @param serialNo ������� PK
     * @return prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @throws Exception
     */
    public PrpLinterPaymentInfoDto findByPrimaryKey(String id,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterPaymentInfoAction blPrpLinterPaymentInfoAction = new BLPrpLinterPaymentInfoAction();
        //����DTO
        PrpLinterPaymentInfoDto prpLinterPaymentInfoDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLinterPaymentInfoDto = blPrpLinterPaymentInfoAction.findByPrimaryKey(dbManager,id, serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterPaymentInfoDto;
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
        BLPrpLinterPaymentInfoAction blPrpLinterPaymentInfoAction = new BLPrpLinterPaymentInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterPaymentInfoAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLinterPaymentInfoDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterPaymentInfoAction blPrpLinterPaymentInfoAction = new BLPrpLinterPaymentInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterPaymentInfoAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterPaymentInfoAction blPrpLinterPaymentInfoAction = new BLPrpLinterPaymentInfoAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterPaymentInfoAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

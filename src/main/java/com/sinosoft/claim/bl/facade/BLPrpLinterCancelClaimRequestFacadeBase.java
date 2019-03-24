package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLinterCancelClaimRequestAction;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ��������ע�������������ҵ���߼�����Facade����<br>
 */
public class BLPrpLinterCancelClaimRequestFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCancelClaimRequestFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterCancelClaimRequestFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public void insert(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLinterCancelClaimRequestAction.insert(dbManager,prpLinterCancelClaimRequestDto);
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
     * @throws Exception
     */
    public void delete(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLinterCancelClaimRequestAction.delete(dbManager,id);
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
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLinterCancelClaimRequestAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public void update(PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLinterCancelClaimRequestAction.update(dbManager,prpLinterCancelClaimRequestDto);
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
     * @return prpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto
     * @throws Exception
     */
    public PrpLinterCancelClaimRequestDto findByPrimaryKey(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        //����DTO
        PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLinterCancelClaimRequestDto = blPrpLinterCancelClaimRequestAction.findByPrimaryKey(dbManager,id);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterCancelClaimRequestDto;
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
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterCancelClaimRequestAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLinterCancelClaimRequestDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterCancelClaimRequestAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterCancelClaimRequestAction blPrpLinterCancelClaimRequestAction = new BLPrpLinterCancelClaimRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterCancelClaimRequestAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

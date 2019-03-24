package com.sinosoft.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLinterRecaseRequestAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿ��ؿ��ⰸ�����м���ҵ���߼�����Facade����<br>
 */
public class BLPrpLinterRecaseRequestFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterRecaseRequestFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLinterRecaseRequestFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public void insert(PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLinterRecaseRequestAction.insert(dbManager,prpLinterRecaseRequestDto);
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
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLinterRecaseRequestAction.delete(dbManager,id);
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
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLinterRecaseRequestAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public void update(PrpLinterRecaseRequestDto prpLinterRecaseRequestDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLinterRecaseRequestAction.update(dbManager,prpLinterRecaseRequestDto);
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
     * @return prpLinterRecaseRequestDto prpLinterRecaseRequestDto
     * @throws Exception
     */
    public PrpLinterRecaseRequestDto findByPrimaryKey(String id)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        //����DTO
        PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLinterRecaseRequestDto = blPrpLinterRecaseRequestAction.findByPrimaryKey(dbManager,id);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLinterRecaseRequestDto;
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
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLinterRecaseRequestAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLinterRecaseRequestDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLinterRecaseRequestAction.findByConditions(dbManager,conditions);
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
        BLPrpLinterRecaseRequestAction blPrpLinterRecaseRequestAction = new BLPrpLinterRecaseRequestAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLinterRecaseRequestAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

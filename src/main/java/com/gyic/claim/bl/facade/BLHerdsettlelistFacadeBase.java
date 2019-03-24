package com.gyic.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdsettlelistDto;
import com.gyic.claim.bl.action.domain.BLHerdsettlelistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����HERDSETTLELIST��ҵ���߼�����Facade����<br>
 */
public class BLHerdsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLHerdsettlelistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLHerdsettlelistFacadeBase(){
    }

    /**
     * ����һ������
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void insert(HerdsettlelistDto herdsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blHerdsettlelistAction.insert(dbManager,herdsettlelistDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    /**
     * �����������
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void insertAll(List list)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blHerdsettlelistAction.insertAll(dbManager,list);
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
     * @param settlelistcode SETTLELISTCODE
     * @param earlabel EARLABEL
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String settlelistcode,String earlabel,String fcode,String kindcode,int serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blHerdsettlelistAction.delete(dbManager,settlelistcode, earlabel, fcode, kindcode, serialno);
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
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blHerdsettlelistAction.deleteByConditions(dbManager,conditions);
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
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void update(HerdsettlelistDto herdsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blHerdsettlelistAction.update(dbManager,herdsettlelistDto);
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
     * @param settlelistcode SETTLELISTCODE
     * @param earlabel EARLABEL
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param serialno SERIALNO
     * @return herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public HerdsettlelistDto findByPrimaryKey(String settlelistcode,String earlabel,String fcode,String kindcode,int serialno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        //����DTO
        HerdsettlelistDto herdsettlelistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            herdsettlelistDto = blHerdsettlelistAction.findByPrimaryKey(dbManager,settlelistcode, earlabel, fcode, kindcode, serialno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return herdsettlelistDto;
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
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blHerdsettlelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����herdsettlelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blHerdsettlelistAction.findByConditions(dbManager,conditions);
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
        BLHerdsettlelistAction blHerdsettlelistAction = new BLHerdsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blHerdsettlelistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

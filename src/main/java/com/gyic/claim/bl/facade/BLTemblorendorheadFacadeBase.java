package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorendorheadDto;
import com.gyic.claim.bl.action.domain.BLTemblorendorheadAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORENDORHEAD��ҵ���߼�����Facade����<br>
 */
public class BLTemblorendorheadFacadeBase{
    private static Logger logger = Logger.getLogger(BLTemblorendorheadFacadeBase.class);

    /**
     * ���캯��
     */
    public BLTemblorendorheadFacadeBase(){
    }

    /**
     * ����һ������
     * @param temblorendorheadDto temblorendorheadDto
     * @throws Exception
     */
    public void insert(TemblorendorheadDto temblorendorheadDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorendorheadAction blTemblorendorheadAction = new BLTemblorendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blTemblorendorheadAction.insert(dbManager,temblorendorheadDto);
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
     * @param endorseno ENDORSENO
     * @throws Exception
     */
    public void delete(String endorseno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorendorheadAction blTemblorendorheadAction = new BLTemblorendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blTemblorendorheadAction.delete(dbManager,endorseno);
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
        BLTemblorendorheadAction blTemblorendorheadAction = new BLTemblorendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blTemblorendorheadAction.deleteByConditions(dbManager,conditions);
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
     * @param temblorendorheadDto temblorendorheadDto
     * @throws Exception
     */
    public void update(TemblorendorheadDto temblorendorheadDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorendorheadAction blTemblorendorheadAction = new BLTemblorendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blTemblorendorheadAction.update(dbManager,temblorendorheadDto);
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
     * @param endorseno ENDORSENO
     * @return temblorendorheadDto temblorendorheadDto
     * @throws Exception
     */
    public TemblorendorheadDto findByPrimaryKey(String endorseno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorendorheadAction blTemblorendorheadAction = new BLTemblorendorheadAction();
        //����DTO
        TemblorendorheadDto temblorendorheadDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            temblorendorheadDto = blTemblorendorheadAction.findByPrimaryKey(dbManager,endorseno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return temblorendorheadDto;
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
        BLTemblorendorheadAction blTemblorendorheadAction = new BLTemblorendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blTemblorendorheadAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����temblorendorheadDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorendorheadAction blTemblorendorheadAction = new BLTemblorendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blTemblorendorheadAction.findByConditions(dbManager,conditions);
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
        BLTemblorendorheadAction blTemblorendorheadAction = new BLTemblorendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorendorheadAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxendorheadDto;
import com.gyic.claim.bl.action.domain.BLNyxendorheadAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXENDORHEAD��ҵ���߼�����Facade����<br>
 */
public class BLNyxendorheadFacadeBase{
    private static Logger logger = Logger.getLogger(BLNyxendorheadFacadeBase.class);

    /**
     * ���캯��
     */
    public BLNyxendorheadFacadeBase(){
    }

    /**
     * ����һ������
     * @param nyxendorheadDto nyxendorheadDto
     * @throws Exception
     */
    public void insert(NyxendorheadDto nyxendorheadDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxendorheadAction blNyxendorheadAction = new BLNyxendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blNyxendorheadAction.insert(dbManager,nyxendorheadDto);
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
        BLNyxendorheadAction blNyxendorheadAction = new BLNyxendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blNyxendorheadAction.delete(dbManager,endorseno);
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
        BLNyxendorheadAction blNyxendorheadAction = new BLNyxendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blNyxendorheadAction.deleteByConditions(dbManager,conditions);
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
     * @param nyxendorheadDto nyxendorheadDto
     * @throws Exception
     */
    public void update(NyxendorheadDto nyxendorheadDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxendorheadAction blNyxendorheadAction = new BLNyxendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blNyxendorheadAction.update(dbManager,nyxendorheadDto);
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
     * @return nyxendorheadDto nyxendorheadDto
     * @throws Exception
     */
    public NyxendorheadDto findByPrimaryKey(String endorseno)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxendorheadAction blNyxendorheadAction = new BLNyxendorheadAction();
        //����DTO
        NyxendorheadDto nyxendorheadDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            nyxendorheadDto = blNyxendorheadAction.findByPrimaryKey(dbManager,endorseno);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nyxendorheadDto;
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
        BLNyxendorheadAction blNyxendorheadAction = new BLNyxendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blNyxendorheadAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����nyxendorheadDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxendorheadAction blNyxendorheadAction = new BLNyxendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blNyxendorheadAction.findByConditions(dbManager,conditions);
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
        BLNyxendorheadAction blNyxendorheadAction = new BLNyxendorheadAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blNyxendorheadAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

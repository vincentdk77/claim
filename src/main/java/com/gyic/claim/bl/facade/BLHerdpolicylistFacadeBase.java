package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.bl.action.domain.BLHerdpolicylistAction;
import com.gyic.claim.bl.action.domain.BLPlantingpolicylistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����HERDPOLICYLIST��ҵ���߼�����Facade����<br>
 */
public class BLHerdpolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLHerdpolicylistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLHerdpolicylistFacadeBase(){
    }

    /**
     * ����һ������
     * @param herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public void insert(HerdpolicylistDto herdpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blHerdpolicylistAction.insert(dbManager,herdpolicylistDto);
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
     * @param inusrelistcode INUSRELISTCODE
     * @param earlabel EARLABEL
     * @param kindcode KINDCODE
     * @param fcode FCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String earlabel,String kindcode,String fcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blHerdpolicylistAction.delete(dbManager,inusrelistcode, earlabel, kindcode, fcode);
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
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blHerdpolicylistAction.deleteByConditions(dbManager,conditions);
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
     * @param herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public void update(HerdpolicylistDto herdpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blHerdpolicylistAction.update(dbManager,herdpolicylistDto);
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
     * @param inusrelistcode INUSRELISTCODE
     * @param earlabel EARLABEL
     * @param kindcode KINDCODE
     * @param fcode FCODE
     * @return herdpolicylistDto herdpolicylistDto
     * @throws Exception
     */
    public HerdpolicylistDto findByPrimaryKey(String inusrelistcode,String earlabel,String kindcode,String fcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        //����DTO
        HerdpolicylistDto herdpolicylistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            herdpolicylistDto = blHerdpolicylistAction.findByPrimaryKey(dbManager,inusrelistcode, earlabel, kindcode, fcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return herdpolicylistDto;
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
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blHerdpolicylistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����herdpolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blHerdpolicylistAction.findByConditions(dbManager,conditions);
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
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blHerdpolicylistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @param fieldName �ֶ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public double getSum(String conditions, String fieldName)
        throws Exception{
        double sum=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blHerdpolicylistAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
    
    /**
     * ��������ѯ��������--��ũ��
     * @param conditions ��ѯ����
     * @return Collection ����herdpolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findNewAgriByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLHerdpolicylistAction blHerdpolicylistAction = new BLHerdpolicylistAction();
        try{
            dbManager.open("NewNXDADataSource");
            collection = blHerdpolicylistAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}

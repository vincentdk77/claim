package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.InsuremainlistDto;
import com.gyic.claim.bl.action.domain.BLInsuremainlistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Ͷ���嵥ͷ���ҵ���߼�����Facade����<br>
 */
public class BLInsuremainlistFacadeBase{
    private static Logger logger = Logger.getLogger(BLInsuremainlistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLInsuremainlistFacadeBase(){
    }

    /**
     * ����һ������
     * @param insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public void insert(InsuremainlistDto insuremainlistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blInsuremainlistAction.insert(dbManager,insuremainlistDto);
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
     * @param inusrelistcode Ͷ���嵥���
     * @throws Exception
     */
    public void delete(String inusrelistcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blInsuremainlistAction.delete(dbManager,inusrelistcode);
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
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blInsuremainlistAction.deleteByConditions(dbManager,conditions);
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
     * @param insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public void update(InsuremainlistDto insuremainlistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blInsuremainlistAction.update(dbManager,insuremainlistDto);
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
     * @param inusrelistcode Ͷ���嵥���
     * @return insuremainlistDto insuremainlistDto
     * @throws Exception
     */
    public InsuremainlistDto findByPrimaryKey(String inusrelistcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        //����DTO
        InsuremainlistDto insuremainlistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            insuremainlistDto = blInsuremainlistAction.findByPrimaryKey(dbManager,inusrelistcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return insuremainlistDto;
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
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blInsuremainlistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����insuremainlistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blInsuremainlistAction.findByConditions(dbManager,conditions);
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
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blInsuremainlistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * ��������ѯ��������--��ũ��
     * @param conditions ��ѯ����
     * @return Collection ����insuremainlistDto�ļ���
     * @throws Exception
     */
    public Collection findNewAgriByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLInsuremainlistAction blInsuremainlistAction = new BLInsuremainlistAction();
        try{
            dbManager.open("NewNXDADataSource");
            collection = blInsuremainlistAction.findByConditions(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
}

package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31PolicyListDto;
import com.gyic.claim.bl.action.domain.BLPlanting31PolicyListAction;
import com.gyic.claim.bl.action.domain.BLPlantingpolicylistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Planting31PolicyList��ҵ���߼�����Facade����<br>
 */
public class BLPlanting31PolicyListFacadeBase{
    private static Logger logger = Logger.getLogger(BLPlanting31PolicyListFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPlanting31PolicyListFacadeBase(){
    }

    /**
     * ����һ������
     * @param planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public void insert(Planting31PolicyListDto planting31PolicyListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blPlanting31PolicyListAction.insert(dbManager,planting31PolicyListDto);
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
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(String inusreListCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPlanting31PolicyListAction.delete(dbManager,inusreListCode);
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
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPlanting31PolicyListAction.deleteByConditions(dbManager,conditions);
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
     * @param planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public void update(Planting31PolicyListDto planting31PolicyListDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPlanting31PolicyListAction.update(dbManager,planting31PolicyListDto);
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
     * @param inusreListCode InusreListCode
     * @return planting31PolicyListDto planting31PolicyListDto
     * @throws Exception
     */
    public Planting31PolicyListDto findByPrimaryKey(String inusreListCode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        //����DTO
        Planting31PolicyListDto planting31PolicyListDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            planting31PolicyListDto = blPlanting31PolicyListAction.findByPrimaryKey(dbManager,inusreListCode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return planting31PolicyListDto;
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
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blPlanting31PolicyListAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����planting31PolicyListDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blPlanting31PolicyListAction.findByConditions(dbManager,conditions);
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
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlanting31PolicyListAction.getCount(dbManager,conditions);
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
        BLPlanting31PolicyListAction blPlanting31PolicyListAction = new BLPlanting31PolicyListAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blPlanting31PolicyListAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}

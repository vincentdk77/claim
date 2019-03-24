package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingpolicylistDto;
import com.gyic.claim.bl.action.domain.BLPlantingpolicylistAction;
import com.gyic.claim.bl.action.domain.BLPlantingsettlelistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGPOLICYLIST��ҵ���߼�����Facade����<br>
 */
public class BLPlantingpolicylistFacadeBase{
    private static Logger logger = Logger.getLogger(BLPlantingpolicylistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPlantingpolicylistFacadeBase(){
    }

    /**
     * ����һ������
     * @param plantingpolicylistDto plantingpolicylistDto
     * @throws Exception
     */
    public void insert(PlantingpolicylistDto plantingpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blPlantingpolicylistAction.insert(dbManager,plantingpolicylistDto);
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
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @throws Exception
     */
    public void delete(String inusrelistcode,String fcode,String kindcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPlantingpolicylistAction.delete(dbManager,inusrelistcode, fcode, kindcode);
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
        BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPlantingpolicylistAction.deleteByConditions(dbManager,conditions);
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
     * @param plantingpolicylistDto plantingpolicylistDto
     * @throws Exception
     */
    public void update(PlantingpolicylistDto plantingpolicylistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPlantingpolicylistAction.update(dbManager,plantingpolicylistDto);
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
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @return plantingpolicylistDto plantingpolicylistDto
     * @throws Exception
     */
    public PlantingpolicylistDto findByPrimaryKey(String inusrelistcode,String fcode,String kindcode)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
        //����DTO
        PlantingpolicylistDto plantingpolicylistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            plantingpolicylistDto = blPlantingpolicylistAction.findByPrimaryKey(dbManager,inusrelistcode, fcode, kindcode);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return plantingpolicylistDto;
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
        BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blPlantingpolicylistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����plantingpolicylistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blPlantingpolicylistAction.findByConditions(dbManager,conditions);
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
        BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlantingpolicylistAction.getCount(dbManager,conditions);
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
        BLPlantingpolicylistAction blPlantingpolicylistAction = new BLPlantingpolicylistAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blPlantingpolicylistAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}

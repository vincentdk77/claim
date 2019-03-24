package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelisttempDto;
import com.gyic.claim.bl.action.domain.BLPlantingsettlelisttempAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGSETTLELISTTEMP��ҵ���߼�����Facade����<br>
 */
public class BLPlantingsettlelisttempFacadeBase{
    private static Logger logger = Logger.getLogger(BLPlantingsettlelisttempFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPlantingsettlelisttempFacadeBase(){
    }

    /**
     * ����һ������
     * @param plantingsettlelisttempDto plantingsettlelisttempDto
     * @throws Exception
     */
    public void insert(PlantingsettlelisttempDto plantingsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelisttempAction blPlantingsettlelisttempAction = new BLPlantingsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blPlantingsettlelisttempAction.insert(dbManager,plantingsettlelisttempDto);
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
     * @param registcode REGISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @throws Exception
     */
    public void delete(String registcode,int indexofsettle,String stringtimestamp)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelisttempAction blPlantingsettlelisttempAction = new BLPlantingsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPlantingsettlelisttempAction.delete(dbManager,registcode, indexofsettle, stringtimestamp);
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
        BLPlantingsettlelisttempAction blPlantingsettlelisttempAction = new BLPlantingsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPlantingsettlelisttempAction.deleteByConditions(dbManager,conditions);
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
     * @param plantingsettlelisttempDto plantingsettlelisttempDto
     * @throws Exception
     */
    public void update(PlantingsettlelisttempDto plantingsettlelisttempDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelisttempAction blPlantingsettlelisttempAction = new BLPlantingsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPlantingsettlelisttempAction.update(dbManager,plantingsettlelisttempDto);
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
     * @param registcode REGISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param stringtimestamp STRINGTIMESTAMP
     * @return plantingsettlelisttempDto plantingsettlelisttempDto
     * @throws Exception
     */
    public PlantingsettlelisttempDto findByPrimaryKey(String registcode,int indexofsettle,String stringtimestamp)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelisttempAction blPlantingsettlelisttempAction = new BLPlantingsettlelisttempAction();
        //����DTO
        PlantingsettlelisttempDto plantingsettlelisttempDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            plantingsettlelisttempDto = blPlantingsettlelisttempAction.findByPrimaryKey(dbManager,registcode, indexofsettle, stringtimestamp);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return plantingsettlelisttempDto;
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
        BLPlantingsettlelisttempAction blPlantingsettlelisttempAction = new BLPlantingsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blPlantingsettlelisttempAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����plantingsettlelisttempDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlantingsettlelisttempAction blPlantingsettlelisttempAction = new BLPlantingsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blPlantingsettlelisttempAction.findByConditions(dbManager,conditions);
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
        BLPlantingsettlelisttempAction blPlantingsettlelisttempAction = new BLPlantingsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlantingsettlelisttempAction.getCount(dbManager,conditions);
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
        BLPlantingsettlelisttempAction blPlantingsettlelisttempAction = new BLPlantingsettlelisttempAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blPlantingsettlelisttempAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
}

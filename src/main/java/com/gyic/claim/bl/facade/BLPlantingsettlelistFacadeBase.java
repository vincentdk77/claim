package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.bl.action.domain.BLPlantingsettlelistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGSETTLELIST��ҵ���߼�����Facade����<br>
 */
public class BLPlantingsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLPlantingsettlelistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPlantingsettlelistFacadeBase(){
    }

    /**
     * ����һ������
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void insert(PlantingsettlelistDto plantingsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blPlantingsettlelistAction.insert(dbManager,plantingsettlelistDto);
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
     * @param List plantingSettleListDtoList
     * @throws Exception
     */
    public void insert(List plantingSettleListDtoList)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            if(null!=plantingSettleListDtoList){
            	for(int i=0;i<plantingSettleListDtoList.size();i++){
            		PlantingsettlelistDto plantingsettlelistDto = (PlantingsettlelistDto)plantingSettleListDtoList.get(i);
		            //�����¼
		            blPlantingsettlelistAction.insert(dbManager,plantingsettlelistDto);
            	}
            }
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
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(String settlelistcode,String fcode,String kindcode,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blPlantingsettlelistAction.delete(dbManager,settlelistcode, fcode, kindcode, nodetype, indexofsettle);
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
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blPlantingsettlelistAction.deleteByConditions(dbManager,conditions);
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
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void update(PlantingsettlelistDto plantingsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blPlantingsettlelistAction.update(dbManager,plantingsettlelistDto);
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
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public PlantingsettlelistDto findByPrimaryKey(String settlelistcode,String fcode,String kindcode,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        //����DTO
        PlantingsettlelistDto plantingsettlelistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            plantingsettlelistDto = blPlantingsettlelistAction.findByPrimaryKey(dbManager,settlelistcode, fcode, kindcode, nodetype, indexofsettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return plantingsettlelistDto;
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
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blPlantingsettlelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����plantingsettlelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blPlantingsettlelistAction.findByConditions(dbManager,conditions);
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
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlantingsettlelistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * ��ѯ��ͬ��ʧ�ʵļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getDistinctLossRateCount(String conditions) 
        throws Exception{
        int rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlantingsettlelistAction.getDistinctLossRateCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    /**
     * ͳ�ƻ���
     * @param conditions conditions
     * @return ͳ�ƻ���
     * @throws Exception
     */
    public double getDamageInsured(String conditions) 
        throws Exception{
    	double rowCount=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPlantingsettlelistAction.getDamageInsured(dbManager,conditions);
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
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blPlantingsettlelistAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
    
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @param fieldName �ֶ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getMaxIndex(String conditions)
        throws Exception{
        int max=0;
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPlantingsettlelistAction blPlantingsettlelistAction = new BLPlantingsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            max = blPlantingsettlelistAction.getMaxIndex(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return max;
    }
}

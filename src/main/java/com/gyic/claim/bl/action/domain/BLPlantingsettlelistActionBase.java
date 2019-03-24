package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGSETTLELIST��ҵ���߼�������<br>
 */
public class BLPlantingsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLPlantingsettlelistActionBase.class);

    /**
     * ���캯��
     */
    public BLPlantingsettlelistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PlantingsettlelistDto plantingsettlelistDto)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        //�����¼
        dbPlantingsettlelist.insert(plantingsettlelistDto);
    }

    /**
     * �����������
     * @param dbManager DB������
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,List plantingsettlelistDtoList)
            throws Exception{
    	if(null!=plantingsettlelistDtoList && plantingsettlelistDtoList.size()>0){
	        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
	        PlantingsettlelistDto plantingsettlelistDto = new PlantingsettlelistDto();
	        //�����¼
	        for(int i=0;i<plantingsettlelistDtoList.size();i++){
	        	plantingsettlelistDto = (PlantingsettlelistDto)plantingsettlelistDtoList.get(i);
	        	dbPlantingsettlelist.insert(plantingsettlelistDto);
	        }
    	}
    }
    
    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settlelistcode,String fcode,String kindcode,String nodetype,int indexofsettle)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        //ɾ����¼
        dbPlantingsettlelist.delete(settlelistcode, fcode, kindcode, nodetype, indexofsettle);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        //������ɾ����¼
        dbPlantingsettlelist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PlantingsettlelistDto plantingsettlelistDto)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        //���¼�¼
        dbPlantingsettlelist.update(plantingsettlelistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return plantingsettlelistDto plantingsettlelistDto
     * @throws Exception
     */
    public PlantingsettlelistDto findByPrimaryKey(DBManager dbManager,String settlelistcode,String fcode,String kindcode,String nodetype,int indexofsettle)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        //����DTO
        PlantingsettlelistDto plantingsettlelistDto = null;
        //��ѯ����,��ֵ��DTO
        plantingsettlelistDto = dbPlantingsettlelist.findByPrimaryKey(settlelistcode, fcode, kindcode, nodetype, indexofsettle);
        return plantingsettlelistDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingsettlelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlantingsettlelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����plantingsettlelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlantingsettlelist.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingsettlelist.getCount(conditions);
        return count;
    }
    /**
     * ��ѯ��ͬ��ʧ�ʵļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getDistinctLossRateCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlantingsettlelist.getDistinctLossRateCount(conditions);
        return count;
    }
    /**
     * ͳ�ƻ���
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ͳ�ƻ���
     * @throws Exception
     */
    public double getDamageInsured(DBManager dbManager,String conditions) 
        throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double count = dbPlantingsettlelist.getDamageInsured(conditions);
        return count;
    }
        /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @param fieldName �ֶ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public double getSum(DBManager dbManager,String conditions,String fieldName) 
        throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlantingsettlelist.getSum(conditions,fieldName);
        return sum;
    }
    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @param fieldName �ֶ���
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getMaxIndex(DBManager dbManager,String conditions)
        throws Exception{
        DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int max = dbPlantingsettlelist.getMaxIndex(conditions);
        return max;
    }
    
    /**
     * �����ݴ���ʱ�� PLANTINGSETTLELISTTEMP ������ʽ�� PLANTINGSETTLELIST
     * @param settleListCode ��ʽ���е������嵥��
     * @param indexOfSettle ��ʽ���е����
     * @param whereCondition ��ʱ���ѯ��������������Щ���ݲ�����ʽ��
     * @throws Exception
     */
    public void evaluate(DBManager dbManager, String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
    	DBPlantingsettlelist dbPlantingsettlelist = new DBPlantingsettlelist(dbManager);

        if(whereCondition.trim().length()==0){
        	whereCondition = "1=1";
        }
        dbPlantingsettlelist.evaluate(settleListCode, indexOfSettle, whereCondition);
    }
}

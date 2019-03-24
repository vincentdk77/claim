package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBMedicalsettlelist;
import java.math.BigDecimal;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGSETTLELIST��ҵ���߼�������<br>
 */
public class BLMedicalsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLMedicalsettlelistActionBase.class);

    /**
     * ���캯��
     */
    public BLMedicalsettlelistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,MedicalsettlelistDto medicalsettlelistDto)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        //�����¼
        dbMedicalsettlelist.insert(medicalsettlelistDto);
    }

    /**
     * �����������
     * @param dbManager DB������
     * @param medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,List medicalsettlelistDtoList)
            throws Exception{
    	if(null!=medicalsettlelistDtoList && medicalsettlelistDtoList.size()>0){
	        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
	        MedicalsettlelistDto medicalsettlelistDto = new MedicalsettlelistDto();
	        //�����¼
	        for(int i=0;i<medicalsettlelistDtoList.size();i++){
	        	medicalsettlelistDto = (MedicalsettlelistDto)medicalsettlelistDtoList.get(i);
	        	dbMedicalsettlelist.insert(medicalsettlelistDto);
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
    public void delete(DBManager dbManager,String settlelistcode,String idcard,String nodetype,int indexofsettle)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        //ɾ����¼
        dbMedicalsettlelist.delete(settlelistcode, idcard, nodetype, indexofsettle);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        //������ɾ����¼
        dbMedicalsettlelist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,MedicalsettlelistDto medicalsettlelistDto)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        //���¼�¼
        dbMedicalsettlelist.update(medicalsettlelistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public MedicalsettlelistDto findByPrimaryKey(DBManager dbManager,String settlelistcode,String idcard,String nodetype,int indexofsettle)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        //����DTO
        MedicalsettlelistDto medicalsettlelistDto = null;
        //��ѯ����,��ֵ��DTO
        medicalsettlelistDto = dbMedicalsettlelist.findByPrimaryKey(settlelistcode, idcard, nodetype, indexofsettle);
        return medicalsettlelistDto;
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
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalsettlelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbMedicalsettlelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����medicalsettlelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbMedicalsettlelist.findByConditions(conditions);
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
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalsettlelist.getCount(conditions);
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
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbMedicalsettlelist.getDistinctLossRateCount(conditions);
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
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double count = dbMedicalsettlelist.getDamageInsured(conditions);
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
    public BigDecimal getSum(DBManager dbManager,String conditions,String fieldName) 
        throws Exception{
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        BigDecimal sum = dbMedicalsettlelist.getSum(conditions,fieldName);
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
        DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int max = dbMedicalsettlelist.getMaxIndex(conditions);
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
    	DBMedicalsettlelist dbMedicalsettlelist = new DBMedicalsettlelist(dbManager);

        if(whereCondition.trim().length()==0){
        	whereCondition = "1=1";
        }
        dbMedicalsettlelist.evaluate(settleListCode, indexOfSettle, whereCondition);
    }
}

package com.gyic.claim.bl.facade;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.MedicalsettlelistDto;
import com.gyic.claim.bl.action.domain.BLMedicalsettlelistAction;
import java.math.BigDecimal;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PLANTINGSETTLELIST��ҵ���߼�����Facade����<br>
 */
public class BLMedicalsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLMedicalsettlelistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLMedicalsettlelistFacadeBase(){
    }

    /**
     * ����һ������
     * @param medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public void insert(MedicalsettlelistDto medicalsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //�����¼
            blMedicalsettlelistAction.insert(dbManager,medicalsettlelistDto);
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
     * @param List medicalSettleListDtoList
     * @throws Exception
     */
    public void insert(List medicalSettleListDtoList)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            if(null!=medicalSettleListDtoList){
            	for(int i=0;i<medicalSettleListDtoList.size();i++){
            		MedicalsettlelistDto medicalsettlelistDto = (MedicalsettlelistDto)medicalSettleListDtoList.get(i);
		            //�����¼
		            blMedicalsettlelistAction.insert(dbManager,medicalsettlelistDto);
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
    public void delete(String settlelistcode,String idcard,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blMedicalsettlelistAction.delete(dbManager,settlelistcode, idcard,  nodetype, indexofsettle);
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blMedicalsettlelistAction.deleteByConditions(dbManager,conditions);
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
     * @param medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public void update(MedicalsettlelistDto medicalsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blMedicalsettlelistAction.update(dbManager,medicalsettlelistDto);
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
     * @return medicalsettlelistDto medicalsettlelistDto
     * @throws Exception
     */
    public MedicalsettlelistDto findByPrimaryKey(String settlelistcode,String idcard,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        //����DTO
        MedicalsettlelistDto medicalsettlelistDto = null;
        try{
            dbManager.open("JKXDataSource");
            //��ѯ����,��ֵ��DTO
            medicalsettlelistDto = blMedicalsettlelistAction.findByPrimaryKey(dbManager,settlelistcode, idcard, nodetype, indexofsettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return medicalsettlelistDto;
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            pageRecord = blMedicalsettlelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����medicalsettlelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            collection = blMedicalsettlelistAction.findByConditions(dbManager,conditions);
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            rowCount = blMedicalsettlelistAction.getCount(dbManager,conditions);
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            rowCount = blMedicalsettlelistAction.getDistinctLossRateCount(dbManager,conditions);
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            rowCount = blMedicalsettlelistAction.getDamageInsured(dbManager,conditions);
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
    public BigDecimal getSum(String conditions, String fieldName)
        throws Exception{
    	BigDecimal sum =new BigDecimal(0);
        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            sum = blMedicalsettlelistAction.getSum(dbManager,conditions,fieldName);
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
        BLMedicalsettlelistAction blMedicalsettlelistAction = new BLMedicalsettlelistAction();
        try{
            dbManager.open("JKXDataSource");
            max = blMedicalsettlelistAction.getMaxIndex(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return max;
    }
}

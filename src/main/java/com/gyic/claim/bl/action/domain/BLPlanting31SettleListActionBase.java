package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Planting31SettleListDto;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31SettleList;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����Planting31SettleList��ҵ���߼�������<br>
 */
public class BLPlanting31SettleListActionBase{
    private static Logger logger = Logger.getLogger(BLPlanting31SettleListActionBase.class);

    /**
     * ���캯��
     */
    public BLPlanting31SettleListActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param planting31SettleListDto planting31SettleListDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Planting31SettleListDto planting31SettleListDto)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        //�����¼
        dbPlanting31SettleList.insert(planting31SettleListDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param settleListCode SettleListCode
     * @param fcode FCode
     * @param kindCode KindCode
     * @param itemCode ItemCode
     * @param nodeType NodeType
     * @param indexOfSettle IndexOfSettle
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settleListCode,String fcode,String kindCode,String itemCode,String nodeType,int indexOfSettle)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        //ɾ����¼
        dbPlanting31SettleList.delete(settleListCode, fcode, kindCode, itemCode, nodeType, indexOfSettle);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        //������ɾ����¼
        dbPlanting31SettleList.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param planting31SettleListDto planting31SettleListDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Planting31SettleListDto planting31SettleListDto)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        //���¼�¼
        dbPlanting31SettleList.update(planting31SettleListDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param settleListCode SettleListCode
     * @param fcode FCode
     * @param kindCode KindCode
     * @param itemCode ItemCode
     * @param nodeType NodeType
     * @param indexOfSettle IndexOfSettle
     * @return planting31SettleListDto planting31SettleListDto
     * @throws Exception
     */
    public Planting31SettleListDto findByPrimaryKey(DBManager dbManager,String settleListCode,String fcode,String kindCode,String itemCode,String nodeType,int indexOfSettle)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        //����DTO
        Planting31SettleListDto planting31SettleListDto = null;
        //��ѯ����,��ֵ��DTO
        planting31SettleListDto = dbPlanting31SettleList.findByPrimaryKey(settleListCode, fcode, kindCode, itemCode, nodeType, indexOfSettle);
        return planting31SettleListDto;
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
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31SettleList.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPlanting31SettleList.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����planting31SettleListDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPlanting31SettleList.findByConditions(conditions);
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
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPlanting31SettleList.getCount(conditions);
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
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlanting31SettleList.getSum(conditions,fieldName);
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
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int max = dbPlanting31SettleList.getMaxIndex(conditions);
        return max;
    }
    
    /**
     * �����ݴ���ʱ�� PLANTING31SETTLELISTTEMP ������ʽ�� PLANTING31SETTLELIST
     * @param settleListCode ��ʽ���е������嵥��
     * @param indexOfSettle ��ʽ���е����
     * @param whereCondition ��ʱ���ѯ��������������Щ���ݲ�����ʽ��
     * @throws Exception
     */
    public void evaluate(DBManager dbManager, String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(whereCondition.trim().length()==0){
        	whereCondition = "1=1";
        }
        dbPlanting31SettleList.evaluate(settleListCode, indexOfSettle, whereCondition);
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
        DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double count = dbPlanting31SettleList.getDamageInsured(conditions);
        return count;
    }
    /**
     * ת�������嵥����
     * @param dbManager DB������
     * @param settleListCode �����嵥��
     * @param nodeTypeFrom �嵥��Դ�ڵ�����
     * @param nodeTypeTo �嵥Ŀ�Ľڵ�����
     * @return  
     * @throws Exception
     */
    public void dumpByNodeType(DBManager dbManager, String settleListCode, String nodeTypeFrom, String nodeTypeTo)
    throws Exception{
        try {
			DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			dbPlanting31SettleList.dumpByNodeType(settleListCode, nodeTypeFrom, nodeTypeTo);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    /**
     * ���ձ𣬱�ģ���ʧ�ʻ��������嵥
     * @param dbManager DB������
     * @param sqlCondition ��ѯ����
     * @return  resultList ����б�
     * @throws Exception
     */
    public Collection getGroupedSumData(DBManager dbManager, String sqlCondition,  boolean groupByKindCode, boolean groupByItemCode, boolean groupByLossRate, boolean groupByClaimRate)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
		try {

			DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			resultList = dbPlanting31SettleList.getGroupedSumData(sqlCondition, groupByKindCode, groupByItemCode, groupByLossRate, groupByClaimRate);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return resultList;
    }
    
    /**
     * ���ձ𣬱�ģ���ʧ�ʣ�ũ�����룬�����������������嵥
     * @param dbManager DB������
     * @param sqlCondition ��ѯ����
     * @return  resultList ����б�
     * @throws Exception
     */
    public Collection getGroupedSumDataByFcode(DBManager dbManager, String sqlCondition)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
		try {

			DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			resultList = dbPlanting31SettleList.getGroupedSumDataByFcode(sqlCondition);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return resultList;
    }
    
    /**
     * ����ĳһũ����������
     * @param settleListCode �����嵥��
     * @param fIdCard ũ�����֤��
     * @return  result ���
     * @throws Exception
     */
    public double getSettleSumByFcodeNodeType(DBManager dbManager, String settleListCode, String fIdCard, String nodeType)
    throws Exception{
    	
    	double settleSum = 0.0;
		try {

			DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			settleSum = dbPlanting31SettleList.getSettleSumByFcodeNodeType(settleListCode, fIdCard,nodeType);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return settleSum;
    }
}


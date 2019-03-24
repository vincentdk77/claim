package com.gyic.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelist;
import com.gyic.claim.resource.dtofactory.domain.DBPlantingsettlelist;
import com.gyic.claim.resource.dtofactory.domain.DBTemblorsettlelist;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORSETTLELIST��ҵ���߼�������<br>
 */
public class BLTemblorsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLTemblorsettlelistActionBase.class);

    /**
     * ���캯��
     */
    public BLTemblorsettlelistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TemblorsettlelistDto temblorsettlelistDto)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //�����¼
        dbTemblorsettlelist.insert(temblorsettlelistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param settlelistcode SETTLELISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settlelistcode,int indexofsettle,String kindcode,String itemcode,String nodetype)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //ɾ����¼
        dbTemblorsettlelist.delete(settlelistcode, indexofsettle, kindcode, itemcode, nodetype);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //������ɾ����¼
        dbTemblorsettlelist.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TemblorsettlelistDto temblorsettlelistDto)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //���¼�¼
        dbTemblorsettlelist.update(temblorsettlelistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param settlelistcode SETTLELISTCODE
     * @param indexofsettle INDEXOFSETTLE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @return temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public TemblorsettlelistDto findByPrimaryKey(DBManager dbManager,String settlelistcode,int indexofsettle,String kindcode,String itemcode,String nodetype)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //����DTO
        TemblorsettlelistDto temblorsettlelistDto = null;
        //��ѯ����,��ֵ��DTO
        temblorsettlelistDto = dbTemblorsettlelist.findByPrimaryKey(settlelistcode, indexofsettle, kindcode, itemcode, nodetype);
        return temblorsettlelistDto;
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
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorsettlelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTemblorsettlelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����temblorsettlelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTemblorsettlelist.findByConditions(conditions);
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
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorsettlelist.getCount(conditions);
        return count;
    }
    
    public void evaluate(DBManager dbManager, String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
    	DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
        //DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(whereCondition.trim().length()==0){
        	whereCondition = "1=1";
        }
        dbTemblorsettlelist.evaluate(settleListCode, indexOfSettle, whereCondition);
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
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTemblorsettlelist.getDistinctLossRateCount(conditions);
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
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double count = dbTemblorsettlelist.getDamageInsured(conditions);
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
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbTemblorsettlelist.getSum(conditions,fieldName);
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
        DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int max = dbTemblorsettlelist.getMaxIndex(conditions);
        return max;
    }
    
    
    /**
     * ����ĳһũ����������
     * @param settleListCode �����嵥��
     * @param fIdCard ũ�����֤��
     * @return  result ���
     * @throws Exception
     */
    public double getSettleSumByFcodeNodeType(DBManager dbManager, String settleListCode, String fIdCard, String address, String nodeType)
    throws Exception{
    	
    	double settleSum = 0.0;
		try {

			DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
			settleSum = dbTemblorsettlelist.getSettleSumByFcodeNodeType(settleListCode, fIdCard,address,nodeType);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return settleSum;
    }
    


    
    public Collection getGroupedSumDataByFcode(DBManager dbManager, String sqlCondition)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
		try {
			DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
			//DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			resultList = dbTemblorsettlelist.getGroupedSumDataByFcode(sqlCondition);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return resultList;
    }
    
    public void dumpByNodeType(DBManager dbManager, String settleListCode, String nodeTypeFrom, String nodeTypeTo)
    throws Exception{
        try {
        	DBTemblorsettlelist dbTemblorsettlelist = new DBTemblorsettlelist(dbManager);
			//DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        	dbTemblorsettlelist.dumpByNodeType(settleListCode, nodeTypeFrom, nodeTypeTo);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

}

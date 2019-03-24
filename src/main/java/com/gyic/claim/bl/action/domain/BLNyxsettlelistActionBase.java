package com.gyic.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelist;
import com.gyic.claim.resource.dtofactory.domain.DBPlanting31SettleList;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXSETTLELIST��ҵ���߼�������<br>
 */
public class BLNyxsettlelistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxsettlelistActionBase.class);

    /**
     * ���캯��
     */
    public BLNyxsettlelistActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxsettlelistDto nyxsettlelistDto)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //�����¼
        dbNyxsettlelist.insert(nyxsettlelistDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String settlelistcode,String fcode,String kindcode,String itemcode,String nodetype,int indexofsettle)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //ɾ����¼
        dbNyxsettlelist.delete(settlelistcode, fcode, kindcode, itemcode, nodetype, indexofsettle);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //������ɾ����¼
        dbNyxsettlelist.deleteByConditions(conditions);
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
    	DBNyxsettlelist dbPlanting31SettleList = new DBNyxsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sum = dbPlanting31SettleList.getSum(conditions,fieldName);
        return sum;
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxsettlelistDto nyxsettlelistDto)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //���¼�¼
        dbNyxsettlelist.update(nyxsettlelistDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param settlelistcode SETTLELISTCODE
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public NyxsettlelistDto findByPrimaryKey(DBManager dbManager,String settlelistcode,String fcode,String kindcode,String itemcode,String nodetype,int indexofsettle)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //����DTO
        NyxsettlelistDto nyxsettlelistDto = null;
        //��ѯ����,��ֵ��DTO
        nyxsettlelistDto = dbNyxsettlelist.findByPrimaryKey(settlelistcode, fcode, kindcode, itemcode, nodetype, indexofsettle);
        return nyxsettlelistDto;
    }
    
    public Collection getGroupedSumData(DBManager dbManager, String sqlCondition,  boolean groupByKindCode, boolean groupByItemCode, boolean groupByLossRate, boolean groupByClaimRate)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
		try {
			DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
			//DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			resultList = dbNyxsettlelist.getGroupedSumData(sqlCondition, groupByKindCode, groupByItemCode, groupByLossRate, groupByClaimRate);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return resultList;
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
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxsettlelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxsettlelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����nyxsettlelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxsettlelist.findByConditions(conditions);
        return collection;
    }
    
    public void dumpByNodeType(DBManager dbManager, String settleListCode, String nodeTypeFrom, String nodeTypeTo)
    throws Exception{
        try {
        	DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
			//DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
        	dbNyxsettlelist.dumpByNodeType(settleListCode, nodeTypeFrom, nodeTypeTo);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
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
        DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxsettlelist.getCount(conditions);
        return count;
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

			DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
			settleSum = dbNyxsettlelist.getSettleSumByFcodeNodeType(settleListCode, fIdCard,nodeType);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return settleSum;
    }
    
    public double getDamageInsured(DBManager dbManager,String conditions) 
    throws Exception{
    	DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);	
    //DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    double count = dbNyxsettlelist.getDamageInsured(conditions);
    return count;
}
    
    /**
     * �����ݴ���ʱ�� PLANTING31SETTLELISTTEMP ������ʽ�� PLANTING31SETTLELIST
     * @param settleListCode ��ʽ���е������嵥��
     * @param indexOfSettle ��ʽ���е����
     * @param whereCondition ��ʱ���ѯ��������������Щ���ݲ�����ʽ��
     * @throws Exception
     */
    public void evaluate(DBManager dbManager, String settleListCode, int indexOfSettle, String whereCondition) throws Exception{
    	DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
        //DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

        if(whereCondition.trim().length()==0){
        	whereCondition = "1=1";
        }
        dbNyxsettlelist.evaluate(settleListCode, indexOfSettle, whereCondition);
    }
    
    public int getMaxIndex(DBManager dbManager,String conditions)
    throws Exception{
    DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
    //DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    int max = dbNyxsettlelist.getMaxIndex(conditions);
    return max;
}
    
    public Collection getGroupedSumDataByFcode(DBManager dbManager, String sqlCondition)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
		try {
			DBNyxsettlelist dbNyxsettlelist = new DBNyxsettlelist(dbManager);
			//DBPlanting31SettleList dbPlanting31SettleList = new DBPlanting31SettleList(dbManager);
			resultList = dbNyxsettlelist.getGroupedSumDataByFcode(sqlCondition);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return resultList;
    }
}

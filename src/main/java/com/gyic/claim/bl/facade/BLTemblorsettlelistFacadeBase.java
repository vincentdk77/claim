package com.gyic.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TemblorsettlelistDto;
import com.gyic.claim.bl.action.domain.BLNyxsettlelistAction;
import com.gyic.claim.bl.action.domain.BLPlantingsettlelistAction;
import com.gyic.claim.bl.action.domain.BLTemblorsettlelistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����TEMBLORSETTLELIST��ҵ���߼�����Facade����<br>
 */
public class BLTemblorsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLTemblorsettlelistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLTemblorsettlelistFacadeBase(){
    }

    /**
     * ����һ������
     * @param temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public void insert(TemblorsettlelistDto temblorsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blTemblorsettlelistAction.insert(dbManager,temblorsettlelistDto);
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
     * @param indexofsettle INDEXOFSETTLE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(String settlelistcode,int indexofsettle,String kindcode,String itemcode,String nodetype)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blTemblorsettlelistAction.delete(dbManager,settlelistcode, indexofsettle, kindcode, itemcode, nodetype);
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
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blTemblorsettlelistAction.deleteByConditions(dbManager,conditions);
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
     * @param temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public void update(TemblorsettlelistDto temblorsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blTemblorsettlelistAction.update(dbManager,temblorsettlelistDto);
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
     * @param indexofsettle INDEXOFSETTLE
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @return temblorsettlelistDto temblorsettlelistDto
     * @throws Exception
     */
    public TemblorsettlelistDto findByPrimaryKey(String settlelistcode,int indexofsettle,String kindcode,String itemcode,String nodetype)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        //����DTO
        TemblorsettlelistDto temblorsettlelistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            temblorsettlelistDto = blTemblorsettlelistAction.findByPrimaryKey(dbManager,settlelistcode, indexofsettle, kindcode, itemcode, nodetype);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return temblorsettlelistDto;
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
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blTemblorsettlelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����temblorsettlelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blTemblorsettlelistAction.findByConditions(dbManager,conditions);
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
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorsettlelistAction.getCount(dbManager,conditions);
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
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorsettlelistAction.getDistinctLossRateCount(dbManager,conditions);
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
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blTemblorsettlelistAction.getDamageInsured(dbManager,conditions);
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
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blTemblorsettlelistAction.getSum(dbManager,conditions,fieldName);
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
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            max = blTemblorsettlelistAction.getMaxIndex(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return max;
    }
    
    /**
     * ����ĳһũ����������
     * @param settleListCode �����嵥��
     * @param fIdCard ũ�����֤��
     * @return  result ���
     * @throws Exception
     */
    public double getSettleSumByFcodeNodeType(String settleListCode, String fIdCard, String address, String nodeType)
    throws Exception{
    	double settleSum = 0.0;
        DBManager dbManager = new DBManager();
        
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
    	try{
            dbManager.open("NXDADataSource");
            settleSum = blTemblorsettlelistAction.getSettleSumByFcodeNodeType(dbManager, settleListCode, fIdCard,address,nodeType);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return settleSum;
    }
    
    public void dumpByNodeType(String settleListCode, String nodeTypeFrom, String nodeTypeTo)
    throws Exception{
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            blTemblorsettlelistAction.dumpByNodeType(dbManager, settleListCode, nodeTypeFrom, nodeTypeTo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    


    
    public Collection getGroupedSumDataByFcode(String sqlCondition)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
        DBManager dbManager = new DBManager();
        BLTemblorsettlelistAction blTemblorsettlelistAction = new BLTemblorsettlelistAction();
        //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    	try{
            dbManager.open("NXDADataSource");
            resultList = blTemblorsettlelistAction.getGroupedSumDataByFcode(dbManager, sqlCondition);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return resultList;
    }
}

package com.gyic.claim.bl.facade;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxsettlelist;
import com.gyic.claim.bl.action.domain.BLNyxsettlelistAction;
import com.gyic.claim.bl.action.domain.BLPlanting31SettleListAction;
import com.gyic.claim.bl.action.domain.BLPlantingsettlelistAction;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����NYXSETTLELIST��ҵ���߼�����Facade����<br>
 */
public class BLNyxsettlelistFacadeBase{
    private static Logger logger = Logger.getLogger(BLNyxsettlelistFacadeBase.class);

    /**
     * ���캯��
     */
    public BLNyxsettlelistFacadeBase(){
    }

    /**
     * ����һ������
     * @param nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public void insert(NyxsettlelistDto nyxsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //�����¼
            blNyxsettlelistAction.insert(dbManager,nyxsettlelistDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    public void insert(List nyxSettleListDtoList)
    throws Exception{
    DBManager dbManager = new DBManager();
    BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
    
    try{
        dbManager.open("NXDADataSource");
        dbManager.beginTransaction();
        if(null!=nyxSettleListDtoList){
        	for(int i=0;i<nyxSettleListDtoList.size();i++){
        		NyxsettlelistDto nyxsettlelistDto = (NyxsettlelistDto)nyxSettleListDtoList.get(i);
	            //�����¼
        		blNyxsettlelistAction.insert(dbManager,nyxsettlelistDto);
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
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @throws Exception
     */
    public void delete(String settlelistcode,String fcode,String kindcode,String itemcode,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //ɾ����¼
            blNyxsettlelistAction.delete(dbManager,settlelistcode, fcode, kindcode, itemcode, nodetype, indexofsettle);
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
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //������ɾ����¼
            blNyxsettlelistAction.deleteByConditions(dbManager,conditions);
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
     * @param nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public void update(NyxsettlelistDto nyxsettlelistDto)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            dbManager.beginTransaction();
            //���¼�¼
            blNyxsettlelistAction.update(dbManager,nyxsettlelistDto);
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
     * @param itemcode ITEMCODE
     * @param nodetype NODETYPE
     * @param indexofsettle INDEXOFSETTLE
     * @return nyxsettlelistDto nyxsettlelistDto
     * @throws Exception
     */
    public NyxsettlelistDto findByPrimaryKey(String settlelistcode,String fcode,String kindcode,String itemcode,String nodetype,int indexofsettle)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        //����DTO
        NyxsettlelistDto nyxsettlelistDto = null;
        try{
            dbManager.open("NXDADataSource");
            //��ѯ����,��ֵ��DTO
            nyxsettlelistDto = blNyxsettlelistAction.findByPrimaryKey(dbManager,settlelistcode, fcode, kindcode, itemcode, nodetype, indexofsettle);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return nyxsettlelistDto;
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
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            pageRecord = blNyxsettlelistAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����nyxsettlelistDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
        throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blNyxsettlelistAction.findByConditions(dbManager,conditions);
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
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            sum = blNyxsettlelistAction.getSum(dbManager,conditions,fieldName);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return sum;
    }
    
    public void dumpByNodeType(String settleListCode, String nodeTypeFrom, String nodeTypeTo)
    throws Exception{
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
        try{
            dbManager.open("NXDADataSource");
            blNyxsettlelistAction.dumpByNodeType(dbManager, settleListCode, nodeTypeFrom, nodeTypeTo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    
    public Collection getGroupedSumData(String sqlCondition, boolean groupByKindCode, boolean groupByItemCode, boolean groupByLossRate, boolean groupByClaimRate)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction BLNyxsettlelistAction = new BLNyxsettlelistAction();
        //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    	try{
            dbManager.open("NXDADataSource");
            resultList = BLNyxsettlelistAction.getGroupedSumData(dbManager, sqlCondition, groupByKindCode, groupByItemCode, groupByLossRate, groupByClaimRate);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return resultList;
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
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blNyxsettlelistAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * ����ĳһũ����������
     * @param settleListCode �����嵥��
     * @param fIdCard ũ�����֤��
     * @return  result ���
     * @throws Exception
     */
    public double getSettleSumByFcodeNodeType(String settleListCode, String fIdCard, String nodeType)
    throws Exception{
    	double settleSum = 0.0;
        DBManager dbManager = new DBManager();
        
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
    	try{
            dbManager.open("NXDADataSource");
            settleSum = blNyxsettlelistAction.getSettleSumByFcodeNodeType(dbManager, settleListCode, fIdCard,nodeType);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return settleSum;
    }
    
    public int getMaxIndex(String conditions)
    throws Exception{
    int max=0;
    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    DBManager dbManager = new DBManager();
    BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
    //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    try{
        dbManager.open("NXDADataSource");
        max = blNyxsettlelistAction.getMaxIndex(dbManager,conditions);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return max;
}
    
    public double getDamageInsured(String conditions) 
    throws Exception{
	double rowCount=0;
    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    DBManager dbManager = new DBManager();
    BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
    //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    try{
        dbManager.open("NXDADataSource");
        rowCount = blNyxsettlelistAction.getDamageInsured(dbManager,conditions);
    }catch(Exception exception){
        throw exception;
    }finally{
        dbManager.close();
    }
    return rowCount;
}
    
    public Collection getGroupedSumDataByFcode(String sqlCondition)
    throws Exception{
    	
    	Collection resultList = new ArrayList();
        DBManager dbManager = new DBManager();
        BLNyxsettlelistAction blNyxsettlelistAction = new BLNyxsettlelistAction();
        //BLPlanting31SettleListAction blPlanting31SettleListAction = new BLPlanting31SettleListAction();
    	try{
            dbManager.open("NXDADataSource");
            resultList = blNyxsettlelistAction.getGroupedSumDataByFcode(dbManager, sqlCondition);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return resultList;
    }
}

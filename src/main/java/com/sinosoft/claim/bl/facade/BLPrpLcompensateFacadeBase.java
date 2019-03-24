package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLcompensateAction;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utility.database.DbPool;

/**
 * ����PrpLcompensate-����������ҵ���߼�����Facade����<br>
 * ������ 2005-03-18 17:53:38.375<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcompensateFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLcompensateFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcompensateFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public void insert(PrpLcompensateDto prpLcompensateDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLcompensateAction.insert(dbManager,prpLcompensateDto);
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
     * @param compensateNo �����������
     * @throws Exception
     */
    public void delete(String compensateNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLcompensateAction.delete(dbManager,compensateNo);
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
    public void deleteByConditions(String conditions) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLcompensateAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public void update(PrpLcompensateDto prpLcompensateDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLcompensateAction.update(dbManager,prpLcompensateDto);
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
     * @param compensateNo �����������
     * @return prpLcompensateDto prpLcompensateDto
     * @throws Exception
     */
    public PrpLcompensateDto findByPrimaryKey(String compensateNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        //����DTO
        PrpLcompensateDto prpLcompensateDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLcompensateDto = blPrpLcompensateAction.findByPrimaryKey(dbManager,compensateNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLcompensateDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,new ArrayList());

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLcompensateAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLcompensateDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLcompensateAction.findByConditions(dbManager,conditions);
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
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLcompensateAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * ���������嵥�������
     * @param conditions ��ѯ����
     *@param rowsPerPage ��¼������(rowsPerPage=0: ������)
     * @throws Exception
     */
    public Collection findByConditionsForNXDA(String conditions,int pageNo,int rowsPerPage) throws Exception{
        Collection collection = new ArrayList(rowsPerPage);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
        
        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open("NXDADataSource");
            collection = blPrpLcompensateAction.findByConditionsForNXDA(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return collection;
    }
    
    /**
     * ��ѯ���������������嵥�ļ�¼��
     * @param conditions conditions
     * @return ��ѯ���������������嵥��¼��
     * @throws Exception
     */
    public int getCountForNXDA(String conditions) 
        throws Exception{
        int rowCount= -1;

        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPrpLcompensateAction.getCountForNXDA(dbManager, conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    
    /**
     * ��ѯ�����嵥����Ķ��
     * @param conditions conditions
     * @return ��ѯ���������������嵥��Ķ��
     * @throws Exception
     */
    public double getSumSettleAreaForNXDA(String conditions) 
        throws Exception{
    	double rowCount= -1;

        DBManager dbManager = new DBManager();
        BLPrpLcompensateAction blPrpLcompensateAction = new BLPrpLcompensateAction();
        try{
            dbManager.open("NXDADataSource");
            rowCount = blPrpLcompensateAction.getSumSettleAreaForNXDA(dbManager, conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
    
    /**
     * ���� ��дSETTLELISTCODELIST  ��Ϣ����
     * @param registNo ������
     * @param claimNo  ������
     * @param compensateNo �������
     * @param relationNo �����嵥��
     * @throws Exception
     */
    public void update(String registNo,String claimNo,String compensateNo,String relationNo) throws Exception{
    	DbPool dbpool = new DbPool();
    	
    	  dbpool.open("NXDADataSource");
    	  try
    	  {
    	    dbpool.beginTransaction();
    	    String strSQL = " Update SETTLELISTCODELIST  Set" +
					        " reportcode = ?, " +
					        " registercode = ?, " +
					        " adjustmentcode = ? " +
					        " Where settlelistcode = ?";     

    	    int index=1;   
    	    dbpool.prepareStatement(strSQL);  
    	    dbpool.setString(index++,registNo); 
    	    dbpool.setString(index++,claimNo);
    	    dbpool.setString(index++,compensateNo);
            dbpool.setString(index++,relationNo); 
            dbpool.executePreparedUpdate(); 
            dbpool.closePreparedStatement();  
    	    dbpool.commitTransaction();
    	  }
    	  catch (Exception e)
    	  {
    	    dbpool.rollbackTransaction();
    	  }
    	  finally
    	  {
    	    dbpool.close();
    	  }
    }
}

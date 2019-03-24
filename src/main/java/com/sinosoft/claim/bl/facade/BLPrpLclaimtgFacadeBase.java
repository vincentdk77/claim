package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpLclaimtgAction;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimtgDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaim-����������Ϣ���ҵ���߼�����tgFacade����<br>
 * ������ 2005-03-18 17:53:38.359<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimtgFacadeBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimtgFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimtgFacadeBase(){
    }

    /**
     * ����һ������
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void insert(PrpLclaimtgDto prpLclaimtgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimtgAction blPrpLclaimtgAction = new BLPrpLclaimtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLclaimtgAction.insert(dbManager,prpLclaimtgDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    public boolean IsAutoClaim(String claimno)
    {
    	boolean result = false;
    	Collection collection = new ArrayList();

    	try
    	{
    		String statement = "Claimno='" + claimno + "' and autoflag='1'";
    		collection = findByConditions(statement);
    		
    		if(null != collection && collection.size() > 0)
    		{
    			result = true;
    		}
    		
    		
    	}
    	catch(Exception ex)
    	{
    		
    	}
    	
    	return result;
    }

    /**
     * ������ɾ��һ������
     * @param claimNo �ⰸ����
     * @throws Exception
     */
    public void delete(String claimNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimtgAction blPrpLclaimtgAction = new BLPrpLclaimtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //ɾ����¼
            blPrpLclaimtgAction.delete(dbManager,claimNo);
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
        BLPrpLclaimtgAction blPrpLclaimtgAction = new BLPrpLclaimtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //������ɾ����¼
            blPrpLclaimtgAction.deleteByConditions(dbManager,conditions);
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
     * @param prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public void update(PrpLclaimtgDto prpLclaimtgDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimtgAction blPrpLclaimtgAction = new BLPrpLclaimtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //���¼�¼
            blPrpLclaimtgAction.update(dbManager,prpLclaimtgDto);
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
     * @param claimNo �ⰸ����
     * @return prpLclaimDto prpLclaimDto
     * @throws Exception
     */
    public PrpLclaimtgDto findByPrimaryKey(String claimNo) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLclaimtgAction blPrpLclaimtgAction = new BLPrpLclaimtgAction();
        //����DTO
        PrpLclaimtgDto prpLclaimtgDto = null;
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            //��ѯ����,��ֵ��DTO
            prpLclaimtgDto = blPrpLclaimtgAction.findByPrimaryKey(dbManager,claimNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpLclaimtgDto;
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
        BLPrpLclaimtgAction blPrpLclaimtgAction = new BLPrpLclaimtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            pageRecord = blPrpLclaimtgAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
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
     * @return Collection ����prpLclaimDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        DBManager dbManager = new DBManager();
        BLPrpLclaimtgAction blPrpLclaimtgAction = new BLPrpLclaimtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            collection = blPrpLclaimtgAction.findByConditions(dbManager,conditions);
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
        BLPrpLclaimtgAction blPrpLclaimtgAction = new BLPrpLclaimtgAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpLclaimtgAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }
}

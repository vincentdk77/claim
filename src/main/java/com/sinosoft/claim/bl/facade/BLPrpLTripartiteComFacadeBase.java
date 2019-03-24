package com.sinosoft.claim.bl.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.bl.action.domain.BLPrpLTripartiteComAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLTripartiteComActionBase;
import com.sinosoft.claim.dto.domain.PrpLTripartiteComDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLTripartiteCom;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPDTRIPARTITECOM��ҵ���߼�����Facade����<br>
 */
public class BLPrpLTripartiteComFacadeBase {
	private static Logger logger = Logger.getLogger(BLPrpLTripartiteComFacadeBase.class);

    /**
     * ���캯��
     */
    public BLPrpLTripartiteComFacadeBase(){
    }
    
    /**
	  * ����һ������
	  * @param dbManager DB������
	  * @param prpCreditAssureDto prpCreditAssureDto
	  * @throws Exception
	  */
	  public void insert(PrpLTripartiteComDto prpLTripartiteComDto) throws Exception{
		  DBManager dbManager = new DBManager();
	      BLPrpLTripartiteComAction blPrpDTripartiteComAction = new BLPrpLTripartiteComAction();
	      try{
	    	  dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	          dbManager.beginTransaction();
	    	  blPrpDTripartiteComAction.insert(dbManager, prpLTripartiteComDto);
	    	  dbManager.commitTransaction();
	      }catch(Exception exception){
	            dbManager.rollbackTransaction();
	            throw exception;
	      }finally{
            dbManager.close();
	      }
	  }
	  
	  public void insertAll(Collection<PrpLTripartiteComDto> prpLTripartiteComDtos) throws Exception{
		  DBManager dbManager = new DBManager();
		  BLPrpLTripartiteComAction blPrpDTripartiteComAction = new BLPrpLTripartiteComAction();
			try{
				dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
				dbManager.beginTransaction();
				blPrpDTripartiteComAction.insertAll(dbManager, prpLTripartiteComDtos);
				dbManager.commitTransaction();
		      }catch(Exception exception){
		            dbManager.rollbackTransaction();
		            throw exception;
		      }finally{
	            dbManager.close();
		      }
	  }
    
    /**
     * ��������
     * @param enterpriseCode ��ҵ����
     * @param approveFlag ����״̬
     * @param suggestion �������
     * @throws Exception
     */
    public void update(String enterpriseCode,String approveFlag,String suggestion) throws Exception{
    	 DBManager dbManager = new DBManager();
         BLPrpLTripartiteComAction blPrpDTripartiteComAction = new BLPrpLTripartiteComAction();
         try{
        	 dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
             dbManager.beginTransaction();
             blPrpDTripartiteComAction.update(dbManager, enterpriseCode, approveFlag, suggestion);
             dbManager.commitTransaction();
	      }catch(Exception exception){
	            dbManager.rollbackTransaction();
	            throw exception;
	      }finally{
           dbManager.close();
	      }
    }
    /**
     * ��ѯ����
     * @param enterpriseCode ��ҵ����
     * @param prpLTripartiteComDto ����
     * @throws Exception
     */
    public void update(String enterpriseCode,PrpLTripartiteComDto prpLTripartiteComDto) throws Exception{
   	 DBManager dbManager = new DBManager();
        BLPrpLTripartiteComAction blPrpLTripartiteComAction = new BLPrpLTripartiteComAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
            blPrpLTripartiteComAction.update(dbManager, enterpriseCode,prpLTripartiteComDto);
            dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    public void delete(String enterpriseCode)throws Exception{
    	DBManager dbManager = new DBManager();
    	BLPrpLTripartiteComAction blPrpLTtripartiteComAction = new BLPrpLTripartiteComAction();
    	try{
    		dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            dbManager.beginTransaction();
    		blPrpLTtripartiteComAction.delete(dbManager,enterpriseCode);
    		dbManager.commitTransaction();
        }catch(Exception exception){
            dbManager.rollbackTransaction();
            throw exception;
        }finally{
            dbManager.close();
        }
    }
    
    public Collection findConditions(String conditions)throws Exception{
		  Collection collection = new ArrayList();
		  if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }
		  DBManager dbManager = new DBManager();
		  BLPrpLTripartiteComAction blPrpDTripartiteComAction = new BLPrpLTripartiteComAction();
		  try{
			  dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			  collection = blPrpDTripartiteComAction.findConditions(dbManager,conditions);
		  }catch(Exception exception){
	            throw exception;
	      }finally{
	            dbManager.close();
	      }
		  return collection;
	  }
    
    public Collection findTripartiteInfoByConditions(String conditions)throws Exception{
		  Collection collection = new ArrayList();
		  if(conditions.trim().length()==0){
	            conditions = "1=1";
	        }
		  DBManager dbManager = new DBManager();
		  BLPrpLTripartiteComAction blPrpDTripartiteComAction = new BLPrpLTripartiteComAction();
		  try{
			  dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			  collection = blPrpDTripartiteComAction.findTripartiteInfoByConditions(dbManager,conditions);
		  }catch(Exception exception){
	            throw exception;
	      }finally{
	            dbManager.close();
	      }
		  return collection;
	  }
    
    public PrpLTripartiteComDto findByKeys(String conditions) throws Exception{
    	PrpLTripartiteComDto prpLTripartiteComDto = new PrpLTripartiteComDto();
    	DBManager dbManager = new DBManager();
        BLPrpLTripartiteComAction blPrpDTripartiteComAction = new BLPrpLTripartiteComAction();
    	if(conditions.trim().length()==0){
            conditions = "1=1";
        }
    	try{
    		dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    		prpLTripartiteComDto = blPrpDTripartiteComAction.findByKeys(dbManager,conditions);
    	}catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
    	return prpLTripartiteComDto;
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
        BLPrpLTripartiteComAction blPrpDTripartiteComAction = new BLPrpLTripartiteComAction();
        try{
        	dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
            pageRecord = blPrpDTripartiteComAction.findByConditions(dbManager,conditions,pageNo,rowsPerPage);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return pageRecord;
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
        BLPrpLTripartiteComAction blPrpDTripartiteComAction = new BLPrpLTripartiteComAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            rowCount = blPrpDTripartiteComAction.getCount(dbManager,conditions);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return rowCount;
    }

}

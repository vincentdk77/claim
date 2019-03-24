package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLinjuryPersonDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLinjuryFacadeBase {
	 private static Log logger = LogFactory.getLog(BLPrpLregistFacadeBase.class);
	 public BLPrpLinjuryFacadeBase(){
	    }
	 /**
     * ����һ������
     * @param prpLregistDto prpLregistDto
     * @throws Exception
     */
     public void insert(PrpLinjuryPersonDto prpLinjuryPersonDto) throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpLinjurypersonAction blPrpLinjurypersonAction = new BLPrpLinjurypersonAction();
        try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            dbManager.beginTransaction();
            //�����¼
            blPrpLinjurypersonAction.insert(dbManager,prpLinjuryPersonDto);
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
      * @throws Exception
      */
     public void delete(String CompensateNo)
         throws Exception{
    	 DBManager dbManager = new DBManager();
         BLPrpLinjurypersonAction bLPrpLinjurypersonAction = new BLPrpLinjurypersonAction();
         //����DTO
         PrpLinjuryPersonDto prpLinjuryPersonDto = null;
         try{
         	dbManager.open(AppConfig.get("sysconst.DBJNDI"));
             dbManager.beginTransaction();
             //ɾ����¼
             bLPrpLinjurypersonAction.delete(dbManager, CompensateNo);
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
      * @param registNo ��������
      * @return prpLregistDto prpLregistDto
      * @throws Exception
      */
     public PrpLinjuryPersonDto findByPrimaryKey(String CompensateNo) throws Exception{
         DBManager dbManager = new DBManager();
         BLPrpLinjurypersonAction bLPrpLinjurypersonAction = new BLPrpLinjurypersonAction();
         //����DTO
         PrpLinjuryPersonDto prpLinjuryPersonDto = null;
         try{
             dbManager.open(AppConfig.get("sysconst.DBJNDI"));
             //��ѯ����,��ֵ��DTO
             prpLinjuryPersonDto = bLPrpLinjurypersonAction.findByPrimaryKey(dbManager, CompensateNo);
         }catch(Exception exception){
             throw exception;
         }finally{
             dbManager.close();
         }
         return prpLinjuryPersonDto;
     }
     
     public Collection findByCondition(String compeNo)throws SQLException,Exception{
    	 DBManager dbManager = new DBManager();
    	 Collection injuryPersonList = new ArrayList();
    	 BLPrpLinjurypersonAction bLPrpLinjurypersonAction = new BLPrpLinjurypersonAction();
    	 try{
    		 dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    		 injuryPersonList = bLPrpLinjurypersonAction.findByCondition(dbManager,compeNo);
    	 }catch (SQLException sqle) {
    		 throw sqle;
    	 }catch(Exception e){
    		 throw e;
    	 }finally{
    		 dbManager.close();
    	 }
    	 return injuryPersonList;
     }
}

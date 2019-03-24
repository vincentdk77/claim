package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLPrpCinsuredAction;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCinsured;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


public class BLPrpCinsuredFacade{
    private static Log logger = LogFactory.getLog(BLPrpCinsuredNatureFacadeBase.class);

    /**
     * ����������һ������
     * @param policyNo PolicyNo
     * @return prpCinsuredNatureDto prpCinsuredNatureDto
     * @throws Exception
     */
    public PrpCinsuredDto findByPrimaryKey(String policyNo,int serialNo)
        throws Exception{
        DBManager dbManager = new DBManager();
        BLPrpCinsuredAction blPrpCinsuredAction = new BLPrpCinsuredAction();
        //����DTO
        PrpCinsuredDto prpCinsuredDto = null;
        try{
            dbManager.open("claimDataSource");
            //��ѯ����,��ֵ��DTO
            prpCinsuredDto = blPrpCinsuredAction.findByPrimaryKey(dbManager,policyNo,serialNo);
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return prpCinsuredDto;
    }

    public Collection findByConditions(String conditions) throws Exception
	  {
	     DBManager dbManager = new DBManager();
	     PrpCinsuredDto PrpCinsuredDto = null;
	     Collection prpCinsuredList = new ArrayList();
	     try
	     {
	       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	       BLPrpCinsuredAction blPrpCinsuredAction = new BLPrpCinsuredAction();
	       prpCinsuredList = (Collection)blPrpCinsuredAction.findByConditions(dbManager,conditions,0,0);
	     }
	     catch(SQLException sqle)
	     {
	       throw sqle;
	     }
	     catch (Exception ex) {
	       throw ex;
	     }
	     finally
	     {
	       dbManager.close();
	     }
	     return prpCinsuredList;
	  }
    /**
     * ��prpcvirturlitem����ȡ������ֻ��ĵ���Ϣ
     * @param  conditions ���������ŵĲ�ѯ����
     * @return
     * @throws Exception
     */
    public Collection findVirturlItemByConditions(String conditions) throws Exception {
		DBManager dbManager = new DBManager();
		PrpCinsuredDto PrpCinsuredDto = null;
		Collection prpCinsuredVirturlItemList = new ArrayList();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLPrpCinsuredAction blPrpCinsuredAction = new BLPrpCinsuredAction();
			prpCinsuredVirturlItemList = (Collection) blPrpCinsuredAction
					.findVirturlItemByConditions(dbManager, conditions, 0, 0);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return prpCinsuredVirturlItemList;
	}
    /**
     * ��prpcvirturlItem����ȡ���ɲ���ϱ��յ�����
     * @param conditions
     * @return
     * @throws Exception
     */
    public Collection findViturlItemDtoByConditions(String conditions) throws Exception {
		DBManager dbManager = new DBManager();
		PrpCinsuredDto PrpCinsuredDto = null;
		Collection prpCinsuredVirturlItemList = new ArrayList();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLPrpCinsuredAction blPrpCinsuredAction = new BLPrpCinsuredAction();
			prpCinsuredVirturlItemList = (Collection) blPrpCinsuredAction
					.findViturlItemDtoByConditions(dbManager, conditions, 0, 0);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return prpCinsuredVirturlItemList;
	}
    
    /**
     * ��prpcvirturlitem����ȡ������ֻ�����������Ϣ
     * @param  conditions ���������ŵĲ�ѯ����
     * @return
     * @throws Exception
     */
    public Collection findVirturlItemBeneInsuredConditions(String conditions) throws Exception {
		DBManager dbManager = new DBManager();
		
		Collection VirturlItemBeneInsured = new ArrayList();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
			VirturlItemBeneInsured = (Collection) dbPrpCinsured
					.findVirturlItemBeneInsured(conditions);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return VirturlItemBeneInsured;
	}

    public String getIdentifyNumber(String conditions) throws Exception {
		return new BLPrpCinsuredAction().getIdentifyNumber(conditions);
	}  
    
    /**
     * ��ũ�գ���ֲ��ũ���嵥��Ϣ��ѯչʾ�¹���
     * @param conditions
     * @return
     * @throws Exception
     */
    public Collection findByOldPlantingConditions(String conditions) throws Exception
	  {
	     DBManager dbManager = new DBManager();
	     PrpCinsuredDto PrpCinsuredDto = null;
	     Collection prpCinsuredList = new ArrayList();
	     try
	     {
	       dbManager.open("NXDADataSource");
	       BLPrpCinsuredAction blPrpCinsuredAction = new BLPrpCinsuredAction();
	       prpCinsuredList = (Collection)blPrpCinsuredAction.findByPlantingConditions(dbManager,conditions,0,0);
	     }
	     catch(SQLException sqle)
	     {
	       throw sqle;
	     }
	     catch (Exception ex) {
	       throw ex;
	     }
	     finally
	     {
	       dbManager.close();
	     }
	     return prpCinsuredList;
	  }
    /**
     * ��ũ�գ���ֲ��ũ���嵥��Ϣ��ѯչʾ�¹���
     * @param conditions
     * @return
     * @throws Exception
     */
    public Collection findByNewPlantingConditions(String conditions) throws Exception
	  {
	     DBManager dbManager = new DBManager();
	     PrpCinsuredDto PrpCinsuredDto = null;
	     Collection prpCinsuredList = new ArrayList();
	     try
	     {
	       dbManager.open("NewNXDADataSource");
	       BLPrpCinsuredAction blPrpCinsuredAction = new BLPrpCinsuredAction();
	       prpCinsuredList = (Collection)blPrpCinsuredAction.findByPlantingConditions(dbManager,conditions,0,0);
	     }
	     catch(SQLException sqle)
	     {
	       throw sqle;
	     }
	     catch (Exception ex) {
	       throw ex;
	     }
	     finally
	     {
	       dbManager.close();
	     }
	     return prpCinsuredList;
	  }
}

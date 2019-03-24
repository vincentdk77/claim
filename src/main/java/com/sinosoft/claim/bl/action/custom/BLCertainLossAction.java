package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBCertainLoss;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertainLoss;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * ����action
 * <p>Title: �������� ����acton</p>
 * <p>Description: �������� ����acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCertainLossAction
{
  public BLCertainLossAction()
  {
  }

  /**
   * ���涨��
   * @param certainLossDto���Զ��嶨�����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,CertainLossDto certainLossDto)
    throws SQLException,Exception
  {
      DBCertainLoss dbCertainLoss = null;
      //ҵ�����
      dbCertainLoss = new DBCertainLoss();
      dbCertainLoss.insert(dbManager,certainLossDto);
  }

  /**
   * ɾ������
   * @param  registNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
      //ҵ�����
      new DBCertainLoss().delete(dbManager,registNo);
  }

  /**
   * ��ö���
   * @param  registNo
   * @param dbManager  ��������
   * @return �Զ��嶨�����
   * @throws SQLException
   * @throws Exception
   */
  public CertainLossDto findByPrimaryKey(DBManager dbManager,String registNo,String lossItemCode)
    throws SQLException,Exception
  {
    CertainLossDto certainLossDto = null;
    certainLossDto = new DBCertainLoss().findByPrimaryKey(dbManager,registNo,lossItemCode);
    return certainLossDto;
  }

  /**
   * �жϱ������Ƿ����
   * @param registNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String registNo,String lossItemCode)throws SQLException,Exception
  {
           if (new DBCertainLoss().findByPrimaryKey(dbManager,registNo,lossItemCode) == null)
      {
        return false;
      }else
      {
        return true;
      }
  }

  /**
   * ��������ѯ��������
   * @param dbManager DBManager
   * @param conditions String
   * @param pageNo int
   * @param rowsPerPage int
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */
  public Collection findByQueryConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcertainLoss.findByQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
  }

  /**
   * ��ö���
   * @param  registNo
   * @param dbManager  ��������
   * @return �Զ��嶨�����
   * @throws SQLException
   * @throws Exception
   */

  public CertainLossDto findByPrimaryKey(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    CertainLossDto certainLossDto = null;
    certainLossDto = new DBCertainLoss().findByPrimaryKey(dbManager,registNo);
    return certainLossDto;
  }
  
  //add by zhaolu 20060803 start
  public PageRecord findByCondition(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
	    DBPrpLcertainLoss dbPrpLcertainLoss = new DBPrpLcertainLoss(dbManager);
	    Collection collection = new ArrayList();
	    
	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
	    //add by zhaolu 20060729 start
	    int count = dbPrpLcertainLoss.getCount1(SqlUtils.getWherePartForGetCount(conditions));
	    int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
	    if(maxQueryCount!=0&&count>maxQueryCount){   
	      throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
	    }
	    
	    collection = dbPrpLcertainLoss.findByQueryConditions(conditions,pageNo,rowsPerPage);
	    PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	    //add by zhaolu 20060729 end
	    
	    
	    return pageRecord;
	  }
  //add by zhaolu 20060803 end

}

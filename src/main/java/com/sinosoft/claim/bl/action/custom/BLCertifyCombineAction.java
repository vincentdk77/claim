package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.CertifyDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBCertify;
import com.sinosoft.claim.resource.dtofactory.custom.DBCertifyCombine;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyCollect;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��֤action
 * <p>Title: �������� ��֤acton</p>
 * <p>Description: �������� ��֤acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLCertifyCombineAction
{
  public BLCertifyCombineAction()
  {
  }

  /**
   * ���浥֤
   * @param certifyDto���Զ��嵥֤����
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,CertifyDto certifyDto)
    throws SQLException,Exception
  {
	  DBCertifyCombine dBCertifyCombine = null;
      //ҵ�����
	  dBCertifyCombine = new DBCertifyCombine();
	  dBCertifyCombine.insert(dbManager,certifyDto);

  }

  /**
   * ɾ����֤
   * @param  certifyNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(DBManager dbManager,String certifyNo)
    throws SQLException,Exception
  {
      //ҵ�����
      new DBCertify().delete(dbManager,certifyNo);
  }

  /**
   * ��õ�֤
   * @param  certifyNo
   * @param dbManager  ��������
   * @return �Զ��嵥֤����
   * @throws SQLException
   * @throws Exception
   */
  public CertifyDto findByPrimaryKey(DBManager dbManager,String registNo)
    throws SQLException,Exception
  {
    CertifyDto certifyDto = null;
    certifyDto = new DBCertify().findByPrimaryKey(dbManager,registNo);
    return certifyDto;
  }
  /**
   * �жϵ�֤֪ͨ���Ƿ����
   * @param certifyNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String certifyNo)throws SQLException,Exception
  {
     if (new DBCertify().findByPrimaryKey(dbManager,certifyNo) == null)
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
    DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLcertifyCollect.findByQueryConditions(conditions,pageNo,rowsPerPage);
    return collection;
    }
  
  //add by zhaolu 20060803 start
  public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
	    DBPrpLcertifyCollect dbPrpLcertifyCollect = new DBPrpLcertifyCollect(dbManager);
	    Collection collection = new ArrayList();

	    if(conditions.trim().length()==0){
	        conditions = "1=1";
	    }
      collection = dbPrpLcertifyCollect.findByQueryConditions(conditions,pageNo,rowsPerPage);
      int count = dbPrpLcertifyCollect.getCount1(SqlUtils.getWherePartForGetCount(conditions));
      int maxQueryCount=Integer.parseInt(DataUtils.nullToZero(AppConfig.get("sysconst.MaxQueryCount")));
      if(maxQueryCount!=0&&count>maxQueryCount){   
        throw new UserException(1,3,"0000","��ѯ�����������ϵͳ����"); 
      }
      
	  PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
	  return pageRecord;
	 
	    }
  //add by zhaolu 20060803 end

}

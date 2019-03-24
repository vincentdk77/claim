package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.EndorDto;
import com.sinosoft.claim.dto.domain.PrpLendorDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLendor;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����������ݿ�������
 * <p>Title: �����������������ݹ���</p>
 * <p>Description: �����������������ݹ���</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class DBEndor
{
  private DBManager dbManager = null; //��Դ������

  /**
   * ���캯��
   * @param dbManager ��Դ������
   */
  public DBEndor()
  {

  }

  /**
   * �������淽��
   *@param endorDto ����������
   * @throws SQLException
   * @throws Exception
   *@return ��
   */
  public void insert(DBManager dbManager,EndorDto endorDto)
    throws SQLException,Exception
  {
    if(endorDto.getPrpLendorList()!=null ){
    	for(int i=0;i<endorDto.getPrpLendorList().size();i++)
    	{
		    PrpLendorDto prpLendor =  (PrpLendorDto)endorDto.getPrpLendorList().get(i);
		    String condition = " claimNo = " + "'" + prpLendor.getClaimNo() + "' and COMPENSATENO = " + "'" + prpLendor.getCompensateNo() +"' and endorType = "+ "'" + prpLendor.getEndorType() +"'";
		    String statement = " DELETE FROM PrpLendor Where " + condition;
		    dbManager.executeUpdate(statement);
    	}
    new DBPrpLendor(dbManager).insertAll(endorDto.getPrpLendorList());
    }
  }
}



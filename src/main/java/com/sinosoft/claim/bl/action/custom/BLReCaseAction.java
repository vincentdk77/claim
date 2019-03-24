package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBReCase;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrecase;
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
public class BLReCaseAction
{
  public BLReCaseAction() 
  {
  }

 
  public void save(DBManager dbManager,ReCaseDto reCaseDto)
    throws SQLException,Exception
  {
      DBReCase dbReCase = null;
      //DBSwfLog dbSwfLog = null;
      //ҵ�����
      dbReCase = new DBReCase();
      dbReCase.insert(dbManager,reCaseDto);
  
  }
  public void savePrpLrecase(DBManager dbManager,ReCaseDto reCaseDto)
  throws SQLException,Exception
{
    DBReCase dbReCase = null;
    //DBSwfLog dbSwfLog = null;
    //ҵ�����
    dbReCase = new DBReCase();
    //modify by lixiang  start at 2006-6-7
    //reason:action�ķ���Ӧ�ñȽ�רһ��Ӧ���ɹ���������Լ��Ĳ���
    dbReCase.insert(dbManager,reCaseDto);
    //modify by lixiang  end at 2006-6-7
    
    
}


 
  public ReCaseDto findByPrimaryKey(DBManager dbManager,String claimNo,int serialNo)
    throws SQLException,Exception
  {
    ReCaseDto reCaseDto = null;
    reCaseDto = new DBReCase().findByPrimaryKey(dbManager,claimNo,serialNo);
    return reCaseDto;
  }
  
  public int getMaxSerialNo(DBManager dbManager,String claimNo)
  throws Exception{
  DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
  String conditions =" claimNo ='"+claimNo+"'";
  
  int serialNo = dbPrpLrecase.getCount(conditions);
  return serialNo;
}
 
  public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
    DBPrpLrecase dbPrpLrecase = new DBPrpLrecase(dbManager);
    Collection collection = new ArrayList();

    if(conditions.trim().length()==0){
        conditions = "1=1";
    }

    collection = dbPrpLrecase.findByConditions(conditions,pageNo,rowsPerPage);
    return collection;
    }
}

package com.sinosoft.claim.bl.action.custom;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.resource.dtofactory.custom.DBPersonLimit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 人员权限查询action
 * <p>Title: 人员权限查询acton</p>
 * <p>Description: 人员权限查询acton</p>
 * <p>Copyright: Copyright (c) 2005/11/15</p>
 * <p>Company: Sinosoft</p>
 * @author qinyongli
 * @version 1.0
 */
public class BLPersonLimitAction {
 
    public BLPersonLimitAction()
      {
      }
    
    /**
     * 
     * @param dbManager
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
    public Collection findByQueryConditions(DBManager dbManager,String conditions) throws Exception{
        DBPersonLimit dbPersonLimit = new DBPersonLimit();
      Collection collection = new ArrayList();

      if(conditions.trim().length()==0){
          conditions = "1=1";
      }

      collection = dbPersonLimit.findByConditions(dbManager,conditions);
      return collection;
  }
    
    
    
    
}
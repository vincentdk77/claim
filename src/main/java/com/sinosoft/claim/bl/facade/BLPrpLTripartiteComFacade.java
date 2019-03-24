package com.sinosoft.claim.bl.facade;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.domain.BLPrpLTripartiteComAction;
import com.sinosoft.claim.dto.domain.PrpLTripartiteComDto;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 这是PRPDTRIPARTITECOM的业务对象Facade类<br>
 * 创建于 JToolpad(1.6.0) 
 */
public class BLPrpLTripartiteComFacade extends BLPrpLTripartiteComFacadeBase{
    private static Logger logger = Logger.getLogger(BLPrpLTripartiteComFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLTripartiteComFacade(){
        super();
    }
    
    public Collection findSql(String sql)throws Exception{
		  Collection collection = new ArrayList();
		  if(sql.trim().length()==0){
			  sql = "1=1";
	        }
		  DBManager dbManager = new DBManager();
		  BLPrpLTripartiteComAction blPrpDTripartiteComAction = new BLPrpLTripartiteComAction();
		  try{
			  dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			  collection = blPrpDTripartiteComAction.findSql(dbManager,sql);
		  }catch(Exception exception){
	            throw exception;
	      }finally{
	            dbManager.close();
	      }
		  return collection;
	  }

}


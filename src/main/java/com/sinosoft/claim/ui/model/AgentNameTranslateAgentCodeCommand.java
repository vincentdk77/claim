/**
 * add by wangli start 20050416
 */
package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.sysframework.web.model.BaseCommand;

import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import com.sinosoft.function.insutil.bl.action.domain.BLPrpDidentifierAction;


public class AgentNameTranslateAgentCodeCommand extends BaseCommand {
	
	  private String agentCode = "";

	  public AgentNameTranslateAgentCodeCommand()  throws Exception {  
	  }
	  
	  public AgentNameTranslateAgentCodeCommand(String agentCode)  throws Exception
	  {
	      this.agentCode = agentCode;     
	  }
	  public Object executeCommand() throws Exception
	  {
	      String agentName = "";
	      BLCodeFacade blCodeFacade = new BLCodeFacade();
	      agentName = blCodeFacade.translateAgentName(agentCode) ;
	      
	      return agentName;
	  }
	  
	  public Collection translateCheckAgentCodeToName(String strCheckAgentCodeSQL) throws SQLException,Exception {
	  	Collection prpDidentifierList = new ArrayList();
	  	BLPrpDidentifierAction bLPrpDidentifierAction = new BLPrpDidentifierAction();
	  	DBManager dbManager = new DBManager();
	    try
	      {
	         dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	  	     prpDidentifierList =  bLPrpDidentifierAction.findByConditions(dbManager, strCheckAgentCodeSQL);
	      }
	      catch (Exception ex)
	      {
	         throw ex;
	      }
	      finally
	      {
	         dbManager.close();
	      }
	  	  return prpDidentifierList;
	  }
}

package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDagentDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdagent代理人代码表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDagent extends DBPrpDagentBase{
    private static Log log = LogFactory.getLog(DBPrpDagent.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDagent(DBManager dbManager){
        super(dbManager);
    }
    
  //modify by wangli add start 20050416
    /** 根据代理人代码得到代理人姓名
     * @param agentCode 代理人代码
     */
  public String translateAgentName(String agentCode)
    throws SQLException,Exception
    {
    	PrpDagentDto prpDagentDto = new PrpDagentDto();	
    	prpDagentDto = this.findByPrimaryKey(agentCode);
    	if(prpDagentDto==null)
    	{
    		return "" ;
    	}
    	return prpDagentDto.getAgentName();
    
    }
    
 //  modify by wangli add start 20050416
    
}

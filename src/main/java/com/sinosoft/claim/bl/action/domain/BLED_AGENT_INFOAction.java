package com.sinosoft.claim.bl.action.domain;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.ED_AGENT_INFODto;
import com.sinosoft.claim.resource.dtofactory.domain.DBED_AGENT_INFO;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是座席员工信息表的业务对象扩展类<br>
 * 创建于 2005-07-19 09:59:01.623<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLED_AGENT_INFOAction extends BLED_AGENT_INFOActionBase{
    private static Log logger = LogFactory.getLog(BLED_AGENT_INFOAction.class);

    /**
     * 构造函数
     */
    public BLED_AGENT_INFOAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,ED_AGENT_INFODto eD_AGENT_INFODto,String mode) throws Exception{
    }
    
     /**
   * 判断工号是否存在
   * @param registNo
   * @param password
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(DBManager dbManager,String agentid,String password)throws SQLException,Exception
  {   
      DBED_AGENT_INFO dbED_AGENT_INFO = new DBED_AGENT_INFO(dbManager);
     
      String strSql ="AGENTID='"+ agentid+"' and AGENTPSWD='"+password+"'";
      
      if(dbED_AGENT_INFO.getCount(strSql)<1)
      {
        return false;
      }else
      {
        return true;
      }
  }
  
}

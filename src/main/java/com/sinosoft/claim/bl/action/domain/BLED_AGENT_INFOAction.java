package com.sinosoft.claim.bl.action.domain;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.ED_AGENT_INFODto;
import com.sinosoft.claim.resource.dtofactory.domain.DBED_AGENT_INFO;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ������ϯԱ����Ϣ���ҵ�������չ��<br>
 * ������ 2005-07-19 09:59:01.623<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLED_AGENT_INFOAction extends BLED_AGENT_INFOActionBase{
    private static Log logger = LogFactory.getLog(BLED_AGENT_INFOAction.class);

    /**
     * ���캯��
     */
    public BLED_AGENT_INFOAction(){
        super();
    }

    /**
     * ת��Dto
     * @param dbManager dbManager
     * @param eD_AGENT_INFODto eD_AGENT_INFODto
     * @param mode ģʽ
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,ED_AGENT_INFODto eD_AGENT_INFODto,String mode) throws Exception{
    }
    
     /**
   * �жϹ����Ƿ����
   * @param registNo
   * @param password
   * @param dbManager  ��������
   * @return ��/��
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

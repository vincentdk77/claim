package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDagentDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdagent�����˴��������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDagent extends DBPrpDagentBase{
    private static Log log = LogFactory.getLog(DBPrpDagent.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDagent(DBManager dbManager){
        super(dbManager);
    }
    
  //modify by wangli add start 20050416
    /** ���ݴ����˴���õ�����������
     * @param agentCode �����˴���
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

package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcustomerUnitDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpDcustomerUnit��λ�ͻ����������ݷ��ʶ�����չ��<br>
 * ������ 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDcustomerUnit extends DBPrpDcustomerUnitBase{
    private static Log log = LogFactory.getLog(DBPrpDcustomerUnit.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDcustomerUnit(DBManager dbManager){
        super(dbManager);
    }
    
    //modify by wangli add start 20050602
    /** ���ݿͻ�����õ��ͻ�����
     * @param agentCode �ͻ�����
     */
  public String translateCustomerCName(String customerCode)
    throws SQLException,Exception
    {
  	    PrpDcustomerUnitDto prpDcustomerUnitDto = new PrpDcustomerUnitDto();	
  	    prpDcustomerUnitDto = this.findByPrimaryKey(customerCode);
    	if(prpDcustomerUnitDto==null)
    	{
    		return "" ;
    	}
    	return prpDcustomerUnitDto.getCustomerCName();
    
    }
    
 //  modify by wangli add start 20050602
}

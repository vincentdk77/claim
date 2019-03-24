package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCinsured;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcinsured保险关系人表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCinsuredAction extends BLPrpCinsuredActionBase{
    private static Log log = LogFactory.getLog(BLPrpCinsuredAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpCinsuredAction(){
        super();
    }

//modify by liuyanmei add 20051108 start 
    public String getIdentifyNumber(String conditions)
    throws Exception
{
	String identifyNumber = "";
	DBManager dbManager = new DBManager();
	
	try {    
	    dbManager.open(AppConfig.get("sysconst.DBJNDI"));
	
	    PrpCinsuredDto prpCinsuredDto = null;
	   	DBPrpCinsured dbPrpCinsured = new DBPrpCinsured(dbManager);
	   	
	   	identifyNumber = dbPrpCinsured.getIdentifyNumber(conditions);
	  
 } catch (Exception ex) {
     throw ex;
 } finally {
     dbManager.close();
 }
 
	return identifyNumber;
}
//  modify by liuyanmei add 20051108 end
    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpCinsuredDto prpCinsuredDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpCinsuredDto prpCinsuredDto,String mode) throws Exception{
    }
}

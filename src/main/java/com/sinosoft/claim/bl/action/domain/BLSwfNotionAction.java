package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfNotionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfNotion;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是工作流意见处理表的业务对象扩展类<br>
 * 创建于 2005-04-05 10:45:04.515<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfNotionAction extends BLSwfNotionActionBase{
    private static Log logger = LogFactory.getLog(BLSwfNotionAction.class);

    /**
     * 构造函数
     */
    public BLSwfNotionAction(){
        super();
    }
    
    /**
     * 查询flowID的最大Lineno的值
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return flowID
     * @throws Exception
     */
    public int getMaxLineNo(DBManager dbManager,String flowID,int logNo)
        throws Exception{
        DBSwfNotion dbSwfNotion = new DBSwfNotion(dbManager);

        int lineNo = dbSwfNotion.getMaxLineNo(flowID, logNo);
        return lineNo;
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param swfNotionDto swfNotionDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfNotionDto swfNotionDto,String mode) throws Exception{
    }
}

package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPathLog;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WFPATHLOG工作流路径日志表的业务对象扩展类<br>
 * 创建于 2004-08-09 19:54:55.016<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfPathLogAction extends BLSwfPathLogActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPathLogAction.class);

    /**
     * 构造函数
     */
    public BLSwfPathLogAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param swfPathLogDto swfPathLogDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfPathLogDto swfPathLogDto,String mode) throws Exception{
    }
    
     /**
     * 查询flowID的最大logno的值
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return flowID
     * @throws Exception
     */
    public int getMaxPathNo(DBManager dbManager,String flowID) 
        throws Exception{
        DBSwfPathLog dbSwfPathLog = new DBSwfPathLog(dbManager);

        int PathNo = dbSwfPathLog.getMaxPathNo(flowID);
        return PathNo;
    }
}

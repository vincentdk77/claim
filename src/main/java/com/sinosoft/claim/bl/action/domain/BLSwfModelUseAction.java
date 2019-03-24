package com.sinosoft.claim.bl.action.domain;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfModelUse;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WfModelUse模板使用设置的业务对象扩展类<br>
 * 创建于 2004-08-10 10:49:28.712<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfModelUseAction extends BLSwfModelUseActionBase{
    private static Log logger = LogFactory.getLog(BLSwfModelUseAction.class);

    /**
     * 构造函数
     */
    public BLSwfModelUseAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param wfModelUseDto wfModelUseDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,SwfModelUseDto swfModelUseDto,String mode) throws Exception{
    }

    /**
     * 插入多条数据
     * @param dbManager DB管理器
     * @param wfModelUseDto wfModelUseDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection modelUseList) throws Exception{
        DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //插入记录
        dbSwfModelUse.insertAll(modelUseList);
    }

    public void deleteAll(DBManager dbManager,Collection modelUseList) throws Exception
    {
      DBSwfModelUse dbSwfModelUse = new DBSwfModelUse(dbManager);
        //删除记录
        dbSwfModelUse.deleteAllBatch(modelUseList);

    }

}

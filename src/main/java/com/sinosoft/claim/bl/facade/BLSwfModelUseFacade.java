package com.sinosoft.claim.bl.facade;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.action.domain.BLSwfModelMainAction;
import com.sinosoft.claim.bl.action.domain.BLSwfModelUseAction;
import com.sinosoft.claim.dto.domain.SwfModelUseDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WfModelUse模板使用设置的业务对象Facade类 <br>
 * 创建于 2004-08-10 10:49:29.683 <br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLSwfModelUseFacade extends BLSwfModelUseFacadeBase {
    private static Log logger = LogFactory.getLog(BLSwfModelUseFacade.class);

    /**
     * 构造函数
     */
    public BLSwfModelUseFacade() {
        super();
    }

    /**
     * 插入一条数据
     * 
     * @param wfModelUseDto wfModelUseDto
     * @throws Exception
     */
    public void insertAll(SwfModelUseDto swfModelUseDto) throws Exception {
        DBManager dbManager = new DBManager();
        BLSwfModelUseAction blSwfModelUseAction = new BLSwfModelUseAction();
        try {
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));

            int modelNo = ((SwfModelUseDto) swfModelUseDto.getModelUseList().iterator().next()).getModelNo();
            //整理数据
            String modelType = new BLSwfModelMainAction().findByPrimaryKey(dbManager, modelNo).getModelType();

            dbManager.beginTransaction();
            StringBuffer conditions = new StringBuffer();
            for (Iterator iter = swfModelUseDto.getModelUseList().iterator(); iter.hasNext();) {
                SwfModelUseDto element = (SwfModelUseDto) iter.next();
                element.setModelType(modelType);
                //删除记录
                conditions = new StringBuffer();
                conditions.append(" riskCode= '");
                conditions.append(element.getRiskCode());
                conditions.append("' and ");
                conditions.append(" comCode= '");
                conditions.append(element.getComCode());
                conditions.append("' and ");
                conditions.append(" modelType = '");
                conditions.append(modelType);
                conditions.append("'");
                blSwfModelUseAction.deleteByConditions(dbManager, conditions.toString());
            }
            //插入记录
            blSwfModelUseAction.insertAll(dbManager, swfModelUseDto.getModelUseList());
            dbManager.commitTransaction();
        } catch (Exception exception) {
            dbManager.rollbackTransaction();
            throw exception;
        } finally {
            dbManager.close();
        }
    }

}
package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLregistExt-报案信息补充说明的业务对象扩展类<br>
 * 创建于 2005-03-11 11:11:46.484<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLregistExtAction extends BLPrpLregistExtActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLregistExtAction.class);

    /**
     * 构造函数
     */
    public BLPrpLregistExtAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLregistExtDto prpLregistExtDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLregistExtDto prpLregistExtDto,String mode) throws Exception{
    }
    
    /**
     * 根据报案号查询
     * @param conditions
     * @return collection
     * @throws Exception
     */
    public Collection<PrpLregistExtDto> findByRegistNo(String conditions) throws Exception{
    	DBManager dbManager = new DBManager();
    	Collection<PrpLregistExtDto> collection = new ArrayList<PrpLregistExtDto>();
    	try {
    		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
    		collection = this.findByConditions(dbManager, conditions);
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			throw exception;
		}finally{
			dbManager.close();
		}
		return collection;
    }
}

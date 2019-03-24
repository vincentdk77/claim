package com.sinosoft.claim.bl.action.domain;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdcode通用代码表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcodeAction extends BLPrpDcodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcodeAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpDcodeAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpDcodeDto prpDcodeDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpDcodeDto prpDcodeDto,String mode) throws Exception{
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
    	return findByConditions(dbManager, conditions, 0, 0);
    }

}

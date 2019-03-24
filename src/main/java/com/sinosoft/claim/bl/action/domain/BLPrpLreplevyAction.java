package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreplevyDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplreplevy权益转让及追偿登记表的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLreplevyAction extends BLPrpLreplevyActionBase{
    private static Log log = LogFactory.getLog(BLPrpLreplevyAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLreplevyAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLreplevyDto prpLreplevyDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLreplevyDto prpLreplevyDto,String mode) throws Exception{
    }
}

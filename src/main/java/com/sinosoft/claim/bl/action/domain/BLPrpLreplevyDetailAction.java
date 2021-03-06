package com.sinosoft.claim.bl.action.domain;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLreplevyDetailDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplreplevydetail权益转让及追偿信息的业务对象扩展类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLreplevyDetailAction extends BLPrpLreplevyDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpLreplevyDetailAction.class.getName());

    /**
     * 构造函数
     */
    public BLPrpLreplevyDetailAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLreplevyDetailDto prpLreplevyDetailDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLreplevyDetailDto prpLreplevyDetailDto,String mode) throws Exception{
    }
}

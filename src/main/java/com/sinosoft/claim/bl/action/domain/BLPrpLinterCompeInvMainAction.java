package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompeInvMain;

/**
 * 这是大病医疗接口参数中间表子表计算书清单信息表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCompeInvMainAction extends BLPrpLinterCompeInvMainActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeInvMainAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCompeInvMainAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterCompeInvMainDto prpLinterCompeInvMainDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCompeInvMainDto prpLinterCompeInvMainDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterCompeInvMainDto[] prpLinterCompeInvMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompeInvMainDto[] prpLinterCompeInvMainDto)
            throws Exception{
        DBPrpLinterCompeInvMain dbPrpLinterCompeInvMain = new DBPrpLinterCompeInvMain(dbManager);
        BLPrpLinterCompeInvDetailAction bLPrpLinterCompeInvDetailAction = new BLPrpLinterCompeInvDetailAction();

        //插入记录
        for(int i=0;i<prpLinterCompeInvMainDto.length;i++){
        	dbPrpLinterCompeInvMain.insert(prpLinterCompeInvMainDto[i]);
        	bLPrpLinterCompeInvDetailAction.insert(dbManager, prpLinterCompeInvMainDto[i].getPrpLinterCompeInvDetailDto());
        }
    }
}

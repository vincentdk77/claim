package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompeInvDetail;

/**
 * 这是大病医疗接口参数中间表子表计算书清单信息明细表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLinterCompeInvDetailAction extends BLPrpLinterCompeInvDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompeInvDetailAction.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCompeInvDetailAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prpLinterCompeInvDetailDto[] prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompeInvDetailDto[] prpLinterCompeInvDetailDto)
            throws Exception{
        DBPrpLinterCompeInvDetail dbPrpLinterCompeInvDetail = new DBPrpLinterCompeInvDetail(dbManager);
        //插入记录
        for(int i=0;i<prpLinterCompeInvDetailDto.length;i++){
        	dbPrpLinterCompeInvDetail.insert(prpLinterCompeInvDetailDto[i]);
        }
    }
}

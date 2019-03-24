package com.sinosoft.claim.bl.action.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterAutoClaimDetail;

/**
 * 这是大病医疗理赔自动流程状态查询表的业务对象扩展类<br>
 * 创建于 JToolpad(1.6.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrplinterAutoClaimDetailAction extends BLPrplinterAutoClaimDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterAutoClaimDetailAction.class);

    /**
     * 构造函数
     */
    public BLPrplinterAutoClaimDetailAction(){
        super();
    }

    /**
     * 转换Dto
     * @param dbManager dbManager
     * @param prplinterAutoClaimDetailDto prplinterAutoClaimDetailDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager,PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto,String mode)
            throws Exception{
    }

    /**
     * 插入一个数组
     * @param dbManager DB管理器
     * @param prplinterAutoClaimDetailDto[] prplinterAutoClaimDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplinterAutoClaimDetailDto[] prplinterAutoClaimDetailDto)
            throws Exception{
        DBPrplinterAutoClaimDetail dbPrplinterAutoClaimDetail = new DBPrplinterAutoClaimDetail(dbManager);
        //插入记录
        for(int i=0;i<prplinterAutoClaimDetailDto.length;i++){
        	dbPrplinterAutoClaimDetail.insert(prplinterAutoClaimDetailDto[i]);
        }
    }
}

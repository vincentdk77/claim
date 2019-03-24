package com.sinosoft.claim.bl.action.domain;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLacciCheck;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLacciCheck--意健险调查主表的业务对象扩展类 <br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLacciCheckAction extends BLPrpLacciCheckActionBase {
    private static Log logger = LogFactory.getLog(BLPrpLacciCheckAction.class);

    /**
     * 构造函数
     */
    public BLPrpLacciCheckAction() {
        super();
    }

    /**
     * 转换Dto
     * 
     * @param dbManager dbManager
     * @param prpLacciCheckDto prpLacciCheckDto
     * @param mode 模式
     * @throws Exception
     */
    public void convertDto(DBManager dbManager, PrpLacciCheckDto prpLacciCheckDto, String mode) throws Exception {
    }

    /**
     * 插入一条数据
     * 
     * @param dbManager DB管理器
     * @param prpLacciCheckDto prpLacciCheckDto
     * @throws Exception
     */
    public void insert(DBManager dbManager, PrpLacciCheckDto prpLacciCheckDto) throws Exception {

        Collection result = super.findByConditions(dbManager, "RegistNo='" + prpLacciCheckDto.getRegistNo()
                + "' Order by Times desc");
        int times = 0;
        if (result.size() > 0) {
            times = ((PrpLacciCheckDto) result.iterator().next()).getTimes();
        }

        prpLacciCheckDto.setTimes(++times);

        BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
        PrpLregistDto prpLregistDto = blPrpLregistAction.findByPrimaryKey(dbManager, prpLacciCheckDto.getRegistNo());

        prpLacciCheckDto.setCheckNo(prpLacciCheckDto.getRegistNo() + "-"
                + StringUtils.newString("0", 3 - String.valueOf(prpLacciCheckDto.getTimes()).length())
                + prpLacciCheckDto.getTimes());
        prpLacciCheckDto.setRiskCode(prpLregistDto.getRiskCode());
        prpLacciCheckDto.setPolicyNo(prpLregistDto.getPolicyNo());
        prpLacciCheckDto.setApproverStatus("0");
        //插入记录
        super.insert(dbManager, prpLacciCheckDto);
    }

    /**
     * 获得等于某个报案号的所有调查费用总和
     * @param dbManager
     * @param registNo
     * @return
     * @throws Exception
     */
    public double getAcciCheckFeeByRegistNo(DBManager dbManager, String registNo) throws Exception {
    	 DBPrpLacciCheck dbPrpLacciCheck = new DBPrpLacciCheck(dbManager);
         //插入记录
         return dbPrpLacciCheck.getSumAcciCheckFeeByRegistNo(registNo);
    }

}

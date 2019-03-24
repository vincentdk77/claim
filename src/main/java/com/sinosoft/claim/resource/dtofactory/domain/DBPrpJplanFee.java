package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJplanFeeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是应收应付费信息表的数据访问对象类<br>
 * 创建于 2007-03-20 16:39:43.906<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpJplanFee extends DBPrpJplanFeeBase{
    private static Log logger = LogFactory.getLog(DBPrpJplanFee.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJplanFee(DBManager dbManager){
        super(dbManager);
    }
	public Collection findJoinJpayRefRecByConditions(String conditions) throws Exception{
		return findJoinJpayRefRecByConditions(conditions,0,0);
	}
    
    
    /**
     * 关联实收实付表的查询方法findByConditions
     * @param conditions
     * @param pageNo
     * @param rowsPerPage
     * @return
     * @throws Exception
     */
	public Collection findJoinJpayRefRecByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception {
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("pf.CertiType,");
        buffer.append("pf.CertiNo,");
        buffer.append("pf.PolicyNo,");
        buffer.append("pf.SerialNo,");
        buffer.append("pf.PayRefReason,");
        buffer.append("pf.ClaimNo,");
        buffer.append("pf.ClassCode,");
        buffer.append("pf.RiskCode,");
        buffer.append("pf.ContractNo,");
        buffer.append("pf.AppliCode,");
        buffer.append("pf.AppliName,");
        buffer.append("pf.InsuredCode,");
        buffer.append("pf.InsuredName,");
        buffer.append("pf.StartDate,");
        buffer.append("pf.EndDate,");
        buffer.append("pf.ValidDate,");
        buffer.append("pf.PayNo,");
        buffer.append("pf.Currency1,");
        buffer.append("pf.PlanFee,");
        buffer.append("pf.PlanDate,");
        buffer.append("pf.ComCode,");
        buffer.append("pf.MakeCom,");
        buffer.append("pf.AgentCode,");
        buffer.append("pf.Handler1Code,");
        buffer.append("pf.HandlerCode,");
        buffer.append("pf.UnderWriteDate,");
        buffer.append("pf.CoinsFlag,");
        buffer.append("pf.CoinsCode,");
        buffer.append("pf.CoinsName,");
        buffer.append("pf.CoinsType,");
        buffer.append("pf.CenterCode,");
        buffer.append("pf.BranchCode,");
        buffer.append("pf.AccBookType,");
        buffer.append("pf.AccBookCode,");
        buffer.append("pf.YearMonth,");
        buffer.append("pf.VoucherNo,");
        buffer.append("pf.ExchangeRate,");
        buffer.append("pf.PlanFeeCNY,");
        buffer.append("pf.PayRefFee,");
        buffer.append("pf.RealPayRefFee,");
        buffer.append("pf.Flag,");
        buffer.append("pf.BusinessNature,");
        buffer.append("pf.OthFlag,");
        buffer.append("pf.CarNatureCode,");
        buffer.append("pf.UseNatureCode,");
        buffer.append("pf.CarProperty,");
        buffer.append("pf.PayComCode,");
        buffer.append("pf.BusinessType,");
        buffer.append("pf.BusinessType1, ");
        buffer.append("pr.payrefdate, ");
        buffer.append("pr.payreffee ");
        buffer.append("FROM PrpJplanFee  pf left join prpjpayrefrec pr on pf.certitype = pr.certitype and pf.certino = pr.certino and pf.serialno = pr.serialno and pf.payrefreason = pr.payrefreason ");
        buffer.append(" WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpJplanFeeDto prpJplanFeeDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpJplanFeeDto = new PrpJplanFeeDto();
            prpJplanFeeDto.setCertiType(dbManager.getString(resultSet,1));
            prpJplanFeeDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJplanFeeDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpJplanFeeDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJplanFeeDto.setPayRefReason(dbManager.getString(resultSet,5));
            prpJplanFeeDto.setClaimNo(dbManager.getString(resultSet,6));
            prpJplanFeeDto.setClassCode(dbManager.getString(resultSet,7));
            prpJplanFeeDto.setRiskCode(dbManager.getString(resultSet,8));
            prpJplanFeeDto.setContractNo(dbManager.getString(resultSet,9));
            prpJplanFeeDto.setAppliCode(dbManager.getString(resultSet,10));
            prpJplanFeeDto.setAppliName(dbManager.getString(resultSet,11));
            prpJplanFeeDto.setInsuredCode(dbManager.getString(resultSet,12));
            prpJplanFeeDto.setInsuredName(dbManager.getString(resultSet,13));
            prpJplanFeeDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpJplanFeeDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJplanFeeDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpJplanFeeDto.setPayNo(dbManager.getInt(resultSet,17));
            prpJplanFeeDto.setCurrency1(dbManager.getString(resultSet,18));
            prpJplanFeeDto.setPlanFee(dbManager.getDouble(resultSet,19));
            prpJplanFeeDto.setPlanDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,20));
            prpJplanFeeDto.setComCode(dbManager.getString(resultSet,21));
            prpJplanFeeDto.setMakeCom(dbManager.getString(resultSet,22));
            prpJplanFeeDto.setAgentCode(dbManager.getString(resultSet,23));
            prpJplanFeeDto.setHandler1Code(dbManager.getString(resultSet,24));
            prpJplanFeeDto.setHandlerCode(dbManager.getString(resultSet,25));
            prpJplanFeeDto.setUnderWriteDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,26));
            prpJplanFeeDto.setCoinsFlag(dbManager.getString(resultSet,27));
            prpJplanFeeDto.setCoinsCode(dbManager.getString(resultSet,28));
            prpJplanFeeDto.setCoinsName(dbManager.getString(resultSet,29));
            prpJplanFeeDto.setCoinsType(dbManager.getString(resultSet,30));
            prpJplanFeeDto.setCenterCode(dbManager.getString(resultSet,31));
            prpJplanFeeDto.setBranchCode(dbManager.getString(resultSet,32));
            prpJplanFeeDto.setAccBookType(dbManager.getString(resultSet,33));
            prpJplanFeeDto.setAccBookCode(dbManager.getString(resultSet,34));
            prpJplanFeeDto.setYearMonth(dbManager.getString(resultSet,35));
            prpJplanFeeDto.setVoucherNo(dbManager.getString(resultSet,36));
            prpJplanFeeDto.setExchangeRate(dbManager.getDouble(resultSet,37));
            prpJplanFeeDto.setPlanFeeCNY(dbManager.getDouble(resultSet,38));
            prpJplanFeeDto.setPayRefFee(dbManager.getDouble(resultSet,39));
            prpJplanFeeDto.setRealPayRefFee(dbManager.getDouble(resultSet,40));
            prpJplanFeeDto.setFlag(dbManager.getString(resultSet,41));
            prpJplanFeeDto.setBusinessNature(dbManager.getString(resultSet,42));
            prpJplanFeeDto.setOthFlag(dbManager.getString(resultSet,43));
            prpJplanFeeDto.setCarNatureCode(dbManager.getString(resultSet,44));
            prpJplanFeeDto.setUseNatureCode(dbManager.getString(resultSet,45));
            prpJplanFeeDto.setCarProperty(dbManager.getDouble(resultSet,46));
            prpJplanFeeDto.setPayComCode(dbManager.getString(resultSet,47));
            prpJplanFeeDto.setBusinessType(dbManager.getString(resultSet,48));
            prpJplanFeeDto.setBusinessType1(dbManager.getString(resultSet,49));
            prpJplanFeeDto.setPayRefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,50));
            prpJplanFeeDto.setPayRefFee(dbManager.getDouble(resultSet,51));
            collection.add(prpJplanFeeDto);
        }
        resultSet.close();
        return collection;
    }

}

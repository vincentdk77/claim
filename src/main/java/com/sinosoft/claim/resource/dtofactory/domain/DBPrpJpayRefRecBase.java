package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayRefRecDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

public class DBPrpJpayRefRecBase {
	//TODO 方法不全
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpJpayRefRecBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJpayRefRecBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CertiType,");
        buffer.append("CertiNo,");
        buffer.append("PolicyNo,");
        buffer.append("SerialNo,");
        buffer.append("PayRefReason,");
        buffer.append("PayRefTimes,");
        buffer.append("ClaimNo,");
        buffer.append("ClassCode,");
        buffer.append("RiskCode,");
        buffer.append("ContractNo,");
        buffer.append("AppliCode,");
        buffer.append("AppliName,");
        buffer.append("InsuredCode,");
        buffer.append("InsuredName,");
        buffer.append("StartDate,");
        buffer.append("EndDate,");
        buffer.append("ValidDate,");
        buffer.append("PayNo,");
        buffer.append("Currency1,");
        buffer.append("PlanFee,");
        buffer.append("PlanDate,");
        buffer.append("ComCode,");
        buffer.append("MakeCom,");
        buffer.append("AgentCode,");
        buffer.append("Handler1Code,");
        buffer.append("HandlerCode,");
        buffer.append("UnderWriteDate,");
        buffer.append("CoinsFlag,");
        buffer.append("CoinsCode,");
        buffer.append("CoinsName,");
        buffer.append("CoinsType,");
        buffer.append("OperateDate,");
        buffer.append("OperatorCode,");
        buffer.append("OperateUnit,");
        buffer.append("Currency2,");
        buffer.append("ExchangeRate,");
        buffer.append("PayRefFee,");
        buffer.append("VisaCode,");
        buffer.append("VisaName,");
        buffer.append("VisaSerialNo,");
        buffer.append("PrintDate,");
        buffer.append("PrinterCode,");
        buffer.append("VisaHandler,");
        buffer.append("PayRefName,");
        buffer.append("IdentifyType,");
        buffer.append("IdentifyNumber,");
        buffer.append("Remark,");
        buffer.append("PayRefNo,");
        buffer.append("PayRefDate,");
        buffer.append("Flag,");
        buffer.append("BusinessNature,");
        buffer.append("OthFlag,");
        buffer.append("TaxFee,");
        buffer.append("CarNatureCode,");
        buffer.append("UseNatureCode,");
        buffer.append("CarProperty ");
        buffer.append("FROM PrpJpayRefRec WHERE ");
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
        PrpJpayRefRecDto prpJpayRefRecDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpJpayRefRecDto = new PrpJpayRefRecDto();
            prpJpayRefRecDto.setCertiType(dbManager.getString(resultSet,1));
            prpJpayRefRecDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJpayRefRecDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpJpayRefRecDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJpayRefRecDto.setPayRefReason(dbManager.getString(resultSet,5));
            prpJpayRefRecDto.setPayRefTimes(dbManager.getInt(resultSet,6));
            prpJpayRefRecDto.setClaimNo(dbManager.getString(resultSet,7));
            prpJpayRefRecDto.setClassCode(dbManager.getString(resultSet,8));
            prpJpayRefRecDto.setRiskCode(dbManager.getString(resultSet,9));
            prpJpayRefRecDto.setContractNo(dbManager.getString(resultSet,10));
            prpJpayRefRecDto.setAppliCode(dbManager.getString(resultSet,11));
            prpJpayRefRecDto.setAppliName(dbManager.getString(resultSet,12));
            prpJpayRefRecDto.setInsuredCode(dbManager.getString(resultSet,13));
            prpJpayRefRecDto.setInsuredName(dbManager.getString(resultSet,14));
            prpJpayRefRecDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJpayRefRecDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpJpayRefRecDto.setValidDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            prpJpayRefRecDto.setPayNo(dbManager.getInt(resultSet,18));
            prpJpayRefRecDto.setCurrency1(dbManager.getString(resultSet,19));
            prpJpayRefRecDto.setPlanFee(dbManager.getDouble(resultSet,20));
            prpJpayRefRecDto.setPlanDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,21));
            prpJpayRefRecDto.setComCode(dbManager.getString(resultSet,22));
            prpJpayRefRecDto.setMakeCom(dbManager.getString(resultSet,23));
            prpJpayRefRecDto.setAgentCode(dbManager.getString(resultSet,24));
            prpJpayRefRecDto.setHandler1Code(dbManager.getString(resultSet,25));
            prpJpayRefRecDto.setHandlerCode(dbManager.getString(resultSet,26));
            prpJpayRefRecDto.setUnderWriteDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,27));
            prpJpayRefRecDto.setCoinsFlag(dbManager.getString(resultSet,28));
            prpJpayRefRecDto.setCoinsCode(dbManager.getString(resultSet,29));
            prpJpayRefRecDto.setCoinsName(dbManager.getString(resultSet,30));
            prpJpayRefRecDto.setCoinsType(dbManager.getString(resultSet,31));
            prpJpayRefRecDto.setOperateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,32));
            prpJpayRefRecDto.setOperatorCode(dbManager.getString(resultSet,33));
            prpJpayRefRecDto.setOperateUnit(dbManager.getString(resultSet,34));
            prpJpayRefRecDto.setCurrency2(dbManager.getString(resultSet,35));
            prpJpayRefRecDto.setExchangeRate(dbManager.getDouble(resultSet,36));
            prpJpayRefRecDto.setPayRefFee(dbManager.getDouble(resultSet,37));
            prpJpayRefRecDto.setVisaCode(dbManager.getString(resultSet,38));
            prpJpayRefRecDto.setVisaName(dbManager.getString(resultSet,39));
            prpJpayRefRecDto.setVisaSerialNo(dbManager.getString(resultSet,40));
            prpJpayRefRecDto.setPrintDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,41));
            prpJpayRefRecDto.setPrinterCode(dbManager.getString(resultSet,42));
            prpJpayRefRecDto.setVisaHandler(dbManager.getString(resultSet,43));
            prpJpayRefRecDto.setPayRefName(dbManager.getString(resultSet,44));
            prpJpayRefRecDto.setIdentifyType(dbManager.getString(resultSet,45));
            prpJpayRefRecDto.setIdentifyNumber(dbManager.getString(resultSet,46));
            prpJpayRefRecDto.setRemark(dbManager.getString(resultSet,47));
            prpJpayRefRecDto.setPayRefNo(dbManager.getString(resultSet,48));
            prpJpayRefRecDto.setPayRefDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,49));
            prpJpayRefRecDto.setFlag(dbManager.getString(resultSet,50));
            prpJpayRefRecDto.setBusinessNature(dbManager.getString(resultSet,51));
            prpJpayRefRecDto.setOthFlag(dbManager.getString(resultSet,52));
            prpJpayRefRecDto.setTaxFee(dbManager.getDouble(resultSet,53));
            prpJpayRefRecDto.setCarNatureCode(dbManager.getString(resultSet,54));
            prpJpayRefRecDto.setUseNatureCode(dbManager.getString(resultSet,55));
            prpJpayRefRecDto.setCarProperty(dbManager.getDouble(resultSet,56));
            collection.add(prpJpayRefRecDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(1) FROM PrpJpayRefRec WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    
    /**
     * 查询收付时间字段
     * 剔除红冲操作的数据
     * @throws Exception 
     */
    public DateTime findRefDate(String conditions) throws Exception{
    	DateTime refDate = null;
    	String stateMent = " SELECT rec.payrefdate from prpjpayrefrec rec Where (rec.flag NOT IN('1','2') or rec.flag is null) and "+conditions;
    	ResultSet resultSet = dbManager.executeQuery(stateMent);
    	if(resultSet !=null){
    		if(resultSet.next()){
    			refDate = dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,1);
    		}
        	resultSet.close();
    	}
		return refDate;
    	
    }
}

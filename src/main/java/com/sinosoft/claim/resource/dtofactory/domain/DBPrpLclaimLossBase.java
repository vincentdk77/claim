package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimLossDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimLoss－立案险别估损金额表的数据访问对象基类<br>
 * 创建于 2006-06-19 11:26:04.968<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLclaimLossBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLclaimLossBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimLossBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimLossDto prpLclaimLossDto
     * @throws Exception
     */
    public void insert(PrpLclaimLossDto prpLclaimLossDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimLoss (");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("Currency,");
        buffer.append("SumClaim,");
        buffer.append("InputDate,");
        buffer.append("RemarkFlag,");
        buffer.append("Flag,");
        buffer.append("LossFeeType,");
        buffer.append("ClaimNumber,");
        buffer.append("ItemDetailName,");
        buffer.append("FeeCategory,");
        buffer.append("KindLoss,");
        buffer.append("KindRest,");
        buffer.append("DeductibleRate,");
        buffer.append("Deductible,");
        buffer.append("AcciDeductibleRate,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName, ");
        buffer.append("licenseNo, ");
        buffer.append("FamilyNoZH, ");
        buffer.append("imei ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLclaimLossDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLclaimLossDto.getRiskCode()).append("',");
            debugBuffer.append("").append(prpLclaimLossDto.getSerialNo()).append(",");
            debugBuffer.append("").append(prpLclaimLossDto.getItemKindNo()).append(",");
            debugBuffer.append("'").append(prpLclaimLossDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLclaimLossDto.getItemCode()).append("',");
            debugBuffer.append("'").append(prpLclaimLossDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLclaimLossDto.getSumClaim()).append(",");
            debugBuffer.append("'").append(prpLclaimLossDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLclaimLossDto.getRemarkFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimLossDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimLossDto.getLossFeeType()).append("',");
            debugBuffer.append("'").append(prpLclaimLossDto.getClaimNumber()).append("',");
            debugBuffer.append("'").append(prpLclaimLossDto.getItemDetailName()).append("',");
            debugBuffer.append("'").append(prpLclaimLossDto.getFeeCategory()).append("',");
            debugBuffer.append("").append(prpLclaimLossDto.getKindLoss()).append(",");
            debugBuffer.append("").append(prpLclaimLossDto.getKindRest()).append(",");
            debugBuffer.append("").append(prpLclaimLossDto.getDeductibleRate()).append(",");
            debugBuffer.append("").append(prpLclaimLossDto.getDeductible()).append(",");
            debugBuffer.append("").append(prpLclaimLossDto.getAcciDeductibleRate()).append(",");
            debugBuffer.append("").append(prpLclaimLossDto.getFamilyNoZH()).append(",");
            debugBuffer.append("").append(prpLclaimLossDto.getImei()).append(")");
            
            
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLclaimLossDto.getClaimNo());
        dbManager.setString(2,prpLclaimLossDto.getRiskCode());
        dbManager.setInt(3,prpLclaimLossDto.getSerialNo());
        dbManager.setInt(4,prpLclaimLossDto.getItemKindNo());
        dbManager.setString(5,prpLclaimLossDto.getKindCode());
        dbManager.setString(6,prpLclaimLossDto.getItemCode());
        dbManager.setString(7,prpLclaimLossDto.getCurrency());
        dbManager.setDouble(8,prpLclaimLossDto.getSumClaim());
        dbManager.setDateTime(9,prpLclaimLossDto.getInputDate());
        dbManager.setString(10,prpLclaimLossDto.getRemarkFlag());
        dbManager.setString(11,prpLclaimLossDto.getFlag());
        dbManager.setString(12,prpLclaimLossDto.getLossFeeType());
        dbManager.setString(13,prpLclaimLossDto.getClaimNumber());
        dbManager.setString(14,prpLclaimLossDto.getItemDetailName());
        dbManager.setString(15,prpLclaimLossDto.getFeeCategory());
        dbManager.setDouble(16,prpLclaimLossDto.getKindLoss());
        dbManager.setDouble(17,prpLclaimLossDto.getKindRest());
        dbManager.setDouble(18,prpLclaimLossDto.getDeductibleRate());
        dbManager.setDouble(19,prpLclaimLossDto.getDeductible());
        dbManager.setDouble(20,prpLclaimLossDto.getAcciDeductibleRate());
        dbManager.setInt(21,prpLclaimLossDto.getFamilyNo());
        dbManager.setString(22,prpLclaimLossDto.getFamilyName());
        dbManager.setString(23,prpLclaimLossDto.getLicenseNo());
        dbManager.setString(24,prpLclaimLossDto.getFamilyNoZH());
        dbManager.setString(25,prpLclaimLossDto.getImei());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimLoss (");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("Currency,");
        buffer.append("SumClaim,");
        buffer.append("InputDate,");
        buffer.append("RemarkFlag,");
        buffer.append("Flag,");
        buffer.append("LossFeeType,");
        buffer.append("ClaimNumber,");
        buffer.append("ItemDetailName,");
        buffer.append("FeeCategory,");
        buffer.append("KindLoss,");
        buffer.append("KindRest,");
        buffer.append("DeductibleRate,");
        buffer.append("Deductible,");
        buffer.append("AcciDeductibleRate,");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName, ");
        buffer.append("licenseNo, ");
        buffer.append("FamilyNoZH, ");
        buffer.append("Imei ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimLossDto prpLclaimLossDto = (PrpLclaimLossDto)i.next();
            dbManager.setString(1,prpLclaimLossDto.getClaimNo());
            dbManager.setString(2,prpLclaimLossDto.getRiskCode());
            dbManager.setInt(3,prpLclaimLossDto.getSerialNo());
            dbManager.setInt(4,prpLclaimLossDto.getItemKindNo());
            dbManager.setString(5,prpLclaimLossDto.getKindCode());
            dbManager.setString(6,prpLclaimLossDto.getItemCode());
            dbManager.setString(7,prpLclaimLossDto.getCurrency());
            dbManager.setDouble(8,prpLclaimLossDto.getSumClaim());
            dbManager.setDateTime(9,prpLclaimLossDto.getInputDate());
            dbManager.setString(10,prpLclaimLossDto.getRemarkFlag());
            dbManager.setString(11,prpLclaimLossDto.getFlag());
            dbManager.setString(12,prpLclaimLossDto.getLossFeeType());
            dbManager.setString(13,prpLclaimLossDto.getClaimNumber());
            dbManager.setString(14,prpLclaimLossDto.getItemDetailName());
            dbManager.setString(15,prpLclaimLossDto.getFeeCategory());
            dbManager.setDouble(16,prpLclaimLossDto.getKindLoss());
            dbManager.setDouble(17,prpLclaimLossDto.getKindRest());
            dbManager.setDouble(18,prpLclaimLossDto.getDeductibleRate());
            dbManager.setDouble(19,prpLclaimLossDto.getDeductible());
            dbManager.setDouble(20,prpLclaimLossDto.getAcciDeductibleRate());
            dbManager.setInt(21,prpLclaimLossDto.getFamilyNo());
            dbManager.setString(22,prpLclaimLossDto.getFamilyName());
            dbManager.setString(23,prpLclaimLossDto.getLicenseNo());
            dbManager.setString(24,prpLclaimLossDto.getFamilyNoZH());
            dbManager.setString(25,prpLclaimLossDto.getImei());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param claimNo 立案号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String claimNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLclaimLoss ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("ClaimNo=").append("'").append(claimNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ClaimNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLclaimLossDto prpLclaimLossDto
     * @throws Exception
     */
    public void update(PrpLclaimLossDto prpLclaimLossDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaimLoss SET ");
        buffer.append("RiskCode = ?, ");
        buffer.append("ItemKindNo = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("ItemCode = ?, ");
        buffer.append("Currency = ?, ");
        buffer.append("SumClaim = ?, ");
        buffer.append("InputDate = ?, ");
        buffer.append("RemarkFlag = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("LossFeeType = ?, ");
        buffer.append("ClaimNumber = ?, ");
        buffer.append("ItemDetailName = ?, ");
        buffer.append("FeeCategory = ?, ");
        buffer.append("KindLoss = ?, ");
        buffer.append("KindRest = ?, ");
        buffer.append("DeductibleRate = ?, ");
        buffer.append("Deductible = ?, ");
        buffer.append("AcciDeductibleRate = ?, ");
        buffer.append("FamilyNo = ?, ");
        buffer.append("FamilyName = ?, ");
        buffer.append("licenseNo = ?,");
        buffer.append("FamilyNoZH = ?, ");
        buffer.append("Imei = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLclaimLoss SET ");
            debugBuffer.append("RiskCode = '" + prpLclaimLossDto.getRiskCode() + "', ");
            debugBuffer.append("ItemKindNo = " + prpLclaimLossDto.getItemKindNo() + ", ");
            debugBuffer.append("KindCode = '" + prpLclaimLossDto.getKindCode() + "', ");
            debugBuffer.append("ItemCode = '" + prpLclaimLossDto.getItemCode() + "', ");
            debugBuffer.append("Currency = '" + prpLclaimLossDto.getCurrency() + "', ");
            debugBuffer.append("SumClaim = " + prpLclaimLossDto.getSumClaim() + ", ");
            debugBuffer.append("InputDate = '" + prpLclaimLossDto.getInputDate() + "', ");
            debugBuffer.append("RemarkFlag = '" + prpLclaimLossDto.getRemarkFlag() + "', ");
            debugBuffer.append("Flag = '" + prpLclaimLossDto.getFlag() + "', ");
            debugBuffer.append("LossFeeType = '" + prpLclaimLossDto.getLossFeeType() + "', ");
            debugBuffer.append("ClaimNumber = '" + prpLclaimLossDto.getClaimNumber() + "', ");
            debugBuffer.append("ItemDetailName = '" + prpLclaimLossDto.getItemDetailName() + "', ");
            debugBuffer.append("FeeCategory = '" + prpLclaimLossDto.getFeeCategory() + "', ");
            debugBuffer.append("KindLoss = " + prpLclaimLossDto.getKindLoss() + ", ");
            debugBuffer.append("KindRest = " + prpLclaimLossDto.getKindRest() + ", ");
            debugBuffer.append("DeductibleRate = " + prpLclaimLossDto.getDeductibleRate() + ", ");
            debugBuffer.append("Deductible = " + prpLclaimLossDto.getDeductible() + ", ");
            debugBuffer.append("AcciDeductibleRate = " + prpLclaimLossDto.getAcciDeductibleRate() + ", ");
            debugBuffer.append("FamilyNo = " + prpLclaimLossDto.getFamilyNo() + ", ");
            debugBuffer.append("FamilyName = " + prpLclaimLossDto.getFamilyName() + ", ");
            debugBuffer.append("FamilyNoZH = " + prpLclaimLossDto.getFamilyNoZH() + ", ");
            debugBuffer.append("Imei = " + prpLclaimLossDto.getFamilyNoZH() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("ClaimNo=").append("'").append(prpLclaimLossDto.getClaimNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLclaimLossDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ClaimNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLclaimLossDto.getRiskCode());
        dbManager.setInt(2,prpLclaimLossDto.getItemKindNo());
        dbManager.setString(3,prpLclaimLossDto.getKindCode());
        dbManager.setString(4,prpLclaimLossDto.getItemCode());
        dbManager.setString(5,prpLclaimLossDto.getCurrency());
        dbManager.setDouble(6,prpLclaimLossDto.getSumClaim());
        dbManager.setDateTime(7,prpLclaimLossDto.getInputDate());
        dbManager.setString(8,prpLclaimLossDto.getRemarkFlag());
        dbManager.setString(9,prpLclaimLossDto.getFlag());
        dbManager.setString(10,prpLclaimLossDto.getLossFeeType());
        dbManager.setString(11,prpLclaimLossDto.getClaimNumber());
        dbManager.setString(12,prpLclaimLossDto.getItemDetailName());
        dbManager.setString(13,prpLclaimLossDto.getFeeCategory());
        dbManager.setDouble(14,prpLclaimLossDto.getKindLoss());
        dbManager.setDouble(15,prpLclaimLossDto.getKindRest());
        dbManager.setDouble(16,prpLclaimLossDto.getDeductibleRate());
        dbManager.setDouble(17,prpLclaimLossDto.getDeductible());
        dbManager.setDouble(18,prpLclaimLossDto.getAcciDeductibleRate());
        dbManager.setInt(19,prpLclaimLossDto.getFamilyNo());
        dbManager.setString(20,prpLclaimLossDto.getFamilyName());
        dbManager.setString(21,prpLclaimLossDto.getLicenseNo());
        dbManager.setString(22,prpLclaimLossDto.getFamilyNoZH());
        dbManager.setString(23,prpLclaimLossDto.getImei());
        //设置条件字段;
        dbManager.setString(24,prpLclaimLossDto.getClaimNo());
        dbManager.setInt(25,prpLclaimLossDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param claimNo 立案号
     * @param serialNo 序号
     * @return PrpLclaimLossDto
     * @throws Exception
     */
    public PrpLclaimLossDto findByPrimaryKey(String claimNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("Currency,");
        buffer.append("SumClaim,");
        buffer.append("InputDate,");
        buffer.append("RemarkFlag,");
        buffer.append("Flag,");
        buffer.append("LossFeeType,");
        buffer.append("ClaimNumber,");
        buffer.append("ItemDetailName,");
        buffer.append("FeeCategory,");
        buffer.append("KindLoss,");
        buffer.append("KindRest,");
        buffer.append("DeductibleRate,");
        buffer.append("Deductible,");
        buffer.append("AcciDeductibleRate, ");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName, ");
        buffer.append("licenseNo, ");
        buffer.append("FamilyNoZH, ");
        buffer.append("Imei ");
        buffer.append("FROM PrpLclaimLoss ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("ClaimNo=").append("'").append(claimNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ClaimNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,claimNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLclaimLossDto prpLclaimLossDto = null;
        if(resultSet.next()){
            prpLclaimLossDto = new PrpLclaimLossDto();
            prpLclaimLossDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLclaimLossDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLclaimLossDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpLclaimLossDto.setKindCode(dbManager.getString(resultSet,5));
            prpLclaimLossDto.setItemCode(dbManager.getString(resultSet,6));
            prpLclaimLossDto.setCurrency(dbManager.getString(resultSet,7));
            prpLclaimLossDto.setSumClaim(dbManager.getDouble(resultSet,8));
            prpLclaimLossDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLclaimLossDto.setRemarkFlag(dbManager.getString(resultSet,10));
            prpLclaimLossDto.setFlag(dbManager.getString(resultSet,11));
            prpLclaimLossDto.setLossFeeType(dbManager.getString(resultSet,12));
            //yx
            prpLclaimLossDto.setClaimNumber(dbManager.getString(resultSet,13));
            prpLclaimLossDto.setItemDetailName(dbManager.getString(resultSet,14));
            prpLclaimLossDto.setFeeCategory(dbManager.getString(resultSet,15));
            prpLclaimLossDto.setKindLoss(dbManager.getDouble(resultSet,16));
            prpLclaimLossDto.setKindRest(dbManager.getDouble(resultSet,17));
            prpLclaimLossDto.setDeductibleRate(dbManager.getDouble(resultSet,18));
            prpLclaimLossDto.setDeductible(dbManager.getDouble(resultSet,19));
            prpLclaimLossDto.setAcciDeductibleRate(dbManager.getDouble(resultSet,20));
            prpLclaimLossDto.setFamilyNo(dbManager.getInt(resultSet,21));
            prpLclaimLossDto.setFamilyName(dbManager.getString(resultSet,22));
            prpLclaimLossDto.setLicenseNo(dbManager.getString(resultSet,23));
            prpLclaimLossDto.setFamilyNoZH(dbManager.getString(resultSet,24));
            prpLclaimLossDto.setImei(dbManager.getString(resultSet,25));
            
        }
        resultSet.close();
        return prpLclaimLossDto;
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
        buffer.append("ClaimNo,");
        buffer.append("RiskCode,");
        buffer.append("SerialNo,");
        buffer.append("ItemKindNo,");
        buffer.append("KindCode,");
        buffer.append("ItemCode,");
        buffer.append("Currency,");
        buffer.append("SumClaim,");
        buffer.append("InputDate,");
        buffer.append("RemarkFlag,");
        buffer.append("Flag,");
        buffer.append("LossFeeType,");
        buffer.append("ClaimNumber,");
        buffer.append("ItemDetailName,");
        buffer.append("FeeCategory,");
        buffer.append("KindLoss,");
        buffer.append("KindRest,");
        buffer.append("DeductibleRate,");
        buffer.append("Deductible,");
        buffer.append("AcciDeductibleRate, ");
        buffer.append("FamilyNo,");
        buffer.append("FamilyName, ");
        buffer.append("licenseNo, ");
        buffer.append("FamilyNoZH, ");
        buffer.append("Imei ");
        buffer.append("FROM PrpLclaimLoss WHERE ");
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
        PrpLclaimLossDto prpLclaimLossDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLclaimLossDto = new PrpLclaimLossDto();
            prpLclaimLossDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimLossDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLclaimLossDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLclaimLossDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpLclaimLossDto.setKindCode(dbManager.getString(resultSet,5));
            prpLclaimLossDto.setItemCode(dbManager.getString(resultSet,6));
            prpLclaimLossDto.setCurrency(dbManager.getString(resultSet,7));
            prpLclaimLossDto.setSumClaim(dbManager.getDouble(resultSet,8));
            prpLclaimLossDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLclaimLossDto.setRemarkFlag(dbManager.getString(resultSet,10));
            prpLclaimLossDto.setFlag(dbManager.getString(resultSet,11));
            prpLclaimLossDto.setLossFeeType(dbManager.getString(resultSet,12));
            //yx
            prpLclaimLossDto.setClaimNumber(dbManager.getString(resultSet,13));
            prpLclaimLossDto.setItemDetailName(dbManager.getString(resultSet,14));
            prpLclaimLossDto.setFeeCategory(dbManager.getString(resultSet,15));
            prpLclaimLossDto.setKindLoss(dbManager.getDouble(resultSet,16));
            prpLclaimLossDto.setKindRest(dbManager.getDouble(resultSet,17));
            prpLclaimLossDto.setDeductibleRate(dbManager.getDouble(resultSet,18));
            prpLclaimLossDto.setDeductible(dbManager.getDouble(resultSet,19));
            prpLclaimLossDto.setAcciDeductibleRate(dbManager.getDouble(resultSet,20));
            prpLclaimLossDto.setFamilyNo(dbManager.getInt(resultSet,21));
            prpLclaimLossDto.setFamilyName(dbManager.getString(resultSet,22));
            prpLclaimLossDto.setLicenseNo(dbManager.getString(resultSet,23));
            prpLclaimLossDto.setFamilyNoZH(dbManager.getString(resultSet,24));
            prpLclaimLossDto.setImei(dbManager.getString(resultSet,25));
            collection.add(prpLclaimLossDto);
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
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLclaimLoss WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
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
         String statement ;
          statement = "SELECT count(1) FROM PrpLclaimLoss WHERE ";
           statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
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
}

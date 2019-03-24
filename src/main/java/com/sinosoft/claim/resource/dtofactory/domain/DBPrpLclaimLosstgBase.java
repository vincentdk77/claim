package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimLosstgDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimLoss－立案险别估损金额表的数据访问对象基类<br>
 * 创建于 2006-06-19 11:26:04.968<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLclaimLosstgBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLclaimLosstgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimLosstgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimLosstgDto prpLclaimLosstgDto
     * @throws Exception
     */
    public void insert(PrpLclaimLosstgDto prpLclaimLosstgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimLosstg (");
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
        buffer.append("FamilyNoZH ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getClaimNo()).append("',");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getRiskCode()).append("',");
            debugBuffer.append("").append(prpLclaimLosstgDto.getSerialNo()).append(",");
            debugBuffer.append("").append(prpLclaimLosstgDto.getItemKindNo()).append(",");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getItemCode()).append("',");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getCurrency()).append("',");
            debugBuffer.append("").append(prpLclaimLosstgDto.getSumClaim()).append(",");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getRemarkFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getFlag()).append("',");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getLossFeeType()).append("',");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getClaimNumber()).append("',");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getItemDetailName()).append("',");
            debugBuffer.append("'").append(prpLclaimLosstgDto.getFeeCategory()).append("',");
            debugBuffer.append("").append(prpLclaimLosstgDto.getKindLoss()).append(",");
            debugBuffer.append("").append(prpLclaimLosstgDto.getKindRest()).append(",");
            debugBuffer.append("").append(prpLclaimLosstgDto.getDeductibleRate()).append(",");
            debugBuffer.append("").append(prpLclaimLosstgDto.getDeductible()).append(",");
            debugBuffer.append("").append(prpLclaimLosstgDto.getAcciDeductibleRate()).append(",");
            debugBuffer.append("").append(prpLclaimLosstgDto.getFamilyNoZH()).append(")");
            
            
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLclaimLosstgDto.getClaimNo());
        dbManager.setString(2,prpLclaimLosstgDto.getRiskCode());
        dbManager.setInt(3,prpLclaimLosstgDto.getSerialNo());
        dbManager.setInt(4,prpLclaimLosstgDto.getItemKindNo());
        dbManager.setString(5,prpLclaimLosstgDto.getKindCode());
        dbManager.setString(6,prpLclaimLosstgDto.getItemCode());
        dbManager.setString(7,prpLclaimLosstgDto.getCurrency());
        dbManager.setDouble(8,prpLclaimLosstgDto.getSumClaim());
        dbManager.setDateTime(9,prpLclaimLosstgDto.getInputDate());
        dbManager.setString(10,prpLclaimLosstgDto.getRemarkFlag());
        dbManager.setString(11,prpLclaimLosstgDto.getFlag());
        dbManager.setString(12,prpLclaimLosstgDto.getLossFeeType());
        dbManager.setString(12,prpLclaimLosstgDto.getClaimNumber());
        dbManager.setString(13,prpLclaimLosstgDto.getItemDetailName());
        dbManager.setString(14,prpLclaimLosstgDto.getFeeCategory());
        dbManager.setDouble(15,prpLclaimLosstgDto.getKindLoss());
        dbManager.setDouble(16,prpLclaimLosstgDto.getKindRest());
        dbManager.setDouble(17,prpLclaimLosstgDto.getDeductibleRate());
        dbManager.setDouble(18,prpLclaimLosstgDto.getDeductible());
        dbManager.setDouble(19,prpLclaimLosstgDto.getAcciDeductibleRate());
        dbManager.setInt(20,prpLclaimLosstgDto.getFamilyNo());
        dbManager.setString(21,prpLclaimLosstgDto.getFamilyName());
        dbManager.setString(22,prpLclaimLosstgDto.getLicenseNo());
        dbManager.setString(23,prpLclaimLosstgDto.getFamilyNoZH());
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
        buffer.append("INSERT INTO PrpLclaimLosstg (");
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
        buffer.append("FamilyNoZH ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimLosstgDto prpLclaimLosstgDto = (PrpLclaimLosstgDto)i.next();
            dbManager.setString(1,prpLclaimLosstgDto.getClaimNo());
            dbManager.setString(2,prpLclaimLosstgDto.getRiskCode());
            dbManager.setInt(3,prpLclaimLosstgDto.getSerialNo());
            dbManager.setInt(4,prpLclaimLosstgDto.getItemKindNo());
            dbManager.setString(5,prpLclaimLosstgDto.getKindCode());
            dbManager.setString(6,prpLclaimLosstgDto.getItemCode());
            dbManager.setString(7,prpLclaimLosstgDto.getCurrency());
            dbManager.setDouble(8,prpLclaimLosstgDto.getSumClaim());
            dbManager.setDateTime(9,prpLclaimLosstgDto.getInputDate());
            dbManager.setString(10,prpLclaimLosstgDto.getRemarkFlag());
            dbManager.setString(11,prpLclaimLosstgDto.getFlag());
            dbManager.setString(12,prpLclaimLosstgDto.getLossFeeType());
            dbManager.setString(13,prpLclaimLosstgDto.getClaimNumber());
            dbManager.setString(14,prpLclaimLosstgDto.getItemDetailName());
            dbManager.setString(15,prpLclaimLosstgDto.getFeeCategory());
            dbManager.setDouble(16,prpLclaimLosstgDto.getKindLoss());
            dbManager.setDouble(17,prpLclaimLosstgDto.getKindRest());
            dbManager.setDouble(18,prpLclaimLosstgDto.getDeductibleRate());
            dbManager.setDouble(19,prpLclaimLosstgDto.getDeductible());
            dbManager.setDouble(20,prpLclaimLosstgDto.getAcciDeductibleRate());
            dbManager.setInt(21,prpLclaimLosstgDto.getFamilyNo());
            dbManager.setString(22,prpLclaimLosstgDto.getFamilyName());
            dbManager.setString(23,prpLclaimLosstgDto.getLicenseNo());
            dbManager.setString(24,prpLclaimLosstgDto.getFamilyNoZH());
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
        buffer.append("DELETE FROM PrpLclaimLosstg ");
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
     * @param prpLclaimLosstgDto prpLclaimLosstgDto
     * @throws Exception
     */
    public void update(PrpLclaimLosstgDto prpLclaimLosstgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaimLosstg SET ");
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
        buffer.append("FamilyNoZH = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLclaimLosstg SET ");
            debugBuffer.append("RiskCode = '" + prpLclaimLosstgDto.getRiskCode() + "', ");
            debugBuffer.append("ItemKindNo = " + prpLclaimLosstgDto.getItemKindNo() + ", ");
            debugBuffer.append("KindCode = '" + prpLclaimLosstgDto.getKindCode() + "', ");
            debugBuffer.append("ItemCode = '" + prpLclaimLosstgDto.getItemCode() + "', ");
            debugBuffer.append("Currency = '" + prpLclaimLosstgDto.getCurrency() + "', ");
            debugBuffer.append("SumClaim = " + prpLclaimLosstgDto.getSumClaim() + ", ");
            debugBuffer.append("InputDate = '" + prpLclaimLosstgDto.getInputDate() + "', ");
            debugBuffer.append("RemarkFlag = '" + prpLclaimLosstgDto.getRemarkFlag() + "', ");
            debugBuffer.append("Flag = '" + prpLclaimLosstgDto.getFlag() + "', ");
            debugBuffer.append("LossFeeType = '" + prpLclaimLosstgDto.getLossFeeType() + "', ");
            debugBuffer.append("ClaimNumber = '" + prpLclaimLosstgDto.getClaimNumber() + "', ");
            debugBuffer.append("ItemDetailName = '" + prpLclaimLosstgDto.getItemDetailName() + "', ");
            debugBuffer.append("FeeCategory = '" + prpLclaimLosstgDto.getFeeCategory() + "', ");
            debugBuffer.append("KindLoss = " + prpLclaimLosstgDto.getKindLoss() + ", ");
            debugBuffer.append("KindRest = " + prpLclaimLosstgDto.getKindRest() + ", ");
            debugBuffer.append("DeductibleRate = " + prpLclaimLosstgDto.getDeductibleRate() + ", ");
            debugBuffer.append("Deductible = " + prpLclaimLosstgDto.getDeductible() + ", ");
            debugBuffer.append("AcciDeductibleRate = " + prpLclaimLosstgDto.getAcciDeductibleRate() + ", ");
            debugBuffer.append("FamilyNo = " + prpLclaimLosstgDto.getFamilyNo() + ", ");
            debugBuffer.append("FamilyName = " + prpLclaimLosstgDto.getFamilyName() + " ");
            debugBuffer.append("FamilyNoZH = " + prpLclaimLosstgDto.getFamilyNoZH() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("ClaimNo=").append("'").append(prpLclaimLosstgDto.getClaimNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLclaimLosstgDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("ClaimNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLclaimLosstgDto.getRiskCode());
        dbManager.setInt(2,prpLclaimLosstgDto.getItemKindNo());
        dbManager.setString(3,prpLclaimLosstgDto.getKindCode());
        dbManager.setString(4,prpLclaimLosstgDto.getItemCode());
        dbManager.setString(5,prpLclaimLosstgDto.getCurrency());
        dbManager.setDouble(6,prpLclaimLosstgDto.getSumClaim());
        dbManager.setDateTime(7,prpLclaimLosstgDto.getInputDate());
        dbManager.setString(8,prpLclaimLosstgDto.getRemarkFlag());
        dbManager.setString(9,prpLclaimLosstgDto.getFlag());
        dbManager.setString(10,prpLclaimLosstgDto.getLossFeeType());
        dbManager.setString(12,prpLclaimLosstgDto.getClaimNumber());
        dbManager.setString(11,prpLclaimLosstgDto.getItemDetailName());
        dbManager.setString(12,prpLclaimLosstgDto.getFeeCategory());
        dbManager.setDouble(13,prpLclaimLosstgDto.getKindLoss());
        dbManager.setDouble(14,prpLclaimLosstgDto.getKindRest());
        dbManager.setDouble(15,prpLclaimLosstgDto.getDeductibleRate());
        dbManager.setDouble(16,prpLclaimLosstgDto.getDeductible());
        dbManager.setDouble(17,prpLclaimLosstgDto.getAcciDeductibleRate());
        dbManager.setInt(18,prpLclaimLosstgDto.getFamilyNo());
        dbManager.setString(19,prpLclaimLosstgDto.getFamilyName());
        dbManager.setString(20,prpLclaimLosstgDto.getLicenseNo());
        dbManager.setString(21,prpLclaimLosstgDto.getFamilyNoZH());
        //设置条件字段;
        dbManager.setString(22,prpLclaimLosstgDto.getClaimNo());
        dbManager.setInt(23,prpLclaimLosstgDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param claimNo 立案号
     * @param serialNo 序号
     * @return PrpLclaimLosstgDto
     * @throws Exception
     */
    public PrpLclaimLosstgDto findByPrimaryKey(String claimNo,int serialNo)
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
        buffer.append("FamilyNoZH ");
        buffer.append("FROM PrpLclaimLosstg ");
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
        PrpLclaimLosstgDto prpLclaimLosstgDto = null;
        if(resultSet.next()){
            prpLclaimLosstgDto = new PrpLclaimLosstgDto();
            prpLclaimLosstgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimLosstgDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLclaimLosstgDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLclaimLosstgDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpLclaimLosstgDto.setKindCode(dbManager.getString(resultSet,5));
            prpLclaimLosstgDto.setItemCode(dbManager.getString(resultSet,6));
            prpLclaimLosstgDto.setCurrency(dbManager.getString(resultSet,7));
            prpLclaimLosstgDto.setSumClaim(dbManager.getDouble(resultSet,8));
            prpLclaimLosstgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLclaimLosstgDto.setRemarkFlag(dbManager.getString(resultSet,10));
            prpLclaimLosstgDto.setFlag(dbManager.getString(resultSet,11));
            prpLclaimLosstgDto.setLossFeeType(dbManager.getString(resultSet,12));
            //yx
            prpLclaimLosstgDto.setClaimNumber(dbManager.getString(resultSet,13));
            prpLclaimLosstgDto.setItemDetailName(dbManager.getString(resultSet,14));
            prpLclaimLosstgDto.setFeeCategory(dbManager.getString(resultSet,15));
            prpLclaimLosstgDto.setKindLoss(dbManager.getDouble(resultSet,16));
            prpLclaimLosstgDto.setKindRest(dbManager.getDouble(resultSet,17));
            prpLclaimLosstgDto.setDeductibleRate(dbManager.getDouble(resultSet,18));
            prpLclaimLosstgDto.setDeductible(dbManager.getDouble(resultSet,19));
            prpLclaimLosstgDto.setAcciDeductibleRate(dbManager.getDouble(resultSet,20));
            prpLclaimLosstgDto.setFamilyNo(dbManager.getInt(resultSet,21));
            prpLclaimLosstgDto.setFamilyName(dbManager.getString(resultSet,22));
            prpLclaimLosstgDto.setLicenseNo(dbManager.getString(resultSet,23));
            prpLclaimLosstgDto.setFamilyNoZH(dbManager.getString(resultSet,24));
            
        }
        resultSet.close();
        return prpLclaimLosstgDto;
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
        buffer.append("FamilyNoZH ");
        buffer.append("FROM PrpLclaimLosstg WHERE ");
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
        PrpLclaimLosstgDto prpLclaimLosstgDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLclaimLosstgDto = new PrpLclaimLosstgDto();
            prpLclaimLosstgDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLclaimLosstgDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLclaimLosstgDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpLclaimLosstgDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpLclaimLosstgDto.setKindCode(dbManager.getString(resultSet,5));
            prpLclaimLosstgDto.setItemCode(dbManager.getString(resultSet,6));
            prpLclaimLosstgDto.setCurrency(dbManager.getString(resultSet,7));
            prpLclaimLosstgDto.setSumClaim(dbManager.getDouble(resultSet,8));
            prpLclaimLosstgDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,9));
            prpLclaimLosstgDto.setRemarkFlag(dbManager.getString(resultSet,10));
            prpLclaimLosstgDto.setFlag(dbManager.getString(resultSet,11));
            prpLclaimLosstgDto.setLossFeeType(dbManager.getString(resultSet,12));
            //yx
            prpLclaimLosstgDto.setClaimNumber(dbManager.getString(resultSet,13));
            prpLclaimLosstgDto.setItemDetailName(dbManager.getString(resultSet,14));
            prpLclaimLosstgDto.setFeeCategory(dbManager.getString(resultSet,15));
            prpLclaimLosstgDto.setKindLoss(dbManager.getDouble(resultSet,16));
            prpLclaimLosstgDto.setKindRest(dbManager.getDouble(resultSet,17));
            prpLclaimLosstgDto.setDeductibleRate(dbManager.getDouble(resultSet,18));
            prpLclaimLosstgDto.setDeductible(dbManager.getDouble(resultSet,19));
            prpLclaimLosstgDto.setAcciDeductibleRate(dbManager.getDouble(resultSet,20));
            prpLclaimLosstgDto.setFamilyNo(dbManager.getInt(resultSet,21));
            prpLclaimLosstgDto.setFamilyName(dbManager.getString(resultSet,22));
            prpLclaimLosstgDto.setLicenseNo(dbManager.getString(resultSet,23));
            prpLclaimLosstgDto.setFamilyNoZH(dbManager.getString(resultSet,24));
            collection.add(prpLclaimLosstgDto);
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
        buffer.append("DELETE FROM PrpLclaimLosstg WHERE ");
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
          statement = "SELECT count(1) FROM PrpLclaimLosstg WHERE ";
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

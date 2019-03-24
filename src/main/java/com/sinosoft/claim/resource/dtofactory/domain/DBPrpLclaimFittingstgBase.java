package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFittingstgDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimFittings的数据访问对象基类<br>
 * 创建于 2006-03-10 09:51:36.000<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLclaimFittingstgBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLclaimFittingstgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimFittingstgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimFittingstgDto prpLclaimFittingstgDto
     * @throws Exception
     */
    public void insert(PrpLclaimFittingstgDto prpLclaimFittingstgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimFittingstg (");
        buffer.append("RegistNo,");
        buffer.append("LossItemCode,");
        buffer.append("ModelCode,");
        buffer.append("LicenseNo,");
        buffer.append("ResultType,");
        buffer.append("SerialNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("FittingCode,");
        buffer.append("FittingName,");
        buffer.append("OriginalID,");
        buffer.append("IndId,");
        buffer.append("Sys4SPrice,");
        buffer.append("SysMarketPrice,");
        buffer.append("SysmatchPrice,");
        buffer.append("Native4SPrice,");
        buffer.append("NativeMarketPrice,");
        buffer.append("NativeMatchPrice,");
        buffer.append("MaxQuantity,");
        buffer.append("CertaSaved,");
        buffer.append("CertaPrice,");
        buffer.append("CertaQuantity,");
        buffer.append("VerifyPrice,");
        buffer.append("Remark,");
        buffer.append("Flag, ");
        buffer.append("PartId, ");
        buffer.append("OriginalName, ");
        buffer.append("PartGroupCode, ");
        buffer.append("PartGroupName, ");
        buffer.append("SumPrice, ");
        buffer.append("SelfConfigFlag, ");
        buffer.append("RepairSitePrice, ");
        buffer.append("ChgCompSetCode, ");
        buffer.append("ChgCompSetName, ");
        buffer.append("ChgRefPrice, ");
        buffer.append("ChgLocPrice, ");
        buffer.append("Remnant, ");
        buffer.append("Status ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getLossItemCode()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getModelCode()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getLicenseNo()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getResultType()).append("',");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getKindName()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getFittingCode()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getFittingName()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getOriginalID()).append("',");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getIndId()).append(",");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getSys4SPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getSysMarketPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getSysmatchPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getNative4SPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getNativeMarketPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getNativeMatchPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getMaxQuantity()).append(",");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getCertaSaved()).append("',");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getCertaPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getCertaQuantity()).append(",");
            debugBuffer.append("").append(prpLclaimFittingstgDto.getVerifyPrice()).append(",");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getFlag()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getPartId()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getOriginalName()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getPartGroupCode()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getPartGroupName()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getSumPrice()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getSelfConfigFlag()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getRepairSitePrice()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getChgCompSetCode()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getChgCompSetName()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getChgRefPrice()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getChgLocPrice()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getRemnant()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingstgDto.getStatus()).append("')");
            
            
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLclaimFittingstgDto.getRegistNo());
        dbManager.setString(2,prpLclaimFittingstgDto.getLossItemCode());
        dbManager.setString(3,prpLclaimFittingstgDto.getModelCode());
        dbManager.setString(4,prpLclaimFittingstgDto.getLicenseNo());
        dbManager.setString(5,prpLclaimFittingstgDto.getResultType());
        dbManager.setLong(6,prpLclaimFittingstgDto.getSerialNo());
        dbManager.setString(7,prpLclaimFittingstgDto.getKindCode());
        dbManager.setString(8,prpLclaimFittingstgDto.getKindName());
        dbManager.setString(9,prpLclaimFittingstgDto.getFittingCode());
        dbManager.setString(10,prpLclaimFittingstgDto.getFittingName());
        dbManager.setString(11,prpLclaimFittingstgDto.getOriginalID());
        dbManager.setInt(12,prpLclaimFittingstgDto.getIndId());
        dbManager.setDouble(13,prpLclaimFittingstgDto.getSys4SPrice());
        dbManager.setDouble(14,prpLclaimFittingstgDto.getSysMarketPrice());
        dbManager.setDouble(15,prpLclaimFittingstgDto.getSysmatchPrice());
        dbManager.setDouble(16,prpLclaimFittingstgDto.getNative4SPrice());
        dbManager.setDouble(17,prpLclaimFittingstgDto.getNativeMarketPrice());
        dbManager.setDouble(18,prpLclaimFittingstgDto.getNativeMatchPrice());
        dbManager.setLong(19,prpLclaimFittingstgDto.getMaxQuantity());
        dbManager.setString(20,prpLclaimFittingstgDto.getCertaSaved());
        dbManager.setDouble(21,prpLclaimFittingstgDto.getCertaPrice());
        dbManager.setLong(22,prpLclaimFittingstgDto.getCertaQuantity());
        dbManager.setDouble(23,prpLclaimFittingstgDto.getVerifyPrice());
        dbManager.setString(24,prpLclaimFittingstgDto.getRemark());
        dbManager.setString(25,prpLclaimFittingstgDto.getFlag());
        dbManager.setString(26, prpLclaimFittingstgDto.getPartId());
        dbManager.setString(27, prpLclaimFittingstgDto.getOriginalName());
        dbManager.setString(28, prpLclaimFittingstgDto.getPartGroupCode());
        dbManager.setString(29, prpLclaimFittingstgDto.getPartGroupName());
        dbManager.setDouble(30, prpLclaimFittingstgDto.getSumPrice());
        dbManager.setString(31, prpLclaimFittingstgDto.getSelfConfigFlag());
        dbManager.setDouble(32, prpLclaimFittingstgDto.getRepairSitePrice());
        dbManager.setString(33, prpLclaimFittingstgDto.getChgCompSetCode());
        dbManager.setString(34, prpLclaimFittingstgDto.getChgCompSetName());
        dbManager.setDouble(35, prpLclaimFittingstgDto.getChgRefPrice());
        dbManager.setDouble(36, prpLclaimFittingstgDto.getChgLocPrice());
        dbManager.setDouble(37, prpLclaimFittingstgDto.getRemnant());
        dbManager.setString(38, prpLclaimFittingstgDto.getStatus());
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
        buffer.append("INSERT INTO PrpLclaimFittingstg (");
        buffer.append("RegistNo,");
        buffer.append("LossItemCode,");
        buffer.append("ModelCode,");
        buffer.append("LicenseNo,");
        buffer.append("ResultType,");
        buffer.append("SerialNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("FittingCode,");
        buffer.append("FittingName,");
        buffer.append("OriginalID,");
        buffer.append("IndId,");
        buffer.append("Sys4SPrice,");
        buffer.append("SysMarketPrice,");
        buffer.append("SysmatchPrice,");
        buffer.append("Native4SPrice,");
        buffer.append("NativeMarketPrice,");
        buffer.append("NativeMatchPrice,");
        buffer.append("MaxQuantity,");
        buffer.append("CertaSaved,");
        buffer.append("CertaPrice,");
        buffer.append("CertaQuantity,");
        buffer.append("VerifyPrice,");
        buffer.append("Remark,");
        buffer.append("Flag, ");
        buffer.append("PartId, ");
        buffer.append("OriginalName, ");
        buffer.append("PartGroupCode, ");
        buffer.append("PartGroupName, ");
        buffer.append("SumPrice, ");
        buffer.append("SelfConfigFlag, ");
        buffer.append("RepairSitePrice, ");
        buffer.append("ChgCompSetCode, ");
        buffer.append("ChgCompSetName, ");
        buffer.append("ChgRefPrice, ");
        buffer.append("ChgLocPrice, ");
        buffer.append("Remnant, ");
        buffer.append("Status ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLclaimFittingstgDto prpLclaimFittingstgDto = (PrpLclaimFittingstgDto)i.next();
            dbManager.setString(1,prpLclaimFittingstgDto.getRegistNo());
            dbManager.setString(2,prpLclaimFittingstgDto.getLossItemCode());
            dbManager.setString(3,prpLclaimFittingstgDto.getModelCode());
            dbManager.setString(4,prpLclaimFittingstgDto.getLicenseNo());
            dbManager.setString(5,prpLclaimFittingstgDto.getResultType());
            dbManager.setLong(6,prpLclaimFittingstgDto.getSerialNo());
            dbManager.setString(7,prpLclaimFittingstgDto.getKindCode());
            dbManager.setString(8,prpLclaimFittingstgDto.getKindName());
            dbManager.setString(9,prpLclaimFittingstgDto.getFittingCode());
            dbManager.setString(10,prpLclaimFittingstgDto.getFittingName());
            dbManager.setString(11,prpLclaimFittingstgDto.getOriginalID());
            dbManager.setInt(12,prpLclaimFittingstgDto.getIndId());
            dbManager.setDouble(13,prpLclaimFittingstgDto.getSys4SPrice());
            dbManager.setDouble(14,prpLclaimFittingstgDto.getSysMarketPrice());
            dbManager.setDouble(15,prpLclaimFittingstgDto.getSysmatchPrice());
            dbManager.setDouble(16,prpLclaimFittingstgDto.getNative4SPrice());
            dbManager.setDouble(17,prpLclaimFittingstgDto.getNativeMarketPrice());
            dbManager.setDouble(18,prpLclaimFittingstgDto.getNativeMatchPrice());
            dbManager.setLong(19,prpLclaimFittingstgDto.getMaxQuantity());
            dbManager.setString(20,prpLclaimFittingstgDto.getCertaSaved());
            dbManager.setDouble(21,prpLclaimFittingstgDto.getCertaPrice());
            dbManager.setLong(22,prpLclaimFittingstgDto.getCertaQuantity());
            dbManager.setDouble(23,prpLclaimFittingstgDto.getVerifyPrice());
            dbManager.setString(24,prpLclaimFittingstgDto.getRemark());
            dbManager.setString(25,prpLclaimFittingstgDto.getFlag());
            dbManager.setString(26, prpLclaimFittingstgDto.getPartId());
            dbManager.setString(27, prpLclaimFittingstgDto.getOriginalName());
            dbManager.setString(28, prpLclaimFittingstgDto.getPartGroupCode());
            dbManager.setString(29, prpLclaimFittingstgDto.getPartGroupName());
            dbManager.setDouble(30, prpLclaimFittingstgDto.getSumPrice());
            dbManager.setString(31, prpLclaimFittingstgDto.getSelfConfigFlag());
            dbManager.setDouble(32, prpLclaimFittingstgDto.getRepairSitePrice());
            dbManager.setString(33, prpLclaimFittingstgDto.getChgCompSetCode());
            dbManager.setString(34, prpLclaimFittingstgDto.getChgCompSetName());
            dbManager.setDouble(35, prpLclaimFittingstgDto.getChgRefPrice());
            dbManager.setDouble(36, prpLclaimFittingstgDto.getChgLocPrice());
            dbManager.setDouble(37, prpLclaimFittingstgDto.getRemnant());
            dbManager.setString(38, prpLclaimFittingstgDto.getStatus());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param registNo RegistNo
     * @param lossItemCode LossItemCode
     * @param resultType ResultType
     * @param fittingCode FittingCode
     * @throws Exception
     */
    public void delete(String registNo,String lossItemCode,String resultType,String fittingCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLclaimFittingstg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("' AND ");
            debugBuffer.append("ResultType=").append("'").append(resultType).append("' AND ");
            debugBuffer.append("FittingCode=").append("'").append(fittingCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("LossItemCode = ? And ");
        buffer.append("ResultType = ? And ");
        buffer.append("FittingCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,lossItemCode);
        dbManager.setString(3,resultType);
        dbManager.setString(4,fittingCode);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLclaimFittingstgDto prpLclaimFittingstgDto
     * @throws Exception
     */
    public void update(PrpLclaimFittingstgDto prpLclaimFittingstgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaimFittingstg SET ");
        buffer.append("ModelCode = ?, ");
        buffer.append("LicenseNo = ?, ");
        buffer.append("SerialNo = ?, ");
        buffer.append("KindCode = ?, ");
        buffer.append("KindName = ?, ");
        buffer.append("FittingName = ?, ");
        buffer.append("OriginalID = ?, ");
        buffer.append("IndId = ?, ");
        buffer.append("Sys4SPrice = ?, ");
        buffer.append("SysMarketPrice = ?, ");
        buffer.append("SysmatchPrice = ?, ");
        buffer.append("Native4SPrice = ?, ");
        buffer.append("NativeMarketPrice = ?, ");
        buffer.append("NativeMatchPrice = ?, ");
        buffer.append("MaxQuantity = ?, ");
        buffer.append("CertaSaved = ?, ");
        buffer.append("CertaPrice = ?, ");
        buffer.append("CertaQuantity = ?, ");
        buffer.append("VerifyPrice = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Flag = ?, ");
        buffer.append("PartId = ?, ");
        buffer.append("OriginalName = ?, ");
        buffer.append("PartGroupCode = ?, ");
        buffer.append("PartGroupName = ?, ");
        buffer.append("SumPrice = ?, ");
        buffer.append("SelfConfigFlag = ?, ");
        buffer.append("RepairSitePrice = ?, ");
        buffer.append("ChgCompSetCode = ?, ");
        buffer.append("ChgCompSetName = ?, ");
        buffer.append("ChgRefPrice = ?, ");
        buffer.append("ChgLocPrice = ?, ");
        buffer.append("Remnant = ?, ");
        buffer.append("Status = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLclaimFittingstg SET ");
            debugBuffer.append("ModelCode = '" + prpLclaimFittingstgDto.getModelCode() + "', ");
            debugBuffer.append("LicenseNo = '" + prpLclaimFittingstgDto.getLicenseNo() + "', ");
            debugBuffer.append("SerialNo = " + prpLclaimFittingstgDto.getSerialNo() + ", ");
            debugBuffer.append("KindCode = '" + prpLclaimFittingstgDto.getKindCode() + "', ");
            debugBuffer.append("KindName = '" + prpLclaimFittingstgDto.getKindName() + "', ");
            debugBuffer.append("FittingName = '" + prpLclaimFittingstgDto.getFittingName() + "', ");
            debugBuffer.append("OriginalID = '" + prpLclaimFittingstgDto.getOriginalID() + "', ");
            debugBuffer.append("IndId = " + prpLclaimFittingstgDto.getIndId() + ", ");
            debugBuffer.append("Sys4SPrice = " + prpLclaimFittingstgDto.getSys4SPrice() + ", ");
            debugBuffer.append("SysMarketPrice = " + prpLclaimFittingstgDto.getSysMarketPrice() + ", ");
            debugBuffer.append("SysmatchPrice = " + prpLclaimFittingstgDto.getSysmatchPrice() + ", ");
            debugBuffer.append("Native4SPrice = " + prpLclaimFittingstgDto.getNative4SPrice() + ", ");
            debugBuffer.append("NativeMarketPrice = " + prpLclaimFittingstgDto.getNativeMarketPrice() + ", ");
            debugBuffer.append("NativeMatchPrice = " + prpLclaimFittingstgDto.getNativeMatchPrice() + ", ");
            debugBuffer.append("MaxQuantity = " + prpLclaimFittingstgDto.getMaxQuantity() + ", ");
            debugBuffer.append("CertaSaved = '" + prpLclaimFittingstgDto.getCertaSaved() + "', ");
            debugBuffer.append("CertaPrice = " + prpLclaimFittingstgDto.getCertaPrice() + ", ");
            debugBuffer.append("CertaQuantity = " + prpLclaimFittingstgDto.getCertaQuantity() + ", ");
            debugBuffer.append("VerifyPrice = " + prpLclaimFittingstgDto.getVerifyPrice() + ", ");
            debugBuffer.append("Remark = '" + prpLclaimFittingstgDto.getRemark() + "', ");
            debugBuffer.append("Flag = '" + prpLclaimFittingstgDto.getFlag() + "', ");
            debugBuffer.append("PartId ='" + prpLclaimFittingstgDto.getPartId() +"', ");
    		debugBuffer.append("OriginalName ='" + prpLclaimFittingstgDto.getOriginalName() +"', ");
    		debugBuffer.append("PartGroupCode ='" + prpLclaimFittingstgDto.getPartGroupCode() +"', ");
    		debugBuffer.append("PartGroupName ='" + prpLclaimFittingstgDto.getPartGroupName() +"', ");
    		debugBuffer.append("SumPrice ='" + prpLclaimFittingstgDto.getSumPrice() +"', ");
    		debugBuffer.append("SelfConfigFlag ='" + prpLclaimFittingstgDto.getSelfConfigFlag() +"', "); 
    		debugBuffer.append("RepairSitePrice ='" + prpLclaimFittingstgDto.getRepairSitePrice() +"', "); 
    		debugBuffer.append("ChgCompSetCode ='" + prpLclaimFittingstgDto.getChgCompSetCode() +"', "); 
    		debugBuffer.append("ChgCompSetName ='" + prpLclaimFittingstgDto.getChgCompSetName() +"', "); 
    		debugBuffer.append("ChgRefPrice ='" + prpLclaimFittingstgDto.getChgRefPrice() +"', "); 
    		debugBuffer.append("ChgLocPrice ='" + prpLclaimFittingstgDto.getChgLocPrice() +"', "); 
    		debugBuffer.append("Remnant ='" + prpLclaimFittingstgDto.getRemnant() +"', "); 
    		debugBuffer.append("Status ='" + prpLclaimFittingstgDto.getStatus() +"' ");  
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(prpLclaimFittingstgDto.getRegistNo()).append("' AND ");
            debugBuffer.append("LossItemCode=").append("'").append(prpLclaimFittingstgDto.getLossItemCode()).append("' AND ");
            debugBuffer.append("ResultType=").append("'").append(prpLclaimFittingstgDto.getResultType()).append("' AND ");
            debugBuffer.append("FittingCode=").append("'").append(prpLclaimFittingstgDto.getFittingCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("LossItemCode = ? And ");
        buffer.append("ResultType = ? And ");
        buffer.append("FittingCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLclaimFittingstgDto.getModelCode());
        dbManager.setString(2,prpLclaimFittingstgDto.getLicenseNo());
        dbManager.setLong(3,prpLclaimFittingstgDto.getSerialNo());
        dbManager.setString(4,prpLclaimFittingstgDto.getKindCode());
        dbManager.setString(5,prpLclaimFittingstgDto.getKindName());
        dbManager.setString(6,prpLclaimFittingstgDto.getFittingName());
        dbManager.setString(7,prpLclaimFittingstgDto.getOriginalID());
        dbManager.setInt(8,prpLclaimFittingstgDto.getIndId());
        dbManager.setDouble(9,prpLclaimFittingstgDto.getSys4SPrice());
        dbManager.setDouble(10,prpLclaimFittingstgDto.getSysMarketPrice());
        dbManager.setDouble(11,prpLclaimFittingstgDto.getSysmatchPrice());
        dbManager.setDouble(12,prpLclaimFittingstgDto.getNative4SPrice());
        dbManager.setDouble(13,prpLclaimFittingstgDto.getNativeMarketPrice());
        dbManager.setDouble(14,prpLclaimFittingstgDto.getNativeMatchPrice());
        dbManager.setLong(15,prpLclaimFittingstgDto.getMaxQuantity());
        dbManager.setString(16,prpLclaimFittingstgDto.getCertaSaved());
        dbManager.setDouble(17,prpLclaimFittingstgDto.getCertaPrice());
        dbManager.setLong(18,prpLclaimFittingstgDto.getCertaQuantity());
        dbManager.setDouble(19,prpLclaimFittingstgDto.getVerifyPrice());
        dbManager.setString(20,prpLclaimFittingstgDto.getRemark());
        dbManager.setString(21,prpLclaimFittingstgDto.getFlag());
        dbManager.setString(22, prpLclaimFittingstgDto.getPartId());
        dbManager.setString(23, prpLclaimFittingstgDto.getOriginalName());
        dbManager.setString(24, prpLclaimFittingstgDto.getPartGroupCode());
        dbManager.setString(25, prpLclaimFittingstgDto.getPartGroupName());
        dbManager.setDouble(26, prpLclaimFittingstgDto.getSumPrice());
        dbManager.setString(27, prpLclaimFittingstgDto.getSelfConfigFlag());
        dbManager.setDouble(28, prpLclaimFittingstgDto.getRepairSitePrice());
        dbManager.setString(29, prpLclaimFittingstgDto.getChgCompSetCode());
        dbManager.setString(30, prpLclaimFittingstgDto.getChgCompSetName());
        dbManager.setDouble(31, prpLclaimFittingstgDto.getChgRefPrice());
        dbManager.setDouble(32, prpLclaimFittingstgDto.getChgLocPrice());
        dbManager.setDouble(33, prpLclaimFittingstgDto.getRemnant());
        dbManager.setString(34, prpLclaimFittingstgDto.getStatus());
        
        //设置条件字段;
        dbManager.setString(35,prpLclaimFittingstgDto.getRegistNo());
        dbManager.setString(36,prpLclaimFittingstgDto.getLossItemCode());
        dbManager.setString(37,prpLclaimFittingstgDto.getResultType());
        dbManager.setString(38,prpLclaimFittingstgDto.getFittingCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registNo RegistNo
     * @param lossItemCode LossItemCode
     * @param resultType ResultType
     * @param fittingCode FittingCode
     * @return PrpLclaimFittingstgDto
     * @throws Exception
     */
    public PrpLclaimFittingstgDto findByPrimaryKey(String registNo,String lossItemCode,String resultType,String fittingCode)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("RegistNo,");
        buffer.append("LossItemCode,");
        buffer.append("ModelCode,");
        buffer.append("LicenseNo,");
        buffer.append("ResultType,");
        buffer.append("SerialNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("FittingCode,");
        buffer.append("FittingName,");
        buffer.append("OriginalID,");
        buffer.append("IndId,");
        buffer.append("Sys4SPrice,");
        buffer.append("SysMarketPrice,");
        buffer.append("SysmatchPrice,");
        buffer.append("Native4SPrice,");
        buffer.append("NativeMarketPrice,");
        buffer.append("NativeMatchPrice,");
        buffer.append("MaxQuantity,");
        buffer.append("CertaSaved,");
        buffer.append("CertaPrice,");
        buffer.append("CertaQuantity,");
        buffer.append("VerifyPrice,");
        buffer.append("Remark,");
        buffer.append("Flag,");
        buffer.append("PartId, ");
        buffer.append("OriginalName, ");
        buffer.append("PartGroupCode, ");
        buffer.append("PartGroupName, ");
        buffer.append("SumPrice, ");
        buffer.append("SelfConfigFlag, ");
        buffer.append("RepairSitePrice, ");
        buffer.append("ChgCompSetCode, ");
        buffer.append("ChgCompSetName, ");
        buffer.append("ChgRefPrice, ");
        buffer.append("ChgLocPrice, ");
        buffer.append("Remnant, ");
        buffer.append("Status ");
        buffer.append("FROM PrpLclaimFittingstg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(registNo).append("' AND ");
            debugBuffer.append("LossItemCode=").append("'").append(lossItemCode).append("' AND ");
            debugBuffer.append("ResultType=").append("'").append(resultType).append("' AND ");
            debugBuffer.append("FittingCode=").append("'").append(fittingCode).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("LossItemCode = ? And ");
        buffer.append("ResultType = ? And ");
        buffer.append("FittingCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,registNo);
        dbManager.setString(2,lossItemCode);
        dbManager.setString(3,resultType);
        dbManager.setString(4,fittingCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLclaimFittingstgDto prpLclaimFittingstgDto = null;
        if(resultSet.next()){
            prpLclaimFittingstgDto = new PrpLclaimFittingstgDto();
            prpLclaimFittingstgDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimFittingstgDto.setLossItemCode(dbManager.getString(resultSet,2));
            prpLclaimFittingstgDto.setModelCode(dbManager.getString(resultSet,3));
            prpLclaimFittingstgDto.setLicenseNo(dbManager.getString(resultSet,4));
            prpLclaimFittingstgDto.setResultType(dbManager.getString(resultSet,5));
            prpLclaimFittingstgDto.setSerialNo(dbManager.getLong(resultSet,6));
            prpLclaimFittingstgDto.setKindCode(dbManager.getString(resultSet,7));
            prpLclaimFittingstgDto.setKindName(dbManager.getString(resultSet,8));
            prpLclaimFittingstgDto.setFittingCode(dbManager.getString(resultSet,9));
            prpLclaimFittingstgDto.setFittingName(dbManager.getString(resultSet,10));
            prpLclaimFittingstgDto.setOriginalID(dbManager.getString(resultSet,11));
            prpLclaimFittingstgDto.setIndId(dbManager.getInt(resultSet,12));
            prpLclaimFittingstgDto.setSys4SPrice(dbManager.getDouble(resultSet,13));
            prpLclaimFittingstgDto.setSysMarketPrice(dbManager.getDouble(resultSet,14));
            prpLclaimFittingstgDto.setSysmatchPrice(dbManager.getDouble(resultSet,15));
            prpLclaimFittingstgDto.setNative4SPrice(dbManager.getDouble(resultSet,16));
            prpLclaimFittingstgDto.setNativeMarketPrice(dbManager.getDouble(resultSet,17));
            prpLclaimFittingstgDto.setNativeMatchPrice(dbManager.getDouble(resultSet,18));
            prpLclaimFittingstgDto.setMaxQuantity(dbManager.getLong(resultSet,19));
            prpLclaimFittingstgDto.setCertaSaved(dbManager.getString(resultSet,20));
            prpLclaimFittingstgDto.setCertaPrice(dbManager.getDouble(resultSet,21));
            prpLclaimFittingstgDto.setCertaQuantity(dbManager.getLong(resultSet,22));
            prpLclaimFittingstgDto.setVerifyPrice(dbManager.getDouble(resultSet,23));
            prpLclaimFittingstgDto.setRemark(dbManager.getString(resultSet,24));
            prpLclaimFittingstgDto.setFlag(dbManager.getString(resultSet,25));
            prpLclaimFittingstgDto.setPartId(dbManager.getString(resultSet,26));
            prpLclaimFittingstgDto.setOriginalName(dbManager.getString(resultSet,27));
            prpLclaimFittingstgDto.setPartGroupCode(dbManager.getString(resultSet,28));
            prpLclaimFittingstgDto.setPartGroupName(dbManager.getString(resultSet,29));
            prpLclaimFittingstgDto.setSumPrice(dbManager.getDouble(resultSet,30));
            prpLclaimFittingstgDto.setSelfConfigFlag(dbManager.getString(resultSet,31));
            prpLclaimFittingstgDto.setRepairSitePrice(dbManager.getDouble(resultSet,32));
            prpLclaimFittingstgDto.setChgCompSetCode(dbManager.getString(resultSet,33));
            prpLclaimFittingstgDto.setChgCompSetName(dbManager.getString(resultSet,34));
            prpLclaimFittingstgDto.setChgRefPrice(dbManager.getDouble(resultSet,35));
            prpLclaimFittingstgDto.setChgLocPrice(dbManager.getDouble(resultSet,36));
            prpLclaimFittingstgDto.setRemnant(dbManager.getDouble(resultSet,37));
            prpLclaimFittingstgDto.setStatus(dbManager.getString(resultSet,38));
        }
        resultSet.close();
        return prpLclaimFittingstgDto;
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
        buffer.append("RegistNo,");
        buffer.append("LossItemCode,");
        buffer.append("ModelCode,");
        buffer.append("LicenseNo,");
        buffer.append("ResultType,");
        buffer.append("SerialNo,");
        buffer.append("KindCode,");
        buffer.append("KindName,");
        buffer.append("FittingCode,");
        buffer.append("FittingName,");
        buffer.append("OriginalID,");
        buffer.append("IndId,");
        buffer.append("Sys4SPrice,");
        buffer.append("SysMarketPrice,");
        buffer.append("SysmatchPrice,");
        buffer.append("Native4SPrice,");
        buffer.append("NativeMarketPrice,");
        buffer.append("NativeMatchPrice,");
        buffer.append("MaxQuantity,");
        buffer.append("CertaSaved,");
        buffer.append("CertaPrice,");
        buffer.append("CertaQuantity,");
        buffer.append("VerifyPrice,");
        buffer.append("Remark,");
        buffer.append("Flag, ");
        buffer.append("PartId, ");
        buffer.append("OriginalName, ");
        buffer.append("PartGroupCode, ");
        buffer.append("PartGroupName, ");
        buffer.append("SumPrice, ");
        buffer.append("SelfConfigFlag, ");
        buffer.append("RepairSitePrice, ");
        buffer.append("ChgCompSetCode, ");
        buffer.append("ChgCompSetName, ");
        buffer.append("ChgRefPrice, ");
        buffer.append("ChgLocPrice, ");
        buffer.append("Remnant, ");
        buffer.append("Status ");
        buffer.append("FROM PrpLclaimFittingstg WHERE ");
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
        PrpLclaimFittingstgDto prpLclaimFittingstgDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLclaimFittingstgDto = new PrpLclaimFittingstgDto();
            prpLclaimFittingstgDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimFittingstgDto.setLossItemCode(dbManager.getString(resultSet,2));
            prpLclaimFittingstgDto.setModelCode(dbManager.getString(resultSet,3));
            prpLclaimFittingstgDto.setLicenseNo(dbManager.getString(resultSet,4));
            prpLclaimFittingstgDto.setResultType(dbManager.getString(resultSet,5));
            prpLclaimFittingstgDto.setSerialNo(dbManager.getLong(resultSet,6));
            prpLclaimFittingstgDto.setKindCode(dbManager.getString(resultSet,7));
            prpLclaimFittingstgDto.setKindName(dbManager.getString(resultSet,8));
            prpLclaimFittingstgDto.setFittingCode(dbManager.getString(resultSet,9));
            prpLclaimFittingstgDto.setFittingName(dbManager.getString(resultSet,10));
            prpLclaimFittingstgDto.setOriginalID(dbManager.getString(resultSet,11));
            prpLclaimFittingstgDto.setIndId(dbManager.getInt(resultSet,12));
            prpLclaimFittingstgDto.setSys4SPrice(dbManager.getDouble(resultSet,13));
            prpLclaimFittingstgDto.setSysMarketPrice(dbManager.getDouble(resultSet,14));
            prpLclaimFittingstgDto.setSysmatchPrice(dbManager.getDouble(resultSet,15));
            prpLclaimFittingstgDto.setNative4SPrice(dbManager.getDouble(resultSet,16));
            prpLclaimFittingstgDto.setNativeMarketPrice(dbManager.getDouble(resultSet,17));
            prpLclaimFittingstgDto.setNativeMatchPrice(dbManager.getDouble(resultSet,18));
            prpLclaimFittingstgDto.setMaxQuantity(dbManager.getLong(resultSet,19));
            prpLclaimFittingstgDto.setCertaSaved(dbManager.getString(resultSet,20));
            prpLclaimFittingstgDto.setCertaPrice(dbManager.getDouble(resultSet,21));
            prpLclaimFittingstgDto.setCertaQuantity(dbManager.getLong(resultSet,22));
            prpLclaimFittingstgDto.setVerifyPrice(dbManager.getDouble(resultSet,23));
            prpLclaimFittingstgDto.setRemark(dbManager.getString(resultSet,24));
            prpLclaimFittingstgDto.setFlag(dbManager.getString(resultSet,25));
            prpLclaimFittingstgDto.setPartId(dbManager.getString(resultSet,26));
            prpLclaimFittingstgDto.setOriginalName(dbManager.getString(resultSet,27));
            prpLclaimFittingstgDto.setPartGroupCode(dbManager.getString(resultSet,28));
            prpLclaimFittingstgDto.setPartGroupName(dbManager.getString(resultSet,29));
            prpLclaimFittingstgDto.setSumPrice(dbManager.getDouble(resultSet,30));
            prpLclaimFittingstgDto.setSelfConfigFlag(dbManager.getString(resultSet,31));
            prpLclaimFittingstgDto.setRepairSitePrice(dbManager.getDouble(resultSet,32));
            prpLclaimFittingstgDto.setChgCompSetCode(dbManager.getString(resultSet,33));
            prpLclaimFittingstgDto.setChgCompSetName(dbManager.getString(resultSet,34));
            prpLclaimFittingstgDto.setChgRefPrice(dbManager.getDouble(resultSet,35));
            prpLclaimFittingstgDto.setChgLocPrice(dbManager.getDouble(resultSet,36));
            prpLclaimFittingstgDto.setRemnant(dbManager.getDouble(resultSet,37));
            prpLclaimFittingstgDto.setStatus(dbManager.getString(resultSet,38));
            collection.add(prpLclaimFittingstgDto);
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
        buffer.append("DELETE FROM PrpLclaimFittingstg WHERE ");
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
          statement = "SELECT count(1) FROM PrpLclaimFittingstg WHERE ";
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

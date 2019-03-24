package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFittingsDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLclaimFittings的数据访问对象基类<br>
 * 创建于 2006-03-10 09:51:36.000<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLclaimFittingsBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Log logger = LogFactory.getLog(DBPrpLclaimFittingsBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLclaimFittingsBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLclaimFittingsDto prpLclaimFittingsDto
     * @throws Exception
     */
    public void insert(PrpLclaimFittingsDto prpLclaimFittingsDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLclaimFittings (");
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
            debugBuffer.append("'").append(prpLclaimFittingsDto.getRegistNo()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getLossItemCode()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getModelCode()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getLicenseNo()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getResultType()).append("',");
            debugBuffer.append("").append(prpLclaimFittingsDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getKindCode()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getKindName()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getFittingCode()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getFittingName()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getOriginalID()).append("',");
            debugBuffer.append("").append(prpLclaimFittingsDto.getIndId()).append(",");
            debugBuffer.append("").append(prpLclaimFittingsDto.getSys4SPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingsDto.getSysMarketPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingsDto.getSysmatchPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingsDto.getNative4SPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingsDto.getNativeMarketPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingsDto.getNativeMatchPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingsDto.getMaxQuantity()).append(",");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getCertaSaved()).append("',");
            debugBuffer.append("").append(prpLclaimFittingsDto.getCertaPrice()).append(",");
            debugBuffer.append("").append(prpLclaimFittingsDto.getCertaQuantity()).append(",");
            debugBuffer.append("").append(prpLclaimFittingsDto.getVerifyPrice()).append(",");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getRemark()).append("',");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getFlag()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getPartId()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getOriginalName()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getPartGroupCode()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getPartGroupName()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getSumPrice()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getSelfConfigFlag()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getRepairSitePrice()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getChgCompSetCode()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getChgCompSetName()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getChgRefPrice()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getChgLocPrice()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getRemnant()).append("',)");
            debugBuffer.append("'").append(prpLclaimFittingsDto.getStatus()).append("')");
            
            
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLclaimFittingsDto.getRegistNo());
        dbManager.setString(2,prpLclaimFittingsDto.getLossItemCode());
        dbManager.setString(3,prpLclaimFittingsDto.getModelCode());
        dbManager.setString(4,prpLclaimFittingsDto.getLicenseNo());
        dbManager.setString(5,prpLclaimFittingsDto.getResultType());
        dbManager.setLong(6,prpLclaimFittingsDto.getSerialNo());
        dbManager.setString(7,prpLclaimFittingsDto.getKindCode());
        dbManager.setString(8,prpLclaimFittingsDto.getKindName());
        dbManager.setString(9,prpLclaimFittingsDto.getFittingCode());
        dbManager.setString(10,prpLclaimFittingsDto.getFittingName());
        dbManager.setString(11,prpLclaimFittingsDto.getOriginalID());
        dbManager.setInt(12,prpLclaimFittingsDto.getIndId());
        dbManager.setDouble(13,prpLclaimFittingsDto.getSys4SPrice());
        dbManager.setDouble(14,prpLclaimFittingsDto.getSysMarketPrice());
        dbManager.setDouble(15,prpLclaimFittingsDto.getSysmatchPrice());
        dbManager.setDouble(16,prpLclaimFittingsDto.getNative4SPrice());
        dbManager.setDouble(17,prpLclaimFittingsDto.getNativeMarketPrice());
        dbManager.setDouble(18,prpLclaimFittingsDto.getNativeMatchPrice());
        dbManager.setLong(19,prpLclaimFittingsDto.getMaxQuantity());
        dbManager.setString(20,prpLclaimFittingsDto.getCertaSaved());
        dbManager.setDouble(21,prpLclaimFittingsDto.getCertaPrice());
        dbManager.setLong(22,prpLclaimFittingsDto.getCertaQuantity());
        dbManager.setDouble(23,prpLclaimFittingsDto.getVerifyPrice());
        dbManager.setString(24,prpLclaimFittingsDto.getRemark());
        dbManager.setString(25,prpLclaimFittingsDto.getFlag());
        dbManager.setString(26, prpLclaimFittingsDto.getPartId());
        dbManager.setString(27, prpLclaimFittingsDto.getOriginalName());
        dbManager.setString(28, prpLclaimFittingsDto.getPartGroupCode());
        dbManager.setString(29, prpLclaimFittingsDto.getPartGroupName());
        dbManager.setDouble(30, prpLclaimFittingsDto.getSumPrice());
        dbManager.setString(31, prpLclaimFittingsDto.getSelfConfigFlag());
        dbManager.setDouble(32, prpLclaimFittingsDto.getRepairSitePrice());
        dbManager.setString(33, prpLclaimFittingsDto.getChgCompSetCode());
        dbManager.setString(34, prpLclaimFittingsDto.getChgCompSetName());
        dbManager.setDouble(35, prpLclaimFittingsDto.getChgRefPrice());
        dbManager.setDouble(36, prpLclaimFittingsDto.getChgLocPrice());
        dbManager.setDouble(37, prpLclaimFittingsDto.getRemnant());
        dbManager.setString(38, prpLclaimFittingsDto.getStatus());
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
        buffer.append("INSERT INTO PrpLclaimFittings (");
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
            PrpLclaimFittingsDto prpLclaimFittingsDto = (PrpLclaimFittingsDto)i.next();
            dbManager.setString(1,prpLclaimFittingsDto.getRegistNo());
            dbManager.setString(2,prpLclaimFittingsDto.getLossItemCode());
            dbManager.setString(3,prpLclaimFittingsDto.getModelCode());
            dbManager.setString(4,prpLclaimFittingsDto.getLicenseNo());
            dbManager.setString(5,prpLclaimFittingsDto.getResultType());
            dbManager.setLong(6,prpLclaimFittingsDto.getSerialNo());
            dbManager.setString(7,prpLclaimFittingsDto.getKindCode());
            dbManager.setString(8,prpLclaimFittingsDto.getKindName());
            dbManager.setString(9,prpLclaimFittingsDto.getFittingCode());
            dbManager.setString(10,prpLclaimFittingsDto.getFittingName());
            dbManager.setString(11,prpLclaimFittingsDto.getOriginalID());
            dbManager.setInt(12,prpLclaimFittingsDto.getIndId());
            dbManager.setDouble(13,prpLclaimFittingsDto.getSys4SPrice());
            dbManager.setDouble(14,prpLclaimFittingsDto.getSysMarketPrice());
            dbManager.setDouble(15,prpLclaimFittingsDto.getSysmatchPrice());
            dbManager.setDouble(16,prpLclaimFittingsDto.getNative4SPrice());
            dbManager.setDouble(17,prpLclaimFittingsDto.getNativeMarketPrice());
            dbManager.setDouble(18,prpLclaimFittingsDto.getNativeMatchPrice());
            dbManager.setLong(19,prpLclaimFittingsDto.getMaxQuantity());
            dbManager.setString(20,prpLclaimFittingsDto.getCertaSaved());
            dbManager.setDouble(21,prpLclaimFittingsDto.getCertaPrice());
            dbManager.setLong(22,prpLclaimFittingsDto.getCertaQuantity());
            dbManager.setDouble(23,prpLclaimFittingsDto.getVerifyPrice());
            dbManager.setString(24,prpLclaimFittingsDto.getRemark());
            dbManager.setString(25,prpLclaimFittingsDto.getFlag());
            dbManager.setString(26, prpLclaimFittingsDto.getPartId());
            dbManager.setString(27, prpLclaimFittingsDto.getOriginalName());
            dbManager.setString(28, prpLclaimFittingsDto.getPartGroupCode());
            dbManager.setString(29, prpLclaimFittingsDto.getPartGroupName());
            dbManager.setDouble(30, prpLclaimFittingsDto.getSumPrice());
            dbManager.setString(31, prpLclaimFittingsDto.getSelfConfigFlag());
            dbManager.setDouble(32, prpLclaimFittingsDto.getRepairSitePrice());
            dbManager.setString(33, prpLclaimFittingsDto.getChgCompSetCode());
            dbManager.setString(34, prpLclaimFittingsDto.getChgCompSetName());
            dbManager.setDouble(35, prpLclaimFittingsDto.getChgRefPrice());
            dbManager.setDouble(36, prpLclaimFittingsDto.getChgLocPrice());
            dbManager.setDouble(37, prpLclaimFittingsDto.getRemnant());
            dbManager.setString(38, prpLclaimFittingsDto.getStatus());
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
        buffer.append("DELETE FROM PrpLclaimFittings ");
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
     * @param prpLclaimFittingsDto prpLclaimFittingsDto
     * @throws Exception
     */
    public void update(PrpLclaimFittingsDto prpLclaimFittingsDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLclaimFittings SET ");
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
            debugBuffer.append("UPDATE PrpLclaimFittings SET ");
            debugBuffer.append("ModelCode = '" + prpLclaimFittingsDto.getModelCode() + "', ");
            debugBuffer.append("LicenseNo = '" + prpLclaimFittingsDto.getLicenseNo() + "', ");
            debugBuffer.append("SerialNo = " + prpLclaimFittingsDto.getSerialNo() + ", ");
            debugBuffer.append("KindCode = '" + prpLclaimFittingsDto.getKindCode() + "', ");
            debugBuffer.append("KindName = '" + prpLclaimFittingsDto.getKindName() + "', ");
            debugBuffer.append("FittingName = '" + prpLclaimFittingsDto.getFittingName() + "', ");
            debugBuffer.append("OriginalID = '" + prpLclaimFittingsDto.getOriginalID() + "', ");
            debugBuffer.append("IndId = " + prpLclaimFittingsDto.getIndId() + ", ");
            debugBuffer.append("Sys4SPrice = " + prpLclaimFittingsDto.getSys4SPrice() + ", ");
            debugBuffer.append("SysMarketPrice = " + prpLclaimFittingsDto.getSysMarketPrice() + ", ");
            debugBuffer.append("SysmatchPrice = " + prpLclaimFittingsDto.getSysmatchPrice() + ", ");
            debugBuffer.append("Native4SPrice = " + prpLclaimFittingsDto.getNative4SPrice() + ", ");
            debugBuffer.append("NativeMarketPrice = " + prpLclaimFittingsDto.getNativeMarketPrice() + ", ");
            debugBuffer.append("NativeMatchPrice = " + prpLclaimFittingsDto.getNativeMatchPrice() + ", ");
            debugBuffer.append("MaxQuantity = " + prpLclaimFittingsDto.getMaxQuantity() + ", ");
            debugBuffer.append("CertaSaved = '" + prpLclaimFittingsDto.getCertaSaved() + "', ");
            debugBuffer.append("CertaPrice = " + prpLclaimFittingsDto.getCertaPrice() + ", ");
            debugBuffer.append("CertaQuantity = " + prpLclaimFittingsDto.getCertaQuantity() + ", ");
            debugBuffer.append("VerifyPrice = " + prpLclaimFittingsDto.getVerifyPrice() + ", ");
            debugBuffer.append("Remark = '" + prpLclaimFittingsDto.getRemark() + "', ");
            debugBuffer.append("Flag = '" + prpLclaimFittingsDto.getFlag() + "', ");
            debugBuffer.append("PartId ='" + prpLclaimFittingsDto.getPartId() +"', ");
    		debugBuffer.append("OriginalName ='" + prpLclaimFittingsDto.getOriginalName() +"', ");
    		debugBuffer.append("PartGroupCode ='" + prpLclaimFittingsDto.getPartGroupCode() +"', ");
    		debugBuffer.append("PartGroupName ='" + prpLclaimFittingsDto.getPartGroupName() +"', ");
    		debugBuffer.append("SumPrice ='" + prpLclaimFittingsDto.getSumPrice() +"', ");
    		debugBuffer.append("SelfConfigFlag ='" + prpLclaimFittingsDto.getSelfConfigFlag() +"', "); 
    		debugBuffer.append("RepairSitePrice ='" + prpLclaimFittingsDto.getRepairSitePrice() +"', "); 
    		debugBuffer.append("ChgCompSetCode ='" + prpLclaimFittingsDto.getChgCompSetCode() +"', "); 
    		debugBuffer.append("ChgCompSetName ='" + prpLclaimFittingsDto.getChgCompSetName() +"', "); 
    		debugBuffer.append("ChgRefPrice ='" + prpLclaimFittingsDto.getChgRefPrice() +"', "); 
    		debugBuffer.append("ChgLocPrice ='" + prpLclaimFittingsDto.getChgLocPrice() +"', "); 
    		debugBuffer.append("Remnant ='" + prpLclaimFittingsDto.getRemnant() +"', "); 
    		debugBuffer.append("Status ='" + prpLclaimFittingsDto.getStatus() +"' ");  
            debugBuffer.append("WHERE ");
            debugBuffer.append("RegistNo=").append("'").append(prpLclaimFittingsDto.getRegistNo()).append("' AND ");
            debugBuffer.append("LossItemCode=").append("'").append(prpLclaimFittingsDto.getLossItemCode()).append("' AND ");
            debugBuffer.append("ResultType=").append("'").append(prpLclaimFittingsDto.getResultType()).append("' AND ");
            debugBuffer.append("FittingCode=").append("'").append(prpLclaimFittingsDto.getFittingCode()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("RegistNo = ? And ");
        buffer.append("LossItemCode = ? And ");
        buffer.append("ResultType = ? And ");
        buffer.append("FittingCode = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLclaimFittingsDto.getModelCode());
        dbManager.setString(2,prpLclaimFittingsDto.getLicenseNo());
        dbManager.setLong(3,prpLclaimFittingsDto.getSerialNo());
        dbManager.setString(4,prpLclaimFittingsDto.getKindCode());
        dbManager.setString(5,prpLclaimFittingsDto.getKindName());
        dbManager.setString(6,prpLclaimFittingsDto.getFittingName());
        dbManager.setString(7,prpLclaimFittingsDto.getOriginalID());
        dbManager.setInt(8,prpLclaimFittingsDto.getIndId());
        dbManager.setDouble(9,prpLclaimFittingsDto.getSys4SPrice());
        dbManager.setDouble(10,prpLclaimFittingsDto.getSysMarketPrice());
        dbManager.setDouble(11,prpLclaimFittingsDto.getSysmatchPrice());
        dbManager.setDouble(12,prpLclaimFittingsDto.getNative4SPrice());
        dbManager.setDouble(13,prpLclaimFittingsDto.getNativeMarketPrice());
        dbManager.setDouble(14,prpLclaimFittingsDto.getNativeMatchPrice());
        dbManager.setLong(15,prpLclaimFittingsDto.getMaxQuantity());
        dbManager.setString(16,prpLclaimFittingsDto.getCertaSaved());
        dbManager.setDouble(17,prpLclaimFittingsDto.getCertaPrice());
        dbManager.setLong(18,prpLclaimFittingsDto.getCertaQuantity());
        dbManager.setDouble(19,prpLclaimFittingsDto.getVerifyPrice());
        dbManager.setString(20,prpLclaimFittingsDto.getRemark());
        dbManager.setString(21,prpLclaimFittingsDto.getFlag());
        dbManager.setString(22, prpLclaimFittingsDto.getPartId());
        dbManager.setString(23, prpLclaimFittingsDto.getOriginalName());
        dbManager.setString(24, prpLclaimFittingsDto.getPartGroupCode());
        dbManager.setString(25, prpLclaimFittingsDto.getPartGroupName());
        dbManager.setDouble(26, prpLclaimFittingsDto.getSumPrice());
        dbManager.setString(27, prpLclaimFittingsDto.getSelfConfigFlag());
        dbManager.setDouble(28, prpLclaimFittingsDto.getRepairSitePrice());
        dbManager.setString(29, prpLclaimFittingsDto.getChgCompSetCode());
        dbManager.setString(30, prpLclaimFittingsDto.getChgCompSetName());
        dbManager.setDouble(31, prpLclaimFittingsDto.getChgRefPrice());
        dbManager.setDouble(32, prpLclaimFittingsDto.getChgLocPrice());
        dbManager.setDouble(33, prpLclaimFittingsDto.getRemnant());
        dbManager.setString(34, prpLclaimFittingsDto.getStatus());
        
        //设置条件字段;
        dbManager.setString(35,prpLclaimFittingsDto.getRegistNo());
        dbManager.setString(36,prpLclaimFittingsDto.getLossItemCode());
        dbManager.setString(37,prpLclaimFittingsDto.getResultType());
        dbManager.setString(38,prpLclaimFittingsDto.getFittingCode());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param registNo RegistNo
     * @param lossItemCode LossItemCode
     * @param resultType ResultType
     * @param fittingCode FittingCode
     * @return PrpLclaimFittingsDto
     * @throws Exception
     */
    public PrpLclaimFittingsDto findByPrimaryKey(String registNo,String lossItemCode,String resultType,String fittingCode)
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
        buffer.append("FROM PrpLclaimFittings ");
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
        PrpLclaimFittingsDto prpLclaimFittingsDto = null;
        if(resultSet.next()){
            prpLclaimFittingsDto = new PrpLclaimFittingsDto();
            prpLclaimFittingsDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimFittingsDto.setLossItemCode(dbManager.getString(resultSet,2));
            prpLclaimFittingsDto.setModelCode(dbManager.getString(resultSet,3));
            prpLclaimFittingsDto.setLicenseNo(dbManager.getString(resultSet,4));
            prpLclaimFittingsDto.setResultType(dbManager.getString(resultSet,5));
            prpLclaimFittingsDto.setSerialNo(dbManager.getLong(resultSet,6));
            prpLclaimFittingsDto.setKindCode(dbManager.getString(resultSet,7));
            prpLclaimFittingsDto.setKindName(dbManager.getString(resultSet,8));
            prpLclaimFittingsDto.setFittingCode(dbManager.getString(resultSet,9));
            prpLclaimFittingsDto.setFittingName(dbManager.getString(resultSet,10));
            prpLclaimFittingsDto.setOriginalID(dbManager.getString(resultSet,11));
            prpLclaimFittingsDto.setIndId(dbManager.getInt(resultSet,12));
            prpLclaimFittingsDto.setSys4SPrice(dbManager.getDouble(resultSet,13));
            prpLclaimFittingsDto.setSysMarketPrice(dbManager.getDouble(resultSet,14));
            prpLclaimFittingsDto.setSysmatchPrice(dbManager.getDouble(resultSet,15));
            prpLclaimFittingsDto.setNative4SPrice(dbManager.getDouble(resultSet,16));
            prpLclaimFittingsDto.setNativeMarketPrice(dbManager.getDouble(resultSet,17));
            prpLclaimFittingsDto.setNativeMatchPrice(dbManager.getDouble(resultSet,18));
            prpLclaimFittingsDto.setMaxQuantity(dbManager.getLong(resultSet,19));
            prpLclaimFittingsDto.setCertaSaved(dbManager.getString(resultSet,20));
            prpLclaimFittingsDto.setCertaPrice(dbManager.getDouble(resultSet,21));
            prpLclaimFittingsDto.setCertaQuantity(dbManager.getLong(resultSet,22));
            prpLclaimFittingsDto.setVerifyPrice(dbManager.getDouble(resultSet,23));
            prpLclaimFittingsDto.setRemark(dbManager.getString(resultSet,24));
            prpLclaimFittingsDto.setFlag(dbManager.getString(resultSet,25));
            prpLclaimFittingsDto.setPartId(dbManager.getString(resultSet,26));
            prpLclaimFittingsDto.setOriginalName(dbManager.getString(resultSet,27));
            prpLclaimFittingsDto.setPartGroupCode(dbManager.getString(resultSet,28));
            prpLclaimFittingsDto.setPartGroupName(dbManager.getString(resultSet,29));
            prpLclaimFittingsDto.setSumPrice(dbManager.getDouble(resultSet,30));
            prpLclaimFittingsDto.setSelfConfigFlag(dbManager.getString(resultSet,31));
            prpLclaimFittingsDto.setRepairSitePrice(dbManager.getDouble(resultSet,32));
            prpLclaimFittingsDto.setChgCompSetCode(dbManager.getString(resultSet,33));
            prpLclaimFittingsDto.setChgCompSetName(dbManager.getString(resultSet,34));
            prpLclaimFittingsDto.setChgRefPrice(dbManager.getDouble(resultSet,35));
            prpLclaimFittingsDto.setChgLocPrice(dbManager.getDouble(resultSet,36));
            prpLclaimFittingsDto.setRemnant(dbManager.getDouble(resultSet,37));
            prpLclaimFittingsDto.setStatus(dbManager.getString(resultSet,38));
        }
        resultSet.close();
        return prpLclaimFittingsDto;
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
        buffer.append("FROM PrpLclaimFittings WHERE ");
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
        PrpLclaimFittingsDto prpLclaimFittingsDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLclaimFittingsDto = new PrpLclaimFittingsDto();
            prpLclaimFittingsDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLclaimFittingsDto.setLossItemCode(dbManager.getString(resultSet,2));
            prpLclaimFittingsDto.setModelCode(dbManager.getString(resultSet,3));
            prpLclaimFittingsDto.setLicenseNo(dbManager.getString(resultSet,4));
            prpLclaimFittingsDto.setResultType(dbManager.getString(resultSet,5));
            prpLclaimFittingsDto.setSerialNo(dbManager.getLong(resultSet,6));
            prpLclaimFittingsDto.setKindCode(dbManager.getString(resultSet,7));
            prpLclaimFittingsDto.setKindName(dbManager.getString(resultSet,8));
            prpLclaimFittingsDto.setFittingCode(dbManager.getString(resultSet,9));
            prpLclaimFittingsDto.setFittingName(dbManager.getString(resultSet,10));
            prpLclaimFittingsDto.setOriginalID(dbManager.getString(resultSet,11));
            prpLclaimFittingsDto.setIndId(dbManager.getInt(resultSet,12));
            prpLclaimFittingsDto.setSys4SPrice(dbManager.getDouble(resultSet,13));
            prpLclaimFittingsDto.setSysMarketPrice(dbManager.getDouble(resultSet,14));
            prpLclaimFittingsDto.setSysmatchPrice(dbManager.getDouble(resultSet,15));
            prpLclaimFittingsDto.setNative4SPrice(dbManager.getDouble(resultSet,16));
            prpLclaimFittingsDto.setNativeMarketPrice(dbManager.getDouble(resultSet,17));
            prpLclaimFittingsDto.setNativeMatchPrice(dbManager.getDouble(resultSet,18));
            prpLclaimFittingsDto.setMaxQuantity(dbManager.getLong(resultSet,19));
            prpLclaimFittingsDto.setCertaSaved(dbManager.getString(resultSet,20));
            prpLclaimFittingsDto.setCertaPrice(dbManager.getDouble(resultSet,21));
            prpLclaimFittingsDto.setCertaQuantity(dbManager.getLong(resultSet,22));
            prpLclaimFittingsDto.setVerifyPrice(dbManager.getDouble(resultSet,23));
            prpLclaimFittingsDto.setRemark(dbManager.getString(resultSet,24));
            prpLclaimFittingsDto.setFlag(dbManager.getString(resultSet,25));
            prpLclaimFittingsDto.setPartId(dbManager.getString(resultSet,26));
            prpLclaimFittingsDto.setOriginalName(dbManager.getString(resultSet,27));
            prpLclaimFittingsDto.setPartGroupCode(dbManager.getString(resultSet,28));
            prpLclaimFittingsDto.setPartGroupName(dbManager.getString(resultSet,29));
            prpLclaimFittingsDto.setSumPrice(dbManager.getDouble(resultSet,30));
            prpLclaimFittingsDto.setSelfConfigFlag(dbManager.getString(resultSet,31));
            prpLclaimFittingsDto.setRepairSitePrice(dbManager.getDouble(resultSet,32));
            prpLclaimFittingsDto.setChgCompSetCode(dbManager.getString(resultSet,33));
            prpLclaimFittingsDto.setChgCompSetName(dbManager.getString(resultSet,34));
            prpLclaimFittingsDto.setChgRefPrice(dbManager.getDouble(resultSet,35));
            prpLclaimFittingsDto.setChgLocPrice(dbManager.getDouble(resultSet,36));
            prpLclaimFittingsDto.setRemnant(dbManager.getDouble(resultSet,37));
            prpLclaimFittingsDto.setStatus(dbManager.getString(resultSet,38));
            collection.add(prpLclaimFittingsDto);
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
        buffer.append("DELETE FROM PrpLclaimFittings WHERE ");
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
          statement = "SELECT count(1) FROM PrpLclaimFittings WHERE ";
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

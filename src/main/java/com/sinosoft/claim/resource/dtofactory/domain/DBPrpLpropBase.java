package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLprop－财产核定损明细清单表的数据访问对象基类<br>
 * 创建于 2006-04-24 17:46:17.485<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLpropBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLpropBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLpropBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLpropDto prpLpropDto
     * @throws Exception
     */
    public void insert(PrpLpropDto prpLpropDto) throws Exception{
        String mainStatement = " Insert Into PrpLprop (" + 
                           " ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " RegistNo," + 
                           " ItemKindNo," + 
                           " FamilyNo," + 
                           " FamilyName," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " Currency," + 
                           " UnitPrice," + 
                           " LossQuantity," + 
                           " Unit," + 
                           " BuyDate," + 
                           " DepreRate," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag," + 
                           " VeriUnitPrice," + 
                           " VeriLossQuantity," + 
                           " VeriUnit," + 
                           " VeriDepreRate," + 
                           " VeriSumLoss," + 
                           " VeriSumReject," + 
                           " VeriRejectReason," + 
                           " VeriLossRate," + 
                           " VeriSumDefLoss," + 
                           " VeriRemark," + 
                           " CompensateBackFlag," + 
                           " modelNo," + 
                           " licenseNo," +
                           " imei )";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLpropDto.getClaimNo() + "'," + 
                           "'" + prpLpropDto.getRiskCode() + "'," + 
                           "'" + prpLpropDto.getPolicyNo() + "'," + 
                           "" + prpLpropDto.getSerialNo() + "," + 
                           "'" + prpLpropDto.getRegistNo() + "'," + 
                           "" + prpLpropDto.getItemKindNo() + "," + 
                           "" + prpLpropDto.getFamilyNo() + "," + 
                           "'" + prpLpropDto.getFamilyName() + "'," + 
                           "'" + prpLpropDto.getKindCode() + "'," + 
                           "'" + prpLpropDto.getItemCode() + "'," + 
                           "'" + prpLpropDto.getLossItemCode() + "'," + 
                           "'" + prpLpropDto.getLossItemName() + "'," + 
                           "'" + prpLpropDto.getFeeTypeCode() + "'," + 
                           "'" + prpLpropDto.getFeeTypeName() + "'," + 
                           "'" + prpLpropDto.getCurrency() + "'," + 
                           "'" + prpLpropDto.getUnitPrice() + "'," + 
                           "'" + prpLpropDto.getLossQuantity() + "'," + 
                           "'" + prpLpropDto.getUnit() + "'," + 
                           "'" + prpLpropDto.getBuyDate() + "'," + 
                           "'" + prpLpropDto.getDepreRate() + "'," + 
                           "'" + prpLpropDto.getSumLoss() + "'," + 
                           "'" + prpLpropDto.getSumReject() + "'," + 
                           "'" + prpLpropDto.getRejectReason() + "'," + 
                           "'" + prpLpropDto.getLossRate() + "'," + 
                           "'" + prpLpropDto.getSumDefLoss() + "'," + 
                           "'" + prpLpropDto.getRemark() + "'," + 
                           "'" + prpLpropDto.getFlag() + "'," + 
                           "'" + prpLpropDto.getVeriUnitPrice() + "'," + 
                           "'" + prpLpropDto.getVeriLossQuantity() + "'," + 
                           "'" + prpLpropDto.getVeriUnit() + "'," + 
                           "'" + prpLpropDto.getVeriDepreRate() + "'," + 
                           "'" + prpLpropDto.getVeriSumLoss() + "'," + 
                           "'" + prpLpropDto.getVeriSumReject() + "'," + 
                           "'" + prpLpropDto.getVeriRejectReason() + "'," + 
                           "'" + prpLpropDto.getVeriLossRate() + "'," + 
                           "'" + prpLpropDto.getVeriSumDefLoss() + "'," + 
                           "'" + prpLpropDto.getVeriRemark() + "'," + 
                           "'" + prpLpropDto.getCompensateBackFlag() + "'," + 
                           "'" + prpLpropDto.getImei() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLpropDto.getClaimNo());
        dbManager.setString(2,prpLpropDto.getRiskCode());
        dbManager.setString(3,prpLpropDto.getPolicyNo());
        dbManager.setInt(4,prpLpropDto.getSerialNo());
        dbManager.setString(5,prpLpropDto.getRegistNo());
        dbManager.setInt(6,prpLpropDto.getItemKindNo());
        dbManager.setInt(7,prpLpropDto.getFamilyNo());
        dbManager.setString(8,prpLpropDto.getFamilyName());
        dbManager.setString(9,prpLpropDto.getKindCode());
        dbManager.setString(10,prpLpropDto.getItemCode());
        dbManager.setString(11,prpLpropDto.getLossItemCode());
        dbManager.setString(12,prpLpropDto.getLossItemName());
        dbManager.setString(13,prpLpropDto.getFeeTypeCode());
        dbManager.setString(14,prpLpropDto.getFeeTypeName());
        dbManager.setString(15,prpLpropDto.getCurrency());
        dbManager.setDouble(16,prpLpropDto.getUnitPrice());
        dbManager.setDouble(17,prpLpropDto.getLossQuantity());
        dbManager.setString(18,prpLpropDto.getUnit());
        dbManager.setDateTime(19,prpLpropDto.getBuyDate());
        dbManager.setDouble(20,prpLpropDto.getDepreRate());
        dbManager.setDouble(21,prpLpropDto.getSumLoss());
        dbManager.setDouble(22,prpLpropDto.getSumReject());
        dbManager.setString(23,prpLpropDto.getRejectReason());
        dbManager.setDouble(24,prpLpropDto.getLossRate());
        dbManager.setDouble(25,prpLpropDto.getSumDefLoss());
        dbManager.setString(26,prpLpropDto.getRemark());
        dbManager.setString(27,prpLpropDto.getFlag());
        dbManager.setDouble(28,prpLpropDto.getVeriUnitPrice());
        dbManager.setDouble(29,prpLpropDto.getVeriLossQuantity());
        dbManager.setString(30,prpLpropDto.getVeriUnit());
        dbManager.setDouble(31,prpLpropDto.getVeriDepreRate());
        dbManager.setDouble(32,prpLpropDto.getVeriSumLoss());
        dbManager.setDouble(33,prpLpropDto.getVeriSumReject());
        dbManager.setString(34,prpLpropDto.getVeriRejectReason());
        dbManager.setDouble(35,prpLpropDto.getVeriLossRate());
        dbManager.setDouble(36,prpLpropDto.getVeriSumDefLoss());
        dbManager.setString(37,prpLpropDto.getVeriRemark());
        dbManager.setString(38,prpLpropDto.getCompensateBackFlag());
        dbManager.setString(39,prpLpropDto.getModelNo());
        dbManager.setString(40,prpLpropDto.getLicenseNo());
        dbManager.setString(41,prpLpropDto.getImei());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpropBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLpropDto prpLpropDto = (PrpLpropDto)i.next();
            insert(prpLpropDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param serialNo 序号
     * @param registNo 报案号
     * @throws Exception
     */
    public void delete(int serialNo,String registNo) throws Exception{
        String statement = " Delete From PrpLprop" + 
	            		   " Where " +
                           " SerialNo = ? And " + 
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLprop Where " +
                           " SerialNo = " + serialNo + " And " + 
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,serialNo);
        dbManager.setString(2,registNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLpropBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLpropDto prpLpropDto
     * @throws Exception
     */
    public void update(PrpLpropDto prpLpropDto) throws Exception{
        String statement = " Update PrpLprop Set ClaimNo = ?," + 
                           " RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " ItemKindNo = ?," + 
                           " FamilyNo = ?," + 
                           " FamilyName = ?," + 
                           " KindCode = ?," + 
                           " ItemCode = ?," + 
                           " LossItemCode = ?," + 
                           " LossItemName = ?," + 
                           " FeeTypeCode = ?," + 
                           " FeeTypeName = ?," + 
                           " Currency = ?," + 
                           " UnitPrice = ?," + 
                           " LossQuantity = ?," + 
                           " Unit = ?," + 
                           " BuyDate = ?," + 
                           " DepreRate = ?," + 
                           " SumLoss = ?," + 
                           " SumReject = ?," + 
                           " RejectReason = ?," + 
                           " LossRate = ?," + 
                           " SumDefLoss = ?," + 
                           " Remark = ?," + 
                           " Flag = ?," + 
                           " VeriUnitPrice = ?," + 
                           " VeriLossQuantity = ?," + 
                           " VeriUnit = ?," + 
                           " VeriDepreRate = ?," + 
                           " VeriSumLoss = ?," + 
                           " VeriSumReject = ?," + 
                           " VeriRejectReason = ?," + 
                           " VeriLossRate = ?," + 
                           " VeriSumDefLoss = ?," + 
                           " VeriRemark = ?," + 
                           " CompensateBackFlag = ?," + 
                           " modelNo = ?," + 
                           " licenseNo = ?," + 
                           " imei = ?" + 
	            		   " Where " +
                           " SerialNo = ? And " + 
                           " RegistNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLprop Set " + 
                           " ClaimNo = '" + prpLpropDto.getClaimNo() + "'," + 
                           " RiskCode = '" + prpLpropDto.getRiskCode() + "'," + 
                           " PolicyNo = '" + prpLpropDto.getPolicyNo() + "'," + 
                           " SerialNo = " + prpLpropDto.getSerialNo() + "," + 
                           " RegistNo = '" + prpLpropDto.getRegistNo() + "'," + 
                           " ItemKindNo = " + prpLpropDto.getItemKindNo() + "," + 
                           " FamilyNo = " + prpLpropDto.getFamilyNo() + "," + 
                           " FamilyName = '" + prpLpropDto.getFamilyName() + "'," + 
                           " KindCode = '" + prpLpropDto.getKindCode() + "'," + 
                           " ItemCode = '" + prpLpropDto.getItemCode() + "'," + 
                           " LossItemCode = '" + prpLpropDto.getLossItemCode() + "'," + 
                           " LossItemName = '" + prpLpropDto.getLossItemName() + "'," + 
                           " FeeTypeCode = '" + prpLpropDto.getFeeTypeCode() + "'," + 
                           " FeeTypeName = '" + prpLpropDto.getFeeTypeName() + "'," + 
                           " Currency = '" + prpLpropDto.getCurrency() + "'," + 
                           " UnitPrice = '" + prpLpropDto.getUnitPrice() + "'," + 
                           " LossQuantity = '" + prpLpropDto.getLossQuantity() + "'," + 
                           " Unit = '" + prpLpropDto.getUnit() + "'," + 
                           " BuyDate = '" + prpLpropDto.getBuyDate() + "'," + 
                           " DepreRate = '" + prpLpropDto.getDepreRate() + "'," + 
                           " SumLoss = '" + prpLpropDto.getSumLoss() + "'," + 
                           " SumReject = '" + prpLpropDto.getSumReject() + "'," + 
                           " RejectReason = '" + prpLpropDto.getRejectReason() + "'," + 
                           " LossRate = '" + prpLpropDto.getLossRate() + "'," + 
                           " SumDefLoss = '" + prpLpropDto.getSumDefLoss() + "'," + 
                           " Remark = '" + prpLpropDto.getRemark() + "'," + 
                           " Flag = '" + prpLpropDto.getFlag() + "'," + 
                           " VeriUnitPrice = '" + prpLpropDto.getVeriUnitPrice() + "'," + 
                           " VeriLossQuantity = '" + prpLpropDto.getVeriLossQuantity() + "'," + 
                           " VeriUnit = '" + prpLpropDto.getVeriUnit() + "'," + 
                           " VeriDepreRate = '" + prpLpropDto.getVeriDepreRate() + "'," + 
                           " VeriSumLoss = '" + prpLpropDto.getVeriSumLoss() + "'," + 
                           " VeriSumReject = '" + prpLpropDto.getVeriSumReject() + "'," + 
                           " VeriRejectReason = '" + prpLpropDto.getVeriRejectReason() + "'," + 
                           " VeriLossRate = '" + prpLpropDto.getVeriLossRate() + "'," + 
                           " VeriSumDefLoss = '" + prpLpropDto.getVeriSumDefLoss() + "'," + 
                           " VeriRemark = '" + prpLpropDto.getVeriRemark() + "'," + 
                           " CompensateBackFlag = '" + prpLpropDto.getCompensateBackFlag() + "'" + 
                           " modelNo = ?," + 
                           " licenseNo = ?" + 
                           " imei = ?" + 
			               " Where " +
                           " SerialNo = " + prpLpropDto.getSerialNo() + " And " + 
                           " RegistNo = '" + prpLpropDto.getRegistNo() + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLpropDto.getClaimNo());
        dbManager.setString(2,prpLpropDto.getRiskCode());
        dbManager.setString(3,prpLpropDto.getPolicyNo());
        dbManager.setInt(4,prpLpropDto.getItemKindNo());
        dbManager.setInt(5,prpLpropDto.getFamilyNo());
        dbManager.setString(6,prpLpropDto.getFamilyName());
        dbManager.setString(7,prpLpropDto.getKindCode());
        dbManager.setString(8,prpLpropDto.getItemCode());
        dbManager.setString(9,prpLpropDto.getLossItemCode());
        dbManager.setString(10,prpLpropDto.getLossItemName());
        dbManager.setString(11,prpLpropDto.getFeeTypeCode());
        dbManager.setString(12,prpLpropDto.getFeeTypeName());
        dbManager.setString(13,prpLpropDto.getCurrency());
        dbManager.setDouble(14,prpLpropDto.getUnitPrice());
        dbManager.setDouble(15,prpLpropDto.getLossQuantity());
        dbManager.setString(16,prpLpropDto.getUnit());
        dbManager.setDateTime(17,prpLpropDto.getBuyDate());
        dbManager.setDouble(18,prpLpropDto.getDepreRate());
        dbManager.setDouble(19,prpLpropDto.getSumLoss());
        dbManager.setDouble(20,prpLpropDto.getSumReject());
        dbManager.setString(21,prpLpropDto.getRejectReason());
        dbManager.setDouble(22,prpLpropDto.getLossRate());
        dbManager.setDouble(23,prpLpropDto.getSumDefLoss());
        dbManager.setString(24,prpLpropDto.getRemark());
        dbManager.setString(25,prpLpropDto.getFlag());
        dbManager.setDouble(26,prpLpropDto.getVeriUnitPrice());
        dbManager.setDouble(27,prpLpropDto.getVeriLossQuantity());
        dbManager.setString(28,prpLpropDto.getVeriUnit());
        dbManager.setDouble(29,prpLpropDto.getVeriDepreRate());
        dbManager.setDouble(30,prpLpropDto.getVeriSumLoss());
        dbManager.setDouble(31,prpLpropDto.getVeriSumReject());
        dbManager.setString(32,prpLpropDto.getVeriRejectReason());
        dbManager.setDouble(33,prpLpropDto.getVeriLossRate());
        dbManager.setDouble(34,prpLpropDto.getVeriSumDefLoss());
        dbManager.setString(35,prpLpropDto.getVeriRemark());
        dbManager.setString(36,prpLpropDto.getCompensateBackFlag());
        dbManager.setString(37,prpLpropDto.getModelNo());
        dbManager.setString(38,prpLpropDto.getLicenseNo());
        dbManager.setString(39,prpLpropDto.getImei());
        //设置条件字段;
        dbManager.setInt(40,prpLpropDto.getSerialNo());
        dbManager.setString(41,prpLpropDto.getRegistNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLpropBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param serialNo 序号
     * @param registNo 报案号
     * @return PrpLpropDto
     * @throws Exception
     */
    public PrpLpropDto findByPrimaryKey(int serialNo,String registNo) throws Exception{
        String mainStatement = " Select ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " RegistNo," + 
                           " ItemKindNo," + 
                           " FamilyNo," + 
                           " FamilyName," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " Currency," + 
                           " UnitPrice," + 
                           " LossQuantity," + 
                           " Unit," + 
                           " BuyDate," + 
                           " DepreRate," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag," + 
                           " VeriUnitPrice," + 
                           " VeriLossQuantity," + 
                           " VeriUnit," + 
                           " VeriDepreRate," + 
                           " VeriSumLoss," + 
                           " VeriSumReject," + 
                           " VeriRejectReason," + 
                           " VeriLossRate," + 
                           " VeriSumDefLoss," + 
                           " VeriRemark," + 
                           " CompensateBackFlag," + 
                           " modelNo," + 
                           " licenseNo," +
                           " imei From PrpLprop";
        String statement = mainStatement + " Where " +
                           " SerialNo = ? And " + 
                           " RegistNo = ?";
        PrpLpropDto prpLpropDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " SerialNo = " + serialNo + " And " + 
                           " RegistNo = '" + registNo + "'";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setInt(1,serialNo);
        dbManager.setString(2,registNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLpropDto = new PrpLpropDto();
            prpLpropDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLpropDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpropDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpropDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLpropDto.setRegistNo(dbManager.getString(resultSet,5));
            prpLpropDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLpropDto.setFamilyNo(dbManager.getInt(resultSet,7));
            prpLpropDto.setFamilyName(dbManager.getString(resultSet,8));
            prpLpropDto.setKindCode(dbManager.getString(resultSet,9));
            prpLpropDto.setItemCode(dbManager.getString(resultSet,10));
            prpLpropDto.setLossItemCode(dbManager.getString(resultSet,11));
            prpLpropDto.setLossItemName(dbManager.getString(resultSet,12));
            prpLpropDto.setFeeTypeCode(dbManager.getString(resultSet,13));
            prpLpropDto.setFeeTypeName(dbManager.getString(resultSet,14));
            prpLpropDto.setCurrency(dbManager.getString(resultSet,15));
            prpLpropDto.setUnitPrice(dbManager.getDouble(resultSet,16));
            prpLpropDto.setLossQuantity(dbManager.getDouble(resultSet,17));
            prpLpropDto.setUnit(dbManager.getString(resultSet,18));
            prpLpropDto.setBuyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLpropDto.setDepreRate(dbManager.getDouble(resultSet,20));
            prpLpropDto.setSumLoss(dbManager.getDouble(resultSet,21));
            prpLpropDto.setSumReject(dbManager.getDouble(resultSet,22));
            prpLpropDto.setRejectReason(dbManager.getString(resultSet,23));
            prpLpropDto.setLossRate(dbManager.getDouble(resultSet,24));
            prpLpropDto.setSumDefLoss(dbManager.getDouble(resultSet,25));
            prpLpropDto.setRemark(dbManager.getString(resultSet,26));
            prpLpropDto.setFlag(dbManager.getString(resultSet,27));
            prpLpropDto.setVeriUnitPrice(dbManager.getDouble(resultSet,28));
            prpLpropDto.setVeriLossQuantity(dbManager.getDouble(resultSet,29));
            prpLpropDto.setVeriUnit(dbManager.getString(resultSet,30));
            prpLpropDto.setVeriDepreRate(dbManager.getDouble(resultSet,31));
            prpLpropDto.setVeriSumLoss(dbManager.getDouble(resultSet,32));
            prpLpropDto.setVeriSumReject(dbManager.getDouble(resultSet,33));
            prpLpropDto.setVeriRejectReason(dbManager.getString(resultSet,34));
            prpLpropDto.setVeriLossRate(dbManager.getDouble(resultSet,35));
            prpLpropDto.setVeriSumDefLoss(dbManager.getDouble(resultSet,36));
            prpLpropDto.setVeriRemark(dbManager.getString(resultSet,37));
            prpLpropDto.setCompensateBackFlag(dbManager.getString(resultSet,38));
            prpLpropDto.setModelNo(dbManager.getString(resultSet,39));
            prpLpropDto.setLicenseNo(dbManager.getString(resultSet,40));
            prpLpropDto.setImei(dbManager.getString(resultSet,41));
        }
        resultSet.close();
        logger.info("DBPrpLpropBase.findByPrimaryKey() success!");
        return prpLpropDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select ClaimNo," + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " RegistNo," + 
                           " ItemKindNo," + 
                           " FamilyNo," + 
                           " FamilyName," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " LossItemCode," + 
                           " LossItemName," + 
                           " FeeTypeCode," + 
                           " FeeTypeName," + 
                           " Currency," + 
                           " UnitPrice," + 
                           " LossQuantity," + 
                           " Unit," + 
                           " BuyDate," + 
                           " DepreRate," + 
                           " SumLoss," + 
                           " SumReject," + 
                           " RejectReason," + 
                           " LossRate," + 
                           " SumDefLoss," + 
                           " Remark," + 
                           " Flag," + 
                           " VeriUnitPrice," + 
                           " VeriLossQuantity," + 
                           " VeriUnit," + 
                           " VeriDepreRate," + 
                           " VeriSumLoss," + 
                           " VeriSumReject," + 
                           " VeriRejectReason," + 
                           " VeriLossRate," + 
                           " VeriSumDefLoss," + 
                           " VeriRemark," + 
                           " CompensateBackFlag," + 
                           " modelNo," + 
                           " licenseNo," +
                           " imei From PrpLprop Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLpropDto prpLpropDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLpropDto = new PrpLpropDto();
            prpLpropDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLpropDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLpropDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLpropDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpLpropDto.setRegistNo(dbManager.getString(resultSet,5));
            prpLpropDto.setItemKindNo(dbManager.getInt(resultSet,6));
            prpLpropDto.setFamilyNo(dbManager.getInt(resultSet,7));
            prpLpropDto.setFamilyName(dbManager.getString(resultSet,8));
            prpLpropDto.setKindCode(dbManager.getString(resultSet,9));
            prpLpropDto.setItemCode(dbManager.getString(resultSet,10));
            prpLpropDto.setLossItemCode(dbManager.getString(resultSet,11));
            prpLpropDto.setLossItemName(dbManager.getString(resultSet,12));
            prpLpropDto.setFeeTypeCode(dbManager.getString(resultSet,13));
            prpLpropDto.setFeeTypeName(dbManager.getString(resultSet,14));
            prpLpropDto.setCurrency(dbManager.getString(resultSet,15));
            prpLpropDto.setUnitPrice(dbManager.getDouble(resultSet,16));
            prpLpropDto.setLossQuantity(dbManager.getDouble(resultSet,17));
            prpLpropDto.setUnit(dbManager.getString(resultSet,18));
            prpLpropDto.setBuyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpLpropDto.setDepreRate(dbManager.getDouble(resultSet,20));
            prpLpropDto.setSumLoss(dbManager.getDouble(resultSet,21));
            prpLpropDto.setSumReject(dbManager.getDouble(resultSet,22));
            prpLpropDto.setRejectReason(dbManager.getString(resultSet,23));
            prpLpropDto.setLossRate(dbManager.getDouble(resultSet,24));
            prpLpropDto.setSumDefLoss(dbManager.getDouble(resultSet,25));
            prpLpropDto.setRemark(dbManager.getString(resultSet,26));
            prpLpropDto.setFlag(dbManager.getString(resultSet,27));
            prpLpropDto.setVeriUnitPrice(dbManager.getDouble(resultSet,28));
            prpLpropDto.setVeriLossQuantity(dbManager.getDouble(resultSet,29));
            prpLpropDto.setVeriUnit(dbManager.getString(resultSet,30));
            prpLpropDto.setVeriDepreRate(dbManager.getDouble(resultSet,31));
            prpLpropDto.setVeriSumLoss(dbManager.getDouble(resultSet,32));
            prpLpropDto.setVeriSumReject(dbManager.getDouble(resultSet,33));
            prpLpropDto.setVeriRejectReason(dbManager.getString(resultSet,34));
            prpLpropDto.setVeriLossRate(dbManager.getDouble(resultSet,35));
            prpLpropDto.setVeriSumDefLoss(dbManager.getDouble(resultSet,36));
            prpLpropDto.setVeriRemark(dbManager.getString(resultSet,37));
            prpLpropDto.setCompensateBackFlag(dbManager.getString(resultSet,38));
            prpLpropDto.setModelNo(dbManager.getString(resultSet,39));
            prpLpropDto.setLicenseNo(dbManager.getString(resultSet,40));
            prpLpropDto.setImei(dbManager.getString(resultSet,41));
            collection.add(prpLpropDto);
        }
        resultSet.close();
        logger.info("DBPrpLpropBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpLprop Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLpropBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLprop Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLpropBase.getCount() success!");
        return count;
    }
}

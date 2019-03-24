package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPitemKindDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppitemkind标的子险信息的数据访问对象基类<br>
 * 创建于 2004-11-22 15:24:18.109<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPitemKindBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpPitemKindBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPitemKindBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpPitemKindDto prpPitemKindDto
     * @throws Exception
     */
    public void insert(PrpPitemKindDto prpPitemKindDto) throws Exception{
        String mainStatement = " Insert Into PrpPitemKind (" +
                           " EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " ItemKindNo," +
                           " FamilyNo," +
                           " FamilyName," +
                           " KindCode," +
                           " KindName," +
                           " ItemNo," +
                           " ItemCode," +
                           " ItemDetailName," +
                           " ModeCode," +
                           " ModeName," +
                           " StartDate," +
                           " StartHour," +
                           " EndDate," +
                           " EndHour," +
                           " Model," +
                           " BuyDate," +
                           " AddressNo," +
                           " CalculateFlag," +
                           " Currency," +
                           " UnitAmount," +
                           " Quantity," +
                           " Unit," +
                           " Value," +
                           " Amount," +
                           " RatePeriod," +
                           " Rate," +
                           " ShortRateFlag," +
                           " ShortRate," +
                           " BasePremium," +
                           " BenchMarkPremium," +
                           " Discount," +
                           " AdjustRate," +
                           " Premium," +
                           " DeductibleRate," +
                           " Deductible," +
                           " Flag," +
                           " ChgQuantity," +
                           " ChgAmount," +
                           " ChgPremium," +
                           " Remark)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpPitemKindDto.getEndorseNo() + "'," +
                           "'" + prpPitemKindDto.getPolicyNo() + "'," +
                           "'" + prpPitemKindDto.getRiskCode() + "'," +
                           "" + prpPitemKindDto.getItemKindNo() + "," +
                           "" + prpPitemKindDto.getFamilyNo() + "," +
                           "'" + prpPitemKindDto.getFamilyName() + "'," +
                           "'" + prpPitemKindDto.getKindCode() + "'," +
                           "'" + prpPitemKindDto.getKindName() + "'," +
                           "" + prpPitemKindDto.getItemNo() + "," +
                           "'" + prpPitemKindDto.getItemCode() + "'," +
                           "'" + prpPitemKindDto.getItemDetailName() + "'," +
                           "'" + prpPitemKindDto.getModeCode() + "'," +
                           "'" + prpPitemKindDto.getModeName() + "'," +
                           "'" + prpPitemKindDto.getStartDate() + "'," +
                           "" + prpPitemKindDto.getStartHour() + "," +
                           "'" + prpPitemKindDto.getEndDate() + "'," +
                           "" + prpPitemKindDto.getEndHour() + "," +
                           "'" + prpPitemKindDto.getModel() + "'," +
                           "'" + prpPitemKindDto.getBuyDate() + "'," +
                           "" + prpPitemKindDto.getAddressNo() + "," +
                           "'" + prpPitemKindDto.getCalculateFlag() + "'," +
                           "'" + prpPitemKindDto.getCurrency() + "'," +
                           "'" + prpPitemKindDto.getUnitAmount() + "'," +
                           "'" + prpPitemKindDto.getQuantity() + "'," +
                           "'" + prpPitemKindDto.getUnit() + "'," +
                           "'" + prpPitemKindDto.getValue() + "'," +
                           "'" + prpPitemKindDto.getAmount() + "'," +
                           "" + prpPitemKindDto.getRatePeriod() + "," +
                           "'" + prpPitemKindDto.getRate() + "'," +
                           "'" + prpPitemKindDto.getShortRateFlag() + "'," +
                           "'" + prpPitemKindDto.getShortRate() + "'," +
                           "'" + prpPitemKindDto.getBasePremium() + "'," +
                           "'" + prpPitemKindDto.getBenchMarkPremium() + "'," +
                           "'" + prpPitemKindDto.getDiscount() + "'," +
                           "'" + prpPitemKindDto.getAdjustRate() + "'," +
                           "'" + prpPitemKindDto.getPremium() + "'," +
                           "'" + prpPitemKindDto.getDeductibleRate() + "'," +
                           "'" + prpPitemKindDto.getDeductible() + "'," +
                           "'" + prpPitemKindDto.getFlag() + "'," +
                           "'" + prpPitemKindDto.getChgQuantity() + "'," +
                           "'" + prpPitemKindDto.getChgAmount() + "'," +
                           "'" + prpPitemKindDto.getChgPremium() + "'," +
                           "'" + prpPitemKindDto.getRemark() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpPitemKindDto.getEndorseNo());
        dbManager.setString(2,prpPitemKindDto.getPolicyNo());
        dbManager.setString(3,prpPitemKindDto.getRiskCode());
        dbManager.setInt(4,prpPitemKindDto.getItemKindNo());
        dbManager.setInt(5,prpPitemKindDto.getFamilyNo());
        dbManager.setString(6,prpPitemKindDto.getFamilyName());
        dbManager.setString(7,prpPitemKindDto.getKindCode());
        dbManager.setString(8,prpPitemKindDto.getKindName());
        dbManager.setInt(9,prpPitemKindDto.getItemNo());
        dbManager.setString(10,prpPitemKindDto.getItemCode());
        dbManager.setString(11,prpPitemKindDto.getItemDetailName());
        dbManager.setString(12,prpPitemKindDto.getModeCode());
        dbManager.setString(13,prpPitemKindDto.getModeName());
        dbManager.setDateTime(14,prpPitemKindDto.getStartDate());
        dbManager.setInt(15,prpPitemKindDto.getStartHour());
        dbManager.setDateTime(16,prpPitemKindDto.getEndDate());
        dbManager.setInt(17,prpPitemKindDto.getEndHour());
        dbManager.setString(18,prpPitemKindDto.getModel());
        dbManager.setDateTime(19,prpPitemKindDto.getBuyDate());
        dbManager.setInt(20,prpPitemKindDto.getAddressNo());
        dbManager.setString(21,prpPitemKindDto.getCalculateFlag());
        dbManager.setString(22,prpPitemKindDto.getCurrency());
        dbManager.setDouble(23,prpPitemKindDto.getUnitAmount());
        dbManager.setDouble(24,prpPitemKindDto.getQuantity());
        dbManager.setString(25,prpPitemKindDto.getUnit());
        dbManager.setDouble(26,prpPitemKindDto.getValue());
        dbManager.setDouble(27,prpPitemKindDto.getAmount());
        dbManager.setInt(28,prpPitemKindDto.getRatePeriod());
        dbManager.setDouble(29,prpPitemKindDto.getRate());
        dbManager.setString(30,prpPitemKindDto.getShortRateFlag());
        dbManager.setDouble(31,prpPitemKindDto.getShortRate());
        dbManager.setDouble(32,prpPitemKindDto.getBasePremium());
        dbManager.setDouble(33,prpPitemKindDto.getBenchMarkPremium());
        dbManager.setDouble(34,prpPitemKindDto.getDiscount());
        dbManager.setDouble(35,prpPitemKindDto.getAdjustRate());
        dbManager.setDouble(36,prpPitemKindDto.getPremium());
        dbManager.setDouble(37,prpPitemKindDto.getDeductibleRate());
        dbManager.setDouble(38,prpPitemKindDto.getDeductible());
        dbManager.setString(39,prpPitemKindDto.getFlag());
        dbManager.setDouble(40,prpPitemKindDto.getChgQuantity());
        dbManager.setDouble(41,prpPitemKindDto.getChgAmount());
        dbManager.setDouble(42,prpPitemKindDto.getChgPremium());
        dbManager.setString(43,prpPitemKindDto.getRemark());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPitemKindBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpPitemKindDto prpPitemKindDto = (PrpPitemKindDto)i.next();
            insert(prpPitemKindDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param endorseNo 批单号码
     * @param itemKindNo 序号
     * @throws Exception
     */
    public void delete(String endorseNo,int itemKindNo) throws Exception{
        String statement = " Delete From PrpPitemKind" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " ItemKindNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpPitemKind Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " ItemKindNo = " + itemKindNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setInt(2,itemKindNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpPitemKindBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpPitemKindDto prpPitemKindDto
     * @throws Exception
     */
    public void update(PrpPitemKindDto prpPitemKindDto) throws Exception{
        String statement = " Update PrpPitemKind Set PolicyNo = ?," +
                           " RiskCode = ?," +
                           " FamilyNo = ?," +
                           " FamilyName = ?," +
                           " KindCode = ?," +
                           " KindName = ?," +
                           " ItemNo = ?," +
                           " ItemCode = ?," +
                           " ItemDetailName = ?," +
                           " ModeCode = ?," +
                           " ModeName = ?," +
                           " StartDate = ?," +
                           " StartHour = ?," +
                           " EndDate = ?," +
                           " EndHour = ?," +
                           " Model = ?," +
                           " BuyDate = ?," +
                           " AddressNo = ?," +
                           " CalculateFlag = ?," +
                           " Currency = ?," +
                           " UnitAmount = ?," +
                           " Quantity = ?," +
                           " Unit = ?," +
                           " Value = ?," +
                           " Amount = ?," +
                           " RatePeriod = ?," +
                           " Rate = ?," +
                           " ShortRateFlag = ?," +
                           " ShortRate = ?," +
                           " BasePremium = ?," +
                           " BenchMarkPremium = ?," +
                           " Discount = ?," +
                           " AdjustRate = ?," +
                           " Premium = ?," +
                           " DeductibleRate = ?," +
                           " Deductible = ?," +
                           " Flag = ?," +
                           " ChgQuantity = ?," +
                           " ChgAmount = ?," +
                           " ChgPremium = ?" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " ItemKindNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpPitemKind Set " +
                           " EndorseNo = '" + prpPitemKindDto.getEndorseNo() + "'," +
                           " PolicyNo = '" + prpPitemKindDto.getPolicyNo() + "'," +
                           " RiskCode = '" + prpPitemKindDto.getRiskCode() + "'," +
                           " ItemKindNo = " + prpPitemKindDto.getItemKindNo() + "," +
                           " FamilyNo = " + prpPitemKindDto.getFamilyNo() + "," +
                           " FamilyName = '" + prpPitemKindDto.getFamilyName() + "'," +
                           " KindCode = '" + prpPitemKindDto.getKindCode() + "'," +
                           " KindName = '" + prpPitemKindDto.getKindName() + "'," +
                           " ItemNo = " + prpPitemKindDto.getItemNo() + "," +
                           " ItemCode = '" + prpPitemKindDto.getItemCode() + "'," +
                           " ItemDetailName = '" + prpPitemKindDto.getItemDetailName() + "'," +
                           " ModeCode = '" + prpPitemKindDto.getModeCode() + "'," +
                           " ModeName = '" + prpPitemKindDto.getModeName() + "'," +
                           " StartDate = '" + prpPitemKindDto.getStartDate() + "'," +
                           " StartHour = " + prpPitemKindDto.getStartHour() + "," +
                           " EndDate = '" + prpPitemKindDto.getEndDate() + "'," +
                           " EndHour = " + prpPitemKindDto.getEndHour() + "," +
                           " Model = '" + prpPitemKindDto.getModel() + "'," +
                           " BuyDate = '" + prpPitemKindDto.getBuyDate() + "'," +
                           " AddressNo = " + prpPitemKindDto.getAddressNo() + "," +
                           " CalculateFlag = '" + prpPitemKindDto.getCalculateFlag() + "'," +
                           " Currency = '" + prpPitemKindDto.getCurrency() + "'," +
                           " UnitAmount = '" + prpPitemKindDto.getUnitAmount() + "'," +
                           " Quantity = '" + prpPitemKindDto.getQuantity() + "'," +
                           " Unit = '" + prpPitemKindDto.getUnit() + "'," +
                           " Value = '" + prpPitemKindDto.getValue() + "'," +
                           " Amount = '" + prpPitemKindDto.getAmount() + "'," +
                           " RatePeriod = " + prpPitemKindDto.getRatePeriod() + "," +
                           " Rate = '" + prpPitemKindDto.getRate() + "'," +
                           " ShortRateFlag = '" + prpPitemKindDto.getShortRateFlag() + "'," +
                           " ShortRate = '" + prpPitemKindDto.getShortRate() + "'," +
                           " BasePremium = '" + prpPitemKindDto.getBasePremium() + "'," +
                           " BenchMarkPremium = '" + prpPitemKindDto.getBenchMarkPremium() + "'," +
                           " Discount = '" + prpPitemKindDto.getDiscount() + "'," +
                           " AdjustRate = '" + prpPitemKindDto.getAdjustRate() + "'," +
                           " Premium = '" + prpPitemKindDto.getPremium() + "'," +
                           " DeductibleRate = '" + prpPitemKindDto.getDeductibleRate() + "'," +
                           " Deductible = '" + prpPitemKindDto.getDeductible() + "'," +
                           " Flag = '" + prpPitemKindDto.getFlag() + "'," +
                           " ChgQuantity = '" + prpPitemKindDto.getChgQuantity() + "'," +
                           " ChgAmount = '" + prpPitemKindDto.getChgAmount() + "'," +
                           " ChgPremium = '" + prpPitemKindDto.getChgPremium() + "'" +
			               " Where " +
                           " EndorseNo = '" + prpPitemKindDto.getEndorseNo() + "' And " +
                           " ItemKindNo = " + prpPitemKindDto.getItemKindNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpPitemKindDto.getPolicyNo());
        dbManager.setString(2,prpPitemKindDto.getRiskCode());
        dbManager.setInt(3,prpPitemKindDto.getFamilyNo());
        dbManager.setString(4,prpPitemKindDto.getFamilyName());
        dbManager.setString(5,prpPitemKindDto.getKindCode());
        dbManager.setString(6,prpPitemKindDto.getKindName());
        dbManager.setInt(7,prpPitemKindDto.getItemNo());
        dbManager.setString(8,prpPitemKindDto.getItemCode());
        dbManager.setString(9,prpPitemKindDto.getItemDetailName());
        dbManager.setString(10,prpPitemKindDto.getModeCode());
        dbManager.setString(11,prpPitemKindDto.getModeName());
        dbManager.setDateTime(12,prpPitemKindDto.getStartDate());
        dbManager.setInt(13,prpPitemKindDto.getStartHour());
        dbManager.setDateTime(14,prpPitemKindDto.getEndDate());
        dbManager.setInt(15,prpPitemKindDto.getEndHour());
        dbManager.setString(16,prpPitemKindDto.getModel());
        dbManager.setDateTime(17,prpPitemKindDto.getBuyDate());
        dbManager.setInt(18,prpPitemKindDto.getAddressNo());
        dbManager.setString(19,prpPitemKindDto.getCalculateFlag());
        dbManager.setString(20,prpPitemKindDto.getCurrency());
        dbManager.setDouble(21,prpPitemKindDto.getUnitAmount());
        dbManager.setDouble(22,prpPitemKindDto.getQuantity());
        dbManager.setString(23,prpPitemKindDto.getUnit());
        dbManager.setDouble(24,prpPitemKindDto.getValue());
        dbManager.setDouble(25,prpPitemKindDto.getAmount());
        dbManager.setInt(26,prpPitemKindDto.getRatePeriod());
        dbManager.setDouble(27,prpPitemKindDto.getRate());
        dbManager.setString(28,prpPitemKindDto.getShortRateFlag());
        dbManager.setDouble(29,prpPitemKindDto.getShortRate());
        dbManager.setDouble(30,prpPitemKindDto.getBasePremium());
        dbManager.setDouble(31,prpPitemKindDto.getBenchMarkPremium());
        dbManager.setDouble(32,prpPitemKindDto.getDiscount());
        dbManager.setDouble(33,prpPitemKindDto.getAdjustRate());
        dbManager.setDouble(34,prpPitemKindDto.getPremium());
        dbManager.setDouble(35,prpPitemKindDto.getDeductibleRate());
        dbManager.setDouble(36,prpPitemKindDto.getDeductible());
        dbManager.setString(37,prpPitemKindDto.getFlag());
        dbManager.setDouble(38,prpPitemKindDto.getChgQuantity());
        dbManager.setDouble(39,prpPitemKindDto.getChgAmount());
        dbManager.setDouble(40,prpPitemKindDto.getChgPremium());
        //设置条件字段;
        dbManager.setString(41,prpPitemKindDto.getEndorseNo());
        dbManager.setInt(42,prpPitemKindDto.getItemKindNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPitemKindBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param endorseNo 批单号码
     * @param itemKindNo 序号
     * @return PrpPitemKindDto
     * @throws Exception
     */
    public PrpPitemKindDto findByPrimaryKey(String endorseNo,int itemKindNo) throws Exception{
        String mainStatement = " Select EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " ItemKindNo," +
                           " FamilyNo," +
                           " FamilyName," +
                           " KindCode," +
                           " KindName," +
                           " ItemNo," +
                           " ItemCode," +
                           " ItemDetailName," +
                           " ModeCode," +
                           " ModeName," +
                           " StartDate," +
                           " StartHour," +
                           " EndDate," +
                           " EndHour," +
                           " Model," +
                           " BuyDate," +
                           " AddressNo," +
                           " CalculateFlag," +
                           " Currency," +
                           " UnitAmount," +
                           " Quantity," +
                           " Unit," +
                           " Value," +
                           " Amount," +
                           " RatePeriod," +
                           " Rate," +
                           " ShortRateFlag," +
                           " ShortRate," +
                           " BasePremium," +
                           " BenchMarkPremium," +
                           " Discount," +
                           " AdjustRate," +
                           " Premium," +
                           " DeductibleRate," +
                           " Deductible," +
                           " Flag," +
                           " ChgQuantity," +
                           " ChgAmount," +
                           " ChgPremium," +
                           " Remark From PrpPitemKind";
        String statement = mainStatement + " Where " +
                           " EndorseNo = ? And " +
                           " ItemKindNo = ?";
        PrpPitemKindDto prpPitemKindDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " ItemKindNo = " + itemKindNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setInt(2,itemKindNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpPitemKindDto = new PrpPitemKindDto();
            prpPitemKindDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPitemKindDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPitemKindDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPitemKindDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpPitemKindDto.setFamilyNo(dbManager.getInt(resultSet,5));
            prpPitemKindDto.setFamilyName(dbManager.getString(resultSet,6));
            prpPitemKindDto.setKindCode(dbManager.getString(resultSet,7));
            prpPitemKindDto.setKindName(dbManager.getString(resultSet,8));
            prpPitemKindDto.setItemNo(dbManager.getInt(resultSet,9));
            prpPitemKindDto.setItemCode(dbManager.getString(resultSet,10));
            prpPitemKindDto.setItemDetailName(dbManager.getString(resultSet,11));
            prpPitemKindDto.setModeCode(dbManager.getString(resultSet,12));
            prpPitemKindDto.setModeName(dbManager.getString(resultSet,13));
            prpPitemKindDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpPitemKindDto.setStartHour(dbManager.getInt(resultSet,15));
            prpPitemKindDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpPitemKindDto.setEndHour(dbManager.getInt(resultSet,17));
            prpPitemKindDto.setModel(dbManager.getString(resultSet,18));
            prpPitemKindDto.setBuyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpPitemKindDto.setAddressNo(dbManager.getInt(resultSet,20));
            prpPitemKindDto.setCalculateFlag(dbManager.getString(resultSet,21));
            prpPitemKindDto.setCurrency(dbManager.getString(resultSet,22));
            prpPitemKindDto.setUnitAmount(dbManager.getDouble(resultSet,23));
            prpPitemKindDto.setQuantity(dbManager.getDouble(resultSet,24));
            prpPitemKindDto.setUnit(dbManager.getString(resultSet,25));
            prpPitemKindDto.setValue(dbManager.getDouble(resultSet,26));
            prpPitemKindDto.setAmount(dbManager.getDouble(resultSet,27));
            prpPitemKindDto.setRatePeriod(dbManager.getInt(resultSet,28));
            prpPitemKindDto.setRate(dbManager.getDouble(resultSet,29));
            prpPitemKindDto.setShortRateFlag(dbManager.getString(resultSet,30));
            prpPitemKindDto.setShortRate(dbManager.getDouble(resultSet,31));
            prpPitemKindDto.setBasePremium(dbManager.getDouble(resultSet,32));
            prpPitemKindDto.setBenchMarkPremium(dbManager.getDouble(resultSet,33));
            prpPitemKindDto.setDiscount(dbManager.getDouble(resultSet,34));
            prpPitemKindDto.setAdjustRate(dbManager.getDouble(resultSet,35));
            prpPitemKindDto.setPremium(dbManager.getDouble(resultSet,36));
            prpPitemKindDto.setDeductibleRate(dbManager.getDouble(resultSet,37));
            prpPitemKindDto.setDeductible(dbManager.getDouble(resultSet,38));
            prpPitemKindDto.setFlag(dbManager.getString(resultSet,39));
            prpPitemKindDto.setChgQuantity(dbManager.getDouble(resultSet,40));
            prpPitemKindDto.setChgAmount(dbManager.getDouble(resultSet,41));
            prpPitemKindDto.setChgPremium(dbManager.getDouble(resultSet,42));
            prpPitemKindDto.setRemark(dbManager.getString(resultSet,43));
        }
        resultSet.close();
        logger.info("DBPrpPitemKindBase.findByPrimaryKey() success!");
        return prpPitemKindDto;
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
        String statement = "Select EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " ItemKindNo," +
                           " FamilyNo," +
                           " FamilyName," +
                           " KindCode," +
                           " KindName," +
                           " ItemNo," +
                           " ItemCode," +
                           " ItemDetailName," +
                           " ModeCode," +
                           " ModeName," +
                           " StartDate," +
                           " StartHour," +
                           " EndDate," +
                           " EndHour," +
                           " Model," +
                           " BuyDate," +
                           " AddressNo," +
                           " CalculateFlag," +
                           " Currency," +
                           " UnitAmount," +
                           " Quantity," +
                           " Unit," +
                           " Value," +
                           " Amount," +
                           " RatePeriod," +
                           " Rate," +
                           " ShortRateFlag," +
                           " ShortRate," +
                           " BasePremium," +
                           " BenchMarkPremium," +
                           " Discount," +
                           " AdjustRate," +
                           " Premium," +
                           " DeductibleRate," +
                           " Deductible," +
                           " Flag," +
                           " ChgQuantity," +
                           " ChgAmount," +
                           " ChgPremium," +
                           " Remark From PrpPitemKind Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpPitemKindDto prpPitemKindDto = null;
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

            prpPitemKindDto = new PrpPitemKindDto();
            prpPitemKindDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPitemKindDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPitemKindDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPitemKindDto.setItemKindNo(dbManager.getInt(resultSet,4));
            prpPitemKindDto.setFamilyNo(dbManager.getInt(resultSet,5));
            prpPitemKindDto.setFamilyName(dbManager.getString(resultSet,6));
            prpPitemKindDto.setKindCode(dbManager.getString(resultSet,7));
            prpPitemKindDto.setKindName(dbManager.getString(resultSet,8));
            prpPitemKindDto.setItemNo(dbManager.getInt(resultSet,9));
            prpPitemKindDto.setItemCode(dbManager.getString(resultSet,10));
            prpPitemKindDto.setItemDetailName(dbManager.getString(resultSet,11));
            prpPitemKindDto.setModeCode(dbManager.getString(resultSet,12));
            prpPitemKindDto.setModeName(dbManager.getString(resultSet,13));
            prpPitemKindDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpPitemKindDto.setStartHour(dbManager.getInt(resultSet,15));
            prpPitemKindDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpPitemKindDto.setEndHour(dbManager.getInt(resultSet,17));
            prpPitemKindDto.setModel(dbManager.getString(resultSet,18));
            prpPitemKindDto.setBuyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpPitemKindDto.setAddressNo(dbManager.getInt(resultSet,20));
            prpPitemKindDto.setCalculateFlag(dbManager.getString(resultSet,21));
            prpPitemKindDto.setCurrency(dbManager.getString(resultSet,22));
            prpPitemKindDto.setUnitAmount(dbManager.getDouble(resultSet,23));
            prpPitemKindDto.setQuantity(dbManager.getDouble(resultSet,24));
            prpPitemKindDto.setUnit(dbManager.getString(resultSet,25));
            prpPitemKindDto.setValue(dbManager.getDouble(resultSet,26));
            prpPitemKindDto.setAmount(dbManager.getDouble(resultSet,27));
            prpPitemKindDto.setRatePeriod(dbManager.getInt(resultSet,28));
            prpPitemKindDto.setRate(dbManager.getDouble(resultSet,29));
            prpPitemKindDto.setShortRateFlag(dbManager.getString(resultSet,30));
            prpPitemKindDto.setShortRate(dbManager.getDouble(resultSet,31));
            prpPitemKindDto.setBasePremium(dbManager.getDouble(resultSet,32));
            prpPitemKindDto.setBenchMarkPremium(dbManager.getDouble(resultSet,33));
            prpPitemKindDto.setDiscount(dbManager.getDouble(resultSet,34));
            prpPitemKindDto.setAdjustRate(dbManager.getDouble(resultSet,35));
            prpPitemKindDto.setPremium(dbManager.getDouble(resultSet,36));
            prpPitemKindDto.setDeductibleRate(dbManager.getDouble(resultSet,37));
            prpPitemKindDto.setDeductible(dbManager.getDouble(resultSet,38));
            prpPitemKindDto.setFlag(dbManager.getString(resultSet,39));
            prpPitemKindDto.setChgQuantity(dbManager.getDouble(resultSet,40));
            prpPitemKindDto.setChgAmount(dbManager.getDouble(resultSet,41));
            prpPitemKindDto.setChgPremium(dbManager.getDouble(resultSet,42));
            prpPitemKindDto.setRemark(dbManager.getString(resultSet,43));
            collection.add(prpPitemKindDto);
        }
        resultSet.close();
        logger.info("DBPrpPitemKindBase.findByConditions() success!");
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
        String statement = "Delete From PrpPitemKind Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpPitemKindBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpPitemKind Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpPitemKindBase.getCount() success!");
        return count;
    }
}

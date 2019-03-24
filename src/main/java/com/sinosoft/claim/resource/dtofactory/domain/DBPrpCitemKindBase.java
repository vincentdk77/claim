package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.prpall.schema.PrpCvirturlItemSchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcitemkind标的子险信息的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCitemKindBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCitemKindBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCitemKindBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCitemKindDto prpCitemKindDto
     * @throws Exception
     */
    public void insert(PrpCitemKindDto prpCitemKindDto) throws Exception{
        String statement = " Insert Into PrpCitemKind(" + 
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
                           " remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCitemKindDto.getPolicyNo());
        dbManager.setString(2,prpCitemKindDto.getRiskCode());
        dbManager.setInt(3,prpCitemKindDto.getItemKindNo());
        dbManager.setInt(4,prpCitemKindDto.getFamilyNo());
        dbManager.setString(5,prpCitemKindDto.getFamilyName());
        dbManager.setString(6,prpCitemKindDto.getKindCode());
        dbManager.setString(7,prpCitemKindDto.getKindName());
        dbManager.setInt(8,prpCitemKindDto.getItemNo());
        dbManager.setString(9,prpCitemKindDto.getItemCode());
        dbManager.setString(10,prpCitemKindDto.getItemDetailName());
        dbManager.setString(11,prpCitemKindDto.getModeCode());
        dbManager.setString(12,prpCitemKindDto.getModeName());
        dbManager.setDateTime(13,prpCitemKindDto.getStartDate());
        dbManager.setInt(14,prpCitemKindDto.getStartHour());
        dbManager.setDateTime(15,prpCitemKindDto.getEndDate());
        dbManager.setInt(16,prpCitemKindDto.getEndHour());
        dbManager.setString(17,prpCitemKindDto.getModel());
        dbManager.setDateTime(18,prpCitemKindDto.getBuyDate());
        dbManager.setInt(19,prpCitemKindDto.getAddressNo());
        dbManager.setString(20,prpCitemKindDto.getCalculateFlag());
        dbManager.setString(21,prpCitemKindDto.getCurrency());
        dbManager.setDouble(22,prpCitemKindDto.getUnitAmount());
        dbManager.setDouble(23,prpCitemKindDto.getQuantity());
        dbManager.setString(24,prpCitemKindDto.getUnit());
        dbManager.setDouble(25,prpCitemKindDto.getValue());
        dbManager.setDouble(26,prpCitemKindDto.getAmount());
        dbManager.setInt(27,prpCitemKindDto.getRatePeriod());
        dbManager.setDouble(28,prpCitemKindDto.getRate());
        dbManager.setString(29,prpCitemKindDto.getShortRateFlag());
        dbManager.setDouble(30,prpCitemKindDto.getShortRate());
        dbManager.setDouble(31,prpCitemKindDto.getBasePremium());
        dbManager.setDouble(32,prpCitemKindDto.getBenchMarkPremium());
        dbManager.setDouble(33,prpCitemKindDto.getDiscount());
        dbManager.setDouble(34,prpCitemKindDto.getAdjustRate());
        dbManager.setDouble(35,prpCitemKindDto.getPremium());
        dbManager.setDouble(36,prpCitemKindDto.getDeductibleRate());
        dbManager.setDouble(37,prpCitemKindDto.getDeductible());
        dbManager.setString(38,prpCitemKindDto.getFlag());
        dbManager.setString(39,prpCitemKindDto.getRemark());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCitemKindBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)i.next();
            insert(prpCitemKindDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param itemKindNo 序号
     * @throws Exception
     */
    public void delete(String policyNo,int itemKindNo) throws Exception{
        String statement = " Delete From PrpCitemKind Where " +
                           " PolicyNo = ? And " + 
                           " ItemKindNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,itemKindNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCitemKindBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCitemKindDto prpCitemKindDto
     * @throws Exception
     */
    public void update(PrpCitemKindDto prpCitemKindDto) throws Exception{
        String statement = " Update PrpCitemKind Set RiskCode = ?," + 
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
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " ItemKindNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCitemKindDto.getRiskCode());
        dbManager.setInt(2,prpCitemKindDto.getFamilyNo());
        dbManager.setString(3,prpCitemKindDto.getFamilyName());
        dbManager.setString(4,prpCitemKindDto.getKindCode());
        dbManager.setString(5,prpCitemKindDto.getKindName());
        dbManager.setInt(6,prpCitemKindDto.getItemNo());
        dbManager.setString(7,prpCitemKindDto.getItemCode());
        dbManager.setString(8,prpCitemKindDto.getItemDetailName());
        dbManager.setString(9,prpCitemKindDto.getModeCode());
        dbManager.setString(10,prpCitemKindDto.getModeName());
        dbManager.setDateTime(11,prpCitemKindDto.getStartDate());
        dbManager.setInt(12,prpCitemKindDto.getStartHour());
        dbManager.setDateTime(13,prpCitemKindDto.getEndDate());
        dbManager.setInt(14,prpCitemKindDto.getEndHour());
        dbManager.setString(15,prpCitemKindDto.getModel());
        dbManager.setDateTime(16,prpCitemKindDto.getBuyDate());
        dbManager.setInt(17,prpCitemKindDto.getAddressNo());
        dbManager.setString(18,prpCitemKindDto.getCalculateFlag());
        dbManager.setString(19,prpCitemKindDto.getCurrency());
        dbManager.setDouble(20,prpCitemKindDto.getUnitAmount());
        dbManager.setDouble(21,prpCitemKindDto.getQuantity());
        dbManager.setString(22,prpCitemKindDto.getUnit());
        dbManager.setDouble(23,prpCitemKindDto.getValue());
        dbManager.setDouble(24,prpCitemKindDto.getAmount());
        dbManager.setInt(25,prpCitemKindDto.getRatePeriod());
        dbManager.setDouble(26,prpCitemKindDto.getRate());
        dbManager.setString(27,prpCitemKindDto.getShortRateFlag());
        dbManager.setDouble(28,prpCitemKindDto.getShortRate());
        dbManager.setDouble(29,prpCitemKindDto.getBasePremium());
        dbManager.setDouble(30,prpCitemKindDto.getBenchMarkPremium());
        dbManager.setDouble(31,prpCitemKindDto.getDiscount());
        dbManager.setDouble(32,prpCitemKindDto.getAdjustRate());
        dbManager.setDouble(33,prpCitemKindDto.getPremium());
        dbManager.setDouble(34,prpCitemKindDto.getDeductibleRate());
        dbManager.setDouble(35,prpCitemKindDto.getDeductible());
        dbManager.setString(36,prpCitemKindDto.getFlag());
        //设置条件字段;
        dbManager.setString(37,prpCitemKindDto.getPolicyNo());
        dbManager.setInt(38,prpCitemKindDto.getItemKindNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCitemKindBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param itemKindNo 序号
     * @return PrpCitemKindDto
     * @throws Exception
     */
    public PrpCitemKindDto findByPrimaryKey(String policyNo,int itemKindNo) throws Exception{
        String statement = " Select PolicyNo," + 
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
                           " Remark From PrpCitemKind Where " +
                           " PolicyNo = ? And " + 
                           " ItemKindNo = ?";
        PrpCitemKindDto prpCitemKindDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,itemKindNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCitemKindDto = new PrpCitemKindDto();
            prpCitemKindDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemKindDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemKindDto.setItemKindNo(dbManager.getInt(resultSet,3));
            prpCitemKindDto.setFamilyNo(dbManager.getInt(resultSet,4));
            prpCitemKindDto.setFamilyName(dbManager.getString(resultSet,5));
            prpCitemKindDto.setKindCode(dbManager.getString(resultSet,6));
            prpCitemKindDto.setKindName(dbManager.getString(resultSet,7));
            prpCitemKindDto.setItemNo(dbManager.getInt(resultSet,8));
            prpCitemKindDto.setItemCode(dbManager.getString(resultSet,9));
            prpCitemKindDto.setItemDetailName(dbManager.getString(resultSet,10));
            prpCitemKindDto.setModeCode(dbManager.getString(resultSet,11));
            prpCitemKindDto.setModeName(dbManager.getString(resultSet,12));
            prpCitemKindDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpCitemKindDto.setStartHour(dbManager.getInt(resultSet,14));
            prpCitemKindDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpCitemKindDto.setEndHour(dbManager.getInt(resultSet,16));
            prpCitemKindDto.setModel(dbManager.getString(resultSet,17));
            prpCitemKindDto.setBuyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpCitemKindDto.setAddressNo(dbManager.getInt(resultSet,19));
            prpCitemKindDto.setCalculateFlag(dbManager.getString(resultSet,20));
            prpCitemKindDto.setCurrency(dbManager.getString(resultSet,21));
            prpCitemKindDto.setUnitAmount(dbManager.getDouble(resultSet,22));
            prpCitemKindDto.setQuantity(dbManager.getDouble(resultSet,23));
            prpCitemKindDto.setUnit(dbManager.getString(resultSet,24));
            prpCitemKindDto.setValue(dbManager.getDouble(resultSet,25));
            prpCitemKindDto.setAmount(dbManager.getDouble(resultSet,26));
            prpCitemKindDto.setRatePeriod(dbManager.getInt(resultSet,27));
            prpCitemKindDto.setRate(dbManager.getDouble(resultSet,28));
            prpCitemKindDto.setShortRateFlag(dbManager.getString(resultSet,29));
            prpCitemKindDto.setShortRate(dbManager.getDouble(resultSet,30));
            prpCitemKindDto.setBasePremium(dbManager.getDouble(resultSet,31));
            prpCitemKindDto.setBenchMarkPremium(dbManager.getDouble(resultSet,32));
            prpCitemKindDto.setDiscount(dbManager.getDouble(resultSet,33));
            prpCitemKindDto.setAdjustRate(dbManager.getDouble(resultSet,34));
            prpCitemKindDto.setPremium(dbManager.getDouble(resultSet,35));
            prpCitemKindDto.setDeductibleRate(dbManager.getDouble(resultSet,36));
            prpCitemKindDto.setDeductible(dbManager.getDouble(resultSet,37));
            prpCitemKindDto.setFlag(dbManager.getString(resultSet,38));
            prpCitemKindDto.setRemark(dbManager.getString(resultSet,39));
        }
        resultSet.close();
        log.info("DBPrpCitemKindBase.findByPrimaryKey() success!");
        return prpCitemKindDto;
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
        String statement = "Select PolicyNo," + 
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
                           " TotalLossRatio," + 
                           " TriggerPoint," + 
                           " Flag," +
                           " Remark From PrpCitemKind Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCitemKindDto prpCitemKindDto = null;
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

            prpCitemKindDto = new PrpCitemKindDto();
            prpCitemKindDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemKindDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemKindDto.setItemKindNo(dbManager.getInt(resultSet,3));
            prpCitemKindDto.setFamilyNo(dbManager.getInt(resultSet,4));
            prpCitemKindDto.setFamilyName(dbManager.getString(resultSet,5));
            prpCitemKindDto.setKindCode(dbManager.getString(resultSet,6));
            prpCitemKindDto.setKindName(dbManager.getString(resultSet,7));
            prpCitemKindDto.setItemNo(dbManager.getInt(resultSet,8));
            prpCitemKindDto.setItemCode(dbManager.getString(resultSet,9));
            prpCitemKindDto.setItemDetailName(dbManager.getString(resultSet,10));
            prpCitemKindDto.setModeCode(dbManager.getString(resultSet,11));
            prpCitemKindDto.setModeName(dbManager.getString(resultSet,12));
            prpCitemKindDto.setStartDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpCitemKindDto.setStartHour(dbManager.getInt(resultSet,14));
            prpCitemKindDto.setEndDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpCitemKindDto.setEndHour(dbManager.getInt(resultSet,16));
            prpCitemKindDto.setModel(dbManager.getString(resultSet,17));
            prpCitemKindDto.setBuyDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpCitemKindDto.setAddressNo(dbManager.getInt(resultSet,19));
            prpCitemKindDto.setCalculateFlag(dbManager.getString(resultSet,20));
            prpCitemKindDto.setCurrency(dbManager.getString(resultSet,21));
            prpCitemKindDto.setUnitAmount(dbManager.getDouble(resultSet,22));
            prpCitemKindDto.setQuantity(dbManager.getDouble(resultSet,23));
            prpCitemKindDto.setUnit(dbManager.getString(resultSet,24));
            prpCitemKindDto.setValue(dbManager.getDouble(resultSet,25));
            prpCitemKindDto.setAmount(dbManager.getDouble(resultSet,26));
            prpCitemKindDto.setRatePeriod(dbManager.getInt(resultSet,27));
            prpCitemKindDto.setRate(dbManager.getDouble(resultSet,28));
            prpCitemKindDto.setShortRateFlag(dbManager.getString(resultSet,29));
            prpCitemKindDto.setShortRate(dbManager.getDouble(resultSet,30));
            prpCitemKindDto.setBasePremium(dbManager.getDouble(resultSet,31));
            prpCitemKindDto.setBenchMarkPremium(dbManager.getDouble(resultSet,32));
            prpCitemKindDto.setDiscount(dbManager.getDouble(resultSet,33));
            prpCitemKindDto.setAdjustRate(dbManager.getDouble(resultSet,34));
            prpCitemKindDto.setPremium(dbManager.getDouble(resultSet,35));
            prpCitemKindDto.setDeductibleRate(dbManager.getDouble(resultSet,36));
            prpCitemKindDto.setDeductible(dbManager.getDouble(resultSet,37));
            prpCitemKindDto.setTotalLossRatio(dbManager.getDouble(resultSet,38));
            prpCitemKindDto.setTriggerPoint(dbManager.getDouble(resultSet,39));
            prpCitemKindDto.setFlag(dbManager.getString(resultSet,40));
            prpCitemKindDto.setRemark(dbManager.getString(resultSet,41));
            collection.add(prpCitemKindDto);
        }
        resultSet.close();
        log.info("DBPrpCitemKindBase.findByConditions() success!");
        return collection;
    }
    
    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findVirturlItemByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = " Select * From prpcvirturlitem Where " + conditions;
        Collection collection = new ArrayList();
        PrpCvirturlItemSchema prpCvirturlItemSchema = null;
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

            prpCvirturlItemSchema = new PrpCvirturlItemSchema();
            prpCvirturlItemSchema.setPolicyNo(dbManager.getString(resultSet,"PolicyNo"));
            prpCvirturlItemSchema.setRiskCode(dbManager.getString(resultSet,"RiskCode"));
            prpCvirturlItemSchema.setItemKindNo(dbManager.getString(resultSet,"ItemKindNo"));
            prpCvirturlItemSchema.setFamilyNo(dbManager.getString(resultSet,"FamilyNo"));
            prpCvirturlItemSchema.setFamilyName(dbManager.getString(resultSet,"FamilyName"));
            prpCvirturlItemSchema.setKindCode(dbManager.getString(resultSet,"KindCode"));
            prpCvirturlItemSchema.setKindName(dbManager.getString(resultSet,"KindName"));
            prpCvirturlItemSchema.setItemCode(dbManager.getString(resultSet,"ItemCode"));
            prpCvirturlItemSchema.setItemDetailName(dbManager.getString(resultSet,"ItemDetailName"));
            prpCvirturlItemSchema.setRationType(dbManager.getString(resultSet,"RationType"));
            prpCvirturlItemSchema.setUnitAmount(dbManager.getString(resultSet,"UnitAmount"));
            prpCvirturlItemSchema.setCurrency(dbManager.getString(resultSet,"Currency"));
            prpCvirturlItemSchema.setPremium(dbManager.getString(resultSet,"Premium"));
            prpCvirturlItemSchema.setAmount(dbManager.getString(resultSet,"Amount"));
            prpCvirturlItemSchema.setVirturlFlag(dbManager.getString(resultSet,"VirturlFlag"));
           
            collection.add(prpCvirturlItemSchema);
        }
        resultSet.close();
        log.info("DBPrpCitemKindBase.findByConditions() success!");
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
        String statement = "Delete From PrpCitemKind Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCitemKindBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCitemKind Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCitemKindBase.getCount() success!");
        return count;
    }
}

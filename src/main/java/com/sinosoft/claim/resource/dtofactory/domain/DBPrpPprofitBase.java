package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPprofitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppprofit优惠信息表的数据访问对象基类<br>
 * 创建于 2004-11-22 15:24:20.578<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpPprofitBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpPprofitBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpPprofitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpPprofitDto prpPprofitDto
     * @throws Exception
     */
    public void insert(PrpPprofitDto prpPprofitDto) throws Exception{
        String mainStatement = " Insert Into PrpPprofit (" +
                           " EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " ProfitType," +
                           " ItemkindNo," +
                           " KindCode," +
                           " Currency," +
                           " Discount," +
                           " TotalProfit," +
                           " MinusFlag," +
                           " HandlerCode," +
                           " ApproverCode," +
                           " OperatorCode," +
                           " InputDate," +
                           " Flag)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" +
                           "'" + prpPprofitDto.getEndorseNo() + "'," +
                           "'" + prpPprofitDto.getPolicyNo() + "'," +
                           "'" + prpPprofitDto.getRiskCode() + "'," +
                           "'" + prpPprofitDto.getProfitType() + "'," +
                           "" + prpPprofitDto.getItemkindNo() + "," +
                           "'" + prpPprofitDto.getKindCode() + "'," +
                           "'" + prpPprofitDto.getCurrency() + "'," +
                           "'" + prpPprofitDto.getDiscount() + "'," +
                           "'" + prpPprofitDto.getTotalProfit() + "'," +
                           "'" + prpPprofitDto.getMinusFlag() + "'," +
                           "'" + prpPprofitDto.getHandlerCode() + "'," +
                           "'" + prpPprofitDto.getApproverCode() + "'," +
                           "'" + prpPprofitDto.getOperatorCode() + "'," +
                           "'" + prpPprofitDto.getInputDate() + "'," +
                           "'" + prpPprofitDto.getFlag() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpPprofitDto.getEndorseNo());
        dbManager.setString(2,prpPprofitDto.getPolicyNo());
        dbManager.setString(3,prpPprofitDto.getRiskCode());
        dbManager.setString(4,prpPprofitDto.getProfitType());
        dbManager.setInt(5,prpPprofitDto.getItemkindNo());
        dbManager.setString(6,prpPprofitDto.getKindCode());
        dbManager.setString(7,prpPprofitDto.getCurrency());
        dbManager.setDouble(8,prpPprofitDto.getDiscount());
        dbManager.setDouble(9,prpPprofitDto.getTotalProfit());
        dbManager.setString(10,prpPprofitDto.getMinusFlag());
        dbManager.setString(11,prpPprofitDto.getHandlerCode());
        dbManager.setString(12,prpPprofitDto.getApproverCode());
        dbManager.setString(13,prpPprofitDto.getOperatorCode());
        dbManager.setDateTime(14,prpPprofitDto.getInputDate());
        dbManager.setString(15,prpPprofitDto.getFlag());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPprofitBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpPprofitDto prpPprofitDto = (PrpPprofitDto)i.next();
            insert(prpPprofitDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param endorseNo 批单号
     * @param profitType 优惠折扣类型
     * @param itemkindNo 标的险别序号
     * @throws Exception
     */
    public void delete(String endorseNo,String profitType,int itemkindNo) throws Exception{
        String statement = " Delete From PrpPprofit" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " ProfitType = ? And " +
                           " ItemkindNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpPprofit Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " ProfitType = '" + profitType + "' And " +
                           " ItemkindNo = " + itemkindNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setString(2,profitType);
        dbManager.setInt(3,itemkindNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpPprofitBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpPprofitDto prpPprofitDto
     * @throws Exception
     */
    public void update(PrpPprofitDto prpPprofitDto) throws Exception{
        String statement = " Update PrpPprofit Set PolicyNo = ?," +
                           " RiskCode = ?," +
                           " KindCode = ?," +
                           " Currency = ?," +
                           " Discount = ?," +
                           " TotalProfit = ?," +
                           " MinusFlag = ?," +
                           " HandlerCode = ?," +
                           " ApproverCode = ?," +
                           " OperatorCode = ?," +
                           " InputDate = ?," +
                           " Flag = ?" +
	            		   " Where " +
                           " EndorseNo = ? And " +
                           " ProfitType = ? And " +
                           " ItemkindNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpPprofit Set " +
                           " EndorseNo = '" + prpPprofitDto.getEndorseNo() + "'," +
                           " PolicyNo = '" + prpPprofitDto.getPolicyNo() + "'," +
                           " RiskCode = '" + prpPprofitDto.getRiskCode() + "'," +
                           " ProfitType = '" + prpPprofitDto.getProfitType() + "'," +
                           " ItemkindNo = " + prpPprofitDto.getItemkindNo() + "," +
                           " KindCode = '" + prpPprofitDto.getKindCode() + "'," +
                           " Currency = '" + prpPprofitDto.getCurrency() + "'," +
                           " Discount = '" + prpPprofitDto.getDiscount() + "'," +
                           " TotalProfit = '" + prpPprofitDto.getTotalProfit() + "'," +
                           " MinusFlag = '" + prpPprofitDto.getMinusFlag() + "'," +
                           " HandlerCode = '" + prpPprofitDto.getHandlerCode() + "'," +
                           " ApproverCode = '" + prpPprofitDto.getApproverCode() + "'," +
                           " OperatorCode = '" + prpPprofitDto.getOperatorCode() + "'," +
                           " InputDate = '" + prpPprofitDto.getInputDate() + "'," +
                           " Flag = '" + prpPprofitDto.getFlag() + "'" +
			               " Where " +
                           " EndorseNo = '" + prpPprofitDto.getEndorseNo() + "' And " +
                           " ProfitType = '" + prpPprofitDto.getProfitType() + "' And " +
                           " ItemkindNo = " + prpPprofitDto.getItemkindNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpPprofitDto.getPolicyNo());
        dbManager.setString(2,prpPprofitDto.getRiskCode());
        dbManager.setString(3,prpPprofitDto.getKindCode());
        dbManager.setString(4,prpPprofitDto.getCurrency());
        dbManager.setDouble(5,prpPprofitDto.getDiscount());
        dbManager.setDouble(6,prpPprofitDto.getTotalProfit());
        dbManager.setString(7,prpPprofitDto.getMinusFlag());
        dbManager.setString(8,prpPprofitDto.getHandlerCode());
        dbManager.setString(9,prpPprofitDto.getApproverCode());
        dbManager.setString(10,prpPprofitDto.getOperatorCode());
        dbManager.setDateTime(11,prpPprofitDto.getInputDate());
        dbManager.setString(12,prpPprofitDto.getFlag());
        //设置条件字段;
        dbManager.setString(13,prpPprofitDto.getEndorseNo());
        dbManager.setString(14,prpPprofitDto.getProfitType());
        dbManager.setInt(15,prpPprofitDto.getItemkindNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpPprofitBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param endorseNo 批单号
     * @param profitType 优惠折扣类型
     * @param itemkindNo 标的险别序号
     * @return PrpPprofitDto
     * @throws Exception
     */
    public PrpPprofitDto findByPrimaryKey(String endorseNo,String profitType,int itemkindNo) throws Exception{
        String mainStatement = " Select EndorseNo," +
                           " PolicyNo," +
                           " RiskCode," +
                           " ProfitType," +
                           " ItemkindNo," +
                           " KindCode," +
                           " Currency," +
                           " Discount," +
                           " TotalProfit," +
                           " MinusFlag," +
                           " HandlerCode," +
                           " ApproverCode," +
                           " OperatorCode," +
                           " InputDate," +
                           " Flag From PrpPprofit";
        String statement = mainStatement + " Where " +
                           " EndorseNo = ? And " +
                           " ProfitType = ? And " +
                           " ItemkindNo = ?";
        PrpPprofitDto prpPprofitDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " EndorseNo = '" + endorseNo + "' And " +
                           " ProfitType = '" + profitType + "' And " +
                           " ItemkindNo = " + itemkindNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,endorseNo);
        dbManager.setString(2,profitType);
        dbManager.setInt(3,itemkindNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpPprofitDto = new PrpPprofitDto();
            prpPprofitDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPprofitDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPprofitDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPprofitDto.setProfitType(dbManager.getString(resultSet,4));
            prpPprofitDto.setItemkindNo(dbManager.getInt(resultSet,5));
            prpPprofitDto.setKindCode(dbManager.getString(resultSet,6));
            prpPprofitDto.setCurrency(dbManager.getString(resultSet,7));
            prpPprofitDto.setDiscount(dbManager.getDouble(resultSet,8));
            prpPprofitDto.setTotalProfit(dbManager.getDouble(resultSet,9));
            prpPprofitDto.setMinusFlag(dbManager.getString(resultSet,10));
            prpPprofitDto.setHandlerCode(dbManager.getString(resultSet,11));
            prpPprofitDto.setApproverCode(dbManager.getString(resultSet,12));
            prpPprofitDto.setOperatorCode(dbManager.getString(resultSet,13));
            prpPprofitDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpPprofitDto.setFlag(dbManager.getString(resultSet,15));
        }
        resultSet.close();
        logger.info("DBPrpPprofitBase.findByPrimaryKey() success!");
        return prpPprofitDto;
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
                           " ProfitType," +
                           " ItemkindNo," +
                           " KindCode," +
                           " Currency," +
                           " Discount," +
                           " TotalProfit," +
                           " MinusFlag," +
                           " HandlerCode," +
                           " ApproverCode," +
                           " OperatorCode," +
                           " InputDate," +
                           " Flag From PrpPprofit Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpPprofitDto prpPprofitDto = null;
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

            prpPprofitDto = new PrpPprofitDto();
            prpPprofitDto.setEndorseNo(dbManager.getString(resultSet,1));
            prpPprofitDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpPprofitDto.setRiskCode(dbManager.getString(resultSet,3));
            prpPprofitDto.setProfitType(dbManager.getString(resultSet,4));
            prpPprofitDto.setItemkindNo(dbManager.getInt(resultSet,5));
            prpPprofitDto.setKindCode(dbManager.getString(resultSet,6));
            prpPprofitDto.setCurrency(dbManager.getString(resultSet,7));
            prpPprofitDto.setDiscount(dbManager.getDouble(resultSet,8));
            prpPprofitDto.setTotalProfit(dbManager.getDouble(resultSet,9));
            prpPprofitDto.setMinusFlag(dbManager.getString(resultSet,10));
            prpPprofitDto.setHandlerCode(dbManager.getString(resultSet,11));
            prpPprofitDto.setApproverCode(dbManager.getString(resultSet,12));
            prpPprofitDto.setOperatorCode(dbManager.getString(resultSet,13));
            prpPprofitDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,14));
            prpPprofitDto.setFlag(dbManager.getString(resultSet,15));
            collection.add(prpPprofitDto);
        }
        resultSet.close();
        logger.info("DBPrpPprofitBase.findByConditions() success!");
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
        String statement = "Delete From PrpPprofit Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpPprofitBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpPprofit Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpPprofitBase.getCount() success!");
        return count;
    }
}

package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJprofitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjprofit优惠记录表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJprofitBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpJprofitBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJprofitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpJprofitDto prpJprofitDto
     * @throws Exception
     */
    public void insert(PrpJprofitDto prpJprofitDto) throws Exception{
        String statement = " Insert Into PrpJprofit(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " EndorseNo," + 
                           " ProfitNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " ItemDetailName," + 
                           " ProfitReasonCode," + 
                           " SumPremium," + 
                           " ProfitRate," + 
                           " Currency," + 
                           " TotalProfit," + 
                           " SafeBountyFlag," + 
                           " MinusFlag," + 
                           " HandlerCode," + 
                           " ApproverCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " RefundFlag," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJprofitDto.getPolicyNo());
        dbManager.setString(2,prpJprofitDto.getRiskCode());
        dbManager.setString(3,prpJprofitDto.getEndorseNo());
        dbManager.setInt(4,prpJprofitDto.getProfitNo());
        dbManager.setInt(5,prpJprofitDto.getItemKindNo());
        dbManager.setString(6,prpJprofitDto.getKindCode());
        dbManager.setString(7,prpJprofitDto.getItemCode());
        dbManager.setString(8,prpJprofitDto.getItemDetailName());
        dbManager.setString(9,prpJprofitDto.getProfitReasonCode());
        dbManager.setDouble(10,prpJprofitDto.getSumPremium());
        dbManager.setDouble(11,prpJprofitDto.getProfitRate());
        dbManager.setString(12,prpJprofitDto.getCurrency());
        dbManager.setDouble(13,prpJprofitDto.getTotalProfit());
        dbManager.setString(14,prpJprofitDto.getSafeBountyFlag());
        dbManager.setString(15,prpJprofitDto.getMinusFlag());
        dbManager.setString(16,prpJprofitDto.getHandlerCode());
        dbManager.setString(17,prpJprofitDto.getApproverCode());
        dbManager.setString(18,prpJprofitDto.getOperatorCode());
        dbManager.setDateTime(19,prpJprofitDto.getInputDate());
        dbManager.setString(20,prpJprofitDto.getRefundFlag());
        dbManager.setString(21,prpJprofitDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJprofitBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJprofitDto prpJprofitDto = (PrpJprofitDto)i.next();
            insert(prpJprofitDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保险单号次
     * @param profitNo 优惠序号
     * @param itemKindNo 标的险别序号
     * @throws Exception
     */
    public void delete(String policyNo,int profitNo,int itemKindNo) throws Exception{
        String statement = " Delete From PrpJprofit Where " +
                           " PolicyNo = ? And " + 
                           " ProfitNo = ? And " + 
                           " ItemKindNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,profitNo);
        dbManager.setInt(3,itemKindNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJprofitBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpJprofitDto prpJprofitDto
     * @throws Exception
     */
    public void update(PrpJprofitDto prpJprofitDto) throws Exception{
        String statement = " Update PrpJprofit Set RiskCode = ?," + 
                           " EndorseNo = ?," + 
                           " KindCode = ?," + 
                           " ItemCode = ?," + 
                           " ItemDetailName = ?," + 
                           " ProfitReasonCode = ?," + 
                           " SumPremium = ?," + 
                           " ProfitRate = ?," + 
                           " Currency = ?," + 
                           " TotalProfit = ?," + 
                           " SafeBountyFlag = ?," + 
                           " MinusFlag = ?," + 
                           " HandlerCode = ?," + 
                           " ApproverCode = ?," + 
                           " OperatorCode = ?," + 
                           " InputDate = ?," + 
                           " RefundFlag = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " ProfitNo = ? And " + 
                           " ItemKindNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpJprofitDto.getRiskCode());
        dbManager.setString(2,prpJprofitDto.getEndorseNo());
        dbManager.setString(3,prpJprofitDto.getKindCode());
        dbManager.setString(4,prpJprofitDto.getItemCode());
        dbManager.setString(5,prpJprofitDto.getItemDetailName());
        dbManager.setString(6,prpJprofitDto.getProfitReasonCode());
        dbManager.setDouble(7,prpJprofitDto.getSumPremium());
        dbManager.setDouble(8,prpJprofitDto.getProfitRate());
        dbManager.setString(9,prpJprofitDto.getCurrency());
        dbManager.setDouble(10,prpJprofitDto.getTotalProfit());
        dbManager.setString(11,prpJprofitDto.getSafeBountyFlag());
        dbManager.setString(12,prpJprofitDto.getMinusFlag());
        dbManager.setString(13,prpJprofitDto.getHandlerCode());
        dbManager.setString(14,prpJprofitDto.getApproverCode());
        dbManager.setString(15,prpJprofitDto.getOperatorCode());
        dbManager.setDateTime(16,prpJprofitDto.getInputDate());
        dbManager.setString(17,prpJprofitDto.getRefundFlag());
        dbManager.setString(18,prpJprofitDto.getFlag());
        //设置条件字段;
        dbManager.setString(19,prpJprofitDto.getPolicyNo());
        dbManager.setInt(20,prpJprofitDto.getProfitNo());
        dbManager.setInt(21,prpJprofitDto.getItemKindNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJprofitBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保险单号次
     * @param profitNo 优惠序号
     * @param itemKindNo 标的险别序号
     * @return PrpJprofitDto
     * @throws Exception
     */
    public PrpJprofitDto findByPrimaryKey(String policyNo,int profitNo,int itemKindNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " EndorseNo," + 
                           " ProfitNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " ItemDetailName," + 
                           " ProfitReasonCode," + 
                           " SumPremium," + 
                           " ProfitRate," + 
                           " Currency," + 
                           " TotalProfit," + 
                           " SafeBountyFlag," + 
                           " MinusFlag," + 
                           " HandlerCode," + 
                           " ApproverCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " RefundFlag," + 
                           " Flag From PrpJprofit Where " +
                           " PolicyNo = ? And " + 
                           " ProfitNo = ? And " + 
                           " ItemKindNo = ?";
        PrpJprofitDto prpJprofitDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,profitNo);
        dbManager.setInt(3,itemKindNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJprofitDto = new PrpJprofitDto();
            prpJprofitDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpJprofitDto.setRiskCode(dbManager.getString(resultSet,2));
            prpJprofitDto.setEndorseNo(dbManager.getString(resultSet,3));
            prpJprofitDto.setProfitNo(dbManager.getInt(resultSet,4));
            prpJprofitDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpJprofitDto.setKindCode(dbManager.getString(resultSet,6));
            prpJprofitDto.setItemCode(dbManager.getString(resultSet,7));
            prpJprofitDto.setItemDetailName(dbManager.getString(resultSet,8));
            prpJprofitDto.setProfitReasonCode(dbManager.getString(resultSet,9));
            prpJprofitDto.setSumPremium(dbManager.getDouble(resultSet,10));
            prpJprofitDto.setProfitRate(dbManager.getDouble(resultSet,11));
            prpJprofitDto.setCurrency(dbManager.getString(resultSet,12));
            prpJprofitDto.setTotalProfit(dbManager.getDouble(resultSet,13));
            prpJprofitDto.setSafeBountyFlag(dbManager.getString(resultSet,14));
            prpJprofitDto.setMinusFlag(dbManager.getString(resultSet,15));
            prpJprofitDto.setHandlerCode(dbManager.getString(resultSet,16));
            prpJprofitDto.setApproverCode(dbManager.getString(resultSet,17));
            prpJprofitDto.setOperatorCode(dbManager.getString(resultSet,18));
            prpJprofitDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpJprofitDto.setRefundFlag(dbManager.getString(resultSet,20));
            prpJprofitDto.setFlag(dbManager.getString(resultSet,21));
        }
        resultSet.close();
        log.info("DBPrpJprofitBase.findByPrimaryKey() success!");
        return prpJprofitDto;
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
                           " EndorseNo," + 
                           " ProfitNo," + 
                           " ItemKindNo," + 
                           " KindCode," + 
                           " ItemCode," + 
                           " ItemDetailName," + 
                           " ProfitReasonCode," + 
                           " SumPremium," + 
                           " ProfitRate," + 
                           " Currency," + 
                           " TotalProfit," + 
                           " SafeBountyFlag," + 
                           " MinusFlag," + 
                           " HandlerCode," + 
                           " ApproverCode," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " RefundFlag," + 
                           " Flag From PrpJprofit Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJprofitDto prpJprofitDto = null;
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

            prpJprofitDto = new PrpJprofitDto();
            prpJprofitDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpJprofitDto.setRiskCode(dbManager.getString(resultSet,2));
            prpJprofitDto.setEndorseNo(dbManager.getString(resultSet,3));
            prpJprofitDto.setProfitNo(dbManager.getInt(resultSet,4));
            prpJprofitDto.setItemKindNo(dbManager.getInt(resultSet,5));
            prpJprofitDto.setKindCode(dbManager.getString(resultSet,6));
            prpJprofitDto.setItemCode(dbManager.getString(resultSet,7));
            prpJprofitDto.setItemDetailName(dbManager.getString(resultSet,8));
            prpJprofitDto.setProfitReasonCode(dbManager.getString(resultSet,9));
            prpJprofitDto.setSumPremium(dbManager.getDouble(resultSet,10));
            prpJprofitDto.setProfitRate(dbManager.getDouble(resultSet,11));
            prpJprofitDto.setCurrency(dbManager.getString(resultSet,12));
            prpJprofitDto.setTotalProfit(dbManager.getDouble(resultSet,13));
            prpJprofitDto.setSafeBountyFlag(dbManager.getString(resultSet,14));
            prpJprofitDto.setMinusFlag(dbManager.getString(resultSet,15));
            prpJprofitDto.setHandlerCode(dbManager.getString(resultSet,16));
            prpJprofitDto.setApproverCode(dbManager.getString(resultSet,17));
            prpJprofitDto.setOperatorCode(dbManager.getString(resultSet,18));
            prpJprofitDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,19));
            prpJprofitDto.setRefundFlag(dbManager.getString(resultSet,20));
            prpJprofitDto.setFlag(dbManager.getString(resultSet,21));
            collection.add(prpJprofitDto);
        }
        resultSet.close();
        
        log.info("DBPrpJprofitBase.findByConditions() success!");
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
        String statement = "Delete From PrpJprofit Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJprofitBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpJprofit Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJprofitBase.getCount() success!");
        return count;
    }
}

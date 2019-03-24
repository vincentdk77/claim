package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCprofitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcprofit优惠信息表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCprofitBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCprofitBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCprofitBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCprofitDto prpCprofitDto
     * @throws Exception
     */
    public void insert(PrpCprofitDto prpCprofitDto) throws Exception{
        String statement = " Insert Into PrpCprofit(" + 
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
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCprofitDto.getPolicyNo());
        dbManager.setString(2,prpCprofitDto.getRiskCode());
        dbManager.setString(3,prpCprofitDto.getProfitType());
        dbManager.setInt(4,prpCprofitDto.getItemkindNo());
        dbManager.setString(5,prpCprofitDto.getKindCode());
        dbManager.setString(6,prpCprofitDto.getCurrency());
        dbManager.setDouble(7,prpCprofitDto.getDiscount());
        dbManager.setDouble(8,prpCprofitDto.getTotalProfit());
        dbManager.setString(9,prpCprofitDto.getMinusFlag());
        dbManager.setString(10,prpCprofitDto.getHandlerCode());
        dbManager.setString(11,prpCprofitDto.getApproverCode());
        dbManager.setString(12,prpCprofitDto.getOperatorCode());
        dbManager.setDateTime(13,prpCprofitDto.getInputDate());
        dbManager.setString(14,prpCprofitDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCprofitBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCprofitDto prpCprofitDto = (PrpCprofitDto)i.next();
            insert(prpCprofitDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号
     * @param profitType 优惠折扣类型
     * @param itemkindNo 标的险别序号
     * @throws Exception
     */
    public void delete(String policyNo,String profitType,int itemkindNo) throws Exception{
        String statement = " Delete From PrpCprofit Where " +
                           " PolicyNo = ? And " + 
                           " ProfitType = ? And " + 
                           " ItemkindNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,profitType);
        dbManager.setInt(3,itemkindNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCprofitBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCprofitDto prpCprofitDto
     * @throws Exception
     */
    public void update(PrpCprofitDto prpCprofitDto) throws Exception{
        String statement = " Update PrpCprofit Set RiskCode = ?," + 
                           " KindCode = ?," + 
                           " Currency = ?," + 
                           " Discount = ?," + 
                           " TotalProfit = ?," + 
                           " MinusFlag = ?," + 
                           " HandlerCode = ?," + 
                           " ApproverCode = ?," + 
                           " OperatorCode = ?," + 
                           " InputDate = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " ProfitType = ? And " + 
                           " ItemkindNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCprofitDto.getRiskCode());
        dbManager.setString(2,prpCprofitDto.getKindCode());
        dbManager.setString(3,prpCprofitDto.getCurrency());
        dbManager.setDouble(4,prpCprofitDto.getDiscount());
        dbManager.setDouble(5,prpCprofitDto.getTotalProfit());
        dbManager.setString(6,prpCprofitDto.getMinusFlag());
        dbManager.setString(7,prpCprofitDto.getHandlerCode());
        dbManager.setString(8,prpCprofitDto.getApproverCode());
        dbManager.setString(9,prpCprofitDto.getOperatorCode());
        dbManager.setDateTime(10,prpCprofitDto.getInputDate());
        dbManager.setString(11,prpCprofitDto.getFlag());
        //设置条件字段;
        dbManager.setString(12,prpCprofitDto.getPolicyNo());
        dbManager.setString(13,prpCprofitDto.getProfitType());
        dbManager.setInt(14,prpCprofitDto.getItemkindNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCprofitBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号
     * @param profitType 优惠折扣类型
     * @param itemkindNo 标的险别序号
     * @return PrpCprofitDto
     * @throws Exception
     */
    public PrpCprofitDto findByPrimaryKey(String policyNo,String profitType,int itemkindNo) throws Exception{
        String statement = " Select PolicyNo," + 
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
                           " Flag From PrpCprofit Where " +
                           " PolicyNo = ? And " + 
                           " ProfitType = ? And " + 
                           " ItemkindNo = ?";
        PrpCprofitDto prpCprofitDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,profitType);
        dbManager.setInt(3,itemkindNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCprofitDto = new PrpCprofitDto();
            prpCprofitDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCprofitDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCprofitDto.setProfitType(dbManager.getString(resultSet,3));
            prpCprofitDto.setItemkindNo(dbManager.getInt(resultSet,4));
            prpCprofitDto.setKindCode(dbManager.getString(resultSet,5));
            prpCprofitDto.setCurrency(dbManager.getString(resultSet,6));
            prpCprofitDto.setDiscount(dbManager.getDouble(resultSet,7));
            prpCprofitDto.setTotalProfit(dbManager.getDouble(resultSet,8));
            prpCprofitDto.setMinusFlag(dbManager.getString(resultSet,9));
            prpCprofitDto.setHandlerCode(dbManager.getString(resultSet,10));
            prpCprofitDto.setApproverCode(dbManager.getString(resultSet,11));
            prpCprofitDto.setOperatorCode(dbManager.getString(resultSet,12));
            prpCprofitDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpCprofitDto.setFlag(dbManager.getString(resultSet,14));
        }
        resultSet.close();
        log.info("DBPrpCprofitBase.findByPrimaryKey() success!");
        return prpCprofitDto;
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
                           " Flag From PrpCprofit Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCprofitDto prpCprofitDto = null;
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

            prpCprofitDto = new PrpCprofitDto();
            prpCprofitDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCprofitDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCprofitDto.setProfitType(dbManager.getString(resultSet,3));
            prpCprofitDto.setItemkindNo(dbManager.getInt(resultSet,4));
            prpCprofitDto.setKindCode(dbManager.getString(resultSet,5));
            prpCprofitDto.setCurrency(dbManager.getString(resultSet,6));
            prpCprofitDto.setDiscount(dbManager.getDouble(resultSet,7));
            prpCprofitDto.setTotalProfit(dbManager.getDouble(resultSet,8));
            prpCprofitDto.setMinusFlag(dbManager.getString(resultSet,9));
            prpCprofitDto.setHandlerCode(dbManager.getString(resultSet,10));
            prpCprofitDto.setApproverCode(dbManager.getString(resultSet,11));
            prpCprofitDto.setOperatorCode(dbManager.getString(resultSet,12));
            prpCprofitDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,13));
            prpCprofitDto.setFlag(dbManager.getString(resultSet,14));
            collection.add(prpCprofitDto);
        }
        resultSet.close();
        log.info("DBPrpCprofitBase.findByConditions() success!");
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
        String statement = "Delete From PrpCprofit Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCprofitBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCprofit Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCprofitBase.getCount() success!");
        return count;
    }
}

package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayRecDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjpayrec收费登记表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJpayRecTGBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpJpayRecTGBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJpayRecTGBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpJpayRecDto prpJpayRecDto
     * @throws Exception
     */
    public void insert(PrpJpayRecDto prpJpayRecDto) throws Exception{
        String statement = " Insert Into PrpJpayRec(" +
                           " RiskCode," +
                           " PolicyNo," +
                           " CertiNo," +
                           " Order02No," +
                           " SerialNo," +
                           " ProfitNo," +
                           " PayReason," +
                           " Currency1," +
                           " PayFee," +
                           " DelinquentFee," +
                           " InputDate," +
                           " TransFlag," +
                           " Currency2," +
                           " RealPayFee," +
                           " RealPayDate," +
                           " ComCode," +
                           " OperatorCode," +
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJpayRecDto.getRiskCode());
        dbManager.setString(2,prpJpayRecDto.getPolicyNo());
        dbManager.setString(3,prpJpayRecDto.getCertiNo());
        dbManager.setInt(4,prpJpayRecDto.getOrder02No());
        dbManager.setInt(5,prpJpayRecDto.getSerialNo());
        dbManager.setInt(6,prpJpayRecDto.getProfitNo());
        dbManager.setString(7,prpJpayRecDto.getPayReason());
        dbManager.setString(8,prpJpayRecDto.getCurrency1());
        dbManager.setDouble(9,prpJpayRecDto.getPayFee());
        dbManager.setDouble(10,prpJpayRecDto.getDelinquentFee());
        dbManager.setDateTime(11,prpJpayRecDto.getInputDate());
        dbManager.setString(12,prpJpayRecDto.getTransFlag());
        dbManager.setString(13,prpJpayRecDto.getCurrency2());
        dbManager.setDouble(14,prpJpayRecDto.getRealPayFee());
        dbManager.setDateTime(15,prpJpayRecDto.getRealPayDate());
        dbManager.setString(16,prpJpayRecDto.getComCode());
        dbManager.setString(17,prpJpayRecDto.getOperatorCode());
        dbManager.setString(18,prpJpayRecDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpayRecBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJpayRecDto prpJpayRecDto = (PrpJpayRecDto)i.next();
            insert(prpJpayRecDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param certiNo 保单号码/批单号码
     * @param order02No 收费序号
     * @throws Exception
     */
    public void delete(String certiNo,int order02No) throws Exception{
        String statement = " Delete From PrpJpayRec Where " +
                           " CertiNo = ? And " +
                           " Order02No = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,order02No);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJpayRecBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpJpayRecDto prpJpayRecDto
     * @throws Exception
     */
    public void update(PrpJpayRecDto prpJpayRecDto) throws Exception{
        String statement = " Update PrpJpayRec Set RiskCode = ?," +
                           " PolicyNo = ?," +
                           " SerialNo = ?," +
                           " ProfitNo = ?," +
                           " PayReason = ?," +
                           " Currency1 = ?," +
                           " PayFee = ?," +
                           " DelinquentFee = ?," +
                           " InputDate = ?," +
                           " TransFlag = ?," +
                           " Currency2 = ?," +
                           " RealPayFee = ?," +
                           " RealPayDate = ?," +
                           " ComCode = ?," +
                           " OperatorCode = ?," +
                           " Flag = ? Where " +
                           " CertiNo = ? And " +
                           " Order02No = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpJpayRecDto.getRiskCode());
        dbManager.setString(2,prpJpayRecDto.getPolicyNo());
        dbManager.setInt(3,prpJpayRecDto.getSerialNo());
        dbManager.setInt(4,prpJpayRecDto.getProfitNo());
        dbManager.setString(5,prpJpayRecDto.getPayReason());
        dbManager.setString(6,prpJpayRecDto.getCurrency1());
        dbManager.setDouble(7,prpJpayRecDto.getPayFee());
        dbManager.setDouble(8,prpJpayRecDto.getDelinquentFee());
        dbManager.setDateTime(9,prpJpayRecDto.getInputDate());
        dbManager.setString(10,prpJpayRecDto.getTransFlag());
        dbManager.setString(11,prpJpayRecDto.getCurrency2());
        dbManager.setDouble(12,prpJpayRecDto.getRealPayFee());
        dbManager.setDateTime(13,prpJpayRecDto.getRealPayDate());
        dbManager.setString(14,prpJpayRecDto.getComCode());
        dbManager.setString(15,prpJpayRecDto.getOperatorCode());
        dbManager.setString(16,prpJpayRecDto.getFlag());
        //设置条件字段;
        dbManager.setString(17,prpJpayRecDto.getCertiNo());
        dbManager.setInt(18,prpJpayRecDto.getOrder02No());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpayRecBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param certiNo 保单号码/批单号码
     * @param order02No 收费序号
     * @return PrpJpayRecDto
     * @throws Exception
     */
    public PrpJpayRecDto findByPrimaryKey(String certiNo,int order02No) throws Exception{
        String statement = " Select RiskCode," +
                           " PolicyNo," +
                           " CertiNo," +
                           " Order02No," +
                           " SerialNo," +
                           " ProfitNo," +
                           " PayReason," +
                           " Currency1," +
                           " PayFee," +
                           " DelinquentFee," +
                           " InputDate," +
                           " TransFlag," +
                           " Currency2," +
                           " RealPayFee," +
                           " RealPayDate," +
                           " ComCode," +
                           " OperatorCode," +
                           " Flag From PrpJpayRec Where " +
                           " CertiNo = ? And " +
                           " Order02No = ?";
        PrpJpayRecDto prpJpayRecDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,order02No);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJpayRecDto = new PrpJpayRecDto();
            prpJpayRecDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJpayRecDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpJpayRecDto.setCertiNo(dbManager.getString(resultSet,3));
            prpJpayRecDto.setOrder02No(dbManager.getInt(resultSet,4));
            prpJpayRecDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpJpayRecDto.setProfitNo(dbManager.getInt(resultSet,6));
            prpJpayRecDto.setPayReason(dbManager.getString(resultSet,7));
            prpJpayRecDto.setCurrency1(dbManager.getString(resultSet,8));
            prpJpayRecDto.setPayFee(dbManager.getDouble(resultSet,9));
            prpJpayRecDto.setDelinquentFee(dbManager.getDouble(resultSet,10));
            prpJpayRecDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpJpayRecDto.setTransFlag(dbManager.getString(resultSet,12));
            prpJpayRecDto.setCurrency2(dbManager.getString(resultSet,13));
            prpJpayRecDto.setRealPayFee(dbManager.getDouble(resultSet,14));
            prpJpayRecDto.setRealPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJpayRecDto.setComCode(dbManager.getString(resultSet,16));
            prpJpayRecDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpJpayRecDto.setFlag(dbManager.getString(resultSet,18));
        }
        resultSet.close();
        log.info("DBPrpJpayRecBase.findByPrimaryKey() success!");
        return prpJpayRecDto;
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
        String statement = "Select RiskCode," +
                           " PolicyNo," +
                           " CertiNo," +
                           " Order02No," +
                           " SerialNo," +
                           " ProfitNo," +
                           " PayReason," +
                           " Currency1," +
                           " PayFee," +
                           " DelinquentFee," +
                           " InputDate," +
                           " TransFlag," +
                           " Currency2," +
                           " RealPayFee," +
                           " RealPayDate," +
                           " ComCode," +
                           " OperatorCode," +
                           " Flag From PrpJpayRec Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJpayRecDto prpJpayRecDto = null;
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

            prpJpayRecDto = new PrpJpayRecDto();
            prpJpayRecDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJpayRecDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpJpayRecDto.setCertiNo(dbManager.getString(resultSet,3));
            prpJpayRecDto.setOrder02No(dbManager.getInt(resultSet,4));
            prpJpayRecDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpJpayRecDto.setProfitNo(dbManager.getInt(resultSet,6));
            prpJpayRecDto.setPayReason(dbManager.getString(resultSet,7));
            prpJpayRecDto.setCurrency1(dbManager.getString(resultSet,8));
            prpJpayRecDto.setPayFee(dbManager.getDouble(resultSet,9));
            prpJpayRecDto.setDelinquentFee(dbManager.getDouble(resultSet,10));
            prpJpayRecDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpJpayRecDto.setTransFlag(dbManager.getString(resultSet,12));
            prpJpayRecDto.setCurrency2(dbManager.getString(resultSet,13));
            prpJpayRecDto.setRealPayFee(dbManager.getDouble(resultSet,14));
            prpJpayRecDto.setRealPayDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJpayRecDto.setComCode(dbManager.getString(resultSet,16));
            prpJpayRecDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpJpayRecDto.setFlag(dbManager.getString(resultSet,18));
            collection.add(prpJpayRecDto);
        }
        resultSet.close();
        log.info("DBPrpJpayRecBase.findByConditions() success!");
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
        String statement = "Delete From PrpJpayRec Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJpayRecBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpJpayRec Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJpayRecBase.getCount() success!");
        return count;
    }
}

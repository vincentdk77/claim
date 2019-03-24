package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefRecDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjrefrec付费登记表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJrefRecBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpJrefRecBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJrefRecBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpJrefRecDto prpJrefRecDto
     * @throws Exception
     */
    public void insert(PrpJrefRecDto prpJrefRecDto) throws Exception{
        String statement = " Insert Into PrpJrefRec(" + 
                           " RiskCode," + 
                           " PolicyNo," + 
                           " CertiType," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " ProfitNo," + 
                           " RefundReason," + 
                           " Currency1," + 
                           " RefundFee," + 
                           " RefundName," + 
                           " InputDate," + 
                           " TransFlag," + 
                           " Currency2," + 
                           " RealRefundFee," + 
                           " RealRefundDate," + 
                           " ComCode," + 
                           " OperatorCode," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJrefRecDto.getRiskCode());
        dbManager.setString(2,prpJrefRecDto.getPolicyNo());
        dbManager.setString(3,prpJrefRecDto.getCertiType());
        dbManager.setString(4,prpJrefRecDto.getCertiNo());
        dbManager.setInt(5,prpJrefRecDto.getSerialNo());
        dbManager.setInt(6,prpJrefRecDto.getProfitNo());
        dbManager.setString(7,prpJrefRecDto.getRefundReason());
        dbManager.setString(8,prpJrefRecDto.getCurrency1());
        dbManager.setDouble(9,prpJrefRecDto.getRefundFee());
        dbManager.setString(10,prpJrefRecDto.getRefundName());
        dbManager.setDateTime(11,prpJrefRecDto.getInputDate());
        dbManager.setString(12,prpJrefRecDto.getTransFlag());
        dbManager.setString(13,prpJrefRecDto.getCurrency2());
        dbManager.setDouble(14,prpJrefRecDto.getRealRefundFee());
        dbManager.setDateTime(15,prpJrefRecDto.getRealRefundDate());
        dbManager.setString(16,prpJrefRecDto.getComCode());
        dbManager.setString(17,prpJrefRecDto.getOperatorCode());
        dbManager.setString(18,prpJrefRecDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefRecBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJrefRecDto prpJrefRecDto = (PrpJrefRecDto)i.next();
            insert(prpJrefRecDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @throws Exception
     */
    public void delete(String certiNo,int serialNo) throws Exception{
        String statement = " Delete From PrpJrefRec Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJrefRecBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpJrefRecDto prpJrefRecDto
     * @throws Exception
     */
    public void update(PrpJrefRecDto prpJrefRecDto) throws Exception{
        String statement = " Update PrpJrefRec Set RiskCode = ?," + 
                           " PolicyNo = ?," + 
                           " CertiType = ?," + 
                           " ProfitNo = ?," + 
                           " RefundReason = ?," + 
                           " Currency1 = ?," + 
                           " RefundFee = ?," + 
                           " RefundName = ?," + 
                           " InputDate = ?," + 
                           " TransFlag = ?," + 
                           " Currency2 = ?," + 
                           " RealRefundFee = ?," + 
                           " RealRefundDate = ?," + 
                           " ComCode = ?," + 
                           " OperatorCode = ?," + 
                           " Flag = ? Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpJrefRecDto.getRiskCode());
        dbManager.setString(2,prpJrefRecDto.getPolicyNo());
        dbManager.setString(3,prpJrefRecDto.getCertiType());
        dbManager.setInt(4,prpJrefRecDto.getProfitNo());
        dbManager.setString(5,prpJrefRecDto.getRefundReason());
        dbManager.setString(6,prpJrefRecDto.getCurrency1());
        dbManager.setDouble(7,prpJrefRecDto.getRefundFee());
        dbManager.setString(8,prpJrefRecDto.getRefundName());
        dbManager.setDateTime(9,prpJrefRecDto.getInputDate());
        dbManager.setString(10,prpJrefRecDto.getTransFlag());
        dbManager.setString(11,prpJrefRecDto.getCurrency2());
        dbManager.setDouble(12,prpJrefRecDto.getRealRefundFee());
        dbManager.setDateTime(13,prpJrefRecDto.getRealRefundDate());
        dbManager.setString(14,prpJrefRecDto.getComCode());
        dbManager.setString(15,prpJrefRecDto.getOperatorCode());
        dbManager.setString(16,prpJrefRecDto.getFlag());
        //设置条件字段;
        dbManager.setString(17,prpJrefRecDto.getCertiNo());
        dbManager.setInt(18,prpJrefRecDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefRecBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @return PrpJrefRecDto
     * @throws Exception
     */
    public PrpJrefRecDto findByPrimaryKey(String certiNo,int serialNo) throws Exception{
        String statement = " Select RiskCode," + 
                           " PolicyNo," + 
                           " CertiType," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " ProfitNo," + 
                           " RefundReason," + 
                           " Currency1," + 
                           " RefundFee," + 
                           " RefundName," + 
                           " InputDate," + 
                           " TransFlag," + 
                           " Currency2," + 
                           " RealRefundFee," + 
                           " RealRefundDate," + 
                           " ComCode," + 
                           " OperatorCode," + 
                           " Flag From PrpJrefRec Where " +
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        PrpJrefRecDto prpJrefRecDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,certiNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJrefRecDto = new PrpJrefRecDto();
            prpJrefRecDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJrefRecDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpJrefRecDto.setCertiType(dbManager.getString(resultSet,3));
            prpJrefRecDto.setCertiNo(dbManager.getString(resultSet,4));
            prpJrefRecDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpJrefRecDto.setProfitNo(dbManager.getInt(resultSet,6));
            prpJrefRecDto.setRefundReason(dbManager.getString(resultSet,7));
            prpJrefRecDto.setCurrency1(dbManager.getString(resultSet,8));
            prpJrefRecDto.setRefundFee(dbManager.getDouble(resultSet,9));
            prpJrefRecDto.setRefundName(dbManager.getString(resultSet,10));
            prpJrefRecDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpJrefRecDto.setTransFlag(dbManager.getString(resultSet,12));
            prpJrefRecDto.setCurrency2(dbManager.getString(resultSet,13));
            prpJrefRecDto.setRealRefundFee(dbManager.getDouble(resultSet,14));
            prpJrefRecDto.setRealRefundDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJrefRecDto.setComCode(dbManager.getString(resultSet,16));
            prpJrefRecDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpJrefRecDto.setFlag(dbManager.getString(resultSet,18));
        }
        resultSet.close();
        log.info("DBPrpJrefRecBase.findByPrimaryKey() success!");
        return prpJrefRecDto;
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
                           " CertiType," + 
                           " CertiNo," + 
                           " SerialNo," + 
                           " ProfitNo," + 
                           " RefundReason," + 
                           " Currency1," + 
                           " RefundFee," + 
                           " RefundName," + 
                           " InputDate," + 
                           " TransFlag," + 
                           " Currency2," + 
                           " RealRefundFee," + 
                           " RealRefundDate," + 
                           " ComCode," + 
                           " OperatorCode," + 
                           " Flag From PrpJrefRec Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJrefRecDto prpJrefRecDto = null;
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

            prpJrefRecDto = new PrpJrefRecDto();
            prpJrefRecDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJrefRecDto.setPolicyNo(dbManager.getString(resultSet,2));
            prpJrefRecDto.setCertiType(dbManager.getString(resultSet,3));
            prpJrefRecDto.setCertiNo(dbManager.getString(resultSet,4));
            prpJrefRecDto.setSerialNo(dbManager.getInt(resultSet,5));
            prpJrefRecDto.setProfitNo(dbManager.getInt(resultSet,6));
            prpJrefRecDto.setRefundReason(dbManager.getString(resultSet,7));
            prpJrefRecDto.setCurrency1(dbManager.getString(resultSet,8));
            prpJrefRecDto.setRefundFee(dbManager.getDouble(resultSet,9));
            prpJrefRecDto.setRefundName(dbManager.getString(resultSet,10));
            prpJrefRecDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpJrefRecDto.setTransFlag(dbManager.getString(resultSet,12));
            prpJrefRecDto.setCurrency2(dbManager.getString(resultSet,13));
            prpJrefRecDto.setRealRefundFee(dbManager.getDouble(resultSet,14));
            prpJrefRecDto.setRealRefundDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJrefRecDto.setComCode(dbManager.getString(resultSet,16));
            prpJrefRecDto.setOperatorCode(dbManager.getString(resultSet,17));
            prpJrefRecDto.setFlag(dbManager.getString(resultSet,18));
            collection.add(prpJrefRecDto);
        }
        resultSet.close();
        log.info("DBPrpJrefRecBase.findByConditions() success!");
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
        String statement = "Delete From PrpJrefRec Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJrefRecBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpJrefRec Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJrefRecBase.getCount() success!");
        return count;
    }
}

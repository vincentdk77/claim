package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLQsCollDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLQs_coll清算中心通赔结算汇总表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:09<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLQsCollBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpLQsCollBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLQsCollBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLQs_collDto prpLQs_collDto
     * @throws Exception
     */
    public void insert(PrpLQsCollDto prpLQs_collDto) throws Exception{
        String statement = " Insert Into PrpLQs_coll(" + 
                           " BatchNo," + 
                           " ProcComCode," + 
                           " ProcComCName," + 
                           " ProcNo," + 
                           " CheckAgntD1," + 
                           " CheckAgntFee1," + 
                           " CheckAgntD2," + 
                           " CheckAgntFee2," + 
                           " CheckAgntD3," + 
                           " CheckAgntFee3," + 
                           " ClaimAgntFee," + 
                           " RefundAgntNo," + 
                           " RefundAgntFee," + 
                           " RealPayAgntFee," + 
                           " RealCheckAgntFee," + 
                           " RealPaySumFee," + 
                           " BalDate," + 
                           " ProcDate," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " Remark," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLQs_collDto.getBatchNo());
        dbManager.setString(2,prpLQs_collDto.getProcComCode());
        dbManager.setString(3,prpLQs_collDto.getProcComCName());
        dbManager.setString(4,prpLQs_collDto.getProcNo());
        dbManager.setInt(5,prpLQs_collDto.getCheckAgntD1());
        dbManager.setDouble(6,prpLQs_collDto.getCheckAgntFee1());
        dbManager.setInt(7,prpLQs_collDto.getCheckAgntD2());
        dbManager.setDouble(8,prpLQs_collDto.getCheckAgntFee2());
        dbManager.setInt(9,prpLQs_collDto.getCheckAgntD3());
        dbManager.setDouble(10,prpLQs_collDto.getCheckAgntFee3());
        dbManager.setDouble(11,prpLQs_collDto.getClaimAgntFee());
        dbManager.setInt(12,prpLQs_collDto.getRefundAgntNo());
        dbManager.setDouble(13,prpLQs_collDto.getRefundAgntFee());
        dbManager.setInt(14,prpLQs_collDto.getRealPayAgntFee());
        dbManager.setDouble(15,prpLQs_collDto.getRealCheckAgntFee());
        dbManager.setDouble(16,prpLQs_collDto.getRealPaySumFee());
        dbManager.setDateTime(17,prpLQs_collDto.getBalDate());
        dbManager.setDateTime(18,prpLQs_collDto.getProcDate());
        dbManager.setString(19,prpLQs_collDto.getOperatorCode());
        dbManager.setString(20,prpLQs_collDto.getComCode());
        dbManager.setString(21,prpLQs_collDto.getRemark());
        dbManager.setString(22,prpLQs_collDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLQs_collBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLQsCollDto prpLQs_collDto = (PrpLQsCollDto)i.next();
            insert(prpLQs_collDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param batchNo 总批次号
     * @param procNo 结算单批次号
     * @throws Exception
     */
    public void delete(String batchNo,String procNo) throws Exception{
        String statement = " Delete From PrpLQs_coll Where " +
                           " BatchNo = ? And " + 
                           " ProcNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,batchNo);
        dbManager.setString(2,procNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLQs_collBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLQs_collDto prpLQs_collDto
     * @throws Exception
     */
    public void update(PrpLQsCollDto prpLQs_collDto) throws Exception{
        String statement = " Update PrpLQs_coll Set ProcComCode = ?," + 
                           " ProcComCName = ?," + 
                           " CheckAgntD1 = ?," + 
                           " CheckAgntFee1 = ?," + 
                           " CheckAgntD2 = ?," + 
                           " CheckAgntFee2 = ?," + 
                           " CheckAgntD3 = ?," + 
                           " CheckAgntFee3 = ?," + 
                           " ClaimAgntFee = ?," + 
                           " RefundAgntNo = ?," + 
                           " RefundAgntFee = ?," + 
                           " RealPayAgntFee = ?," + 
                           " RealCheckAgntFee = ?," + 
                           " RealPaySumFee = ?," + 
                           " BalDate = ?," + 
                           " ProcDate = ?," + 
                           " OperatorCode = ?," + 
                           " ComCode = ?," + 
                           " Remark = ?," + 
                           " Flag = ? Where " +
                           " BatchNo = ? And " + 
                           " ProcNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLQs_collDto.getProcComCode());
        dbManager.setString(2,prpLQs_collDto.getProcComCName());
        dbManager.setInt(3,prpLQs_collDto.getCheckAgntD1());
        dbManager.setDouble(4,prpLQs_collDto.getCheckAgntFee1());
        dbManager.setInt(5,prpLQs_collDto.getCheckAgntD2());
        dbManager.setDouble(6,prpLQs_collDto.getCheckAgntFee2());
        dbManager.setInt(7,prpLQs_collDto.getCheckAgntD3());
        dbManager.setDouble(8,prpLQs_collDto.getCheckAgntFee3());
        dbManager.setDouble(9,prpLQs_collDto.getClaimAgntFee());
        dbManager.setInt(10,prpLQs_collDto.getRefundAgntNo());
        dbManager.setDouble(11,prpLQs_collDto.getRefundAgntFee());
        dbManager.setInt(12,prpLQs_collDto.getRealPayAgntFee());
        dbManager.setDouble(13,prpLQs_collDto.getRealCheckAgntFee());
        dbManager.setDouble(14,prpLQs_collDto.getRealPaySumFee());
        dbManager.setDateTime(15,prpLQs_collDto.getBalDate());
        dbManager.setDateTime(16,prpLQs_collDto.getProcDate());
        dbManager.setString(17,prpLQs_collDto.getOperatorCode());
        dbManager.setString(18,prpLQs_collDto.getComCode());
        dbManager.setString(19,prpLQs_collDto.getRemark());
        dbManager.setString(20,prpLQs_collDto.getFlag());
        //设置条件字段;
        dbManager.setString(21,prpLQs_collDto.getBatchNo());
        dbManager.setString(22,prpLQs_collDto.getProcNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLQs_collBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param batchNo 总批次号
     * @param procNo 结算单批次号
     * @return PrpLQsCollDto
     * @throws Exception
     */
    public PrpLQsCollDto findByPrimaryKey(String batchNo,String procNo) throws Exception{
        String statement = " Select BatchNo," + 
                           " ProcComCode," + 
                           " ProcComCName," + 
                           " ProcNo," + 
                           " CheckAgntD1," + 
                           " CheckAgntFee1," + 
                           " CheckAgntD2," + 
                           " CheckAgntFee2," + 
                           " CheckAgntD3," + 
                           " CheckAgntFee3," + 
                           " ClaimAgntFee," + 
                           " RefundAgntNo," + 
                           " RefundAgntFee," + 
                           " RealPayAgntFee," + 
                           " RealCheckAgntFee," + 
                           " RealPaySumFee," + 
                           " BalDate," + 
                           " ProcDate," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " Remark," + 
                           " Flag From PrpLQs_coll Where " +
                           " BatchNo = ? And " + 
                           " ProcNo = ?";
        PrpLQsCollDto prpLQs_collDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,batchNo);
        dbManager.setString(2,procNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLQs_collDto = new PrpLQsCollDto();
            prpLQs_collDto.setBatchNo(dbManager.getString(resultSet,1));
            prpLQs_collDto.setProcComCode(dbManager.getString(resultSet,2));
            prpLQs_collDto.setProcComCName(dbManager.getString(resultSet,3));
            prpLQs_collDto.setProcNo(dbManager.getString(resultSet,4));
            prpLQs_collDto.setCheckAgntD1(dbManager.getInt(resultSet,5));
            prpLQs_collDto.setCheckAgntFee1(dbManager.getDouble(resultSet,6));
            prpLQs_collDto.setCheckAgntD2(dbManager.getInt(resultSet,7));
            prpLQs_collDto.setCheckAgntFee2(dbManager.getDouble(resultSet,8));
            prpLQs_collDto.setCheckAgntD3(dbManager.getInt(resultSet,9));
            prpLQs_collDto.setCheckAgntFee3(dbManager.getDouble(resultSet,10));
            prpLQs_collDto.setClaimAgntFee(dbManager.getDouble(resultSet,11));
            prpLQs_collDto.setRefundAgntNo(dbManager.getInt(resultSet,12));
            prpLQs_collDto.setRefundAgntFee(dbManager.getDouble(resultSet,13));
            prpLQs_collDto.setRealPayAgntFee(dbManager.getInt(resultSet,14));
            prpLQs_collDto.setRealCheckAgntFee(dbManager.getDouble(resultSet,15));
            prpLQs_collDto.setRealPaySumFee(dbManager.getDouble(resultSet,16));
            prpLQs_collDto.setBalDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            prpLQs_collDto.setProcDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLQs_collDto.setOperatorCode(dbManager.getString(resultSet,19));
            prpLQs_collDto.setComCode(dbManager.getString(resultSet,20));
            prpLQs_collDto.setRemark(dbManager.getString(resultSet,21));
            prpLQs_collDto.setFlag(dbManager.getString(resultSet,22));
        }
        resultSet.close();
        log.info("DBPrpLQs_collBase.findByPrimaryKey() success!");
        return prpLQs_collDto;
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
        String statement = "Select BatchNo," + 
                           " ProcComCode," + 
                           " ProcComCName," + 
                           " ProcNo," + 
                           " CheckAgntD1," + 
                           " CheckAgntFee1," + 
                           " CheckAgntD2," + 
                           " CheckAgntFee2," + 
                           " CheckAgntD3," + 
                           " CheckAgntFee3," + 
                           " ClaimAgntFee," + 
                           " RefundAgntNo," + 
                           " RefundAgntFee," + 
                           " RealPayAgntFee," + 
                           " RealCheckAgntFee," + 
                           " RealPaySumFee," + 
                           " BalDate," + 
                           " ProcDate," + 
                           " OperatorCode," + 
                           " ComCode," + 
                           " Remark," + 
                           " Flag From PrpLQs_coll Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLQsCollDto prpLQs_collDto = null;
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

            prpLQs_collDto = new PrpLQsCollDto();
            prpLQs_collDto.setBatchNo(dbManager.getString(resultSet,1));
            prpLQs_collDto.setProcComCode(dbManager.getString(resultSet,2));
            prpLQs_collDto.setProcComCName(dbManager.getString(resultSet,3));
            prpLQs_collDto.setProcNo(dbManager.getString(resultSet,4));
            prpLQs_collDto.setCheckAgntD1(dbManager.getInt(resultSet,5));
            prpLQs_collDto.setCheckAgntFee1(dbManager.getDouble(resultSet,6));
            prpLQs_collDto.setCheckAgntD2(dbManager.getInt(resultSet,7));
            prpLQs_collDto.setCheckAgntFee2(dbManager.getDouble(resultSet,8));
            prpLQs_collDto.setCheckAgntD3(dbManager.getInt(resultSet,9));
            prpLQs_collDto.setCheckAgntFee3(dbManager.getDouble(resultSet,10));
            prpLQs_collDto.setClaimAgntFee(dbManager.getDouble(resultSet,11));
            prpLQs_collDto.setRefundAgntNo(dbManager.getInt(resultSet,12));
            prpLQs_collDto.setRefundAgntFee(dbManager.getDouble(resultSet,13));
            prpLQs_collDto.setRealPayAgntFee(dbManager.getInt(resultSet,14));
            prpLQs_collDto.setRealCheckAgntFee(dbManager.getDouble(resultSet,15));
            prpLQs_collDto.setRealPaySumFee(dbManager.getDouble(resultSet,16));
            prpLQs_collDto.setBalDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,17));
            prpLQs_collDto.setProcDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,18));
            prpLQs_collDto.setOperatorCode(dbManager.getString(resultSet,19));
            prpLQs_collDto.setComCode(dbManager.getString(resultSet,20));
            prpLQs_collDto.setRemark(dbManager.getString(resultSet,21));
            prpLQs_collDto.setFlag(dbManager.getString(resultSet,22));
            collection.add(prpLQs_collDto);
        }
        resultSet.close();
        log.info("DBPrpLQs_collBase.findByConditions() success!");
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
        String statement = "Delete From PrpLQs_coll Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpLQs_collBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLQs_coll Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpLQs_collBase.getCount() success!");
        return count;
    }
}

package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJcommAllocDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjcommalloc手续费分摊表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJcommAllocBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpJcommAllocBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJcommAllocBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpJcommAllocDto prpJcommAllocDto
     * @throws Exception
     */
    public void insert(PrpJcommAllocDto prpJcommAllocDto) throws Exception{
        String statement = " Insert Into PrpJcommAlloc(" + 
                           " RiskCode," + 
                           " AllocNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " PayReason," + 
                           " Currency," + 
                           " Commission," + 
                           " OwCommission," + 
                           " AllocFee," + 
                           " AllocDate," + 
                           " TransFlag," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJcommAllocDto.getRiskCode());
        dbManager.setString(2,prpJcommAllocDto.getAllocNo());
        dbManager.setString(3,prpJcommAllocDto.getPolicyNo());
        dbManager.setInt(4,prpJcommAllocDto.getSerialNo());
        dbManager.setString(5,prpJcommAllocDto.getPayReason());
        dbManager.setString(6,prpJcommAllocDto.getCurrency());
        dbManager.setDouble(7,prpJcommAllocDto.getCommission());
        dbManager.setDouble(8,prpJcommAllocDto.getOwCommission());
        dbManager.setDouble(9,prpJcommAllocDto.getAllocFee());
        dbManager.setDateTime(10,prpJcommAllocDto.getAllocDate());
        dbManager.setString(11,prpJcommAllocDto.getTransFlag());
        dbManager.setString(12,prpJcommAllocDto.getComCode());
        dbManager.setString(13,prpJcommAllocDto.getMakeCom());
        dbManager.setString(14,prpJcommAllocDto.getOperatorCode());
        dbManager.setDateTime(15,prpJcommAllocDto.getInputDate());
        dbManager.setString(16,prpJcommAllocDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJcommAllocBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJcommAllocDto prpJcommAllocDto = (PrpJcommAllocDto)i.next();
            insert(prpJcommAllocDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param allocNo 分摊号
     * @param policyNo 保单号
     * @param serialNo 分摊序号
     * @throws Exception
     */
    public void delete(String allocNo,String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpJcommAlloc Where " +
                           " AllocNo = ? And " + 
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,allocNo);
        dbManager.setString(2,policyNo);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJcommAllocBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpJcommAllocDto prpJcommAllocDto
     * @throws Exception
     */
    public void update(PrpJcommAllocDto prpJcommAllocDto) throws Exception{
        String statement = " Update PrpJcommAlloc Set RiskCode = ?," + 
                           " PayReason = ?," + 
                           " Currency = ?," + 
                           " Commission = ?," + 
                           " OwCommission = ?," + 
                           " AllocFee = ?," + 
                           " AllocDate = ?," + 
                           " TransFlag = ?," + 
                           " ComCode = ?," + 
                           " MakeCom = ?," + 
                           " OperatorCode = ?," + 
                           " InputDate = ?," + 
                           " Flag = ? Where " +
                           " AllocNo = ? And " + 
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpJcommAllocDto.getRiskCode());
        dbManager.setString(2,prpJcommAllocDto.getPayReason());
        dbManager.setString(3,prpJcommAllocDto.getCurrency());
        dbManager.setDouble(4,prpJcommAllocDto.getCommission());
        dbManager.setDouble(5,prpJcommAllocDto.getOwCommission());
        dbManager.setDouble(6,prpJcommAllocDto.getAllocFee());
        dbManager.setDateTime(7,prpJcommAllocDto.getAllocDate());
        dbManager.setString(8,prpJcommAllocDto.getTransFlag());
        dbManager.setString(9,prpJcommAllocDto.getComCode());
        dbManager.setString(10,prpJcommAllocDto.getMakeCom());
        dbManager.setString(11,prpJcommAllocDto.getOperatorCode());
        dbManager.setDateTime(12,prpJcommAllocDto.getInputDate());
        dbManager.setString(13,prpJcommAllocDto.getFlag());
        //设置条件字段;
        dbManager.setString(14,prpJcommAllocDto.getAllocNo());
        dbManager.setString(15,prpJcommAllocDto.getPolicyNo());
        dbManager.setInt(16,prpJcommAllocDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJcommAllocBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param allocNo 分摊号
     * @param policyNo 保单号
     * @param serialNo 分摊序号
     * @return PrpJcommAllocDto
     * @throws Exception
     */
    public PrpJcommAllocDto findByPrimaryKey(String allocNo,String policyNo,int serialNo) throws Exception{
        String statement = " Select RiskCode," + 
                           " AllocNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " PayReason," + 
                           " Currency," + 
                           " Commission," + 
                           " OwCommission," + 
                           " AllocFee," + 
                           " AllocDate," + 
                           " TransFlag," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " Flag From PrpJcommAlloc Where " +
                           " AllocNo = ? And " + 
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpJcommAllocDto prpJcommAllocDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,allocNo);
        dbManager.setString(2,policyNo);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJcommAllocDto = new PrpJcommAllocDto();
            prpJcommAllocDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJcommAllocDto.setAllocNo(dbManager.getString(resultSet,2));
            prpJcommAllocDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpJcommAllocDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJcommAllocDto.setPayReason(dbManager.getString(resultSet,5));
            prpJcommAllocDto.setCurrency(dbManager.getString(resultSet,6));
            prpJcommAllocDto.setCommission(dbManager.getDouble(resultSet,7));
            prpJcommAllocDto.setOwCommission(dbManager.getDouble(resultSet,8));
            prpJcommAllocDto.setAllocFee(dbManager.getDouble(resultSet,9));
            prpJcommAllocDto.setAllocDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpJcommAllocDto.setTransFlag(dbManager.getString(resultSet,11));
            prpJcommAllocDto.setComCode(dbManager.getString(resultSet,12));
            prpJcommAllocDto.setMakeCom(dbManager.getString(resultSet,13));
            prpJcommAllocDto.setOperatorCode(dbManager.getString(resultSet,14));
            prpJcommAllocDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJcommAllocDto.setFlag(dbManager.getString(resultSet,16));
        }
        resultSet.close();
        log.info("DBPrpJcommAllocBase.findByPrimaryKey() success!");
        return prpJcommAllocDto;
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
                           " AllocNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " PayReason," + 
                           " Currency," + 
                           " Commission," + 
                           " OwCommission," + 
                           " AllocFee," + 
                           " AllocDate," + 
                           " TransFlag," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " Flag From PrpJcommAlloc Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJcommAllocDto prpJcommAllocDto = null;
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

            prpJcommAllocDto = new PrpJcommAllocDto();
            prpJcommAllocDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJcommAllocDto.setAllocNo(dbManager.getString(resultSet,2));
            prpJcommAllocDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpJcommAllocDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJcommAllocDto.setPayReason(dbManager.getString(resultSet,5));
            prpJcommAllocDto.setCurrency(dbManager.getString(resultSet,6));
            prpJcommAllocDto.setCommission(dbManager.getDouble(resultSet,7));
            prpJcommAllocDto.setOwCommission(dbManager.getDouble(resultSet,8));
            prpJcommAllocDto.setAllocFee(dbManager.getDouble(resultSet,9));
            prpJcommAllocDto.setAllocDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpJcommAllocDto.setTransFlag(dbManager.getString(resultSet,11));
            prpJcommAllocDto.setComCode(dbManager.getString(resultSet,12));
            prpJcommAllocDto.setMakeCom(dbManager.getString(resultSet,13));
            prpJcommAllocDto.setOperatorCode(dbManager.getString(resultSet,14));
            prpJcommAllocDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,15));
            prpJcommAllocDto.setFlag(dbManager.getString(resultSet,16));
            collection.add(prpJcommAllocDto);
        }
        resultSet.close();
        log.info("DBPrpJcommAllocBase.findByConditions() success!");
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
        String statement = "Delete From PrpJcommAlloc Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJcommAllocBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpJcommAlloc Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJcommAllocBase.getCount() success!");
        return count;
    }
}

package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpremAllocDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjpremalloc长期险业务保费分摊表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJpremAllocBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpJpremAllocBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpJpremAllocBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpJpremAllocDto prpJpremAllocDto
     * @throws Exception
     */
    public void insert(PrpJpremAllocDto prpJpremAllocDto) throws Exception{
        String statement = " Insert Into PrpJpremAlloc(" + 
                           " RiskCode," + 
                           " AllocNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " PayReason," + 
                           " Currency," + 
                           " SumPremium," + 
                           " PrePremium," + 
                           " AllocPremium," + 
                           " AllocFee," + 
                           " AllocDate," + 
                           " TransFlag," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJpremAllocDto.getRiskCode());
        dbManager.setString(2,prpJpremAllocDto.getAllocNo());
        dbManager.setString(3,prpJpremAllocDto.getPolicyNo());
        dbManager.setInt(4,prpJpremAllocDto.getSerialNo());
        dbManager.setString(5,prpJpremAllocDto.getPayReason());
        dbManager.setString(6,prpJpremAllocDto.getCurrency());
        dbManager.setDouble(7,prpJpremAllocDto.getSumPremium());
        dbManager.setDouble(8,prpJpremAllocDto.getPrePremium());
        dbManager.setDouble(9,prpJpremAllocDto.getAllocPremium());
        dbManager.setDouble(10,prpJpremAllocDto.getAllocFee());
        dbManager.setDateTime(11,prpJpremAllocDto.getAllocDate());
        dbManager.setString(12,prpJpremAllocDto.getTransFlag());
        dbManager.setString(13,prpJpremAllocDto.getComCode());
        dbManager.setString(14,prpJpremAllocDto.getMakeCom());
        dbManager.setString(15,prpJpremAllocDto.getOperatorCode());
        dbManager.setDateTime(16,prpJpremAllocDto.getInputDate());
        dbManager.setString(17,prpJpremAllocDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpremAllocBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJpremAllocDto prpJpremAllocDto = (PrpJpremAllocDto)i.next();
            insert(prpJpremAllocDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpJpremAlloc Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJpremAllocBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpJpremAllocDto prpJpremAllocDto
     * @throws Exception
     */
    public void update(PrpJpremAllocDto prpJpremAllocDto) throws Exception{
        String statement = " Update PrpJpremAlloc Set RiskCode = ?," + 
                           " AllocNo = ?," + 
                           " PayReason = ?," + 
                           " Currency = ?," + 
                           " SumPremium = ?," + 
                           " PrePremium = ?," + 
                           " AllocPremium = ?," + 
                           " AllocFee = ?," + 
                           " AllocDate = ?," + 
                           " TransFlag = ?," + 
                           " ComCode = ?," + 
                           " MakeCom = ?," + 
                           " OperatorCode = ?," + 
                           " InputDate = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpJpremAllocDto.getRiskCode());
        dbManager.setString(2,prpJpremAllocDto.getAllocNo());
        dbManager.setString(3,prpJpremAllocDto.getPayReason());
        dbManager.setString(4,prpJpremAllocDto.getCurrency());
        dbManager.setDouble(5,prpJpremAllocDto.getSumPremium());
        dbManager.setDouble(6,prpJpremAllocDto.getPrePremium());
        dbManager.setDouble(7,prpJpremAllocDto.getAllocPremium());
        dbManager.setDouble(8,prpJpremAllocDto.getAllocFee());
        dbManager.setDateTime(9,prpJpremAllocDto.getAllocDate());
        dbManager.setString(10,prpJpremAllocDto.getTransFlag());
        dbManager.setString(11,prpJpremAllocDto.getComCode());
        dbManager.setString(12,prpJpremAllocDto.getMakeCom());
        dbManager.setString(13,prpJpremAllocDto.getOperatorCode());
        dbManager.setDateTime(14,prpJpremAllocDto.getInputDate());
        dbManager.setString(15,prpJpremAllocDto.getFlag());
        //设置条件字段;
        dbManager.setString(16,prpJpremAllocDto.getPolicyNo());
        dbManager.setInt(17,prpJpremAllocDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpremAllocBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @return PrpJpremAllocDto
     * @throws Exception
     */
    public PrpJpremAllocDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select RiskCode," + 
                           " AllocNo," + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " PayReason," + 
                           " Currency," + 
                           " SumPremium," + 
                           " PrePremium," + 
                           " AllocPremium," + 
                           " AllocFee," + 
                           " AllocDate," + 
                           " TransFlag," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " Flag From PrpJpremAlloc Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpJpremAllocDto prpJpremAllocDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJpremAllocDto = new PrpJpremAllocDto();
            prpJpremAllocDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJpremAllocDto.setAllocNo(dbManager.getString(resultSet,2));
            prpJpremAllocDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpJpremAllocDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJpremAllocDto.setPayReason(dbManager.getString(resultSet,5));
            prpJpremAllocDto.setCurrency(dbManager.getString(resultSet,6));
            prpJpremAllocDto.setSumPremium(dbManager.getDouble(resultSet,7));
            prpJpremAllocDto.setPrePremium(dbManager.getDouble(resultSet,8));
            prpJpremAllocDto.setAllocPremium(dbManager.getDouble(resultSet,9));
            prpJpremAllocDto.setAllocFee(dbManager.getDouble(resultSet,10));
            prpJpremAllocDto.setAllocDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpJpremAllocDto.setTransFlag(dbManager.getString(resultSet,12));
            prpJpremAllocDto.setComCode(dbManager.getString(resultSet,13));
            prpJpremAllocDto.setMakeCom(dbManager.getString(resultSet,14));
            prpJpremAllocDto.setOperatorCode(dbManager.getString(resultSet,15));
            prpJpremAllocDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpJpremAllocDto.setFlag(dbManager.getString(resultSet,17));
        }
        resultSet.close();
        log.info("DBPrpJpremAllocBase.findByPrimaryKey() success!");
        return prpJpremAllocDto;
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
                           " SumPremium," + 
                           " PrePremium," + 
                           " AllocPremium," + 
                           " AllocFee," + 
                           " AllocDate," + 
                           " TransFlag," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " OperatorCode," + 
                           " InputDate," + 
                           " Flag From PrpJpremAlloc Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJpremAllocDto prpJpremAllocDto = null;
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

            prpJpremAllocDto = new PrpJpremAllocDto();
            prpJpremAllocDto.setRiskCode(dbManager.getString(resultSet,1));
            prpJpremAllocDto.setAllocNo(dbManager.getString(resultSet,2));
            prpJpremAllocDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpJpremAllocDto.setSerialNo(dbManager.getInt(resultSet,4));
            prpJpremAllocDto.setPayReason(dbManager.getString(resultSet,5));
            prpJpremAllocDto.setCurrency(dbManager.getString(resultSet,6));
            prpJpremAllocDto.setSumPremium(dbManager.getDouble(resultSet,7));
            prpJpremAllocDto.setPrePremium(dbManager.getDouble(resultSet,8));
            prpJpremAllocDto.setAllocPremium(dbManager.getDouble(resultSet,9));
            prpJpremAllocDto.setAllocFee(dbManager.getDouble(resultSet,10));
            prpJpremAllocDto.setAllocDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpJpremAllocDto.setTransFlag(dbManager.getString(resultSet,12));
            prpJpremAllocDto.setComCode(dbManager.getString(resultSet,13));
            prpJpremAllocDto.setMakeCom(dbManager.getString(resultSet,14));
            prpJpremAllocDto.setOperatorCode(dbManager.getString(resultSet,15));
            prpJpremAllocDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,16));
            prpJpremAllocDto.setFlag(dbManager.getString(resultSet,17));
            collection.add(prpJpremAllocDto);
        }
        resultSet.close();
        log.info("DBPrpJpremAllocBase.findByConditions() success!");
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
        String statement = "Delete From PrpJpremAlloc Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJpremAllocBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpJpremAlloc Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJpremAllocBase.getCount() success!");
        return count;
    }
}

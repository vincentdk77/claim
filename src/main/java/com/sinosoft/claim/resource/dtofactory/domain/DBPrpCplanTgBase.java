package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCplanDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcplan收费计划表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCplanTgBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCplanTgBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCplanTgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCplanDto prpCplanDto
     * @throws Exception
     */
    public void insert(PrpCplanDto prpCplanDto) throws Exception{
        String statement = " Insert Into PrpCplanTg(" + 
                           " PolicyNo," + 
                           " EndorseNo," + 
                           " SerialNo," + 
                           " PayNo," + 
                           " PayReason," + 
                           " PlanDate," + 
                           " Currency," + 
                           " PlanFee," + 
                           " DelinquentFee," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCplanDto.getPolicyNo());
        dbManager.setString(2,prpCplanDto.getEndorseNo());
        dbManager.setInt(3,prpCplanDto.getSerialNo());
        dbManager.setInt(4,prpCplanDto.getPayNo());
        dbManager.setString(5,prpCplanDto.getPayReason());
        dbManager.setDateTime(6,prpCplanDto.getPlanDate());
        dbManager.setString(7,prpCplanDto.getCurrency());
        dbManager.setDouble(8,prpCplanDto.getPlanFee());
        dbManager.setDouble(9,prpCplanDto.getDelinquentFee());
        dbManager.setString(10,prpCplanDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCplanBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCplanDto prpCplanDto = (PrpCplanDto)i.next();
            insert(prpCplanDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param serialNo 交费次数序号
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo) throws Exception{
        String statement = " Delete From PrpCplanTg Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCplanBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCplanDto prpCplanDto
     * @throws Exception
     */
    public void update(PrpCplanDto prpCplanDto) throws Exception{
        String statement = " Update PrpCplanTg Set EndorseNo = ?," + 
                           " PayNo = ?," + 
                           " PayReason = ?," + 
                           " PlanDate = ?," + 
                           " Currency = ?," + 
                           " PlanFee = ?," + 
                           " DelinquentFee = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCplanDto.getEndorseNo());
        dbManager.setInt(2,prpCplanDto.getPayNo());
        dbManager.setString(3,prpCplanDto.getPayReason());
        dbManager.setDateTime(4,prpCplanDto.getPlanDate());
        dbManager.setString(5,prpCplanDto.getCurrency());
        dbManager.setDouble(6,prpCplanDto.getPlanFee());
        dbManager.setDouble(7,prpCplanDto.getDelinquentFee());
        dbManager.setString(8,prpCplanDto.getFlag());
        //设置条件字段;
        dbManager.setString(9,prpCplanDto.getPolicyNo());
        dbManager.setInt(10,prpCplanDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCplanBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param serialNo 交费次数序号
     * @return PrpCplanDto
     * @throws Exception
     */
    public PrpCplanDto findByPrimaryKey(String policyNo,int serialNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " EndorseNo," + 
                           " SerialNo," + 
                           " PayNo," + 
                           " PayReason," + 
                           " PlanDate," + 
                           " Currency," + 
                           " PlanFee," + 
                           " DelinquentFee," + 
                           " Flag From PrpCplanTg Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ?";
        PrpCplanDto prpCplanDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCplanDto = new PrpCplanDto();
            prpCplanDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCplanDto.setEndorseNo(dbManager.getString(resultSet,2));
            prpCplanDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCplanDto.setPayNo(dbManager.getInt(resultSet,4));
            prpCplanDto.setPayReason(dbManager.getString(resultSet,5));
            prpCplanDto.setPlanDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpCplanDto.setCurrency(dbManager.getString(resultSet,7));
            prpCplanDto.setPlanFee(dbManager.getDouble(resultSet,8));
            prpCplanDto.setDelinquentFee(dbManager.getDouble(resultSet,9));
            prpCplanDto.setFlag(dbManager.getString(resultSet,10));
        }
        resultSet.close();
        log.info("DBPrpCplanBase.findByPrimaryKey() success!");
        return prpCplanDto;
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
                           " EndorseNo," + 
                           " SerialNo," + 
                           " PayNo," + 
                           " PayReason," + 
                           " PlanDate," + 
                           " Currency," + 
                           " PlanFee," + 
                           " DelinquentFee," + 
                           " Flag From PrpCplanTg Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCplanDto prpCplanDto = null;
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

            prpCplanDto = new PrpCplanDto();
            prpCplanDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCplanDto.setEndorseNo(dbManager.getString(resultSet,2));
            prpCplanDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpCplanDto.setPayNo(dbManager.getInt(resultSet,4));
            prpCplanDto.setPayReason(dbManager.getString(resultSet,5));
            prpCplanDto.setPlanDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpCplanDto.setCurrency(dbManager.getString(resultSet,7));
            prpCplanDto.setPlanFee(dbManager.getDouble(resultSet,8));
            prpCplanDto.setDelinquentFee(dbManager.getDouble(resultSet,9));
            prpCplanDto.setFlag(dbManager.getString(resultSet,10));
            collection.add(prpCplanDto);
        }
        resultSet.close();
        log.info("DBPrpCplanBase.findByConditions() success!");
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
        String statement = "Delete From PrpCplanTg Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCplanBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCplanTg Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCplanBase.getCount() success!");
        return count;
    }
}

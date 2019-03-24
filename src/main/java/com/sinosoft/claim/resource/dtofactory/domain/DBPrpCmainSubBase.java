package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainSubDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcmainsub保单隶属表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCmainSubBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCmainSubBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCmainSubBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCmainSubDto prpCmainSubDto
     * @throws Exception
     */
    public void insert(PrpCmainSubDto prpCmainSubDto) throws Exception{
        String statement = " Insert Into PrpCmainSub(" + 
                           " PolicyNo," + 
                           " MainPolicyNo," + 
                           " EndorseNo," + 
                           " Flag) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCmainSubDto.getPolicyNo());
        dbManager.setString(2,prpCmainSubDto.getMainPolicyNo());
        dbManager.setString(3,prpCmainSubDto.getEndorseNo());
        dbManager.setString(4,prpCmainSubDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCmainSubBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCmainSubDto prpCmainSubDto = (PrpCmainSubDto)i.next();
            insert(prpCmainSubDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param mainPolicyNo 主保单号码
     * @throws Exception
     */
    public void delete(String policyNo,String mainPolicyNo) throws Exception{
        String statement = " Delete From PrpCmainSub Where " +
                           " PolicyNo = ? And " + 
                           " MainPolicyNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,mainPolicyNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCmainSubBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCmainSubDto prpCmainSubDto
     * @throws Exception
     */
    public void update(PrpCmainSubDto prpCmainSubDto) throws Exception{
        String statement = " Update PrpCmainSub Set EndorseNo = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " MainPolicyNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCmainSubDto.getEndorseNo());
        dbManager.setString(2,prpCmainSubDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,prpCmainSubDto.getPolicyNo());
        dbManager.setString(4,prpCmainSubDto.getMainPolicyNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCmainSubBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param mainPolicyNo 主保单号码
     * @return PrpCmainSubDto
     * @throws Exception
     */
    public PrpCmainSubDto findByPrimaryKey(String policyNo,String mainPolicyNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " MainPolicyNo," + 
                           " EndorseNo," + 
                           " Flag From PrpCmainSub Where " +
                           " PolicyNo = ? And " + 
                           " MainPolicyNo = ?";
        PrpCmainSubDto prpCmainSubDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setString(2,mainPolicyNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCmainSubDto = new PrpCmainSubDto();
            prpCmainSubDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCmainSubDto.setMainPolicyNo(dbManager.getString(resultSet,2));
            prpCmainSubDto.setEndorseNo(dbManager.getString(resultSet,3));
            prpCmainSubDto.setFlag(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBPrpCmainSubBase.findByPrimaryKey() success!");
        return prpCmainSubDto;
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
                           " MainPolicyNo," + 
                           " EndorseNo," + 
                           " Flag," +
                           " startDate," +
                           " endDate From PrpCmainSub Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCmainSubDto prpCmainSubDto = null;
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

            prpCmainSubDto = new PrpCmainSubDto();
            prpCmainSubDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCmainSubDto.setMainPolicyNo(dbManager.getString(resultSet,2));
            prpCmainSubDto.setEndorseNo(dbManager.getString(resultSet,3));
            prpCmainSubDto.setFlag(dbManager.getString(resultSet,4));
            prpCmainSubDto.setStartDate(dbManager.getDateTime(resultSet,5));
            prpCmainSubDto.setEndDate(dbManager.getDateTime(resultSet,6));
            collection.add(prpCmainSubDto);
        }
        resultSet.close();
        log.info("DBPrpCmainSubBase.findByConditions() success!");
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
        String statement = "Delete From PrpCmainSub Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCmainSubBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCmainSub Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCmainSubBase.getCount() success!");
        return count;
    }
}

package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCitemDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcitem保险标的项目表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCitemBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCitemBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCitemBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCitemDto prpCitemDto
     * @throws Exception
     */
    public void insert(PrpCitemDto prpCitemDto) throws Exception{
        String statement = " Insert Into PrpCitem(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " ItemNo," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " PlusRate," + 
                           " AddressNo," + 
                           " Flag) values(?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCitemDto.getPolicyNo());
        dbManager.setString(2,prpCitemDto.getRiskCode());
        dbManager.setInt(3,prpCitemDto.getItemNo());
        dbManager.setString(4,prpCitemDto.getItemCode());
        dbManager.setString(5,prpCitemDto.getItemName());
        dbManager.setDouble(6,prpCitemDto.getPlusRate());
        dbManager.setInt(7,prpCitemDto.getAddressNo());
        dbManager.setString(8,prpCitemDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCitemBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCitemDto prpCitemDto = (PrpCitemDto)i.next();
            insert(prpCitemDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param itemNo 标的序号
     * @throws Exception
     */
    public void delete(String policyNo,int itemNo) throws Exception{
        String statement = " Delete From PrpCitem Where " +
                           " PolicyNo = ? And " + 
                           " ItemNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,itemNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCitemBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCitemDto prpCitemDto
     * @throws Exception
     */
    public void update(PrpCitemDto prpCitemDto) throws Exception{
        String statement = " Update PrpCitem Set RiskCode = ?," + 
                           " ItemCode = ?," + 
                           " ItemName = ?," + 
                           " PlusRate = ?," + 
                           " AddressNo = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " ItemNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCitemDto.getRiskCode());
        dbManager.setString(2,prpCitemDto.getItemCode());
        dbManager.setString(3,prpCitemDto.getItemName());
        dbManager.setDouble(4,prpCitemDto.getPlusRate());
        dbManager.setInt(5,prpCitemDto.getAddressNo());
        dbManager.setString(6,prpCitemDto.getFlag());
        //设置条件字段;
        dbManager.setString(7,prpCitemDto.getPolicyNo());
        dbManager.setInt(8,prpCitemDto.getItemNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCitemBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param itemNo 标的序号
     * @return PrpCitemDto
     * @throws Exception
     */
    public PrpCitemDto findByPrimaryKey(String policyNo,int itemNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " ItemNo," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " PlusRate," + 
                           " AddressNo," + 
                           " Flag From PrpCitem Where " +
                           " PolicyNo = ? And " + 
                           " ItemNo = ?";
        PrpCitemDto prpCitemDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,itemNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCitemDto = new PrpCitemDto();
            prpCitemDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemDto.setItemNo(dbManager.getInt(resultSet,3));
            prpCitemDto.setItemCode(dbManager.getString(resultSet,4));
            prpCitemDto.setItemName(dbManager.getString(resultSet,5));
            prpCitemDto.setPlusRate(dbManager.getDouble(resultSet,6));
            prpCitemDto.setAddressNo(dbManager.getInt(resultSet,7));
            prpCitemDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        log.info("DBPrpCitemBase.findByPrimaryKey() success!");
        return prpCitemDto;
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
                           " ItemNo," + 
                           " ItemCode," + 
                           " ItemName," + 
                           " PlusRate," + 
                           " AddressNo," + 
                           " Flag From PrpCitem Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCitemDto prpCitemDto = null;
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

            prpCitemDto = new PrpCitemDto();
            prpCitemDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCitemDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCitemDto.setItemNo(dbManager.getInt(resultSet,3));
            prpCitemDto.setItemCode(dbManager.getString(resultSet,4));
            prpCitemDto.setItemName(dbManager.getString(resultSet,5));
            prpCitemDto.setPlusRate(dbManager.getDouble(resultSet,6));
            prpCitemDto.setAddressNo(dbManager.getInt(resultSet,7));
            prpCitemDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpCitemDto);
        }
        resultSet.close();
        log.info("DBPrpCitemBase.findByConditions() success!");
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
        String statement = "Delete From PrpCitem Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCitemBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCitem Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCitemBase.getCount() success!");
        return count;
    }
}

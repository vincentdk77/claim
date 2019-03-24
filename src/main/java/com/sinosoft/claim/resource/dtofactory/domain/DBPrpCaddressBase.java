package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCaddressDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcaddress保险地址表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCaddressBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCaddressBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCaddressBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCaddressDto prpCaddressDto
     * @throws Exception
     */
    public void insert(PrpCaddressDto prpCaddressDto) throws Exception{
        String statement = " Insert Into PrpCaddress(" + 
                           " PolicyNo," + 
                           " RiskCode," + 
                           " AddressNo," + 
                           " AddressCode," + 
                           " AddressName," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCaddressDto.getPolicyNo());
        dbManager.setString(2,prpCaddressDto.getRiskCode());
        dbManager.setInt(3,prpCaddressDto.getAddressNo());
        dbManager.setString(4,prpCaddressDto.getAddressCode());
        dbManager.setString(5,prpCaddressDto.getAddressName());
        dbManager.setString(6,prpCaddressDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCaddressBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCaddressDto prpCaddressDto = (PrpCaddressDto)i.next();
            insert(prpCaddressDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param addressNo 地址序号
     * @throws Exception
     */
    public void delete(String policyNo,int addressNo) throws Exception{
        String statement = " Delete From PrpCaddress Where " +
                           " PolicyNo = ? And " + 
                           " AddressNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,addressNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCaddressBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCaddressDto prpCaddressDto
     * @throws Exception
     */
    public void update(PrpCaddressDto prpCaddressDto) throws Exception{
        String statement = " Update PrpCaddress Set RiskCode = ?," + 
                           " AddressCode = ?," + 
                           " AddressName = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " AddressNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCaddressDto.getRiskCode());
        dbManager.setString(2,prpCaddressDto.getAddressCode());
        dbManager.setString(3,prpCaddressDto.getAddressName());
        dbManager.setString(4,prpCaddressDto.getFlag());
        //设置条件字段;
        dbManager.setString(5,prpCaddressDto.getPolicyNo());
        dbManager.setInt(6,prpCaddressDto.getAddressNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCaddressBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param addressNo 地址序号
     * @return PrpCaddressDto
     * @throws Exception
     */
    public PrpCaddressDto findByPrimaryKey(String policyNo,int addressNo) throws Exception{
        String statement = " Select PolicyNo," + 
                           " RiskCode," + 
                           " AddressNo," + 
                           " AddressCode," + 
                           " AddressName," + 
                           " Flag From PrpCaddress Where " +
                           " PolicyNo = ? And " + 
                           " AddressNo = ?";
        PrpCaddressDto prpCaddressDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,addressNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCaddressDto = new PrpCaddressDto();
            prpCaddressDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCaddressDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCaddressDto.setAddressNo(dbManager.getInt(resultSet,3));
            prpCaddressDto.setAddressCode(dbManager.getString(resultSet,4));
            prpCaddressDto.setAddressName(dbManager.getString(resultSet,5));
            prpCaddressDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpCaddressBase.findByPrimaryKey() success!");
        return prpCaddressDto;
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
                           " AddressNo," + 
                           " AddressCode," + 
                           " AddressName," + 
                           " Flag From PrpCaddress Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCaddressDto prpCaddressDto = null;
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

            prpCaddressDto = new PrpCaddressDto();
            prpCaddressDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCaddressDto.setRiskCode(dbManager.getString(resultSet,2));
            prpCaddressDto.setAddressNo(dbManager.getInt(resultSet,3));
            prpCaddressDto.setAddressCode(dbManager.getString(resultSet,4));
            prpCaddressDto.setAddressName(dbManager.getString(resultSet,5));
            prpCaddressDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpCaddressDto);
        }
        resultSet.close();
        log.info("DBPrpCaddressBase.findByConditions() success!");
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
        String statement = "Delete From PrpCaddress Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCaddressBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCaddress Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCaddressBase.getCount() success!");
        return count;
    }
}

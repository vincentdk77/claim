package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpXPformDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpxpform的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpXPformBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpXPformBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpXPformBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpXPformDto prpXPformDto
     * @throws Exception
     */
    public void insert(PrpXPformDto prpXPformDto) throws Exception{
        String statement = " Insert Into PrpXPform(" + 
                           " RiskCode," + 
                           " EndorType," + 
                           " EndorTypeName," + 
                           " LayRow," + 
                           " LayCol," + 
                           " FormName," + 
                           " TableName," + 
                           " Flag) values(?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpXPformDto.getRiskCode());
        dbManager.setString(2,prpXPformDto.getEndorType());
        dbManager.setString(3,prpXPformDto.getEndorTypeName());
        dbManager.setInt(4,prpXPformDto.getLayRow());
        dbManager.setInt(5,prpXPformDto.getLayCol());
        dbManager.setString(6,prpXPformDto.getFormName());
        dbManager.setString(7,prpXPformDto.getTableName());
        dbManager.setString(8,prpXPformDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpXPformBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpXPformDto prpXPformDto = (PrpXPformDto)i.next();
            insert(prpXPformDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param riskCode riskcode
     * @param endorType endortype
     * @throws Exception
     */
    public void delete(String riskCode,String endorType) throws Exception{
        String statement = " Delete From PrpXPform Where " +
                           " RiskCode = ? And " + 
                           " EndorType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,endorType);
        dbManager.executePreparedUpdate();
        log.info("DBPrpXPformBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpXPformDto prpXPformDto
     * @throws Exception
     */
    public void update(PrpXPformDto prpXPformDto) throws Exception{
        String statement = " Update PrpXPform Set EndorTypeName = ?," + 
                           " LayRow = ?," + 
                           " LayCol = ?," + 
                           " FormName = ?," + 
                           " TableName = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " EndorType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpXPformDto.getEndorTypeName());
        dbManager.setInt(2,prpXPformDto.getLayRow());
        dbManager.setInt(3,prpXPformDto.getLayCol());
        dbManager.setString(4,prpXPformDto.getFormName());
        dbManager.setString(5,prpXPformDto.getTableName());
        dbManager.setString(6,prpXPformDto.getFlag());
        //设置条件字段;
        dbManager.setString(7,prpXPformDto.getRiskCode());
        dbManager.setString(8,prpXPformDto.getEndorType());
        dbManager.executePreparedUpdate();

        log.info("DBPrpXPformBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param riskCode riskcode
     * @param endorType endortype
     * @return PrpXPformDto
     * @throws Exception
     */
    public PrpXPformDto findByPrimaryKey(String riskCode,String endorType) throws Exception{
        String statement = " Select RiskCode," + 
                           " EndorType," + 
                           " EndorTypeName," + 
                           " LayRow," + 
                           " LayCol," + 
                           " FormName," + 
                           " TableName," + 
                           " Flag From PrpXPform Where " +
                           " RiskCode = ? And " + 
                           " EndorType = ?";
        PrpXPformDto prpXPformDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,endorType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpXPformDto = new PrpXPformDto();
            prpXPformDto.setRiskCode(dbManager.getString(resultSet,1));
            prpXPformDto.setEndorType(dbManager.getString(resultSet,2));
            prpXPformDto.setEndorTypeName(dbManager.getString(resultSet,3));
            prpXPformDto.setLayRow(dbManager.getInt(resultSet,4));
            prpXPformDto.setLayCol(dbManager.getInt(resultSet,5));
            prpXPformDto.setFormName(dbManager.getString(resultSet,6));
            prpXPformDto.setTableName(dbManager.getString(resultSet,7));
            prpXPformDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        log.info("DBPrpXPformBase.findByPrimaryKey() success!");
        return prpXPformDto;
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
                           " EndorType," + 
                           " EndorTypeName," + 
                           " LayRow," + 
                           " LayCol," + 
                           " FormName," + 
                           " TableName," + 
                           " Flag From PrpXPform Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpXPformDto prpXPformDto = null;
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

            prpXPformDto = new PrpXPformDto();
            prpXPformDto.setRiskCode(dbManager.getString(resultSet,1));
            prpXPformDto.setEndorType(dbManager.getString(resultSet,2));
            prpXPformDto.setEndorTypeName(dbManager.getString(resultSet,3));
            prpXPformDto.setLayRow(dbManager.getInt(resultSet,4));
            prpXPformDto.setLayCol(dbManager.getInt(resultSet,5));
            prpXPformDto.setFormName(dbManager.getString(resultSet,6));
            prpXPformDto.setTableName(dbManager.getString(resultSet,7));
            prpXPformDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(prpXPformDto);
        }
        resultSet.close();
        log.info("DBPrpXPformBase.findByConditions() success!");
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
        String statement = "Delete From PrpXPform Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpXPformBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpXPform Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpXPformBase.getCount() success!");
        return count;
    }
}

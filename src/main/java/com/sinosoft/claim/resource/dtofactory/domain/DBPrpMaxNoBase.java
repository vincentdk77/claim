package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpMaxNoDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpmaxno单证号表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpMaxNoBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpMaxNoBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpMaxNoBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpMaxNoDto prpMaxNoDto
     * @throws Exception
     */
    public void insert(PrpMaxNoDto prpMaxNoDto) throws Exception{
        String statement = " Insert Into PrpMaxNo(" + 
                           " GroupNo," + 
                           " MaxNo," + 
                           " TableName," + 
                           " Flag) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpMaxNoDto.getGroupNo());
        dbManager.setString(2,prpMaxNoDto.getMaxNo());
        dbManager.setString(3,prpMaxNoDto.getTableName());
        dbManager.setString(4,prpMaxNoDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpMaxNoBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpMaxNoDto prpMaxNoDto = (PrpMaxNoDto)i.next();
            insert(prpMaxNoDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param groupNo 编组
     * @param maxNo 编号
     * @param tableName 表名
     * @throws Exception
     */
    public void delete(String groupNo,String maxNo,String tableName) throws Exception{
        String statement = " Delete From PrpMaxNo Where " +
                           " GroupNo = ? And " + 
                           " MaxNo = ? And " + 
                           " TableName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,groupNo);
        dbManager.setString(2,maxNo);
        dbManager.setString(3,tableName);
        dbManager.executePreparedUpdate();
        log.info("DBPrpMaxNoBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpMaxNoDto prpMaxNoDto
     * @throws Exception
     */
    public void update(PrpMaxNoDto prpMaxNoDto) throws Exception{
        String statement = " Update PrpMaxNo Set Flag = ? Where " +
                           " GroupNo = ? And " + 
                           " MaxNo = ? And " + 
                           " TableName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpMaxNoDto.getFlag());
        //设置条件字段;
        dbManager.setString(2,prpMaxNoDto.getGroupNo());
        dbManager.setString(3,prpMaxNoDto.getMaxNo());
        dbManager.setString(4,prpMaxNoDto.getTableName());
        dbManager.executePreparedUpdate();

        log.info("DBPrpMaxNoBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param groupNo 编组
     * @param maxNo 编号
     * @param tableName 表名
     * @return PrpMaxNoDto
     * @throws Exception
     */
    public PrpMaxNoDto findByPrimaryKey(String groupNo,String maxNo,String tableName) throws Exception{
        String statement = " Select GroupNo," + 
                           " MaxNo," + 
                           " TableName," + 
                           " Flag From PrpMaxNo Where " +
                           " GroupNo = ? And " + 
                           " MaxNo = ? And " + 
                           " TableName = ?";
        PrpMaxNoDto prpMaxNoDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,groupNo);
        dbManager.setString(2,maxNo);
        dbManager.setString(3,tableName);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpMaxNoDto = new PrpMaxNoDto();
            prpMaxNoDto.setGroupNo(dbManager.getString(resultSet,1));
            prpMaxNoDto.setMaxNo(dbManager.getString(resultSet,2));
            prpMaxNoDto.setTableName(dbManager.getString(resultSet,3));
            prpMaxNoDto.setFlag(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBPrpMaxNoBase.findByPrimaryKey() success!");
        return prpMaxNoDto;
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
        String statement = "Select GroupNo," + 
                           " MaxNo," + 
                           " TableName," + 
                           " Flag From PrpMaxNo Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpMaxNoDto prpMaxNoDto = null;
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

            prpMaxNoDto = new PrpMaxNoDto();
            prpMaxNoDto.setGroupNo(dbManager.getString(resultSet,1));
            prpMaxNoDto.setMaxNo(dbManager.getString(resultSet,2));
            prpMaxNoDto.setTableName(dbManager.getString(resultSet,3));
            prpMaxNoDto.setFlag(dbManager.getString(resultSet,4));
            collection.add(prpMaxNoDto);
        }
        resultSet.close();
        log.info("DBPrpMaxNoBase.findByConditions() success!");
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
        String statement = "Delete From PrpMaxNo Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpMaxNoBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpMaxNo Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpMaxNoBase.getCount() success!");
        return count;
    }
}

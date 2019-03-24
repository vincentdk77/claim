package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCinsuredExtDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcinsuredext关系人扩展信息表的数据访问对象类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCinsuredExtBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCinsuredExtBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCinsuredExtBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpCinsuredExtDto prpCinsuredExtDto
     * @throws Exception
     */
    public void insert(PrpCinsuredExtDto prpCinsuredExtDto) throws Exception{
        String statement = " Insert Into PrpCinsuredExt(" + 
                           " PolicyNo," + 
                           " SerialNo," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " ColumnValue," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpCinsuredExtDto.getPolicyNo());
        dbManager.setInt(2,prpCinsuredExtDto.getSerialNo());
        dbManager.setString(3,prpCinsuredExtDto.getColumnName());
        dbManager.setString(4,prpCinsuredExtDto.getDisplayName());
        dbManager.setString(5,prpCinsuredExtDto.getColumnValue());
        dbManager.setString(6,prpCinsuredExtDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCinsuredExtBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpCinsuredExtDto prpCinsuredExtDto = (PrpCinsuredExtDto)i.next();
            insert(prpCinsuredExtDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @param columnName 扩充字段名
     * @throws Exception
     */
    public void delete(String policyNo,int serialNo,String columnName) throws Exception{
        String statement = " Delete From PrpCinsuredExt Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ColumnName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,columnName);
        dbManager.executePreparedUpdate();
        log.info("DBPrpCinsuredExtBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpCinsuredExtDto prpCinsuredExtDto
     * @throws Exception
     */
    public void update(PrpCinsuredExtDto prpCinsuredExtDto) throws Exception{
        String statement = " Update PrpCinsuredExt Set DisplayName = ?," + 
                           " ColumnValue = ?," + 
                           " Flag = ? Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ColumnName = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpCinsuredExtDto.getDisplayName());
        dbManager.setString(2,prpCinsuredExtDto.getColumnValue());
        dbManager.setString(3,prpCinsuredExtDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,prpCinsuredExtDto.getPolicyNo());
        dbManager.setInt(5,prpCinsuredExtDto.getSerialNo());
        dbManager.setString(6,prpCinsuredExtDto.getColumnName());
        dbManager.executePreparedUpdate();

        log.info("DBPrpCinsuredExtBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param policyNo 保单号码
     * @param serialNo 序号
     * @param columnName 扩充字段名
     * @return PrpCinsuredExtDto
     * @throws Exception
     */
    public PrpCinsuredExtDto findByPrimaryKey(String policyNo,int serialNo,String columnName) throws Exception{
        String statement = " Select PolicyNo," + 
                           " SerialNo," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " ColumnValue," + 
                           " Flag From PrpCinsuredExt Where " +
                           " PolicyNo = ? And " + 
                           " SerialNo = ? And " + 
                           " ColumnName = ?";
        PrpCinsuredExtDto prpCinsuredExtDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,policyNo);
        dbManager.setInt(2,serialNo);
        dbManager.setString(3,columnName);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpCinsuredExtDto = new PrpCinsuredExtDto();
            prpCinsuredExtDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCinsuredExtDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCinsuredExtDto.setColumnName(dbManager.getString(resultSet,3));
            prpCinsuredExtDto.setDisplayName(dbManager.getString(resultSet,4));
            prpCinsuredExtDto.setColumnValue(dbManager.getString(resultSet,5));
            prpCinsuredExtDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBPrpCinsuredExtBase.findByPrimaryKey() success!");
        return prpCinsuredExtDto;
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
                           " SerialNo," + 
                           " ColumnName," + 
                           " DisplayName," + 
                           " ColumnValue," + 
                           " Flag From PrpCinsuredExt Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpCinsuredExtDto prpCinsuredExtDto = null;
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

            prpCinsuredExtDto = new PrpCinsuredExtDto();
            prpCinsuredExtDto.setPolicyNo(dbManager.getString(resultSet,1));
            prpCinsuredExtDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpCinsuredExtDto.setColumnName(dbManager.getString(resultSet,3));
            prpCinsuredExtDto.setDisplayName(dbManager.getString(resultSet,4));
            prpCinsuredExtDto.setColumnValue(dbManager.getString(resultSet,5));
            prpCinsuredExtDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(prpCinsuredExtDto);
        }
        resultSet.close();
        log.info("DBPrpCinsuredExtBase.findByConditions() success!");
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
        String statement = "Delete From PrpCinsuredExt Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpCinsuredExtBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpCinsuredExt Where " + conditions;
        statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpCinsuredExtBase.getCount() success!");
        return count;
    }
}

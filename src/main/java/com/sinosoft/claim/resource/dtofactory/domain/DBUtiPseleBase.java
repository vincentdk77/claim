package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPseleDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utipsele单证打印的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiPseleBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiPseleBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiPseleBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiPseleDto utiPseleDto
     * @throws Exception
     */
    public void insert(UtiPseleDto utiPseleDto) throws Exception{
        String statement = " Insert Into UtiPsele(" + 
                           " FileName," + 
                           " OrderNo," + 
                           " FieldName," + 
                           " SelFlag," + 
                           " TabName," + 
                           " WhereClause," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiPseleDto.getFileName());
        dbManager.setString(2,utiPseleDto.getOrderNo());
        dbManager.setString(3,utiPseleDto.getFieldName());
        dbManager.setString(4,utiPseleDto.getSelFlag());
        dbManager.setString(5,utiPseleDto.getTabName());
        dbManager.setString(6,utiPseleDto.getWhereClause());
        dbManager.setString(7,utiPseleDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPseleBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiPseleDto utiPseleDto = (UtiPseleDto)i.next();
            insert(utiPseleDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param fileName 文件名
     * @param orderNo 序号
     * @throws Exception
     */
    public void delete(String fileName,String orderNo) throws Exception{
        String statement = " Delete From UtiPsele Where " +
                           " FileName = ? And " + 
                           " OrderNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,fileName);
        dbManager.setString(2,orderNo);
        dbManager.executePreparedUpdate();
        log.info("DBUtiPseleBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiPseleDto utiPseleDto
     * @throws Exception
     */
    public void update(UtiPseleDto utiPseleDto) throws Exception{
        String statement = " Update UtiPsele Set FieldName = ?," + 
                           " SelFlag = ?," + 
                           " TabName = ?," + 
                           " WhereClause = ?," + 
                           " Flag = ? Where " +
                           " FileName = ? And " + 
                           " OrderNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiPseleDto.getFieldName());
        dbManager.setString(2,utiPseleDto.getSelFlag());
        dbManager.setString(3,utiPseleDto.getTabName());
        dbManager.setString(4,utiPseleDto.getWhereClause());
        dbManager.setString(5,utiPseleDto.getFlag());
        //设置条件字段;
        dbManager.setString(6,utiPseleDto.getFileName());
        dbManager.setString(7,utiPseleDto.getOrderNo());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPseleBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param fileName 文件名
     * @param orderNo 序号
     * @return UtiPseleDto
     * @throws Exception
     */
    public UtiPseleDto findByPrimaryKey(String fileName,String orderNo) throws Exception{
        String statement = " Select FileName," + 
                           " OrderNo," + 
                           " FieldName," + 
                           " SelFlag," + 
                           " TabName," + 
                           " WhereClause," + 
                           " Flag From UtiPsele Where " +
                           " FileName = ? And " + 
                           " OrderNo = ?";
        UtiPseleDto utiPseleDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,fileName);
        dbManager.setString(2,orderNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiPseleDto = new UtiPseleDto();
            utiPseleDto.setFileName(dbManager.getString(resultSet,1));
            utiPseleDto.setOrderNo(dbManager.getString(resultSet,2));
            utiPseleDto.setFieldName(dbManager.getString(resultSet,3));
            utiPseleDto.setSelFlag(dbManager.getString(resultSet,4));
            utiPseleDto.setTabName(dbManager.getString(resultSet,5));
            utiPseleDto.setWhereClause(dbManager.getString(resultSet,6));
            utiPseleDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBUtiPseleBase.findByPrimaryKey() success!");
        return utiPseleDto;
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
        String statement = "Select FileName," + 
                           " OrderNo," + 
                           " FieldName," + 
                           " SelFlag," + 
                           " TabName," + 
                           " WhereClause," + 
                           " Flag From UtiPsele Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiPseleDto utiPseleDto = null;
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

            utiPseleDto = new UtiPseleDto();
            utiPseleDto.setFileName(dbManager.getString(resultSet,1));
            utiPseleDto.setOrderNo(dbManager.getString(resultSet,2));
            utiPseleDto.setFieldName(dbManager.getString(resultSet,3));
            utiPseleDto.setSelFlag(dbManager.getString(resultSet,4));
            utiPseleDto.setTabName(dbManager.getString(resultSet,5));
            utiPseleDto.setWhereClause(dbManager.getString(resultSet,6));
            utiPseleDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(utiPseleDto);
        }
        resultSet.close();
        log.info("DBUtiPseleBase.findByConditions() success!");
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
        String statement = "Delete From UtiPsele Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiPseleBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from UtiPsele Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiPseleBase.getCount() success!");
        return count;
    }
}

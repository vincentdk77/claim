package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiPrtFormDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utiprtform复杂横纵表头的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiPrtFormBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiPrtFormBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiPrtFormBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiPrtFormDto utiPrtFormDto
     * @throws Exception
     */
    public void insert(UtiPrtFormDto utiPrtFormDto) throws Exception{
        String statement = " Insert Into UtiPrtForm(" + 
                           " HeadCode," + 
                           " HeadName," + 
                           " HeadLength," + 
                           " HeadType) values(?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiPrtFormDto.getHeadCode());
        dbManager.setString(2,utiPrtFormDto.getHeadName());
        dbManager.setInt(3,utiPrtFormDto.getHeadLength());
        dbManager.setString(4,utiPrtFormDto.getHeadType());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPrtFormBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiPrtFormDto utiPrtFormDto = (UtiPrtFormDto)i.next();
            insert(utiPrtFormDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param headCode 表头编码
     * @throws Exception
     */
    public void delete(String headCode) throws Exception{
        String statement = " Delete From UtiPrtForm Where " +
                           " HeadCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,headCode);
        dbManager.executePreparedUpdate();
        log.info("DBUtiPrtFormBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiPrtFormDto utiPrtFormDto
     * @throws Exception
     */
    public void update(UtiPrtFormDto utiPrtFormDto) throws Exception{
        String statement = " Update UtiPrtForm Set HeadName = ?," + 
                           " HeadLength = ?," + 
                           " HeadType = ? Where " +
                           " HeadCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiPrtFormDto.getHeadName());
        dbManager.setInt(2,utiPrtFormDto.getHeadLength());
        dbManager.setString(3,utiPrtFormDto.getHeadType());
        //设置条件字段;
        dbManager.setString(4,utiPrtFormDto.getHeadCode());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPrtFormBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param headCode 表头编码
     * @return UtiPrtFormDto
     * @throws Exception
     */
    public UtiPrtFormDto findByPrimaryKey(String headCode) throws Exception{
        String statement = " Select HeadCode," + 
                           " HeadName," + 
                           " HeadLength," + 
                           " HeadType From UtiPrtForm Where " +
                           " HeadCode = ?";
        UtiPrtFormDto utiPrtFormDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,headCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiPrtFormDto = new UtiPrtFormDto();
            utiPrtFormDto.setHeadCode(dbManager.getString(resultSet,1));
            utiPrtFormDto.setHeadName(dbManager.getString(resultSet,2));
            utiPrtFormDto.setHeadLength(dbManager.getInt(resultSet,3));
            utiPrtFormDto.setHeadType(dbManager.getString(resultSet,4));
        }
        resultSet.close();
        log.info("DBUtiPrtFormBase.findByPrimaryKey() success!");
        return utiPrtFormDto;
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
        String statement = "Select HeadCode," + 
                           " HeadName," + 
                           " HeadLength," + 
                           " HeadType From UtiPrtForm Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiPrtFormDto utiPrtFormDto = null;
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

            utiPrtFormDto = new UtiPrtFormDto();
            utiPrtFormDto.setHeadCode(dbManager.getString(resultSet,1));
            utiPrtFormDto.setHeadName(dbManager.getString(resultSet,2));
            utiPrtFormDto.setHeadLength(dbManager.getInt(resultSet,3));
            utiPrtFormDto.setHeadType(dbManager.getString(resultSet,4));
            collection.add(utiPrtFormDto);
        }
        resultSet.close();
        log.info("DBUtiPrtFormBase.findByConditions() success!");
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
        String statement = "Delete From UtiPrtForm Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiPrtFormBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from UtiPrtForm Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiPrtFormBase.getCount() success!");
        return count;
    }
}

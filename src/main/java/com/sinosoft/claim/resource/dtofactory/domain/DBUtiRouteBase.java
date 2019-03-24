package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiRouteDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是UtiRoute路由配置表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiRouteBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiRouteBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiRouteBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiRouteDto utiRouteDto
     * @throws Exception
     */
    public void insert(UtiRouteDto utiRouteDto) throws Exception{
        String statement = " Insert Into UtiRoute(" + 
                           " ComCode," + 
                           " ComName," + 
                           " HostName," + 
                           " IPaddress," + 
                           " ServerName," + 
                           " ValidStatus," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiRouteDto.getComCode());
        dbManager.setString(2,utiRouteDto.getComName());
        dbManager.setString(3,utiRouteDto.getHostName());
        dbManager.setString(4,utiRouteDto.getIPaddress());
        dbManager.setString(5,utiRouteDto.getServerName());
        dbManager.setString(6,utiRouteDto.getValidStatus());
        dbManager.setString(7,utiRouteDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiRouteBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiRouteDto utiRouteDto = (UtiRouteDto)i.next();
            insert(utiRouteDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param comCode 机构代码
     * @throws Exception
     */
    public void delete(String comCode) throws Exception{
        String statement = " Delete From UtiRoute Where " +
                           " ComCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,comCode);
        dbManager.executePreparedUpdate();
        log.info("DBUtiRouteBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiRouteDto utiRouteDto
     * @throws Exception
     */
    public void update(UtiRouteDto utiRouteDto) throws Exception{
        String statement = " Update UtiRoute Set ComName = ?," + 
                           " HostName = ?," + 
                           " IPaddress = ?," + 
                           " ServerName = ?," + 
                           " ValidStatus = ?," + 
                           " Flag = ? Where " +
                           " ComCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiRouteDto.getComName());
        dbManager.setString(2,utiRouteDto.getHostName());
        dbManager.setString(3,utiRouteDto.getIPaddress());
        dbManager.setString(4,utiRouteDto.getServerName());
        dbManager.setString(5,utiRouteDto.getValidStatus());
        dbManager.setString(6,utiRouteDto.getFlag());
        //设置条件字段;
        dbManager.setString(7,utiRouteDto.getComCode());
        dbManager.executePreparedUpdate();

        log.info("DBUtiRouteBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param comCode 机构代码
     * @return UtiRouteDto
     * @throws Exception
     */
    public UtiRouteDto findByPrimaryKey(String comCode) throws Exception{
        String statement = " Select ComCode," + 
                           " ComName," + 
                           " HostName," + 
                           " IPaddress," + 
                           " ServerName," + 
                           " ValidStatus," + 
                           " Flag From UtiRoute Where " +
                           " ComCode = ?";
        UtiRouteDto utiRouteDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,comCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiRouteDto = new UtiRouteDto();
            utiRouteDto.setComCode(dbManager.getString(resultSet,1));
            utiRouteDto.setComName(dbManager.getString(resultSet,2));
            utiRouteDto.setHostName(dbManager.getString(resultSet,3));
            utiRouteDto.setIPaddress(dbManager.getString(resultSet,4));
            utiRouteDto.setServerName(dbManager.getString(resultSet,5));
            utiRouteDto.setValidStatus(dbManager.getString(resultSet,6));
            utiRouteDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBUtiRouteBase.findByPrimaryKey() success!");
        return utiRouteDto;
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
        String statement = "Select ComCode," + 
                           " ComName," + 
                           " HostName," + 
                           " IPaddress," + 
                           " ServerName," + 
                           " ValidStatus," + 
                           " Flag From UtiRoute Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiRouteDto utiRouteDto = null;
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

            utiRouteDto = new UtiRouteDto();
            utiRouteDto.setComCode(dbManager.getString(resultSet,1));
            utiRouteDto.setComName(dbManager.getString(resultSet,2));
            utiRouteDto.setHostName(dbManager.getString(resultSet,3));
            utiRouteDto.setIPaddress(dbManager.getString(resultSet,4));
            utiRouteDto.setServerName(dbManager.getString(resultSet,5));
            utiRouteDto.setValidStatus(dbManager.getString(resultSet,6));
            utiRouteDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(utiRouteDto);
        }
        resultSet.close();
        log.info("DBUtiRouteBase.findByConditions() success!");
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
        String statement = "Delete From UtiRoute Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiRouteBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from UtiRoute Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiRouteBase.getCount() success!");
        return count;
    }
}

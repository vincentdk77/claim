package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDareaGroupDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdareagroup机动车费率区域分组表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDareaGroupBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDareaGroupBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDareaGroupBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDareaGroupDto prpDareaGroupDto
     * @throws Exception
     */
    public void insert(PrpDareaGroupDto prpDareaGroupDto) throws Exception{
        String statement = " Insert Into PrpDareaGroup(" + 
                           " ComCode," + 
                           " AreaGroup," + 
                           " Flag) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDareaGroupDto.getComCode());
        dbManager.setString(2,prpDareaGroupDto.getAreaGroup());
        dbManager.setString(3,prpDareaGroupDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDareaGroupBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDareaGroupDto prpDareaGroupDto = (PrpDareaGroupDto)i.next();
            insert(prpDareaGroupDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param comCode 属于此区域的机构
     * @throws Exception
     */
    public void delete(String comCode) throws Exception{
        String statement = " Delete From PrpDareaGroup Where " +
                           " ComCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,comCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDareaGroupBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDareaGroupDto prpDareaGroupDto
     * @throws Exception
     */
    public void update(PrpDareaGroupDto prpDareaGroupDto) throws Exception{
        String statement = " Update PrpDareaGroup Set AreaGroup = ?," + 
                           " Flag = ? Where " +
                           " ComCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDareaGroupDto.getAreaGroup());
        dbManager.setString(2,prpDareaGroupDto.getFlag());
        //设置条件字段;
        dbManager.setString(3,prpDareaGroupDto.getComCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDareaGroupBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param comCode 属于此区域的机构
     * @return PrpDareaGroupDto
     * @throws Exception
     */
    public PrpDareaGroupDto findByPrimaryKey(String comCode) throws Exception{
        String statement = " Select ComCode," + 
                           " AreaGroup," + 
                           " Flag From PrpDareaGroup Where " +
                           " ComCode = ?";
        PrpDareaGroupDto prpDareaGroupDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,comCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDareaGroupDto = new PrpDareaGroupDto();
            prpDareaGroupDto.setComCode(dbManager.getString(resultSet,1));
            prpDareaGroupDto.setAreaGroup(dbManager.getString(resultSet,2));
            prpDareaGroupDto.setFlag(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpDareaGroupBase.findByPrimaryKey() success!");
        return prpDareaGroupDto;
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
                           " AreaGroup," + 
                           " Flag From PrpDareaGroup Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDareaGroupDto prpDareaGroupDto = null;
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

            prpDareaGroupDto = new PrpDareaGroupDto();
            prpDareaGroupDto.setComCode(dbManager.getString(resultSet,1));
            prpDareaGroupDto.setAreaGroup(dbManager.getString(resultSet,2));
            prpDareaGroupDto.setFlag(dbManager.getString(resultSet,3));
            collection.add(prpDareaGroupDto);
        }
        resultSet.close();
        log.info("DBPrpDareaGroupBase.findByConditions() success!");
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
        String statement = "Delete From PrpDareaGroup Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDareaGroupBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDareaGroup Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDareaGroupBase.getCount() success!");
        return count;
    }
}

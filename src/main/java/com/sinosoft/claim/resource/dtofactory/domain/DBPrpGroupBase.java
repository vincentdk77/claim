package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGroupDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgroup单证分组的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGroupBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpGroupBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpGroupBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpGroupDto prpGroupDto
     * @throws Exception
     */
    public void insert(PrpGroupDto prpGroupDto) throws Exception{
        String statement = " Insert Into PrpGroup(" + 
                           " GroupNo," + 
                           " SubGroupNo," + 
                           " Flag) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpGroupDto.getGroupNo());
        dbManager.setString(2,prpGroupDto.getSubGroupNo());
        dbManager.setString(3,prpGroupDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGroupBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpGroupDto prpGroupDto = (PrpGroupDto)i.next();
            insert(prpGroupDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param groupNo 合编组
     * @param subGroupNo 分编组
     * @throws Exception
     */
    public void delete(String groupNo,String subGroupNo) throws Exception{
        String statement = " Delete From PrpGroup Where " +
                           " GroupNo = ? And " + 
                           " SubGroupNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,groupNo);
        dbManager.setString(2,subGroupNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpGroupBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpGroupDto prpGroupDto
     * @throws Exception
     */
    public void update(PrpGroupDto prpGroupDto) throws Exception{
        String statement = " Update PrpGroup Set Flag = ? Where " +
                           " GroupNo = ? And " + 
                           " SubGroupNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpGroupDto.getFlag());
        //设置条件字段;
        dbManager.setString(2,prpGroupDto.getGroupNo());
        dbManager.setString(3,prpGroupDto.getSubGroupNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGroupBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param groupNo 合编组
     * @param subGroupNo 分编组
     * @return PrpGroupDto
     * @throws Exception
     */
    public PrpGroupDto findByPrimaryKey(String groupNo,String subGroupNo) throws Exception{
        String statement = " Select GroupNo," + 
                           " SubGroupNo," + 
                           " Flag From PrpGroup Where " +
                           " GroupNo = ? And " + 
                           " SubGroupNo = ?";
        PrpGroupDto prpGroupDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,groupNo);
        dbManager.setString(2,subGroupNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpGroupDto = new PrpGroupDto();
            prpGroupDto.setGroupNo(dbManager.getString(resultSet,1));
            prpGroupDto.setSubGroupNo(dbManager.getString(resultSet,2));
            prpGroupDto.setFlag(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpGroupBase.findByPrimaryKey() success!");
        return prpGroupDto;
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
                           " SubGroupNo," + 
                           " Flag From PrpGroup Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpGroupDto prpGroupDto = null;
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

            prpGroupDto = new PrpGroupDto();
            prpGroupDto.setGroupNo(dbManager.getString(resultSet,1));
            prpGroupDto.setSubGroupNo(dbManager.getString(resultSet,2));
            prpGroupDto.setFlag(dbManager.getString(resultSet,3));
            collection.add(prpGroupDto);
        }
        resultSet.close();
        log.info("DBPrpGroupBase.findByConditions() success!");
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
        String statement = "Delete From PrpGroup Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpGroupBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpGroup Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpGroupBase.getCount() success!");
        return count;
    }
}

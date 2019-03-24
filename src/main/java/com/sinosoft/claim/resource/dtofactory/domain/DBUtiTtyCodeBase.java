package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiTtyCodeDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utittycode终端属性记录表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiTtyCodeBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiTtyCodeBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiTtyCodeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiTtyCodeDto utiTtyCodeDto
     * @throws Exception
     */
    public void insert(UtiTtyCodeDto utiTtyCodeDto) throws Exception{
        String statement = " Insert Into UtiTtyCode(" + 
                           " TtyCode," + 
                           " SysTty," + 
                           " TtyType," + 
                           " TtyName," + 
                           " PrtType," + 
                           " PrtName," + 
                           " PrtMode," + 
                           " Flag) values(?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiTtyCodeDto.getTtyCode());
        dbManager.setString(2,utiTtyCodeDto.getSysTty());
        dbManager.setString(3,utiTtyCodeDto.getTtyType());
        dbManager.setString(4,utiTtyCodeDto.getTtyName());
        dbManager.setString(5,utiTtyCodeDto.getPrtType());
        dbManager.setString(6,utiTtyCodeDto.getPrtName());
        dbManager.setString(7,utiTtyCodeDto.getPrtMode());
        dbManager.setString(8,utiTtyCodeDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiTtyCodeBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiTtyCodeDto utiTtyCodeDto = (UtiTtyCodeDto)i.next();
            insert(utiTtyCodeDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param ttyCode 终端序号
     * @throws Exception
     */
    public void delete(String ttyCode) throws Exception{
        String statement = " Delete From UtiTtyCode Where " +
                           " TtyCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,ttyCode);
        dbManager.executePreparedUpdate();
        log.info("DBUtiTtyCodeBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiTtyCodeDto utiTtyCodeDto
     * @throws Exception
     */
    public void update(UtiTtyCodeDto utiTtyCodeDto) throws Exception{
        String statement = " Update UtiTtyCode Set SysTty = ?," + 
                           " TtyType = ?," + 
                           " TtyName = ?," + 
                           " PrtType = ?," + 
                           " PrtName = ?," + 
                           " PrtMode = ?," + 
                           " Flag = ? Where " +
                           " TtyCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiTtyCodeDto.getSysTty());
        dbManager.setString(2,utiTtyCodeDto.getTtyType());
        dbManager.setString(3,utiTtyCodeDto.getTtyName());
        dbManager.setString(4,utiTtyCodeDto.getPrtType());
        dbManager.setString(5,utiTtyCodeDto.getPrtName());
        dbManager.setString(6,utiTtyCodeDto.getPrtMode());
        dbManager.setString(7,utiTtyCodeDto.getFlag());
        //设置条件字段;
        dbManager.setString(8,utiTtyCodeDto.getTtyCode());
        dbManager.executePreparedUpdate();

        log.info("DBUtiTtyCodeBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param ttyCode 终端序号
     * @return UtiTtyCodeDto
     * @throws Exception
     */
    public UtiTtyCodeDto findByPrimaryKey(String ttyCode) throws Exception{
        String statement = " Select TtyCode," + 
                           " SysTty," + 
                           " TtyType," + 
                           " TtyName," + 
                           " PrtType," + 
                           " PrtName," + 
                           " PrtMode," + 
                           " Flag From UtiTtyCode Where " +
                           " TtyCode = ?";
        UtiTtyCodeDto utiTtyCodeDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,ttyCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiTtyCodeDto = new UtiTtyCodeDto();
            utiTtyCodeDto.setTtyCode(dbManager.getString(resultSet,1));
            utiTtyCodeDto.setSysTty(dbManager.getString(resultSet,2));
            utiTtyCodeDto.setTtyType(dbManager.getString(resultSet,3));
            utiTtyCodeDto.setTtyName(dbManager.getString(resultSet,4));
            utiTtyCodeDto.setPrtType(dbManager.getString(resultSet,5));
            utiTtyCodeDto.setPrtName(dbManager.getString(resultSet,6));
            utiTtyCodeDto.setPrtMode(dbManager.getString(resultSet,7));
            utiTtyCodeDto.setFlag(dbManager.getString(resultSet,8));
        }
        resultSet.close();
        log.info("DBUtiTtyCodeBase.findByPrimaryKey() success!");
        return utiTtyCodeDto;
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
        String statement = "Select TtyCode," + 
                           " SysTty," + 
                           " TtyType," + 
                           " TtyName," + 
                           " PrtType," + 
                           " PrtName," + 
                           " PrtMode," + 
                           " Flag From UtiTtyCode Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiTtyCodeDto utiTtyCodeDto = null;
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

            utiTtyCodeDto = new UtiTtyCodeDto();
            utiTtyCodeDto.setTtyCode(dbManager.getString(resultSet,1));
            utiTtyCodeDto.setSysTty(dbManager.getString(resultSet,2));
            utiTtyCodeDto.setTtyType(dbManager.getString(resultSet,3));
            utiTtyCodeDto.setTtyName(dbManager.getString(resultSet,4));
            utiTtyCodeDto.setPrtType(dbManager.getString(resultSet,5));
            utiTtyCodeDto.setPrtName(dbManager.getString(resultSet,6));
            utiTtyCodeDto.setPrtMode(dbManager.getString(resultSet,7));
            utiTtyCodeDto.setFlag(dbManager.getString(resultSet,8));
            collection.add(utiTtyCodeDto);
        }
        resultSet.close();
        log.info("DBUtiTtyCodeBase.findByConditions() success!");
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
        String statement = "Delete From UtiTtyCode Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiTtyCodeBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from UtiTtyCode Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiTtyCodeBase.getCount() success!");
        return count;
    }
}

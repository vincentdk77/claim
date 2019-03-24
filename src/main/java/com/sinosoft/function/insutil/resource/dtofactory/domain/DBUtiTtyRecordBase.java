package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiTtyRecordDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utittyrecord的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiTtyRecordBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiTtyRecordBase.class.getName());
 
    /**
     * 构造函数 
     * @param dbManager 资源管理类
     */
    public DBUtiTtyRecordBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiTtyRecordDto utiTtyRecordDto
     * @throws Exception
     */
    public void insert(UtiTtyRecordDto utiTtyRecordDto) throws Exception{
        String statement = " Insert Into UtiTtyRecord(" + 
                           " TtyCode," + 
                           " UserCode," + 
                           " UserName," + 
                           " IPAddress," + 
                           " LoginName," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " Year," + 
                           " RiskCode," + 
                           " LoginDate," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiTtyRecordDto.getTtyCode());
        dbManager.setString(2,utiTtyRecordDto.getUserCode());
        dbManager.setString(3,utiTtyRecordDto.getUserName());
        dbManager.setString(4,utiTtyRecordDto.getIPAddress());
        dbManager.setString(5,utiTtyRecordDto.getLoginName());
        dbManager.setString(6,utiTtyRecordDto.getComCode());
        dbManager.setString(7,utiTtyRecordDto.getMakeCom());
        dbManager.setString(8,utiTtyRecordDto.getYear());
        dbManager.setString(9,utiTtyRecordDto.getRiskCode());
        dbManager.setDateTime(10,utiTtyRecordDto.getLoginDate());
        dbManager.setString(11,utiTtyRecordDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiTtyRecordBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiTtyRecordDto utiTtyRecordDto = (UtiTtyRecordDto)i.next();
            insert(utiTtyRecordDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param ttyCode ttycode
     * @throws Exception
     */
    public void delete(String ttyCode) throws Exception{
        String statement = " Delete From UtiTtyRecord Where " +
                           " TtyCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,ttyCode);
        dbManager.executePreparedUpdate();
        log.info("DBUtiTtyRecordBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiTtyRecordDto utiTtyRecordDto
     * @throws Exception
     */
    public void update(UtiTtyRecordDto utiTtyRecordDto) throws Exception{
        String statement = " Update UtiTtyRecord Set UserCode = ?," + 
                           " UserName = ?," + 
                           " IPAddress = ?," + 
                           " LoginName = ?," + 
                           " ComCode = ?," + 
                           " MakeCom = ?," + 
                           " Year = ?," + 
                           " RiskCode = ?," + 
                           " LoginDate = ?," + 
                           " Flag = ? Where " +
                           " TtyCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiTtyRecordDto.getUserCode());
        dbManager.setString(2,utiTtyRecordDto.getUserName());
        dbManager.setString(3,utiTtyRecordDto.getIPAddress());
        dbManager.setString(4,utiTtyRecordDto.getLoginName());
        dbManager.setString(5,utiTtyRecordDto.getComCode());
        dbManager.setString(6,utiTtyRecordDto.getMakeCom());
        dbManager.setString(7,utiTtyRecordDto.getYear());
        dbManager.setString(8,utiTtyRecordDto.getRiskCode());
        dbManager.setDateTime(9,utiTtyRecordDto.getLoginDate());
        dbManager.setString(10,utiTtyRecordDto.getFlag());
        //设置条件字段;
        dbManager.setString(11,utiTtyRecordDto.getTtyCode());
        dbManager.executePreparedUpdate();

        log.info("DBUtiTtyRecordBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param ttyCode ttycode
     * @return UtiTtyRecordDto
     * @throws Exception
     */
    public UtiTtyRecordDto findByPrimaryKey(String ttyCode) throws Exception{
        String statement = " Select TtyCode," + 
                           " UserCode," + 
                           " UserName," + 
                           " IPAddress," + 
                           " LoginName," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " Year," + 
                           " RiskCode," + 
                           " LoginDate," + 
                           " Flag From UtiTtyRecord Where " +
                           " TtyCode = ?";
        UtiTtyRecordDto utiTtyRecordDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,ttyCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiTtyRecordDto = new UtiTtyRecordDto();
            utiTtyRecordDto.setTtyCode(dbManager.getString(resultSet,1));
            utiTtyRecordDto.setUserCode(dbManager.getString(resultSet,2));
            utiTtyRecordDto.setUserName(dbManager.getString(resultSet,3));
            utiTtyRecordDto.setIPAddress(dbManager.getString(resultSet,4));
            utiTtyRecordDto.setLoginName(dbManager.getString(resultSet,5));
            utiTtyRecordDto.setComCode(dbManager.getString(resultSet,6));
            utiTtyRecordDto.setMakeCom(dbManager.getString(resultSet,7));
            utiTtyRecordDto.setYear(dbManager.getString(resultSet,8));
            utiTtyRecordDto.setRiskCode(dbManager.getString(resultSet,9));
            utiTtyRecordDto.setLoginDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            utiTtyRecordDto.setFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        log.info("DBUtiTtyRecordBase.findByPrimaryKey() success!");
        return utiTtyRecordDto;
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
                           " UserCode," + 
                           " UserName," + 
                           " IPAddress," + 
                           " LoginName," + 
                           " ComCode," + 
                           " MakeCom," + 
                           " Year," + 
                           " RiskCode," + 
                           " LoginDate," + 
                           " Flag From UtiTtyRecord Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiTtyRecordDto utiTtyRecordDto = null;
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

            utiTtyRecordDto = new UtiTtyRecordDto();
            utiTtyRecordDto.setTtyCode(dbManager.getString(resultSet,1));
            utiTtyRecordDto.setUserCode(dbManager.getString(resultSet,2));
            utiTtyRecordDto.setUserName(dbManager.getString(resultSet,3));
            utiTtyRecordDto.setIPAddress(dbManager.getString(resultSet,4));
            utiTtyRecordDto.setLoginName(dbManager.getString(resultSet,5));
            utiTtyRecordDto.setComCode(dbManager.getString(resultSet,6));
            utiTtyRecordDto.setMakeCom(dbManager.getString(resultSet,7));
            utiTtyRecordDto.setYear(dbManager.getString(resultSet,8));
            utiTtyRecordDto.setRiskCode(dbManager.getString(resultSet,9));
            utiTtyRecordDto.setLoginDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            utiTtyRecordDto.setFlag(dbManager.getString(resultSet,11));
            collection.add(utiTtyRecordDto);
        }
        resultSet.close();
        log.info("DBUtiTtyRecordBase.findByConditions() success!");
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
        String statement = "Delete From UtiTtyRecord Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiTtyRecordBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from UtiTtyRecord Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiTtyRecordBase.getCount() success!");
        return count;
    }
}

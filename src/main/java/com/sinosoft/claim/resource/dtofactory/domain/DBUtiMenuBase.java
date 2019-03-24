package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiMenuDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utimenu菜单控制表的数据访问对象类<br>
 * 创建于 2004-4-5 15:33:42<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiMenuBase{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiMenuBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiMenuBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiMenuDto utiMenuDto
     * @throws Exception
     */
    public void insert(UtiMenuDto utiMenuDto) throws Exception{
        String statement = " Insert Into UtiMenu(" + 
                           " MenuName," + 
                           " HotKey," + 
                           " RiskCode," + 
                           " MenuItem," + 
                           " Message," + 
                           " Flag) values(?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiMenuDto.getMenuName());
        dbManager.setString(2,utiMenuDto.getHotKey());
        dbManager.setString(3,utiMenuDto.getRiskCode());
        dbManager.setString(4,utiMenuDto.getMenuItem());
        dbManager.setString(5,utiMenuDto.getMessage());
        dbManager.setString(6,utiMenuDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBUtiMenuBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiMenuDto utiMenuDto = (UtiMenuDto)i.next();
            insert(utiMenuDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param menuName 菜单名
     * @param hotKey 热键
     * @param riskCode 险种
     * @throws Exception
     */
    public void delete(String menuName,String hotKey,String riskCode) throws Exception{
        String statement = " Delete From UtiMenu Where " +
                           " MenuName = ? And " + 
                           " HotKey = ? And " + 
                           " RiskCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,menuName);
        dbManager.setString(2,hotKey);
        dbManager.setString(3,riskCode);
        dbManager.executePreparedUpdate();
        log.info("DBUtiMenuBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiMenuDto utiMenuDto
     * @throws Exception
     */
    public void update(UtiMenuDto utiMenuDto) throws Exception{
        String statement = " Update UtiMenu Set MenuItem = ?," + 
                           " Message = ?," + 
                           " Flag = ? Where " +
                           " MenuName = ? And " + 
                           " HotKey = ? And " + 
                           " RiskCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,utiMenuDto.getMenuItem());
        dbManager.setString(2,utiMenuDto.getMessage());
        dbManager.setString(3,utiMenuDto.getFlag());
        //设置条件字段;
        dbManager.setString(4,utiMenuDto.getMenuName());
        dbManager.setString(5,utiMenuDto.getHotKey());
        dbManager.setString(6,utiMenuDto.getRiskCode());
        dbManager.executePreparedUpdate();

        log.info("DBUtiMenuBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param menuName 菜单名
     * @param hotKey 热键
     * @param riskCode 险种
     * @return UtiMenuDto
     * @throws Exception
     */
    public UtiMenuDto findByPrimaryKey(String menuName,String hotKey,String riskCode) throws Exception{
        String statement = " Select MenuName," + 
                           " HotKey," + 
                           " RiskCode," + 
                           " MenuItem," + 
                           " Message," + 
                           " Flag From UtiMenu Where " +
                           " MenuName = ? And " + 
                           " HotKey = ? And " + 
                           " RiskCode = ?";
        UtiMenuDto utiMenuDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,menuName);
        dbManager.setString(2,hotKey);
        dbManager.setString(3,riskCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiMenuDto = new UtiMenuDto();
            utiMenuDto.setMenuName(dbManager.getString(resultSet,1));
            utiMenuDto.setHotKey(dbManager.getString(resultSet,2));
            utiMenuDto.setRiskCode(dbManager.getString(resultSet,3));
            utiMenuDto.setMenuItem(dbManager.getString(resultSet,4));
            utiMenuDto.setMessage(dbManager.getString(resultSet,5));
            utiMenuDto.setFlag(dbManager.getString(resultSet,6));
        }
        resultSet.close();
        log.info("DBUtiMenuBase.findByPrimaryKey() success!");
        return utiMenuDto;
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
        String statement = "Select MenuName," + 
                           " HotKey," + 
                           " RiskCode," + 
                           " MenuItem," + 
                           " Message," + 
                           " Flag From UtiMenu Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiMenuDto utiMenuDto = null;
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

            utiMenuDto = new UtiMenuDto();
            utiMenuDto.setMenuName(dbManager.getString(resultSet,1));
            utiMenuDto.setHotKey(dbManager.getString(resultSet,2));
            utiMenuDto.setRiskCode(dbManager.getString(resultSet,3));
            utiMenuDto.setMenuItem(dbManager.getString(resultSet,4));
            utiMenuDto.setMessage(dbManager.getString(resultSet,5));
            utiMenuDto.setFlag(dbManager.getString(resultSet,6));
            collection.add(utiMenuDto);
        }
        resultSet.close();
        log.info("DBUtiMenuBase.findByConditions() success!");
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
        String statement = "Delete From UtiMenu Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiMenuBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from UtiMenu Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiMenuBase.getCount() success!");
        return count;
    }
}

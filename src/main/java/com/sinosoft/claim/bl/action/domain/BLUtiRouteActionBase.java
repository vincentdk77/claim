package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiRouteDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiRoute;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是UtiRoute路由配置表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:46<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiRouteActionBase{
    private static Log log = LogFactory.getLog(BLUtiRouteActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiRouteActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiRouteDto utiRouteDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiRouteDto utiRouteDto) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        //插入记录
        dbUtiRoute.insert(utiRouteDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param comCode 机构代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String comCode) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        //删除记录
        dbUtiRoute.delete(comCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        //按条件删除记录
        dbUtiRoute.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiRouteDto utiRouteDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiRouteDto utiRouteDto) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        //更新记录
        dbUtiRoute.update(utiRouteDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param comCode 机构代码
     * @return utiRouteDto utiRouteDto
     * @throws Exception
     */
    public UtiRouteDto findByPrimaryKey(DBManager dbManager,String comCode) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        //声明DTO
        UtiRouteDto utiRouteDto = null;
        //查询数据,赋值给DTO
        utiRouteDto = dbUtiRoute.findByPrimaryKey(comCode);
        return utiRouteDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiRouteDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiRoute.getCount(conditions);
        collection = dbUtiRoute.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBUtiRoute dbUtiRoute = new DBUtiRoute(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiRoute.getCount(conditions);
        return count;
    }
}

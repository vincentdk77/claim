package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.UtiMenuDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBUtiMenu;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utimenu菜单控制表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLUtiMenuActionBase{
    private static Log log = LogFactory.getLog(BLUtiMenuActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLUtiMenuActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param utiMenuDto utiMenuDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,UtiMenuDto utiMenuDto) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        //插入记录
        dbUtiMenu.insert(utiMenuDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param menuName 菜单名
     * @param hotKey 热键
     * @param riskCode 险种
     * @throws Exception
     */
    public void delete(DBManager dbManager,String menuName,String hotKey,String riskCode) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        //删除记录
        dbUtiMenu.delete(menuName, hotKey, riskCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        //按条件删除记录
        dbUtiMenu.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param utiMenuDto utiMenuDto
     * @throws Exception
     */
    public void update(DBManager dbManager,UtiMenuDto utiMenuDto) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        //更新记录
        dbUtiMenu.update(utiMenuDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param menuName 菜单名
     * @param hotKey 热键
     * @param riskCode 险种
     * @return utiMenuDto utiMenuDto
     * @throws Exception
     */
    public UtiMenuDto findByPrimaryKey(DBManager dbManager,String menuName,String hotKey,String riskCode) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        //声明DTO
        UtiMenuDto utiMenuDto = null;
        //查询数据,赋值给DTO
        utiMenuDto = dbUtiMenu.findByPrimaryKey(menuName, hotKey, riskCode);
        return utiMenuDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含utiMenuDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbUtiMenu.getCount(conditions);
        collection = dbUtiMenu.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBUtiMenu dbUtiMenu = new DBUtiMenu(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbUtiMenu.getCount(conditions);
        return count;
    }
}

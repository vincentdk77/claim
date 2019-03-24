package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLmenuDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLmenu;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLmenu-菜单表(新增)的业务逻辑对象类<br>
 * 创建于 2005-05-08 15:15:53.812<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLmenuActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLmenuActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLmenuActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLmenuDto prpLmenuDto) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        //插入记录
        dbPrpLmenu.insert(prpLmenuDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param funcID 菜单功能代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String funcID) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        //删除记录
        dbPrpLmenu.delete(funcID);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        //按条件删除记录
        dbPrpLmenu.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLmenuDto prpLmenuDto) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        //更新记录
        dbPrpLmenu.update(prpLmenuDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param funcID 菜单功能代码
     * @return prpLmenuDto prpLmenuDto
     * @throws Exception
     */
    public PrpLmenuDto findByPrimaryKey(DBManager dbManager,String funcID) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        //声明DTO
        PrpLmenuDto prpLmenuDto = null;
        //查询数据,赋值给DTO
        prpLmenuDto = dbPrpLmenu.findByPrimaryKey(funcID);
        return prpLmenuDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLmenu.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLmenu.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLmenuDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLmenu.findByConditions(conditions);
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLmenu dbPrpLmenu = new DBPrpLmenu(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLmenu.getCount(conditions);
        return count;
    }
}

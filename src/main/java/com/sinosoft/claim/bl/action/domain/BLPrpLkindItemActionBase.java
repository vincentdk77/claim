package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLkindItemDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLkindItem;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是承保险别标的表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLkindItemActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLkindItemActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLkindItemActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLkindItemDto prpLkindItemDto)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        //插入记录
        dbPrpLkindItem.insert(prpLkindItemDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param kindCode 险别代码
     * @param itemCode 标的项目代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String kindCode,String itemCode)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        //删除记录
        dbPrpLkindItem.delete(riskCode, kindCode, itemCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        //按条件删除记录
        dbPrpLkindItem.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLkindItemDto prpLkindItemDto)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        //更新记录
        dbPrpLkindItem.update(prpLkindItemDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param kindCode 险别代码
     * @param itemCode 标的项目代码
     * @return prpLkindItemDto prpLkindItemDto
     * @throws Exception
     */
    public PrpLkindItemDto findByPrimaryKey(DBManager dbManager,String riskCode,String kindCode,String itemCode)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        //声明DTO
        PrpLkindItemDto prpLkindItemDto = null;
        //查询数据,赋值给DTO
        prpLkindItemDto = dbPrpLkindItem.findByPrimaryKey(riskCode, kindCode, itemCode);
        return prpLkindItemDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLkindItem.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLkindItem.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLkindItemDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLkindItem.findByConditions(conditions);
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
        DBPrpLkindItem dbPrpLkindItem = new DBPrpLkindItem(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLkindItem.getCount(conditions);
        return count;
    }
}

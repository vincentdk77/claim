package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLext;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLext的业务逻辑对象类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLextActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLextActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLextActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLextDto prpLextDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLextDto prpLextDto) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        //插入记录
        dbPrpLext.insert(prpLextDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param certiNo 单号
     * @param certiType 单号类型
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,String certiType) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        //删除记录
        dbPrpLext.delete(certiNo, certiType);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        //按条件删除记录
        dbPrpLext.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLextDto prpLextDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLextDto prpLextDto) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        //更新记录
        dbPrpLext.update(prpLextDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param certiNo 单号
     * @param certiType 单号类型
     * @return prpLextDto prpLextDto
     * @throws Exception
     */
    public PrpLextDto findByPrimaryKey(DBManager dbManager,String certiNo,String certiType) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        //声明DTO
        PrpLextDto prpLextDto = null;
        //查询数据,赋值给DTO
        prpLextDto = dbPrpLext.findByPrimaryKey(certiNo, certiType);
        return prpLextDto;
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
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLext.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLext.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLextDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLext.findByConditions(conditions);
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
        DBPrpLext dbPrpLext = new DBPrpLext(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLext.getCount(conditions);
        return count;
    }
}

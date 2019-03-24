package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyDirect;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLcertifyDirect－索赔指引的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLcertifyDirectActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyDirectActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcertifyDirectActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcertifyDirectDto prpLcertifyDirectDto)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        //插入记录
        dbPrpLcertifyDirect.insert(prpLcertifyDirectDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,String lossItemCode)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        //删除记录
        dbPrpLcertifyDirect.delete(registNo, serialNo, lossItemCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        //按条件删除记录
        dbPrpLcertifyDirect.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcertifyDirectDto prpLcertifyDirectDto)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        //更新记录
        dbPrpLcertifyDirect.update(prpLcertifyDirectDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param serialNo 序号
     * @param lossItemCode 标的代码
     * @return prpLcertifyDirectDto prpLcertifyDirectDto
     * @throws Exception
     */
    public PrpLcertifyDirectDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,String lossItemCode)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        //声明DTO
        PrpLcertifyDirectDto prpLcertifyDirectDto = null;
        //查询数据,赋值给DTO
        prpLcertifyDirectDto = dbPrpLcertifyDirect.findByPrimaryKey(registNo, serialNo, lossItemCode);
        return prpLcertifyDirectDto;
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
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyDirect.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcertifyDirect.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcertifyDirectDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcertifyDirect.findByConditions(conditions);
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
        DBPrpLcertifyDirect dbPrpLcertifyDirect = new DBPrpLcertifyDirect(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyDirect.getCount(conditions);
        return count;
    }
}

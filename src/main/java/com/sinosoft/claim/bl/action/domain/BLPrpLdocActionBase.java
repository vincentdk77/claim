package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLdocDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLdoc;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLdoc-索赔单证信息表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.000<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLdocActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLdocActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLdocActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLdocDto prpLdocDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLdocDto prpLdocDto) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        //插入记录
        dbPrpLdoc.insert(prpLdocDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号码
     * @param docCode 单证代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String docCode) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        //删除记录
        dbPrpLdoc.delete(claimNo, docCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        //按条件删除记录
        dbPrpLdoc.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLdocDto prpLdocDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLdocDto prpLdocDto) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        //更新记录
        dbPrpLdoc.update(prpLdocDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号码
     * @param docCode 单证代码
     * @return prpLdocDto prpLdocDto
     * @throws Exception
     */
    public PrpLdocDto findByPrimaryKey(DBManager dbManager,String claimNo,String docCode) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        //声明DTO
        PrpLdocDto prpLdocDto = null;
        //查询数据,赋值给DTO
        prpLdocDto = dbPrpLdoc.findByPrimaryKey(claimNo, docCode);
        return prpLdocDto;
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
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLdoc.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLdoc.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLdocDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLdoc.findByConditions(conditions);
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
        DBPrpLdoc dbPrpLdoc = new DBPrpLdoc(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLdoc.getCount(conditions);
        return count;
    }
}

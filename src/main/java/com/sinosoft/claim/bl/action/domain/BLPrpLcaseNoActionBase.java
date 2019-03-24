package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcaseNo;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcaseNo-赔案号表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.109<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcaseNoActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcaseNoActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcaseNoActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcaseNoDto prpLcaseNoDto) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        //插入记录
        dbPrpLcaseNo.insert(prpLcaseNoDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param certiNo 单证号
     * @param certiType 单证类型
     * @param caseNo 赔案号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,String certiType,String caseNo) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        //删除记录
        dbPrpLcaseNo.delete(certiNo, certiType, caseNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        //按条件删除记录
        dbPrpLcaseNo.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcaseNoDto prpLcaseNoDto) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        //更新记录
        dbPrpLcaseNo.update(prpLcaseNoDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param certiNo 单证号
     * @param certiType 单证类型
     * @param caseNo 赔案号
     * @return prpLcaseNoDto prpLcaseNoDto
     * @throws Exception
     */
    public PrpLcaseNoDto findByPrimaryKey(DBManager dbManager,String certiNo,String certiType,String caseNo) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        //声明DTO
        PrpLcaseNoDto prpLcaseNoDto = null;
        //查询数据,赋值给DTO
        prpLcaseNoDto = dbPrpLcaseNo.findByPrimaryKey(certiNo, certiType, caseNo);
        return prpLcaseNoDto;
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
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcaseNo.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcaseNo.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcaseNoDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcaseNo.findByConditions(conditions);
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
        DBPrpLcaseNo dbPrpLcaseNo = new DBPrpLcaseNo(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcaseNo.getCount(conditions);
        return count;
    }
}

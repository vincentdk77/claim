package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLafterwardDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLafterward;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLafterward-案后费用处理表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLafterwardActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLafterwardActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLafterwardActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLafterwardDto prpLafterwardDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLafterwardDto prpLafterwardDto) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        //插入记录
        dbPrpLafterward.insert(prpLafterwardDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        //删除记录
        dbPrpLafterward.delete(claimNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        //按条件删除记录
        dbPrpLafterward.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLafterwardDto prpLafterwardDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLafterwardDto prpLafterwardDto) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        //更新记录
        dbPrpLafterward.update(prpLafterwardDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号
     * @param serialNo 序号
     * @return prpLafterwardDto prpLafterwardDto
     * @throws Exception
     */
    public PrpLafterwardDto findByPrimaryKey(DBManager dbManager,String claimNo,int serialNo) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        //声明DTO
        PrpLafterwardDto prpLafterwardDto = null;
        //查询数据,赋值给DTO
        prpLafterwardDto = dbPrpLafterward.findByPrimaryKey(claimNo, serialNo);
        return prpLafterwardDto;
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
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLafterward.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLafterward.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLafterwardDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLafterward.findByConditions(conditions);
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
        DBPrpLafterward dbPrpLafterward = new DBPrpLafterward(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLafterward.getCount(conditions);
        return count;
    }
}

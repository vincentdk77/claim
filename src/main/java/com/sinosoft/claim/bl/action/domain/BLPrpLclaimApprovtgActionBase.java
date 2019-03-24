package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimApprovtgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimApprovtg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimApprov-代赔数据转出确认表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimApprovtgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimApprovtgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimApprovtgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimApprovtgDto prpLclaimApprovtgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimApprovtgDto prpLclaimApprovtgDto) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        //插入记录
        dbPrpLclaimApprovtg.insert(prpLclaimApprovtgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        //删除记录
        dbPrpLclaimApprovtg.delete(registNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        //按条件删除记录
        dbPrpLclaimApprovtg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimApprovtgDto prpLclaimApprovtgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimApprovtgDto prpLclaimApprovtgDto) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        //更新记录
        dbPrpLclaimApprovtg.update(prpLclaimApprovtgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @return prpLclaimApprovtgDto prpLclaimApprovtgDto
     * @throws Exception
     */
    public PrpLclaimApprovtgDto findByPrimaryKey(DBManager dbManager,String registNo) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        //声明DTO
        PrpLclaimApprovtgDto prpLclaimApprovtgDto = null;
        //查询数据,赋值给DTO
        prpLclaimApprovtgDto = dbPrpLclaimApprovtg.findByPrimaryKey(registNo);
        return prpLclaimApprovtgDto;
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
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimApprovtg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimApprovtg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimApprovtgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimApprovtg.findByConditions(conditions);
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
        DBPrpLclaimApprovtg dbPrpLclaimApprovtg = new DBPrpLclaimApprovtg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimApprovtg.getCount(conditions);
        return count;
    }
}

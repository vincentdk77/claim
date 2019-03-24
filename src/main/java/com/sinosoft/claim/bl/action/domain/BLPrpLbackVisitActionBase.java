package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLbackVisit;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisit--回访信息主表的业务逻辑对象类<br>
 * 创建于 2005-03-25 20:44:46.953<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLbackVisitActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLbackVisitDto prpLbackVisitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLbackVisitDto prpLbackVisitDto) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        //插入记录
        dbPrpLbackVisit.insert(prpLbackVisitDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @throws Exception
     */
    public void delete(DBManager dbManager,int backVisitID,String registNo,String backVisitType) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        //删除记录
        dbPrpLbackVisit.delete(backVisitID, registNo, backVisitType);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        //按条件删除记录
        dbPrpLbackVisit.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLbackVisitDto prpLbackVisitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLbackVisitDto prpLbackVisitDto) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        //更新记录
        dbPrpLbackVisit.update(prpLbackVisitDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @return prpLbackVisitDto prpLbackVisitDto
     * @throws Exception
     */
    public PrpLbackVisitDto findByPrimaryKey(DBManager dbManager,int backVisitID,String registNo,String backVisitType) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        //声明DTO
        PrpLbackVisitDto prpLbackVisitDto = null;
        //查询数据,赋值给DTO
        prpLbackVisitDto = dbPrpLbackVisit.findByPrimaryKey(backVisitID, registNo, backVisitType);
        return prpLbackVisitDto;
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
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisit.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLbackVisit.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLbackVisitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLbackVisit.findByConditions(conditions);
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
        DBPrpLbackVisit dbPrpLbackVisit = new DBPrpLbackVisit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisit.getCount(conditions);
        return count;
    }
}

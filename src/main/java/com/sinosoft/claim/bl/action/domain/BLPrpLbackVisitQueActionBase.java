package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLbackVisitQueDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLbackVisitQue;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLbackVisitQue--回访问询表的业务逻辑对象类<br>
 * 创建于 2005-03-23 09:00:24.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLbackVisitQueActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLbackVisitQueActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLbackVisitQueActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        //插入记录
        dbPrpLbackVisitQue.insert(prpLbackVisitQueDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @param questionCode 回访项目代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,int backVisitID,String registNo,String backVisitType,String questionCode) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        //删除记录
        dbPrpLbackVisitQue.delete(backVisitID, registNo, backVisitType, questionCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        //按条件删除记录
        dbPrpLbackVisitQue.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLbackVisitQueDto prpLbackVisitQueDto) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        //更新记录
        dbPrpLbackVisitQue.update(prpLbackVisitQueDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param backVisitID 客户回访记录ID
     * @param registNo 报案号码
     * @param backVisitType 业务类型
     * @param questionCode 回访项目代码
     * @return prpLbackVisitQueDto prpLbackVisitQueDto
     * @throws Exception
     */
    public PrpLbackVisitQueDto findByPrimaryKey(DBManager dbManager,int backVisitID,String registNo,String backVisitType,String questionCode) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        //声明DTO
        PrpLbackVisitQueDto prpLbackVisitQueDto = null;
        //查询数据,赋值给DTO
        prpLbackVisitQueDto = dbPrpLbackVisitQue.findByPrimaryKey(backVisitID, registNo, backVisitType, questionCode);
        return prpLbackVisitQueDto;
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
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisitQue.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLbackVisitQue.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLbackVisitQueDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLbackVisitQue.findByConditions(conditions);
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
        DBPrpLbackVisitQue dbPrpLbackVisitQue = new DBPrpLbackVisitQue(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLbackVisitQue.getCount(conditions);
        return count;
    }
}

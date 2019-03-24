package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpPmainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPmain;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prppmain批改保单信息表的业务逻辑对象类<br>
 * 创建于 2004-11-22 15:24:30.906<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpPmainActionBase{
    private static Log logger = LogFactory.getLog(BLPrpPmainActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpPmainActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpPmainDto prpPmainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPmainDto prpPmainDto) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        //插入记录
        dbPrpPmain.insert(prpPmainDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param endorseNo 批单号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        //删除记录
        dbPrpPmain.delete(endorseNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        //按条件删除记录
        dbPrpPmain.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpPmainDto prpPmainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPmainDto prpPmainDto) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        //更新记录
        dbPrpPmain.update(prpPmainDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param endorseNo 批单号码
     * @return prpPmainDto prpPmainDto
     * @throws Exception
     */
    public PrpPmainDto findByPrimaryKey(DBManager dbManager,String endorseNo) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        //声明DTO
        PrpPmainDto prpPmainDto = null;
        //查询数据,赋值给DTO
        prpPmainDto = dbPrpPmain.findByPrimaryKey(endorseNo);
        return prpPmainDto;
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
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPmain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpPmain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpPmainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpPmain.findByConditions(conditions);
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
        DBPrpPmain dbPrpPmain = new DBPrpPmain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPmain.getCount(conditions);
        return count;
    }
}

package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprepay;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLprepay-预赔登记表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.046<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLprepayActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLprepayActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLprepayActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLprepayDto prpLprepayDto) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        //插入记录
        dbPrpLprepay.insert(prpLprepayDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param preCompensateNo 预赔登记号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String preCompensateNo) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        //删除记录
        dbPrpLprepay.delete(preCompensateNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        //按条件删除记录
        dbPrpLprepay.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLprepayDto prpLprepayDto) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        //更新记录
        dbPrpLprepay.update(prpLprepayDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param preCompensateNo 预赔登记号
     * @return prpLprepayDto prpLprepayDto
     * @throws Exception
     */
    public PrpLprepayDto findByPrimaryKey(DBManager dbManager,String preCompensateNo) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        //声明DTO
        PrpLprepayDto prpLprepayDto = null;
        //查询数据,赋值给DTO
        prpLprepayDto = dbPrpLprepay.findByPrimaryKey(preCompensateNo);
        return prpLprepayDto;
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
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprepay.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLprepay.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLprepayDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLprepay.findByConditions(conditions);
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
        DBPrpLprepay dbPrpLprepay = new DBPrpLprepay(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprepay.getCount(conditions);
        return count;
    }
}

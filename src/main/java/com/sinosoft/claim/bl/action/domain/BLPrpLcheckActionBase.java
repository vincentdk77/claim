package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheck;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcheck-查勘/代查勘扩展表(修改)的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.968<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcheckActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcheckDto prpLcheckDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcheckDto prpLcheckDto) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        //插入记录
        dbPrpLcheck.insert(prpLcheckDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param referSerialNo 关联理赔车辆序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int referSerialNo) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        //删除记录
        dbPrpLcheck.delete(registNo, referSerialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        //按条件删除记录
        dbPrpLcheck.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcheckDto prpLcheckDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcheckDto prpLcheckDto) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        //更新记录
        dbPrpLcheck.update(prpLcheckDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param referSerialNo 关联理赔车辆序号
     * @return prpLcheckDto prpLcheckDto
     * @throws Exception
     */
    public PrpLcheckDto findByPrimaryKey(DBManager dbManager,String registNo,int referSerialNo) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        //声明DTO
        PrpLcheckDto prpLcheckDto = null;
        //查询数据,赋值给DTO
        prpLcheckDto = dbPrpLcheck.findByPrimaryKey(registNo, referSerialNo);
        return prpLcheckDto;
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
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheck.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcheck.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcheckDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcheck.findByConditions(conditions);
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
        DBPrpLcheck dbPrpLcheck = new DBPrpLcheck(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheck.getCount(conditions);
        return count;
    }
}

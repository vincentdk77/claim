package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLassureDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLassure;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLassure-担保函（船舶）的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.203<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLassureActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLassureActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLassureActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLassureDto prpLassureDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLassureDto prpLassureDto) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        //插入记录
        dbPrpLassure.insert(prpLassureDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param assureNo 担保号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String assureNo) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        //删除记录
        dbPrpLassure.delete(assureNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        //按条件删除记录
        dbPrpLassure.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLassureDto prpLassureDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLassureDto prpLassureDto) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        //更新记录
        dbPrpLassure.update(prpLassureDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param assureNo 担保号
     * @return prpLassureDto prpLassureDto
     * @throws Exception
     */
    public PrpLassureDto findByPrimaryKey(DBManager dbManager,String assureNo) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        //声明DTO
        PrpLassureDto prpLassureDto = null;
        //查询数据,赋值给DTO
        prpLassureDto = dbPrpLassure.findByPrimaryKey(assureNo);
        return prpLassureDto;
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
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLassure.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLassure.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLassureDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLassure.findByConditions(conditions);
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
        DBPrpLassure dbPrpLassure = new DBPrpLassure(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLassure.getCount(conditions);
        return count;
    }
}

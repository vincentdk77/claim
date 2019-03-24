package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprop;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLprop-财产核定损明细清单表(修改)的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.062<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpropActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpropActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpropActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpropDto prpLpropDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpropDto prpLpropDto) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        //插入记录
        dbPrpLprop.insert(prpLpropDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param serialNo 序号
     * @param registNo 报案号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,int serialNo,String registNo) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        //删除记录
        dbPrpLprop.delete(serialNo, registNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        //按条件删除记录
        dbPrpLprop.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpropDto prpLpropDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpropDto prpLpropDto) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        //更新记录
        dbPrpLprop.update(prpLpropDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param serialNo 序号
     * @param registNo 报案号码
     * @return prpLpropDto prpLpropDto
     * @throws Exception
     */
    public PrpLpropDto findByPrimaryKey(DBManager dbManager,int serialNo,String registNo) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        //声明DTO
        PrpLpropDto prpLpropDto = null;
        //查询数据,赋值给DTO
        prpLpropDto = dbPrpLprop.findByPrimaryKey(serialNo, registNo);
        return prpLpropDto;
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
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprop.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLprop.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLpropDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLprop.findByConditions(conditions);
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
        DBPrpLprop dbPrpLprop = new DBPrpLprop(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprop.getCount(conditions);
        return count;
    }
}

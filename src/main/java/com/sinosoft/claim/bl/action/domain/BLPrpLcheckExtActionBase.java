package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcheckExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcheckExt;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLcheckExt-查勘/代查勘扩展表(修改)的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.984<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcheckExtActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcheckExtActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcheckExtActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcheckExtDto prpLcheckExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcheckExtDto prpLcheckExtDto) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        //插入记录
        dbPrpLcheckExt.insert(prpLcheckExtDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param serialNo 序号
     * @param columnName 查勘项目代码
     * @param referSerialNo 关联理赔车辆序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,String columnName,int referSerialNo) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        //删除记录
        dbPrpLcheckExt.delete(registNo, serialNo, columnName, referSerialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        //按条件删除记录
        dbPrpLcheckExt.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcheckExtDto prpLcheckExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcheckExtDto prpLcheckExtDto) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        //更新记录
        dbPrpLcheckExt.update(prpLcheckExtDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @param serialNo 序号
     * @param columnName 查勘项目代码
     * @param referSerialNo 关联理赔车辆序号
     * @return prpLcheckExtDto prpLcheckExtDto
     * @throws Exception
     */
    public PrpLcheckExtDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,String columnName,int referSerialNo) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        //声明DTO
        PrpLcheckExtDto prpLcheckExtDto = null;
        //查询数据,赋值给DTO
        prpLcheckExtDto = dbPrpLcheckExt.findByPrimaryKey(registNo, serialNo, columnName, referSerialNo);
        return prpLcheckExtDto;
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
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckExt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcheckExt.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcheckExtDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcheckExt.findByConditions(conditions);
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
        DBPrpLcheckExt dbPrpLcheckExt = new DBPrpLcheckExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcheckExt.getCount(conditions);
        return count;
    }
}

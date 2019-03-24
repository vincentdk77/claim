package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpDriskDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpDrisk;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpDrisk险种代码表的业务逻辑对象类<br>
 * 创建于 2004-11-09 10:40:54.669<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDriskActionBase{
    private static Log logger = LogFactory.getLog(BLPrpDriskActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpDriskActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDriskDto prpDriskDto) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        //插入记录
        dbPrpDrisk.insert(prpDriskDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        //删除记录
        dbPrpDrisk.delete(riskCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        //按条件删除记录
        dbPrpDrisk.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDriskDto prpDriskDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDriskDto prpDriskDto) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        //更新记录
        dbPrpDrisk.update(prpDriskDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @return prpDriskDto prpDriskDto
     * @throws Exception
     */
    public PrpDriskDto findByPrimaryKey(DBManager dbManager,String riskCode) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        //声明DTO
        PrpDriskDto prpDriskDto = null;
        //查询数据,赋值给DTO
        prpDriskDto = dbPrpDrisk.findByPrimaryKey(riskCode);
        return prpDriskDto;
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
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrisk.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpDrisk.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpDriskDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpDrisk.findByConditions(conditions);
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
        DBPrpDrisk dbPrpDrisk = new DBPrpDrisk(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDrisk.getCount(conditions);
        return count;
    }
}

package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcfeecoins;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLcfeecoins的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLcfeecoinsActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLcfeecoinsActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLcfeecoinsActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcfeecoinsDto prpLcfeecoinsDto)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        //插入记录
        dbPrpLcfeecoins.insert(prpLcfeecoinsDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param businessNo businessNo
     * @param serialNo serialNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo,int serialNo)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        //删除记录
        dbPrpLcfeecoins.delete(businessNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        //按条件删除记录
        dbPrpLcfeecoins.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcfeecoinsDto prpLcfeecoinsDto)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        //更新记录
        dbPrpLcfeecoins.update(prpLcfeecoinsDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param businessNo businessNo
     * @param serialNo serialNo
     * @return prpLcfeecoinsDto prpLcfeecoinsDto
     * @throws Exception
     */
    public PrpLcfeecoinsDto findByPrimaryKey(DBManager dbManager,String businessNo,int serialNo)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        //声明DTO
        PrpLcfeecoinsDto prpLcfeecoinsDto = null;
        //查询数据,赋值给DTO
        prpLcfeecoinsDto = dbPrpLcfeecoins.findByPrimaryKey(businessNo, serialNo);
        return prpLcfeecoinsDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcfeecoins.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcfeecoins.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLcfeecoinsDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcfeecoins.findByConditions(conditions);
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
        DBPrpLcfeecoins dbPrpLcfeecoins = new DBPrpLcfeecoins(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcfeecoins.getCount(conditions);
        return count;
    }
}

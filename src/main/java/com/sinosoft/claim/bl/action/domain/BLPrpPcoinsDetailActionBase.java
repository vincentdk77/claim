package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpPcoinsDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpPcoinsDetail;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpPcoinsDetail的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpPcoinsDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpPcoinsDetailActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpPcoinsDetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpPcoinsDetailDto prpPcoinsDetailDto)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        //插入记录
        dbPrpPcoinsDetail.insert(prpPcoinsDetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @param currency currency
     * @throws Exception
     */
    public void delete(DBManager dbManager,String endorseNo,long serialNo,String currency)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        //删除记录
        dbPrpPcoinsDetail.delete(endorseNo, serialNo, currency);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        //按条件删除记录
        dbPrpPcoinsDetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpPcoinsDetailDto prpPcoinsDetailDto)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        //更新记录
        dbPrpPcoinsDetail.update(prpPcoinsDetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param endorseNo endorseNo
     * @param serialNo serialNo
     * @param currency currency
     * @return prpPcoinsDetailDto prpPcoinsDetailDto
     * @throws Exception
     */
    public PrpPcoinsDetailDto findByPrimaryKey(DBManager dbManager,String endorseNo,long serialNo,String currency)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        //声明DTO
        PrpPcoinsDetailDto prpPcoinsDetailDto = null;
        //查询数据,赋值给DTO
        prpPcoinsDetailDto = dbPrpPcoinsDetail.findByPrimaryKey(endorseNo, serialNo, currency);
        return prpPcoinsDetailDto;
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
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPcoinsDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpPcoinsDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpPcoinsDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpPcoinsDetail.findByConditions(conditions);
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
        DBPrpPcoinsDetail dbPrpPcoinsDetail = new DBPrpPcoinsDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpPcoinsDetail.getCount(conditions);
        return count;
    }
}

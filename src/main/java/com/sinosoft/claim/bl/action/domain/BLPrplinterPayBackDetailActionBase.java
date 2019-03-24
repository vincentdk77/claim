package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterPayBackDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterPayBackDetail;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是大病医疗接口支付退回流程轨迹表的业务逻辑对象类<br>
 */
public class BLPrplinterPayBackDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterPayBackDetailActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplinterPayBackDetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplinterPayBackDetailDto prplinterPayBackDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplinterPayBackDetailDto prplinterPayBackDetailDto)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        //插入记录
        dbPrplinterPayBackDetail.insert(prplinterPayBackDetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        //删除记录
        dbPrplinterPayBackDetail.delete(id);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        //按条件删除记录
        dbPrplinterPayBackDetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplinterPayBackDetailDto prplinterPayBackDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplinterPayBackDetailDto prplinterPayBackDetailDto)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        //更新记录
        dbPrplinterPayBackDetail.update(prplinterPayBackDetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @return prplinterPayBackDetailDto prplinterPayBackDetailDto
     * @throws Exception
     */
    public PrplinterPayBackDetailDto findByPrimaryKey(DBManager dbManager,String id)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        //声明DTO
        PrplinterPayBackDetailDto prplinterPayBackDetailDto = null;
        //查询数据,赋值给DTO
        prplinterPayBackDetailDto = dbPrplinterPayBackDetail.findByPrimaryKey(id);
        return prplinterPayBackDetailDto;
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
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterPayBackDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplinterPayBackDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplinterPayBackDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplinterPayBackDetail.findByConditions(conditions);
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
        DBPrplinterPayBackDetail dbPrplinterPayBackDetail = new DBPrplinterPayBackDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterPayBackDetail.getCount(conditions);
        return count;
    }
}

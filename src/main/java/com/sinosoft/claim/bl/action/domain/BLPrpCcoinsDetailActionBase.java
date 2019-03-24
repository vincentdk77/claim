package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpCcoinsDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcoinsDetail;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpCcoinsDetail的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpCcoinsDetailActionBase{
    private static Logger logger = Logger.getLogger(BLPrpCcoinsDetailActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpCcoinsDetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCcoinsDetailDto prpCcoinsDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCcoinsDetailDto prpCcoinsDetailDto)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        //插入记录
        dbPrpCcoinsDetail.insert(prpCcoinsDetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @param currency currency
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,long serialNo,String currency)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        //删除记录
        dbPrpCcoinsDetail.delete(policyNo, serialNo, currency);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        //按条件删除记录
        dbPrpCcoinsDetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCcoinsDetailDto prpCcoinsDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCcoinsDetailDto prpCcoinsDetailDto)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        //更新记录
        dbPrpCcoinsDetail.update(prpCcoinsDetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo policyNo
     * @param serialNo serialNo
     * @param currency currency
     * @return prpCcoinsDetailDto prpCcoinsDetailDto
     * @throws Exception
     */
    public PrpCcoinsDetailDto findByPrimaryKey(DBManager dbManager,String policyNo,long serialNo,String currency)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        //声明DTO
        PrpCcoinsDetailDto prpCcoinsDetailDto = null;
        //查询数据,赋值给DTO
        prpCcoinsDetailDto = dbPrpCcoinsDetail.findByPrimaryKey(policyNo, serialNo, currency);
        return prpCcoinsDetailDto;
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
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCcoinsDetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpCcoinsDetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpCcoinsDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpCcoinsDetail.findByConditions(conditions);
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
        DBPrpCcoinsDetail dbPrpCcoinsDetail = new DBPrpCcoinsDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCcoinsDetail.getCount(conditions);
        return count;
    }
}

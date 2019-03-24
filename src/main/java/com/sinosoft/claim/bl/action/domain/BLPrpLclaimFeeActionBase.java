package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimFee;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimFee-估损金额表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.984<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFeeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFeeActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimFeeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimFeeDto prpLclaimFeeDto) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        //插入记录
        dbPrpLclaimFee.insert(prpLclaimFeeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号号
     * @param currency 币别代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String currency) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        //删除记录
        dbPrpLclaimFee.delete(claimNo, currency);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        //按条件删除记录
        dbPrpLclaimFee.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimFeeDto prpLclaimFeeDto) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        //更新记录
        dbPrpLclaimFee.update(prpLclaimFeeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号号
     * @param currency 币别代码
     * @return prpLclaimFeeDto prpLclaimFeeDto
     * @throws Exception
     */
    public PrpLclaimFeeDto findByPrimaryKey(DBManager dbManager,String claimNo,String currency) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        //声明DTO
        PrpLclaimFeeDto prpLclaimFeeDto = null;
        //查询数据,赋值给DTO
        prpLclaimFeeDto = dbPrpLclaimFee.findByPrimaryKey(claimNo, currency);
        return prpLclaimFeeDto;
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
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimFee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimFee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimFeeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimFee.findByConditions(conditions);
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
        DBPrpLclaimFee dbPrpLclaimFee = new DBPrpLclaimFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimFee.getCount(conditions);
        return count;
    }
}

package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterCompePayFee;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是计算书赔款费用信息的业务逻辑对象类<br>
 */
public class BLPrpLinterCompePayFeeActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterCompePayFeeActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterCompePayFeeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterCompePayFeeDto prpLinterCompePayFeeDto)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //插入记录
        dbPrpLinterCompePayFee.insert(prpLinterCompePayFeeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @param serialNo 主键序号pk
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //删除记录
        dbPrpLinterCompePayFee.delete(id, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //按条件删除记录
        dbPrpLinterCompePayFee.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterCompePayFeeDto prpLinterCompePayFeeDto)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //更新记录
        dbPrpLinterCompePayFee.update(prpLinterCompePayFeeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键pk
     * @param serialNo 主键序号pk
     * @return prpLinterCompePayFeeDto prpLinterCompePayFeeDto
     * @throws Exception
     */
    public PrpLinterCompePayFeeDto findByPrimaryKey(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        //声明DTO
        PrpLinterCompePayFeeDto prpLinterCompePayFeeDto = null;
        //查询数据,赋值给DTO
        prpLinterCompePayFeeDto = dbPrpLinterCompePayFee.findByPrimaryKey(id, serialNo);
        return prpLinterCompePayFeeDto;
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
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompePayFee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterCompePayFee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterCompePayFeeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterCompePayFee.findByConditions(conditions);
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
        DBPrpLinterCompePayFee dbPrpLinterCompePayFee = new DBPrpLinterCompePayFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterCompePayFee.getCount(conditions);
        return count;
    }
}

package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLrepairFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLrepairFee;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLrepairFee-修理费用清单(修改)的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.093<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLrepairFeeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLrepairFeeActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLrepairFeeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLrepairFeeDto prpLrepairFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLrepairFeeDto prpLrepairFeeDto) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        //插入记录
        dbPrpLrepairFee.insert(prpLrepairFeeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param serialNo 序号
     * @param registNo 报案号码
     * @param lossItemCode 标的代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,int serialNo,String registNo,String lossItemCode) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        //删除记录
        dbPrpLrepairFee.delete(serialNo, registNo, lossItemCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        //按条件删除记录
        dbPrpLrepairFee.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLrepairFeeDto prpLrepairFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLrepairFeeDto prpLrepairFeeDto) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        //更新记录
        dbPrpLrepairFee.update(prpLrepairFeeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param serialNo 序号
     * @param registNo 报案号码
     * @param lossItemCode 标的代码
     * @return prpLrepairFeeDto prpLrepairFeeDto
     * @throws Exception
     */
    public PrpLrepairFeeDto findByPrimaryKey(DBManager dbManager,int serialNo,String registNo,String lossItemCode) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        //声明DTO
        PrpLrepairFeeDto prpLrepairFeeDto = null;
        //查询数据,赋值给DTO
        prpLrepairFeeDto = dbPrpLrepairFee.findByPrimaryKey(serialNo, registNo, lossItemCode);
        return prpLrepairFeeDto;
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
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrepairFee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLrepairFee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLrepairFeeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLrepairFee.findByConditions(conditions);
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
        DBPrpLrepairFee dbPrpLrepairFee = new DBPrpLrepairFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLrepairFee.getCount(conditions);
        return count;
    }
}

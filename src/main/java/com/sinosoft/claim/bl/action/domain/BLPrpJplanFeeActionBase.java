package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJplanFeeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJplanFee;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是应收应付费信息表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpJplanFeeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpJplanFeeActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpJplanFeeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJplanFeeDto prpJplanFeeDto)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        //插入记录
        dbPrpJplanFee.insert(prpJplanFeeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param certiType 业务类型
     * @param certiNo 保单号码/批单号码
     * @param serialNo 交费计划序号
     * @param payRefReason 收付原因
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiType,String certiNo,int serialNo,String payRefReason)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        //删除记录
        dbPrpJplanFee.delete(certiType, certiNo, serialNo, payRefReason);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        //按条件删除记录
        dbPrpJplanFee.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJplanFeeDto prpJplanFeeDto)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        //更新记录
        dbPrpJplanFee.update(prpJplanFeeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param certiType 业务类型
     * @param certiNo 保单号码/批单号码
     * @param serialNo 交费计划序号
     * @param payRefReason 收付原因
     * @return prpJplanFeeDto prpJplanFeeDto
     * @throws Exception
     */
    public PrpJplanFeeDto findByPrimaryKey(DBManager dbManager,String certiType,String certiNo,int serialNo,String payRefReason)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        //声明DTO
        PrpJplanFeeDto prpJplanFeeDto = null;
        //查询数据,赋值给DTO
        prpJplanFeeDto = dbPrpJplanFee.findByPrimaryKey(certiType, certiNo, serialNo, payRefReason);
        return prpJplanFeeDto;
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
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJplanFee.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpJplanFee.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpJplanFeeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpJplanFee.findByConditions(conditions);
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
        DBPrpJplanFee dbPrpJplanFee = new DBPrpJplanFee(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJplanFee.getCount(conditions);
        return count;
    }
}

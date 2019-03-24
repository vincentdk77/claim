package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCprofitDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCprofitDetail;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcprofitdetail优惠折扣明细表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCprofitDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpCprofitDetailActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCprofitDetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCprofitDetailDto prpCprofitDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCprofitDetailDto prpCprofitDetailDto) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        //插入记录
        dbPrpCprofitDetail.insert(prpCprofitDetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号
     * @param profitType 优惠折扣类型
     * @param itemKindNo 标的子险序号
     * @param profitCode 优惠折扣代码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,String profitType,int itemKindNo,String profitCode,int serialNo) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        //删除记录
        dbPrpCprofitDetail.delete(policyNo, profitType, itemKindNo, profitCode, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        //按条件删除记录
        dbPrpCprofitDetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCprofitDetailDto prpCprofitDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCprofitDetailDto prpCprofitDetailDto) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        //更新记录
        dbPrpCprofitDetail.update(prpCprofitDetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号
     * @param profitType 优惠折扣类型
     * @param itemKindNo 标的子险序号
     * @param profitCode 优惠折扣代码
     * @param serialNo 序号
     * @return prpCprofitDetailDto prpCprofitDetailDto
     * @throws Exception
     */
    public PrpCprofitDetailDto findByPrimaryKey(DBManager dbManager,String policyNo,String profitType,int itemKindNo,String profitCode,int serialNo) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        //声明DTO
        PrpCprofitDetailDto prpCprofitDetailDto = null;
        //查询数据,赋值给DTO
        prpCprofitDetailDto = dbPrpCprofitDetail.findByPrimaryKey(policyNo, profitType, itemKindNo, profitCode, serialNo);
        return prpCprofitDetailDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCprofitDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCprofitDetail.getCount(conditions);
        collection = dbPrpCprofitDetail.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpCprofitDetail dbPrpCprofitDetail = new DBPrpCprofitDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCprofitDetail.getCount(conditions);
        return count;
    }
}

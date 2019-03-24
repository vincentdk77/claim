package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcargoDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcargoDetail;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpccargodetail货运险货运明细信息的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcargoDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcargoDetailActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCcargoDetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCcargoDetailDto prpCcargoDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCcargoDetailDto prpCcargoDetailDto) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        //插入记录
        dbPrpCcargoDetail.insert(prpCcargoDetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号/协议号
     * @param batchNo 批次
     * @param serialNo 顺序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int batchNo,int serialNo) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        //删除记录
        dbPrpCcargoDetail.delete(policyNo, batchNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        //按条件删除记录
        dbPrpCcargoDetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCcargoDetailDto prpCcargoDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCcargoDetailDto prpCcargoDetailDto) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        //更新记录
        dbPrpCcargoDetail.update(prpCcargoDetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号/协议号
     * @param batchNo 批次
     * @param serialNo 顺序号
     * @return prpCcargoDetailDto prpCcargoDetailDto
     * @throws Exception
     */
    public PrpCcargoDetailDto findByPrimaryKey(DBManager dbManager,String policyNo,int batchNo,int serialNo) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        //声明DTO
        PrpCcargoDetailDto prpCcargoDetailDto = null;
        //查询数据,赋值给DTO
        prpCcargoDetailDto = dbPrpCcargoDetail.findByPrimaryKey(policyNo, batchNo, serialNo);
        return prpCcargoDetailDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCcargoDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCcargoDetail.getCount(conditions);
        collection = dbPrpCcargoDetail.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCcargoDetail dbPrpCcargoDetail = new DBPrpCcargoDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCcargoDetail.getCount(conditions);
        return count;
    }
}

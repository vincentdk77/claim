package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefRecDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJrefRecDetail;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpjrefrecdetail付费登记明细表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefRecDetailActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefRecDetailActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpJrefRecDetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpJrefRecDetailDto prpJrefRecDetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJrefRecDetailDto prpJrefRecDetailDto) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        //插入记录
        dbPrpJrefRecDetail.insert(prpJrefRecDetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @param itemKindNo 标的险别序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,int serialNo,int itemKindNo) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        //删除记录
        dbPrpJrefRecDetail.delete(certiNo, serialNo, itemKindNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        //按条件删除记录
        dbPrpJrefRecDetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpJrefRecDetailDto prpJrefRecDetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJrefRecDetailDto prpJrefRecDetailDto) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        //更新记录
        dbPrpJrefRecDetail.update(prpJrefRecDetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param certiNo 保单号码/批单号码/赔款计算书号码
     * @param serialNo 本次付费序号
     * @param itemKindNo 标的险别序号
     * @return prpJrefRecDetailDto prpJrefRecDetailDto
     * @throws Exception
     */
    public PrpJrefRecDetailDto findByPrimaryKey(DBManager dbManager,String certiNo,int serialNo,int itemKindNo) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        //声明DTO
        PrpJrefRecDetailDto prpJrefRecDetailDto = null;
        //查询数据,赋值给DTO
        prpJrefRecDetailDto = dbPrpJrefRecDetail.findByPrimaryKey(certiNo, serialNo, itemKindNo);
        return prpJrefRecDetailDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpJrefRecDetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJrefRecDetail.getCount(conditions);
        collection = dbPrpJrefRecDetail.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJrefRecDetail dbPrpJrefRecDetail = new DBPrpJrefRecDetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJrefRecDetail.getCount(conditions);
        return count;
    }
}

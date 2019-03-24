package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDstatiTypeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDstatiType;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdstatitype险种统计分类表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDstatiTypeActionBase{
    private static Log log = LogFactory.getLog(BLPrpDstatiTypeActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDstatiTypeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDstatiTypeDto prpDstatiTypeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDstatiTypeDto prpDstatiTypeDto) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        //插入记录
        dbPrpDstatiType.insert(prpDstatiTypeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种
     * @param kindCode 险别
     * @param belongType 统计类型
     * @param validDate 生效日期
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String kindCode,String belongType,DateTime validDate) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        //删除记录
        dbPrpDstatiType.delete(riskCode, kindCode, belongType, validDate);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        //按条件删除记录
        dbPrpDstatiType.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDstatiTypeDto prpDstatiTypeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDstatiTypeDto prpDstatiTypeDto) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        //更新记录
        dbPrpDstatiType.update(prpDstatiTypeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种
     * @param kindCode 险别
     * @param belongType 统计类型
     * @param validDate 生效日期
     * @return prpDstatiTypeDto prpDstatiTypeDto
     * @throws Exception
     */
    public PrpDstatiTypeDto findByPrimaryKey(DBManager dbManager,String riskCode,String kindCode,String belongType,DateTime validDate) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        //声明DTO
        PrpDstatiTypeDto prpDstatiTypeDto = null;
        //查询数据,赋值给DTO
        prpDstatiTypeDto = dbPrpDstatiType.findByPrimaryKey(riskCode, kindCode, belongType, validDate);
        return prpDstatiTypeDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDstatiTypeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDstatiType.getCount(conditions);
        collection = dbPrpDstatiType.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDstatiType dbPrpDstatiType = new DBPrpDstatiType(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDstatiType.getCount(conditions);
        return count;
    }
}

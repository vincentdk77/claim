package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCrenewalDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCrenewal;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcrenewal续保信息表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCrenewalActionBase{
    private static Log log = LogFactory.getLog(BLPrpCrenewalActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCrenewalActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCrenewalDto prpCrenewalDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCrenewalDto prpCrenewalDto) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        //插入记录
        dbPrpCrenewal.insert(prpCrenewalDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        //删除记录
        dbPrpCrenewal.delete(policyNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        //按条件删除记录
        dbPrpCrenewal.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCrenewalDto prpCrenewalDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCrenewalDto prpCrenewalDto) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        //更新记录
        dbPrpCrenewal.update(prpCrenewalDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @return prpCrenewalDto prpCrenewalDto
     * @throws Exception
     */
    public PrpCrenewalDto findByPrimaryKey(DBManager dbManager,String policyNo) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        //声明DTO
        PrpCrenewalDto prpCrenewalDto = null;
        //查询数据,赋值给DTO
        prpCrenewalDto = dbPrpCrenewal.findByPrimaryKey(policyNo);
        return prpCrenewalDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCrenewalDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCrenewal.getCount(conditions);
        collection = dbPrpCrenewal.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCrenewal dbPrpCrenewal = new DBPrpCrenewal(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCrenewal.getCount(conditions);
        return count;
    }
}

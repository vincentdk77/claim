package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLtrackDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLtrack;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpltrack的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLtrackActionBase{
    private static Log log = LogFactory.getLog(BLPrpLtrackActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpLtrackActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLtrackDto prpLtrackDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLtrackDto prpLtrackDto) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        //插入记录
        dbPrpLtrack.insert(prpLtrackDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param docCode 单证代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,String docCode) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        //删除记录
        dbPrpLtrack.delete(registNo, docCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        //按条件删除记录
        dbPrpLtrack.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLtrackDto prpLtrackDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLtrackDto prpLtrackDto) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        //更新记录
        dbPrpLtrack.update(prpLtrackDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param docCode 单证代码
     * @return prpLtrackDto prpLtrackDto
     * @throws Exception
     */
    public PrpLtrackDto findByPrimaryKey(DBManager dbManager,String registNo,String docCode) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        //声明DTO
        PrpLtrackDto prpLtrackDto = null;
        //查询数据,赋值给DTO
        prpLtrackDto = dbPrpLtrack.findByPrimaryKey(registNo, docCode);
        return prpLtrackDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpLtrackDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLtrack.getCount(conditions);
        collection = dbPrpLtrack.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLtrack dbPrpLtrack = new DBPrpLtrack(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLtrack.getCount(conditions);
        return count;
    }
}

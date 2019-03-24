package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpeds_CompDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpeds_Comp;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLpeds_Comp换件清单接口数据表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpLpeds_CompActionBase{
    private static Log log = LogFactory.getLog(BLPrpLpeds_CompActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpLpeds_CompActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpeds_CompDto prpLpeds_CompDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpeds_CompDto prpLpeds_CompDto) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        //插入记录
        dbPrpLpeds_Comp.insert(prpLpeds_CompDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        //删除记录
        dbPrpLpeds_Comp.delete(registNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        //按条件删除记录
        dbPrpLpeds_Comp.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpeds_CompDto prpLpeds_CompDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpeds_CompDto prpLpeds_CompDto) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        //更新记录
        dbPrpLpeds_Comp.update(prpLpeds_CompDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @param serialNo 序号
     * @return prpLpeds_CompDto prpLpeds_CompDto
     * @throws Exception
     */
    public PrpLpeds_CompDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        //声明DTO
        PrpLpeds_CompDto prpLpeds_CompDto = null;
        //查询数据,赋值给DTO
        prpLpeds_CompDto = dbPrpLpeds_Comp.findByPrimaryKey(registNo, serialNo);
        return prpLpeds_CompDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpLpeds_CompDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpLpeds_Comp.getCount(conditions);
        collection = dbPrpLpeds_Comp.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpLpeds_Comp dbPrpLpeds_Comp = new DBPrpLpeds_Comp(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpeds_Comp.getCount(conditions);
        return count;
    }
}

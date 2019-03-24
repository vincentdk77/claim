package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDportDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDport;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdport港口代码的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDportActionBase{
    private static Log log = LogFactory.getLog(BLPrpDportActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDportActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDportDto prpDportDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDportDto prpDportDto) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        //插入记录
        dbPrpDport.insert(prpDportDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param portCode 港口代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String portCode) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        //删除记录
        dbPrpDport.delete(portCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        //按条件删除记录
        dbPrpDport.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDportDto prpDportDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDportDto prpDportDto) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        //更新记录
        dbPrpDport.update(prpDportDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param portCode 港口代码
     * @return prpDportDto prpDportDto
     * @throws Exception
     */
    public PrpDportDto findByPrimaryKey(DBManager dbManager,String portCode) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        //声明DTO
        PrpDportDto prpDportDto = null;
        //查询数据,赋值给DTO
        prpDportDto = dbPrpDport.findByPrimaryKey(portCode);
        return prpDportDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDportDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDport.getCount(conditions);
        collection = dbPrpDport.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDport dbPrpDport = new DBPrpDport(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDport.getCount(conditions);
        return count;
    }
}

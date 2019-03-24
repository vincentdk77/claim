package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCcarDriverDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCcarDriver;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpccardriver车辆驾驶员关系表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCcarDriverActionBase{
    private static Log log = LogFactory.getLog(BLPrpCcarDriverActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCcarDriverActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCcarDriverDto prpCcarDriverDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCcarDriverDto prpCcarDriverDto) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        //插入记录
        dbPrpCcarDriver.insert(prpCcarDriverDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 顺序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        //删除记录
        dbPrpCcarDriver.delete(policyNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        //按条件删除记录
        dbPrpCcarDriver.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCcarDriverDto prpCcarDriverDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCcarDriverDto prpCcarDriverDto) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        //更新记录
        dbPrpCcarDriver.update(prpCcarDriverDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @param serialNo 顺序号
     * @return prpCcarDriverDto prpCcarDriverDto
     * @throws Exception
     */
    public PrpCcarDriverDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        //声明DTO
        PrpCcarDriverDto prpCcarDriverDto = null;
        //查询数据,赋值给DTO
        prpCcarDriverDto = dbPrpCcarDriver.findByPrimaryKey(policyNo, serialNo);
        return prpCcarDriverDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCcarDriverDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCcarDriver.getCount(conditions);
        collection = dbPrpCcarDriver.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCcarDriver dbPrpCcarDriver = new DBPrpCcarDriver(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCcarDriver.getCount(conditions);
        return count;
    }
}

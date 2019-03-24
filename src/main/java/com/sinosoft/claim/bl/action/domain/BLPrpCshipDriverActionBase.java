package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCshipDriverDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCshipDriver;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcshipdriver船舶险船员信息表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCshipDriverActionBase{
    private static Log log = LogFactory.getLog(BLPrpCshipDriverActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCshipDriverActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCshipDriverDto prpCshipDriverDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCshipDriverDto prpCshipDriverDto) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        //插入记录
        dbPrpCshipDriver.insert(prpCshipDriverDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 投保单号码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        //删除记录
        dbPrpCshipDriver.delete(policyNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        //按条件删除记录
        dbPrpCshipDriver.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCshipDriverDto prpCshipDriverDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCshipDriverDto prpCshipDriverDto) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        //更新记录
        dbPrpCshipDriver.update(prpCshipDriverDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 投保单号码
     * @param serialNo 序号
     * @return prpCshipDriverDto prpCshipDriverDto
     * @throws Exception
     */
    public PrpCshipDriverDto findByPrimaryKey(DBManager dbManager,String policyNo,int serialNo) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        //声明DTO
        PrpCshipDriverDto prpCshipDriverDto = null;
        //查询数据,赋值给DTO
        prpCshipDriverDto = dbPrpCshipDriver.findByPrimaryKey(policyNo, serialNo);
        return prpCshipDriverDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCshipDriverDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCshipDriver.getCount(conditions);
        collection = dbPrpCshipDriver.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCshipDriver dbPrpCshipDriver = new DBPrpCshipDriver(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCshipDriver.getCount(conditions);
        return count;
    }
}

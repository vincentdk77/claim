package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmain;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcmain保单基本信息表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCmainActionBase{
    private static Log log = LogFactory.getLog(BLPrpCmainActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpCmainActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpCmainDto prpCmainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCmainDto prpCmainDto) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        //插入记录
        dbPrpCmain.insert(prpCmainDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        //删除记录
        dbPrpCmain.delete(policyNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        //按条件删除记录
        dbPrpCmain.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpCmainDto prpCmainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCmainDto prpCmainDto) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        //更新记录
        dbPrpCmain.update(prpCmainDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param policyNo 保单号码
     * @return prpCmainDto prpCmainDto
     * @throws Exception
     */
    public PrpCmainDto findByPrimaryKey(DBManager dbManager,String policyNo) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        //声明DTO
        PrpCmainDto prpCmainDto = null;
        //查询数据,赋值给DTO
        prpCmainDto = dbPrpCmain.findByPrimaryKey(policyNo);
        return prpCmainDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpCmainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCmain.getCount(conditions);
        collection = dbPrpCmain.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCmain.getCount(conditions);
        return count;
    }
}

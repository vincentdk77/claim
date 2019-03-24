package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDlimitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDlimit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdlimit限额免赔代码表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDlimitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDlimitActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpDlimitActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpDlimitDto prpDlimitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDlimitDto prpDlimitDto) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //插入记录
        dbPrpDlimit.insert(prpDlimitDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param limitCode 限额/免赔类别代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String limitCode) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //删除记录
        dbPrpDlimit.delete(riskCode, limitCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //按条件删除记录
        dbPrpDlimit.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpDlimitDto prpDlimitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDlimitDto prpDlimitDto) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //更新记录
        dbPrpDlimit.update(prpDlimitDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param riskCode 险种代码
     * @param limitCode 限额/免赔类别代码
     * @return prpDlimitDto prpDlimitDto
     * @throws Exception
     */
    public PrpDlimitDto findByPrimaryKey(DBManager dbManager,String riskCode,String limitCode) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //声明DTO
        PrpDlimitDto prpDlimitDto = null;
        //查询数据,赋值给DTO
        prpDlimitDto = dbPrpDlimit.findByPrimaryKey(riskCode, limitCode);
        return prpDlimitDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpDlimitDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDlimit.getCount(conditions);
        collection = dbPrpDlimit.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDlimit.getCount(conditions);
        return count;
    }
}

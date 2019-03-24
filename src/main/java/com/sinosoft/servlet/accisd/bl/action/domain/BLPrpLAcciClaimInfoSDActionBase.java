package com.sinosoft.servlet.accisd.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;
import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciClaimInfoSDDto;
import com.sinosoft.servlet.accisd.resource.dtofactory.domain.DBPrpLAcciClaimInfoSD;
import com.sinosoft.servlet.accisd.resource.dtofactory.domain.DBPrpLAcciClaimInfoSD;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLACCICLAIMINFOSD的业务逻辑对象类<br>
 */
public class BLPrpLAcciClaimInfoSDActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLAcciClaimInfoSDActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLAcciClaimInfoSDActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        //插入记录
        dbPrplacciclaiminfosd.insert(prplacciclaiminfosdDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param name NAME
     * @throws Exception
     */
    public void delete(DBManager dbManager,String name,String credentialType,String credentialNo,String claimNo)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        //删除记录
        dbPrplacciclaiminfosd.delete(name,credentialType,credentialNo,claimNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        //按条件删除记录
        dbPrplacciclaiminfosd.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        //更新记录
        dbPrplacciclaiminfosd.update(prplacciclaiminfosdDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param name NAME
     * @return prplacciclaiminfosdDto prplacciclaiminfosdDto
     * @throws Exception
     */
    public PrpLAcciClaimInfoSDDto findByPrimaryKey(DBManager dbManager,String name,String credentialType,String credentialNo,String claimNo)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        //声明DTO
        PrpLAcciClaimInfoSDDto prplacciclaiminfosdDto = null;
        //查询数据,赋值给DTO
        prplacciclaiminfosdDto = dbPrplacciclaiminfosd.findByPrimaryKey(name,credentialType,credentialNo,claimNo);
        return prplacciclaiminfosdDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return PageRecord 查询的一页的结果
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplacciclaiminfosd.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplacciclaiminfosd.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplacciclaiminfosdDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplacciclaiminfosd.findByConditions(conditions);
        return collection;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLAcciClaimInfoSD dbPrplacciclaiminfosd = new DBPrpLAcciClaimInfoSD(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplacciclaiminfosd.getCount(conditions);
        return count;
    }
}

package com.sinosoft.servlet.accisd.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.servlet.accisd.dto.domain.PrpLAcciBaseInfoSDDto;
import com.sinosoft.servlet.accisd.resource.dtofactory.domain.DBPrpLAcciBaseInfoSD;
import com.sinosoft.servlet.accisd.resource.dtofactory.domain.DBPrpLAcciBaseInfoSD;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.log.Logger;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLACCIBASEINFOSD的业务逻辑对象类<br>
 */
public class BLPrpLAcciBaseInfoSDActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLAcciBaseInfoSDActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLAcciBaseInfoSDActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        //插入记录
        dbPrplaccibaseinfosd.insert(prplaccibaseinfosdDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param name NAME
     * @throws Exception
     */
    public void delete(DBManager dbManager,String name,String credentialType,String credentialNo)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        //删除记录
        dbPrplaccibaseinfosd.delete(name,credentialType,credentialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        //按条件删除记录
        dbPrplaccibaseinfosd.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        //更新记录
        dbPrplaccibaseinfosd.update(prplaccibaseinfosdDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param name NAME
     * @return prplaccibaseinfosdDto prplaccibaseinfosdDto
     * @throws Exception
     */
    public PrpLAcciBaseInfoSDDto findByPrimaryKey(DBManager dbManager,String name,String credentialType,String credentialNo)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        //声明DTO
        PrpLAcciBaseInfoSDDto prplaccibaseinfosdDto = null;
        //查询数据,赋值给DTO
        prplaccibaseinfosdDto = dbPrplaccibaseinfosd.findByPrimaryKey(name,credentialType,credentialNo);
        return prplaccibaseinfosdDto;
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
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccibaseinfosd.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplaccibaseinfosd.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplaccibaseinfosdDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplaccibaseinfosd.findByConditions(conditions);
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
        DBPrpLAcciBaseInfoSD dbPrplaccibaseinfosd = new DBPrpLAcciBaseInfoSD(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplaccibaseinfosd.getCount(conditions);
        return count;
    }
}

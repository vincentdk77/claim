package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpJthirdBankMappingDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJthirdBankMapping;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpJthirdBankMapping的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpJthirdBankMappingActionBase{
    private static Logger logger = Logger.getLogger(BLPrpJthirdBankMappingActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpJthirdBankMappingActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJthirdBankMappingDto prpJthirdBankMappingDto)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        //插入记录
        dbPrpJthirdBankMapping.insert(prpJthirdBankMappingDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param thirdType thirdType
     * @throws Exception
     */
    public void delete(DBManager dbManager,String thirdType)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        //删除记录
        dbPrpJthirdBankMapping.delete(thirdType);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        //按条件删除记录
        dbPrpJthirdBankMapping.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJthirdBankMappingDto prpJthirdBankMappingDto)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        //更新记录
        dbPrpJthirdBankMapping.update(prpJthirdBankMappingDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param thirdType thirdType
     * @return prpJthirdBankMappingDto prpJthirdBankMappingDto
     * @throws Exception
     */
    public PrpJthirdBankMappingDto findByPrimaryKey(DBManager dbManager,String thirdType)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        //声明DTO
        PrpJthirdBankMappingDto prpJthirdBankMappingDto = null;
        //查询数据,赋值给DTO
        prpJthirdBankMappingDto = dbPrpJthirdBankMapping.findByPrimaryKey(thirdType);
        return prpJthirdBankMappingDto;
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
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJthirdBankMapping.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpJthirdBankMapping.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpJthirdBankMappingDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpJthirdBankMapping.findByConditions(conditions);
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
        DBPrpJthirdBankMapping dbPrpJthirdBankMapping = new DBPrpJthirdBankMapping(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJthirdBankMapping.getCount(conditions);
        return count;
    }
}

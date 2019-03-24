package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLinterPaymentInfo;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是传入参数子表-----赔付信息的业务逻辑对象类<br>
 */
public class BLPrpLinterPaymentInfoActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLinterPaymentInfoActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLinterPaymentInfoActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLinterPaymentInfoDto prpLinterPaymentInfoDto)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //插入记录
        dbPrpLinterPaymentInfo.insert(prpLinterPaymentInfoDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @param serialNo 主键序号 PK
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //删除记录
        dbPrpLinterPaymentInfo.delete(id, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //按条件删除记录
        dbPrpLinterPaymentInfo.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLinterPaymentInfoDto prpLinterPaymentInfoDto)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //更新记录
        dbPrpLinterPaymentInfo.update(prpLinterPaymentInfoDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键id PK
     * @param serialNo 主键序号 PK
     * @return prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @throws Exception
     */
    public PrpLinterPaymentInfoDto findByPrimaryKey(DBManager dbManager,String id,int serialNo)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        //声明DTO
        PrpLinterPaymentInfoDto prpLinterPaymentInfoDto = null;
        //查询数据,赋值给DTO
        prpLinterPaymentInfoDto = dbPrpLinterPaymentInfo.findByPrimaryKey(id, serialNo);
        return prpLinterPaymentInfoDto;
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
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPaymentInfo.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLinterPaymentInfo.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLinterPaymentInfoDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLinterPaymentInfo.findByConditions(conditions);
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
        DBPrpLinterPaymentInfo dbPrpLinterPaymentInfo = new DBPrpLinterPaymentInfo(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLinterPaymentInfo.getCount(conditions);
        return count;
    }
}

package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplinterrelation;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是中间表关联报案号的业务逻辑对象类<br>
 */
public class BLPrplinterrelationActionBase{
    private static Logger logger = Logger.getLogger(BLPrplinterrelationActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplinterrelationActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplinterrelationDto prplinterrelationDto)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        //插入记录
        dbPrplinterrelation.insert(prplinterrelationDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param id 主键id
     * @param outId 客户端主键
     * @throws Exception
     */
    public void delete(DBManager dbManager,String id,String outId)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        //删除记录
        dbPrplinterrelation.delete(id, outId);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        //按条件删除记录
        dbPrplinterrelation.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplinterrelationDto prplinterrelationDto)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        //更新记录
        dbPrplinterrelation.update(prplinterrelationDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param id 主键id
     * @param outId 客户端主键
     * @return prplinterrelationDto prplinterrelationDto
     * @throws Exception
     */
    public PrplinterrelationDto findByPrimaryKey(DBManager dbManager,String id,String outRigstNo)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        //声明DTO
        PrplinterrelationDto prplinterrelationDto = null;
        //查询数据,赋值给DTO
        prplinterrelationDto = dbPrplinterrelation.findByPrimaryKey(id, outRigstNo);
        return prplinterrelationDto;
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
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterrelation.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplinterrelation.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplinterrelationDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplinterrelation.findByConditions(conditions);
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
        DBPrplinterrelation dbPrplinterrelation = new DBPrplinterrelation(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplinterrelation.getCount(conditions);
        return count;
    }
    
}

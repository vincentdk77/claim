package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimFeetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimFeetg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimFee-估损金额表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.984<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimFeetgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimFeetgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimFeetgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimFeetgDto prpLclaimFeetgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimFeetgDto prpLclaimFeetgDto) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        //插入记录
        dbPrpLclaimFeetg.insert(prpLclaimFeetgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号号
     * @param currency 币别代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo,String currency) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        //删除记录
        dbPrpLclaimFeetg.delete(claimNo, currency);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        //按条件删除记录
        dbPrpLclaimFeetg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimFeetgDto prpLclaimFeetgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimFeetgDto prpLclaimFeetgDto) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        //更新记录
        dbPrpLclaimFeetg.update(prpLclaimFeetgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 赔案号号
     * @param currency 币别代码
     * @return prpLclaimFeetgDto prpLclaimFeetgDto
     * @throws Exception
     */
    public PrpLclaimFeetgDto findByPrimaryKey(DBManager dbManager,String claimNo,String currency) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        //声明DTO
        PrpLclaimFeetgDto prpLclaimFeetgDto = null;
        //查询数据,赋值给DTO
        prpLclaimFeetgDto = dbPrpLclaimFeetg.findByPrimaryKey(claimNo, currency);
        return prpLclaimFeetgDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimFeetg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimFeetg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimFeetgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimFeetg.findByConditions(conditions);
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
        DBPrpLclaimFeetg dbPrpLclaimFeetg = new DBPrpLclaimFeetg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimFeetg.getCount(conditions);
        return count;
    }
}

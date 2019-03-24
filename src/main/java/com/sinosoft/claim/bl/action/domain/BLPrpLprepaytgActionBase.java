package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLprepaytgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLprepaytg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLprepay-预赔登记表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.046<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLprepaytgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLprepaytgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLprepaytgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLprepaytgDto prpLprepaytgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLprepaytgDto prpLprepaytgDto) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        //插入记录
        dbPrpLprepaytg.insert(prpLprepaytgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param preCompensateNo 预赔登记号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String preCompensateNo) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        //删除记录
        dbPrpLprepaytg.delete(preCompensateNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        //按条件删除记录
        dbPrpLprepaytg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLprepaytgDto prpLprepaytgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLprepaytgDto prpLprepaytgDto) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        //更新记录
        dbPrpLprepaytg.update(prpLprepaytgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param preCompensateNo 预赔登记号
     * @return prpLprepaytgDto prpLprepaytgDto
     * @throws Exception
     */
    public PrpLprepaytgDto findByPrimaryKey(DBManager dbManager,String preCompensateNo) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        //声明DTO
        PrpLprepaytgDto prpLprepaytgDto = null;
        //查询数据,赋值给DTO
        prpLprepaytgDto = dbPrpLprepaytg.findByPrimaryKey(preCompensateNo);
        return prpLprepaytgDto;
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
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprepaytg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLprepaytg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLprepaytgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLprepaytg.findByConditions(conditions);
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
        DBPrpLprepaytg dbPrpLprepaytg = new DBPrpLprepaytg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLprepaytg.getCount(conditions);
        return count;
    }
}

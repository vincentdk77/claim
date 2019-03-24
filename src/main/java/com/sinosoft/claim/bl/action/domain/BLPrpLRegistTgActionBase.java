package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLRegistTgDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLRegistTg;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLRegistTg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLregist-报案信息表的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:37.984<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLRegistTgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLRegistTgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLRegistTgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLregistDto prpLregistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLRegistTgDto prpLregistDto) throws Exception{
        DBPrpLRegistTg dbPrpLregisttg = new DBPrpLRegistTg(dbManager);
        //插入记录
        dbPrpLregisttg.insert(prpLregistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo) throws Exception{
        DBPrpLRegistTg dbPrpLregisttg = new DBPrpLRegistTg(dbManager);
        //删除记录
        dbPrpLregisttg.delete(registNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLRegistTg dbPrpLregisttg = new DBPrpLRegistTg(dbManager);
        //按条件删除记录
        dbPrpLregisttg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLregistDto prpLregistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLRegistTgDto prpLregistDto) throws Exception{
        DBPrpLRegistTg dbPrpLregisttg = new DBPrpLRegistTg(dbManager);
        //更新记录
        dbPrpLregisttg.update(prpLregistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号码
     * @return prpLregistDto prpLregistDto
     * @throws Exception
     */
    public PrpLRegistTgDto findByPrimaryKey(DBManager dbManager,String registNo) throws Exception{
        DBPrpLRegistTg dbPrpLregisttg = new DBPrpLRegistTg(dbManager);
        //声明DTO
        PrpLRegistTgDto prpLregistDto = null;
        //查询数据,赋值给DTO
        prpLregistDto = dbPrpLregisttg.findByPrimaryKey(registNo);
        return prpLregistDto;
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
        DBPrpLRegistTg dbPrpLregisttg = new DBPrpLRegistTg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLregisttg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLregisttg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLregistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLRegistTg dbPrpLregisttg = new DBPrpLRegistTg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLregisttg.findByConditions(conditions);
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
        DBPrpLRegistTg dbPrpLregisttg = new DBPrpLRegistTg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLregisttg.getCount(conditions);
        return count;
    }
}

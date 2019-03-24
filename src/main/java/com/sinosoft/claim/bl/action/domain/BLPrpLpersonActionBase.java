package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLpersonDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLperson;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLperson-人员赔付信息表(修改)的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.046<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLpersonActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLpersonActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpersonActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpersonDto prpLpersonDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpersonDto prpLpersonDto) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        //插入记录
        dbPrpLperson.insert(prpLpersonDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param serialNo 序号
     * @param registNo 报案号码
     * @throws Exception
     */
    public void delete(DBManager dbManager,int serialNo,String registNo) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        //删除记录
        dbPrpLperson.delete(serialNo, registNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        //按条件删除记录
        dbPrpLperson.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpersonDto prpLpersonDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpersonDto prpLpersonDto) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        //更新记录
        dbPrpLperson.update(prpLpersonDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param serialNo 序号
     * @param registNo 报案号码
     * @return prpLpersonDto prpLpersonDto
     * @throws Exception
     */
    public PrpLpersonDto findByPrimaryKey(DBManager dbManager,int serialNo,String registNo) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        //声明DTO
        PrpLpersonDto prpLpersonDto = null;
        //查询数据,赋值给DTO
        prpLpersonDto = dbPrpLperson.findByPrimaryKey(serialNo, registNo);
        return prpLpersonDto;
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
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLperson.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLperson.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLpersonDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLperson.findByConditions(conditions);
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
        DBPrpLperson dbPrpLperson = new DBPrpLperson(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLperson.getCount(conditions);
        return count;
    }
}

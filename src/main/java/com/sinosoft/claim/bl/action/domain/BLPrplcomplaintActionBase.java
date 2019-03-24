package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcomplaint;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCOMPLAINT的业务逻辑对象类<br>
 */
public class BLPrplcomplaintActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcomplaintActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplcomplaintActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplcomplaintDto prplcomplaintDto)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        //插入记录
        dbPrplcomplaint.insert(prplcomplaintDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param complaintno COMPLAINTNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String complaintno)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        //删除记录
        dbPrplcomplaint.delete(complaintno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        //按条件删除记录
        dbPrplcomplaint.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplcomplaintDto prplcomplaintDto)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        //更新记录
        dbPrplcomplaint.update(prplcomplaintDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param complaintno COMPLAINTNO
     * @return prplcomplaintDto prplcomplaintDto
     * @throws Exception
     */
    public PrplcomplaintDto findByPrimaryKey(DBManager dbManager,String complaintno)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        //声明DTO
        PrplcomplaintDto prplcomplaintDto = null;
        //查询数据,赋值给DTO
        prplcomplaintDto = dbPrplcomplaint.findByPrimaryKey(complaintno);
        return prplcomplaintDto;
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
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcomplaint.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplcomplaint.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplcomplaintDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplcomplaint.findByConditions(conditions);
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
        DBPrplcomplaint dbPrplcomplaint = new DBPrplcomplaint(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcomplaint.getCount(conditions);
        return count;
    }
}

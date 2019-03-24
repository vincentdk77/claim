package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehousetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrplcompensatehousetg;
import java.math.*;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCOMPENSATEHOUSE的业务逻辑对象类<br>
 */
public class BLPrplcompensatehousetgActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensatehousetgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplcompensatehousetgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplcompensatehousetgDto prplcompensatehousetgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplcompensatehousetgDto prplcompensatehousetgDto)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        //插入记录
        DBPrplcompensatehousetg.insert(prplcompensatehousetgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @throws Exception
     */
    public void delete(DBManager dbManager,String idcard,String registno,String nodetype,String businessno)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        //删除记录
        DBPrplcompensatehousetg.delete(idcard, registno, nodetype, businessno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        //按条件删除记录
        DBPrplcompensatehousetg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplcompensatehousetgDto prplcompensatehousetgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplcompensatehousetgDto prplcompensatehousetgDto)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        //更新记录
        DBPrplcompensatehousetg.update(prplcompensatehousetgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @return prplcompensatehousetgDto prplcompensatehousetgDto
     * @throws Exception
     */
    public PrplcompensatehousetgDto findByPrimaryKey(DBManager dbManager,String idcard,String registno,String nodetype,String businessno)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        //声明DTO
        PrplcompensatehousetgDto prplcompensatehousetgDto = null;
        //查询数据,赋值给DTO
        prplcompensatehousetgDto = DBPrplcompensatehousetg.findByPrimaryKey(idcard, registno, nodetype, businessno);
        return prplcompensatehousetgDto;
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
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = DBPrplcompensatehousetg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = DBPrplcompensatehousetg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplcompensatehousetgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = DBPrplcompensatehousetg.findByConditions(conditions);
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
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = DBPrplcompensatehousetg.getCount(conditions);
        return count;
    }
    
    public BigDecimal getSumCompensate(DBManager dbManager,String idcard,String policyno) 
    throws Exception{
    DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);
    BigDecimal sum = DBPrplcompensatehousetg.getSumCompensate(idcard,policyno);
    return sum;
}
    
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getInprocessCount(DBManager dbManager,String policyno,String idcard) 
        throws Exception{
        DBPrplcompensatehousetg DBPrplcompensatehousetg = new DBPrplcompensatehousetg(dbManager);

        int count = DBPrplcompensatehousetg.getInprocessCount(policyno,idcard);
        return count;
    }
}

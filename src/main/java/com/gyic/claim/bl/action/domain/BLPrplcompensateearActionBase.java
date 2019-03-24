package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.gyic.claim.resource.dtofactory.domain.DBPrplcompensateear;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Prplcompensateear的业务逻辑对象类<br>
 */
public class BLPrplcompensateearActionBase{
    private static Logger logger = Logger.getLogger(BLPrplcompensateearActionBase.class);

    /**
     * 构造函数
     */
    public BLPrplcompensateearActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrplcompensateearDto prplcompensateearDto)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        //插入记录
        dbPrplcompensateear.insert(prplcompensateearDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param earno EARNO
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String earno,String registno,String nodetype,String businessno)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        //删除记录
        dbPrplcompensateear.delete(earno, registno, nodetype,businessno);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        //按条件删除记录
        dbPrplcompensateear.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrplcompensateearDto prplcompensateearDto)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        //更新记录
        dbPrplcompensateear.update(prplcompensateearDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param earno EARNO
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @return prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public PrplcompensateearDto findByPrimaryKey(DBManager dbManager,String earno,String registno,String nodetype,String businessno)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        //声明DTO
        PrplcompensateearDto prplcompensateearDto = null;
        //查询数据,赋值给DTO
        prplcompensateearDto = dbPrplcompensateear.findByPrimaryKey(earno, registno, nodetype,businessno);
        return prplcompensateearDto;
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
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcompensateear.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrplcompensateear.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prplcompensateearDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrplcompensateear.findByConditions(conditions);
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
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrplcompensateear.getCount(conditions);
        return count;
    }
    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getInprocessCount(DBManager dbManager,String policyno,String earno) 
        throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);

        int count = dbPrplcompensateear.getInprocessCount(policyno,earno);
        return count;
    }
    /**
     * 查询满足模糊查询条件的预计给付金额
     * @param dbManager DB管理器
     * @param conditions 模糊查询条件
     * @return 满足模糊查询条件的预计给付金额
     * @throws Exception
     */
    public double getSumLoss(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrplcompensateear dbPrplcompensateear = new DBPrplcompensateear(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        double sumLoss = dbPrplcompensateear.getSumLoss(conditions);
        return sumLoss;
    }
}

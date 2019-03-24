package com.sinosoft.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLpaymain;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是支付信息主表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLpaymainActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLpaymainActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLpaymainActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLpaymainDto prpLpaymainDto)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        //插入记录
        dbPrpLpaymain.insert(prpLpaymainDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param paymentNo 支付编号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String paymentNo)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        //删除记录
        dbPrpLpaymain.delete(paymentNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        //按条件删除记录
        dbPrpLpaymain.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLpaymainDto prpLpaymainDto)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        //更新记录
        dbPrpLpaymain.update(prpLpaymainDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param paymentNo 支付编号
     * @return prpLpaymainDto prpLpaymainDto
     * @throws Exception
     */
    public PrpLpaymainDto findByPrimaryKey(DBManager dbManager,String paymentNo)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        //声明DTO
        PrpLpaymainDto prpLpaymainDto = null;
        //查询数据,赋值给DTO
        prpLpaymainDto = dbPrpLpaymain.findByPrimaryKey(paymentNo);
        return prpLpaymainDto;
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
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.getCount(conditions);
        collection = dbPrpLpaymain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLpaymainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLpaymain.findByConditions(conditions);
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
        DBPrpLpaymain dbPrpLpaymain = new DBPrpLpaymain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLpaymain.getCount(conditions);
        return count;
    }
}

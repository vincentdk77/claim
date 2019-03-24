package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxendorchgdetailDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxendorchgdetail;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXENDORCHGDETAIL的业务逻辑对象类<br>
 */
public class BLNyxendorchgdetailActionBase{
    private static Logger logger = Logger.getLogger(BLNyxendorchgdetailActionBase.class);

    /**
     * 构造函数
     */
    public BLNyxendorchgdetailActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param nyxendorchgdetailDto nyxendorchgdetailDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxendorchgdetailDto nyxendorchgdetailDto)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        //插入记录
        dbNyxendorchgdetail.insert(nyxendorchgdetailDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String businessno,String endorseno,String kindcode,String itemcode)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        //删除记录
        dbNyxendorchgdetail.delete(inusrelistcode, businessno, endorseno, kindcode, itemcode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        //按条件删除记录
        dbNyxendorchgdetail.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param nyxendorchgdetailDto nyxendorchgdetailDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxendorchgdetailDto nyxendorchgdetailDto)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        //更新记录
        dbNyxendorchgdetail.update(nyxendorchgdetailDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param endorseno ENDORSENO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return nyxendorchgdetailDto nyxendorchgdetailDto
     * @throws Exception
     */
    public NyxendorchgdetailDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String businessno,String endorseno,String kindcode,String itemcode)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        //声明DTO
        NyxendorchgdetailDto nyxendorchgdetailDto = null;
        //查询数据,赋值给DTO
        nyxendorchgdetailDto = dbNyxendorchgdetail.findByPrimaryKey(inusrelistcode, businessno, endorseno, kindcode, itemcode);
        return nyxendorchgdetailDto;
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
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxendorchgdetail.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxendorchgdetail.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含nyxendorchgdetailDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxendorchgdetail.findByConditions(conditions);
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
        DBNyxendorchgdetail dbNyxendorchgdetail = new DBNyxendorchgdetail(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxendorchgdetail.getCount(conditions);
        return count;
    }
}

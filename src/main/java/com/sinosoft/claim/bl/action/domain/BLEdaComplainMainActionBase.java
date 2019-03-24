package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaComplainMainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBEdaComplainMain;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaComplainMain投诉信息表的业务逻辑对象类<br>
 * 创建于 2005-08-20 17:56:01.505<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaComplainMainActionBase{
    private static Log logger = LogFactory.getLog(BLEdaComplainMainActionBase.class);

    /**
     * 构造函数
     */
    public BLEdaComplainMainActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,EdaComplainMainDto edaComplainMainDto) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        //插入记录
        dbEdaComplainMain.insert(edaComplainMainDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param acceptNo 投诉登记号
     * @throws Exception
     */
    public void delete(DBManager dbManager,int acceptNo) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        //删除记录
        dbEdaComplainMain.delete(acceptNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        //按条件删除记录
        dbEdaComplainMain.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,EdaComplainMainDto edaComplainMainDto) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        //更新记录
        dbEdaComplainMain.update(edaComplainMainDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param acceptNo 投诉登记号
     * @return edaComplainMainDto edaComplainMainDto
     * @throws Exception
     */
    public EdaComplainMainDto findByPrimaryKey(DBManager dbManager,int acceptNo) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        //声明DTO
        EdaComplainMainDto edaComplainMainDto = null;
        //查询数据,赋值给DTO
        edaComplainMainDto = dbEdaComplainMain.findByPrimaryKey(acceptNo);
        return edaComplainMainDto;
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
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaComplainMain.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbEdaComplainMain.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含edaComplainMainDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbEdaComplainMain.findByConditions(conditions);
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
        DBEdaComplainMain dbEdaComplainMain = new DBEdaComplainMain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaComplainMain.getCount(conditions);
        return count;
    }
}

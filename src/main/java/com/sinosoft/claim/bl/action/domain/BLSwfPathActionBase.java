package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfPath;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是SwfPath工作流路径定义表（新增）的业务逻辑对象类<br>
 * 创建于 2005-03-18 17:53:38.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLSwfPathActionBase{
    private static Log logger = LogFactory.getLog(BLSwfPathActionBase.class);

    /**
     * 构造函数
     */
    public BLSwfPathActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param swfPathDto swfPathDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,SwfPathDto swfPathDto) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        //插入记录
        dbSwfPath.insert(swfPathDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编号
     * @param pathNo 程边号
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int pathNo) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        //删除记录
        dbSwfPath.delete(modelNo, pathNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        //按条件删除记录
        dbSwfPath.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param swfPathDto swfPathDto
     * @throws Exception
     */
    public void update(DBManager dbManager,SwfPathDto swfPathDto) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        //更新记录
        dbSwfPath.update(swfPathDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编号
     * @param pathNo 程边号
     * @return swfPathDto swfPathDto
     * @throws Exception
     */
    public SwfPathDto findByPrimaryKey(DBManager dbManager,int modelNo,int pathNo) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        //声明DTO
        SwfPathDto swfPathDto = null;
        //查询数据,赋值给DTO
        swfPathDto = dbSwfPath.findByPrimaryKey(modelNo, pathNo);
        return swfPathDto;
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
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPath.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbSwfPath.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含swfPathDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbSwfPath.findByConditions(conditions);
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
        DBSwfPath dbSwfPath = new DBSwfPath(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbSwfPath.getCount(conditions);
        return count;
    }
}

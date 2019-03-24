package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaUserDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBEdaUser;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是EdaUser-座席员信息表的业务逻辑对象类<br>
 * 创建于 2005-06-22 14:57:10.201<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaUserActionBase{
    private static Log logger = LogFactory.getLog(BLEdaUserActionBase.class);

    /**
     * 构造函数
     */
    public BLEdaUserActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param edaUserDto edaUserDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,EdaUserDto edaUserDto) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        //插入记录
        dbEdaUser.insert(edaUserDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param edaUserCode 座席员工号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String edaUserCode) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        //删除记录
        dbEdaUser.delete(edaUserCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        //按条件删除记录
        dbEdaUser.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param edaUserDto edaUserDto
     * @throws Exception
     */
    public void update(DBManager dbManager,EdaUserDto edaUserDto) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        //更新记录
        dbEdaUser.update(edaUserDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param edaUserCode 座席员工号
     * @return edaUserDto edaUserDto
     * @throws Exception
     */
    public EdaUserDto findByPrimaryKey(DBManager dbManager,String edaUserCode) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        //声明DTO
        EdaUserDto edaUserDto = null;
        //查询数据,赋值给DTO
        edaUserDto = dbEdaUser.findByPrimaryKey(edaUserCode);
        return edaUserDto;
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
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaUser.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbEdaUser.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含edaUserDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbEdaUser.findByConditions(conditions);
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
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaUser.getCount(conditions);
        return count;
    }
}

package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.TembloruploadinsurancelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBTembloruploadinsurancelist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是TEMBLORUPLOADINSURANCELIST的业务逻辑对象类<br>
 */
public class BLTembloruploadinsurancelistActionBase{
    private static Logger logger = Logger.getLogger(BLTembloruploadinsurancelistActionBase.class);

    /**
     * 构造函数
     */
    public BLTembloruploadinsurancelistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,TembloruploadinsurancelistDto tembloruploadinsurancelistDto)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        //插入记录
        dbTembloruploadinsurancelist.insert(tembloruploadinsurancelistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String address,String idcard)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        //删除记录
        dbTembloruploadinsurancelist.delete(inusrelistcode, address, idcard);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        //按条件删除记录
        dbTembloruploadinsurancelist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,TembloruploadinsurancelistDto tembloruploadinsurancelistDto)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        //更新记录
        dbTembloruploadinsurancelist.update(tembloruploadinsurancelistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param address ADDRESS
     * @param idcard IDCARD
     * @return tembloruploadinsurancelistDto tembloruploadinsurancelistDto
     * @throws Exception
     */
    public TembloruploadinsurancelistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String address,String idcard)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        //声明DTO
        TembloruploadinsurancelistDto tembloruploadinsurancelistDto = null;
        //查询数据,赋值给DTO
        tembloruploadinsurancelistDto = dbTembloruploadinsurancelist.findByPrimaryKey(inusrelistcode, address, idcard);
        return tembloruploadinsurancelistDto;
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
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTembloruploadinsurancelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbTembloruploadinsurancelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含tembloruploadinsurancelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbTembloruploadinsurancelist.findByConditions(conditions);
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
        DBTembloruploadinsurancelist dbTembloruploadinsurancelist = new DBTembloruploadinsurancelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbTembloruploadinsurancelist.getCount(conditions);
        return count;
    }
}

package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxinsurancelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxinsurancelist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXINSURANCELIST的业务逻辑对象类<br>
 */
public class BLNyxinsurancelistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxinsurancelistActionBase.class);

    /**
     * 构造函数
     */
    public BLNyxinsurancelistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param nyxinsurancelistDto nyxinsurancelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxinsurancelistDto nyxinsurancelistDto)
            throws Exception{
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        //插入记录
        dbNyxinsurancelist.insert(nyxinsurancelistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String businessno,String kindcode,String itemcode)
            throws Exception{
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        //删除记录
        dbNyxinsurancelist.delete(inusrelistcode, businessno, kindcode, itemcode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        //按条件删除记录
        dbNyxinsurancelist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param nyxinsurancelistDto nyxinsurancelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxinsurancelistDto nyxinsurancelistDto)
            throws Exception{
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        //更新记录
        dbNyxinsurancelist.update(nyxinsurancelistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param kindcode KINDCODE
     * @param itemcode ITEMCODE
     * @return nyxinsurancelistDto nyxinsurancelistDto
     * @throws Exception
     */
    public NyxinsurancelistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String businessno,String kindcode,String itemcode)
            throws Exception{
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        //声明DTO
        NyxinsurancelistDto nyxinsurancelistDto = null;
        //查询数据,赋值给DTO
        nyxinsurancelistDto = dbNyxinsurancelist.findByPrimaryKey(inusrelistcode, businessno, kindcode, itemcode);
        return nyxinsurancelistDto;
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
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxinsurancelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxinsurancelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含nyxinsurancelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxinsurancelist.findByConditions(conditions);
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
        DBNyxinsurancelist dbNyxinsurancelist = new DBNyxinsurancelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxinsurancelist.getCount(conditions);
        return count;
    }
}

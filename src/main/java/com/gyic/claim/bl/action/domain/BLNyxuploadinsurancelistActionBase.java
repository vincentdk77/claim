package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.NyxuploadinsurancelistDto;
import com.gyic.claim.resource.dtofactory.domain.DBNyxuploadinsurancelist;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是NYXUPLOADINSURANCELIST的业务逻辑对象类<br>
 */
public class BLNyxuploadinsurancelistActionBase{
    private static Logger logger = Logger.getLogger(BLNyxuploadinsurancelistActionBase.class);

    /**
     * 构造函数
     */
    public BLNyxuploadinsurancelistActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,NyxuploadinsurancelistDto nyxuploadinsurancelistDto)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        //插入记录
        dbNyxuploadinsurancelist.insert(nyxuploadinsurancelistDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param mulchtype MULCHTYPE
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusrelistcode,String businessno,String mulchtype)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        //删除记录
        dbNyxuploadinsurancelist.delete(inusrelistcode, businessno, mulchtype);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        //按条件删除记录
        dbNyxuploadinsurancelist.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @throws Exception
     */
    public void update(DBManager dbManager,NyxuploadinsurancelistDto nyxuploadinsurancelistDto)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        //更新记录
        dbNyxuploadinsurancelist.update(nyxuploadinsurancelistDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusrelistcode INUSRELISTCODE
     * @param businessno BUSINESSNO
     * @param mulchtype MULCHTYPE
     * @return nyxuploadinsurancelistDto nyxuploadinsurancelistDto
     * @throws Exception
     */
    public NyxuploadinsurancelistDto findByPrimaryKey(DBManager dbManager,String inusrelistcode,String businessno,String mulchtype)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        //声明DTO
        NyxuploadinsurancelistDto nyxuploadinsurancelistDto = null;
        //查询数据,赋值给DTO
        nyxuploadinsurancelistDto = dbNyxuploadinsurancelist.findByPrimaryKey(inusrelistcode, businessno, mulchtype);
        return nyxuploadinsurancelistDto;
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
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxuploadinsurancelist.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbNyxuploadinsurancelist.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含nyxuploadinsurancelistDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbNyxuploadinsurancelist.findByConditions(conditions);
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
        DBNyxuploadinsurancelist dbNyxuploadinsurancelist = new DBNyxuploadinsurancelist(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbNyxuploadinsurancelist.getCount(conditions);
        return count;
    }
}

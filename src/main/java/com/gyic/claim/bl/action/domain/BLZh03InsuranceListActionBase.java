package com.gyic.claim.bl.action.domain;

import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.Zh03InsuranceListDto;
import com.gyic.claim.resource.dtofactory.domain.DBZh03InsuranceList;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是ZH03InsuranceList的业务逻辑对象类<br>
 */
public class BLZh03InsuranceListActionBase{
    private static Logger logger = Logger.getLogger(BLZh03InsuranceListActionBase.class);

    /**
     * 构造函数
     */
    public BLZh03InsuranceListActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,Zh03InsuranceListDto zh03InsuranceListDto)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        //插入记录
        dbZh03InsuranceList.insert(zh03InsuranceListDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param inusreListCode InusreListCode
     * @throws Exception
     */
    public void delete(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        //删除记录
        dbZh03InsuranceList.delete(inusreListCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        //按条件删除记录
        dbZh03InsuranceList.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public void update(DBManager dbManager,Zh03InsuranceListDto zh03InsuranceListDto)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        //更新记录
        dbZh03InsuranceList.update(zh03InsuranceListDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param inusreListCode InusreListCode
     * @return zh03InsuranceListDto zh03InsuranceListDto
     * @throws Exception
     */
    public Zh03InsuranceListDto findByPrimaryKey(DBManager dbManager,String inusreListCode)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        //声明DTO
        Zh03InsuranceListDto zh03InsuranceListDto = null;
        //查询数据,赋值给DTO
        zh03InsuranceListDto = dbZh03InsuranceList.findByPrimaryKey(inusreListCode);
        return zh03InsuranceListDto;
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
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03InsuranceList.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbZh03InsuranceList.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含zh03InsuranceListDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbZh03InsuranceList.findByConditions(conditions);
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
        DBZh03InsuranceList dbZh03InsuranceList = new DBZh03InsuranceList(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbZh03InsuranceList.getCount(conditions);
        return count;
    }
}

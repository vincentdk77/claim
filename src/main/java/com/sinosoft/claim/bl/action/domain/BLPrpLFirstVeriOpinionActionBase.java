package com.sinosoft.claim.bl.action.domain;

import java.util.*;

import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLFirstVeriOpinionDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLFirstVeriOpinion;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是初核意见表的业务逻辑对象类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLFirstVeriOpinionActionBase{
    private static Logger logger = Logger.getLogger(BLPrpLFirstVeriOpinionActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLFirstVeriOpinionActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //插入记录
        dbPrpLFirstVeriOpinion.insert(prpLFirstVeriOpinionDto);
    }
    /**
     * 插入多条数据
     * @param dbManager DB管理器
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public void insertAll(DBManager dbManager,Collection<PrpLFirstVeriOpinionDto> prpLFirstVeriOpinionDtos)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //插入记录
        dbPrpLFirstVeriOpinion.insertAll(prpLFirstVeriOpinionDtos);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //删除记录
        dbPrpLFirstVeriOpinion.delete(registNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //按条件删除记录
        dbPrpLFirstVeriOpinion.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //更新记录
        dbPrpLFirstVeriOpinion.update(prpLFirstVeriOpinionDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param registNo 报案号
     * @return prpLFirstVeriOpinionDto prpLFirstVeriOpinionDto
     * @throws Exception
     */
    public PrpLFirstVeriOpinionDto findByPrimaryKey(DBManager dbManager,String registNo)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        //声明DTO
        PrpLFirstVeriOpinionDto prpLFirstVeriOpinionDto = null;
        //查询数据,赋值给DTO
        prpLFirstVeriOpinionDto = dbPrpLFirstVeriOpinion.findByPrimaryKey(registNo);
        return prpLFirstVeriOpinionDto;
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
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLFirstVeriOpinion.getCount(conditions);
        collection = dbPrpLFirstVeriOpinion.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLFirstVeriOpinionDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLFirstVeriOpinion.findByConditions(conditions);
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
        DBPrpLFirstVeriOpinion dbPrpLFirstVeriOpinion = new DBPrpLFirstVeriOpinion(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLFirstVeriOpinion.getCount(conditions);
        return count;
    }
}

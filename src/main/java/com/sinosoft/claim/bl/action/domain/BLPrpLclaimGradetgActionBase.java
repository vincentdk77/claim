package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimGradetgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimGradetg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLclaimGrade--理赔业务权限表(新增)的业务逻辑对象类<br>
 * 创建于 2005-04-19 09:24:22.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimGradetgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimGradetgActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpLclaimGradetgActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpLclaimGradetgDto prpLclaimGradetgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimGradetgDto prpLclaimGradetgDto) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        //插入记录
        dbPrpLclaimGradetg.insert(prpLclaimGradetgDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param userCode 员工代码
     * @param taskCode 任务代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String userCode,String taskCode,String configPara) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        //删除记录
        dbPrpLclaimGradetg.delete(userCode, taskCode,configPara);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        //按条件删除记录
        dbPrpLclaimGradetg.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpLclaimGradetgDto prpLclaimGradetgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimGradetgDto prpLclaimGradetgDto) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        //更新记录
        dbPrpLclaimGradetg.update(prpLclaimGradetgDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param userCode 员工代码
     * @param taskCode 任务代码
     * @return prpLclaimGradetgDto prpLclaimGradetgDto
     * @throws Exception
     */
    public PrpLclaimGradetgDto findByPrimaryKey(DBManager dbManager,String userCode,String taskCode,String configPara) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        //声明DTO
        PrpLclaimGradetgDto prpLclaimGradetgDto = null;
        //查询数据,赋值给DTO
        prpLclaimGradetgDto = dbPrpLclaimGradetg.findByPrimaryKey(userCode, taskCode,configPara);
        return prpLclaimGradetgDto;
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
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimGradetg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimGradetg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpLclaimGradetgDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimGradetg.findByConditions(conditions);
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
        DBPrpLclaimGradetg dbPrpLclaimGradetg = new DBPrpLclaimGradetg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimGradetg.getCount(conditions);
        return count;
    }
}

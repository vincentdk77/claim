package com.sinosoft.function.power.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.power.dto.domain.PrpUserGradeDto;
import com.sinosoft.function.power.resource.dtofactory.domain.DBPrpUserGrade;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpUserGrade 员工权限表的业务逻辑对象类<br>
 * 创建于 2004-11-09 10:40:54.658<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpUserGradeActionBase{
    private static Log logger = LogFactory.getLog(BLPrpUserGradeActionBase.class);

    /**
     * 构造函数
     */
    public BLPrpUserGradeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpUserGradeDto prpUserGradeDto) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //插入记录
        dbPrpUserGrade.insert(prpUserGradeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param userCode 员工代码
     * @param groupCode 权限组号代码
     * @param taskCode 任务代码
     * @param checkCode 权限检验代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //删除记录
        dbPrpUserGrade.delete(userCode, groupCode, taskCode, checkCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //按条件删除记录
        dbPrpUserGrade.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpUserGradeDto prpUserGradeDto) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //更新记录
        dbPrpUserGrade.update(prpUserGradeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param userCode 员工代码
     * @param groupCode 权限组号代码
     * @param taskCode 任务代码
     * @param checkCode 权限检验代码
     * @return prpUserGradeDto prpUserGradeDto
     * @throws Exception
     */
    public PrpUserGradeDto findByPrimaryKey(DBManager dbManager,String userCode,String groupCode,String taskCode,String checkCode) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        //声明DTO
        PrpUserGradeDto prpUserGradeDto = null;
        //查询数据,赋值给DTO
        prpUserGradeDto = dbPrpUserGrade.findByPrimaryKey(userCode, groupCode, taskCode, checkCode);
        return prpUserGradeDto;
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
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpUserGrade.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpUserGrade.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含prpUserGradeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpUserGrade.findByConditions(conditions);
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
        DBPrpUserGrade dbPrpUserGrade = new DBPrpUserGrade(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpUserGrade.getCount(conditions);
        return count;
    }
}

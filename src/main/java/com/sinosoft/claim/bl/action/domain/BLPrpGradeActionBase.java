package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGradeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpGrade;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgrade岗位定义表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGradeActionBase{
    private static Log log = LogFactory.getLog(BLPrpGradeActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpGradeActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpGradeDto prpGradeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGradeDto prpGradeDto) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        //插入记录
        dbPrpGrade.insert(prpGradeDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param gradeCode 岗位代码
     * @throws Exception
     */
    public void delete(DBManager dbManager,String gradeCode) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        //删除记录
        dbPrpGrade.delete(gradeCode);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        //按条件删除记录
        dbPrpGrade.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpGradeDto prpGradeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGradeDto prpGradeDto) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        //更新记录
        dbPrpGrade.update(prpGradeDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param gradeCode 岗位代码
     * @return prpGradeDto prpGradeDto
     * @throws Exception
     */
    public PrpGradeDto findByPrimaryKey(DBManager dbManager,String gradeCode) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        //声明DTO
        PrpGradeDto prpGradeDto = null;
        //查询数据,赋值给DTO
        prpGradeDto = dbPrpGrade.findByPrimaryKey(gradeCode);
        return prpGradeDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpGradeDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpGrade.getCount(conditions);
        collection = dbPrpGrade.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * 必须在findByConditions后调用,返回findByConditions查询到的记录数
     * @return 记录数
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param dbManager DB管理器
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpGrade dbPrpGrade = new DBPrpGrade(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGrade.getCount(conditions);
        return count;
    }
}

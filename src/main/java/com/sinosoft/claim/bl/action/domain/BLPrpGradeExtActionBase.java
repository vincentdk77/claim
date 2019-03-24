package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGradeExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpGradeExt;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpgradeext岗位扩展表的业务逻辑对象类<br>
 * 创建于 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpGradeExtActionBase{
    private static Log log = LogFactory.getLog(BLPrpGradeExtActionBase.class.getName());
    private int rowCount; //findByConditions查询到的记录数

    /**
     * 构造函数
     */
    public BLPrpGradeExtActionBase(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param prpGradeExtDto prpGradeExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpGradeExtDto prpGradeExtDto) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        //插入记录
        dbPrpGradeExt.insert(prpGradeExtDto);
    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param gradeCode 岗位代码
     * @param riskCode 险种代码
     * @param currency 币别
     * @throws Exception
     */
    public void delete(DBManager dbManager,String gradeCode,String riskCode,String currency) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        //删除记录
        dbPrpGradeExt.delete(gradeCode, riskCode, currency);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param condtions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        //按条件删除记录
        dbPrpGradeExt.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param prpGradeExtDto prpGradeExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpGradeExtDto prpGradeExtDto) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        //更新记录
        dbPrpGradeExt.update(prpGradeExtDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param gradeCode 岗位代码
     * @param riskCode 险种代码
     * @param currency 币别
     * @return prpGradeExtDto prpGradeExtDto
     * @throws Exception
     */
    public PrpGradeExtDto findByPrimaryKey(DBManager dbManager,String gradeCode,String riskCode,String currency) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        //声明DTO
        PrpGradeExtDto prpGradeExtDto = null;
        //查询数据,赋值给DTO
        prpGradeExtDto = dbPrpGradeExt.findByPrimaryKey(gradeCode, riskCode, currency);
        return prpGradeExtDto;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection 包含prpGradeExtDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpGradeExt.getCount(conditions);
        collection = dbPrpGradeExt.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpGradeExt dbPrpGradeExt = new DBPrpGradeExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpGradeExt.getCount(conditions);
        return count;
    }
}

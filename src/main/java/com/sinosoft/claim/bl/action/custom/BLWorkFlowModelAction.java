package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.WorkFlowModelDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBWorkFlowModel;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是WorkFlowModel工作流模板的业务逻辑对象类<br>
 * 创建于 2004-08-09 19:54:54.996<br>
 * JToolpad(1.2.12-RC10) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLWorkFlowModelAction{
    private static Log logger = LogFactory.getLog(BLWorkFlowModelAction.class);

    /**
     * 构造函数
     */
    public BLWorkFlowModelAction(){
    }

    /**
     * 插入一条数据
     * @param dbManager DB管理器
     * @param workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,WorkFlowModelDto workFlowModelDto) throws Exception{
      DBWorkFlowModel dbWorkFlowModel = null;
      //业务操作
      dbWorkFlowModel = new DBWorkFlowModel();

     //如果是新增加或者修改那么用insert
       dbWorkFlowModel.insert(dbManager,workFlowModelDto);

    }

    /**
     * 按主键删除一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编码
     * @param pathNo 流程边编码
     * @param conditionNo 条件编码
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        //删除记录
       // dbWorkFlowModel.delete(conditionNo, serialNo);
    }

    /**
     * 按条件删除数据
     * @param dbManager DB管理器
     * @param conditions 删除条件
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        //按条件删除记录
        //dbWorkFlowModel.deleteByConditions(conditions);
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param dbManager DB管理器
     * @param workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public void update(DBManager dbManager,WorkFlowModelDto workFlowModelDto) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        //更新记录
        //dbWorkFlowModel.update(workFlowModelDto);
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编码
     * @param pathNo 流程边编码
     * @param conditionNo 条件编码
     * @param serialNo 序号
     * @return workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public WorkFlowModelDto findByPrimaryKey(DBManager dbManager,int modelNo,int pathNo,int conditionNo,int serialNo) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        //声明DTO
        WorkFlowModelDto workFlowModelDto = null;
        //查询数据,赋值给DTO
        //workFlowModelDto = dbWorkFlowModel.findByPrimaryKey(modelNo, pathNo, conditionNo, serialNo);
        return workFlowModelDto;
    }

    /**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param modelNo 模板编码
     * @return workFlowModelDto workFlowModelDto
     * @throws Exception
     */
    public WorkFlowModelDto findByPrimaryKey(DBManager dbManager,int modelNo) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        //声明DTO
        WorkFlowModelDto workFlowModelDto = null;
        //查询数据,赋值给DTO
        workFlowModelDto = dbWorkFlowModel.findByPrimaryKey(dbManager,modelNo);
        return workFlowModelDto;
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
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

       // int count = dbWorkFlowModel.getCount(SqlUtils.getWherePartForGetCount(conditions));
       // collection = dbWorkFlowModel.findByConditions(conditions,pageNo,rowsPerPage);
       // PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);

       PageRecord pageRecord = new PageRecord(0,pageNo,1,rowsPerPage,collection);
       return pageRecord;
    }

    /**
     * 按条件查询多条数据
     * @param dbManager DB管理器
     * @param conditions 查询条件
     * @return Collection 包含workFlowModelDto的集合
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

     //   collection = dbWorkFlowModel.findByConditions(conditions,0,0);
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
        DBWorkFlowModel dbWorkFlowModel = new DBWorkFlowModel();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }
       int count=0;
       // int count = dbWorkFlowModel.getCount(conditions);
        return count;
    }

/**
 * 取modelNo号
 * @param dbManager  数据连接
 * @return modelNo
 * @throws SQLException
 * @throws Exception
 */
public int getModelNo(DBManager dbManager)throws SQLException,Exception
{
  DBWorkFlowModel dbWorkFlowModel= new DBWorkFlowModel();
  int modelNo=-1;
  modelNo= dbWorkFlowModel.getModelNo(dbManager) ;
  return modelNo;
}

}

package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.UtiPrtParDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是utiprtpar的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBUtiPrtParBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBUtiPrtParBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBUtiPrtParBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param utiPrtParDto utiPrtParDto
     * @throws Exception
     */
    public void insert(UtiPrtParDto utiPrtParDto) throws Exception{
        String statement = " Insert Into UtiPrtPar(" + 
                           " FileName," + 
                           " LabelNo," + 
                           " Xpos," + 
                           " Ypos," + 
                           " Len) values(?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,utiPrtParDto.getFileName());
        dbManager.setString(2,utiPrtParDto.getLabelNo());
        dbManager.setInt(3,utiPrtParDto.getXpos());
        dbManager.setInt(4,utiPrtParDto.getYpos());
        dbManager.setInt(5,utiPrtParDto.getLen());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPrtParBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            UtiPrtParDto utiPrtParDto = (UtiPrtParDto)i.next();
            insert(utiPrtParDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param fileName filename
     * @param labelNo labelno
     * @throws Exception
     */
    public void delete(String fileName,String labelNo) throws Exception{
        String statement = " Delete From UtiPrtPar Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,fileName);
        dbManager.setString(2,labelNo);
        dbManager.executePreparedUpdate();
        log.info("DBUtiPrtParBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param utiPrtParDto utiPrtParDto
     * @throws Exception
     */
    public void update(UtiPrtParDto utiPrtParDto) throws Exception{
        String statement = " Update UtiPrtPar Set Xpos = ?," + 
                           " Ypos = ?," + 
                           " Len = ? Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setInt(1,utiPrtParDto.getXpos());
        dbManager.setInt(2,utiPrtParDto.getYpos());
        dbManager.setInt(3,utiPrtParDto.getLen());
        //设置条件字段;
        dbManager.setString(4,utiPrtParDto.getFileName());
        dbManager.setString(5,utiPrtParDto.getLabelNo());
        dbManager.executePreparedUpdate();

        log.info("DBUtiPrtParBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param fileName filename
     * @param labelNo labelno
     * @return UtiPrtParDto
     * @throws Exception
     */
    public UtiPrtParDto findByPrimaryKey(String fileName,String labelNo) throws Exception{
        String statement = " Select FileName," + 
                           " LabelNo," + 
                           " Xpos," + 
                           " Ypos," + 
                           " Len From UtiPrtPar Where " +
                           " FileName = ? And " + 
                           " LabelNo = ?";
        UtiPrtParDto utiPrtParDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,fileName);
        dbManager.setString(2,labelNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            utiPrtParDto = new UtiPrtParDto();
            utiPrtParDto.setFileName(dbManager.getString(resultSet,1));
            utiPrtParDto.setLabelNo(dbManager.getString(resultSet,2));
            utiPrtParDto.setXpos(dbManager.getInt(resultSet,3));
            utiPrtParDto.setYpos(dbManager.getInt(resultSet,4));
            utiPrtParDto.setLen(dbManager.getInt(resultSet,5));
        }
        resultSet.close();
        log.info("DBUtiPrtParBase.findByPrimaryKey() success!");
        return utiPrtParDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select FileName," + 
                           " LabelNo," + 
                           " Xpos," + 
                           " Ypos," + 
                           " Len From UtiPrtPar Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        UtiPrtParDto utiPrtParDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            utiPrtParDto = new UtiPrtParDto();
            utiPrtParDto.setFileName(dbManager.getString(resultSet,1));
            utiPrtParDto.setLabelNo(dbManager.getString(resultSet,2));
            utiPrtParDto.setXpos(dbManager.getInt(resultSet,3));
            utiPrtParDto.setYpos(dbManager.getInt(resultSet,4));
            utiPrtParDto.setLen(dbManager.getInt(resultSet,5));
            collection.add(utiPrtParDto);
        }
        resultSet.close();
        log.info("DBUtiPrtParBase.findByConditions() success!");
        return collection;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From UtiPrtPar Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBUtiPrtParBase.deleteByConditions() success!");
        return count;
    }

    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        String statement = "Select count(*) from UtiPrtPar Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBUtiPrtParBase.getCount() success!");
        return count;
    }
}

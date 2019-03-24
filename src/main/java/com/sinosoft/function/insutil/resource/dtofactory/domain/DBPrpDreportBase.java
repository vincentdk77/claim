package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDreportDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpdreport的数据访问对象类<br>
 * 创建于 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDreportBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpDreportBase.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpDreportBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpDreportDto prpDreportDto
     * @throws Exception
     */
    public void insert(PrpDreportDto prpDreportDto) throws Exception{
        String statement = " Insert Into PrpDreport(" + 
                           " ReportCode," + 
                           " ReportName," + 
                           " SerialNo," + 
                           " LayRow," + 
                           " LayCol," + 
                           " WorkField," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDreportDto.getReportCode());
        dbManager.setString(2,prpDreportDto.getReportName());
        dbManager.setInt(3,prpDreportDto.getSerialNo());
        dbManager.setInt(4,prpDreportDto.getLayRow());
        dbManager.setInt(5,prpDreportDto.getLayCol());
        dbManager.setString(6,prpDreportDto.getWorkField());
        dbManager.setString(7,prpDreportDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDreportBase.insert() success!");
    }

    /**
     * 插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDreportDto prpDreportDto = (PrpDreportDto)i.next();
            insert(prpDreportDto);
        }
    }

    /**
     * 按主键删除一条数据
     * @param reportCode reportcode
     * @param serialNo serialno
     * @throws Exception
     */
    public void delete(String reportCode,int serialNo) throws Exception{
        String statement = " Delete From PrpDreport Where " +
                           " ReportCode = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,reportCode);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDreportBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpDreportDto prpDreportDto
     * @throws Exception
     */
    public void update(PrpDreportDto prpDreportDto) throws Exception{
        String statement = " Update PrpDreport Set ReportName = ?," + 
                           " LayRow = ?," + 
                           " LayCol = ?," + 
                           " WorkField = ?," + 
                           " Flag = ? Where " +
                           " ReportCode = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpDreportDto.getReportName());
        dbManager.setInt(2,prpDreportDto.getLayRow());
        dbManager.setInt(3,prpDreportDto.getLayCol());
        dbManager.setString(4,prpDreportDto.getWorkField());
        dbManager.setString(5,prpDreportDto.getFlag());
        //设置条件字段;
        dbManager.setString(6,prpDreportDto.getReportCode());
        dbManager.setInt(7,prpDreportDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDreportBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param reportCode reportcode
     * @param serialNo serialno
     * @return PrpDreportDto
     * @throws Exception
     */
    public PrpDreportDto findByPrimaryKey(String reportCode,int serialNo) throws Exception{
        String statement = " Select ReportCode," + 
                           " ReportName," + 
                           " SerialNo," + 
                           " LayRow," + 
                           " LayCol," + 
                           " WorkField," + 
                           " Flag From PrpDreport Where " +
                           " ReportCode = ? And " + 
                           " SerialNo = ?";
        PrpDreportDto prpDreportDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,reportCode);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDreportDto = new PrpDreportDto();
            prpDreportDto.setReportCode(dbManager.getString(resultSet,1));
            prpDreportDto.setReportName(dbManager.getString(resultSet,2));
            prpDreportDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpDreportDto.setLayRow(dbManager.getInt(resultSet,4));
            prpDreportDto.setLayCol(dbManager.getInt(resultSet,5));
            prpDreportDto.setWorkField(dbManager.getString(resultSet,6));
            prpDreportDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpDreportBase.findByPrimaryKey() success!");
        return prpDreportDto;
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
        String statement = "Select ReportCode," + 
                           " ReportName," + 
                           " SerialNo," + 
                           " LayRow," + 
                           " LayCol," + 
                           " WorkField," + 
                           " Flag From PrpDreport Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDreportDto prpDreportDto = null;
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

            prpDreportDto = new PrpDreportDto();
            prpDreportDto.setReportCode(dbManager.getString(resultSet,1));
            prpDreportDto.setReportName(dbManager.getString(resultSet,2));
            prpDreportDto.setSerialNo(dbManager.getInt(resultSet,3));
            prpDreportDto.setLayRow(dbManager.getInt(resultSet,4));
            prpDreportDto.setLayCol(dbManager.getInt(resultSet,5));
            prpDreportDto.setWorkField(dbManager.getString(resultSet,6));
            prpDreportDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpDreportDto);
        }
        resultSet.close();
        log.info("DBPrpDreportBase.findByConditions() success!");
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
        String statement = "Delete From PrpDreport Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDreportBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDreport Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDreportBase.getCount() success!");
        return count;
    }
}

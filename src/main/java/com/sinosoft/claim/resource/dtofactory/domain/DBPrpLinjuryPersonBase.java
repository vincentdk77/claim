package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLinjuryPersonDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLacciPerson的数据访问对象基类<br>
 * 创建于 2005-06-16 13:55:17.687<br>
 * JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLinjuryPersonBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLinjuryPersonBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLinjuryPersonBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLacciPersonDto prpLacciPersonDto
     * @throws Exception
     */
    public void insert(PrpLinjuryPersonDto prpLinjuryPersonDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinjuryperson(");
        buffer.append("CompensateNo,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinjuryPersonDto.getCompensateNo()).append("',");
            debugBuffer.append("'").append(prpLinjuryPersonDto.getAcciName()).append("',");
            debugBuffer.append("'").append(prpLinjuryPersonDto.getSex()).append("',");
            debugBuffer.append("'").append(prpLinjuryPersonDto.getIdentifyNumber()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinjuryPersonDto.getCompensateNo());
        dbManager.setString(2,prpLinjuryPersonDto.getAcciName());
        dbManager.setString(3,prpLinjuryPersonDto.getSex());
        dbManager.setString(4,prpLinjuryPersonDto.getIdentifyNumber());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinjuryperson (");
        buffer.append("CompensateNo,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
        	PrpLinjuryPersonDto prpLinjuryPersonDto = (PrpLinjuryPersonDto)i.next();
            dbManager.prepareStatement(buffer.toString());
            dbManager.setString(1,prpLinjuryPersonDto.getCompensateNo());
            dbManager.setString(2,prpLinjuryPersonDto.getAcciName());
            dbManager.setString(3,prpLinjuryPersonDto.getSex());
            dbManager.setString(4,prpLinjuryPersonDto.getIdentifyNumber());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param certiNo CertiNo
     * @param certiType CertiType
     * @param serialNo SerialNo
     * @throws Exception
     */
    public void delete(String CompensateNo) throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinjuryperson ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(CompensateNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ? ");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,CompensateNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLacciPersonDto prpLacciPersonDto
     * @throws Exception
     */
    public void update(PrpLinjuryPersonDto prpLinjuryPersonDto) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinjuryperson SET ");
        buffer.append("AcciName = ?, ");
        buffer.append("Sex = ?, ");
        buffer.append("IdentifyNumber = ?,");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(prpLinjuryPersonDto.getAcciName()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpLinjuryPersonDto.getAcciName());
        dbManager.setString(2,prpLinjuryPersonDto.getSex());
        dbManager.setString(3,prpLinjuryPersonDto.getIdentifyNumber());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param certiNo CertiNo
     * @param certiType CertiType
     * @param serialNo SerialNo
     * @return PrpLacciPersonDto
     * @throws Exception
     */
    public PrpLinjuryPersonDto findByPrimaryKey(String CompensateNo) throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("CompensateNo,");
        buffer.append("AcciName,");
        buffer.append("Sex,");
        buffer.append("IdentifyNumber");
        buffer.append(" FROM PrpLinjuryperson ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("CompensateNo=").append("'").append(CompensateNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("CompensateNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,CompensateNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinjuryPersonDto prpLinjuryPersonDto = null;
        if(resultSet.next()){
        	prpLinjuryPersonDto = new PrpLinjuryPersonDto();
        	prpLinjuryPersonDto.setCompensateNo(dbManager.getString(resultSet,1));
        	prpLinjuryPersonDto.setAcciName(dbManager.getString(resultSet,2));
        	prpLinjuryPersonDto.setSex(dbManager.getString(resultSet,3));
        	prpLinjuryPersonDto.setIdentifyNumber(dbManager.getString(resultSet,4));
            
        }else{
            logger.info("DBPrpLinjuryPersonBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLinjuryPersonDto;
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
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append(" CompensateNo,");
        buffer.append(" AcciName,");
        buffer.append(" decode(Sex,'1','男','2','女','未知') Sex,");
        buffer.append(" IdentifyNumber ");
        buffer.append(" FROM PrpLinjuryperson WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrpLinjuryPersonDto prpLinjuryPersonDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLinjuryPersonDto = new PrpLinjuryPersonDto();
            prpLinjuryPersonDto.setCompensateNo(dbManager.getString(resultSet,1));
            prpLinjuryPersonDto.setAcciName(dbManager.getString(resultSet,2));
            prpLinjuryPersonDto.setSex(dbManager.getString(resultSet,3));
            prpLinjuryPersonDto.setIdentifyNumber(dbManager.getString(resultSet,4));
            collection.add(prpLinjuryPersonDto);
        }
        resultSet.close();
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
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinjuryperson WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
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
        StringBuffer buffer = new StringBuffer(100);
        String  statement ;
        statement = "SELECT count(1) FROM PrpLinjuryperson WHERE ";
        statement = SqlUtils.getWherePartForGetCount(statement);
        buffer.append(statement);
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        return count;
    }
    
    /**
     * 集合删除
     * @param collection collection
     * @throws Exception
     */
    public void deleteAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinjuryPersonDto prpLinjuryPersonDto = (PrpLinjuryPersonDto)i.next();
            StringBuffer buffer = new StringBuffer(200);
            buffer.append("DELETE FROM PrpLinjuryperson ");
            //设置条件字段;
            buffer.append("WHERE ");
            buffer.append("CompensateNo = ?");
     
            dbManager.prepareStatement(buffer.toString());
            //设置条件字段;
            dbManager.setString(1,prpLinjuryPersonDto.getCompensateNo());
            dbManager.setString(2,prpLinjuryPersonDto.getAcciName());
            dbManager.setString(3,prpLinjuryPersonDto.getSex());
            dbManager.setString(4,prpLinjuryPersonDto.getIdentifyNumber());
            dbManager.executePreparedUpdate();

        }
    }
    
}
    
    


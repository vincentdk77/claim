package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLassureDetailDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是PrpLassureDetail-担保函明细（船舶）的数据访问对象基类<br>
 * 创建于 2005-03-18 17:53:36.937<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class DBPrpLassureDetailBase{
    protected DBManager dbManager = null; //资源管理类
    private static Log logger = LogFactory.getLog(DBPrpLassureDetailBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLassureDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public void insert(PrpLassureDetailDto prpLassureDetailDto) throws Exception{
        String mainStatement = " Insert Into PrpLassureDetail (" + 
                           " AssureNo," + 
                           " SerialNo," + 
                           " PolicyNo," + 
                           " LadingNo," + 
                           " GoodsDetailName," + 
                           " Marks," + 
                           " Count," + 
                           " Currency," + 
                           " Amount)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?)";
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " values(" + 
                           "'" + prpLassureDetailDto.getAssureNo() + "'," + 
                           "" + prpLassureDetailDto.getSerialNo() + "," + 
                           "'" + prpLassureDetailDto.getPolicyNo() + "'," + 
                           "'" + prpLassureDetailDto.getLadingNo() + "'," + 
                           "'" + prpLassureDetailDto.getGoodsDetailName() + "'," + 
                           "'" + prpLassureDetailDto.getMarks() + "'," + 
                           "'" + prpLassureDetailDto.getCount() + "'," + 
                           "'" + prpLassureDetailDto.getCurrency() + "'," + 
                           "'" + prpLassureDetailDto.getAmount() + "')";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLassureDetailDto.getAssureNo());
        dbManager.setInt(2,prpLassureDetailDto.getSerialNo());
        dbManager.setString(3,prpLassureDetailDto.getPolicyNo());
        dbManager.setString(4,prpLassureDetailDto.getLadingNo());
        dbManager.setString(5,prpLassureDetailDto.getGoodsDetailName());
        dbManager.setString(6,prpLassureDetailDto.getMarks());
        dbManager.setString(7,prpLassureDetailDto.getCount());
        dbManager.setString(8,prpLassureDetailDto.getCurrency());
        dbManager.setDouble(9,prpLassureDetailDto.getAmount());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLassureDetailBase.insert() success!");
    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        String mainStatement = " Insert Into PrpLassureDetail (" + 
                           " AssureNo," + 
                           " SerialNo," + 
                           " PolicyNo," + 
                           " LadingNo," + 
                           " GoodsDetailName," + 
                           " Marks," + 
                           " Count," + 
                           " Currency," + 
                           " Amount)";
        String statement = mainStatement + " values(?,?,?,?,?,?,?,?,?)";
        logger.debug(statement);
        dbManager.prepareStatement(statement);
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLassureDetailDto prpLassureDetailDto = (PrpLassureDetailDto)i.next();
            dbManager.setString(1,prpLassureDetailDto.getAssureNo());
            dbManager.setInt(2,prpLassureDetailDto.getSerialNo());
            dbManager.setString(3,prpLassureDetailDto.getPolicyNo());
            dbManager.setString(4,prpLassureDetailDto.getLadingNo());
            dbManager.setString(5,prpLassureDetailDto.getGoodsDetailName());
            dbManager.setString(6,prpLassureDetailDto.getMarks());
            dbManager.setString(7,prpLassureDetailDto.getCount());
            dbManager.setString(8,prpLassureDetailDto.getCurrency());
            dbManager.setDouble(9,prpLassureDetailDto.getAmount());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
        logger.info("DBPrpLassureDetailBase.insertAll() success!");
    }

    /**
     * 按主键删除一条数据
     * @param assureNo 担保号
     * @param serialNo 序号
     * @throws Exception
     */
    public void delete(String assureNo,int serialNo) throws Exception{
        String statement = " Delete From PrpLassureDetail" + 
	            		   " Where " +
                           " AssureNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Delete From PrpLassureDetail Where " +
                           " AssureNo = '" + assureNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,assureNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
        logger.info("DBPrpLassureDetailBase.delete() success!");
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpLassureDetailDto prpLassureDetailDto
     * @throws Exception
     */
    public void update(PrpLassureDetailDto prpLassureDetailDto) throws Exception{
        String statement = " Update PrpLassureDetail Set PolicyNo = ?," + 
                           " LadingNo = ?," + 
                           " GoodsDetailName = ?," + 
                           " Marks = ?," + 
                           " Count = ?," + 
                           " Currency = ?," + 
                           " Amount = ?" + 
	            		   " Where " +
                           " AssureNo = ? And " + 
                           " SerialNo = ?";
        if(logger.isDebugEnabled()){
            String debugStatement = "Update PrpLassureDetail Set " + 
                           " AssureNo = '" + prpLassureDetailDto.getAssureNo() + "'," + 
                           " SerialNo = " + prpLassureDetailDto.getSerialNo() + "," + 
                           " PolicyNo = '" + prpLassureDetailDto.getPolicyNo() + "'," + 
                           " LadingNo = '" + prpLassureDetailDto.getLadingNo() + "'," + 
                           " GoodsDetailName = '" + prpLassureDetailDto.getGoodsDetailName() + "'," + 
                           " Marks = '" + prpLassureDetailDto.getMarks() + "'," + 
                           " Count = '" + prpLassureDetailDto.getCount() + "'," + 
                           " Currency = '" + prpLassureDetailDto.getCurrency() + "'," + 
                           " Amount = '" + prpLassureDetailDto.getAmount() + "'" + 
			               " Where " +
                           " AssureNo = '" + prpLassureDetailDto.getAssureNo() + "' And " + 
                           " SerialNo = " + prpLassureDetailDto.getSerialNo() + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置更新字段;
        dbManager.setString(1,prpLassureDetailDto.getPolicyNo());
        dbManager.setString(2,prpLassureDetailDto.getLadingNo());
        dbManager.setString(3,prpLassureDetailDto.getGoodsDetailName());
        dbManager.setString(4,prpLassureDetailDto.getMarks());
        dbManager.setString(5,prpLassureDetailDto.getCount());
        dbManager.setString(6,prpLassureDetailDto.getCurrency());
        dbManager.setDouble(7,prpLassureDetailDto.getAmount());
        //设置条件字段;
        dbManager.setString(8,prpLassureDetailDto.getAssureNo());
        dbManager.setInt(9,prpLassureDetailDto.getSerialNo());
        dbManager.executePreparedUpdate();

        logger.info("DBPrpLassureDetailBase.update() success!");
    }

    /**
     * 按主键查找一条数据
     * @param assureNo 担保号
     * @param serialNo 序号
     * @return PrpLassureDetailDto
     * @throws Exception
     */
    public PrpLassureDetailDto findByPrimaryKey(String assureNo,int serialNo) throws Exception{
        String mainStatement = " Select AssureNo," + 
                           " SerialNo," + 
                           " PolicyNo," + 
                           " LadingNo," + 
                           " GoodsDetailName," + 
                           " Marks," + 
                           " Count," + 
                           " Currency," + 
                           " Amount From PrpLassureDetail";
        String statement = mainStatement + " Where " +
                           " AssureNo = ? And " + 
                           " SerialNo = ?";
        PrpLassureDetailDto prpLassureDetailDto = null;
        if(logger.isDebugEnabled()){
            String debugStatement = mainStatement + " Where " +
                           " AssureNo = '" + assureNo + "' And " + 
                           " SerialNo = " + serialNo + "";
            logger.debug(debugStatement);
        }

        dbManager.prepareStatement(statement);
        //设置条件字段;
        dbManager.setString(1,assureNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLassureDetailDto = new PrpLassureDetailDto();
            prpLassureDetailDto.setAssureNo(dbManager.getString(resultSet,1));
            prpLassureDetailDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLassureDetailDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLassureDetailDto.setLadingNo(dbManager.getString(resultSet,4));
            prpLassureDetailDto.setGoodsDetailName(dbManager.getString(resultSet,5));
            prpLassureDetailDto.setMarks(dbManager.getString(resultSet,6));
            prpLassureDetailDto.setCount(dbManager.getString(resultSet,7));
            prpLassureDetailDto.setCurrency(dbManager.getString(resultSet,8));
            prpLassureDetailDto.setAmount(dbManager.getDouble(resultSet,9));
            logger.info("DBPrpLassureDetailBase.findByPrimaryKey() success!");
        }else{
            logger.info("DBPrpLassureDetailBase.findByPrimaryKey() failure!");
        }
        resultSet.close();
        return prpLassureDetailDto;
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
        String statement = "Select AssureNo," + 
                           " SerialNo," + 
                           " PolicyNo," + 
                           " LadingNo," + 
                           " GoodsDetailName," + 
                           " Marks," + 
                           " Count," + 
                           " Currency," + 
                           " Amount From PrpLassureDetail Where " + conditions;
        logger.debug(statement);
        Collection collection = new ArrayList();
        PrpLassureDetailDto prpLassureDetailDto = null;
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

            prpLassureDetailDto = new PrpLassureDetailDto();
            prpLassureDetailDto.setAssureNo(dbManager.getString(resultSet,1));
            prpLassureDetailDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLassureDetailDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLassureDetailDto.setLadingNo(dbManager.getString(resultSet,4));
            prpLassureDetailDto.setGoodsDetailName(dbManager.getString(resultSet,5));
            prpLassureDetailDto.setMarks(dbManager.getString(resultSet,6));
            prpLassureDetailDto.setCount(dbManager.getString(resultSet,7));
            prpLassureDetailDto.setCurrency(dbManager.getString(resultSet,8));
            prpLassureDetailDto.setAmount(dbManager.getDouble(resultSet,9));
            collection.add(prpLassureDetailDto);
        }
        resultSet.close();
        logger.info("DBPrpLassureDetailBase.findByConditions() success!");
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
        String statement = "Delete From PrpLassureDetail Where " + conditions;
        logger.debug(statement);
        int count = dbManager.executeUpdate(statement);
        logger.info("DBPrpLassureDetailBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpLassureDetail Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        logger.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        logger.info("DBPrpLassureDetailBase.getCount() success!");
        return count;
    }
}

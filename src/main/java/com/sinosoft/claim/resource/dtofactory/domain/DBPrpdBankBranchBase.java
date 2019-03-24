package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpdBankBranchDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpdBankBranch的数据访问对象基类<br>
 * 创建于 2018-01-26 15:40:08.031<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpdBankBranchBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpdBankBranchBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpdBankBranchBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prpdBankBranchDto prpdBankBranchDto
     * @throws Exception
     */
    public void insert(PrpdBankBranchDto prpdBankBranchDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpdBankBranch (");
        buffer.append("bank_number,");
        buffer.append("bank_name,");
        buffer.append("bank_type_code,");
        buffer.append("bank_type_name,");
        buffer.append("bank_clear_code,");
        buffer.append("cpcc,");
        buffer.append("prov_code,");
        buffer.append("bank_clear_name,");
        buffer.append("prov_name,");
        buffer.append("created_by,");
        buffer.append("creation_date,");
        buffer.append("last_update_by,");
        buffer.append("last_update_date,");
        buffer.append("belong_bank_value,");
        buffer.append("belong_bank_name,");
        buffer.append("id,");
        buffer.append("city_code,");
        buffer.append("city_name,");
        buffer.append("head_bank_flag,");
        buffer.append("detail_bank_code,");
        buffer.append("detal_bank_code,");
        buffer.append("detal_bank_name,");
        buffer.append("routing_number,");
        buffer.append("country ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpdBankBranchDto.getBank_number()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getBank_name()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getBank_type_code()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getBank_type_name()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getBank_clear_code()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getCpcc()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getProv_code()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getBank_clear_name()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getProv_name()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getCreated_by()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getCreation_date()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getLast_update_by()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getLast_update_date()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getBelong_bank_value()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getBelong_bank_name()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getId()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getCity_code()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getCity_name()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getHead_bank_flag()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getDetail_bank_code()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getDetal_bank_code()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getDetal_bank_name()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getRouting_number()).append("',");
            debugBuffer.append("'").append(prpdBankBranchDto.getCountry()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpdBankBranchDto.getBank_number());
        dbManager.setString(2,prpdBankBranchDto.getBank_name());
        dbManager.setString(3,prpdBankBranchDto.getBank_type_code());
        dbManager.setString(4,prpdBankBranchDto.getBank_type_name());
        dbManager.setString(5,prpdBankBranchDto.getBank_clear_code());
        dbManager.setString(6,prpdBankBranchDto.getCpcc());
        dbManager.setString(7,prpdBankBranchDto.getProv_code());
        dbManager.setString(8,prpdBankBranchDto.getBank_clear_name());
        dbManager.setString(9,prpdBankBranchDto.getProv_name());
        dbManager.setString(10,prpdBankBranchDto.getCreated_by());
        dbManager.setString(11,prpdBankBranchDto.getCreation_date());
        dbManager.setString(12,prpdBankBranchDto.getLast_update_by());
        dbManager.setString(13,prpdBankBranchDto.getLast_update_date());
        dbManager.setString(14,prpdBankBranchDto.getBelong_bank_value());
        dbManager.setString(15,prpdBankBranchDto.getBelong_bank_name());
        dbManager.setString(16,prpdBankBranchDto.getId());
        dbManager.setString(17,prpdBankBranchDto.getCity_code());
        dbManager.setString(18,prpdBankBranchDto.getCity_name());
        dbManager.setString(19,prpdBankBranchDto.getHead_bank_flag());
        dbManager.setString(20,prpdBankBranchDto.getDetail_bank_code());
        dbManager.setString(21,prpdBankBranchDto.getDetal_bank_code());
        dbManager.setString(22,prpdBankBranchDto.getDetal_bank_name());
        dbManager.setString(23,prpdBankBranchDto.getRouting_number());
        dbManager.setString(24,prpdBankBranchDto.getCountry());
        dbManager.executePreparedUpdate();

    }

    /**
     * 采用批方式插入多条数据
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpdBankBranch (");
        buffer.append("bank_number,");
        buffer.append("bank_name,");
        buffer.append("bank_type_code,");
        buffer.append("bank_type_name,");
        buffer.append("bank_clear_code,");
        buffer.append("cpcc,");
        buffer.append("prov_code,");
        buffer.append("bank_clear_name,");
        buffer.append("prov_name,");
        buffer.append("created_by,");
        buffer.append("creation_date,");
        buffer.append("last_update_by,");
        buffer.append("last_update_date,");
        buffer.append("belong_bank_value,");
        buffer.append("belong_bank_name,");
        buffer.append("id,");
        buffer.append("city_code,");
        buffer.append("city_name,");
        buffer.append("head_bank_flag,");
        buffer.append("detail_bank_code,");
        buffer.append("detal_bank_code,");
        buffer.append("detal_bank_name,");
        buffer.append("routing_number,");
        buffer.append("country ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpdBankBranchDto prpdBankBranchDto = (PrpdBankBranchDto)i.next();
            dbManager.setString(1,prpdBankBranchDto.getBank_number());
            dbManager.setString(2,prpdBankBranchDto.getBank_name());
            dbManager.setString(3,prpdBankBranchDto.getBank_type_code());
            dbManager.setString(4,prpdBankBranchDto.getBank_type_name());
            dbManager.setString(5,prpdBankBranchDto.getBank_clear_code());
            dbManager.setString(6,prpdBankBranchDto.getCpcc());
            dbManager.setString(7,prpdBankBranchDto.getProv_code());
            dbManager.setString(8,prpdBankBranchDto.getBank_clear_name());
            dbManager.setString(9,prpdBankBranchDto.getProv_name());
            dbManager.setString(10,prpdBankBranchDto.getCreated_by());
            dbManager.setString(11,prpdBankBranchDto.getCreation_date());
            dbManager.setString(12,prpdBankBranchDto.getLast_update_by());
            dbManager.setString(13,prpdBankBranchDto.getLast_update_date());
            dbManager.setString(14,prpdBankBranchDto.getBelong_bank_value());
            dbManager.setString(15,prpdBankBranchDto.getBelong_bank_name());
            dbManager.setString(16,prpdBankBranchDto.getId());
            dbManager.setString(17,prpdBankBranchDto.getCity_code());
            dbManager.setString(18,prpdBankBranchDto.getCity_name());
            dbManager.setString(19,prpdBankBranchDto.getHead_bank_flag());
            dbManager.setString(20,prpdBankBranchDto.getDetail_bank_code());
            dbManager.setString(21,prpdBankBranchDto.getDetal_bank_code());
            dbManager.setString(22,prpdBankBranchDto.getDetal_bank_name());
            dbManager.setString(23,prpdBankBranchDto.getRouting_number());
            dbManager.setString(24,prpdBankBranchDto.getCountry());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param bank_number bank_number
     * @throws Exception
     */
    public void delete(String bank_number)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpdBankBranch ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("bank_number=").append("'").append(bank_number).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("bank_number = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,bank_number);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prpdBankBranchDto prpdBankBranchDto
     * @throws Exception
     */
    public void update(PrpdBankBranchDto prpdBankBranchDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpdBankBranch SET ");
        buffer.append("bank_name = ?, ");
        buffer.append("bank_type_code = ?, ");
        buffer.append("bank_type_name = ?, ");
        buffer.append("bank_clear_code = ?, ");
        buffer.append("cpcc = ?, ");
        buffer.append("prov_code = ?, ");
        buffer.append("bank_clear_name = ?, ");
        buffer.append("prov_name = ?, ");
        buffer.append("created_by = ?, ");
        buffer.append("creation_date = ?, ");
        buffer.append("last_update_by = ?, ");
        buffer.append("last_update_date = ?, ");
        buffer.append("belong_bank_value = ?, ");
        buffer.append("belong_bank_name = ?, ");
        buffer.append("id = ?, ");
        buffer.append("city_code = ?, ");
        buffer.append("city_name = ?, ");
        buffer.append("head_bank_flag = ?, ");
        buffer.append("detail_bank_code = ?, ");
        buffer.append("detal_bank_code = ?, ");
        buffer.append("detal_bank_name = ?, ");
        buffer.append("routing_number = ?, ");
        buffer.append("country = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpdBankBranch SET ");
            debugBuffer.append("bank_name = '" + prpdBankBranchDto.getBank_name() + "', ");
            debugBuffer.append("bank_type_code = '" + prpdBankBranchDto.getBank_type_code() + "', ");
            debugBuffer.append("bank_type_name = '" + prpdBankBranchDto.getBank_type_name() + "', ");
            debugBuffer.append("bank_clear_code = '" + prpdBankBranchDto.getBank_clear_code() + "', ");
            debugBuffer.append("cpcc = '" + prpdBankBranchDto.getCpcc() + "', ");
            debugBuffer.append("prov_code = '" + prpdBankBranchDto.getProv_code() + "', ");
            debugBuffer.append("bank_clear_name = '" + prpdBankBranchDto.getBank_clear_name() + "', ");
            debugBuffer.append("prov_name = '" + prpdBankBranchDto.getProv_name() + "', ");
            debugBuffer.append("created_by = '" + prpdBankBranchDto.getCreated_by() + "', ");
            debugBuffer.append("creation_date = '" + prpdBankBranchDto.getCreation_date() + "', ");
            debugBuffer.append("last_update_by = '" + prpdBankBranchDto.getLast_update_by() + "', ");
            debugBuffer.append("last_update_date = '" + prpdBankBranchDto.getLast_update_date() + "', ");
            debugBuffer.append("belong_bank_value = '" + prpdBankBranchDto.getBelong_bank_value() + "', ");
            debugBuffer.append("belong_bank_name = '" + prpdBankBranchDto.getBelong_bank_name() + "', ");
            debugBuffer.append("id = '" + prpdBankBranchDto.getId() + "', ");
            debugBuffer.append("city_code = '" + prpdBankBranchDto.getCity_code() + "', ");
            debugBuffer.append("city_name = '" + prpdBankBranchDto.getCity_name() + "', ");
            debugBuffer.append("head_bank_flag = '" + prpdBankBranchDto.getHead_bank_flag() + "', ");
            debugBuffer.append("detail_bank_code = '" + prpdBankBranchDto.getDetail_bank_code() + "', ");
            debugBuffer.append("detal_bank_code = '" + prpdBankBranchDto.getDetal_bank_code() + "', ");
            debugBuffer.append("detal_bank_name = '" + prpdBankBranchDto.getDetal_bank_name() + "', ");
            debugBuffer.append("routing_number = '" + prpdBankBranchDto.getRouting_number() + "', ");
            debugBuffer.append("country = '" + prpdBankBranchDto.getCountry() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("bank_number=").append("'").append(prpdBankBranchDto.getBank_number()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("bank_number = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prpdBankBranchDto.getBank_name());
        dbManager.setString(2,prpdBankBranchDto.getBank_type_code());
        dbManager.setString(3,prpdBankBranchDto.getBank_type_name());
        dbManager.setString(4,prpdBankBranchDto.getBank_clear_code());
        dbManager.setString(5,prpdBankBranchDto.getCpcc());
        dbManager.setString(6,prpdBankBranchDto.getProv_code());
        dbManager.setString(7,prpdBankBranchDto.getBank_clear_name());
        dbManager.setString(8,prpdBankBranchDto.getProv_name());
        dbManager.setString(9,prpdBankBranchDto.getCreated_by());
        dbManager.setString(10,prpdBankBranchDto.getCreation_date());
        dbManager.setString(11,prpdBankBranchDto.getLast_update_by());
        dbManager.setString(12,prpdBankBranchDto.getLast_update_date());
        dbManager.setString(13,prpdBankBranchDto.getBelong_bank_value());
        dbManager.setString(14,prpdBankBranchDto.getBelong_bank_name());
        dbManager.setString(15,prpdBankBranchDto.getId());
        dbManager.setString(16,prpdBankBranchDto.getCity_code());
        dbManager.setString(17,prpdBankBranchDto.getCity_name());
        dbManager.setString(18,prpdBankBranchDto.getHead_bank_flag());
        dbManager.setString(19,prpdBankBranchDto.getDetail_bank_code());
        dbManager.setString(20,prpdBankBranchDto.getDetal_bank_code());
        dbManager.setString(21,prpdBankBranchDto.getDetal_bank_name());
        dbManager.setString(22,prpdBankBranchDto.getRouting_number());
        dbManager.setString(23,prpdBankBranchDto.getCountry());
        //设置条件字段;
        dbManager.setString(24,prpdBankBranchDto.getBank_number());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param bank_number bank_number
     * @return PrpdBankBranchDto
     * @throws Exception
     */
    public PrpdBankBranchDto findByPrimaryKey(String bank_number)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("bank_number,");
        buffer.append("bank_name,");
        buffer.append("bank_type_code,");
        buffer.append("bank_type_name,");
        buffer.append("bank_clear_code,");
        buffer.append("cpcc,");
        buffer.append("prov_code,");
        buffer.append("bank_clear_name,");
        buffer.append("prov_name,");
        buffer.append("created_by,");
        buffer.append("creation_date,");
        buffer.append("last_update_by,");
        buffer.append("last_update_date,");
        buffer.append("belong_bank_value,");
        buffer.append("belong_bank_name,");
        buffer.append("id,");
        buffer.append("city_code,");
        buffer.append("city_name,");
        buffer.append("head_bank_flag,");
        buffer.append("detail_bank_code,");
        buffer.append("detal_bank_code,");
        buffer.append("detal_bank_name,");
        buffer.append("routing_number,");
        buffer.append("country ");
        buffer.append("FROM PrpdBankBranch ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("bank_number=").append("'").append(bank_number).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("bank_number = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,bank_number);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpdBankBranchDto prpdBankBranchDto = null;
        if(resultSet.next()){
            prpdBankBranchDto = new PrpdBankBranchDto();
            prpdBankBranchDto.setBank_number(dbManager.getString(resultSet,1));
            prpdBankBranchDto.setBank_name(dbManager.getString(resultSet,2));
            prpdBankBranchDto.setBank_type_code(dbManager.getString(resultSet,3));
            prpdBankBranchDto.setBank_type_name(dbManager.getString(resultSet,4));
            prpdBankBranchDto.setBank_clear_code(dbManager.getString(resultSet,5));
            prpdBankBranchDto.setCpcc(dbManager.getString(resultSet,6));
            prpdBankBranchDto.setProv_code(dbManager.getString(resultSet,7));
            prpdBankBranchDto.setBank_clear_name(dbManager.getString(resultSet,8));
            prpdBankBranchDto.setProv_name(dbManager.getString(resultSet,9));
            prpdBankBranchDto.setCreated_by(dbManager.getString(resultSet,10));
            prpdBankBranchDto.setCreation_date(dbManager.getString(resultSet,11));
            prpdBankBranchDto.setLast_update_by(dbManager.getString(resultSet,12));
            prpdBankBranchDto.setLast_update_date(dbManager.getString(resultSet,13));
            prpdBankBranchDto.setBelong_bank_value(dbManager.getString(resultSet,14));
            prpdBankBranchDto.setBelong_bank_name(dbManager.getString(resultSet,15));
            prpdBankBranchDto.setId(dbManager.getString(resultSet,16));
            prpdBankBranchDto.setCity_code(dbManager.getString(resultSet,17));
            prpdBankBranchDto.setCity_name(dbManager.getString(resultSet,18));
            prpdBankBranchDto.setHead_bank_flag(dbManager.getString(resultSet,19));
            prpdBankBranchDto.setDetail_bank_code(dbManager.getString(resultSet,20));
            prpdBankBranchDto.setDetal_bank_code(dbManager.getString(resultSet,21));
            prpdBankBranchDto.setDetal_bank_name(dbManager.getString(resultSet,22));
            prpdBankBranchDto.setRouting_number(dbManager.getString(resultSet,23));
            prpdBankBranchDto.setCountry(dbManager.getString(resultSet,24));
        }
        resultSet.close();
        return prpdBankBranchDto;
    }

    /**
     * 按条件查询多条数据
     * @param conditions 查询条件
     * @param pageNo 页号
     * @param rowsPerPage 每页的行数
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("bank_number,");
        buffer.append("bank_name,");
        buffer.append("bank_type_code,");
        buffer.append("bank_type_name,");
        buffer.append("bank_clear_code,");
        buffer.append("cpcc,");
        buffer.append("prov_code,");
        buffer.append("bank_clear_name,");
        buffer.append("prov_name,");
        buffer.append("created_by,");
        buffer.append("creation_date,");
        buffer.append("last_update_by,");
        buffer.append("last_update_date,");
        buffer.append("belong_bank_value,");
        buffer.append("belong_bank_name,");
        buffer.append("id,");
        buffer.append("city_code,");
        buffer.append("city_name,");
        buffer.append("head_bank_flag,");
        buffer.append("detail_bank_code,");
        buffer.append("detal_bank_code,");
        buffer.append("detal_bank_name,");
        buffer.append("routing_number,");
        buffer.append("country ");
        buffer.append("FROM PrpdBankBranch WHERE ");
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
        PrpdBankBranchDto prpdBankBranchDto = null;
        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                    break;
                }
            }

            prpdBankBranchDto = new PrpdBankBranchDto();
            prpdBankBranchDto.setBank_number(dbManager.getString(resultSet,1));
            prpdBankBranchDto.setBank_name(dbManager.getString(resultSet,2));
            prpdBankBranchDto.setBank_type_code(dbManager.getString(resultSet,3));
            prpdBankBranchDto.setBank_type_name(dbManager.getString(resultSet,4));
            prpdBankBranchDto.setBank_clear_code(dbManager.getString(resultSet,5));
            prpdBankBranchDto.setCpcc(dbManager.getString(resultSet,6));
            prpdBankBranchDto.setProv_code(dbManager.getString(resultSet,7));
            prpdBankBranchDto.setBank_clear_name(dbManager.getString(resultSet,8));
            prpdBankBranchDto.setProv_name(dbManager.getString(resultSet,9));
            prpdBankBranchDto.setCreated_by(dbManager.getString(resultSet,10));
            prpdBankBranchDto.setCreation_date(dbManager.getString(resultSet,11));
            prpdBankBranchDto.setLast_update_by(dbManager.getString(resultSet,12));
            prpdBankBranchDto.setLast_update_date(dbManager.getString(resultSet,13));
            prpdBankBranchDto.setBelong_bank_value(dbManager.getString(resultSet,14));
            prpdBankBranchDto.setBelong_bank_name(dbManager.getString(resultSet,15));
            prpdBankBranchDto.setId(dbManager.getString(resultSet,16));
            prpdBankBranchDto.setCity_code(dbManager.getString(resultSet,17));
            prpdBankBranchDto.setCity_name(dbManager.getString(resultSet,18));
            prpdBankBranchDto.setHead_bank_flag(dbManager.getString(resultSet,19));
            prpdBankBranchDto.setDetail_bank_code(dbManager.getString(resultSet,20));
            prpdBankBranchDto.setDetal_bank_code(dbManager.getString(resultSet,21));
            prpdBankBranchDto.setDetal_bank_name(dbManager.getString(resultSet,22));
            prpdBankBranchDto.setRouting_number(dbManager.getString(resultSet,23));
            prpdBankBranchDto.setCountry(dbManager.getString(resultSet,24));
            collection.add(prpdBankBranchDto);
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
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * 按条件删除数据
     * @param conditions 查询条件
     * @return 删除的行数
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpdBankBranch WHERE ");
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
        buffer.append("SELECT count(*) FROM PrpdBankBranch WHERE ");
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
}

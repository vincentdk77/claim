package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import java.math.*;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCOMPENSATEHOUSE的数据访问对象基类<br>
 */
public class DBPrplcompensatehouseBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplcompensatehouseBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplcompensatehouseBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public void insert(PrplcompensatehouseDto prplcompensatehouseDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplcompensatehouse (");
        buffer.append("Idcard,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Caseno,");
        buffer.append("Damagestartdate,");
        buffer.append("Damagecode,");
        buffer.append("Damagename,");
        buffer.append("Name,");
        buffer.append("Nodeno,");
        buffer.append("Nodetype,");
        buffer.append("Kindcode,");
        buffer.append("Phone,");
        buffer.append("Address,");
        buffer.append("Remark,");
        buffer.append("Hukoubu,");
        buffer.append("Estimateloss,");
        buffer.append("Businessno,");
        buffer.append("Floor,");
        buffer.append("Buildingnumber,");
        buffer.append("Zhuannumber,");
        buffer.append("Wanumber,");
        buffer.append("Kitchennumber,");
        buffer.append("Othernumber ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplcompensatehouseDto.getIdcard()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getClaimno()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getCompensateno()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getCaseno()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getDamagestartdate()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getDamagecode()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getDamagename()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getName()).append("',");
            debugBuffer.append("").append(prplcompensatehouseDto.getNodeno()).append(",");
            debugBuffer.append("'").append(prplcompensatehouseDto.getNodetype()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getKindcode()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getPhone()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getAddress()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getRemark()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getHukoubu()).append("',");
            debugBuffer.append("").append(prplcompensatehouseDto.getEstimateloss()).append(",");
            debugBuffer.append("'").append(prplcompensatehouseDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getFloor()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getBuildingnumber()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getZhuannumber()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getWanumber()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getKitchennumber()).append("',");
            debugBuffer.append("'").append(prplcompensatehouseDto.getOthernumber()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplcompensatehouseDto.getIdcard());
        dbManager.setString(2,prplcompensatehouseDto.getPolicyno());
        dbManager.setString(3,prplcompensatehouseDto.getRegistno());
        dbManager.setString(4,prplcompensatehouseDto.getClaimno());
        dbManager.setString(5,prplcompensatehouseDto.getCompensateno());
        dbManager.setString(6,prplcompensatehouseDto.getCaseno());
        dbManager.setDateTime(7,prplcompensatehouseDto.getDamagestartdate());
        dbManager.setString(8,prplcompensatehouseDto.getDamagecode());
        dbManager.setString(9,prplcompensatehouseDto.getDamagename());
        dbManager.setString(10,prplcompensatehouseDto.getName());
        dbManager.setInt(11,prplcompensatehouseDto.getNodeno());
        dbManager.setString(12,prplcompensatehouseDto.getNodetype());
        dbManager.setString(13,prplcompensatehouseDto.getKindcode());
        dbManager.setString(14,prplcompensatehouseDto.getPhone());
        dbManager.setString(15,prplcompensatehouseDto.getAddress());
        dbManager.setString(16,prplcompensatehouseDto.getRemark());
        dbManager.setString(17,prplcompensatehouseDto.getHukoubu());
        dbManager.setDouble(18,prplcompensatehouseDto.getEstimateloss());
        dbManager.setString(19,prplcompensatehouseDto.getBusinessno());
        dbManager.setString(20,prplcompensatehouseDto.getFloor());
        dbManager.setString(21,prplcompensatehouseDto.getBuildingnumber());
        dbManager.setString(22,prplcompensatehouseDto.getZhuannumber());
        dbManager.setString(23,prplcompensatehouseDto.getWanumber());
        dbManager.setString(24,prplcompensatehouseDto.getKitchennumber());
        dbManager.setString(25,prplcompensatehouseDto.getOthernumber());
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
        buffer.append("INSERT INTO Prplcompensatehouse (");
        buffer.append("Idcard,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Caseno,");
        buffer.append("Damagestartdate,");
        buffer.append("Damagecode,");
        buffer.append("Damagename,");
        buffer.append("Name,");
        buffer.append("Nodeno,");
        buffer.append("Nodetype,");
        buffer.append("Kindcode,");
        buffer.append("Phone,");
        buffer.append("Address,");
        buffer.append("Remark,");
        buffer.append("Hukoubu,");
        buffer.append("Estimateloss,");
        buffer.append("Businessno,");
        buffer.append("Floor,");
        buffer.append("Buildingnumber,");
        buffer.append("Zhuannumber,");
        buffer.append("Wanumber,");
        buffer.append("Kitchennumber,");
        buffer.append("Othernumber ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplcompensatehouseDto prplcompensatehouseDto = (PrplcompensatehouseDto)i.next();
            dbManager.setString(1,prplcompensatehouseDto.getIdcard());
            dbManager.setString(2,prplcompensatehouseDto.getPolicyno());
            dbManager.setString(3,prplcompensatehouseDto.getRegistno());
            dbManager.setString(4,prplcompensatehouseDto.getClaimno());
            dbManager.setString(5,prplcompensatehouseDto.getCompensateno());
            dbManager.setString(6,prplcompensatehouseDto.getCaseno());
            dbManager.setDateTime(7,prplcompensatehouseDto.getDamagestartdate());
            dbManager.setString(8,prplcompensatehouseDto.getDamagecode());
            dbManager.setString(9,prplcompensatehouseDto.getDamagename());
            dbManager.setString(10,prplcompensatehouseDto.getName());
            dbManager.setInt(11,prplcompensatehouseDto.getNodeno());
            dbManager.setString(12,prplcompensatehouseDto.getNodetype());
            dbManager.setString(13,prplcompensatehouseDto.getKindcode());
            dbManager.setString(14,prplcompensatehouseDto.getPhone());
            dbManager.setString(15,prplcompensatehouseDto.getAddress());
            dbManager.setString(16,prplcompensatehouseDto.getRemark());
            dbManager.setString(17,prplcompensatehouseDto.getHukoubu());
            dbManager.setDouble(18,prplcompensatehouseDto.getEstimateloss());
            dbManager.setString(19,prplcompensatehouseDto.getBusinessno());
            dbManager.setString(20,prplcompensatehouseDto.getFloor());
            dbManager.setString(21,prplcompensatehouseDto.getBuildingnumber());
            dbManager.setString(22,prplcompensatehouseDto.getZhuannumber());
            dbManager.setString(23,prplcompensatehouseDto.getWanumber());
            dbManager.setString(24,prplcompensatehouseDto.getKitchennumber());
            dbManager.setString(25,prplcompensatehouseDto.getOthernumber());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @throws Exception
     */
    public void delete(String idcard,String registno,String nodetype,String businessno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplcompensatehouse ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("' AND ");
            debugBuffer.append("Registno=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Idcard = ? And ");
        buffer.append("Registno = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Businessno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,idcard);
        dbManager.setString(2,registno);
        dbManager.setString(3,nodetype);
        dbManager.setString(4,businessno);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplcompensatehouseDto prplcompensatehouseDto
     * @throws Exception
     */
    public void update(PrplcompensatehouseDto prplcompensatehouseDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplcompensatehouse SET ");
        buffer.append("Policyno = ?, ");
        buffer.append("Claimno = ?, ");
        buffer.append("Compensateno = ?, ");
        buffer.append("Caseno = ?, ");
        buffer.append("Damagestartdate = ?, ");
        buffer.append("Damagecode = ?, ");
        buffer.append("Damagename = ?, ");
        buffer.append("Name = ?, ");
        buffer.append("Nodeno = ?, ");
        buffer.append("Kindcode = ?, ");
        buffer.append("Phone = ?, ");
        buffer.append("Address = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Hukoubu = ?, ");
        buffer.append("Estimateloss = ?, ");
        buffer.append("Floor = ?, ");
        buffer.append("Buildingnumber = ?, ");
        buffer.append("Zhuannumber = ?, ");
        buffer.append("Wanumber = ?, ");
        buffer.append("Kitchennumber = ?, ");
        buffer.append("Othernumber = ? ");
        
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplcompensatehouse SET ");
            debugBuffer.append("Policyno = '" + prplcompensatehouseDto.getPolicyno() + "', ");
            debugBuffer.append("Claimno = '" + prplcompensatehouseDto.getClaimno() + "', ");
            debugBuffer.append("Compensateno = '" + prplcompensatehouseDto.getCompensateno() + "', ");
            debugBuffer.append("Caseno = '" + prplcompensatehouseDto.getCaseno() + "', ");
            debugBuffer.append("Damagestartdate = '" + prplcompensatehouseDto.getDamagestartdate() + "', ");
            debugBuffer.append("Damagecode = '" + prplcompensatehouseDto.getDamagecode() + "', ");
            debugBuffer.append("Damagename = '" + prplcompensatehouseDto.getDamagename() + "', ");
            debugBuffer.append("Name = '" + prplcompensatehouseDto.getName() + "', ");
            debugBuffer.append("Nodeno = " + prplcompensatehouseDto.getNodeno() + ", ");
            debugBuffer.append("Kindcode = '" + prplcompensatehouseDto.getKindcode() + "', ");
            debugBuffer.append("Phone = '" + prplcompensatehouseDto.getPhone() + "', ");
            debugBuffer.append("Address = '" + prplcompensatehouseDto.getAddress() + "', ");
            debugBuffer.append("Remark = '" + prplcompensatehouseDto.getRemark() + "', ");
            debugBuffer.append("Hukoubu = '" + prplcompensatehouseDto.getHukoubu() + "', ");
            debugBuffer.append("Estimateloss = " + prplcompensatehouseDto.getEstimateloss() + ", ");
            debugBuffer.append("Floor = '" + prplcompensatehouseDto.getFloor() + "', ");
            debugBuffer.append("Buildingnumber = '" + prplcompensatehouseDto.getBuildingnumber() + "', ");
            debugBuffer.append("Zhuannumber = '" + prplcompensatehouseDto.getZhuannumber() + "', ");
            debugBuffer.append("Wanumber = '" + prplcompensatehouseDto.getWanumber() + "', ");
            debugBuffer.append("Kitchennumber = '" + prplcompensatehouseDto.getKitchennumber() + "', ");
            debugBuffer.append("Othernumber = '" + prplcompensatehouseDto.getOthernumber() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Idcard=").append("'").append(prplcompensatehouseDto.getIdcard()).append("' AND ");
            debugBuffer.append("Registno=").append("'").append(prplcompensatehouseDto.getRegistno()).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(prplcompensatehouseDto.getNodetype()).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(prplcompensatehouseDto.getBusinessno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Idcard = ? And ");
        buffer.append("Registno = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Businessno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prplcompensatehouseDto.getPolicyno());
        dbManager.setString(2,prplcompensatehouseDto.getClaimno());
        dbManager.setString(3,prplcompensatehouseDto.getCompensateno());
        dbManager.setString(4,prplcompensatehouseDto.getCaseno());
        dbManager.setDateTime(5,prplcompensatehouseDto.getDamagestartdate());
        dbManager.setString(6,prplcompensatehouseDto.getDamagecode());
        dbManager.setString(7,prplcompensatehouseDto.getDamagename());
        dbManager.setString(8,prplcompensatehouseDto.getName());
        dbManager.setInt(9,prplcompensatehouseDto.getNodeno());
        dbManager.setString(10,prplcompensatehouseDto.getKindcode());
        dbManager.setString(11,prplcompensatehouseDto.getPhone());
        dbManager.setString(12,prplcompensatehouseDto.getAddress());
        dbManager.setString(13,prplcompensatehouseDto.getRemark());
        dbManager.setString(14,prplcompensatehouseDto.getHukoubu());
        dbManager.setDouble(15,prplcompensatehouseDto.getEstimateloss());
        dbManager.setString(16,prplcompensatehouseDto.getFloor());
        dbManager.setString(17,prplcompensatehouseDto.getBuildingnumber());
        dbManager.setString(18,prplcompensatehouseDto.getZhuannumber());
        dbManager.setString(19,prplcompensatehouseDto.getWanumber());
        dbManager.setString(20,prplcompensatehouseDto.getKitchennumber());
        dbManager.setString(21,prplcompensatehouseDto.getOthernumber());
        //设置条件字段;
        dbManager.setString(22,prplcompensatehouseDto.getIdcard());
        dbManager.setString(23,prplcompensatehouseDto.getRegistno());
        dbManager.setString(24,prplcompensatehouseDto.getNodetype());
        dbManager.setString(25,prplcompensatehouseDto.getBusinessno());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @return PrplcompensatehouseDto
     * @throws Exception
     */
    public PrplcompensatehouseDto findByPrimaryKey(String idcard,String registno,String nodetype,String businessno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Idcard,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Caseno,");
        buffer.append("Damagestartdate,");
        buffer.append("Damagecode,");
        buffer.append("Damagename,");
        buffer.append("Name,");
        buffer.append("Nodeno,");
        buffer.append("Nodetype,");
        buffer.append("Kindcode,");
        buffer.append("Phone,");
        buffer.append("Address,");
        buffer.append("Remark,");
        buffer.append("Hukoubu,");
        buffer.append("Estimateloss,");
        buffer.append("Businessno,");
        buffer.append("Floor,");
        buffer.append("Buildingnumber,");
        buffer.append("Zhuannumber,");
        buffer.append("Wanumber,");
        buffer.append("Kitchennumber,");
        buffer.append("Othernumber ");
        buffer.append("FROM Prplcompensatehouse ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Idcard=").append("'").append(idcard).append("' AND ");
            debugBuffer.append("Registno=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Idcard = ? And ");
        buffer.append("Registno = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Businessno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,idcard);
        dbManager.setString(2,registno);
        dbManager.setString(3,nodetype);
        dbManager.setString(4,businessno);
        ResultSet resultSet = null;
        PrplcompensatehouseDto prplcompensatehouseDto = null;
        try{
            resultSet = dbManager.executePreparedQuery();
            if(resultSet.next()){
                prplcompensatehouseDto = new PrplcompensatehouseDto();
                prplcompensatehouseDto.setIdcard(dbManager.getString(resultSet,1));
                prplcompensatehouseDto.setPolicyno(dbManager.getString(resultSet,2));
                prplcompensatehouseDto.setRegistno(dbManager.getString(resultSet,3));
                prplcompensatehouseDto.setClaimno(dbManager.getString(resultSet,4));
                prplcompensatehouseDto.setCompensateno(dbManager.getString(resultSet,5));
                prplcompensatehouseDto.setCaseno(dbManager.getString(resultSet,6));
                prplcompensatehouseDto.setDamagestartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
                prplcompensatehouseDto.setDamagecode(dbManager.getString(resultSet,8));
                prplcompensatehouseDto.setDamagename(dbManager.getString(resultSet,9));
                prplcompensatehouseDto.setName(dbManager.getString(resultSet,10));
                prplcompensatehouseDto.setNodeno(dbManager.getInt(resultSet,11));
                prplcompensatehouseDto.setNodetype(dbManager.getString(resultSet,12));
                prplcompensatehouseDto.setKindcode(dbManager.getString(resultSet,13));
                prplcompensatehouseDto.setPhone(dbManager.getString(resultSet,14));
                prplcompensatehouseDto.setAddress(dbManager.getString(resultSet,15));
                prplcompensatehouseDto.setRemark(dbManager.getString(resultSet,16));
                prplcompensatehouseDto.setHukoubu(dbManager.getString(resultSet,17));
                prplcompensatehouseDto.setEstimateloss(dbManager.getDouble(resultSet,18));
                prplcompensatehouseDto.setBusinessno(dbManager.getString(resultSet,19));
                prplcompensatehouseDto.setFloor(dbManager.getString(resultSet,20));
                prplcompensatehouseDto.setBuildingnumber(dbManager.getString(resultSet,21));
                prplcompensatehouseDto.setZhuannumber(dbManager.getString(resultSet,22));
                prplcompensatehouseDto.setWanumber(dbManager.getString(resultSet,23));
                prplcompensatehouseDto.setKitchennumber(dbManager.getString(resultSet,24));
                prplcompensatehouseDto.setOthernumber(dbManager.getString(resultSet,25));
            }
        }finally{
            if(resultSet!=null){
                resultSet.close();
            }
        }
        return prplcompensatehouseDto;
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
        buffer.append("Idcard,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Caseno,");
        buffer.append("Damagestartdate,");
        buffer.append("Damagecode,");
        buffer.append("Damagename,");
        buffer.append("Name,");
        buffer.append("Nodeno,");
        buffer.append("Nodetype,");
        buffer.append("Kindcode,");
        buffer.append("Phone,");
        buffer.append("Address,");
        buffer.append("Remark,");
        buffer.append("Hukoubu,");
        buffer.append("Estimateloss,");
        buffer.append("Businessno,");
        buffer.append("Floor,");
        buffer.append("Buildingnumber,");
        buffer.append("Zhuannumber,");
        buffer.append("Wanumber,");
        buffer.append("Kitchennumber,");
        buffer.append("Othernumber ");
        buffer.append("FROM Prplcompensatehouse WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//数据库是否支持分页
        if (pageNo > 0){
            //对Oracle优化
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
                supportPaging=true;
            }
            else if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("DB2")){
                String sql = buffer.toString();
                buffer.setLength(0);
                buffer.append("select * from ( select rownumber() over(");
                int orderByIndex = sql.toLowerCase().indexOf("order by");
                if ( orderByIndex>0 ) {
                   buffer.append( sql.substring(orderByIndex) );
                }
                buffer.append(") as rownumber_,");
                buffer.append(sql.substring( 6 ));
                buffer.append(" ) as temp_ where rownumber_");
                buffer.append(" between "+ (rowsPerPage * (pageNo - 1) + 1) +" and "+rowsPerPage * pageNo);
                supportPaging=true;
            }
        }
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        ResultSet resultSet = null;
        try{
            resultSet = dbManager.executeQuery(buffer.toString());
            int count=0;
            if(supportPaging==false && pageNo>1){
                dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
            }

            PrplcompensatehouseDto prplcompensatehouseDto = null;
            while(resultSet.next()){
                if (supportPaging == false && pageNo>0) {
                    count++;
                    if(count > rowsPerPage){
                        break;
                    }
                }

                prplcompensatehouseDto = new PrplcompensatehouseDto();
                prplcompensatehouseDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
                prplcompensatehouseDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
                prplcompensatehouseDto.setRegistno(dbManager.getString(resultSet,"Registno"));
                prplcompensatehouseDto.setClaimno(dbManager.getString(resultSet,"Claimno"));
                prplcompensatehouseDto.setCompensateno(dbManager.getString(resultSet,"Compensateno"));
                prplcompensatehouseDto.setCaseno(dbManager.getString(resultSet,"Caseno"));
                prplcompensatehouseDto.setDamagestartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Damagestartdate"));
                prplcompensatehouseDto.setDamagecode(dbManager.getString(resultSet,"Damagecode"));
                prplcompensatehouseDto.setDamagename(dbManager.getString(resultSet,"Damagename"));
                prplcompensatehouseDto.setName(dbManager.getString(resultSet,"Name"));
                prplcompensatehouseDto.setNodeno(dbManager.getInt(resultSet,"Nodeno"));
                prplcompensatehouseDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
                prplcompensatehouseDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
                prplcompensatehouseDto.setPhone(dbManager.getString(resultSet,"Phone"));
                prplcompensatehouseDto.setAddress(dbManager.getString(resultSet,"Address"));
                prplcompensatehouseDto.setRemark(dbManager.getString(resultSet,"Remark"));
                prplcompensatehouseDto.setHukoubu(dbManager.getString(resultSet,"Hukoubu"));
                prplcompensatehouseDto.setEstimateloss(dbManager.getDouble(resultSet,"Estimateloss"));
                prplcompensatehouseDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
                prplcompensatehouseDto.setFloor(dbManager.getString(resultSet,"Floor"));
                prplcompensatehouseDto.setBuildingnumber(dbManager.getString(resultSet,"Buildingnumber"));
                prplcompensatehouseDto.setZhuannumber(dbManager.getString(resultSet,"Zhuannumber"));
                prplcompensatehouseDto.setWanumber(dbManager.getString(resultSet,"Wanumber"));
                prplcompensatehouseDto.setKitchennumber(dbManager.getString(resultSet,"Kitchennumber"));
                prplcompensatehouseDto.setOthernumber(dbManager.getString(resultSet,"Othernumber"));
                collection.add(prplcompensatehouseDto);
            }
        }finally{
            if(resultSet!=null){
                resultSet.close();
            }
        }
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
        buffer.append("DELETE FROM Prplcompensatehouse WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        return dbManager.executeUpdate(buffer.toString());
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
        buffer.append("SELECT count(1) FROM Prplcompensatehouse WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = null;
        try{
            resultSet = dbManager.executeQuery(buffer.toString());
            resultSet.next();
            count = dbManager.getInt(resultSet,1);
        }finally{
            if(resultSet!=null){
                resultSet.close();
            }
        }
        return count;
    }
    
    public BigDecimal getSumCompensate(String idcard,String policyno) 
    throws Exception{
    BigDecimal sum = new BigDecimal(0.00);
    StringBuffer buffer = new StringBuffer(500);
    buffer.append("select sum(l.sumloss) as sumloss from prplcompensatehouse h,prplcompensate l where h.idcard='" + idcard + "' and h.policyno='" + policyno + "' and h.compensateno=l.compensateno and l.underwriteflag='1'");
    if(logger.isDebugEnabled()){
        logger.debug(buffer.toString());
    }
    ResultSet resultSet = null;
    try{
        resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        sum = BigDecimal.valueOf(dbManager.getDouble(resultSet,1));
    }finally{
        if(resultSet!=null){
            resultSet.close();
        }
    }
    return sum;
}
    
    /**
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getInprocessCount(String policyno,String idcard) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("select count(1) from prplcompensatehouse a where (registno,idcard,nodeno) in (select registno,idcard,max(nodeno) from prplcompensatehouse where "
        		+ " policyno='" + policyno
        		+ "' and idcard='" + idcard
        		+ "' group by registno,idcard) and exists (select 1 from swflog where registno=a.registno and flowstatus!='0' )"
        		//+ "group by earno"
        		);
       
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

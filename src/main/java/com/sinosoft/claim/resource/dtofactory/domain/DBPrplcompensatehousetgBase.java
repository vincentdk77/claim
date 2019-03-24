package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplcompensatehousetgDto;
import java.math.*;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCOMPENSATEHOUSE的数据访问对象基类<br>
 */
public class DBPrplcompensatehousetgBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplcompensatehousetgBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplcompensatehousetgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplcompensatehousetgDto prplcompensatehousetgDto
     * @throws Exception
     */
    public void insert(PrplcompensatehousetgDto prplcompensatehousetgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplcompensatehousetg (");
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
            debugBuffer.append("'").append(prplcompensatehousetgDto.getIdcard()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getClaimno()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getCompensateno()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getCaseno()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getDamagestartdate()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getDamagecode()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getDamagename()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getName()).append("',");
            debugBuffer.append("").append(prplcompensatehousetgDto.getNodeno()).append(",");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getNodetype()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getKindcode()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getPhone()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getAddress()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getRemark()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getHukoubu()).append("',");
            debugBuffer.append("").append(prplcompensatehousetgDto.getEstimateloss()).append(",");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getFloor()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getBuildingnumber()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getZhuannumber()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getWanumber()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getKitchennumber()).append("',");
            debugBuffer.append("'").append(prplcompensatehousetgDto.getOthernumber()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplcompensatehousetgDto.getIdcard());
        dbManager.setString(2,prplcompensatehousetgDto.getPolicyno());
        dbManager.setString(3,prplcompensatehousetgDto.getRegistno());
        dbManager.setString(4,prplcompensatehousetgDto.getClaimno());
        dbManager.setString(5,prplcompensatehousetgDto.getCompensateno());
        dbManager.setString(6,prplcompensatehousetgDto.getCaseno());
        dbManager.setDateTime(7,prplcompensatehousetgDto.getDamagestartdate());
        dbManager.setString(8,prplcompensatehousetgDto.getDamagecode());
        dbManager.setString(9,prplcompensatehousetgDto.getDamagename());
        dbManager.setString(10,prplcompensatehousetgDto.getName());
        dbManager.setInt(11,prplcompensatehousetgDto.getNodeno());
        dbManager.setString(12,prplcompensatehousetgDto.getNodetype());
        dbManager.setString(13,prplcompensatehousetgDto.getKindcode());
        dbManager.setString(14,prplcompensatehousetgDto.getPhone());
        dbManager.setString(15,prplcompensatehousetgDto.getAddress());
        dbManager.setString(16,prplcompensatehousetgDto.getRemark());
        dbManager.setString(17,prplcompensatehousetgDto.getHukoubu());
        dbManager.setDouble(18,prplcompensatehousetgDto.getEstimateloss());
        dbManager.setString(19,prplcompensatehousetgDto.getBusinessno());
        dbManager.setString(20,prplcompensatehousetgDto.getFloor());
        dbManager.setString(21,prplcompensatehousetgDto.getBuildingnumber());
        dbManager.setString(22,prplcompensatehousetgDto.getZhuannumber());
        dbManager.setString(23,prplcompensatehousetgDto.getWanumber());
        dbManager.setString(24,prplcompensatehousetgDto.getKitchennumber());
        dbManager.setString(25,prplcompensatehousetgDto.getOthernumber());
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
        buffer.append("INSERT INTO Prplcompensatehousetg (");
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
            PrplcompensatehousetgDto prplcompensatehousetgDto = (PrplcompensatehousetgDto)i.next();
            dbManager.setString(1,prplcompensatehousetgDto.getIdcard());
            dbManager.setString(2,prplcompensatehousetgDto.getPolicyno());
            dbManager.setString(3,prplcompensatehousetgDto.getRegistno());
            dbManager.setString(4,prplcompensatehousetgDto.getClaimno());
            dbManager.setString(5,prplcompensatehousetgDto.getCompensateno());
            dbManager.setString(6,prplcompensatehousetgDto.getCaseno());
            dbManager.setDateTime(7,prplcompensatehousetgDto.getDamagestartdate());
            dbManager.setString(8,prplcompensatehousetgDto.getDamagecode());
            dbManager.setString(9,prplcompensatehousetgDto.getDamagename());
            dbManager.setString(10,prplcompensatehousetgDto.getName());
            dbManager.setInt(11,prplcompensatehousetgDto.getNodeno());
            dbManager.setString(12,prplcompensatehousetgDto.getNodetype());
            dbManager.setString(13,prplcompensatehousetgDto.getKindcode());
            dbManager.setString(14,prplcompensatehousetgDto.getPhone());
            dbManager.setString(15,prplcompensatehousetgDto.getAddress());
            dbManager.setString(16,prplcompensatehousetgDto.getRemark());
            dbManager.setString(17,prplcompensatehousetgDto.getHukoubu());
            dbManager.setDouble(18,prplcompensatehousetgDto.getEstimateloss());
            dbManager.setString(19,prplcompensatehousetgDto.getBusinessno());
            dbManager.setString(20,prplcompensatehousetgDto.getFloor());
            dbManager.setString(21,prplcompensatehousetgDto.getBuildingnumber());
            dbManager.setString(22,prplcompensatehousetgDto.getZhuannumber());
            dbManager.setString(23,prplcompensatehousetgDto.getWanumber());
            dbManager.setString(24,prplcompensatehousetgDto.getKitchennumber());
            dbManager.setString(25,prplcompensatehousetgDto.getOthernumber());
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
        buffer.append("DELETE FROM Prplcompensatehousetg ");
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
     * @param prplcompensatehousetgDto prplcompensatehousetgDto
     * @throws Exception
     */
    public void update(PrplcompensatehousetgDto prplcompensatehousetgDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplcompensatehousetg SET ");
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
            debugBuffer.append("UPDATE Prplcompensatehousetg SET ");
            debugBuffer.append("Policyno = '" + prplcompensatehousetgDto.getPolicyno() + "', ");
            debugBuffer.append("Claimno = '" + prplcompensatehousetgDto.getClaimno() + "', ");
            debugBuffer.append("Compensateno = '" + prplcompensatehousetgDto.getCompensateno() + "', ");
            debugBuffer.append("Caseno = '" + prplcompensatehousetgDto.getCaseno() + "', ");
            debugBuffer.append("Damagestartdate = '" + prplcompensatehousetgDto.getDamagestartdate() + "', ");
            debugBuffer.append("Damagecode = '" + prplcompensatehousetgDto.getDamagecode() + "', ");
            debugBuffer.append("Damagename = '" + prplcompensatehousetgDto.getDamagename() + "', ");
            debugBuffer.append("Name = '" + prplcompensatehousetgDto.getName() + "', ");
            debugBuffer.append("Nodeno = " + prplcompensatehousetgDto.getNodeno() + ", ");
            debugBuffer.append("Kindcode = '" + prplcompensatehousetgDto.getKindcode() + "', ");
            debugBuffer.append("Phone = '" + prplcompensatehousetgDto.getPhone() + "', ");
            debugBuffer.append("Address = '" + prplcompensatehousetgDto.getAddress() + "', ");
            debugBuffer.append("Remark = '" + prplcompensatehousetgDto.getRemark() + "', ");
            debugBuffer.append("Hukoubu = '" + prplcompensatehousetgDto.getHukoubu() + "', ");
            debugBuffer.append("Estimateloss = " + prplcompensatehousetgDto.getEstimateloss() + ", ");
            debugBuffer.append("Floor = '" + prplcompensatehousetgDto.getFloor() + "', ");
            debugBuffer.append("Buildingnumber = '" + prplcompensatehousetgDto.getBuildingnumber() + "', ");
            debugBuffer.append("Zhuannumber = '" + prplcompensatehousetgDto.getZhuannumber() + "', ");
            debugBuffer.append("Wanumber = '" + prplcompensatehousetgDto.getWanumber() + "', ");
            debugBuffer.append("Kitchennumber = '" + prplcompensatehousetgDto.getKitchennumber() + "', ");
            debugBuffer.append("Othernumber = '" + prplcompensatehousetgDto.getOthernumber() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Idcard=").append("'").append(prplcompensatehousetgDto.getIdcard()).append("' AND ");
            debugBuffer.append("Registno=").append("'").append(prplcompensatehousetgDto.getRegistno()).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(prplcompensatehousetgDto.getNodetype()).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(prplcompensatehousetgDto.getBusinessno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Idcard = ? And ");
        buffer.append("Registno = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Businessno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prplcompensatehousetgDto.getPolicyno());
        dbManager.setString(2,prplcompensatehousetgDto.getClaimno());
        dbManager.setString(3,prplcompensatehousetgDto.getCompensateno());
        dbManager.setString(4,prplcompensatehousetgDto.getCaseno());
        dbManager.setDateTime(5,prplcompensatehousetgDto.getDamagestartdate());
        dbManager.setString(6,prplcompensatehousetgDto.getDamagecode());
        dbManager.setString(7,prplcompensatehousetgDto.getDamagename());
        dbManager.setString(8,prplcompensatehousetgDto.getName());
        dbManager.setInt(9,prplcompensatehousetgDto.getNodeno());
        dbManager.setString(10,prplcompensatehousetgDto.getKindcode());
        dbManager.setString(11,prplcompensatehousetgDto.getPhone());
        dbManager.setString(12,prplcompensatehousetgDto.getAddress());
        dbManager.setString(13,prplcompensatehousetgDto.getRemark());
        dbManager.setString(14,prplcompensatehousetgDto.getHukoubu());
        dbManager.setDouble(15,prplcompensatehousetgDto.getEstimateloss());
        dbManager.setString(16,prplcompensatehousetgDto.getFloor());
        dbManager.setString(17,prplcompensatehousetgDto.getBuildingnumber());
        dbManager.setString(18,prplcompensatehousetgDto.getZhuannumber());
        dbManager.setString(19,prplcompensatehousetgDto.getWanumber());
        dbManager.setString(20,prplcompensatehousetgDto.getKitchennumber());
        dbManager.setString(21,prplcompensatehousetgDto.getOthernumber());
        //设置条件字段;
        dbManager.setString(22,prplcompensatehousetgDto.getIdcard());
        dbManager.setString(23,prplcompensatehousetgDto.getRegistno());
        dbManager.setString(24,prplcompensatehousetgDto.getNodetype());
        dbManager.setString(25,prplcompensatehousetgDto.getBusinessno());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param idcard IDCARD
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @param businessno BUSINESSNO
     * @return PrplcompensatehousetgDto
     * @throws Exception
     */
    public PrplcompensatehousetgDto findByPrimaryKey(String idcard,String registno,String nodetype,String businessno)
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
        buffer.append("FROM Prplcompensatehousetg ");
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
        PrplcompensatehousetgDto prplcompensatehousetgDto = null;
        try{
            resultSet = dbManager.executePreparedQuery();
            if(resultSet.next()){
                prplcompensatehousetgDto = new PrplcompensatehousetgDto();
                prplcompensatehousetgDto.setIdcard(dbManager.getString(resultSet,1));
                prplcompensatehousetgDto.setPolicyno(dbManager.getString(resultSet,2));
                prplcompensatehousetgDto.setRegistno(dbManager.getString(resultSet,3));
                prplcompensatehousetgDto.setClaimno(dbManager.getString(resultSet,4));
                prplcompensatehousetgDto.setCompensateno(dbManager.getString(resultSet,5));
                prplcompensatehousetgDto.setCaseno(dbManager.getString(resultSet,6));
                prplcompensatehousetgDto.setDamagestartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
                prplcompensatehousetgDto.setDamagecode(dbManager.getString(resultSet,8));
                prplcompensatehousetgDto.setDamagename(dbManager.getString(resultSet,9));
                prplcompensatehousetgDto.setName(dbManager.getString(resultSet,10));
                prplcompensatehousetgDto.setNodeno(dbManager.getInt(resultSet,11));
                prplcompensatehousetgDto.setNodetype(dbManager.getString(resultSet,12));
                prplcompensatehousetgDto.setKindcode(dbManager.getString(resultSet,13));
                prplcompensatehousetgDto.setPhone(dbManager.getString(resultSet,14));
                prplcompensatehousetgDto.setAddress(dbManager.getString(resultSet,15));
                prplcompensatehousetgDto.setRemark(dbManager.getString(resultSet,16));
                prplcompensatehousetgDto.setHukoubu(dbManager.getString(resultSet,17));
                prplcompensatehousetgDto.setEstimateloss(dbManager.getDouble(resultSet,18));
                prplcompensatehousetgDto.setBusinessno(dbManager.getString(resultSet,19));
                prplcompensatehousetgDto.setFloor(dbManager.getString(resultSet,20));
                prplcompensatehousetgDto.setBuildingnumber(dbManager.getString(resultSet,21));
                prplcompensatehousetgDto.setZhuannumber(dbManager.getString(resultSet,22));
                prplcompensatehousetgDto.setWanumber(dbManager.getString(resultSet,23));
                prplcompensatehousetgDto.setKitchennumber(dbManager.getString(resultSet,24));
                prplcompensatehousetgDto.setOthernumber(dbManager.getString(resultSet,25));
            }
        }finally{
            if(resultSet!=null){
                resultSet.close();
            }
        }
        return prplcompensatehousetgDto;
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
        buffer.append("FROM Prplcompensatehousetg WHERE ");
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

            PrplcompensatehousetgDto prplcompensatehousetgDto = null;
            while(resultSet.next()){
                if (supportPaging == false && pageNo>0) {
                    count++;
                    if(count > rowsPerPage){
                        break;
                    }
                }

                prplcompensatehousetgDto = new PrplcompensatehousetgDto();
                prplcompensatehousetgDto.setIdcard(dbManager.getString(resultSet,"Idcard"));
                prplcompensatehousetgDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
                prplcompensatehousetgDto.setRegistno(dbManager.getString(resultSet,"Registno"));
                prplcompensatehousetgDto.setClaimno(dbManager.getString(resultSet,"Claimno"));
                prplcompensatehousetgDto.setCompensateno(dbManager.getString(resultSet,"Compensateno"));
                prplcompensatehousetgDto.setCaseno(dbManager.getString(resultSet,"Caseno"));
                prplcompensatehousetgDto.setDamagestartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Damagestartdate"));
                prplcompensatehousetgDto.setDamagecode(dbManager.getString(resultSet,"Damagecode"));
                prplcompensatehousetgDto.setDamagename(dbManager.getString(resultSet,"Damagename"));
                prplcompensatehousetgDto.setName(dbManager.getString(resultSet,"Name"));
                prplcompensatehousetgDto.setNodeno(dbManager.getInt(resultSet,"Nodeno"));
                prplcompensatehousetgDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
                prplcompensatehousetgDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
                prplcompensatehousetgDto.setPhone(dbManager.getString(resultSet,"Phone"));
                prplcompensatehousetgDto.setAddress(dbManager.getString(resultSet,"Address"));
                prplcompensatehousetgDto.setRemark(dbManager.getString(resultSet,"Remark"));
                prplcompensatehousetgDto.setHukoubu(dbManager.getString(resultSet,"Hukoubu"));
                prplcompensatehousetgDto.setEstimateloss(dbManager.getDouble(resultSet,"Estimateloss"));
                prplcompensatehousetgDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
                prplcompensatehousetgDto.setFloor(dbManager.getString(resultSet,"Floor"));
                prplcompensatehousetgDto.setBuildingnumber(dbManager.getString(resultSet,"Buildingnumber"));
                prplcompensatehousetgDto.setZhuannumber(dbManager.getString(resultSet,"Zhuannumber"));
                prplcompensatehousetgDto.setWanumber(dbManager.getString(resultSet,"Wanumber"));
                prplcompensatehousetgDto.setKitchennumber(dbManager.getString(resultSet,"Kitchennumber"));
                prplcompensatehousetgDto.setOthernumber(dbManager.getString(resultSet,"Othernumber"));
                collection.add(prplcompensatehousetgDto);
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
        buffer.append("DELETE FROM Prplcompensatehousetg WHERE ");
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
        buffer.append("SELECT count(1) FROM Prplcompensatehousetg WHERE ");
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
    buffer.append("select sum(l.sumloss) as sumloss from prplcompensatehouse h,prplcompensatetg l where h.idcard='" + idcard + "' and h.policyno='" + policyno + "' and h.compensateno=l.compensateno and l.underwriteflag='1'");
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

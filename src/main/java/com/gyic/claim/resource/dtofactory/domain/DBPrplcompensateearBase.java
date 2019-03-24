package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.PrplcompensateearDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是Prplcompensateear的数据访问对象基类<br>
 */
public class DBPrplcompensateearBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplcompensateearBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrplcompensateearBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public void insert(PrplcompensateearDto prplcompensateearDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplcompensateear (");
        buffer.append("Earno,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Combineno,");
        buffer.append("Caseno,");
        buffer.append("Damagestartdate,");
        buffer.append("Damagestarthour,");
        buffer.append("Damageenddate,");
        buffer.append("Damagecode,");
        buffer.append("Damagename,");
        buffer.append("Name,");
        buffer.append("Id_card,");
        buffer.append("Bank,");
        buffer.append("Account,");
        buffer.append("Unitamount,");
        buffer.append("Estimateloss,");
        buffer.append("Restfee,");
        buffer.append("Claimrate,");
        buffer.append("Deductiblerate,");
        buffer.append("Deductible,");
        buffer.append("Sumrealpay,");
        buffer.append("Nodeno,");
        buffer.append("Nodetype,");
        buffer.append("Cullnumber,");
        buffer.append("Deadnumber,");
        buffer.append("Deadreason,");
        buffer.append("Breedingareaname,");
        buffer.append("Fcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Kindcode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Reporttime ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplcompensateearDto.getEarno()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getPolicyno()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getRegistno()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getClaimno()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getCompensateno()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getCombineno()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getCaseno()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getDamagestartdate()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getDamagestarthour()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getDamageenddate()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getDamagecode()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getDamagename()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getName()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getId_card()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getBank()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getAccount()).append("',");
            debugBuffer.append("").append(prplcompensateearDto.getUnitamount()).append(",");
            debugBuffer.append("").append(prplcompensateearDto.getEstimateloss()).append(",");
            debugBuffer.append("").append(prplcompensateearDto.getRestfee()).append(",");
            debugBuffer.append("").append(prplcompensateearDto.getClaimrate()).append(",");
            debugBuffer.append("").append(prplcompensateearDto.getDeductiblerate()).append(",");
            debugBuffer.append("").append(prplcompensateearDto.getDeductible()).append(",");
            debugBuffer.append("").append(prplcompensateearDto.getSumrealpay()).append(",");
            debugBuffer.append("").append(prplcompensateearDto.getNodeno()).append(",");
            debugBuffer.append("'").append(prplcompensateearDto.getNodetype()).append("',");
            debugBuffer.append("").append(prplcompensateearDto.getCullnumber()).append(",");
            debugBuffer.append("").append(prplcompensateearDto.getDeadnumber()).append(",");
            debugBuffer.append("'").append(prplcompensateearDto.getDeadreason()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getBreedingareaname()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getFcode()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getBreedingareacode()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getKindcode()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getInusrelistcode()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getBusinessno()).append("',");
            debugBuffer.append("'").append(prplcompensateearDto.getReporttime()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplcompensateearDto.getEarno());
        dbManager.setString(2,prplcompensateearDto.getPolicyno());
        dbManager.setString(3,prplcompensateearDto.getRegistno());
        dbManager.setString(4,prplcompensateearDto.getClaimno());
        dbManager.setString(5,prplcompensateearDto.getCompensateno());
        dbManager.setString(6,prplcompensateearDto.getCombineno());
        dbManager.setString(7,prplcompensateearDto.getCaseno());
        dbManager.setDateTime(8,prplcompensateearDto.getDamagestartdate());
        dbManager.setString(9,prplcompensateearDto.getDamagestarthour());
        dbManager.setDateTime(10,prplcompensateearDto.getDamageenddate());
        dbManager.setString(11,prplcompensateearDto.getDamagecode());
        dbManager.setString(12,prplcompensateearDto.getDamagename());
        dbManager.setString(13,prplcompensateearDto.getName());
        dbManager.setString(14,prplcompensateearDto.getId_card());
        dbManager.setString(15,prplcompensateearDto.getBank());
        dbManager.setString(16,prplcompensateearDto.getAccount());
        dbManager.setDouble(17,prplcompensateearDto.getUnitamount());
        dbManager.setDouble(18,prplcompensateearDto.getEstimateloss());
        dbManager.setDouble(19,prplcompensateearDto.getRestfee());
        dbManager.setDouble(20,prplcompensateearDto.getClaimrate());
        dbManager.setDouble(21,prplcompensateearDto.getDeductiblerate());
        dbManager.setDouble(22,prplcompensateearDto.getDeductible());
        dbManager.setDouble(23,prplcompensateearDto.getSumrealpay());
        dbManager.setInt(24,prplcompensateearDto.getNodeno());
        dbManager.setString(25,prplcompensateearDto.getNodetype());
        dbManager.setInt(26,prplcompensateearDto.getCullnumber());
        dbManager.setInt(27,prplcompensateearDto.getDeadnumber());
        dbManager.setString(28,prplcompensateearDto.getDeadreason());
        dbManager.setString(29,prplcompensateearDto.getBreedingareaname());
        dbManager.setString(30,prplcompensateearDto.getFcode());
        dbManager.setString(31,prplcompensateearDto.getBreedingareacode());
        dbManager.setString(32,prplcompensateearDto.getKindcode());
        dbManager.setString(33,prplcompensateearDto.getInusrelistcode());
        dbManager.setString(34,prplcompensateearDto.getBusinessno());
        dbManager.setString(35,prplcompensateearDto.getReporttime());
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
        buffer.append("INSERT INTO Prplcompensateear (");
        buffer.append("Earno,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Combineno,");
        buffer.append("Caseno,");
        buffer.append("Damagestartdate,");
        buffer.append("Damagestarthour,");
        buffer.append("Damageenddate,");
        buffer.append("Damagecode,");
        buffer.append("Damagename,");
        buffer.append("Name,");
        buffer.append("Id_card,");
        buffer.append("Bank,");
        buffer.append("Account,");
        buffer.append("Unitamount,");
        buffer.append("Estimateloss,");
        buffer.append("Restfee,");
        buffer.append("Claimrate,");
        buffer.append("Deductiblerate,");
        buffer.append("Deductible,");
        buffer.append("Sumrealpay,");
        buffer.append("Nodeno,");
        buffer.append("Nodetype,");
        buffer.append("Cullnumber,");
        buffer.append("Deadnumber,");
        buffer.append("Deadreason,");
        buffer.append("Breedingareaname,");
        buffer.append("Fcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Kindcode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Reporttime ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplcompensateearDto prplcompensateearDto = (PrplcompensateearDto)i.next();
            dbManager.setString(1,prplcompensateearDto.getEarno());
            dbManager.setString(2,prplcompensateearDto.getPolicyno());
            dbManager.setString(3,prplcompensateearDto.getRegistno());
            dbManager.setString(4,prplcompensateearDto.getClaimno());
            dbManager.setString(5,prplcompensateearDto.getCompensateno());
            dbManager.setString(6,prplcompensateearDto.getCombineno());
            dbManager.setString(7,prplcompensateearDto.getCaseno());
            dbManager.setDateTime(8,prplcompensateearDto.getDamagestartdate());
            dbManager.setString(9,prplcompensateearDto.getDamagestarthour());
            dbManager.setDateTime(10,prplcompensateearDto.getDamageenddate());
            dbManager.setString(11,prplcompensateearDto.getDamagecode());
            dbManager.setString(12,prplcompensateearDto.getDamagename());
            dbManager.setString(13,prplcompensateearDto.getName());
            dbManager.setString(14,prplcompensateearDto.getId_card());
            dbManager.setString(15,prplcompensateearDto.getBank());
            dbManager.setString(16,prplcompensateearDto.getAccount());
            dbManager.setDouble(17,prplcompensateearDto.getUnitamount());
            dbManager.setDouble(18,prplcompensateearDto.getEstimateloss());
            dbManager.setDouble(19,prplcompensateearDto.getRestfee());
            dbManager.setDouble(20,prplcompensateearDto.getClaimrate());
            dbManager.setDouble(21,prplcompensateearDto.getDeductiblerate());
            dbManager.setDouble(22,prplcompensateearDto.getDeductible());
            dbManager.setDouble(23,prplcompensateearDto.getSumrealpay());
            dbManager.setInt(24,prplcompensateearDto.getNodeno());
            dbManager.setString(25,prplcompensateearDto.getNodetype());
            dbManager.setInt(26,prplcompensateearDto.getCullnumber());
            dbManager.setInt(27,prplcompensateearDto.getDeadnumber());
            dbManager.setString(28,prplcompensateearDto.getDeadreason());
            dbManager.setString(29,prplcompensateearDto.getBreedingareaname());
            dbManager.setString(30,prplcompensateearDto.getFcode());
            dbManager.setString(31,prplcompensateearDto.getBreedingareacode());
            dbManager.setString(32,prplcompensateearDto.getKindcode());
            dbManager.setString(33,prplcompensateearDto.getInusrelistcode());
            dbManager.setString(34,prplcompensateearDto.getBusinessno());
            dbManager.setString(35,prplcompensateearDto.getReporttime());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param earno EARNO
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @throws Exception
     */
    public void delete(String earno,String registno,String nodetype,String businessno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplcompensateear ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Earno=").append("'").append(earno).append("' AND ");
            debugBuffer.append("Registno=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Earno = ? And ");
        buffer.append("Registno = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Businessno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,earno);
        dbManager.setString(2,registno);
        dbManager.setString(3,nodetype);
        dbManager.setString(4,businessno);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param prplcompensateearDto prplcompensateearDto
     * @throws Exception
     */
    public void update(PrplcompensateearDto prplcompensateearDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplcompensateear SET ");
        buffer.append("Policyno = ?, ");
        buffer.append("Claimno = ?, ");
        buffer.append("Compensateno = ?, ");
        buffer.append("Combineno = ?, ");
        buffer.append("Caseno = ?, ");
        buffer.append("Damagestartdate = ?, ");
        buffer.append("Damagestarthour = ?, ");
        buffer.append("Damageenddate = ?, ");
        buffer.append("Damagecode = ?, ");
        buffer.append("Damagename = ?, ");
        buffer.append("Name = ?, ");
        buffer.append("Id_card = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("Account = ?, ");
        buffer.append("Unitamount = ?, ");
        buffer.append("Estimateloss = ?, ");
        buffer.append("Restfee = ?, ");
        buffer.append("Claimrate = ?, ");
        buffer.append("Deductiblerate = ?, ");
        buffer.append("Deductible = ?, ");
        buffer.append("Sumrealpay = ?, ");
        buffer.append("Nodeno = ?, ");
        buffer.append("Cullnumber = ?, ");
        buffer.append("Deadnumber = ?, ");
        buffer.append("Deadreason = ?, ");
        buffer.append("Breedingareaname = ?, ");
        buffer.append("Fcode = ?, ");
        buffer.append("Breedingareacode = ?, ");
        buffer.append("Kindcode = ?, ");
        buffer.append("Inusrelistcode = ?, ");
        buffer.append("Reporttime = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplcompensateear SET ");
            debugBuffer.append("Policyno = '" + prplcompensateearDto.getPolicyno() + "', ");
            debugBuffer.append("Claimno = '" + prplcompensateearDto.getClaimno() + "', ");
            debugBuffer.append("Compensateno = '" + prplcompensateearDto.getCompensateno() + "', ");
            debugBuffer.append("Combineno = '" + prplcompensateearDto.getCombineno() + "', ");
            debugBuffer.append("Caseno = '" + prplcompensateearDto.getCaseno() + "', ");
            debugBuffer.append("Damagestartdate = '" + prplcompensateearDto.getDamagestartdate() + "', ");
            debugBuffer.append("Damagestarthour = '" + prplcompensateearDto.getDamagestarthour() + "', ");
            debugBuffer.append("Damageenddate = '" + prplcompensateearDto.getDamageenddate() + "', ");
            debugBuffer.append("Damagecode = '" + prplcompensateearDto.getDamagecode() + "', ");
            debugBuffer.append("Damagename = '" + prplcompensateearDto.getDamagename() + "', ");
            debugBuffer.append("Name = '" + prplcompensateearDto.getName() + "', ");
            debugBuffer.append("Id_card = '" + prplcompensateearDto.getId_card() + "', ");
            debugBuffer.append("Bank = '" + prplcompensateearDto.getBank() + "', ");
            debugBuffer.append("Account = '" + prplcompensateearDto.getAccount() + "', ");
            debugBuffer.append("Unitamount = " + prplcompensateearDto.getUnitamount() + ", ");
            debugBuffer.append("Estimateloss = " + prplcompensateearDto.getEstimateloss() + ", ");
            debugBuffer.append("Restfee = " + prplcompensateearDto.getRestfee() + ", ");
            debugBuffer.append("Claimrate = " + prplcompensateearDto.getClaimrate() + ", ");
            debugBuffer.append("Deductiblerate = " + prplcompensateearDto.getDeductiblerate() + ", ");
            debugBuffer.append("Deductible = " + prplcompensateearDto.getDeductible() + ", ");
            debugBuffer.append("Sumrealpay = " + prplcompensateearDto.getSumrealpay() + ", ");
            debugBuffer.append("Nodeno = " + prplcompensateearDto.getNodeno() + ", ");
            debugBuffer.append("Cullnumber = " + prplcompensateearDto.getCullnumber() + ", ");
            debugBuffer.append("Deadnumber = " + prplcompensateearDto.getDeadnumber() + ", ");
            debugBuffer.append("Deadreason = '" + prplcompensateearDto.getDeadreason() + "', ");
            debugBuffer.append("Breedingareaname = '" + prplcompensateearDto.getBreedingareaname() + "', ");
            debugBuffer.append("Fcode = '" + prplcompensateearDto.getFcode() + "', ");
            debugBuffer.append("Breedingareacode = '" + prplcompensateearDto.getBreedingareacode() + "', ");
            debugBuffer.append("Kindcode = '" + prplcompensateearDto.getKindcode() + "', ");
            debugBuffer.append("Inusrelistcode = '" + prplcompensateearDto.getInusrelistcode() + "', ");
            debugBuffer.append("Reporttime = '" + prplcompensateearDto.getReporttime() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Earno=").append("'").append(prplcompensateearDto.getEarno()).append("' AND ");
            debugBuffer.append("Registno=").append("'").append(prplcompensateearDto.getRegistno()).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(prplcompensateearDto.getNodetype()).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(prplcompensateearDto.getBusinessno()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Earno = ? And ");
        buffer.append("Registno = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Businessno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,prplcompensateearDto.getPolicyno());
        dbManager.setString(2,prplcompensateearDto.getClaimno());
        dbManager.setString(3,prplcompensateearDto.getCompensateno());
        dbManager.setString(4,prplcompensateearDto.getCombineno());
        dbManager.setString(5,prplcompensateearDto.getCaseno());
        dbManager.setDateTime(6,prplcompensateearDto.getDamagestartdate());
        dbManager.setString(7,prplcompensateearDto.getDamagestarthour());
        dbManager.setDateTime(8,prplcompensateearDto.getDamageenddate());
        dbManager.setString(9,prplcompensateearDto.getDamagecode());
        dbManager.setString(10,prplcompensateearDto.getDamagename());
        dbManager.setString(11,prplcompensateearDto.getName());
        dbManager.setString(12,prplcompensateearDto.getId_card());
        dbManager.setString(13,prplcompensateearDto.getBank());
        dbManager.setString(14,prplcompensateearDto.getAccount());
        dbManager.setDouble(15,prplcompensateearDto.getUnitamount());
        dbManager.setDouble(16,prplcompensateearDto.getEstimateloss());
        dbManager.setDouble(17,prplcompensateearDto.getRestfee());
        dbManager.setDouble(18,prplcompensateearDto.getClaimrate());
        dbManager.setDouble(19,prplcompensateearDto.getDeductiblerate());
        dbManager.setDouble(20,prplcompensateearDto.getDeductible());
        dbManager.setDouble(21,prplcompensateearDto.getSumrealpay());
        dbManager.setInt(22,prplcompensateearDto.getNodeno());
        dbManager.setInt(23,prplcompensateearDto.getCullnumber());
        dbManager.setInt(24,prplcompensateearDto.getDeadnumber());
        dbManager.setString(25,prplcompensateearDto.getDeadreason());
        dbManager.setString(26,prplcompensateearDto.getBreedingareaname());
        dbManager.setString(27,prplcompensateearDto.getFcode());
        dbManager.setString(28,prplcompensateearDto.getBreedingareacode());
        dbManager.setString(29,prplcompensateearDto.getKindcode());
        dbManager.setString(30,prplcompensateearDto.getInusrelistcode());
        dbManager.setString(31,prplcompensateearDto.getReporttime());
        //设置条件字段;
        dbManager.setString(32,prplcompensateearDto.getEarno());
        dbManager.setString(33,prplcompensateearDto.getRegistno());
        dbManager.setString(34,prplcompensateearDto.getNodetype());
        dbManager.setString(35,prplcompensateearDto.getBusinessno());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param earno EARNO
     * @param registno REGISTNO
     * @param nodetype NODETYPE
     * @return PrplcompensateearDto
     * @throws Exception
     */
    public PrplcompensateearDto findByPrimaryKey(String earno,String registno,String nodetype,String businessno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Earno,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Combineno,");
        buffer.append("Caseno,");
        buffer.append("Damagestartdate,");
        buffer.append("Damagestarthour,");
        buffer.append("Damageenddate,");
        buffer.append("Damagecode,");
        buffer.append("Damagename,");
        buffer.append("Name,");
        buffer.append("Id_card,");
        buffer.append("Bank,");
        buffer.append("Account,");
        buffer.append("Unitamount,");
        buffer.append("Estimateloss,");
        buffer.append("Restfee,");
        buffer.append("Claimrate,");
        buffer.append("Deductiblerate,");
        buffer.append("Deductible,");
        buffer.append("Sumrealpay,");
        buffer.append("Nodeno,");
        buffer.append("Nodetype,");
        buffer.append("Cullnumber,");
        buffer.append("Deadnumber,");
        buffer.append("Deadreason,");
        buffer.append("Breedingareaname,");
        buffer.append("Fcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Kindcode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,");
        buffer.append("Reporttime ");
        buffer.append("FROM Prplcompensateear ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Earno=").append("'").append(earno).append("' AND ");
            debugBuffer.append("Registno=").append("'").append(registno).append("' AND ");
            debugBuffer.append("Nodetype=").append("'").append(nodetype).append("' AND ");
            debugBuffer.append("Businessno=").append("'").append(businessno).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Earno = ? And ");
        buffer.append("Registno = ? And ");
        buffer.append("Nodetype = ? And ");
        buffer.append("Businessno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,earno);
        dbManager.setString(2,registno);
        dbManager.setString(3,nodetype);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplcompensateearDto prplcompensateearDto = null;
        if(resultSet.next()){
            prplcompensateearDto = new PrplcompensateearDto();
            prplcompensateearDto.setEarno(dbManager.getString(resultSet,1));
            prplcompensateearDto.setPolicyno(dbManager.getString(resultSet,2));
            prplcompensateearDto.setRegistno(dbManager.getString(resultSet,3));
            prplcompensateearDto.setClaimno(dbManager.getString(resultSet,4));
            prplcompensateearDto.setCompensateno(dbManager.getString(resultSet,5));
            prplcompensateearDto.setCombineno(dbManager.getString(resultSet,6));
            prplcompensateearDto.setCaseno(dbManager.getString(resultSet,7));
            prplcompensateearDto.setDamagestartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prplcompensateearDto.setDamagestarthour(dbManager.getString(resultSet,9));
            prplcompensateearDto.setDamageenddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prplcompensateearDto.setDamagecode(dbManager.getString(resultSet,11));
            prplcompensateearDto.setDamagename(dbManager.getString(resultSet,12));
            prplcompensateearDto.setName(dbManager.getString(resultSet,13));
            prplcompensateearDto.setId_card(dbManager.getString(resultSet,14));
            prplcompensateearDto.setBank(dbManager.getString(resultSet,15));
            prplcompensateearDto.setAccount(dbManager.getString(resultSet,16));
            prplcompensateearDto.setUnitamount(dbManager.getDouble(resultSet,17));
            prplcompensateearDto.setEstimateloss(dbManager.getDouble(resultSet,18));
            prplcompensateearDto.setRestfee(dbManager.getDouble(resultSet,19));
            prplcompensateearDto.setClaimrate(dbManager.getDouble(resultSet,20));
            prplcompensateearDto.setDeductiblerate(dbManager.getDouble(resultSet,21));
            prplcompensateearDto.setDeductible(dbManager.getDouble(resultSet,22));
            prplcompensateearDto.setSumrealpay(dbManager.getDouble(resultSet,23));
            prplcompensateearDto.setNodeno(dbManager.getInt(resultSet,24));
            prplcompensateearDto.setNodetype(dbManager.getString(resultSet,25));
            prplcompensateearDto.setCullnumber(dbManager.getInt(resultSet,26));
            prplcompensateearDto.setDeadnumber(dbManager.getInt(resultSet,27));
            prplcompensateearDto.setDeadreason(dbManager.getString(resultSet,28));
            prplcompensateearDto.setBreedingareaname(dbManager.getString(resultSet,29));
            prplcompensateearDto.setFcode(dbManager.getString(resultSet,30));
            prplcompensateearDto.setBreedingareacode(dbManager.getString(resultSet,31));
            prplcompensateearDto.setKindcode(dbManager.getString(resultSet,32));
            prplcompensateearDto.setInusrelistcode(dbManager.getString(resultSet,33));
            prplcompensateearDto.setBusinessno(dbManager.getString(resultSet,34));
            prplcompensateearDto.setReporttime(dbManager.getString(resultSet,35));
        }
        resultSet.close();
        return prplcompensateearDto;
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
        buffer.append("Earno,");
        buffer.append("Policyno,");
        buffer.append("Registno,");
        buffer.append("Claimno,");
        buffer.append("Compensateno,");
        buffer.append("Combineno,");
        buffer.append("Caseno,");
        buffer.append("Damagestartdate,");
        buffer.append("Damagestarthour,");
        buffer.append("Damageenddate,");
        buffer.append("Damagecode,");
        buffer.append("Damagename,");
        buffer.append("Name,");
        buffer.append("Id_card,");
        buffer.append("Bank,");
        buffer.append("Account,");
        buffer.append("Unitamount,");
        buffer.append("Estimateloss,");
        buffer.append("Restfee,");
        buffer.append("Claimrate,");
        buffer.append("Deductiblerate,");
        buffer.append("Deductible,");
        buffer.append("Sumrealpay,");
        buffer.append("Nodeno,");
        buffer.append("Nodetype,");
        buffer.append("Cullnumber,");
        buffer.append("Deadnumber,");
        buffer.append("Deadreason,");
        buffer.append("Breedingareaname,");
        buffer.append("Fcode,");
        buffer.append("Breedingareacode,");
        buffer.append("Kindcode,");
        buffer.append("Inusrelistcode,");
        buffer.append("Businessno,"); 
        buffer.append("Reporttime ");
        buffer.append("FROM Prplcompensateear WHERE ");
        buffer.append(conditions);
        System.err.println(buffer.toString());
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
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        PrplcompensateearDto prplcompensateearDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplcompensateearDto = new PrplcompensateearDto();
            prplcompensateearDto.setEarno(dbManager.getString(resultSet,"Earno"));
            prplcompensateearDto.setPolicyno(dbManager.getString(resultSet,"Policyno"));
            prplcompensateearDto.setRegistno(dbManager.getString(resultSet,"Registno"));
            prplcompensateearDto.setClaimno(dbManager.getString(resultSet,"Claimno"));
            prplcompensateearDto.setCompensateno(dbManager.getString(resultSet,"Compensateno"));
            prplcompensateearDto.setCombineno(dbManager.getString(resultSet,"Combineno"));
            prplcompensateearDto.setCaseno(dbManager.getString(resultSet,"Caseno"));
            prplcompensateearDto.setDamagestartdate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Damagestartdate"));
            prplcompensateearDto.setDamagestarthour(dbManager.getString(resultSet,"Damagestarthour"));
            prplcompensateearDto.setDamageenddate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,"Damageenddate"));
            prplcompensateearDto.setDamagecode(dbManager.getString(resultSet,"Damagecode"));
            prplcompensateearDto.setDamagename(dbManager.getString(resultSet,"Damagename"));
            prplcompensateearDto.setName(dbManager.getString(resultSet,"Name"));
            prplcompensateearDto.setId_card(dbManager.getString(resultSet,"Id_card"));
            prplcompensateearDto.setBank(dbManager.getString(resultSet,"Bank"));
            prplcompensateearDto.setAccount(dbManager.getString(resultSet,"Account"));
            prplcompensateearDto.setUnitamount(dbManager.getDouble(resultSet,"Unitamount"));
            prplcompensateearDto.setEstimateloss(dbManager.getDouble(resultSet,"Estimateloss"));
            prplcompensateearDto.setRestfee(dbManager.getDouble(resultSet,"Restfee"));
            prplcompensateearDto.setClaimrate(dbManager.getDouble(resultSet,"Claimrate"));
            prplcompensateearDto.setDeductiblerate(dbManager.getDouble(resultSet,"Deductiblerate"));
            prplcompensateearDto.setDeductible(dbManager.getDouble(resultSet,"Deductible"));
            prplcompensateearDto.setSumrealpay(dbManager.getDouble(resultSet,"Sumrealpay"));
            prplcompensateearDto.setNodeno(dbManager.getInt(resultSet,"Nodeno"));
            prplcompensateearDto.setNodetype(dbManager.getString(resultSet,"Nodetype"));
            prplcompensateearDto.setCullnumber(dbManager.getInt(resultSet,"Cullnumber"));
            prplcompensateearDto.setDeadnumber(dbManager.getInt(resultSet,"Deadnumber"));
            prplcompensateearDto.setDeadreason(dbManager.getString(resultSet,"Deadreason"));
            prplcompensateearDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
            prplcompensateearDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            prplcompensateearDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
            prplcompensateearDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            prplcompensateearDto.setInusrelistcode(dbManager.getString(resultSet,"Inusrelistcode"));
            prplcompensateearDto.setBusinessno(dbManager.getString(resultSet,"Businessno"));
            prplcompensateearDto.setReporttime(dbManager.getString(resultSet,"Reporttime"));
            collection.add(prplcompensateearDto);
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
        buffer.append("DELETE FROM Prplcompensateear WHERE ");
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
        buffer.append("SELECT count(*) FROM Prplcompensateear WHERE ");
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
     * 查询满足模糊查询条件的记录数
     * @param conditions conditions
     * @return 满足模糊查询条件的记录数
     * @throws Exception
     */
    public int getInprocessCount(String policyno,String earno) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("select count(*) from prplcompensateear a where (registno,earno,nodeno) in (select registno,earno,max(nodeno) from prplcompensateear where "
        		+ " policyno='" + policyno
        		+ "' and earno='" + earno
        		+ "' group by registno,earno) and exists (select 1 from swflog where registno=a.registno and flowstatus!='0' )"
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
    
    /**
     * 查询满足模糊查询条件的预计给付金额
     * @param conditions conditions
     * @return 满足模糊查询条件的预计给付金额
     * @throws Exception
     */
    public double getSumLoss(String conditions) 
        throws Exception{
    	double sumLoss = 0.00;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT sum(ESTIMATELOSS) FROM Prplcompensateear WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        resultSet.next();
        sumLoss = dbManager.getDouble(resultSet,1);
        resultSet.close();
        return sumLoss;
    }
}

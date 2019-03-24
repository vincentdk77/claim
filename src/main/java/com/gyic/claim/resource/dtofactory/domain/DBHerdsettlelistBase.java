package com.gyic.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.gyic.claim.dto.domain.HerdsettlelistDto;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是HERDSETTLELIST的数据访问对象基类<br>
 */
public class DBHerdsettlelistBase{
    /**
     * 资源管理类的实例，处理数据库操作.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBHerdsettlelistBase.class);

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBHerdsettlelistBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * 插入一条数据
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void insert(HerdsettlelistDto herdsettlelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Herdsettlelist (");
        buffer.append("Settlelistcode,");
        buffer.append("Earlabel,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Breedingareacode,");
        buffer.append("Breedingareaname,");
        buffer.append("Bankname,");
        buffer.append("Bankaccount,");
        buffer.append("Damagetime,");
        buffer.append("Reporttime,");
        buffer.append("Deadreason,");
        buffer.append("Deadnumber,");
        buffer.append("Cullnumber,");
        buffer.append("Settleamount,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Insurelistcode,");
        buffer.append("Kindcode,");
        buffer.append("Serialno ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(herdsettlelistDto.getSettlelistcode()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getEarlabel()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getFcode()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getFname()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getFidcard()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getBreedingareacode()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getBreedingareaname()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getBankname()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getBankaccount()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getDamagetime()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getReporttime()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getDeadreason()).append("',");
            debugBuffer.append("").append(herdsettlelistDto.getDeadnumber()).append(",");
            debugBuffer.append("").append(herdsettlelistDto.getCullnumber()).append(",");
            debugBuffer.append("").append(herdsettlelistDto.getSettleamount()).append(",");
            debugBuffer.append("'").append(herdsettlelistDto.getOpcode()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getOptime()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getValidity()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getRemark()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getInsurelistcode()).append("',");
            debugBuffer.append("'").append(herdsettlelistDto.getKindcode()).append("',");
            debugBuffer.append("").append(herdsettlelistDto.getSerialno()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,herdsettlelistDto.getSettlelistcode());
        dbManager.setString(2,herdsettlelistDto.getEarlabel());
        dbManager.setString(3,herdsettlelistDto.getFcode());
        dbManager.setString(4,herdsettlelistDto.getFname());
        dbManager.setString(5,herdsettlelistDto.getFidcard());
        dbManager.setString(6,herdsettlelistDto.getBreedingareacode());
        dbManager.setString(7,herdsettlelistDto.getBreedingareaname());
        dbManager.setString(8,herdsettlelistDto.getBankname());
        dbManager.setString(9,herdsettlelistDto.getBankaccount());
        dbManager.setString(10,herdsettlelistDto.getDamagetime());
        dbManager.setString(11,herdsettlelistDto.getReporttime());
        dbManager.setString(12,herdsettlelistDto.getDeadreason());
        dbManager.setInt(13,herdsettlelistDto.getDeadnumber());
        dbManager.setInt(14,herdsettlelistDto.getCullnumber());
        dbManager.setInt(15,herdsettlelistDto.getSettleamount());
        dbManager.setString(16,herdsettlelistDto.getOpcode());
        dbManager.setDateTime(17,herdsettlelistDto.getOptime());
        dbManager.setString(18,herdsettlelistDto.getValidity());
        dbManager.setString(19,herdsettlelistDto.getRemark());
        dbManager.setString(20,herdsettlelistDto.getInsurelistcode());
        dbManager.setString(21,herdsettlelistDto.getKindcode());
        dbManager.setInt(22,herdsettlelistDto.getSerialno());
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
        buffer.append("INSERT INTO Herdsettlelist (");
        buffer.append("Settlelistcode,");
        buffer.append("Earlabel,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Breedingareacode,");
        buffer.append("Breedingareaname,");
        buffer.append("Bankname,");
        buffer.append("Bankaccount,");
        buffer.append("Damagetime,");
        buffer.append("Reporttime,");
        buffer.append("Deadreason,");
        buffer.append("Deadnumber,");
        buffer.append("Cullnumber,");
        buffer.append("Settleamount,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Insurelistcode,");
        buffer.append("Kindcode,");
        buffer.append("Serialno ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            HerdsettlelistDto herdsettlelistDto = (HerdsettlelistDto)i.next();
            dbManager.setString(1,herdsettlelistDto.getSettlelistcode());
            dbManager.setString(2,herdsettlelistDto.getEarlabel());
            dbManager.setString(3,herdsettlelistDto.getFcode());
            dbManager.setString(4,herdsettlelistDto.getFname());
            dbManager.setString(5,herdsettlelistDto.getFidcard());
            dbManager.setString(6,herdsettlelistDto.getBreedingareacode());
            dbManager.setString(7,herdsettlelistDto.getBreedingareaname());
            dbManager.setString(8,herdsettlelistDto.getBankname());
            dbManager.setString(9,herdsettlelistDto.getBankaccount());
            dbManager.setString(10,herdsettlelistDto.getDamagetime());
            dbManager.setString(11,herdsettlelistDto.getReporttime());
            dbManager.setString(12,herdsettlelistDto.getDeadreason());
            dbManager.setInt(13,herdsettlelistDto.getDeadnumber());
            dbManager.setInt(14,herdsettlelistDto.getCullnumber());
            dbManager.setInt(15,herdsettlelistDto.getSettleamount());
            dbManager.setString(16,herdsettlelistDto.getOpcode());
            dbManager.setDateTime(17,herdsettlelistDto.getOptime());
            dbManager.setString(18,herdsettlelistDto.getValidity());
            dbManager.setString(19,herdsettlelistDto.getRemark());
            dbManager.setString(20,herdsettlelistDto.getInsurelistcode());
            dbManager.setString(21,herdsettlelistDto.getKindcode());
            dbManager.setInt(22,herdsettlelistDto.getSerialno());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * 按主键删除一条数据
     * @param settlelistcode SETTLELISTCODE
     * @param earlabel EARLABEL
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String settlelistcode,String earlabel,String fcode,String kindcode,int serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Herdsettlelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("' AND ");
            debugBuffer.append("Earlabel=").append("'").append(earlabel).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Serialno=").append("").append(serialno).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Earlabel = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,settlelistcode);
        dbManager.setString(2,earlabel);
        dbManager.setString(3,fcode);
        dbManager.setString(4,kindcode);
        dbManager.setInt(5,serialno);
        dbManager.executePreparedUpdate();
    }

    /**
     * 按主键更新一条数据(主键本身无法变更)
     * @param herdsettlelistDto herdsettlelistDto
     * @throws Exception
     */
    public void update(HerdsettlelistDto herdsettlelistDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Herdsettlelist SET ");
        buffer.append("Fname = ?, ");
        buffer.append("Fidcard = ?, ");
        buffer.append("Breedingareacode = ?, ");
        buffer.append("Breedingareaname = ?, ");
        buffer.append("Bankname = ?, ");
        buffer.append("Bankaccount = ?, ");
        buffer.append("Damagetime = ?, ");
        buffer.append("Reporttime = ?, ");
        buffer.append("Deadreason = ?, ");
        buffer.append("Deadnumber = ?, ");
        buffer.append("Cullnumber = ?, ");
        buffer.append("Settleamount = ?, ");
        buffer.append("Opcode = ?, ");
        buffer.append("Optime = ?, ");
        buffer.append("Validity = ?, ");
        buffer.append("Remark = ?, ");
        buffer.append("Insurelistcode = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Herdsettlelist SET ");
            debugBuffer.append("Fname = '" + herdsettlelistDto.getFname() + "', ");
            debugBuffer.append("Fidcard = '" + herdsettlelistDto.getFidcard() + "', ");
            debugBuffer.append("Breedingareacode = '" + herdsettlelistDto.getBreedingareacode() + "', ");
            debugBuffer.append("Breedingareaname = '" + herdsettlelistDto.getBreedingareaname() + "', ");
            debugBuffer.append("Bankname = '" + herdsettlelistDto.getBankname() + "', ");
            debugBuffer.append("Bankaccount = '" + herdsettlelistDto.getBankaccount() + "', ");
            debugBuffer.append("Damagetime = '" + herdsettlelistDto.getDamagetime() + "', ");
            debugBuffer.append("Reporttime = '" + herdsettlelistDto.getReporttime() + "', ");
            debugBuffer.append("Deadreason = '" + herdsettlelistDto.getDeadreason() + "', ");
            debugBuffer.append("Deadnumber = " + herdsettlelistDto.getDeadnumber() + ", ");
            debugBuffer.append("Cullnumber = " + herdsettlelistDto.getCullnumber() + ", ");
            debugBuffer.append("Settleamount = " + herdsettlelistDto.getSettleamount() + ", ");
            debugBuffer.append("Opcode = '" + herdsettlelistDto.getOpcode() + "', ");
            debugBuffer.append("Optime = '" + herdsettlelistDto.getOptime() + "', ");
            debugBuffer.append("Validity = '" + herdsettlelistDto.getValidity() + "', ");
            debugBuffer.append("Remark = '" + herdsettlelistDto.getRemark() + "', ");
            debugBuffer.append("Insurelistcode = '" + herdsettlelistDto.getInsurelistcode() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(herdsettlelistDto.getSettlelistcode()).append("' AND ");
            debugBuffer.append("Earlabel=").append("'").append(herdsettlelistDto.getEarlabel()).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(herdsettlelistDto.getFcode()).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(herdsettlelistDto.getKindcode()).append("' AND ");
            debugBuffer.append("Serialno=").append("").append(herdsettlelistDto.getSerialno()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Earlabel = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置更新字段;
        dbManager.setString(1,herdsettlelistDto.getFname());
        dbManager.setString(2,herdsettlelistDto.getFidcard());
        dbManager.setString(3,herdsettlelistDto.getBreedingareacode());
        dbManager.setString(4,herdsettlelistDto.getBreedingareaname());
        dbManager.setString(5,herdsettlelistDto.getBankname());
        dbManager.setString(6,herdsettlelistDto.getBankaccount());
        dbManager.setString(7,herdsettlelistDto.getDamagetime());
        dbManager.setString(8,herdsettlelistDto.getReporttime());
        dbManager.setString(9,herdsettlelistDto.getDeadreason());
        dbManager.setInt(10,herdsettlelistDto.getDeadnumber());
        dbManager.setInt(11,herdsettlelistDto.getCullnumber());
        dbManager.setInt(12,herdsettlelistDto.getSettleamount());
        dbManager.setString(13,herdsettlelistDto.getOpcode());
        dbManager.setDateTime(14,herdsettlelistDto.getOptime());
        dbManager.setString(15,herdsettlelistDto.getValidity());
        dbManager.setString(16,herdsettlelistDto.getRemark());
        dbManager.setString(17,herdsettlelistDto.getInsurelistcode());
        //设置条件字段;
        dbManager.setString(18,herdsettlelistDto.getSettlelistcode());
        dbManager.setString(19,herdsettlelistDto.getEarlabel());
        dbManager.setString(20,herdsettlelistDto.getFcode());
        dbManager.setString(21,herdsettlelistDto.getKindcode());
        dbManager.setInt(22,herdsettlelistDto.getSerialno());
        dbManager.executePreparedUpdate();

    }

    /**
     * 按主键查找一条数据
     * @param settlelistcode SETTLELISTCODE
     * @param earlabel EARLABEL
     * @param fcode FCODE
     * @param kindcode KINDCODE
     * @param serialno SERIALNO
     * @return HerdsettlelistDto
     * @throws Exception
     */
    public HerdsettlelistDto findByPrimaryKey(String settlelistcode,String earlabel,String fcode,String kindcode,int serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //拼SQL语句
        buffer.append("SELECT ");
        buffer.append("Settlelistcode,");
        buffer.append("Earlabel,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Breedingareacode,");
        buffer.append("Breedingareaname,");
        buffer.append("Bankname,");
        buffer.append("Bankaccount,");
        buffer.append("Damagetime,");
        buffer.append("Reporttime,");
        buffer.append("Deadreason,");
        buffer.append("Deadnumber,");
        buffer.append("Cullnumber,");
        buffer.append("Settleamount,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Insurelistcode,");
        buffer.append("Kindcode,");
        buffer.append("Serialno ");
        buffer.append("FROM Herdsettlelist ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Settlelistcode=").append("'").append(settlelistcode).append("' AND ");
            debugBuffer.append("Earlabel=").append("'").append(earlabel).append("' AND ");
            debugBuffer.append("Fcode=").append("'").append(fcode).append("' AND ");
            debugBuffer.append("Kindcode=").append("'").append(kindcode).append("' AND ");
            debugBuffer.append("Serialno=").append("").append(serialno).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Settlelistcode = ? And ");
        buffer.append("Earlabel = ? And ");
        buffer.append("Fcode = ? And ");
        buffer.append("Kindcode = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //设置条件字段;
        dbManager.setString(1,settlelistcode);
        dbManager.setString(2,earlabel);
        dbManager.setString(3,fcode);
        dbManager.setString(4,kindcode);
        dbManager.setInt(5,serialno);
        ResultSet resultSet = dbManager.executePreparedQuery();
        HerdsettlelistDto herdsettlelistDto = null;
        if(resultSet.next()){
            herdsettlelistDto = new HerdsettlelistDto();
            herdsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,1));
            herdsettlelistDto.setEarlabel(dbManager.getString(resultSet,2));
            herdsettlelistDto.setFcode(dbManager.getString(resultSet,3));
            herdsettlelistDto.setFname(dbManager.getString(resultSet,4));
            herdsettlelistDto.setFidcard(dbManager.getString(resultSet,5));
            herdsettlelistDto.setBreedingareacode(dbManager.getString(resultSet,6));
            herdsettlelistDto.setBreedingareaname(dbManager.getString(resultSet,7));
            herdsettlelistDto.setBankname(dbManager.getString(resultSet,8));
            herdsettlelistDto.setBankaccount(dbManager.getString(resultSet,9));
            herdsettlelistDto.setDamagetime(dbManager.getString(resultSet,10));
            herdsettlelistDto.setReporttime(dbManager.getString(resultSet,11));
            herdsettlelistDto.setDeadreason(dbManager.getString(resultSet,12));
            herdsettlelistDto.setDeadnumber(dbManager.getInt(resultSet,13));
            herdsettlelistDto.setCullnumber(dbManager.getInt(resultSet,14));
            herdsettlelistDto.setSettleamount(dbManager.getInt(resultSet,15));
            herdsettlelistDto.setOpcode(dbManager.getString(resultSet,16));
            herdsettlelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,17));
            herdsettlelistDto.setValidity(dbManager.getString(resultSet,18));
            herdsettlelistDto.setRemark(dbManager.getString(resultSet,19));
            herdsettlelistDto.setInsurelistcode(dbManager.getString(resultSet,20));
            herdsettlelistDto.setKindcode(dbManager.getString(resultSet,21));
            herdsettlelistDto.setSerialno(dbManager.getInt(resultSet,22));
        }
        resultSet.close();
        return herdsettlelistDto;
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
        buffer.append("Settlelistcode,");
        buffer.append("Earlabel,");
        buffer.append("Fcode,");
        buffer.append("Fname,");
        buffer.append("Fidcard,");
        buffer.append("Breedingareacode,");
        buffer.append("Breedingareaname,");
        buffer.append("Bankname,");
        buffer.append("Bankaccount,");
        buffer.append("Damagetime,");
        buffer.append("Reporttime,");
        buffer.append("Deadreason,");
        buffer.append("Deadnumber,");
        buffer.append("Cullnumber,");
        buffer.append("Settleamount,");
        buffer.append("Opcode,");
        buffer.append("Optime,");
        buffer.append("Validity,");
        buffer.append("Remark,");
        buffer.append("Insurelistcode,");
        buffer.append("Kindcode,");
        buffer.append("Serialno ");
        buffer.append("FROM Herdsettlelist WHERE ");
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
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        if(supportPaging==false && pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        //定义返回结果集合
        Collection collection = new ArrayList(rowsPerPage);
        HerdsettlelistDto herdsettlelistDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            herdsettlelistDto = new HerdsettlelistDto();
            herdsettlelistDto.setSettlelistcode(dbManager.getString(resultSet,"Settlelistcode"));
            herdsettlelistDto.setEarlabel(dbManager.getString(resultSet,"Earlabel"));
            herdsettlelistDto.setFcode(dbManager.getString(resultSet,"Fcode"));
            herdsettlelistDto.setFname(dbManager.getString(resultSet,"Fname"));
            herdsettlelistDto.setFidcard(dbManager.getString(resultSet,"Fidcard"));
            herdsettlelistDto.setBreedingareacode(dbManager.getString(resultSet,"Breedingareacode"));
            herdsettlelistDto.setBreedingareaname(dbManager.getString(resultSet,"Breedingareaname"));
            herdsettlelistDto.setBankname(dbManager.getString(resultSet,"Bankname"));
            herdsettlelistDto.setBankaccount(dbManager.getString(resultSet,"Bankaccount"));
            herdsettlelistDto.setDamagetime(dbManager.getString(resultSet,"Damagetime"));
            herdsettlelistDto.setReporttime(dbManager.getString(resultSet,"Reporttime"));
            herdsettlelistDto.setDeadreason(dbManager.getString(resultSet,"Deadreason"));
            herdsettlelistDto.setDeadnumber(dbManager.getInt(resultSet,"Deadnumber"));
            herdsettlelistDto.setCullnumber(dbManager.getInt(resultSet,"Cullnumber"));
            herdsettlelistDto.setSettleamount(dbManager.getInt(resultSet,"Settleamount"));
            herdsettlelistDto.setOpcode(dbManager.getString(resultSet,"Opcode"));
            herdsettlelistDto.setOptime(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_MINUTE,"Optime"));
            herdsettlelistDto.setValidity(dbManager.getString(resultSet,"Validity"));
            herdsettlelistDto.setRemark(dbManager.getString(resultSet,"Remark"));
            herdsettlelistDto.setInsurelistcode(dbManager.getString(resultSet,"Insurelistcode"));
            herdsettlelistDto.setKindcode(dbManager.getString(resultSet,"Kindcode"));
            herdsettlelistDto.setSerialno(dbManager.getInt(resultSet,"Serialno"));
            collection.add(herdsettlelistDto);
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
        buffer.append("DELETE FROM Herdsettlelist WHERE ");
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
        buffer.append("SELECT count(*) FROM Herdsettlelist WHERE ");
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

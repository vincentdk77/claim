package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangersdDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCIDANGERSD�����ݷ��ʶ������<br>
 */
public class DBPrplaccidangersdBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplaccidangersdBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplaccidangersdBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public void insert(PrplaccidangersdDto prplaccidangersdDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplaccidangersd (");
        buffer.append("Insuredname,");
        buffer.append("Serialno,");
        buffer.append("Gender,");
        buffer.append("Birthday,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno,");
        buffer.append("Isrisk,");
        buffer.append("Losstimes,");
        buffer.append("Sumclaimamount,");
        buffer.append("Refuseclaimtimes ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplaccidangersdDto.getInsuredName()).append("',");
            debugBuffer.append("").append(prplaccidangersdDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prplaccidangersdDto.getGender()).append("',");
            debugBuffer.append("'").append(prplaccidangersdDto.getBirthday()).append("',");
            debugBuffer.append("'").append(prplaccidangersdDto.getCredentialType()).append("',");
            debugBuffer.append("'").append(prplaccidangersdDto.getCredentialNo()).append("',");
            debugBuffer.append("'").append(prplaccidangersdDto.getIsRisk()).append("',");
            debugBuffer.append("").append(prplaccidangersdDto.getLossTimes()).append(",");
            debugBuffer.append("").append(prplaccidangersdDto.getSumClaimAmount()).append(",");
            debugBuffer.append("").append(prplaccidangersdDto.getRefuseClaimTimes()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplaccidangersdDto.getInsuredName());
        dbManager.setInt(2,prplaccidangersdDto.getSerialNo());
        dbManager.setString(3,prplaccidangersdDto.getGender());
        dbManager.setString(4,prplaccidangersdDto.getBirthday());
        dbManager.setString(5,prplaccidangersdDto.getCredentialType());
        dbManager.setString(6,prplaccidangersdDto.getCredentialNo());
        dbManager.setString(7,prplaccidangersdDto.getIsRisk());
        dbManager.setInt(8,prplaccidangersdDto.getLossTimes());
        dbManager.setDouble(9,prplaccidangersdDto.getSumClaimAmount());
        dbManager.setInt(10,prplaccidangersdDto.getRefuseClaimTimes());
        dbManager.executePreparedUpdate();

    }

    /**
     * ��������ʽ�����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplaccidangersd (");
        buffer.append("Insuredname,");
        buffer.append("Serialno,");
        buffer.append("Gender,");
        buffer.append("Birthday,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno,");
        buffer.append("Isrisk,");
        buffer.append("Losstimes,");
        buffer.append("Sumclaimamount,");
        buffer.append("Refuseclaimtimes ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplaccidangersdDto prplaccidangersdDto = (PrplaccidangersdDto)i.next();
            dbManager.setString(1,prplaccidangersdDto.getInsuredName());
            dbManager.setInt(2,prplaccidangersdDto.getSerialNo());
            dbManager.setString(3,prplaccidangersdDto.getGender());
            dbManager.setString(4,prplaccidangersdDto.getBirthday());
            dbManager.setString(5,prplaccidangersdDto.getCredentialType());
            dbManager.setString(6,prplaccidangersdDto.getCredentialNo());
            dbManager.setString(7,prplaccidangersdDto.getIsRisk());
            dbManager.setInt(8,prplaccidangersdDto.getLossTimes());
            dbManager.setDouble(9,prplaccidangersdDto.getSumClaimAmount());
            dbManager.setInt(10,prplaccidangersdDto.getRefuseClaimTimes());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @throws Exception
     */
    public void delete(String insuredname,int serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplaccidangersd ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Insuredname=").append("'").append(insuredname).append("' AND ");
            debugBuffer.append("Serialno=").append("").append(serialno).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Insuredname = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,insuredname);
        dbManager.setInt(2,serialno);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prplaccidangersdDto prplaccidangersdDto
     * @throws Exception
     */
    public void update(PrplaccidangersdDto prplaccidangersdDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplaccidangersd SET ");
        buffer.append("Gender = ?, ");
        buffer.append("Birthday = ?, ");
        buffer.append("Credentialtype = ?, ");
        buffer.append("Credentialno = ?, ");
        buffer.append("Isrisk = ?, ");
        buffer.append("Losstimes = ?, ");
        buffer.append("Sumclaimamount = ?, ");
        buffer.append("Refuseclaimtimes = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplaccidangersd SET ");
            debugBuffer.append("Gender = '" + prplaccidangersdDto.getGender() + "', ");
            debugBuffer.append("Birthday = '" + prplaccidangersdDto.getBirthday() + "', ");
            debugBuffer.append("Credentialtype = '" + prplaccidangersdDto.getCredentialType() + "', ");
            debugBuffer.append("Credentialno = '" + prplaccidangersdDto.getCredentialNo() + "', ");
            debugBuffer.append("Isrisk = '" + prplaccidangersdDto.getIsRisk() + "', ");
            debugBuffer.append("Losstimes = " + prplaccidangersdDto.getLossTimes() + ", ");
            debugBuffer.append("Sumclaimamount = " + prplaccidangersdDto.getSumClaimAmount() + ", ");
            debugBuffer.append("Refuseclaimtimes = " + prplaccidangersdDto.getRefuseClaimTimes() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Insuredname=").append("'").append(prplaccidangersdDto.getInsuredName()).append("' AND ");
            debugBuffer.append("Serialno=").append("").append(prplaccidangersdDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Insuredname = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prplaccidangersdDto.getGender());
        dbManager.setString(2,prplaccidangersdDto.getBirthday());
        dbManager.setString(3,prplaccidangersdDto.getCredentialType());
        dbManager.setString(4,prplaccidangersdDto.getCredentialNo());
        dbManager.setString(5,prplaccidangersdDto.getIsRisk());
        dbManager.setInt(6,prplaccidangersdDto.getLossTimes());
        dbManager.setDouble(7,prplaccidangersdDto.getSumClaimAmount());
        dbManager.setInt(8,prplaccidangersdDto.getRefuseClaimTimes());
        //���������ֶ�;
        dbManager.setString(9,prplaccidangersdDto.getInsuredName());
        dbManager.setInt(10,prplaccidangersdDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @return PrplaccidangersdDto
     * @throws Exception
     */
    public PrplaccidangersdDto findByPrimaryKey(String insuredname,int serialno)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Insuredname,");
        buffer.append("Serialno,");
        buffer.append("Gender,");
        buffer.append("Birthday,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno,");
        buffer.append("Isrisk,");
        buffer.append("Losstimes,");
        buffer.append("Sumclaimamount,");
        buffer.append("Refuseclaimtimes ");
        buffer.append("FROM Prplaccidangersd ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Insuredname=").append("'").append(insuredname).append("' AND ");
            debugBuffer.append("Serialno=").append("").append(serialno).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Insuredname = ? And ");
        buffer.append("Serialno = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,insuredname);
        dbManager.setInt(2,serialno);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplaccidangersdDto prplaccidangersdDto = null;
        if(resultSet.next()){
            prplaccidangersdDto = new PrplaccidangersdDto();
            prplaccidangersdDto.setInsuredName(dbManager.getString(resultSet,1));
            prplaccidangersdDto.setSerialNo(dbManager.getInt(resultSet,2));
            prplaccidangersdDto.setGender(dbManager.getString(resultSet,3));
            prplaccidangersdDto.setBirthday(dbManager.getString(resultSet,4));
            prplaccidangersdDto.setCredentialType(dbManager.getString(resultSet,5));
            prplaccidangersdDto.setCredentialNo(dbManager.getString(resultSet,6));
            prplaccidangersdDto.setIsRisk(dbManager.getString(resultSet,7));
            prplaccidangersdDto.setLossTimes(dbManager.getInt(resultSet,8));
            prplaccidangersdDto.setSumClaimAmount(dbManager.getDouble(resultSet,9));
            prplaccidangersdDto.setRefuseClaimTimes(dbManager.getInt(resultSet,10));
        }
        resultSet.close();
        return prplaccidangersdDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Insuredname,");
        buffer.append("Serialno,");
        buffer.append("Gender,");
        buffer.append("Birthday,");
        buffer.append("Credentialtype,");
        buffer.append("Credentialno,");
        buffer.append("Isrisk,");
        buffer.append("Losstimes,");
        buffer.append("Sumclaimamount,");
        buffer.append("Refuseclaimtimes ");
        buffer.append("FROM Prplaccidangersd WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if (pageNo > 0){
            //��Oracle�Ż�
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

        //���巵�ؽ������
        Collection collection = new ArrayList(rowsPerPage);
        PrplaccidangersdDto prplaccidangersdDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplaccidangersdDto = new PrplaccidangersdDto();
            prplaccidangersdDto.setInsuredName(dbManager.getString(resultSet,"Insuredname"));
            prplaccidangersdDto.setSerialNo(dbManager.getInt(resultSet,"Serialno"));
            prplaccidangersdDto.setGender(dbManager.getString(resultSet,"Gender"));
            prplaccidangersdDto.setBirthday(dbManager.getString(resultSet,"Birthday"));
            prplaccidangersdDto.setCredentialType(dbManager.getString(resultSet,"Credentialtype"));
            prplaccidangersdDto.setCredentialNo(dbManager.getString(resultSet,"Credentialno"));
            prplaccidangersdDto.setIsRisk(dbManager.getString(resultSet,"Isrisk"));
            prplaccidangersdDto.setLossTimes(dbManager.getInt(resultSet,"Losstimes"));
            prplaccidangersdDto.setSumClaimAmount(dbManager.getDouble(resultSet,"Sumclaimamount"));
            prplaccidangersdDto.setRefuseClaimTimes(dbManager.getInt(resultSet,"Refuseclaimtimes"));
            collection.add(prplaccidangersdDto);
        }
        resultSet.close();
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions)
            throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplaccidangersd WHERE ");
        buffer.append(conditions);
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        int count = dbManager.executeUpdate(buffer.toString());
        return count;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(String conditions) 
        throws Exception{
        int count = -1;
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("SELECT count(*) FROM Prplaccidangersd WHERE ");
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

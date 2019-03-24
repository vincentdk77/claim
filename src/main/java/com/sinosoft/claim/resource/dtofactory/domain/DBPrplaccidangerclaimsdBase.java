package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrplaccidangerclaimsdDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCIDANGERCLAIMSD�����ݷ��ʶ������<br>
 */
public class DBPrplaccidangerclaimsdBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrplaccidangerclaimsdBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrplaccidangerclaimsdBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @throws Exception
     */
    public void insert(PrplaccidangerclaimsdDto prplaccidangerclaimsdDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Prplaccidangerclaimsd (");
        buffer.append("Insuredname,");
        buffer.append("Serialno,");
        buffer.append("Companycode,");
        buffer.append("Lossdate,");
        buffer.append("Lossresult,");
        buffer.append("Claimamount ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prplaccidangerclaimsdDto.getInsuredname()).append("',");
            debugBuffer.append("").append(prplaccidangerclaimsdDto.getSerialno()).append(",");
            debugBuffer.append("'").append(prplaccidangerclaimsdDto.getCompanycode()).append("',");
            debugBuffer.append("'").append(prplaccidangerclaimsdDto.getLossdate()).append("',");
            debugBuffer.append("'").append(prplaccidangerclaimsdDto.getLossresult()).append("',");
            debugBuffer.append("").append(prplaccidangerclaimsdDto.getClaimamount()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prplaccidangerclaimsdDto.getInsuredname());
        dbManager.setInt(2,prplaccidangerclaimsdDto.getSerialno());
        dbManager.setString(3,prplaccidangerclaimsdDto.getCompanycode());
        dbManager.setString(4,prplaccidangerclaimsdDto.getLossdate());
        dbManager.setString(5,prplaccidangerclaimsdDto.getLossresult());
        dbManager.setDouble(6,prplaccidangerclaimsdDto.getClaimamount());
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
        buffer.append("INSERT INTO Prplaccidangerclaimsd (");
        buffer.append("Insuredname,");
        buffer.append("Serialno,");
        buffer.append("Companycode,");
        buffer.append("Lossdate,");
        buffer.append("Lossresult,");
        buffer.append("Claimamount ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrplaccidangerclaimsdDto prplaccidangerclaimsdDto = (PrplaccidangerclaimsdDto)i.next();
            dbManager.setString(1,prplaccidangerclaimsdDto.getInsuredname());
            dbManager.setInt(2,prplaccidangerclaimsdDto.getSerialno());
            dbManager.setString(3,prplaccidangerclaimsdDto.getCompanycode());
            dbManager.setString(4,prplaccidangerclaimsdDto.getLossdate());
            dbManager.setString(5,prplaccidangerclaimsdDto.getLossresult());
            dbManager.setDouble(6,prplaccidangerclaimsdDto.getClaimamount());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @param companycode COMPANYCODE
     * @param lossdate LOSSDATE
     * @throws Exception
     */
    public void delete(String insuredname,int serialno,String companycode,String lossdate)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Prplaccidangerclaimsd ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Insuredname=").append("'").append(insuredname).append("' AND ");
            debugBuffer.append("Serialno=").append("").append(serialno).append(" AND ");
            debugBuffer.append("Companycode=").append("'").append(companycode).append("' AND ");
            debugBuffer.append("Lossdate=").append("'").append(lossdate).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Insuredname = ? And ");
        buffer.append("Serialno = ? And ");
        buffer.append("Companycode = ? And ");
        buffer.append("Lossdate = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,insuredname);
        dbManager.setInt(2,serialno);
        dbManager.setString(3,companycode);
        dbManager.setString(4,lossdate);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prplaccidangerclaimsdDto prplaccidangerclaimsdDto
     * @throws Exception
     */
    public void update(PrplaccidangerclaimsdDto prplaccidangerclaimsdDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Prplaccidangerclaimsd SET ");
        buffer.append("Lossresult = ?, ");
        buffer.append("Claimamount = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Prplaccidangerclaimsd SET ");
            debugBuffer.append("Lossresult = '" + prplaccidangerclaimsdDto.getLossresult() + "', ");
            debugBuffer.append("Claimamount = " + prplaccidangerclaimsdDto.getClaimamount() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Insuredname=").append("'").append(prplaccidangerclaimsdDto.getInsuredname()).append("' AND ");
            debugBuffer.append("Serialno=").append("").append(prplaccidangerclaimsdDto.getSerialno()).append(" AND ");
            debugBuffer.append("Companycode=").append("'").append(prplaccidangerclaimsdDto.getCompanycode()).append("' AND ");
            debugBuffer.append("Lossdate=").append("'").append(prplaccidangerclaimsdDto.getLossdate()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Insuredname = ? And ");
        buffer.append("Serialno = ? And ");
        buffer.append("Companycode = ? And ");
        buffer.append("Lossdate = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prplaccidangerclaimsdDto.getLossresult());
        dbManager.setDouble(2,prplaccidangerclaimsdDto.getClaimamount());
        //���������ֶ�;
        dbManager.setString(3,prplaccidangerclaimsdDto.getInsuredname());
        dbManager.setInt(4,prplaccidangerclaimsdDto.getSerialno());
        dbManager.setString(5,prplaccidangerclaimsdDto.getCompanycode());
        dbManager.setString(6,prplaccidangerclaimsdDto.getLossdate());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param insuredname INSUREDNAME
     * @param serialno SERIALNO
     * @param companycode COMPANYCODE
     * @param lossdate LOSSDATE
     * @return PrplaccidangerclaimsdDto
     * @throws Exception
     */
    public PrplaccidangerclaimsdDto findByPrimaryKey(String insuredname,int serialno,String companycode,String lossdate)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Insuredname,");
        buffer.append("Serialno,");
        buffer.append("Companycode,");
        buffer.append("Lossdate,");
        buffer.append("Lossresult,");
        buffer.append("Claimamount ");
        buffer.append("FROM Prplaccidangerclaimsd ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Insuredname=").append("'").append(insuredname).append("' AND ");
            debugBuffer.append("Serialno=").append("").append(serialno).append(" AND ");
            debugBuffer.append("Companycode=").append("'").append(companycode).append("' AND ");
            debugBuffer.append("Lossdate=").append("'").append(lossdate).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Insuredname = ? And ");
        buffer.append("Serialno = ? And ");
        buffer.append("Companycode = ? And ");
        buffer.append("Lossdate = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,insuredname);
        dbManager.setInt(2,serialno);
        dbManager.setString(3,companycode);
        dbManager.setString(4,lossdate);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrplaccidangerclaimsdDto prplaccidangerclaimsdDto = null;
        if(resultSet.next()){
            prplaccidangerclaimsdDto = new PrplaccidangerclaimsdDto();
            prplaccidangerclaimsdDto.setInsuredname(dbManager.getString(resultSet,1));
            prplaccidangerclaimsdDto.setSerialno(dbManager.getInt(resultSet,2));
            prplaccidangerclaimsdDto.setCompanycode(dbManager.getString(resultSet,3));
            prplaccidangerclaimsdDto.setLossdate(dbManager.getString(resultSet,4));
            prplaccidangerclaimsdDto.setLossresult(dbManager.getString(resultSet,5));
            prplaccidangerclaimsdDto.setClaimamount(dbManager.getDouble(resultSet,6));
        }
        resultSet.close();
        return prplaccidangerclaimsdDto;
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
        buffer.append("Companycode,");
        buffer.append("Lossdate,");
        buffer.append("Lossresult,");
        buffer.append("Claimamount ");
        buffer.append("FROM Prplaccidangerclaimsd WHERE ");
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
        PrplaccidangerclaimsdDto prplaccidangerclaimsdDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prplaccidangerclaimsdDto = new PrplaccidangerclaimsdDto();
            prplaccidangerclaimsdDto.setInsuredname(dbManager.getString(resultSet,"Insuredname"));
            prplaccidangerclaimsdDto.setSerialno(dbManager.getInt(resultSet,"Serialno"));
            prplaccidangerclaimsdDto.setCompanycode(dbManager.getString(resultSet,"Companycode"));
            prplaccidangerclaimsdDto.setLossdate(dbManager.getString(resultSet,"Lossdate"));
            prplaccidangerclaimsdDto.setLossresult(dbManager.getString(resultSet,"Lossresult"));
            prplaccidangerclaimsdDto.setClaimamount(dbManager.getDouble(resultSet,"Claimamount"));
            collection.add(prplaccidangerclaimsdDto);
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
        buffer.append("DELETE FROM Prplaccidangerclaimsd WHERE ");
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
        buffer.append("SELECT count(*) FROM Prplaccidangerclaimsd WHERE ");
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

package com.sinosoft.NXCaseUp.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.NXCaseUp.dto.domain.CasefarmerDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����CASEFARMER�����ݷ��ʶ������<br>
 * ������ 2015-09-25 12:30:11.531<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBCasefarmerBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBCasefarmerBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBCasefarmerBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param casefarmerDto casefarmerDto
     * @throws Exception
     */
    public void insert(CasefarmerDto casefarmerDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO Casefarmer (");
        buffer.append("Farmername,");
        buffer.append("Farmeridnumber,");
        buffer.append("Farmerphone,");
        buffer.append("Insureobiectnumber,");
        buffer.append("Lossdegree,");
        buffer.append("Settleamount,");
        buffer.append("Settlesumamount,");
        buffer.append("Serino,");
        buffer.append("Affectedarea,");
        buffer.append("Damagedarea,");
        buffer.append("Lossarea,");
        buffer.append("Measuremantunit,");
        buffer.append("Caseno,");
        buffer.append("Farmeridtype,");
        buffer.append("Settleobjectnumber,");
        buffer.append("Prepaidamount ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(casefarmerDto.getFarmername()).append("',");
            debugBuffer.append("'").append(casefarmerDto.getFarmeridnumber()).append("',");
            debugBuffer.append("'").append(casefarmerDto.getFarmerphone()).append("',");
            debugBuffer.append("").append(casefarmerDto.getInsureobiectnumber()).append(",");
            debugBuffer.append("").append(casefarmerDto.getLossdegree()).append(",");
            debugBuffer.append("").append(casefarmerDto.getSettleamount()).append(",");
            debugBuffer.append("").append(casefarmerDto.getSettlesumamount()).append(",");
            debugBuffer.append("").append(casefarmerDto.getSerino()).append(",");
            debugBuffer.append("").append(casefarmerDto.getAffectedarea()).append(",");
            debugBuffer.append("").append(casefarmerDto.getDamagedarea()).append(",");
            debugBuffer.append("").append(casefarmerDto.getLossarea()).append(",");
            debugBuffer.append("'").append(casefarmerDto.getMeasuremantunit()).append("',");
            debugBuffer.append("'").append(casefarmerDto.getCaseno()).append("',");
            debugBuffer.append("'").append(casefarmerDto.getFarmeridtype()).append("',");
            debugBuffer.append("").append(casefarmerDto.getSettleobjectnumber()).append(",");
            debugBuffer.append("").append(casefarmerDto.getPrepaidamount()).append(")");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,casefarmerDto.getFarmername());
        dbManager.setString(2,casefarmerDto.getFarmeridnumber());
        dbManager.setString(3,casefarmerDto.getFarmerphone());
        dbManager.setDouble(4,casefarmerDto.getInsureobiectnumber());
        dbManager.setDouble(5,casefarmerDto.getLossdegree());
        dbManager.setDouble(6,casefarmerDto.getSettleamount());
        dbManager.setDouble(7,casefarmerDto.getSettlesumamount());
        dbManager.setLong(8,casefarmerDto.getSerino());
        dbManager.setDouble(9,casefarmerDto.getAffectedarea());
        dbManager.setDouble(10,casefarmerDto.getDamagedarea());
        dbManager.setDouble(11,casefarmerDto.getLossarea());
        dbManager.setString(12,casefarmerDto.getMeasuremantunit());
        dbManager.setString(13,casefarmerDto.getCaseno());
        dbManager.setString(14,casefarmerDto.getFarmeridtype());
        dbManager.setDouble(15,casefarmerDto.getSettleobjectnumber());
        dbManager.setDouble(16,casefarmerDto.getPrepaidamount());
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
        buffer.append("INSERT INTO Casefarmer (");
        buffer.append("Farmername,");
        buffer.append("Farmeridnumber,");
        buffer.append("Farmerphone,");
        buffer.append("Insureobiectnumber,");
        buffer.append("Lossdegree,");
        buffer.append("Settleamount,");
        buffer.append("Settlesumamount,");
        buffer.append("Serino,");
        buffer.append("Affectedarea,");
        buffer.append("Damagedarea,");
        buffer.append("Lossarea,");
        buffer.append("Measuremantunit,");
        buffer.append("Caseno,");
        buffer.append("Farmeridtype,");
        buffer.append("Settleobjectnumber,");
        buffer.append("Prepaidamount ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            CasefarmerDto casefarmerDto = (CasefarmerDto)i.next();
            dbManager.setString(1,casefarmerDto.getFarmername());
            dbManager.setString(2,casefarmerDto.getFarmeridnumber());
            dbManager.setString(3,casefarmerDto.getFarmerphone());
            dbManager.setDouble(4,casefarmerDto.getInsureobiectnumber());
            dbManager.setDouble(5,casefarmerDto.getLossdegree());
            dbManager.setDouble(6,casefarmerDto.getSettleamount());
            dbManager.setDouble(7,casefarmerDto.getSettlesumamount());
            dbManager.setLong(8,casefarmerDto.getSerino());
            dbManager.setDouble(9,casefarmerDto.getAffectedarea());
            dbManager.setDouble(10,casefarmerDto.getDamagedarea());
            dbManager.setDouble(11,casefarmerDto.getLossarea());
            dbManager.setString(12,casefarmerDto.getMeasuremantunit());
            dbManager.setString(13,casefarmerDto.getCaseno());
            dbManager.setString(14,casefarmerDto.getFarmeridtype());
            dbManager.setDouble(15,casefarmerDto.getSettleobjectnumber());
            dbManager.setDouble(16,casefarmerDto.getPrepaidamount());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param farmername FARMERNAME
     * @throws Exception
     */
    public void delete(String farmername)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM Casefarmer ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Farmername=").append("'").append(farmername).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Farmername = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,farmername);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param casefarmerDto casefarmerDto
     * @throws Exception
     */
    public void update(CasefarmerDto casefarmerDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE Casefarmer SET ");
        buffer.append("Farmeridnumber = ?, ");
        buffer.append("Farmerphone = ?, ");
        buffer.append("Insureobiectnumber = ?, ");
        buffer.append("Lossdegree = ?, ");
        buffer.append("Settleamount = ?, ");
        buffer.append("Settlesumamount = ?, ");
        buffer.append("Serino = ?, ");
        buffer.append("Affectedarea = ?, ");
        buffer.append("Damagedarea = ?, ");
        buffer.append("Lossarea = ?, ");
        buffer.append("Measuremantunit = ?, ");
        buffer.append("Caseno = ?, ");
        buffer.append("Farmeridtype = ?, ");
        buffer.append("Settleobjectnumber = ?, ");
        buffer.append("Prepaidamount = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE Casefarmer SET ");
            debugBuffer.append("Farmeridnumber = '" + casefarmerDto.getFarmeridnumber() + "', ");
            debugBuffer.append("Farmerphone = '" + casefarmerDto.getFarmerphone() + "', ");
            debugBuffer.append("Insureobiectnumber = " + casefarmerDto.getInsureobiectnumber() + ", ");
            debugBuffer.append("Lossdegree = " + casefarmerDto.getLossdegree() + ", ");
            debugBuffer.append("Settleamount = " + casefarmerDto.getSettleamount() + ", ");
            debugBuffer.append("Settlesumamount = " + casefarmerDto.getSettlesumamount() + ", ");
            debugBuffer.append("Serino = " + casefarmerDto.getSerino() + ", ");
            debugBuffer.append("Affectedarea = " + casefarmerDto.getAffectedarea() + ", ");
            debugBuffer.append("Damagedarea = " + casefarmerDto.getDamagedarea() + ", ");
            debugBuffer.append("Lossarea = " + casefarmerDto.getLossarea() + ", ");
            debugBuffer.append("Measuremantunit = '" + casefarmerDto.getMeasuremantunit() + "', ");
            debugBuffer.append("Caseno = '" + casefarmerDto.getCaseno() + "', ");
            debugBuffer.append("Farmeridtype = '" + casefarmerDto.getFarmeridtype() + "', ");
            debugBuffer.append("Settleobjectnumber = " + casefarmerDto.getSettleobjectnumber() + ", ");
            debugBuffer.append("Prepaidamount = " + casefarmerDto.getPrepaidamount() + " ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Farmername=").append("'").append(casefarmerDto.getFarmername()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Farmername = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,casefarmerDto.getFarmeridnumber());
        dbManager.setString(2,casefarmerDto.getFarmerphone());
        dbManager.setDouble(3,casefarmerDto.getInsureobiectnumber());
        dbManager.setDouble(4,casefarmerDto.getLossdegree());
        dbManager.setDouble(5,casefarmerDto.getSettleamount());
        dbManager.setDouble(6,casefarmerDto.getSettlesumamount());
        dbManager.setLong(7,casefarmerDto.getSerino());
        dbManager.setDouble(8,casefarmerDto.getAffectedarea());
        dbManager.setDouble(9,casefarmerDto.getDamagedarea());
        dbManager.setDouble(10,casefarmerDto.getLossarea());
        dbManager.setString(11,casefarmerDto.getMeasuremantunit());
        dbManager.setString(12,casefarmerDto.getCaseno());
        dbManager.setString(13,casefarmerDto.getFarmeridtype());
        dbManager.setDouble(14,casefarmerDto.getSettleobjectnumber());
        dbManager.setDouble(15,casefarmerDto.getPrepaidamount());
        //���������ֶ�;
        dbManager.setString(16,casefarmerDto.getFarmername());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param farmername FARMERNAME
     * @return CasefarmerDto
     * @throws Exception
     */
    public CasefarmerDto findByPrimaryKey(String farmername)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Farmername,");
        buffer.append("Farmeridnumber,");
        buffer.append("Farmerphone,");
        buffer.append("Insureobiectnumber,");
        buffer.append("Lossdegree,");
        buffer.append("Settleamount,");
        buffer.append("Settlesumamount,");
        buffer.append("Serino,");
        buffer.append("Affectedarea,");
        buffer.append("Damagedarea,");
        buffer.append("Lossarea,");
        buffer.append("Measuremantunit,");
        buffer.append("Caseno,");
        buffer.append("Farmeridtype,");
        buffer.append("Settleobjectnumber,");
        buffer.append("Prepaidamount ");
        buffer.append("FROM Casefarmer ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Farmername=").append("'").append(farmername).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Farmername = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,farmername);
        ResultSet resultSet = dbManager.executePreparedQuery();
        CasefarmerDto casefarmerDto = null;
        if(resultSet.next()){
            casefarmerDto = new CasefarmerDto();
            casefarmerDto.setFarmername(dbManager.getString(resultSet,1));
            casefarmerDto.setFarmeridnumber(dbManager.getString(resultSet,2));
            casefarmerDto.setFarmerphone(dbManager.getString(resultSet,3));
            casefarmerDto.setInsureobiectnumber(dbManager.getDouble(resultSet,4));
            casefarmerDto.setLossdegree(dbManager.getDouble(resultSet,5));
            casefarmerDto.setSettleamount(dbManager.getDouble(resultSet,6));
            casefarmerDto.setSettlesumamount(dbManager.getDouble(resultSet,7));
            casefarmerDto.setSerino(dbManager.getLong(resultSet,8));
            casefarmerDto.setAffectedarea(dbManager.getDouble(resultSet,9));
            casefarmerDto.setDamagedarea(dbManager.getDouble(resultSet,10));
            casefarmerDto.setLossarea(dbManager.getDouble(resultSet,11));
            casefarmerDto.setMeasuremantunit(dbManager.getString(resultSet,12));
            casefarmerDto.setCaseno(dbManager.getString(resultSet,13));
            casefarmerDto.setFarmeridtype(dbManager.getString(resultSet,14));
            casefarmerDto.setSettleobjectnumber(dbManager.getDouble(resultSet,15));
            casefarmerDto.setPrepaidamount(dbManager.getDouble(resultSet,16));
        }
        resultSet.close();
        return casefarmerDto;
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
        buffer.append("Farmername,");
        buffer.append("Farmeridnumber,");
        buffer.append("Farmerphone,");
        buffer.append("Insureobiectnumber,");
        buffer.append("Lossdegree,");
        buffer.append("Settleamount,");
        buffer.append("Settlesumamount,");
        buffer.append("Serino,");
        buffer.append("Affectedarea,");
        buffer.append("Damagedarea,");
        buffer.append("Lossarea,");
        buffer.append("Measuremantunit,");
        buffer.append("Caseno,");
        buffer.append("Farmeridtype,");
        buffer.append("Settleobjectnumber,");
        buffer.append("Prepaidamount ");
        buffer.append("FROM Casefarmer WHERE ");
        buffer.append(conditions);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        if (pageNo > 0){
            //Ŀǰֻ��Oracle�Ż�
            if(dbManager.getConnection().getMetaData().getDatabaseProductName().equalsIgnoreCase("Oracle")){
                buffer.insert(0,"SELECT * FROM ( SELECT row_.*, rownum rownum_ FROM (");
                buffer.append(") row_ WHERE rownum <= "+rowsPerPage * pageNo+") WHERE rownum_ > "+rowsPerPage * (pageNo - 1));
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
        CasefarmerDto casefarmerDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            casefarmerDto = new CasefarmerDto();
            casefarmerDto.setFarmername(dbManager.getString(resultSet,1));
            casefarmerDto.setFarmeridnumber(dbManager.getString(resultSet,2));
            casefarmerDto.setFarmerphone(dbManager.getString(resultSet,3));
            casefarmerDto.setInsureobiectnumber(dbManager.getDouble(resultSet,4));
            casefarmerDto.setLossdegree(dbManager.getDouble(resultSet,5));
            casefarmerDto.setSettleamount(dbManager.getDouble(resultSet,6));
            casefarmerDto.setSettlesumamount(dbManager.getDouble(resultSet,7));
            casefarmerDto.setSerino(dbManager.getLong(resultSet,8));
            casefarmerDto.setAffectedarea(dbManager.getDouble(resultSet,9));
            casefarmerDto.setDamagedarea(dbManager.getDouble(resultSet,10));
            casefarmerDto.setLossarea(dbManager.getDouble(resultSet,11));
            casefarmerDto.setMeasuremantunit(dbManager.getString(resultSet,12));
            casefarmerDto.setCaseno(dbManager.getString(resultSet,13));
            casefarmerDto.setFarmeridtype(dbManager.getString(resultSet,14));
            casefarmerDto.setSettleobjectnumber(dbManager.getDouble(resultSet,15));
            casefarmerDto.setPrepaidamount(dbManager.getDouble(resultSet,16));
            collection.add(casefarmerDto);
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
        buffer.append("DELETE FROM Casefarmer WHERE ");
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
        buffer.append("SELECT count(1) FROM (SELECT * FROM Casefarmer WHERE ");
        buffer.append(conditions);
        buffer.append(")");
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

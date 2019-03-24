package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvDetailDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ�������嵥��Ϣ��ϸ������ݷ��ʶ������<br>
 */
public class DBPrpLinterCompeInvDetailBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterCompeInvDetailBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterCompeInvDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public void insert(PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterCompeInvDetail (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("DetilSerialNo,");
        buffer.append("Name,");
        buffer.append("MedicalCard,");
        buffer.append("IdCard,");
        buffer.append("SumInsured,");
        buffer.append("SettleSum,");
        buffer.append("MedicalFamily,");
        buffer.append("Bank,");
        buffer.append("CreditCard ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterCompeInvDetailDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterCompeInvDetailDto.getSerialNo()).append(",");
            debugBuffer.append("").append(prpLinterCompeInvDetailDto.getDetilSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterCompeInvDetailDto.getName()).append("',");
            debugBuffer.append("'").append(prpLinterCompeInvDetailDto.getMedicalCard()).append("',");
            debugBuffer.append("'").append(prpLinterCompeInvDetailDto.getIdCard()).append("',");
            debugBuffer.append("").append(prpLinterCompeInvDetailDto.getSumInsured()).append(",");
            debugBuffer.append("").append(prpLinterCompeInvDetailDto.getSettleSum()).append(",");
            debugBuffer.append("'").append(prpLinterCompeInvDetailDto.getMedicalFamily()).append("',");
            debugBuffer.append("'").append(prpLinterCompeInvDetailDto.getBank()).append("',");
            debugBuffer.append("'").append(prpLinterCompeInvDetailDto.getCreditCard()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterCompeInvDetailDto.getId());
        dbManager.setInt(2,prpLinterCompeInvDetailDto.getSerialNo());
        dbManager.setInt(3,prpLinterCompeInvDetailDto.getDetilSerialNo());
        dbManager.setString(4,prpLinterCompeInvDetailDto.getName());
        dbManager.setString(5,prpLinterCompeInvDetailDto.getMedicalCard());
        dbManager.setString(6,prpLinterCompeInvDetailDto.getIdCard());
        dbManager.setDouble(7,prpLinterCompeInvDetailDto.getSumInsured());
        dbManager.setDouble(8,prpLinterCompeInvDetailDto.getSettleSum());
        dbManager.setString(9,prpLinterCompeInvDetailDto.getMedicalFamily());
        dbManager.setString(10,prpLinterCompeInvDetailDto.getBank());
        dbManager.setString(11,prpLinterCompeInvDetailDto.getCreditCard());
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
        buffer.append("INSERT INTO PrpLinterCompeInvDetail (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("DetilSerialNo,");
        buffer.append("Name,");
        buffer.append("MedicalCard,");
        buffer.append("IdCard,");
        buffer.append("SumInsured,");
        buffer.append("SettleSum,");
        buffer.append("MedicalFamily,");
        buffer.append("Bank,");
        buffer.append("CreditCard ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto = (PrpLinterCompeInvDetailDto)i.next();
            dbManager.setString(1,prpLinterCompeInvDetailDto.getId());
            dbManager.setInt(2,prpLinterCompeInvDetailDto.getSerialNo());
            dbManager.setInt(3,prpLinterCompeInvDetailDto.getDetilSerialNo());
            dbManager.setString(4,prpLinterCompeInvDetailDto.getName());
            dbManager.setString(5,prpLinterCompeInvDetailDto.getMedicalCard());
            dbManager.setString(6,prpLinterCompeInvDetailDto.getIdCard());
            dbManager.setDouble(7,prpLinterCompeInvDetailDto.getSumInsured());
            dbManager.setDouble(8,prpLinterCompeInvDetailDto.getSettleSum());
            dbManager.setString(9,prpLinterCompeInvDetailDto.getMedicalFamily());
            dbManager.setString(10,prpLinterCompeInvDetailDto.getBank());
            dbManager.setString(11,prpLinterCompeInvDetailDto.getCreditCard());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ����pk
     * @param serialNo �嵥�������
     * @param detilSerialNo �嵥��ϸ���
     * @throws Exception
     */
    public void delete(String id,int serialNo,int detilSerialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterCompeInvDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("DetilSerialNo=").append("").append(detilSerialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("DetilSerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,detilSerialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLinterCompeInvDetailDto prpLinterCompeInvDetailDto
     * @throws Exception
     */
    public void update(PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterCompeInvDetail SET ");
        buffer.append("Name = ?, ");
        buffer.append("MedicalCard = ?, ");
        buffer.append("IdCard = ?, ");
        buffer.append("SumInsured = ?, ");
        buffer.append("SettleSum = ?, ");
        buffer.append("MedicalFamily = ?, ");
        buffer.append("Bank = ?, ");
        buffer.append("CreditCard = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterCompeInvDetail SET ");
            debugBuffer.append("Name = '" + prpLinterCompeInvDetailDto.getName() + "', ");
            debugBuffer.append("MedicalCard = '" + prpLinterCompeInvDetailDto.getMedicalCard() + "', ");
            debugBuffer.append("IdCard = '" + prpLinterCompeInvDetailDto.getIdCard() + "', ");
            debugBuffer.append("SumInsured = " + prpLinterCompeInvDetailDto.getSumInsured() + ", ");
            debugBuffer.append("SettleSum = " + prpLinterCompeInvDetailDto.getSettleSum() + ", ");
            debugBuffer.append("MedicalFamily = '" + prpLinterCompeInvDetailDto.getMedicalFamily() + "', ");
            debugBuffer.append("Bank = '" + prpLinterCompeInvDetailDto.getBank() + "', ");
            debugBuffer.append("CreditCard = '" + prpLinterCompeInvDetailDto.getCreditCard() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterCompeInvDetailDto.getId()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLinterCompeInvDetailDto.getSerialNo()).append(" AND ");
            debugBuffer.append("DetilSerialNo=").append("").append(prpLinterCompeInvDetailDto.getDetilSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("DetilSerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLinterCompeInvDetailDto.getName());
        dbManager.setString(2,prpLinterCompeInvDetailDto.getMedicalCard());
        dbManager.setString(3,prpLinterCompeInvDetailDto.getIdCard());
        dbManager.setDouble(4,prpLinterCompeInvDetailDto.getSumInsured());
        dbManager.setDouble(5,prpLinterCompeInvDetailDto.getSettleSum());
        dbManager.setString(6,prpLinterCompeInvDetailDto.getMedicalFamily());
        dbManager.setString(7,prpLinterCompeInvDetailDto.getBank());
        dbManager.setString(8,prpLinterCompeInvDetailDto.getCreditCard());
        //���������ֶ�;
        dbManager.setString(9,prpLinterCompeInvDetailDto.getId());
        dbManager.setInt(10,prpLinterCompeInvDetailDto.getSerialNo());
        dbManager.setInt(11,prpLinterCompeInvDetailDto.getDetilSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����pk
     * @param serialNo �嵥�������
     * @param detilSerialNo �嵥��ϸ���
     * @return PrpLinterCompeInvDetailDto
     * @throws Exception
     */
    public PrpLinterCompeInvDetailDto findByPrimaryKey(String id,int serialNo,int detilSerialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("DetilSerialNo,");
        buffer.append("Name,");
        buffer.append("MedicalCard,");
        buffer.append("IdCard,");
        buffer.append("SumInsured,");
        buffer.append("SettleSum,");
        buffer.append("MedicalFamily,");
        buffer.append("Bank,");
        buffer.append("CreditCard ");
        buffer.append("FROM PrpLinterCompeInvDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append(" AND ");
            debugBuffer.append("DetilSerialNo=").append("").append(detilSerialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ? And ");
        buffer.append("DetilSerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.setInt(2,serialNo);
        dbManager.setInt(3,detilSerialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto = null;
        if(resultSet.next()){
            prpLinterCompeInvDetailDto = new PrpLinterCompeInvDetailDto();
            prpLinterCompeInvDetailDto.setId(dbManager.getString(resultSet,1));
            prpLinterCompeInvDetailDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterCompeInvDetailDto.setDetilSerialNo(dbManager.getInt(resultSet,3));
            prpLinterCompeInvDetailDto.setName(dbManager.getString(resultSet,4));
            prpLinterCompeInvDetailDto.setMedicalCard(dbManager.getString(resultSet,5));
            prpLinterCompeInvDetailDto.setIdCard(dbManager.getString(resultSet,6));
            prpLinterCompeInvDetailDto.setSumInsured(dbManager.getDouble(resultSet,7));
            prpLinterCompeInvDetailDto.setSettleSum(dbManager.getDouble(resultSet,8));
            prpLinterCompeInvDetailDto.setMedicalFamily(dbManager.getString(resultSet,9));
            prpLinterCompeInvDetailDto.setBank(dbManager.getString(resultSet,10));
            prpLinterCompeInvDetailDto.setCreditCard(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        return prpLinterCompeInvDetailDto;
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
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("DetilSerialNo,");
        buffer.append("Name,");
        buffer.append("MedicalCard,");
        buffer.append("IdCard,");
        buffer.append("SumInsured,");
        buffer.append("SettleSum,");
        buffer.append("MedicalFamily,");
        buffer.append("Bank,");
        buffer.append("CreditCard ");
        buffer.append("FROM PrpLinterCompeInvDetail WHERE ");
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
        PrpLinterCompeInvDetailDto prpLinterCompeInvDetailDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterCompeInvDetailDto = new PrpLinterCompeInvDetailDto();
            prpLinterCompeInvDetailDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterCompeInvDetailDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterCompeInvDetailDto.setDetilSerialNo(dbManager.getInt(resultSet,"DetilSerialNo"));
            prpLinterCompeInvDetailDto.setName(dbManager.getString(resultSet,"Name"));
            prpLinterCompeInvDetailDto.setMedicalCard(dbManager.getString(resultSet,"MedicalCard"));
            prpLinterCompeInvDetailDto.setIdCard(dbManager.getString(resultSet,"IdCard"));
            prpLinterCompeInvDetailDto.setSumInsured(dbManager.getDouble(resultSet,"SumInsured"));
            prpLinterCompeInvDetailDto.setSettleSum(dbManager.getDouble(resultSet,"SettleSum"));
            prpLinterCompeInvDetailDto.setMedicalFamily(dbManager.getString(resultSet,"MedicalFamily"));
            prpLinterCompeInvDetailDto.setBank(dbManager.getString(resultSet,"Bank"));
            prpLinterCompeInvDetailDto.setCreditCard(dbManager.getString(resultSet,"CreditCard"));
            collection.add(prpLinterCompeInvDetailDto);
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
        buffer.append("DELETE FROM PrpLinterCompeInvDetail WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterCompeInvDetail WHERE ");
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

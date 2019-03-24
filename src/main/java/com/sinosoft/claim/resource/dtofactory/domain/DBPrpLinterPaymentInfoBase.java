package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�������ӱ�-----�⸶��Ϣ�����ݷ��ʶ������<br>
 */
public class DBPrpLinterPaymentInfoBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterPaymentInfoBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterPaymentInfoBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @throws Exception
     */
    public void insert(PrpLinterPaymentInfoDto prpLinterPaymentInfoDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterPaymentInfo (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("RegistNoPay,");
        buffer.append("InsuredNamePay,");
        buffer.append("CertiNoPay,");
        buffer.append("PaymentType,");
        buffer.append("PaymentTypeCode,");
        buffer.append("SumPaidPay,");
        buffer.append("HavPaidPay,");
        buffer.append("PaidPay,");
        buffer.append("RelationOutId,");
        buffer.append("RelationOutIdType ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterPaymentInfoDto.getId()).append("',");
            debugBuffer.append("").append(prpLinterPaymentInfoDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLinterPaymentInfoDto.getRegistNoPay()).append("',");
            debugBuffer.append("'").append(prpLinterPaymentInfoDto.getInsuredNamePay()).append("',");
            debugBuffer.append("'").append(prpLinterPaymentInfoDto.getCertiNoPay()).append("',");
            debugBuffer.append("'").append(prpLinterPaymentInfoDto.getPaymentType()).append("',");
            debugBuffer.append("'").append(prpLinterPaymentInfoDto.getPaymentTypeCode()).append("',");
            debugBuffer.append("").append(prpLinterPaymentInfoDto.getSumPaidPay()).append(",");
            debugBuffer.append("").append(prpLinterPaymentInfoDto.getHavPaidPay()).append(",");
            debugBuffer.append("").append(prpLinterPaymentInfoDto.getPaidPay()).append(",");
            debugBuffer.append("'").append(prpLinterPaymentInfoDto.getRelationOutId()).append("',");
            debugBuffer.append("'").append(prpLinterPaymentInfoDto.getRelationOutIdType()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterPaymentInfoDto.getId());
        dbManager.setInt(2,prpLinterPaymentInfoDto.getSerialNo());
        dbManager.setString(3,prpLinterPaymentInfoDto.getRegistNoPay());
        dbManager.setString(4,prpLinterPaymentInfoDto.getInsuredNamePay());
        dbManager.setString(5,prpLinterPaymentInfoDto.getCertiNoPay());
        dbManager.setString(6,prpLinterPaymentInfoDto.getPaymentType());
        dbManager.setString(7,prpLinterPaymentInfoDto.getPaymentTypeCode());
        dbManager.setDouble(8,prpLinterPaymentInfoDto.getSumPaidPay());
        dbManager.setDouble(9,prpLinterPaymentInfoDto.getHavPaidPay());
        dbManager.setDouble(10,prpLinterPaymentInfoDto.getPaidPay());
        dbManager.setString(11,prpLinterPaymentInfoDto.getRelationOutId());
        dbManager.setString(12,prpLinterPaymentInfoDto.getRelationOutIdType());
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
        buffer.append("INSERT INTO PrpLinterPaymentInfo (");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("RegistNoPay,");
        buffer.append("InsuredNamePay,");
        buffer.append("CertiNoPay,");
        buffer.append("PaymentType,");
        buffer.append("PaymentTypeCode,");
        buffer.append("SumPaidPay,");
        buffer.append("HavPaidPay,");
        buffer.append("PaidPay,");
        buffer.append("RelationOutId,");
        buffer.append("RelationOutIdType ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterPaymentInfoDto prpLinterPaymentInfoDto = (PrpLinterPaymentInfoDto)i.next();
            dbManager.setString(1,prpLinterPaymentInfoDto.getId());
            dbManager.setInt(2,prpLinterPaymentInfoDto.getSerialNo());
            dbManager.setString(3,prpLinterPaymentInfoDto.getRegistNoPay());
            dbManager.setString(4,prpLinterPaymentInfoDto.getInsuredNamePay());
            dbManager.setString(5,prpLinterPaymentInfoDto.getCertiNoPay());
            dbManager.setString(6,prpLinterPaymentInfoDto.getPaymentType());
            dbManager.setString(7,prpLinterPaymentInfoDto.getPaymentTypeCode());
            dbManager.setDouble(8,prpLinterPaymentInfoDto.getSumPaidPay());
            dbManager.setDouble(9,prpLinterPaymentInfoDto.getHavPaidPay());
            dbManager.setDouble(10,prpLinterPaymentInfoDto.getPaidPay());
            dbManager.setString(11,prpLinterPaymentInfoDto.getRelationOutId());
            dbManager.setString(12,prpLinterPaymentInfoDto.getRelationOutIdType());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ����id PK
     * @param serialNo ������� PK
     * @throws Exception
     */
    public void delete(String id,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterPaymentInfo ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLinterPaymentInfoDto prpLinterPaymentInfoDto
     * @throws Exception
     */
    public void update(PrpLinterPaymentInfoDto prpLinterPaymentInfoDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterPaymentInfo SET ");
        buffer.append("RegistNoPay = ?, ");
        buffer.append("InsuredNamePay = ?, ");
        buffer.append("CertiNoPay = ?, ");
        buffer.append("PaymentType = ?, ");
        buffer.append("PaymentTypeCode = ?, ");
        buffer.append("SumPaidPay = ?, ");
        buffer.append("HavPaidPay = ?, ");
        buffer.append("PaidPay = ?, ");
        buffer.append("RelationOutId = ?, ");
        buffer.append("RelationOutIdType = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterPaymentInfo SET ");
            debugBuffer.append("RegistNoPay = '" + prpLinterPaymentInfoDto.getRegistNoPay() + "', ");
            debugBuffer.append("InsuredNamePay = '" + prpLinterPaymentInfoDto.getInsuredNamePay() + "', ");
            debugBuffer.append("CertiNoPay = '" + prpLinterPaymentInfoDto.getCertiNoPay() + "', ");
            debugBuffer.append("PaymentType = '" + prpLinterPaymentInfoDto.getPaymentType() + "', ");
            debugBuffer.append("PaymentTypeCode = '" + prpLinterPaymentInfoDto.getPaymentTypeCode() + "', ");
            debugBuffer.append("SumPaidPay = " + prpLinterPaymentInfoDto.getSumPaidPay() + ", ");
            debugBuffer.append("HavPaidPay = " + prpLinterPaymentInfoDto.getHavPaidPay() + ", ");
            debugBuffer.append("PaidPay = " + prpLinterPaymentInfoDto.getPaidPay() + ", ");
            debugBuffer.append("RelationOutId = '" + prpLinterPaymentInfoDto.getRelationOutId() + "', ");
            debugBuffer.append("RelationOutIdType = '" + prpLinterPaymentInfoDto.getRelationOutIdType() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterPaymentInfoDto.getId()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLinterPaymentInfoDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLinterPaymentInfoDto.getRegistNoPay());
        dbManager.setString(2,prpLinterPaymentInfoDto.getInsuredNamePay());
        dbManager.setString(3,prpLinterPaymentInfoDto.getCertiNoPay());
        dbManager.setString(4,prpLinterPaymentInfoDto.getPaymentType());
        dbManager.setString(5,prpLinterPaymentInfoDto.getPaymentTypeCode());
        dbManager.setDouble(6,prpLinterPaymentInfoDto.getSumPaidPay());
        dbManager.setDouble(7,prpLinterPaymentInfoDto.getHavPaidPay());
        dbManager.setDouble(8,prpLinterPaymentInfoDto.getPaidPay());
        dbManager.setString(9,prpLinterPaymentInfoDto.getRelationOutId());
        dbManager.setString(10,prpLinterPaymentInfoDto.getRelationOutIdType());
        //���������ֶ�;
        dbManager.setString(11,prpLinterPaymentInfoDto.getId());
        dbManager.setInt(12,prpLinterPaymentInfoDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����id PK
     * @param serialNo ������� PK
     * @return PrpLinterPaymentInfoDto
     * @throws Exception
     */
    public PrpLinterPaymentInfoDto findByPrimaryKey(String id,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("SerialNo,");
        buffer.append("RegistNoPay,");
        buffer.append("InsuredNamePay,");
        buffer.append("CertiNoPay,");
        buffer.append("PaymentType,");
        buffer.append("PaymentTypeCode,");
        buffer.append("SumPaidPay,");
        buffer.append("HavPaidPay,");
        buffer.append("PaidPay,");
        buffer.append("RelationOutId,");
        buffer.append("RelationOutIdType ");
        buffer.append("FROM PrpLinterPaymentInfo ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterPaymentInfoDto prpLinterPaymentInfoDto = null;
        if(resultSet.next()){
            prpLinterPaymentInfoDto = new PrpLinterPaymentInfoDto();
            prpLinterPaymentInfoDto.setId(dbManager.getString(resultSet,1));
            prpLinterPaymentInfoDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLinterPaymentInfoDto.setRegistNoPay(dbManager.getString(resultSet,3));
            prpLinterPaymentInfoDto.setInsuredNamePay(dbManager.getString(resultSet,4));
            prpLinterPaymentInfoDto.setCertiNoPay(dbManager.getString(resultSet,5));
            prpLinterPaymentInfoDto.setPaymentType(dbManager.getString(resultSet,6));
            prpLinterPaymentInfoDto.setPaymentTypeCode(dbManager.getString(resultSet,7));
            prpLinterPaymentInfoDto.setSumPaidPay(dbManager.getDouble(resultSet,8));
            prpLinterPaymentInfoDto.setHavPaidPay(dbManager.getDouble(resultSet,9));
            prpLinterPaymentInfoDto.setPaidPay(dbManager.getDouble(resultSet,10));
            prpLinterPaymentInfoDto.setRelationOutId(dbManager.getString(resultSet,11));
            prpLinterPaymentInfoDto.setRelationOutIdType(dbManager.getString(resultSet,12));
        }
        resultSet.close();
        return prpLinterPaymentInfoDto;
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
        buffer.append("RegistNoPay,");
        buffer.append("InsuredNamePay,");
        buffer.append("CertiNoPay,");
        buffer.append("PaymentType,");
        buffer.append("PaymentTypeCode,");
        buffer.append("SumPaidPay,");
        buffer.append("HavPaidPay,");
        buffer.append("PaidPay,");
        buffer.append("RelationOutId,");
        buffer.append("RelationOutIdType ");
        buffer.append("FROM PrpLinterPaymentInfo WHERE ");
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
        PrpLinterPaymentInfoDto prpLinterPaymentInfoDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterPaymentInfoDto = new PrpLinterPaymentInfoDto();
            prpLinterPaymentInfoDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterPaymentInfoDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLinterPaymentInfoDto.setRegistNoPay(dbManager.getString(resultSet,"RegistNoPay"));
            prpLinterPaymentInfoDto.setInsuredNamePay(dbManager.getString(resultSet,"InsuredNamePay"));
            prpLinterPaymentInfoDto.setCertiNoPay(dbManager.getString(resultSet,"CertiNoPay"));
            prpLinterPaymentInfoDto.setPaymentType(dbManager.getString(resultSet,"PaymentType"));
            prpLinterPaymentInfoDto.setPaymentTypeCode(dbManager.getString(resultSet,"PaymentTypeCode"));
            prpLinterPaymentInfoDto.setSumPaidPay(dbManager.getDouble(resultSet,"SumPaidPay"));
            prpLinterPaymentInfoDto.setHavPaidPay(dbManager.getDouble(resultSet,"HavPaidPay"));
            prpLinterPaymentInfoDto.setPaidPay(dbManager.getDouble(resultSet,"PaidPay"));
            prpLinterPaymentInfoDto.setRelationOutId(dbManager.getString(resultSet,"RelationOutId"));
            prpLinterPaymentInfoDto.setRelationOutIdType(dbManager.getString(resultSet,"RelationOutIdType"));
            collection.add(prpLinterPaymentInfoDto);
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
        buffer.append("DELETE FROM PrpLinterPaymentInfo WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterPaymentInfo WHERE ");
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

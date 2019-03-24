package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֧���������������ݷ��ʶ������<br>
 */
public class DBPrpLpayExttgBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLpayExttgBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpayExttgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLpayExtDto prpLpayExtDto
     * @throws Exception
     */
    public void insert(PrpLpayExtDto prpLpayExtDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLpayExttg (");
        buffer.append("PaymentNo,");
        buffer.append("SerialNo,");
        buffer.append("InputDate,");
        buffer.append("OperatorCode,");
        buffer.append("Context,");
        buffer.append("ComCode,");
        buffer.append("NodeType,");
        buffer.append("NodeName,");
        buffer.append("NotionCode,");
        buffer.append("NotionName,");
        buffer.append("Flag ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLpayExtDto.getPaymentNo()).append("',");
            debugBuffer.append("").append(prpLpayExtDto.getSerialNo()).append(",");
            debugBuffer.append("'").append(prpLpayExtDto.getInputDate()).append("',");
            debugBuffer.append("'").append(prpLpayExtDto.getOperatorCode()).append("',");
            debugBuffer.append("'").append(prpLpayExtDto.getContext()).append("',");
            debugBuffer.append("'").append(prpLpayExtDto.getComCode()).append("',");
            debugBuffer.append("'").append(prpLpayExtDto.getNodeType()).append("',");
            debugBuffer.append("'").append(prpLpayExtDto.getNodeName()).append("',");
            debugBuffer.append("'").append(prpLpayExtDto.getNotionCode()).append("',");
            debugBuffer.append("'").append(prpLpayExtDto.getNotionName()).append("',");
            debugBuffer.append("'").append(prpLpayExtDto.getFlag()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLpayExtDto.getPaymentNo());
        dbManager.setInt(2,prpLpayExtDto.getSerialNo());
        dbManager.setDateTime(3,prpLpayExtDto.getInputDate());
        dbManager.setString(4,prpLpayExtDto.getOperatorCode());
        dbManager.setString(5,prpLpayExtDto.getContext());
        dbManager.setString(6,prpLpayExtDto.getComCode());
        dbManager.setString(7,prpLpayExtDto.getNodeType());
        dbManager.setString(8,prpLpayExtDto.getNodeName());
        dbManager.setString(9,prpLpayExtDto.getNotionCode());
        dbManager.setString(10,prpLpayExtDto.getNotionName());
        dbManager.setString(11,prpLpayExtDto.getFlag());
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
        buffer.append("INSERT INTO PrpLpayExttg (");
        buffer.append("PaymentNo,");
        buffer.append("SerialNo,");
        buffer.append("InputDate,");
        buffer.append("OperatorCode,");
        buffer.append("Context,");
        buffer.append("ComCode,");
        buffer.append("NodeType,");
        buffer.append("NodeName,");
        buffer.append("NotionCode,");
        buffer.append("NotionName,");
        buffer.append("Flag ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLpayExtDto prpLpayExtDto = (PrpLpayExtDto)i.next();
            dbManager.setString(1,prpLpayExtDto.getPaymentNo());
            dbManager.setInt(2,prpLpayExtDto.getSerialNo());
            dbManager.setDateTime(3,prpLpayExtDto.getInputDate());
            dbManager.setString(4,prpLpayExtDto.getOperatorCode());
            dbManager.setString(5,prpLpayExtDto.getContext());
            dbManager.setString(6,prpLpayExtDto.getComCode());
            dbManager.setString(7,prpLpayExtDto.getNodeType());
            dbManager.setString(8,prpLpayExtDto.getNodeName());
            dbManager.setString(9,prpLpayExtDto.getNotionCode());
            dbManager.setString(10,prpLpayExtDto.getNotionName());
            dbManager.setString(11,prpLpayExtDto.getFlag());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param paymentNo �ո����
     * @param serialNo ���
     * @throws Exception
     */
    public void delete(String paymentNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLpayExttg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PaymentNo=").append("'").append(paymentNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PaymentNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,paymentNo);
        dbManager.setInt(2,serialNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLpayExtDto prpLpayExtDto
     * @throws Exception
     */
    public void update(PrpLpayExtDto prpLpayExtDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpayExttg SET ");
        buffer.append("InputDate = ?, ");
        buffer.append("OperatorCode = ?, ");
        buffer.append("Context = ?, ");
        buffer.append("ComCode = ?, ");
        buffer.append("NodeType = ?, ");
        buffer.append("NodeName = ?, ");
        buffer.append("NotionCode = ?, ");
        buffer.append("NotionName = ?, ");
        buffer.append("Flag = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLpayExttg SET ");
            debugBuffer.append("InputDate = '" + prpLpayExtDto.getInputDate() + "', ");
            debugBuffer.append("OperatorCode = '" + prpLpayExtDto.getOperatorCode() + "', ");
            debugBuffer.append("Context = '" + prpLpayExtDto.getContext() + "', ");
            debugBuffer.append("ComCode = '" + prpLpayExtDto.getComCode() + "', ");
            debugBuffer.append("NodeType = '" + prpLpayExtDto.getNodeType() + "', ");
            debugBuffer.append("NodeName = '" + prpLpayExtDto.getNodeName() + "', ");
            debugBuffer.append("NotionCode = '" + prpLpayExtDto.getNotionCode() + "', ");
            debugBuffer.append("NotionName = '" + prpLpayExtDto.getNotionName() + "', ");
            debugBuffer.append("Flag = '" + prpLpayExtDto.getFlag() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("PaymentNo=").append("'").append(prpLpayExtDto.getPaymentNo()).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(prpLpayExtDto.getSerialNo()).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PaymentNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setDateTime(1,prpLpayExtDto.getInputDate());
        dbManager.setString(2,prpLpayExtDto.getOperatorCode());
        dbManager.setString(3,prpLpayExtDto.getContext());
        dbManager.setString(4,prpLpayExtDto.getComCode());
        dbManager.setString(5,prpLpayExtDto.getNodeType());
        dbManager.setString(6,prpLpayExtDto.getNodeName());
        dbManager.setString(7,prpLpayExtDto.getNotionCode());
        dbManager.setString(8,prpLpayExtDto.getNotionName());
        dbManager.setString(9,prpLpayExtDto.getFlag());
        //���������ֶ�;
        dbManager.setString(10,prpLpayExtDto.getPaymentNo());
        dbManager.setInt(11,prpLpayExtDto.getSerialNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param paymentNo �ո����
     * @param serialNo ���
     * @return PrpLpayExtDto
     * @throws Exception
     */
    public PrpLpayExtDto findByPrimaryKey(String paymentNo,int serialNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("PaymentNo,");
        buffer.append("SerialNo,");
        buffer.append("InputDate,");
        buffer.append("OperatorCode,");
        buffer.append("Context,");
        buffer.append("ComCode,");
        buffer.append("NodeType,");
        buffer.append("NodeName,");
        buffer.append("NotionCode,");
        buffer.append("NotionName,");
        buffer.append("Flag ");
        buffer.append("FROM PrpLpayExttg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("PaymentNo=").append("'").append(paymentNo).append("' AND ");
            debugBuffer.append("SerialNo=").append("").append(serialNo).append("");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("PaymentNo = ? And ");
        buffer.append("SerialNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,paymentNo);
        dbManager.setInt(2,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLpayExtDto prpLpayExtDto = null;
        if(resultSet.next()){
            prpLpayExtDto = new PrpLpayExtDto();
            prpLpayExtDto.setPaymentNo(dbManager.getString(resultSet,1));
            prpLpayExtDto.setSerialNo(dbManager.getInt(resultSet,2));
            prpLpayExtDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,3));
            prpLpayExtDto.setOperatorCode(dbManager.getString(resultSet,4));
            prpLpayExtDto.setContext(dbManager.getString(resultSet,5));
            prpLpayExtDto.setComCode(dbManager.getString(resultSet,6));
            prpLpayExtDto.setNodeType(dbManager.getString(resultSet,7));
            prpLpayExtDto.setNodeName(dbManager.getString(resultSet,8));
            prpLpayExtDto.setNotionCode(dbManager.getString(resultSet,9));
            prpLpayExtDto.setNotionName(dbManager.getString(resultSet,10));
            prpLpayExtDto.setFlag(dbManager.getString(resultSet,11));
        }
        resultSet.close();
        return prpLpayExtDto;
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
        buffer.append("PaymentNo,");
        buffer.append("SerialNo,");
        buffer.append("InputDate,");
        buffer.append("OperatorCode,");
        buffer.append("Context,");
        buffer.append("ComCode,");
        buffer.append("NodeType,");
        buffer.append("NodeName,");
        buffer.append("NotionCode,");
        buffer.append("NotionName,");
        buffer.append("Flag ");
        buffer.append("FROM PrpLpayExttg WHERE ");
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
        PrpLpayExtDto prpLpayExtDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpayExtDto = new PrpLpayExtDto();
            prpLpayExtDto.setPaymentNo(dbManager.getString(resultSet,"PaymentNo"));
            prpLpayExtDto.setSerialNo(dbManager.getInt(resultSet,"SerialNo"));
            prpLpayExtDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"InputDate"));
            prpLpayExtDto.setOperatorCode(dbManager.getString(resultSet,"OperatorCode"));
            prpLpayExtDto.setContext(dbManager.getString(resultSet,"Context"));
            prpLpayExtDto.setComCode(dbManager.getString(resultSet,"ComCode"));
            prpLpayExtDto.setNodeType(dbManager.getString(resultSet,"NodeType"));
            prpLpayExtDto.setNodeName(dbManager.getString(resultSet,"NodeName"));
            prpLpayExtDto.setNotionCode(dbManager.getString(resultSet,"NotionCode"));
            prpLpayExtDto.setNotionName(dbManager.getString(resultSet,"NotionName"));
            prpLpayExtDto.setFlag(dbManager.getString(resultSet,"Flag"));
            collection.add(prpLpayExtDto);
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
        buffer.append("DELETE FROM PrpLpayExttg WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLpayExttg WHERE ");
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
    /**************************�Ż��޸ģ�start*****************************/
    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditionsByPrepered(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLpayExttg WHERE paymentNo= ? ");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1, conditions);
        int count = dbManager.executePreparedUpdate();
        return count;
    }
    /**************************�Ż��޸ģ�end*****************************/
}

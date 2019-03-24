package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǽ�����Ϣ������------�켣������ݷ��ʶ������<br>
 */
public class DBPrpLinterPayDetailBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLinterPayDetailBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLinterPayDetailBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLinterPayDetailDto prpLinterPayDetailDto
     * @throws Exception
     */
    public void insert(PrpLinterPayDetailDto prpLinterPayDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLinterPayDetail (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("PaySuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("InputDate ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLinterPayDetailDto.getId()).append("',");
            debugBuffer.append("'").append(prpLinterPayDetailDto.getOutId()).append("',");
            debugBuffer.append("'").append(prpLinterPayDetailDto.getPaymentNo()).append("',");
            debugBuffer.append("'").append(prpLinterPayDetailDto.getPaySuccFlag()).append("',");
            debugBuffer.append("'").append(prpLinterPayDetailDto.getVericSuccFlag()).append("',");
            debugBuffer.append("'").append(prpLinterPayDetailDto.getInputDate()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLinterPayDetailDto.getId());
        dbManager.setString(2,prpLinterPayDetailDto.getOutId());
        dbManager.setString(3,prpLinterPayDetailDto.getPaymentNo());
        dbManager.setString(4,prpLinterPayDetailDto.getPaySuccFlag());
        dbManager.setString(5,prpLinterPayDetailDto.getVericSuccFlag());
        dbManager.setDateTime(6,prpLinterPayDetailDto.getInputDate());
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
        buffer.append("INSERT INTO PrpLinterPayDetail (");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("PaySuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("InputDate ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLinterPayDetailDto prpLinterPayDetailDto = (PrpLinterPayDetailDto)i.next();
            dbManager.setString(1,prpLinterPayDetailDto.getId());
            dbManager.setString(2,prpLinterPayDetailDto.getOutId());
            dbManager.setString(3,prpLinterPayDetailDto.getPaymentNo());
            dbManager.setString(4,prpLinterPayDetailDto.getPaySuccFlag());
            dbManager.setString(5,prpLinterPayDetailDto.getVericSuccFlag());
            dbManager.setDateTime(6,prpLinterPayDetailDto.getInputDate());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param id ����pk
     * @throws Exception
     */
    public void delete(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLinterPayDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLinterPayDetailDto prpLinterPayDetailDto
     * @throws Exception
     */
    public void update(PrpLinterPayDetailDto prpLinterPayDetailDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLinterPayDetail SET ");
        buffer.append("OutId = ?, ");
        buffer.append("PaymentNo = ?, ");
        buffer.append("PaySuccFlag = ?, ");
        buffer.append("VericSuccFlag = ?, ");
        buffer.append("InputDate = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLinterPayDetail SET ");
            debugBuffer.append("OutId = '" + prpLinterPayDetailDto.getOutId() + "', ");
            debugBuffer.append("PaymentNo = '" + prpLinterPayDetailDto.getPaymentNo() + "', ");
            debugBuffer.append("PaySuccFlag = '" + prpLinterPayDetailDto.getPaySuccFlag() + "', ");
            debugBuffer.append("VericSuccFlag = '" + prpLinterPayDetailDto.getVericSuccFlag() + "', ");
            debugBuffer.append("InputDate = '" + prpLinterPayDetailDto.getInputDate() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(prpLinterPayDetailDto.getId()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLinterPayDetailDto.getOutId());
        dbManager.setString(2,prpLinterPayDetailDto.getPaymentNo());
        dbManager.setString(3,prpLinterPayDetailDto.getPaySuccFlag());
        dbManager.setString(4,prpLinterPayDetailDto.getVericSuccFlag());
        dbManager.setDateTime(5,prpLinterPayDetailDto.getInputDate());
        //���������ֶ�;
        dbManager.setString(6,prpLinterPayDetailDto.getId());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param id ����pk
     * @return PrpLinterPayDetailDto
     * @throws Exception
     */
    public PrpLinterPayDetailDto findByPrimaryKey(String id)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Id,");
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("PaySuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("InputDate ");
        buffer.append("FROM PrpLinterPayDetail ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("Id=").append("'").append(id).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("Id = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,id);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLinterPayDetailDto prpLinterPayDetailDto = null;
        if(resultSet.next()){
            prpLinterPayDetailDto = new PrpLinterPayDetailDto();
            prpLinterPayDetailDto.setId(dbManager.getString(resultSet,1));
            prpLinterPayDetailDto.setOutId(dbManager.getString(resultSet,2));
            prpLinterPayDetailDto.setPaymentNo(dbManager.getString(resultSet,3));
            prpLinterPayDetailDto.setPaySuccFlag(dbManager.getString(resultSet,4));
            prpLinterPayDetailDto.setVericSuccFlag(dbManager.getString(resultSet,5));
            prpLinterPayDetailDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,6));
        }
        resultSet.close();
        return prpLinterPayDetailDto;
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
        buffer.append("OutId,");
        buffer.append("PaymentNo,");
        buffer.append("PaySuccFlag,");
        buffer.append("VericSuccFlag,");
        buffer.append("InputDate ");
        buffer.append("FROM PrpLinterPayDetail WHERE ");
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
        PrpLinterPayDetailDto prpLinterPayDetailDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLinterPayDetailDto = new PrpLinterPayDetailDto();
            prpLinterPayDetailDto.setId(dbManager.getString(resultSet,"Id"));
            prpLinterPayDetailDto.setOutId(dbManager.getString(resultSet,"OutId"));
            prpLinterPayDetailDto.setPaymentNo(dbManager.getString(resultSet,"PaymentNo"));
            prpLinterPayDetailDto.setPaySuccFlag(dbManager.getString(resultSet,"PaySuccFlag"));
            prpLinterPayDetailDto.setVericSuccFlag(dbManager.getString(resultSet,"VericSuccFlag"));
            prpLinterPayDetailDto.setInputDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_SECOND,"InputDate"));
            collection.add(prpLinterPayDetailDto);
        }
        resultSet.close();
        return collection;
    }

    
    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByAllOutId(String conditions)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("Prplinterpayrequest.Outid as Outid,");
        buffer.append("PrpLpaymain.Paymentno as Paymentno,");
        buffer.append("PrpLpaymain.Thirdpayflag as Thirdpayflag ");
        buffer.append("FROM Prplinterpayrequest,PrpLinterPayDetail, PrpLpaymain WHERE ");
        buffer.append(" Prplinterpayrequest.Outid = PrpLinterPayDetail.Outid(+) ");
        buffer.append(" and PrpLinterPayDetail.Paymentno = PrpLpaymain.Paymentno(+) and ");
        buffer.append(conditions);
        boolean supportPaging = false;//���ݿ��Ƿ�֧�ַ�ҳ
        
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        ResultSet resultSet = dbManager.executeQuery(buffer.toString());
        int count=0;
        

        //���巵�ؽ������
        Collection collection = new ArrayList();
        PrpLinterPayDetailDto prpLinterPayDetailDto = null;
        while(resultSet.next()){
           

            prpLinterPayDetailDto = new PrpLinterPayDetailDto();
            prpLinterPayDetailDto.setOutId(dbManager.getString(resultSet,"Outid"));
            prpLinterPayDetailDto.setPaymentNo(dbManager.getString(resultSet,"Paymentno"));
            prpLinterPayDetailDto.setThirdPayFlag(dbManager.getString(resultSet,"Thirdpayflag"));
            collection.add(prpLinterPayDetailDto);
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
        buffer.append("DELETE FROM PrpLinterPayDetail WHERE ");
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
        buffer.append("SELECT count(1) FROM PrpLinterPayDetail WHERE ");
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

package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeListDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֪ͨ������������ݷ��ʶ������<br>
 * ������ 2013-06-28 13:28:27.402<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayNoticeListtgBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLpayNoticeListtgBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpayNoticeListtgBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public void insert(PrpLpayNoticeListDto prpLpayNoticeListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLpayNoticeListtg (");
        buffer.append("NoticeNo,");
        buffer.append("PaymentNo ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLpayNoticeListDto.getNoticeNo()).append("',");
            debugBuffer.append("'").append(prpLpayNoticeListDto.getPaymentNo()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLpayNoticeListDto.getNoticeNo());
        dbManager.setString(2,prpLpayNoticeListDto.getPaymentNo());
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
        buffer.append("INSERT INTO PrpLpayNoticeListtg (");
        buffer.append("NoticeNo,");
        buffer.append("PaymentNo ");
        buffer.append(") ");
        buffer.append("VALUES(?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLpayNoticeListDto prpLpayNoticeListDto = (PrpLpayNoticeListDto)i.next();
            dbManager.setString(1,prpLpayNoticeListDto.getNoticeNo());
            dbManager.setString(2,prpLpayNoticeListDto.getPaymentNo());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param noticeNo ֪ͨ����
     * @param paymentNo �ո����
     * @throws Exception
     */
    public void delete(String noticeNo,String paymentNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLpayNoticeListtg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(noticeNo).append("' AND ");
            debugBuffer.append("PaymentNo=").append("'").append(paymentNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ? And ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,noticeNo);
        dbManager.setString(2,paymentNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLpayNoticeListDto prpLpayNoticeListDto
     * @throws Exception
     */
    public void update(PrpLpayNoticeListDto prpLpayNoticeListDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpayNoticeListtg SET ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLpayNoticeListtg SET ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(prpLpayNoticeListDto.getNoticeNo()).append("' AND ");
            debugBuffer.append("PaymentNo=").append("'").append(prpLpayNoticeListDto.getPaymentNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ? And ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        //���������ֶ�;
        dbManager.setString(1,prpLpayNoticeListDto.getNoticeNo());
        dbManager.setString(2,prpLpayNoticeListDto.getPaymentNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param noticeNo ֪ͨ����
     * @param paymentNo �ո����
     * @return PrpLpayNoticeListDto
     * @throws Exception
     */
    public PrpLpayNoticeListDto findByPrimaryKey(String noticeNo,String paymentNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("NoticeNo,");
        buffer.append("PaymentNo ");
        buffer.append("FROM PrpLpayNoticeListtg ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(noticeNo).append("' AND ");
            debugBuffer.append("PaymentNo=").append("'").append(paymentNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ? And ");
        buffer.append("PaymentNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,noticeNo);
        dbManager.setString(2,paymentNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLpayNoticeListDto prpLpayNoticeListDto = null;
        if(resultSet.next()){
            prpLpayNoticeListDto = new PrpLpayNoticeListDto();
            prpLpayNoticeListDto.setNoticeNo(dbManager.getString(resultSet,1));
            prpLpayNoticeListDto.setPaymentNo(dbManager.getString(resultSet,2));
        }
        resultSet.close();
        return prpLpayNoticeListDto;
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
        buffer.append("NoticeNo,");
        buffer.append("PaymentNo ");
        buffer.append("FROM PrpLpayNoticeListtg WHERE ");
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
        PrpLpayNoticeListDto prpLpayNoticeListDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpayNoticeListDto = new PrpLpayNoticeListDto();
            prpLpayNoticeListDto.setNoticeNo(dbManager.getString(resultSet,1));
            prpLpayNoticeListDto.setPaymentNo(dbManager.getString(resultSet,2));
            collection.add(prpLpayNoticeListDto);
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
        buffer.append("DELETE FROM PrpLpayNoticeListtg WHERE ");
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
        buffer.append("SELECT count(1) FROM (SELECT * FROM PrpLpayNoticeListtg WHERE ");
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

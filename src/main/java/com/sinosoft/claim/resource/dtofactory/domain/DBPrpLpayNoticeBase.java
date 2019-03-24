package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.*;
import java.util.*;
import com.sinosoft.sysframework.log.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.claim.dto.domain.PrpLpayNoticeDto;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����֪ͨ��������ݷ��ʶ������<br>
 * ������ 2013-06-28 13:27:39.644<br>
 * JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class DBPrpLpayNoticeBase{
    /**
     * ��Դ�������ʵ�����������ݿ����.
     */
    protected DBManager dbManager = null;
    private static Logger logger = Logger.getLogger(DBPrpLpayNoticeBase.class);

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLpayNoticeBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void insert(PrpLpayNoticeDto prpLpayNoticeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("INSERT INTO PrpLpayNotice (");
        buffer.append("NoticeNo,");
        buffer.append("NoticeType,");
        buffer.append("OpreateDate,");
        buffer.append("OpreateCode,");
        buffer.append("ReceiverFullName ");
        buffer.append(") ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("VALUES(");
            debugBuffer.append("'").append(prpLpayNoticeDto.getNoticeNo()).append("',");
            debugBuffer.append("'").append(prpLpayNoticeDto.getNoticeType()).append("',");
            debugBuffer.append("'").append(prpLpayNoticeDto.getOpreateDate()).append("',");
            debugBuffer.append("'").append(prpLpayNoticeDto.getOpreateCode()).append("',");
            debugBuffer.append("'").append(prpLpayNoticeDto.getReceiverFullName()).append("')");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("VALUES(?,?,?,?,?)");
        dbManager.prepareStatement(buffer.toString());
        dbManager.setString(1,prpLpayNoticeDto.getNoticeNo());
        dbManager.setString(2,prpLpayNoticeDto.getNoticeType());
        dbManager.setDateTime(3,prpLpayNoticeDto.getOpreateDate());
        dbManager.setString(4,prpLpayNoticeDto.getOpreateCode());
        dbManager.setString(5,prpLpayNoticeDto.getReceiverFullName());
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
        buffer.append("INSERT INTO PrpLpayNotice (");
        buffer.append("NoticeNo,");
        buffer.append("NoticeType,");
        buffer.append("OpreateDate,");
        buffer.append("OpreateCode,");
        buffer.append("ReceiverFullName ");
        buffer.append(") ");
        buffer.append("VALUES(?,?,?,?,?)");
        if(logger.isDebugEnabled()){
            logger.debug(buffer.toString());
        }
        dbManager.prepareStatement(buffer.toString());
        for (Iterator i = collection.iterator(); i.hasNext();) {
            PrpLpayNoticeDto prpLpayNoticeDto = (PrpLpayNoticeDto)i.next();
            dbManager.setString(1,prpLpayNoticeDto.getNoticeNo());
            dbManager.setString(2,prpLpayNoticeDto.getNoticeType());
            dbManager.setDateTime(3,prpLpayNoticeDto.getOpreateDate());
            dbManager.setString(4,prpLpayNoticeDto.getOpreateCode());
            dbManager.setString(5,prpLpayNoticeDto.getReceiverFullName());
            dbManager.addBatch();
        }
        dbManager.executePreparedUpdateBatch();
    }

    /**
     * ������ɾ��һ������
     * @param noticeNo ֪ͨ����
     * @throws Exception
     */
    public void delete(String noticeNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(100);
        buffer.append("DELETE FROM PrpLpayNotice ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(noticeNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,noticeNo);
        dbManager.executePreparedUpdate();
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLpayNoticeDto prpLpayNoticeDto
     * @throws Exception
     */
    public void update(PrpLpayNoticeDto prpLpayNoticeDto)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        buffer.append("UPDATE PrpLpayNotice SET ");
        buffer.append("NoticeType = ?, ");
        buffer.append("OpreateDate = ?, ");
        buffer.append("OpreateCode = ?, ");
        buffer.append("ReceiverFullName = ? ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append("UPDATE PrpLpayNotice SET ");
            debugBuffer.append("NoticeType = '" + prpLpayNoticeDto.getNoticeType() + "', ");
            debugBuffer.append("OpreateDate = '" + prpLpayNoticeDto.getOpreateDate() + "', ");
            debugBuffer.append("OpreateCode = '" + prpLpayNoticeDto.getOpreateCode() + "', ");
            debugBuffer.append("ReceiverFullName = '" + prpLpayNoticeDto.getReceiverFullName() + "' ");
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(prpLpayNoticeDto.getNoticeNo()).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���ø����ֶ�;
        dbManager.setString(1,prpLpayNoticeDto.getNoticeType());
        dbManager.setDateTime(2,prpLpayNoticeDto.getOpreateDate());
        dbManager.setString(3,prpLpayNoticeDto.getOpreateCode());
        dbManager.setString(4,prpLpayNoticeDto.getReceiverFullName());
        //���������ֶ�;
        dbManager.setString(5,prpLpayNoticeDto.getNoticeNo());
        dbManager.executePreparedUpdate();

    }

    /**
     * ����������һ������
     * @param noticeNo ֪ͨ����
     * @return PrpLpayNoticeDto
     * @throws Exception
     */
    public PrpLpayNoticeDto findByPrimaryKey(String noticeNo)
            throws Exception{
        StringBuffer buffer = new StringBuffer(200);
        //ƴSQL���
        buffer.append("SELECT ");
        buffer.append("NoticeNo,");
        buffer.append("NoticeType,");
        buffer.append("OpreateDate,");
        buffer.append("OpreateCode,");
        buffer.append("ReceiverFullName ");
        buffer.append("FROM PrpLpayNotice ");
        if(logger.isDebugEnabled()){
            StringBuffer debugBuffer =  new StringBuffer(buffer.length()*4);
            debugBuffer.append(buffer.toString());
            debugBuffer.append("WHERE ");
            debugBuffer.append("NoticeNo=").append("'").append(noticeNo).append("'");
            logger.debug(debugBuffer.toString());
        }

        buffer.append("WHERE ");
        buffer.append("NoticeNo = ?");

        dbManager.prepareStatement(buffer.toString());
        //���������ֶ�;
        dbManager.setString(1,noticeNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        PrpLpayNoticeDto prpLpayNoticeDto = null;
        if(resultSet.next()){
            prpLpayNoticeDto = new PrpLpayNoticeDto();
            prpLpayNoticeDto.setNoticeNo(dbManager.getString(resultSet,1));
            prpLpayNoticeDto.setNoticeType(dbManager.getString(resultSet,2));
            prpLpayNoticeDto.setOpreateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLpayNoticeDto.setOpreateCode(dbManager.getString(resultSet,4));
            prpLpayNoticeDto.setReceiverFullName(dbManager.getString(resultSet,5));
        }
        resultSet.close();
        return prpLpayNoticeDto;
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
        buffer.append("NoticeType,");
        buffer.append("OpreateDate,");
        buffer.append("OpreateCode,");
        buffer.append("ReceiverFullName ");
        buffer.append("FROM PrpLpayNotice WHERE ");
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
        PrpLpayNoticeDto prpLpayNoticeDto = null;
        while(resultSet.next()){
            if (supportPaging == false && pageNo>0) {
                count++;
                if(count > rowsPerPage){
                    break;
                }
            }

            prpLpayNoticeDto = new PrpLpayNoticeDto();
            prpLpayNoticeDto.setNoticeNo(dbManager.getString(resultSet,1));
            prpLpayNoticeDto.setNoticeType(dbManager.getString(resultSet,2));
            prpLpayNoticeDto.setOpreateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,3));
            prpLpayNoticeDto.setOpreateCode(dbManager.getString(resultSet,4));
            prpLpayNoticeDto.setReceiverFullName(dbManager.getString(resultSet,5));
            collection.add(prpLpayNoticeDto);
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
        buffer.append("DELETE FROM PrpLpayNotice WHERE ");
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
        buffer.append("SELECT count(1) FROM (SELECT * FROM PrpLpayNotice WHERE ");
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

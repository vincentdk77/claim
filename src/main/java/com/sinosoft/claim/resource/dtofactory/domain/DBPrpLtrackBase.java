package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLtrackDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpltrack�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLtrackBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpLtrackBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpLtrackBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpLtrackDto prpLtrackDto
     * @throws Exception
     */
    public void insert(PrpLtrackDto prpLtrackDto) throws Exception{
        String statement = " Insert Into PrpLtrack(" + 
                           " RegistNo," + 
                           " DocCode," + 
                           " DocName," + 
                           " Status," + 
                           " SendorName," + 
                           " SendDate," + 
                           " AcceptName," + 
                           " AcceptDate," + 
                           " CheckName," + 
                           " CheckDate," + 
                           " ReturnDate," + 
                           " DossierMark," + 
                           " EndCase," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpLtrackDto.getRegistNo());
        dbManager.setString(2,prpLtrackDto.getDocCode());
        dbManager.setString(3,prpLtrackDto.getDocName());
        dbManager.setInt(4,prpLtrackDto.getStatus());
        dbManager.setString(5,prpLtrackDto.getSendorName());
        dbManager.setDateTime(6,prpLtrackDto.getSendDate());
        dbManager.setString(7,prpLtrackDto.getAcceptName());
        dbManager.setDateTime(8,prpLtrackDto.getAcceptDate());
        dbManager.setString(9,prpLtrackDto.getCheckName());
        dbManager.setDateTime(10,prpLtrackDto.getCheckDate());
        dbManager.setDateTime(11,prpLtrackDto.getReturnDate());
        dbManager.setString(12,prpLtrackDto.getDossierMark());
        dbManager.setString(13,prpLtrackDto.getEndCase());
        dbManager.setString(14,prpLtrackDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLtrackBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpLtrackDto prpLtrackDto = (PrpLtrackDto)i.next();
            insert(prpLtrackDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param registNo ������
     * @param docCode ��֤����
     * @throws Exception
     */
    public void delete(String registNo,String docCode) throws Exception{
        String statement = " Delete From PrpLtrack Where " +
                           " RegistNo = ? And " + 
                           " DocCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setString(2,docCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpLtrackBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpLtrackDto prpLtrackDto
     * @throws Exception
     */
    public void update(PrpLtrackDto prpLtrackDto) throws Exception{
        String statement = " Update PrpLtrack Set DocName = ?," + 
                           " Status = ?," + 
                           " SendorName = ?," + 
                           " SendDate = ?," + 
                           " AcceptName = ?," + 
                           " AcceptDate = ?," + 
                           " CheckName = ?," + 
                           " CheckDate = ?," + 
                           " ReturnDate = ?," + 
                           " DossierMark = ?," + 
                           " EndCase = ?," + 
                           " Flag = ? Where " +
                           " RegistNo = ? And " + 
                           " DocCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpLtrackDto.getDocName());
        dbManager.setInt(2,prpLtrackDto.getStatus());
        dbManager.setString(3,prpLtrackDto.getSendorName());
        dbManager.setDateTime(4,prpLtrackDto.getSendDate());
        dbManager.setString(5,prpLtrackDto.getAcceptName());
        dbManager.setDateTime(6,prpLtrackDto.getAcceptDate());
        dbManager.setString(7,prpLtrackDto.getCheckName());
        dbManager.setDateTime(8,prpLtrackDto.getCheckDate());
        dbManager.setDateTime(9,prpLtrackDto.getReturnDate());
        dbManager.setString(10,prpLtrackDto.getDossierMark());
        dbManager.setString(11,prpLtrackDto.getEndCase());
        dbManager.setString(12,prpLtrackDto.getFlag());
        //���������ֶ�;
        dbManager.setString(13,prpLtrackDto.getRegistNo());
        dbManager.setString(14,prpLtrackDto.getDocCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpLtrackBase.update() success!");
    }

    /**
     * ����������һ������
     * @param registNo ������
     * @param docCode ��֤����
     * @return PrpLtrackDto
     * @throws Exception
     */
    public PrpLtrackDto findByPrimaryKey(String registNo,String docCode) throws Exception{
        String statement = " Select RegistNo," + 
                           " DocCode," + 
                           " DocName," + 
                           " Status," + 
                           " SendorName," + 
                           " SendDate," + 
                           " AcceptName," + 
                           " AcceptDate," + 
                           " CheckName," + 
                           " CheckDate," + 
                           " ReturnDate," + 
                           " DossierMark," + 
                           " EndCase," + 
                           " Flag From PrpLtrack Where " +
                           " RegistNo = ? And " + 
                           " DocCode = ?";
        PrpLtrackDto prpLtrackDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,registNo);
        dbManager.setString(2,docCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpLtrackDto = new PrpLtrackDto();
            prpLtrackDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLtrackDto.setDocCode(dbManager.getString(resultSet,2));
            prpLtrackDto.setDocName(dbManager.getString(resultSet,3));
            prpLtrackDto.setStatus(dbManager.getInt(resultSet,4));
            prpLtrackDto.setSendorName(dbManager.getString(resultSet,5));
            prpLtrackDto.setSendDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLtrackDto.setAcceptName(dbManager.getString(resultSet,7));
            prpLtrackDto.setAcceptDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpLtrackDto.setCheckName(dbManager.getString(resultSet,9));
            prpLtrackDto.setCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLtrackDto.setReturnDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpLtrackDto.setDossierMark(dbManager.getString(resultSet,12));
            prpLtrackDto.setEndCase(dbManager.getString(resultSet,13));
            prpLtrackDto.setFlag(dbManager.getString(resultSet,14));
        }
        resultSet.close();
        log.info("DBPrpLtrackBase.findByPrimaryKey() success!");
        return prpLtrackDto;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
        String statement = "Select RegistNo," + 
                           " DocCode," + 
                           " DocName," + 
                           " Status," + 
                           " SendorName," + 
                           " SendDate," + 
                           " AcceptName," + 
                           " AcceptDate," + 
                           " CheckName," + 
                           " CheckDate," + 
                           " ReturnDate," + 
                           " DossierMark," + 
                           " EndCase," + 
                           " Flag From PrpLtrack Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLtrackDto prpLtrackDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                	break;
                }
            }

            prpLtrackDto = new PrpLtrackDto();
            prpLtrackDto.setRegistNo(dbManager.getString(resultSet,1));
            prpLtrackDto.setDocCode(dbManager.getString(resultSet,2));
            prpLtrackDto.setDocName(dbManager.getString(resultSet,3));
            prpLtrackDto.setStatus(dbManager.getInt(resultSet,4));
            prpLtrackDto.setSendorName(dbManager.getString(resultSet,5));
            prpLtrackDto.setSendDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLtrackDto.setAcceptName(dbManager.getString(resultSet,7));
            prpLtrackDto.setAcceptDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpLtrackDto.setCheckName(dbManager.getString(resultSet,9));
            prpLtrackDto.setCheckDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,10));
            prpLtrackDto.setReturnDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,11));
            prpLtrackDto.setDossierMark(dbManager.getString(resultSet,12));
            prpLtrackDto.setEndCase(dbManager.getString(resultSet,13));
            prpLtrackDto.setFlag(dbManager.getString(resultSet,14));
            collection.add(prpLtrackDto);
        }
        resultSet.close();
        log.info("DBPrpLtrackBase.findByConditions() success!");
        return collection;
    }

    /**
     * ��������ѯ��������
     * @param conditions ��ѯ����
     * @return Collection
     * @throws Exception
     */
    public Collection findByConditions(String conditions) throws Exception{
        return findByConditions(conditions,0,0);
    }

    /**
     * ������ɾ������
     * @param conditions ��ѯ����
     * @return ɾ��������
     * @throws Exception
     */
    public int deleteByConditions(String conditions) throws Exception{
        String statement = "Delete From PrpLtrack Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpLtrackBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpLtrack Where " + conditions;
           statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpLtrackBase.getCount() success!");
        return count;
    }
}

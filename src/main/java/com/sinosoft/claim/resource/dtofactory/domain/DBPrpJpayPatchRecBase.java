package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJpayPatchRecDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjpaypatchrec�����շѵǼǱ�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJpayPatchRecBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpJpayPatchRecBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpJpayPatchRecBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpJpayPatchRecDto prpJpayPatchRecDto
     * @throws Exception
     */
    public void insert(PrpJpayPatchRecDto prpJpayPatchRecDto) throws Exception{
        String statement = " Insert Into PrpJpayPatchRec(" + 
                           " PayGroupNo," + 
                           " CertiNo," + 
                           " SerialNo) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJpayPatchRecDto.getPayGroupNo());
        dbManager.setString(2,prpJpayPatchRecDto.getCertiNo());
        dbManager.setInt(3,prpJpayPatchRecDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpayPatchRecBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJpayPatchRecDto prpJpayPatchRecDto = (PrpJpayPatchRecDto)i.next();
            insert(prpJpayPatchRecDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param payGroupNo �����շѵǼǺ�
     * @param certiNo ��������/��������/�����������
     * @param serialNo �����շ����
     * @throws Exception
     */
    public void delete(String payGroupNo,String certiNo,int serialNo) throws Exception{
        String statement = " Delete From PrpJpayPatchRec Where " +
                           " PayGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,payGroupNo);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJpayPatchRecBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpJpayPatchRecDto prpJpayPatchRecDto
     * @throws Exception
     */
    public void update(PrpJpayPatchRecDto prpJpayPatchRecDto) throws Exception{
        String statement = " Update PrpJpayPatchRec Set  Where " +
                           " PayGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        //���������ֶ�;
        dbManager.setString(1,prpJpayPatchRecDto.getPayGroupNo());
        dbManager.setString(2,prpJpayPatchRecDto.getCertiNo());
        dbManager.setInt(3,prpJpayPatchRecDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJpayPatchRecBase.update() success!");
    }

    /**
     * ����������һ������
     * @param payGroupNo �����շѵǼǺ�
     * @param certiNo ��������/��������/�����������
     * @param serialNo �����շ����
     * @return PrpJpayPatchRecDto
     * @throws Exception
     */
    public PrpJpayPatchRecDto findByPrimaryKey(String payGroupNo,String certiNo,int serialNo) throws Exception{
        String statement = " Select PayGroupNo," + 
                           " CertiNo," + 
                           " SerialNo From PrpJpayPatchRec Where " +
                           " PayGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        PrpJpayPatchRecDto prpJpayPatchRecDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,payGroupNo);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJpayPatchRecDto = new PrpJpayPatchRecDto();
            prpJpayPatchRecDto.setPayGroupNo(dbManager.getString(resultSet,1));
            prpJpayPatchRecDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJpayPatchRecDto.setSerialNo(dbManager.getInt(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpJpayPatchRecBase.findByPrimaryKey() success!");
        return prpJpayPatchRecDto;
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
        String statement = "Select PayGroupNo," + 
                           " CertiNo," + 
                           " SerialNo From PrpJpayPatchRec Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJpayPatchRecDto prpJpayPatchRecDto = null;
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

            prpJpayPatchRecDto = new PrpJpayPatchRecDto();
            prpJpayPatchRecDto.setPayGroupNo(dbManager.getString(resultSet,1));
            prpJpayPatchRecDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJpayPatchRecDto.setSerialNo(dbManager.getInt(resultSet,3));
            collection.add(prpJpayPatchRecDto);
        }
        resultSet.close();
        log.info("DBPrpJpayPatchRecBase.findByConditions() success!");
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
        String statement = "Delete From PrpJpayPatchRec Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJpayPatchRecBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpJpayPatchRec Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJpayPatchRecBase.getCount() success!");
        return count;
    }
}

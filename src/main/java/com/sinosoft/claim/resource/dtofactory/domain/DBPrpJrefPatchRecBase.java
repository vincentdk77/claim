package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefPatchRecDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjrefpatchrec�������ѵǼǱ�����ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpJrefPatchRecBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpJrefPatchRecBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpJrefPatchRecBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpJrefPatchRecDto prpJrefPatchRecDto
     * @throws Exception
     */
    public void insert(PrpJrefPatchRecDto prpJrefPatchRecDto) throws Exception{
        String statement = " Insert Into PrpJrefPatchRec(" + 
                           " RefundGroupNo," + 
                           " CertiNo," + 
                           " SerialNo) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpJrefPatchRecDto.getRefundGroupNo());
        dbManager.setString(2,prpJrefPatchRecDto.getCertiNo());
        dbManager.setInt(3,prpJrefPatchRecDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefPatchRecBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpJrefPatchRecDto prpJrefPatchRecDto = (PrpJrefPatchRecDto)i.next();
            insert(prpJrefPatchRecDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param refundGroupNo �������ѵǼǺ�
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @throws Exception
     */
    public void delete(String refundGroupNo,String certiNo,int serialNo) throws Exception{
        String statement = " Delete From PrpJrefPatchRec Where " +
                           " RefundGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,refundGroupNo);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpJrefPatchRecBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpJrefPatchRecDto prpJrefPatchRecDto
     * @throws Exception
     */
    public void update(PrpJrefPatchRecDto prpJrefPatchRecDto) throws Exception{
        String statement = " Update PrpJrefPatchRec Set  Where " +
                           " RefundGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        //���������ֶ�;
        dbManager.setString(1,prpJrefPatchRecDto.getRefundGroupNo());
        dbManager.setString(2,prpJrefPatchRecDto.getCertiNo());
        dbManager.setInt(3,prpJrefPatchRecDto.getSerialNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpJrefPatchRecBase.update() success!");
    }

    /**
     * ����������һ������
     * @param refundGroupNo �������ѵǼǺ�
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @return PrpJrefPatchRecDto
     * @throws Exception
     */
    public PrpJrefPatchRecDto findByPrimaryKey(String refundGroupNo,String certiNo,int serialNo) throws Exception{
        String statement = " Select RefundGroupNo," + 
                           " CertiNo," + 
                           " SerialNo From PrpJrefPatchRec Where " +
                           " RefundGroupNo = ? And " + 
                           " CertiNo = ? And " + 
                           " SerialNo = ?";
        PrpJrefPatchRecDto prpJrefPatchRecDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,refundGroupNo);
        dbManager.setString(2,certiNo);
        dbManager.setInt(3,serialNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpJrefPatchRecDto = new PrpJrefPatchRecDto();
            prpJrefPatchRecDto.setRefundGroupNo(dbManager.getString(resultSet,1));
            prpJrefPatchRecDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJrefPatchRecDto.setSerialNo(dbManager.getInt(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpJrefPatchRecBase.findByPrimaryKey() success!");
        return prpJrefPatchRecDto;
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
        String statement = "Select RefundGroupNo," + 
                           " CertiNo," + 
                           " SerialNo From PrpJrefPatchRec Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpJrefPatchRecDto prpJrefPatchRecDto = null;
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

            prpJrefPatchRecDto = new PrpJrefPatchRecDto();
            prpJrefPatchRecDto.setRefundGroupNo(dbManager.getString(resultSet,1));
            prpJrefPatchRecDto.setCertiNo(dbManager.getString(resultSet,2));
            prpJrefPatchRecDto.setSerialNo(dbManager.getInt(resultSet,3));
            collection.add(prpJrefPatchRecDto);
        }
        resultSet.close();
        log.info("DBPrpJrefPatchRecBase.findByConditions() success!");
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
        String statement = "Delete From PrpJrefPatchRec Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpJrefPatchRecBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpJrefPatchRec Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpJrefPatchRecBase.getCount() success!");
        return count;
    }
}

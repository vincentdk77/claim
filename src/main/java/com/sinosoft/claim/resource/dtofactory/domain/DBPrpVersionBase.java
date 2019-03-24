package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpVersionDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpversion���ݿ�汾��Ϣ������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpVersionBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpVersionBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpVersionBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpVersionDto prpVersionDto
     * @throws Exception
     */
    public void insert(PrpVersionDto prpVersionDto) throws Exception{
        String statement = " Insert Into PrpVersion(" + 
                           " ProjectName," + 
                           " ProjectVersion," + 
                           " ProductID," + 
                           " Times," + 
                           " UserName," + 
                           " Company," + 
                           " UpdateDate," + 
                           " PrimaryVersion," + 
                           " Flag1," + 
                           " Flag2," + 
                           " Flag3," + 
                           " Flag4," + 
                           " Flag5) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpVersionDto.getProjectName());
        dbManager.setString(2,prpVersionDto.getProjectVersion());
        dbManager.setString(3,prpVersionDto.getProductID());
        dbManager.setInt(4,prpVersionDto.getTimes());
        dbManager.setString(5,prpVersionDto.getUserName());
        dbManager.setString(6,prpVersionDto.getCompany());
        dbManager.setDateTime(7,prpVersionDto.getUpdateDate());
        dbManager.setString(8,prpVersionDto.getPrimaryVersion());
        dbManager.setString(9,prpVersionDto.getFlag1());
        dbManager.setString(10,prpVersionDto.getFlag2());
        dbManager.setString(11,prpVersionDto.getFlag3());
        dbManager.setString(12,prpVersionDto.getFlag4());
        dbManager.setString(13,prpVersionDto.getFlag5());
        dbManager.executePreparedUpdate();

        log.info("DBPrpVersionBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpVersionDto prpVersionDto = (PrpVersionDto)i.next();
            insert(prpVersionDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param projectVersion ��Ŀ�汾��
     * @param productID ��Ʒ��ʶ
     * @param times �������
     * @throws Exception
     */
    public void delete(String projectVersion,String productID,int times) throws Exception{
        String statement = " Delete From PrpVersion Where " +
                           " ProjectVersion = ? And " + 
                           " ProductID = ? And " + 
                           " Times = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,projectVersion);
        dbManager.setString(2,productID);
        dbManager.setInt(3,times);
        dbManager.executePreparedUpdate();
        log.info("DBPrpVersionBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpVersionDto prpVersionDto
     * @throws Exception
     */
    public void update(PrpVersionDto prpVersionDto) throws Exception{
        String statement = " Update PrpVersion Set ProjectName = ?," + 
                           " UserName = ?," + 
                           " Company = ?," + 
                           " UpdateDate = ?," + 
                           " PrimaryVersion = ?," + 
                           " Flag1 = ?," + 
                           " Flag2 = ?," + 
                           " Flag3 = ?," + 
                           " Flag4 = ?," + 
                           " Flag5 = ? Where " +
                           " ProjectVersion = ? And " + 
                           " ProductID = ? And " + 
                           " Times = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpVersionDto.getProjectName());
        dbManager.setString(2,prpVersionDto.getUserName());
        dbManager.setString(3,prpVersionDto.getCompany());
        dbManager.setDateTime(4,prpVersionDto.getUpdateDate());
        dbManager.setString(5,prpVersionDto.getPrimaryVersion());
        dbManager.setString(6,prpVersionDto.getFlag1());
        dbManager.setString(7,prpVersionDto.getFlag2());
        dbManager.setString(8,prpVersionDto.getFlag3());
        dbManager.setString(9,prpVersionDto.getFlag4());
        dbManager.setString(10,prpVersionDto.getFlag5());
        //���������ֶ�;
        dbManager.setString(11,prpVersionDto.getProjectVersion());
        dbManager.setString(12,prpVersionDto.getProductID());
        dbManager.setInt(13,prpVersionDto.getTimes());
        dbManager.executePreparedUpdate();

        log.info("DBPrpVersionBase.update() success!");
    }

    /**
     * ����������һ������
     * @param projectVersion ��Ŀ�汾��
     * @param productID ��Ʒ��ʶ
     * @param times �������
     * @return PrpVersionDto
     * @throws Exception
     */
    public PrpVersionDto findByPrimaryKey(String projectVersion,String productID,int times) throws Exception{
        String statement = " Select ProjectName," + 
                           " ProjectVersion," + 
                           " ProductID," + 
                           " Times," + 
                           " UserName," + 
                           " Company," + 
                           " UpdateDate," + 
                           " PrimaryVersion," + 
                           " Flag1," + 
                           " Flag2," + 
                           " Flag3," + 
                           " Flag4," + 
                           " Flag5 From PrpVersion Where " +
                           " ProjectVersion = ? And " + 
                           " ProductID = ? And " + 
                           " Times = ?";
        PrpVersionDto prpVersionDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,projectVersion);
        dbManager.setString(2,productID);
        dbManager.setInt(3,times);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpVersionDto = new PrpVersionDto();
            prpVersionDto.setProjectName(dbManager.getString(resultSet,1));
            prpVersionDto.setProjectVersion(dbManager.getString(resultSet,2));
            prpVersionDto.setProductID(dbManager.getString(resultSet,3));
            prpVersionDto.setTimes(dbManager.getInt(resultSet,4));
            prpVersionDto.setUserName(dbManager.getString(resultSet,5));
            prpVersionDto.setCompany(dbManager.getString(resultSet,6));
            prpVersionDto.setUpdateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpVersionDto.setPrimaryVersion(dbManager.getString(resultSet,8));
            prpVersionDto.setFlag1(dbManager.getString(resultSet,9));
            prpVersionDto.setFlag2(dbManager.getString(resultSet,10));
            prpVersionDto.setFlag3(dbManager.getString(resultSet,11));
            prpVersionDto.setFlag4(dbManager.getString(resultSet,12));
            prpVersionDto.setFlag5(dbManager.getString(resultSet,13));
        }
        resultSet.close();
        log.info("DBPrpVersionBase.findByPrimaryKey() success!");
        return prpVersionDto;
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
        String statement = "Select ProjectName," + 
                           " ProjectVersion," + 
                           " ProductID," + 
                           " Times," + 
                           " UserName," + 
                           " Company," + 
                           " UpdateDate," + 
                           " PrimaryVersion," + 
                           " Flag1," + 
                           " Flag2," + 
                           " Flag3," + 
                           " Flag4," + 
                           " Flag5 From PrpVersion Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpVersionDto prpVersionDto = null;
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

            prpVersionDto = new PrpVersionDto();
            prpVersionDto.setProjectName(dbManager.getString(resultSet,1));
            prpVersionDto.setProjectVersion(dbManager.getString(resultSet,2));
            prpVersionDto.setProductID(dbManager.getString(resultSet,3));
            prpVersionDto.setTimes(dbManager.getInt(resultSet,4));
            prpVersionDto.setUserName(dbManager.getString(resultSet,5));
            prpVersionDto.setCompany(dbManager.getString(resultSet,6));
            prpVersionDto.setUpdateDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,7));
            prpVersionDto.setPrimaryVersion(dbManager.getString(resultSet,8));
            prpVersionDto.setFlag1(dbManager.getString(resultSet,9));
            prpVersionDto.setFlag2(dbManager.getString(resultSet,10));
            prpVersionDto.setFlag3(dbManager.getString(resultSet,11));
            prpVersionDto.setFlag4(dbManager.getString(resultSet,12));
            prpVersionDto.setFlag5(dbManager.getString(resultSet,13));
            collection.add(prpVersionDto);
        }
        resultSet.close();
        log.info("DBPrpVersionBase.findByConditions() success!");
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
        String statement = "Delete From PrpVersion Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpVersionBase.deleteByConditions() success!");
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
        String statement = "Select count(1) from PrpVersion Where " + conditions;
          statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpVersionBase.getCount() success!");
        return count;
    }
}

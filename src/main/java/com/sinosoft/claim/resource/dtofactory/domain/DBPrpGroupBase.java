package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpGroupDto;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpgroup��֤��������ݷ��ʶ�����<br>
 * ������ 2004-4-5 15:33:43<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpGroupBase{
    private DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpGroupBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpGroupBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpGroupDto prpGroupDto
     * @throws Exception
     */
    public void insert(PrpGroupDto prpGroupDto) throws Exception{
        String statement = " Insert Into PrpGroup(" + 
                           " GroupNo," + 
                           " SubGroupNo," + 
                           " Flag) values(?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpGroupDto.getGroupNo());
        dbManager.setString(2,prpGroupDto.getSubGroupNo());
        dbManager.setString(3,prpGroupDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGroupBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpGroupDto prpGroupDto = (PrpGroupDto)i.next();
            insert(prpGroupDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param groupNo �ϱ���
     * @param subGroupNo �ֱ���
     * @throws Exception
     */
    public void delete(String groupNo,String subGroupNo) throws Exception{
        String statement = " Delete From PrpGroup Where " +
                           " GroupNo = ? And " + 
                           " SubGroupNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,groupNo);
        dbManager.setString(2,subGroupNo);
        dbManager.executePreparedUpdate();
        log.info("DBPrpGroupBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpGroupDto prpGroupDto
     * @throws Exception
     */
    public void update(PrpGroupDto prpGroupDto) throws Exception{
        String statement = " Update PrpGroup Set Flag = ? Where " +
                           " GroupNo = ? And " + 
                           " SubGroupNo = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpGroupDto.getFlag());
        //���������ֶ�;
        dbManager.setString(2,prpGroupDto.getGroupNo());
        dbManager.setString(3,prpGroupDto.getSubGroupNo());
        dbManager.executePreparedUpdate();

        log.info("DBPrpGroupBase.update() success!");
    }

    /**
     * ����������һ������
     * @param groupNo �ϱ���
     * @param subGroupNo �ֱ���
     * @return PrpGroupDto
     * @throws Exception
     */
    public PrpGroupDto findByPrimaryKey(String groupNo,String subGroupNo) throws Exception{
        String statement = " Select GroupNo," + 
                           " SubGroupNo," + 
                           " Flag From PrpGroup Where " +
                           " GroupNo = ? And " + 
                           " SubGroupNo = ?";
        PrpGroupDto prpGroupDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,groupNo);
        dbManager.setString(2,subGroupNo);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpGroupDto = new PrpGroupDto();
            prpGroupDto.setGroupNo(dbManager.getString(resultSet,1));
            prpGroupDto.setSubGroupNo(dbManager.getString(resultSet,2));
            prpGroupDto.setFlag(dbManager.getString(resultSet,3));
        }
        resultSet.close();
        log.info("DBPrpGroupBase.findByPrimaryKey() success!");
        return prpGroupDto;
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
        String statement = "Select GroupNo," + 
                           " SubGroupNo," + 
                           " Flag From PrpGroup Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpGroupDto prpGroupDto = null;
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

            prpGroupDto = new PrpGroupDto();
            prpGroupDto.setGroupNo(dbManager.getString(resultSet,1));
            prpGroupDto.setSubGroupNo(dbManager.getString(resultSet,2));
            prpGroupDto.setFlag(dbManager.getString(resultSet,3));
            collection.add(prpGroupDto);
        }
        resultSet.close();
        log.info("DBPrpGroupBase.findByConditions() success!");
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
        String statement = "Delete From PrpGroup Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpGroupBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpGroup Where " + conditions;
         statement = SqlUtils.getWherePartForGetCount(statement);
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpGroupBase.getCount() success!");
        return count;
    }
}

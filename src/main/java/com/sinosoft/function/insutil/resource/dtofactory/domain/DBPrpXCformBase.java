package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpXCformDto;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpxcform�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:46<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpXCformBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpXCformBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpXCformBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpXCformDto prpXCformDto
     * @throws Exception
     */
    public void insert(PrpXCformDto prpXCformDto) throws Exception{
        String statement = " Insert Into PrpXCform(" + 
                           " RiskCode," + 
                           " FileType," + 
                           " LayRow," + 
                           " LayCol," + 
                           " FileName," + 
                           " TableName," + 
                           " Flag) values(?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpXCformDto.getRiskCode());
        dbManager.setString(2,prpXCformDto.getFileType());
        dbManager.setInt(3,prpXCformDto.getLayRow());
        dbManager.setInt(4,prpXCformDto.getLayCol());
        dbManager.setString(5,prpXCformDto.getFileName());
        dbManager.setString(6,prpXCformDto.getTableName());
        dbManager.setString(7,prpXCformDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpXCformBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpXCformDto prpXCformDto = (PrpXCformDto)i.next();
            insert(prpXCformDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param riskCode riskcode
     * @param fileType filetype
     * @throws Exception
     */
    public void delete(String riskCode,String fileType) throws Exception{
        String statement = " Delete From PrpXCform Where " +
                           " RiskCode = ? And " + 
                           " FileType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,fileType);
        dbManager.executePreparedUpdate();
        log.info("DBPrpXCformBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpXCformDto prpXCformDto
     * @throws Exception
     */
    public void update(PrpXCformDto prpXCformDto) throws Exception{
        String statement = " Update PrpXCform Set LayRow = ?," + 
                           " LayCol = ?," + 
                           " FileName = ?," + 
                           " TableName = ?," + 
                           " Flag = ? Where " +
                           " RiskCode = ? And " + 
                           " FileType = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setInt(1,prpXCformDto.getLayRow());
        dbManager.setInt(2,prpXCformDto.getLayCol());
        dbManager.setString(3,prpXCformDto.getFileName());
        dbManager.setString(4,prpXCformDto.getTableName());
        dbManager.setString(5,prpXCformDto.getFlag());
        //���������ֶ�;
        dbManager.setString(6,prpXCformDto.getRiskCode());
        dbManager.setString(7,prpXCformDto.getFileType());
        dbManager.executePreparedUpdate();

        log.info("DBPrpXCformBase.update() success!");
    }

    /**
     * ����������һ������
     * @param riskCode riskcode
     * @param fileType filetype
     * @return PrpXCformDto
     * @throws Exception
     */
    public PrpXCformDto findByPrimaryKey(String riskCode,String fileType) throws Exception{
        String statement = " Select RiskCode," + 
                           " FileType," + 
                           " LayRow," + 
                           " LayCol," + 
                           " FileName," + 
                           " TableName," + 
                           " Flag From PrpXCform Where " +
                           " RiskCode = ? And " + 
                           " FileType = ?";
        PrpXCformDto prpXCformDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,riskCode);
        dbManager.setString(2,fileType);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpXCformDto = new PrpXCformDto();
            prpXCformDto.setRiskCode(dbManager.getString(resultSet,1));
            prpXCformDto.setFileType(dbManager.getString(resultSet,2));
            prpXCformDto.setLayRow(dbManager.getInt(resultSet,3));
            prpXCformDto.setLayCol(dbManager.getInt(resultSet,4));
            prpXCformDto.setFileName(dbManager.getString(resultSet,5));
            prpXCformDto.setTableName(dbManager.getString(resultSet,6));
            prpXCformDto.setFlag(dbManager.getString(resultSet,7));
        }
        resultSet.close();
        log.info("DBPrpXCformBase.findByPrimaryKey() success!");
        return prpXCformDto;
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
        String statement = "Select RiskCode," + 
                           " FileType," + 
                           " LayRow," + 
                           " LayCol," + 
                           " FileName," + 
                           " TableName," + 
                           " Flag From PrpXCform Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpXCformDto prpXCformDto = null;
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

            prpXCformDto = new PrpXCformDto();
            prpXCformDto.setRiskCode(dbManager.getString(resultSet,1));
            prpXCformDto.setFileType(dbManager.getString(resultSet,2));
            prpXCformDto.setLayRow(dbManager.getInt(resultSet,3));
            prpXCformDto.setLayCol(dbManager.getInt(resultSet,4));
            prpXCformDto.setFileName(dbManager.getString(resultSet,5));
            prpXCformDto.setTableName(dbManager.getString(resultSet,6));
            prpXCformDto.setFlag(dbManager.getString(resultSet,7));
            collection.add(prpXCformDto);
        }
        resultSet.close();
        log.info("DBPrpXCformBase.findByConditions() success!");
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
        String statement = "Delete From PrpXCform Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpXCformBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpXCform Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpXCformBase.getCount() success!");
        return count;
    }
}

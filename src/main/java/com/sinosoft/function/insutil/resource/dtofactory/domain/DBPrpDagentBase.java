package com.sinosoft.function.insutil.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.function.insutil.dto.domain.PrpDagentDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdagent�����ݷ��ʶ�����<br>
 * ������ 2004-4-6 16:07:47<br>
 * JToolpad(1.2.4) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpDagentBase{
    protected DBManager dbManager = null; //��Դ������
    private static Log log = LogFactory.getLog(DBPrpDagentBase.class.getName());

    /**
     * ���캯��
     * @param dbManager ��Դ������
     */
    public DBPrpDagentBase(DBManager dbManager){
        this.dbManager = dbManager;
    }

    /**
     * ����һ������
     * @param prpDagentDto prpDagentDto
     * @throws Exception
     */
    public void insert(PrpDagentDto prpDagentDto) throws Exception{
        String statement = " Insert Into PrpDagent(" + 
                           " AgentCode," + 
                           " AgentName," + 
                           " AddressName," + 
                           " PostCode," + 
                           " AgentType," + 
                           " PermitNo," + 
                           " LinkerName," + 
                           " BargainDate," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " UpperAgentCode," + 
                           " NewAgentCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " Flag) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        dbManager.setString(1,prpDagentDto.getAgentCode());
        dbManager.setString(2,prpDagentDto.getAgentName());
        dbManager.setString(3,prpDagentDto.getAddressName());
        dbManager.setString(4,prpDagentDto.getPostCode());
        dbManager.setString(5,prpDagentDto.getAgentType());
        dbManager.setString(6,prpDagentDto.getPermitNo());
        dbManager.setString(7,prpDagentDto.getLinkerName());
        dbManager.setDateTime(8,prpDagentDto.getBargainDate());
        dbManager.setString(9,prpDagentDto.getPhoneNumber());
        dbManager.setString(10,prpDagentDto.getFaxNumber());
        dbManager.setString(11,prpDagentDto.getComCode());
        dbManager.setString(12,prpDagentDto.getHandlerCode());
        dbManager.setString(13,prpDagentDto.getUpperAgentCode());
        dbManager.setString(14,prpDagentDto.getNewAgentCode());
        dbManager.setString(15,prpDagentDto.getValidStatus());
        dbManager.setString(16,prpDagentDto.getArticleCode());
        dbManager.setString(17,prpDagentDto.getFlag());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDagentBase.insert() success!");
    }

    /**
     * �����������
     * @param collection collection
     * @throws Exception
     */
    public void insertAll(Collection collection) throws Exception{
        for (Iterator i = collection.iterator(); i.hasNext(); ) {
            PrpDagentDto prpDagentDto = (PrpDagentDto)i.next();
            insert(prpDagentDto);
        }
    }

    /**
     * ������ɾ��һ������
     * @param agentCode agentcode
     * @throws Exception
     */
    public void delete(String agentCode) throws Exception{
        String statement = " Delete From PrpDagent Where " +
                           " AgentCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,agentCode);
        dbManager.executePreparedUpdate();
        log.info("DBPrpDagentBase.delete() success!");
    }

    /**
     * ����������һ������(���������޷����)
     * @param prpDagentDto prpDagentDto
     * @throws Exception
     */
    public void update(PrpDagentDto prpDagentDto) throws Exception{
        String statement = " Update PrpDagent Set AgentName = ?," + 
                           " AddressName = ?," + 
                           " PostCode = ?," + 
                           " AgentType = ?," + 
                           " PermitNo = ?," + 
                           " LinkerName = ?," + 
                           " BargainDate = ?," + 
                           " PhoneNumber = ?," + 
                           " FaxNumber = ?," + 
                           " ComCode = ?," + 
                           " HandlerCode = ?," + 
                           " UpperAgentCode = ?," + 
                           " NewAgentCode = ?," + 
                           " ValidStatus = ?," + 
                           " ArticleCode = ?," + 
                           " Flag = ? Where " +
                           " AgentCode = ?";
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���ø����ֶ�;
        dbManager.setString(1,prpDagentDto.getAgentName());
        dbManager.setString(2,prpDagentDto.getAddressName());
        dbManager.setString(3,prpDagentDto.getPostCode());
        dbManager.setString(4,prpDagentDto.getAgentType());
        dbManager.setString(5,prpDagentDto.getPermitNo());
        dbManager.setString(6,prpDagentDto.getLinkerName());
        dbManager.setDateTime(7,prpDagentDto.getBargainDate());
        dbManager.setString(8,prpDagentDto.getPhoneNumber());
        dbManager.setString(9,prpDagentDto.getFaxNumber());
        dbManager.setString(10,prpDagentDto.getComCode());
        dbManager.setString(11,prpDagentDto.getHandlerCode());
        dbManager.setString(12,prpDagentDto.getUpperAgentCode());
        dbManager.setString(13,prpDagentDto.getNewAgentCode());
        dbManager.setString(14,prpDagentDto.getValidStatus());
        dbManager.setString(15,prpDagentDto.getArticleCode());
        dbManager.setString(16,prpDagentDto.getFlag());
        //���������ֶ�;
        dbManager.setString(17,prpDagentDto.getAgentCode());
        dbManager.executePreparedUpdate();

        log.info("DBPrpDagentBase.update() success!");
    }

    /**
     * ����������һ������
     * @param agentCode agentcode
     * @return PrpDagentDto
     * @throws Exception
     */
    public PrpDagentDto findByPrimaryKey(String agentCode) throws Exception{
        String statement = " Select AgentCode," + 
                           " AgentName," + 
                           " AddressName," + 
                           " PostCode," + 
                           " AgentType," + 
                           " PermitNo," + 
                           " LinkerName," + 
                           " BargainDate," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " UpperAgentCode," + 
                           " NewAgentCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " Flag From PrpDagent Where " +
                           " AgentCode = ?";
        PrpDagentDto prpDagentDto = null;
        log.debug(statement);
        dbManager.prepareStatement(statement);
        //���������ֶ�;
        dbManager.setString(1,agentCode);
        ResultSet resultSet = dbManager.executePreparedQuery();
        if(resultSet.next()){
            prpDagentDto = new PrpDagentDto();
            prpDagentDto.setAgentCode(dbManager.getString(resultSet,1));
            prpDagentDto.setAgentName(dbManager.getString(resultSet,2));
            prpDagentDto.setAddressName(dbManager.getString(resultSet,3));
            prpDagentDto.setPostCode(dbManager.getString(resultSet,4));
            prpDagentDto.setAgentType(dbManager.getString(resultSet,5));
            prpDagentDto.setPermitNo(dbManager.getString(resultSet,6));
            prpDagentDto.setLinkerName(dbManager.getString(resultSet,7));
            prpDagentDto.setBargainDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpDagentDto.setPhoneNumber(dbManager.getString(resultSet,9));
            prpDagentDto.setFaxNumber(dbManager.getString(resultSet,10));
            prpDagentDto.setComCode(dbManager.getString(resultSet,11));
            prpDagentDto.setHandlerCode(dbManager.getString(resultSet,12));
            prpDagentDto.setUpperAgentCode(dbManager.getString(resultSet,13));
            prpDagentDto.setNewAgentCode(dbManager.getString(resultSet,14));
            prpDagentDto.setValidStatus(dbManager.getString(resultSet,15));
            prpDagentDto.setArticleCode(dbManager.getString(resultSet,16));
            prpDagentDto.setFlag(dbManager.getString(resultSet,17));
        }
        resultSet.close();
        log.info("DBPrpDagentBase.findByPrimaryKey() success!");
        return prpDagentDto;
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
        String statement = "Select AgentCode," + 
                           " AgentName," + 
                           " AddressName," + 
                           " PostCode," + 
                           " AgentType," + 
                           " PermitNo," + 
                           " LinkerName," + 
                           " BargainDate," + 
                           " PhoneNumber," + 
                           " FaxNumber," + 
                           " ComCode," + 
                           " HandlerCode," + 
                           " UpperAgentCode," + 
                           " NewAgentCode," + 
                           " ValidStatus," + 
                           " ArticleCode," + 
                           " Flag From PrpDagent Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpDagentDto prpDagentDto = null;
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

            prpDagentDto = new PrpDagentDto();
            prpDagentDto.setAgentCode(dbManager.getString(resultSet,1));
            prpDagentDto.setAgentName(dbManager.getString(resultSet,2));
            prpDagentDto.setAddressName(dbManager.getString(resultSet,3));
            prpDagentDto.setPostCode(dbManager.getString(resultSet,4));
            prpDagentDto.setAgentType(dbManager.getString(resultSet,5));
            prpDagentDto.setPermitNo(dbManager.getString(resultSet,6));
            prpDagentDto.setLinkerName(dbManager.getString(resultSet,7));
            prpDagentDto.setBargainDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,8));
            prpDagentDto.setPhoneNumber(dbManager.getString(resultSet,9));
            prpDagentDto.setFaxNumber(dbManager.getString(resultSet,10));
            prpDagentDto.setComCode(dbManager.getString(resultSet,11));
            prpDagentDto.setHandlerCode(dbManager.getString(resultSet,12));
            prpDagentDto.setUpperAgentCode(dbManager.getString(resultSet,13));
            prpDagentDto.setNewAgentCode(dbManager.getString(resultSet,14));
            prpDagentDto.setValidStatus(dbManager.getString(resultSet,15));
            prpDagentDto.setArticleCode(dbManager.getString(resultSet,16));
            prpDagentDto.setFlag(dbManager.getString(resultSet,17));
            collection.add(prpDagentDto);
        }
        resultSet.close();
        log.info("DBPrpDagentBase.findByConditions() success!");
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
        String statement = "Delete From PrpDagent Where " + conditions;
        log.debug(statement);
        int count = dbManager.executeUpdate(statement);
        log.info("DBPrpDagentBase.deleteByConditions() success!");
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
        String statement = "Select count(*) from PrpDagent Where " + conditions;
        log.debug(statement);
        ResultSet resultSet = dbManager.executeQuery(statement);
        resultSet.next();
        count = dbManager.getInt(resultSet,1);
        resultSet.close();
        log.info("DBPrpDagentBase.getCount() success!");
        return count;
    }
}

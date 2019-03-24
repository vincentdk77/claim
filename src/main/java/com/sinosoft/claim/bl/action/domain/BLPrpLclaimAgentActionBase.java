package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLclaimAgentDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLclaimAgent;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLclaimAgent-�����Ᵽ����Ϣ���ҵ���߼�������<br>
 * ������ 2005-03-18 17:53:38.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLclaimAgentActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLclaimAgentActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLclaimAgentActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLclaimAgentDto prpLclaimAgentDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLclaimAgentDto prpLclaimAgentDto) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        //�����¼
        dbPrpLclaimAgent.insert(prpLclaimAgentDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @throws Exception
     */
    public void delete(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        //ɾ����¼
        dbPrpLclaimAgent.delete(claimNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        //������ɾ����¼
        dbPrpLclaimAgent.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLclaimAgentDto prpLclaimAgentDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLclaimAgentDto prpLclaimAgentDto) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        //���¼�¼
        dbPrpLclaimAgent.update(prpLclaimAgentDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo �ⰸ��
     * @return prpLclaimAgentDto prpLclaimAgentDto
     * @throws Exception
     */
    public PrpLclaimAgentDto findByPrimaryKey(DBManager dbManager,String claimNo) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        //����DTO
        PrpLclaimAgentDto prpLclaimAgentDto = null;
        //��ѯ����,��ֵ��DTO
        prpLclaimAgentDto = dbPrpLclaimAgent.findByPrimaryKey(claimNo);
        return prpLclaimAgentDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return PageRecord ��ѯ��һҳ�Ľ��
     * @throws Exception
     */
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimAgent.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLclaimAgent.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLclaimAgentDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLclaimAgent.findByConditions(conditions);
        return collection;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions ģ����ѯ����
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpLclaimAgent dbPrpLclaimAgent = new DBPrpLclaimAgent(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLclaimAgent.getCount(conditions);
        return count;
    }
}

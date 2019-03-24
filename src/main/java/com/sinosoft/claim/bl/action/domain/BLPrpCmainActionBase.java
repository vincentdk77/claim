package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCmain;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpcmain����������Ϣ���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:24<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpCmainActionBase{
    private static Log log = LogFactory.getLog(BLPrpCmainActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpCmainActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpCmainDto prpCmainDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpCmainDto prpCmainDto) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        //�����¼
        dbPrpCmain.insert(prpCmainDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String policyNo) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        //ɾ����¼
        dbPrpCmain.delete(policyNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        //������ɾ����¼
        dbPrpCmain.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpCmainDto prpCmainDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpCmainDto prpCmainDto) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        //���¼�¼
        dbPrpCmain.update(prpCmainDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param policyNo ��������
     * @return prpCmainDto prpCmainDto
     * @throws Exception
     */
    public PrpCmainDto findByPrimaryKey(DBManager dbManager,String policyNo) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        //����DTO
        PrpCmainDto prpCmainDto = null;
        //��ѯ����,��ֵ��DTO
        prpCmainDto = dbPrpCmain.findByPrimaryKey(policyNo);
        return prpCmainDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpCmainDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpCmain.getCount(conditions);
        collection = dbPrpCmain.findByConditions(conditions,pageNo,rowsPerPage);
        return collection;
    }

    /**
     * ������findByConditions�����,����findByConditions��ѯ���ļ�¼��
     * @return ��¼��
     */
    public int getRowCount(){
        return rowCount;
    }

    /**
     * ��ѯ����ģ����ѯ�����ļ�¼��
     * @param dbManager DB������
     * @param conditions conditions
     * @return ����ģ����ѯ�����ļ�¼��
     * @throws Exception
     */
    public int getRowCount(DBManager dbManager,String conditions) 
        throws Exception{
        DBPrpCmain dbPrpCmain = new DBPrpCmain(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpCmain.getCount(conditions);
        return count;
    }
}

package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDcodeRiskDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcodeRisk;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdcoderiskͨ�ô������ֶ��ձ��ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDcodeRiskActionBase{
    private static Log log = LogFactory.getLog(BLPrpDcodeRiskActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDcodeRiskActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDcodeRiskDto prpDcodeRiskDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDcodeRiskDto prpDcodeRiskDto) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        //�����¼
        dbPrpDcodeRisk.insert(prpDcodeRiskDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param codeType ��������
     * @param codeCode ҵ�����
     * @param riskCode ���ִ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType,String codeCode,String riskCode) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        //ɾ����¼
        dbPrpDcodeRisk.delete(codeType, codeCode, riskCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        //������ɾ����¼
        dbPrpDcodeRisk.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDcodeRiskDto prpDcodeRiskDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDcodeRiskDto prpDcodeRiskDto) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        //���¼�¼
        dbPrpDcodeRisk.update(prpDcodeRiskDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param codeType ��������
     * @param codeCode ҵ�����
     * @param riskCode ���ִ���
     * @return prpDcodeRiskDto prpDcodeRiskDto
     * @throws Exception
     */
    public PrpDcodeRiskDto findByPrimaryKey(DBManager dbManager,String codeType,String codeCode,String riskCode) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        //����DTO
        PrpDcodeRiskDto prpDcodeRiskDto = null;
        //��ѯ����,��ֵ��DTO
        prpDcodeRiskDto = dbPrpDcodeRisk.findByPrimaryKey(codeType, codeCode, riskCode);
        return prpDcodeRiskDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDcodeRiskDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDcodeRisk.getCount(conditions);
        collection = dbPrpDcodeRisk.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDcodeRisk dbPrpDcodeRisk = new DBPrpDcodeRisk(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDcodeRisk.getCount(conditions);
        return count;
    }
}

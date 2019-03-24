package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpIDCodeDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpIDCode;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpidcode�ӿڴ�����ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpIDCodeActionBase{
    private static Log log = LogFactory.getLog(BLPrpIDCodeActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpIDCodeActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpIDCodeDto prpIDCodeDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpIDCodeDto prpIDCodeDto) throws Exception{
        DBPrpIDCode dbPrpIDCode = new DBPrpIDCode(dbManager);
        //�����¼
        dbPrpIDCode.insert(prpIDCodeDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param codeType �ӿڴ�������
     * @param riskCode ���ִ���
     * @param codeCode ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String codeType,String riskCode,String codeCode) throws Exception{
        DBPrpIDCode dbPrpIDCode = new DBPrpIDCode(dbManager);
        //ɾ����¼
        dbPrpIDCode.delete(codeType, riskCode, codeCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpIDCode dbPrpIDCode = new DBPrpIDCode(dbManager);
        //������ɾ����¼
        dbPrpIDCode.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpIDCodeDto prpIDCodeDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpIDCodeDto prpIDCodeDto) throws Exception{
        DBPrpIDCode dbPrpIDCode = new DBPrpIDCode(dbManager);
        //���¼�¼
        dbPrpIDCode.update(prpIDCodeDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param codeType �ӿڴ�������
     * @param riskCode ���ִ���
     * @param codeCode ����
     * @return prpIDCodeDto prpIDCodeDto
     * @throws Exception
     */
    public PrpIDCodeDto findByPrimaryKey(DBManager dbManager,String codeType,String riskCode,String codeCode) throws Exception{
        DBPrpIDCode dbPrpIDCode = new DBPrpIDCode(dbManager);
        //����DTO
        PrpIDCodeDto prpIDCodeDto = null;
        //��ѯ����,��ֵ��DTO
        prpIDCodeDto = dbPrpIDCode.findByPrimaryKey(codeType, riskCode, codeCode);
        return prpIDCodeDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpIDCodeDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpIDCode dbPrpIDCode = new DBPrpIDCode(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpIDCode.getCount(conditions);
        collection = dbPrpIDCode.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpIDCode dbPrpIDCode = new DBPrpIDCode(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpIDCode.getCount(conditions);
        return count;
    }
}

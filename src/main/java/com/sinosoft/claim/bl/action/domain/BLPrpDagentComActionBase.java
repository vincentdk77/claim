package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDagentComDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDagentCom;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdagentcom�б�����,�б���˾���ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDagentComActionBase{
    private static Log log = LogFactory.getLog(BLPrpDagentComActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDagentComActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDagentComDto prpDagentComDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDagentComDto prpDagentComDto) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        //�����¼
        dbPrpDagentCom.insert(prpDagentComDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param centreCode �б���������
     * @param unitCode �б���˾����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String centreCode,String unitCode) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        //ɾ����¼
        dbPrpDagentCom.delete(centreCode, unitCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        //������ɾ����¼
        dbPrpDagentCom.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDagentComDto prpDagentComDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDagentComDto prpDagentComDto) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        //���¼�¼
        dbPrpDagentCom.update(prpDagentComDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param centreCode �б���������
     * @param unitCode �б���˾����
     * @return prpDagentComDto prpDagentComDto
     * @throws Exception
     */
    public PrpDagentComDto findByPrimaryKey(DBManager dbManager,String centreCode,String unitCode) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        //����DTO
        PrpDagentComDto prpDagentComDto = null;
        //��ѯ����,��ֵ��DTO
        prpDagentComDto = dbPrpDagentCom.findByPrimaryKey(centreCode, unitCode);
        return prpDagentComDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDagentComDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDagentCom.getCount(conditions);
        collection = dbPrpDagentCom.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDagentCom dbPrpDagentCom = new DBPrpDagentCom(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDagentCom.getCount(conditions);
        return count;
    }
}

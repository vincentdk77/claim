package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpDlimitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDlimit;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpdlimit�޶����������ҵ���߼�������<br>
 * ������ 2004-4-5 15:33:45<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpDlimitActionBase{
    private static Log log = LogFactory.getLog(BLPrpDlimitActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpDlimitActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpDlimitDto prpDlimitDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpDlimitDto prpDlimitDto) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //�����¼
        dbPrpDlimit.insert(prpDlimitDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param limitCode �޶�/����������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String riskCode,String limitCode) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //ɾ����¼
        dbPrpDlimit.delete(riskCode, limitCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //������ɾ����¼
        dbPrpDlimit.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpDlimitDto prpDlimitDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpDlimitDto prpDlimitDto) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //���¼�¼
        dbPrpDlimit.update(prpDlimitDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param riskCode ���ִ���
     * @param limitCode �޶�/����������
     * @return prpDlimitDto prpDlimitDto
     * @throws Exception
     */
    public PrpDlimitDto findByPrimaryKey(DBManager dbManager,String riskCode,String limitCode) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        //����DTO
        PrpDlimitDto prpDlimitDto = null;
        //��ѯ����,��ֵ��DTO
        prpDlimitDto = dbPrpDlimit.findByPrimaryKey(riskCode, limitCode);
        return prpDlimitDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpDlimitDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpDlimit.getCount(conditions);
        collection = dbPrpDlimit.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpDlimit dbPrpDlimit = new DBPrpDlimit(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpDlimit.getCount(conditions);
        return count;
    }
}

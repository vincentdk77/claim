package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpJrefPayRecDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpJrefPayRec;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����prpjrefpayrec���Ѻ��շ���ϵ��¼���ҵ���߼�������<br>
 * ������ 2004-4-5 15:32:25<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLPrpJrefPayRecActionBase{
    private static Log log = LogFactory.getLog(BLPrpJrefPayRecActionBase.class.getName());
    private int rowCount; //findByConditions��ѯ���ļ�¼��

    /**
     * ���캯��
     */
    public BLPrpJrefPayRecActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpJrefPayRecDto prpJrefPayRecDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpJrefPayRecDto prpJrefPayRecDto) throws Exception{
        DBPrpJrefPayRec dbPrpJrefPayRec = new DBPrpJrefPayRec(dbManager);
        //�����¼
        dbPrpJrefPayRec.insert(prpJrefPayRecDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @throws Exception
     */
    public void delete(DBManager dbManager,String certiNo,int serialNo) throws Exception{
        DBPrpJrefPayRec dbPrpJrefPayRec = new DBPrpJrefPayRec(dbManager);
        //ɾ����¼
        dbPrpJrefPayRec.delete(certiNo, serialNo);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param condtions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpJrefPayRec dbPrpJrefPayRec = new DBPrpJrefPayRec(dbManager);
        //������ɾ����¼
        dbPrpJrefPayRec.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpJrefPayRecDto prpJrefPayRecDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpJrefPayRecDto prpJrefPayRecDto) throws Exception{
        DBPrpJrefPayRec dbPrpJrefPayRec = new DBPrpJrefPayRec(dbManager);
        //���¼�¼
        dbPrpJrefPayRec.update(prpJrefPayRecDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param certiNo ��������/��������/�����������
     * @param serialNo ���θ������
     * @return prpJrefPayRecDto prpJrefPayRecDto
     * @throws Exception
     */
    public PrpJrefPayRecDto findByPrimaryKey(DBManager dbManager,String certiNo,int serialNo) throws Exception{
        DBPrpJrefPayRec dbPrpJrefPayRec = new DBPrpJrefPayRec(dbManager);
        //����DTO
        PrpJrefPayRecDto prpJrefPayRecDto = null;
        //��ѯ����,��ֵ��DTO
        prpJrefPayRecDto = dbPrpJrefPayRec.findByPrimaryKey(certiNo, serialNo);
        return prpJrefPayRecDto;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @param pageNo ҳ��
     * @param rowsPerPage ÿҳ������
     * @return Collection ����prpJrefPayRecDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage) throws Exception{
        DBPrpJrefPayRec dbPrpJrefPayRec = new DBPrpJrefPayRec(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        rowCount = dbPrpJrefPayRec.getCount(conditions);
        collection = dbPrpJrefPayRec.findByConditions(conditions,pageNo,rowsPerPage);
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
        DBPrpJrefPayRec dbPrpJrefPayRec = new DBPrpJrefPayRec(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpJrefPayRec.getCount(conditions);
        return count;
    }
}

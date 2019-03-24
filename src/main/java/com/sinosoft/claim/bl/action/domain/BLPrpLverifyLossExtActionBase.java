package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLverifyLossExtDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLverifyLossExt;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLverifyLossExt��ҵ���߼�������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class BLPrpLverifyLossExtActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLverifyLossExtActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLverifyLossExtActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLverifyLossExtDto prpLverifyLossExtDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLverifyLossExtDto prpLverifyLossExtDto)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        //�����¼
        dbPrpLverifyLossExt.insert(prpLverifyLossExtDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param registNo RegistNo
     * @param serialNo SerialNo
     * @throws Exception
     */
    public void delete(DBManager dbManager,String registNo,int serialNo,String lossItemCode)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        //ɾ����¼
        dbPrpLverifyLossExt.delete(registNo, serialNo,lossItemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        //������ɾ����¼
        dbPrpLverifyLossExt.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLverifyLossExtDto prpLverifyLossExtDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLverifyLossExtDto prpLverifyLossExtDto)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        //���¼�¼
        dbPrpLverifyLossExt.update(prpLverifyLossExtDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo RegistNo
     * @param serialNo SerialNo
     * @return prpLverifyLossExtDto prpLverifyLossExtDto
     * @throws Exception
     */
    public PrpLverifyLossExtDto findByPrimaryKey(DBManager dbManager,String registNo,int serialNo,String lossItemCode)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        //����DTO
        PrpLverifyLossExtDto prpLverifyLossExtDto = null;
        //��ѯ����,��ֵ��DTO
        prpLverifyLossExtDto = dbPrpLverifyLossExt.findByPrimaryKey(registNo, serialNo,lossItemCode);
        return prpLverifyLossExtDto;
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
    public PageRecord findByConditions(DBManager dbManager,String conditions,int pageNo,int rowsPerPage)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLverifyLossExt.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLverifyLossExt.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLverifyLossExtDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions)
            throws Exception{
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLverifyLossExt.findByConditions(conditions);
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
        DBPrpLverifyLossExt dbPrpLverifyLossExt = new DBPrpLverifyLossExt(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLverifyLossExt.getCount(conditions);
        return count;
    }
}

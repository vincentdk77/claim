package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLcertifyImg;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����PrpLcertifyImg-����ͼƬ�ϴ�·����ҵ���߼�������<br>
 * ������ 2005-03-23 16:36:58.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class BLPrpLcertifyImgActionBase{
    private static Log logger = LogFactory.getLog(BLPrpLcertifyImgActionBase.class);

    /**
     * ���캯��
     */
    public BLPrpLcertifyImgActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param prpLcertifyImgDto prpLcertifyImgDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        //�����¼
        dbPrpLcertifyImg.insert(prpLcertifyImgDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param businessNo ҵ�����
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @throws Exception
     */
    public void delete(DBManager dbManager,String businessNo,int serialNo,String lossItemCode) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        //ɾ����¼
        dbPrpLcertifyImg.delete(businessNo, serialNo, lossItemCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        //������ɾ����¼
        dbPrpLcertifyImg.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param prpLcertifyImgDto prpLcertifyImgDto
     * @throws Exception
     */
    public void update(DBManager dbManager,PrpLcertifyImgDto prpLcertifyImgDto) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        //���¼�¼
        dbPrpLcertifyImg.update(prpLcertifyImgDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param businessNo ҵ�����
     * @param serialNo ���
     * @param lossItemCode ��Ĵ���
     * @return prpLcertifyImgDto prpLcertifyImgDto
     * @throws Exception
     */
    public PrpLcertifyImgDto findByPrimaryKey(DBManager dbManager,String businessNo,int serialNo,String lossItemCode) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        //����DTO
        PrpLcertifyImgDto prpLcertifyImgDto = null;
        //��ѯ����,��ֵ��DTO
        prpLcertifyImgDto = dbPrpLcertifyImg.findByPrimaryKey(businessNo, serialNo, lossItemCode);
        return prpLcertifyImgDto;
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
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyImg.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbPrpLcertifyImg.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����prpLcertifyImgDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbPrpLcertifyImg.findByConditions(conditions);
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
        DBPrpLcertifyImg dbPrpLcertifyImg = new DBPrpLcertifyImg(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbPrpLcertifyImg.getCount(conditions);
        return count;
    }
}

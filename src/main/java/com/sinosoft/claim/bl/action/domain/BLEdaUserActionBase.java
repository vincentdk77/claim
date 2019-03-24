package com.sinosoft.claim.bl.action.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.EdaUserDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBEdaUser;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.SqlUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ����EdaUser-��ϯԱ��Ϣ���ҵ���߼�������<br>
 * ������ 2005-06-22 14:57:10.201<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class BLEdaUserActionBase{
    private static Log logger = LogFactory.getLog(BLEdaUserActionBase.class);

    /**
     * ���캯��
     */
    public BLEdaUserActionBase(){
    }

    /**
     * ����һ������
     * @param dbManager DB������
     * @param edaUserDto edaUserDto
     * @throws Exception
     */
    public void insert(DBManager dbManager,EdaUserDto edaUserDto) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        //�����¼
        dbEdaUser.insert(edaUserDto);
    }

    /**
     * ������ɾ��һ������
     * @param dbManager DB������
     * @param edaUserCode ��ϯԱ����
     * @throws Exception
     */
    public void delete(DBManager dbManager,String edaUserCode) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        //ɾ����¼
        dbEdaUser.delete(edaUserCode);
    }

    /**
     * ������ɾ������
     * @param dbManager DB������
     * @param conditions ɾ������
     * @throws Exception
     */
    public void deleteByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        //������ɾ����¼
        dbEdaUser.deleteByConditions(conditions);
    }

    /**
     * ����������һ������(���������޷����)
     * @param dbManager DB������
     * @param edaUserDto edaUserDto
     * @throws Exception
     */
    public void update(DBManager dbManager,EdaUserDto edaUserDto) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        //���¼�¼
        dbEdaUser.update(edaUserDto);
    }

    /**
     * ����������һ������
     * @param dbManager DB������
     * @param edaUserCode ��ϯԱ����
     * @return edaUserDto edaUserDto
     * @throws Exception
     */
    public EdaUserDto findByPrimaryKey(DBManager dbManager,String edaUserCode) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        //����DTO
        EdaUserDto edaUserDto = null;
        //��ѯ����,��ֵ��DTO
        edaUserDto = dbEdaUser.findByPrimaryKey(edaUserCode);
        return edaUserDto;
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
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaUser.getCount(SqlUtils.getWherePartForGetCount(conditions));
        collection = dbEdaUser.findByConditions(conditions,pageNo,rowsPerPage);
        PageRecord pageRecord = new PageRecord(count,pageNo,1,rowsPerPage,collection);
        return pageRecord;
    }

    /**
     * ��������ѯ��������
     * @param dbManager DB������
     * @param conditions ��ѯ����
     * @return Collection ����edaUserDto�ļ���
     * @throws Exception
     */
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);
        Collection collection = new ArrayList();

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        collection = dbEdaUser.findByConditions(conditions);
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
        DBEdaUser dbEdaUser = new DBEdaUser(dbManager);

        if(conditions.trim().length()==0){
            conditions = "1=1";
        }

        int count = dbEdaUser.getCount(conditions);
        return count;
    }
}

package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import java.util.Collection;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcertifyImg�����ݴ��������<br>
 * ������ 2004-07-05 17:15:52.448<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcertifyImgDto extends PrpLcertifyImgDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcertifyImgDto����
     */
    public PrpLcertifyImgDto(){
    }
    /** ���� **/
    Collection certifyImgList;
    /** �༭���� */
    private String editType = "";

    /** �������Ĳ���״̬ 1��δ���� 2�����ڴ��� 3������� 4�����ύ 5�� ���� */
    private String status ="";

    /**�õ���֤�Ĳ���״̬
    * @return ��֤�Ĳ���״̬
    */
     public String getStatus() {
       return status;
     }

    /**���õ�֤�Ĳ���״̬
    * @param status ��֤�Ĳ���״̬
    */
     public void setStatus(String status) {
       this.status = status;
     }
   /**
     * ���ñ༭����
     * @param editType �����õı༭���͵�ֵ
     */
    public void setEditType(String editType){
        this.editType = StringUtils.rightTrim(editType);
    }

    /**
     * ��ȡ�༭����
     * @return ���Ա༭����
     */
    public String getEditType(){
        return editType;
    }

    /**�õ���֤����
    * @return ��֤������Ϣ
    */
    public Collection getCertifyImgList() {
      return certifyImgList;
    }

    /**���õ�֤����
    * @param certifyCollectList ��֤����
    */
    public void setCertifyImgList(Collection certifyImgList) {
      this.certifyImgList = certifyImgList;
    }
}

package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLbackVisit--�ط���Ϣ��������ݴ��������<br>
 * ������ 2005-03-23 08:59:50.781<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLbackVisitDto extends PrpLbackVisitDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLbackVisitDto����
     */
    public PrpLbackVisitDto(){
    }

    /** ����״̬ 1��δ���� 2�����ڴ��� 3������� 4�����ύ 5�� ���� */
    private String status ="";

    /**
     * �������Բ���״̬
     * @param status �����õ����Բ���״̬
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**
     * ��ȡ���Բ���״̬
     * @return ���Բ���״̬
     */
    public String getStatus(){
        return status;
    }

}

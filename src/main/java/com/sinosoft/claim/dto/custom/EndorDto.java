package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * �Զ����������ݴ������
 * <p>Title: ������������DTO</p>
 * <p>Description: ��������������������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class EndorDto implements Serializable
{
  /** �����������*/
  private ArrayList prpLendorList;
  /** ׷����������˵��*/
  private ArrayList prpLrtextList;

  public ArrayList getPrpLrtextList() {
    return prpLrtextList;
  }

  public void setPrpLendorList(ArrayList prpLendorList) {
    this.prpLendorList = prpLendorList;
  }

  public void setPrpLrtextList(ArrayList prpLrtextList) {
    this.prpLrtextList = prpLrtextList;
  }

  public ArrayList getPrpLendorList() {
    return prpLendorList;
  }
}

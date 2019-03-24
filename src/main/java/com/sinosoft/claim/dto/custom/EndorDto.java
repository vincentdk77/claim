package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 自定义批单数据传输对象
 * <p>Title: 车险理赔批单DTO</p>
 * <p>Description: 车险理赔批单样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class EndorDto implements Serializable
{
  /** 理赔冲减保额表*/
  private ArrayList prpLendorList;
  /** 追偿损余文字说明*/
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

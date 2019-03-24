package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 * ����MidResultConfig���ҳ�����ñ�����ݴ��������<br>
 * ������ 2005-03-11 10:51:25.921<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class MidResultConfigDto extends MidResultConfigDtoBase implements Serializable{
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�MidResultConfigDto����
     */
    public MidResultConfigDto(){
    }

  /**��ѯ��ʽ��S-���ܲ�ѯ��D����ϸ��ѯ*/
  private String style ="";
  /**�Ƿ��½��´���*/
  private String windowFlag = "0";
  /**ͳ����ʵ����*/
  private String startDate = "";
  /**ͳ�ƽ�������*/
  private String endDate = "";
  /**��ϸ��ѯ��URL*/
  private String strURL = "";
  /**��ʾλ�ã�right,left,center*/
  private String strAlign = "right";
  /** ��ı���*/
  private String tableName = "";

  public void setStyle(String iStyle)
  {
    this.style =iStyle ;
  }

  public String getStyle()
  {
    return style;
  }

  public void setWindowFlag(String iWindowFlag)
  {
    this.windowFlag = iWindowFlag;
  }

  public String getWindowFlag()
  {
    return windowFlag;
  }

  public void setStartDate(String iStartDate)
  {
    this.startDate = iStartDate;
  }

  public String getStartDate()
  {
    return startDate;
  }

  public void setEndDate(String iEndDate)
  {
    this.endDate = iEndDate;
  }

  public String getEndDate()
  {
    return endDate;
  }

  public void setURL(String iURL)
  {
    this.strURL = iURL;
  }

  public String getURL()
  {
    return strURL;
  }

   public void setAlign(String iAlign)
  {
    this.strAlign = iAlign;
  }

  public String getAlign()
  {
    return strAlign;
  }

  public void setTableName(String tableName)
  {
    this.tableName = tableName;
  }
  public String getTableName()
  {
    return tableName;
  }
  public boolean equals(MidResultConfigDto midResultConfigDto){
  	if(!this.getColumnType().equals(midResultConfigDto.getColumnType())){
  		System.out.println("ColumnType not Equal");
  		return false;
  	}
  	if(!this.getConfigOwner().equals(midResultConfigDto.getConfigOwner())){
  		System.out.println("ConfigOwner not Equal");
  		return false;
  	}
  	if(!this.getDataType().equals(midResultConfigDto.getDataType())){
  		System.out.println("DataType not Equal");
  		return false;
  	}
  	if(!this.getGroupFlag().equals(midResultConfigDto.getGroupFlag())){
  		System.out.println("GroupFlag not Equal");
  		return false;
  	}
  	if(!this.getItemColumn().equals(midResultConfigDto.getItemColumn())){
  		System.out.println("ItemColumn not Equal");
  		return false;
  	}
  	if(!this.getItemColumnName().equals(midResultConfigDto.getItemColumnName())){
  		System.out.println("ItemColumnName not Equal");
  		return false;
  	}
  	if(this.getItemNo()!=midResultConfigDto.getItemNo()) {
  		
  		System.out.println("ItemNo not Equal");
  		return false;
  	}
  	if(!this.getItemTable().equals(midResultConfigDto.getItemTable())){
  		System.out.println("ItemTable not Equal");
  		return false;
  	}
  	if(!this.getLinkFlag().equals(midResultConfigDto.getLinkFlag())) {
  		System.out.println("LinkFlag not Equal");
  		return false;
  	}
  	if(!this.getOrderType().equals(midResultConfigDto.getOrderType())){
  		System.out.println("OrderType not Equal");
  		return false;
  	}
  	if(!this.getResultType().equals(midResultConfigDto.getResultType())){
  		System.out.println("ResultType not Equal");
  		return false;
  	}
  	if(!this.getResultTypeName().equals(midResultConfigDto.getResultTypeName())) {
  		System.out.println("ResultTypeName not Equal");
  		return false;
  	}
  	if(!this.getSelectFlag().equals(midResultConfigDto.getSelectFlag())) {
  		System.out.println("SelectFlag not Equal");
  		return false;
  	}
  	if(!this.getShowAlign().equals(midResultConfigDto.getShowAlign())) {
  		System.out.println("ShowAlign not Equal");
  		return false;
  	}
  	if(!this.getShowStatus().equals(midResultConfigDto.getShowStatus())) {
  		System.out.println("ShowStatus not Equal");
  		return false;
  	}
  	if(this.getShowWidth()!=midResultConfigDto.getShowWidth()) {
  		System.out.println("ShowWidth not Equal");
  		return false;
  	}
  	return true;
  }
  public static void main(String[]args){
  	MidResultConfigDto	midResultConfigDto	=	new	MidResultConfigDto();
  	MidResultConfigDto	midResultConfigDto1	=	new	MidResultConfigDto();
  	midResultConfigDto.setDataType(null);
  	midResultConfigDto1.setDataType(null);
  	midResultConfigDto.setGroupFlag(null);
  	midResultConfigDto1.setGroupFlag(null);
  	String strA=new String("a");
  	String strB=new String("a");
  	//strA	=	"b";
  	if(strA==strB)
  	{
System.out.println("equals");
  	}
  	else
System.out.println("not equals");
  }
}


/*
****************************************************************************
* DESC       ����֤�������ƽű� 
* AUTHOR     ��liubvo 
* CREATEDATE ��2005-01-25
* MODIFYLIST ��  Name       Date            Reason/Contents
*          ------------------------------------------------------


/**
 @description ��ҳ�ж� 
 @param       page��ǰҳ��
 @return      �� 
 */
function currPage( page ){
	document.forms[0].pageNo.value = page;
	//document.forms[0].editType.value = "RegistBeforeQuery";
	document.forms[0].submit();
  } 
   
/**
 @description ǰһҳ
 @param       page��ǰҳ��
 @return      ��
 */
function PrePage( page ){
	currPage( page-1 );
   }
   
/**
 @description ��һҳ
 @param       page��ǰҳ��
 @return      ��
 */
function NextPage( page ){
	currPage( page+1 );
   }
   
/**
 @description ��������ҳ
 @param       ��
 @return      ��
 */
function ChangePage(){

	var page = document.forms[0].changepage.value;
	if (CheckPage(page)) currPage(page);			    
}


/**
 @description ������ҳ
 @param       ��
 @return      ��
 */
function FirstPage(){

	var page = 1;	
	currPage(page);			    
}

/**
 @description ����βҳ
 @param       ��
 @return      ��
 */
function LastPage(){

	var page = document.forms[0].totalPage.value;	
	currPage(page);			    
}


/**
 @description У��ҳ��
 @param       ��
 @return      ��
 */
function CheckPage(pageNo){
  
  var page = parseInt(pageNo);	
  var totalPage=parseInt(document.forms[0].totalPage.value);
	
	if (isNaN(page))
	{
		alert("������Ϸ���ҳ����");
    return false;
	}
	
	if (page.toString().length!=pageNo.length)
	{
		alert("�������������͵�ҳ����");
    return false;
	}
	
	if (page<1) 
	{
		alert("��ת��ҳ������С��1��");
    return false;
	}
	
	if (page>totalPage) 
	{
		alert("��ת��ҳ�����ܴ�����ҳ����");
    return false;
	}
	
	return true;
				    
}

/****************************************************************************
* DESC       ��SelectCode.js
* AUTHOR     ��weishixin
* CREATEDATE ��2004-11-29
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/

function selectCode(field)
{
  if (field.value.length==0)
    return;
  var oldTarget = fm.target;
  var oldAction = fm.action;

  fm.target="fraSubmit"
  fm.action="/claim/test/SelectCode.jsp?nodeType=" + field.value;
  fm.submit();

  fm.target=oldTarget;
  fm.action=oldAction;	
  return;
}

//�ָ���벢����select����
//���ĸ�ʽ: ֵFIELD_SEPARATOR�ı�GROUP_SEPARATORֵFIELD_SEPARATOR�ı�...
function setFrameOption(selectName,strValue)
{
  //�鲻�����뷵��
  if(strValue==null || trim(strValue)=="")
  {
    return;
  }

  var arrayField=strValue.split(GROUP_SEPARATOR);
  var i=0;
  var j=0;
  var intCount = getFrameElementCount(selectName);

  if(intCount>1)
  {
    for(j=0;j<intCount;j++)
    {
      parent.fraInterface.fm.all(selectName)[j].options.length = 0;
    }
  }
  else
  {
    parent.fraInterface.fm.all(selectName).options.length = 0;
  }

  while(i<arrayField.length)
  {
    if(intCount>1)
    {
      for(j=0;j<intCount;j++)
      {
        var option=parent.fraInterface.document.createElement("option");
        var arrayTemp=arrayField[i].split(FIELD_SEPARATOR);
        var strFieldName=arrayTemp[0];
        var strFieldValue=unescape(arrayTemp[1]);
        option.value=strFieldName;
        option.text=strFieldValue;

        parent.fraInterface.fm.all(selectName)[j].add(option);
      }
    }
    else
    {
        var option=parent.fraInterface.document.createElement("option");
        var arrayTemp=arrayField[i].split(FIELD_SEPARATOR);
        var strFieldName=arrayTemp[0];
        var strFieldValue=unescape(arrayTemp[1]);
        option.value=strFieldName;
        option.text=strFieldValue;
        parent.fraInterface.fm.all(selectName).add(option);
    }
    i++;
  }
}


/**
 * ������Document�е�element��name���Ե��紫��ֵ��element������û���򷵻�0
 * @param fieldName Ԫ������
 * @return ��Document�е�element��name���Ե��紫��ֵ��element����
 */
function getFrameElementCount(fieldName)
{
    var count = 0;
    count = parent.fraInterface.document.getElementsByName(fieldName).length;
    return count;
}
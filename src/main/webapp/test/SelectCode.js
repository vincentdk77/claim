/****************************************************************************
* DESC       ：SelectCode.js
* AUTHOR     ：weishixin
* CREATEDATE ：2004-11-29
* MODIFYLIST ：   Name       Date            Reason/Contents
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

//分割代码并放在select域里
//串的格式: 值FIELD_SEPARATOR文本GROUP_SEPARATOR值FIELD_SEPARATOR文本...
function setFrameOption(selectName,strValue)
{
  //查不到代码返回
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
 * 查找在Document中的element的name属性等如传入值的element个数，没有则返回0
 * @param fieldName 元素名称
 * @return 在Document中的element的name属性等如传入值的element个数
 */
function getFrameElementCount(fieldName)
{
    var count = 0;
    count = parent.fraInterface.document.getElementsByName(fieldName).length;
    return count;
}
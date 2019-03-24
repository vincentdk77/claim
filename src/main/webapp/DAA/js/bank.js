/*这个这个呢 */

/* *
 * 全局空间 Vcity
 * */
var Vcity = {};
/* *
 * 静态方法集
 * @name _m
 * */
Vcity._m = {
    /* 选择元素 */
    $:function (arg, context) {
        var tagAll, n, eles = [], i, sub = arg.substring(1);
        context = context || document;
        if (typeof arg == 'string') {
            switch (arg.charAt(0)) {
                case '#':
                    return document.getElementById(sub);
                    break;
                case '.':
                    if (context.getElementsByClassName) return context.getElementsByClassName(sub);
                    tagAll = Vcity._m.$('*', context);
                    n = tagAll.length;
                    for (i = 0; i < n; i++) {
                        if (tagAll[i].className.indexOf(sub) > -1) eles.push(tagAll[i]);
                    }
                    return eles;
                    break;
                default:
                    return context.getElementsByTagName(arg);
                    break;
            }
        }
    },

    /* 绑定事件 */
    on:function (node, type, handler) {
        node.addEventListener ? node.addEventListener(type, handler, false) : node.attachEvent('on' + type, handler);
    },

    /* 获取事件 */
    getEvent:function(event){
        return event || window.event;
    },

    /* 获取事件目标 */
    getTarget:function(event){
        return event.target || event.srcElement;
    },

    /* 获取元素位置 */
    getPos:function (node) {
        var scrollx = document.documentElement.scrollLeft || document.body.scrollLeft,
                scrollt = document.documentElement.scrollTop || document.body.scrollTop;
        var pos = node.getBoundingClientRect();
        return {top:pos.top + scrollt, right:pos.right + scrollx, bottom:pos.bottom + scrollt, left:pos.left + scrollx }
    },

    /* 添加样式名 */
    addClass:function (c, node) {
        if(!node)return;
        node.className = Vcity._m.hasClass(c,node) ? node.className : node.className + ' ' + c ;
    },

    /* 移除样式名 */
    removeClass:function (c, node) {
        var reg = new RegExp("(^|\\s+)" + c + "(\\s+|$)", "g");
        if(!Vcity._m.hasClass(c,node))return;
        node.className = reg.test(node.className) ? node.className.replace(reg, '') : node.className;
    },

    /* 是否含有CLASS */
    hasClass:function (c, node) {
        if(!node || !node.className)return false;
        return node.className.indexOf(c)>-1;
    },

    /* 阻止冒泡 */
    stopPropagation:function (event) {
        event = event || window.event;
        event.stopPropagation ? event.stopPropagation() : event.cancelBubble = true;
    },
    /* 去除两端空格 */
    trim:function (str) {
        return str.replace(/^\s+|\s+$/g,'');
    }
};

/* 所有城市数据,可以按照格式自行添加（北京|beijing|bj），前6条为热门城市 */

Vcity.allCity = ['农业银行|nongye|ny','交通银行|jiaotong|jt', '建设银行|jianshe|js',  '光大银行|guangda|gd', '招商银行|zhaoshang|zs', '中信银行|zhongxin|zx',
    '工商银行|gongshang|gs', '浦发银行|pufa|pf', '民生银行|minsheng|ms', '广发银行|guangfa|gf','中国银行|zhonguo|zg', '国家开发银行|guojia|gj',
    '中国进出口银行|zhonguojinchukou|zgjck','中国农业发展银行|zhonguonongyefazhan|zg', '华夏银行|huaxia|hx','广东发展银行|guangdongfazhan|gd',
    '深圳发展银行|shenzhenfazhan|sz','兴业银行|xingye|xy','城市商业银行|chengshishangye|cs', '江苏农村商业银行|nongcunshangyeyinhang|nc',
    '恒丰银行|huifeng|hf', '浙商银行|zheshang|zs','农村合作银行|nongcunhezuo|nc', '渤海银行股份有限公司|bohai|bh', '徽商银行股份有限公司|huishang|hs', 
    '镇银行有限责任公司|zhenyinhang|zy','城市信用社|chengshixinyongshe|cs', '农村信用社含北京农村商业银行|nongcunxinyongshe|nc', 
    '中国邮政储蓄银行|zhongguoyongzheng|zg', '汇丰银行|huifeng|hf', '东亚银行|dongya|dy', '南洋商业银行|nanyang|ny', '恒生银行中国有限公司|hengsheng|fs', 
    '中国银行香港有限公司|zhongguoxianggang|zg', '集友银行有限公司|jiyou|jy', '创兴银行有限公司|chuangye|cy', '星展银行中国有限公司|xingchen|xc',
    '永亨银行中国有限公司|yongheng|yh', '永隆银行|yonglong|yl', '花旗银行中国有限公司|huaqi|hq', '美国银行有限公司|meiguo|mg','摩根大通银行中国有限公司|mogen|mg',
    '三菱东京日联银行中国有限公司|sanling|sl','日本三井住友银行股份有限公司|riben|rb','香港地区银行|xianggang|xg','瑞穗实业银行中国有限公司|ruihui|rh',
    '日本山口银行股份有限公司|riben|rb','韩国外换银行股份有限公司|hanguo|hg','友利银行中国有限公司|youli|yl','韩国产业银行|hanguo|hg',
    '新韩银行中国有限公司|xinhan|xh','韩国中小企业银行有限公司|hanguo|hg','韩亚银行中国有限公司|hanya|hy','华侨银行中国有限公司|huaqiao|hq',
    '大华银行中国有限公司|dahua|dh','星展银行中国有限公司|xingzhan|xz','泰国盘谷银行大众有限公司|taiguo|tg','奥地利中央合作银行股份有限公司|aodili|ad',
    '比利时联合银行股份有限公司|buli|bl','比利时富通银行有限公司|fubi|fb','荷兰银行|helan|hl','荷兰安智银行股份有限公司|helan|hl',
    '渣打银行|zhada|zd','英国苏格兰皇家银行公众有限公司|yinguo|yg','法国兴业银行中国有限公司|faguo|fg','法国东方汇理银行股份有限公司|faguo|fg',
    '法国外贸银行股份有限公司|faguo|fg','德国德累斯登银行股份公司|deguo|dg','德意志银行中国有限公司|deyi|dy','德国商业银行股份有限公司|deguo|dg',
    '德国西德银行股份有限公司|deguo|dg','德国巴伐利亚州银行|deguo|dg','德国北德意志州银行|deguo|dg','意大利联合圣保罗银行股份有限公司|yidali|yd',
    '瑞士信贷银行股份有限公司|ruishi|rs','瑞士银行|ruishi|rs','加拿大丰业银行有限公司|jiana|jn','加拿大蒙特利尔银行有限公司|jiana|jn',
    '澳大利亚和新西兰银行集团有限公司|aoda|ad','摩根士丹利国际银行中国有限公司|mogen|mg','联合银行中国有限公司|lianhe|lh','荷兰合作银行有限公司|helan|hl',
    '厦门国际银行|xiamen|xm','法国巴黎银行中国有限公司|faguo|fg','华商银行|huashang|hs','华一银行|huayi|hy','澳门地区银行|aomen|am','国家金库|guojia|gj','其他银行|qita|qt'];

/* 正则表达式 筛选中文城市名、拼音、首字母 */

Vcity.regEx = /^([\u4E00-\u9FA5\uf900-\ufa2d]+)\|(\w+)\|(\w)\w*$/i;
Vcity.regExChiese = /([\u4E00-\u9FA5\uf900-\ufa2d]+)/;

/* *
 * 格式化城市数组为对象oCity，按照a-h,i-p,q-z,hot热门城市分组：
 * {HOT:{hot:[]},ABCDEFGH:{a:[1,2,3],b:[1,2,3]},IJKLMNOP:{i:[1.2.3],j:[1,2,3]},QRSTUVWXYZ:{}}
 * */

(function () {
    var citys = Vcity.allCity, match, letter,
            regEx = Vcity.regEx,
            reg2 = /^[a-h]$/i, reg3 = /^[i-p]$/i, reg4 = /^[q-z]$/i;
    if (!Vcity.oCity) {
        Vcity.oCity = {hot:{},ABCDEFGH:{}, IJKLMNOP:{}, QRSTUVWXYZ:{}};
        //console.log(citys.length);
        for (var i = 0, n = citys.length; i < n; i++) {
            match = regEx.exec(citys[i]);
            letter = match[3].toUpperCase();
            if (reg2.test(letter)) {
                if (!Vcity.oCity.ABCDEFGH[letter]) Vcity.oCity.ABCDEFGH[letter] = [];
                Vcity.oCity.ABCDEFGH[letter].push(match[1]);
            } else if (reg3.test(letter)) {
                if (!Vcity.oCity.IJKLMNOP[letter]) Vcity.oCity.IJKLMNOP[letter] = [];
                Vcity.oCity.IJKLMNOP[letter].push(match[1]);
            } else if (reg4.test(letter)) {
                if (!Vcity.oCity.QRSTUVWXYZ[letter]) Vcity.oCity.QRSTUVWXYZ[letter] = [];
                Vcity.oCity.QRSTUVWXYZ[letter].push(match[1]);
            }
            /* 热门城市 前16条 */
            if(i<10){
                if(!Vcity.oCity.hot['hot']) Vcity.oCity.hot['hot'] = [];
                Vcity.oCity.hot['hot'].push(match[1]);
            }
        }
    }
})();
/* 城市HTML模板 */
Vcity._template = [
    '<p class="tip">根据银行名首字母顺寻查找</p>',
    '<ul>',
    '<li class="on">热门银行</li>',
    '<li>ABCDEFGH</li>',
    '<li>IJKLMNOP</li>',
    '<li>QRSTUVWXYZ</li>',
    '</ul>'
];

/* *
 * 城市控件构造函数
 * @CitySelector
 * */

Vcity.CitySelector = function () {
    this.initialize.apply(this, arguments);
};

Vcity.CitySelector.prototype = {

    constructor:Vcity.CitySelector,

    /* 初始化 */

    initialize :function (options) {
        var input = options.input;
        this.input = Vcity._m.$('#'+ input);
        this.inputEvent();
    },

    /* *
     * @createWarp
     * 创建城市BOX HTML 框架
     * */

    createWarp:function(){
        var inputPos = Vcity._m.getPos(this.input);
        var div = this.rootDiv = document.createElement('div');
        var that = this;

        // 设置DIV阻止冒泡
        Vcity._m.on(this.rootDiv,'click',function(event){
            Vcity._m.stopPropagation(event);
        });

        // 设置点击文档隐藏弹出的城市选择框
        Vcity._m.on(document, 'click', function (event) {
            event = Vcity._m.getEvent(event);
            var target = Vcity._m.getTarget(event);
            if(target == that.input) return false;
            //console.log(target.className);
            if (that.cityBox)Vcity._m.addClass('hide', that.cityBox);
            if (that.ul)Vcity._m.addClass('hide', that.ul);
            if(that.myIframe)Vcity._m.addClass('hide',that.myIframe);
        });
        div.className = 'citySelector';
        div.style.position = 'absolute';
        div.style.left = inputPos.left + 'px';
        div.style.top = inputPos.bottom + 'px';
        div.style.zIndex = 999999;

        // 判断是否IE6，如果是IE6需要添加iframe才能遮住SELECT框
        var isIe = (document.all) ? true : false;
        var isIE6 = this.isIE6 = isIe && !window.XMLHttpRequest;
        if(isIE6){
            var myIframe = this.myIframe =  document.createElement('iframe');
            myIframe.frameborder = '0';
            myIframe.src = 'about:blank';
            myIframe.style.position = 'absolute';
            myIframe.style.zIndex = '-1';
            this.rootDiv.appendChild(this.myIframe);
        }

        var childdiv = this.cityBox = document.createElement('div');
        childdiv.className = 'cityBox';
        childdiv.id = 'cityBox';
        childdiv.innerHTML = Vcity._template.join('');
        var hotCity = this.hotCity =  document.createElement('div');
        hotCity.className = 'hotCity';
        childdiv.appendChild(hotCity);
        div.appendChild(childdiv);
        this.createHotCity();
    },

    /* *
     * @createHotCity
     * TAB下面DIV：hot,a-h,i-p,q-z 分类HTML生成，DOM操作
     * {HOT:{hot:[]},ABCDEFGH:{a:[1,2,3],b:[1,2,3]},IJKLMNOP:{},QRSTUVWXYZ:{}}
     **/

    createHotCity:function(){
        var odiv,odl,odt,odd,odda=[],str,key,ckey,sortKey,regEx = Vcity.regEx,
                oCity = Vcity.oCity;
        for(key in oCity){
            odiv = this[key] = document.createElement('div');
            // 先设置全部隐藏hide
            odiv.className = key + ' ' + 'cityTab hide';
            sortKey=[];
            for(ckey in oCity[key]){
                sortKey.push(ckey);
                // ckey按照ABCDEDG顺序排序
                sortKey.sort();
            }
            for(var j=0,k = sortKey.length;j<k;j++){
                odl = document.createElement('dl');
                odt = document.createElement('dt');
                odd = document.createElement('dd');
                odt.innerHTML = sortKey[j] == 'hot'?'&nbsp;':sortKey[j];
                odda = [];
                for(var i=0,n=oCity[key][sortKey[j]].length;i<n;i++){
                    str = '<a href="#">' + oCity[key][sortKey[j]][i] + '</a>';
                    odda.push(str);
                }
                odd.innerHTML = odda.join('');
                odl.appendChild(odt);
                odl.appendChild(odd);
                odiv.appendChild(odl);
            }

            // 移除热门城市的隐藏CSS
            Vcity._m.removeClass('hide',this.hot);
            this.hotCity.appendChild(odiv);
        }
        document.body.appendChild(this.rootDiv);
        /* IE6 */
        this.changeIframe();

        this.tabChange();
        this.linkEvent();
    },

    /* *
     *  tab按字母顺序切换
     *  @ tabChange
     * */

    tabChange:function(){
        var lis = Vcity._m.$('li',this.cityBox);
        var divs = Vcity._m.$('div',this.hotCity);
        var that = this;
        for(var i=0,n=lis.length;i<n;i++){
            lis[i].index = i;
            lis[i].onclick = function(){
                for(var j=0;j<n;j++){
                    Vcity._m.removeClass('on',lis[j]);
                    Vcity._m.addClass('hide',divs[j]);
                }
                Vcity._m.addClass('on',this);
                Vcity._m.removeClass('hide',divs[this.index]);
                /* IE6 改变TAB的时候 改变Iframe 大小*/
                that.changeIframe();
            };
        }
    },

    /* *
     * 城市LINK事件
     *  @linkEvent
     * */

    linkEvent:function(){
        var links = Vcity._m.$('a',this.hotCity);
        var that = this;
        for(var i=0,n=links.length;i<n;i++){
            links[i].onclick = function(){
                that.input.value = this.innerHTML;
                Vcity._m.addClass('hide',that.cityBox);
                /* 点击城市名的时候隐藏myIframe */
                Vcity._m.addClass('hide',that.myIframe);
            }
        }
    },

    /* *
     * INPUT城市输入框事件
     * @inputEvent
     * */

    inputEvent:function(){
        var that = this;
        Vcity._m.on(this.input,'click',function(event){
            event = event || window.event;
            if(!that.cityBox){
                that.createWarp();
            }else if(!!that.cityBox && Vcity._m.hasClass('hide',that.cityBox)){
                // slideul 不存在或者 slideul存在但是是隐藏的时候 两者不能共存
                if(!that.ul || (that.ul && Vcity._m.hasClass('hide',that.ul))){
                    Vcity._m.removeClass('hide',that.cityBox);

                    /* IE6 移除iframe 的hide 样式 */
                    //alert('click');
                    Vcity._m.removeClass('hide',that.myIframe);
                    that.changeIframe();
                }
            }
        });
        Vcity._m.on(this.input,'focus',function(){
            that.input.select();
            if(that.input.value == '') that.input.value = '';
        });
        Vcity._m.on(this.input,'blur',function(){
            if(that.input.value == '') that.input.value = '';
        });
        Vcity._m.on(this.input,'keyup',function(event){
            event = event || window.event;
            var keycode = event.keyCode;
            Vcity._m.addClass('hide',that.cityBox);
            that.createUl();

            /* 移除iframe 的hide 样式 */
            Vcity._m.removeClass('hide',that.myIframe);

            // 下拉菜单显示的时候捕捉按键事件
            if(that.ul && !Vcity._m.hasClass('hide',that.ul) && !that.isEmpty){
                that.KeyboardEvent(event,keycode);
            }
        });
    },
    /* IE6的改变遮罩SELECT 的 IFRAME尺寸大小 */
    changeIframe:function(){
        if(!this.isIE6)return;
        this.myIframe.style.width = this.rootDiv.offsetWidth + 'px';
        this.myIframe.style.height = this.rootDiv.offsetHeight + 'px';
    },

    /* *
     * 特定键盘事件，上、下、Enter键
     * @ KeyboardEvent
     * */

    KeyboardEvent:function(event,keycode){
        var lis = Vcity._m.$('li',this.ul);
        var len = lis.length;
        switch(keycode){
            case 40: //向下箭头↓
                this.count++;
                if(this.count > len-1) this.count = 0;
                for(var i=0;i<len;i++){
                    Vcity._m.removeClass('on',lis[i]);
                }
                Vcity._m.addClass('on',lis[this.count]);
                break;
            case 38: //向上箭头↑
                this.count--;
                if(this.count<0) this.count = len-1;
                for(i=0;i<len;i++){
                    Vcity._m.removeClass('on',lis[i]);
                }
                Vcity._m.addClass('on',lis[this.count]);
                break;
            case 13: // enter键
                this.input.value = Vcity.regExChiese.exec(lis[this.count].innerHTML)[0];
                Vcity._m.addClass('hide',this.ul);
                Vcity._m.addClass('hide',this.ul);
                /* IE6 */
                Vcity._m.addClass('hide',this.myIframe);
                break;
            default:
                break;
        }
    },

    /* *
     * 下拉列表的li事件
     * @ liEvent
     * */

    liEvent:function(){
        var that = this;
        var lis = Vcity._m.$('li',this.ul);
        for(var i = 0,n = lis.length;i < n;i++){
            Vcity._m.on(lis[i],'click',function(event){
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);
                that.input.value = Vcity.regExChiese.exec(target.innerHTML)[0];
                Vcity._m.addClass('hide',that.ul);
                /* IE6 下拉菜单点击事件 */
                Vcity._m.addClass('hide',that.myIframe);
            });
            Vcity._m.on(lis[i],'mouseover',function(event){
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);
                Vcity._m.addClass('on',target);
            });
            Vcity._m.on(lis[i],'mouseout',function(event){
                event = Vcity._m.getEvent(event);
                var target = Vcity._m.getTarget(event);
                Vcity._m.removeClass('on',target);
            })
        }
    }
};
    var test=new Vcity.CitySelector({input:'citySelect'});
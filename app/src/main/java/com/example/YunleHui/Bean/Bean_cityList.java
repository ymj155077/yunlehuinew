package com.example.YunleHui.Bean;

import com.example.YunleHui.view.cityList.BaseIndexPinyinBean;

import java.util.List;

/**
 * Created by admin on 2019/8/24 0024.
 */

public class Bean_cityList {


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : [{"id":500000,"cityName":"重庆市","remark":"重庆市"},{"id":510100,"cityName":"成都市","remark":"四川省"},{"id":110100,"cityName":"北京市","remark":"北京市"},{"id":120100,"cityName":"天津市","remark":"天津市"},{"id":310100,"cityName":"上海市","remark":"上海市"},{"id":440100,"cityName":"广州市","remark":"广东省"},{"id":440300,"cityName":"深圳市","remark":"广东省"},{"id":513200,"cityName":"阿坝藏族羌族自治州","remark":"四川省"},{"id":652900,"cityName":"阿克苏地区","remark":"新疆维吾尔自治区"},{"id":152900,"cityName":"阿拉善盟","remark":"内蒙古自治区"},{"id":654300,"cityName":"阿勒泰地区","remark":"新疆维吾尔自治区"},{"id":542500,"cityName":"阿里地区","remark":"西藏自治区"},{"id":610900,"cityName":"安康市","remark":"陕西省"},{"id":340800,"cityName":"安庆市","remark":"安徽省"},{"id":520400,"cityName":"安顺市","remark":"贵州省"},{"id":410500,"cityName":"安阳市","remark":"河南省"},{"id":210300,"cityName":"鞍山市","remark":"辽宁省"},{"id":150800,"cityName":"巴彦淖尔市","remark":"内蒙古自治区"},{"id":652800,"cityName":"巴音郭楞蒙古自治州","remark":"新疆维吾尔自治区"},{"id":511900,"cityName":"巴中市","remark":"四川省"},{"id":220800,"cityName":"白城市","remark":"吉林省"},{"id":220600,"cityName":"白山市","remark":"吉林省"},{"id":620400,"cityName":"白银市","remark":"甘肃省"},{"id":451000,"cityName":"百色市","remark":"广西壮族自治区"},{"id":340300,"cityName":"蚌埠市","remark":"安徽省"},{"id":150200,"cityName":"包头市","remark":"内蒙古自治区"},{"id":610300,"cityName":"宝鸡市","remark":"陕西省"},{"id":130600,"cityName":"保定市","remark":"河北省"},{"id":530500,"cityName":"保山市","remark":"云南省"},{"id":450500,"cityName":"北海市","remark":"广西壮族自治区"},{"id":210500,"cityName":"本溪市","remark":"辽宁省"},{"id":520500,"cityName":"毕节市","remark":"贵州省"},{"id":371600,"cityName":"滨州市","remark":"山东省"},{"id":341600,"cityName":"亳州市","remark":"安徽省"},{"id":652700,"cityName":"博尔塔拉蒙古自治州","remark":"新疆维吾尔自治区"},{"id":130900,"cityName":"沧州市","remark":"河北省"},{"id":540300,"cityName":"昌都市","remark":"西藏自治区"},{"id":652300,"cityName":"昌吉回族自治州","remark":"新疆维吾尔自治区"},{"id":220100,"cityName":"长春市","remark":"吉林省"},{"id":430100,"cityName":"长沙市","remark":"湖南省"},{"id":140400,"cityName":"长治市","remark":"山西省"},{"id":430700,"cityName":"常德市","remark":"湖南省"},{"id":320400,"cityName":"常州市","remark":"江苏省"},{"id":211300,"cityName":"朝阳市","remark":"辽宁省"},{"id":445100,"cityName":"潮州市","remark":"广东省"},{"id":431000,"cityName":"郴州市","remark":"湖南省"},{"id":130800,"cityName":"承德市","remark":"河北省"},{"id":341700,"cityName":"池州市","remark":"安徽省"},{"id":150400,"cityName":"赤峰市","remark":"内蒙古自治区"},{"id":451400,"cityName":"崇左市","remark":"广西壮族自治区"},{"id":341100,"cityName":"滁州市","remark":"安徽省"},{"id":532300,"cityName":"楚雄彝族自治州","remark":"云南省"},{"id":511700,"cityName":"达州市","remark":"四川省"},{"id":532900,"cityName":"大理白族自治州","remark":"云南省"},{"id":210200,"cityName":"大连市","remark":"辽宁省"},{"id":230600,"cityName":"大庆市","remark":"黑龙江省"},{"id":140200,"cityName":"大同市","remark":"山西省"},{"id":232700,"cityName":"大兴安岭地区","remark":"黑龙江省"},{"id":210600,"cityName":"丹东市","remark":"辽宁省"},{"id":460400,"cityName":"儋州市","remark":"海南省"},{"id":533100,"cityName":"德宏傣族景颇族自治州","remark":"云南省"},{"id":510600,"cityName":"德阳市","remark":"四川省"},{"id":371400,"cityName":"德州市","remark":"山东省"},{"id":533400,"cityName":"迪庆藏族自治州","remark":"云南省"},{"id":621100,"cityName":"定西市","remark":"甘肃省"},{"id":441900,"cityName":"东莞市","remark":"广东省"},{"id":370500,"cityName":"东营市","remark":"山东省"},{"id":150600,"cityName":"鄂尔多斯市","remark":"内蒙古自治区"},{"id":420700,"cityName":"鄂州市","remark":"湖北省"},{"id":422800,"cityName":"恩施土家族苗族自治州","remark":"湖北省"},{"id":450600,"cityName":"防城港市","remark":"广西壮族自治区"},{"id":440600,"cityName":"佛山市","remark":"广东省"},{"id":350100,"cityName":"福州市","remark":"福建省"},{"id":210400,"cityName":"抚顺市","remark":"辽宁省"},{"id":361000,"cityName":"抚州市","remark":"江西省"},{"id":210900,"cityName":"阜新市","remark":"辽宁省"},{"id":341200,"cityName":"阜阳市","remark":"安徽省"},{"id":623000,"cityName":"甘南藏族自治州","remark":"甘肃省"},{"id":513300,"cityName":"甘孜藏族自治州","remark":"四川省"},{"id":360700,"cityName":"赣州市","remark":"江西省"},{"id":640400,"cityName":"固原市","remark":"宁夏回族自治区"},{"id":511600,"cityName":"广安市","remark":"四川省"},{"id":510800,"cityName":"广元市","remark":"四川省"},{"id":450800,"cityName":"贵港市","remark":"广西壮族自治区"},{"id":520100,"cityName":"贵阳市","remark":"贵州省"},{"id":450300,"cityName":"桂林市","remark":"广西壮族自治区"},{"id":632600,"cityName":"果洛藏族自治州","remark":"青海省"},{"id":230100,"cityName":"哈尔滨市","remark":"黑龙江省"},{"id":650500,"cityName":"哈密市","remark":"新疆维吾尔自治区"},{"id":632200,"cityName":"海北藏族自治州","remark":"青海省"},{"id":630200,"cityName":"海东市","remark":"青海省"},{"id":460100,"cityName":"海口市","remark":"海南省"},{"id":632500,"cityName":"海南藏族自治州","remark":"青海省"},{"id":632800,"cityName":"海西蒙古族藏族自治州","remark":"青海省"},{"id":130400,"cityName":"邯郸市","remark":"河北省"},{"id":610700,"cityName":"汉中市","remark":"陕西省"},{"id":330100,"cityName":"杭州市","remark":"浙江省"},{"id":340100,"cityName":"合肥市","remark":"安徽省"},{"id":653200,"cityName":"和田地区","remark":"新疆维吾尔自治区"},{"id":451200,"cityName":"河池市","remark":"广西壮族自治区"},{"id":441600,"cityName":"河源市","remark":"广东省"},{"id":371700,"cityName":"菏泽市","remark":"山东省"},{"id":451100,"cityName":"贺州市","remark":"广西壮族自治区"},{"id":410600,"cityName":"鹤壁市","remark":"河南省"},{"id":230400,"cityName":"鹤岗市","remark":"黑龙江省"},{"id":231100,"cityName":"黑河市","remark":"黑龙江省"},{"id":131100,"cityName":"衡水市","remark":"河北省"},{"id":430400,"cityName":"衡阳市","remark":"湖南省"},{"id":532500,"cityName":"红河哈尼族彝族自治州","remark":"云南省"},{"id":150100,"cityName":"呼和浩特市","remark":"内蒙古自治区"},{"id":150700,"cityName":"呼伦贝尔市","remark":"内蒙古自治区"},{"id":330500,"cityName":"湖州市","remark":"浙江省"},{"id":211400,"cityName":"葫芦岛市","remark":"辽宁省"},{"id":431200,"cityName":"怀化市","remark":"湖南省"},{"id":320800,"cityName":"淮安市","remark":"江苏省"},{"id":340600,"cityName":"淮北市","remark":"安徽省"},{"id":340400,"cityName":"淮南市","remark":"安徽省"},{"id":421100,"cityName":"黄冈市","remark":"湖北省"},{"id":632300,"cityName":"黄南藏族自治州","remark":"青海省"},{"id":341000,"cityName":"黄山市","remark":"安徽省"},{"id":420200,"cityName":"黄石市","remark":"湖北省"},{"id":441300,"cityName":"惠州市","remark":"广东省"},{"id":230300,"cityName":"鸡西市","remark":"黑龙江省"},{"id":360800,"cityName":"吉安市","remark":"江西省"},{"id":220200,"cityName":"吉林市","remark":"吉林省"},{"id":370100,"cityName":"济南市","remark":"山东省"},{"id":370800,"cityName":"济宁市","remark":"山东省"},{"id":230800,"cityName":"佳木斯市","remark":"黑龙江省"},{"id":330400,"cityName":"嘉兴市","remark":"浙江省"},{"id":620200,"cityName":"嘉峪关市","remark":"甘肃省"},{"id":440700,"cityName":"江门市","remark":"广东省"},{"id":410800,"cityName":"焦作市","remark":"河南省"},{"id":445200,"cityName":"揭阳市","remark":"广东省"},{"id":620300,"cityName":"金昌市","remark":"甘肃省"},{"id":330700,"cityName":"金华市","remark":"浙江省"},{"id":210700,"cityName":"锦州市","remark":"辽宁省"},{"id":140500,"cityName":"晋城市","remark":"山西省"},{"id":140700,"cityName":"晋中市","remark":"山西省"},{"id":420800,"cityName":"荆门市","remark":"湖北省"},{"id":421000,"cityName":"荆州市","remark":"湖北省"},{"id":360200,"cityName":"景德镇市","remark":"江西省"},{"id":360400,"cityName":"九江市","remark":"江西省"},{"id":620900,"cityName":"酒泉市","remark":"甘肃省"},{"id":653100,"cityName":"喀什地区","remark":"新疆维吾尔自治区"},{"id":410200,"cityName":"开封市","remark":"河南省"},{"id":650200,"cityName":"克拉玛依市","remark":"新疆维吾尔自治区"},{"id":653000,"cityName":"克孜勒苏柯尔克孜自治州","remark":"新疆维吾尔自治区"},{"id":530100,"cityName":"昆明市","remark":"云南省"},{"id":540100,"cityName":"拉萨市","remark":"西藏自治区"},{"id":451300,"cityName":"来宾市","remark":"广西壮族自治区"},{"id":371200,"cityName":"莱芜市","remark":"山东省"},{"id":620100,"cityName":"兰州市","remark":"甘肃省"},{"id":131000,"cityName":"廊坊市","remark":"河北省"},{"id":511100,"cityName":"乐山市","remark":"四川省"},{"id":530700,"cityName":"丽江市","remark":"云南省"},{"id":331100,"cityName":"丽水市","remark":"浙江省"},{"id":320700,"cityName":"连云港市","remark":"江苏省"},{"id":513400,"cityName":"凉山彝族自治州","remark":"四川省"},{"id":211000,"cityName":"辽阳市","remark":"辽宁省"},{"id":220400,"cityName":"辽源市","remark":"吉林省"},{"id":371500,"cityName":"聊城市","remark":"山东省"},{"id":540400,"cityName":"林芝市","remark":"西藏自治区"},{"id":530900,"cityName":"临沧市","remark":"云南省"},{"id":141000,"cityName":"临汾市","remark":"山西省"},{"id":622900,"cityName":"临夏回族自治州","remark":"甘肃省"},{"id":371300,"cityName":"临沂市","remark":"山东省"},{"id":450200,"cityName":"柳州市","remark":"广西壮族自治区"},{"id":341500,"cityName":"六安市","remark":"安徽省"},{"id":520200,"cityName":"六盘水市","remark":"贵州省"},{"id":350800,"cityName":"龙岩市","remark":"福建省"},{"id":621200,"cityName":"陇南市","remark":"甘肃省"},{"id":431300,"cityName":"娄底市","remark":"湖南省"},{"id":510500,"cityName":"泸州市","remark":"四川省"},{"id":141100,"cityName":"吕梁市","remark":"山西省"},{"id":410300,"cityName":"洛阳市","remark":"河南省"},{"id":411100,"cityName":"漯河市","remark":"河南省"},{"id":340500,"cityName":"马鞍山市","remark":"安徽省"},{"id":440900,"cityName":"茂名市","remark":"广东省"},{"id":511400,"cityName":"眉山市","remark":"四川省"},{"id":441400,"cityName":"梅州市","remark":"广东省"},{"id":510700,"cityName":"绵阳市","remark":"四川省"},{"id":231000,"cityName":"牡丹江市","remark":"黑龙江省"},{"id":511000,"cityName":"内江市","remark":"四川省"},{"id":542400,"cityName":"那曲地区","remark":"西藏自治区"},{"id":360100,"cityName":"南昌市","remark":"江西省"},{"id":511300,"cityName":"南充市","remark":"四川省"},{"id":320100,"cityName":"南京市","remark":"江苏省"},{"id":450100,"cityName":"南宁市","remark":"广西壮族自治区"},{"id":350700,"cityName":"南平市","remark":"福建省"},{"id":320600,"cityName":"南通市","remark":"江苏省"},{"id":411300,"cityName":"南阳市","remark":"河南省"},{"id":330200,"cityName":"宁波市","remark":"浙江省"},{"id":350900,"cityName":"宁德市","remark":"福建省"},{"id":533300,"cityName":"怒江傈僳族自治州","remark":"云南省"},{"id":510400,"cityName":"攀枝花市","remark":"四川省"},{"id":211100,"cityName":"盘锦市","remark":"辽宁省"},{"id":410400,"cityName":"平顶山市","remark":"河南省"},{"id":620800,"cityName":"平凉市","remark":"甘肃省"},{"id":360300,"cityName":"萍乡市","remark":"江西省"},{"id":350300,"cityName":"莆田市","remark":"福建省"},{"id":410900,"cityName":"濮阳市","remark":"河南省"},{"id":530800,"cityName":"普洱市","remark":"云南省"},{"id":230900,"cityName":"七台河市","remark":"黑龙江省"},{"id":230200,"cityName":"齐齐哈尔市","remark":"黑龙江省"},{"id":522600,"cityName":"黔东南苗族侗族自治州","remark":"贵州省"},{"id":522700,"cityName":"黔南布依族苗族自治州","remark":"贵州省"},{"id":522300,"cityName":"黔西南布依族苗族自治州","remark":"贵州省"},{"id":450700,"cityName":"钦州市","remark":"广西壮族自治区"},{"id":130300,"cityName":"秦皇岛市","remark":"河北省"},{"id":370200,"cityName":"青岛市","remark":"山东省"},{"id":441800,"cityName":"清远市","remark":"广东省"},{"id":621000,"cityName":"庆阳市","remark":"甘肃省"},{"id":530300,"cityName":"曲靖市","remark":"云南省"},{"id":330800,"cityName":"衢州市","remark":"浙江省"},{"id":350500,"cityName":"泉州市","remark":"福建省"},{"id":540200,"cityName":"日喀则市","remark":"西藏自治区"},{"id":371100,"cityName":"日照市","remark":"山东省"},{"id":411200,"cityName":"三门峡市","remark":"河南省"},{"id":350400,"cityName":"三明市","remark":"福建省"},{"id":460300,"cityName":"三沙市","remark":"海南省"},{"id":460200,"cityName":"三亚市","remark":"海南省"},{"id":540500,"cityName":"山南市","remark":"西藏自治区"},{"id":440500,"cityName":"汕头市","remark":"广东省"},{"id":441500,"cityName":"汕尾市","remark":"广东省"},{"id":611000,"cityName":"商洛市","remark":"陕西省"},{"id":411400,"cityName":"商丘市","remark":"河南省"},{"id":361100,"cityName":"上饶市","remark":"江西省"},{"id":440200,"cityName":"韶关市","remark":"广东省"},{"id":430500,"cityName":"邵阳市","remark":"湖南省"},{"id":330600,"cityName":"绍兴市","remark":"浙江省"},{"id":210100,"cityName":"沈阳市","remark":"辽宁省"},{"id":139000,"cityName":"省直辖县级行政区划","remark":"河北省"},{"id":419000,"cityName":"省直辖县级行政区划","remark":"河南省"},{"id":429000,"cityName":"省直辖县级行政区划","remark":"湖北省"},{"id":469000,"cityName":"省直辖县级行政区划","remark":"海南省"},{"id":420300,"cityName":"十堰市","remark":"湖北省"},{"id":130100,"cityName":"石家庄市","remark":"河北省"},{"id":640200,"cityName":"石嘴山市","remark":"宁夏回族自治区"},{"id":230500,"cityName":"双鸭山市","remark":"黑龙江省"},{"id":140600,"cityName":"朔州市","remark":"山西省"},{"id":220300,"cityName":"四平市","remark":"吉林省"},{"id":220700,"cityName":"松原市","remark":"吉林省"},{"id":320500,"cityName":"苏州市","remark":"江苏省"},{"id":321300,"cityName":"宿迁市","remark":"江苏省"},{"id":341300,"cityName":"宿州市","remark":"安徽省"},{"id":231200,"cityName":"绥化市","remark":"黑龙江省"},{"id":421300,"cityName":"随州市","remark":"湖北省"},{"id":510900,"cityName":"遂宁市","remark":"四川省"},{"id":654200,"cityName":"塔城地区","remark":"新疆维吾尔自治区"},{"id":331000,"cityName":"台州市","remark":"浙江省"},{"id":140100,"cityName":"太原市","remark":"山西省"},{"id":370900,"cityName":"泰安市","remark":"山东省"},{"id":321200,"cityName":"泰州市","remark":"江苏省"},{"id":130200,"cityName":"唐山市","remark":"河北省"},{"id":620500,"cityName":"天水市","remark":"甘肃省"},{"id":211200,"cityName":"铁岭市","remark":"辽宁省"},{"id":220500,"cityName":"通化市","remark":"吉林省"},{"id":150500,"cityName":"通辽市","remark":"内蒙古自治区"},{"id":610200,"cityName":"铜川市","remark":"陕西省"},{"id":340700,"cityName":"铜陵市","remark":"安徽省"},{"id":520600,"cityName":"铜仁市","remark":"贵州省"},{"id":650400,"cityName":"吐鲁番市","remark":"新疆维吾尔自治区"},{"id":371000,"cityName":"威海市","remark":"山东省"},{"id":370700,"cityName":"潍坊市","remark":"山东省"},{"id":610500,"cityName":"渭南市","remark":"陕西省"},{"id":330300,"cityName":"温州市","remark":"浙江省"},{"id":532600,"cityName":"文山壮族苗族自治州","remark":"云南省"},{"id":150300,"cityName":"乌海市","remark":"内蒙古自治区"},{"id":150900,"cityName":"乌兰察布市","remark":"内蒙古自治区"},{"id":650100,"cityName":"乌鲁木齐市","remark":"新疆维吾尔自治区"},{"id":320200,"cityName":"无锡市","remark":"江苏省"},{"id":640300,"cityName":"吴忠市","remark":"宁夏回族自治区"},{"id":340200,"cityName":"芜湖市","remark":"安徽省"},{"id":450400,"cityName":"梧州市","remark":"广西壮族自治区"},{"id":420100,"cityName":"武汉市","remark":"湖北省"},{"id":620600,"cityName":"武威市","remark":"甘肃省"},{"id":610100,"cityName":"西安市","remark":"陕西省"},{"id":630100,"cityName":"西宁市","remark":"青海省"},{"id":532800,"cityName":"西双版纳傣族自治州","remark":"云南省"},{"id":152500,"cityName":"锡林郭勒盟","remark":"内蒙古自治区"},{"id":350200,"cityName":"厦门市","remark":"福建省"},{"id":421200,"cityName":"咸宁市","remark":"湖北省"},{"id":610400,"cityName":"咸阳市","remark":"陕西省"},{"id":500000,"cityName":"重庆市","remark":"重庆市"},{"id":430300,"cityName":"湘潭市","remark":"湖南省"},{"id":433100,"cityName":"湘西土家族苗族自治州","remark":"湖南省"},{"id":420600,"cityName":"襄阳市","remark":"湖北省"},{"id":420900,"cityName":"孝感市","remark":"湖北省"},{"id":140900,"cityName":"忻州市","remark":"山西省"},{"id":410700,"cityName":"新乡市","remark":"河南省"},{"id":360500,"cityName":"新余市","remark":"江西省"},{"id":411500,"cityName":"信阳市","remark":"河南省"},{"id":152200,"cityName":"兴安盟","remark":"内蒙古自治区"},{"id":130500,"cityName":"邢台市","remark":"河北省"},{"id":320300,"cityName":"徐州市","remark":"江苏省"},{"id":411000,"cityName":"许昌市","remark":"河南省"},{"id":341800,"cityName":"宣城市","remark":"安徽省"},{"id":511800,"cityName":"雅安市","remark":"四川省"},{"id":370600,"cityName":"烟台市","remark":"山东省"},{"id":610600,"cityName":"延安市","remark":"陕西省"},{"id":222400,"cityName":"延边朝鲜族自治州","remark":"吉林省"},{"id":320900,"cityName":"盐城市","remark":"江苏省"},{"id":321000,"cityName":"扬州市","remark":"江苏省"},{"id":441700,"cityName":"阳江市","remark":"广东省"},{"id":140300,"cityName":"阳泉市","remark":"山西省"},{"id":230700,"cityName":"伊春市","remark":"黑龙江省"},{"id":654000,"cityName":"伊犁哈萨克自治州","remark":"新疆维吾尔自治区"},{"id":511500,"cityName":"宜宾市","remark":"四川省"},{"id":420500,"cityName":"宜昌市","remark":"湖北省"},{"id":360900,"cityName":"宜春市","remark":"江西省"},{"id":430900,"cityName":"益阳市","remark":"湖南省"},{"id":640100,"cityName":"银川市","remark":"宁夏回族自治区"},{"id":360600,"cityName":"鹰潭市","remark":"江西省"},{"id":210800,"cityName":"营口市","remark":"辽宁省"},{"id":431100,"cityName":"永州市","remark":"湖南省"},{"id":610800,"cityName":"榆林市","remark":"陕西省"},{"id":450900,"cityName":"玉林市","remark":"广西壮族自治区"},{"id":632700,"cityName":"玉树藏族自治州","remark":"青海省"},{"id":530400,"cityName":"玉溪市","remark":"云南省"},{"id":430600,"cityName":"岳阳市","remark":"湖南省"},{"id":445300,"cityName":"云浮市","remark":"广东省"},{"id":140800,"cityName":"运城市","remark":"山西省"},{"id":370400,"cityName":"枣庄市","remark":"山东省"},{"id":440800,"cityName":"湛江市","remark":"广东省"},{"id":430800,"cityName":"张家界市","remark":"湖南省"},{"id":130700,"cityName":"张家口市","remark":"河北省"},{"id":620700,"cityName":"张掖市","remark":"甘肃省"},{"id":350600,"cityName":"漳州市","remark":"福建省"},{"id":530600,"cityName":"昭通市","remark":"云南省"},{"id":441200,"cityName":"肇庆市","remark":"广东省"},{"id":321100,"cityName":"镇江市","remark":"江苏省"},{"id":410100,"cityName":"郑州市","remark":"河南省"},{"id":442000,"cityName":"中山市","remark":"广东省"},{"id":640500,"cityName":"中卫市","remark":"宁夏回族自治区"},{"id":330900,"cityName":"舟山市","remark":"浙江省"},{"id":411600,"cityName":"周口市","remark":"河南省"},{"id":430200,"cityName":"株洲市","remark":"湖南省"},{"id":440400,"cityName":"珠海市","remark":"广东省"},{"id":411700,"cityName":"驻马店市","remark":"河南省"},{"id":512000,"cityName":"资阳市","remark":"四川省"},{"id":370300,"cityName":"淄博市","remark":"山东省"},{"id":510300,"cityName":"自贡市","remark":"四川省"},{"id":659000,"cityName":"自治区直辖县级行政区划","remark":"新疆维吾尔自治区"},{"id":520300,"cityName":"遵义市","remark":"贵州省"}]
     */

    private boolean success;
    private int code;
    private String msg;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean extends BaseIndexPinyinBean {
        /**
         * id : 500000
         * cityName : 重庆市
         * remark : 重庆市
         */

        public DataBean(){}


        public DataBean(int id, String cityName,String remark){

            this.id = id;
            this.cityName = cityName;
            this.remark = remark;

        }



        private int id;
        private String cityName;
        private String remark;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        @Override
        public String getTarget() {
            return cityName;
        }
    }
}

package com.example.YunleHui.Bean;

import java.io.Serializable;
import java.util.List;

public class Bean_nmn implements Serializable{


    /**
     * success : true
     * code : 200
     * msg : 成功
     * data : {"cartInfoCollection":{"totalCount":1,"entityList":[{"id":1750,"customerId":2,"shopId":1,"goodsId":894,"buyNum":1,"addTime":1568887580000,"updateTime":1568887580000,"goodsName":"广式香肠500g±20g","price":1880,"totalPrice":1880,"resultPrice":0,"specifications":"件","logoUrl":"https://file.aicenyi.com/iconf3b20d8d-b328-4db8-a739-c1fea3a458871549005366028.jpg"}]},"shopInfo":{"id":1,"shopName":"两路口核销店","shopTel":"18122222222","shopAddress":"两路口地铁站附近","cityId":500000,"districtId":0,"shopLogoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","longitude":106.54863,"latitude":29.552567,"userId":3,"typeId":2,"classId":0,"remark":"店铺介绍","crateTime":1563527315000,"state":1,"salesVolume":0,"shopNature":1,"selfShop":0,"openTime":"8:00-22:00"},"communityInfoList":[{"id":9,"communityName":"天龙城市花园","communityAddress":"南坪正街1号","sortNum":0,"description":"社区代理:张薇","logoUrl":"https://file.aicenyi.com/icon5658d531-2a33-4cb4-9adc-ee4934a2bafb1549000795342.jpg","tel":"13965784967","state":1,"longitude":106.568283,"latitude":29.530665,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":10,"communityName":"恒大滨河左岸","communityAddress":"南岸区长生镇长生雅苑旁","sortNum":0,"description":"社区代理:周宇","logoUrl":"https://file.aicenyi.com/icon799d1c07-033b-45a5-9d6e-ff7385d77bd21549001986016.jpg","tel":"13967426627","state":1,"longitude":106.67188,"latitude":29.508272,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":11,"communityName":"同景国际城W组团","communityAddress":"茶园丁香路1号","sortNum":0,"description":"社区代理:李好","logoUrl":"https://file.aicenyi.com/icon50ca2d47-5857-47ae-afb8-502dcc689ff41548926014611.jpg","tel":"15625478906","state":1,"longitude":106.65596,"latitude":29.50291,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":12,"communityName":"同景国际城香溪迈上","communityAddress":"重庆市南岸区月季路","sortNum":0,"description":"社区代理:李霞","logoUrl":"https://file.aicenyi.com/icondd261124-a514-49ef-826b-d5d15dd498c81548926157739.jpg","tel":"15625492201","state":1,"longitude":106.648877,"latitude":29.490292,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":13,"communityName":"融创伊顿庄园","communityAddress":"茶园米兰路38号","sortNum":0,"description":"社区代理:陈杰","logoUrl":"https://file.aicenyi.com/iconbec4d168-dbe9-4b0a-aebd-3663b99226a31549000950725.jpg","tel":"15936452301","state":1,"longitude":106.62511,"latitude":29.47258,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":14,"communityName":"光华安纳溪湖","communityAddress":"南岸区米兰路","sortNum":0,"description":"社区代理:陈东","logoUrl":"https://file.aicenyi.com/icon4feb4d35-256b-4873-bd49-f85416f00fff1548926321890.jpg","tel":"15944567893","state":1,"longitude":106.63064,"latitude":29.48043,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":15,"communityName":"法蓝西莊邸","communityAddress":"茶园米兰大道","sortNum":0,"description":"社区代理:唐敏","logoUrl":"https://file.aicenyi.com/icon174818c0-28ee-4564-bf66-36ecc556f7c31548926397522.jpg","tel":"15967803457","state":1,"longitude":106.62917,"latitude":29.48262,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":16,"communityName":"金辉城春上南滨","communityAddress":"南岸区芭蕉弯70号正东方向130米","sortNum":0,"description":"社区代理:唐明","logoUrl":"https://file.aicenyi.com/iconef6ed99d-0533-4605-94f0-80ad0adaacda1548926735893.jpg","tel":"15968876231","state":1,"longitude":106.54455,"latitude":29.53493,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":17,"communityName":"小苑三村","communityAddress":"江北区观音桥家乐福超市小苑车站","sortNum":0,"description":"社区代理:刘兆国","logoUrl":"https://file.aicenyi.com/iconf74c23ab-cb9b-4170-81aa-a98c26d0f8211549003247374.jpg","tel":"18983397590","state":1,"longitude":106.52968,"latitude":29.56984,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":18,"communityName":"融侨城花漫庭","communityAddress":"南岸区风临路3号","sortNum":0,"description":"社区代理:钟霞","logoUrl":"https://file.aicenyi.com/icondb1b5268-8f3e-4978-b757-9c0cdcedc4a91548927470556.jpg","tel":"13883972567","state":1,"longitude":106.53835,"latitude":29.52689,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":19,"communityName":"云满庭","communityAddress":"南岸区明佳路33号","sortNum":0,"description":"社区代理:钟燕","logoUrl":"https://file.aicenyi.com/icon875bc550-f901-424a-ba77-01c7279a72451548927529137.jpg","tel":"13868902435","state":1,"longitude":106.552177,"latitude":29.531122,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":20,"communityName":"万科悦湾北区","communityAddress":"江北区宏帆路135号","sortNum":0,"description":"社区代理:戴苛","logoUrl":"https://file.aicenyi.com/icona8420d8f-bc6f-415c-8f71-8619a9c4d8231548927612068.jpg","tel":"15123210773","state":1,"longitude":106.47436,"latitude":29.60853,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":21,"communityName":"龙湖观山水","communityAddress":"铜元局光电路26号","sortNum":0,"description":"社区代理:钟达","logoUrl":"https://file.aicenyi.com/icon23d1e25c-989b-4d77-b375-c319101d17651548927706228.jpg","tel":"13875490035","state":1,"longitude":106.54158,"latitude":29.52087,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":22,"communityName":"金辉御江府","communityAddress":"南岸区南滨路东侧","sortNum":0,"description":"社区代理:李莉","logoUrl":"https://file.aicenyi.com/icon655bd0ca-a982-4167-8fa2-a5278d5a88151548927783362.jpg","tel":"13636798803","state":1,"longitude":106.54014,"latitude":29.53495,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":23,"communityName":"石韵桂园小区","communityAddress":"江北区石韵桂园1号","sortNum":0,"description":"社区代理:钟燕","logoUrl":"https://file.aicenyi.com/icon31f6a9c8-b9dc-496a-b5c0-84e5e47aa7441548927861018.jpg","tel":"13883093834","state":1,"longitude":106.49467,"latitude":29.57109,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":65,"communityName":"阳光100国际新城两江壹号","communityAddress":"南岸区野猫溪正街1号","sortNum":0,"description":"社区代理:郭宏","logoUrl":"https://file.aicenyi.com/icon5081de51-a9b5-4cf3-a586-6cd5036679cb1548999762080.jpg","tel":"18783972276","state":1,"longitude":106.59103,"latitude":29.5737,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":27,"communityName":"山水丽都","communityAddress":"江北区石马河松石大道(玉带山小学旁)","sortNum":0,"description":"社区代理:骆高林","logoUrl":"https://file.aicenyi.com/icon95f07721-9672-45c2-b311-d421540a42c51548997718012.jpg","tel":"13609455143","state":1,"longitude":106.471801,"latitude":29.578887,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":29,"communityName":"云立家天下","communityAddress":"南坪东路辅仁路2号","sortNum":0,"description":"社区代理:朱晓","logoUrl":"https://file.aicenyi.com/icon2c880561-219d-4025-addc-7d7228cab2a61549000998294.jpg","tel":"13689872235","state":1,"longitude":106.5761,"latitude":29.52319,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":31,"communityName":"东原锦悦","communityAddress":"南岸区南坪东路2巷2号(现代女子医院对面)","sortNum":0,"description":"社区代理:朱俊","logoUrl":"https://file.aicenyi.com/icon59ae9d4e-ec3e-479d-8d24-a72bd32cb5f91548998049836.jpg","tel":"13676889035","state":1,"longitude":106.573,"latitude":29.53058,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":32,"communityName":"阳光南滨","communityAddress":"南坪东路宏声路46号","sortNum":0,"description":"社区代理:杨光","logoUrl":"https://file.aicenyi.com/iconf8d565d5-c039-4271-be62-df7d819e58951548998249264.jpg","tel":"13609832178","state":1,"longitude":106.57314,"latitude":29.53492,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":33,"communityName":"桥鸿一村","communityAddress":"江北区三湾路76号","sortNum":0,"description":"社区代理:王雨桐","logoUrl":"https://file.aicenyi.com/icon595fcde2-0d8a-4b2a-993d-d7c9e422aba61548998325039.jpg","tel":"15730106394","state":1,"longitude":106.517643,"latitude":29.567298,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":34,"communityName":"渝能国际","communityAddress":"学府路学府大道51号","sortNum":0,"description":"社区代理:杨丽","logoUrl":"https://file.aicenyi.com/icon86df574b-04e2-481b-ab49-cecb93a41c5f1548998406927.jpg","tel":"13688856790","state":1,"longitude":106.575541,"latitude":29.499228,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":35,"communityName":"保利观塘","communityAddress":"南岸区二塘路79号附16号正北方向82米","sortNum":0,"description":"社区代理:杨云鹏","logoUrl":"https://file.aicenyi.com/icon487e63a6-c036-4be8-b923-d2a57042a1921549001094751.jpg","tel":"13634556892","state":1,"longitude":106.56024,"latitude":29.49001,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":36,"communityName":"丽景苑","communityAddress":"江北区盘溪五支路31号","sortNum":0,"description":"社区代理:王露","logoUrl":"https://file.aicenyi.com/icon11bd9e6b-bad8-4672-854e-7719776a94311548998517969.jpg","tel":"18623307062","state":1,"longitude":106.47623,"latitude":29.59037,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":37,"communityName":"万友七季城","communityAddress":"南岸区回龙路88号","sortNum":0,"description":"社区代理:刘浩","logoUrl":"https://file.aicenyi.com/iconec3f53d8-834c-49dc-953c-71b5e90e11771548998610631.jpg","tel":"13614773568","state":1,"longitude":106.56679,"latitude":29.50035,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":38,"communityName":"山千院","communityAddress":"南岸区南坪五公里学府大道工商大学兰花湖校区旁正西方向48米","sortNum":0,"description":"社区代理:刘敏","logoUrl":"https://file.aicenyi.com/icon2e0bd6c4-0bfa-4961-8e00-73fed2686cb41548998774162.jpg","tel":"13633789045","state":1,"longitude":106.56573,"latitude":29.49903,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":39,"communityName":"雅居乐国际花园","communityAddress":"南岸区经开区汇龙路55号(美堤雅城旁)","sortNum":0,"description":"社区代理:赵飞","logoUrl":"https://file.aicenyi.com/iconb4ede6ee-8c87-4a12-9b45-538fa124dea21548998843314.jpg","tel":"13898768856","state":1,"longitude":106.560044,"latitude":29.500956,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":40,"communityName":"明瑜恒康佳苑","communityAddress":"江北区茶叶专业批发市场C区东北方向120米","sortNum":0,"description":"社区代理:赵勇","logoUrl":"https://file.aicenyi.com/icon214cd621-1172-4203-8056-c822f8b3bb401548998904575.jpg","tel":"15922661648","state":1,"longitude":106.48122,"latitude":29.58288,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":41,"communityName":"回龙湾小区","communityAddress":"学府路回龙路66号","sortNum":0,"description":"社区代理:赵芬芳","logoUrl":"https://file.aicenyi.com/iconea8babcc-4b38-4568-aa7b-a0133e5659651548998959518.jpg","tel":"15637490025","state":1,"longitude":106.56832,"latitude":29.50666,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":45,"communityName":"蓝光COCO时代","communityAddress":"南岸区腾龙大道与滕滨路交叉口","sortNum":0,"description":"社区代理:赵琪","logoUrl":"https://file.aicenyi.com/icon78e718a8-0caf-446a-a07f-9ce9a834ab821548999315633.jpg","tel":"15639786658","state":1,"longitude":106.598496,"latitude":29.592686,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":46,"communityName":"龙湖源著北区","communityAddress":"江北区盘溪路420号","sortNum":0,"description":"社区代理:高飞","logoUrl":"https://file.aicenyi.com/icon58331518-0791-4d92-93ae-9658da4272491548999543335.jpg","tel":"18602335824","state":1,"longitude":106.48427,"latitude":29.60264,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":47,"communityName":"龙湖郦江","communityAddress":"南岸区南岸弹子石街道大佛段(求新村4号)","sortNum":0,"description":"社区代理:孙芳","logoUrl":"https://file.aicenyi.com/iconaa5c71cb-f2c5-4f4c-aaa7-39d8479e0a161548999556600.jpg","tel":"15674452346","state":1,"longitude":106.534851,"latitude":29.527706,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":48,"communityName":"泽科弹子石中心","communityAddress":"南岸区群慧路19号","sortNum":0,"description":"社区代理:孙立","logoUrl":"https://file.aicenyi.com/iconea34f012-f59d-42f2-b19c-3d6454656bf81548999770618.jpg","tel":"18156890268","state":1,"longitude":106.59309,"latitude":29.58448,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":49,"communityName":"龙湖春森彼岸","communityAddress":"江北区北滨一路258号","sortNum":0,"description":"社区代理:杨秀洁","logoUrl":"https://file.aicenyi.com/icon082475a5-ec61-44c1-b9b0-9822796707e71548999782132.jpg","tel":"13883149715","state":1,"longitude":106.54835,"latitude":29.570518,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":50,"communityName":"国际社区海悦府","communityAddress":"南岸区福民路39号","sortNum":0,"description":"社区代理:孙鹏鹏","logoUrl":"https://file.aicenyi.com/iconf5f4dae0-b99f-41ef-b5f9-afb450e0f1731548999843935.jpg","tel":"18862492037","state":1,"longitude":106.59296,"latitude":29.59461,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":51,"communityName":"兰溪小区","communityAddress":"江北区海尔路181号","sortNum":0,"description":"社区代理:黄颖","logoUrl":"https://file.aicenyi.com/icon9d4301c0-d633-4691-bf70-2204cf73861c1548999936273.jpg","tel":"15223173722","state":1,"longitude":106.57405,"latitude":29.6101,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":52,"communityName":"富力现代广场","communityAddress":"南岸区石新街59号","sortNum":0,"description":"社区代理:吴双","logoUrl":"https://file.aicenyi.com/icon2e77f81a-c765-4af0-a9f8-8b642ec0231d1549001134236.jpg","tel":"18983897745","state":1,"longitude":106.59872,"latitude":29.5803,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":53,"communityName":"巨龙江山国际","communityAddress":"江北区和煦路30号","sortNum":0,"description":"社区代理:郭成","logoUrl":"https://file.aicenyi.com/icon53e594e5-14c3-4305-b739-9797897660ec1549000171336.jpg","tel":"13635492201","state":1,"longitude":106.76735,"latitude":29.62507,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":54,"communityName":"国际社区观园","communityAddress":"南岸区福民路38号","sortNum":0,"description":"社区代理:吴莉","logoUrl":"https://file.aicenyi.com/icon14d4f275-45b1-40dd-b6d1-24e384370d581549000422448.jpg","tel":"18977654347","state":1,"longitude":106.59471,"latitude":29.59769,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":7,"communityName":"天龙广场三期","communityAddress":"南坪宏声路35号","sortNum":0,"description":"社区代理:张波","logoUrl":"https://file.aicenyi.com/icon878380e6-d580-401a-974a-ed46fce525a21549000603401.jpg","tel":"13827658820","state":1,"longitude":106.570107,"latitude":29.531195,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":6,"communityName":"珊瑚水岸","communityAddress":"重庆市南岸区南滨路28号","sortNum":0,"description":"社区代理:王浩","logoUrl":"https://file.aicenyi.com/icon69e2c5ee-2c85-4e83-adb2-5506209866c51548924684091.jpg","tel":"13883345634","state":1,"longitude":106.57493,"latitude":29.53985,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":55,"communityName":"银翔翡翠谷","communityAddress":"南岸区兴塘路2号","sortNum":0,"description":"社区代理:李静","logoUrl":"https://file.aicenyi.com/icon69fcc186-4cf8-4c6e-9d5d-4d1b90b5590f1549000494111.jpg","tel":"15167890368","state":1,"longitude":106.650303,"latitude":29.507731,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":57,"communityName":"鲁能领秀城骏峰","communityAddress":"南岸区天文大道35号","sortNum":0,"description":"社区代理:刘玉栋","logoUrl":"https://file.aicenyi.com/icon74b8cd80-73bd-4d4a-8409-9dc23031aada1549000377561.jpg","tel":"15190870045","state":1,"longitude":106.64206,"latitude":29.51047,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":58,"communityName":"江南小区","communityAddress":"南岸区广福大道与莲池路交口","sortNum":0,"description":"社区代理:李贤玉","logoUrl":"https://file.aicenyi.com/iconfcfa70cd-2fc5-456c-8a35-5010fe6631711549002078976.jpg","tel":"15178903596","state":1,"longitude":106.636793,"latitude":29.493267,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":61,"communityName":"金果园小区","communityAddress":"江北区金果园1号","sortNum":0,"description":"社区代理:刘志国","logoUrl":"https://file.aicenyi.com/icon497528fd-b0b1-41c4-9282-3ce37b5340c91549000098549.jpg","tel":"17772327632","state":1,"longitude":106.48867,"latitude":29.57986,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":63,"communityName":"鑫茂源E时代","communityAddress":"南岸区青龙路36号","sortNum":0,"description":"社区代理:高翔","logoUrl":"https://file.aicenyi.com/icon967919c1-83f8-46b0-a2cf-6c4a391936bc1548999849481.jpg","tel":"18937790254","state":1,"longitude":106.57293,"latitude":29.513344,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":64,"communityName":"华宇北国风光","communityAddress":"江北区北滨一路476号","sortNum":0,"description":"社区代理:赖维","logoUrl":"https://file.aicenyi.com/icon1998f38e-07dc-4d63-aeef-0ba096a579ec1548999798702.jpg","tel":"18623504577","state":1,"longitude":106.5093,"latitude":29.55948,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":65,"communityName":"阳光100国际新城两江壹号","communityAddress":"南岸区野猫溪正街1号","sortNum":0,"description":"社区代理:郭宏","logoUrl":"https://file.aicenyi.com/icon5081de51-a9b5-4cf3-a586-6cd5036679cb1548999762080.jpg","tel":"18783972276","state":1,"longitude":106.59103,"latitude":29.5737,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":66,"communityName":"华润中央公园","communityAddress":"江北区北滨一路大石坝三村北","sortNum":0,"description":"社区代理:唐甜甜","logoUrl":"https://file.aicenyi.com/icona64570c7-c845-4573-aa3d-f3d3afcb4bf41548999641176.jpg","tel":"13618305486","state":1,"longitude":106.4976,"latitude":29.56108,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":67,"communityName":"东海星洲","communityAddress":"南岸区涂山路580号","sortNum":0,"description":"社区代理:黎莉","logoUrl":"https://file.aicenyi.com/iconab84847b-690e-4c89-a94c-e76532a73e861548999563209.jpg","tel":"15199813548","state":1,"longitude":106.60388,"latitude":29.57799,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":69,"communityName":"金港尚城","communityAddress":"南岸区腾黄路","sortNum":0,"description":"社区代理:宋玉","logoUrl":"https://file.aicenyi.com/icon6d0bac37-1098-4450-957b-0673c01b4f5d1548999489713.jpg","tel":"13689007656","state":1,"longitude":106.604554,"latitude":29.596408,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":70,"communityName":"海尔海语江山","communityAddress":"江北区海尔路","sortNum":0,"description":"社区代理:刘杰","logoUrl":"https://file.aicenyi.com/icone8ea9722-6d31-4a45-919b-18475c0c12231548999444982.jpg","tel":"15922966682","state":1,"longitude":106.513126,"latitude":29.558468,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":59,"communityName":"金科10年城","communityAddress":"江北区石马河街道石子山村原坪上社(堰塘湾社D宗)","sortNum":0,"description":"社区代理:甘科龙","logoUrl":"https://file.aicenyi.com/icona165b0db-64e1-4367-aed3-2e64872917261549000274278.jpg","tel":"15523866631","state":1,"longitude":106.48304,"latitude":29.607682,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":71,"communityName":"和泓南山道","communityAddress":"南岸区海棠溪敦厚街36号(江南体育中心旁)","sortNum":0,"description":"社区代理:钱俊","logoUrl":"https://file.aicenyi.com/icon910aece3-a586-4a79-b652-7f7343defbfc1548998915538.jpg","tel":"13635570967","state":1,"longitude":106.58779,"latitude":29.54036,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":60,"communityName":"巨成龙湾","communityAddress":"南岸区青龙路8号","sortNum":0,"description":"社区代理:陈红","logoUrl":"https://file.aicenyi.com/icon8396175a-4f77-453d-bd1c-51e4c6ec57071549000236616.jpg","tel":"15199082698","state":1,"longitude":106.558402,"latitude":29.512291,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":72,"communityName":"山与城","communityAddress":"南岸区黄桷垭黄沙坎广黔路与福寿路交口附近(重庆邮电大学与老厂道路之间)","sortNum":0,"description":"社区代理:李蓉","logoUrl":"https://file.aicenyi.com/icon8a8d7373-db44-46bc-8188-1f92dc96c0351548998855454.jpg","tel":"13899876740","state":1,"longitude":106.594553,"latitude":29.501587,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":79,"communityName":"和泓江山国际","communityAddress":"渝中区和泓江山国际小区和复旦中学分校之间东北方向84米","sortNum":0,"description":"社区代理:周偶","logoUrl":"https://file.aicenyi.com/icon80a57e95-2cda-4a4f-8d9a-9955afabf2bd1548998026822.jpg","tel":"13908073326","state":1,"longitude":106.52759,"latitude":29.54136,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":43,"communityName":"中国核建紫金一品","communityAddress":"南岸区腾龙大道4号正南方向135米","sortNum":0,"description":"社区代理:赵宝庆","logoUrl":"https://file.aicenyi.com/iconaea15c82-05e7-4a65-9fb7-cc2c0e59998e1548999137477.jpg","tel":"15666789347","state":1,"longitude":106.59637,"latitude":29.58474,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":80,"communityName":"国奥村时光漫","communityAddress":"江北区国惠路15号","sortNum":0,"description":"社区代理:李玲","logoUrl":"https://file.aicenyi.com/icond8a9fcc6-c06a-4cbd-a17a-8497b676b9d91548997968833.jpg","tel":"15608331314","state":1,"longitude":106.459473,"latitude":29.590693,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":5,"communityName":"新欧鹏教育城","communityAddress":"江北区江北嘴鲁溉路(中央公园旁)","sortNum":0,"description":"社区代理:尹国红","logoUrl":"https://file.aicenyi.com/iconbb2ee733-51d1-480e-b94a-9621c00f86c31548925475954.jpg","tel":"17726638949","state":1,"longitude":106.5732,"latitude":29.59,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":81,"communityName":"嘉华鑫城","communityAddress":"渝中区大坪正街118号","sortNum":0,"description":"社区代理:周鹏","logoUrl":"https://file.aicenyi.com/icon13de5b52-93af-43b4-9651-ef03402685e21548997824322.jpg","tel":"13900457902","state":1,"longitude":106.51187,"latitude":29.54142,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":42,"communityName":"绿地保税中心","communityAddress":"江北区金渝大道138号","sortNum":0,"description":"社区代理:朱恬恬","logoUrl":"https://file.aicenyi.com/icon84e798a9-e8f3-4c51-a63e-ea12cf7e0d811548999062750.jpg","tel":"18623161572","state":1,"longitude":106.582779,"latitude":29.620691,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":44,"communityName":"龙湖源著南区","communityAddress":"江北区福泉路26号","sortNum":0,"description":"社区代理:雷莹","logoUrl":"https://file.aicenyi.com/icona72671af-521e-464f-8fe1-650fe554ba7f1548999220114.jpg","tel":"13541874210","state":1,"longitude":106.48704,"latitude":29.59983,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":86,"communityName":"光华可乐小镇","communityAddress":"江北区福居路12号","sortNum":0,"description":"社区代理:冯军","logoUrl":"https://file.aicenyi.com/icon8a688d6c-b2cb-43f2-bd6c-b76013f17c3f1548996595357.jpg","tel":"13692228745","state":1,"longitude":106.483856,"latitude":29.593225,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":83,"communityName":"国奥村","communityAddress":"江北区宏帆路西","sortNum":0,"description":"社区代理:蒲慧琳","logoUrl":"https://file.aicenyi.com/icon9808851b-56e9-4163-bb85-59bba174e4131548996316147.jpg","tel":"18613061312","state":1,"longitude":106.461088,"latitude":29.592597,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":62,"communityName":"金阳罗马假日","communityAddress":"南岸区青龙路36号","sortNum":0,"description":"社区代理:高莉","logoUrl":"https://file.aicenyi.com/icon1ab8e522-48d9-47e5-a242-de4d3a2088281549000015018.jpg","tel":"15176453390","state":1,"longitude":106.56219,"latitude":29.51287,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":87,"communityName":"张家花园社区","communityAddress":"渝中区人和街与北区路交叉口南150米","sortNum":0,"description":"社区代理:肖强","logoUrl":"https://file.aicenyi.com/iconde6e6460-688f-47da-8266-55bb173392e21549001451234.jpg","tel":"15189902368","state":1,"longitude":106.559616,"latitude":29.562471,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":88,"communityName":"光华观府国际","communityAddress":"江北区华新路96号","sortNum":0,"description":"社区代理:石雨荷","logoUrl":"https://file.aicenyi.com/icon7c136b26-93b5-49e7-b1e5-5b5769568c631548996729726.jpg","tel":"15736156308","state":1,"longitude":106.53459,"latitude":29.567729,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":77,"communityName":"财信渝中城","communityAddress":"渝中区中山一路6号(七星岗车站旁)","sortNum":0,"description":"社区代理:鲍莉","logoUrl":"https://file.aicenyi.com/icon0c01e67f-bb44-406c-a2f5-f4e7064bc4051548998276482.jpg","tel":"13999876878","state":1,"longitude":106.566258,"latitude":29.555766,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":90,"communityName":"竹园小区","communityAddress":"渝中区交通街109号","sortNum":0,"description":"社区代理:吴美莉","logoUrl":"https://file.aicenyi.com/icon6673ed1e-0cf1-4cc1-81bf-5797f75c866d1548996934686.jpg","tel":"15697802683","state":1,"longitude":106.53113,"latitude":29.53771,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":85,"communityName":"书香苑","communityAddress":"渝中区华福巷53号","sortNum":0,"description":"社区代理:肖晓月","logoUrl":"https://file.aicenyi.com/icon6105c644-f4f1-48e8-a826-373faa85876f1548996514385.jpg","tel":"15988973458","state":1,"longitude":106.556033,"latitude":29.558934,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":91,"communityName":"中驰领寓","communityAddress":"渝中区解放东路72号","sortNum":0,"description":"社区代理:吴艳丽","logoUrl":"https://file.aicenyi.com/icon4796b9f6-8fa1-4972-b3b8-da72230c67331548997002727.jpg","tel":"15998372651","state":1,"longitude":106.58397,"latitude":29.55667,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":78,"communityName":"江屿朗廷","communityAddress":"渝中区菜袁路168号","sortNum":0,"description":"社区代理:林峰","logoUrl":"https://file.aicenyi.com/icon5c6add0c-7815-40ec-90cd-ede3432ea5ff1548998120719.jpg","tel":"13976885798","state":1,"longitude":106.52816,"latitude":29.537038,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":92,"communityName":"华一坡社区","communityAddress":"渝中区华一坡33正东方向114米","sortNum":0,"description":"社区代理:冯唐","logoUrl":"https://file.aicenyi.com/icon288a21df-1acd-42f9-89ba-c25e01d2d31f1549002333638.jpg","tel":"15968016672","state":1,"longitude":106.56667,"latitude":29.55817,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":74,"communityName":"奥园康城","communityAddress":"渝中区黄杨路6号","sortNum":0,"description":"社区代理:王志","logoUrl":"https://file.aicenyi.com/icon1a69cdc8-ed7a-4d8c-991c-d5148ebaf9f71548998485571.jpg","tel":"13877804798","state":1,"longitude":106.52369,"latitude":29.53013,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":84,"communityName":"兰波红城丽景","communityAddress":"渝中区大坪长江二路39号附18号","sortNum":0,"description":"社区代理:王银","logoUrl":"https://file.aicenyi.com/icon80e0ffd6-466b-4114-8f89-3af30a72e7c11548996465821.jpg","tel":"13998875645","state":1,"longitude":106.52543,"latitude":29.53938,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":93,"communityName":"凤凰湾","communityAddress":"江北区宏帆路28号","sortNum":0,"description":"社区代理:刘林","logoUrl":"https://file.aicenyi.com/icon802931e6-264c-4580-93e6-eda3f29519941548991899825.jpg","tel":"15123217856","state":1,"longitude":106.468785,"latitude":29.596505,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":94,"communityName":"天官府小区","communityAddress":"渝中区金汤街79西北方向141米","sortNum":0,"description":"社区代理:唐涛","logoUrl":"https://file.aicenyi.com/icon67dffa75-ba23-44d9-940d-c2e50b52f3eb1549002828062.jpg","tel":"15977013690","state":1,"longitude":106.56686,"latitude":29.55245,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":75,"communityName":"华宇·渝州新都","communityAddress":"渝中区大坪正街140号","sortNum":0,"description":"社区代理:鲍成风","logoUrl":"https://file.aicenyi.com/icondcd0e935-91ef-421d-a1e5-41523452557c1548998401348.jpg","tel":"13809015578","state":1,"longitude":106.50787,"latitude":29.53902,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":95,"communityName":"互助里小区","communityAddress":"渝中区互助里43号","sortNum":0,"description":"社区代理:王立忠","logoUrl":"https://file.aicenyi.com/iconc4659541-4824-4821-84e9-0e53fce46e271548927974177.jpg","tel":"15905534809","state":1,"longitude":106.545944,"latitude":29.556959,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":76,"communityName":"国兴北岸江山","communityAddress":"江北区观音桥江北观音桥北滨一路456号(鸿恩寺公园旁)","sortNum":0,"description":"社区代理:王渊","logoUrl":"https://file.aicenyi.com/icona9aa76f1-97c1-4f35-bd6a-1fcb3b3bc0541548998339435.jpg","tel":"15029903288","state":1,"longitude":106.51767,"latitude":29.55939,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":96,"communityName":"桂花园","communityAddress":"渝中区新桂花园位于重庆市渝中区桂花园62号","sortNum":0,"description":"社区代理:卫清茗","logoUrl":"https://file.aicenyi.com/icon4312e646-1889-44b0-997e-7b958e0064941548927930059.jpg","tel":"15185670091","state":1,"longitude":106.542198,"latitude":29.555485,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":73,"communityName":"恒大名都","communityAddress":"渝中区石油路1号","sortNum":0,"description":"社区代理:王志峰","logoUrl":"https://file.aicenyi.com/iconc893b781-c1fd-49f2-a348-b50a9537b8721548998544883.jpg","tel":"13833586787","state":1,"longitude":106.506302,"latitude":29.542244,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":56,"communityName":"锦绣嘉陵","communityAddress":"江北区宁福路101号","sortNum":0,"description":"社区代理:郝倩","logoUrl":"https://file.aicenyi.com/icon45ab50e4-45cb-4a0d-881c-4f89189309c81549000452791.jpg","tel":"19923096976","state":1,"longitude":106.51809,"latitude":29.56238,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":98,"communityName":"东原D7区","communityAddress":"江北区鸿恩寺红石路段(大石坝公交站点旁)","sortNum":0,"description":"社区代理:李婷","logoUrl":"https://file.aicenyi.com/icon498588ec-ae75-473e-97f6-70f238daad5d1548927573291.jpg","tel":"13956232456","state":1,"longitude":106.496817,"latitude":29.568816,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":89,"communityName":"时代豪苑","communityAddress":"渝中区青年路3号","sortNum":0,"description":"社区代理:杨萍","logoUrl":"https://file.aicenyi.com/icon79f97e28-0ec9-43eb-aef9-6bb148324a471548996797092.jpg","tel":"15813557983","state":1,"longitude":106.57702,"latitude":29.55805,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":82,"communityName":"海客瀛洲","communityAddress":"渝中区长江滨江路20号","sortNum":0,"description":"社区代理:洪流海","logoUrl":"https://file.aicenyi.com/iconc469c4b1-921f-4043-968c-59dfebd585e61548991989289.jpg","tel":"13888475698","state":1,"longitude":106.58836,"latitude":29.56215,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":100,"communityName":"保利江上明珠乐园","communityAddress":"江北区三湾路西100米","sortNum":0,"description":"社区代理:王锐","logoUrl":"https://file.aicenyi.com/icon624cc2cf-d48d-4293-b013-2a01369a05a41548927206658.jpg","tel":"13324598532","state":1,"longitude":106.515059,"latitude":29.568468,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":97,"communityName":"东原D8公馆","communityAddress":"江北区大石坝鸿恩寺红石路段(大石坝公交站点旁)","sortNum":0,"description":"社区代理:吴霞","logoUrl":"https://file.aicenyi.com/icon6220a712-93ef-4fed-879a-94fc286451621548927767836.jpg","tel":"13635492103","state":1,"longitude":106.49412,"latitude":29.56906,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":101,"communityName":"保利江上明珠锦园","communityAddress":"江北区鸿恩路鸿恩寺森林公园东侧","sortNum":0,"description":"社区代理:魏杰","logoUrl":"https://file.aicenyi.com/icon0d4cf932-2d15-4064-86e2-2b86bc5f6afa1548927104223.jpg","tel":"13884567821","state":1,"longitude":106.511474,"latitude":29.568763,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":102,"communityName":"半山华府","communityAddress":"江北区兴竹路21号","sortNum":0,"description":"社区代理:唐宇","logoUrl":"https://file.aicenyi.com/icon8a74bd36-e8c2-42cf-87c5-7af327527e191548926811210.jpg","tel":"15745936592","state":1,"longitude":106.524234,"latitude":29.562338,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":68,"communityName":"东海长洲","communityAddress":"南岸区涂山路滨江实验学校东侧","sortNum":0,"description":"社区代理:孙杨","logoUrl":"https://file.aicenyi.com/icon65a939a2-7339-449c-94f6-851f9448e5cb1549001539170.jpg","tel":"15107496687","state":1,"longitude":106.60195,"latitude":29.57491,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":30,"communityName":"庆业巴蜀城","communityAddress":"江北区海尔路6号","sortNum":0,"description":"社区代理:屈章文","logoUrl":"https://file.aicenyi.com/iconeb30e114-bcd8-47b8-903c-3e43048e79571548997971800.jpg","tel":"13330251575","state":1,"longitude":106.56246,"latitude":29.58841,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":28,"communityName":"康德国会山","communityAddress":"南坪东路辅仁路8号","sortNum":0,"description":"社区代理:刘恋","logoUrl":"https://file.aicenyi.com/icon2378a7ff-1bdd-4d16-baa2-e57ea738baf51548997808410.jpg","tel":"13676754431","state":1,"longitude":106.57775,"latitude":29.52772,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":99,"communityName":"东海岸","communityAddress":"江北区下石门618号","sortNum":0,"description":"社区代理:赵飞","logoUrl":"https://file.aicenyi.com/icone27dc299-4fd9-4115-89b0-82cdde567aa91548927355355.jpg","tel":"13266541286","state":1,"longitude":106.484215,"latitude":29.563203,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":3,"communityName":"中亿阳明山水","communityAddress":"江北区海尔路179号","sortNum":1,"description":"社区代理:刘月","logoUrl":"https://file.aicenyi.com/icon9a5d049b-a9c1-4e91-bdb2-dd80ca696f491548925152102.jpg","tel":"15683334374","state":1,"longitude":106.56867,"latitude":29.60748,"del":0,"returnPercentage":1000,"openId":"oCZVp1Cbrtd_BOHE_uhpPd11gpvY","wechatLogin":0,"areaCode":null,"distance":0},{"id":2,"communityName":"紫御江山","communityAddress":"江北区北滨二路537号(北滨二路,朝天门大桥旁)","sortNum":1,"description":"社区代理:郑胜中","logoUrl":"https://file.aicenyi.com/iconcc8c1f63-0bb8-4dba-8de0-50bf83c12b151548925059245.jpg","tel":"17318213273","state":1,"longitude":106.54541,"latitude":29.52567,"del":0,"returnPercentage":1000,"openId":"oCZVp1BGH0X_qo8C9h0FG9nlCrxM","wechatLogin":0,"areaCode":null,"distance":0},{"id":8,"communityName":"星宇花园","communityAddress":"南坪东路11号","sortNum":0,"description":"社区代理:张伯","logoUrl":"https://file.aicenyi.com/iconbf2699e2-f7ba-416b-b319-1a557cf9de171548924806365.jpg","tel":"13877632190","state":1,"longitude":106.571002,"latitude":29.529924,"del":0,"returnPercentage":1000,"openId":"oCZVp1Cbrtd_BOHE_uhpPd11gpvY","wechatLogin":0,"areaCode":null,"distance":0}],"orderInfo":null}
     */

    private boolean success;
    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * cartInfoCollection : {"totalCount":1,"entityList":[{"id":1750,"customerId":2,"shopId":1,"goodsId":894,"buyNum":1,"addTime":1568887580000,"updateTime":1568887580000,"goodsName":"广式香肠500g±20g","price":1880,"totalPrice":1880,"resultPrice":0,"specifications":"件","logoUrl":"https://file.aicenyi.com/iconf3b20d8d-b328-4db8-a739-c1fea3a458871549005366028.jpg"}]}
         * shopInfo : {"id":1,"shopName":"两路口核销店","shopTel":"18122222222","shopAddress":"两路口地铁站附近","cityId":500000,"districtId":0,"shopLogoUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg","longitude":106.54863,"latitude":29.552567,"userId":3,"typeId":2,"classId":0,"remark":"店铺介绍","crateTime":1563527315000,"state":1,"salesVolume":0,"shopNature":1,"selfShop":0,"openTime":"8:00-22:00"}
         * communityInfoList : [{"id":9,"communityName":"天龙城市花园","communityAddress":"南坪正街1号","sortNum":0,"description":"社区代理:张薇","logoUrl":"https://file.aicenyi.com/icon5658d531-2a33-4cb4-9adc-ee4934a2bafb1549000795342.jpg","tel":"13965784967","state":1,"longitude":106.568283,"latitude":29.530665,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":10,"communityName":"恒大滨河左岸","communityAddress":"南岸区长生镇长生雅苑旁","sortNum":0,"description":"社区代理:周宇","logoUrl":"https://file.aicenyi.com/icon799d1c07-033b-45a5-9d6e-ff7385d77bd21549001986016.jpg","tel":"13967426627","state":1,"longitude":106.67188,"latitude":29.508272,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":11,"communityName":"同景国际城W组团","communityAddress":"茶园丁香路1号","sortNum":0,"description":"社区代理:李好","logoUrl":"https://file.aicenyi.com/icon50ca2d47-5857-47ae-afb8-502dcc689ff41548926014611.jpg","tel":"15625478906","state":1,"longitude":106.65596,"latitude":29.50291,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":12,"communityName":"同景国际城香溪迈上","communityAddress":"重庆市南岸区月季路","sortNum":0,"description":"社区代理:李霞","logoUrl":"https://file.aicenyi.com/icondd261124-a514-49ef-826b-d5d15dd498c81548926157739.jpg","tel":"15625492201","state":1,"longitude":106.648877,"latitude":29.490292,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":13,"communityName":"融创伊顿庄园","communityAddress":"茶园米兰路38号","sortNum":0,"description":"社区代理:陈杰","logoUrl":"https://file.aicenyi.com/iconbec4d168-dbe9-4b0a-aebd-3663b99226a31549000950725.jpg","tel":"15936452301","state":1,"longitude":106.62511,"latitude":29.47258,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":14,"communityName":"光华安纳溪湖","communityAddress":"南岸区米兰路","sortNum":0,"description":"社区代理:陈东","logoUrl":"https://file.aicenyi.com/icon4feb4d35-256b-4873-bd49-f85416f00fff1548926321890.jpg","tel":"15944567893","state":1,"longitude":106.63064,"latitude":29.48043,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":15,"communityName":"法蓝西莊邸","communityAddress":"茶园米兰大道","sortNum":0,"description":"社区代理:唐敏","logoUrl":"https://file.aicenyi.com/icon174818c0-28ee-4564-bf66-36ecc556f7c31548926397522.jpg","tel":"15967803457","state":1,"longitude":106.62917,"latitude":29.48262,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":16,"communityName":"金辉城春上南滨","communityAddress":"南岸区芭蕉弯70号正东方向130米","sortNum":0,"description":"社区代理:唐明","logoUrl":"https://file.aicenyi.com/iconef6ed99d-0533-4605-94f0-80ad0adaacda1548926735893.jpg","tel":"15968876231","state":1,"longitude":106.54455,"latitude":29.53493,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":17,"communityName":"小苑三村","communityAddress":"江北区观音桥家乐福超市小苑车站","sortNum":0,"description":"社区代理:刘兆国","logoUrl":"https://file.aicenyi.com/iconf74c23ab-cb9b-4170-81aa-a98c26d0f8211549003247374.jpg","tel":"18983397590","state":1,"longitude":106.52968,"latitude":29.56984,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":18,"communityName":"融侨城花漫庭","communityAddress":"南岸区风临路3号","sortNum":0,"description":"社区代理:钟霞","logoUrl":"https://file.aicenyi.com/icondb1b5268-8f3e-4978-b757-9c0cdcedc4a91548927470556.jpg","tel":"13883972567","state":1,"longitude":106.53835,"latitude":29.52689,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":19,"communityName":"云满庭","communityAddress":"南岸区明佳路33号","sortNum":0,"description":"社区代理:钟燕","logoUrl":"https://file.aicenyi.com/icon875bc550-f901-424a-ba77-01c7279a72451548927529137.jpg","tel":"13868902435","state":1,"longitude":106.552177,"latitude":29.531122,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":20,"communityName":"万科悦湾北区","communityAddress":"江北区宏帆路135号","sortNum":0,"description":"社区代理:戴苛","logoUrl":"https://file.aicenyi.com/icona8420d8f-bc6f-415c-8f71-8619a9c4d8231548927612068.jpg","tel":"15123210773","state":1,"longitude":106.47436,"latitude":29.60853,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":21,"communityName":"龙湖观山水","communityAddress":"铜元局光电路26号","sortNum":0,"description":"社区代理:钟达","logoUrl":"https://file.aicenyi.com/icon23d1e25c-989b-4d77-b375-c319101d17651548927706228.jpg","tel":"13875490035","state":1,"longitude":106.54158,"latitude":29.52087,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":22,"communityName":"金辉御江府","communityAddress":"南岸区南滨路东侧","sortNum":0,"description":"社区代理:李莉","logoUrl":"https://file.aicenyi.com/icon655bd0ca-a982-4167-8fa2-a5278d5a88151548927783362.jpg","tel":"13636798803","state":1,"longitude":106.54014,"latitude":29.53495,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":23,"communityName":"石韵桂园小区","communityAddress":"江北区石韵桂园1号","sortNum":0,"description":"社区代理:钟燕","logoUrl":"https://file.aicenyi.com/icon31f6a9c8-b9dc-496a-b5c0-84e5e47aa7441548927861018.jpg","tel":"13883093834","state":1,"longitude":106.49467,"latitude":29.57109,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":65,"communityName":"阳光100国际新城两江壹号","communityAddress":"南岸区野猫溪正街1号","sortNum":0,"description":"社区代理:郭宏","logoUrl":"https://file.aicenyi.com/icon5081de51-a9b5-4cf3-a586-6cd5036679cb1548999762080.jpg","tel":"18783972276","state":1,"longitude":106.59103,"latitude":29.5737,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":27,"communityName":"山水丽都","communityAddress":"江北区石马河松石大道(玉带山小学旁)","sortNum":0,"description":"社区代理:骆高林","logoUrl":"https://file.aicenyi.com/icon95f07721-9672-45c2-b311-d421540a42c51548997718012.jpg","tel":"13609455143","state":1,"longitude":106.471801,"latitude":29.578887,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":29,"communityName":"云立家天下","communityAddress":"南坪东路辅仁路2号","sortNum":0,"description":"社区代理:朱晓","logoUrl":"https://file.aicenyi.com/icon2c880561-219d-4025-addc-7d7228cab2a61549000998294.jpg","tel":"13689872235","state":1,"longitude":106.5761,"latitude":29.52319,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":31,"communityName":"东原锦悦","communityAddress":"南岸区南坪东路2巷2号(现代女子医院对面)","sortNum":0,"description":"社区代理:朱俊","logoUrl":"https://file.aicenyi.com/icon59ae9d4e-ec3e-479d-8d24-a72bd32cb5f91548998049836.jpg","tel":"13676889035","state":1,"longitude":106.573,"latitude":29.53058,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":32,"communityName":"阳光南滨","communityAddress":"南坪东路宏声路46号","sortNum":0,"description":"社区代理:杨光","logoUrl":"https://file.aicenyi.com/iconf8d565d5-c039-4271-be62-df7d819e58951548998249264.jpg","tel":"13609832178","state":1,"longitude":106.57314,"latitude":29.53492,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":33,"communityName":"桥鸿一村","communityAddress":"江北区三湾路76号","sortNum":0,"description":"社区代理:王雨桐","logoUrl":"https://file.aicenyi.com/icon595fcde2-0d8a-4b2a-993d-d7c9e422aba61548998325039.jpg","tel":"15730106394","state":1,"longitude":106.517643,"latitude":29.567298,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":34,"communityName":"渝能国际","communityAddress":"学府路学府大道51号","sortNum":0,"description":"社区代理:杨丽","logoUrl":"https://file.aicenyi.com/icon86df574b-04e2-481b-ab49-cecb93a41c5f1548998406927.jpg","tel":"13688856790","state":1,"longitude":106.575541,"latitude":29.499228,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":35,"communityName":"保利观塘","communityAddress":"南岸区二塘路79号附16号正北方向82米","sortNum":0,"description":"社区代理:杨云鹏","logoUrl":"https://file.aicenyi.com/icon487e63a6-c036-4be8-b923-d2a57042a1921549001094751.jpg","tel":"13634556892","state":1,"longitude":106.56024,"latitude":29.49001,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":36,"communityName":"丽景苑","communityAddress":"江北区盘溪五支路31号","sortNum":0,"description":"社区代理:王露","logoUrl":"https://file.aicenyi.com/icon11bd9e6b-bad8-4672-854e-7719776a94311548998517969.jpg","tel":"18623307062","state":1,"longitude":106.47623,"latitude":29.59037,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":37,"communityName":"万友七季城","communityAddress":"南岸区回龙路88号","sortNum":0,"description":"社区代理:刘浩","logoUrl":"https://file.aicenyi.com/iconec3f53d8-834c-49dc-953c-71b5e90e11771548998610631.jpg","tel":"13614773568","state":1,"longitude":106.56679,"latitude":29.50035,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":38,"communityName":"山千院","communityAddress":"南岸区南坪五公里学府大道工商大学兰花湖校区旁正西方向48米","sortNum":0,"description":"社区代理:刘敏","logoUrl":"https://file.aicenyi.com/icon2e0bd6c4-0bfa-4961-8e00-73fed2686cb41548998774162.jpg","tel":"13633789045","state":1,"longitude":106.56573,"latitude":29.49903,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":39,"communityName":"雅居乐国际花园","communityAddress":"南岸区经开区汇龙路55号(美堤雅城旁)","sortNum":0,"description":"社区代理:赵飞","logoUrl":"https://file.aicenyi.com/iconb4ede6ee-8c87-4a12-9b45-538fa124dea21548998843314.jpg","tel":"13898768856","state":1,"longitude":106.560044,"latitude":29.500956,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":40,"communityName":"明瑜恒康佳苑","communityAddress":"江北区茶叶专业批发市场C区东北方向120米","sortNum":0,"description":"社区代理:赵勇","logoUrl":"https://file.aicenyi.com/icon214cd621-1172-4203-8056-c822f8b3bb401548998904575.jpg","tel":"15922661648","state":1,"longitude":106.48122,"latitude":29.58288,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":41,"communityName":"回龙湾小区","communityAddress":"学府路回龙路66号","sortNum":0,"description":"社区代理:赵芬芳","logoUrl":"https://file.aicenyi.com/iconea8babcc-4b38-4568-aa7b-a0133e5659651548998959518.jpg","tel":"15637490025","state":1,"longitude":106.56832,"latitude":29.50666,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":45,"communityName":"蓝光COCO时代","communityAddress":"南岸区腾龙大道与滕滨路交叉口","sortNum":0,"description":"社区代理:赵琪","logoUrl":"https://file.aicenyi.com/icon78e718a8-0caf-446a-a07f-9ce9a834ab821548999315633.jpg","tel":"15639786658","state":1,"longitude":106.598496,"latitude":29.592686,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":46,"communityName":"龙湖源著北区","communityAddress":"江北区盘溪路420号","sortNum":0,"description":"社区代理:高飞","logoUrl":"https://file.aicenyi.com/icon58331518-0791-4d92-93ae-9658da4272491548999543335.jpg","tel":"18602335824","state":1,"longitude":106.48427,"latitude":29.60264,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":47,"communityName":"龙湖郦江","communityAddress":"南岸区南岸弹子石街道大佛段(求新村4号)","sortNum":0,"description":"社区代理:孙芳","logoUrl":"https://file.aicenyi.com/iconaa5c71cb-f2c5-4f4c-aaa7-39d8479e0a161548999556600.jpg","tel":"15674452346","state":1,"longitude":106.534851,"latitude":29.527706,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":48,"communityName":"泽科弹子石中心","communityAddress":"南岸区群慧路19号","sortNum":0,"description":"社区代理:孙立","logoUrl":"https://file.aicenyi.com/iconea34f012-f59d-42f2-b19c-3d6454656bf81548999770618.jpg","tel":"18156890268","state":1,"longitude":106.59309,"latitude":29.58448,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":49,"communityName":"龙湖春森彼岸","communityAddress":"江北区北滨一路258号","sortNum":0,"description":"社区代理:杨秀洁","logoUrl":"https://file.aicenyi.com/icon082475a5-ec61-44c1-b9b0-9822796707e71548999782132.jpg","tel":"13883149715","state":1,"longitude":106.54835,"latitude":29.570518,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":50,"communityName":"国际社区海悦府","communityAddress":"南岸区福民路39号","sortNum":0,"description":"社区代理:孙鹏鹏","logoUrl":"https://file.aicenyi.com/iconf5f4dae0-b99f-41ef-b5f9-afb450e0f1731548999843935.jpg","tel":"18862492037","state":1,"longitude":106.59296,"latitude":29.59461,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":51,"communityName":"兰溪小区","communityAddress":"江北区海尔路181号","sortNum":0,"description":"社区代理:黄颖","logoUrl":"https://file.aicenyi.com/icon9d4301c0-d633-4691-bf70-2204cf73861c1548999936273.jpg","tel":"15223173722","state":1,"longitude":106.57405,"latitude":29.6101,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":52,"communityName":"富力现代广场","communityAddress":"南岸区石新街59号","sortNum":0,"description":"社区代理:吴双","logoUrl":"https://file.aicenyi.com/icon2e77f81a-c765-4af0-a9f8-8b642ec0231d1549001134236.jpg","tel":"18983897745","state":1,"longitude":106.59872,"latitude":29.5803,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":53,"communityName":"巨龙江山国际","communityAddress":"江北区和煦路30号","sortNum":0,"description":"社区代理:郭成","logoUrl":"https://file.aicenyi.com/icon53e594e5-14c3-4305-b739-9797897660ec1549000171336.jpg","tel":"13635492201","state":1,"longitude":106.76735,"latitude":29.62507,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":54,"communityName":"国际社区观园","communityAddress":"南岸区福民路38号","sortNum":0,"description":"社区代理:吴莉","logoUrl":"https://file.aicenyi.com/icon14d4f275-45b1-40dd-b6d1-24e384370d581549000422448.jpg","tel":"18977654347","state":1,"longitude":106.59471,"latitude":29.59769,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":7,"communityName":"天龙广场三期","communityAddress":"南坪宏声路35号","sortNum":0,"description":"社区代理:张波","logoUrl":"https://file.aicenyi.com/icon878380e6-d580-401a-974a-ed46fce525a21549000603401.jpg","tel":"13827658820","state":1,"longitude":106.570107,"latitude":29.531195,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":6,"communityName":"珊瑚水岸","communityAddress":"重庆市南岸区南滨路28号","sortNum":0,"description":"社区代理:王浩","logoUrl":"https://file.aicenyi.com/icon69e2c5ee-2c85-4e83-adb2-5506209866c51548924684091.jpg","tel":"13883345634","state":1,"longitude":106.57493,"latitude":29.53985,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":55,"communityName":"银翔翡翠谷","communityAddress":"南岸区兴塘路2号","sortNum":0,"description":"社区代理:李静","logoUrl":"https://file.aicenyi.com/icon69fcc186-4cf8-4c6e-9d5d-4d1b90b5590f1549000494111.jpg","tel":"15167890368","state":1,"longitude":106.650303,"latitude":29.507731,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":57,"communityName":"鲁能领秀城骏峰","communityAddress":"南岸区天文大道35号","sortNum":0,"description":"社区代理:刘玉栋","logoUrl":"https://file.aicenyi.com/icon74b8cd80-73bd-4d4a-8409-9dc23031aada1549000377561.jpg","tel":"15190870045","state":1,"longitude":106.64206,"latitude":29.51047,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":58,"communityName":"江南小区","communityAddress":"南岸区广福大道与莲池路交口","sortNum":0,"description":"社区代理:李贤玉","logoUrl":"https://file.aicenyi.com/iconfcfa70cd-2fc5-456c-8a35-5010fe6631711549002078976.jpg","tel":"15178903596","state":1,"longitude":106.636793,"latitude":29.493267,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":61,"communityName":"金果园小区","communityAddress":"江北区金果园1号","sortNum":0,"description":"社区代理:刘志国","logoUrl":"https://file.aicenyi.com/icon497528fd-b0b1-41c4-9282-3ce37b5340c91549000098549.jpg","tel":"17772327632","state":1,"longitude":106.48867,"latitude":29.57986,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":63,"communityName":"鑫茂源E时代","communityAddress":"南岸区青龙路36号","sortNum":0,"description":"社区代理:高翔","logoUrl":"https://file.aicenyi.com/icon967919c1-83f8-46b0-a2cf-6c4a391936bc1548999849481.jpg","tel":"18937790254","state":1,"longitude":106.57293,"latitude":29.513344,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":64,"communityName":"华宇北国风光","communityAddress":"江北区北滨一路476号","sortNum":0,"description":"社区代理:赖维","logoUrl":"https://file.aicenyi.com/icon1998f38e-07dc-4d63-aeef-0ba096a579ec1548999798702.jpg","tel":"18623504577","state":1,"longitude":106.5093,"latitude":29.55948,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":65,"communityName":"阳光100国际新城两江壹号","communityAddress":"南岸区野猫溪正街1号","sortNum":0,"description":"社区代理:郭宏","logoUrl":"https://file.aicenyi.com/icon5081de51-a9b5-4cf3-a586-6cd5036679cb1548999762080.jpg","tel":"18783972276","state":1,"longitude":106.59103,"latitude":29.5737,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":66,"communityName":"华润中央公园","communityAddress":"江北区北滨一路大石坝三村北","sortNum":0,"description":"社区代理:唐甜甜","logoUrl":"https://file.aicenyi.com/icona64570c7-c845-4573-aa3d-f3d3afcb4bf41548999641176.jpg","tel":"13618305486","state":1,"longitude":106.4976,"latitude":29.56108,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":67,"communityName":"东海星洲","communityAddress":"南岸区涂山路580号","sortNum":0,"description":"社区代理:黎莉","logoUrl":"https://file.aicenyi.com/iconab84847b-690e-4c89-a94c-e76532a73e861548999563209.jpg","tel":"15199813548","state":1,"longitude":106.60388,"latitude":29.57799,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":69,"communityName":"金港尚城","communityAddress":"南岸区腾黄路","sortNum":0,"description":"社区代理:宋玉","logoUrl":"https://file.aicenyi.com/icon6d0bac37-1098-4450-957b-0673c01b4f5d1548999489713.jpg","tel":"13689007656","state":1,"longitude":106.604554,"latitude":29.596408,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":70,"communityName":"海尔海语江山","communityAddress":"江北区海尔路","sortNum":0,"description":"社区代理:刘杰","logoUrl":"https://file.aicenyi.com/icone8ea9722-6d31-4a45-919b-18475c0c12231548999444982.jpg","tel":"15922966682","state":1,"longitude":106.513126,"latitude":29.558468,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":59,"communityName":"金科10年城","communityAddress":"江北区石马河街道石子山村原坪上社(堰塘湾社D宗)","sortNum":0,"description":"社区代理:甘科龙","logoUrl":"https://file.aicenyi.com/icona165b0db-64e1-4367-aed3-2e64872917261549000274278.jpg","tel":"15523866631","state":1,"longitude":106.48304,"latitude":29.607682,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":71,"communityName":"和泓南山道","communityAddress":"南岸区海棠溪敦厚街36号(江南体育中心旁)","sortNum":0,"description":"社区代理:钱俊","logoUrl":"https://file.aicenyi.com/icon910aece3-a586-4a79-b652-7f7343defbfc1548998915538.jpg","tel":"13635570967","state":1,"longitude":106.58779,"latitude":29.54036,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":60,"communityName":"巨成龙湾","communityAddress":"南岸区青龙路8号","sortNum":0,"description":"社区代理:陈红","logoUrl":"https://file.aicenyi.com/icon8396175a-4f77-453d-bd1c-51e4c6ec57071549000236616.jpg","tel":"15199082698","state":1,"longitude":106.558402,"latitude":29.512291,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":72,"communityName":"山与城","communityAddress":"南岸区黄桷垭黄沙坎广黔路与福寿路交口附近(重庆邮电大学与老厂道路之间)","sortNum":0,"description":"社区代理:李蓉","logoUrl":"https://file.aicenyi.com/icon8a8d7373-db44-46bc-8188-1f92dc96c0351548998855454.jpg","tel":"13899876740","state":1,"longitude":106.594553,"latitude":29.501587,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":79,"communityName":"和泓江山国际","communityAddress":"渝中区和泓江山国际小区和复旦中学分校之间东北方向84米","sortNum":0,"description":"社区代理:周偶","logoUrl":"https://file.aicenyi.com/icon80a57e95-2cda-4a4f-8d9a-9955afabf2bd1548998026822.jpg","tel":"13908073326","state":1,"longitude":106.52759,"latitude":29.54136,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":43,"communityName":"中国核建紫金一品","communityAddress":"南岸区腾龙大道4号正南方向135米","sortNum":0,"description":"社区代理:赵宝庆","logoUrl":"https://file.aicenyi.com/iconaea15c82-05e7-4a65-9fb7-cc2c0e59998e1548999137477.jpg","tel":"15666789347","state":1,"longitude":106.59637,"latitude":29.58474,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":80,"communityName":"国奥村时光漫","communityAddress":"江北区国惠路15号","sortNum":0,"description":"社区代理:李玲","logoUrl":"https://file.aicenyi.com/icond8a9fcc6-c06a-4cbd-a17a-8497b676b9d91548997968833.jpg","tel":"15608331314","state":1,"longitude":106.459473,"latitude":29.590693,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":5,"communityName":"新欧鹏教育城","communityAddress":"江北区江北嘴鲁溉路(中央公园旁)","sortNum":0,"description":"社区代理:尹国红","logoUrl":"https://file.aicenyi.com/iconbb2ee733-51d1-480e-b94a-9621c00f86c31548925475954.jpg","tel":"17726638949","state":1,"longitude":106.5732,"latitude":29.59,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":81,"communityName":"嘉华鑫城","communityAddress":"渝中区大坪正街118号","sortNum":0,"description":"社区代理:周鹏","logoUrl":"https://file.aicenyi.com/icon13de5b52-93af-43b4-9651-ef03402685e21548997824322.jpg","tel":"13900457902","state":1,"longitude":106.51187,"latitude":29.54142,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":42,"communityName":"绿地保税中心","communityAddress":"江北区金渝大道138号","sortNum":0,"description":"社区代理:朱恬恬","logoUrl":"https://file.aicenyi.com/icon84e798a9-e8f3-4c51-a63e-ea12cf7e0d811548999062750.jpg","tel":"18623161572","state":1,"longitude":106.582779,"latitude":29.620691,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":44,"communityName":"龙湖源著南区","communityAddress":"江北区福泉路26号","sortNum":0,"description":"社区代理:雷莹","logoUrl":"https://file.aicenyi.com/icona72671af-521e-464f-8fe1-650fe554ba7f1548999220114.jpg","tel":"13541874210","state":1,"longitude":106.48704,"latitude":29.59983,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":86,"communityName":"光华可乐小镇","communityAddress":"江北区福居路12号","sortNum":0,"description":"社区代理:冯军","logoUrl":"https://file.aicenyi.com/icon8a688d6c-b2cb-43f2-bd6c-b76013f17c3f1548996595357.jpg","tel":"13692228745","state":1,"longitude":106.483856,"latitude":29.593225,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":83,"communityName":"国奥村","communityAddress":"江北区宏帆路西","sortNum":0,"description":"社区代理:蒲慧琳","logoUrl":"https://file.aicenyi.com/icon9808851b-56e9-4163-bb85-59bba174e4131548996316147.jpg","tel":"18613061312","state":1,"longitude":106.461088,"latitude":29.592597,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":62,"communityName":"金阳罗马假日","communityAddress":"南岸区青龙路36号","sortNum":0,"description":"社区代理:高莉","logoUrl":"https://file.aicenyi.com/icon1ab8e522-48d9-47e5-a242-de4d3a2088281549000015018.jpg","tel":"15176453390","state":1,"longitude":106.56219,"latitude":29.51287,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":87,"communityName":"张家花园社区","communityAddress":"渝中区人和街与北区路交叉口南150米","sortNum":0,"description":"社区代理:肖强","logoUrl":"https://file.aicenyi.com/iconde6e6460-688f-47da-8266-55bb173392e21549001451234.jpg","tel":"15189902368","state":1,"longitude":106.559616,"latitude":29.562471,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":88,"communityName":"光华观府国际","communityAddress":"江北区华新路96号","sortNum":0,"description":"社区代理:石雨荷","logoUrl":"https://file.aicenyi.com/icon7c136b26-93b5-49e7-b1e5-5b5769568c631548996729726.jpg","tel":"15736156308","state":1,"longitude":106.53459,"latitude":29.567729,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":77,"communityName":"财信渝中城","communityAddress":"渝中区中山一路6号(七星岗车站旁)","sortNum":0,"description":"社区代理:鲍莉","logoUrl":"https://file.aicenyi.com/icon0c01e67f-bb44-406c-a2f5-f4e7064bc4051548998276482.jpg","tel":"13999876878","state":1,"longitude":106.566258,"latitude":29.555766,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":90,"communityName":"竹园小区","communityAddress":"渝中区交通街109号","sortNum":0,"description":"社区代理:吴美莉","logoUrl":"https://file.aicenyi.com/icon6673ed1e-0cf1-4cc1-81bf-5797f75c866d1548996934686.jpg","tel":"15697802683","state":1,"longitude":106.53113,"latitude":29.53771,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":85,"communityName":"书香苑","communityAddress":"渝中区华福巷53号","sortNum":0,"description":"社区代理:肖晓月","logoUrl":"https://file.aicenyi.com/icon6105c644-f4f1-48e8-a826-373faa85876f1548996514385.jpg","tel":"15988973458","state":1,"longitude":106.556033,"latitude":29.558934,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":91,"communityName":"中驰领寓","communityAddress":"渝中区解放东路72号","sortNum":0,"description":"社区代理:吴艳丽","logoUrl":"https://file.aicenyi.com/icon4796b9f6-8fa1-4972-b3b8-da72230c67331548997002727.jpg","tel":"15998372651","state":1,"longitude":106.58397,"latitude":29.55667,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":78,"communityName":"江屿朗廷","communityAddress":"渝中区菜袁路168号","sortNum":0,"description":"社区代理:林峰","logoUrl":"https://file.aicenyi.com/icon5c6add0c-7815-40ec-90cd-ede3432ea5ff1548998120719.jpg","tel":"13976885798","state":1,"longitude":106.52816,"latitude":29.537038,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":92,"communityName":"华一坡社区","communityAddress":"渝中区华一坡33正东方向114米","sortNum":0,"description":"社区代理:冯唐","logoUrl":"https://file.aicenyi.com/icon288a21df-1acd-42f9-89ba-c25e01d2d31f1549002333638.jpg","tel":"15968016672","state":1,"longitude":106.56667,"latitude":29.55817,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":74,"communityName":"奥园康城","communityAddress":"渝中区黄杨路6号","sortNum":0,"description":"社区代理:王志","logoUrl":"https://file.aicenyi.com/icon1a69cdc8-ed7a-4d8c-991c-d5148ebaf9f71548998485571.jpg","tel":"13877804798","state":1,"longitude":106.52369,"latitude":29.53013,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":84,"communityName":"兰波红城丽景","communityAddress":"渝中区大坪长江二路39号附18号","sortNum":0,"description":"社区代理:王银","logoUrl":"https://file.aicenyi.com/icon80e0ffd6-466b-4114-8f89-3af30a72e7c11548996465821.jpg","tel":"13998875645","state":1,"longitude":106.52543,"latitude":29.53938,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":93,"communityName":"凤凰湾","communityAddress":"江北区宏帆路28号","sortNum":0,"description":"社区代理:刘林","logoUrl":"https://file.aicenyi.com/icon802931e6-264c-4580-93e6-eda3f29519941548991899825.jpg","tel":"15123217856","state":1,"longitude":106.468785,"latitude":29.596505,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":94,"communityName":"天官府小区","communityAddress":"渝中区金汤街79西北方向141米","sortNum":0,"description":"社区代理:唐涛","logoUrl":"https://file.aicenyi.com/icon67dffa75-ba23-44d9-940d-c2e50b52f3eb1549002828062.jpg","tel":"15977013690","state":1,"longitude":106.56686,"latitude":29.55245,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":75,"communityName":"华宇·渝州新都","communityAddress":"渝中区大坪正街140号","sortNum":0,"description":"社区代理:鲍成风","logoUrl":"https://file.aicenyi.com/icondcd0e935-91ef-421d-a1e5-41523452557c1548998401348.jpg","tel":"13809015578","state":1,"longitude":106.50787,"latitude":29.53902,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":95,"communityName":"互助里小区","communityAddress":"渝中区互助里43号","sortNum":0,"description":"社区代理:王立忠","logoUrl":"https://file.aicenyi.com/iconc4659541-4824-4821-84e9-0e53fce46e271548927974177.jpg","tel":"15905534809","state":1,"longitude":106.545944,"latitude":29.556959,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":76,"communityName":"国兴北岸江山","communityAddress":"江北区观音桥江北观音桥北滨一路456号(鸿恩寺公园旁)","sortNum":0,"description":"社区代理:王渊","logoUrl":"https://file.aicenyi.com/icona9aa76f1-97c1-4f35-bd6a-1fcb3b3bc0541548998339435.jpg","tel":"15029903288","state":1,"longitude":106.51767,"latitude":29.55939,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":96,"communityName":"桂花园","communityAddress":"渝中区新桂花园位于重庆市渝中区桂花园62号","sortNum":0,"description":"社区代理:卫清茗","logoUrl":"https://file.aicenyi.com/icon4312e646-1889-44b0-997e-7b958e0064941548927930059.jpg","tel":"15185670091","state":1,"longitude":106.542198,"latitude":29.555485,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":73,"communityName":"恒大名都","communityAddress":"渝中区石油路1号","sortNum":0,"description":"社区代理:王志峰","logoUrl":"https://file.aicenyi.com/iconc893b781-c1fd-49f2-a348-b50a9537b8721548998544883.jpg","tel":"13833586787","state":1,"longitude":106.506302,"latitude":29.542244,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":56,"communityName":"锦绣嘉陵","communityAddress":"江北区宁福路101号","sortNum":0,"description":"社区代理:郝倩","logoUrl":"https://file.aicenyi.com/icon45ab50e4-45cb-4a0d-881c-4f89189309c81549000452791.jpg","tel":"19923096976","state":1,"longitude":106.51809,"latitude":29.56238,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":98,"communityName":"东原D7区","communityAddress":"江北区鸿恩寺红石路段(大石坝公交站点旁)","sortNum":0,"description":"社区代理:李婷","logoUrl":"https://file.aicenyi.com/icon498588ec-ae75-473e-97f6-70f238daad5d1548927573291.jpg","tel":"13956232456","state":1,"longitude":106.496817,"latitude":29.568816,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":89,"communityName":"时代豪苑","communityAddress":"渝中区青年路3号","sortNum":0,"description":"社区代理:杨萍","logoUrl":"https://file.aicenyi.com/icon79f97e28-0ec9-43eb-aef9-6bb148324a471548996797092.jpg","tel":"15813557983","state":1,"longitude":106.57702,"latitude":29.55805,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":82,"communityName":"海客瀛洲","communityAddress":"渝中区长江滨江路20号","sortNum":0,"description":"社区代理:洪流海","logoUrl":"https://file.aicenyi.com/iconc469c4b1-921f-4043-968c-59dfebd585e61548991989289.jpg","tel":"13888475698","state":1,"longitude":106.58836,"latitude":29.56215,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":100,"communityName":"保利江上明珠乐园","communityAddress":"江北区三湾路西100米","sortNum":0,"description":"社区代理:王锐","logoUrl":"https://file.aicenyi.com/icon624cc2cf-d48d-4293-b013-2a01369a05a41548927206658.jpg","tel":"13324598532","state":1,"longitude":106.515059,"latitude":29.568468,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":97,"communityName":"东原D8公馆","communityAddress":"江北区大石坝鸿恩寺红石路段(大石坝公交站点旁)","sortNum":0,"description":"社区代理:吴霞","logoUrl":"https://file.aicenyi.com/icon6220a712-93ef-4fed-879a-94fc286451621548927767836.jpg","tel":"13635492103","state":1,"longitude":106.49412,"latitude":29.56906,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":101,"communityName":"保利江上明珠锦园","communityAddress":"江北区鸿恩路鸿恩寺森林公园东侧","sortNum":0,"description":"社区代理:魏杰","logoUrl":"https://file.aicenyi.com/icon0d4cf932-2d15-4064-86e2-2b86bc5f6afa1548927104223.jpg","tel":"13884567821","state":1,"longitude":106.511474,"latitude":29.568763,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":102,"communityName":"半山华府","communityAddress":"江北区兴竹路21号","sortNum":0,"description":"社区代理:唐宇","logoUrl":"https://file.aicenyi.com/icon8a74bd36-e8c2-42cf-87c5-7af327527e191548926811210.jpg","tel":"15745936592","state":1,"longitude":106.524234,"latitude":29.562338,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":68,"communityName":"东海长洲","communityAddress":"南岸区涂山路滨江实验学校东侧","sortNum":0,"description":"社区代理:孙杨","logoUrl":"https://file.aicenyi.com/icon65a939a2-7339-449c-94f6-851f9448e5cb1549001539170.jpg","tel":"15107496687","state":1,"longitude":106.60195,"latitude":29.57491,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":30,"communityName":"庆业巴蜀城","communityAddress":"江北区海尔路6号","sortNum":0,"description":"社区代理:屈章文","logoUrl":"https://file.aicenyi.com/iconeb30e114-bcd8-47b8-903c-3e43048e79571548997971800.jpg","tel":"13330251575","state":1,"longitude":106.56246,"latitude":29.58841,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":28,"communityName":"康德国会山","communityAddress":"南坪东路辅仁路8号","sortNum":0,"description":"社区代理:刘恋","logoUrl":"https://file.aicenyi.com/icon2378a7ff-1bdd-4d16-baa2-e57ea738baf51548997808410.jpg","tel":"13676754431","state":1,"longitude":106.57775,"latitude":29.52772,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":99,"communityName":"东海岸","communityAddress":"江北区下石门618号","sortNum":0,"description":"社区代理:赵飞","logoUrl":"https://file.aicenyi.com/icone27dc299-4fd9-4115-89b0-82cdde567aa91548927355355.jpg","tel":"13266541286","state":1,"longitude":106.484215,"latitude":29.563203,"del":0,"returnPercentage":1000,"openId":null,"wechatLogin":-1,"areaCode":null,"distance":0},{"id":3,"communityName":"中亿阳明山水","communityAddress":"江北区海尔路179号","sortNum":1,"description":"社区代理:刘月","logoUrl":"https://file.aicenyi.com/icon9a5d049b-a9c1-4e91-bdb2-dd80ca696f491548925152102.jpg","tel":"15683334374","state":1,"longitude":106.56867,"latitude":29.60748,"del":0,"returnPercentage":1000,"openId":"oCZVp1Cbrtd_BOHE_uhpPd11gpvY","wechatLogin":0,"areaCode":null,"distance":0},{"id":2,"communityName":"紫御江山","communityAddress":"江北区北滨二路537号(北滨二路,朝天门大桥旁)","sortNum":1,"description":"社区代理:郑胜中","logoUrl":"https://file.aicenyi.com/iconcc8c1f63-0bb8-4dba-8de0-50bf83c12b151548925059245.jpg","tel":"17318213273","state":1,"longitude":106.54541,"latitude":29.52567,"del":0,"returnPercentage":1000,"openId":"oCZVp1BGH0X_qo8C9h0FG9nlCrxM","wechatLogin":0,"areaCode":null,"distance":0},{"id":8,"communityName":"星宇花园","communityAddress":"南坪东路11号","sortNum":0,"description":"社区代理:张伯","logoUrl":"https://file.aicenyi.com/iconbf2699e2-f7ba-416b-b319-1a557cf9de171548924806365.jpg","tel":"13877632190","state":1,"longitude":106.571002,"latitude":29.529924,"del":0,"returnPercentage":1000,"openId":"oCZVp1Cbrtd_BOHE_uhpPd11gpvY","wechatLogin":0,"areaCode":null,"distance":0}]
         * orderInfo : null
         */

        private CartInfoCollectionBean cartInfoCollection;
        private ShopInfoBean shopInfo;
        private Object orderInfo;
        private List<CommunityInfoListBean> communityInfoList;

        public CartInfoCollectionBean getCartInfoCollection() {
            return cartInfoCollection;
        }

        public void setCartInfoCollection(CartInfoCollectionBean cartInfoCollection) {
            this.cartInfoCollection = cartInfoCollection;
        }

        public ShopInfoBean getShopInfo() {
            return shopInfo;
        }

        public void setShopInfo(ShopInfoBean shopInfo) {
            this.shopInfo = shopInfo;
        }

        public Object getOrderInfo() {
            return orderInfo;
        }

        public void setOrderInfo(Object orderInfo) {
            this.orderInfo = orderInfo;
        }

        public List<CommunityInfoListBean> getCommunityInfoList() {
            return communityInfoList;
        }

        public void setCommunityInfoList(List<CommunityInfoListBean> communityInfoList) {
            this.communityInfoList = communityInfoList;
        }

        public static class CartInfoCollectionBean implements Serializable{
            /**
             * totalCount : 1
             * entityList : [{"id":1750,"customerId":2,"shopId":1,"goodsId":894,"buyNum":1,"addTime":1568887580000,"updateTime":1568887580000,"goodsName":"广式香肠500g±20g","price":1880,"totalPrice":1880,"resultPrice":0,"specifications":"件","logoUrl":"https://file.aicenyi.com/iconf3b20d8d-b328-4db8-a739-c1fea3a458871549005366028.jpg"}]
             */

            private int totalCount;
            private List<EntityListBean> entityList;

            public int getTotalCount() {
                return totalCount;
            }

            public void setTotalCount(int totalCount) {
                this.totalCount = totalCount;
            }

            public List<EntityListBean> getEntityList() {
                return entityList;
            }

            public void setEntityList(List<EntityListBean> entityList) {
                this.entityList = entityList;
            }

            public static class EntityListBean implements Serializable {
                /**
                 * id : 1750
                 * customerId : 2
                 * shopId : 1
                 * goodsId : 894
                 * buyNum : 1
                 * addTime : 1568887580000
                 * updateTime : 1568887580000
                 * goodsName : 广式香肠500g±20g
                 * price : 1880
                 * totalPrice : 1880
                 * resultPrice : 0
                 * specifications : 件
                 * logoUrl : https://file.aicenyi.com/iconf3b20d8d-b328-4db8-a739-c1fea3a458871549005366028.jpg
                 */

                private int id;
                private int customerId;
                private int shopId;
                private int goodsId;
                private int buyNum;
                private long addTime;
                private long updateTime;
                private String goodsName;
                private int price;
                private int totalPrice;
                private int resultPrice;
                private String specifications;
                private String logoUrl;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getCustomerId() {
                    return customerId;
                }

                public void setCustomerId(int customerId) {
                    this.customerId = customerId;
                }

                public int getShopId() {
                    return shopId;
                }

                public void setShopId(int shopId) {
                    this.shopId = shopId;
                }

                public int getGoodsId() {
                    return goodsId;
                }

                public void setGoodsId(int goodsId) {
                    this.goodsId = goodsId;
                }

                public int getBuyNum() {
                    return buyNum;
                }

                public void setBuyNum(int buyNum) {
                    this.buyNum = buyNum;
                }

                public long getAddTime() {
                    return addTime;
                }

                public void setAddTime(long addTime) {
                    this.addTime = addTime;
                }

                public long getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(long updateTime) {
                    this.updateTime = updateTime;
                }

                public String getGoodsName() {
                    return goodsName;
                }

                public void setGoodsName(String goodsName) {
                    this.goodsName = goodsName;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public int getTotalPrice() {
                    return totalPrice;
                }

                public void setTotalPrice(int totalPrice) {
                    this.totalPrice = totalPrice;
                }

                public int getResultPrice() {
                    return resultPrice;
                }

                public void setResultPrice(int resultPrice) {
                    this.resultPrice = resultPrice;
                }

                public String getSpecifications() {
                    return specifications;
                }

                public void setSpecifications(String specifications) {
                    this.specifications = specifications;
                }

                public String getLogoUrl() {
                    return logoUrl;
                }

                public void setLogoUrl(String logoUrl) {
                    this.logoUrl = logoUrl;
                }
            }
        }

        public static class ShopInfoBean implements Serializable{
            /**
             * id : 1
             * shopName : 两路口核销店
             * shopTel : 18122222222
             * shopAddress : 两路口地铁站附近
             * cityId : 500000
             * districtId : 0
             * shopLogoUrl : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1563536200243&di=e02853590a5836a27ac7df4f95521913&imgtype=0&src=http%3A%2F%2Fimgup04.iefans.net%2Fiefans%2F2019-02%2F11%2F11%2F15498570716693_1.jpg
             * longitude : 106.54863
             * latitude : 29.552567
             * userId : 3
             * typeId : 2
             * classId : 0
             * remark : 店铺介绍
             * crateTime : 1563527315000
             * state : 1
             * salesVolume : 0
             * shopNature : 1
             * selfShop : 0
             * openTime : 8:00-22:00
             */

            private int id;
            private String shopName;
            private String shopTel;
            private String shopAddress;
            private int cityId;
            private int districtId;
            private String shopLogoUrl;
            private double longitude;
            private double latitude;
            private int userId;
            private int typeId;
            private int classId;
            private String remark;
            private long crateTime;
            private int state;
            private int salesVolume;
            private int shopNature;
            private int selfShop;
            private String openTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getShopTel() {
                return shopTel;
            }

            public void setShopTel(String shopTel) {
                this.shopTel = shopTel;
            }

            public String getShopAddress() {
                return shopAddress;
            }

            public void setShopAddress(String shopAddress) {
                this.shopAddress = shopAddress;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public int getDistrictId() {
                return districtId;
            }

            public void setDistrictId(int districtId) {
                this.districtId = districtId;
            }

            public String getShopLogoUrl() {
                return shopLogoUrl;
            }

            public void setShopLogoUrl(String shopLogoUrl) {
                this.shopLogoUrl = shopLogoUrl;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getTypeId() {
                return typeId;
            }

            public void setTypeId(int typeId) {
                this.typeId = typeId;
            }

            public int getClassId() {
                return classId;
            }

            public void setClassId(int classId) {
                this.classId = classId;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public long getCrateTime() {
                return crateTime;
            }

            public void setCrateTime(long crateTime) {
                this.crateTime = crateTime;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getSalesVolume() {
                return salesVolume;
            }

            public void setSalesVolume(int salesVolume) {
                this.salesVolume = salesVolume;
            }

            public int getShopNature() {
                return shopNature;
            }

            public void setShopNature(int shopNature) {
                this.shopNature = shopNature;
            }

            public int getSelfShop() {
                return selfShop;
            }

            public void setSelfShop(int selfShop) {
                this.selfShop = selfShop;
            }

            public String getOpenTime() {
                return openTime;
            }

            public void setOpenTime(String openTime) {
                this.openTime = openTime;
            }
        }

        public static class CommunityInfoListBean implements Serializable{
            /**
             * id : 9
             * communityName : 天龙城市花园
             * communityAddress : 南坪正街1号
             * sortNum : 0
             * description : 社区代理:张薇
             * logoUrl : https://file.aicenyi.com/icon5658d531-2a33-4cb4-9adc-ee4934a2bafb1549000795342.jpg
             * tel : 13965784967
             * state : 1
             * longitude : 106.568283
             * latitude : 29.530665
             * del : 0
             * returnPercentage : 1000
             * openId : null
             * wechatLogin : -1
             * areaCode : null
             * distance : 0
             */

            private int id;
            private String communityName;
            private String communityAddress;
            private int sortNum;
            private String description;
            private String logoUrl;
            private String tel;
            private int state;
            private double longitude;
            private double latitude;
            private int del;
            private int returnPercentage;
            private Object openId;
            private int wechatLogin;
            private Object areaCode;
            private int distance;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getCommunityName() {
                return communityName;
            }

            public void setCommunityName(String communityName) {
                this.communityName = communityName;
            }

            public String getCommunityAddress() {
                return communityAddress;
            }

            public void setCommunityAddress(String communityAddress) {
                this.communityAddress = communityAddress;
            }

            public int getSortNum() {
                return sortNum;
            }

            public void setSortNum(int sortNum) {
                this.sortNum = sortNum;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getLogoUrl() {
                return logoUrl;
            }

            public void setLogoUrl(String logoUrl) {
                this.logoUrl = logoUrl;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public int getDel() {
                return del;
            }

            public void setDel(int del) {
                this.del = del;
            }

            public int getReturnPercentage() {
                return returnPercentage;
            }

            public void setReturnPercentage(int returnPercentage) {
                this.returnPercentage = returnPercentage;
            }

            public Object getOpenId() {
                return openId;
            }

            public void setOpenId(Object openId) {
                this.openId = openId;
            }

            public int getWechatLogin() {
                return wechatLogin;
            }

            public void setWechatLogin(int wechatLogin) {
                this.wechatLogin = wechatLogin;
            }

            public Object getAreaCode() {
                return areaCode;
            }

            public void setAreaCode(Object areaCode) {
                this.areaCode = areaCode;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }
        }
    }
}

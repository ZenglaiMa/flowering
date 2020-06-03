/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50615
 Source Host           : localhost:3306
 Source Schema         : flowering

 Target Server Type    : MySQL
 Target Server Version : 50615
 File Encoding         : 65001

 Date: 03/06/2020 11:18:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `overview` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `reading_num` int(11) NULL DEFAULT NULL,
  `type_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '向日葵的奥秘', '/article-img/z_1.jpg', '<!DOCTYPE html>\n<html>\n<head>\n    <title></title>\n</head>\n<body>\n    <img src=\"http://192.168.1.109:8080/article-img/z_1.jpg\" width=\"100%\">\n    <h3>向日葵的别称</h3>\n    <p>向日葵是菊科的一年生草本植物，别称有“朝阳花”、“望日莲”和“太阳花”等。<br/>向日葵的原产地 是南美洲，目前在欧洲、俄罗斯、中国等世界各地都有种植。</p>\n    <h3>向日葵的形态特征</h3>\n    <p>向日葵的茎为粗壮的直立茎，整体呈多棱角的圆形，生有白色的粗硬毛。<br/>向日葵的叶子一般为互生，形状一般为卵圆形或是心状的卵形，叶片两面都生有粗糙的毛。<br/>向日葵的花序为极大的头状，单生在枝的端部或者茎的顶部，通常开时会有下倾。<br/>向日葵的果实为倒卵形或卵状长圆形的瘦果，即“葵花籽”，木质化的果皮呈黑色或灰色。</p>\n    <img src=\"http://192.168.1.109:8080/article-img/z_2.jpg\" width=\"100%\">\n    <h3>向日葵的生长习性</h3>\n    <p>    一年四季均能对向日葵进行栽种，在夏冬两季最好。向日葵的生长速度很快，从种下到开花一般只需2个月左右，最长的花期时间约在两周以上。</p>\n    <img src=\"http://192.168.1.109:8080/article-img/z_3.jpg\" class=\"imgType\" width=\"100%\">\n    <h3>向日葵的价值用途</h3>\n    <p>    食用价值：因为向日葵的种子内含有大量的油，因此有着很高的食用价值，是一种很好的油料作物，榨油和炒食均可。<br/>\n    药用价值：向日葵植株的很多部分都可入药使用，有着清热化痰、疏风解毒和利湿止痛等多种功效。<br/>\n    净化价值：向日葵有着修复土壤的绿化功能，它的根系在吸收养分的同时还能提取土壤中的有害污染物。</p>\n</body>\n</html>', '神秘的向日葵，为太阳而生', NULL, 61, 1);
INSERT INTO `article` VALUES (2, '姜花，你喜欢吗', '/article-img/z_4.jpg', '<!DOCTYPE html>\n<html>\n<head>\n    <title></title>\n</head>\n<body>\n    <img src=\"http://192.168.1.109:8080/article-img/z_4.jpg\" width=\"100%\">\n    <h3>姜花的别称</h3>\n    <p>姜花又名蝴蝶姜、蝴蝶花、夜寒苏、香雪花、姜兰花、穗花山奈，姜黄等。<br/>姜花的形态特征 姜花茎可高达两米。其叶片长为披针形或长圆披针形，约长20-40厘</p>\n    <h3>姜花的形态特征</h3>\n    <p>姜花茎可高达两米。其叶片长为披针形或长圆披针形，约长20-40厘米，顶部渐尖生长，根基急尖，叶表面光滑有光泽，带有长2-3厘米的叶舌。<br>\n       顶部花生长有序，呈椭圆形，约长不足20厘米；苞片为卵圆形，每一苞片约花开3朵；倒心形的唇瓣，6厘米左右长宽。花丝长3厘米左右，花药室长约1.5厘米。</p>\n    <h3>姜花的花语</h3>\n    <p>将记忆永远留在夏天。<br>\n        它是巨蟹座的守护花朵，居家的幸福感。<br>\n        原产于印度，只有一天的寿命，如蝴蝶般飘陨。<br>\n        芳香沁人，所有绚丽的颜色都淡出。<br>\n        由爱到情：爱一个人最好的状态就是将记忆留在夏天。<br>\n        生命如此，在特定的时间邂逅特定的你，这或许就是人生的幸福。<br>\n        爱花的恬淡，它的与世无争，以此情有独钟。</p><br>\n    <img src=\"http://192.168.1.109:8080/article-img/z_5.jpg\" class=\"imgType\" width=\"100%\">\n</body>\n</html>\n', '姜花：它是巨蟹座的守护花朵，居家的幸福感。', NULL, 16, 2);
INSERT INTO `article` VALUES (3, '你养过琉璃翠吗', '/article-img/z_6.jpg', '<!DOCTYPE html>\n<html>\n<head>\n    <title></title>\n</head>\n<body>\n    <img src=\"http://192.168.1.109:8080/article-img/z_6.jpg\" width=\"100%\">\n    <h3>玻璃翠的培植</h3>\n    <p>培养土可选用腐叶土、园土和粗沙以1:1:1的比例混合，并施入少量豆饼为基肥。</p>\n    <h3>浇水</h3>\n    <p>玻璃翠性喜湿润，畏气候干燥。生长期间除了适当浇水外，要保持较高的空气湿度。<br>为此，可经常用清水向叶面喷雾，特别是在夏天，每天早、晚都应用水喷洗枝叶，同时向花盆四周洒水，以提高空气湿度、降低温度。在整个生长过程中，一旦空气过于干燥，叶片即失去光泽、不舒展，严重时叶柄也卷曲。</p>\n    <h3>光照、温度</h3>\n    <p>夏季要适当遮阴，避免强光直晒。如果过度阴蔽或施肥水过足，易引起茎叶徒长，导致倒伏。<br>\n       冬季移入室内，放置窗台阳光充足处养护。保持室温13-16℃、盆土微潮润，每隔5-7天用与室温接近的温水喷洗枝叶1次；空气干燥时也要经常用水喷雾，以增加空气湿度，只有这样，才能保持玻璃翠叶片翠嫩、花朵鲜艳。<br>\n       玻璃翠在整个生长发育过程中，每7天左右最好转动花盆1次，使植株各部分受光均匀、株型美观。</p><br>\n    <img src=\"http://192.168.1.109:8080/article-img/z_7.jpg\" class=\"imgType\" width=\"100%\">\n</body>\n</html>\n', '琉璃翠：翠绿为何而生', NULL, 19, 1);
INSERT INTO `article` VALUES (4, '百子莲的秘密', '/article-img/z_8.jpg', '<!DOCTYPE html>\n<html>\n<head>\n    <title></title>\n</head>\n<body>\n    <img src=\"http://192.168.1.109:8080/article-img/z_8.jpg\">\n    <h3>培植</h3>\n    <p>百子莲栽培宜用园土3份、砻糠灰和堆肥各1份混合使用。</p>\n    <h3>浇水</h3>\n    <p>浇水浇水以湿润为度，见干见湿，夏季尤要注意保证给予充足的水分，并要经常在植株及周围环境喷水增湿、降温。<br>冬季要注意控制浇水，保持盆土稍微湿润即可，不能多浇。</p>\n    <img src=\"http://192.168.1.109:8080/article-img/z_9.jpg\">\n    <h3>光照、温度</h3>\n    <p>养护宜放在半阴湿润处，6-9月要注意不让烈日直射，以免灼伤叶片。<br>\n        10月以后停止施肥，并在温度降至1-2℃时移入室内湿润处，保持0℃以上就可安全越冬。</p><br>\n    <h3>繁殖</h3>\n    <p>百子莲以分株繁殖为主，播种需5-6年才能开花，较少使用。<br>\n        分株可在春季翻盆时进行，但当年多不开花。秋季花后较为适宜，取分蘖种植，或将大株分为2-3丛，分开栽植。分株后要注意施肥灌水，放阴凉和通风良好处。</p>\n</body>\n</html>\n', '百子莲：呆在自己的小世界', NULL, 7, 3);
INSERT INTO `article` VALUES (5, '巴西木的养殖', '/article-img/z_10.jpg', '<!DOCTYPE html>\n<html>\n<head>\n    <title></title>\n</head>\n<body>\n    <img src=\"http://192.168.1.109:8080/article-img/z_10.jpg\">\n    <h3>培植</h3>\n    <p>盆栽巴西木常用12-20厘米口径盆，3个茎干的用25厘米口径盆。<br>\n        盆栽以腐叶土、培养土和粗沙的混合土最好。市场上盆栽巴西木多采用精沙土，有利于植株发根，但长期使用会因缺肥而不利于植物生长，必须换成以上配制的混合土。每年春季必须换盆，新株每年换盆1次，老株2年换盆1次。</p>\n    <h3>浇水</h3>\n    <p>巴西木对水分需求量少，浇水一般10天左右1次，盆土保持在半干半湿即可。浇水不宜过多，以防树干腐烂。<br>    此外，在北方莳养，由于气候干燥，应经常向叶面及周围地面喷水，提高周围的空气湿度，以利于巴西木的生长。</p>\n    <img src=\"http://192.168.1.109:8080/article-img/z_11.jpg\">\n    <h3>光照、温度</h3>\n    <p>巴西木生长适温为20-30℃。冬季10℃以上即可过冬，温度过低时会停止生长，且叶尖和叶缘会出现黄褐斑。<br>\n        巴西木较喜阴，在明亮的散射光处生长良好。夏季要避免直射光，宜置于阴凉处。秋、冬季时，放在室内阳光充足处即可。光照过少时，巴西木的叶片会呈灰绿色且条纹不清，基部叶片黄化，尤其是斑叶种类长期在低光照条件下，色彩会变浅或消失，从而失去观赏价值。</p>\n</body>\n</html>\n', '巴西木：和巴西有关吗', NULL, 10, 4);
INSERT INTO `article` VALUES (6, '君子兰：花中君子', '/article-img/z_12.jpg', '<!DOCTYPE html>\n<html>\n<head>\n    <title></title>\n</head>\n<body>\n    <img src=\"http://192.168.1.109:8080/article-img/z_12.jpg\">\n    <h3>适宜君子兰生长的土壤</h3>\n    <p>君子兰专用土不能直接用来种植栀子花，需要经过处理之后才能种植，否则栀子花会出现黄叶。<br>\n        君子兰属石蒜科君子兰属，是多年生常绿草本植物，它的叶片明亮有光泽，很有特色，从假鳞茎处分开，向两边生长，而且每片叶子排列整齐，有很高的观赏性；它的花朵花色鲜艳，花期长；它的果实成熟时呈红色，很是可爱。因此，君子兰是既可以观叶、观花，还可以观果的植物。那种植这么可爱的君子兰需要什么样的土壤呢？</p>\n    <p>种植君子兰需要选择疏松、肥沃、排水性良好的微酸性土壤，这种土壤比较适宜君子兰的生长。养植了十多年的君子兰，个人比较喜欢利用园土、松针腐叶土和河沙混合土配制君子兰土壤，上盆的时候在盆底铺一些风化的松果，或者适量的腐熟果皮，君子兰长势很好。<br>\n     当然，也有人觉得自己配制土壤太麻烦，或者没有其它土壤来配制，就直接买君子兰专用土，觉得用起来比较简单方便，而且土壤配制更专业。君子兰专用土基本都会选用珍珠岩、草炭土、发酵的树皮、蛭石、河沙等配制而成，其中发酵的树皮会含有腐殖质，虽然含有丰富的微量元素，但是酸性度不高，PH值在6—6.5之间，属于微酸性土壤。<br></p>\n     <img src=\"http://192.168.1.109:8080/article-img/z_13.jpg\">\n    <h3>适宜栀子花生长的土壤</h3>\n    栀子花是一种常绿灌木，原产于我国南方，也就是说适宜南方的酸性土壤，栀子花的花朵洁白，带着浓郁的香味，代表着美好与喜悦，而且栀子花还有净化空气的作用，很受花友的喜欢。\n    栀子花到了北方因为气候和土壤的关系，只能盆栽养植，配制的酸性土壤要肥沃、疏松、排水性好。栀子花在种植之前需要将土壤配制成酸性土壤，PH值在5—6之间，栀子花才不会因为酸性度不够而发生黄化病。\n    因此，个人觉得直接利用君子兰专用土来种植栀子花，酸性度还不够，会影响栀子花的生长、开花。如果想要用君子兰专用土种植栀子花，那就在使用之前在土壤中加入适量的堆肥、腐熟肥，或者用硫酸亚铁溶液灌浇君子兰专用土，提高土壤的酸性度之后，再种植栀子花。\n    \n</body>\n</html>\n', '君子兰专用土种植栀子花合适吗', NULL, 2, 1);
INSERT INTO `article` VALUES (7, '鼠尾掌的奥秘', '/article-img/z_14.jpg', '<!DOCTYPE html>\r\n<html>\r\n<head>\r\n    <title></title>\r\n</head>\r\n<body>\r\n    <img src=\"http://192.168.1.109:8080/article-img/z_15.jpg\">\r\n    <h3>鼠尾掌的介绍</h3>\r\n    <p>鼠尾掌又名金纽，为仙人掌科鼠尾掌属多浆植物。变态茎细长、匍匐，通常扭状下垂，在原产地可长达2米，一般栽培20—30厘米，具气生根。幼茎绿色，以后变灰，径1.5—2厘米，无叶，具10—14棱，隔0.5厘米着生15—20枚短刺丛，初生略带红色，以后变至黄褐色，因其外形酷似老鼠尾巴而得名。花期4—5月，花漏斗状，粉红色，长约8厘米，径长7厘米，花被片急尖，昼开夜闭，可持续一周。浆果球形，红色，有刺毛，种子小，红褐色。鼠尾掌茎细扭垂，颜色浓绿，短刺丛生，排列整齐，花色鲜艳而优美，是室内优良观赏植物。用金属丝将花盆悬挂檐下，冬季陈列于窗前，观赏效果极佳。</p>\r\n    \r\n     <img src=\"http://192.168.1.109:8080/article-img/z_16.jpg\">\r\n    <h3>鼠尾掌的形态特征</h3>\r\n    茎细长，匍匐，多分枝，长可达2米，幼时亮绿色，后变灰绿色。具浅棱10-14，辐射刺10-20，新刺红色，后变黄至褐色。4-5月开花，花两侧对称，粉红色，昼开夜闭。浆果球形，红色。\r\n    <h3>鼠尾掌的病害防治</h3>\r\n    <p>茎部有时发生斑点病，可用65%代森锌可湿性粉剂600倍液喷洒。主要害虫是红蜘蛛，可定期喷洒乐果预防。 鼠尾掌属植物约有7种，常见栽培的有：细蛇鼠尾掌A.leptophis，茎粗约1厘米。\r\n具浅棱7-8，刺10-15。花红色。康氏鼠尾掌A.conzatii，茎粗1-2.5厘米。具棱8-10，刺15-20。花砖红色。鞭形鼠尾掌A.flagriformis，与鼠尾掌很相似，但茎较粗，棱较少，仅7-10，刺黄色。花深红色。<br></p>\r\n</body>\r\n</html>\r\n', '鼠尾掌要怎么培育呢？', NULL, 1, 5);
INSERT INTO `article` VALUES (8, '黄丽：又名宝石花', '/article-img/z_17.jpg', '<!DOCTYPE html>\r\n<html>\r\n<head>\r\n    <title></title>\r\n</head>\r\n<body>\r\n    <img src=\"http://192.168.1.109:8080/article-img/z_18.jpg\">\r\n    <h3>黄丽的介绍</h3>\r\n    <p>也称“宝石花”。被称为宝石花的品种繁多，且模样相似，一般人难以区分。蜡质的叶片呈现特别的金黄色，喜欢充足的阳光，日光浴之后，边缘会变成漂亮的红色。光线不足虽然也能生长，但颜色会比较暗淡，茎也会伸长。害怕潮湿。春秋是生长季节，盆土差不多全部干燥的时候浇透水。夏季要保持盆土稍干，避免暴晒。冬天也要减少浇水，否则容易腐烂。</p>\r\n    \r\n     <img src=\"http://192.168.1.109:8080/article-img/z_19.jpg\">\r\n    <h3>黄丽的形态特征</h3>\r\n    <p>多年生多肉类植物，植株具短茎，肉质叶，排列紧密，呈莲座状，叶片匙形，顶端有小尖头，叶片松散，表面附蜡质呈黄绿色或金黄色偏红，长期生长于阴凉处时叶片呈绿色，光照充足情况下，叶片边缘会泛红，花单瓣，聚伞花序，浅黄色，较少开花。</p>\r\n    <h3>黄丽的生态习性</h3>\r\n    <p>性喜日照，耐半阴，忌暴晒，忌大湿大水，怕潮，人工繁殖成活率高。</p>\r\n</body>\r\n</html>\r\n', '宝石花的美', NULL, 1, 6);
INSERT INTO `article` VALUES (9, '骆驼刺的生长', '/article-img/z_20.jpg', '<!DOCTYPE html>\r\n<html>\r\n<head>\r\n    <title></title>\r\n</head>\r\n<body>\r\n    <img src=\"http://192.168.1.109:8080/article-img/z_21.jpg\">\r\n    <h3>骆驼刺的介绍</h3>\r\n    <p>骆驼刺属豆科、落叶灌木，主要枝上多刺，叶长圆形，花粉红色，6月开花，8月最盛，每朵花可开放20 余天，结荚果，总状花序，根系一般长达20米。从沙漠和戈壁深处吸取地下水份和营养，是一种自然生长的耐旱植物，因为这种植物茎上长着剌状的很坚硬的小绿叶，故叫骆驼剌，是草本植物，是戈壁滩和沙漠中骆驼唯一能吃的赖以生存的草，故又名骆驼草。\r\n骆驼刺主要分布在内陆干旱地区，被誉为沙漠勇士。骆驼刺是一种低矮的地表植物。骆驼刺具有抗寒、抗旱、耐盐和抗风沙的特性，并具有适应性强、分布广、面积大的特点，在防止土地遭受风沙侵蚀方面具有非常重要的作用。</p>\r\n    \r\n     <img src=\"http://192.168.1.109:8080/article-img/z_22.jpg\">\r\n    <h3>骆驼刺的形态特征</h3>\r\n    <p>骆驼刺为半灌木，高25-40厘米。茎直立，具细条纹，无毛或幼茎具短柔毛，从基部开始分枝，枝条平行上升。叶互生，卵形、倒卵形或倒圆卵形，长8-15毫米，宽5-10毫米，先端圆形，具短硬尖，基部楔形，全缘，无毛，具短柄。总状花序，腋生，花序轴变成坚硬的锐刺，刺长为叶的2-3倍，无毛，当年生枝条的刺上具花3-6 (-8) 朵，老茎的刺上无花；花长8-10毫米；苞片钻状，长约1毫米；花梗长1-3毫米；花萼钟状，长4-5毫米，被短柔毛，萼齿三角状或钻状三角形，长为萼筒的三之一至四分之一；花冠深紫红色，旗瓣倒长卵形，长8-9毫米，先端钝圆或截平，基部楔形，具短瓣柄，冀瓣长圆形，长为旗瓣的四分之三，龙骨瓣与旗瓣约等长；子房线形，无毛。荚果线形，常弯曲，几无毛。\r\n骆驼刺落叶、多分枝灌木；茎、枝有腋生的长针刺；叶小，单叶，全缘；生于上部的无叶而叶柄变为刺；托叶小；花数朵排成腋生的总状花序，总轴有刺；萼钟形，裂齿5，短，近相等；花冠红色，各瓣近等长，旗瓣倒卵形，具短柄，翼瓣镰状长圆形，龙骨瓣内弯；雄蕊10，二体（9+1），花药同型；子房近无柄，有胚珠多颗，花柱丝状，内弯；荚果线形，厚或近圆柱状，常弯曲，几无毛，不开裂，常于种子间缢缩而内面具隔膜，但荚节不断离；种子肾形，无种阜。\r\n骆驼刺主要枝上多刺，叶长圆形，花粉红色，6月开花，8月最盛，每朵花可开放20 余天，结荚果，总状花序，根系一般长达20米。</p>\r\n</body>\r\n</html>\r\n', '骆驼刺的倔强', NULL, 1, 6);
INSERT INTO `article` VALUES (10, '火棘：你听说过吗', '/article-img/z_35.jpg', '<!DOCTYPE html>\r\n<html>\r\n<head>\r\n    <title></title>\r\n</head>\r\n<body>\r\n    <img src=\"http://192.168.1.109:8080/article-img/z_36.jpg\">\r\n    <h3>火棘的介绍</h3>\r\n    <p>火棘又名救兵粮、救命粮、火把果、赤阳子，蔷薇科火棘属常绿灌木或小乔木，高可达4m，通常采用播种、扦插和压条法繁殖。 火棘树形优美，夏有繁花，秋有红果，果实存留枝头甚久，在庭院中做绿篱以及园林造景材料，在路边可以用作绿篱，美化、绿化环境。</p>\r\n    \r\n     <img src=\"http://192.168.1.109:8080/article-img/z_37.jpg\">\r\n    <h3>火棘的生态习性</h3>\r\n    <p>喜强光，耐贫瘠，抗干旱；黄河以南露地种植，华北需盆栽，塑料棚或低温温室越冬，温度可低至0℃、水搓子。对土壤要求不严，而以排水良好、湿润、疏松的中性或微酸性壤土为好。</p>\r\n</body>\r\n</html>\r\n', '火棘的奥秘', NULL, 2, 7);
INSERT INTO `article` VALUES (11, '独占春的培植', '/article-img/z_32.jpg', '<!DOCTYPE html>\r\n<html>\r\n<head>\r\n    <title></title>\r\n</head>\r\n<body>\r\n    <img src=\"http://192.168.1.109:8080/article-img/z_33.jpg\">\r\n    <h3>独占春的介绍</h3>\r\n    <p>独占春为附生植物；假鳞茎近梭形或卵形，包藏于叶基之内，基部常有由叶鞘撕裂后残留的纤维状物。叶6-11枚，每年继续发出新叶，多者可达15-17枚。花葶从假鳞茎下部叶腋发出，直立或近直立；总状花序具1-3朵花；花较大，不完全开放，稍有香气；萼片与花瓣白色，有时略有粉红色晕，唇瓣亦白色。\r\n独占春又有“双燕齐飞”或“双燕迎春”的美称。广州人叫“双飞燕”，是从它所开的花形貌似两只正在飞翔的燕子而得名。\r\n此花是农历正月初五开的兰花，若能掌握其习性，适当加强光照，管理得法，培育有方的话，很可能使它在春节期间开花贺岁。通常它的花期能达一月之久。生于溪谷旁岩石上。产中国海南、广西和云南，尼泊尔、印度、缅甸也有分布。有栽培，具较高的观赏价值。</p>\r\n    \r\n     <img src=\"http://192.168.1.109:8080/article-img/z_34.jpg\">\r\n    <h3>独占春的生态习性</h3>\r\n    <p>独占春一般生长在深山幽谷的山腰谷壁，透水和保水性良好的倾斜山坡或石隙，稀疏的山草旁，次生杂木林阴下。或有遮阴，日照时间短或只有星散漏光的地方。空气湿度大且空气能流通的地方，有时也生于山溪边峭壁之上。<br>\r\n独占春宜种植于空气流通的环境。性喜阴，忌阳光直射，喜湿润，忌干燥，15℃至30℃最宜生长。35℃以上生长不良。5℃以下的严寒会影响其生长力，这时，兰花常处于休眠状态。如气温太高加上阳光曝晒则一两天内即出现叶子灼伤或枯焦。如气温太低又没及时转移进屋里，则会出现冻伤的现象。\r\n独占春是肉质根，适合采用富含腐殖质的砂质壤土，排水性能必须良好，应选用腐叶土或含腐殖质较多的山土。微酸性的松土或含铁质的土壤，pH值以5.5-6.5为宜。</p>\r\n</body>\r\n</html>\r\n', '独占春的奥秘，你来看看吗', NULL, 7, 8);
INSERT INTO `article` VALUES (12, '矮仙丹的奥秘', '/article-img/z_29.jpg', '<!DOCTYPE html>\r\n<html>\r\n<head>\r\n    <title></title>\r\n</head>\r\n<body>\r\n    <img src=\"http://192.168.1.109:8080/article-img/z_30.jpg\">\r\n    <h3>矮仙丹的介绍</h3>\r\n    <p>矮仙丹常绿矮小灌木，叶长椭圆形，成对长在枝条上，叶小生长紧密。原产亚洲热带地区。日照需充足，耐旱喜高温。<br>\r\n矮仙丹叶长椭圆形，成对长在枝条上，叶小生长紧密。日照需充足，耐旱喜高温，早春应剪枝，促进生长。 常绿矮小灌木。叶外形椭圆，成对长在枝条上；叶柄着落处两侧有一对小托叶。</p>\r\n    \r\n     <img src=\"http://192.168.1.109:8080/article-img/z_31.jpg\">\r\n    <h3>矮仙丹的形态特征</h3>\r\n    <p>常绿矮小灌木。叶长椭圆形，成对长在枝条上，叶小生长紧密。四季开花，但夏季为盛开期。夏秋开红色花，盛花期花团锦簇，美丽壮观。果实为浆果，球形，成熟时黑色。早春应剪枝，促进生长。</p>\r\n    <h3>矮仙丹的名字由来</h3>\r\n    <p>从前，有一对母子住在深山中，母亲体弱多病，儿子看了很操心，就在每天的早晨去採花採药，突然看见了仙丹花，把母亲的病治好了，人们才较它做仙丹花。</p>\r\n</body>\r\n</html>\r\n', '矮仙丹是名字由来', NULL, 4, 9);
INSERT INTO `article` VALUES (13, '岩桐：花中美人', '/article-img/z_26.jpg', '<!DOCTYPE html>\r\n<html>\r\n<head>\r\n    <title></title>\r\n</head>\r\n<body>\r\n    <img src=\"http://192.168.1.109:8080/article-img/z_27.jpg\">\r\n    <h3>岩桐的介绍</h3>\r\n    <p>岩桐：苦苣苔科，多年生草本。 又名落雪尼，为苦苣苔科多年生球根草本花卉。<br>具肥大肉质块茎，地上茎极短，叶片长椭圆形，密生绒毛，稍成肉质，叶对生，花顶生或腋生，花冠钟形，尖端浑圆，色彩艳丽，有丝绒感，颜色有红、粉红、玫瑰红、紫红、蓝及复色，花形奇特，是一种极好的盆栽观花植物。</p>\r\n    \r\n     <img src=\"http://192.168.1.109:8080/article-img/z_28.jpg\">\r\n    <h3>岩桐的形态特征</h3>\r\n    <p>叶心脏形，肥大而厚，有长叶柄，自根丛生。春夏间叶丛抽花茎着花，一茎一萼，花冠长筒形，花瓣肥厚，生有光泽，五浅裂，色白，其叶俱密生绒毛。具肥大肉质块茎，地上茎极短，叶片长椭圆形，密生绒毛，稍成肉质，叶对生，花顶生或腋生，花冠钟形，尖端浑圆，色彩艳丽，有丝绒感，颜色有红、粉红、玫瑰红、紫红、蓝及复色，花形奇特，是一种极好的盆栽观花植物。</p>\r\n    <h3>岩桐的病害防治</h3>\r\n    <p>生长期间主要有尺蠖食腋芽，可用氧化乐果1000倍液防治。</p>\r\n</body>\r\n</html>\r\n', '岩桐的美姿', NULL, 2, 9);
INSERT INTO `article` VALUES (14, '白玉草的美姿', '/article-img/z_23.jpg', '<!DOCTYPE html>\r\n<html>\r\n<head>\r\n    <title></title>\r\n</head>\r\n<body>\r\n    <img src=\"http://192.168.1.109:8080/article-img/z_24.jpg\">\r\n    <h3>白玉草的介绍</h3>\r\n    <p>白玉草（学名：Silene vulgaris）是石竹科蝇子草属的植物。<br>\r\n白玉草多年生草本，高40-100厘米，全株无毛，呈灰绿色。生于海拔150-2700米的草甸、灌丛中、林下多砾石的草地或撂荒地，有时生于农田中</p>\r\n    \r\n     <img src=\"http://192.168.1.109:8080/article-img/z_25.jpg\">\r\n    <h3>白玉草的形态特征</h3>\r\n    <p>多年生草本，高40-100厘米，全株无毛，呈灰绿色。根微粗壮，木质。茎疏丛生，直立，上部分枝，常灰白色。叶片卵状披针形、披针形或卵形，长4-10厘米，宽1-3 (-4.5) 厘米，下部茎生叶片基部渐狭成柄状，顶端渐尖或急尖，边缘有时具不明显的细齿，中脉明显，上部茎生叶片基部楔形、截形或圆形，微抱茎。二歧聚伞花序大型；花微俯垂；花梗比花萼短或近等长；苞片卵状披针形，草质；花萼宽卵形，呈囊状，长13-16毫米，直径5-7毫米，近膜质，常显紫堇色，萼齿短，宽三角形，顶端急尖，边缘具缘毛；雌雄蕊柄无毛，长约2毫米；花瓣白色，长15-18毫米，爪楔状倒披针形，无毛，耳卵形，瓣片露出花萼，轮廓倒卵形，深2裂几达瓣片基部，裂片狭倒卵形；副花冠缺；雄蕊明显外露，花丝无毛，花药蓝紫色；花柱明显外露。种子圆肾形，长约1.5毫米，褐色，脊平。2n = 24。花期6-8月，果期8-9月。</p>\r\n    <h3>白玉草的生态习性</h3>\r\n    <p>生于海拔150-2700米的草甸、灌丛中、林下多砾石的草地或撂荒地，有时生于农田中 。</p>\r\n</body>\r\n</html>\r\n', '养殖白玉草有什么需要注意的？', NULL, 5, 10);

-- ----------------------------
-- Table structure for attention
-- ----------------------------
DROP TABLE IF EXISTS `attention`;
CREATE TABLE `attention`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_initiative` int(11) NULL DEFAULT NULL,
  `user_passive` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of attention
-- ----------------------------
INSERT INTO `attention` VALUES (1, 1, 2);
INSERT INTO `attention` VALUES (2, 1, 3);
INSERT INTO `attention` VALUES (3, 1, 4);
INSERT INTO `attention` VALUES (4, 3, 2);
INSERT INTO `attention` VALUES (5, 4, 2);
INSERT INTO `attention` VALUES (6, 2, 1);
INSERT INTO `attention` VALUES (7, 4, 1);
INSERT INTO `attention` VALUES (8, 2, 5);
INSERT INTO `attention` VALUES (9, 2, 6);
INSERT INTO `attention` VALUES (10, 2, 7);

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `article_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (1, 2, 1);
INSERT INTO `collect` VALUES (4, 2, 11);
INSERT INTO `collect` VALUES (5, 2, 14);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `post_id` int(11) NULL DEFAULT NULL,
  `content` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 4, 1, '美。', '2020-05-17 18:40:50');
INSERT INTO `comment` VALUES (2, 5, 1, '这花真漂亮！', '2020-05-17 18:40:52');
INSERT INTO `comment` VALUES (3, 6, 1, '哇塞，你这花养的真好。', '2020-05-17 18:40:53');
INSERT INTO `comment` VALUES (4, 8, 17, '真好看。', '2020-05-17 18:45:00');
INSERT INTO `comment` VALUES (5, 12, 17, '我是小葵花~', '2020-05-17 18:45:18');
INSERT INTO `comment` VALUES (7, 2, 16, '厉害厉害。', '2020-05-17 20:47:04');
INSERT INTO `comment` VALUES (8, 2, 15, '哈哈哈', '2020-06-02 09:24:04');
INSERT INTO `comment` VALUES (9, 2, 8, '你好', '2020-06-02 20:59:45');
INSERT INTO `comment` VALUES (10, 2, 16, '你好你好', '2020-06-03 11:14:46');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id_send` int(11) NULL DEFAULT NULL,
  `user_id_recv` int(11) NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for plant
-- ----------------------------
DROP TABLE IF EXISTS `plant`;
CREATE TABLE `plant`  (
  `plant_id` int(11) NOT NULL AUTO_INCREMENT,
  `name_cn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name_en` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `family` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `conservation` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `skill` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `initial` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`plant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 506 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of plant
-- ----------------------------
INSERT INTO `plant` VALUES (1, '艾草', 'Asiatic wormwood', '中国', '春黄菊族', '艾（学名：Artemisia argyi Levl. et Van）是菊科蒿属植物，多年生草本或略成半灌木状，植株有浓烈香气。主根明显，略粗长，直径达1.5厘米，侧根多。茎单生或少数，高80-150（-250）厘米。叶厚纸质，上面被灰白色短柔毛，并有白色腺点与小凹点。头状花序椭圆形，直径2.5-3（-3.5）毫米，无梗或近无梗。瘦果长卵形或长圆形。花果期7-10月。分布于蒙古、朝鲜、俄罗斯（远东地区）和中国；分布广，在中国除极干旱与高寒地区外，几乎遍及中国。日本有栽培。生于低海拔至中海拔地区的荒地、路旁河边及山坡等地，也见于森林草原及草原地区，局部地区为植物群落的优势种。', '土壤：养艾草要用肥沃、通透性良好的土壤。浇水：保证土壤微微湿润，浇水时要适量，不要过多或过少，浇水也不要过于频繁。光照：保证充足的光照，夏季阳光强烈要采取遮荫措施。施肥：播种之前要施底肥，每采收一次就要施一次肥。', '全草入药，有温经、去湿、散寒、止血、消炎、平喘、止咳、安胎、抗过敏等作用。艾叶晒干捣碎得“艾绒”，制艾条供艾灸用，又可作“印泥”的原料。此外全草作杀虫的农药或薰烟作房间消毒、杀虫药。嫩芽及幼苗作菜蔬。 [1]  艾晒干粉碎成艾蒿粉，是畜禽优质饲料添加剂。还可以做天然植物染料使用。', 'https://i.loli.net/2020/05/11/qdZmPtLln51MFKT.jpg', 'A');
INSERT INTO `plant` VALUES (2, '薄荷', 'mint', '江苏、安徽', '塔花族', '薄荷，土名叫“银丹草”，为唇形科植物，即同属其他干燥全草。多生于山野湿地河旁，根茎横生地下，多生于2100米海拔高度，但也可在3500米海拔上生长，是一种有特种经济价值的芳香作物。全株青气芳香。叶对生，花小淡紫色，唇形，花后结暗紫棕色的小粒果。', '养薄荷需要提供排水性能力好、透气性高的土。它不耐强光，应该放在半阴的地方养殖，保证每天不少于五小时的光照条件。给它浇水先观察土壤的状态，只有完全干燥下才需要浇。施肥的时候选用淡肥。繁殖方法可以使用采用扦插法。还需注意病虫害的防治。', '薄荷是中华常用中药之一。它是辛凉性发汗解热药，治流行性感冒、头疼、目赤、身热、咽喉、牙床肿痛等症。外用可治神经痛、皮肤瘙痒、皮疹和湿疹等。平常以薄荷代茶，清心明目。', 'https://i.loli.net/2020/05/11/ACRXkarmbYzLvOc.jpg', 'B');
INSERT INTO `plant` VALUES (3, '白晶菊', 'Chrysanthemum paludo', '原产于：北非、西班牙', '春黄菊族', '白晶菊又名小白菊，为一、二年生草本花卉。喜温暖湿润和阳光充足的环境。较耐寒，耐半荫。适宜生长在疏松肥沃排水性好的壤土中。白晶菊矮而强健，多花，花期早，花期长，成片栽培耀眼夺目。头状花序顶生，花后结瘦果，5月下旬成熟。白晶菊的花有色白、黄色，植株低矮，花繁茂，适用于花坛、庭院布置，也可作为地被花卉栽种。白晶菊低矮而强健，多花，花期早，花期长,成片栽培耀眼夺目，也适合盆栽或早春花坛美化。', '白晶菊由于花期长，生育期或开花期间每20-30天追肥一次，所以平时培养土要保持湿润，花谢后立即剪除残花，可促使新芽再开花。病虫防治：常见病害有叶斑病、茎腐病，可用65%代森锌可湿性粉剂喷洒。虫害有盲蝽和潜叶蝇危害，可用25%西维因可湿性粉剂1500倍喷杀。', '白晶菊低矮而强健，多花，花期早，花期长，成片栽培耀眼夺目，也适合盆栽或早春花坛美化。也可作为地被花卉栽种。', 'https://i.loli.net/2020/05/11/Vpcj4tf67IiAOCT.jpg', 'B');
INSERT INTO `plant` VALUES (4, '百合花', 'Lilium', '原产于中国，主要分布在亚洲东部、欧洲、北美洲等', '百合属', '百合花（学名：Lilium）是百合科百合属多年生草本球根植物，原产于北半球的几乎每一个大陆的温带地区，主要分布在亚洲东部、欧洲、北美洲等，全球已发现有110多个品种，其中55种产于中国。近年更有不少经过人工杂交而产生的新品种，如：亚洲百合、麝香百合、香水百合、葵（火）百合、姬百合等。百合花姿雅致叶片青翠娟秀，茎干亭亭玉立，是名贵的切花新秀。学名(Lilium brownii var. viridulum Baker)又名强蜀、番韭、山丹、倒仙、重迈、中庭、摩罗、重箱、中逢花、百合蒜、大师傅蒜、蒜脑薯、夜合花等。', '首先要选择充实、健壮的种鳞茎，亚洲系列的种鳞茎周径必须在10～12厘米，东方系列的种鳞茎周径在12～14厘米。种鳞茎越大，花蕾数也多，见表。但品种不同，着蕾数也有一定差别。因此，好的种鳞茎具有较高的商品价值，对盆栽百合十分重要。', '百合具有较高的营养成分，又具有较高的药用价值，早在2000多年前，百合就被中医引用，历代《本草》中有详尽的记述。中医认为：百合有润肺止咳、清心安神、补中益气之功能，能治肺痨久咳、咳唾痰血、虚烦、惊悸、神志恍惚、脚气浮肿等症，常用的百合药膳方有蜜煎百合、百合香米粥、百合党参猪肺汤、百合鸡子汤、百合煨肉等；临床常用的方剂有百合知母汤、百合地黄汤、百合滑不散、百合干粉、新鲜百合汁等。百合虽是滋补佳品和名食，但因其甘寒质润，凡风寒咳嗽、大便溏泄、脾胃虚弱、寒湿久滞，肾阳衰退者均忌用。', 'https://i.loli.net/2020/05/11/4eY5hr6sxPBdnCm.jpg', 'B');
INSERT INTO `plant` VALUES (5, '白兰花', 'Michelia alba DC', '中国福建、广东、广西、云南', '含笑属', '白兰（学名：Michelia alba DC.）：常绿乔木，高达17米，枝广展，呈阔伞形树冠；胸径30厘米；树皮灰色；揉枝叶有芳香；嫩枝及芽密被淡黄白色微柔毛，老时毛渐脱落。叶薄革质，长椭圆形或披针状椭圆形，上面无毛，下面疏生微柔毛，干时两面网脉均很明显。花白色，极香；花被片10片，披针形；雌蕊心皮多数，成熟时随着花托的延伸，形成蓇葖疏生的聚合果；蓇葖熟时鲜红色。花期4-9月，夏季盛开，通常不结实。', '家庭盆栽白兰花，应选择疏松、透气性强且含腐殖质较丰富的土壤栽培。通常选用透气性好的瓦盆、紫砂盆（缸）或用底孔较多的塑料盆。盆内土壤最好能有一定量的大小不等的颗粒状土壤，以利渗水透气。', '白兰花株形直立有分枝，落落大方。在南方可露地庭院栽培，是南方园林中的骨干树种。北方盆栽，可布置庭院、厅堂、会议室。中小型植株可陈设于客厅、书房。因其惧怕烟熏，应放在空气流通处。除了可以花叶齐观，作为一种香料植物，白兰花还可以兼做香料和药用。', 'https://i.loli.net/2020/05/11/JblfVKaDeGAvwoS.jpg', 'B');
INSERT INTO `plant` VALUES (6, '金边龙舌兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick37971445246358.jpg', 'J');
INSERT INTO `plant` VALUES (7, '花烟草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick84711440409959.jpg', 'H');
INSERT INTO `plant` VALUES (8, '锦晃星', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick14741443603797.jpg', 'J');
INSERT INTO `plant` VALUES (9, '丽格海棠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick50981443604909.jpg', 'L');
INSERT INTO `plant` VALUES (10, '火焰兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick97441452591977.jpg', 'H');
INSERT INTO `plant` VALUES (11, '金鱼草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick22501428056022.jpg', 'J');
INSERT INTO `plant` VALUES (12, '乙女心', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick56501443173854.jpg', 'Y');
INSERT INTO `plant` VALUES (13, '铁线蕨', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick60501441704980.jpg', 'T');
INSERT INTO `plant` VALUES (14, '山茶花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick96241428056732.jpg', 'S');
INSERT INTO `plant` VALUES (15, '莲花掌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick71761448529487.jpg', 'L');
INSERT INTO `plant` VALUES (16, '高砂之翁', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick16691452503343.png', 'G');
INSERT INTO `plant` VALUES (17, '金银花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick30351440581995.jpg', 'J');
INSERT INTO `plant` VALUES (18, '姬星美人', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick81601442222732.jpg', 'J');
INSERT INTO `plant` VALUES (19, '黄蝉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick86871448358077.jpg', 'H');
INSERT INTO `plant` VALUES (20, '凝脂菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick14601451898319.jpg', 'N');
INSERT INTO `plant` VALUES (21, '山茶花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick8011439286458.jpg', 'S');
INSERT INTO `plant` VALUES (22, '虎刺梅', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick67861439544559.jpg', 'H');
INSERT INTO `plant` VALUES (23, '紫罗兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick64291438766891.jpg', 'Z');
INSERT INTO `plant` VALUES (24, '齿缘吊钟花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick90521453109126.jpg', 'C');
INSERT INTO `plant` VALUES (25, '冬美人', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick37611444468476.jpg', 'D');
INSERT INTO `plant` VALUES (26, '雷神', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick69581438853360.jpg', 'L');
INSERT INTO `plant` VALUES (27, '万年青', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick5371439890988.jpg', 'W');
INSERT INTO `plant` VALUES (28, '白凤', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick79451453886480.jpg', 'B');
INSERT INTO `plant` VALUES (29, '朱莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick34191454058966.jpg', 'Z');
INSERT INTO `plant` VALUES (30, '石榴花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick3491439977388.jpg', 'S');
INSERT INTO `plant` VALUES (31, '荷花玉兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick6521447234735.jpg', 'H');
INSERT INTO `plant` VALUES (32, '白凤菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick86391450429419.jpg', 'B');
INSERT INTO `plant` VALUES (33, '锦鸡儿', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick37381447061228.jpg', 'J');
INSERT INTO `plant` VALUES (34, '花叶寒月夜', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick10341454060052.jpg', 'H');
INSERT INTO `plant` VALUES (35, '木荷', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick6731446198782.jpg', 'M');
INSERT INTO `plant` VALUES (36, '梭鱼草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick88871446198442.jpg', 'S');
INSERT INTO `plant` VALUES (37, '阔叶十大功劳', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick55381446197975.jpg', 'K');
INSERT INTO `plant` VALUES (38, '黑心菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick90701447235657.jpg', 'H');
INSERT INTO `plant` VALUES (39, '桔梗', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick98641438855128.jpg', 'J');
INSERT INTO `plant` VALUES (40, '多叶羽扇豆', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick19711453110190.jpg', 'D');
INSERT INTO `plant` VALUES (41, '白睡莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick2641450949213.jpg', 'B');
INSERT INTO `plant` VALUES (42, '带叶兜兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick7191452763089.jpg', 'D');
INSERT INTO `plant` VALUES (43, '棣棠花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick98841443605197.jpg', 'L');
INSERT INTO `plant` VALUES (44, '大花紫薇', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick85821448358709.jpg', 'D');
INSERT INTO `plant` VALUES (45, '金光菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick6651448444908.jpg', 'J');
INSERT INTO `plant` VALUES (46, '接骨木', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick89961443433830.jpg', 'J');
INSERT INTO `plant` VALUES (47, '红缘莲花掌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick94751451983395.jpg', 'H');
INSERT INTO `plant` VALUES (48, '杏花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick48981443172810.jpg', 'X');
INSERT INTO `plant` VALUES (49, '千兔耳', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick26991452676359.jpg', 'Q');
INSERT INTO `plant` VALUES (50, '大花六道木', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick83341448530093.jpg', 'D');
INSERT INTO `plant` VALUES (51, '冬红', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick49391452590787.jpg', 'D');
INSERT INTO `plant` VALUES (52, '香水草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick43491448961232.jpg', 'X');
INSERT INTO `plant` VALUES (53, '大花美人蕉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick55011450864382.jpg', 'D');
INSERT INTO `plant` VALUES (54, '西府海棠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick2301442482822.jpg', 'X');
INSERT INTO `plant` VALUES (55, '铁十字秋海棠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick43711448875920.jpg', 'T');
INSERT INTO `plant` VALUES (56, '矮雪轮', 'Silene pendula L', '原产欧洲南部，世界各地广为栽培', '剪秋罗族', '大蔓樱草（学名：Silene pendula L.）是石竹科蝇子草属植物。一年生或二年生草本，全株被柔毛和腺毛。茎俯仰，多分枝，长20-40厘米。叶片卵状披针形或椭圆状倒披针形。单歧式聚伞花序；花梗细，直立，长5-15毫米，果时反折。蒴果卵状锥形，长约9毫米，比宿存萼短；种子圆肾形，长约1毫米。花期5-6月，果期6-7月。原产于欧洲南部，世界各地广为栽培。性喜温暖和充足的阳光照射，要求在疏松肥沃、通透性好的砂质土壤中生长。大蔓樱草是一种美丽的草本花卉。株形丛生龙状，茎干长至30厘米以后，便匍匐生长，蓬径紧密，生长繁茂。花朵小巧玲珑，蕚筒肥大，内有粘状胶质，是一种花后还可观赏花萼的匍匐状花卉，可以盆栽观赏，也是花园、花圃作地被植物栽培的很好花卉。', '浇水：从幼苗期过度到生长期的时候，它的浇水量也要逐渐的增加，保持盆土微微湿润，但是不要让花盆中有积水产生，否则很容易形成烂根。\r\n土壤：它在松软和排水性好的土壤中会生长的更好，配制土壤的时候选择园土、砂质土和腐叶土进行混合，这样的土壤对它幼苗期的生长有很大的好处。\r\n光照：它喜欢阳光充足的生长环境，可以放在窗台或者露台日照时间长的位置进行养护，但是夏天正午的时候，可以暂时的搬到室内，避免暴晒。\r\n施肥：秋季是丰收的季节，也是它生长速度最快的时候，这个时候需要施加足够的肥料，来维持它生长所需的养分，可以施氮磷钾复合肥料。', '大蔓樱草是一种美丽的草本花卉。株形丛生龙状，茎干长至30厘米以后，便匍匐生长，蓬径紧密，生长繁茂。花朵小巧玲珑，蕚筒肥大，内有粘状胶质，是一种花后还可观赏花萼的匍匐状花卉，可以盆栽观赏，也是花园、花圃作地被植物栽培的很好花卉。', 'http://img.boqiicdn.com/Data/BK/P/imagick7491451381613.jpg', 'A');
INSERT INTO `plant` VALUES (57, '初恋', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick59061451294928.jpg', 'C');
INSERT INTO `plant` VALUES (58, '金丝桃', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick88821445506838.jpg', 'J');
INSERT INTO `plant` VALUES (59, '繁星花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick14751451296244.jpg', 'F');
INSERT INTO `plant` VALUES (60, '红彩阁', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick61011454404773.jpg', 'H');
INSERT INTO `plant` VALUES (61, '枝干番杏', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick89511448270297.jpg', 'Z');
INSERT INTO `plant` VALUES (62, '银星', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick78691455441296.jpg', 'Y');
INSERT INTO `plant` VALUES (63, '花叶艳山姜', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick58961447666128.jpg', 'H');
INSERT INTO `plant` VALUES (64, '一串红', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick86671448876137.jpg', 'Y');
INSERT INTO `plant` VALUES (65, '旱金莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick94931449568030.jpg', 'H');
INSERT INTO `plant` VALUES (66, '黄金钮', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick96571454404481.jpg', 'H');
INSERT INTO `plant` VALUES (67, '点地梅', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick33181448531087.jpg', 'D');
INSERT INTO `plant` VALUES (68, '蔓花生', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick58041450085359.jpg', 'W');
INSERT INTO `plant` VALUES (69, '明镜', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick21031455441711.jpg', 'M');
INSERT INTO `plant` VALUES (70, '俏黄栌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick19291449480057.jpg', 'Q');
INSERT INTO `plant` VALUES (71, '蜡梅', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick76191440150067.jpg', 'L');
INSERT INTO `plant` VALUES (72, '五色苋', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick53231447839313.jpg', 'W');
INSERT INTO `plant` VALUES (73, '大花马齿苋', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick69091449222374.jpg', 'D');
INSERT INTO `plant` VALUES (74, '蟆叶秋海棠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick53211449046317.jpg', 'M');
INSERT INTO `plant` VALUES (75, '狗牙花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick85141447235311.jpg', 'G');
INSERT INTO `plant` VALUES (76, '金纽仙人鞭', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick96241455528894.jpg', 'J');
INSERT INTO `plant` VALUES (77, '红睡莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick92221452677674.jpg', 'H');
INSERT INTO `plant` VALUES (78, '福禄考', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick36631445246907.jpg', 'F');
INSERT INTO `plant` VALUES (79, '眩美玉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick66291453713606.jpg', 'X');
INSERT INTO `plant` VALUES (80, '松霞', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick14471454318541.jpg', 'S');
INSERT INTO `plant` VALUES (81, '赤鬼城', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick86511451554169.jpg', 'C');
INSERT INTO `plant` VALUES (82, '火焰木', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick65541445507653.jpg', 'H');
INSERT INTO `plant` VALUES (83, '罂粟花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick45201441014523.jpg', 'Y');
INSERT INTO `plant` VALUES (84, '大白杜鹃', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick10521452851080.jpg', 'D');
INSERT INTO `plant` VALUES (85, '紫叶小檗', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick38071443604128.jpg', 'Z');
INSERT INTO `plant` VALUES (86, '番红花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick18831440495428.jpg', 'F');
INSERT INTO `plant` VALUES (87, '宝绿', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick88631453714474.jpg', 'B');
INSERT INTO `plant` VALUES (88, '迷迭香', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick66841450257683.jpg', 'M');
INSERT INTO `plant` VALUES (89, '红花银桦', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick88891451468250.jpg', 'H');
INSERT INTO `plant` VALUES (90, '七叶树', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick25131442915530.jpg', 'Q');
INSERT INTO `plant` VALUES (91, '月兔耳', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick30031446714856.jpg', 'Y');
INSERT INTO `plant` VALUES (92, '大花萱草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick39641452072217.jpg', 'D');
INSERT INTO `plant` VALUES (93, '九里香', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick7411442309508.jpg', 'J');
INSERT INTO `plant` VALUES (94, '鱼尾葵', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick76571445937475.jpg', 'Y');
INSERT INTO `plant` VALUES (95, '木槿', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick61941441705666.jpg', 'M');
INSERT INTO `plant` VALUES (96, '蓝松', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick3311455443338.jpg', 'L');
INSERT INTO `plant` VALUES (97, '黄水仙', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick69821451468448.jpg', 'H');
INSERT INTO `plant` VALUES (98, '红背竹芋', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick9331448443666.jpg', 'H');
INSERT INTO `plant` VALUES (99, '紫荆', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick32131441705909.jpg', 'Z');
INSERT INTO `plant` VALUES (100, '吊灯扶桑', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick45191452677901.jpg', 'D');
INSERT INTO `plant` VALUES (101, '海仙花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick50201449569170.jpg', 'H');
INSERT INTO `plant` VALUES (102, '佛甲草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick10141441790417.jpg', 'F');
INSERT INTO `plant` VALUES (103, '月见草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick93141442916303.jpg', 'Y');
INSERT INTO `plant` VALUES (104, '卧牛', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick88061455787425.jpg', 'W');
INSERT INTO `plant` VALUES (105, '美人蕉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick14761442828778.jpg', 'M');
INSERT INTO `plant` VALUES (106, '金缕梅', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick92051444469017.jpg', 'J');
INSERT INTO `plant` VALUES (107, '粉花绣线菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick55991449740748.jpg', 'F');
INSERT INTO `plant` VALUES (108, '风铃草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick57361450084558.jpg', 'F');
INSERT INTO `plant` VALUES (109, '芳香波', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick1561453801000.jpg', 'F');
INSERT INTO `plant` VALUES (110, '玉龙观音', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick2791450084100.jpg', 'Y');
INSERT INTO `plant` VALUES (111, '灰莉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick95071449826176.jpg', 'H');
INSERT INTO `plant` VALUES (112, '凤眼莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick37971446543432.jpg', 'F');
INSERT INTO `plant` VALUES (113, '美叶凤尾蕉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick6751449824895.jpg', 'M');
INSERT INTO `plant` VALUES (114, '金苞花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick51051449653595.jpg', 'J');
INSERT INTO `plant` VALUES (115, '紫玉兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick88131443519815.jpg', 'Z');
INSERT INTO `plant` VALUES (116, '花木蓝', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick81411452245981.jpg', 'H');
INSERT INTO `plant` VALUES (117, '红背桂花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick55681445850406.jpg', 'H');
INSERT INTO `plant` VALUES (118, '香龙血树', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick20801445505540.jpg', 'X');
INSERT INTO `plant` VALUES (119, '金鸡菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick58161445591297.jpg', 'J');
INSERT INTO `plant` VALUES (120, '泥鳅掌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick771454405017.jpg', 'N');
INSERT INTO `plant` VALUES (121, '木棉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick85911441619210.jpg', 'M');
INSERT INTO `plant` VALUES (122, '紫鹅绒', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick12101447924871.jpg', 'Z');
INSERT INTO `plant` VALUES (123, '垂丝海棠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick17371442483212.jpg', 'C');
INSERT INTO `plant` VALUES (124, '葱兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick65321448617401.jpg', 'C');
INSERT INTO `plant` VALUES (125, '紫珍珠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick31751444902469.jpg', 'Z');
INSERT INTO `plant` VALUES (126, '条纹十二卷', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick74991446086489.jpg', 'T');
INSERT INTO `plant` VALUES (127, '臭牡丹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick27841448530875.jpg', 'C');
INSERT INTO `plant` VALUES (128, '梨花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick17571442396763.jpg', 'L');
INSERT INTO `plant` VALUES (129, '矢车菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick70311441619512.jpg', 'S');
INSERT INTO `plant` VALUES (130, '时钟花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick51761449480717.jpg', 'S');
INSERT INTO `plant` VALUES (131, '黄兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick23941450172150.jpg', 'H');
INSERT INTO `plant` VALUES (132, '星乙女', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick22431452677246.jpg', 'X');
INSERT INTO `plant` VALUES (133, '彩叶凤梨', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick28331449567736.jpg', 'C');
INSERT INTO `plant` VALUES (134, '小红衣', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick69111452762428.jpg', 'X');
INSERT INTO `plant` VALUES (135, '神想曲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick83701453800257.jpg', 'S');
INSERT INTO `plant` VALUES (136, '芙蓉葵', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick9331450864206.jpg', 'F');
INSERT INTO `plant` VALUES (137, '美叶光萼荷', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick85181449133648.jpg', 'M');
INSERT INTO `plant` VALUES (138, '桂花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick25651438940297.jpg', 'G');
INSERT INTO `plant` VALUES (139, '千日红', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick89031449222007.jpg', 'Q');
INSERT INTO `plant` VALUES (140, '玉吊钟', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick66941446629050.jpg', 'Y');
INSERT INTO `plant` VALUES (141, '小球玫瑰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick11211444295692.jpg', 'X');
INSERT INTO `plant` VALUES (142, '非洲紫罗兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick12051451555061.jpg', 'F');
INSERT INTO `plant` VALUES (143, '红稚莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick91451447839036.jpg', 'H');
INSERT INTO `plant` VALUES (144, '扶桑', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick69121442397623.jpg', 'F');
INSERT INTO `plant` VALUES (145, '绯牡丹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick76191450170596.jpg', 'F');
INSERT INTO `plant` VALUES (146, '红丁香', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick8121451898935.jpg', 'H');
INSERT INTO `plant` VALUES (147, '牡丹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick77551439459374.jpg', 'M');
INSERT INTO `plant` VALUES (148, '蜡菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick76241448961739.jpg', 'L');
INSERT INTO `plant` VALUES (149, '锦上珠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick93301453972502.jpg', 'J');
INSERT INTO `plant` VALUES (150, '帝冠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick86831452848556.jpg', 'D');
INSERT INTO `plant` VALUES (151, '九轮塔', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick43411454319182.jpg', 'J');
INSERT INTO `plant` VALUES (152, '珊瑚藤', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick47881450344812.jpg', 'S');
INSERT INTO `plant` VALUES (153, '荷花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick20101439891602.jpg', 'H');
INSERT INTO `plant` VALUES (154, '蜀葵', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick79581448962134.jpg', 'S');
INSERT INTO `plant` VALUES (155, '金盏菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick17501448445669.jpg', 'J');
INSERT INTO `plant` VALUES (156, '金露梅', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick76551450430600.jpg', 'J');
INSERT INTO `plant` VALUES (157, '皱叶椒草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick13881448529822.jpg', 'Z');
INSERT INTO `plant` VALUES (158, '黑兔耳', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick84671453887123.jpg', 'H');
INSERT INTO `plant` VALUES (159, '变叶木', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick17801444641394.jpg', 'B');
INSERT INTO `plant` VALUES (160, '异叶南洋杉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick92131448356993.jpg', 'Y');
INSERT INTO `plant` VALUES (161, '凤凰木', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick2021444470101.jpg', 'F');
INSERT INTO `plant` VALUES (162, '藿香蓟', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick4051448271542.jpg', 'H');
INSERT INTO `plant` VALUES (163, '毛海星', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick41891453715532.jpg', 'M');
INSERT INTO `plant` VALUES (164, '六倍利', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick11371445851246.jpg', 'L');
INSERT INTO `plant` VALUES (165, '吹雪之松锦', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick89351451380066.jpg', 'C');
INSERT INTO `plant` VALUES (166, '兜唇石斛', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick38131450776421.jpg', 'D');
INSERT INTO `plant` VALUES (167, '豆瓣绿', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick4801440149795.jpg', 'D');
INSERT INTO `plant` VALUES (168, '若绿', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick89581450863968.jpg', 'R');
INSERT INTO `plant` VALUES (169, '白芨', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick55171443172018.jpg', 'B');
INSERT INTO `plant` VALUES (170, '珍珠梅', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick20601443519568.jpg', 'Z');
INSERT INTO `plant` VALUES (171, '紫玄月', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick30971451467626.jpg', 'Z');
INSERT INTO `plant` VALUES (172, '五色梅', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick90221445591728.jpg', 'W');
INSERT INTO `plant` VALUES (173, '球花石斛', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick40531450430822.jpg', 'Q');
INSERT INTO `plant` VALUES (174, '雪莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick84071453108567.jpg', 'X');
INSERT INTO `plant` VALUES (175, '姬红小松', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick99541450343905.jpg', 'J');
INSERT INTO `plant` VALUES (176, '火炬树', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick66321444382790.jpg', 'H');
INSERT INTO `plant` VALUES (177, '矮牵牛', 'Petunia hybrida', '分布于南美洲，如今各国广为流行', '碧冬茄属', '茄科，碧冬茄属。正式名碧冬茄。多年生草本，常作一二年生栽培，高20—45厘米；茎匍地生长，被有粘质柔毛；叶质柔软，卵形，全缘，互生，上部叶对生；花单生，呈漏斗状，重瓣花球形，花白、紫或各种红色，并镶有它色边，非常美丽，花期4月至降霜；蒴果；种子细小。分布于南美洲，如今各国广为流行。', '喜温暖和阳光充足的环境。不耐霜冻，怕雨涝。它生长适温为13～18℃，冬季温度在4～10℃，如低于4℃，植株生长停止。夏季能耐35℃以上的高温。夏季生长旺期，需充足水分，特别在夏季高温季节，应在早、晚浇水，保持盆土湿润。但梅雨季节，雨水多，对矮牵牛生长十分不利，盆土过湿，茎叶容易徒长，花期雨水多，花朵易褪色或腐烂。盆土若长期积水，则烂根死亡，所以盆栽矮牵牛宜用疏松肥沃和排水良好的砂壤土。', '花大而多，开花繁盛，花期长，色彩丰富，是优良的花坛和种植钵花卉，也可自然式丛植，还可作为切花。气候适宜或温室栽培可四季开花。可以广泛用于花坛布置，花槽配置，景点摆设，窗台点缀，家庭装饰。', 'http://img.boqiicdn.com/Data/BK/P/imagick48711447322252.jpg', 'A');
INSERT INTO `plant` VALUES (178, '彩色马蹄莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick80361450085551.jpg', 'C');
INSERT INTO `plant` VALUES (179, '蓝黛莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick29171453972752.jpg', 'L');
INSERT INTO `plant` VALUES (180, '红蕉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick34461452245755.jpg', 'H');
INSERT INTO `plant` VALUES (181, '二乔木兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick50411452244725.jpg', 'E');
INSERT INTO `plant` VALUES (182, '小和锦', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick7991452590010.jpg', 'X');
INSERT INTO `plant` VALUES (183, '碧玉兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick75601452677466.jpg', 'B');
INSERT INTO `plant` VALUES (184, '星王子', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick45571452590450.jpg', 'X');
INSERT INTO `plant` VALUES (185, '垂枝红千层', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick36751452591507.jpg', 'C');
INSERT INTO `plant` VALUES (186, '独占春', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick65911452850264.jpg', 'D');
INSERT INTO `plant` VALUES (187, '硫华菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick55151448876793.jpg', 'L');
INSERT INTO `plant` VALUES (188, '八角金盘', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick2381442308920.jpg', 'B');
INSERT INTO `plant` VALUES (189, '令箭荷花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick78161442915861.jpg', 'L');
INSERT INTO `plant` VALUES (190, '广东万年青', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick28621447407155.jpg', 'G');
INSERT INTO `plant` VALUES (191, '千代田之松', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick17401450689825.jpg', 'Q');
INSERT INTO `plant` VALUES (192, '百子莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick43661446631260.jpg', 'B');
INSERT INTO `plant` VALUES (193, '龙柏', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick3861442396213.jpg', 'L');
INSERT INTO `plant` VALUES (194, '子持莲华', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick91771441012489.jpg', 'Z');
INSERT INTO `plant` VALUES (195, '茑萝', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick12761450430056.jpg', 'N');
INSERT INTO `plant` VALUES (196, '稠李', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick36921446457354.jpg', 'C');
INSERT INTO `plant` VALUES (197, '小人祭', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick20611448356658.jpg', 'X');
INSERT INTO `plant` VALUES (198, '白斑玉露', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick70341454061029.jpg', 'B');
INSERT INTO `plant` VALUES (199, '薄雪万年青', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick68421444728196.jpg', 'B');
INSERT INTO `plant` VALUES (200, '报春花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick30141444730024.jpg', 'B');
INSERT INTO `plant` VALUES (201, '金手指', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick11691439198155.jpg', 'J');
INSERT INTO `plant` VALUES (202, '瓜叶菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick80281450344632.jpg', 'G');
INSERT INTO `plant` VALUES (203, '孔雀草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick68641447148898.jpg', 'K');
INSERT INTO `plant` VALUES (204, '紫藤', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick80411441533948.jpg', 'Z');
INSERT INTO `plant` VALUES (205, '爱染锦', 'Aeonium domesticum f', '原产地位于大西洋诸岛、北非和地中海沿岸', '莲花掌属', '爱染锦（Aeonium domesticum fa Variegata ），别名黄笠姬锦、墨染，景天科莲花掌属多肉植物，矮小灌木状植株。原产地位于大西洋诸岛、北非和地中海沿岸，叶美，可观赏，亦可净化空气。', '冬种型，喜冷凉气候，夏季休眠明显，表现为叶片掉落。除夏季高温天气以外都应给予充足的光照，株型才会变美，且会产生很多分枝，形成群生。夏季高温时应增加通风，适当遮阴。生长速度较快，但枝干极易木质化，春秋两季生长明显。生长期不能缺水，否则叶片会变软。喜欢光照充足温暖的环境，夏季高温时会休眠，如果通风不好，很容易滋生病虫害，对肥、水的需求不多，冬季不低于5℃会继续生长。', '叶形叶色较美，有一定的观赏价值；盆栽可放置于电视、电脑旁，可吸收辐射，亦可栽植于室内以吸收甲醛等物质，净化空气。', 'http://img.boqiicdn.com/Data/BK/P/imagick72651452848369.jpg', 'A');
INSERT INTO `plant` VALUES (206, '红掌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick38801439978611.jpg', 'H');
INSERT INTO `plant` VALUES (207, '黄槿', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick8451447667211.jpg', 'H');
INSERT INTO `plant` VALUES (208, '紫叶李', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick77741441964405.jpg', 'Z');
INSERT INTO `plant` VALUES (209, '奔龙', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick95601455788682.png', 'B');
INSERT INTO `plant` VALUES (210, '福娘', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick75341452503139.jpg', 'F');
INSERT INTO `plant` VALUES (211, '凤仙花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick18231446024381.jpg', 'F');
INSERT INTO `plant` VALUES (212, '凌霄', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick83461442396431.jpg', 'L');
INSERT INTO `plant` VALUES (213, '牵牛花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick19311445851432.jpg', 'Q');
INSERT INTO `plant` VALUES (214, '麦李', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick21131448617713.jpg', 'M');
INSERT INTO `plant` VALUES (215, '油菜花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick1061441965157.jpg', 'Y');
INSERT INTO `plant` VALUES (216, '黄花风铃木', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick80921446110386.jpg', 'H');
INSERT INTO `plant` VALUES (217, '冷水花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick43651445419400.jpg', 'L');
INSERT INTO `plant` VALUES (218, '青枫', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick98461445332142.jpg', 'Q');
INSERT INTO `plant` VALUES (219, '天鹅绒竹芋', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick69131446086743.jpg', 'T');
INSERT INTO `plant` VALUES (220, '金盏花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick18261442829086.jpg', 'J');
INSERT INTO `plant` VALUES (221, '虞美人', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick7211442224811.jpg', 'Y');
INSERT INTO `plant` VALUES (222, '麝香百合', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick50021449048202.jpg', 'S');
INSERT INTO `plant` VALUES (223, '康乃馨', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick9591439286120.jpg', 'K');
INSERT INTO `plant` VALUES (224, '非洲凤仙', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick33541447060787.jpg', 'F');
INSERT INTO `plant` VALUES (225, '西瓜皮椒草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick71401450171081.jpg', 'G');
INSERT INTO `plant` VALUES (226, '鸾凤玉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick38001449479621.jpg', 'L');
INSERT INTO `plant` VALUES (227, '彩叶草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick50731446715226.jpg', 'C');
INSERT INTO `plant` VALUES (228, '绒针', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick64871451983146.jpg', 'R');
INSERT INTO `plant` VALUES (229, '天人菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick70211446543088.jpg', 'T');
INSERT INTO `plant` VALUES (230, '鼠尾掌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick23161452155199.jpg', 'S');
INSERT INTO `plant` VALUES (231, '非洲菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick73001447322923.jpg', 'F');
INSERT INTO `plant` VALUES (232, '花叶万年青', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick84911447147926.jpg', 'H');
INSERT INTO `plant` VALUES (233, '勋章菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick52011451984995.jpg', 'X');
INSERT INTO `plant` VALUES (234, '地涌金莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick37181451984798.jpg', 'D');
INSERT INTO `plant` VALUES (235, '八仙花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick48751443087982.jpg', 'B');
INSERT INTO `plant` VALUES (236, '黄花照波', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick49721450947635.jpg', 'H');
INSERT INTO `plant` VALUES (237, '鹿角海棠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick32671441877349.jpg', 'L');
INSERT INTO `plant` VALUES (238, '锦葵', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick32521451898600.jpg', 'J');
INSERT INTO `plant` VALUES (239, '火祭', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick63401441532698.jpg', 'H');
INSERT INTO `plant` VALUES (240, '东京樱花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick23191440409633.jpg', 'D');
INSERT INTO `plant` VALUES (241, '玉兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick81361441791493.jpg', 'Y');
INSERT INTO `plant` VALUES (242, '鸭脚木', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick3111440581679.jpg', 'Y');
INSERT INTO `plant` VALUES (243, '八宝景天', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick63581442308679.jpg', 'B');
INSERT INTO `plant` VALUES (244, '凤尾兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick13461444899797.jpg', 'F');
INSERT INTO `plant` VALUES (245, '水竹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick74291442828434.jpg', 'S');
INSERT INTO `plant` VALUES (246, '金凤花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick16701447408428.jpg', 'J');
INSERT INTO `plant` VALUES (247, '霜之朝', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick28461447320082.jpg', 'S');
INSERT INTO `plant` VALUES (248, '蓝雪花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick2901445938137.jpg', 'L');
INSERT INTO `plant` VALUES (249, '蓝目菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick99851447148491.jpg', 'L');
INSERT INTO `plant` VALUES (250, '白晶菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick91851446717339.jpg', 'B');
INSERT INTO `plant` VALUES (251, '水鬼蕉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick75841446716517.jpg', 'S');
INSERT INTO `plant` VALUES (252, '五十铃玉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick51651446541082.jpg', 'W');
INSERT INTO `plant` VALUES (253, '三色堇', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick62431441188242.jpg', 'S');
INSERT INTO `plant` VALUES (254, '大花葱', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick12841449826388.jpg', 'D');
INSERT INTO `plant` VALUES (255, '红掌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick98771441187701.jpg', 'H');
INSERT INTO `plant` VALUES (256, '雏菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick21551443002548.jpg', 'C');
INSERT INTO `plant` VALUES (257, '黄连木', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick16281443431678.jpg', 'H');
INSERT INTO `plant` VALUES (258, '棕榈', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick54101441790662.jpg', 'Z');
INSERT INTO `plant` VALUES (259, '狗娃花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick95661452504616.jpg', 'G');
INSERT INTO `plant` VALUES (260, '夹竹桃', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick87431441791786.jpg', 'J');
INSERT INTO `plant` VALUES (261, '筒叶花月', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick32471445505010.jpg', 'T');
INSERT INTO `plant` VALUES (262, '子孙球', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick31081451379863.jpg', 'Z');
INSERT INTO `plant` VALUES (263, '红千层', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick40321445419771.jpg', 'H');
INSERT INTO `plant` VALUES (264, '文心兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick57221451983623.jpg', 'W');
INSERT INTO `plant` VALUES (265, '雷童', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick12521448443502.jpg', 'L');
INSERT INTO `plant` VALUES (266, '大花蕙兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick85241440496118.jpg', 'D');
INSERT INTO `plant` VALUES (267, '天狗之舞', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick48221451294704.jpg', 'T');
INSERT INTO `plant` VALUES (268, '光叶子花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick45301452156489.jpg', 'G');
INSERT INTO `plant` VALUES (269, '樱水晶', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick74351453367683.jpg', 'Y');
INSERT INTO `plant` VALUES (270, '刺桐', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick41451444730476.jpg', 'C');
INSERT INTO `plant` VALUES (271, '钓钟柳', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick87611449653386.jpg', 'D');
INSERT INTO `plant` VALUES (272, '孔雀竹芋', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick82831442568772.jpg', 'K');
INSERT INTO `plant` VALUES (273, '虹之玉锦', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick4241445850207.jpg', 'H');
INSERT INTO `plant` VALUES (274, '软枝黄蝉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick56571449741113.jpg', 'R');
INSERT INTO `plant` VALUES (275, '鹅掌藤', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick42181447060021.jpg', 'E');
INSERT INTO `plant` VALUES (276, '羽叶薰衣草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick83571448357876.jpg', 'Y');
INSERT INTO `plant` VALUES (277, '蓝花楹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick64561441965839.jpg', 'L');
INSERT INTO `plant` VALUES (278, '桃金娘', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick41821443002166.jpg', 'T');
INSERT INTO `plant` VALUES (279, '若歌诗', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick50671448960398.jpg', 'R');
INSERT INTO `plant` VALUES (280, '新几内亚凤仙', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick28351450171861.jpg', 'X');
INSERT INTO `plant` VALUES (281, '卡特兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick33941452156679.jpg', 'K');
INSERT INTO `plant` VALUES (282, '月季花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick78761439199251.jpg', 'Y');
INSERT INTO `plant` VALUES (283, '紫娇花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick87021447840583.jpg', 'Z');
INSERT INTO `plant` VALUES (284, '百日草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick46441449047616.jpg', 'B');
INSERT INTO `plant` VALUES (285, '黄刺玫', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick84611444383374.jpg', 'H');
INSERT INTO `plant` VALUES (286, '龙船花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick9681445507134.jpg', 'L');
INSERT INTO `plant` VALUES (287, '卷丹百合', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick38861450691425.jpg', 'J');
INSERT INTO `plant` VALUES (288, '大岩桐', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick82271450864551.jpg', 'D');
INSERT INTO `plant` VALUES (289, '黄金花月', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick63581451467341.jpg', 'H');
INSERT INTO `plant` VALUES (290, '荷包牡丹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick39331449480953.jpg', 'H');
INSERT INTO `plant` VALUES (291, '小苍兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick54011451382522.jpg', 'X');
INSERT INTO `plant` VALUES (292, '夏堇', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick92631447061608.jpg', 'X');
INSERT INTO `plant` VALUES (293, '九里香', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick17421428056277.jpg', 'J');
INSERT INTO `plant` VALUES (294, '燕子掌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick82281439976564.jpg', 'Y');
INSERT INTO `plant` VALUES (295, '长春花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick55371443088504.jpg', 'C');
INSERT INTO `plant` VALUES (296, '鹤望兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick23051440409379.jpg', 'H');
INSERT INTO `plant` VALUES (297, '木芙蓉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick26411439977652.jpg', 'M');
INSERT INTO `plant` VALUES (298, '白花小松', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick45921450689552.jpg', 'B');
INSERT INTO `plant` VALUES (299, '碧玉莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick81401453887420.jpg', 'B');
INSERT INTO `plant` VALUES (300, '飘香藤', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick48241447752354.jpg', 'P');
INSERT INTO `plant` VALUES (301, '鲁氏石莲花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick7711450947424.jpg', 'L');
INSERT INTO `plant` VALUES (302, '秋丽', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick29661448616231.jpg', 'Q');
INSERT INTO `plant` VALUES (303, '六月雪', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick68501439544938.jpg', 'L');
INSERT INTO `plant` VALUES (304, '翠菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick80081451554515.jpg', 'C');
INSERT INTO `plant` VALUES (305, '鸡冠刺桐', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick57581446111055.jpg', 'J');
INSERT INTO `plant` VALUES (306, '白网纹草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick5561447320555.jpg', 'B');
INSERT INTO `plant` VALUES (307, '翡翠景天', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick61571452244522.jpg', 'F');
INSERT INTO `plant` VALUES (308, '假龙头花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick13091451380956.jpg', 'J');
INSERT INTO `plant` VALUES (309, '荷包花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick65861440150564.jpg', 'H');
INSERT INTO `plant` VALUES (310, '假昙花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick76261443431323.jpg', 'J');
INSERT INTO `plant` VALUES (311, '大和锦', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick14521446109320.jpg', 'D');
INSERT INTO `plant` VALUES (312, '鹿角蕨', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick67121446542148.jpg', 'L');
INSERT INTO `plant` VALUES (313, '琴叶珊瑚', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick4201446457037.jpg', 'Q');
INSERT INTO `plant` VALUES (314, '芍药', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick67801444384225.jpg', 'S');
INSERT INTO `plant` VALUES (315, '日本晚樱', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick78011444642683.jpg', 'R');
INSERT INTO `plant` VALUES (316, '蝴蝶花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick29311443087482.jpg', 'H');
INSERT INTO `plant` VALUES (317, '木兰花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick43961441533674.jpg', 'M');
INSERT INTO `plant` VALUES (318, '玫瑰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick95121441014192.jpg', 'M');
INSERT INTO `plant` VALUES (319, '茜之塔', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick6321447059839.jpg', 'Q');
INSERT INTO `plant` VALUES (320, '蒜香藤', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick36431450345019.jpg', 'S');
INSERT INTO `plant` VALUES (321, '半枝莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick84471442309157.jpg', 'B');
INSERT INTO `plant` VALUES (322, '蛛丝卷绢', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick80311449824694.jpg', 'Z');
INSERT INTO `plant` VALUES (323, '清盛锦', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick63961449567244.jpg', 'Q');
INSERT INTO `plant` VALUES (324, '千佛手', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick51541445331959.jpg', 'Q');
INSERT INTO `plant` VALUES (325, '春兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick36641442223694.jpg', 'C');
INSERT INTO `plant` VALUES (326, '大滨菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick26381449480364.jpg', 'D');
INSERT INTO `plant` VALUES (327, '阿拉伯婆婆纳', 'Veronica persica Poi', '原产于亚洲西部及欧洲，分布于中国华东、华中及贵州、云南、西藏东部及新疆', '婆婆纳属', '阿拉伯婆婆纳 （学名：Veronica persica Poir.）是玄参科，婆婆纳属铺散多分枝草本植物，高可达50厘米。叶片短柄，卵形或圆形，腋内生花的称苞片，边缘具钝齿，两面疏生柔毛。总状花序很长；花梗比苞片长，裂片卵状披针形，花冠蓝色、紫色或蓝紫色，雄蕊短于花冠。蒴果肾形，网脉明显，种子背面具深的横纹，3-5月开花。', '阿拉伯婆婆纳容易进行种子繁殖，种子结果量大，生活史很短，生长速度快，生长期长，具有极强的无性繁殖能力，匍匐茎着土易生不定根。阿拉伯婆婆纳种子于4月渐次成熟，经3-4个月的休眠期便可萌发。11月上旬达到出苗高峰。整个冬春季节阿拉伯婆婆纳较好填补了草花花坛裸露地表不足。阿拉伯婆婆纳繁殖能力强。在田间的种子萌发率可达10%以上，而农田其他杂草的种子平均萌发率一般为3.32%。种子在0.1-1厘米土层间萌发率为30%-100%，在3厘米以下出苗较少，浅耕会促使其种子萌发。萌发对土壤湿度的要求比较宽，含水率在20%-40%时具有较高的发芽率，但是在小于10%-大于50%时，种子萌发率极低。粗放管理即可。', '无', 'http://img.boqiicdn.com/Data/BK/P/imagick81241449134514.jpg', 'A');
INSERT INTO `plant` VALUES (328, '荷兰菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick32821440064459.jpg', 'H');
INSERT INTO `plant` VALUES (329, '万寿菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick53261448271956.jpg', 'W');
INSERT INTO `plant` VALUES (330, '仙女杯', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick45241450775491.jpg', 'X');
INSERT INTO `plant` VALUES (331, '静夜', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick48881451897865.jpg', 'J');
INSERT INTO `plant` VALUES (332, '叶子花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick71141446629824.jpg', 'Y');
INSERT INTO `plant` VALUES (333, '迎春花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick39451439287149.jpg', 'Y');
INSERT INTO `plant` VALUES (334, '珍珠吊兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick62441443000755.jpg', 'Z');
INSERT INTO `plant` VALUES (335, '铃兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick11801442224359.jpg', 'L');
INSERT INTO `plant` VALUES (336, '毛娟', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick73031446802560.jpg', 'M');
INSERT INTO `plant` VALUES (337, '金铃花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick40221450691877.jpg', 'J');
INSERT INTO `plant` VALUES (338, '龟背竹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick24791439976961.jpg', 'G');
INSERT INTO `plant` VALUES (339, '海桐', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick51341441877569.jpg', 'H');
INSERT INTO `plant` VALUES (340, '紫薇花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick26041439891316.jpg', 'Z');
INSERT INTO `plant` VALUES (341, '新玉缀', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick21821450344220.jpg', 'X');
INSERT INTO `plant` VALUES (342, '大叶落地生根', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick94161450775934.jpg', 'D');
INSERT INTO `plant` VALUES (343, '石楠花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick5761444383680.jpg', 'S');
INSERT INTO `plant` VALUES (344, '龙骨柱', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick82851446801735.jpg', 'L');
INSERT INTO `plant` VALUES (345, '散尾葵', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick93421441186519.jpg', 'S');
INSERT INTO `plant` VALUES (346, '黑王子', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick84091453713795.jpg', 'H');
INSERT INTO `plant` VALUES (347, '观音莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick8891453799699.jpg', 'G');
INSERT INTO `plant` VALUES (348, '乌羽玉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick37601447665568.jpg', 'W');
INSERT INTO `plant` VALUES (349, '孔雀木', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick78981447752105.jpg', 'K');
INSERT INTO `plant` VALUES (350, '丽娜莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick76651448875736.jpg', 'L');
INSERT INTO `plant` VALUES (351, '石蒜', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick42491440150917.jpg', 'S');
INSERT INTO `plant` VALUES (352, '红花檵木', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick27371445332537.jpg', 'H');
INSERT INTO `plant` VALUES (353, '桃花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick33051438854597.jpg', 'T');
INSERT INTO `plant` VALUES (354, '铁线莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick14021442916077.jpg', 'T');
INSERT INTO `plant` VALUES (355, '睡莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick20931439373866.jpg', 'S');
INSERT INTO `plant` VALUES (356, '雅乐之舞', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick70581441186179.jpg', 'Y');
INSERT INTO `plant` VALUES (357, '橡皮树', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick46421441618381.jpg', 'X');
INSERT INTO `plant` VALUES (358, '白掌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick82341441878218.jpg', 'B');
INSERT INTO `plant` VALUES (359, '金叶女贞', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick83311442223069.jpg', 'J');
INSERT INTO `plant` VALUES (360, '禾雀花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick13981444815100.jpg', 'H');
INSERT INTO `plant` VALUES (361, '茶梅', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick66371444642156.jpg', 'C');
INSERT INTO `plant` VALUES (362, '露娜莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick22011449133260.jpg', 'L');
INSERT INTO `plant` VALUES (363, '巴西鸢尾', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick78531446630637.jpg', 'B');
INSERT INTO `plant` VALUES (364, '塔松', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick3771454404047.jpg', 'T');
INSERT INTO `plant` VALUES (365, '金边瑞香', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick23821444642468.jpg', 'J');
INSERT INTO `plant` VALUES (366, '朱蕉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick93231444729766.jpg', 'Z');
INSERT INTO `plant` VALUES (367, '勿忘我', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick77981440582537.jpg', 'W');
INSERT INTO `plant` VALUES (368, '石竹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick18211445246656.jpg', 'S');
INSERT INTO `plant` VALUES (369, '吊竹梅', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick74301443173509.jpg', 'D');
INSERT INTO `plant` VALUES (370, '铁树', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick96441441532888.jpg', 'T');
INSERT INTO `plant` VALUES (371, '荷花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick56961428055422.jpg', 'H');
INSERT INTO `plant` VALUES (372, '虹之玉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick53031439803630.jpg', 'H');
INSERT INTO `plant` VALUES (373, '垂盆草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick36301442828001.jpg', 'C');
INSERT INTO `plant` VALUES (374, '黄杨', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick9661440408917.jpg', 'H');
INSERT INTO `plant` VALUES (375, '海石竹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick52001449653817.jpg', 'H');
INSERT INTO `plant` VALUES (376, '一品红', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick6601439891835.jpg', 'Y');
INSERT INTO `plant` VALUES (377, '金琥', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick86101440149575.jpg', 'J');
INSERT INTO `plant` VALUES (378, '球松', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick36051447924403.jpg', 'Q');
INSERT INTO `plant` VALUES (379, '姬胧月', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick28031445418898.jpg', 'J');
INSERT INTO `plant` VALUES (380, '唐菖蒲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick60801451295611.jpg', 'T');
INSERT INTO `plant` VALUES (381, '唐印', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick35901450429725.jpg', 'T');
INSERT INTO `plant` VALUES (382, '藏红花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick741441100314.jpg', 'Z');
INSERT INTO `plant` VALUES (383, '邹菊', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick52141428056523.jpg', 'C');
INSERT INTO `plant` VALUES (384, '马蹄莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick40571439200220.jpg', 'M');
INSERT INTO `plant` VALUES (385, '沙漠玫瑰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick75331442915091.jpg', 'S');
INSERT INTO `plant` VALUES (386, '风兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick27111451295168.jpg', 'F');
INSERT INTO `plant` VALUES (387, '鸡蛋花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick91361439373140.jpg', 'J');
INSERT INTO `plant` VALUES (388, '悬铃花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick27301449568506.jpg', 'X');
INSERT INTO `plant` VALUES (389, '熊童子', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick82501440063226.jpg', 'X');
INSERT INTO `plant` VALUES (390, '栀子花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick31381438854285.jpg', 'Z');
INSERT INTO `plant` VALUES (391, '费菜', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick34051448010794.jpg', 'F');
INSERT INTO `plant` VALUES (392, '水仙花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick68511428055718.jpg', 'S');
INSERT INTO `plant` VALUES (393, '梅花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick66611438767173.jpg', 'M');
INSERT INTO `plant` VALUES (394, '黄丽', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick40151441618102.jpg', 'H');
INSERT INTO `plant` VALUES (395, '垂叶榕', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick99581444901534.jpg', 'C');
INSERT INTO `plant` VALUES (396, '文殊兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick15451451467914.jpg', 'W');
INSERT INTO `plant` VALUES (397, '合果芋', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick34671428054815.jpg', 'H');
INSERT INTO `plant` VALUES (398, '洋桔梗', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick82301450259141.jpg', 'Y');
INSERT INTO `plant` VALUES (399, '玉簪花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick89861444297161.jpg', 'Y');
INSERT INTO `plant` VALUES (400, '百合花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick87711440495190.jpg', 'B');
INSERT INTO `plant` VALUES (401, '石楠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick90621440494768.jpg', 'S');
INSERT INTO `plant` VALUES (402, '青星美人', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick43961447751847.jpg', 'Q');
INSERT INTO `plant` VALUES (403, '茉莉花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick80331438768060.jpg', 'M');
INSERT INTO `plant` VALUES (404, '万代兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick4441448444051.jpg', 'W');
INSERT INTO `plant` VALUES (405, '萼距花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick94741449741335.jpg', 'E');
INSERT INTO `plant` VALUES (406, '常春藤', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick40671439804146.jpg', 'C');
INSERT INTO `plant` VALUES (407, '星美人', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick44381440408395.jpg', 'X');
INSERT INTO `plant` VALUES (408, '酒瓶兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick33841444468734.jpg', 'J');
INSERT INTO `plant` VALUES (409, '大丽花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick33821446716143.jpg', 'D');
INSERT INTO `plant` VALUES (410, '倒挂金钟', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick33171443604455.jpg', 'D');
INSERT INTO `plant` VALUES (411, '虎耳草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick34131443001212.jpg', 'H');
INSERT INTO `plant` VALUES (412, '虎尾兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick29661442482550.jpg', 'H');
INSERT INTO `plant` VALUES (413, '郁金香', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick43181439805316.jpg', 'Y');
INSERT INTO `plant` VALUES (414, '飞燕草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick37951443432010.jpg', 'F');
INSERT INTO `plant` VALUES (415, '朱顶红', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick43841446109964.jpg', 'Z');
INSERT INTO `plant` VALUES (416, '芙蓉雪莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick64991449221190.jpg', 'F');
INSERT INTO `plant` VALUES (417, '蔷薇花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick10701441705427.jpg', 'Q');
INSERT INTO `plant` VALUES (418, '南洋杉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick981428055093.jpg', 'N');
INSERT INTO `plant` VALUES (419, '水塔花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick54821447234250.jpg', 'S');
INSERT INTO `plant` VALUES (420, '绿萝', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick46701439198388.jpg', 'L');
INSERT INTO `plant` VALUES (421, '长寿花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick93171439285186.jpg', 'C');
INSERT INTO `plant` VALUES (422, '金花茶', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick39821439804741.jpg', 'J');
INSERT INTO `plant` VALUES (423, '天竺葵', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick20421441878521.jpg', 'T');
INSERT INTO `plant` VALUES (424, '特玉莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick2271447233939.jpg', 'T');
INSERT INTO `plant` VALUES (425, '绯花玉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick57381445590024.jpg', 'F');
INSERT INTO `plant` VALUES (426, '曼陀罗', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick48741439199643.jpg', 'M');
INSERT INTO `plant` VALUES (427, '乌木', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick3081428056199.jpg', 'W');
INSERT INTO `plant` VALUES (428, '向日葵', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick61531439459813.jpg', 'X');
INSERT INTO `plant` VALUES (429, '紫背竹芋', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick98391428055894.jpg', 'Z');
INSERT INTO `plant` VALUES (430, '豆瓣绿', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick76931428055306.jpg', 'D');
INSERT INTO `plant` VALUES (431, '松红梅', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick7781449135161.jpg', 'S');
INSERT INTO `plant` VALUES (432, '白牡丹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick77471428056336.jpg', 'B');
INSERT INTO `plant` VALUES (433, '菊花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick54751439545616.jpg', 'J');
INSERT INTO `plant` VALUES (434, '碰碰香', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick23211439890494.jpg', 'P');
INSERT INTO `plant` VALUES (435, '碧光环', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick31541443086593.jpg', 'B');
INSERT INTO `plant` VALUES (436, '蝴蝶兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick24831441098711.jpg', 'H');
INSERT INTO `plant` VALUES (437, '麒麟掌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick63021441963723.jpg', 'Q');
INSERT INTO `plant` VALUES (438, '吉娃莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick37821444382540.jpg', 'J');
INSERT INTO `plant` VALUES (439, '龙吐珠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick84631445937816.jpg', 'L');
INSERT INTO `plant` VALUES (440, '草玉露', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick37211449652806.jpg', 'C');
INSERT INTO `plant` VALUES (441, '球兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick34441444469318.jpg', 'Q');
INSERT INTO `plant` VALUES (442, '炮仗花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick45701443520053.jpg', 'P');
INSERT INTO `plant` VALUES (443, '鸳鸯茉莉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick20571444901318.jpg', 'Y');
INSERT INTO `plant` VALUES (444, '宝石花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick73781439371850.jpg', 'B');
INSERT INTO `plant` VALUES (445, '仙客来', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick74751441618658.jpg', 'X');
INSERT INTO `plant` VALUES (446, '杜鹃花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick88461438940747.jpg', 'D');
INSERT INTO `plant` VALUES (447, '发财树', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick85091438853639.jpg', 'F');
INSERT INTO `plant` VALUES (448, '韭莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick99781451554757.jpg', 'J');
INSERT INTO `plant` VALUES (449, '姬秋丽', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick6301445937012.jpg', 'J');
INSERT INTO `plant` VALUES (450, '滴水观音', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick44321439372442.jpg', 'D');
INSERT INTO `plant` VALUES (451, '黑法师', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick8201440494551.jpg', 'H');
INSERT INTO `plant` VALUES (452, '蕙兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick38861442569512.jpg', 'H');
INSERT INTO `plant` VALUES (453, '山影拳', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick83021447147462.jpg', 'S');
INSERT INTO `plant` VALUES (454, '文竹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick10721439543978.jpg', 'W');
INSERT INTO `plant` VALUES (455, '蟹爪兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick67901439458054.jpg', 'X');
INSERT INTO `plant` VALUES (456, '垂笑君子兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick62891444816217.jpg', 'C');
INSERT INTO `plant` VALUES (457, '凤尾竹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick24541428055532.jpg', 'F');
INSERT INTO `plant` VALUES (458, '白龙球', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick63591455614546.jpg', 'B');
INSERT INTO `plant` VALUES (459, '黄毛掌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick88601453714987.jpg', 'H');
INSERT INTO `plant` VALUES (460, '粉苞酸脚杆', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick27101452762689.jpg', 'F');
INSERT INTO `plant` VALUES (461, '厚萼凌霄', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick83291453280822.jpg', 'H');
INSERT INTO `plant` VALUES (462, '滇山茶', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick22691452850528.jpg', 'D');
INSERT INTO `plant` VALUES (463, '爆仗竹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick35911453281235.jpg', 'B');
INSERT INTO `plant` VALUES (464, '美丽莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick86001453367358.jpg', 'M');
INSERT INTO `plant` VALUES (465, '青凤凰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick51011454490880.jpg', 'Q');
INSERT INTO `plant` VALUES (466, '樱麒麟', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick21561454060521.jpg', 'Y');
INSERT INTO `plant` VALUES (467, '多花指甲兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick53701453369024.jpg', 'D');
INSERT INTO `plant` VALUES (468, '金晃', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick83661453799270.jpg', 'J');
INSERT INTO `plant` VALUES (469, '彩云球', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick9751455614848.jpg', 'C');
INSERT INTO `plant` VALUES (470, '黄雪光', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick13091455441076.jpg', 'H');
INSERT INTO `plant` VALUES (471, '红花文殊兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick90451452763747.jpg', 'H');
INSERT INTO `plant` VALUES (472, '红花羊蹄甲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick43821439805049.jpg', 'H');
INSERT INTO `plant` VALUES (473, '红辉艳', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick71301454320419.jpg', 'H');
INSERT INTO `plant` VALUES (474, '英冠玉', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick41453886238.jpg', 'Y');
INSERT INTO `plant` VALUES (475, '不夜城芦荟', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick56101442395759.jpg', 'B');
INSERT INTO `plant` VALUES (476, '紫蛮刀', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick94811453973299.jpg', 'Z');
INSERT INTO `plant` VALUES (477, '蓟', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick1421442309769.jpg', 'J');
INSERT INTO `plant` VALUES (478, '大叶莲花掌', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick84741455700832.jpg', 'D');
INSERT INTO `plant` VALUES (479, '五叶地锦', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick18571445590492.jpg', 'W');
INSERT INTO `plant` VALUES (480, '夜合花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick9681447407531.jpg', 'Y');
INSERT INTO `plant` VALUES (481, '花月夜', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick13601454319376.jpg', 'H');
INSERT INTO `plant` VALUES (482, '白车轴草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick36051448617938.jpg', 'B');
INSERT INTO `plant` VALUES (483, '粉紫重瓣木槿', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick76621453280530.jpg', 'F');
INSERT INTO `plant` VALUES (484, '蓝花鼠尾草', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick67941447408159.jpg', 'L');
INSERT INTO `plant` VALUES (485, '结香', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick6921445851651.jpg', 'J');
INSERT INTO `plant` VALUES (486, '野牡丹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick3051446455886.jpg', 'Y');
INSERT INTO `plant` VALUES (487, '彼岸花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick19351441099726.jpg', 'B');
INSERT INTO `plant` VALUES (488, '富贵竹', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick88601439458274.jpg', 'F');
INSERT INTO `plant` VALUES (489, '吊兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick32161439285452.jpg', 'D');
INSERT INTO `plant` VALUES (490, '花毛莨', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick16311445592064.jpg', 'H');
INSERT INTO `plant` VALUES (491, '玉蝶', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick98431441099802.jpg', 'Y');
INSERT INTO `plant` VALUES (492, '兰花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick31061441015519.jpg', 'L');
INSERT INTO `plant` VALUES (493, '王莲', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick19901441013789.jpg', 'W');
INSERT INTO `plant` VALUES (494, '量天尺', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick59361445245627.jpg', 'L');
INSERT INTO `plant` VALUES (495, '铁兰', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick97711440064187.jpg', 'T');
INSERT INTO `plant` VALUES (496, '钱串子', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick52191428056622.jpg', 'Q');
INSERT INTO `plant` VALUES (497, '袖珍椰子', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick11411441100146.jpg', 'X');
INSERT INTO `plant` VALUES (498, '绣球花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick97091441877962.jpg', 'X');
INSERT INTO `plant` VALUES (499, '昙花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick41971441187207.jpg', 'T');
INSERT INTO `plant` VALUES (500, '米兰花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick68961439459080.jpg', 'M');
INSERT INTO `plant` VALUES (501, '帝王花', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick15111447926149.jpg', 'D');
INSERT INTO `plant` VALUES (502, '风信子', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick79391428055079.jpg', 'F');
INSERT INTO `plant` VALUES (503, '桃美人', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick1361441704641.jpg', 'T');
INSERT INTO `plant` VALUES (504, '四季海棠', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick88991447925084.jpg', 'S');
INSERT INTO `plant` VALUES (505, '白粉藤', NULL, NULL, NULL, NULL, NULL, NULL, 'http://img.boqiicdn.com/Data/BK/P/imagick22231448960884.jpg', 'B');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `txt` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `topic_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, '爱养花，爱生活。', '/post-img/1.jpg', 2, 2, '2020-04-01 16:27:27');
INSERT INTO `post` VALUES (2, 'Hoooooooo漂亮~', '/post-img/1.jpg,/post-img/2.jpg', 1, 1, '2020-04-02 16:27:38');
INSERT INTO `post` VALUES (3, '这些花有人想要吗？', '/post-img/1.jpg,/post-img/2.jpg,/post-img/3.jpg', 3, 3, '2020-04-03 16:27:42');
INSERT INTO `post` VALUES (4, '今天这些花娇艳欲滴。', '/post-img/1.jpg,/post-img/2.jpg,/post-img/3.jpg,/post-img/4.jpg', 2, 4, '2020-04-09 16:27:48');
INSERT INTO `post` VALUES (5, '美丽的花儿要和大家分享~', '/post-img/1.jpg,/post-img/2.jpg,/post-img/3.jpg,/post-img/4.jpg,/post-img/5.jpg', 4, 5, '2020-04-14 16:28:02');
INSERT INTO `post` VALUES (6, '一片花海。', '/post-img/1.jpg,/post-img/2.jpg,/post-img/3.jpg,/post-img/4.jpg,/post-img/5.jpg,/post-img/6.jpg', 1, 6, '2020-04-05 16:28:06');
INSERT INTO `post` VALUES (7, '看到这么多美丽的花儿心情真舒畅。', '/post-img/1.jpg,/post-img/2.jpg,/post-img/3.jpg,/post-img/4.jpg,/post-img/5.jpg,/post-img/6.jpg,/post-img/7.jpg', 4, 7, '2020-04-13 16:28:09');
INSERT INTO `post` VALUES (8, '快来看看，快来看看！', '/post-img/1.jpg,/post-img/2.jpg,/post-img/3.jpg,/post-img/4.jpg,/post-img/5.jpg,/post-img/6.jpg,/post-img/7.jpg,/post-img/8.jpg', 2, 8, '2020-04-07 16:28:12');
INSERT INTO `post` VALUES (9, '悠闲惬意的时光~', '/post-img/1.jpg,/post-img/2.jpg,/post-img/3.jpg,/post-img/4.jpg,/post-img/5.jpg,/post-img/6.jpg,/post-img/7.jpg,/post-img/8.jpg,/post-img/9.jpg', 3, 9, '2020-04-21 16:28:17');
INSERT INTO `post` VALUES (10, '养花可以让人心静下来。', '/post-img/7.jpg,/post-img/8.jpg,/post-img/9.jpg', 1, 10, '2020-04-23 09:38:44');
INSERT INTO `post` VALUES (11, '这些花儿太美了。', '/post-img/1.jpg,/post-img/2.jpg,/post-img/3.jpg,/post-img/4.jpg', 4, 11, '2020-04-23 10:12:00');
INSERT INTO `post` VALUES (12, '花花世界迷人眼~', '/post-img/1.jpg,/post-img/2.jpg,/post-img/3.jpg,/post-img/4.jpg,/post-img/5.jpg,/post-img/6.jpg,/post-img/7.jpg,/post-img/8.jpg,/post-img/9.jpg', 1, 11, '2020-04-23 10:38:44');
INSERT INTO `post` VALUES (13, '修心养性。', '/post-img/1.jpg,/post-img/2.jpg,/post-img/3.jpg,/post-img/4.jpg,/post-img/5.jpg', 3, 11, '2020-04-23 10:39:02');
INSERT INTO `post` VALUES (14, '你们觉得漂亮吗？', '/post-img/1.jpg,/post-img/2.jpg', 2, 11, '2020-04-23 10:54:48');
INSERT INTO `post` VALUES (15, '开启养花新生活。', '/post-img/1.jpg,/post-img/2.jpg,/post-img/3.jpg,/post-img/4.jpg,/post-img/5.jpg,/post-img/6.jpg,/post-img/7.jpg,/post-img/8.jpg,/post-img/9.jpg', 3, 1, '2020-05-16 18:44:09');
INSERT INTO `post` VALUES (16, '向日葵太漂亮了！', '/post-img/10.jpg,/post-img/11.jpg,/post-img/12.jpg,/post-img/13.jpg,/post-img/14.jpg,/post-img/15.jpg,/post-img/16.jpg', 5, 12, '2020-05-16 20:46:03');
INSERT INTO `post` VALUES (17, '四哥的一天~', '/post-img/10.jpg,/post-img/11.jpg,/post-img/12.jpg,/post-img/13.jpg,/post-img/14.jpg,/post-img/15.jpg', 10, 2, '2020-05-17 18:44:15');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `content` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`reply_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for thumbsup
-- ----------------------------
DROP TABLE IF EXISTS `thumbsup`;
CREATE TABLE `thumbsup`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `post_id` int(11) NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of thumbsup
-- ----------------------------
INSERT INTO `thumbsup` VALUES (1, 3, 1, '2020-05-23 15:32:20');
INSERT INTO `thumbsup` VALUES (2, 4, 1, '2020-05-17 15:32:24');
INSERT INTO `thumbsup` VALUES (3, 1, 2, NULL);
INSERT INTO `thumbsup` VALUES (4, 1, 3, NULL);
INSERT INTO `thumbsup` VALUES (5, 1, 4, '2020-05-17 15:30:06');
INSERT INTO `thumbsup` VALUES (6, 2, 4, '2020-05-17 15:30:08');
INSERT INTO `thumbsup` VALUES (7, 3, 4, '2020-05-17 15:30:11');
INSERT INTO `thumbsup` VALUES (8, 5, 4, '2020-05-17 15:30:13');
INSERT INTO `thumbsup` VALUES (9, 1, 5, NULL);
INSERT INTO `thumbsup` VALUES (10, 1, 6, NULL);
INSERT INTO `thumbsup` VALUES (11, 1, 6, NULL);
INSERT INTO `thumbsup` VALUES (12, 1, 7, NULL);
INSERT INTO `thumbsup` VALUES (13, 1, 8, NULL);
INSERT INTO `thumbsup` VALUES (14, 1, 9, NULL);
INSERT INTO `thumbsup` VALUES (15, 1, 9, NULL);
INSERT INTO `thumbsup` VALUES (16, 1, 9, NULL);
INSERT INTO `thumbsup` VALUES (17, 1, 9, NULL);
INSERT INTO `thumbsup` VALUES (18, 1, 9, NULL);
INSERT INTO `thumbsup` VALUES (19, 1, 9, NULL);
INSERT INTO `thumbsup` VALUES (20, 1, 10, NULL);
INSERT INTO `thumbsup` VALUES (21, 1, 1, '2020-05-16 09:21:23');
INSERT INTO `thumbsup` VALUES (22, 1, 14, '2020-05-16 19:05:13');
INSERT INTO `thumbsup` VALUES (23, 2, 16, '2020-05-17 18:24:20');
INSERT INTO `thumbsup` VALUES (24, 2, 16, '2020-05-17 20:46:56');
INSERT INTO `thumbsup` VALUES (25, 2, 15, '2020-06-02 09:23:57');
INSERT INTO `thumbsup` VALUES (26, 2, 8, '2020-06-02 20:59:52');
INSERT INTO `thumbsup` VALUES (27, 2, 8, '2020-06-02 21:00:39');
INSERT INTO `thumbsup` VALUES (28, 2, 16, '2020-06-03 11:14:47');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`topic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES (1, '#爱花展示#');
INSERT INTO `topic` VALUES (2, '#阳台养花#');
INSERT INTO `topic` VALUES (3, '#今日花事#');
INSERT INTO `topic` VALUES (4, '#生活要有花#');
INSERT INTO `topic` VALUES (5, '#花花世界#');
INSERT INTO `topic` VALUES (6, '#花友交流#');
INSERT INTO `topic` VALUES (7, '#爱花互换#');
INSERT INTO `topic` VALUES (8, '#养花日记#');
INSERT INTO `topic` VALUES (9, '#识花鉴花#');
INSERT INTO `topic` VALUES (10, '#开心一天#');
INSERT INTO `topic` VALUES (11, '#云赏花#');
INSERT INTO `topic` VALUES (12, '#百花迎春#');
INSERT INTO `topic` VALUES (13, '#今日萌宠#');
INSERT INTO `topic` VALUES (14, '#早安日签#');
INSERT INTO `topic` VALUES (15, '#艺术插花#');
INSERT INTO `topic` VALUES (16, '#夏花绚烂#');
INSERT INTO `topic` VALUES (17, '#盛夏花语#');
INSERT INTO `topic` VALUES (18, '#秋日美好时光#');
INSERT INTO `topic` VALUES (19, '#冬之物语#');
INSERT INTO `topic` VALUES (20, '#多肉植物#');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '爱花展示');
INSERT INTO `type` VALUES (2, '花友换花');
INSERT INTO `type` VALUES (3, '兰花专区');
INSERT INTO `type` VALUES (4, '多肉植物');
INSERT INTO `type` VALUES (5, '月季专区');
INSERT INTO `type` VALUES (6, '造园交流');
INSERT INTO `type` VALUES (7, '养花日记');
INSERT INTO `type` VALUES (8, '心情树洞');
INSERT INTO `type` VALUES (9, '萌宠家园');
INSERT INTO `type` VALUES (10, '花友生活秀');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(1) NULL DEFAULT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profile` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '刘能', '123456', 1, '河北省石家庄市', '随风奔跑自由是方向~', '/header-img/1.jpg');
INSERT INTO `user` VALUES (2, '赵四', '123456', 1, '辽宁省铁岭市', '念桥边红药，年年知为谁生。', '/header-img/2.jpg');
INSERT INTO `user` VALUES (3, '广坤', '123456', 1, '北京市海淀区', '一蓑烟雨任平生。', '/header-img/3.jpg');
INSERT INTO `user` VALUES (4, '王老七', '123456', 1, '山东省青岛市', '小舟从此逝，江海寄余生。', '/header-img/4.jpg');
INSERT INTO `user` VALUES (5, '谢大脚', '123456', 2, '美国加利福尼亚州', '大江东去，浪淘尽，千古风流人物。', '/header-img/5.jpg');
INSERT INTO `user` VALUES (6, '王长贵', '123456', 1, '天津市和平区', '此心安处是吾乡。', '/header-img/6.jpg');
INSERT INTO `user` VALUES (7, '赵玉田', '123456', 1, '河北省秦皇岛市', '夜阑对酒处，依旧梦魂中。 ', '/header-img/7.jpg');
INSERT INTO `user` VALUES (8, '王大拿', '123456', 1, '河北省唐山市', '少年听雨歌楼上，红烛昏罗帐。', '/header-img/8.jpg');
INSERT INTO `user` VALUES (9, '刘大脑袋', '123456', 1, '河北省保定市', '壮年听雨客舟中，江阔云低，断雁叫西风。', '/header-img/9.jpg');
INSERT INTO `user` VALUES (10, '永强娘', '123456', 2, '广东省深圳市', '而今听雨僧庐下，鬓已星星也。', '/header-img/10.jpg');
INSERT INTO `user` VALUES (11, '谢腾飞', '123456', 1, '黑龙江省齐齐哈尔市', '莫惜尊前仔细看，应是容颜老。', '/header-img/11.jpg');
INSERT INTO `user` VALUES (12, '小葵花', '123456', 2, '日本北海道', '渡船春雨至，船上伞高低。', '/header-img/12.jpg');

SET FOREIGN_KEY_CHECKS = 1;

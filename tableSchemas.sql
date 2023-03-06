CREATE SEQUENCE"District_id_seq"MAXVALUE 32 CYCLE;
CREATE TABLE"District"(
	"id"int2 DEFAULT"nextval"('"District_id_seq"'::"regclass")PRIMARY KEY,
	"name"varchar NOT NULL UNIQUE
);
ALTER SEQUENCE"District_id_seq"OWNED BY"District"."id";
COMMENT ON COLUMN"District"."id"IS'主鍵';
COMMENT ON COLUMN"District"."name"IS'名稱';
COMMENT ON TABLE"District"IS'行政區';
-- 
INSERT INTO"District"("name")VALUES
(E'臺北市'),(E'基隆市'),(E'新北市'),(E'宜蘭縣'),(E'釣魚臺列嶼'),(E'新竹市'),(E'新竹縣'),(E'桃園市'),(E'苗栗縣'),(E'臺中市'),(E'彰化縣'),(E'南投縣'),(E'嘉義市'),(E'嘉義縣'),(E'雲林縣'),(E'臺南市'),(E'高雄市'),(E'南海諸島'),(E'澎湖縣'),(E'屏東縣'),(E'花蓮縣'),(E'金門縣'),(E'連江縣');

CREATE SEQUENCE"FinancialInstitution_id_seq"MAXVALUE 32767 CYCLE;
CREATE TABLE"FinancialInstitution"(
	"id"int2 DEFAULT"nextval"('"FinancialInstitution_id_seq"'::"regclass")PRIMARY KEY,
	"code"varchar NOT NULL,
	"name"varchar NOT NULL UNIQUE,
	"shown"bool NOT NULL DEFAULT'0'
);
ALTER SEQUENCE"FinancialInstitution_id_seq"OWNED BY"FinancialInstitution"."id";
COMMENT ON COLUMN"FinancialInstitution"."id"IS'主鍵';
COMMENT ON COLUMN"FinancialInstitution"."code"IS'代碼';
COMMENT ON COLUMN"FinancialInstitution"."name"IS'金融機構名稱';
COMMENT ON COLUMN"FinancialInstitution"."shown"IS'顯示與否';
COMMENT ON TABLE"FinancialInstitution"IS'金融機構';
-- 
INSERT INTO"FinancialInstitution"("code","name")VALUES(E'004',E'臺灣銀行'),(E'005',E'土地銀行'),(E'006',E'合庫商銀'),(E'007',E'第一銀行'),(E'008',E'華南銀行'),(E'009',E'彰化銀行'),(E'011',E'上海銀行'),(E'012',E'台北富邦'),(E'013',E'國泰世華'),(E'016',E'高雄銀行'),(E'017',E'兆豐商銀'),(E'018',E'農業金庫'),(E'021',E'花旗(台灣)銀行'),(E'022',E'美國銀行'),(E'025',E'首都銀行'),(E'039',E'澳盛(台灣)銀行'),(E'040',E'中華開發'),(E'050',E'臺灣企銀'),(E'052',E'渣打商銀'),(E'053',E'台中銀行'),(E'054',E'京城商銀'),(E'072',E'德意志銀行'),(E'075',E'東亞銀行'),(E'081',E'匯豐(台灣)銀行'),(E'101',E'瑞興銀行'),(E'102',E'華泰銀行'),(E'103',E'臺灣新光商銀'),(E'104',E'台北五信'),(E'108',E'陽信銀行'),(E'114',E'基隆一信'),(E'115',E'基隆二信'),(E'118',E'板信銀行'),(E'119',E'淡水一信'),(E'120',E'淡水信合社'),(E'124',E'宜蘭信合社'),(E'127',E'桃園信合社'),(E'130',E'新竹一信'),(E'132',E'新竹三信'),(E'146',E'台中二信'),(E'147',E'三信銀行'),(E'158',E'彰化一信'),(E'161',E'彰化五信'),(E'162',E'彰化六信'),(E'163',E'彰化十信'),(E'165',E'鹿港信合社'),(E'178',E'嘉義三信'),(E'188',E'台南三信'),(E'204',E'高雄三信'),(E'215',E'花蓮一信'),(E'216',E'花蓮二信'),(E'222',E'澎湖一信'),(E'223',E'澎湖二信'),(E'224',E'金門信合社');
INSERT INTO"FinancialInstitution"("code","name","shown")VALUES(E'700',E'中華郵政','1');
INSERT INTO"FinancialInstitution"("code","name")VALUES(E'803',E'聯邦銀行'),(E'805',E'遠東銀行'),(E'806',E'元大銀行'),(E'807',E'永豐銀行');
INSERT INTO"FinancialInstitution"("code","name","shown")VALUES(E'808',E'玉山銀行','1');
INSERT INTO"FinancialInstitution"("code","name")VALUES(E'809',E'凱基銀行'),(E'810',E'星展(台灣)銀行'),(E'812',E'台新銀行'),(E'814',E'大眾銀行'),(E'815',E'日盛銀行'),(E'816',E'安泰銀行'),(E'822',E'中國信託');

CREATE SEQUENCE"Industry_id_seq"MAXVALUE 32767 CYCLE;
CREATE TABLE"Industry"(
	"id"int2 DEFAULT"nextval"('"Industry_id_seq"'::"regclass")PRIMARY KEY,
	"name"varchar NOT NULL UNIQUE,
	"sequential"int2 NOT NULL UNIQUE
);
ALTER SEQUENCE"Industry_id_seq"OWNED BY"Industry"."id";
COMMENT ON COLUMN"Industry"."id"IS'主鍵';
COMMENT ON COLUMN"Industry"."name"IS'名稱';
COMMENT ON COLUMN"Industry"."sequential"IS'順序';
COMMENT ON TABLE"Industry"IS'行業別';
-- 
INSERT INTO"Industry"("name","sequential")VALUES
(E'軍公教','1'),(E'服務業','2'),(E'資訊業','3'),(E'自由業','4'),(E'金融業','5'),(E'待業中','6'),(E'學生','7');

CREATE SEQUENCE"Soldier_id_seq"MAXVALUE 2147483647 CYCLE;
CREATE TABLE"Soldier"(
	"id"int4 DEFAULT"nextval"('"Soldier_id_seq"'::"regclass")PRIMARY KEY,
	"name"varchar NOT NULL,
	"email"varchar NOT NULL UNIQUE,
	"emailVerified"bool NOT NULL,
	"password"varchar NOT NULL,
	"birth"date NOT NULL,
	"gender"bool NOT NULL,
	"forbidden"bool NOT NULL DEFAULT'0',
	"cellular"varchar UNIQUE,
	"district"int2 REFERENCES"District"("id")ON DELETE RESTRICT ON UPDATE CASCADE,
	"financialInstitution"int2 REFERENCES"FinancialInstitution"("id")ON DELETE RESTRICT ON UPDATE CASCADE,
	"financialAccountHolder"varchar,
	"financialAccountNumber"varchar,
	"industry"int2 REFERENCES"Industry"("id")ON DELETE RESTRICT ON UPDATE CASCADE,
	UNIQUE("financialInstitution","financialAccountNumber")
);
ALTER SEQUENCE"Soldier_id_seq"OWNED BY"Soldier"."id";
COMMENT ON COLUMN"Soldier"."id"IS'主鍵';
COMMENT ON COLUMN"Soldier"."name"IS'全名';
COMMENT ON COLUMN"Soldier"."email"IS'電子郵件';
COMMENT ON COLUMN"Soldier"."emailVerified"IS'電子郵件已認證';
COMMENT ON COLUMN"Soldier"."password"IS'密碼';
COMMENT ON COLUMN"Soldier"."birth"IS'生日';
COMMENT ON COLUMN"Soldier"."gender"IS'性別';
COMMENT ON COLUMN"Soldier"."forbidden"IS'被禁止';
COMMENT ON COLUMN"Soldier"."cellular"IS'手機';
COMMENT ON COLUMN"Soldier"."district"IS'行政區';
COMMENT ON COLUMN"Soldier"."financialInstitution"IS'金融機構';
COMMENT ON COLUMN"Soldier"."financialAccountHolder"IS'金融帳戶戶名';
COMMENT ON COLUMN"Soldier"."financialAccountNumber"IS'金融帳戶號碼';
COMMENT ON COLUMN"Soldier"."industry"IS'職業';
COMMENT ON TABLE"Soldier"IS'網兵';

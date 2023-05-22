/*
 Navicat Premium Data Transfer

 Source Server         : 1.14黄gg-pgsql
 Source Server Type    : PostgreSQL
 Source Server Version : 110000
 Source Host           : 192.168.1.14:5432
 Source Catalog        : search
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 110000
 File Encoding         : 65001

 Date: 21/05/2023 15:04:09
*/


-- ----------------------------
-- Sequence structure for ci_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."ci_id_seq";
CREATE SEQUENCE "public"."ci_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for ci
-- ----------------------------
DROP TABLE IF EXISTS "public"."ci";
CREATE TABLE "public"."ci" (
  "id" int8 NOT NULL GENERATED ALWAYS AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
),
  "ci" varchar[] COLLATE "pg_catalog"."default",
  "app_id" int4,
  "content" text COLLATE "pg_catalog"."default",
  "app_name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of ci
-- ----------------------------
INSERT INTO "public"."ci" VALUES (1, '{流,流量,量}', NULL, '流量', NULL);
INSERT INTO "public"."ci" VALUES (2, '{社会主义,标,建设,义,复兴,复,华,任务,社会主义现代化,族,中华民族,发,民,国家,展,化,目标,作出,会,进,作,伟,伟大,务,面,代,大,全,推,中,发展,目,全面,现,兴,家,为,建,出,任,主,国,设,社,推进,现代化}', NULL, '发展目标任务，为全面建设社会主义现代化国家、全面推进中华民族伟大复兴作出', NULL);
INSERT INTO "public"."ci" VALUES (3, '{group,a,c,d,e,f,g,h,i,n,thread,o,fenci-group@fenci-thread-,p,2,r,t,u,fenci,fenci-group@fenci-thread-2}', NULL, 'fenci-Group@fenci-Thread-2', NULL);
INSERT INTO "public"."ci" VALUES (4, '{p,q,a,r,r,requestparam,s,t,e,u,requestparam,m}', NULL, 'RequestParam', NULL);
INSERT INTO "public"."ci" VALUES (5, '{最,厉害,一,的,没有,最厉害,厉,有,进化,上,手,之,和,双,进化史,史上,化,官,进,之一,生,没,器,攻击,是,生命,史,害,嘴,双手,人,器官,攻,击,命}', NULL, '人的双手和嘴，是生命进化史上最厉害的攻击器官，没有之一。', NULL);
INSERT INTO "public"."ci" VALUES (6, '{最,一,吃,的,者,了,成多,有,进化,二,渐渐,于,后,成,渐,撒,就是,化,多,通,吃喝拉撒,喝,原,生,来说,生物,用,动,之后,别,原口,是,唯,就,生物进化,区,区别,唯一,叫做,但,细,拉,动物,之,只有,的话,细胞,俗,做,进,话,胞,口,来,但却,物,只,叫,通俗,吃喝,关于,二者,关,却,说}', NULL, '关于二者的区别，用最通俗的话来说就是，生物进化成多细胞动物之后，就渐渐有了口，但却只有唯一的口吃喝拉撒，叫做原口', NULL);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."ci_id_seq"
OWNED BY "public"."ci"."id";
SELECT setval('"public"."ci_id_seq"', 7, true);

-- ----------------------------
-- Indexes structure for table ci
-- ----------------------------
CREATE INDEX "ci_gin_index" ON "public"."ci" USING gin (
  "ci" COLLATE "pg_catalog"."default" "pg_catalog"."array_ops"
);

-- ----------------------------
-- Primary Key structure for table ci
-- ----------------------------
ALTER TABLE "public"."ci" ADD CONSTRAINT "ci_pkey" PRIMARY KEY ("id");

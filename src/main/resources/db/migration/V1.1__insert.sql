/*
 userテーブルへのInsert情報
    パスワードは文字列「password」を、SHA256でハッシュ化。
    性別は "0"（男性）、"1"（女性）。
*/
INSERT INTO user (first_name, last_name, sex, mail_address, password) VALUES
 ('Nozomi'    , 'Akamatsu'  , '1', 'nozomi_akamatsu@zpsou.bjxb.mj' , 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86')
,('Ichirou'   , 'Takao'     , '0', 'ichirou263@rhrsems.gwu.bue'    , 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86')
,('Yuzuki'    , 'Oka'       , '1', 'ioka@dzsw.gyc'                 , 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86')
,('Tatsuo'    , 'Nakatani'  , '0', 'tatsuo962@wykcfuwx.sz.ilh'     , 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86')
,('Reika'     , 'Funaki'    , '1', null                            , 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86')
,('Matsutarou', 'Matsushita', '0', 'Matsutarou_Matsushita@cqpmb.mz', 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86')
,('Nanami'    ,  'Minato'   , '1', 'nanamiminato@gevjylkemp.qvn'   , 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86')
,('Takuya'    , 'Oda'       , '0', null                            , 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86')
;

/* foodテーブルへのInsert情報 */
INSERT INTO food (item_name, price) VALUES ('apple', 100), ('meat', 150), ('egg', 198);

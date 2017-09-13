/* userテーブル */
CREATE TABLE user (
      id            BIGINT          PRIMARY KEY AUTO_INCREMENT
    , password      VARCHAR(128)    NOT NULL
    , first_name    VARCHAR(100)    NOT NULL
    , last_name     VARCHAR(100)    NOT NULL
    , sex           CHAR(1)         NOT NULL
    , mail_address  VARCHAR(255)
    , created_at    TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP
    , updated_at    TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP
);

/* foodテーブル */
CREATE TABLE food (
      id            BIGINT          PRIMARY KEY AUTO_INCREMENT
    , item_name     VARCHAR(255)    NOT NULL
    , price         INT             NOT NULL
    , category_id   INT             NOT NULL
    , created_at    TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP
    , updated_at    TIMESTAMP       NOT NULL DEFAULT CURRENT_TIMESTAMP
);

/** 食べ物カテゴリ */
CREATE TABLE  food_category (
    category_id     INT           PRIMARY KEY
  , category_name   VARCHAR(100)  NOT NULL
  , created_at      TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP
  , updated_at      TIMESTAMP     NOT NULL  DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO user (
      password
    , first_name
    , last_name
    , sex
    /*%if user.mailAddress != null */
    , mail_address
    /*%end */
    , created_at
    , updated_at
) VALUES (
      /* user.password */'password'
    , /* user.fullName.getFirstName() */'Taro'
    , /* user.fullName.getLastName() */'Tanaka'
    , /* user.sex */'1'
    /*%if user.mailAddress != null */
    , /* user.mailAddress */'test@mail.com'
    /*%end */
    , CURRENT_TIMESTAMP()
    , CURRENT_TIMESTAMP()
);

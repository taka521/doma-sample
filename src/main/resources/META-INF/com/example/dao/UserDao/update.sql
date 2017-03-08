UPDATE
    user
SET
      first_name = /* user.fullName.getFirstName() */'Taro'
    , last_name = /* user.fullName.getLastName() */'Tanaka'
    , sex = /* user.sex */'0'
    /*%if user.mailAddress != null */
    , mail_address = /* user.mailAddress */'test@mail.com'
    /*%end */
    /*%if @isNotBlank(user.password.getValue()) */
    , password = /* user.password */'password'
    /*%end */
WHERE
    id = /* user.id */0
;

/**
    DomaではOptionalでラップされた値はOptionalとして扱わず、
    その要素として扱うため、Optional#isPresent()メソッドは使えない。
*/

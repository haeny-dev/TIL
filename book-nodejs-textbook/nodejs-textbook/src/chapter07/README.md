# Chapter07. MySQL

## ๐ 7.1 ๋ฐ์ดํฐ๋ฒ ์ด์ค๋?

- ๋ฐ์ดํฐ๋ฒ ์ด์ค

  - ๊ด๋ จ์ฑ์ ๊ฐ์ง๋ฉฐ ์ค๋ณต์ด ์๋ ๋ฐ์ดํฐ๋ค์ ์งํฉ์ด๋ค.
  - ์ด๋ฌํ ๋ฐ์ดํฐ๋ฒ ์ด์ค๋ฅผ ๊ด๋ฆฌํ๋ ์์คํ์ DBMS(DataBase Management System)๋ผ๊ณ  ๋ถ๋ฅธ๋ค.

- RDBMS(Relational DBMS)
  - ๊ด๊ณํ DBMS
  - Oracle, MySQL, MSSQL ๋ฑ์ด ์๋ค.

## ๐ 7.2 MySQL ์ค์นํ๊ธฐ

- homebrew ๋ก ์ค์น

  ```
  brew install mysql
  ```

- mysql ์คํ

  ```
  brew services start mysql
  ```

- root ๋น๋ฐ๋ฒํธ ์ค์ 
  ```
  mysql_secure_installation
  ```
- root ๊ณ์  ์คํ
  ```
  mysql -h localhost -u root -p
  ```

## ๐ 7.3 ์ํฌ๋ฒค์น ์ค์นํ๊ธฐ

- homebrew ๋ก ์ค์น

  ```
  brew install --cask mysqlworkbench
  ```

## ๐ 7.4 ๋ฐ์ดํฐ๋ฒ ์ด์ค ๋ฐ ํ์ด๋ธ ์์ฑํ๊ธฐ

- ๋ฐ์ดํฐ๋ฒ ์ด์ค ์์ฑํ๊ธฐ

  ```sql
  CREATE SCHEMA 'nodejs' DEFAULT CHARACTER SET utf8;
  ```

- ํ์ด๋ธ ์์ฑํ๊ธฐ

  ```sql
  CREATE TABLE nodejs.users (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    age INT UNSIGNED NOT NULL,
    married TINYINT NOT NULL,
    comment TEXT NULL,
    created_at DATETIME NOT NULL DEFAULT now(),
    PRIMARY KEY(id),
    UNIQUE INDEX name_UNIQUE (name ASC)
  )
  COMMENT = '์ฌ์ฉ์ ์ ๋ณด'
  DEFAULT CHARACTER SET = utf8
  ENGINE = InnoDB;
  ```

  - ์ปฌ๋ผ์ ๋ํ ์ค์ 
  - _์๋ฃํ_

    - `INT`
    - : ์ ์๋ฅผ ์๋ฏธํ๋ค. ์์๊น์ง ์ ์ฅํ๊ณ  ์ถ๋ค๋ฉด FLOAT, DOUBLE ์๋ฃํ์ ์ฌ์ฉํ๋ฉด ๋๋ค.
    - `VARCHAR(์๋ฆฟ์)`
    - : `CHAR` ๋ผ๋ ์๋ฃํ๋ ์๊ณ , CHAR๋ ๊ณ ์  ๊ธธ์ด๊ณ , VARCHAR๋ ๊ฐ๋ณ ๊ธธ์ด๋ฅผ ๊ฐ์ง๋ค.
    - `TEXT`
    - : ๊ธด ๊ธ์ ์ ์ฅํ  ๋ ์ฌ์ฉํ๋ฉฐ, ์๋ฐฑ ์ ์ด๋ด์ ๋ฌธ์์ด์ ๋ณดํต VARCHAR๋ก ๋ง์ด ์ฒ๋ฆฌํ๊ณ , ๊ทธ๋ณด๋ค ๊ธธ๋ฉด TEXT๋ก ์ฒ๋ฆฌํ๋ค.
    - `TINYINT`
    - : -128๋ถํฐ 127๊น์ง์ ์ ์๋ฅผ ์ ์ฅํ  ๋ ์ฌ์ฉํ๋ค. 1 ๋๋ 0๋ง ์ ์ฅํ๋ค๋ฉด boolean๊ฐ๊ณผ ๊ฐ์ ์ญํ ์ ํ  ์ ์๋ค.
    - `DATETIME`
    - : ๋ ์ง์ ์๊ฐ์ ๋ํ ์ ๋ณด๋ฅผ ๋ด๊ณ  ์๊ณ , ๋ ์ง ์ ๋ณด๋ง ๋ด๋ DATE์ ์๊ฐ ์ ๋ณด๋ง ๋ด๋ TIME ์๋ฃํ๋ ์๋ค.
    - ์ด ์ธ์๋ ๋ง์ ์๋ฃํ์ด ์๋ค.

  - _์ต์_

    - `NULL` or `NOT NULL`
    - : ๋น์นธ์ ํ์ฉํ ์ง ์ฌ๋ถ๋ฅผ ๋ฌป๋ ์ต์์ด๋ค.
    - `AUTO_INCREMENT`
    - : ์๋์ผ๋ก ์ฆ๊ฐํ๋ ๊ฐ์ ๋ฃ์ด์ฃผ๋ ์ต์์ด๋ค.
    - `UNSIGNED`
    - : ์ซ์ ์๋ฃํ์ ์ ์ฉ๋๋ ์ต์์ด๋ค.
    - : ์ซ์ ์๋ฃํ์ ๊ธฐ๋ณธ์ ์ผ๋ก ์์ ๋ฒ์๋ฅผ ์ง์ํ๋๋ฐ, ์๋ฅผ ๋ค์ด INT๋ -2147483648 ~ 2147483647 ๊น์ง์ ์ซ์๋ฅผ ์ ์ฅํ  ์ ์๋ค. UNSIGNED ๊ฐ ์ ์ฉ๋์ด ์๋ค๋ฉด ์์๋ ๋ฌด์๋๊ณ  0 ~ 4294967295 ๊น์ง ์ ์ฅํ  ์ ์๋ค.
    - : FLOAT ๊ณผ DOUBLE ์๋ ์ ์ฉ ๋ถ๊ฐ๋ฅํ๋ค.
    - `ZEROFILL`
    - : ์ซ์์ ์๋ฆฟ์๊ฐ ๊ณ ์ ๋์ด ์์ ๋ ์ฌ์ฉํ  ์ ์๋ค.
    - : ์๋ฃํ์ผ๋ก INT ๋์  INT(์๋ฆฟ์)์ฒ๋ผ ํํํ๋ ๊ฒฝ์ฐ์ ZEROFILL์ ์ค์ ํด๋๋ค๋ฉด ๋น์ด ์๋ ์๋ฆฌ์ ๋ชจ๋ 0์ ๋ฃ๋๋ค.
    - `DEFAULT now()`
    - : ๋ฐ์ดํฐ๋ฒ ์ด์ค ์ ์ฅ ์ ํด๋น ์ปฌ๋ผ์ ๊ฐ์ด ์๋ค๋ฉด MySQL์ด ๊ธฐ๋ณธ๊ฐ์ ๋์  ๋ฃ๋๋ค.
    - : now()๋ ํ์ฌ ์๊ฐ์ ๋ฃ์ผ๋ผ๋ ๋ป์ด๋ค.
    - : now() ๋์  CURRENT_TIMESTAMP๋ฅผ ์ ์ด๋ ๊ฐ์ ๋ป์ด ๋๋ค.
    - `PRIMARY KEY`
    - : ํด๋น ์ปฌ๋ผ์ด ๊ธฐ๋ณธ ํค์ธ ๊ฒฝ์ฐ ์ค์ ํ๋ค.
    - `UNIQUE INDEX`
    - : ํด๋น ๊ฐ์ด ๊ณ ์ ํด์ผ ํ๋์ง์ ๋ํ ์ต์์ด๋ค.
    - : ๊ธฐ๋ณธํค๋ ์ฌ์ค ๊ณ ์ ํด์ผ ํ์ง๋ง PRIMARY KEY๋ ์๋์ผ๋ก UNIQUE INDEX๋ฅผ ํฌํจํ๋ฏ๋ก ๋ฐ๋ก ์ ์ง ์์๋ ๋๋ค.

  - ํ์ด๋ธ์ ๋ํ ์ค์ 
    - `COMMENT`
    - : ํ์ด๋ธ์ ๋ํ ๋ณด์ถฉ ์ค๋ช์ ์๋งํ๋ค. ์ด ํ์ด๋ธ์ด ๋ฌด์จ ์ญํ ์ ํ๋์ง ์ ์ด๋๋ฉด ๋๋ค.
    - `DEFAULT CHARACTER SET`
    - : utf8๋ก ์ค์ ํ์ง ์์ผ๋ฉด ํ๊ธ์ด ์๋ ฅ๋์ง ์๋๋ค.
    - `ENGINE`
    - : ์ฌ๋ฌ ๊ฐ์ง๊ฐ ์์ง๋ง, MyISAM๊ณผ InnoDB๊ฐ ์ ์ผ ๋ง์ด ์ฌ์ฉ๋๋ค.

- ํ์ด๋ธ ์ ๋ณดํ์ธ

  ```sql
  DESC users;
  ```

- ํ์ด๋ธ ์ญ์ 

  ```sql
  DROP TABLE users;
  ```

## ๐ 7.5 CRUD ์์ํ๊ธฐ

- Create(์์ฑ)

  ```sql
  INSERT INTO nodejs.users(name, age, married, comment) VALUES('zero', 24, 0, '์๊ธฐ์๊ฐ1');
  INSERT INTO nodejs.users(name, age, married, comment) VALUES('nero', 32, 1, '์๊ธฐ์๊ฐ2');
  INSERT INTO nodejs.comments(commenter, comment) VALUES(1, '์๋ํ์ธ์. zero์ ๋๊ธ์๋๋ค.');
  ```

- Read(์กฐํ)

  ```sql
  SELECT * FROM nodejs.users;
  SELECT * FROM nodejs.comments;

  SELECT name, married FROM nodejs.users;

  SELECT name, age FROM nodejs.users WHERE married = 1 AND age > 30;
  SELECT id, name FROM nodejs.users WHERE married = 0 OR age > 30;

  SELECT id, name FROM nodejs.users ORDER BY age DESC;
  SELECT id, name FROM nodejs.users ORDER BY age DESC LIMIT 1;
  SELECT id, name FROM nodejs.users ORDER BY age DESC LIMIT 1 OFFSET 1;
  ```

- Update(์์ )

  ```sql
  UPDATE nodejs.users SET comment = '๋ฐ๊ฟ ๋ด์ฉ' WHERE id = 2;
  ```

- Delete(์ญ์ )
  ```sql
  DELETE FROM nodejs.users WHERE id = 2;
  ```

## ๐ 7.6 ์ํ๋ผ์ด์ฆ ์ฌ์ฉํ๊ธฐ

- ๋ธ๋์์ MySQL ์์์ ์ฝ๊ฒ ํ  ์ ์๋๋ก ๋์์ฃผ๋ ๋ผ์ด๋ธ๋ฌ๋ฆฌ์ด๋ค.
- ์ํ๋ผ์ด์ฆ๋ ORM(Object-relational Mapping)์ผ๋ก ๋ถ๋ฅ๋๋ค.
  - ์ํ๋ผ์ด์ฆ๋ฅผ ์ฌ์ฉํ๋ ์ด์ ๋ ์๋ฐ์คํฌ๋ฆฝํธ ๊ตฌ๋ฌธ์ ์์์ SQL๋ก ๋ฐ๊ฟ์ฃผ๊ธฐ ๋๋ฌธ์ด๋ค.

### โ 7.6.4 ์ฟผ๋ฆฌ ์์๋ณด๊ธฐ

- `create`

  ```sql
  INSERT INTO nodejs.users(name, age, married, comment) VALUES ('zero', 24, 0, '์๊ธฐ์๊ฐ1')
  ```

  ```javascript
  const User = require('../models')
  User.create({
    name: 'zero',
    age: 24,
    married: 0,
    comment: '์๊ธฐ์๊ฐ1',
  })
  ```

- `findAll`

  ```sql
  SELECT * FROM nodejs.users
  ```

  ```javascript
  User.findAll({})
  ```

- `findOne`

  ```sql
  SELECT * FROM nodejs.users LIMIT 1
  ```

  ```javascript
  User.findOne({})
  ```

- `attributes` ์ต์

  ```sql
  SELECT name, married FROM nodejs.users
  ```

  ```javascript
  User.findAll({
    attributes: ['name', 'married'],
  })
  ```

- `where` ์ต์

  ```sql
  SELECT name, age FROM nodejs.users WHERE married = 1 AND age > 30
  ```

  ```javascript
  const { Op } = require('sequelize')
  User.findAll({
    attributes: ['name', 'age'],
    where: {
      married: true,
      age: {
        [Op.gt]: 30,
      },
    },
  })
  ```

- `Op.or`

  ```sql
  SELECT id, name FROM users WHERE married = 0 OR age > 30
  ```

  ```javascript
  User.findAll({
    attributes: ['id', 'name'],
    where: {
      [Op.or]: [
        { married: false },
        {
          age: {
            [Op.gt]: 30,
          },
        },
      ],
    },
  })
  ```

- `order` ์ต์

  ```sql
  SELECT id, name FROM users ORDER BY age DESC
  ```

  ```javascript
  User.findAll({
    attributes: ['id', 'name'],
    order: [['age', 'DESC']],
  })
  ```

- `LIMIT`

  ```sql
  SELECT id, name FROM users ORDER BY age DESC LIMIT 1
  ```

  ```javascript
  User.findAll({
    attributes: ['id', 'name'],
    order: [['age', 'DESC']],
    limit: 1,
  })
  ```

- `OFFSET`

  ```sql
  SELECT id, name FROM users ORDER BY age DESC LIMIT 1 OFFSET 1
  ```

  ```javascript
  User.findAll({
    attributes: ['id', 'name'],
    order: [['age', 'DESC']],
    limit: 1,
    offset: 1,
  })
  ```

- `update`

  ```sql
  UPDATE nodejs.users SET comment = '๋ฐ๊ฟ ๋ด์ฉ' WHERE id = 2
  ```

  ```javascript
  User.update(
    {
      comment: '๋ฐ๊ฟ ๋ด์ฉ',
    },
    {
      where: { id: 2 },
    }
  )
  ```

- `destroy`

  ```sql
  DELETE FROM nodejs.users WHERE id = 2
  ```

  ```javascript
  User.destroy({
    where: { id: 2 },
  })
  ```

### โ 7.6.4.1 ๊ด๊ณ ์ฟผ๋ฆฌ

- `User` ๋ชจ๋ธ๊ณผ `Comment` ๋ชจ๋ธ์ด hasMany-belongTo ๊ด๊ณ์ ์์ ๋
- ์ฌ์ฉ์๋ฅผ ๊ฐ์ ธ์ค๋ฉด์ ๊ทธ ์ฌ๋์ ๋๊ธ๊น์ง ๊ฐ์ ธ์ค๊ณ  ์ถ์ ๊ฒฝ์ฐ

  ```javascript
  const user = await User.findOne({
    include: [
      {
        model: Comment,
      },
    ],
  })

  const comments = user.getComments()
  ```

  - ๊ด๊ณ๋ฅผ ์ค์ ํ๋ค๋ฉด getComments(์กฐํ), setComments(์์ ), addComment(ํ๋ ์์ฑ), addComments(์ฌ๋ฌ ๊ฐ ์์ฑ), removeComments(์ญ์ ) ๋ฉ์๋๋ฅผ ์ง์ํ๋ค.

### โ 7.6.4.2 SQL ์ฟผ๋ฆฌํ๊ธฐ

- ์ง์  SQL๋ฌธ์ ํตํด ์ฟผ๋ฆฌํ  ์ ๋ ์๋ค.

```javascript
const [result, metadata] = await sequelize.query('SELECT * FROM comments')
```

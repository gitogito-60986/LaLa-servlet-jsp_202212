-- gender テーブル作成
-- テーブル初期化
DROP TABLE IF EXISTS gender;
CREATE TABLE gender (
	id CHAR(1) PRIMARY KEY,
	name VARCHAR(10)
);

-- レコード挿入
INSERT INTO gender
(id, name) VALUES
('0', '不明'),
('1', '男性'),
('2', '女性'),
('3', 'その他');


-- dept テーブル作成
-- テーブル初期化
DROP TABLE IF EXISTS dept;
CREATE TABLE dept (
  id CHAR(3) PRIMARY KEY,
  name VARCHAR(100)
);

-- レコード挿入
INSERT INTO dept
(id, name) VALUES
('d01', '総務部'),
('d02', '経理部'),
('d03', '第一営業部'),
('d04', '開発部'),
('d05', '第二営業部');


-- employee テーブル作成
-- テーブル初期化
DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
	id CHAR(6) PRIMARY KEY,
	name VARCHAR(100),
	gender_id CHAR(1),
	birthday DATE,
	dept_id CHAR(3)
);

-- レコード挿入
INSERT INTO employee
(id, name, gender_id, birthday, dept_id) VALUES
('EMP001', '二階堂 ふみ', '2', '1994-09-21', 'd05'),
('EMP002', '染谷 翔太', '1', '1992-09-03', 'd04'),
('EMP003', '吉高 由里子', '2', '1988-07-22', 'd02'),
('EMP004', '窪塚 洋介', '1', '1979-05-07', 'd04');

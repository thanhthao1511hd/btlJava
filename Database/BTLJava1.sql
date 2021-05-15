/* This comment for MSSQL Server Managerment Studio */
/*
USE MASTER
GO
IF(EXISTS(SELECT * FROM SYSDATABASES WHERE NAME='BTLJava'))
	DROP DATABASE BTLJava
GO
USE MASTER
GO

CREATE DATABASE BTLJava
GO
USE BTLJava
GO

*/

GO
CREATE TABLE CanBo (
  IDCanBo int IDENTITY NOT NULL PRIMARY KEY, 
  HoTen   nvarchar(100) NULL, 
  NamSinh  varchar(50) NULL, 
  GioiTinh  nvarchar(20) NULL, 
  DiaChi   nvarchar(200) NULL,
  Username   nvarchar(200) NULL,
  Password   nvarchar(200) NULL,
  isAdmin integer NULL,
);
---------------------------------
CREATE TABLE ChucVu (
  IDChucVu nvarchar(20)  NOT NULL PRIMARY KEY, 
  TenChucVu   nvarchar(100) NULL, 
);
---------------------------------
CREATE TABLE ChucVuCanBo (
	IDChucVuCanBo int IDENTITY NOT NULL PRIMARY KEY, 
  IDCanBo    int NOT NULL REFERENCES CanBo (IDCanBo), 
  IDChucVu    nvarchar(20) NOT NULL REFERENCES ChucVu (IDChucVu),
  ChiTiet   nvarchar(200) NULL,
);
go

/* INSERT DATABASE */
---------------------------------
INSERT INTO CanBo VALUES
(N'Hà Quốc Tuấn','2000',	N'Nam',	N'Hải Dương','hqt','1234',1),
(N'An Thị Thanh Thảo','2000',	N'Nữ',	N'Hải Dương','attt','1234',0),
(N'Nguyễn Thị Yến','2000',	N'Nữ',	N'Bắc Giang','nty','1234',0),
(N'Hà My','1999',	N'Nữ',	N'Hà Nội','hamy','1234',0),
(N'Tùng Anh',		'2001',	N'Nam',	N'Bắc Giang','ta','1234',0)

INSERT INTO ChucVu VALUES 
('CV01',N'Công nhân'),
('CV02',N'Kỹ sư'),
('CV03',N'Nhân viên')

INSERT INTO ChucVuCanBo VALUES
('1','CV02',N'Kỹ sư CNTT'),
('2','CV02',N'Kỹ sư kế toán'),
('3','CV03',N'Chuyên viên'),
('4','CV01',N'Bảo vệ'),
('5','CV01',N'Bảo vệ')

/*
truy van
*/

select * from CanBo

select * from ChucVu

select * from ChucVuCanBo

select * 
from CanBo inner join ChucVuCanBo on CanBo.IDCanBo = ChucVuCanBo.IDCanBo
			inner join ChucVu on ChucVu.IDChucVu = ChucVuCanBo.IDChucVu

--lay danh sach ky su
select HoTen, NamSinh, GioiTinh, DiaChi, ChiTiet
from CanBo inner join ChucVuCanBo on CanBo.IDCanBo = ChucVuCanBo.IDCanBo
			inner join ChucVu on ChucVu.IDChucVu = ChucVuCanBo.IDChucVu
where ChucVuCanBo.IDChucVu = 'CV02'

--lay danh sach nhan vien
select HoTen, NamSinh, GioiTinh, DiaChi, ChiTiet
from CanBo inner join ChucVuCanBo on CanBo.IDCanBo = ChucVuCanBo.IDCanBo
			inner join ChucVu on ChucVu.IDChucVu = ChucVuCanBo.IDChucVu
where ChucVuCanBo.IDChucVu = 'CV03'

--lay danh sach cong nhan
select HoTen, NamSinh, GioiTinh, DiaChi, ChiTiet
from CanBo inner join ChucVuCanBo on CanBo.IDCanBo = ChucVuCanBo.IDCanBo
			inner join ChucVu on ChucVu.IDChucVu = ChucVuCanBo.IDChucVu
where ChucVuCanBo.IDChucVu = 'CV01'

--isAdmin
select isAdmin 
from CanBo
where Username = 'hqt'and Password = 1234

select isAdmin 
from CanBo
where Username = 'attt' 

--tim kiem theo ten
select HoTen, NamSinh, GioiTinh, DiaChi, ChiTiet
from CanBo inner join ChucVuCanBo on CanBo.IDCanBo = ChucVuCanBo.IDCanBo
			inner join ChucVu on ChucVu.IDChucVu = ChucVuCanBo.IDChucVu
where CanBo.HoTen = N'Hà Quốc Tuấn'

--sap xep theo ten
select HoTen, NamSinh, GioiTinh, DiaChi, ChiTiet
from CanBo inner join ChucVuCanBo on CanBo.IDCanBo = ChucVuCanBo.IDCanBo
			inner join ChucVu on ChucVu.IDChucVu = ChucVuCanBo.IDChucVu
order by CanBo.HoTen

--sap xep theo nam sinh
select HoTen, NamSinh, GioiTinh, DiaChi, ChiTiet
from CanBo inner join ChucVuCanBo on CanBo.IDCanBo = ChucVuCanBo.IDCanBo
			inner join ChucVu on ChucVu.IDChucVu = ChucVuCanBo.IDChucVu
order by CanBo.NamSinh
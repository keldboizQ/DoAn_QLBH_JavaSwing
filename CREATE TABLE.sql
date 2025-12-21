create database Swing_QuanLyBH

use Swing_QuanLyBH
go

-----------------------------------------------------------------

--Bang thuong hieu
create table BRANDS (
id_brand int identity(1,1) primary key,
name_brand nvarchar(200) not null
);

-----------------------------------------------------------------

--Bang Danh muc
create table CATEGORIES (
id_category int identity(1,1) primary key,
name_category nvarchar(200) not null
);

-----------------------------------------------------------------

--Bang San pham
create table PRODUCTS (
id_product int identity(1,1) primary key,
name_product nvarchar(200) not null,
description nvarchar(max) null,
price decimal(18,0) not null,
stock int not null,

id_category int,
id_brand int,

foreign key (id_category) references CATEGORIES (id_category),
foreign key (id_brand) references BRANDS (id_brand)
);

-----------------------------------------------------------------

CREATE TABLE ROLES (
id_role INT IDENTITY(1,1) PRIMARY KEY,
name_role NVARCHAR(100) NOT NULL
);

----------------------------------------------------------------------------------

CREATE TABLE ACCOUNTS (                              -- 1 Quyền có thể có nhiều Accounts nhưng 1 Account thì không thể có nhiều quyền (UNIQUE) (Nguyên lí khoá ngoại)
id_account INT IDENTITY(1,1) PRIMARY KEY,
email NVARCHAR(200) UNIQUE NOT NULL,
passwordHash VARBINARY(64) NOT NULL,
Salt UNIQUEIDENTIFIER DEFAULT NEWID(),

id_role INT,
FOREIGN KEY (id_role) REFERENCES ROLES (id_role)
);

-- Mã hóa mật khẩu bằng SHA2_256 và tạo Salt Ngẫu nhiên
DECLARE @password NVARCHAR(100) = '123';
DECLARE @salt UNIQUEIDENTIFIER = NEWID();

-- Thêm 1 tài khoản dành cho admin ---- email defaul là admin, pass 123

INSERT INTO ACCOUNTS (email, passwordHash, Salt, id_role) VALUES
(N'admin', 
HASHBYTES('SHA2_256', @password + CAST(@salt AS NVARCHAR(36))),
@salt, 1
);
GO

-- Thêm 1 tài khoản dành cho nhân viên ---- email default là nv, pass 123456
  
DECLARE @password NVARCHAR(100) = '123456';
DECLARE @salt UNIQUEIDENTIFIER = NEWID();

-- Thêm 1 tài khoản dành cho admin ---- email defaul là admin, pass 123 và nhân viên là nv, pass 123456

INSERT INTO ACCOUNTS (email, passwordHash, Salt, id_role) VALUES
(N'nv', 
HASHBYTES('SHA2_256', @password + CAST(@salt AS NVARCHAR(36))),
@salt, 2
);
GO  



----------------------------------------------------------------------------------

CREATE TABLE ADMINS (				     -- Cùng 1 Account chung có thể truyền tay cho nhiều ngươi dùng, nhưng 1 người thì không thể có nhiều Account
id_admin INT IDENTITY(1,1) PRIMARY KEY,
fullname NVARCHAR(100) NOT NULL,
phone VARCHAR(15),
sex nvarchar(10),
status bit default 1,

id_account INT,
FOREIGN KEY (id_account) REFERENCES ACCOUNTS (id_account)
);

----------------------------------------------------------------------------------

--Bảng khách hàng
create table CUSTOMERS (
id_customer int identity(1,1) primary key,
name_customer nvarchar(100) not null,
phone varchar(15),
address nvarchar(200)
);

----------------------------------------------------------------------------------

--Bảng Đơn hàng
create table ORDERS (
id_order int identity(1,1) primary key,
createdAT datetime default getdate(),
Total decimal(18,0),

----------------------------------------------------------------------------------

id_admin int,
id_customer int,
foreign key (id_admin) references ADMINS (id_admin),
foreign key (id_customer) references CUSTOMERS (id_customer)
);

----------------------------------------------------------------------------------

--Bảng Chi tiết Đơn hàng
create table ORDERDETAILS (
price decimal(18,0),
quantity int,
total_price as (quantity * price),

id_order int,
id_product int,
primary key (id_order, id_product),
foreign key (id_order) references ORDERS (id_order),
foreign key (id_product) references PRODUCTS (id_product)
);




--INSERT Dữ liệu vào bảng
INSERT INTO BRANDS (name_brand) VALUES
(N'Yonex'),
(N'Lining'),
(N'Victor'),
(N'Mizuno'),
(N'Nike'),
(N'Adidas'),
(N'Mikasa'),
(N'Molten');

select * from BRANDS



INSERT INTO CATEGORIES (name_category) VALUES
(N'FootBall'),
(N'Badminton'),
(N'BasketBall'),
(N'VolleyBall');

select * from CATEGORIES



INSERT INTO PRODUCTS (name_product, description, price, stock, id_category, id_brand) VALUES
(N'Vợt Cầu lông Yonex Astrox 77 Pro Đỏ China Limited', N' Vợt Cầu Lông Yonex Astrox 77 Pro Đỏ China Limited là phiên bản được thiết kế tri ân cho VĐV Chen Yu Fei, tay vợt đơn nữ số 1 của Trung Quốc. Đây chắc chắn sẽ là một cây vợt mà bất cứ ai hâm mộ tay vợt này cũng không thể bỏ qua. 
Ở phiên bản lần này, ngay vị trí cổ vợt có thêm phần chữ kí của tay vợt', 
14990000, 1, 2, 1),

(N'Vợt Cầu lông Victor Mjolnir Metallic Limited 2024', 
N'Vợt cầu lông Victor Mjolnir Metallic Limited 2024 là sản phẩm cao cấp vừa được ra mắt của thương hiệu Victor với thiết kế lấy cảm hứng từ chiếc búa Mjolnir của nhân vật Thor trong loạt phim Marvel nổi tiếng trên toàn thế giới. 
Khung vợt được phủ lên bởi các họa tiết sấm sét cùng với gam màu xanh phối hợp với đen, là nét đặc trưng của chiếc búa trong loạt phim đình đám này, thân vợt có thêm những họa tiết tạo hình cán búa làm tổng thể cây vợt có một ngoại hình mạnh mẽ, độc đáo. ', 
4650000, 3, 2, 3),

(N'Vợt cầu lông Lining Axforce 80 Light', N' Vợt cầu lông Lining Axforce 80 Light sở hữu tông màu trắng chủ đạo, kết hợp với các chi tiết tinh tế tạo nên vẻ ngoài hiện đại, sang trọng. 
Thiết kế này không chỉ giúp vợt trở nên nổi bật hơn trên sân đấu mà còn tạo cảm giác thanh lịch, phù hợp với những người chơi yêu thích sự tối giản nhưng không kém phần đẳng cấp.', 
4690000, 10, 2, 2),

(N'LeBron XXIII "The Chosen One" EP', N'LeBrons carried the game for two decades. But what if we could help lighten the load? Enter the LeBron XXIII. It offers peak lightweight responsiveness thanks to springy, full-length ZoomX foam—perfect for the high speed demands of the modern game.',
5869000, 2, 3, 5),

(N'Air Jordan 40 PF', N'Theres only one way to celebrate 40 years of Air Jordans. You gotta do whats never been done. For the first time, we stacked a full-length Zoom Strobel unit on top of full-length ZoomX foam for responsive, marathon-level cushioning.',
5869000, 2, 3, 5),

(N'Nike Phantom 6 High Elite "EA SPORTS FC"', N'On field or online, this Phantom 6 Elite is so precise its scary. With mods like our revolutionary Gripknit and Cyclone 360 traction plate, this glitchy goal machine is a like cheat code for your next match.',
9089000, 4, 1, 5),

(N'Nike Mercurial Vapor 16 Elite x Air Max 95 SE', N'As we celebrate the 30th anniversary of the Air Max 95, its only right we toast the rarefied AIR allegiance between the lifestyle icon and meteoric Mercurial.',
9089000, 9, 1, 5),

(N'Volleyball V200W', N'Exclusive official FIVB game ball - Professional Model as seen in the worlds top professional games.',
479000, 20, 4, 7),

(N'Molten V5M5000', N'Vật liệu phủ: PU da, chống nước Ruột: Butyl.', 1490000, 13, 4, 8);

select * from PRODUCTS



INSERT INTO ROLES (name_role) VALUES 
(N'Quản lý'),
(N'Nhân viên');

select * from ROLES




INSERT INTO CUSTOMERS (name_customer, phone, address) VALUES
(N'Phoenix', '0564', N'Thủ Đức'),
(N'Yoru', '0790', N'Thủ Đức');

select * from CUSTOMERS




INSERT INTO ADMINS (fullname, phone, sex, status, id_account) VALUES
(N'Phạm Hoàng Công Quân', '0375', N'Nam', 1, 1),
(N'Phạm Thanh Tùng', '0798', N'Nam', 1,1);

select * from ADMINS




INSERT INTO ORDERS (total, id_admin, id_customer) VALUES
(1500000, 1, 3),
(3790000, 2, 4);

select * from ORDERS



INSERT INTO ORDERDETAILS (price, quantity, id_order, id_product) VALUES
(1500000, 2, 1, 5),
(3790000, 1, 2, 3);

select * from ORDERDETAILS


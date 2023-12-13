
create database QLLuongSanPham
go
use QLLuongSanPham
go
create table ChucVu(
	idChucVu varchar(10) primary key not null,
	tenChucVu nvarchar(50),
	heSoLuong float
)
create table PhongBan(
	idPhongBan varchar(10) primary key not null,
	tenPhongBan nvarchar(50)
)
create table TaiKhoan(
	tenTaiKhoan varchar(10) primary key not null,
	matKhau varchar(50),
	loaiTaiKhoan nvarchar(30),
	soTaiKhoan nvarchar(20)
)
create table CaLam(
	idCaLam int  primary key not null,
	tenCaLam nvarchar(50),
	thoiGianBatDau time(7),
	thoiGianKetThuc time(7),
	heSoLuong float
)
create table PhanXuong(
	idPhanXuong varchar(10) primary key not null,
	tenPhanXuong nvarchar(50)
)
CREATE TABLE TaiKhoanNganHang (
    soTaiKhoan nvarchar(20) PRIMARY KEY NOT NULL,
    tenNganHang NVARCHAR(50),
    chuTaiKhoan NVARCHAR(50),
    chiNhanh NVARCHAR(100)
);
ALTER TABLE TaiKhoan
ADD CONSTRAINT FK_TaiKhoan_TaiKhoanNganHang
FOREIGN KEY (soTaiKhoan)
REFERENCES TaiKhoanNganHang(soTaiKhoan);
create table NhanVien(
	idNhanVien varchar(10) primary key not null,
	hoTen nvarchar(50),
	phai bit,
	ngaySinh date,
	ngayBatDauCongTac date,
	ngayKetThucCongTac date,
	email varchar(50),
	soDienThoai varchar(10),
	idChucVu varchar(10),
	heSoBaoHiemXaHoi float,
	luongCoBan money,
	tenTaiKhoan varchar(10),
	idPhongBan varchar(10),
	phuCap float,
	anhDaiDien nvarchar(50),
	cCCD varchar(15)
)

alter table NhanVien add constraint FK_tenTaiKhoan foreign key (tenTaiKhoan) references TaiKhoan(tenTaiKhoan) on delete cascade
alter table NhanVien add constraint FK_idPhongBan foreign key (idPhongBan) references PhongBan(idPhongBan) on delete cascade
alter table NhanVien add constraint FK_idChucVu foreign key (idChucVu) references ChucVu(idChucVu) on delete cascade
create table CongNhan(
	idCongNhan varchar(10) primary key not null,
	hoTen nvarchar(50),
	phai bit,
	ngaySinh date,
	ngayBatDauCongTac date,
	ngayKetThucCongTac date,
	idPhanXuong varchar(10),
	email varchar(50),
	soDienThoai varchar(10),
	phuCap float,
	tayNghe nvarchar(20),
	tenTaiKhoan varchar(10),
	anhDaiDien nvarchar(50),
	cCCD varchar(15)
)
alter table CongNhan add constraint FK_tenTaiKhoan_CongNhan foreign key (tenTaiKhoan) references TaiKhoan(tenTaiKhoan) on delete cascade
--alter table CongNhan add constraint FK_CaLam_CongNhan foreign key (idCaLam) references CaLam(idCaLam) on delete cascade
alter table CongNhan add constraint FK_PhanXuong_CongNhan foreign key (idPhanXuong) references PhanXuong(idPhanXuong) on delete cascade
create table HopDongSanPham(
	idHopDong varchar(10) primary key not null,
	tenHopDong nvarchar(50),
	ngayBatDau date,
	ngayKetThuc date,
	idNguoiQuanLy varchar(10),
	tongTien money,
	ghiChu nvarchar(max)
)
alter table HopDongSanPham add constraint FK_HopDongSanPham_NhanVien foreign key (idNguoiQuanLy) references NhanVien(idNhanVien)
create table SanPham(
	idSanPham varchar(10) primary key not null,
	tenSanPham nvarchar(50),
	donGia money,
	chatLieu nvarchar(max),
	donViTinh nvarchar(30),
	ghiChu nvarchar(max),
	anhSanPham varchar(max)
)
--alter table SanPham add constraint FK_HopDongSanPham_SanPham foreign key (idHopDongSanPham) references HopDongSanPham(idHopDong) on delete cascade
create table ChiTietHopDong
(
	idHopDong varchar(10),
	idSanPham varchar(10),
	soLuong int,
	thanhTien money
)
alter table ChiTietHopDong add constraint FK_ChiTietHopDong_HopDong foreign key (idHopDong) references HopDongSanPham(idHopDong) on delete cascade
alter table ChiTietHopDong add constraint FK_ChiTietHopDong_SanPham foreign key (idSanPham) references SanPham(idSanPham) on delete cascade

create table CongDoanSP(
	idCongDoan varchar(10) primary key not null,
	tenCongDoan nvarchar(50),
	soLuongSanPham int,
	luongCongDoan money,
	idSanPham varchar(10),
)
alter table CongDoanSP add constraint FK_CongDoanSP_SanPham foreign key (idSanPham) references SanPham(idSanPham)
create table CongDoanPhanCong(
	idPhanCong varchar (10) primary key not null,
	idCongDoan varchar(10) not null,
	idCongNhan varchar(10) not null,
	soLuongSPDuocGiao int,
	idCaLam int,
	soLuongConLai int
)
alter table CongDoanPhanCong add constraint FK_CongDoanPhanCong_CongDoanSanPham foreign key (idCongDoan) references CongDoanSP(idCongDoan)
alter table CongDoanPhanCong add constraint FK_CongDoanPhanCong_CongNhan foreign key (idCongNhan) references CongNhan(idCongNhan) on delete cascade
alter table CongDoanPhanCong add constraint FK_CongDoanPhanCong_CaLam foreign key (idCaLam) references CaLam(idCaLam) on delete cascade

create table BangChamCongCongNhan(
	idNgayChamCong varchar(10) primary key not null,
	ngayChamCong date,
	soLuongHoanThanh int,
	idPhanCong varchar(10),
	heSoNgayLam float
)
--alter table BangChamCongCongNhan add constraint FK_BangChamCongCongNhan_CongDoanPhanCong foreign key (idCongDoan,idCongNhan) references CongDoanPhanCong(idCongDoan,idCongNhan) on delete cascade
alter table BangChamCongCongNhan add constraint FK_BangChamCongCongNhan_CongDoanPhanCong foreign key (idPhanCong) references CongDoanPhanCong(idPhanCong) on delete cascade

create table BangLuongCongNhan(
	idLuongCN varchar(10) primary key not null,
	ngayTinhLuong date,
	idCongNhan varchar(10),
	tongLuong money,
	thucLanh money,
	thang int,
	nam int
)
alter table BangLuongCongNhan add constraint FK_BangLuongCongNhan_CongNhan foreign key (idCongNhan) references CongNhan(idCongNhan)

create table BangChamCongNhanVienHC(
	idChamCong varchar(10) primary key not null,
	ngayChamCong date,
	trangThai nvarchar(10),
	idNhanVien varchar(10),
	
)
alter table BangChamCongNhanVienHC add constraint FK_BangChamCongNhanVienHC_NhanVien foreign key (idNhanVien) references NhanVien(idNhanVien)
create table BangLuongNhanVien(
	idLuongNVHC varchar(10) primary key not null,
	ngayTinhLuong date,
	idNhanVien varchar(10),
	thueLaoDong money,
	tienBaoHiemXaHoi money,
	tongLuong money,
	thucLanh money,
	thang int,
	nam int
)
alter table BangLuongNhanVien add constraint FK_BangLuongNhanVien_NhanVien foreign key (idNhanVien) references NhanVien(idNhanVien)

insert into TaiKhoan(tenTaiKhoan,matKhau,loaiTaiKhoan) values('admin', '1111', 'admin')
go



-- Thêm các chức vụ
INSERT INTO ChucVu (idChucVu, tenChucVu, heSoLuong)
VALUES
    ('CV001', N'Nhân viên hành chánh', 1.0),
    ('CV002', N'Kế toán', 1.4),
    ('CV003', N'Trưởng phòng sản xuất', 2.1),
    ('CV004', N'Trưởng phòng nhân sự', 2.1),
	('CV005', N'Trưởng kế toán', 2.1);
-- Thêm các phòng ban
go
INSERT INTO PhongBan (idPhongBan, tenPhongBan)
VALUES
    ('PB001', N'Phòng Kế Toán'),
    ('PB002', N'Phòng Nhân Sự'),
    ('PB003', N'Phòng Sản Xuất');
go

INSERT INTO TaiKhoanNganHang (soTaiKhoan, tenNganHang, chuTaiKhoan, chiNhanh)
VALUES
    ('111100001111', N'SacomBank', N'Nguyễn Thị Ánh', N'Chi nhánh TP.HCM'),
    ('111100002111', N'SacomBank', N'Lê Văn Hùng', N'Chi nhánh TP.HCM'),
    ('111100003111', N'SacomBank', N'Trần Thị Thảo', N'Chi nhánh TP.HCM'),
    ('111100004111', N'SacomBank', N'Vũ Văn Minh', N'Chi nhánh TP.HCM'),
    ('111100005111', N'SacomBank', N'Phạm Thị Hương', N'Chi nhánh TP.HCM'),
    ('111100006111', N'SacomBank', N'Lê Huy Hoàng', N'Chi nhánh TP.HCM'),
    ('111100007111', N'SacomBank', N'Trần Thị Minh', N'Chi nhánh TP.HCM'),
    ('111100008111', N'SacomBank', N'Hoàng Văn Phú', N'Chi nhánh TP.HCM'),
    ('111100009111', N'SacomBank', N'Ngọc Thị Bích', N'Chi nhánh TP.HCM'),
    ('111100010111', N'SacomBank', N'Phan Văn Hòa', N'Chi nhánh TP.HCM'),
    ('111100011111', N'SacomBank', N'Trần Thị Linh', N'Chi nhánh TP.HCM'),
    ('111100012111', N'SacomBank', N'Lê Thanh Hùng', N'Chi nhánh TP.HCM'),
    ('111100013111', N'SacomBank', N'Nguyễn Thị Hoài', N'Chi nhánh TP.HCM'),
    ('111100014111', N'SacomBank', N'Vũ Văn Đức', N'Chi nhánh TP.HCM'),
    ('111100015111', N'SacomBank', N'Nguyễn Thị Mai', N'Chi nhánh TP.HCM'),
    ('111100016111', N'SacomBank', N'Phạm Văn Thái', N'Chi nhánh TP.HCM'),
    ('111100017111', N'SacomBank', N'Lê Thị Hương', N'Chi nhánh TP.HCM'),
    ('111100018111', N'SacomBank', N'Nguyễn Văn An', N'Chi nhánh TP.HCM'),
    ('111100019111', N'SacomBank', N'Trần Thị Bình', N'Chi nhánh TP.HCM'),
    ('111100020111', N'SacomBank', N'Lê Văn Minh', N'CChi nhánh TP.HCM'),
    ('111100021111', N'SacomBank', N'Nguyễn V', N'Chi nhánh TP.HCM'),
	('111100022111', N'SacomBank', N'Nguyễn Văn An', N'Chi nhánh TP.HCM'),
    ('111100023111', N'SacomBank', N'Phạm Thị Bình', N'Chi nhánh TP.HCM'),
    ('111100024111', N'Sacombank', N'Vũ Văn Minh', N'Chi nhánh TP.HCM'),
    ('111100025111', N'SacomBank', N'Trần Thị Mai', N'Chi nhánh TP.HCM'),
    ('111100026111', N'SacomBank', N'Lê Thanh Hùng', N'Chi nhánh TP.HCM'),
    ('111100027111', N'SacomBank', N'Hoàng Thị Ngọc', N'Chi nhánh TP.HCM'),
    ('111100028111', N'SacomBank', N'Phạm Văn Tuấn', N'Chi nhánh TP.HCM'),
    ('111100029111', N'SacomBank', N'Trần Thị Lan', N'Chi nhánh TP.HCM'),
    ('111100030111', N'SacomBank', N'Trần Thanh Tâm', N'Chi nhánh TP.HCM'),
    ('111100031111', N'SacomBank', N'Hà Thị An', N'Chi nhánh TP.HCM'),
    ('111100032111', N'Sacombank', N'Lê Văn Trung', N'Chi nhánh TP.HCM'),
    ('111100033111', N'SacomBank', N'Nguyễn Thị Lan', N'Chi nhánh TP.HCM'),
    ('111100034111', N'SacomBank', N'Nguyễn Văn Long', N'Chi nhánh TP.HCM'),
    ('111100035111', N'SacomBank', N'Trần Văn Bình', N'Chi nhánh TP.HCM'),
    ('111100036111', N'SacomBank', N'Nguyễn Thị Hoa', N'Chi nhánh TP.HCM'),
    ('111100037111', N'SacomBank', N'Vũ Văn Đức', N'Chi nhánh TP.HCM'),
    ('111100038111', N'SacomBank', N'Hoàng Văn Phú', N'Chi nhánh TP.HCM'),
    ('111100039111', N'SacomBank', N'Trần Thị Minh', N'Chi nhánh TP.HCM'),
    ('111100040111', N'SacomBank', N'Lê Huy Hoàng', N'Chi nhánh TP.HCM'),
    ('111100041111', N'SacomBank', N'Phan Văn Hòa', N'Chi nhánh TP.HCM');
go
INSERT INTO TaiKhoan (tenTaiKhoan, matKhau, loaiTaiKhoan,soTaiKhoan)
VALUES
    ('NV0001', '1111', N'KT','111100001111'),
    ('NV0002', '1111', N'KT toán','111100002111'),
    ('NV0003', '1111', N'TPNS','111100003111'),
    ('NV0004', '1111', N'TPSX','111100004111'),
    ('NV0005', '1111', N'NV','111100005111'),
    ('NV0006', '1111', N'NV','111100006111'),
    ('NV0007', '1111', N'NV','111100007111'),
    ('NV0008', '1111', N'NV','111100008111'),
    ('NV0009', '1111', N'NV','111100009111'),
    ('NV0010', '1111', N'NV','111100010111'),
    ('NV0011', '1111', N'NV','111100011111'),
    ('NV0012', '1111', N'NV','111100012111'),
    ('NV0013', '1111', N'NV','111100013111'),
    ('NV0014', '1111', N'NV','111100014111'),
    ('NV0015', '1111', N'NV','111100015111'),
    ('NV0016', '1111', N'NV','111100016111'),
    ('NV0017', '1111', N'NV','111100017111'),
    ('NV0018', '1111', N'NV','111100018111'),
    ('NV0019', '1111', N'NV','111100019111'),
    ('NV0020', '1111', N'NV','111100020111'),
    ('NV0021', '1111', N'NV','111100021111'),
    ('CN0001', '1111', N'CN', '111100022111'),
    ('CN0002', '1111', N'CN', '111100023111'),
    ('CN0003', '1111', N'CN', '111100024111'),
    ('CN0004', '1111', N'CN', '111100025111'),
    ('CN0005', '1111', N'CN', '111100026111'),
    ('CN0006', '1111', N'CN', '111100027111'),
    ('CN0007', '1111', N'CN', '111100028111'),
    ('CN0008', '1111', N'CN', '111100029111'),
    ('CN0009', '1111', N'CN', '111100030111'),
    ('CN0010', '1111', N'CN', '111100031111'),
    ('CN0011', '1111', N'CN', '111100032111'),
    ('CN0012', '1111', N'CN', '111100033111'),
    ('CN0013', '1111', N'CN', '111100034111'),
    ('CN0014', '1111', N'CN', '111100035111'),
    ('CN0015', '1111', N'CN', '111100036111'),
    ('CN0016', '1111', N'CN', '111100037111'),
    ('CN0017', '1111', N'CN', '111100038111'),
    ('CN0018', '1111', N'CN', '111100039111'),
    ('CN0019', '1111', N'CN', '111100040111'),
    ('CN0020', '1111', N'CN', '111100041111');

go

INSERT INTO NhanVien (idNhanVien, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, email, soDienThoai, idChucVu, heSoBaoHiemXaHoi, luongCoBan, tenTaiKhoan, idPhongBan, phuCap,anhDaiDien, cCCD)
VALUES
('NV0001', N'Nguyễn Thị Ánh', 0, '1985-11-25', '2007-07-17', null, 'duongnhat512@gmail.com', '0901234561', 'CV002', 0.05, 8000000, 'NV0001', 'PB001', 700000, 'Unknown_person.jpg','012345678901'),
    ('NV0002', N'Lê Văn Hùng', 1, '1986-02-12', '2008-09-05', NULL, 'hungle@gmail.com', '0901234562', 'CV002', 0.05, 8000000, 'NV0002', 'PB001', 700000,'Unknown_person.jpg','012345678902'),
    ('NV0003', N'Trần Thị Thảo', 0, '1982-08-31', '2005-10-09', NULL, 'thao.tran@gmail.com', '0901234563', 'CV003', 0.05, 8000000, 'NV0003', 'PB002', 1000000,'Unknown_person.jpg','012345678903'),
    ('NV0004', N'Vũ Văn Minh', 1, '1980-06-20', '2002-03-18', NULL, 'minhvu@gmail.com', '0901234564', 'CV003', 0.05, 8000000, 'NV0004', 'PB003', 1000000,'Unknown_person.jpg','012345678904'),
    ('NV0005', N'Phạm Thị Hương', 0, '1991-07-20', '2018-03-25', NULL, 'pthuong@gmail.com', '0901234565', 'CV001', 0.05, 8000000, 'NV0005', 'PB002', 500000, 'Unknown_person.jpg','012345678905'),
    ('NV0006', N'Lê Huy Hoàng', 1, '1995-11-10', '2019-09-02', NULL, 'lhhoang@gmail.com', '0901234566', 'CV001', 0.05, 8000000, 'NV0006', 'PB001', 500000, 'Unknown_person.jpg','012345678906'),
    ('NV0007', N'Trần Thị Minh', 0, '1992-05-25', '2021-06-14',  NULL,'ttminh@gmail.com', '0901234567', 'CV001', 0.05, 8000000, 'NV0007', 'PB003', 500000, 'Unknown_person.jpg','012345678907'),
    ('NV0008', N'Hoàng Văn Phú', 1, '1989-12-02', '2019-04-20', NULL, 'hvphu@gmail.com', '0901234568', 'CV001', 0.05, 8000000, 'NV0008', 'PB002', 500000, 'Unknown_person.jpg','012345678908'),
    ('NV0009', N'Ngọc Thị Bích', 0, '1993-08-12', '2022-02-05', NULL, 'ntbich@gmail.com', '0901234569', 'CV001', 0.05, 8000000, 'NV0009', 'PB001', 500000, 'Unknown_person.jpg','012345678909'),
    ('NV0010', N'Phan Văn Hòa', 1, '1991-04-30', '2018-11-30', NULL, 'pvhoa@gmail.com', '0901234510', 'CV001', 0.05, 8000000, 'NV0010', 'PB003', 500000, 'Unknown_person.jpg','012345678910'),
    ('NV0011', N'Trần Thị Linh', 0, '1994-06-18', '2022-03-10', NULL, 'ttlinh@gmail.com', '0901234511', 'CV001', 0.05, 8000000, 'NV0011', 'PB001', 500000, 'Unknown_person.jpg','012345678911'),
    ('NV0012', N'Lê Thanh Hùng', 1, '1990-02-08', '2019-01-07', NULL, 'lthung@gmail.com', '0901234512', 'CV001', 0.05, 8000000, 'NV0012', 'PB002', 500000, 'Unknown_person.jpg','012345678912'),
    ('NV0013', N'Nguyễn Thị Hoài', 0, '1992-10-05', '2020-05-03', NULL, 'nthoai@gmail.com', '0901234513', 'CV001', 0.05, 8000000, 'NV0013', 'PB003', 500000, 'Unknown_person.jpg','012345678913'),
    ('NV0014', N'Vũ Văn Đức', 1, '1988-11-21', '2018-12-14', NULL, 'vvduc@gmail.com', '0901234514', 'CV001', 0.05, 8000000, 'NV0014', 'PB001', 500000, 'Unknown_person.jpg','012345678914'),
    ('NV0015', N'Nguyễn Thị Mai', 0, '1993-07-07', '2020-09-28', NULL, 'nthimai@gmail.com', '0901234515', 'CV001', 0.05, 8000000, 'NV0015', 'PB001', 500000, 'Unknown_person.jpg','012345678915'),
    ('NV0016', N'Phạm Văn Thái', 1, '1987-03-25', '2019-11-15', NULL, 'pvthai@gmail.com', '0901234516', 'CV001', 0.05, 8000000, 'NV0016', 'PB003', 500000, 'Unknown_person.jpg','012345678916'),
    ('NV0017', N'Lê Thị Hương', 0, '1995-09-12', '2021-07-20', NULL, 'lthuong@gmail.com', '0901234517', 'CV001', 0.05, 8000000, 'NV0017', 'PB002', 500000, 'Unknown_person.jpg','012345678917'),
	('NV0018', N'Nguyễn Văn An', 1, '1990-03-15', '2010-01-15', NULL, 'vanan@gmail.com', '0901234518', 'CV001', 0.05, 8000000, 'NV0018', 'PB001', 500000,'Unknown_person.jpg','012345678918'),
    ('NV0019', N'Trần Thị Bình', 0, '1992-05-20', '2012-02-18', NULL, 'binhtran@gmail.com', '0901234519', 'CV001', 0.05, 8000000, 'NV0019', 'PB001', 500000,'Unknown_person.jpg','012345678919'),
    ('NV0020', N'Lê Văn Minh', 1, '1988-12-10', '2009-03-28', NULL, 'minhle@gmail.com', '0901234520', 'CV001', 0.05, 8000000, 'NV0020', 'PB003', 500000,'Unknown_person.jpg','012345678920'),
	('NV0021', N'Nguyễn V', 1, '1990-03-15', '2020-01-15', NULL, 'nvan@gmail.com', '0901234521', 'CV001', 0.05, 8000000, 'NV0021', 'PB003', 500000, 'Unknown_person.jpg','012345678921')
INSERT INTO PhanXuong (idPhanXuong, tenPhanXuong)
VALUES
    ('PX001', N'A1'),
    ('PX002', N'A2'),
    ('PX003', N'B1'),
    ('PX004', N'B2');

INSERT INTO CaLam (idCaLam,tenCaLam, thoiGianBatDau, thoiGianKetThuc, heSoLuong)
VALUES
    (1,N'Ca sáng', '08:00:00', '12:00:00', 1),
    (2,N'Ca chiều', '13:00:00', '17:00:00', 1),
    (3,N'Ca tối', '18:00:00', '22:00:00', 1.5);

-- Tạo 20 bảng Công Nhân
INSERT INTO CongNhan (idCongNhan, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, idPhanXuong, email, soDienThoai, phuCap, tayNghe, tenTaiKhoan,anhDaiDien,cccd)
VALUES
('CN0001', N'Nguyễn Văn An', 1, '1980-01-01', '2005-05-10', NULL, 'PX001', 'duongnhat512@gmail.com', '0323456780',700000, N'Giỏi', 'CN0001', 'Unknown_person.jpg','012345678922'),
('CN0002', N'Phạm Thị Bình', 0, '1985-03-15', '2008-11-20', NULL, 'PX002', 'binhpham@yahoo.com', '0323456781', 700000, N'Khá', 'CN0002', 'Unknown_person.jpg','012345678923'),
('CN0003', N'Vũ Văn Minh', 1, '1990-07-20', '2010-09-30', NULL, 'PX003', 'vuminh@gmail.com', '0323456782', 700000, N'Trung bình', 'CN0003', 'Unknown_person.jpg','012345678924'),
('CN0004', N'Trần Thị Mai', 0, '1988-05-05', '2009-12-05', NULL, 'PX001', 'maitran@yahoo.com', '0323456783', 700000, N'Giỏi', 'CN0004', 'Unknown_person.jpg','012345678925'),
('CN0005', N'Lê Thanh Hùng', 1, '1986-09-10', '2007-06-15', NULL, 'PX002', 'hungle@gmail.com', '0323456784', 700000, N'Khá', 'CN0005', 'Unknown_person.jpg','012345678926'),
('CN0006', N'Hoàng Thị Ngọc', 0, '1992-11-25', '2013-04-28', NULL, 'PX003', 'ngochoang@gmail.com', '0323456785', 700000, N'Trung bình', 'CN0006', 'Unknown_person.jpg','012345678927'),
('CN0007', N'Phạm Văn Tuấn', 1, '1995-02-01', '2016-07-10', NULL, 'PX001', 'tuanpham@gmail.com', '0323456786', 700000, N'Giỏi', 'CN0007', 'Unknown_person.jpg','012345678928'),
('CN0008', N'Trần Thị Lan', 0, '1984-12-12', '2006-09-23', NULL, 'PX002', 'lantran@gmail.com', '0323456787', 700000, N'Khá', 'CN0008', 'Unknown_person.jpg','012345678929'),
('CN0009', N'Trần Thanh Tâm', 1, '1989-06-20', '2010-11-15', NULL, 'PX003', 'tamtran@yahoo.com', '0323456788', 700000, N'Trung bình', 'CN0009', 'Unknown_person.jpg','012345678930'),
('CN0010', N'Hà Thị An', 0, '1991-08-18', '2012-12-12', NULL, 'PX001', 'anh@gmail.com', '0323456789', 700000, N'Giỏi', 'CN0010', 'Unknown_person.jpg','0123456789031'),
('CN0011', N'Lê Văn Trung', 1, '1983-04-30', '2004-06-25', NULL, 'PX002', 'trung@gmail.com', '0323456710', 700000, N'Khá', 'CN0011', 'Unknown_person.jpg','012345678932'),
('CN0012', N'Nguyễn Thị Lan', 0, '1987-10-02', '2008-07-10', NULL, 'PX003', 'lan@gmail.com', '0323456720', 700000, N'Trung bình', 'CN0012', 'Unknown_person.jpg','012345678933'),
('CN0013', N'Nguyễn Văn Long', 1, '1982-03-17', '2003-05-20', NULL, 'PX001', 'long@gmail.com', '0323456730', 700000, N'Giỏi', 'CN0013', 'Unknown_person.jpg','012345678934'),
('CN0014', N'Trần Văn Bình', 0, '1993-07-08', '2014-09-30', NULL, 'PX002', 'binh@gmail.com', '0323456740', 700000, N'Khá', 'CN0014', 'Unknown_person.jpg','012345678935'),
('CN0015', N'Nguyễn Thị Hoa', 1, '1981-05-25', '2002-06-10', NULL, 'PX003', 'hoa@gmail.com', '0323456750', 700000, N'Trung bình', 'CN0015', 'Unknown_person.jpg','012345678936'),
('CN0016', N'Vũ Văn Đức', 1, '1980-08-12', '2001-12-25', NULL, 'PX001', 'duc@gmail.com', '0323456760', 700000, N'Giỏi', 'CN0016', 'Unknown_person.jpg','012345678937'),
('CN0017', N'Hoàng Văn Phú', 1, '1994-01-10', '2015-03-15', NULL, 'PX002', 'phu@gmail.com', '0323456770', 700000, N'Khá', 'CN0017', 'Unknown_person.jpg','012345678938'),
('CN0018', N'Lê Huy Hoàng', 1, '1996-09-28', '2017-11-20', NULL, 'PX003', 'hoang@gmail.com', '0323456788', 700000, N'Trung bình', 'CN0018', 'Unknown_person.jpg','012345678939'),
('CN0019', N'Phan Văn Hòa', 1, '1988-06-15', '2009-08-30', NULL, 'PX001', 'hoa@gmail.com', '0323456790', 700000, N'Giỏi', 'CN0019', 'Unknown_person.jpg','012345678940'),
('CN0020', N'Vũ Thị Thùy', 0, '1991-03-20', '2012-06-10', NULL, 'PX002', 'thuy@gmail.com', '0323456799', 700000, N'Khá', 'CN0020', 'Unknown_person.jpg','012345678941');
--Tạo 10 hop dong
INSERT INTO HopDongSanPham (idHopDong, tenHopDong, ngayBatDau, ngayKetThuc, idNguoiQuanLy, ghiChu)
VALUES
    ('HD0001', N'Hợp đồng Áo Khoác Mùa Đông', '2023-08-31', '2023-11-30', 'NV0004', N'Đang tiến hành'),
    ('HD0002', N'Hợp đồng Quần Jean Mùa Xuân', '2023-09-30', '2023-12-30', 'NV0004', N'Đang tiến hành'),
    ('HD0003', N'Hợp đồng Đầm Dự Tiệc', '2023-09-20', '2023-12-20', 'NV0003', N'Đang tiến hành'),
    ('HD0004', N'Hợp đồng Quần Kaki Mùa Hè', '2023-10-01', '2024-01-01', 'NV0004', N'Đang tiến hành'),
    ('HD0005', N'Hợp đồng Áo Thun Mùa Hè', '2023-05-01', '2023-08-01', 'NV0004', N'Đã hoàn thành'),
    ('HD0006', N'Hợp đồng Áo Sơ Mi Mùa Xuân', '2023-09-05', '2023-12-05', 'NV0004', N'Đang tiến hành'),
    ('HD0007', N'Hợp đồng Áo Phông Mùa Hè', '2023-07-10', '2023-10-10', 'NV0003', N'Đang tiến hành'),
    ('HD0008', N'Hợp đồng Đầm Công Sở', '2023-08-20', '2023-11-20', 'NV0004', N'Đang tiến hành'),
    ('HD0009', N'Hợp đồng Quần Áo Thể Thao', '2023-07-31', '2023-10-31', 'NV0003', N'Đã hoàn thành'),
    ('HD0010', N'Hợp đồng Áo Khoác Mùa Thu', '2023-10-10', '2024-01-10', 'NV0003', N'Đang tiến hành');

-- Thêm 10 sản phẩm
INSERT INTO SanPham (idSanPham, tenSanPham, donGia, chatLieu, donViTinh, ghiChu, anhSanPham)
VALUES
    ('SP0001', N'Áo Khoác Đông', 50000, N'Len', 'Cái', N'Áo khoác dành cho mùa Đông', 'path/to/anh1.jpg'),
    ('SP0002', N'Quần Jean Xuân', 35000, N'Jean', 'Cái', N'Quần Jean phong cách Xuân', 'path/to/anh2.jpg'),
    ('SP0003', N'Đầm Dự Tiệc', 60000, N'Vải Satin', 'Cái', N'Đầm dự tiệc sang trọng', 'path/to/anh3.jpg'),
    ('SP0004', N'Quần Kaki Hè', 30000, N'Kaki', 'Cái', N'Quần kaki thích hợp cho mùa Hè', 'path/to/anh4.jpg'),
    ('SP0005', N'Áo Thun Hè', 15000, N'Cotton', 'Cái', N'Áo thun mát mẻ cho mùa Hè', 'path/to/anh5.jpg'),
    ('SP0006', N'Áo Sơ Mi Xuân', 25000, N'Vải lụa', 'Cái', N'Áo sơ mi thời trang cho mùa Xuân', 'path/to/anh6.jpg'),
    ('SP0007', N'Áo Phông Hè', 18000, N'Cotton', 'Cái', N'Áo phông phong cách cho mùa Hè', 'path/to/anh7.jpg'),
    ('SP0008', N'Đầm Công Sở', 45000, N'Vải công sở', 'Cái', N'Đầm phù hợp cho công sở', 'path/to/anh8.jpg'),
    ('SP0009', N'Quần Thể Thao', 28000, N'Polyester', 'Cái', N'Quần thể thao cho mùa Xuân', 'path/to/anh9.jpg'),
    ('SP0010', N'Áo Khoác Thu', 52000, N'Len', 'Cái', N'Áo khoác cho mùa Thu', 'path/to/anh10.jpg');


--tHÊM 4 công đoạn

INSERT INTO CongDoanSP (idCongDoan, tenCongDoan, soLuongSanPham, luongCongDoan, idSanPham)
VALUES
    ('CDSP0001', N'Chuẩn bị nguyên vật liệu', 100, 50000, 'SP0001'),
    ('CDSP0002', N'Cắt vải', 120, 30000,  'SP0001'),
    ('CDSP0003', N'May áo khoác', 90, 35000,  'SP0001'),
    ('CDSP0004', N'Chuẩn bị vải jean', 130, 25000,  'SP0002'),
    ('CDSP0005', N'Cắt vải jean', 110, 20000,  'SP0002'),
    ('CDSP0006', N'May quần jean', 85, 30000,  'SP0002'),
	('CDSP0007', N'Chuẩn bị vải satin', 80, 20000,  'SP0003'),
	('CDSP0008', N'Cắt vải satin', 70, 18000, 'SP0003'),
	('CDSP0009', N'May đầm dự tiệc', 50, 25000,  'SP0003'),
	('CDSP0010', N'Chuẩn bị vải kaki', 95, 18000, 'SP0004'),
    ('CDSP0011', N'Cắt vải kaki', 85, 15000, 'SP0004'),
    ('CDSP0012', N'May quần kaki', 70, 20000, 'SP0004'),
    ('CDSP0013', N'Chuẩn bị vải cotton', 120, 15000, 'SP0005'),
    ('CDSP0014', N'Cắt vải cotton', 100, 12000, 'SP0005'),
    ('CDSP0015', N'May áo thun', 80, 18000, 'SP0005'),
    ('CDSP0016', N'Chuẩn bị vải lụa', 110, 25000, 'SP0006'),
    ('CDSP0017', N'Cắt vải lụa', 95, 22000, 'SP0006'),
    ('CDSP0018', N'May áo sơ mi', 75, 28000, 'SP0006'),
    ('CDSP0019', N'Chuẩn bị vải công sở', 105, 20000, 'SP0008'),
    ('CDSP0020', N'Cắt vải công sở', 90, 17000, 'SP0008'),
    ('CDSP0021', N'May đầm công sở', 70, 23000, 'SP0008'),
    ('CDSP0022', N'Chuẩn bị vải polyester', 100, 10000, 'SP0009'),
    ('CDSP0023', N'Cắt vải polyester', 85, 13000, 'SP0009'),
    ('CDSP0024', N'May quần thể thao', 65, 10000, 'SP0009'),
    ('CDSP0025', N'Chuẩn bị vải len', 115, 20000, 'SP0010'),
    ('CDSP0026', N'Cắt vải len', 100, 17000, 'SP0010'),
    ('CDSP0027', N'May áo khoác', 80, 22000, 'SP0010'),
	 ('CDSP0028', N'Chuẩn bị vải cotton', 120, 15000, 'SP0007'),
    ('CDSP0029', N'Cắt vải cotton', 100, 12000, 'SP0007'),
    ('CDSP0030', N'May áo phông', 80, 18000, 'SP0007')
--THÊM CONG DOAN PHAN CONG
-- Bảng phân công cho sản phẩm SP0001
-- Công đoạn 1
INSERT INTO CongDoanPhanCong (idPhanCong, idCongDoan, idCongNhan, soLuongSPDuocGiao, idCaLam, soLuongConLai)
VALUES 
    ('PC0001', 'CDSP0001', 'CN0001', 50, 1, 50),
    ('PC0002', 'CDSP0002', 'CN0002', 50, 2, 50),
    ('PC0003', 'CDSP0003', 'CN0003', 50, 3, 50),
    ('PC0004', 'CDSP0004', 'CN0004', 50, 1, 50),
    ('PC0005', 'CDSP0005', 'CN0005', 50, 2, 50),
    ('PC0006', 'CDSP0006', 'CN0006', 50, 3, 50),
    ('PC0007', 'CDSP0007', 'CN0007', 50, 1, 50),
    ('PC0008', 'CDSP0008', 'CN0008', 50, 2, 50),
    ('PC0009', 'CDSP0009', 'CN0001', 50, 3, 50),
    ('PC0010', 'CDSP0010', 'CN0002', 50, 1, 50),
    ('PC0011', 'CDSP0011', 'CN0003', 50, 2, 50),
    ('PC0012', 'CDSP0012', 'CN0004', 50, 3, 50),
    ('PC0013', 'CDSP0013', 'CN0005', 50, 1, 50),
    ('PC0014', 'CDSP0014', 'CN0006', 50, 2, 50),
    ('PC0015', 'CDSP0015', 'CN0007', 50, 3, 50),
    ('PC0016', 'CDSP0016', 'CN0008', 50, 1, 50),
    ('PC0017', 'CDSP0017', 'CN0001', 50, 2, 50),
    ('PC0018', 'CDSP0018', 'CN0002', 50, 3, 50),
    ('PC0019', 'CDSP0019', 'CN0003', 50, 1, 50),
    ('PC0020', 'CDSP0020', 'CN0004', 50, 2, 50),
    ('PC0021', 'CDSP0021', 'CN0005', 50, 3, 50),
    ('PC0022', 'CDSP0022', 'CN0006', 50, 1, 50),
    ('PC0023', 'CDSP0023', 'CN0007', 50, 2, 50),
    ('PC0024', 'CDSP0024', 'CN0008', 50, 3, 50),
    ('PC0025', 'CDSP0025', 'CN0001', 50, 1, 50),
    ('PC0026', 'CDSP0026', 'CN0002', 50, 2, 50),
    ('PC0027', 'CDSP0027', 'CN0003', 50, 3, 50),
    ('PC0028', 'CDSP0028', 'CN0004', 50, 1, 50),
    ('PC0029', 'CDSP0029', 'CN0005', 50, 2, 50),
    ('PC0030', 'CDSP0030', 'CN0006', 50, 3, 50),
    ('PC0031', 'CDSP0001', 'CN0007', 50, 1, 50),
    ('PC0032', 'CDSP0002', 'CN0008', 50, 2, 50),
    ('PC0033', 'CDSP0003', 'CN0001', 50, 3, 50),
    ('PC0034', 'CDSP0004', 'CN0002', 50, 1, 50),
    ('PC0035', 'CDSP0005', 'CN0003', 50, 2, 50),
    ('PC0036', 'CDSP0006', 'CN0004', 50, 3, 50),
    ('PC0037', 'CDSP0007', 'CN0005', 50, 1, 50),
    ('PC0038', 'CDSP0008', 'CN0006', 50, 2, 50),
    ('PC0039', 'CDSP0009', 'CN0007', 50, 3, 50),
    ('PC0040', 'CDSP0010', 'CN0008', 50, 1, 50),
    ('PC0041', 'CDSP0011', 'CN0001', 50, 2, 50),
    ('PC0042', 'CDSP0012', 'CN0002', 50, 3, 50),
    ('PC0043', 'CDSP0013', 'CN0003', 50, 1, 50),
    ('PC0044', 'CDSP0014', 'CN0004', 50, 2, 50),
    ('PC0045', 'CDSP0015', 'CN0005', 50, 3, 50),
    ('PC0046', 'CDSP0016', 'CN0006', 50, 1, 50),
    ('PC0047', 'CDSP0017', 'CN0007', 50, 2, 50),
    ('PC0048', 'CDSP0018', 'CN0008', 50, 3, 50),
    ('PC0049', 'CDSP0019', 'CN0001', 50, 1, 50),
    ('PC0050', 'CDSP0020', 'CN0002', 50, 2, 50),
    ('PC0051', 'CDSP0021', 'CN0003', 50, 3, 50),
    ('PC0052', 'CDSP0022', 'CN0004', 50, 1, 50),
    ('PC0053', 'CDSP0023', 'CN0005', 50, 2, 50),
    ('PC0054', 'CDSP0024', 'CN0006', 50, 3, 50),
    ('PC0055', 'CDSP0025', 'CN0007', 50, 1, 50),
    ('PC0056', 'CDSP0026', 'CN0008', 50, 2, 50),
    ('PC0057', 'CDSP0027', 'CN0001', 50, 3, 50),
    ('PC0058', 'CDSP0028', 'CN0002', 50, 1, 50),
    ('PC0059', 'CDSP0029', 'CN0003', 50, 2, 50),
    ('PC0060', 'CDSP0030', 'CN0004', 50, 3, 50);
go
INSERT INTO BangChamCongCongNhan (idNgayChamCong, ngayChamCong, soLuongHoanThanh, idPhanCong, heSoNgayLam)
VALUES
	('CCN0001', '2023-10-01', 10, 'PC0001', 1.35),
    ('CCN0002', '2023-10-02', 5, 'PC0001', 1),
    ('CCN0003', '2023-10-03', 5, 'PC0001', 1),
    ('CCN0004', '2023-10-04', 5, 'PC0001', 1),
    ('CCN0005', '2023-10-05', 5, 'PC0001', 1),
    ('CCN0006', '2023-10-06', 0, 'PC0001', 1),

	('CCN0007', '2023-10-01', 8, 'PC0002', 1),
    ('CCN0008', '2023-10-02', 10, 'PC0002', 1.5),
    ('CCN0009', '2023-10-03', 9, 'PC0002', 1),
    ('CCN0010', '2023-10-04', 10, 'PC0002', 1.5),
    ('CCN0011', '2023-10-05', 8, 'PC0002', 1),
    ('CCN0012', '2023-10-06', 5, 'PC0002', 1.5),

	('CCN0013', '2023-10-01', 10, 'PC0003', 1.5),
    ('CCN0014', '2023-10-02', 9, 'PC0003', 1),
    ('CCN0015', '2023-10-03', 10, 'PC0003', 1.5),
    ('CCN0016', '2023-10-04', 8, 'PC0003', 1),
    ('CCN0017', '2023-10-05', 10, 'PC0003', 1.5),
    ('CCN0018', '2023-10-06', 3, 'PC0003', 1),

	('CCN0019', '2023-10-01', 12, 'PC0004', 1.5),
    ('CCN0020', '2023-10-02', 10, 'PC0004', 1),
    ('CCN0021', '2023-10-03', 10, 'PC0004', 1.5),
    ('CCN0022', '2023-10-04', 10, 'PC0004', 1),
    ('CCN0023', '2023-10-05', 8, 'PC0004', 1.5),
    ('CCN0024', '2023-10-06', 10, 'PC0004', 1),

	('CCN0025', '2023-10-01', 11, 'PC0005', 1),
    ('CCN0026', '2023-10-02', 9, 'PC0005', 1.5),
    ('CCN0027', '2023-10-03', 12, 'PC0005', 1),
    ('CCN0028', '2023-10-04', 9, 'PC0005', 1.5),
    ('CCN0029', '2023-10-05', 10, 'PC0005', 1),
    ('CCN0030', '2023-10-06', 9, 'PC0005', 1.5),

	('CCN0031', '2023-10-01', 12, 'PC0006', 1.5),
    ('CCN0032', '2023-10-02', 10, 'PC0006', 1),
    ('CCN0033', '2023-10-03', 10, 'PC0006', 1.5),
    ('CCN0034', '2023-10-04', 11, 'PC0006', 1),
    ('CCN0035', '2023-10-05', 9, 'PC0006', 1.5),
    ('CCN0036', '2023-10-06', 11, 'PC0006', 1),

	 ('CCN0037', '2023-10-01', 12, 'PC0007', 1),
    ('CCN0038', '2023-10-02', 10, 'PC0007', 1.5),
    ('CCN0039', '2023-10-03', 10, 'PC0007', 1),
    ('CCN0040', '2023-10-04', 12, 'PC0007', 1.5),
    ('CCN0041', '2023-10-05', 9, 'PC0007', 1),
    ('CCN0042', '2023-10-06', 7, 'PC0007', 1.5),

	('CCN0043', '2023-10-01', 11, 'PC0008', 1.5),
    ('CCN0044', '2023-10-02', 10, 'PC0008', 1),
    ('CCN0045', '2023-10-03', 11, 'PC0008', 1.5),
    ('CCN0046', '2023-10-04', 10, 'PC0008', 1),
    ('CCN0047', '2023-10-05', 9, 'PC0008', 1.5),
    ('CCN0048', '2023-10-06', 9, 'PC0008', 1),
	---
	('CCN0049', '2023-10-07', 12, 'PC0009', 1.5),
    ('CCN0050', '2023-10-08', 10, 'PC0009', 1),
    ('CCN0051', '2023-10-09', 10, 'PC0009', 1.5),
    ('CCN0052', '2023-10-10', 11, 'PC0009', 1),
    ('CCN0053', '2023-10-11', 9, 'PC0009', 1.5),
    ('CCN0054', '2023-10-12', 10, 'PC0009', 1),

	 ('CCN0055', '2023-10-07', 11, 'PC0010', 1),
    ('CCN0056', '2023-10-08', 9, 'PC0010', 1.5),
    ('CCN0057', '2023-10-09', 12, 'PC0010', 1),
    ('CCN0058', '2023-10-10', 9, 'PC0010', 1.5),
    ('CCN0059', '2023-10-11', 10, 'PC0010', 1),
    ('CCN0060', '2023-10-12', 9, 'PC0010', 1.5),

	 ('CCN0061', '2023-10-07', 12, 'PC0011', 1.5),
    ('CCN0062', '2023-10-08', 10, 'PC0011', 1),
    ('CCN0063', '2023-10-09', 10, 'PC0011', 1.5),
    ('CCN0064', '2023-10-10', 11, 'PC0011', 1),
    ('CCN0065', '2023-10-11', 9, 'PC0011', 1.5),
    ('CCN0066', '2023-10-12', 11, 'PC0011', 1),

	 ('CCN0067', '2023-10-07', 13, 'PC0012', 1),
    ('CCN0068', '2023-10-08', 10, 'PC0012', 1.5),
    ('CCN0069', '2023-10-09', 11, 'PC0012', 1),
    ('CCN0070', '2023-10-10', 10, 'PC0012', 1.5),
    ('CCN0071', '2023-10-11', 9, 'PC0012', 1),
    ('CCN0072', '2023-10-12', 8, 'PC0012', 1.5),

	('CCN0073', '2023-10-07', 11, 'PC0013', 1.5),
    ('CCN0074', '2023-10-08', 10, 'PC0013', 1),
    ('CCN0075', '2023-10-09', 11, 'PC0013', 1.5),
    ('CCN0076', '2023-10-10', 10, 'PC0013', 1),
    ('CCN0077', '2023-10-11', 9, 'PC0013', 1.5),
    ('CCN0078', '2023-10-12', 9, 'PC0013', 1),

	('CCN0079', '2023-10-07', 12, 'PC0014', 1),
    ('CCN0080', '2023-10-08', 10, 'PC0014', 1.5),
    ('CCN0081', '2023-10-09', 10, 'PC0014', 1),
    ('CCN0082', '2023-10-10', 12, 'PC0014', 1.5),
    ('CCN0083', '2023-10-11', 9, 'PC0014', 1),
    ('CCN0084', '2023-10-12', 7, 'PC0014', 1.5),
	
	 ('CCN0085', '2023-10-07', 12, 'PC0015', 1.5),
    ('CCN0086', '2023-10-08', 10, 'PC0015', 1),
    ('CCN0087', '2023-10-09', 10, 'PC0015', 1.5),
    ('CCN0088', '2023-10-10', 11, 'PC0015', 1),
    ('CCN0089', '2023-10-11', 9, 'PC0015', 1.5),
    ('CCN0090', '2023-10-12', 8, 'PC0015', 1),

	 ('CCN0091', '2023-10-07', 11, 'PC0016', 1),
    ('CCN0092', '2023-10-08', 10, 'PC0016', 1.5),
    ('CCN0093', '2023-10-09', 11, 'PC0016', 1),
    ('CCN0094', '2023-10-10', 10, 'PC0016', 1.5),
    ('CCN0095', '2023-10-11', 9, 'PC0016', 1),
    ('CCN0096', '2023-10-12', 9, 'PC0016', 1.5),

	---
	 ('CCN0097', '2023-10-13', 10, 'PC0017', 1),
    ('CCN0098', '2023-10-14', 10, 'PC0017', 1.5),
    ('CCN0099', '2023-10-15', 5, 'PC0017', 1),
    ('CCN0100', '2023-10-16', 10, 'PC0017', 1.5),
    ('CCN0101', '2023-10-17', 5, 'PC0017', 1),
    ('CCN0102', '2023-10-18', 3, 'PC0017', 1.5),
    ('CCN0103', '2023-10-19', 4, 'PC0017', 1),
    ('CCN0104', '2023-10-20', 3, 'PC0017', 1.5),

	('CCN0105', '2023-10-13', 7, 'PC0018', 1),
    ('CCN0106', '2023-10-14', 7, 'PC0018', 1.5),
    ('CCN0107', '2023-10-15', 7, 'PC0018', 1),
    ('CCN0108', '2023-10-16', 7, 'PC0018', 1.5),
    ('CCN0109', '2023-10-17', 7, 'PC0018', 1),
    ('CCN0110', '2023-10-18', 7, 'PC0018', 1.5),
    ('CCN0111', '2023-10-19', 7, 'PC0018', 1),
    ('CCN0112', '2023-10-20', 8, 'PC0018', 1.5),

	('CCN0113', '2023-10-13', 10, 'PC0019', 1.5),
    ('CCN0114', '2023-10-14', 7, 'PC0019', 1),
    ('CCN0115', '2023-10-15', 3, 'PC0019', 1.5),
    ('CCN0116', '2023-10-16', 5, 'PC0019', 1),
    ('CCN0117', '2023-10-17', 10, 'PC0019', 1.5),
    ('CCN0118', '2023-10-18', 5, 'PC0019', 1),
    ('CCN0119', '2023-10-19', 5, 'PC0019', 1.5),
    ('CCN0120', '2023-10-20', 5, 'PC0019', 1),

	('CCN0121', '2023-10-13', 10, 'PC0020', 1),
    ('CCN0122', '2023-10-14', 7, 'PC0020', 1.5),
    ('CCN0123', '2023-10-15', 3, 'PC0020', 1),
    ('CCN0124', '2023-10-16', 5, 'PC0020', 1.5),
    ('CCN0125', '2023-10-17', 5, 'PC0020', 1),
    ('CCN0126', '2023-10-18', 6, 'PC0020', 1.5),
    ('CCN0127', '2023-10-19', 4, 'PC0020', 1),
    ('CCN0128', '2023-10-20', 10, 'PC0020', 1.5),

	('CCN0129', '2023-10-13', 10, 'PC0021', 1),
    ('CCN0130', '2023-10-14', 10, 'PC0021', 1.5),
    ('CCN0131', '2023-10-15', 5, 'PC0021', 1),
    ('CCN0132', '2023-10-16', 5, 'PC0021', 1.5),
    ('CCN0133', '2023-10-17', 4, 'PC0021', 1),
    ('CCN0134', '2023-10-18', 6, 'PC0021', 1.5),
    ('CCN0135', '2023-10-19', 5, 'PC0021', 1),
    ('CCN0136', '2023-10-20', 5, 'PC0021', 1),

	 ('CCN0137', '2023-10-13', 12, 'PC0022', 1.5),
    ('CCN0138', '2023-10-14', 9, 'PC0022', 1),
    ('CCN0139', '2023-10-15', 10, 'PC0022', 1.5),
    ('CCN0140', '2023-10-16', 11, 'PC0022', 1),
    ('CCN0141', '2023-10-17', 9, 'PC0022', 1.5),
    ('CCN0142', '2023-10-18', 11, 'PC0022', 1),
    ('CCN0143', '2023-10-19', 10, 'PC0022', 1.5),
    ('CCN0144', '2023-10-20', 8, 'PC0022', 1),

	('CCN0145', '2023-10-13', 10, 'PC0023', 1),
    ('CCN0146', '2023-10-14', 10, 'PC0023', 1.5),
    ('CCN0147', '2023-10-15', 5, 'PC0023', 1),
    ('CCN0148', '2023-10-16', 5, 'PC0023', 1.5),
    ('CCN0149', '2023-10-17', 3, 'PC0023', 1),
    ('CCN0150', '2023-10-18', 7, 'PC0023', 1.5),
    ('CCN0151', '2023-10-19', 7, 'PC0023', 1),
    ('CCN0152', '2023-10-20', 3, 'PC0023', 1.5),

    ('CCN0153', '2023-10-13', 9, 'PC0024', 1),
    ('CCN0154', '2023-10-14', 10, 'PC0024', 1.5),
    ('CCN0155', '2023-10-15', 10, 'PC0024', 1),
    ('CCN0156', '2023-10-16', 11, 'PC0024', 1.5),
    ('CCN0157', '2023-10-17', 10, 'PC0024', 1),
    ('CCN0158', '2023-10-18', 10, 'PC0024', 1.5),
    ('CCN0159', '2023-10-19', 11, 'PC0024', 1),
    ('CCN0160', '2023-10-20', 11, 'PC0024', 1),
	----
	('CCN0161', '2023-10-21', 10, 'PC0025', 1),
    ('CCN0162', '2023-10-22', 10, 'PC0025', 1),
    ('CCN0163', '2023-10-23', 10, 'PC0025', 1),
    ('CCN0164', '2023-10-24', 10, 'PC0025', 1),
    ('CCN0165', '2023-10-25', 10, 'PC0025', 1),

	 ('CCN0166', '2023-10-21', 10, 'PC0026', 1),
    ('CCN0167', '2023-10-22', 10, 'PC0026', 1),
    ('CCN0168', '2023-10-23', 10, 'PC0026', 1),
    ('CCN0169', '2023-10-24', 10, 'PC0026', 1),
    ('CCN0170', '2023-10-25', 10, 'PC0026', 1),

	('CCN0171', '2023-10-21', 10, 'PC0027', 1),
    ('CCN0172', '2023-10-22', 10, 'PC0027', 1),
    ('CCN0173', '2023-10-23', 10, 'PC0027', 1),
    ('CCN0174', '2023-10-24', 10, 'PC0027', 1),
    ('CCN0175', '2023-10-25', 10, 'PC0027', 1),

	('CCN0176', '2023-10-21', 10, 'PC0028', 1),
    ('CCN0177', '2023-10-22', 10, 'PC0028', 1),
    ('CCN0178', '2023-10-23', 10, 'PC0028', 1),
    ('CCN0179', '2023-10-24', 10, 'PC0028', 1),
    ('CCN0180', '2023-10-25', 10, 'PC0028', 1.35),

	('CCN0181', '2023-10-21', 10, 'PC0029', 1),
    ('CCN0182', '2023-10-22', 10, 'PC0029', 1),
    ('CCN0183', '2023-10-23', 10, 'PC0029', 1),
    ('CCN0184', '2023-10-24', 10, 'PC0029', 1.35),
    ('CCN0185', '2023-10-25', 10, 'PC0029', 1.35),

	('CCN0186', '2023-10-21', 10, 'PC0030', 1.35),
    ('CCN0187', '2023-10-22', 10, 'PC0030', 1),
    ('CCN0188', '2023-10-23', 10, 'PC0030', 1),
    ('CCN0189', '2023-10-24', 10, 'PC0030', 1),
    ('CCN0190', '2023-10-25', 10, 'PC0030', 1.35),

	 ('CCN0191', '2023-10-21', 10, 'PC0031', 1),
    ('CCN0192', '2023-10-22', 10, 'PC0031', 1),
    ('CCN0193', '2023-10-23', 10, 'PC0031', 1),
    ('CCN0194', '2023-10-24', 10, 'PC0031', 1),
    ('CCN0195', '2023-10-25', 10, 'PC0031', 1),

	 ('CCN0196', '2023-10-21', 10, 'PC0032', 1),
    ('CCN0197', '2023-10-22', 10, 'PC0032', 1),
    ('CCN0198', '2023-10-23', 10, 'PC0032', 1),
    ('CCN0199', '2023-10-24', 10, 'PC0032', 1),
    ('CCN0200', '2023-10-25', 10, 'PC0032', 1),
	---
	('CCN0201', '2023-10-26', 6, 'PC0033', 1),
	('CCN0202', '2023-10-27', 6, 'PC0033', 1),
	('CCN0203', '2023-10-28', 6, 'PC0033', 1),
	('CCN0204', '2023-10-29', 10, 'PC0033', 1),
	('CCN0205', '2023-10-30', 5, 'PC0033', 1),
	('CCN0206', '2023-10-31', 5, 'PC0033', 1),
	('CCN0207', '2023-11-01', 4, 'PC0033', 1),
	('CCN0208', '2023-11-02', 4, 'PC0033', 1),
	('CCN0209', '2023-11-03', 4, 'PC0033', 1),
	('CCN0210', '2023-10-26', 6, 'PC0034', 1),
	('CCN0211', '2023-10-27', 6, 'PC0034', 1),
	('CCN0212', '2023-10-28', 6, 'PC0034', 1),
	('CCN0213', '2023-10-29', 10, 'PC0034', 1),
	('CCN0214', '2023-10-30', 5, 'PC0034', 1),
	('CCN0215', '2023-10-31', 5, 'PC0034', 1),
	('CCN0216', '2023-11-01', 4, 'PC0034', 1),
	('CCN0217', '2023-11-02', 4, 'PC0034', 1),
	('CCN0218', '2023-11-03', 4, 'PC0034', 1),
	('CCN0219', '2023-10-26', 6, 'PC0035', 1),
	('CCN0220', '2023-10-27', 6, 'PC0035', 1),
	('CCN0221', '2023-10-28', 6, 'PC0035', 1),
	('CCN0222', '2023-10-29', 10, 'PC0035', 1),
	('CCN0223', '2023-10-30', 5, 'PC0035', 1),
	('CCN0224', '2023-10-31', 5, 'PC0035', 1),
	('CCN0225', '2023-11-01', 4, 'PC0035', 1),
	('CCN0226', '2023-11-02', 4, 'PC0035', 1),
	('CCN0227', '2023-11-03', 4, 'PC0035', 1),
	('CCN0228', '2023-10-26', 6, 'PC0036', 1),
	('CCN0229', '2023-10-27', 6, 'PC0036', 1),
	('CCN0230', '2023-10-28', 6, 'PC0036', 1),
	('CCN0231', '2023-10-29', 10, 'PC0036', 1),
	('CCN0232', '2023-10-30', 5, 'PC0036', 1),
	('CCN0233', '2023-10-31', 5, 'PC0036', 1),
	('CCN0234', '2023-11-01', 4, 'PC0036', 1),
	('CCN0235', '2023-11-02', 4, 'PC0036', 1),
	('CCN0236', '2023-11-03', 4, 'PC0036', 1),
	('CCN0237', '2023-10-26', 6, 'PC0037', 1),
	('CCN0238', '2023-10-27', 6, 'PC0037', 1),
	('CCN0239', '2023-10-28', 6, 'PC0037', 1),
	('CCN0240', '2023-10-29', 10, 'PC0037', 1),
	('CCN0241', '2023-10-30', 5, 'PC0037', 1),
	('CCN0242', '2023-10-31', 5, 'PC0037', 1),
	('CCN0243', '2023-11-01', 4, 'PC0037', 1),
	('CCN0244', '2023-11-02', 4, 'PC0037', 1),
	('CCN0245', '2023-11-03', 4, 'PC0037', 1),
	('CCN0246', '2023-10-26', 6, 'PC0038', 1),
	('CCN0247', '2023-10-27', 6, 'PC0038', 1),
	('CCN0248', '2023-10-28', 6, 'PC0038', 1),
	('CCN0249', '2023-10-29', 10, 'PC0038', 1),
	('CCN0250', '2023-10-30', 5, 'PC0038', 1),
	('CCN0251', '2023-10-31', 5, 'PC0038', 1),
	('CCN0252', '2023-11-01', 4, 'PC0038', 1),
	('CCN0253', '2023-11-02', 4, 'PC0038', 1),
	('CCN0254', '2023-11-03', 4, 'PC0038', 1),
	('CCN0255', '2023-10-26', 6, 'PC0039', 1),
	('CCN0256', '2023-10-27', 6, 'PC0039', 1),
	('CCN0257', '2023-10-28', 6, 'PC0039', 1),
	('CCN0258', '2023-10-29', 10, 'PC0039', 1),
	('CCN0259', '2023-10-30', 5, 'PC0039', 1),
	('CCN0260', '2023-10-31', 5, 'PC0039', 1),
	('CCN0261', '2023-11-01', 4, 'PC0039', 1),
	('CCN0262', '2023-11-02', 4, 'PC0039', 1),
	('CCN0263', '2023-11-03', 4, 'PC0039', 1),
	('CCN0264', '2023-10-26', 6, 'PC0040', 1),
	('CCN0265', '2023-10-27', 6, 'PC0040', 1),
	('CCN0266', '2023-10-28', 6, 'PC0040', 1),
	('CCN0267', '2023-10-29', 10, 'PC0040', 1),
	('CCN0268', '2023-10-30', 5, 'PC0040', 1),
	('CCN0269', '2023-10-31', 5, 'PC0040', 1),
	('CCN0270', '2023-11-01', 4, 'PC0040', 1),
	('CCN0271', '2023-11-02', 4, 'PC0040', 1),
	('CCN0272', '2023-11-03', 4, 'PC0040', 1),
	('CCN0273', '2023-11-04', 6, 'PC0041', 1),
	('CCN0274', '2023-11-05', 6, 'PC0041', 1),
	('CCN0275', '2023-11-06', 6, 'PC0041', 1),
	('CCN0276', '2023-11-07', 10, 'PC0041', 1),
	('CCN0277', '2023-11-08', 5, 'PC0041', 1),
	('CCN0278', '2023-11-09', 5, 'PC0041', 1),
	('CCN0279', '2023-11-10', 4, 'PC0041', 1),
	('CCN0280', '2023-11-11', 4, 'PC0041', 1),
	('CCN0281', '2023-11-12', 4, 'PC0041', 1),
	('CCN0282', '2023-11-13', 4, 'PC0041', 1),
	('CCN0283', '2023-11-04', 6, 'PC0042', 1),
	('CCN0284', '2023-11-05', 6, 'PC0042', 1),
	('CCN0285', '2023-11-06', 6, 'PC0042', 1),
	('CCN0286', '2023-11-07', 10, 'PC0042', 1),
	('CCN0287', '2023-11-08', 5, 'PC0042', 1),
	('CCN0288', '2023-11-09', 5, 'PC0042', 1),
	('CCN0289', '2023-11-10', 4, 'PC0042', 1),
	('CCN0290', '2023-11-11', 4, 'PC0042', 1),
	('CCN0291', '2023-11-12', 4, 'PC0042', 1),
	('CCN0292', '2023-11-13', 4, 'PC0042', 1),
	('CCN0293', '2023-11-04', 6, 'PC0043', 1),
	('CCN0294', '2023-11-05', 6, 'PC0043', 1),
	('CCN0295', '2023-11-06', 6, 'PC0043', 1),
	('CCN0296', '2023-11-07', 10, 'PC0043', 1),
	('CCN0297', '2023-11-08', 5, 'PC0043', 1),
	('CCN0298', '2023-11-09', 5, 'PC0043', 1),
	('CCN0299', '2023-11-10', 4, 'PC0043', 1),
	('CCN0300', '2023-11-11', 4, 'PC0043', 1),
	('CCN0301', '2023-11-12', 4, 'PC0043', 1),
	('CCN0302', '2023-11-13', 4, 'PC0043', 1),
	('CCN0303', '2023-11-04', 6, 'PC0044', 1),
	('CCN0304', '2023-11-05', 6, 'PC0044', 1),
	('CCN0305', '2023-11-06', 6, 'PC0044', 1),
	('CCN0306', '2023-11-07', 10, 'PC0044', 1),
	('CCN0307', '2023-11-08', 5, 'PC0044', 1),
	('CCN0308', '2023-11-09', 5, 'PC0044', 1),
	('CCN0309', '2023-11-10', 4, 'PC0044', 1),
	('CCN0310', '2023-11-11', 4, 'PC0044', 1),
	('CCN0311', '2023-11-12', 4, 'PC0044', 1),
	('CCN0312', '2023-11-13', 4, 'PC0044', 1),
	('CCN0313', '2023-11-04', 6, 'PC0045', 1),
	('CCN0314', '2023-11-05', 6, 'PC0045', 1),
	('CCN0315', '2023-11-06', 6, 'PC0045', 1),
	('CCN0316', '2023-11-07', 10, 'PC0045', 1),
	('CCN0317', '2023-11-08', 5, 'PC0045', 1),
	('CCN0318', '2023-11-09', 5, 'PC0045', 1),
	('CCN0319', '2023-11-10', 4, 'PC0045', 1),
	('CCN0320', '2023-11-11', 4, 'PC0045', 1),
	('CCN0321', '2023-11-12', 4, 'PC0045', 1),
	('CCN0322', '2023-11-13', 4, 'PC0045', 1),
	('CCN0323', '2023-11-04', 6, 'PC0046', 1),
	('CCN0324', '2023-11-05', 6, 'PC0046', 1),
	('CCN0325', '2023-11-06', 6, 'PC0046', 1),
	('CCN0326', '2023-11-07', 10, 'PC0046', 1),
	('CCN0327', '2023-11-08', 5, 'PC0046', 1),
	('CCN0328', '2023-11-09', 5, 'PC0046', 1),
	('CCN0329', '2023-11-10', 4, 'PC0046', 1),
	('CCN0330', '2023-11-11', 4, 'PC0046', 1),
	('CCN0331', '2023-11-12', 4, 'PC0046', 1),
	('CCN0332', '2023-11-13', 4, 'PC0046', 1),
	('CCN0333', '2023-11-04', 6, 'PC0047', 1),
	('CCN0334', '2023-11-05', 6, 'PC0047', 1),
	('CCN0335', '2023-11-06', 6, 'PC0047', 1),
	('CCN0336', '2023-11-07', 10, 'PC0047', 1),
	('CCN0337', '2023-11-08', 5, 'PC0047', 1),
	('CCN0338', '2023-11-09', 5, 'PC0047', 1),
	('CCN0339', '2023-11-10', 4, 'PC0047', 1),
	('CCN0340', '2023-11-11', 4, 'PC0047', 1),
	('CCN0341', '2023-11-12', 4, 'PC0047', 1),
	('CCN0342', '2023-11-13', 4, 'PC0047', 1),
	('CCN0343', '2023-11-04', 6, 'PC0048', 1),
	('CCN0344', '2023-11-05', 6, 'PC0048', 1),
	('CCN0345', '2023-11-06', 6, 'PC0048', 1),
	('CCN0346', '2023-11-07', 10, 'PC0048', 1),
	('CCN0347', '2023-11-08', 5, 'PC0048', 1),
	('CCN0348', '2023-11-09', 5, 'PC0048', 1),
	('CCN0349', '2023-11-10', 4, 'PC0048', 1),
	('CCN0350', '2023-11-11', 4, 'PC0048', 1),
	('CCN0351', '2023-11-12', 4, 'PC0048', 1),
	('CCN0352', '2023-11-13', 4, 'PC0048', 1),
	('CCN0353', '2023-11-14', 6, 'PC0049', 1),
	('CCN0354', '2023-11-15', 6, 'PC0049', 1),
	('CCN0355', '2023-11-16', 6, 'PC0049', 1),
	('CCN0356', '2023-11-17', 10, 'PC0049', 1),
	('CCN0357', '2023-11-18', 5, 'PC0049', 1),
	('CCN0358', '2023-11-19', 5, 'PC0049', 1),
	('CCN0359', '2023-11-20', 4, 'PC0049', 1),
	('CCN0360', '2023-11-21', 4, 'PC0049', 1),
	('CCN0361', '2023-11-22', 4, 'PC0049', 1),
	('CCN0362', '2023-11-23', 4, 'PC0049', 1),
	('CCN0363', '2023-11-14', 6, 'PC0050', 1),
	('CCN0364', '2023-11-15', 6, 'PC0050', 1),
	('CCN0365', '2023-11-16', 6, 'PC0050', 1),
	('CCN0366', '2023-11-17', 10, 'PC0050', 1),
	('CCN0367', '2023-11-18', 5, 'PC0050', 1),
	('CCN0368', '2023-11-19', 5, 'PC0050', 1),
	('CCN0369', '2023-11-20', 4, 'PC0050', 1),
	('CCN0370', '2023-11-21', 4, 'PC0050', 1),
	('CCN0371', '2023-11-22', 4, 'PC0050', 1),
	('CCN0372', '2023-11-23', 4, 'PC0050', 1),
	('CCN0373', '2023-11-14', 6, 'PC0051', 1),
('CCN0374', '2023-11-15', 6, 'PC0051', 1),
('CCN0375', '2023-11-16', 6, 'PC0051', 1),
('CCN0376', '2023-11-17', 10, 'PC0051', 1),
('CCN0377', '2023-11-18', 5, 'PC0051', 1),
('CCN0378', '2023-11-19', 5, 'PC0051', 1),
('CCN0379', '2023-11-20', 4, 'PC0051', 1),
('CCN0380', '2023-11-21', 4, 'PC0051', 1),
('CCN0381', '2023-11-22', 4, 'PC0051', 1),
('CCN0382', '2023-11-23', 4, 'PC0051', 1),
('CCN0383', '2023-11-14', 6, 'PC0052', 1),
('CCN0384', '2023-11-15', 6, 'PC0052', 1),
('CCN0385', '2023-11-16', 6, 'PC0052', 1),
('CCN0386', '2023-11-17', 10, 'PC0052', 1),
('CCN0387', '2023-11-18', 5, 'PC0052', 1),
('CCN0388', '2023-11-19', 5, 'PC0052', 1),
('CCN0389', '2023-11-20', 4, 'PC0052', 1),
('CCN0390', '2023-11-21', 4, 'PC0052', 1),
('CCN0391', '2023-11-22', 4, 'PC0052', 1),
('CCN0392', '2023-11-23', 4, 'PC0052', 1),
('CCN0393', '2023-11-14', 6, 'PC0053', 1),
('CCN0394', '2023-11-15', 6, 'PC0053', 1),
('CCN0395', '2023-11-16', 6, 'PC0053', 1),
('CCN0396', '2023-11-17', 10, 'PC0053', 1),
('CCN0397', '2023-11-18', 5, 'PC0053', 1),
('CCN0398', '2023-11-19', 5, 'PC0053', 1),
('CCN0399', '2023-11-20', 4, 'PC0053', 1),
('CCN0400', '2023-11-21', 4, 'PC0053', 1),
('CCN0401', '2023-11-22', 4, 'PC0053', 1),
('CCN0402', '2023-11-23', 4, 'PC0053', 1),
('CCN0403', '2023-11-14', 6, 'PC0054', 1),
('CCN0404', '2023-11-15', 6, 'PC0054', 1),
('CCN0405', '2023-11-16', 6, 'PC0054', 1),
('CCN0406', '2023-11-17', 10, 'PC0054', 1),
('CCN0407', '2023-11-18', 5, 'PC0054', 1),
('CCN0408', '2023-11-19', 5, 'PC0054', 1),
('CCN0409', '2023-11-20', 4, 'PC0054', 1),
('CCN0410', '2023-11-21', 4, 'PC0054', 1),
('CCN0411', '2023-11-22', 4, 'PC0054', 1),
('CCN0412', '2023-11-23', 4, 'PC0054', 1),
('CCN0413', '2023-11-14', 6, 'PC0055', 1),
('CCN0414', '2023-11-15', 6, 'PC0055', 1),
('CCN0415', '2023-11-16', 6, 'PC0055', 1),
('CCN0416', '2023-11-17', 10, 'PC0055', 1),
('CCN0417', '2023-11-18', 5, 'PC0055', 1),
('CCN0418', '2023-11-19', 5, 'PC0055', 1),
('CCN0419', '2023-11-20', 4, 'PC0055', 1),
('CCN0420', '2023-11-21', 4, 'PC0055', 1),
('CCN0421', '2023-11-22', 4, 'PC0055', 1),
('CCN0422', '2023-11-23', 4, 'PC0055', 1),
('CCN0423', '2023-11-14', 6, 'PC0056', 1),
('CCN0424', '2023-11-15', 6, 'PC0056', 1),
('CCN0425', '2023-11-16', 6, 'PC0056', 1),
('CCN0426', '2023-11-17', 10, 'PC0056', 1),
('CCN0427', '2023-11-18', 5, 'PC0056', 1),
('CCN0428', '2023-11-19', 5, 'PC0056', 1),
('CCN0429', '2023-11-20', 4, 'PC0056', 1),
('CCN0430', '2023-11-21', 4, 'PC0056', 1),
('CCN0431', '2023-11-22', 4, 'PC0056', 1),
('CCN0432', '2023-11-23', 4, 'PC0056', 1),
('CCN0433', '2023-11-24', 7, 'PC0057', 1),
('CCN0434', '2023-11-25', 7, 'PC0057', 1),
('CCN0435', '2023-11-26', 7, 'PC0057', 1),
('CCN0436', '2023-11-27', 7, 'PC0057', 1),
('CCN0437', '2023-11-28', 7, 'PC0057', 1),
('CCN0438', '2023-11-29', 7, 'PC0057', 1),
('CCN0439', '2023-11-30', 8, 'PC0057', 1),
('CCN0440', '2023-11-24', 7, 'PC0058', 1),
('CCN0441', '2023-11-25', 7, 'PC0058', 1),
('CCN0442', '2023-11-26', 7, 'PC0058', 1),
('CCN0443', '2023-11-27', 7, 'PC0058', 1),
('CCN0444', '2023-11-28', 7, 'PC0058', 1),
('CCN0445', '2023-11-29', 7, 'PC0058', 1),
('CCN0446', '2023-11-30', 8, 'PC0058', 1),
('CCN0447', '2023-11-24', 7, 'PC0059', 1),
('CCN0448', '2023-11-25', 7, 'PC0059', 1),
('CCN0449', '2023-11-26', 7, 'PC0059', 1),
('CCN0450', '2023-11-27', 7, 'PC0059', 1),
('CCN0451', '2023-11-28', 7, 'PC0059', 1),
('CCN0452', '2023-11-29', 7, 'PC0059', 1),
('CCN0453', '2023-11-30', 8, 'PC0059', 1),
('CCN0454', '2023-11-24', 7, 'PC0060', 1),
('CCN0455', '2023-11-25', 7, 'PC0060', 1),
('CCN0456', '2023-11-26', 7, 'PC0060', 1),
('CCN0457', '2023-11-27', 7, 'PC0060', 1),
('CCN0458', '2023-11-28', 7, 'PC0060', 1),
('CCN0459', '2023-11-29', 7, 'PC0060', 1),
('CCN0460', '2023-11-30', 8, 'PC0060', 1)

--Thêm 1 nhan vien đã làm 30 ngày
INSERT INTO BangChamCongNhanVienHC (idChamCong, ngayChamCong, trangThai, idNhanVien)
VALUES
    ('CNVHC0001', '2023-10-01', N'Có mặt', 'NV0001'),
	('CNVHC0002', '2023-10-02', N'Có mặt', 'NV0001'),
	('CNVHC0003', '2023-10-03', N'Có mặt', 'NV0001'),
	('CNVHC0004', '2023-10-04', N'Có mặt', 'NV0001'),
	('CNVHC0005', '2023-10-05', N'Có mặt', 'NV0001'),
	('CNVHC0006', '2023-10-06', N'Có phép', 'NV0001'),
	('CNVHC0007', '2023-10-07', N'Có mặt', 'NV0001'),
	('CNVHC0008', '2023-10-08', N'Có mặt', 'NV0001'),
	('CNVHC0009', '2023-10-09', N'Có mặt', 'NV0001'),
	('CNVHC0010', '2023-10-10', N'Có mặt', 'NV0001'),
	('CNVHC0011', '2023-10-11', N'Có mặt', 'NV0001'),
	('CNVHC0012', '2023-10-12', N'Có mặt', 'NV0001'),
	('CNVHC0013', '2023-10-13', N'Có mặt', 'NV0001'),
	('CNVHC0014', '2023-10-14', N'Có mặt', 'NV0001'),
	('CNVHC0015', '2023-10-15', N'Có mặt', 'NV0001'),
	('CNVHC0016', '2023-10-16', N'Không phép', 'NV0001'),
	('CNVHC0017', '2023-10-17', N'Có mặt', 'NV0001'),
	('CNVHC0018', '2023-10-18', N'Có mặt', 'NV0001'),
	('CNVHC0019', '2023-10-19', N'Có mặt', 'NV0001'),
	('CNVHC0020', '2023-10-20', N'Có mặt', 'NV0001'),
	('CNVHC0021', '2023-10-21', N'Có mặt', 'NV0001'),
	('CNVHC0022', '2023-10-22', N'Có mặt', 'NV0001'),
	('CNVHC0023', '2023-10-23', N'Có mặt', 'NV0001'),
	('CNVHC0024', '2023-10-24', N'Có mặt', 'NV0001'),
	('CNVHC0025', '2023-10-25', N'Có mặt', 'NV0001'),
	('CNVHC0026', '2023-10-26', N'Có mặt', 'NV0001'),
	----
	('CNVHC0232', '2023-10-01', N'Có mặt', 'NV0002'),
    ('CNVHC0207', '2023-10-02', N'Có mặt', 'NV0002'),
    ('CNVHC0208', '2023-10-03', N'Có mặt', 'NV0002'),
    ('CNVHC0209', '2023-10-04', N'Có mặt', 'NV0002'),
    ('CNVHC0210', '2023-10-05', N'Có mặt', 'NV0002'),
    ('CNVHC0211', '2023-10-06', N'Có mặt', 'NV0002'),
    ('CNVHC0212', '2023-10-07', N'Có mặt', 'NV0002'),
    ('CNVHC0213', '2023-10-08', N'Có mặt', 'NV0002'),
    ('CNVHC0214', '2023-10-09', N'Có mặt', 'NV0002'),
    ('CNVHC0215', '2023-10-10', N'Có mặt', 'NV0002'),
    ('CNVHC0216', '2023-10-11', N'Có mặt', 'NV0002'),
    ('CNVHC0217', '2023-10-12', N'Có mặt', 'NV0002'),
    ('CNVHC0218', '2023-10-13', N'Có mặt', 'NV0002'),
    ('CNVHC0219', '2023-10-14', N'Có mặt', 'NV0002'),
    ('CNVHC0220', '2023-10-15', N'Có mặt', 'NV0002'),
    ('CNVHC0221', '2023-10-16', N'Có mặt', 'NV0002'),
    ('CNVHC0222', '2023-10-17', N'Có mặt', 'NV0002'),
    ('CNVHC0223', '2023-10-18', N'Có mặt', 'NV0002'),
    ('CNVHC0224', '2023-10-19', N'Có mặt', 'NV0002'),
    ('CNVHC0225', '2023-10-20', N'Có mặt', 'NV0002'),
    ('CNVHC0226', '2023-10-21', N'Có mặt', 'NV0002'),
    ('CNVHC0227', '2023-10-22', N'Có mặt', 'NV0002'),
    ('CNVHC0228', '2023-10-23', N'Có mặt', 'NV0002'),
    ('CNVHC0229', '2023-10-24', N'Có mặt', 'NV0002'),
    ('CNVHC0230', '2023-10-25', N'Có mặt', 'NV0002'),
    ('CNVHC0231', '2023-10-26', N'Có mặt', 'NV0002'),
	----
	  ('CNVHC0233', '2023-10-01', N'Có mặt', 'NV0003'),
    ('CNVHC0234', '2023-10-02', N'Có mặt', 'NV0003'),
    ('CNVHC0235', '2023-10-03', N'Có mặt', 'NV0003'),
    ('CNVHC0236', '2023-10-04', N'Có mặt', 'NV0003'),
    ('CNVHC0237', '2023-10-05', N'Có phép', 'NV0003'),
    ('CNVHC0238', '2023-10-06', N'Có phép', 'NV0003'),
    ('CNVHC0239', '2023-10-07', N'Có mặt', 'NV0003'),
    ('CNVHC0240', '2023-10-08', N'Có mặt', 'NV0003'),
    ('CNVHC0241', '2023-10-09', N'Có mặt', 'NV0003'),
    ('CNVHC0242', '2023-10-10', N'Có mặt', 'NV0003'),
    ('CNVHC0243', '2023-10-11', N'Có mặt', 'NV0003'),
    ('CNVHC0244', '2023-10-12', N'Có mặt', 'NV0003'),
    ('CNVHC0245', '2023-10-13', N'Có mặt', 'NV0003'),
    ('CNVHC0246', '2023-10-14', N'Có mặt', 'NV0003'),
    ('CNVHC0247', '2023-10-15', N'Có mặt', 'NV0003'),
    ('CNVHC0248', '2023-10-16', N'Có mặt', 'NV0003'),
    ('CNVHC0249', '2023-10-17', N'Có mặt', 'NV0003'),
    ('CNVHC0250', '2023-10-18', N'Có mặt', 'NV0003'),
    ('CNVHC0251', '2023-10-19', N'Có mặt', 'NV0003'),
    ('CNVHC0252', '2023-10-20', N'Có mặt', 'NV0003'),
    ('CNVHC0253', '2023-10-21', N'Có mặt', 'NV0003'),
    ('CNVHC0254', '2023-10-22', N'Có mặt', 'NV0003'),
    ('CNVHC0255', '2023-10-23', N'Có mặt', 'NV0003'),
    ('CNVHC0256', '2023-10-24', N'Có mặt', 'NV0003'),
    ('CNVHC0257', '2023-10-25', N'Có mặt', 'NV0003'),
    ('CNVHC0258', '2023-10-26', N'Có mặt', 'NV0003'),
	----
	 ('CNVHC0259', '2023-10-01', N'Có mặt', 'NV0004'),
    ('CNVHC0260', '2023-10-02', N'Có mặt', 'NV0004'),
    ('CNVHC0261', '2023-10-03', N'Có mặt', 'NV0004'),
    ('CNVHC0262', '2023-10-04', N'Có phép', 'NV0004'),
    ('CNVHC0263', '2023-10-05', N'Có phép', 'NV0004'),
    ('CNVHC0264', '2023-10-06', N'Có mặt', 'NV0004'),
    ('CNVHC0265', '2023-10-07', N'Có mặt', 'NV0004'),
    ('CNVHC0266', '2023-10-08', N'Có mặt', 'NV0004'),
    ('CNVHC0267', '2023-10-09', N'Có mặt', 'NV0004'),
    ('CNVHC0268', '2023-10-10', N'Có mặt', 'NV0004'),
    ('CNVHC0269', '2023-10-11', N'Có mặt', 'NV0004'),
    ('CNVHC0270', '2023-10-12', N'Có mặt', 'NV0004'),
    ('CNVHC0271', '2023-10-13', N'Có mặt', 'NV0004'),
    ('CNVHC0272', '2023-10-14', N'Có mặt', 'NV0004'),
    ('CNVHC0273', '2023-10-15', N'Có mặt', 'NV0004'),
    ('CNVHC0274', '2023-10-16', N'Có mặt', 'NV0004'),
    ('CNVHC0275', '2023-10-17', N'Có mặt', 'NV0004'),
    ('CNVHC0276', '2023-10-18', N'Có mặt', 'NV0004'),
    ('CNVHC0277', '2023-10-19', N'Có mặt', 'NV0004'),
    ('CNVHC0278', '2023-10-20', N'Có mặt', 'NV0004'),
    ('CNVHC0279', '2023-10-21', N'Có mặt', 'NV0004'),
    ('CNVHC0280', '2023-10-22', N'Có mặt', 'NV0004'),
    ('CNVHC0281', '2023-10-23', N'Có mặt', 'NV0004'),
    ('CNVHC0282', '2023-10-24', N'Có mặt', 'NV0004'),
    ('CNVHC0283', '2023-10-25', N'Có mặt', 'NV0004'),
    ('CNVHC0284', '2023-10-26', N'Có mặt', 'NV0004'),
	----
	 ('CNVHC0285', '2023-10-01', N'Có mặt', 'NV0005'),
    ('CNVHC0286', '2023-10-02', N'Có mặt', 'NV0005'),
    ('CNVHC0287', '2023-10-03', N'Có phép', 'NV0005'),
    ('CNVHC0288', '2023-10-04', N'Có phép', 'NV0005'),
    ('CNVHC0289', '2023-10-05', N'Có mặt', 'NV0005'),
    ('CNVHC0290', '2023-10-06', N'Có mặt', 'NV0005'),
    ('CNVHC0291', '2023-10-07', N'Có mặt', 'NV0005'),
    ('CNVHC0292', '2023-10-08', N'Có mặt', 'NV0005'),
    ('CNVHC0293', '2023-10-09', N'Có mặt', 'NV0005'),
    ('CNVHC0294', '2023-10-10', N'Có mặt', 'NV0005'),
    ('CNVHC0295', '2023-10-11', N'Có mặt', 'NV0005'),
    ('CNVHC0296', '2023-10-12', N'Có mặt', 'NV0005'),
    ('CNVHC0297', '2023-10-13', N'Có mặt', 'NV0005'),
    ('CNVHC0298', '2023-10-14', N'Có mặt', 'NV0005'),
    ('CNVHC0299', '2023-10-15', N'Có mặt', 'NV0005'),
    ('CNVHC0300', '2023-10-16', N'Có mặt', 'NV0005'),
    ('CNVHC0301', '2023-10-17', N'Có mặt', 'NV0005'),
    ('CNVHC0302', '2023-10-18', N'Có mặt', 'NV0005'),
    ('CNVHC0303', '2023-10-19', N'Có mặt', 'NV0005'),
    ('CNVHC0304', '2023-10-20', N'Có mặt', 'NV0005'),
    ('CNVHC0305', '2023-10-21', N'Có mặt', 'NV0005'),
    ('CNVHC0306', '2023-10-22', N'Có mặt', 'NV0005'),
    ('CNVHC0307', '2023-10-23', N'Có mặt', 'NV0005'),
    ('CNVHC0308', '2023-10-24', N'Có mặt', 'NV0005'),
    ('CNVHC0309', '2023-10-25', N'Có mặt', 'NV0005'),
    ('CNVHC0310', '2023-10-26', N'Có mặt', 'NV0005'),
	----
	('CNVHC0311', '2023-10-01', N'Có mặt', 'NV0006'),
    ('CNVHC0312', '2023-10-02', N'Có mặt', 'NV0006'),
    ('CNVHC0313', '2023-10-03', N'Có phép', 'NV0006'),
    ('CNVHC0314', '2023-10-04', N'Có mặt', 'NV0006'),
    ('CNVHC0315', '2023-10-05', N'Không phép', 'NV0006'),
    ('CNVHC0316', '2023-10-06', N'Có mặt', 'NV0006'),
    ('CNVHC0317', '2023-10-07', N'Có mặt', 'NV0006'),
    ('CNVHC0318', '2023-10-08', N'Có mặt', 'NV0006'),
    ('CNVHC0319', '2023-10-09', N'Có phép', 'NV0006'),
    ('CNVHC0320', '2023-10-10', N'Có mặt', 'NV0006'),
    ('CNVHC0321', '2023-10-11', N'Không phép', 'NV0006'),
    ('CNVHC0322', '2023-10-12', N'Có mặt', 'NV0006'),
    ('CNVHC0323', '2023-10-13', N'Có mặt', 'NV0006'),
    ('CNVHC0324', '2023-10-14', N'Có mặt', 'NV0006'),
    ('CNVHC0325', '2023-10-15', N'Có phép', 'NV0006'),
    ('CNVHC0326', '2023-10-16', N'Có mặt', 'NV0006'),
    ('CNVHC0327', '2023-10-17', N'Có mặt', 'NV0006'),
    ('CNVHC0328', '2023-10-18', N'Có mặt', 'NV0006'),
    ('CNVHC0329', '2023-10-19', N'Không phép', 'NV0006'),
    ('CNVHC0330', '2023-10-20', N'Có mặt', 'NV0006'),
    ('CNVHC0331', '2023-10-21', N'Có mặt', 'NV0006'),
    ('CNVHC0332', '2023-10-22', N'Có phép', 'NV0006'),
    ('CNVHC0333', '2023-10-23', N'Có mặt', 'NV0006'),
    ('CNVHC0334', '2023-10-24', N'Có mặt', 'NV0006'),
    ('CNVHC0335', '2023-10-25', N'Có mặt', 'NV0006'),
    ('CNVHC0336', '2023-10-26', N'Không phép', 'NV0006'),
	----
	('CNVHC0337', '2023-10-01', N'Có mặt', 'NV0007'),
    ('CNVHC0338', '2023-10-02', N'Có mặt', 'NV0007'),
    ('CNVHC0339', '2023-10-03', N'Có phép', 'NV0007'),
    ('CNVHC0340', '2023-10-04', N'Có mặt', 'NV0007'),
    ('CNVHC0341', '2023-10-05', N'Không phép', 'NV0007'),
    ('CNVHC0342', '2023-10-06', N'Có mặt', 'NV0007'),
    ('CNVHC0343', '2023-10-07', N'Có mặt', 'NV0007'),
    ('CNVHC0344', '2023-10-08', N'Có mặt', 'NV0007'),
    ('CNVHC0345', '2023-10-09', N'Có phép', 'NV0007'),
    ('CNVHC0346', '2023-10-10', N'Có mặt', 'NV0007'),
    ('CNVHC0347', '2023-10-11', N'Không phép', 'NV0007'),
    ('CNVHC0348', '2023-10-12', N'Có mặt', 'NV0007'),
    ('CNVHC0349', '2023-10-13', N'Có mặt', 'NV0007'),
    ('CNVHC0350', '2023-10-14', N'Có mặt', 'NV0007'),
    ('CNVHC0351', '2023-10-15', N'Có phép', 'NV0007'),
    ('CNVHC0352', '2023-10-16', N'Có mặt', 'NV0007'),
    ('CNVHC0353', '2023-10-17', N'Có mặt', 'NV0007'),
    ('CNVHC0354', '2023-10-18', N'Có mặt', 'NV0007'),
    ('CNVHC0355', '2023-10-19', N'Không phép', 'NV0007'),
    ('CNVHC0356', '2023-10-20', N'Có mặt', 'NV0007'),
    ('CNVHC0357', '2023-10-21', N'Có mặt', 'NV0007'),
    ('CNVHC0358', '2023-10-22', N'Có phép', 'NV0007'),
    ('CNVHC0359', '2023-10-23', N'Có mặt', 'NV0007'),
    ('CNVHC0360', '2023-10-24', N'Có mặt', 'NV0007'),
    ('CNVHC0361', '2023-10-25', N'Có mặt', 'NV0007'),
    ('CNVHC0362', '2023-10-26', N'Không phép', 'NV0007'),
	----
	 ('CNVHC0438', '2023-10-01', N'Có mặt', 'NV0008'),
    ('CNVHC0363', '2023-10-02', N'Có mặt', 'NV0008'),
    ('CNVHC0364', '2023-10-03', N'Có phép', 'NV0008'),
    ('CNVHC0365', '2023-10-04', N'Có mặt', 'NV0008'),
    ('CNVHC0366', '2023-10-05', N'Không phép', 'NV0008'),
    ('CNVHC0367', '2023-10-06', N'Có mặt', 'NV0008'),
    ('CNVHC0368', '2023-10-07', N'Có mặt', 'NV0008'),
    ('CNVHC0369', '2023-10-08', N'Có mặt', 'NV0008'),
    ('CNVHC0370', '2023-10-09', N'Có phép', 'NV0008'),
    ('CNVHC0371', '2023-10-10', N'Có mặt', 'NV0008'),
    ('CNVHC0372', '2023-10-11', N'Không phép', 'NV0008'),
    ('CNVHC0373', '2023-10-12', N'Có mặt', 'NV0008'),
    ('CNVHC0374', '2023-10-13', N'Có mặt', 'NV0008'),
    ('CNVHC0375', '2023-10-14', N'Có mặt', 'NV0008'),
    ('CNVHC0376', '2023-10-15', N'Có phép', 'NV0008'),
    ('CNVHC0377', '2023-10-16', N'Có mặt', 'NV0008'),
    ('CNVHC0378', '2023-10-17', N'Có mặt', 'NV0008'),
    ('CNVHC0379', '2023-10-18', N'Có mặt', 'NV0008'),
    ('CNVHC0380', '2023-10-19', N'Không phép', 'NV0008'),
    ('CNVHC0381', '2023-10-20', N'Có mặt', 'NV0008'),
    ('CNVHC0382', '2023-10-21', N'Có mặt', 'NV0008'),
    ('CNVHC0383', '2023-10-22', N'Có phép', 'NV0008'),
    ('CNVHC0384', '2023-10-23', N'Có mặt', 'NV0008'),
    ('CNVHC0385', '2023-10-24', N'Có mặt', 'NV0008'),
    ('CNVHC0386', '2023-10-25', N'Có mặt', 'NV0008'),
    ('CNVHC0387', '2023-10-26', N'Không phép', 'NV0008'),
	----
	 ('CNVHC0032', '2023-11-01', N'Có mặt', 'NV0001'),
    ('CNVHC0033', '2023-11-02', N'Có phép', 'NV0001'),
    ('CNVHC0034', '2023-11-03', N'Có phép', 'NV0001'),
    ('CNVHC0035', '2023-11-04', N'Có mặt', 'NV0001'),
    ('CNVHC0036', '2023-11-05', N'Có mặt', 'NV0001'),
    ('CNVHC0037', '2023-11-06', N'Có mặt', 'NV0001'),
    ('CNVHC0038', '2023-11-07', N'Có mặt', 'NV0001'),
    ('CNVHC0039', '2023-11-08', N'Có mặt', 'NV0001'),
    ('CNVHC0040', '2023-11-09', N'Có mặt', 'NV0001'),
    ('CNVHC0041', '2023-11-10', N'Có mặt', 'NV0001'),
    ('CNVHC0043', '2023-11-12', N'Có phép', 'NV0001'),
    ('CNVHC0045', '2023-11-14', N'Không phép', 'NV0001'),
    ('CNVHC0046', '2023-11-15', N'Không phép', 'NV0001'),
    ('CNVHC0047', '2023-11-16', N'Không phép', 'NV0001'),
    ('CNVHC0048', '2023-11-17', N'Có mặt', 'NV0001'),
    ('CNVHC0049', '2023-11-18', N'Có mặt', 'NV0001'),
    ('CNVHC0050', '2023-11-19', N'Có mặt', 'NV0001'),
    ('CNVHC0052', '2023-11-21', N'Có mặt', 'NV0001'),
    ('CNVHC0053', '2023-11-22', N'Có mặt', 'NV0001'),
    ('CNVHC0054', '2023-11-23', N'Có mặt', 'NV0001'),
    ('CNVHC0056', '2023-11-25', N'Có mặt', 'NV0001'),
	---
	('CNVHC0062', '2023-11-01', N'Có mặt', 'NV0002'),
    ('CNVHC0063', '2023-11-02', N'Có mặt', 'NV0002'),
    ('CNVHC0064', '2023-11-03', N'Có mặt', 'NV0002'),
    ('CNVHC0065', '2023-11-04', N'Có mặt', 'NV0002'),
    ('CNVHC0066', '2023-11-05', N'Có mặt', 'NV0002'),
    ('CNVHC0068', '2023-11-07', N'Có mặt', 'NV0002'),
    ('CNVHC0069', '2023-11-08', N'Có mặt', 'NV0002'),
    ('CNVHC0071', '2023-11-10', N'Có mặt', 'NV0002'),
    ('CNVHC0072', '2023-11-11', N'Có phép', 'NV0002'),
    ('CNVHC0073', '2023-11-12', N'Có phép', 'NV0002'),
    ('CNVHC0074', '2023-11-13', N'Có mặt', 'NV0002'),
    ('CNVHC0075', '2023-11-14', N'Có mặt', 'NV0002'),
    ('CNVHC0076', '2023-11-15', N'Có mặt', 'NV0002'),
    ('CNVHC0077', '2023-11-16', N'Không phép', 'NV0002'),
    ('CNVHC0078', '2023-11-17', N'Có mặt', 'NV0002'),
    ('CNVHC0079', '2023-11-18', N'Có mặt', 'NV0002'),
    ('CNVHC0080', '2023-11-19', N'Có mặt', 'NV0002'),
    ('CNVHC0081', '2023-11-20', N'Có mặt', 'NV0002'),
    ('CNVHC0082', '2023-11-21', N'Có mặt', 'NV0002'),
    ('CNVHC0083', '2023-11-22', N'Có mặt', 'NV0002'),
    ('CNVHC0084', '2023-11-23', N'Có mặt', 'NV0002'),
    ('CNVHC0085', '2023-11-24', N'Có mặt', 'NV0002'),
    ('CNVHC0086', '2023-11-25', N'Có mặt', 'NV0002'),
	----
	('CNVHC0092', '2023-11-01', N'Có mặt', 'NV0003'),
    ('CNVHC0093', '2023-11-02', N'Có phép', 'NV0003'),
    ('CNVHC0094', '2023-11-03', N'Có phép', 'NV0003'),
    ('CNVHC0095', '2023-11-04', N'Có mặt', 'NV0003'),
    ('CNVHC0096', '2023-11-05', N'Có mặt', 'NV0003'),
    ('CNVHC0097', '2023-11-06', N'Có mặt', 'NV0003'),
    ('CNVHC0098', '2023-11-07', N'Có mặt', 'NV0003'),
    ('CNVHC0099', '2023-11-08', N'Có mặt', 'NV0003'),
    ('CNVHC0100', '2023-11-09', N'Có mặt', 'NV0003'),
    ('CNVHC0101', '2023-11-10', N'Có mặt', 'NV0003'),
    ('CNVHC0102', '2023-11-11', N'Có phép', 'NV0003'),
    ('CNVHC0103', '2023-11-12', N'Có phép', 'NV0003'),
    ('CNVHC0104', '2023-11-13', N'Có mặt', 'NV0003'),
    ('CNVHC0105', '2023-11-14', N'Có mặt', 'NV0003'),
    ('CNVHC0106', '2023-11-15', N'Không phép', 'NV0003'),
    ('CNVHC0107', '2023-11-16', N'Không phép', 'NV0003'),
    ('CNVHC0108', '2023-11-17', N'Có mặt', 'NV0003'),
    ('CNVHC0109', '2023-11-18', N'Có mặt', 'NV0003'),
    ('CNVHC0110', '2023-11-19', N'Có mặt', 'NV0003'),
    ('CNVHC0111', '2023-11-20', N'Có mặt', 'NV0003'),
    ('CNVHC0112', '2023-11-21', N'Có mặt', 'NV0003'),
    ('CNVHC0113', '2023-11-22', N'Có mặt', 'NV0003'),
    ('CNVHC0114', '2023-11-23', N'Có mặt', 'NV0003'),
    ('CNVHC0115', '2023-11-24', N'Có mặt', 'NV0003'),
    ('CNVHC0116', '2023-11-25', N'Có mặt', 'NV0003'),
	----
	('CNVHC0122', '2023-11-01', N'Có mặt', 'NV0004'),
    ('CNVHC0123', '2023-11-02', N'Có phép', 'NV0004'),
    ('CNVHC0124', '2023-11-03', N'Có phép', 'NV0004'),
    ('CNVHC0125', '2023-11-04', N'Có mặt', 'NV0004'),
    ('CNVHC0126', '2023-11-05', N'Có mặt', 'NV0004'),
    ('CNVHC0127', '2023-11-06', N'Có mặt', 'NV0004'),
    ('CNVHC0128', '2023-11-07', N'Có mặt', 'NV0004'),
    ('CNVHC0129', '2023-11-08', N'Có mặt', 'NV0004'),
    ('CNVHC0130', '2023-11-09', N'Có mặt', 'NV0004'),
    ('CNVHC0131', '2023-11-10', N'Có mặt', 'NV0004'),
    ('CNVHC0132', '2023-11-11', N'Có phép', 'NV0004'),
    ('CNVHC0133', '2023-11-12', N'Có phép', 'NV0004'),
    ('CNVHC0134', '2023-11-13', N'Có mặt', 'NV0004'),
    ('CNVHC0135', '2023-11-14', N'Có mặt', 'NV0004'),
    ('CNVHC0136', '2023-11-15', N'Không phép', 'NV0004'),
    ('CNVHC0137', '2023-11-16', N'Không phép', 'NV0004'),
    ('CNVHC0138', '2023-11-17', N'Có mặt', 'NV0004'),
    ('CNVHC0139', '2023-11-18', N'Có mặt', 'NV0004'),
    ('CNVHC0140', '2023-11-19', N'Có mặt', 'NV0004'),
    ('CNVHC0141', '2023-11-20', N'Có mặt', 'NV0004'),
    ('CNVHC0142', '2023-11-21', N'Có mặt', 'NV0004'),
    ('CNVHC0143', '2023-11-22', N'Có mặt', 'NV0004'),
    ('CNVHC0144', '2023-11-23', N'Có mặt', 'NV0004'),
    ('CNVHC0145', '2023-11-24', N'Có mặt', 'NV0004'),
    ('CNVHC0146', '2023-11-25', N'Có mặt', 'NV0004'),
	----
	 ('CNVHC0152', '2023-11-01', N'Có mặt', 'NV0005'),
    ('CNVHC0153', '2023-11-02', N'Có mặt', 'NV0005'),
    ('CNVHC0154', '2023-11-03', N'Có phép', 'NV0005'),
    ('CNVHC0155', '2023-11-04', N'Có mặt', 'NV0005'),
    ('CNVHC0156', '2023-11-05', N'Có mặt', 'NV0005'),
    ('CNVHC0157', '2023-11-06', N'Có mặt', 'NV0005'),
    ('CNVHC0158', '2023-11-07', N'Có mặt', 'NV0005'),
    ('CNVHC0159', '2023-11-08', N'Có mặt', 'NV0005'),
    ('CNVHC0160', '2023-11-09', N'Có phép', 'NV0005'),
    ('CNVHC0161', '2023-11-10', N'Có mặt', 'NV0005'),
    ('CNVHC0162', '2023-11-11', N'Có mặt', 'NV0005'),
    ('CNVHC0163', '2023-11-12', N'Có mặt', 'NV0005'),
    ('CNVHC0164', '2023-11-13', N'Có mặt', 'NV0005'),
    ('CNVHC0165', '2023-11-14', N'Có mặt', 'NV0005'),
    ('CNVHC0166', '2023-11-15', N'Có phép', 'NV0005'),
    ('CNVHC0167', '2023-11-16', N'Có mặt', 'NV0005'),
    ('CNVHC0168', '2023-11-17', N'Có mặt', 'NV0005'),
    ('CNVHC0169', '2023-11-18', N'Có mặt', 'NV0005'),
    ('CNVHC0170', '2023-11-19', N'Có mặt', 'NV0005'),
    ('CNVHC0171', '2023-11-20', N'Có mặt', 'NV0005'),
    ('CNVHC0172', '2023-11-21', N'Có mặt', 'NV0005'),
    ('CNVHC0173', '2023-11-22', N'Có mặt', 'NV0005'),
    ('CNVHC0174', '2023-11-23', N'Có phép', 'NV0005'),
    ('CNVHC0175', '2023-11-24', N'Có mặt', 'NV0005'),
    ('CNVHC0176', '2023-11-25', N'Có mặt', 'NV0005'),
	----
	 ('CNVHC0177', '2023-11-01', N'Có mặt', 'NV0006'),
    ('CNVHC0178', '2023-11-02', N'Có mặt', 'NV0006'),
    ('CNVHC0179', '2023-11-03', N'Có mặt', 'NV0006'),
    ('CNVHC0180', '2023-11-04', N'Có mặt', 'NV0006'),
    ('CNVHC0181', '2023-11-05', N'Có mặt', 'NV0006'),
    ('CNVHC0182', '2023-11-06', N'Có mặt', 'NV0006'),
    ('CNVHC0183', '2023-11-07', N'Có mặt', 'NV0006'),
    ('CNVHC0184', '2023-11-08', N'Có mặt', 'NV0006'),
    ('CNVHC0185', '2023-11-09', N'Có mặt', 'NV0006'),
    ('CNVHC0186', '2023-11-10', N'Có mặt', 'NV0006'),
    ('CNVHC0187', '2023-11-11', N'Có mặt', 'NV0006'),
    ('CNVHC0188', '2023-11-12', N'Có mặt', 'NV0006'),
    ('CNVHC0189', '2023-11-13', N'Có mặt', 'NV0006'),
    ('CNVHC0190', '2023-11-14', N'Có mặt', 'NV0006'),
    ('CNVHC0191', '2023-11-15', N'Có mặt', 'NV0006'),
    ('CNVHC0192', '2023-11-16', N'Có mặt', 'NV0006'),
    ('CNVHC0193', '2023-11-17', N'Có mặt', 'NV0006'),
    ('CNVHC0194', '2023-11-18', N'Có mặt', 'NV0006'),
    ('CNVHC0195', '2023-11-19', N'Có mặt', 'NV0006'),
    ('CNVHC0196', '2023-11-20', N'Có mặt', 'NV0006'),
    ('CNVHC0197', '2023-11-21', N'Có mặt', 'NV0006'),
    ('CNVHC0198', '2023-11-22', N'Có mặt', 'NV0006'),
    ('CNVHC0199', '2023-11-23', N'Có mặt', 'NV0006'),
    ('CNVHC0200', '2023-11-24', N'Có mặt', 'NV0006'),
    ('CNVHC0201', '2023-11-25', N'Có mặt', 'NV0006'),
	
	----
	 ('CNVHC0388', '2023-11-01', N'Có mặt', 'NV0007'),
    ('CNVHC0389', '2023-11-02', N'Có mặt', 'NV0007'),
    ('CNVHC0390', '2023-11-03', N'Có phép', 'NV0007'),
    ('CNVHC0391', '2023-11-04', N'Có mặt', 'NV0007'),
    ('CNVHC0392', '2023-11-05', N'Không phép', 'NV0007'),
    ('CNVHC0393', '2023-11-06', N'Có mặt', 'NV0007'),
    ('CNVHC0394', '2023-11-07', N'Có mặt', 'NV0007'),
    ('CNVHC0395', '2023-11-08', N'Có mặt', 'NV0007'),
    ('CNVHC0396', '2023-11-09', N'Có phép', 'NV0007'),
    ('CNVHC0397', '2023-11-10', N'Có mặt', 'NV0007'),
    ('CNVHC0398', '2023-11-11', N'Không phép', 'NV0007'),
    ('CNVHC0399', '2023-11-12', N'Có mặt', 'NV0007'),
    ('CNVHC0400', '2023-11-13', N'Có mặt', 'NV0007'),
    ('CNVHC0401', '2023-11-14', N'Có mặt', 'NV0007'),
    ('CNVHC0402', '2023-11-15', N'Có phép', 'NV0007'),
    ('CNVHC0403', '2023-11-16', N'Có mặt', 'NV0007'),
    ('CNVHC0404', '2023-11-17', N'Có mặt', 'NV0007'),
    ('CNVHC0405', '2023-11-18', N'Có mặt', 'NV0007'),
    ('CNVHC0406', '2023-11-19', N'Không phép', 'NV0007'),
    ('CNVHC0407', '2023-11-20', N'Có mặt', 'NV0007'),
    ('CNVHC0408', '2023-11-21', N'Có mặt', 'NV0007'),
    ('CNVHC0409', '2023-11-22', N'Có phép', 'NV0007'),
    ('CNVHC0410', '2023-11-23', N'Có mặt', 'NV0007'),
    ('CNVHC0411', '2023-11-24', N'Có mặt', 'NV0007'),
    ('CNVHC0412', '2023-11-25', N'Có mặt', 'NV0007'),
	---
	 ('CNVHC0413', '2023-11-01', N'Có mặt', 'NV0008'),
    ('CNVHC0414', '2023-11-02', N'Có mặt', 'NV0008'),
    ('CNVHC0415', '2023-11-03', N'Có phép', 'NV0008'),
    ('CNVHC0416', '2023-11-04', N'Có mặt', 'NV0008'),
    ('CNVHC0417', '2023-11-05', N'Không phép', 'NV0008'),
    ('CNVHC0418', '2023-11-06', N'Có mặt', 'NV0008'),
    ('CNVHC0419', '2023-11-07', N'Có mặt', 'NV0008'),
    ('CNVHC0420', '2023-11-08', N'Có mặt', 'NV0008'),
    ('CNVHC0421', '2023-11-09', N'Có phép', 'NV0008'),
    ('CNVHC0422', '2023-11-10', N'Có mặt', 'NV0008'),
    ('CNVHC0423', '2023-11-11', N'Không phép', 'NV0008'),
    ('CNVHC0424', '2023-11-12', N'Có mặt', 'NV0008'),
    ('CNVHC0425', '2023-11-13', N'Có mặt', 'NV0008'),
    ('CNVHC0426', '2023-11-14', N'Có mặt', 'NV0008'),
    ('CNVHC0427', '2023-11-15', N'Có phép', 'NV0008'),
    ('CNVHC0428', '2023-11-16', N'Có mặt', 'NV0008'),
    ('CNVHC0429', '2023-11-17', N'Có mặt', 'NV0008'),
    ('CNVHC0430', '2023-11-18', N'Có mặt', 'NV0008'),
    ('CNVHC0431', '2023-11-19', N'Không phép', 'NV0008'),
    ('CNVHC0432', '2023-11-20', N'Có mặt', 'NV0008'),
    ('CNVHC0433', '2023-11-21', N'Có mặt', 'NV0008'),
    ('CNVHC0434', '2023-11-22', N'Có phép', 'NV0008'),
    ('CNVHC0435', '2023-11-23', N'Có mặt', 'NV0008'),
    ('CNVHC0436', '2023-11-24', N'Có mặt', 'NV0008'),
    ('CNVHC0437', '2023-11-25', N'Có mặt', 'NV0008')
go
INSERT INTO BangLuongNhanVien (idLuongNVHC, ngayTinhLuong, idNhanVien, thueLaoDong, tienBaoHiemXaHoi, tongLuong, thucLanh, thang, nam)
VALUES
    ('LNV0001', '2023-12-05', 'NV0001', 0, 560000, 7161538.4615, 6601538.4615, 11, 2023),
    ('LNV0002', '2023-12-05', 'NV0002', 0, 560000, 9315384.6154, 8755384.6154, 11, 2023),
    ('LNV0003', '2023-12-05', 'NV0003', 1327692.3077, 840000, 13276923.0769, 11109230.7692, 11, 2023),
    ('LNV0004', '2023-12-05', 'NV0004', 1327692.3077, 840000, 13276923.0769, 11109230.7692, 11, 2023),
    ('LNV0005', '2023-12-05', 'NV0005', 0, 400000, 6961538.4615, 6561538.4615, 11, 2023),
    ('LNV0006', '2023-12-05', 'NV0006', 0, 400000, 8192307.6923, 7792307.6923, 11, 2023),
    ('LNV0007', '2023-12-05', 'NV0007', 0, 400000, 6038461.5385, 5638461.5385, 11, 2023),
    ('LNV0008', '2023-12-05', 'NV0008', 0, 400000, 6038461.5385, 5638461.5385, 11, 2023),
    ('LNV0009', '2023-11-05', 'NV0001', 551923.0769, 560000, 11038461.5385, 9926538.4616, 10, 2023),
    ('LNV0010', '2023-11-05', 'NV0002', 595000, 560000, 11900000, 10745000, 10, 2023),
    ('LNV0011', '2023-11-05', 'NV0003', 1650769.2308, 840000, 16507692.3077, 14016923.0769, 10, 2023),
    ('LNV0012', '2023-11-05', 'NV0004', 1650769.2308, 840000, 16507692.3077, 14016923.0769, 10, 2023),
    ('LNV0013', '2023-11-05', 'NV0005', 0, 400000, 7884615.3846, 7484615.3846, 10, 2023),
    ('LNV0014', '2023-11-05', 'NV0006', 0, 400000, 6038461.5385, 5638461.5385, 10, 2023),
    ('LNV0015', '2023-11-05', 'NV0007', 0, 400000, 6038461.5385, 5638461.5385, 10, 2023),
    ('LNV0016', '2023-11-05', 'NV0008', 0, 400000, 6038461.5385, 5638461.5385, 10, 2023);
go
INSERT INTO bangluongcongnhan (idLuongCn, ngayTinhLuong, idCongNhan, tongLuong, thuclanh, thang, nam)
VALUES
    ('LCN0001', '2023-12-05', 'CN0001', 4170000, 4870000, 11, 2023),
    ('LCN0002', '2023-12-05', 'CN0002', 3588000, 4288000, 11, 2023),
    ('LCN0003', '2023-12-05', 'CN0003', 3513000, 4213000, 11, 2023),
    ('LCN0004', '2023-12-05', 'CN0004', 3078000,3778000, 11, 2023),
    ('LCN0005', '2023-12-05', 'CN0005', 2400000,3100000, 11, 2023),
    ('LCN0006', '2023-12-05', 'CN0006', 2376000, 3076000.0000, 11, 2023),
    ('LCN0007', '2023-12-05', 'CN0007', 2718000.0000, 3418000.0000,11, 2023),
    ('LCN0008', '2023-11-05', 'CN0008', 3402000.0000, 4102000.0000, 11, 2023),
    ('LCN0009', '2023-11-05', 'CN0001', 8962250.0000, 9662250.0000, 10, 2023),
    ('LCN0010', '2023-11-05', 'CN0002', 8001000.0000, 8701000.0000, 10, 2023),
    ('LCN0011', '2023-11-05', 'CN0003', 8280000.0000, 8980000.0000, 10, 2023),
    ('LCN0012', '2023-11-05', 'CN0004', 7725500.0000, 8425500.0000, 10, 2023),
    ('LCN0013', '2023-11-05', 'CN0005', 6133750.0000, 6833750.0000, 10, 2023),
	('LCN0014', '2023-11-05', 'CN0006', 7654500.0000, 8354500.0000, 10, 2023),
	('LCN0015', '2023-11-05', 'CN0007', 8266000.0000, 8966000.0000, 10, 2023),
	('LCN0016', '2023-11-05', 'CN0008', 6868000.0000,7568000.0000, 10, 2023);


go
CREATE PROCEDURE TinhLuongNhanVien_proc (
    @idNhanVien varchar(10),
    @thang int,
    @nam int,
	@thue money output,
	@bhxh money output,
	@thuclanh money output,
    @tongTienLuong money OUTPUT
)
AS
BEGIN
    DECLARE @luongCoBan money
    DECLARE @heSoLuong float
    DECLARE @soNgayLamThucTe int
    DECLARE @soNgayLamQuyDinh int
    DECLARE @phuCap float
    DECLARE @heSoChucVu float
    DECLARE @heSoBaoHiemXaHoi float
    DECLARE @soNgayNghiKhongPhep int
    DECLARE @tienBaoHiemXaHoi money
    DECLARE @thueLaoDong money
	declare @idChucVu varchar(10)

    -- Lấy thông tin lương cơ bản của nhân viên
    SELECT @luongCoBan = luongCoBan, @heSoChucVu = heSoLuong, @heSoBaoHiemXaHoi = heSoBaoHiemXaHoi,@idChucVu = n.idChucVu
    FROM NhanVien n  join ChucVu c on n.idChucVu=c.idChucVu
    WHERE idNhanVien = @idNhanVien

    -- Lấy thông tin số ngày làm thực tế của nhân viên trong tháng
    SELECT @soNgayLamThucTe = COUNT(*)
    FROM BangChamCongNhanVienHC
    WHERE idNhanVien = @idNhanVien AND MONTH(ngayChamCong) = @thang and YEAR(ngayChamCong) = @nam and trangThai = N'Có mặt'

    -- Tính số ngày làm quy định trong tháng
    SET @soNgayLamQuyDinh = DAY(EOMONTH( CAST(2021 AS NVARCHAR(50))+'-'+ CAST(12 AS NVARCHAR(50))+'-1')) - 5

    -- Lấy thông tin phụ cấp của nhân viên
    SELECT @phuCap = phuCap
    FROM NhanVien
    WHERE idNhanVien = @idNhanVien

    -- Lấy thông tin số ngày nghỉ không phép trong tháng
    SELECT @soNgayNghiKhongPhep = COUNT(*)
    FROM BangChamCongNhanVienHC
    WHERE idNhanVien = @idNhanVien  AND MONTH(ngayChamCong) = @thang and YEAR(ngayChamCong) = @nam and trangThai = N'Không phép'

    -- Tính tiền bảo hiểm xã hội
    SET @tienBaoHiemXaHoi = @luongCoBan * @heSoChucVu * @heSoBaoHiemXaHoi

	declare @tongLuong money 
	set @tongLuong = @luongCoBan * @heSoChucVu * @soNgayLamThucTe / @soNgayLamQuyDinh + @phuCap
    -- Tính thuế lao động
    SET @thueLaoDong = CASE
        WHEN (@tongLuong <= 11000000) THEN 0
        WHEN (@tongLuong > 11000000) AND (@idChucVu IN ('CV001', 'CV002')) THEN 0.05 * @tongLuong
        WHEN (@tongLuong > 11000000) AND (@idChucVu IN ('CV003', 'CV004')) THEN 0.1 * @tongLuong
    END

    -- Tính tiền lương
    SET @thuclanh = @tongLuong - @tienBaoHiemXaHoi - @thueLaoDong - (@soNgayNghiKhongPhep * 150000)
	set @thue = @thueLaoDong
	set @bhxh = @tienBaoHiemXaHoi
	set @tongTienLuong = @tongLuong
END

go
create PROCEDURE chiTietLuongNhanVien_proc (
    @idNhanVien varchar(10),
    @thang int,
    @nam int,
    @soNgayCongTrongThang int OUTPUT,
    @soNgayDiLamThucTe int OUTPUT,
    @soNgayNghiCoPhep int OUTPUT,
    @soNgayNghiKhongPhep int OUTPUT,
    @soTienNghiKhongPhep int OUTPUT
)
AS
BEGIN
    -- Lấy thông tin số ngày làm thực tế của nhân viên trong tháng
    SELECT @soNgayDiLamThucTe = COUNT(*)
    FROM BangChamCongNhanVienHC
    WHERE idNhanVien = @idNhanVien AND MONTH(ngayChamCong) = @thang and YEAR(ngayChamCong) = @nam and trangThai = N'Có mặt'

    -- Tính số ngày làm quy định trong tháng
    SET @soNgayCongTrongThang = DAY(EOMONTH( CAST(2021 AS NVARCHAR(50))+'-'+ CAST(12 AS NVARCHAR(50))+'-1')) - 5

    -- Lấy thông tin số ngày nghỉ không phép trong tháng
    SELECT @soNgayNghiKhongPhep = COUNT(*)
    FROM BangChamCongNhanVienHC
    WHERE idNhanVien = @idNhanVien  AND MONTH(ngayChamCong) = @thang and YEAR(ngayChamCong) = @nam and trangThai = N'Không phép'

    -- Số Tiền Nghỉ Làm Không Phép
    SET @soTienNghiKhongPhep = @soNgayNghiKhongPhep * 150000

    -- Số Ngày Nghỉ Có Phép
    SELECT @soNgayNghiCoPhep = COUNT(*)
    FROM BangChamCongNhanVienHC
    WHERE idNhanVien = @idNhanVien  AND MONTH(ngayChamCong) = @thang and YEAR(ngayChamCong) = @nam and trangThai = N'Có phép'
END
go
create PROCEDURE ThongTinLuongCongNhan
    @Thang INT,
    @Nam INT,
    @idCongNhan NVARCHAR(10),
    @thucLanh MONEY OUTPUT,
    @tongLuong MONEY OUTPUT

AS
BEGIN
    DECLARE @phuCap MONEY;
	Declare @luongHanhChanh money
	DECLARE @LuongTangCa MONEY
    SELECT @phuCap = CN.phuCap
    FROM CongNhan CN
    WHERE CN.idCongNhan = @idCongNhan;

    SELECT
        @luongHanhChanh = SUM(CASE WHEN CL.idCaLam IN (1, 2) THEN BC.soLuongHoanThanh * CDSP.luongCongDoan * CL.heSoLuong * BC.heSoNgayLam ELSE 0 END),
        @LuongTangCa = SUM(CASE WHEN CL.idCaLam = 3 THEN BC.soLuongHoanThanh * CDSP.luongCongDoan * CL.heSoLuong * BC.heSoNgayLam ELSE 0 END)
    FROM
        CongNhan CN
    JOIN PhanXuong PX ON CN.idPhanXuong = PX.idPhanXuong
    JOIN CongDoanPhanCong PC ON CN.idCongNhan = PC.idCongNhan
    JOIN BangChamCongCongNhan BC ON PC.idPhanCong = BC.idPhanCong
    JOIN CongDoanSP CDSP ON PC.idCongDoan = CDSP.idCongDoan
    JOIN CaLam CL ON PC.idCaLam = CL.idCaLam
    WHERE
        MONTH(BC.ngayChamCong) = @Thang
        AND YEAR(BC.ngayChamCong) = @Nam
        AND CN.idCongNhan = @idCongNhan;

    SET @thucLanh = @luongHanhChanh + @LuongTangCa + @phuCap;
	set @tongLuong = @LuongTangCa+@luongHanhChanh
END;
go
go
create PROCEDURE TinhTongSanLuongVaThoiGianLamViec
    @Thang INT,
    @Nam INT,
    @idCongNhan NVARCHAR(10),
	@TongSanLuong INT output,
    @TongThoiGianLamViec FLOAT output,
	@luongHanhChanh money output,
	@luongTangCa money output
AS
BEGIN
    -- Tính tổng sản lượng hoàn thành
    SELECT @TongSanLuong = SUM(BC.soLuongHoanThanh)
    FROM BangChamCongCongNhan BC
    JOIN CongDoanPhanCong PC ON BC.idPhanCong = PC.idPhanCong
	join CongNhan CN ON CN.idCongNhan = PC.idCongNhan
    JOIN PhanXuong PX ON CN.idPhanXuong = PX.idPhanXuong
    WHERE MONTH(BC.ngayChamCong) = @Thang AND YEAR(BC.ngayChamCong) = @Nam AND Cn.idCongNhan=@idCongNhan;
	SELECT
        @luongHanhChanh = SUM(CASE WHEN CL.idCaLam IN (1, 2) THEN BC.soLuongHoanThanh * CDSP.luongCongDoan * CL.heSoLuong * BC.heSoNgayLam ELSE 0 END),
        @LuongTangCa = SUM(CASE WHEN CL.idCaLam = 3 THEN BC.soLuongHoanThanh * CDSP.luongCongDoan * CL.heSoLuong * BC.heSoNgayLam ELSE 0 END)
    FROM
        CongNhan CN
    JOIN PhanXuong PX ON CN.idPhanXuong = PX.idPhanXuong
    JOIN CongDoanPhanCong PC ON CN.idCongNhan = PC.idCongNhan
    JOIN BangChamCongCongNhan BC ON PC.idPhanCong = BC.idPhanCong
    JOIN CongDoanSP CDSP ON PC.idCongDoan = CDSP.idCongDoan
    JOIN CaLam CL ON PC.idCaLam = CL.idCaLam
    WHERE
        MONTH(BC.ngayChamCong) = @Thang
        AND YEAR(BC.ngayChamCong) = @Nam
        AND CN.idCongNhan = @idCongNhan;
    -- Tính tổng thời gian làm việc
    SELECT @TongThoiGianLamViec = SUM(4)
    FROM BangChamCongCongNhan BC
    JOIN CongDoanPhanCong PC ON BC.idPhanCong = PC.idPhanCong
	join CongNhan CN ON CN.idCongNhan = PC.idCongNhan
    JOIN PhanXuong PX ON CN.idPhanXuong = PX.idPhanXuong
    WHERE MONTH(BC.ngayChamCong) = @Thang AND YEAR(BC.ngayChamCong) = @Nam AND Cn.idCongNhan=@idCongNhan;

END;

go
create trigger trigger_TinhTongTienHD
on ChiTietHopDong
after insert 
as
begin
	declare @tongTien money
	select @tongTien = sum(thanhTien)
	from ChiTietHopDong
	where idHopDong = (select idHopDong from inserted)
	group by idHopDong
	update HopDongSanPham
	set tongTien = @tongTien
	where idHopDong = (select idHopDong from inserted)
end
go
go
create trigger trigger_ThemSanPhamCongDoan
on ChiTietHopDong
after insert
as
begin
	update CongDoanSP
	set soLuongSanPham = soLuongSanPham + (select inserted.soLuong from inserted)
	where idSanPham = (select inserted.idSanPham from inserted)
end
go
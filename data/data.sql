--use master
--drop database QLLuongSanPham
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
	thuTuUuTien varchar(3)
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
    ('CV002', N'Kế Toán', 1.4),
    ('CV003', N'Trưởng phòng sản xuất', 2.1),
    ('CV004', N'Trưởng phòng nhân sự', 2.1);
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
    ('1111000001', N'SacomBank', N'Nguyễn Thị Ánh', N'Chi nhánh Hà Nội'),
    ('1111000002', N'Techcombank', N'Lê Văn Hùng', N'Chi nhánh TP.HCM'),
    ('1111000003', N'Agribank', N'Trần Thị Thảo', N'Chi nhánh Đà Nẵng'),
    ('1111000004', N'Vietcombank', N'Vũ Văn Minh', N'Chi nhánh Hải Phòng'),
    ('1111000005', N'BIDV', N'Phạm Thị Hương', N'Chi nhánh Cần Thơ'),
    ('1111000006', N'VietinBank', N'Lê Huy Hoàng', N'Chi nhánh Huế'),
    ('1111000007', N'SHB', N'Trần Thị Minh', N'Chi nhánh Nha Trang'),
    ('1111000008', N'ACB', N'Hoàng Văn Phú', N'Chi nhánh Vũng Tàu'),
    ('1111000009', N'Maritime Bank', N'Ngọc Thị Bích', N'Chi nhánh Long An'),
    ('1111000010', N'SEABank', N'Phan Văn Hòa', N'Chi nhánh Đồng Nai'),
    ('1111000011', N'Sacombank', N'Trần Thị Linh', N'Chi nhánh Hà Nội'),
    ('1111000012', N'Techcombank', N'Lê Thanh Hùng', N'Chi nhánh TP.HCM'),
    ('1111000013', N'Agribank', N'Nguyễn Thị Hoài', N'Chi nhánh Đà Nẵng'),
    ('1111000014', N'Vietcombank', N'Vũ Văn Đức', N'Chi nhánh Hải Phòng'),
    ('1111000015', N'BIDV', N'Nguyễn Thị Mai', N'Chi nhánh Cần Thơ'),
    ('1111000016', N'VietinBank', N'Phạm Văn Thái', N'Chi nhánh Huế'),
    ('1111000017', N'SHB', N'Lê Thị Hương', N'Chi nhánh Nha Trang'),
    ('1111000018', N'ACB', N'Nguyễn Văn An', N'Chi nhánh Vũng Tàu'),
    ('1111000019', N'Maritime Bank', N'Trần Thị Bình', N'Chi nhánh Long An'),
    ('1111000020', N'SEABank', N'Lê Văn Minh', N'Chi nhánh Đồng Nai'),
    ('1111000021', N'SEABank', N'Nguyễn V', N'Chi nhánh Đồng Nai'),
	('1111000022', N'Vietcombank', N'Nguyễn Văn An', N'Chi nhánh Hà Nội'),
    ('1111000023', N'Techcombank', N'Phạm Thị Bình', N'Chi nhánh TP.HCM'),
    ('1111000024', N'Sacombank', N'Vũ Văn Minh', N'Chi nhánh Đà Nẵng'),
    ('1111000025', N'Agribank', N'Trần Thị Mai', N'Chi nhánh Hải Phòng'),
    ('1111000026', N'BIDV', N'Lê Thanh Hùng', N'Chi nhánh Cần Thơ'),
    ('1111000027', N'VietinBank', N'Hoàng Thị Ngọc', N'Chi nhánh Huế'),
    ('1111000028', N'SHB', N'Phạm Văn Tuấn', N'Chi nhánh Nha Trang'),
    ('1111000029', N'Maritime Bank', N'Trần Thị Lan', N'Chi nhánh Vũng Tàu'),
    ('1111000030', N'ACB', N'Trần Thanh Tâm', N'Chi nhánh Long An'),
    ('1111000031', N'SEABank', N'Hà Thị An', N'Chi nhánh Đồng Nai'),
    ('1111000032', N'Sacombank', N'Lê Văn Trung', N'Chi nhánh Hà Nội'),
    ('1111000033', N'Techcombank', N'Nguyễn Thị Lan', N'Chi nhánh TP.HCM'),
    ('1111000034', N'Agribank', N'Nguyễn Văn Long', N'Chi nhánh Đà Nẵng'),
    ('1111000035', N'Vietcombank', N'Trần Văn Bình', N'Chi nhánh Hải Phòng'),
    ('1111000036', N'BIDV', N'Nguyễn Thị Hoa', N'Chi nhánh Cần Thơ'),
    ('1111000037', N'VietinBank', N'Vũ Văn Đức', N'Chi nhánh Huế'),
    ('1111000038', N'SHB', N'Hoàng Văn Phú', N'Chi nhánh Nha Trang'),
    ('1111000039', N'ACB', N'Trần Thị Minh', N'Chi nhánh Vũng Tàu'),
    ('1111000040', N'Maritime Bank', N'Lê Huy Hoàng', N'Chi nhánh Long An'),
    ('1111000041', N'SEABank', N'Phan Văn Hòa', N'Chi nhánh Đồng Nai');
go
INSERT INTO TaiKhoan (tenTaiKhoan, matKhau, loaiTaiKhoan,soTaiKhoan)
VALUES
    ('NV0001', 'Password1', N'kế toán','1111000001'),
    ('NV0002', 'Password2', N'kế toán','1111000002'),
    ('NV0003', 'Password3', N'Trưởng phòng nhân sự','1111000003'),
    ('NV0004', 'Password4', N'Trưởng phòng sản xuất','1111000004'),
    ('NV0005', 'Password5', N'nhân viên hành chánh','1111000005'),
    ('NV0006', 'Password6', N'nhân viên hành chánh','1111000006'),
    ('NV0007', 'Password7', N'nhân viên hành chánh','1111000007'),
    ('NV0008', 'Password8', N'nhân viên hành chánh','1111000008'),
    ('NV0009', 'Password9', N'nhân viên hành chánh','1111000009'),
    ('NV0010', 'Password10', N'nhân viên hành chánh','1111000010'),
    ('NV0011', 'Password11', N'nhân viên hành chánh','1111000011'),
    ('NV0012', 'Password12', N'nhân viên hành chánh','1111000012'),
    ('NV0013', 'Password13', N'nhân viên hành chánh','1111000013'),
    ('NV0014', 'Password14', N'nhân viên hành chánh','1111000014'),
    ('NV0015', 'Password15', N'nhân viên hành chánh','1111000015'),
    ('NV0016', 'Password16', N'nhân viên hành chánh','1111000016'),
    ('NV0017', 'Password17', N'nhân viên hành chánh','1111000017'),
    ('NV0018', 'Password18', N'nhân viên hành chánh','1111000018'),
    ('NV0019', 'Password19', N'nhân viên hành chánh','1111000019'),
    ('NV0020', 'Password20', N'nhân viên hành chánh','1111000020'),
    ('NV0021', 'Password21', N'nhân viên hành chánh','1111000021'),
    ('CN0001', 'Matkhau1', N'cong nhân', '1111000022'),
    ('CN0002', 'Matkhau2', N'cong nhân', '1111000023'),
    ('CN0003', 'Matkhau3', N'cong nhân', '1111000024'),
    ('CN0004', 'Matkhau4', N'cong nhân', '1111000025'),
    ('CN0005', 'Matkhau5', N'cong nhân', '1111000026'),
    ('CN0006', 'Matkhau6', N'cong nhân', '1111000027'),
    ('CN0007', 'Matkhau7', N'cong nhân', '1111000028'),
    ('CN0008', 'Matkhau8', N'cong nhân', '1111000029'),
    ('CN0009', 'Matkhau9', N'cong nhân', '1111000030'),
    ('CN0010', 'Matkhau10', N'cong nhân', '1111000031'),
    ('CN0011', 'Matkhau11', N'cong nhân', '1111000032'),
    ('CN0012', 'Matkhau12', N'cong nhân', '1111000033'),
    ('CN0013', 'Matkhau13', N'cong nhân', '1111000034'),
    ('CN0014', 'Matkhau14', N'cong nhân', '1111000035'),
    ('CN0015', 'Matkhau15', N'cong nhân', '1111000036'),
    ('CN0016', 'Matkhau16', N'cong nhân', '1111000037'),
    ('CN0017', 'Matkhau17', N'cong nhân', '1111000038'),
    ('CN0018', 'Matkhau18', N'cong nhân', '1111000039'),
    ('CN0019', 'Matkhau19', N'cong nhân', '1111000040'),
    ('CN0020', 'Matkhau20', N'cong nhân', '1111000041');

go
INSERT INTO NhanVien (idNhanVien, hoTen, phai, ngaySinh, ngayBatDauCongTac, ngayKetThucCongTac, email, soDienThoai, idChucVu, heSoBaoHiemXaHoi, luongCoBan, tenTaiKhoan, idPhongBan, phuCap,anhDaiDien, cCCD)
VALUES
('NV0001', N'Nguyễn Thị Ánh', 0, '1985-11-25', '2007-07-17', null, 'anhnguyen@gmail.com', '0901234567', 'CV002', 0.05, 8000000, 'NV0001', 'PB001', 700000, 'avatar1.jpg','012345678901'),
    ('NV0002', N'Lê Văn Hùng', 1, '1986-02-12', '2008-09-05', NULL, 'hungle@gmail.com', '0912345678', 'CV002', 0.05, 8000000, 'NV0002', 'PB001', 700000,'avatar2.jpg','012345678901'),
    ('NV0003', N'Trần Thị Thảo', 0, '1982-08-31', '2005-10-09', NULL, 'thao.tran@gmail.com', '0923456789', 'CV003', 0.05, 8000000, 'NV0003', 'PB002', 1000000,'avatar3.jpg','012345678901'),
    ('NV0004', N'Vũ Văn Minh', 1, '1980-06-20', '2002-03-18', NULL, 'minhvu@gmail.com', '0934567890', 'CV003', 0.05, 8000000, 'NV0004', 'PB003', 1000000,'avatar4.jpg','012345678901'),
    ('NV0005', N'Phạm Thị Hương', 0, '1991-07-20', '2018-03-25', NULL, 'pthuong@gmail.com', '0987654322', 'CV001', 0.05, 8000000, 'NV0005', 'PB002', 500000, 'avatar5.jpg','012345678901'),
    ('NV0006', N'Lê Huy Hoàng', 1, '1995-11-10', '2019-09-02', NULL, 'lhhoang@gmail.com', '0987654323', 'CV001', 0.05, 8000000, 'NV0006', 'PB001', 500000, 'avatar6.jpg','012345678901'),
    ('NV0007', N'Trần Thị Minh', 0, '1992-05-25', '2021-06-14',  NULL,'ttminh@gmail.com', '0987654324', 'CV001', 0.05, 8000000, 'NV0007', 'PB003', 500000, 'avatar7.jpg','012345678901'),
    ('NV0008', N'Hoàng Văn Phú', 1, '1989-12-02', '2019-04-20', NULL, 'hvphu@gmail.com', '0987654325', 'CV001', 0.05, 8000000, 'NV0008', 'PB002', 500000, 'avatar8.jpg','012345678901'),
    ('NV0009', N'Ngọc Thị Bích', 0, '1993-08-12', '2022-02-05', NULL, 'ntbich@gmail.com', '0987654326', 'CV001', 0.05, 8000000, 'NV0009', 'PB001', 500000, 'avatar9.jpg','012345678901'),
    ('NV0010', N'Phan Văn Hòa', 1, '1991-04-30', '2018-11-30', NULL, 'pvhoa@gmail.com', '0987654327', 'CV001', 0.05, 8000000, 'NV0010', 'PB003', 500000, 'avatar10.jpg','012345678901'),
    ('NV0011', N'Trần Thị Linh', 0, '1994-06-18', '2022-03-10', NULL, 'ttlinh@gmail.com', '0987654328', 'CV001', 0.05, 8000000, 'NV0011', 'PB001', 500000, 'avatar11.jpg','012345678901'),
    ('NV0012', N'Lê Thanh Hùng', 1, '1990-02-08', '2019-01-07', NULL, 'lthung@gmail.com', '0987654329', 'CV001', 0.05, 8000000, 'NV0012', 'PB002', 500000, 'avatar12.jpg','012345678901'),
    ('NV0013', N'Nguyễn Thị Hoài', 0, '1992-10-05', '2020-05-03', NULL, 'nthoai@gmail.com', '0987654330', 'CV001', 0.05, 8000000, 'NV0013', 'PB003', 500000, 'avatar13.jpg','012345678901'),
    ('NV0014', N'Vũ Văn Đức', 1, '1988-11-21', '2018-12-14', NULL, 'vvduc@gmail.com', '0987654331', 'CV001', 0.05, 8000000, 'NV0014', 'PB001', 500000, 'avatar14.jpg','012345678901'),
    ('NV0015', N'Nguyễn Thị Mai', 0, '1993-07-07', '2020-09-28', NULL, 'nthimai@gmail.com', '0987654332', 'CV001', 0.05, 8000000, 'NV0015', 'PB001', 500000, 'avatar15.jpg','012345678901'),
    ('NV0016', N'Phạm Văn Thái', 1, '1987-03-25', '2019-11-15', NULL, 'pvthai@gmail.com', '0987654333', 'CV001', 0.05, 8000000, 'NV0016', 'PB003', 500000, 'avatar16.jpg','012345678901'),
    ('NV0017', N'Lê Thị Hương', 0, '1995-09-12', '2021-07-20', NULL, 'lthuong@gmail.com', '0987654334', 'CV001', 0.05, 8000000, 'NV0017', 'PB002', 500000, 'avatar17.jpg','012345678901'),
	('NV0018', N'Nguyễn Văn An', 1, '1990-03-15', '2010-01-15', NULL, 'vanan@gmail.com', '0987654321', 'CV001', 0.05, 8000000, 'NV0018', 'PB001', 500000,'avatar18.jpg','012345678901'),
    ('NV0019', N'Trần Thị Bình', 0, '1992-05-20', '2012-02-18', NULL, 'binhtran@gmail.com', '0971234567', 'CV001', 0.05, 8000000, 'NV0019', 'PB001', 500000,'avatar19.jpg','012345678901'),
    ('NV0020', N'Lê Văn Minh', 1, '1988-12-10', '2009-03-28', NULL, 'minhle@gmail.com', '0965432198', 'CV001', 0.05, 8000000, 'NV0020', 'PB003', 500000,'avatar20.jpg','012345678901'),
	('NV0021', N'Nguyễn V', 1, '1990-03-15', '2020-01-15', NULL, 'nvan@gmail.com', '0987654321', 'CV001', 0.05, 8000000, 'NV0021', 'PB003', 500000, 'avatar21.jpg','012345678901')
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
('CN0001', N'Nguyễn Văn An', 1, '1980-01-01', '2005-05-10', NULL, 'PX001', 'nguyenvanan@gmail.com', '0123456789',700000, N'Giỏi', 'CN0001', 'avatar22.jpg','012345678901'),
('CN0002', N'Phạm Thị Bình', 0, '1985-03-15', '2008-11-20', NULL, 'PX002', 'binhpham@yahoo.com', '0234567890', 700000, N'Khá', 'CN0002', 'avatar23.jpg','012345678901'),
('CN0003', N'Vũ Văn Minh', 1, '1990-07-20', '2010-09-30', NULL, 'PX003', 'vuminh@gmail.com', '0345678901', 700000, N'Trung bình', 'CN0003', 'avatar24.jpg','012345678901'),
('CN0004', N'Trần Thị Mai', 0, '1988-05-05', '2009-12-05', NULL, 'PX001', 'maitran@yahoo.com', '0456789012', 700000, N'Giỏi', 'CN0004', 'avatar25.jpg','012345678901'),
('CN0005', N'Lê Thanh Hùng', 1, '1986-09-10', '2007-06-15', NULL, 'PX002', 'hungle@gmail.com', '0567890123', 700000, N'Khá', 'CN0005', 'avatar26.jpg','012345678901'),
('CN0006', N'Hoàng Thị Ngọc', 0, '1992-11-25', '2013-04-28', NULL, 'PX003', 'ngochoang@gmail.com', '0678901234', 700000, N'Trung bình', 'CN0006', 'avatar27.jpg','012345678901'),
('CN0007', N'Phạm Văn Tuấn', 1, '1995-02-01', '2016-07-10', NULL, 'PX001', 'tuanpham@gmail.com', '0789012345', 700000, N'Giỏi', 'CN0007', 'avatar28.jpg','012345678901'),
('CN0008', N'Trần Thị Lan', 0, '1984-12-12', '2006-09-23', NULL, 'PX002', 'lantran@gmail.com', '0890123456', 700000, N'Khá', 'CN0008', 'avatar29.jpg','012345678901'),
('CN0009', N'Trần Thanh Tâm', 1, '1989-06-20', '2010-11-15', NULL, 'PX003', 'tamtran@yahoo.com', '0901234567', 700000, N'Trung bình', 'CN0009', 'avatar30.jpg','012345678901'),
('CN0010', N'Hà Thị An', 0, '1991-08-18', '2012-12-12', NULL, 'PX001', 'anh@gmail.com', '0987654321', 700000, N'Giỏi', 'CN0010', 'avatar31.jpg','012345678901'),
('CN0011', N'Lê Văn Trung', 1, '1983-04-30', '2004-06-25', NULL, 'PX002', 'trung@gmail.com', '0987654321', 700000, N'Khá', 'CN0011', 'avatar32.jpg','012345678901'),
('CN0012', N'Nguyễn Thị Lan', 0, '1987-10-02', '2008-07-10', NULL, 'PX003', 'lan@gmail.com', '0987654321', 700000, N'Trung bình', 'CN0012', 'avatar33.jpg','012345678901'),
('CN0013', N'Nguyễn Văn Long', 1, '1982-03-17', '2003-05-20', NULL, 'PX001', 'long@gmail.com', '0987654321', 700000, N'Giỏi', 'CN0013', 'avatar34.jpg','012345678901'),
('CN0014', N'Trần Văn Bình', 0, '1993-07-08', '2014-09-30', NULL, 'PX002', 'binh@gmail.com', '0987654321', 700000, N'Khá', 'CN0014', 'avatar35.jpg','012345678901'),
('CN0015', N'Nguyễn Thị Hoa', 1, '1981-05-25', '2002-06-10', NULL, 'PX003', 'hoa@gmail.com', '0987654321', 700000, N'Trung bình', 'CN0015', 'avatar36.jpg','012345678901'),
('CN0016', N'Vũ Văn Đức', 1, '1980-08-12', '2001-12-25', NULL, 'PX001', 'duc@gmail.com', '0987654321', 700000, N'Giỏi', 'CN0016', 'avatar37.jpg','012345678901'),
('CN0017', N'Hoàng Văn Phú', 1, '1994-01-10', '2015-03-15', NULL, 'PX002', 'phu@gmail.com', '0987654321', 700000, N'Khá', 'CN0017', 'avatar38.jpg','012345678901'),
('CN0018', N'Lê Huy Hoàng', 1, '1996-09-28', '2017-11-20', NULL, 'PX003', 'hoang@gmail.com', '0987654321', 700000, N'Trung bình', 'CN0018', 'avatar39.jpg','012345678901'),
('CN0019', N'Phan Văn Hòa', 1, '1988-06-15', '2009-08-30', NULL, 'PX001', 'hoa@gmail.com', '0987654321', 700000, N'Giỏi', 'CN0019', 'avatar40.jpg','012345678901'),
('CN0020', N'Vũ Thị Thùy', 0, '1991-03-20', '2012-06-10', NULL, 'PX002', 'thuy@gmail.com', '0987654321', 700000, N'Khá', 'CN0020', 'avatar41.jpg','012345678901');
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
    ('SP0001', N'Áo Khoác Đông', 500000, N'Len', 'Cái', N'Áo khoác dành cho mùa Đông', 'path/to/anh1.jpg'),
    ('SP0002', N'Quần Jean Xuân', 350000, N'Jean', 'Cái', N'Quần Jean phong cách Xuân', 'path/to/anh2.jpg'),
    ('SP0003', N'Đầm Dự Tiệc', 600000, N'Vải Satin', 'Cái', N'Đầm dự tiệc sang trọng', 'path/to/anh3.jpg'),
    ('SP0004', N'Quần Kaki Hè', 300000, N'Kaki', 'Cái', N'Quần kaki thích hợp cho mùa Hè', 'path/to/anh4.jpg'),
    ('SP0005', N'Áo Thun Hè', 150000, N'Cotton', 'Cái', N'Áo thun mát mẻ cho mùa Hè', 'path/to/anh5.jpg'),
    ('SP0006', N'Áo Sơ Mi Xuân', 250000, N'Vải lụa', 'Cái', N'Áo sơ mi thời trang cho mùa Xuân', 'path/to/anh6.jpg'),
    ('SP0007', N'Áo Phông Hè', 180000, N'Cotton', 'Cái', N'Áo phông phong cách cho mùa Hè', 'path/to/anh7.jpg'),
    ('SP0008', N'Đầm Công Sở', 450000, N'Vải công sở', 'Cái', N'Đầm phù hợp cho công sở', 'path/to/anh8.jpg'),
    ('SP0009', N'Quần Thể Thao', 280000, N'Polyester', 'Cái', N'Quần thể thao cho mùa Xuân', 'path/to/anh9.jpg'),
    ('SP0010', N'Áo Khoác Thu', 520000, N'Len', 'Cái', N'Áo khoác cho mùa Thu', 'path/to/anh10.jpg');


--tHÊM 4 công đoạn

INSERT INTO CongDoanSP (idCongDoan, tenCongDoan, soLuongSanPham, luongCongDoan, idSanPham, thuTuUuTien)
VALUES
    ('CDSP0001', N'Chuẩn bị nguyên vật liệu', 100, 500000, 'SP0001', 1),
    ('CDSP0002', N'Cắt vải', 120, 300000,  'SP0001', 2),
    ('CDSP0003', N'May áo khoác', 90, 350000,  'SP0001', 3),
    ('CDSP0004', N'Chuẩn bị vải jean', 130, 250000,  'SP0002',1),
    ('CDSP0005', N'Cắt vải jean', 110, 200000,  'SP0002',2),
    ('CDSP0006', N'May quần jean', 85, 300000,  'SP0002',3),
	('CDSP0007', N'Chuẩn bị vải satin', 80, 200000,  'SP0003', 1),
	('CDSP0008', N'Cắt vải satin', 70, 180000, 'SP0003', 2),
	('CDSP0009', N'May đầm dự tiệc', 50, 250000,  'SP0003', 3);
--THÊM CONG DOAN PHAN CONG
-- Bảng phân công cho sản phẩm SP0001
-- Công đoạn 1
INSERT INTO CongDoanPhanCong (idPhanCong, idCongDoan, idCongNhan, soLuongSPDuocGiao, idCaLam, soLuongConLai)
VALUES 
		('PC0001',  'CDSP0001', 'CN0001', 30, 1,30),
		('PC0002', 'CDSP0002', 'CN0001', 20, 2, 20),
		('PC0003', 'CDSP0003', 'CN0001', 15, 3, 15),
		('PC0004', 'CDSP0001', 'CN0002', 25, 1, 25),
		('PC0005', 'CDSP0002', 'CN0002', 22, 2, 22),
		('PC0006', 'CDSP0003', 'CN0002', 18, 3, 18),
		('PC0007', 'CDSP0004', 'CN0003', 25, 1,25),
		('PC0008', 'CDSP0005', 'CN0003', 20, 2, 20),
		('PC0009', 'CDSP0006', 'CN0003', 15, 3, 15),
		('PC0010', 'CDSP0007', 'CN0001', 10, 1, 10),
		('PC0011', 'CDSP0008', 'CN0002', 8, 2, 8),
		('PC0012', 'CDSP0009', 'CN0003', 7, 3, 7);

INSERT INTO BangChamCongCongNhan (idNgayChamCong, ngayChamCong, soLuongHoanThanh, idPhanCong, heSoNgayLam)
VALUES
    ('CCN0001', '2023-10-01', 30, 'PC0001', 1.35),
    ('CCN0002', '2023-10-02', 30, 'PC0002', 1.0),
    ('CCN0003', '2023-10-03', 30, 'PC0003', 1.0),
    ('CCN0004', '2023-10-04', 30, 'PC0004', 1.0),
    ('CCN0005', '2023-10-05', 30, 'PC0005', 1.0),
    ('CCN0006', '2023-10-06', 30, 'PC0006', 1.0),
    ('CCN0007', '2023-10-07', 30, 'PC0007', 1.0),
    ('CCN0008', '2023-10-08', 30, 'PC0008', 1.35),
    ('CCN0009', '2023-10-09', 30, 'PC0009', 1.0),
    ('CCN0010', '2023-10-10', 30, 'PC0010', 1.0),
    ('CCN0011', '2023-10-11', 30, 'PC0011', 1.0),
    ('CCN0012', '2023-10-12', 30, 'PC0012', 1.0),
    ('CCN0013', '2023-10-13', 30, 'PC0001', 1.0),
    ('CCN0014', '2023-10-14', 30, 'PC0002', 1.0),
    ('CCN0015', '2023-10-15', 30, 'PC0003', 1.35),
    ('CCN0016', '2023-10-16', 30, 'PC0004', 1.0),
    ('CCN0017', '2023-10-17', 30, 'PC0005', 1.0),
    ('CCN0018', '2023-10-18', 30, 'PC0006', 1.0),
    ('CCN0019', '2023-10-19', 30, 'PC0007', 1.0),
    ('CCN0020', '2023-10-20', 30, 'PC0008', 1.0),
    ('CCN0021', '2023-10-21', 30, 'PC0009', 1.0),
    ('CCN0022', '2023-10-22', 30, 'PC0010', 1.35),
    ('CCN0023', '2023-10-23', 30, 'PC0011', 1.0),
    ('CCN0024', '2023-10-24', 30, 'PC0012', 1.0),
    ('CCN0025', '2023-10-25', 30, 'PC0001', 1.0),
    ('CCN0026', '2023-10-26', 30, 'PC0002', 1.0),
    ('CCN0027', '2023-10-27', 50, 'PC0003', 1.0),
    ('CCN0028', '2023-10-28', 50, 'PC0004', 1.0),
    ('CCN0029', '2023-10-29', 50, 'PC0005', 1.35),
    ('CCN0030', '2023-10-30', 50, 'PC0006', 1.0),
    ('CCN0031', '2023-10-31', 50, 'PC0007', 1.0),
	--
	('CCN0032', '2023-11-01', 30, 'PC0001', 1.35),
    ('CCN0033', '2023-11-02', 30, 'PC0002', 1.0),
    ('CCN0034', '2023-11-03', 30, 'PC0003', 1.0),
    ('CCN0035', '2023-11-04', 30, 'PC0004', 1.0),
    ('CCN0036', '2023-11-05', 30, 'PC0005', 1.0),
    ('CCN0037', '2023-11-06', 30, 'PC0006', 1.0),
    ('CCN0038', '2023-11-07', 30, 'PC0007', 1.0),
    ('CCN0039', '2023-11-08', 30, 'PC0008', 1.35),
    ('CCN0040', '2023-11-09', 30, 'PC0009', 1.0),
    ('CCN0041', '2023-11-10', 30, 'PC0010', 1.0),
    ('CCN0042', '2023-11-11', 30, 'PC0011', 1.0),
    ('CCN0043', '2023-11-12', 30, 'PC0012', 1.0),
    ('CCN0044', '2023-11-13', 30, 'PC0001', 1.0),
    ('CCN0045', '2023-11-14', 30, 'PC0002', 1.0),
    ('CCN0046', '2023-11-15', 30, 'PC0003', 1.35),
    ('CCN0047', '2023-11-16', 30, 'PC0004', 1.0),
    ('CCN0048', '2023-11-17', 30, 'PC0005', 1.0),
    ('CCN0049', '2023-11-18', 30, 'PC0006', 1.0),
    ('CCN0050', '2023-11-19', 30, 'PC0007', 1.0)
    

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
	('CNVHC0027', '2023-10-27', N'Có mặt', 'NV0001'),
	('CNVHC0028', '2023-10-28', N'Có mặt', 'NV0001'),
	('CNVHC0029', '2023-10-29', N'Có mặt', 'NV0001'),
	('CNVHC0030', '2023-10-30', N'Có mặt', 'NV0001'),
	('CNVHC0031', '2023-10-31', N'Có mặt', 'NV0001'),
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
    ('CNVHC0057', '2023-11-26', N'Có mặt', 'NV0001'),
    ('CNVHC0059', '2023-11-28', N'Có mặt', 'NV0001'),
    ('CNVHC0060', '2023-11-29', N'Có mặt', 'NV0001'),
    ('CNVHC0061', '2023-11-30', N'Có mặt', 'NV0001'),
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
    ('CNVHC0087', '2023-11-26', N'Có mặt', 'NV0002'),
    ('CNVHC0088', '2023-11-27', N'Có mặt', 'NV0002'),
    ('CNVHC0089', '2023-11-28', N'Có mặt', 'NV0002'),
    ('CNVHC0090', '2023-11-29', N'Có mặt', 'NV0002'),
    ('CNVHC0091', '2023-11-30', N'Có mặt', 'NV0002'),
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
    ('CNVHC0117', '2023-11-26', N'Có mặt', 'NV0003'),
    ('CNVHC0118', '2023-11-27', N'Có mặt', 'NV0003'),
    ('CNVHC0119', '2023-11-28', N'Có mặt', 'NV0003'),
    ('CNVHC0120', '2023-11-29', N'Có mặt', 'NV0003'),
    ('CNVHC0121', '2023-11-30', N'Có mặt', 'NV0003'),
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
    ('CNVHC0147', '2023-11-26', N'Có mặt', 'NV0004'),
    ('CNVHC0148', '2023-11-27', N'Có mặt', 'NV0004'),
    ('CNVHC0149', '2023-11-28', N'Có mặt', 'NV0004'),
    ('CNVHC0150', '2023-11-29', N'Có mặt', 'NV0004'),
    ('CNVHC0151', '2023-11-30', N'Có mặt', 'NV0004'),
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
    ('CNVHC0202', '2023-11-26', N'Có mặt', 'NV0006'),
    ('CNVHC0203', '2023-11-27', N'Có mặt', 'NV0006'),
    ('CNVHC0204', '2023-11-28', N'Có mặt', 'NV0006'),
    ('CNVHC0205', '2023-11-29', N'Có mặt', 'NV0006'),
    ('CNVHC0206', '2023-11-30', N'Có mặt', 'NV0006'),
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
    ('CNVHC0310', '2023-10-26', N'Có mặt', 'NV0005')

select n.idNhanVien,n.idPhongBan,c.tenChucVu from NhanVien n join BangChamCongNhanVienHC l on n.idNhanVien=l.idNhanVien join ChucVu c on n.idChucVu = c.idChucVu
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
    WHERE idNhanVien = @idNhanVien  AND MONTH(ngayChamCong) = @thang and YEAR(ngayChamCong) = @nam and trangThai = N'Vắng Mặt'

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
CREATE PROCEDURE chiTietLuongNhanVien_proc (
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
    WHERE idNhanVien = @idNhanVien  AND MONTH(ngayChamCong) = @thang and YEAR(ngayChamCong) = @nam and trangThai = N'Vắng Mặt'

    -- Số Tiền Nghỉ Làm Không Phép
    SET @soTienNghiKhongPhep = @soNgayNghiKhongPhep * 150000

    -- Số Ngày Nghỉ Có Phép
    SELECT @soNgayNghiCoPhep = COUNT(*)
    FROM BangChamCongNhanVienHC
    WHERE idNhanVien = @idNhanVien  AND MONTH(ngayChamCong) = @thang and YEAR(ngayChamCong) = @nam and trangThai = N'Có phép'
END
go
go
create PROCEDURE ThongTinLuongCongNhan
    @Thang INT,
    @Nam INT,
    @idNhanVien NVARCHAR(10),
    @thucLanh MONEY OUTPUT,
    @luongHanhChanh MONEY OUTPUT

AS
BEGIN
    DECLARE @phuCap MONEY;
	DECLARE @LuongTangCa MONEY
    SELECT @phuCap = CN.phuCap
    FROM CongNhan CN
    WHERE CN.idCongNhan = @idNhanVien;

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
        AND CN.idCongNhan = @idNhanVien;

    SET @thucLanh = @luongHanhChanh + @LuongTangCa + @phuCap;
END;
go
create PROCEDURE TinhTongSanLuongVaThoiGianLamViec
    @Thang INT,
    @Nam INT,
    @idCongNhan NVARCHAR(10),
	@TongSanLuong INT output,
    @TongThoiGianLamViec FLOAT output
AS
BEGIN
    -- Tính tổng sản lượng hoàn thành
    SELECT @TongSanLuong = SUM(BC.soLuongHoanThanh)
    FROM BangChamCongCongNhan BC
    JOIN CongDoanPhanCong PC ON BC.idPhanCong = PC.idPhanCong
	join CongNhan CN ON CN.idCongNhan = PC.idCongNhan
    JOIN PhanXuong PX ON CN.idPhanXuong = PX.idPhanXuong
    WHERE MONTH(BC.ngayChamCong) = @Thang AND YEAR(BC.ngayChamCong) = @Nam AND Cn.idCongNhan=@idCongNhan;

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





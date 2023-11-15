package bus;

import java.util.ArrayList;

import dao.ThongKeLuongCongNhan_DAO;

public class ThongKeLuongCongNhan_BUS {
       private ThongKeLuongCongNhan_DAO thongKeLuongCongNhan_DAO = new ThongKeLuongCongNhan_DAO();
       public ArrayList<String> getListLuongPX(int month, int year)
       {
    	   return thongKeLuongCongNhan_DAO.getListLuongCNtheoPhanXuong(month, year);
       }
}

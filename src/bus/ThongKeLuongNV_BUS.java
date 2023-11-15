package bus;

import java.lang.reflect.Array;
import java.util.ArrayList;

import dao.ThongKeLuongNhanVien_DAO;

public class ThongKeLuongNV_BUS {
      private ThongKeLuongNhanVien_DAO thongKeLuongNhanVien_DAO = new ThongKeLuongNhanVien_DAO();
      public ArrayList<String> getListLuongPB(int month, int year)
      {
    	  return thongKeLuongNhanVien_DAO.getListLuongTheoPhongBan(month, year);
      }
}

package bus;

import java.util.ArrayList;

import dao.ThongKeKPI_DAO;

public class ThongKeKPI_BUS {
       private ThongKeKPI_DAO thongKeKPI_DAO = new ThongKeKPI_DAO();
       public ArrayList<String> getListCNKPI(int month, int year)
       {
    	   return thongKeKPI_DAO.getListCongNhanKPI(month, year);
       }
}

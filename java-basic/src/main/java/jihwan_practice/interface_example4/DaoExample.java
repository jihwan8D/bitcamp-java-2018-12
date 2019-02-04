package jihwan_practice.interface_example4;

public class DaoExample {

  public static void dbWork(DataAccessObject dao) {
    dao.select();
    dao.insert();
    dao.updata();
    dao.delete();
  }
  
  
  public static void main(String[] args) {
    dbWork(new OracleDao());
    dbWork(new MySqlDao());
     
  }

}

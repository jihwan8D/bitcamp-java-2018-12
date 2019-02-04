package jihwan_practice.interface_example4;

public class OracleDao implements DataAccessObject {

  @Override
  public void select() {
    System.out.println("Oracle DB에서 검색");
  }

  @Override
  public void insert() {
    System.out.println("Oracle DB에서 삽입");
  }

  @Override
  public void updata() {
    System.out.println("Oracle DB에서 수정");
  }

  @Override
  public void delete() {
    System.out.println("Oracle DB에서 삭제");
  }

}

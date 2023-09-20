public class Person extends CRUDFile {
  private String name;
  private String desc;

  public Person(String name, String desc, String fileName) {
    super(fileName);
    this.name = name;
    this.desc = desc;
  }

  public Person(String fileName) {
    super(fileName);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return desc;
  }

  public void setDescription(String desc) {
    this.desc = desc;
  }

  // deve retornar uma string com os dados da pessoa
  @Override
  public String toString() {
    return "Nome: " + this.name + "\nDesc: " + this.desc + "\n";
  }

  // methods CRUD

  public void create() {
    String data = this.name + "," + this.desc + ";";
    super.create(data);
  }

  public String readAll() {
    return super.readAll();
  }

  public String read(String identifier, int index) {
    return super.read(identifier, index);
  }

  public boolean update(String identifier, String newData, int index) {
    return super.update(identifier, newData, index);
  }

  public boolean delete(String identifier, int index) {
    return super.delete(identifier, index);
  }
}

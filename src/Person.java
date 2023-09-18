public class Person extends CRUDFile {
  private String name;
  private String cpf;
  private String email;

  public Person(String name, String cpf, String email, String fileName) {
    super(fileName);
    this.name = name;
    this.cpf = cpf;
    this.email = email;
  }

  // getters and setters

  public String getName() {
    return name;
  }

  public String getCpf() {
    return cpf;
  }

  public String getEmail() {
    return email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // deve retornar uma string com os dados da pessoa
  @Override
  public String toString() {
    return "Nome: " + this.name + "\nCPF: " + this.cpf + "\nEmail: " + this.email;
  }

  // methods CRUD

  public void create() {
    String data = this.name + "," + this.cpf + "," + this.email + ";";
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

package empleados;

public class Empleado {
	private String name;
	private String surname;
	private String post;
	private int salary;
	
	public Empleado(String name, String surname, String post, int salary) {
		this.name=name;
		this.surname=surname;
		this.post=post;
		this.salary=salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}

package lt.viko.eif.saitynas_final_project.objects;

public class Staff {
	private int id;
	private String name;
	private String surname;
	private String role;
	private String origin;
	private int movieId;
	
	public Staff(int id, String name, String surname, String role, String origin, int movieId) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.origin = origin;
		this.movieId = movieId;
	}
	
	public Staff() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
}

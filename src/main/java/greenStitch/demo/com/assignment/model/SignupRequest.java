package greenStitch.demo.com.assignment.model;

public class SignupRequest {
	private String name;
    private String username;
    private String password;
    private String phone;
    private String dob;
	
	// Default constructor (required by Spring for request deserialization)
    public SignupRequest() {
    }

    // Getters and setters for the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

	public SignupRequest(String name, String username, String password, String phone, String dob) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.dob = dob;
	}
    
}

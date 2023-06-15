package greenStitch.demo.com.assignment.model;

public class LoginRequest {
	private String username;
	private String password;
	
	// Default constructor (required by Spring for request deserialization)
	public LoginRequest() {
    }

    // Getters and setters for the fields
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
}

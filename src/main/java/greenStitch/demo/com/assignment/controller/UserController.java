package greenStitch.demo.com.assignment.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import greenStitch.demo.com.assignment.model.LoginRequest;
import greenStitch.demo.com.assignment.model.SignupRequest;
import greenStitch.demo.com.assignment.service.User;
import greenStitch.demo.com.assignment.service.UserRepository;

@RestController
public class UserController {
	private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
	
    @Value("${jwt.secret}")
    private String jwtSecret;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // Implement the logic for user authentication and token generation
        // Retrieve the user's credentials from loginRequest.getUsername() and loginRequest.getPassword()
        // Verify the credentials against the stored data in the database
        // If the authentication is successful, generate and return a token
        // If the authentication fails, return an appropriate error message
		String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Mocked user credentials for demonstration purposes
        String storedUsername = "testUser";
        String storedPassword = "$2a$10$FiwHIAlhmu8AfQqzgTIwfeYlFs1xrhD.N1aVeAeeflJn5y1vrDnX."; // Hashed password

        // Verify user credentials
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (username.equals(storedUsername) && passwordEncoder.matches(password, storedPassword)) {
            // Authentication successful
            // Generate the web token
            String token = generateToken(username);

            // Return the token with an HTTP status of 200 (OK)
            return ResponseEntity.ok(token);
        } else {
            // Authentication failed
            // Return an error message with an HTTP status of 401 (Unauthorized)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // Helper method to generate a web token
    private String generateToken(String username) {
        // Set the expiration time of the token (e.g., 1 hour from now)
        long expirationMillis = System.currentTimeMillis() + 3600000;

        
		// Generate the token
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(expirationMillis))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

        return token;
    }
    

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest signupRequest) {
        
    	 if (userRepository.findByUsername(signupRequest.getUsername()) != null) {
             return "Username already exists";
         }

         // Create a new user entity
         User user = new User();
         user.setName(signupRequest.getName());
         user.setUsername(signupRequest.getUsername());

         // Hash the password using BCryptPasswordEncoder
         String hashedPassword = passwordEncoder.encode(signupRequest.getPassword());
         user.setPassword(hashedPassword);

         user.setPhone(signupRequest.getPhone());
         user.setDob(signupRequest.getDob());

         // Save the user entity to the database
         userRepository.save(user);

         return "Signup successful";
    
    }
}


package tacos.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import tacos.User;
import tacos.data.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

/*    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> userList = new ArrayList<>();

        userList.add(new User("buzz", encoder.encode("password"),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))));

        userList.add(new User("woody", encoder.encode("password"),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))));

        return new InMemoryUserDetailsManager(userList);
    }*/

//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepo) {
//        return username -> {
//            User user = userRepo.findUserByUsername(username);
//            if (user != null) return user;
//
//            throw new UsernameNotFoundException("User '" + username + "' not found.");
//        };
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authorizeHttpRequestCustomizer) -> authorizeHttpRequestCustomizer
//                .requestMatchers("/design", "/orders").hasRole("USER")
//                .requestMatchers("/", "/**").permitAll()
//        );
//
//        http.formLogin((formLoginConfigurer) -> formLoginConfigurer.loginPage("/login"));
//
//        http.oauth2Login().loginPage("/login");
//
//        return http.build();
//    }


}

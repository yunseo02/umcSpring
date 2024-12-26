package umcspring.umc.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity//Spring security 설정을 활성화
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/", "/home", "/signup", "/members/signup", "/css/**").permitAll()//누구나 접근 가능한 경로
                    .requestMatchers("/admin/**").hasRole("ADMIN")//admin 권한이 있는 사용자만 접근 가능
                    .anyRequest().authenticated()//위에 명시되지 않은 모든 요청은 로그인이 필요하다
            )
            .formLogin((form) -> form//로그인 설정/ formLogin: spring security 제공 기본 로그인 폼 사용 혹은 커스텀 로그인 페이지 사용
                    .loginPage("/login")//커스텀 로그인 페이지를 /login 경로로 지정
                    .defaultSuccessUrl("/home", true)//true: 로그인 성공 시 항상 /home으로 보냄
                    .permitAll()//누구나 로그인 페이지에 접근할 수 있도록
            )
            .logout((logout) -> logout
                    .logoutUrl("/logout")//로그아웃 요청 url을 /logout으로 설정
                    .logoutSuccessUrl("/login?logout")//성공 후 리다이렉트될 url
                    .permitAll()
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();//비밀번호를 암호화하여 저장하기 위해
    }
}

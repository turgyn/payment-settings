package kz.bank.config;
import kz.bank.security.JwtAuthenticationEntryPoint;
import kz.bank.security.JwtRequestFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 27.04.2022
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


    private UserDetailsService jwtUserDetailsService;


    private JwtRequestFilter jwtRequestFilter;


    private void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // Csrf не юзаем для примера
         httpSecurity.cors().and().csrf().disable()
          //httpSecurity
                //данные urls защищать не надо
                .authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll().
                // защищать  надо
                 anyRequest().authenticated().and().
                // убедитесь, что мы используем сеанс без сохранения состояния;
                // сессия не будет использоваться для
                  //хранения состояние пользователя.
                        exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //Добавьте фильтр для проверки токенов при каждом запросе.
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }


    private  final String[] AUTH_WHITELIST = {
            "/v1/auth/login",
            "/v1/auth/token",
            // TODO вынести в config файл
            "/openapi/v3/api-docs/**",
            "/openapi/swagger-ui/**"
            //"/**"


    };


}

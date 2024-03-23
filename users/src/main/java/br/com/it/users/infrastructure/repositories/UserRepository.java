package br.com.it.users.infrastructure.repositories;

import br.com.it.users.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}

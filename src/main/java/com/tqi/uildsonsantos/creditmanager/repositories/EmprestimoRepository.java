package com.tqi.uildsonsantos.creditmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tqi.uildsonsantos.creditmanager.entities.Emprestimo;
import com.tqi.uildsonsantos.creditmanager.entities.User;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

	List<Emprestimo> findByUser(User user);

	@Query("SELECT obj FROM Emprestimo obj INNER JOIN obj.user users WHERE " + "obj.id =  :id ")
	Optional<Emprestimo> findByIdAndUserId(Long id);

}

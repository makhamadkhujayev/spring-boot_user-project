package com.example.user_project.repository;

import com.example.user_project.entity.Role;
import com.example.user_project.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityRepository extends JpaRepository <RoleEntity, Long>{
}

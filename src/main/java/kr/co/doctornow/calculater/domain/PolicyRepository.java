package kr.co.doctornow.calculater.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long>{
    public List<Policy> findAll();
}

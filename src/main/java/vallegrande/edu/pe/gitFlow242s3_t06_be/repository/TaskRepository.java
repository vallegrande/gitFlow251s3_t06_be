package vallegrande.edu.pe.gitFlow242s3_t06_be.repository;

import vallegrande.edu.pe.gitFlow242s3_t06_be.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
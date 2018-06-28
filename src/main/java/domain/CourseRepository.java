package domain;

import entity.Course;
import entity.Department;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
public interface CourseRepository extends JpaRepository<Course, Long> {


}

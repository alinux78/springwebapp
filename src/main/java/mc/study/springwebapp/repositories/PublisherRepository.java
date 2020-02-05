package mc.study.springwebapp.repositories;

import mc.study.springwebapp.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}

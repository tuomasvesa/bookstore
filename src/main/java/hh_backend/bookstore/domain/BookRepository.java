package hh_backend.bookstore.domain;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
    // perii mm. palvelut save, deleteById, findById, findAll()

}

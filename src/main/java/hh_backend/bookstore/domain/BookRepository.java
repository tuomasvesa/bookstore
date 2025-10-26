package hh_backend.bookstore.domain;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long>{
    // perii mm. palvelut save, deleteById, findById, findAll()
    List<Book> findByTitle(String title);

}

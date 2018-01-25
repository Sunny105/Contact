package contact;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    List<Contact> findById(Long id);
    List<Contact> findAll();
    Contact save(Contact c);
}
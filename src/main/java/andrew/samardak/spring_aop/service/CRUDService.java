package andrew.samardak.spring_aop.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CRUDService<T, ID> {

    default T create(T t) {
        return getRepository().save(t);
    }

    default T read(ID id) {
        return getRepository().findById(id).orElseThrow();
    }

    default T update(T t) {
        return getRepository().save(t);
    }

    default void delete(ID id) {
        getRepository().deleteById(id);
    }

    JpaRepository<T, ID> getRepository();
}

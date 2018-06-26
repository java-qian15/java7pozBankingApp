package repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import util.HibernateUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

@Slf4j
public abstract class GenericRepository<T, K> {

    private Class<T> type;

    @SuppressWarnings("unchecked")
    GenericRepository() {

        Type genericSuperClass = getClass().getGenericSuperclass();

        ParameterizedType parametrizedType = null;
        while (parametrizedType == null) {
            if ((genericSuperClass instanceof ParameterizedType)) {
                parametrizedType = (ParameterizedType) genericSuperClass;
            } else {
                genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass();
            }
        }
        type = (Class<T>) parametrizedType.getActualTypeArguments()[0];
    }


    public void create(T entity){
        try(
                Session session = HibernateUtil.openSession()
        ){
            session.getTransaction().begin();
            session.persist(entity);
            session.getTransaction().commit();
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
    }

    public void update(T entity){
        try(
                Session session = HibernateUtil.openSession()
        ){
            session.getTransaction().begin();
            session.update(entity);
            session.getTransaction().commit();
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }
    }



    public Optional<T> get(K key){
        try(
                Session session = HibernateUtil.openSession()
        ){
            return Optional.ofNullable(session.find(type, key));
        }catch (Exception e){
            log.error(e.getMessage(), e);
            return Optional.empty();
        }
    }
}

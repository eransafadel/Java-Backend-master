package main.repo;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 *  interface UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     *
     * @param userName userName
     * @return  User - contains username,id , count and url of user.
     */
    User findByUserNameLike(String userName);

    /**
     * findFirst10ByOrderByCountDesc
     * @return List of User that  contains username,id , count and url of user.
     */
    List<User> findFirst10ByOrderByCountDesc();

}

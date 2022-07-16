package project2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Member;

import java.util.List;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Long> {

    Page<Member> findAll(Pageable pageable);


    @Query(value = "SELECT * " +
            "FROM `member` " +
            "inner join `rank` on `rank`.id_rank = `member`.id_rank " +
            "where (`member`.name_member like concat('%' ,?1,'%') or ?1 is null ) " +
            "and (`member`.email_member like concat('%' ,?2,'%') or ?2 is null ) " +
            "and (`member`.address_member like concat('%' ,?3,'%') or ?3 is null ) " +
            "and (`member`.phone_member like concat('%' ,?4,'%') or ?4 is null ) " +
            "and (`rank`.name_rank like concat('%' ,?5,'%') or ?5 is null )" ,
            countQuery = "SELECT `rank`.id_rank " +
                    "FROM `member` " +
                    "inner join `rank` on `rank`.id_rank = `member`.id_rank " +
                    "where (`member`.name_member like concat('%' ,?1,'%') or ?1 is null ) " +
                    "and (`member`.email_member like concat('%' ,?2,'%') or ?2 is null ) " +
                    "and (`member`.address_member like concat('%' ,?3,'%') or ?3 is null ) " +
                    "and (`member`.phone_member like concat('%' ,?4,'%') or ?4 is null ) " +
                    "and (`rank`.name_rank like concat('%' ,?5,'%') or ?5 is null )" , nativeQuery = true)
    Page<Member> searchAllMember(String name, String email, String address, String phoneNumber, String nameRank, Pageable pageable);

    //SonLT View-Member
    Member findMemberByAccount_IdAccount(Long id);

}

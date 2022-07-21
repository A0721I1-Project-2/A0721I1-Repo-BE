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
    //HauNT
    @Query(value = "select `account`.id_account,`account`.username,`account`.`password`,`account`.`block`,`account`.last_login,`account`.flag_delete,`role`.id_role,`role`.name_role\n" +
            " ,`member`.id_member,`member`.name_member,`member`.date_of_birth_member,`member`.email_member,\n" +
            " `member`.address_member,`member`.phone_member,`member`.id_card_member,`member`.paypal_member,`member`.flag_delete\n" +
            ",`member`.id_rank,`member`.`point` from `member`\n" +
            "inner join `account` on `account`.id_account = `member`.id_account\n" +
            "inner join account_role on account_role.id_account = `account`.id_account\n" +
            "inner join `role` on `role`.id_role = account_role.id_role\n" +
            "where `member`.id_account=:idAccount", nativeQuery = true)
    Member findMemberByIdAccount(Long idAccount);


    Page<Member> findAll(Pageable pageable);


    @Query(value = "SELECT * " +
            "FROM `member` " +
            "inner join `rank` on `rank`.id_rank = `member`.id_rank " +
            "inner join `account` on `account`.id_account = `member`.id_account " +
            "where (`member`.name_member like concat('%' ,?1,'%') or ?1 is null ) " +
            "and (`member`.email_member like concat('%' ,?2,'%') or ?2 is null ) " +
            "and (`member`.address_member like concat('%' ,?3,'%') or ?3 is null ) " +
            "and (`member`.phone_member like concat('%' ,?4,'%') or ?4 is null ) " +
            "and (`rank`.name_rank like concat('%' ,?5,'%') or ?5 is null )" +
            "and `account`.flag_delete = 0",
            countQuery = "SELECT `rank`.id_rank " +
                    "FROM `member` " +
                    "inner join `rank` on `rank`.id_rank = `member`.id_rank " +
                    "inner join `account` on `account`.id_account = `member`.id_account " +
                    "where (`member`.name_member like concat('%' ,?1,'%') or ?1 is null ) " +
                    "and (`member`.email_member like concat('%' ,?2,'%') or ?2 is null ) " +
                    "and (`member`.address_member like concat('%' ,?3,'%') or ?3 is null ) " +
                    "and (`member`.phone_member like concat('%' ,?4,'%') or ?4 is null ) " +
                    "and (`rank`.name_rank like concat('%' ,?5,'%') or ?5 is null )" +
                    "and `account`.flag_delete = 0", nativeQuery = true)
    Page<Member> searchAllMember(String name, String email, String address, String phoneNumber, String nameRank, Pageable pageable);

    //SonLT View-Member
    Member findMemberByAccount_IdAccount(Long id);

    @Query(value = "select nameMember from Member")
    void getTransactionByMember();

}

package project2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project2.model.Member;

@Repository
public interface IMemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "select `account`.id_account,`account`.username,`account`.`password`,`account`.`block`,`account`.last_login,`account`.flag_delete,`role`.id_role,`role`.name_role\n" +
            " ,`member`.id_member,`member`.name_member,`member`.date_of_birth_member,`member`.email_member,\n" +
            " `member`.address_member,`member`.phone_member,`member`.id_card_member,`member`.paypal_member,`member`.flag_delete\n" +
            ",`member`.id_rank,`member`.`point` from `member`\n" +
            "inner join `account` on `account`.id_account = `member`.id_account\n" +
            "inner join account_role on account_role.id_account = `account`.id_account\n" +
            "inner join `role` on `role`.id_role = account_role.id_role\n" +
            "where `member`.id_account=:idAccount", nativeQuery = true)
    Member findMemberByIdAccount(Long idAccount);
}

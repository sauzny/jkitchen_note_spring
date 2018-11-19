package com.sauzny.sbsecuritydemo.jpa;

import com.sauzny.sbsecuritydemo.entity.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/***************************************************************************
 *
 * ███████╗ █████╗ ██╗   ██╗███████╗███╗   ██╗██╗   ██╗
 * ██╔════╝██╔══██╗██║   ██║╚══███╔╝████╗  ██║╚██╗ ██╔╝
 * ███████╗███████║██║   ██║  ███╔╝ ██╔██╗ ██║ ╚████╔╝ 
 * ╚════██║██╔══██║██║   ██║ ███╔╝  ██║╚██╗██║  ╚██╔╝  
 * ███████║██║  ██║╚██████╔╝███████╗██║ ╚████║   ██║   
 * ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝   
 *
 * @时间: 2018/11/13 - 16:32
 *
 * @描述: TODO
 *
 ***************************************************************************/
public interface AccessRepository extends JpaRepository<Access, Integer>, JpaSpecificationExecutor<Access> {

    // join 可修改为  left outer join
    @Query(value = "SELECT a.* FROM tb_user_role_rel urr INNER JOIN tb_role_access_rel rar ON urr.role_id = rar.role_id INNER JOIN tb_access a ON rar.access_id = a.id WHERE urr.user_id = ?1", nativeQuery = true)
    List<Access> findWithUserId(Integer userId);


    @Query(value = "SELECT a FROM Role r JOIN FETCH r.accesses a WHERE r.id in ?1")
    List<Access> findWithRoleIds(List<Integer> roleIds);
}

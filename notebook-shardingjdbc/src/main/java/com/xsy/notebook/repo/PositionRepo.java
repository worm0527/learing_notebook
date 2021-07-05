package com.xsy.notebook.repo;

import com.xsy.notebook.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author shuyuan.xu
 * @date 2020-08-16.
 */
public interface PositionRepo extends JpaRepository<Position, Long> {

  @Query(nativeQuery = true,
      value = "select p.id, p.name, p.salary, p.city, pd.pid, pd.description from position p \n"
      + "LEFT JOIN position_detail pd ON p.id = pd.pid\n"
      + "WHERE p.id = :id")
  Object getInfoById(@Param("id") Long id);

}

package springboot.askisi3.dao;

import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.askisi3.entity.ImportsExports;

public interface ImportsExportsRepository extends JpaRepository<ImportsExports, Integer> {

	@Query("Select * from ImportsExports inner join Reports on ImportsExports.reportsId=Reports.id WHERE Reports.dateRep = :date and ImportsExports.productId = :productId")
	public List<ImportsExports> findApothema(@Param("date")Date date,@Param("productId")int productId);
	List<ImportsExports> findByProduct_id(int product_id);
}

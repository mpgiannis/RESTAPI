package springboot.askisi3.dao;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springboot.askisi3.entity.ImportsExports;

public interface ImportsExportsRepository extends JpaRepository<ImportsExports, Integer> {

	@Query("Select ie from ImportsExports ie inner join Reports r on ie.report_id=r.id WHERE r.date_rep =?1 and ie.product_id =?2")
	public List<ImportsExports> findApothema(LocalDate date,int productId);
	
	List<ImportsExports> findByProduct_id(int product_id);
}

package springboot.askisi3.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import springboot.askisi3.entity.ImportsExports;

public interface ImportsExportsRepository extends JpaRepository<ImportsExports, Integer>, QuerydslPredicateExecutor<ImportsExports>,ImportsExportsRepositoryCustom{

	
	List<ImportsExports> findByProduct_id(int product_id);
}

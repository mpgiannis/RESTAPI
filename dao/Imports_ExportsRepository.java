package springboot.askisi3.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.askisi3.entity.Imports_exports;

public interface Imports_ExportsRepository extends JpaRepository<Imports_exports, Integer> {

	//@Query("Select * from imports_exports inner join reports on imports_exports.reports_id=reports.id WHERE reports.type = :type and imports_exports.product_id = :product_id")
	//public List<Imports_exports> findApothema(@Param("type")String type,@Param("product_id")int product_id);
	List<Imports_exports> findByProduct_id(int product_id);
}

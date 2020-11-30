package springboot.askisi3.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.askisi3.entity.Reports;

public interface ReportsRepository  extends JpaRepository<Reports, Integer>{
	List<Reports> findByDateRep(Date dateRep);

}

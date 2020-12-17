package springboot.askisi3.dao;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.FactoryExpression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.impl.JPAQuery;
import springboot.askisi3.dto.ImExDto;
import springboot.askisi3.dto.ImExSearch;
import springboot.askisi3.entity.ImportsExports;
import springboot.askisi3.entity.QImportsExports;
import springboot.askisi3.entity.QProduct;
import springboot.askisi3.entity.QRacks;
import springboot.askisi3.entity.QReports;

@Service
public class ImportsExportsRepositoryCustomImpl implements ImportsExportsRepositoryCustom {


	
	private QImportsExports importsExports = QImportsExports.importsExports;
	private QRacks racks =QRacks.racks;
	private QProduct product= QProduct.product;
    private QReports reports= QReports.reports;
    @Autowired
	private EntityManager entityManager;


	@Override
	public List<ImExDto> searchImEx(ImExSearch search) {
		Order order =  Order.ASC;
		NumberPath<Integer> a = QImportsExports.importsExports.id;
		OrderSpecifier<?> orderSpecifier = new OrderSpecifier<>(order, a);
		
		JPAQuery<ImExDto> query =new JPAQuery<>(entityManager);
				query.select(projection())
				.from(importsExports)
				.join(importsExports.report, reports)
				.join(importsExports.rack, racks )
				.join(importsExports.product, product)
				.where(predicate(search)).orderBy(orderSpecifier);
				
		return query.fetch();
		
	}
	
    
	private FactoryExpression<ImExDto> projection(){
		return Projections.bean(ImExDto.class,
				importsExports.id,
				reports.id.as("repId"),
				reports.type.as("repType"),
                racks.store.id.as("storeId"),
                racks.id.as("rackId"),
                product.id.as("productId"),
                product.name.as("productName"),
                importsExports.amount.as("amount"));
				
	}
    
    
    
    private Predicate predicate(ImExSearch search) {
    	BooleanBuilder pre  = new BooleanBuilder();
    	
    	if(search.getProductId() != null) {
    		pre.and(product.id.eq(search.getProductId()));
    	}
    	if(search.getTypeRep() != null) {
    		pre.and(reports.type.eq(search.getTypeRep()));
    	}
    	
    	
    	return pre;
    	
    	
    }
    
    
    
	
    

	@Override
	public List<ImportsExports> findByDateAndProductId(String str,int id) {
		LocalDate localdate =LocalDate.parse(str).plusDays(1);
		QImportsExports a = new QImportsExports ("a");
		QReports b = new QReports ("b");
		List<ImportsExports> result =  new JPAQuery<>(entityManager)
				.select(a)
				.from(a, b)
				.join(a.report, b)
				.where(a.product.id.eq(id), b.dateRep.eq(localdate))
				.fetch();
		
		
		
		return result;
	}



















	
	
	
	
	
	
}

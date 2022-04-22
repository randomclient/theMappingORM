package kkh.manytomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManytomanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManytomanyApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner mappingDemo(MiniStockRepository miniStockRepository,
//			MiniRefrigeratorRepository miniRefrigeratorRepository) {
//		return args -> {
//			//create stock
//			MiniStockDTO stock0 = new MiniStockDTO("SID-0001","spur",3 , 3000, "disable");
//			MiniStockDTO stock1 = new MiniStockDTO("SID-0002","spur",4 , 4000, "disable");
//			
//			//save stock
//			miniStockRepository.save(stock0);
//			miniStockRepository.save(stock1);
//			
//			//create refrigerator
//			MiniRefrigeratorDTO refrigerator0 = new MiniRefrigeratorDTO("RG-001","disable");
//			MiniRefrigeratorDTO refrigerator1 = new MiniRefrigeratorDTO("RG-002","disable");
//			MiniRefrigeratorDTO refrigerator2 = new MiniRefrigeratorDTO("RG-003","disable");
//			
//			
//			//save refrigerator
//			miniRefrigeratorRepository.saveAll(Arrays.asList(refrigerator0,refrigerator1,refrigerator2));
//			
//			
//			//addrefrigeratortotheStock
//			stock0.getRefrigerator().addAll(Arrays.asList(refrigerator0,refrigerator1,refrigerator2));
//			stock1.getRefrigerator().addAll(Arrays.asList(refrigerator0,refrigerator1,refrigerator2));
//			
//			//update the stock
//			miniStockRepository.save(stock0);
//			miniStockRepository.save(stock1);
//		};
//	}

}

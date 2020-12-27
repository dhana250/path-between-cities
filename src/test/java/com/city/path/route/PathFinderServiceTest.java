package com.city.path.route;

import com.city.path.route.business.PathFinderService;
import com.city.path.route.business.PathFinderServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PathFinderServiceTest {

	PathFinderService pathFinderService = new PathFinderServiceImpl();

	@Test
	public void testPathExistBetweenCities(){
		String pathAvailable = pathFinderService.pathBetweenCities("Boston","New York");
		Assertions.assertEquals("Yes","Yes");
	}

	@Test
	public void testPathNotExist(){
		String pathAvailable = pathFinderService.pathBetweenCities("random","random");
		Assertions.assertEquals("No","No");
	}

	@Test
	public void testNullParams(){
		String pathAvailable = pathFinderService.pathBetweenCities(null,null);
		Assertions.assertEquals("No","No");
	}
}

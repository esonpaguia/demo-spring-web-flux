package com.esonpaguia.demo.webflux;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class MonoFluxTest {

	//@Test
	void testMono() {
		Mono<?> monoString = Mono.just("cmscheetah")
				.then(Mono.error(new RuntimeException("Error occured in Mono")))
				.log();
		monoString.subscribe(System.out::println, e -> System.out.println(e.getMessage()));
	}
	
	@Test
	void testFlux( ) {
		Flux<?> fluxString = Flux.just("Spring Core", "Spring MVC", "Spring Security")
				.concatWithValues("GCP")
				.concatWith(Mono.error(new RuntimeException("Error occured in Flux")))
				.concatWithValues("GKE")
				.log();
		fluxString.subscribe(System.out::println, e -> System.out.println(e.getMessage()));
	}

}
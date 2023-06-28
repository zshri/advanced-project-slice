package com.example.profileservice.config;


//@Configuration
//@EnableSwagger2WebFlux
//public class SwaggerConfiguration implements WebFluxConfigurer {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .enable(true)
//                //.genericModelSubstitutes(Mono.class, Flux.class, Publisher.class)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder().title("Reactive Stream Starter Demo")
//                .description("Reactive Stream Starter Demo")
//                .version("1.0").build();
//    }
//}
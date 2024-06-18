package com.in.spring_boot_graph_ql.client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class GraphQLClientConfig {

    @Bean
    public HttpGraphQlClient getGraphQlClient() {
        WebClient client = WebClient.builder()
                .baseUrl("https://countries.trevorblades.com")
                .build();
        return  HttpGraphQlClient.builder(client).build();
    }

   /* public void getPayload(){
        RestTemplate restTemplate = new RestTemplate();
        //setting up headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String query = "query($code: ID!) {\n" +
                "  country(code: $code) {\n" +
                "    name\n" +
                "    native\n" +
                "    capital\n" +
                "    emoji\n" +
                "    currency\n" +
                "    languages {\n" +
                "      code\n" +
                "      name\n" +
                "    }\n" +
                "  }\n" +
                "}";

        //create requestBody with query
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("query", query);
        //create variables
        Map<String, Object> variables = new HashMap<>();
        variables.put("code", "IN");
        //add variables in the requestBody
        requestBody.put("variables",variables);
        HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        System.out.println(response);
    }*/
}

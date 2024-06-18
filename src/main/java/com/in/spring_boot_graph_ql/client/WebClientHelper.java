package com.in.spring_boot_graph_ql.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;

@Service
public class WebClientHelper {

    private final HttpGraphQlClient graphQlClient;

    @Autowired
    public WebClientHelper(final HttpGraphQlClient graphQlClient) {
        this.graphQlClient = graphQlClient;
    }

    public void fetch() {
        // Example GraphQL query
        String query = "{ countries { code, name } }";
        // Execute the query
        graphQlClient.document(query).execute().subscribe(response -> {
            System.out.println("Response: " + response);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode jsonNode = objectMapper.readTree(response.toString());
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

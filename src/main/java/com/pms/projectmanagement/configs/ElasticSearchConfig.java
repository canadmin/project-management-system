package com.pms.projectmanagement.configs;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.Transport;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.InetSocketAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.pms.projectmanagement.elasticsearch.repository")
public class ElasticSearchConfig {

    @Value("${elasticsearch.host}")
    private String elasticSearchHost;

    @Value("${elasticsearch.port}")
    private int elasticSearchPort;

    @Value("${elasticsearch.clustername}")
    private String elasticSearchClusterName;

    @Bean
    public Client client() throws Exception{
        Settings settings = Settings.builder().put("client.transport.sniff",true).put("cluster.name",elasticSearchClusterName).build();
        TransportClient client = new PreBuiltTransportClient(settings);
        client.addTransportAddress(new TransportAddress(InetAddress.getByName(elasticSearchHost),elasticSearchPort));
        return client;
    }
    public ElasticsearchOperations elasticsearchOperations() throws Exception{
        return new ElasticsearchTemplate(client());
    }
}


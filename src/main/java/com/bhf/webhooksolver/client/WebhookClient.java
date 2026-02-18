package com.bhf.webhooksolver.client;

import com.bhf.webhooksolver.dto.GenerateWebhookRequest;
import com.bhf.webhooksolver.dto.GenerateWebhookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class WebhookClient {

    private final RestTemplate restTemplate;

    private static final String GENERATE_URL =
            "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

    public GenerateWebhookResponse generateWebhook() {

        GenerateWebhookRequest request =
                new GenerateWebhookRequest(
                        "Yallaling",
                        "3GU21CS052",
                        "channa99yallaling@gmail.com"
                );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GenerateWebhookRequest> entity =
                new HttpEntity<>(request, headers);

        ResponseEntity<GenerateWebhookResponse> response =
                restTemplate.exchange(
                        GENERATE_URL,
                        HttpMethod.POST,
                        entity,
                        GenerateWebhookResponse.class
                );

        return response.getBody();
    }
}

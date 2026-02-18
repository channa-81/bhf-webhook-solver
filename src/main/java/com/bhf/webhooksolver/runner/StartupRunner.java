package com.bhf.webhooksolver.runner;

import com.bhf.webhooksolver.client.SolutionSubmissionClient;
import com.bhf.webhooksolver.client.WebhookClient;
import com.bhf.webhooksolver.dto.GenerateWebhookResponse;
import com.bhf.webhooksolver.service.SqlSolutionService;
import com.bhf.webhooksolver.util.RegNoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupRunner implements CommandLineRunner {

    private final WebhookClient webhookClient;
    private final SolutionSubmissionClient submissionClient;
    private final SqlSolutionService sqlService;

    private static final String REG_NO = "REG12347";

    @Override
    public void run(String... args) {

        System.out.println("STEP 1: Generating webhook...");
        GenerateWebhookResponse response = webhookClient.generateWebhook();

        boolean isOdd = RegNoUtil.isOdd(REG_NO);

        System.out.println("STEP 2: Solving SQL...");
        String sql = sqlService.getSolution(isOdd);

        System.out.println("STEP 3: Submitting solution...");
        submissionClient.submitSolution(
                response.getWebhook(),
                response.getAccessToken(),
                sql
        );

        System.out.println("TASK COMPLETED");
    }
}

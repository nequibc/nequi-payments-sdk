package com.nequi.payments.client;

import com.amazonaws.mobileconnectors.apigateway.ApiClientFactory;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nequi.auth.NequiAuth;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class NequiUnregisteredPaymentsTest {
    public static void main(String[] args) {
        try {
            System.out.println("Testing NequiPayments...");
            System.out.println("Getting token...");

            NequiAuth auth = NequiAuth.getInstance().fromEnvVars();
            String token = auth.getToken();

            System.out.println(String.format("Token >> %s", token));

            System.out.println("Calling service...");

            ApiClientFactory factory = new ApiClientFactory();
            factory.apiKey(System.getenv("NEQUI_API_KEY"));

            NequiPaymentsGatewayClient client = factory.build(NequiPaymentsGatewayClient.class);

            Reader jsonReader = new FileReader(
                new File(
                    NequiUnregisteredPaymentsTest.class
                        .getClassLoader()
                        .getResource("json/payment/unregisteredPayment.json")
                        .toURI()
                )
            );
            JsonObject body = new JsonParser().parse(jsonReader).getAsJsonObject();

            JsonObject jsonResponse = client.servicesPaymentserviceUnregisteredpaymentPost(
                body, token
            );
            JsonObject jsonStatus = jsonResponse
                .getAsJsonObject("ResponseMessage")
                .getAsJsonObject("ResponseHeader")
                .getAsJsonObject("Status");

            String statusCode = jsonStatus.get("StatusCode").getAsString();
            String statusDesc = jsonStatus.get("StatusDesc").getAsString();

            if (statusCode != null && statusCode.equals("0")) {
                JsonObject jsonResult = jsonResponse
                    .getAsJsonObject("ResponseMessage")
                    .getAsJsonObject("ResponseBody")
                    .getAsJsonObject("any")
                    .getAsJsonObject("unregisteredPaymentRS");

                String trnId = jsonResult.get("transactionId").getAsString();

                System.out.println(
                    "Solicitud de pago realizada correctamente" +
                    "- Id Transacción -> " + trnId.trim()
                );
            } else {
                throw new Exception(String.format("Error %s = %s", statusCode, statusDesc.trim()));
            }
        } catch (Exception e) {
            System.out.println(String.format("Error >> '%s'", e.getMessage()));
        }
    }
}

/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.nequi.payments.client;

import com.amazonaws.mobileconnectors.apigateway.annotation.Operation;
import com.amazonaws.mobileconnectors.apigateway.annotation.Parameter;
import com.amazonaws.mobileconnectors.apigateway.annotation.Service;
import com.google.gson.JsonObject;

@Service(endpoint = "https://api.nequi.com/payments/v2")
public interface NequiPaymentsGatewayClient {
    
    @Operation(path = "/-services-paymentservice-cancelqrpayment", method = "POST")
    JsonObject servicesPaymentserviceCancelqrpaymentPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-paymentservice-cancelunregisteredpayment", method = "POST")
    JsonObject servicesPaymentserviceCancelunregisteredpaymentPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-paymentservice-createboughtqrrecord", method = "POST")
    JsonObject servicesPaymentserviceCreateboughtqrrecordPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-paymentservice-generatecodeqr", method = "POST")
    JsonObject servicesPaymentserviceGeneratecodeqrPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-paymentservice-getboughtqrrecords", method = "POST")
    JsonObject servicesPaymentserviceGetboughtqrrecordsPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-paymentservice-getstatuspayment", method = "POST")
    JsonObject servicesPaymentserviceGetstatuspaymentPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-paymentservice-unregisteredpayment", method = "POST")
    JsonObject servicesPaymentserviceUnregisteredpaymentPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-reverseservices-reversetransaction", method = "POST")
    JsonObject servicesReverseservicesReversetransactionPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-staticqrservices-creatependingpayment", method = "POST")
    JsonObject servicesStaticqrservicesCreatependingpaymentPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-staticqrservices-getinfo", method = "POST")
    JsonObject servicesStaticqrservicesGetinfoPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-staticqrservices-getpendingpayment", method = "POST")
    JsonObject servicesStaticqrservicesGetpendingpaymentPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-staticqrservices-getstatuspayment", method = "POST")
    JsonObject servicesStaticqrservicesGetstatuspaymentPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
    
    @Operation(path = "/-services-staticqrservices-reversepayment", method = "POST")
    JsonObject servicesStaticqrservicesReversepaymentPost(
        JsonObject body,
        @Parameter(name = "Authorization", location = "header") String authorization
    );
}
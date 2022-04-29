package com.akshit.services.clients;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.akshit.grpcinterface.hello.HelloServiceGrpc;
import org.akshit.grpcinterface.hello.HelloWorld;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AnnoyingGreeter {
    @GrpcClient("hello-service")
    HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub;

    @Scheduled(fixedRate = 1000)
    public void greet() {
        log.info("trying to greet");
        String greeting = helloServiceBlockingStub.sayHello(HelloWorld.Greeter.newBuilder()
                        .setName("Thalaiva").build())
                .getMessage();
        log.info("received greetings: {}", greeting);
    }
}

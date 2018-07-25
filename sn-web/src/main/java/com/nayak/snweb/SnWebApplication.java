package com.nayak.snweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SnWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnWebApplication.class, args);
	}
}
@Component
@EnableBinding(Source.class)
class TaskProcessor{

    @Autowired
    Source source;

    public void publishRequest(){
        String url="maven://com.nayak:sn-task:jar:0.0.1-SNAPSHOT";

        TaskLaunchRequest taskLaunchRequest=new TaskLaunchRequest(url,null,null,null,"sn-sn-sn");

        GenericMessage<TaskLaunchRequest> genericMessage=new GenericMessage<>(taskLaunchRequest);

        this.source.output().send(genericMessage);
    }
}

@Configuration
class TaskConfig{
    @Bean
    public TaskProcessor taskProcessor(){
        return new TaskProcessor();
    }
}

@RestController
class TaskController{
    @Autowired
    TaskProcessor taskProcessor;

    @RequestMapping("/task-launch")
    public String taskLaunch(){
        taskProcessor.publishRequest();
        return "success";
    }
}

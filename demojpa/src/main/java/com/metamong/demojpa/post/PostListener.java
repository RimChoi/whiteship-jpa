package com.metamong.demojpa.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

public class PostListener {

    // 혹은 클래스에 implements ApplicationListener<PostPublishedEvent>
    @EventListener
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("======================");
        System.out.println(event.getPost().getTitle() + " is published..!");
        System.out.println("======================");
    }
}

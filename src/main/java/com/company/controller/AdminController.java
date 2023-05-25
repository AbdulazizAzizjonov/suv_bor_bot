package com.company.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
@Component
@RequiredArgsConstructor
public class AdminController {

    public void handleMessage(User user, Message message) {

    }

    public void handleCallBack(User user, Message message, String data) {

    }

}

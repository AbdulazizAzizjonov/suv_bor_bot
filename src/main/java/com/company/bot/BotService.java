package com.company.bot;

import com.company.container.ComponentContainer;
import com.company.controller.AdminController;
import com.company.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
@Component
public class BotService extends TelegramLongPollingBot {
    @Autowired
    private AdminController adminController;
    @Autowired
    private UserController userController;

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    @Value("${admin.id}")
    private Long adminId;

    @Override
    public String getBotUsername() {
        return ComponentContainer.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return ComponentContainer.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {

        try {

            if (update.hasMessage()) {

                Message message = update.getMessage();
                User user = message.getFrom();
                String chatId = String.valueOf(message.getChatId());

                if (String.valueOf(user.getId()).equals(ComponentContainer.ADMIN_ID)) {
                    adminController.handleMessage (user, message);
                } else {
                    userController.handleMessage (user, message);
                }

                if (message.hasLocation()) {
                    userController.handleLocation(user, message);
                }
                else if (message.hasContact()) {
                    userController.handleContact(user, message, chatId);
                }
            }

            else if (update.hasCallbackQuery()){

                CallbackQuery callbackQuery = update.getCallbackQuery();
                Message message = callbackQuery.getMessage();
                User user = callbackQuery.getFrom();
                String data = callbackQuery.getData();

                if(String.valueOf(user.getId()).equals(ComponentContainer.ADMIN_ID)){
                    adminController.handleCallBack(user, message, data);
                }else{
                    userController.handleCallBack(user, message, data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }





    public void sendMsg (Object message){

        try {
            if (message instanceof SendMessage) {
                execute((SendMessage) message);
            }
            if (message instanceof SendVideo) {
                execute((SendVideo) message);
            }
            if (message instanceof SendDocument) {
                execute((SendDocument) message);
            }
            if (message instanceof DeleteMessage) {
                execute((DeleteMessage) message);
            }
            if (message instanceof EditMessageText) {
                execute((EditMessageText) message);
            }
            if (message instanceof SendSticker) {
                execute((SendSticker) message);
            }
            if (message instanceof SendPhoto) {
                execute((SendPhoto) message);
            }
            if (message instanceof SendDice) {
                execute((SendDice) message);
            }
            if (message instanceof SendVenue) {
                execute((SendVenue) message);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}

package com.company.controller;

import com.company.container.ComponentContainer;
import com.company.dto.CustomerDTO;
import com.company.entity.CustomerEntity;
import com.company.repository.CustomerRepository;
import com.company.service.CustomerService;
import com.company.util.KeyboardUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

@Component
@RequiredArgsConstructor
public class UserController  {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;
    public void handleMessage(User user, Message message) {
        if (message.hasText()) {
            handleText(user, message);
        } else if (message.hasPhoto()) {
            handlePhoto(user, message);
        }
    }

    private void handlePhoto(User user, Message message) {

    }


    public void handleContact(User user, Message message, String chatId) {

        Contact contact = message.getContact();
        String customerId = String.valueOf(contact.getUserId());

        CustomerEntity entity = (CustomerEntity) customerRepository.findById(customerId);

        if (entity == null){
            entity = new CustomerEntity();
            CustomerDTO dto = new CustomerDTO();
            entity.setId(dto.getId());
            entity.setSurname(dto.getSurname());
            entity.setName(dto.getName());
            entity.setPhone(dto.getPhone());
            entity.setLocation(dto.getLocation());
            entity.setCustomerNumber(dto.getCustomerNumber());

            customerRepository.save(entity);
        }

        SendMessage sendMessage = new SendMessage(
                String.valueOf(message.getChatId()), "Quyidagilardan birini tanlang\uD83D\uDC47"
        );

        sendMessage.setReplyMarkup(KeyboardUtil.AsosiyMenu());
        ComponentContainer.botService.sendMsg(sendMessage);

    }


    private void handleText(User user, Message message) {

        String text = message.getText();
        String chatId = String.valueOf(message.getChatId());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));


        CustomerEntity customerEntity = new CustomerEntity();

        CustomerEntity customer = (CustomerEntity) customerRepository.findById(customerEntity.getId());

        if (text.equals("/start")) {
            if (customer == null) {
                sendMessage.setText("Assalomu alaykum!\n" +
                        "@tdtualbot botiga xush kelibsiz \uD83D\uDE0A  \n" +
                        "Quyidagilardan birini tanlang \uD83D\uDC47");
                sendMessage.setChatId(chatId);
                sendMessage.setReplyMarkup(KeyboardUtil.changeLanguage());


            } else {
                System.out.println("BILMADIM");
            }

        }

    }

    public void handleLocation(User user, Message message) {

    }


    public void handleCallBack(User user, Message message, String data) {

    }
}

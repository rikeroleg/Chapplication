package com.chapplication.example.controllers;

import java.net.URI;
import java.util.List;

import com.chapplication.example.objects.MessageObject;
import com.chapplication.example.servicerepo.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class MessageController {

    @Autowired
    public MessageService messageService;

    @RequestMapping(value = "/messageObject/", method = RequestMethod.POST)
    public ResponseEntity<MessageObject> createMessage(@RequestBody MessageObject messageObject) {
        messageService.saveAndFlush(messageObject);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity<>(messageObject, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/messageObject/", method = RequestMethod.GET)
    public List<MessageObject> listAllMessages(){
        return messageService.findAll();
    }

    @RequestMapping(value = "/messageObject/{messageId}", method = RequestMethod.GET)
    public MessageObject getMessageById(@PathVariable Long messageId){
        return messageService.findOne(messageId);
    }

    @RequestMapping(value = "/messageObject/{messageId}", method = RequestMethod.PUT)
    public MessageObject updateMessageById(@PathVariable Long messageId, @RequestBody MessageObject messageObject){
        MessageObject existingMessage = getMessageById(messageId);
        BeanUtils.copyProperties(messageObject, existingMessage);
        return messageService.saveAndFlush(existingMessage);
    }

    @RequestMapping(value = "/messageObject/{messageId}", method = RequestMethod.DELETE)
    public MessageObject deleteMessageById(@PathVariable Long messageId){
        MessageObject existingMessage = getMessageById(messageId);
        messageService.delete(existingMessage);
        return existingMessage;
    }
}

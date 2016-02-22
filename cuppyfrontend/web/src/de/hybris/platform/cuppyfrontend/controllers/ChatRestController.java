package de.hybris.platform.cuppyfrontend.controllers;


import de.hybris.platform.cuppy.web.data.ChatMessageData;
import de.hybris.platform.cuppy.web.facades.PlayerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ChatRestController {

    @Autowired
    private PlayerFacade playerFacade;

    @RequestMapping (value="/fetchChatMessages", method = RequestMethod.GET)
    public ResponseEntity<List<ChatMessageData>> fetchMessages () {

        return new ResponseEntity<List<ChatMessageData>>(playerFacade.findMessages(), HttpStatus.OK);
    }

    @RequestMapping (value="/fetchChatMessagesFromDate/{from:.+}", method = RequestMethod.GET )
    public  ResponseEntity<List<ChatMessageData>> fetchMessages (@PathVariable String from ) throws ParseException,
            UnsupportedEncodingException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); //"yyyy-MM-dd, HH:mm:ss"
        String decodeFrom = URLDecoder.decode(from, "UTF-8");
        Date fromDate = (from == null ? new Date() : dateFormat.parse(decodeFrom));

        return new ResponseEntity<List<ChatMessageData>>(playerFacade.findMessagesFromDate(fromDate), HttpStatus.OK);
    }

    @RequestMapping (value="/saveMessage", method=RequestMethod.POST)
    public ResponseEntity saveMessage (@RequestParam(value = "message") String message) {

        playerFacade.addMessage(message);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}

package com.active.payment.qr_code_generator;

import com.active.payment.qr_code_generator.model.Payment;
import com.active.payment.qr_code_generator.model.QrInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.WriterException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api")
public class QRCodeGenController {
    @PostMapping("/qrcode")
    public QrInfo genQRCodeInfo(@RequestBody Payment payment) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String payment_json = mapper.writeValueAsString(payment);

        //System.out.println(payment.getId());

        //String medium="https://rahul26021999.medium.com/";
        int imageSize = 250;
        byte[] image = new byte[0];
        try {

            // Generate and Return Qr Code in Byte Array
            image = QRCodeGenerator.getQRCodeImage(payment_json, imageSize, imageSize);

        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }

        // Convert Byte Array into Base64 Encode String
        String qrcode = Base64.getEncoder().encodeToString(image);
        System.out.println(qrcode);

        //return QrInfo
        QrInfo qrInfo = new QrInfo(payment,qrcode, 200);
        //System.out.println(qrInfo.toString());

        //ObjectMapper mapper = new ObjectMapper();
        //String jsonString = mapper.writeValueAsString(qrInfo);

        //System.out.println("jsonString");
        //System.out.println(jsonString);

        //return new ResponseEntity<QrInfo>(qrInfo, HttpStatus.OK);
        return qrInfo;
    }

}
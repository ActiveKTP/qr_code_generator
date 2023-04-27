package com.active.payment.qr_code_generator.model;

public class QrInfo {
    private  Payment payment;
    private  String image;

    private int statusCode;

    public QrInfo(Payment _payment, String _image, int _status){
        this.payment = _payment;
        this.image = _image;
        this.statusCode = _status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}

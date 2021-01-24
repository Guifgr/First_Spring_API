package com.example.demo.models;

public class ValidCpf {
    private String cpfNumber;
    private boolean valid;


    public String getCpfNumber() {
        return cpfNumber;
    }

    public void setCpfNumber(String cpfNumber) {
        this.cpfNumber = cpfNumber;
    }

    public boolean isValid() {
        return valid;
    }

    public void setAuth(boolean auth) {
        this.valid = auth;
    }

    public int numPos(ValidCpf cpf, int position){
        return Integer.parseInt(String.valueOf(cpf.getCpfNumber().charAt(position)));
    }

    public int validDigit(int partResult){
        return (partResult *10) % 11;
    }

    public String parseStringDash(ValidCpf cpf){
        return cpf.getCpfNumber().replace("-", "");
    }

    public void validCpf(ValidCpf cpf){
        cpf.setCpfNumber(parseStringDash(cpf));
        int firstPartPartialResult = (numPos(cpf, 0)*10) +
                            (numPos(cpf, 1)*9) +
                            (numPos(cpf, 2)*8) +
                            (numPos(cpf, 3)*7) +
                            (numPos(cpf, 4)*6) +
                            (numPos(cpf, 5)*5) +
                            (numPos(cpf, 6)*4) +
                            (numPos(cpf, 7)*3) +
                            (numPos(cpf, 8)*2);

        int firstPartResult = validDigit(firstPartPartialResult);

        int secondPartPartialResult = (numPos(cpf, 0)*11) +
                                (numPos(cpf, 1)*10) +
                                (numPos(cpf, 2)*9) +
                                (numPos(cpf, 3)*8) +
                                (numPos(cpf, 4)*7) +
                                (numPos(cpf, 5)*6) +
                                (numPos(cpf, 6)*5) +
                                (numPos(cpf, 7)*4) +
                                (numPos(cpf, 8)*3)+
                                (firstPartResult * 2);

        int secondPartResult = validDigit(secondPartPartialResult);

        cpf.setAuth(firstPartResult == numPos(cpf, 9) && (secondPartResult == numPos(cpf, 10)));
    }
}
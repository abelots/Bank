public enum BankError{
    OK("ок"),
    ERROR("Есть ошибка"),
    LOGIN_ERROR("Логин уже существует");

    String text;

    BankError(String text) {
        this.text = text;
    }
}

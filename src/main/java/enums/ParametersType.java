package enums;

public enum ParametersType {
    FN("fn"),
    ORG("org"),
    GAME_ID("gameid"),
    LANG("lang"),
    USER_NAME("userName"),
    CHANNEL("channel"),
    CR_ID("crid"),
    CS_ID("csid"),
    CURRENCY("currency"),
    SESSION_ID("sessid"),
    GH_SESSION_ID("gameHistorySessionId"),
    GH_TICKED_ID("gameHistoryTicketId"),
    AMOUNT("amount"),
    LINES("lines"),
    COIN("coin"),
    IS_PREPAID("isPrepaid"),
    CLIENT_INFO("clientinfo");

    private String value;

    ParametersType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

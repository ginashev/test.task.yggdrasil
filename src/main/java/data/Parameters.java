package data;

import java.util.HashMap;
import java.util.Map;

import static enums.ParametersType.*;

public class Parameters {
    public Map<String, String> getLoginParameters() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(FN.getValue(), "authenticate");
        params.put(ORG.getValue(), "Demo");
        params.put(GAME_ID.getValue(), "7316");
        params.put(LANG.getValue(), "en");
        params.put(USER_NAME.getValue(), "undefined");
        params.put(CHANNEL.getValue(), "pc");
        params.put(CR_ID.getValue(), "d07c628c-8e16-4633-9276-9f59aad3c298");
        params.put(CS_ID.getValue(), "25553048-2687-462e-8462-a5ff17acedfc");
        return params;
    }

    public Map<String, String> getGameParametersWithSessionID(String sessId) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(FN.getValue(), "play");
        params.put(CHANNEL.getValue(), "pc");
        params.put(CURRENCY.getValue(), "EUR");
        params.put(LANG.getValue(), "en");
        params.put(GAME_ID.getValue(), "7316");
        params.put(SESSION_ID.getValue(), sessId);
        params.put(GH_SESSION_ID.getValue(), "session");
        params.put(GH_TICKED_ID.getValue(), "ticket");
        params.put(AMOUNT.getValue(), "100");
        params.put(LINES.getValue(), "1111111111111111111111111");
        params.put(COIN.getValue(), "4");
        params.put(IS_PREPAID.getValue(), "false");
        params.put(CLIENT_INFO.getValue(), "1904171344380100000");
        params.put(CR_ID.getValue(), "36dc7cde-a067-40f2-9df7-046fb4f7c408");
        params.put(CS_ID.getValue(), " 25553048-2687-462e-8462-a5ff17acedfc");
        return params;
    }
}

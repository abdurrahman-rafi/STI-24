public class CasualResponseStyle implements ResponseStyle{
    // TODO:
    // Kelas ini harus mengimplementasikan interface ResponseStyle
    @Override
    public String format(String baseResponse){
        if(baseResponse == null){
            return "";
        }
        return ("Hey! " + baseResponse);
    }
    // TODO:
    // Kelas ini harus method format dari DeliveryChannel dengan ketentuan:
    // 1. Lakukan return: "Hey! <response>""
}
